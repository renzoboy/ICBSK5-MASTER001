package icbs.admin



import static org.springframework.http.HttpStatus.*
import groovy.json.JsonBuilder
import grails.converters.JSON
import grails.converters.deep.JSON
import groovy.sql.Sql

import grails.transaction.Transactional
import icbs.admin.BranchProduct
import icbs.admin.CustomerGroupProduct
import icbs.admin.Branch
import icbs.lov.ConfigItemStatus

@Transactional(readOnly = true)
class ProductController {
    def dataSource
    def auditLogService
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]
    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)

        if (params.sort == null) {  // default ordering
            params.sort = "configItemStatus"
        }

        if (params.query == null) {  // show all instances            
            respond Product.list(params), model:[ProductInstanceCount: Product.count()]
        }
        else {    // show query results
            def productList = Product.createCriteria().list(params) {
                or {
                    eq("code", params.int('query'))
                    ilike("name", "%${params.query}%")
                }
            }
            respond productList, model:[ProductInstanceCount: productList.totalCount]
        }
    }

    def show(Product productInstance) {
        respond productInstance, model:[productBranches: BranchProduct.findAllByProduct(productInstance)]
    }

    def create() {
        
        def newEntry = 1
        
        respond new Product(params),model:[newEntry:newEntry]
    }

    @Transactional
    def save(Product productInstance) {

        if (productInstance == null) {
            notFound()
            return
        }

        if (productInstance.hasErrors()) {
            respond productInstance.errors, view:'create'
            return
        }

        productInstance.configItemStatus = ConfigItemStatus.get(2)

        productInstance.save flush:true

        params.list('branches').each {      
            BranchProduct bp = new BranchProduct(branch:it, product:productInstance, configItemStatus:ConfigItemStatus.get(2)).save(flush:true)
        }
        
        params.list('customerGroups').each {    
            CustomerGroupProduct cg = new CustomerGroupProduct(customerGroup:it, product:productInstance, configItemStatus:ConfigItemStatus.get(2)).save(flush:true)
        }

        params.list('txnTemplates').each {
            ProductTxn tt = new ProductTxn(txnTemplate:it, product:productInstance, configItemStatus:ConfigItemStatus.get(2)).save(flush:true)
        }
        
        // Log
        def description = 'save new product ' +  productInstance.name
        //add new product code "CFG00702"
        auditLogService.insert('040', 'CFG00702', description, 'product', null, null, null, productInstance.id)
        
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'product.label', default: 'Product'), productInstance.id])
                redirect productInstance
            }
            '*' { respond productInstance, [status: CREATED] }
        }
    }

    def edit(Product productInstance) {
       // def tmplist = TxnTemplate.list()
        def v = "%"+productInstance.productType.id+"%"
        if (productInstance.productType.id == 7){
            v = "%6%"
        }
        def tmplist = TxnTemplate.findAllByAppTypeLike(v)
        respond productInstance, model:[branchProducts:BranchProduct.findAllByProduct(productInstance),tmplist:tmplist]
    }

    @Transactional
    def update(Product productInstance) {
        println("================ Update PRODUCT details")
        println("params: "+params)
        if (productInstance == null) {
            notFound()
            return
        }

        if (productInstance.hasErrors()) {
            respond productInstance.errors, view:'edit'
            return
        }

        productInstance.save flush:true
         // ======================== CUSTOMER GROUP PRODUCT ============================
        def delProductCusGrp = CustomerGroupProduct.findAllByProduct(productInstance)
        for(delCg in delProductCusGrp){
            delCg.delete(flush:true)
        }
        params.list('customerGroups').each {
            def cgp = CustomerGroupProduct.findAllByCustomerGroupAndProduct(CustomerGroup.get(it),productInstance)

            if(!cgp) {
                CustomerGroupProduct newCGP = new CustomerGroupProduct(customerGroup:it, product:productInstance, configItemStatus:ConfigItemStatus.get(2)).save(flush:true)
            }
        }
        // ======================== BRANCH PRODUCT ============================
        def delProductBrch = BranchProduct.findAllByProduct(productInstance)
        for(delBr in delProductBrch){
            delBr.delete(flush:true)
        }
        params.list('branches').each {
            def bp = BranchProduct.findAllByBranchAndProduct(Branch.get(it),productInstance)

            if(!bp) {
                BranchProduct newBP = new BranchProduct(branch:it, product:productInstance, configItemStatus:ConfigItemStatus.get(2)).save(flush:true)
            }
        }
        println("params.txnTemplates: "+params.txnTemplates)
        println("list txnTEmplates: "+params.list('txnTemplates'))
        
        // ======================== TRANSACTION TEMPLATE ============================
        
        def delProductTxn = ProductTxn.findAllByProduct(productInstance)
        for(delPTxn in delProductTxn){
            delPTxn.delete(flush:true)
        }
        params.list('txnTemplates').each {
            println("it: "+it)
            println("productInstance: "+productInstance)
            def pt = ProductTxn.findAllByTxnTemplateAndProduct(TxnTemplate.get(it),productInstance)
            println("pt: "+pt)
            
            if(!pt) {
                ProductTxn newPT = new ProductTxn(txnTemplate:it, product:productInstance, configItemStatus:ConfigItemStatus.get(2)).save(flush:true)
            }
        }
        def description = 'Update product ' +  productInstance.name
        // product code amendment "CFG00703"
        auditLogService.insert('040', 'CFG00703', description, 'product', null, null, null, productInstance.id)
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Product.label', default: 'Product'), productInstance.id])
                redirect productInstance
            }
            '*'{ respond productInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Product productInstance) {

        if (productInstance == null) {
            notFound()
            return
        }

        //productInstance.delete flush:true
        productInstance.configItemStatus = ConfigItemStatus.get(3) 
        productInstance.save(flush:true)
        def description = 'delete product ' +  productInstance.name
        // remove product code "CFG00704"
        auditLogService.insert('040', 'CFG00704', description, 'product', null, null, null, productInstance.id)
        
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Product.label', default: 'Product'), productInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'product.label', default: 'Product'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
    
    def templateList()
    {
        //println params
        def db = new Sql(dataSource) 
        def sql = "select id,description from txn_template where app_type like '%"+params.tid+"%'"
        //println sql
        def results = new JsonBuilder(db.rows(sql)).toPrettyString()
        //println results
        render(text: results) as JSON
        return
      
        
    }
}
//vitro