import icbs.admin.UserMaster
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_ropaspecialtransferToRopaGSP_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/ropa/specialtransferToRopaGSP.gsp" }
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
createTagBody(2, {->
printHtmlPart(4)
expressionOut.print(createLink(controller: 'loan', action:'search'))
printHtmlPart(5)
expressionOut.print(createLink(controller:'loan', action:'getLoanDetailsAjax'))
printHtmlPart(6)
expressionOut.print(createLink(controller:'Ropa', action:'ropaSpecialCollateralValidatorAjax'))
printHtmlPart(7)
})
invokeTag('javascript','g',130,[:],2)
printHtmlPart(8)
})
invokeTag('captureHead','sitemesh',131,[:],1)
printHtmlPart(9)
createTagBody(1, {->
printHtmlPart(10)
createClosureForHtmlPart(11, 2)
invokeTag('captureContent','sitemesh',136,['tag':("breadcrumbs")],2)
printHtmlPart(1)
createTagBody(2, {->
printHtmlPart(12)
if(true && (flash.message)) {
printHtmlPart(13)
expressionOut.print(flash.message)
printHtmlPart(14)
}
printHtmlPart(15)
createTagBody(3, {->
printHtmlPart(16)
createTagBody(4, {->
printHtmlPart(17)
if(true && (error in org.springframework.validation.FieldError)) {
printHtmlPart(18)
expressionOut.print(error.field)
printHtmlPart(19)
}
printHtmlPart(20)
invokeTag('message','g',151,['error':("${error.field} - ${error}")],-1)
printHtmlPart(21)
})
invokeTag('eachError','g',152,['bean':(ropaInstance),'var':("error")],4)
printHtmlPart(22)
})
invokeTag('hasErrors','g',154,['bean':(ropaInstance)],3)
printHtmlPart(23)
invokeTag('render','g',155,['template':("details/collateralDetails")],-1)
printHtmlPart(15)
createTagBody(3, {->
printHtmlPart(24)
invokeTag('hiddenField','g',157,['id':("loanID"),'name':("loanID"),'value':("")],-1)
printHtmlPart(25)
expressionOut.print(hasErrors(bean: loanLedgerInstance, field: 'loan', 'has-error'))
printHtmlPart(26)
invokeTag('message','g',160,['code':("loanLedger.loan.label"),'default':("Loan Account")],-1)
printHtmlPart(27)
invokeTag('field','g',163,['name':("accountNo"),'value':(""),'class':("form-control"),'readonly':("true")],-1)
printHtmlPart(28)
createTagBody(4, {->
printHtmlPart(29)
expressionOut.print(it)
printHtmlPart(30)
})
invokeTag('hasErrors','g',174,['bean':(loanLedgerInstance),'field':("loan")],4)
printHtmlPart(31)
expressionOut.print(hasErrors(bean: ropaInstance, field: 'loan', 'has-error'))
printHtmlPart(32)
invokeTag('textField','g',181,['name':("loanAccountName"),'required':(""),'value':(""),'class':("form-control"),'readonly':("true")],-1)
printHtmlPart(33)
createTagBody(4, {->
printHtmlPart(34)
createTagBody(5, {->
printHtmlPart(35)
invokeTag('message','g',186,['error':(it)],-1)
printHtmlPart(36)
})
invokeTag('eachError','g',187,['bean':(ropaInstance),'field':("loan")],5)
printHtmlPart(37)
})
invokeTag('hasErrors','g',190,['bean':(ropaInstance),'field':("loan")],4)
printHtmlPart(38)
expressionOut.print(hasErrors(bean: ropaInstance, field: 'loan', 'has-error'))
printHtmlPart(39)
invokeTag('textField','g',195,['name':("loanBalance"),'required':(""),'value':(""),'class':("form-control"),'readonly':("true")],-1)
printHtmlPart(33)
createTagBody(4, {->
printHtmlPart(34)
createTagBody(5, {->
printHtmlPart(35)
invokeTag('message','g',200,['error':(it)],-1)
printHtmlPart(36)
})
invokeTag('eachError','g',201,['bean':(ropaInstance),'field':("loan")],5)
printHtmlPart(37)
})
invokeTag('hasErrors','g',204,['bean':(ropaInstance),'field':("loan")],4)
printHtmlPart(38)
expressionOut.print(hasErrors(bean: transferToRopaInstance, field: 'transferAmount', 'has-error'))
printHtmlPart(40)
invokeTag('message','g',209,['code':("RopaTransfer.transferAmount.label"),'default':("Transfer Amount")],-1)
printHtmlPart(41)
invokeTag('field','g',211,['name':("transferAmount"),'id':("transferAmount"),'value':(""),'class':("form-control truncated")],-1)
printHtmlPart(42)
createTagBody(4, {->
printHtmlPart(43)
createTagBody(5, {->
printHtmlPart(44)
invokeTag('message','g',217,['error':(it)],-1)
printHtmlPart(45)
})
invokeTag('eachError','g',218,['bean':(transferToRopaInstance),'field':("transferAmount")],5)
printHtmlPart(46)
})
invokeTag('hasErrors','g',221,['bean':(transferToRopaInstance),'field':("transferAmount")],4)
printHtmlPart(47)
invokeTag('render','g',225,['template':("ropaTransfer/form")],-1)
printHtmlPart(48)
invokeTag('hiddenField','g',227,['id':("collateral"),'name':("collateral"),'value':(collateralInstance?.id)],-1)
printHtmlPart(49)
invokeTag('hiddenField','g',228,['id':("transferRopa"),'name':("transferRopa"),'value':(transferToRopaInstance?.id)],-1)
printHtmlPart(49)
invokeTag('hiddenField','g',229,['id':("loanAcctStatusId"),'name':("loanAcctStatusId"),'value':("")],-1)
printHtmlPart(49)
invokeTag('hiddenField','g',230,['id':("idOfCollateral"),'name':("idOfCollateral"),'value':(collateralInstance?.collateral?.id)],-1)
printHtmlPart(49)
invokeTag('hiddenField','g',231,['id':("ropaCollateralLoanAcctNo"),'name':("ropaCollateralLoanAcctNo"),'value':(collateralInstance?.loan?.accountNo)],-1)
printHtmlPart(50)
})
invokeTag('form','g',233,['id':("saveSpecialTransfer"),'url':([controller:'ropa', action:'saveSpecialTransfer']),'onsubmit':("callLoadingDialog();")],3)
printHtmlPart(51)
})
invokeTag('captureContent','sitemesh',235,['tag':("main-content")],2)
printHtmlPart(1)
createTagBody(2, {->
printHtmlPart(52)
createTagBody(3, {->
invokeTag('message','g',239,['code':("default.cancel.label"),'args':([entityName]),'default':("Cancel")],-1)
})
invokeTag('link','g',239,['action':("index")],3)
printHtmlPart(53)
})
invokeTag('captureContent','sitemesh',241,['tag':("main-actions")],2)
printHtmlPart(9)
})
invokeTag('captureBody','sitemesh',242,[:],1)
printHtmlPart(54)
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
