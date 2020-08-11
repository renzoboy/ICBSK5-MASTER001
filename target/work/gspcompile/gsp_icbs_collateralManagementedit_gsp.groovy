import icbs.loans.Collateral
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_collateralManagementedit_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/collateralManagement/edit.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
createTagBody(2, {->
createClosureForHtmlPart(2, 3)
invokeTag('captureTitle','sitemesh',6,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',6,[:],2)
printHtmlPart(1)
createTagBody(2, {->
printHtmlPart(3)
expressionOut.print(createLink(controller:'customer', action:'showBasicCustomerInfoAjax'))
printHtmlPart(4)
expressionOut.print(createLink(controller: 'search', action:'search'))
printHtmlPart(5)
expressionOut.print(collateralInstance?.id)
printHtmlPart(6)
expressionOut.print(createLink(controller:'collateralManagement', action:'showPDCsAjax2'))
printHtmlPart(7)
expressionOut.print(collateralInstance?.id)
printHtmlPart(8)
expressionOut.print(createLink(controller:'collateralManagement', action:'addPDCAjax2'))
printHtmlPart(9)
expressionOut.print(createLink(controller: 'collateralManagement', action:'showAddPDCAjax'))
printHtmlPart(10)
expressionOut.print(createLink(controller:'collateralManagement', action:'updatePDCAjax2'))
printHtmlPart(11)
expressionOut.print(createLink(controller:'collateralManagement', action:'showUpdatePDCAjax2'))
printHtmlPart(12)
expressionOut.print(collateralInstance?.id)
printHtmlPart(13)
expressionOut.print(createLink(controller:'collateralManagement', action:'deletePDCAjax2'))
printHtmlPart(14)
expressionOut.print(collateralInstance?.id)
printHtmlPart(6)
expressionOut.print(createLink(controller:'collateralManagement', action:'showAttachmentsAjax2'))
printHtmlPart(15)
expressionOut.print(collateralInstance?.id)
printHtmlPart(16)
expressionOut.print(createLink(controller:'collateralManagement', action:'addAttachmentAjax2'))
printHtmlPart(17)
expressionOut.print(createLink(controller: 'collateralManagement', action:'showAddAttachmentAjax'))
printHtmlPart(18)
expressionOut.print(createLink(controller:'collateralManagement', action:'updateAttachmentAjax2'))
printHtmlPart(19)
expressionOut.print(createLink(controller:'collateralManagement', action:'showUpdateAttachmentAjax2'))
printHtmlPart(20)
expressionOut.print(collateralInstance?.id)
printHtmlPart(21)
expressionOut.print(createLink(controller:'collateralManagement', action:'deleteAttachmentAjax2'))
printHtmlPart(22)
expressionOut.print(collateralInstance?.id)
printHtmlPart(6)
expressionOut.print(createLink(controller:'collateralManagement', action:'showLoanApplicationsAjax2'))
printHtmlPart(23)
expressionOut.print(collateralInstance?.id)
printHtmlPart(24)
expressionOut.print(createLink(controller:'collateralManagement', action:'addLoanApplicationAjax2'))
printHtmlPart(25)
expressionOut.print(createLink(controller: 'loanApplication', action:'search'))
printHtmlPart(26)
expressionOut.print(collateralInstance?.id)
printHtmlPart(27)
expressionOut.print(createLink(controller:'collateralManagement', action:'deleteLoanApplicationAjax2'))
printHtmlPart(28)
})
invokeTag('javascript','g',363,[:],2)
printHtmlPart(29)
})
invokeTag('captureHead','sitemesh',364,[:],1)
printHtmlPart(30)
createTagBody(1, {->
printHtmlPart(31)
createClosureForHtmlPart(32, 2)
invokeTag('captureContent','sitemesh',368,['tag':("breadcrumbs")],2)
printHtmlPart(31)
createTagBody(2, {->
printHtmlPart(33)
if(true && (flash.message)) {
printHtmlPart(34)
expressionOut.print(flash.message)
printHtmlPart(35)
}
printHtmlPart(36)
createTagBody(3, {->
printHtmlPart(37)
expressionOut.print(it)
printHtmlPart(38)
})
invokeTag('hasErrors','g',388,['bean':(collateralInstance)],3)
printHtmlPart(39)
createTagBody(3, {->
printHtmlPart(40)
invokeTag('hiddenField','g',392,['name':("version"),'value':(collateralInstance?.version)],-1)
printHtmlPart(41)
invokeTag('render','g',403,['template':("details/form")],-1)
printHtmlPart(42)
invokeTag('render','g',406,['template':("pdc/list")],-1)
printHtmlPart(43)
invokeTag('render','g',409,['template':("attachments/list")],-1)
printHtmlPart(44)
invokeTag('render','g',412,['template':("loanApplications/list")],-1)
printHtmlPart(45)
})
invokeTag('form','g',415,['id':("collateral-form"),'url':([controller:collateralManagement, action:'update', id:collateralInstance?.id]),'method':("PUT"),'onsubmit':("callLoadingDialog();")],3)
printHtmlPart(46)
})
invokeTag('captureContent','sitemesh',417,['tag':("main-content")],2)
printHtmlPart(36)
createTagBody(2, {->
printHtmlPart(47)
invokeTag('submitButton','g',420,['id':("save"),'name':("save"),'value':("Save")],-1)
printHtmlPart(48)
createClosureForHtmlPart(49, 3)
invokeTag('link','g',435,['class':("list"),'action':("show"),'id':(collateralInstance.id),'onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');")],3)
printHtmlPart(50)
})
invokeTag('captureContent','sitemesh',437,['tag':("main-actions")],2)
printHtmlPart(51)
})
invokeTag('captureBody','sitemesh',439,[:],1)
printHtmlPart(52)
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
