import icbs.admin.Product
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_productshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/product/show.gsp" }
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
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'product.label', default: 'Product'))],-1)
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
expressionOut.print(createLink(uri: '/product'))
printHtmlPart(7)
})
invokeTag('captureContent','sitemesh',14,['tag':("breadcrumbs")],2)
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(8)
if(true && (flash.message)) {
printHtmlPart(9)
expressionOut.print(flash.message)
printHtmlPart(10)
}
printHtmlPart(11)
if(true && (productInstance?.code)) {
printHtmlPart(12)
invokeTag('message','g',41,['code':("product.code.label"),'default':("Code")],-1)
printHtmlPart(13)
expressionOut.print(fieldValue(bean: productInstance, field: "code").padLeft(3, '0'))
printHtmlPart(14)
}
printHtmlPart(15)
if(true && (productInstance?.name)) {
printHtmlPart(12)
invokeTag('message','g',47,['code':("product.name.label"),'default':("Name")],-1)
printHtmlPart(16)
invokeTag('fieldValue','g',48,['bean':(productInstance),'field':("name")],-1)
printHtmlPart(17)
}
printHtmlPart(18)
if(true && (productInstance?.productType)) {
printHtmlPart(19)
invokeTag('message','g',53,['code':("product.productType.label"),'default':("Product Type")],-1)
printHtmlPart(20)
expressionOut.print(productInstance?.productType?.description)
printHtmlPart(21)
}
printHtmlPart(15)
if(true && (productInstance?.shortName)) {
printHtmlPart(19)
invokeTag('message','g',59,['code':("product.shortName.label"),'default':("Short Name")],-1)
printHtmlPart(22)
invokeTag('fieldValue','g',60,['bean':(productInstance),'field':("shortName")],-1)
printHtmlPart(21)
}
printHtmlPart(15)
if(true && (productInstance?.allowFdPartialWithrawal)) {
printHtmlPart(12)
invokeTag('message','g',65,['code':("product.allowFdPartialWithrawal.label"),'default':("Allow Fd Partial Withrawal")],-1)
printHtmlPart(23)
invokeTag('formatBoolean','g',66,['boolean':(productInstance?.allowFdPartialWithrawal)],-1)
printHtmlPart(17)
}
printHtmlPart(15)
if(true && (productInstance?.allowFdMultiplePlacement)) {
printHtmlPart(12)
invokeTag('message','g',71,['code':("product.allowFdMultiplePlacement.label"),'default':("Allow Fd Multiple Placement")],-1)
printHtmlPart(24)
invokeTag('formatBoolean','g',72,['boolean':(productInstance?.allowFdMultiplePlacement)],-1)
printHtmlPart(21)
}
printHtmlPart(15)
if(true && (productInstance?.depositDormancyMonths)) {
printHtmlPart(25)
invokeTag('message','g',77,['code':("product.depositDormancyMonths.label"),'default':("Deposit Dormancy Months")],-1)
printHtmlPart(26)
invokeTag('fieldValue','g',78,['bean':(productInstance),'field':("depositDormancyMonths")],-1)
printHtmlPart(17)
}
printHtmlPart(15)
if(true && (productInstance?.depositDormancyTransferFreq)) {
printHtmlPart(12)
invokeTag('message','g',83,['code':("product.depositDormancyTransferFreq.label"),'default':("Deposit Dormancy Transfer Freq")],-1)
printHtmlPart(27)
createTagBody(4, {->
expressionOut.print(productInstance?.depositDormancyTransferFreq?.description)
})
invokeTag('link','g',84,['controller':("depositAcctDormancyTransferFreq"),'action':("show"),'id':(productInstance?.depositDormancyTransferFreq?.id)],4)
printHtmlPart(17)
}
printHtmlPart(15)
if(true && (productInstance?.hasDepositDormancyInterest)) {
printHtmlPart(12)
invokeTag('message','g',89,['code':("product.hasDepositDormancyInterest.label"),'default':("Has Deposit Dormancy Interest")],-1)
printHtmlPart(28)
invokeTag('formatBoolean','g',90,['boolean':(productInstance?.hasDepositDormancyInterest)],-1)
printHtmlPart(21)
}
printHtmlPart(15)
if(true && (productInstance?.depositDormancyAmt)) {
printHtmlPart(12)
invokeTag('message','g',95,['code':("product.depositDormancyAmt.label"),'default':("Deposit Dormancy Amt")],-1)
printHtmlPart(29)
invokeTag('fieldValue','g',96,['bean':(productInstance),'field':("depositDormancyAmt")],-1)
printHtmlPart(21)
}
printHtmlPart(15)
if(true && (productInstance?.depositChargeStart)) {
printHtmlPart(12)
invokeTag('message','g',101,['code':("product.depositChargeStart.label"),'default':("Dormancy Charge Start")],-1)
printHtmlPart(30)
invokeTag('fieldValue','g',102,['bean':(productInstance),'field':("depositChargeStart")],-1)
printHtmlPart(17)
}
printHtmlPart(15)
if(true && (productInstance?.isMicrofinance)) {
printHtmlPart(12)
invokeTag('message','g',107,['code':("product.isMicrofinance.label"),'default':("Is Microfinance")],-1)
printHtmlPart(31)
invokeTag('formatBoolean','g',108,['boolean':(productInstance?.isMicrofinance)],-1)
printHtmlPart(17)
}
printHtmlPart(15)
if(true && (productInstance?.documentTemplate)) {
printHtmlPart(32)
invokeTag('message','g',113,['code':("product.documentTemplate.label"),'default':("Document Template")],-1)
printHtmlPart(33)
invokeTag('fieldValue','g',114,['bean':(productInstance),'field':("documentTemplate")],-1)
printHtmlPart(17)
}
printHtmlPart(15)
if(true && (productInstance?.amortizedChargeSchemes)) {
printHtmlPart(12)
invokeTag('message','g',119,['code':("product.amortizedChargeSchemes.label"),'default':("Amortized Charge Schemes")],-1)
printHtmlPart(34)
for( a in (productInstance.amortizedChargeSchemes) ) {
printHtmlPart(35)
createTagBody(5, {->
expressionOut.print(a?.name)
})
invokeTag('link','g',121,['controller':("amortizedChargeSchemeProduct"),'action':("show"),'id':(a.id)],5)
printHtmlPart(36)
}
printHtmlPart(37)
}
printHtmlPart(15)
if(true && (productInstance?.currency)) {
printHtmlPart(12)
invokeTag('message','g',127,['code':("product.currency.label"),'default':("Currency")],-1)
printHtmlPart(38)
createTagBody(4, {->
expressionOut.print(productInstance?.currency?.name)
})
invokeTag('link','g',128,['controller':("currency"),'action':("show"),'id':(productInstance?.currency?.id)],4)
printHtmlPart(17)
}
printHtmlPart(39)
if(true && (productInstance?.interestIncomeSchemes)) {
printHtmlPart(40)
invokeTag('message','g',134,['code':("product.interestIncomeSchemes.label"),'default':("Interest Income Schemes")],-1)
printHtmlPart(41)
invokeTag('sortableColumn','g',138,['property':("code"),'title':(message(code: 'interestIncomeSchemes.code.label', default: 'Code'))],-1)
printHtmlPart(42)
invokeTag('sortableColumn','g',139,['property':("description"),'title':(message(code: 'interestIncomeSchemes.description.label', default: 'Description'))],-1)
printHtmlPart(43)
loop:{
int i = 0
for( intr in (productInstance.interestIncomeSchemes) ) {
printHtmlPart(44)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(45)
createTagBody(5, {->
expressionOut.print(intr.code)
})
invokeTag('link','g',145,['controller':("interestIncomeScheme"),'action':("show"),'id':(intr.id)],5)
printHtmlPart(46)
expressionOut.print(intr.name)
printHtmlPart(47)
i++
}
}
printHtmlPart(48)
}
printHtmlPart(49)
if(true && (productInstance?.loanDeductionSchemes)) {
printHtmlPart(50)
invokeTag('message','g',153,['code':("product.loanDeductionSchemes.label"),'default':("Loan Deduction Schemes")],-1)
printHtmlPart(41)
invokeTag('sortableColumn','g',157,['property':("code"),'title':(message(code: 'loanDeductionSchemes.code.label', default: 'Code'))],-1)
printHtmlPart(42)
invokeTag('sortableColumn','g',158,['property':("description"),'title':(message(code: 'loanDeductionSchemes.description.label', default: 'Description'))],-1)
printHtmlPart(43)
loop:{
int i = 0
for( l in (productInstance.loanDeductionSchemes) ) {
printHtmlPart(44)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(45)
createTagBody(5, {->
expressionOut.print(l.code)
})
invokeTag('link','g',164,['controller':("loanDeductionScheme"),'action':("show"),'id':(l.id)],5)
printHtmlPart(46)
expressionOut.print(l.name)
printHtmlPart(47)
i++
}
}
printHtmlPart(51)
}
printHtmlPart(49)
if(true && (productInstance?.loanPerformanceClassificationSchemes)) {
printHtmlPart(40)
invokeTag('message','g',172,['code':("product.loanPerformanceClassifications.label"),'default':("Loan Performance Classifications")],-1)
printHtmlPart(52)
for( l in (productInstance.loanPerformanceClassificationSchemes) ) {
printHtmlPart(53)
createTagBody(5, {->
expressionOut.print(l?.name)
})
invokeTag('link','g',176,['controller':("loanPerformanceClassificationProduct"),'action':("show"),'id':(l.id)],5)
printHtmlPart(54)
}
printHtmlPart(55)
}
printHtmlPart(56)
if(true && (productInstance?.maxBalance)) {
printHtmlPart(57)
invokeTag('message','g',186,['code':("product.maxBalance.label"),'default':("Max Balance")],-1)
printHtmlPart(58)
invokeTag('formatNumber','g',187,['format':("###,###,##0.00"),'number':(productInstance?.maxBalance)],-1)
printHtmlPart(59)
}
printHtmlPart(60)
if(true && (productInstance?.maxOpen)) {
printHtmlPart(57)
invokeTag('message','g',193,['code':("product.maxOpen.label"),'default':("Max Open")],-1)
printHtmlPart(61)
invokeTag('fieldValue','g',194,['bean':(productInstance),'field':("maxOpen")],-1)
printHtmlPart(59)
}
printHtmlPart(60)
if(true && (productInstance?.maxTerm)) {
printHtmlPart(57)
invokeTag('message','g',200,['code':("product.maxTerm.label"),'default':("Max Term")],-1)
printHtmlPart(62)
invokeTag('formatNumber','g',201,['format':("#####"),'number':(productInstance?.maxTerm)],-1)
printHtmlPart(59)
}
printHtmlPart(60)
if(true && (productInstance?.minBalance)) {
printHtmlPart(57)
invokeTag('message','g',207,['code':("product.minBalance.label"),'default':("Min Balance")],-1)
printHtmlPart(63)
invokeTag('formatNumber','g',208,['format':("###,###,##0.00"),'number':(productInstance?.minBalance)],-1)
printHtmlPart(59)
}
printHtmlPart(60)
if(true && (productInstance?.minOpen)) {
printHtmlPart(57)
invokeTag('message','g',214,['code':("product.minOpen.label"),'default':("Min Open")],-1)
printHtmlPart(64)
invokeTag('formatNumber','g',215,['format':("###,###,##0.00"),'number':(productInstance?.minOpen)],-1)
printHtmlPart(59)
}
printHtmlPart(60)
if(true && (productInstance?.minTerm)) {
printHtmlPart(57)
invokeTag('message','g',221,['code':("product.minTerm.label"),'default':("Min Term")],-1)
printHtmlPart(65)
invokeTag('formatNumber','g',222,['format':("#####"),'number':(productInstance?.minTerm)],-1)
printHtmlPart(59)
}
printHtmlPart(66)
if(true && (productInstance?.penaltyIncomeSchemes)) {
printHtmlPart(50)
invokeTag('message','g',229,['code':("product.penaltyIncomeSchemes.label"),'default':("Penalty Income Schemes")],-1)
printHtmlPart(41)
invokeTag('sortableColumn','g',233,['property':("code"),'title':(message(code: 'penaltyIncomeSchemes.code.label', default: 'Code'))],-1)
printHtmlPart(42)
invokeTag('sortableColumn','g',234,['property':("description"),'title':(message(code: 'penaltyIncomeSchemes.description.label', default: 'Description'))],-1)
printHtmlPart(43)
loop:{
int i = 0
for( p in (productInstance.penaltyIncomeSchemes) ) {
printHtmlPart(44)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(45)
createTagBody(5, {->
expressionOut.print(p.code)
})
invokeTag('link','g',240,['controller':("penaltyIncomeScheme"),'action':("show"),'id':(p.id)],5)
printHtmlPart(46)
expressionOut.print(p.name)
printHtmlPart(47)
i++
}
}
printHtmlPart(51)
}
printHtmlPart(67)
if(true && (productInstance?.loanProvisionFreq)) {
printHtmlPart(68)
invokeTag('message','g',251,['code':("product.loanProvisionFreq.label"),'default':("Loan Provision Freq")],-1)
printHtmlPart(69)
expressionOut.print(productInstance?.loanProvisionFreq?.description)
printHtmlPart(70)
}
printHtmlPart(60)
if(true && (productInstance?.loanReclassFreq)) {
printHtmlPart(71)
invokeTag('message','g',258,['code':("product.loanReclassFreq.label"),'default':("Loan Reclass Freq")],-1)
printHtmlPart(72)
expressionOut.print(productInstance?.loanReclassFreq?.description)
printHtmlPart(70)
}
printHtmlPart(60)
if(true && (productInstance?.loanUidTransferFreq)) {
printHtmlPart(71)
invokeTag('message','g',265,['code':("product.loanUidTransferFreq.label"),'default':("Loan Uid Transfer Freq")],-1)
printHtmlPart(73)
expressionOut.print(productInstance?.loanUidTransferFreq?.description)
printHtmlPart(70)
}
printHtmlPart(74)
if(true && (productInstance?.configItemStatus)) {
printHtmlPart(71)
invokeTag('message','g',272,['code':("product.configItemStatus.label"),'default':("Config Item Status")],-1)
printHtmlPart(75)
expressionOut.print(productInstance?.configItemStatus?.description)
printHtmlPart(70)
}
printHtmlPart(76)
invokeTag('sortableColumn','g',283,['property':("code"),'title':(message(code: 'branch.code.label', default: 'Code'))],-1)
printHtmlPart(77)
invokeTag('sortableColumn','g',284,['property':("description"),'title':(message(code: 'branch.name.label', default: 'Branch Name'))],-1)
printHtmlPart(78)
loop:{
int i = 0
for( productBranch in (productBranches) ) {
printHtmlPart(79)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(80)
createTagBody(4, {->
expressionOut.print(productBranch.branch.code)
})
invokeTag('link','g',290,['controller':("Branch"),'action':("show"),'id':(productBranch.branch.id)],4)
printHtmlPart(81)
expressionOut.print(productBranch.branch.name)
printHtmlPart(82)
i++
}
}
printHtmlPart(83)
for( customerGroup in (productInstance.customerGroups) ) {
printHtmlPart(84)
expressionOut.print(customerGroup.name)
printHtmlPart(82)
}
printHtmlPart(85)
invokeTag('sortableColumn','g',312,['property':("code"),'title':(message(code: 'txnTemplates.code.label', default: 'Code'))],-1)
printHtmlPart(77)
invokeTag('sortableColumn','g',313,['property':("description"),'title':(message(code: 'txnTemplates.description.label', default: 'Description'))],-1)
printHtmlPart(86)
loop:{
int i = 0
for( txnTemplate in (productInstance.txnTemplates) ) {
printHtmlPart(79)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(80)
createTagBody(4, {->
expressionOut.print(txnTemplate.code)
})
invokeTag('link','g',320,['controller':("TxnTemplate"),'action':("show"),'id':(txnTemplate.id)],4)
printHtmlPart(81)
expressionOut.print(txnTemplate.description)
printHtmlPart(82)
i++
}
}
printHtmlPart(87)
createClosureForHtmlPart(88, 3)
invokeTag('form','g',329,['id':("delete"),'url':([resource:productInstance, action:'delete']),'method':("DELETE")],3)
printHtmlPart(89)
})
invokeTag('captureContent','sitemesh',331,['tag':("main-content")],2)
printHtmlPart(90)
createTagBody(2, {->
printHtmlPart(91)
createTagBody(3, {->
invokeTag('message','g',334,['code':("default.new.label"),'args':([entityName])],-1)
})
invokeTag('link','g',334,['class':("create"),'action':("create")],3)
printHtmlPart(92)
if(true && (productInstance.configItemStatus.id.toInteger() in [1, 2])) {
printHtmlPart(93)
createTagBody(4, {->
invokeTag('message','g',336,['code':("default.button.edit.label"),'default':("Edit")],-1)
})
invokeTag('link','g',336,['class':("edit"),'action':("edit"),'resource':(productInstance)],4)
printHtmlPart(94)
invokeTag('actionSubmit','g',345,['id':("deleteProduct"),'class':("delete"),'action':("delete"),'value':(message(code: 'default.button.delete.label', default: 'Delete')),'onclick':("""
                            alertify.confirm(AppTitle,'Are you sure you want to delete?',
                                function(){
                                    checkIfAllowed('CFG00703', 'form#delete', 'Override delete Product.', null);
                                },
                                function(){
                                    return;
                                });                                 
                            """)],-1)
printHtmlPart(92)
}
printHtmlPart(95)
createClosureForHtmlPart(96, 3)
invokeTag('link','g',356,['action':("index")],3)
printHtmlPart(97)
})
invokeTag('captureContent','sitemesh',358,['tag':("main-actions")],2)
printHtmlPart(4)
})
invokeTag('captureBody','sitemesh',359,[:],1)
printHtmlPart(98)
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
