import icbs.loans.LoanApplicationSpecAdditional
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_creditInvestigation_details_show_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/creditInvestigation/details/_show.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
if(true && (secUnsecTag == "unsec")) {
printHtmlPart(2)
}
else {
printHtmlPart(3)
}
printHtmlPart(4)
if(true && (secUnsecTag == "secured")) {
printHtmlPart(5)
invokeTag('formatDate','g',16,['format':("MM/dd/yyyy"),'date':(creditInvestigationInstance?.ciCreatedDate),'style':("FULL")],-1)
printHtmlPart(6)
createTagBody(2, {->
expressionOut.print(creditInvestigationInstance?.loanApplication?.id)
})
invokeTag('link','g',21,['controller':("loanApplication"),'action':("show"),'id':(creditInvestigationInstance?.loanApplication?.id)],2)
printHtmlPart(7)
invokeTag('formatDate','g',25,['format':("MM/dd/yyyy"),'date':(creditInvestigationInstance?.loanApplication?.applicationDate),'style':("FULL")],-1)
printHtmlPart(8)
if(true && (creditInvestigationInstance?.loanApplication)) {
printHtmlPart(9)
expressionOut.print(creditInvestigationInstance?.loanApplication?.customer?.displayName)
printHtmlPart(10)
expressionOut.print(creditInvestigationInstance?.status.description)
printHtmlPart(11)
createTagBody(3, {->
expressionOut.print(creditInvestigationInstance?.loanApplication?.product?.name)
})
invokeTag('link','g',38,['controller':("product"),'action':("show"),'id':(creditInvestigationInstance?.loanApplication?.product?.id)],3)
printHtmlPart(12)
invokeTag('formatNumber','g',42,['format':("###,##0.00"),'number':(creditInvestigationInstance?.loanApplication?.amount)],-1)
printHtmlPart(13)
}
printHtmlPart(14)
invokeTag('formatDate','g',48,['format':("MM/dd/yyyy"),'date':(creditInvestigationInstance?.folderReceivedByBranchDept),'style':("FULL")],-1)
printHtmlPart(15)
invokeTag('formatDate','g',52,['format':("MM/dd/yyyy"),'date':(creditInvestigationInstance?.folderTransToCau),'style':("FULL")],-1)
printHtmlPart(16)
invokeTag('formatDate','g',56,['format':("MM/dd/yyyy"),'date':(creditInvestigationInstance?.assignedToCi),'style':("FULL")],-1)
printHtmlPart(17)
invokeTag('formatDate','g',60,['format':("MM/dd/yyyy"),'date':(creditInvestigationInstance?.deadlineAssignedToCreCom),'style':("FULL")],-1)
printHtmlPart(18)
invokeTag('formatDate','g',64,['format':("MM/dd/yyyy"),'date':(creditInvestigationInstance?.assignedToAnalyst),'style':("FULL")],-1)
printHtmlPart(17)
invokeTag('formatDate','g',68,['format':("MM/dd/yyyy"),'date':(creditInvestigationInstance?.deadlineSubAnalystreport),'style':("FULL")],-1)
printHtmlPart(19)
invokeTag('formatDate','g',72,['format':("MM/dd/yyyy"),'date':(creditInvestigationInstance?.submitAnalystRep),'style':("FULL")],-1)
printHtmlPart(20)
invokeTag('formatDate','g',76,['format':("MM/dd/yyyy"),'date':(creditInvestigationInstance?.reviewDateByManager),'style':("FULL")],-1)
printHtmlPart(21)
invokeTag('formatDate','g',80,['format':("MM/dd/yyyy"),'date':(creditInvestigationInstance?.schedForCac),'style':("FULL")],-1)
printHtmlPart(22)
invokeTag('formatDate','g',84,['format':("MM/dd/yyyy"),'date':(creditInvestigationInstance?.actualCac),'style':("FULL")],-1)
printHtmlPart(23)
invokeTag('formatDate','g',88,['format':("MM/dd/yyyy"),'date':(creditInvestigationInstance?.schedCrecom),'style':("FULL")],-1)
printHtmlPart(24)
invokeTag('formatDate','g',92,['format':("MM/dd/yyyy"),'date':(creditInvestigationInstance?.actualCrecom),'style':("FULL")],-1)
printHtmlPart(25)
invokeTag('formatDate','g',96,['format':("MM/dd/yyyy"),'date':(creditInvestigationInstance?.approvalDate),'style':("FULL")],-1)
printHtmlPart(26)
expressionOut.print(creditInvestigationInstance?.ci?.username)
printHtmlPart(27)
expressionOut.print(creditInvestigationInstance?.analyst?.username)
printHtmlPart(28)
}
else {
printHtmlPart(29)
invokeTag('formatDate','g',110,['format':("MM/dd/yyyy"),'date':(creditInvestigationInstance?.folderReceivedByBranchDept),'style':("FULL")],-1)
printHtmlPart(30)
invokeTag('formatDate','g',114,['format':("MM/dd/yyyy"),'date':(creditInvestigationInstance?.folderTransToCau),'style':("FULL")],-1)
printHtmlPart(31)
invokeTag('formatDate','g',118,['format':("MM/dd/yyyy"),'date':(creditInvestigationInstance?.assignedToCi),'style':("FULL")],-1)
printHtmlPart(32)
invokeTag('formatDate','g',122,['format':("MM/dd/yyyy"),'date':(creditInvestigationInstance?.schedForCi),'style':("FULL")],-1)
printHtmlPart(33)
invokeTag('formatDate','g',126,['format':("MM/dd/yyyy"),'date':(creditInvestigationInstance?.performedCi),'style':("FULL")],-1)
printHtmlPart(34)
invokeTag('formatDate','g',130,['format':("MM/dd/yyyy"),'date':(creditInvestigationInstance?.assignedToAnalyst),'style':("FULL")],-1)
printHtmlPart(35)
invokeTag('formatDate','g',134,['format':("MM/dd/yyyy"),'date':(creditInvestigationInstance?.schedForAnalyst),'style':("FULL")],-1)
printHtmlPart(36)
invokeTag('textArea','g',138,['class':("form-control"),'name':("xxReason"),'value':(creditInvestigationInstance?.recommendation),'rows':("5"),'cols':("80"),'disabled':("disable")],-1)
printHtmlPart(37)
invokeTag('formatDate','g',142,['format':("MM/dd/yyyy"),'date':(creditInvestigationInstance?.performedByAnalyst),'style':("FULL")],-1)
printHtmlPart(38)
invokeTag('formatDate','g',146,['format':("MM/dd/yyyy"),'date':(creditInvestigationInstance?.submitAnalystRep),'style':("FULL")],-1)
printHtmlPart(39)
}
printHtmlPart(40)
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
