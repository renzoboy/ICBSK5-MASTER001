import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_loan_loanGuarantee_form_smallBusinessGuaranAndFee_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/loan/loanGuarantee/form/_smallBusinessGuaranAndFee.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
expressionOut.print(hasErrors(bean: loanGuaranteeInstance, field: 'sbgfcMainOfficeAddress', 'has-error'))
printHtmlPart(2)
invokeTag('message','g',14,['code':("loan.sbgfcMainOfficeAddress.label"),'default':("Main Office Address")],-1)
printHtmlPart(3)
invokeTag('field','g',18,['id':("sbgfcMainOfficeAddress"),'name':("sbgfcMainOfficeAddress"),'value':(loanGuaranteeInstance?.sbgfcMainOfficeAddress),'class':("form-control")],-1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(6)
invokeTag('message','g',23,['error':(it)],-1)
printHtmlPart(7)
})
invokeTag('eachError','g',24,['bean':(loanGuaranteeInstance),'field':("sbgfcMainOfficeAddress")],2)
printHtmlPart(8)
})
invokeTag('hasErrors','g',27,['bean':(loanGuaranteeInstance),'field':("sbgfcMainOfficeAddress")],1)
printHtmlPart(9)
expressionOut.print(hasErrors(bean: loanGuaranteeInstance, field: 'sbgfcPosition', 'has-error'))
printHtmlPart(10)
invokeTag('message','g',33,['code':("loan.sbgfcPosition.label"),'default':("Position ")],-1)
printHtmlPart(3)
invokeTag('field','g',37,['type':("text"),'id':("sbgfcPosition"),'name':("sbgfcPosition"),'value':(loanGuaranteeInstance?.sbgfcPosition),'class':("form-control")],-1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(6)
invokeTag('message','g',42,['error':(it)],-1)
printHtmlPart(7)
})
invokeTag('eachError','g',43,['bean':(loanGuaranteeInstance),'field':("sbgfcPosition")],2)
printHtmlPart(8)
})
invokeTag('hasErrors','g',46,['bean':(loanGuaranteeInstance),'field':("sbgfcPosition")],1)
printHtmlPart(9)
expressionOut.print(hasErrors(bean: loanGuaranteeInstance, field: 'sbgfcNetWorth', 'has-error'))
printHtmlPart(11)
invokeTag('message','g',52,['code':("loan.sbgfcNetWorth.label"),'default':("Net Worth")],-1)
printHtmlPart(12)
invokeTag('field','g',56,['type':("text"),'id':("sbgfcNetWorth"),'name':("sbgfcNetWorth"),'value':(loanGuaranteeInstance?.sbgfcNetWorth),'class':("form-control truncated")],-1)
printHtmlPart(13)
createTagBody(1, {->
printHtmlPart(14)
createTagBody(2, {->
printHtmlPart(15)
invokeTag('message','g',61,['error':(it)],-1)
printHtmlPart(16)
})
invokeTag('eachError','g',62,['bean':(loanGuaranteeInstance),'field':("sbgfcNetWorth")],2)
printHtmlPart(17)
})
invokeTag('hasErrors','g',65,['bean':(loanGuaranteeInstance),'field':("sbgfcNetWorth")],1)
printHtmlPart(18)
expressionOut.print(hasErrors(bean: loanGuaranteeInstance, field: 'sbgfcNatureOfBusiness', 'has-error'))
printHtmlPart(19)
invokeTag('message','g',71,['code':("loan.sbgfcNatureOfBusiness.label"),'default':("Nature of Business")],-1)
printHtmlPart(3)
invokeTag('field','g',75,['type':("text"),'id':("sbgfcNatureOfBusiness"),'name':("sbgfcNatureOfBusiness"),'value':(loanGuaranteeInstance?.sbgfcNatureOfBusiness),'class':("form-control")],-1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(6)
invokeTag('message','g',80,['error':(it)],-1)
printHtmlPart(7)
})
invokeTag('eachError','g',81,['bean':(loanGuaranteeInstance),'field':("sbgfcNatureOfBusiness")],2)
printHtmlPart(8)
})
invokeTag('hasErrors','g',84,['bean':(loanGuaranteeInstance),'field':("sbgfcNatureOfBusiness")],1)
printHtmlPart(9)
expressionOut.print(hasErrors(bean: loanGuaranteeInstance, field: 'sbgfcBusinessType', 'has-error'))
printHtmlPart(20)
invokeTag('message','g',90,['code':("loan.sbgfcBusinessType.label"),'default':("Business Type")],-1)
printHtmlPart(3)
invokeTag('field','g',94,['type':("text"),'id':("sbgfcBusinessType"),'name':("sbgfcBusinessType"),'value':(loanGuaranteeInstance?.sbgfcBusinessType),'class':("form-control")],-1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(6)
invokeTag('message','g',99,['error':(it)],-1)
printHtmlPart(7)
})
invokeTag('eachError','g',100,['bean':(loanGuaranteeInstance),'field':("sbgfcBusinessType")],2)
printHtmlPart(8)
})
invokeTag('hasErrors','g',103,['bean':(loanGuaranteeInstance),'field':("sbgfcBusinessType")],1)
printHtmlPart(9)
expressionOut.print(hasErrors(bean: loanGuaranteeInstance, field: 'sbgfcStartOfBusinessOperation', 'has-error'))
printHtmlPart(21)
invokeTag('message','g',109,['code':("loan.sbgfcStartOfBusinessOperation.label"),'default':("Start of Business Operation")],-1)
printHtmlPart(3)
invokeTag('field','g',113,['type':("text"),'id':("sbgfcStartOfBusinessOperation"),'name':("sbgfcStartOfBusinessOperation"),'value':(loanGuaranteeInstance?.sbgfcStartOfBusinessOperation),'class':("form-control")],-1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(6)
invokeTag('message','g',118,['error':(it)],-1)
printHtmlPart(7)
})
invokeTag('eachError','g',119,['bean':(loanGuaranteeInstance),'field':("sbgfcStartOfBusinessOperation")],2)
printHtmlPart(8)
})
invokeTag('hasErrors','g',122,['bean':(loanGuaranteeInstance),'field':("sbgfcStartOfBusinessOperation")],1)
printHtmlPart(9)
expressionOut.print(hasErrors(bean: loanGuaranteeInstance, field: 'sbgfcAssetSize', 'has-error'))
printHtmlPart(22)
invokeTag('message','g',128,['code':("loan.sbgfcAssetSize.label"),'default':("Asset Size")],-1)
printHtmlPart(3)
invokeTag('field','g',132,['id':("sbgfcAssetSize"),'name':("sbgfcAssetSize"),'value':(loanGuaranteeInstance?.sbgfcAssetSize),'class':("form-control truncated")],-1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(6)
invokeTag('message','g',137,['error':(it)],-1)
printHtmlPart(7)
})
invokeTag('eachError','g',138,['bean':(loanGuaranteeInstance),'field':("sbgfcAssetSize")],2)
printHtmlPart(8)
})
invokeTag('hasErrors','g',141,['bean':(loanGuaranteeInstance),'field':("sbgfcAssetSize")],1)
printHtmlPart(9)
expressionOut.print(hasErrors(bean: loanGuaranteeInstance, field: 'sbgfcNumberOfEmployees', 'has-error'))
printHtmlPart(23)
invokeTag('message','g',147,['code':("loan.sbgfcNumberOfEmployees.label"),'default':("Number of Employee")],-1)
printHtmlPart(3)
invokeTag('field','g',151,['type':("text"),'id':("sbgfcNumberOfEmployees"),'name':("sbgfcNumberOfEmployees"),'value':(loanGuaranteeInstance?.sbgfcNumberOfEmployees),'class':("form-control")],-1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(6)
invokeTag('message','g',156,['error':(it)],-1)
printHtmlPart(7)
})
invokeTag('eachError','g',157,['bean':(loanGuaranteeInstance),'field':("sbgfcNumberOfEmployees")],2)
printHtmlPart(8)
})
invokeTag('hasErrors','g',160,['bean':(loanGuaranteeInstance),'field':("sbgfcNumberOfEmployees")],1)
printHtmlPart(9)
expressionOut.print(hasErrors(bean: loanGuaranteeInstance, field: 'sbgfcApprovalExiryDate', 'has-error'))
printHtmlPart(24)
invokeTag('message','g',166,['code':("loan.sbgfcApprovalExiryDate.label"),'default':("Approve Expiry Date")],-1)
printHtmlPart(25)
invokeTag('customDatePicker','g',171,['id':("sbgfcApprovalExiryDate"),'name':("sbgfcApprovalExiryDate"),'value':(loanGuaranteeInstance?.sbgfcApprovalExiryDate),'class':("form-control")],-1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(6)
invokeTag('message','g',176,['error':(it)],-1)
printHtmlPart(7)
})
invokeTag('eachError','g',177,['bean':(loanGuaranteeInstance),'field':("agfpRemarks")],2)
printHtmlPart(8)
})
invokeTag('hasErrors','g',180,['bean':(loanGuaranteeInstance),'field':("sbgfcApprovalExiryDate")],1)
printHtmlPart(9)
expressionOut.print(hasErrors(bean: loanGuaranteeInstance, field: 'sbgfcTypeOfLoan', 'has-error'))
printHtmlPart(26)
invokeTag('message','g',186,['code':("loan.sbgfcTypeOfLoan.label"),'default':("Type of Loan")],-1)
printHtmlPart(3)
invokeTag('field','g',190,['type':("text"),'id':("sbgfcTypeOfLoan"),'name':("sbgfcTypeOfLoan"),'value':(loanGuaranteeInstance?.sbgfcTypeOfLoan),'class':("form-control")],-1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(6)
invokeTag('message','g',195,['error':(it)],-1)
printHtmlPart(7)
})
invokeTag('eachError','g',196,['bean':(loanGuaranteeInstance),'field':("sbgfcTypeOfLoan")],2)
printHtmlPart(8)
})
invokeTag('hasErrors','g',199,['bean':(loanGuaranteeInstance),'field':("sbgfcTypeOfLoan")],1)
printHtmlPart(9)
expressionOut.print(hasErrors(bean: loanGuaranteeInstance, field: 'sbgfcPurposeOfLoan', 'has-error'))
printHtmlPart(27)
invokeTag('message','g',205,['code':("loan.sbgfcPurposeOfLoan.label"),'default':("Purpose of Loan")],-1)
printHtmlPart(3)
invokeTag('field','g',209,['type':("text"),'id':("sbgfcPurposeOfLoan"),'name':("sbgfcPurposeOfLoan"),'value':(loanGuaranteeInstance?.sbgfcPurposeOfLoan),'class':("form-control")],-1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(6)
invokeTag('message','g',214,['error':(it)],-1)
printHtmlPart(7)
})
invokeTag('eachError','g',215,['bean':(loanGuaranteeInstance),'field':("sbgfcPurposeOfLoan")],2)
printHtmlPart(8)
})
invokeTag('hasErrors','g',218,['bean':(loanGuaranteeInstance),'field':("sbgfcPurposeOfLoan")],1)
printHtmlPart(9)
expressionOut.print(hasErrors(bean: loanGuaranteeInstance, field: 'sbgfcOutstandingBalance', 'has-error'))
printHtmlPart(28)
invokeTag('message','g',224,['code':("loan.sbgfcOutstandingBalance.label"),'default':("Outstanding Balance")],-1)
printHtmlPart(3)
invokeTag('field','g',228,['id':("sbgfcOutstandingBalance"),'name':("sbgfcOutstandingBalance"),'value':(loanGuaranteeInstance?.sbgfcOutstandingBalance),'class':("form-control truncated")],-1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(6)
invokeTag('message','g',233,['error':(it)],-1)
printHtmlPart(7)
})
invokeTag('eachError','g',234,['bean':(loanGuaranteeInstance),'field':("sbgfcOutstandingBalance")],2)
printHtmlPart(8)
})
invokeTag('hasErrors','g',237,['bean':(loanGuaranteeInstance),'field':("sbgfcOutstandingBalance")],1)
printHtmlPart(9)
expressionOut.print(hasErrors(bean: loanGuaranteeInstance, field: 'sbgfcDsc', 'has-error'))
printHtmlPart(29)
invokeTag('message','g',243,['code':("loan.sbgfcDsc.label"),'default':("Debt Serv. Capacity")],-1)
printHtmlPart(3)
invokeTag('field','g',247,['type':("text"),'id':("sbgfcDsc"),'name':("sbgfcDsc"),'value':(loanGuaranteeInstance?.sbgfcDsc),'class':("form-control")],-1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(6)
invokeTag('message','g',252,['error':(it)],-1)
printHtmlPart(7)
})
invokeTag('eachError','g',253,['bean':(loanGuaranteeInstance),'field':("sbgfcDsc")],2)
printHtmlPart(8)
})
invokeTag('hasErrors','g',256,['bean':(loanGuaranteeInstance),'field':("sbgfcDsc")],1)
printHtmlPart(9)
expressionOut.print(hasErrors(bean: loanGuaranteeInstance, field: 'sbgfcInitialBrrTotalPoints', 'has-error'))
printHtmlPart(30)
invokeTag('message','g',262,['code':("loan.sbgfcInitialBrrTotalPoints.label"),'default':("Initial BRR Total Points")],-1)
printHtmlPart(3)
invokeTag('field','g',266,['type':("text"),'id':("sbgfcInitialBrrTotalPoints"),'name':("sbgfcInitialBrrTotalPoints"),'value':(loanGuaranteeInstance?.sbgfcInitialBrrTotalPoints),'class':("form-control truncated")],-1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(6)
invokeTag('message','g',271,['error':(it)],-1)
printHtmlPart(7)
})
invokeTag('eachError','g',272,['bean':(loanGuaranteeInstance),'field':("sbgfcInitialBrrTotalPoints")],2)
printHtmlPart(8)
})
invokeTag('hasErrors','g',275,['bean':(loanGuaranteeInstance),'field':("sbgfcInitialBrrTotalPoints")],1)
printHtmlPart(9)
expressionOut.print(hasErrors(bean: loanGuaranteeInstance, field: 'sbgfcInitialBrrGrade', 'has-error'))
printHtmlPart(31)
invokeTag('message','g',281,['code':("loan.sbgfcInitialBrrGrade.label"),'default':("Initial BRR Grade")],-1)
printHtmlPart(3)
invokeTag('field','g',285,['type':("text"),'id':("sbgfcInitialBrrGrade"),'name':("sbgfcInitialBrrGrade"),'value':(loanGuaranteeInstance?.sbgfcInitialBrrGrade),'class':("form-control truncated")],-1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(6)
invokeTag('message','g',290,['error':(it)],-1)
printHtmlPart(7)
})
invokeTag('eachError','g',291,['bean':(loanGuaranteeInstance),'field':("sbgfcInitialBrrGrade")],2)
printHtmlPart(8)
})
invokeTag('hasErrors','g',294,['bean':(loanGuaranteeInstance),'field':("sbgfcInitialBrrGrade")],1)
printHtmlPart(9)
expressionOut.print(hasErrors(bean: loanGuaranteeInstance, field: 'sbgfcBrrTotalPoints', 'has-error'))
printHtmlPart(32)
invokeTag('message','g',300,['code':("loan.sbgfcBrrTotalPoints.label"),'default':("BRR Total Points")],-1)
printHtmlPart(3)
invokeTag('field','g',304,['type':("text"),'id':("sbgfcBrrTotalPoints"),'name':("sbgfcBrrTotalPoints"),'value':(loanGuaranteeInstance?.sbgfcInitialBrrGrade),'class':("form-control truncated")],-1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(6)
invokeTag('message','g',309,['error':(it)],-1)
printHtmlPart(7)
})
invokeTag('eachError','g',310,['bean':(loanGuaranteeInstance),'field':("sbgfcBrrTotalPoints")],2)
printHtmlPart(8)
})
invokeTag('hasErrors','g',313,['bean':(loanGuaranteeInstance),'field':("sbgfcBrrTotalPoints")],1)
printHtmlPart(9)
expressionOut.print(hasErrors(bean: loanGuaranteeInstance, field: 'sbgfcBrrGrade', 'has-error'))
printHtmlPart(33)
invokeTag('message','g',319,['code':("loan.sbgfcBrrGrade.label"),'default':("BRR Grade")],-1)
printHtmlPart(3)
invokeTag('field','g',323,['type':("text"),'id':("sbgfcBrrGrade"),'name':("sbgfcBrrGrade"),'value':(loanGuaranteeInstance?.sbgfcBrrGrade),'class':("form-control truncated")],-1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(6)
invokeTag('message','g',328,['error':(it)],-1)
printHtmlPart(7)
})
invokeTag('eachError','g',329,['bean':(loanGuaranteeInstance),'field':("sbgfcBrrGrade")],2)
printHtmlPart(8)
})
invokeTag('hasErrors','g',332,['bean':(loanGuaranteeInstance),'field':("sbgfcBrrGrade")],1)
printHtmlPart(9)
expressionOut.print(hasErrors(bean: loanGuaranteeInstance, field: 'sbgfcTypeOfCollateral', 'has-error'))
printHtmlPart(34)
invokeTag('message','g',338,['code':("loan.sbgfcTypeOfCollateral.label"),'default':("Type of Collateral")],-1)
printHtmlPart(3)
invokeTag('field','g',342,['type':("text"),'id':("sbgfcTypeOfCollateral"),'name':("sbgfcTypeOfCollateral"),'value':(loanGuaranteeInstance?.sbgfcTypeOfCollateral),'class':("form-control")],-1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(6)
invokeTag('message','g',347,['error':(it)],-1)
printHtmlPart(7)
})
invokeTag('eachError','g',348,['bean':(loanGuaranteeInstance),'field':("sbgfcTypeOfCollateral")],2)
printHtmlPart(8)
})
invokeTag('hasErrors','g',351,['bean':(loanGuaranteeInstance),'field':("sbgfcTypeOfCollateral")],1)
printHtmlPart(9)
expressionOut.print(hasErrors(bean: loanGuaranteeInstance, field: 'sbgfcMarketValue', 'has-error'))
printHtmlPart(35)
invokeTag('message','g',357,['code':("loan.sbgfcMarketValue.label"),'default':("Market Value")],-1)
printHtmlPart(3)
invokeTag('field','g',361,['type':("text"),'id':("sbgfcMarketValue"),'name':("sbgfcMarketValue"),'value':(loanGuaranteeInstance?.sbgfcMarketValue),'class':("form-control truncated")],-1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(6)
invokeTag('message','g',366,['error':(it)],-1)
printHtmlPart(7)
})
invokeTag('eachError','g',367,['bean':(loanGuaranteeInstance),'field':("sbgfcMarketValue")],2)
printHtmlPart(8)
})
invokeTag('hasErrors','g',370,['bean':(loanGuaranteeInstance),'field':("sbgfcMarketValue")],1)
printHtmlPart(9)
expressionOut.print(hasErrors(bean: loanGuaranteeInstance, field: 'sbgfcLoanValue', 'has-error'))
printHtmlPart(36)
invokeTag('message','g',376,['code':("loan.sbgfcLoanValue.label"),'default':("Loan Value")],-1)
printHtmlPart(3)
invokeTag('field','g',380,['id':("sbgfcLoanValue"),'name':("sbgfcLoanValue"),'value':("${loanGuaranteeInstance?.sbgfcLoanValue} "),'class':("form-control truncated")],-1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(6)
invokeTag('message','g',385,['error':(it)],-1)
printHtmlPart(7)
})
invokeTag('eachError','g',386,['bean':(loanGuaranteeInstance),'field':("sbgfcLoanValue")],2)
printHtmlPart(8)
})
invokeTag('hasErrors','g',389,['bean':(loanGuaranteeInstance),'field':("sbgfcLoanValue")],1)
printHtmlPart(37)
expressionOut.print(hasErrors(bean: loanGuaranteeInstance, field: 'sbgfcBusinessName', 'has-error'))
printHtmlPart(38)
invokeTag('message','g',394,['code':("loan.sbgfcBusinessName.label"),'default':("Business Name")],-1)
printHtmlPart(3)
invokeTag('field','g',398,['id':("sbgfcBusinessName"),'name':("sbgfcBusinessName"),'value':(loanGuaranteeInstance?.sbgfcBusinessName),'class':("form-control")],-1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(6)
invokeTag('message','g',403,['error':(it)],-1)
printHtmlPart(7)
})
invokeTag('eachError','g',404,['bean':(loanGuaranteeInstance),'field':("sbgfcBusinessName")],2)
printHtmlPart(8)
})
invokeTag('hasErrors','g',407,['bean':(loanGuaranteeInstance),'field':("sbgfcBusinessName")],1)
printHtmlPart(39)
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
