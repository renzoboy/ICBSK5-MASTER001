import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_tellering_tellerBalancingviewTellerCashTxn_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/tellering/tellerBalancing/viewTellerCashTxn.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',9,['gsp_sm_xmlClosingForEmptyTag':(""),'http-equiv':("Content-Type"),'content':("text/html; charset=UTF-8")],-1)
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',10,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
createTagBody(2, {->
createClosureForHtmlPart(2, 3)
invokeTag('captureTitle','sitemesh',11,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',11,[:],2)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',12,[:],1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(1)
createClosureForHtmlPart(4, 2)
invokeTag('captureContent','sitemesh',16,['tag':("breadcrumbs")],2)
printHtmlPart(1)
createTagBody(2, {->
printHtmlPart(5)
invokeTag('set','g',32,['var':("w"),'value':(0)],-1)
printHtmlPart(6)
invokeTag('set','g',33,['var':("x"),'value':(0)],-1)
printHtmlPart(6)
invokeTag('set','g',34,['var':("y"),'value':(0)],-1)
printHtmlPart(6)
invokeTag('set','g',35,['var':("z"),'value':(0)],-1)
printHtmlPart(6)
loop:{
int i = 0
for( tbc in (tbCash) ) {
printHtmlPart(7)
if(true && (tbc?.txnFile.txnDate == tbc?.branch?.runDate)) {
printHtmlPart(8)
createTagBody(5, {->
expressionOut.print(tbc?.txnFile.id)
})
invokeTag('link','g',39,['action':("txnReprint"),'id':(tbc?.txnFile.id)],5)
printHtmlPart(9)
expressionOut.print(tbc?.txnParticulars)
printHtmlPart(10)
if(true && (tbc.cashInAmt != 0)) {
printHtmlPart(11)
invokeTag('formatNumber','g',42,['number':(tbc.cashInAmt),'format':("###,###,##0.00")],-1)
printHtmlPart(10)
}
else {
printHtmlPart(12)
}
printHtmlPart(13)
if(true && (tbc.cashOutAmt != 0)) {
printHtmlPart(11)
invokeTag('formatNumber','g',48,['number':(tbc.cashOutAmt),'format':("###,###,##0.00")],-1)
printHtmlPart(10)
}
else {
printHtmlPart(12)
}
printHtmlPart(14)
if(true && (tbc.checkInAmt != 0)) {
printHtmlPart(11)
invokeTag('formatNumber','g',54,['number':(tbc.checkInAmt),'format':("###,###,##0.00")],-1)
printHtmlPart(10)
}
else {
printHtmlPart(12)
}
printHtmlPart(15)
if(true && (tbc.checkOutAmt != 0)) {
printHtmlPart(11)
invokeTag('formatNumber','g',60,['number':(tbc.checkOutAmt),'format':("###,###,##0.00")],-1)
printHtmlPart(10)
}
else {
printHtmlPart(12)
}
printHtmlPart(16)
invokeTag('set','g',65,['var':("w"),'value':(w + tbc?.cashInAmt)],-1)
printHtmlPart(16)
invokeTag('set','g',66,['var':("x"),'value':(x + tbc?.cashOutAmt)],-1)
printHtmlPart(17)
invokeTag('set','g',67,['var':("y"),'value':(y + tbc?.checkInAmt)],-1)
printHtmlPart(17)
invokeTag('set','g',68,['var':("z"),'value':(z + tbc?.checkOutAmt)],-1)
printHtmlPart(18)
}
printHtmlPart(19)
i++
}
}
printHtmlPart(20)
invokeTag('formatNumber','g',78,['number':(w),'format':("###,###,##0.00")],-1)
printHtmlPart(21)
invokeTag('formatNumber','g',82,['number':(x),'format':("###,###,##0.00")],-1)
printHtmlPart(22)
invokeTag('formatNumber','g',86,['number':(y),'format':("###,###,##0.00")],-1)
printHtmlPart(23)
invokeTag('formatNumber','g',90,['number':(z),'format':("###,###,##0.00")],-1)
printHtmlPart(24)
invokeTag('formatNumber','g',94,['number':(w-x),'format':("###,###,##0.00")],-1)
printHtmlPart(25)
invokeTag('formatNumber','g',98,['number':(y-z),'format':("###,###,##0.00")],-1)
printHtmlPart(26)
})
invokeTag('captureContent','sitemesh',102,['tag':("main-content")],2)
printHtmlPart(27)
createTagBody(2, {->
printHtmlPart(28)
createClosureForHtmlPart(29, 3)
invokeTag('link','g',105,['action':("Index")],3)
printHtmlPart(30)
createClosureForHtmlPart(31, 3)
invokeTag('link','g',106,['action':("viewTellerBalancing")],3)
printHtmlPart(32)
createTagBody(3, {->
printHtmlPart(33)
expressionOut.print(icbs.admin.Institution.get(94).paramValue)
expressionOut.print(icbs.admin.Report.get(38).baseParams)
printHtmlPart(34)
expressionOut.print(icbs.admin.Report.get(38).outputParam)
printHtmlPart(35)
expressionOut.print(icbs.admin.Report.get(38).reportUnit)
printHtmlPart(36)
expressionOut.print(session.user_id)
printHtmlPart(37)
expressionOut.print(g.formatDate(date: (runDate), format: 'yyyy-MM-dd'))
printHtmlPart(38)
expressionOut.print(icbs.admin.UserMaster.get(session.user_id).username)
printHtmlPart(39)
expressionOut.print(icbs.admin.Institution.get(94).paramValue)
expressionOut.print(icbs.admin.Report.get(39).baseParams)
printHtmlPart(34)
expressionOut.print(icbs.admin.Report.get(39).outputParam)
printHtmlPart(35)
expressionOut.print(icbs.admin.Report.get(39).reportUnit)
printHtmlPart(40)
expressionOut.print(session.branch)
printHtmlPart(41)
expressionOut.print(session.user_id)
printHtmlPart(37)
expressionOut.print(g.formatDate(date: (runDate), format: 'yyyy-MM-dd'))
printHtmlPart(42)
expressionOut.print(g.formatDate(date: (runDate), format: 'yyyy-MM-dd'))
printHtmlPart(38)
expressionOut.print(icbs.admin.UserMaster.get(session.user_id).username)
printHtmlPart(43)
expressionOut.print(icbs.admin.Institution.get(94).paramValue)
expressionOut.print(icbs.admin.Report.get(40).baseParams)
printHtmlPart(34)
expressionOut.print(icbs.admin.Report.get(40).outputParam)
printHtmlPart(35)
expressionOut.print(icbs.admin.Report.get(40).reportUnit)
printHtmlPart(40)
expressionOut.print(session.branch)
printHtmlPart(41)
expressionOut.print(session.user_id)
printHtmlPart(37)
expressionOut.print(g.formatDate(date: (runDate), format: 'yyyy-MM-dd'))
printHtmlPart(42)
expressionOut.print(g.formatDate(date: (runDate), format: 'yyyy-MM-dd'))
printHtmlPart(38)
expressionOut.print(icbs.admin.UserMaster.get(session.user_id).username)
printHtmlPart(44)
expressionOut.print(icbs.admin.Institution.get(94).paramValue)
expressionOut.print(icbs.admin.Report.get(41).baseParams)
printHtmlPart(34)
expressionOut.print(icbs.admin.Report.get(41).outputParam)
printHtmlPart(35)
expressionOut.print(icbs.admin.Report.get(41).reportUnit)
printHtmlPart(40)
expressionOut.print(session.branch)
printHtmlPart(41)
expressionOut.print(session.user_id)
printHtmlPart(37)
expressionOut.print(g.formatDate(date: (runDate), format: 'yyyy-MM-dd'))
printHtmlPart(45)
expressionOut.print(icbs.admin.UserMaster.get(session.user_id).username)
printHtmlPart(46)
})
invokeTag('javascript','g',159,[:],3)
printHtmlPart(47)
})
invokeTag('captureContent','sitemesh',163,['tag':("main-actions")],2)
printHtmlPart(48)
})
invokeTag('captureBody','sitemesh',164,[:],1)
printHtmlPart(49)
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
