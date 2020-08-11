import icbs.loans.LoanLedger
import icbs.admin.Branch
import icbs.admin.UserMaster
import icbs.lov.WriteOffCollectionType
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_tellering_loanWriteOffCollection_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/tellering/loanWriteOffCollection/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(0)
printHtmlPart(0)
printHtmlPart(1)
expressionOut.print(hasErrors(bean: loanLedgerInstance, field: 'txnType', 'has-error'))
printHtmlPart(2)
invokeTag('message','g',11,['code':("loanLedger.txnType.label"),'default':("Transaction Type*")],-1)
printHtmlPart(3)
invokeTag('select','g',14,['id':("txnTemplate"),'name':("txnTemplate.id"),'from':(icbs.admin.TxnTemplate.findAll{txnType.id == 67}),'optionKey':("id"),'optionValue':("description"),'value':(""),'class':("many-to-one form-control"),'onchange':("updateForm()")],-1)
printHtmlPart(4)
expressionOut.print(hasErrors(bean: loanLedgerInstance, field: 'loan', 'has-error'))
printHtmlPart(5)
invokeTag('message','g',20,['code':("loanLedger.loan.label"),'default':("Account*")],-1)
printHtmlPart(6)
invokeTag('field','g',23,['name':("accountNo"),'value':(loanLedgerInstance?.loan?.accountNo),'class':("form-control"),'readonly':("true")],-1)
printHtmlPart(7)
createTagBody(1, {->
printHtmlPart(8)
expressionOut.print(it)
printHtmlPart(9)
})
invokeTag('hasErrors','g',34,['bean':(loanLedgerInstance),'field':("loan")],1)
printHtmlPart(10)
invokeTag('hiddenField','g',40,['id':("loan"),'name':("loan.id"),'value':(loanLedgerInstance?.loan?.id)],-1)
printHtmlPart(11)
expressionOut.print(hasErrors(bean: loanLedgerInstance, field: 'interestCredit', 'has-error'))
printHtmlPart(12)
invokeTag('message','g',102,['code':("loanLedger.interestCredit.label"),'default':("Collection Type*")],-1)
printHtmlPart(13)
invokeTag('select','g',105,['name':("collectionType"),'id':("collectionType"),'from':(WriteOffCollectionType.findAll{status == true}),'value':(""),'optionKey':("id"),'optionValue':("description"),'class':("form-control"),'noSelection':(['':'-Select Collection Type-'])],-1)
printHtmlPart(14)
expressionOut.print(hasErrors(bean: loanLedgerInstance, field: 'interestCredit', 'has-error'))
printHtmlPart(12)
invokeTag('message','g',110,['code':("loanLedger.interestCredit.label"),'default':("Collection Amount*")],-1)
printHtmlPart(13)
invokeTag('field','g',113,['name':("collectionAmt"),'id':("collectionAmt"),'value':(""),'class':("form-control truncated")],-1)
printHtmlPart(14)
expressionOut.print(hasErrors(bean: loanLedgerInstance, field: 'interestCredit', 'has-error'))
printHtmlPart(12)
invokeTag('message','g',118,['code':("loanLedger.interestCredit.label"),'default':("Collected By*")],-1)
printHtmlPart(13)
invokeTag('select','g',121,['name':("collectedBy"),'id':("collectedBy"),'from':(UserMaster.list()),'value':(""),'optionKey':("id"),'optionValue':("name"),'class':("form-control"),'noSelection':(['':'-Choose Collector-'])],-1)
printHtmlPart(14)
expressionOut.print(hasErrors(bean: loanLedgerInstance, field: 'interestCredit', 'has-error'))
printHtmlPart(12)
invokeTag('message','g',126,['code':("loanLedger.interestCredit.label"),'default':("Reference*")],-1)
printHtmlPart(13)
invokeTag('field','g',129,['name':("txnReference"),'id':("txnReference"),'value':(""),'class':("form-control")],-1)
printHtmlPart(14)
expressionOut.print(hasErrors(bean: loanLedgerInstance, field: 'interestCredit', 'has-error'))
printHtmlPart(12)
invokeTag('message','g',134,['code':("loanLedger.interestCredit.label"),'default':("Particulars*")],-1)
printHtmlPart(13)
invokeTag('textArea','g',137,['name':("txnParticulars"),'id':("txnParticulars"),'value':(""),'rows':("5"),'cols':("40"),'class':("form-control")],-1)
printHtmlPart(15)
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
