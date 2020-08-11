import icbs.admin.UserMaster
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_periodicOpsEODCheck_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/periodicOps/EODCheck.gsp" }
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
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'userMaster.label', default: 'UserMaster'))],-1)
printHtmlPart(2)
createTagBody(2, {->
createClosureForHtmlPart(3, 3)
invokeTag('captureTitle','sitemesh',8,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',8,[:],2)
printHtmlPart(4)
})
invokeTag('captureHead','sitemesh',9,[:],1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(6)
expressionOut.print(createLink(uri: '/periodicOps'))
printHtmlPart(7)
})
invokeTag('captureContent','sitemesh',14,['tag':("breadcrumbs")],2)
printHtmlPart(8)
createTagBody(2, {->
printHtmlPart(9)
if(true && (flash.message)) {
printHtmlPart(10)
expressionOut.print(flash.message)
printHtmlPart(11)
expressionOut.print(flash.message)
printHtmlPart(12)
}
printHtmlPart(13)
invokeTag('sortableColumn','g',37,['property':("username"),'title':(message(code: 'userMaster.username.label', default: 'User Name'))],-1)
printHtmlPart(14)
invokeTag('sortableColumn','g',38,['property':("branch"),'title':(message(code: 'userMaster.branch.label', default: 'Branch Name'))],-1)
printHtmlPart(14)
invokeTag('sortableColumn','g',39,['property':("login"),'title':(message(code: 'userSession.login.label', default: 'Login'))],-1)
printHtmlPart(15)
loop:{
int i = 0
for( loggedUserInstance in (loggedUserList) ) {
printHtmlPart(16)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(17)
expressionOut.print(loggedUserInstance.userMaster.username)
printHtmlPart(18)
expressionOut.print(loggedUserInstance.userMaster.branch.name)
printHtmlPart(18)
expressionOut.print(loggedUserInstance.login)
printHtmlPart(19)
expressionOut.print(loggedUserInstance.userMasterId)
printHtmlPart(20)
i++
}
}
printHtmlPart(21)
invokeTag('sortableColumn','g',61,['property':("username"),'title':(message(code: 'userMaster.username.label', default: 'Username'))],-1)
printHtmlPart(22)
invokeTag('sortableColumn','g',63,['property':("name1"),'title':(message(code: 'userMaster.name1.label', default: 'Full Name'))],-1)
printHtmlPart(22)
invokeTag('sortableColumn','g',65,['property':("branch"),'title':(message(code: 'userMaster.branch.label', default: 'Branch'))],-1)
printHtmlPart(22)
invokeTag('sortableColumn','g',67,['property':("designation"),'title':(message(code: 'userMaster.designation.label', default: 'Designation'))],-1)
printHtmlPart(22)
invokeTag('sortableColumn','g',69,['property':("configItemStatus"),'title':(message(code: 'currency.configItemStatus.label', default: 'Status'))],-1)
printHtmlPart(23)
invokeTag('sortableColumn','g',71,['property':("isLocked"),'title':(message(code: 'userMaster.isLocked.label', default: 'Locked'))],-1)
printHtmlPart(23)
invokeTag('sortableColumn','g',73,['property':("isTellerBalanced"),'title':(message(code: 'userMaster.isTellerBalanced.label', default: 'Balanced'))],-1)
printHtmlPart(24)
loop:{
int i = 0
for( userMasterInstance in (userMasterInstanceList) ) {
printHtmlPart(25)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(26)
expressionOut.print(fieldValue(bean: userMasterInstance, field: "username"))
printHtmlPart(27)
expressionOut.print(fieldValue(bean: userMasterInstance, field: "name1") + " " + fieldValue(bean: userMasterInstance, field: "name2") + " " + fieldValue(bean: userMasterInstance, field: "name3"))
printHtmlPart(28)
expressionOut.print(fieldValue(bean: userMasterInstance, field: "branch.name"))
printHtmlPart(27)
expressionOut.print(fieldValue(bean: userMasterInstance, field: "designation.description"))
printHtmlPart(29)
if(true && (userMasterInstance.configItemStatus.description == 'Active')) {
printHtmlPart(30)
}
else {
printHtmlPart(31)
}
printHtmlPart(23)
if(true && (userMasterInstance.isLocked)) {
printHtmlPart(32)
}
else {
printHtmlPart(33)
}
printHtmlPart(34)
if(true && (userMasterInstance.isTellerBalanced)) {
printHtmlPart(32)
}
else {
printHtmlPart(33)
}
printHtmlPart(35)
expressionOut.print(userMasterInstance.id)
printHtmlPart(36)
i++
}
}
printHtmlPart(37)
invokeTag('sortableColumn','g',118,['property':("userId"),'title':(message(code: 'txnTellerBalance.user.label', default: 'Username'))],-1)
printHtmlPart(38)
invokeTag('sortableColumn','g',119,['property':("branch"),'title':(message(code: 'txnTellerBalance.user.branch.label', default: 'Branch'))],-1)
printHtmlPart(14)
invokeTag('sortableColumn','g',120,['property':("cashIn"),'title':(message(code: 'txnTellerBalance.cashIn.label', default: 'Cash In'))],-1)
printHtmlPart(14)
invokeTag('sortableColumn','g',121,['property':("cashOut"),'title':(message(code: 'txnTellerBalance.cashOut.label', default: 'Cash Out'))],-1)
printHtmlPart(39)
loop:{
int i = 0
for( txnCashInstance in (txnCashList) ) {
printHtmlPart(16)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(17)
expressionOut.print(txnCashInstance?.user?.username)
printHtmlPart(18)
expressionOut.print(txnCashInstance?.user?.branch?.name)
printHtmlPart(18)
invokeTag('formatNumber','g',129,['format':("###,###,##0.00"),'number':(txnCashInstance?.cashIn)],-1)
printHtmlPart(18)
invokeTag('formatNumber','g',130,['format':("###,###,##0.00"),'number':(txnCashInstance?.cashOut)],-1)
printHtmlPart(40)
i++
}
}
printHtmlPart(41)
invokeTag('sortableColumn','g',140,['property':("accountNo"),'title':(message(code: 'loan.accountNo.label', default: 'Loan Account'))],-1)
printHtmlPart(38)
invokeTag('sortableColumn','g',141,['property':("branch"),'title':(message(code: 'loan.branch.label', default: 'Branch'))],-1)
printHtmlPart(14)
invokeTag('sortableColumn','g',142,['property':("totalDisbursementAmount"),'title':(message(code: 'loan.totalDisbursementAmount.label', default: 'Amount Disbursed'))],-1)
printHtmlPart(14)
invokeTag('sortableColumn','g',143,['property':("totalNetProceeds"),'title':(message(code: 'loan.totalNetProceeds.label', default: 'Net Proceeds'))],-1)
printHtmlPart(14)
invokeTag('sortableColumn','g',144,['property':("dateApproved"),'title':(message(code: 'loan.totalNetProceeds.label', default: 'Date Approved'))],-1)
printHtmlPart(39)
loop:{
int i = 0
for( loanInstance in (loanInstanceList) ) {
printHtmlPart(16)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(17)
expressionOut.print(loanInstance.accountNo)
printHtmlPart(18)
expressionOut.print(fieldValue(bean: loanInstance, field: "branch.name"))
printHtmlPart(18)
invokeTag('formatNumber','g',152,['format':("###,###,##0.00"),'number':(loanInstance?.totalDisbursementAmount)],-1)
printHtmlPart(18)
invokeTag('formatNumber','g',153,['format':("###,###,##0.00"),'number':(loanInstance?.totalNetProceeds)],-1)
printHtmlPart(18)
invokeTag('formatDate','g',154,['format':("yyyy-MM-dd"),'date':(loanInstance?.dateApproved)],-1)
printHtmlPart(40)
i++
}
}
printHtmlPart(42)
invokeTag('sortableColumn','g',163,['property':("branch"),'title':("Branch")],-1)
printHtmlPart(14)
invokeTag('sortableColumn','g',164,['property':("id"),'title':("Batch#")],-1)
printHtmlPart(14)
invokeTag('sortableColumn','g',165,['property':("batchName"),'title':("Batch Name")],-1)
printHtmlPart(14)
invokeTag('sortableColumn','g',166,['property':("createdBy"),'title':("User")],-1)
printHtmlPart(43)
loop:{
int i = 0
for( upGl in (unpostedGlList) ) {
printHtmlPart(16)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(17)
expressionOut.print(upGl?.branch?.name)
printHtmlPart(18)
expressionOut.print(upGl?.id)
printHtmlPart(18)
expressionOut.print(upGl?.batchName)
printHtmlPart(18)
expressionOut.print(upGl?.createdBy?.username)
printHtmlPart(40)
i++
}
}
printHtmlPart(44)
expressionOut.print(createLink(controller:'UserMaster', action: 'adminForceLogoutPerUser'))
printHtmlPart(45)
expressionOut.print(createLink(controller:'tellering', action: 'forceBalancePerUser'))
printHtmlPart(46)
})
invokeTag('captureContent','sitemesh',276,['tag':("main-content")],2)
printHtmlPart(8)
createTagBody(2, {->
printHtmlPart(47)
expressionOut.print(createLink(uri: '/'))
printHtmlPart(48)
createClosureForHtmlPart(49, 3)
invokeTag('link','g',280,['class':("index"),'action':("index")],3)
printHtmlPart(50)
if(true && (userMasterInstanceList)) {
printHtmlPart(51)
}
else {
printHtmlPart(52)
}
printHtmlPart(53)
if(true && (loggedUserList)) {
printHtmlPart(54)
}
else {
printHtmlPart(55)
}
printHtmlPart(56)
expressionOut.print(createLink(controller:'UserMaster', action: 'adminForceLogoutAllUser'))
printHtmlPart(57)
expressionOut.print(createLink(controller:'tellering', action: 'forceBalanceAllUser'))
printHtmlPart(58)
})
invokeTag('captureContent','sitemesh',362,['tag':("main-actions")],2)
printHtmlPart(4)
})
invokeTag('captureBody','sitemesh',363,[:],1)
printHtmlPart(59)
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
