import icbs.tellering.TxnCOCI
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_depositdepositViewMoreInformation_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/deposit/depositViewMoreInformation.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':(""),'http-equiv':("Content-Type"),'content':("text/html; charset=UTF-8")],-1)
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',6,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(2)
createTagBody(2, {->
createClosureForHtmlPart(3, 3)
invokeTag('captureTitle','sitemesh',7,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',7,[:],2)
printHtmlPart(4)
})
invokeTag('captureHead','sitemesh',8,[:],1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(2)
createClosureForHtmlPart(5, 2)
invokeTag('captureContent','sitemesh',12,['tag':("breadcrumbs")],2)
printHtmlPart(2)
createTagBody(2, {->
printHtmlPart(6)
expressionOut.print(depositInstance?.acctNo)
printHtmlPart(7)
invokeTag('render','g',18,['template':("/customer/details/newCustomerDetailedInfo"),'model':([customerInstance:depositInstance?.customer])],-1)
printHtmlPart(8)
invokeTag('render','g',34,['template':("viewMoreInfoTemplates/accountAndBalance")],-1)
printHtmlPart(9)
invokeTag('render','g',38,['template':("viewMoreInfoTemplates/owner")],-1)
printHtmlPart(10)
invokeTag('render','g',42,['template':("/search/searchTemplate/deposit/txn/viewGrid")],-1)
printHtmlPart(11)
invokeTag('render','g',46,['template':("viewMoreInfoTemplates/unclearedDeposits")],-1)
printHtmlPart(12)
})
invokeTag('captureContent','sitemesh',50,['tag':("main-content")],2)
printHtmlPart(2)
createTagBody(2, {->
printHtmlPart(13)
createClosureForHtmlPart(14, 3)
invokeTag('link','g',53,['action':("depositInquiry"),'id':(depositInstance?.id),'onclick':("return confirm('Are you sure you want to return to Deposit Inquiries page?');  ")],3)
printHtmlPart(15)
createClosureForHtmlPart(14, 3)
invokeTag('link','g',54,['action':("depositInquiry"),'id':(depositInstance?.id)],3)
printHtmlPart(16)
createTagBody(3, {->
printHtmlPart(17)
expressionOut.print(icbs.admin.Institution.get(90).paramValue)
expressionOut.print(icbs.admin.Report.get(14).baseParams)
printHtmlPart(18)
expressionOut.print(icbs.admin.Report.get(14).outputParam)
printHtmlPart(19)
expressionOut.print(icbs.admin.Report.get(14).reportUnit)
printHtmlPart(20)
expressionOut.print(depositInstance?.acctNo)
printHtmlPart(21)
expressionOut.print(icbs.admin.UserMaster.get(session.user_id).username)
printHtmlPart(22)
})
invokeTag('javascript','g',66,[:],3)
printHtmlPart(23)
expressionOut.print(hasErrors(bean: customerInstance, field: 'registrationDate', 'has-error'))
printHtmlPart(24)
invokeTag('customDatePicker','g',85,['name':("date1"),'id':("date1"),'precision':("day"),'class':("form-control"),'value':(""),'default':("none"),'noSelection':(['': ''])],-1)
printHtmlPart(25)
expressionOut.print(hasErrors(bean: customerInstance, field: 'registrationDate', 'has-error'))
printHtmlPart(26)
invokeTag('customDatePicker','g',90,['name':("date2"),'id':("date2"),'precision':("day"),'class':("form-control"),'value':(""),'default':("none"),'noSelection':(['': ''])],-1)
printHtmlPart(27)
createTagBody(3, {->
printHtmlPart(28)
expressionOut.print(icbs.admin.Institution.get(94).paramValue)
expressionOut.print(icbs.admin.Report.get(15).baseParams)
printHtmlPart(18)
expressionOut.print(icbs.admin.Report.get(15).outputParam)
printHtmlPart(29)
expressionOut.print(icbs.admin.Report.get(15).reportUnit)
printHtmlPart(30)
expressionOut.print(depositInstance?.acctNo)
printHtmlPart(31)
expressionOut.print(icbs.admin.UserMaster.get(session.user_id).username)
printHtmlPart(32)
})
invokeTag('javascript','g',108,[:],3)
printHtmlPart(33)
})
invokeTag('captureContent','sitemesh',115,['tag':("main-actions")],2)
printHtmlPart(4)
})
invokeTag('captureBody','sitemesh',116,[:],1)
printHtmlPart(34)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1595820635024L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
