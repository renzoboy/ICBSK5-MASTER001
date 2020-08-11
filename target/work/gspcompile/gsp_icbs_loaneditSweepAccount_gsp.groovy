import icbs.loans.Loan
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_loaneditSweepAccount_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/loan/editSweepAccount.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
invokeTag('set','g',6,['var':("entityName"),'value':(message(code: 'loan.label', default: 'Loan'))],-1)
printHtmlPart(1)
if(true && (module == 'loan')) {
printHtmlPart(2)
createTagBody(3, {->
createClosureForHtmlPart(3, 4)
invokeTag('captureTitle','sitemesh',8,[:],4)
})
invokeTag('wrapTitleTag','sitemesh',8,[:],3)
printHtmlPart(4)
}
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(6)
expressionOut.print(createLink(controller:'Loan', action:'removeLoanSweepAccountAjax'))
printHtmlPart(7)
})
invokeTag('javascript','g',60,[:],2)
printHtmlPart(8)
})
invokeTag('captureHead','sitemesh',61,[:],1)
printHtmlPart(9)
createTagBody(1, {->
printHtmlPart(10)
createClosureForHtmlPart(11, 2)
invokeTag('captureContent','sitemesh',65,['tag':("breadcrumbs")],2)
printHtmlPart(10)
createTagBody(2, {->
printHtmlPart(12)
expressionOut.print(loanApplicationInstance?.customer?.displayName)
printHtmlPart(13)
expressionOut.print(loanInstance?.accountNo)
printHtmlPart(14)
invokeTag('textField','g',68,['name':("loanid"),'id':("loanid"),'value':(params?.id),'style':("display:none")],-1)
printHtmlPart(15)
if(true && (flash.message)) {
printHtmlPart(16)
expressionOut.print(flash.message)
printHtmlPart(17)
}
printHtmlPart(18)
invokeTag('set','g',98,['var':("i"),'value':(0)],-1)
printHtmlPart(19)
for( sweepAccounts in (session["sweeplist"]) ) {
printHtmlPart(20)
expressionOut.print(sweepAccounts?.depositAccount?.acctNo)
printHtmlPart(21)
expressionOut.print(sweepAccounts?.depositAccount?.acctName)
printHtmlPart(21)
expressionOut.print(sweepAccounts?.type?.description)
printHtmlPart(21)
expressionOut.print(sweepAccounts?.rule?.description)
printHtmlPart(22)
expressionOut.print(sweepAccounts?.remarks)
printHtmlPart(23)
invokeTag('hiddenField','g',108,['name':("loanSweepId"),'id':("loanSweepId"),'value':(sweepAccounts?.id)],-1)
printHtmlPart(24)
invokeTag('hiddenField','g',109,['name':("loanAccountId"),'id':("loanAccountId"),'value':(params?.id)],-1)
printHtmlPart(25)
expressionOut.print(i)
printHtmlPart(26)
expressionOut.print(sweepAccounts?.id)
printHtmlPart(27)
invokeTag('hiddenField','g',112,['name':("actionPage"),'id':("actionPage"),'value':(session["pageAction"])],-1)
printHtmlPart(28)
expressionOut.print(i)
printHtmlPart(29)
invokeTag('hiddenField','g',116,['name':("loopcounterId"),'id':("loopcounterId"),'value':(i)],-1)
printHtmlPart(30)
invokeTag('field','g',127,['class':("form-control"),'id':("editaccountNo${i}"),'name':("editaccountNo"),'value':(sweepAccounts?.depositAccount?.acctNo),'readonly':("true")],-1)
printHtmlPart(31)
invokeTag('hiddenField','g',128,['id':("editdepositAccount${i}"),'name':("editdepositAccount.id"),'value':(sweepAccount?.depositAccount?.id)],-1)
printHtmlPart(31)
invokeTag('hiddenField','g',129,['id':("editloanIdvalue${i}"),'name':("editloanIdvalue"),'value':(params?.id)],-1)
printHtmlPart(31)
invokeTag('hiddenField','g',130,['id':("editdepositAccountId${i}"),'name':("editdepositAccountId"),'value':(sweepAccounts?.depositAccount?.id)],-1)
printHtmlPart(31)
invokeTag('hiddenField','g',131,['id':("loanRecoveryId${i}"),'name':("loanRecoveryId"),'value':(sweepAccounts?.id)],-1)
printHtmlPart(32)
expressionOut.print(i)
printHtmlPart(33)
invokeTag('select','g',137,['class':("form-control"),'id':("edittype${i}"),'name':("edittype.id"),'from':(icbs.lov.SweepType.list().sort{it.id}),'optionKey':("id"),'optionValue':("description"),'value':(sweepAccounts?.type?.id),'onchange':("updateSweepForm()")],-1)
printHtmlPart(34)
invokeTag('select','g',141,['class':("form-control"),'id':("editrule${i}"),'name':("editrule.id"),'from':(icbs.lov.SweepRule.list().sort{it.id}),'optionKey':("id"),'optionValue':("description"),'value':(sweepAccount?.rule?.id),'onchange':("updateSweepForm1('${i}')")],-1)
printHtmlPart(35)
expressionOut.print(i)
printHtmlPart(36)
invokeTag('field','g',145,['id':("editfundLimitAmt${i}"),'name':("editfundLimitAmt"),'value':(sweepAccounts?.fundLimitAmt),'class':("form-control truncated")],-1)
printHtmlPart(37)
expressionOut.print(i)
printHtmlPart(38)
invokeTag('field','g',149,['id':("editfundLimitPercentage${i}"),'name':("editfundLimitPercentage"),'value':(sweepAccounts?.fundLimitPercentage),'required':(""),'class':("form-control")],-1)
printHtmlPart(39)
invokeTag('textArea','g',153,['id':("editremarks${i}"),'name':("remarks"),'cols':("40"),'rows':("5"),'maxlength':("255"),'value':(sweepAccounts?.remarks),'class':("form-control")],-1)
printHtmlPart(40)
expressionOut.print(i)
printHtmlPart(41)
createTagBody(4, {->
printHtmlPart(42)
expressionOut.print(createLink(controller : 'search', action:'search', params:[searchDomain: "deposit"]))
printHtmlPart(43)
expressionOut.print(createLink(controller:'Loan', action:'editLoanSweepAccountAjaxx'))
printHtmlPart(44)
expressionOut.print(createLink(controller:'loan', action:'showDepositAccountInfo'))
printHtmlPart(45)
expressionOut.print(createLink(controller:'Loan', action:'validateDuplicateSweepDepositAcctNoAjax'))
printHtmlPart(46)
})
invokeTag('javascript','g',373,[:],4)
printHtmlPart(47)
invokeTag('set','g',380,['var':("i"),'value':(i = i + 1)],-1)
printHtmlPart(19)
}
printHtmlPart(48)
})
invokeTag('captureContent','sitemesh',389,['tag':("main-content")],2)
printHtmlPart(49)
createTagBody(2, {->
printHtmlPart(50)
if(true && (loanInstance?.status.id<7)) {
printHtmlPart(51)
}
printHtmlPart(52)
expressionOut.print(sweepAccount?.depositAccount?.id)
printHtmlPart(53)
invokeTag('field','g',412,['class':("form-control"),'id':("accountNo"),'name':("accountNo"),'value':(sweepAccounts?.depositAccount?.acctNo),'readonly':("true")],-1)
printHtmlPart(54)
invokeTag('hiddenField','g',413,['id':("depositAccount"),'name':("depositAccount.id"),'value':(sweepAccount?.depositAccount?.id)],-1)
printHtmlPart(54)
invokeTag('hiddenField','g',414,['id':("loanAccountIds"),'name':("loanAccountIds"),'value':(params?.id)],-1)
printHtmlPart(55)
invokeTag('select','g',420,['class':("form-control"),'id':("type"),'name':("type.id"),'from':(icbs.lov.SweepType.list().sort{it.id}),'optionKey':("id"),'optionValue':("description"),'value':(""),'onchange':("updateSweepForm()")],-1)
printHtmlPart(56)
invokeTag('select','g',424,['class':("form-control"),'id':("addrule"),'name':("rule.id"),'from':(icbs.lov.SweepRule.list().sort{it.id}),'optionKey':("id"),'optionValue':("description"),'value':(""),'onchange':("updateSweepForm();")],-1)
printHtmlPart(57)
invokeTag('field','g',428,['id':("fundLimitAmt"),'name':("fundLimitAmt"),'value':(""),'class':("form-control truncated")],-1)
printHtmlPart(58)
invokeTag('field','g',432,['id':("fundLimitPercentage"),'name':("fundLimitPercentage"),'value':(""),'required':(""),'class':("form-control")],-1)
printHtmlPart(59)
invokeTag('textArea','g',437,['id':("remarks"),'name':("remarks"),'cols':("40"),'rows':("5"),'maxlength':("255"),'value':(""),'class':("form-control")],-1)
printHtmlPart(60)
createTagBody(3, {->
printHtmlPart(61)
expressionOut.print(createLink(controller:'Loan', action:'addLoanSweepAccountAjaxx'))
printHtmlPart(62)
expressionOut.print(createLink(controller : 'search', action:'search', params:[searchDomain: "deposit"]))
printHtmlPart(63)
expressionOut.print(createLink(controller:'loan', action:'showDepositAccountInfo'))
printHtmlPart(64)
expressionOut.print(createLink(controller:'Loan', action:'validateDuplicateSweepDepositAcctNoAjax'))
printHtmlPart(65)
})
invokeTag('javascript','g',632,[:],3)
printHtmlPart(66)
})
invokeTag('captureContent','sitemesh',638,['tag':("main-actions")],2)
printHtmlPart(67)
})
invokeTag('captureBody','sitemesh',640,[:],1)
printHtmlPart(68)
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
