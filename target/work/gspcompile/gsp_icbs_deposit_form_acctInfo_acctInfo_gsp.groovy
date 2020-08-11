import icbs.lov.ConfigItemStatus
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_deposit_form_acctInfo_acctInfo_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/deposit/form/acctInfo/_acctInfo.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
printHtmlPart(2)
if(true && (depositInstance?.type?.id==null || depositInstance?.type?.id==1)) {
printHtmlPart(3)
invokeTag('render','g',13,['template':("form/acctInfo/templates/deposit")],-1)
printHtmlPart(4)
}
printHtmlPart(4)
if(true && (depositInstance?.type?.id==2)) {
printHtmlPart(3)
invokeTag('render','g',16,['template':("form/acctInfo/templates/current")],-1)
printHtmlPart(4)
}
printHtmlPart(4)
if(true && (depositInstance?.type?.id==3)) {
printHtmlPart(3)
invokeTag('render','g',19,['template':("form/acctInfo/templates/fixedDeposit")],-1)
printHtmlPart(4)
}
printHtmlPart(4)
if(true && (depositInstance?.type?.id==4)) {
printHtmlPart(3)
invokeTag('render','g',22,['template':("form/acctInfo/templates/deposit")],-1)
printHtmlPart(4)
}
printHtmlPart(4)
if(true && (depositInstance?.type?.id==5)) {
printHtmlPart(3)
invokeTag('render','g',25,['template':("form/acctInfo/templates/deposit")],-1)
printHtmlPart(4)
}
printHtmlPart(5)
expressionOut.print(hasErrors(bean: depositInstance, field: 'userDepositAcctOfficer', 'has-error'))
printHtmlPart(6)
invokeTag('message','g',29,['code':("deposit.userDepositAcctOfficer.label"),'default':("Deposit Account Officer")],-1)
printHtmlPart(7)
invokeTag('select','g',33,['id':("userDepositAcctOfficer"),'name':("userDepositAcctOfficer.id"),'from':(icbs.admin.UserMaster.findAllByConfigItemStatus(ConfigItemStatus.get(2))),'optionKey':("id"),'optionValue':("name"),'required':(""),'value':(depositInstance?.userDepositAcctOfficer?.id),'class':("many-to-one form-control")],-1)
printHtmlPart(8)
createTagBody(1, {->
printHtmlPart(9)
createTagBody(2, {->
printHtmlPart(10)
invokeTag('message','g',38,['error':(it)],-1)
printHtmlPart(11)
})
invokeTag('eachError','g',38,['bean':(depositInstance),'field':("userDepositAcctOfficer")],2)
printHtmlPart(12)
})
invokeTag('hasErrors','g',39,['bean':(depositInstance),'field':("userDepositAcctOfficer")],1)
printHtmlPart(13)
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
