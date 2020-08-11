package icbs.loans


import grails.converters.JSON
import grails.converters.deep.JSON

import static org.springframework.http.HttpStatus.*
import org.springframework.web.multipart.MultipartHttpServletRequest
import grails.transaction.Transactional
import icbs.admin.UserMaster
import icbs.lov.AttachmentType
import icbs.lov.ConfigItemStatus

@Transactional(readOnly = true)
class CreditInvestigationController {
    def auditLogService
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]
    
    def index(Integer max) {
       // params.max = Math.min(max ?: 10, 100)
       params.max = Math.min(max ?: 25, 100)
        if (params.sort == null) {
            params.sort = "id"
        }
        println("params.query: "+params.query+"jmx")
        if (params.query == null || params.query == "") {
            //respond CreditInvestigation.list(params), model:[params:params, CreditInvestigationInstanceCount: CreditInvestigation.count()]
            def result = CreditInvestigation.createCriteria().list(params) {                
                eq("lnTrackingStatus", ConfigItemStatus.get(2))
            }
            respond result, model:[params:params, creditInvestigationInstanceCount: result.totalCount]
        } else{
            def result = CreditInvestigation.createCriteria().list(params) {                
                or{
                    'loanApplication'{
                        or{
                            'customer'{
                                or{
                                    ilike("displayName","%${params.query.trim()}%")
                                }
                            }
                        }
                        /*if(params.query.trim().isLong()){
                            //idEq(params.query.trim().toLong())\
                            eq("id", CreditInvestigation.get(params.query.trim().toLong()))
                        }*/
                    }
                }
                eq("lnTrackingStatus", ConfigItemStatus.get(2))
            }
            respond result, model:[params:params, creditInvestigationInstanceCount: result.totalCount]
        }
        return
    }

    def show(CreditInvestigation creditInvestigationInstance) {
        def unsecOrSecuredId = LoanApplicationSpecAdditional.findByLoanApplication(creditInvestigationInstance?.loanApplication).guaranteeFacility.id
        def secUnsecTag = "secured"
        if(unsecOrSecuredId == 8 || unsecOrSecuredId == 5 || unsecOrSecuredId == 9 || unsecOrSecuredId == 2 ||  unsecOrSecuredId == 10){
            println("UNSECURED")
            secUnsecTag = "unsec"
        }
        [creditInvestigationInstance:creditInvestigationInstance,secUnsecTag:secUnsecTag]
    }

    def create() {
        // initialize session variables
        def creditTypeAction = params?.creditType
        session["attachments"] = []
        
        def loanApplication = null
        if (params?.id) {
            loanApplication = LoanApplication.get(params?.id)
        }

        respond new CreditInvestigation(params), model:[loanApplication:loanApplication,creditTypeAction:creditTypeAction]
    }

    @Transactional
    def save(CreditInvestigation creditInvestigationInstance) {
        println("params: "+params)
        println "CREDIT INVESTIGATION"+ params.analystId
        println "CREDIT INVESTIGATION"+ creditInvestigationInstance.loanApplication
        
        
        def checkIfCiLoanAppExist = CreditInvestigation.findByLoanApplication(creditInvestigationInstance.loanApplication)
        
        if (creditInvestigationInstance == null) {
            notFound()
            return
        }

        if (creditInvestigationInstance.hasErrors()) {
            respond creditInvestigationInstance.errors, view:'create'
            return
        }

        //println "SAVE:" + creditInvestigationInstance.analystId
        
        //creditInvestigationInstance.analystId = params.analystId
         //println "SAVE:" + params.analystId
         
         
        
        //creditInvestigationInstance.save flush:true
       // params.save flush:true
       //////////unsecperformedByAnalyst/
        //check duplicate loan application
        if(checkIfCiLoanAppExist){
            // loan application already used in CI or loan tracking do not save another
            flash.message = "Sorry, Loan Application Already used. please check " 
            respond creditInvestigationInstance.errors, view:'create'
            return
        }else{
            for(attachment in session["attachments"]) {
                creditInvestigationInstance.addToAttachments(attachment)
            }
            session["attachments"] = null
            def secAndUnsecCheck = params.loanAppSecOrUnsecId.toInteger()
        if(secAndUnsecCheck == 8 || secAndUnsecCheck == 5 || secAndUnsecCheck == 9 || secAndUnsecCheck == 2 || secAndUnsecCheck == 10){
		creditInvestigationInstance.folderReceivedByBranchDept = params.unsecfolderReceivedByBranchDept ? new Date().parse("MM/dd/yyyy", params?.unsecfolderReceivedByBranchDept) : null
                creditInvestigationInstance.folderTransToCau = params.unsecfolderTransToCau ? new Date().parse("MM/dd/yyyy", params?.unsecfolderTransToCau) : null
                creditInvestigationInstance.assignedToCi = params.unsecassignedToCi ? new Date().parse("MM/dd/yyyy", params?.unsecassignedToCi) : null
                creditInvestigationInstance.schedForCi = params.unsecschedForCi ? new Date().parse("MM/dd/yyyy", params?.unsecschedForCi) : null
                creditInvestigationInstance.performedCi = params.unsecperformedCi ? new Date().parse("MM/dd/yyyy", params?.unsecperformedCi) : null
                creditInvestigationInstance.assignedToAnalyst = params.unsecassignedToAnalyst ? new Date().parse("MM/dd/yyyy", params?.unsecassignedToAnalyst) : null
                creditInvestigationInstance.schedForAnalyst = params.unsecschedForAnalyst ? new Date().parse("MM/dd/yyyy", params?.unsecschedForAnalyst) : null
                creditInvestigationInstance.recommendation = params.unsecrecommendation 
                creditInvestigationInstance.performedByAnalyst = params.unsecperformedByAnalyst ? new Date().parse("MM/dd/yyyy", params?.unsecperformedByAnalyst) : null
                creditInvestigationInstance.submitAnalystRep = params.unsecsubmitAnalystRep ? new Date().parse("MM/dd/yyyy", params?.unsecsubmitAnalystRep) : null
            }
        creditInvestigationInstance.ciCreatedDate = UserMaster.get(session.user_id).branch.runDate
        creditInvestigationInstance.lnTrackingStatus = ConfigItemStatus.get(2)
        creditInvestigationInstance.save(flush:true)
		def description = 'Loan credit investigation ' +  creditInvestigationInstance.id + ' was created by ' + UserMaster.get(session.user_id).username
        auditLogService.insert('090', 'LON00401', description, 'Loan', null, null, null, creditInvestigationInstance.id)
        
        }
        
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'creditInvestigation.label', default: 'CreditInvestigation'), creditInvestigationInstance.id])
                redirect creditInvestigationInstance
            }
            '*' { respond creditInvestigationInstance, [status: CREATED] }
        }
    }

    def edit(CreditInvestigation creditInvestigationInstance) {
        def creditTypeAction = params?.creditType
        respond creditInvestigationInstance, model:[creditTypeAction:creditTypeAction]
    }

    @Transactional
    def update(CreditInvestigation creditInvestigationInstance) {
        if (creditInvestigationInstance == null) {
            notFound()
            return
        }

        if (creditInvestigationInstance.hasErrors()) {
            respond creditInvestigationInstance.errors, view:'edit'
            return
        }
        def secAndUnsecCheck = params.loanAppSecOrUnsecId.toInteger()
        if(secAndUnsecCheck == 8 || secAndUnsecCheck == 5 || secAndUnsecCheck == 9 || secAndUnsecCheck == 2 || secAndUnsecCheck == 10){
            creditInvestigationInstance.folderReceivedByBranchDept = params.unsecfolderReceivedByBranchDept ? new Date().parse("MM/dd/yyyy", params?.unsecfolderReceivedByBranchDept) : null
            creditInvestigationInstance.folderTransToCau = params.unsecfolderTransToCau ? new Date().parse("MM/dd/yyyy", params?.unsecfolderTransToCau) : null
            creditInvestigationInstance.assignedToCi = params.unsecassignedToCi ? new Date().parse("MM/dd/yyyy", params?.unsecassignedToCi) : null
            creditInvestigationInstance.schedForCi = params.unsecschedForCi ? new Date().parse("MM/dd/yyyy", params?.unsecschedForCi) : null
            creditInvestigationInstance.performedCi = params.unsecperformedCi ? new Date().parse("MM/dd/yyyy", params?.unsecperformedCi) : null
            creditInvestigationInstance.assignedToAnalyst = params.unsecassignedToAnalyst ? new Date().parse("MM/dd/yyyy", params?.unsecassignedToAnalyst) : null
            creditInvestigationInstance.schedForAnalyst = params.unsecschedForAnalyst ? new Date().parse("MM/dd/yyyy", params?.unsecschedForAnalyst) : null
            creditInvestigationInstance.recommendation = params.unsecrecommendation 
            creditInvestigationInstance.performedByAnalyst = params.unsecperformedByAnalyst ? new Date().parse("MM/dd/yyyy", params?.unsecperformedByAnalyst) : null
            creditInvestigationInstance.submitAnalystRep = params.unsecsubmitAnalystRep ? new Date().parse("MM/dd/yyyy", params?.unsecsubmitAnalystRep) : null
           
        }
        
        creditInvestigationInstance.save flush:true
            def description = 'Loan credit investigation ' +  creditInvestigationInstance.id + ' was edited by ' + UserMaster.get(session.user_id).username
           auditLogService.insert('090', 'LON00402', description, 'Loan', null, null, null, creditInvestigationInstance.id)
        
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'CreditInvestigation.label', default: 'CreditInvestigation'), creditInvestigationInstance.id])
                redirect creditInvestigationInstance
            }
            '*'{ respond creditInvestigationInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(CreditInvestigation creditInvestigationInstance) {

        if (creditInvestigationInstance == null) {
            notFound()
            return
        }

        creditInvestigationInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'CreditInvestigation.label', default: 'CreditInvestigation'), creditInvestigationInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    /*
     * Attachments
     */

    def showAttachmentsAjax() {
        render(template:"attachments/list") as JSON
        return
    }    

    def showAttachmentsAjax2() {
        def id  = params?.id
        def creditInvestigationInstance = CreditInvestigation.get(id)

        render(template:"attachments/list", model:[creditInvestigationInstance:creditInvestigationInstance]) as JSON
        return
    } 

    def showAddAttachmentAjax() {    
        render(template:"attachments/form") as JSON
        return
    }

    def addAttachmentAjax() {  
        def description = params?.description
        def type = params?.type           

        if (params?.file == "undefined") {
            def attachment = new LoanAttachment(description: description, type: AttachmentType.get(type))
            attachment.errors.rejectValue("fileData", "loanAttachment.file.empty")

            render(template:"attachments/form", model:[attachment:attachment]) as JSON
            return
        }

        def fileName = params?.file?.getOriginalFilename()
        def fileType = params?.file?.getContentType()
        def fileData = params?.file?.getBytes()        

        def attachment = new LoanAttachment(fileName: fileName, fileType: fileType, fileData: fileData, 
            description: description, type: AttachmentType.get(type))
                
        def attachments
        if (session["attachments"]) {
            attachments = session["attachments"]
        } else {
            attachments = []
        }        
        attachments.add(attachment)
        session["attachments"] = attachments        

        def message = "Attachment successfully added"
        render(template:"attachments/form", model:[message:message]) as JSON    
        return
    }

    @Transactional
    def addAttachmentAjax2() { 
        def id  = params?.id 
        def description = params?.description
        def type = params?.type           

        if (params?.file == "undefined") {
            def attachment = new LoanAttachment(description: description, type: AttachmentType.get(type))
            attachment.errors.rejectValue("fileData", "loanAttachment.file.empty")

            render(template:"attachments/form", model:[attachment:attachment]) as JSON
            return
        }

        def fileName = params?.file?.getOriginalFilename()
        def fileType = params?.file?.getContentType()
        def fileData = params?.file?.getBytes()        

        def attachment = new LoanAttachment(fileName: fileName, fileType: fileType, fileData: fileData, 
            description: description, type: AttachmentType.get(type))
                
        def creditInvestigationInstance = CreditInvestigation.get(id)
        creditInvestigationInstance.addToAttachments(attachment)
        creditInvestigationInstance.save flush:true       

        def message = "Attachment successfully added"
        render(template:"attachments/form", model:[message:message]) as JSON    
        return
    }

    def showUpdateAttachmentAjax() {   
        def id = params?.id?.toInteger()
        
        def attachments = session["attachments"]        
        def attachment = attachments[id]

        render(template:"attachments/edit", model:[attachment:attachment]) as JSON
        return
    }

    def showUpdateAttachmentAjax2() {
        def id = params?.id?.toInteger()
        
        def attachment = LoanAttachment.get(id)

        render(template:"attachments/edit", model:[attachment:attachment]) as JSON
        return
    } 

    def updateAttachmentAjax() {  
        def id = params?.id?.toInteger()
        def description = params?.description
        def type = params?.type           

        def attachments = session["attachments"]        
        def attachment = attachments[id]

        attachment.description = description
        attachment.type = AttachmentType.get(type)

        def message = "Attachment successfully updated"
        render(template:"attachments/edit", model:[attachment:attachment, message:message]) as JSON    
        return
    }

    @Transactional
    def updateAttachmentAjax2() {  
        def id = params?.id?.toInteger()
        def description = params?.description
        def type = params?.type           

        def attachment = LoanAttachment.get(id)
        attachment.description = description
        attachment.type = AttachmentType.get(type)
        attachment.save flush:true

        def message = "Attachment successfully updated"
        render(template:"attachments/edit", model:[attachment:attachment, message:message]) as JSON    
        return
    }

    def deleteAttachmentAjax() {
        def id = params?.id?.toInteger()
        session["attachments"].remove(id)

        render "success"
        return
    }

    @Transactional
    def deleteAttachmentAjax2() {
        def id = params?.id?.toInteger()
        def attachmentId = params?.attachmentId?.toInteger()

        def creditInvestigationInstance = CreditInvestigation.get(id)
        def attachment = LoanAttachment.get(attachmentId)

        creditInvestigationInstance.removeFromAttachments(attachment)
        creditInvestigationInstance.save flush:true

        render "success"
        return
    }

    def showAttachment() {
        def id = params?.id
        def attachment = LoanAttachment.get(id)

        if (attachment) {
            response.setHeader("Content-Disposition", "inline;Filename=\"${attachment.fileName}\"")
            response.setContentType(attachment.fileType)
            response.outputStream << attachment.fileData
            response.outputStream.flush()
            response.outputStream.close()
        }
    }

    def downloadAttachment() {
        def id = params?.id
        def attachment = LoanAttachment.get(id)

        if (attachment) {
            response.setContentType("APPLICATION/OCTET-STREAM")
            response.setHeader("Content-Disposition", "Attachment;Filename=\"${attachment.fileName}\"")
            response.setContentType(attachment.fileType)
            response.outputStream << attachment.fileData
            response.outputStream.flush()
            response.outputStream.close()
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'creditInvestigation.label', default: 'CreditInvestigation'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
    