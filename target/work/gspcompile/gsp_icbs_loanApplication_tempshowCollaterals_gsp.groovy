import icbs.loans.Loan
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_loanApplication_tempshowCollaterals_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/loanApplication/temp/showCollaterals.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',6,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(2)
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'loan.label', default: 'Loan'))],-1)
printHtmlPart(2)
createTagBody(2, {->
createClosureForHtmlPart(3, 3)
invokeTag('captureTitle','sitemesh',8,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',8,[:],2)
printHtmlPart(2)
createTagBody(2, {->
printHtmlPart(4)
expressionOut.print(createLink(controller :'loan', action:'getDeductionSchemeInfoAjax'))
printHtmlPart(5)
})
invokeTag('javascript','g',49,[:],2)
printHtmlPart(6)
})
invokeTag('captureHead','sitemesh',50,[:],1)
printHtmlPart(6)
createTagBody(1, {->
printHtmlPart(7)
createTagBody(2, {->
printHtmlPart(8)
if(true && (flash.message)) {
printHtmlPart(9)
expressionOut.print(flash.message)
printHtmlPart(10)
}
printHtmlPart(11)
createTagBody(3, {->
printHtmlPart(12)
invokeTag('select','g',67,['name':("max"),'value':(params.max),'from':([5, 10, 15, 20]),'class':("form-control input-sm"),'onchange':("this.form.submit()")],-1)
printHtmlPart(13)
invokeTag('textField','g',70,['type':("text"),'name':("query"),'class':("form-control"),'placeholder':("Collateral ID")],-1)
printHtmlPart(14)
invokeTag('submitButton','g',72,['name':("Search"),'class':("btn btn-primary")],-1)
printHtmlPart(15)
})
invokeTag('form','g',77,['url':([controller:loanApplication, id:"${loanApplicationInstance?.id}", action:'showCollaterals']),'name':("list-form")],3)
printHtmlPart(16)
invokeTag('sortableColumn','g',83,['property':("id"),'title':("ID")],-1)
printHtmlPart(17)
invokeTag('sortableColumn','g',84,['property':("collateralType"),'title':("Type")],-1)
printHtmlPart(18)
invokeTag('sortableColumn','g',85,['property':("estimatedValue"),'title':("Estimated Value")],-1)
printHtmlPart(17)
invokeTag('sortableColumn','g',86,['property':("status"),'title':("Status")],-1)
printHtmlPart(19)
loop:{
int i = 0
for( collateral in (collaterals) ) {
printHtmlPart(20)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(21)
expressionOut.print(collateral?.id)
printHtmlPart(22)
expressionOut.print(collateral?.collateralType?.description)
printHtmlPart(23)
expressionOut.print(collateral?.estimatedValue)
printHtmlPart(24)
expressionOut.print(collateral?.status?.description)
printHtmlPart(22)
createClosureForHtmlPart(25, 4)
invokeTag('link','g',97,['class':("btn btn-secondary"),'action':("showCollateral"),'id':(collateral?.id),'params':([loanApplication:"${loanApplicationInstance?.id}"])],4)
printHtmlPart(26)
i++
}
}
printHtmlPart(27)
invokeTag('paginate','g',104,['total':(count ?: 0),'params':(params)],-1)
printHtmlPart(28)
createClosureForHtmlPart(29, 3)
invokeTag('link','g',108,['class':("btn btn-primary"),'action':("createCollateral"),'params':([loanApplication:"${loanApplicationInstance?.id}"])],3)
printHtmlPart(30)
})
invokeTag('captureContent','sitemesh',109,['tag':("main-content")],2)
printHtmlPart(7)
createTagBody(2, {->
printHtmlPart(31)
createClosureForHtmlPart(32, 3)
invokeTag('link','g',114,['class':("list"),'action':("index")],3)
printHtmlPart(33)
createClosureForHtmlPart(34, 3)
invokeTag('link','g',115,['class':("create"),'action':("create")],3)
printHtmlPart(33)
createClosureForHtmlPart(35, 3)
invokeTag('link','g',117,['action':("show"),'id':(loanApplicationInstance.id)],3)
printHtmlPart(33)
createClosureForHtmlPart(36, 3)
invokeTag('link','g',118,['action':("showDetails"),'id':(loanApplicationInstance.id)],3)
printHtmlPart(33)
createClosureForHtmlPart(37, 3)
invokeTag('link','g',119,['action':("editSpecification"),'resource':(loanApplicationInstance)],3)
printHtmlPart(33)
createClosureForHtmlPart(38, 3)
invokeTag('link','g',120,['action':("editFinancialDetails"),'resource':(loanApplicationInstance)],3)
printHtmlPart(33)
createClosureForHtmlPart(39, 3)
invokeTag('link','g',121,['action':("editComakers"),'resource':(loanApplicationInstance)],3)
printHtmlPart(40)
})
invokeTag('captureContent','sitemesh',123,['tag':("main-actions")],2)
printHtmlPart(6)
})
invokeTag('captureBody','sitemesh',123,[:],1)
printHtmlPart(41)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1592209176000L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
