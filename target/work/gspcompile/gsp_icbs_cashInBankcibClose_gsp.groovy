import icbs.gl.CashInBank
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_cashInBankcibClose_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/cashInBank/cibClose.gsp" }
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
expressionOut.print(createLink(uri: '/cashInBank'))
printHtmlPart(6)
})
invokeTag('captureContent','sitemesh',12,['tag':("breadcrumbs")],2)
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(7)
if(true && (flash.message)) {
printHtmlPart(8)
expressionOut.print(flash.message)
printHtmlPart(9)
}
printHtmlPart(10)
expressionOut.print(cashInBankInstance?.branch?.name)
printHtmlPart(11)
expressionOut.print(cashInBankInstance?.type?.description)
printHtmlPart(12)
expressionOut.print(cashInBankInstance?.currency?.code)
printHtmlPart(13)
expressionOut.print(cashInBankInstance?.bankName)
printHtmlPart(14)
expressionOut.print(cashInBankInstance?.bankBranch)
printHtmlPart(15)
expressionOut.print(cashInBankInstance?.bankAddress)
printHtmlPart(16)
expressionOut.print(cashInBankInstance?.acctNo)
printHtmlPart(17)
invokeTag('formatNumber','g',57,['format':("##0.00000"),'number':(cashInBankInstance?.intRate)],-1)
printHtmlPart(18)
invokeTag('formatNumber','g',61,['format':("###,###,##0.00"),'number':(cashInBankInstance?.balance)],-1)
printHtmlPart(19)
invokeTag('formatDate','g',65,['format':("MM/dd/yyyy"),'date':(cashInBankInstance?.openDate)],-1)
printHtmlPart(20)
invokeTag('formatDate','g',69,['format':("MM/dd/yyyy"),'date':(cashInBankInstance?.maturityDate)],-1)
printHtmlPart(21)
expressionOut.print(cashInBankInstance?.user?.name)
printHtmlPart(22)
invokeTag('formatDate','g',77,['format':("MM/dd/yyyy"),'date':(cashInBankInstance?.createDate)],-1)
printHtmlPart(23)
expressionOut.print(cashInBankInstance?.glContra)
printHtmlPart(24)
expressionOut.print(cashInBankInstance?.status?.description)
printHtmlPart(25)
expressionOut.print(cashInBankInstance?.remarks)
printHtmlPart(26)
createTagBody(3, {->
printHtmlPart(27)
invokeTag('hiddenField','g',95,['name':("cashInBankId"),'id':("cashInBankId"),'value':(params.id)],-1)
printHtmlPart(28)
})
invokeTag('form','g',96,['id':("cibClose"),'url':([resource:cashInBankInstance, action:'saveCibClose']),'method':("PUT")],3)
printHtmlPart(4)
})
invokeTag('captureContent','sitemesh',97,['tag':("main-content")],2)
printHtmlPart(29)
createTagBody(2, {->
printHtmlPart(30)
invokeTag('actionSubmit','g',109,['class':("save"),'id':("saveCibClose"),'name':("saveCibClose"),'action':("saveCibClose"),'value':(message(code: 'default.button.Save.label', default: 'Close Cash in Bank')),'onclick':("""
                        alertify.confirm(AppTitle,'Are you sure you want to continue this transaction?',
                                function(){
                                     checkIfAllowed('CFG00303', 'form#cibClose', 'Override edit cash in bank.', null); 
                                },
                                function(){
                                    return;
                                });                      
                    """)],-1)
printHtmlPart(31)
createClosureForHtmlPart(32, 3)
invokeTag('link','g',110,['action':("index"),'controller':("cashInBank"),'id':(cashInBankInstance.id)],3)
printHtmlPart(33)
})
invokeTag('captureContent','sitemesh',112,['tag':("main-actions")],2)
printHtmlPart(3)
})
invokeTag('captureBody','sitemesh',113,[:],1)
printHtmlPart(34)
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
