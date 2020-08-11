import icbs.deposit.Deposit
import icbs.admin.Branch
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_deposit_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/deposit/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
invokeTag('hiddenField','g',4,['id':("RollTerm"),'name':("RollTerm")],-1)
printHtmlPart(0)
invokeTag('hiddenField','g',5,['id':("DepSchemValMin"),'name':("DepSchemValMin"),'value':(depositInstance?.fixedDepositTermScheme?.termMin)],-1)
printHtmlPart(0)
invokeTag('hiddenField','g',7,['id':("DepSchemValMax"),'name':("DepSchemValMax"),'value':(depositInstance?.fixedDepositTermScheme?.termMax)],-1)
printHtmlPart(0)
invokeTag('hiddenField','g',7,['id':("DepTypeId"),'name':("DepTypeId"),'value':(depositInstance?.type?.id)],-1)
printHtmlPart(2)
if(true && (depositInstance?.acctNo)) {
printHtmlPart(3)
expressionOut.print(depositInstance?.acctNo)
printHtmlPart(4)
expressionOut.print(depositInstance?.acctName)
printHtmlPart(5)
}
printHtmlPart(6)
if(true && (depositInstance?.type?.id==3 && !depositInstance?.id)) {
printHtmlPart(7)
}
printHtmlPart(8)
if(true && (depositInstance?.type?.id==3 && depositInstance?.id)) {
printHtmlPart(9)
}
printHtmlPart(10)
if(true && (depositInstance?.id)) {
printHtmlPart(11)
}
printHtmlPart(12)
invokeTag('render','g',34,['template':("form/basicInfo/basicInfo")],-1)
printHtmlPart(13)
invokeTag('render','g',36,['template':("form/acctInfo/acctInfo")],-1)
printHtmlPart(14)
invokeTag('render','g',38,['template':("form/signatory/signatoryInfo")],-1)
printHtmlPart(15)
if(true && (depositInstance?.type?.id==3 && !depositInstance?.id)) {
printHtmlPart(16)
invokeTag('render','g',44,['template':("form/rollover/form")],-1)
printHtmlPart(17)
}
printHtmlPart(18)
if(true && (depositInstance?.type?.id==3 && depositInstance?.id)) {
printHtmlPart(19)
}
printHtmlPart(18)
if(true && (depositInstance?.id)) {
printHtmlPart(20)
invokeTag('render','g',53,['template':("form/status/form")],-1)
printHtmlPart(17)
}
printHtmlPart(21)
createTagBody(1, {->
printHtmlPart(22)
expressionOut.print(createLink(controller : 'deposit', action:'changeAcctInformationFormAjax'))
printHtmlPart(23)
expressionOut.print(createLink(controller : 'deposit', action:'showCustomerDetailsAjax'))
printHtmlPart(24)
})
invokeTag('javascript','g',98,[:],1)
printHtmlPart(0)
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
