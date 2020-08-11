import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_customercreate_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/customer/create.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',4,['gsp_sm_xmlClosingForEmptyTag':(""),'http-equiv':("Content-Type"),'content':("text/html; charset=UTF-8")],-1)
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
invokeTag('javascript','asset',6,['src':("customerHelper.js")],-1)
printHtmlPart(1)
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'customer.label', default: 'Customer'))],-1)
printHtmlPart(1)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',8,['code':("default.create.label"),'args':([entityName])],-1)
printHtmlPart(2)
if(true && (customerInstance?.displayName)) {
printHtmlPart(3)
expressionOut.print(customerInstance?.displayName)
printHtmlPart(4)
}
printHtmlPart(5)
})
invokeTag('captureTitle','sitemesh',14,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',14,[:],2)
printHtmlPart(1)
createTagBody(2, {->
printHtmlPart(6)
expressionOut.print(createLink(controller : 'customer', action:'customerVerificationValidationAjax'))
printHtmlPart(7)
expressionOut.print(createLink(controller : 'customer', action:'customerVerificationValidationAjax'))
printHtmlPart(8)
expressionOut.print(createLink(controller : 'customer', action:'customerAddressInformationValidationAjax'))
printHtmlPart(9)
expressionOut.print(createLink(controller : 'customer', action:'customerBeneficiaryInformationValidationAjax'))
printHtmlPart(10)
expressionOut.print(createLink(controller : 'customer', action:'customerInsuranceInformationValidationAjax'))
printHtmlPart(11)
expressionOut.print(createLink(controller : 'customer', action:'customerContactInformationValidationAjax'))
printHtmlPart(12)
expressionOut.print(createLink(controller : 'customer', action:'customerOtherDetailsValidationAjax'))
printHtmlPart(13)
expressionOut.print(customerInstance?.type?.id)
printHtmlPart(14)
expressionOut.print(createLink(controller : 'customer', action:'customerEducationInformationValidationAjax'))
printHtmlPart(15)
expressionOut.print(createLink(controller : 'customer', action:'customerEmploymentBusinessInformationValidationAjax'))
printHtmlPart(16)
expressionOut.print(customerInstance?.type?.id)
printHtmlPart(17)
expressionOut.print(createLink(controller : 'customer', action:'customerIdsAndOtherAcctsValidationAjax'))
printHtmlPart(18)
expressionOut.print(customerInstance?.type?.id)
printHtmlPart(19)
expressionOut.print(createLink(controller : 'customer', action:'customerRelationValidationAjax'))
printHtmlPart(20)
expressionOut.print(createLink(controller : 'customer', action:'changeCustomerTypeFormAjax'))
printHtmlPart(21)
expressionOut.print(createLink(controller : 'customer', action:'addAddressFormAjax'))
printHtmlPart(22)
expressionOut.print(createLink(controller : 'customer', action:'addBeneficiaryFormAjax'))
printHtmlPart(23)
expressionOut.print(createLink(controller : 'customer', action:'addAttachmentFormAjax'))
printHtmlPart(24)
expressionOut.print(createLink(controller : 'customer', action:'addContactFormAjax'))
printHtmlPart(25)
expressionOut.print(createLink(controller : 'customer', action:'addEducationFormAjax'))
printHtmlPart(26)
expressionOut.print(createLink(controller : 'customer', action:'addOtherAcctFormAjax'))
printHtmlPart(27)
expressionOut.print(createLink(controller : 'customer', action:'addPresentedIdFormAjax'))
printHtmlPart(28)
expressionOut.print(createLink(controller : 'customer', action:'addRelationFormAjax'))
printHtmlPart(29)
expressionOut.print(createLink(controller : 'customer', action:'addRelationFormAjax'))
printHtmlPart(30)
expressionOut.print(createLink(controller : 'search', action:'search'))
printHtmlPart(31)
})
invokeTag('javascript','g',102,[:],2)
printHtmlPart(32)
})
invokeTag('captureHead','sitemesh',103,[:],1)
printHtmlPart(32)
createTagBody(1, {->
printHtmlPart(1)
createClosureForHtmlPart(33, 2)
invokeTag('captureContent','sitemesh',107,['tag':("breadcrumbs")],2)
printHtmlPart(1)
createTagBody(2, {->
printHtmlPart(34)
if(true && (flash.message)) {
printHtmlPart(35)
expressionOut.print(flash.message)
printHtmlPart(36)
}
printHtmlPart(34)
createClosureForHtmlPart(37, 3)
invokeTag('hasErrors','g',129,['bean':(customerInstance)],3)
printHtmlPart(38)
if(true && (firstCreate)) {
printHtmlPart(34)
createTagBody(4, {->
printHtmlPart(4)
invokeTag('render','g',133,['template':("form/customer/customerverification/customerType")],-1)
printHtmlPart(34)
})
invokeTag('form','g',134,['id':("saveCustomerForm"),'url':([resource:customerInstance,action:'create']),'method':("POST"),'class':("form-horizontal"),'onsubmit':("callLoadingDialog();")],4)
printHtmlPart(38)
}
else {
printHtmlPart(34)
createTagBody(4, {->
printHtmlPart(4)
invokeTag('render','g',138,['template':("form")],-1)
printHtmlPart(34)
})
invokeTag('uploadForm','g',139,['id':("saveCustomerForm"),'onsubmit':("callLoadingDialog();"),'url':([resource:customerInstance,action:'save']),'method':("POST"),'class':("form-horizontal")],4)
printHtmlPart(38)
}
printHtmlPart(1)
})
invokeTag('captureContent','sitemesh',141,['tag':("main-content")],2)
printHtmlPart(1)
createTagBody(2, {->
printHtmlPart(39)
if(true && (!firstCreate)) {
printHtmlPart(40)
}
else {
printHtmlPart(41)
}
printHtmlPart(42)
createClosureForHtmlPart(43, 3)
invokeTag('javascript','g',253,[:],3)
printHtmlPart(44)
})
invokeTag('captureContent','sitemesh',255,['tag':("main-actions")],2)
printHtmlPart(32)
})
invokeTag('captureBody','sitemesh',256,[:],1)
printHtmlPart(32)
createTagBody(1, {->
printHtmlPart(45)
expressionOut.print(customerInstance?.contacts.size())
printHtmlPart(46)
expressionOut.print(customerInstance?.attachments.size())
printHtmlPart(47)
expressionOut.print(customerInstance?.addresses.size())
printHtmlPart(48)
expressionOut.print(customerInstance?.beneficiaries.size())
printHtmlPart(49)
expressionOut.print(customerInstance?.relations.size())
printHtmlPart(50)
expressionOut.print(customerInstance?.otheraccts.size())
printHtmlPart(51)
expressionOut.print(customerInstance?.presentedids.size())
printHtmlPart(52)
expressionOut.print(customerInstance?.educations.size())
printHtmlPart(53)
})
invokeTag('javascript','g',266,[:],1)
printHtmlPart(54)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1597132938941L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
