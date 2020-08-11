import icbs.gl.AccountsReceivable
import icbs.gl.AccountsPayable
import icbs.loans.LoanApplicationComaker
import icbs.loans.Loan
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_customercustomerMembership_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/customer/customerMembership.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
printHtmlPart(1)
printHtmlPart(1)
printHtmlPart(1)
printHtmlPart(2)
createTagBody(1, {->
printHtmlPart(3)
createTagBody(2, {->
createClosureForHtmlPart(4, 3)
invokeTag('captureTitle','sitemesh',13,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',13,[:],2)
printHtmlPart(3)
invokeTag('captureMeta','sitemesh',14,['gsp_sm_xmlClosingForEmptyTag':(""),'http-equiv':("Content-Type"),'content':("text/html; charset=UTF-8")],-1)
printHtmlPart(3)
invokeTag('captureMeta','sitemesh',15,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(3)
invokeTag('javascript','asset',16,['src':("customerHelper.js")],-1)
printHtmlPart(3)
createTagBody(2, {->
printHtmlPart(5)
expressionOut.print(createLink(controller : 'customer', action:'getCustomerUpdateMembershipFormAjax'))
printHtmlPart(6)
expressionOut.print(customerInstance?.id)
printHtmlPart(7)
expressionOut.print(createLink(controller : 'customer', action:'customerUpdateMembershipAjax'))
printHtmlPart(8)
})
invokeTag('javascript','g',32,[:],2)
printHtmlPart(9)
})
invokeTag('captureHead','sitemesh',33,[:],1)
printHtmlPart(9)
createTagBody(1, {->
printHtmlPart(3)
createClosureForHtmlPart(10, 2)
invokeTag('captureContent','sitemesh',37,['tag':("breadcrumbs")],2)
printHtmlPart(3)
createTagBody(2, {->
printHtmlPart(11)
expressionOut.print(customerInstance?.displayName)
printHtmlPart(12)
invokeTag('set','g',50,['var':("primaryAddress"),'value':((customerInstance?.addresses?.find{it.isPrimary==true}))],-1)
printHtmlPart(13)
if(true && (primaryAddress!=null)) {
printHtmlPart(14)
expressionOut.print(primaryAddress?.address1 + ", "+ primaryAddress?.address2 +", " +primaryAddress?.town.description+", "+primaryAddress?.address3)
printHtmlPart(15)
}
else {
printHtmlPart(16)
}
printHtmlPart(17)
expressionOut.print(customerInstance?.birthDate?.format("MM/dd/yyyy"))
printHtmlPart(18)
loop:{
int i = 0
for( membershipHist in (icbs.cif.MembershipHistory.findAllByMember(customerInstance?.membership,[sort: "id", order: "asc"])) ) {
printHtmlPart(19)
expressionOut.print(membershipHist?.membershipType?.description)
printHtmlPart(20)
invokeTag('formatDate','g',87,['format':("MM/dd/yyyy"),'date':(membershipHist?.membershipDate)],-1)
printHtmlPart(20)
expressionOut.print(membershipHist?.refferedBy)
printHtmlPart(20)
expressionOut.print(membershipHist?.relationship?.itemValue)
printHtmlPart(20)
invokeTag('formatDate','g',90,['format':("MM/dd/yyyy"),'date':(membershipHist?.dateCreated)],-1)
printHtmlPart(20)
expressionOut.print(membershipHist?.createdBy?.username)
printHtmlPart(20)
expressionOut.print(membershipHist?.status?.description)
printHtmlPart(21)
i++
}
}
printHtmlPart(22)
invokeTag('render','g',109,['template':("/customer/details/customerInfo"),'model':([customerInstance:customerInstance])],-1)
printHtmlPart(23)
})
invokeTag('captureContent','sitemesh',121,['tag':("main-content")],2)
printHtmlPart(3)
createTagBody(2, {->
printHtmlPart(24)
createClosureForHtmlPart(25, 3)
invokeTag('link','g',125,['action':("customerInquiry"),'id':(customerInstance?.id)],3)
printHtmlPart(26)
})
invokeTag('captureContent','sitemesh',127,['tag':("main-actions")],2)
printHtmlPart(9)
})
invokeTag('captureBody','sitemesh',128,[:],1)
printHtmlPart(27)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1597124699080L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
