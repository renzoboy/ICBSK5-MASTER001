import icbs.loans.ROPA
import icbs.loans.ScrRopa
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_loan_scrscrMaintenance_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/loan/scr/scrMaintenance.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
printHtmlPart(1)
printHtmlPart(2)
createTagBody(1, {->
printHtmlPart(3)
invokeTag('captureMeta','sitemesh',16,['gsp_sm_xmlClosingForEmptyTag':(""),'http-equiv':("Content-Type"),'content':("text/html; charset=UTF-8")],-1)
printHtmlPart(3)
invokeTag('captureMeta','sitemesh',17,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(4)
createTagBody(2, {->
createClosureForHtmlPart(5, 3)
invokeTag('captureTitle','sitemesh',18,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',18,[:],2)
printHtmlPart(3)
createTagBody(2, {->
printHtmlPart(6)
expressionOut.print(createLink(controller:'loan', action:'collectionInformation'))
printHtmlPart(7)
expressionOut.print(createLink(controller: 'scr', action:'search'))
printHtmlPart(8)
expressionOut.print(ropa?.id)
printHtmlPart(9)
})
invokeTag('javascript','g',74,[:],2)
printHtmlPart(10)
})
invokeTag('captureHead','sitemesh',75,[:],1)
printHtmlPart(11)
createTagBody(1, {->
printHtmlPart(3)
createTagBody(2, {->
printHtmlPart(12)
expressionOut.print(loanInstance?.pnNo)
printHtmlPart(13)
expressionOut.print(loanInstance?.accountNo)
printHtmlPart(14)
expressionOut.print(loanInstance?.customer?.displayName)
printHtmlPart(15)
invokeTag('formatDate','g',94,['format':("MM/dd/yyyy"),'date':(loanInstance?.openingDate)],-1)
printHtmlPart(16)
invokeTag('formatNumber','g',98,['format':("###,###,##0.00"),'number':(loanInstance?.grantedAmount)],-1)
printHtmlPart(17)
invokeTag('formatNumber','g',102,['format':("###,###,##0.00"),'number':(loanInstance?.balanceAmount)],-1)
printHtmlPart(18)
createTagBody(3, {->
printHtmlPart(19)
expressionOut.print(hasErrors(bean: ropaInstance, field: 'ropa', 'has-error'))
printHtmlPart(20)
invokeTag('message','g',116,['code':("ScrRopa.ropa.label"),'default':("ROPA Name")],-1)
printHtmlPart(21)
invokeTag('field','g',118,['name':("customerDisplayName"),'id':("customerDisplayName"),'value':(ropaInstance?.customerDisplayName),'disabled':("disable"),'class':("form-control")],-1)
printHtmlPart(22)
createTagBody(4, {->
printHtmlPart(23)
createTagBody(5, {->
printHtmlPart(24)
invokeTag('message','g',124,['error':(it)],-1)
printHtmlPart(25)
})
invokeTag('eachError','g',125,['bean':(ropaInstance),'field':("ropa")],5)
printHtmlPart(26)
})
invokeTag('hasErrors','g',128,['bean':(ropaInstance),'field':("ropaLoanAcctNo")],4)
printHtmlPart(27)
expressionOut.print(hasErrors(bean: ropaInstance, field: 'loanAcctNo', 'has-error'))
printHtmlPart(28)
invokeTag('message','g',135,['code':("creditInvestigation.ciName.label"),'default':("Loan Account")],-1)
printHtmlPart(29)
invokeTag('field','g',137,['name':("lnaccountNo"),'id':("lnaccountNo"),'value':(ropaInstance?.loanAcctNo),'disabled':("disable"),'class':("form-control")],-1)
printHtmlPart(30)
createTagBody(4, {->
printHtmlPart(31)
createTagBody(5, {->
printHtmlPart(32)
invokeTag('message','g',143,['error':(it)],-1)
printHtmlPart(33)
})
invokeTag('eachError','g',144,['bean':(creditInvestigationInstance),'field':("loanAcctNo")],5)
printHtmlPart(34)
})
invokeTag('hasErrors','g',147,['bean':(creditInvestigationInstance),'field':("loanAcctNo")],4)
printHtmlPart(35)
invokeTag('hiddenField','g',152,['name':("scrId"),'id':("scrId"),'value':(params?.id)],-1)
printHtmlPart(36)
invokeTag('hiddenField','g',154,['name':("ropaididid"),'id':("ropaididid"),'value':(ropaInstance?.id)],-1)
printHtmlPart(37)
invokeTag('field','g',159,['class':("form-control"),'id':("remarks"),'name':("remarks"),'value':("")],-1)
printHtmlPart(38)
})
invokeTag('form','g',163,['id':("deposit"),'url':([controller:loan, action:'saveScrMaintenance']),'method':("PUT")],3)
printHtmlPart(39)
})
invokeTag('captureContent','sitemesh',166,['tag':("main-content")],2)
printHtmlPart(40)
createTagBody(2, {->
printHtmlPart(41)
invokeTag('submitButton','g',177,['id':("saveScrMaintenance"),'name':("saveScrMaintenance"),'value':(message(code: 'default.button.Save.label', default: 'Link To Ropa')),'onclick':("""
                        alertify.confirm(AppTitle,'Are you sure you want to continue this transaction?',
                                function(){
                                     checkIfAllowed('CFG00303', 'form#deposit', 'save.', null); 
                                },
                                function(){
                                    return;
                                });     
                        """)],-1)
printHtmlPart(42)
createClosureForHtmlPart(43, 3)
invokeTag('link','g',178,['action':("show"),'id':(loanInstance.id)],3)
printHtmlPart(44)
})
invokeTag('captureContent','sitemesh',180,['tag':("main-actions")],2)
printHtmlPart(11)
})
invokeTag('captureBody','sitemesh',181,[:],1)
printHtmlPart(1)
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
