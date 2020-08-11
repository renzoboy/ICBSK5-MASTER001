import icbs.lov.ConfigItemStatus
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_ropa_ropaSaleCashForm_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/ropa/_ropaSaleCashForm.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
invokeTag('hiddenField','g',2,['name':("id"),'id':("id"),'value':(params?.id)],-1)
printHtmlPart(1)
expressionOut.print(hasErrors(bean: loanInstance, field: 'loanApplication', 'has-error'))
printHtmlPart(2)
invokeTag('message','g',5,['code':("loan.loanApplication.label"),'default':("SCR Application ")],-1)
printHtmlPart(3)
invokeTag('field','g',8,['name':("loanApplication"),'id':("loanApplication"),'type':("number"),'value':(loanInstance?.loanApplication?.id),'class':("form-control"),'readonly':("true")],-1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(6)
invokeTag('message','g',13,['error':(it)],-1)
printHtmlPart(7)
})
invokeTag('eachError','g',14,['bean':(loanInstance),'field':("loanApplication")],2)
printHtmlPart(8)
})
invokeTag('hasErrors','g',17,['bean':(loanInstance),'field':("loanApplication")],1)
printHtmlPart(9)
if(true && (!reschedule)) {
printHtmlPart(10)
}
printHtmlPart(11)
expressionOut.print(hasErrors(bean: ropaInstance, field: 'ciName', 'has-error'))
printHtmlPart(12)
invokeTag('message','g',26,['code':("creditInvestigation.ciName.label"),'default':("Customer Name")],-1)
printHtmlPart(13)
invokeTag('field','g',28,['name':("lnaccountName"),'id':("lnaccountName"),'value':(loanInstance?.loanApplication?.customer?.displayName),'disabled':("disable"),'class':("form-control")],-1)
printHtmlPart(14)
createTagBody(1, {->
printHtmlPart(15)
createTagBody(2, {->
printHtmlPart(16)
invokeTag('message','g',34,['error':(it)],-1)
printHtmlPart(17)
})
invokeTag('eachError','g',35,['bean':(ropaInstance),'field':("ciName")],2)
printHtmlPart(18)
})
invokeTag('hasErrors','g',38,['bean':(ropaInstance),'field':("ciName")],1)
printHtmlPart(19)
expressionOut.print(hasErrors(bean: txnTemplateInstance, field: 'txnType', 'has-error'))
printHtmlPart(20)
invokeTag('select','g',44,['id':("txnType"),'name':("txnType"),'from':(icbs.admin.TxnTemplate.get(icbs.admin.Institution.findByParamCode("GLS.60620").paramValue.toInteger())),'optionKey':("id"),'optionValue':("description"),'required':(""),'value':(""),'onchange':("getcode();"),'class':("many-to-one form-control")],-1)
printHtmlPart(21)
expressionOut.print(hasErrors(bean: transferToRopaInstance, field: 'sellingPrice', 'has-error'))
printHtmlPart(22)
invokeTag('message','g',49,['code':("ropaSale.sellingPrice.label"),'default':("Selling Price")],-1)
printHtmlPart(23)
invokeTag('field','g',51,['name':("sellingPrice"),'id':("sellingPrice"),'value':(""),'class':("form-control truncated")],-1)
printHtmlPart(24)
createTagBody(1, {->
printHtmlPart(25)
createTagBody(2, {->
printHtmlPart(26)
invokeTag('message','g',57,['error':(it)],-1)
printHtmlPart(27)
})
invokeTag('eachError','g',58,['bean':(collateralInstance),'field':("sellingPrice")],2)
printHtmlPart(28)
})
invokeTag('hasErrors','g',61,['bean':(collateralInstance),'field':("sellingPrice")],1)
printHtmlPart(29)
expressionOut.print(hasErrors(bean: transferToRopaInstance, field: 'commission', 'has-error'))
printHtmlPart(30)
invokeTag('message','g',67,['code':("ropaSale.commission.label"),'default':("Commission")],-1)
printHtmlPart(31)
invokeTag('field','g',69,['name':("commission"),'id':("commission"),'value':(""),'class':("form-control truncated")],-1)
printHtmlPart(24)
createTagBody(1, {->
printHtmlPart(25)
createTagBody(2, {->
printHtmlPart(26)
invokeTag('message','g',75,['error':(it)],-1)
printHtmlPart(27)
})
invokeTag('eachError','g',76,['bean':(collateralInstance),'field':("grt")],2)
printHtmlPart(28)
})
invokeTag('hasErrors','g',79,['bean':(collateralInstance),'field':("commission")],1)
printHtmlPart(32)
expressionOut.print(hasErrors(bean: transferToRopaInstance, field: 'reference', 'has-error'))
printHtmlPart(33)
invokeTag('message','g',85,['code':("ropaSale.commission.label"),'default':("Agent")],-1)
printHtmlPart(31)
invokeTag('select','g',90,['id':("agent"),'name':("agent.id"),'from':(icbs.admin.UserMaster.findAllByConfigItemStatus(ConfigItemStatus.get(2))),'optionKey':("id"),'optionValue':("name"),'required':(""),'value':(""),'class':("many-to-one form-control")],-1)
printHtmlPart(24)
createTagBody(1, {->
printHtmlPart(25)
createTagBody(2, {->
printHtmlPart(26)
invokeTag('message','g',96,['error':(it)],-1)
printHtmlPart(27)
})
invokeTag('eachError','g',98,['bean':(collateralInstance),'field':("Agent")],2)
printHtmlPart(28)
})
invokeTag('hasErrors','g',100,['bean':(collateralInstance),'field':("Agent")],1)
printHtmlPart(34)
expressionOut.print(hasErrors(bean: transferToRopaInstance, field: 'reference', 'has-error'))
printHtmlPart(33)
invokeTag('message','g',104,['code':("ropaSale.commission.label"),'default':("Reference")],-1)
printHtmlPart(31)
invokeTag('field','g',107,['name':("reference"),'id':("reference"),'value':(""),'class':("form-control")],-1)
printHtmlPart(24)
createTagBody(1, {->
printHtmlPart(25)
createTagBody(2, {->
printHtmlPart(26)
invokeTag('message','g',112,['error':(it)],-1)
printHtmlPart(27)
})
invokeTag('eachError','g',114,['bean':(collateralInstance),'field':("grt")],2)
printHtmlPart(28)
})
invokeTag('hasErrors','g',118,['bean':(collateralInstance),'field':("reference")],1)
printHtmlPart(34)
expressionOut.print(hasErrors(bean: transferToRopaInstance, field: 'particulars', 'has-error'))
printHtmlPart(35)
invokeTag('message','g',122,['code':("ropaSale.commission.label"),'default':("Particulars")],-1)
printHtmlPart(31)
invokeTag('textArea','g',122,['name':("particulars"),'value':(""),'rows':("5"),'cols':("40"),'class':("form-control")],-1)
printHtmlPart(24)
createTagBody(1, {->
printHtmlPart(25)
createTagBody(2, {->
printHtmlPart(26)
invokeTag('message','g',128,['error':(it)],-1)
printHtmlPart(27)
})
invokeTag('eachError','g',128,['bean':(collateralInstance),'field':("grt")],2)
printHtmlPart(28)
})
invokeTag('hasErrors','g',130,['bean':(collateralInstance),'field':("particulars")],1)
printHtmlPart(36)
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
