import icbs.loans.Collateral
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_collateralManagementcreate_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/collateralManagement/create.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(2)
createTagBody(2, {->
createClosureForHtmlPart(3, 3)
invokeTag('captureTitle','sitemesh',6,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',6,[:],2)
printHtmlPart(1)
createTagBody(2, {->
printHtmlPart(4)
expressionOut.print(createLink(controller:'customer', action:'showBasicCustomerInfoAjax'))
printHtmlPart(5)
expressionOut.print(createLink(controller: 'search', action:'search'))
printHtmlPart(6)
expressionOut.print(createLink(controller : 'search', action:'search', params:[searchDomain: "deposit"]))
printHtmlPart(7)
expressionOut.print(createLink(controller:'collateralManagement', action:'showPDCsAjax'))
printHtmlPart(8)
expressionOut.print(createLink(controller:'collateralManagement', action:'addPDCAjax'))
printHtmlPart(9)
expressionOut.print(createLink(controller: 'collateralManagement', action:'showAddPDCAjax'))
printHtmlPart(10)
expressionOut.print(createLink(controller:'collateralManagement', action:'updatePDCAjax'))
printHtmlPart(11)
expressionOut.print(createLink(controller:'collateralManagement', action:'showUpdatePDCAjax'))
printHtmlPart(12)
expressionOut.print(createLink(controller:'collateralManagement', action:'deletePDCAjax'))
printHtmlPart(13)
expressionOut.print(createLink(controller:'collateralManagement', action:'showAttachmentsAjax'))
printHtmlPart(14)
expressionOut.print(createLink(controller:'collateralManagement', action:'addAttachmentAjax'))
printHtmlPart(15)
expressionOut.print(createLink(controller: 'collateralManagement', action:'showAddAttachmentAjax'))
printHtmlPart(16)
expressionOut.print(createLink(controller:'collateralManagement', action:'updateAttachmentAjax'))
printHtmlPart(17)
expressionOut.print(createLink(controller:'collateralManagement', action:'showUpdateAttachmentAjax'))
printHtmlPart(18)
expressionOut.print(createLink(controller:'collateralManagement', action:'deleteAttachmentAjax'))
printHtmlPart(19)
expressionOut.print(createLink(controller:'collateralManagement', action:'showLoanApplicationsAjax'))
printHtmlPart(20)
expressionOut.print(createLink(controller:'collateralManagement', action:'addLoanApplicationAjax'))
printHtmlPart(21)
expressionOut.print(createLink(controller: 'loanApplication', action:'search'))
printHtmlPart(22)
expressionOut.print(createLink(controller:'collateralManagement', action:'deleteLoanApplicationAjax'))
printHtmlPart(23)
})
invokeTag('javascript','g',362,[:],2)
printHtmlPart(24)
})
invokeTag('captureHead','sitemesh',363,[:],1)
printHtmlPart(24)
createTagBody(1, {->
printHtmlPart(25)
createClosureForHtmlPart(26, 2)
invokeTag('captureContent','sitemesh',367,['tag':("breadcrumbs")],2)
printHtmlPart(25)
createTagBody(2, {->
printHtmlPart(27)
if(true && (flash.message)) {
printHtmlPart(28)
expressionOut.print(flash.message)
printHtmlPart(29)
}
printHtmlPart(30)
createClosureForHtmlPart(31, 3)
invokeTag('hasErrors','g',387,['bean':(collateralInstance)],3)
printHtmlPart(32)
createTagBody(3, {->
printHtmlPart(33)
invokeTag('render','g',403,['template':("details/form")],-1)
printHtmlPart(34)
invokeTag('render','g',406,['template':("pdc/list")],-1)
printHtmlPart(35)
invokeTag('render','g',409,['template':("attachments/list")],-1)
printHtmlPart(36)
invokeTag('render','g',412,['template':("loanApplications/list")],-1)
printHtmlPart(37)
})
invokeTag('uploadForm','g',413,['id':("collateral-form"),'url':([controller:collateralManagement, action:'save']),'onsubmit':("callLoadingDialog();")],3)
printHtmlPart(38)
})
invokeTag('captureContent','sitemesh',414,['tag':("main-content")],2)
printHtmlPart(25)
createTagBody(2, {->
printHtmlPart(39)
invokeTag('submitButton','g',426,['name':("save"),'value':("Save"),'onclick':("""
                    alertify.confirm(AppTitle,'Are you sure you want to continue this transaction?',
                    function(){
                        jQuery('#collateral-form').submit()
                        },
                    function(){
                        return;
                    });                        
                    """)],-1)
printHtmlPart(40)
createClosureForHtmlPart(41, 3)
invokeTag('link','g',431,['class':("list"),'action':("index"),'onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');")],3)
printHtmlPart(42)
})
invokeTag('captureContent','sitemesh',432,['tag':("main-actions")],2)
printHtmlPart(24)
})
invokeTag('captureBody','sitemesh',433,[:],1)
printHtmlPart(43)
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
