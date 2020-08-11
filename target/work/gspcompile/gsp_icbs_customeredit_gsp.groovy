import icbs.cif.Customer
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_customeredit_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/customer/edit.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':(""),'http-equiv':("Content-Type"),'content':("text/html; charset=UTF-8")],-1)
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',6,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
invokeTag('javascript','asset',7,['src':("customerHelper.js")],-1)
printHtmlPart(1)
invokeTag('set','g',8,['var':("entityName"),'value':(message(code: 'customer.label', default: 'Customer'))],-1)
printHtmlPart(1)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',9,['code':("default.edit.label"),'args':([entityName])],-1)
printHtmlPart(2)
if(true && (customerInstance?.displayName)) {
printHtmlPart(3)
expressionOut.print(customerInstance?.displayName)
printHtmlPart(4)
}
printHtmlPart(5)
})
invokeTag('captureTitle','sitemesh',15,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',15,[:],2)
printHtmlPart(6)
createTagBody(2, {->
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
expressionOut.print(customerInstance?.contacts.size())
printHtmlPart(32)
expressionOut.print(customerInstance?.attachments.size())
printHtmlPart(33)
expressionOut.print(customerInstance?.addresses.size())
printHtmlPart(34)
expressionOut.print(customerInstance?.beneficiaries.size())
printHtmlPart(35)
expressionOut.print(customerInstance?.relations.size())
printHtmlPart(36)
expressionOut.print(customerInstance?.otheraccts.size())
printHtmlPart(37)
expressionOut.print(customerInstance?.presentedids.size())
printHtmlPart(38)
expressionOut.print(customerInstance?.educations.size())
printHtmlPart(39)
})
invokeTag('javascript','g',139,[:],2)
printHtmlPart(40)
})
invokeTag('captureHead','sitemesh',140,[:],1)
printHtmlPart(40)
createTagBody(1, {->
printHtmlPart(1)
createClosureForHtmlPart(41, 2)
invokeTag('captureContent','sitemesh',144,['tag':("breadcrumbs")],2)
printHtmlPart(1)
createTagBody(2, {->
printHtmlPart(42)
if(true && (flash.message)) {
printHtmlPart(43)
expressionOut.print(flash.message)
printHtmlPart(44)
}
printHtmlPart(42)
createClosureForHtmlPart(45, 3)
invokeTag('hasErrors','g',166,['bean':(customerInstance)],3)
printHtmlPart(46)
createTagBody(3, {->
printHtmlPart(4)
invokeTag('render','g',168,['template':("form")],-1)
printHtmlPart(42)
})
invokeTag('uploadForm','g',169,['id':("updateCustomerForm"),'url':([resource:customerInstance,action:'update']),'method':("POST"),'onsubmit':("callLoadingDialog();")],3)
printHtmlPart(1)
})
invokeTag('captureContent','sitemesh',170,['tag':("main-content")],2)
printHtmlPart(1)
createTagBody(2, {->
printHtmlPart(47)
expressionOut.print(customerInstance.id)
printHtmlPart(48)
expressionOut.print(customerInstance.type.id)
printHtmlPart(49)
})
invokeTag('captureContent','sitemesh',218,['tag':("main-actions")],2)
printHtmlPart(40)
})
invokeTag('captureBody','sitemesh',219,[:],1)
printHtmlPart(50)
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
