import icbs.lov.ProductType
import icbs.loans.LoanApplication
import icbs.admin.Product
import icbs.loans.ROPA
import icbs.cif.Customer
import icbs.loans.Collateral
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_roparopaSale_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/ropa/ropaSale.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(0)
printHtmlPart(0)
printHtmlPart(0)
printHtmlPart(0)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',10,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(2)
createTagBody(2, {->
createClosureForHtmlPart(3, 3)
invokeTag('captureTitle','sitemesh',11,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',11,[:],2)
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(5)
expressionOut.print(createLink(controller:'ropa', action:'collectionInformation'))
printHtmlPart(6)
expressionOut.print(createLink(controller: 'ropa', action:'search'))
printHtmlPart(7)
expressionOut.print(loanApplication?.id)
printHtmlPart(8)
})
invokeTag('javascript','g',66,[:],2)
printHtmlPart(9)
})
invokeTag('captureHead','sitemesh',67,[:],1)
printHtmlPart(9)
createTagBody(1, {->
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(10)
expressionOut.print(createLink(uri: '/ropa'))
printHtmlPart(11)
})
invokeTag('captureContent','sitemesh',72,['tag':("breadcrumbs")],2)
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(12)
createTagBody(3, {->
printHtmlPart(13)
expressionOut.print(createLink(controller:'TxnTemplate', action:'validateExistingGlCodeAjax'))
printHtmlPart(14)
expressionOut.print(createLink(controller:'TxnTemplate', action:'validateExistingGlCodeAjax'))
printHtmlPart(15)
})
invokeTag('javascript','g',302,[:],3)
printHtmlPart(16)
if(true && (flash.message)) {
printHtmlPart(17)
expressionOut.print(flash.message)
printHtmlPart(18)
}
printHtmlPart(19)
expressionOut.print(ropaSaleInstance?.ropa?.loanAcctNo)
printHtmlPart(20)
expressionOut.print(ropaSaleInstance?.ropa?.customerDisplayName)
printHtmlPart(21)
invokeTag('formatNumber','g',326,['format':("###,###,##0.00"),'number':(ropaSaleInstance?.ropa?.loan?.grantedAmount)],-1)
printHtmlPart(22)
invokeTag('formatDate','g',330,['format':("MM/dd/yyyy"),'date':(ropaSaleInstance?.ropa?.loan?.openingDate)],-1)
printHtmlPart(23)
invokeTag('formatDate','g',334,['format':("MM/dd/yyyy"),'date':(ropaSaleInstance?.ropa?.dateCreated)],-1)
printHtmlPart(24)
createTagBody(3, {->
printHtmlPart(25)
expressionOut.print(hasErrors(bean: loanInstance, field: 'loanApplication', 'has-error'))
printHtmlPart(26)
invokeTag('message','g',349,['code':("loan.loanApplication.label"),'default':("Loan Application SCR")],-1)
printHtmlPart(27)
invokeTag('field','g',352,['name':("loanApplication"),'id':("loanApplication"),'type':("number"),'value':(loanInstance?.loanApplication?.id),'class':("form-control"),'readonly':("true")],-1)
printHtmlPart(28)
createTagBody(4, {->
printHtmlPart(29)
createTagBody(5, {->
printHtmlPart(30)
invokeTag('message','g',357,['error':(it)],-1)
printHtmlPart(31)
})
invokeTag('eachError','g',358,['bean':(loanInstance),'field':("loanApplication")],5)
printHtmlPart(32)
})
invokeTag('hasErrors','g',361,['bean':(loanInstance),'field':("loanApplication")],4)
printHtmlPart(33)
if(true && (!reschedule)) {
printHtmlPart(34)
}
printHtmlPart(35)
expressionOut.print(hasErrors(bean: ropaInstance, field: 'ciName', 'has-error'))
printHtmlPart(36)
invokeTag('message','g',370,['code':("creditInvestigation.ciName.label"),'default':("Customer Name")],-1)
printHtmlPart(37)
invokeTag('field','g',372,['name':("lnaccountName"),'id':("lnaccountName"),'value':(loanInstance?.loanApplication?.customer?.displayName),'disabled':("disable"),'class':("form-control")],-1)
printHtmlPart(38)
createTagBody(4, {->
printHtmlPart(39)
createTagBody(5, {->
printHtmlPart(40)
invokeTag('message','g',378,['error':(it)],-1)
printHtmlPart(41)
})
invokeTag('eachError','g',379,['bean':(ropaInstance),'field':("ciName")],5)
printHtmlPart(42)
})
invokeTag('hasErrors','g',382,['bean':(ropaInstance),'field':("ciName")],4)
printHtmlPart(43)
expressionOut.print(hasErrors(bean: ropaInstance, field: 'lnGrantedAmount', 'has-error'))
printHtmlPart(44)
invokeTag('message','g',387,['code':("creditInvestigation.lnGrantedAmount.label"),'default':("Granted Amount")],-1)
printHtmlPart(37)
invokeTag('field','g',389,['name':("lnGrantedAmount"),'id':("lnGrantedAmount"),'value':(loanInstance?.loanApplication?.amount),'disabled':("disable"),'class':("form-control truncated")],-1)
printHtmlPart(38)
createTagBody(4, {->
printHtmlPart(39)
createTagBody(5, {->
printHtmlPart(40)
invokeTag('message','g',395,['error':(it)],-1)
printHtmlPart(41)
})
invokeTag('eachError','g',396,['bean':(ropaInstance),'field':("lnGrantedAmount")],5)
printHtmlPart(42)
})
invokeTag('hasErrors','g',399,['bean':(ropaInstance),'field':("lnGrantedAmount")],4)
printHtmlPart(43)
expressionOut.print(hasErrors(bean: ropaInstance, field: 'lnApplicationDate', 'has-error'))
printHtmlPart(45)
invokeTag('message','g',404,['code':("creditInvestigation.lnApplicationDate.label"),'default':("Loan Application Date")],-1)
printHtmlPart(46)
invokeTag('customDatePicker','g',407,['name':("lnApplicationDate"),'id':("lnApplicationDate"),'precision':("day"),'class':("form-control"),'disabled':("disable"),'value':(loanInstance?.loanApplication?.applicationDate)],-1)
printHtmlPart(47)
createTagBody(4, {->
printHtmlPart(48)
createTagBody(5, {->
printHtmlPart(49)
invokeTag('message','g',412,['error':(it)],-1)
printHtmlPart(50)
})
invokeTag('eachError','g',413,['bean':(ropaInstance),'field':("lnApplicationDate")],5)
printHtmlPart(51)
})
invokeTag('hasErrors','g',416,['bean':(ropaInstance),'field':("lnApplicationDate")],4)
printHtmlPart(52)
expressionOut.print(hasErrors(bean: txnTemplateInstance, field: 'txnType', 'has-error'))
printHtmlPart(53)
invokeTag('select','g',423,['id':("txnType"),'name':("txnType"),'from':(icbs.admin.TxnTemplate.findAllByTxnTypeAndMemoTxnType(icbs.lov.TxnType.read(66),icbs.lov.MemoTxnType.read(1))),'optionKey':("id"),'optionValue':("description"),'required':(""),'value':(""),'onchange':("getcode();"),'class':("many-to-one form-control")],-1)
printHtmlPart(54)
invokeTag('field','g',429,['class':("form-control truncated"),'id':("sale"),'name':("sale"),'onblur':("scrxAmount();"),'value':("")],-1)
printHtmlPart(28)
invokeTag('hiddenField','g',430,['name':("hiddenSale"),'id':("hiddenSale"),'value':(ropaSaleInstance?.ropa?.loan?.grantedAmount)],-1)
printHtmlPart(55)
invokeTag('field','g',436,['class':("form-control truncated"),'onblur':("scrxAmount();"),'id':("income"),'name':("income"),'value':("")],-1)
printHtmlPart(28)
invokeTag('hiddenField','g',437,['name':("hiddenIncome"),'id':("hiddenIncome"),'value':("")],-1)
printHtmlPart(56)
expressionOut.print(hasErrors(bean: ropaInstance, field: 'glContraLitigationExp', 'has-error'))
printHtmlPart(57)
invokeTag('textField','g',442,['id':("ropaIncomeContra"),'name':("ropaIncomeContra"),'maxlength':("25"),'required':(""),'value':(ropaInstance?.ropaContra),'onblur':("validateGlCodeIncome();"),'class':("form-control")],-1)
printHtmlPart(28)
createTagBody(4, {->
printHtmlPart(58)
createTagBody(5, {->
printHtmlPart(59)
invokeTag('message','g',447,['error':(it)],-1)
printHtmlPart(60)
})
invokeTag('eachError','g',448,['bean':(ropaInstance),'field':("ropaIncomeContra")],5)
printHtmlPart(61)
})
invokeTag('hasErrors','g',451,['bean':(ropaInstance),'field':("ropaIncomeContra")],4)
printHtmlPart(62)
expressionOut.print(hasErrors(bean: txnTemplateInstance, field: 'depcontra', 'has-error'))
printHtmlPart(63)
invokeTag('message','g',458,['code':("ropa.gldescriptionIncome.label"),'default':("GL Account Name")],-1)
printHtmlPart(64)
invokeTag('textField','g',461,['readonly':("true"),'name':("gldescriptionIncome"),'id':("gldescriptionIncome"),'onblur':("validateGlCodeIncome();"),'maxlength':("100"),'class':("form-control")],-1)
printHtmlPart(65)
createTagBody(4, {->
printHtmlPart(48)
createTagBody(5, {->
printHtmlPart(49)
invokeTag('message','g',467,['error':(it)],-1)
printHtmlPart(50)
})
invokeTag('eachError','g',468,['bean':(txnTemplateInstance),'field':("gldescriptionIncome")],5)
printHtmlPart(51)
})
invokeTag('hasErrors','g',471,['bean':(ropaInstance),'field':("gldescriptionIncome")],4)
printHtmlPart(66)
invokeTag('field','g',477,['class':("form-control truncated"),'id':("scrAmount"),'name':("scrAmount"),'value':("")],-1)
printHtmlPart(28)
invokeTag('hiddenField','g',478,['name':("hiddenScrAmount"),'id':("hiddenScrAmount"),'value':("")],-1)
printHtmlPart(67)
invokeTag('field','g',484,['class':("form-control truncated"),'id':("downpayment"),'name':("downpayment"),'value':("")],-1)
printHtmlPart(56)
expressionOut.print(hasErrors(bean: ropaInstance, field: 'glContraLitigationExp', 'has-error'))
printHtmlPart(68)
invokeTag('textField','g',489,['id':("ropaContra"),'name':("ropaContra"),'maxlength':("25"),'required':(""),'value':(ropaInstance?.ropaContra),'onblur':("validateGlCode();"),'class':("form-control")],-1)
printHtmlPart(28)
createTagBody(4, {->
printHtmlPart(58)
createTagBody(5, {->
printHtmlPart(59)
invokeTag('message','g',494,['error':(it)],-1)
printHtmlPart(60)
})
invokeTag('eachError','g',495,['bean':(ropaInstance),'field':("ropaContra")],5)
printHtmlPart(61)
})
invokeTag('hasErrors','g',498,['bean':(ropaInstance),'field':("ropaContra")],4)
printHtmlPart(69)
invokeTag('hiddenField','g',501,['id':("financialYear"),'name':("financialYear"),'value':(g.formatDate(date: (runDate), format: 'yyyy'))],-1)
printHtmlPart(70)
expressionOut.print(hasErrors(bean: txnTemplateInstance, field: 'depcontra', 'has-error'))
printHtmlPart(63)
invokeTag('message','g',505,['code':("ropa.ropaContraDescription.label"),'default':("GL Account Name")],-1)
printHtmlPart(71)
invokeTag('textField','g',508,['readonly':("true"),'name':("gldescription"),'id':("gldescription"),'onblur':("validateGlCode();"),'maxlength':("100"),'class':("form-control")],-1)
printHtmlPart(65)
createTagBody(4, {->
printHtmlPart(48)
createTagBody(5, {->
printHtmlPart(49)
invokeTag('message','g',514,['error':(it)],-1)
printHtmlPart(50)
})
invokeTag('eachError','g',515,['bean':(txnTemplateInstance),'field':("gldescription")],5)
printHtmlPart(51)
})
invokeTag('hasErrors','g',518,['bean':(ropaInstance),'field':("gldescription")],4)
printHtmlPart(72)
invokeTag('hiddenField','g',522,['name':("loanAppId"),'id':("loanAppId"),'value':(params.id)],-1)
printHtmlPart(73)
invokeTag('hiddenField','g',523,['name':("findCollId"),'id':("findCollId"),'value':(ropaSaleInstance?.collateral?.id)],-1)
printHtmlPart(73)
invokeTag('hiddenField','g',524,['name':("getRopaId"),'id':("getRopaId"),'value':(params.idRopa)],-1)
printHtmlPart(73)
invokeTag('hiddenField','g',525,['name':("productType"),'id':("productType"),'value':("")],-1)
printHtmlPart(74)
invokeTag('field','g',530,['class':("form-control"),'type':("Text"),'id':("reference"),'name':("reference"),'value':("")],-1)
printHtmlPart(75)
invokeTag('field','g',536,['class':("form-control"),'type':("Text"),'id':("particulars"),'name':("particulars"),'value':("")],-1)
printHtmlPart(76)
})
invokeTag('form','g',540,['id':("ropaSale"),'url':([controller:'ropa', action:'saveropaSale']),'method':("POST")],3)
printHtmlPart(77)
})
invokeTag('captureContent','sitemesh',543,['tag':("main-content")],2)
printHtmlPart(78)
createTagBody(2, {->
printHtmlPart(79)
invokeTag('actionSubmit','g',555,['class':("save"),'id':("saveropaCredit"),'name':("saveropaCredit"),'onclick':("""
                        alertify.confirm(AppTitle,'Are you sure you want to continue this transaction?',
                                function(){
                                     checkIfAllowed('CFG00303', 'form#ropaSale', 'ROPA Sale .', null); 
                                },
                                function(){
                                    return;
                                });                      
                    """),'value':(message(code: 'default.button.Save.label', default: 'Save'))],-1)
printHtmlPart(80)
createClosureForHtmlPart(81, 3)
invokeTag('link','g',557,['action':("collateralShow"),'id':(ropaSaleInstance?.id)],3)
printHtmlPart(82)
})
invokeTag('captureContent','sitemesh',561,['tag':("main-actions")],2)
printHtmlPart(9)
})
invokeTag('captureBody','sitemesh',562,[:],1)
printHtmlPart(83)
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
