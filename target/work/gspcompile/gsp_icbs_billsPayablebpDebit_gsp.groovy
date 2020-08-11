import icbs.gl.BillsPayable
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_billsPayablebpDebit_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/billsPayable/bpDebit.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
createTagBody(2, {->
createClosureForHtmlPart(2, 3)
invokeTag('captureTitle','sitemesh',6,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',6,[:],2)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',7,[:],1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(5)
expressionOut.print(createLink(uri: '/billsPayable'))
printHtmlPart(6)
})
invokeTag('captureContent','sitemesh',12,['tag':("breadcrumbs")],2)
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(7)
expressionOut.print(billsPayableInstance?.accountName)
printHtmlPart(8)
expressionOut.print(billsPayableInstance?.glContra)
printHtmlPart(9)
expressionOut.print(billsPayableInstance?.branch?.name)
printHtmlPart(10)
expressionOut.print(billsPayableInstance?.creditorName)
printHtmlPart(11)
invokeTag('formatDate','g',29,['format':("MM/dd/yyyy"),'date':(billsPayableInstance?.dateOpened)],-1)
printHtmlPart(12)
invokeTag('formatNumber','g',33,['format':("###,###,##0.00"),'number':(billsPayableInstance?.principal)],-1)
printHtmlPart(13)
createTagBody(3, {->
printHtmlPart(14)
expressionOut.print(hasErrors(bean: txnTemplateInstance, field: 'txnType', 'has-error'))
printHtmlPart(15)
invokeTag('select','g',48,['id':("txnType"),'name':("txnType"),'from':(icbs.admin.TxnTemplate.findAllByTxnTypeAndMemoTxnType(icbs.lov.TxnType.read(51),icbs.lov.MemoTxnType.read(1))),'optionKey':("id"),'optionValue':("description"),'required':(""),'value':(""),'onchange':("getcode();"),'class':("many-to-one form-control")],-1)
printHtmlPart(16)
invokeTag('hiddenField','g',52,['name':("bpDebitId"),'id':("bpDebitId"),'value':(params.id)],-1)
printHtmlPart(17)
invokeTag('field','g',56,['class':("form-control truncated"),'id':("debitAmt"),'name':("debitAmt"),'value':("")],-1)
printHtmlPart(18)
invokeTag('field','g',62,['class':("form-control"),'type':("Text"),'id':("reference"),'name':("reference"),'value':("")],-1)
printHtmlPart(19)
invokeTag('field','g',68,['class':("form-control"),'type':("Text"),'id':("particulars"),'name':("particulars"),'value':("")],-1)
printHtmlPart(20)
})
invokeTag('form','g',72,['id':("deposit"),'url':([resource:billsPayableInstance, action:'savebpDebit']),'method':("PUT")],3)
printHtmlPart(21)
})
invokeTag('captureContent','sitemesh',75,['tag':("main-content")],2)
printHtmlPart(22)
createTagBody(2, {->
printHtmlPart(23)
invokeTag('actionSubmit','g',87,['class':("save"),'id':("savebpDebit"),'name':("savebpDebit"),'action':("savebpDebit"),'value':(message(code: 'default.button.Save.label', default: 'Save')),'onclick':("""
                        alertify.confirm(AppTitle,'Are you sure you want to continue this transaction?',
                                function(){
                                     checkIfAllowed('CFG00303', 'form#deposit', 'Override edit cash in bank.', null); 
                                },
                                function(){
                                    return;
                                });                      
                    """)],-1)
printHtmlPart(24)
createClosureForHtmlPart(25, 3)
invokeTag('link','g',88,['action':("show"),'id':(billsPayableInstance.id)],3)
printHtmlPart(26)
})
invokeTag('captureContent','sitemesh',90,['tag':("main-actions")],2)
printHtmlPart(3)
})
invokeTag('captureBody','sitemesh',91,[:],1)
printHtmlPart(27)
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
