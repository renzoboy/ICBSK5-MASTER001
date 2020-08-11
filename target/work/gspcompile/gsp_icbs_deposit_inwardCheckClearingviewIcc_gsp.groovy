import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_deposit_inwardCheckClearingviewIcc_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/deposit/inwardCheckClearing/viewIcc.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',9,['gsp_sm_xmlClosingForEmptyTag':(""),'http-equiv':("Content-Type"),'content':("text/html; charset=UTF-8")],-1)
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',10,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(2)
createTagBody(2, {->
createClosureForHtmlPart(3, 3)
invokeTag('captureTitle','sitemesh',11,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',11,[:],2)
printHtmlPart(4)
})
invokeTag('captureHead','sitemesh',12,[:],1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(2)
createTagBody(2, {->
printHtmlPart(5)
if(true && (flash.message)) {
printHtmlPart(6)
expressionOut.print(flash.message)
printHtmlPart(7)
expressionOut.print(flash.message)
printHtmlPart(8)
}
printHtmlPart(9)
createTagBody(3, {->
printHtmlPart(10)
loop:{
int i = 0
for( check in (domainInstance?.checks) ) {
printHtmlPart(11)
invokeTag('hiddenField','g',47,['name':("checks[${i}].chequeNo"),'value':(check?.chequeNo)],-1)
printHtmlPart(12)
invokeTag('hiddenField','g',48,['name':("checks[${i}].amt"),'value':(check?.amt)],-1)
printHtmlPart(12)
invokeTag('hiddenField','g',49,['name':("checks[${i}].brstn"),'value':(check?.brstn)],-1)
printHtmlPart(12)
invokeTag('hiddenField','g',50,['name':("checks[${i}].trancd"),'value':(check?.trancd)],-1)
printHtmlPart(12)
invokeTag('hiddenField','g',51,['name':("checks[${i}].acctNo"),'value':(check?.acctNo)],-1)
printHtmlPart(13)
expressionOut.print(i + 1)
printHtmlPart(14)
expressionOut.print(check?.acctNo)
printHtmlPart(14)
expressionOut.print(check?.chequeNo)
printHtmlPart(14)
invokeTag('formatNumber','g',55,['format':("###,###,##0.00"),'number':(check?.amt)],-1)
printHtmlPart(14)
expressionOut.print(check?.brstn)
printHtmlPart(14)
expressionOut.print(check?.trancd)
printHtmlPart(15)
createTagBody(5, {->
printHtmlPart(16)
createTagBody(6, {->
printHtmlPart(17)
invokeTag('message','g',62,['error':(it)],-1)
printHtmlPart(18)
})
invokeTag('eachError','g',63,['bean':(domainInstance),'field':("checks[${i}].acctNo")],6)
printHtmlPart(19)
})
invokeTag('hasErrors','g',65,['bean':(domainInstance),'field':("checks[${i}].acctNo")],5)
printHtmlPart(20)
createTagBody(5, {->
printHtmlPart(16)
createTagBody(6, {->
printHtmlPart(17)
invokeTag('message','g',69,['error':(it)],-1)
printHtmlPart(18)
})
invokeTag('eachError','g',70,['bean':(domainInstance),'field':("checks[${i}].chequeNo")],6)
printHtmlPart(19)
})
invokeTag('hasErrors','g',72,['bean':(domainInstance),'field':("checks[${i}].chequeNo")],5)
printHtmlPart(21)
createTagBody(5, {->
printHtmlPart(16)
createTagBody(6, {->
printHtmlPart(17)
invokeTag('message','g',76,['error':(it)],-1)
printHtmlPart(18)
})
invokeTag('eachError','g',77,['bean':(domainInstance),'field':("checks[${i}].amt")],6)
printHtmlPart(19)
})
invokeTag('hasErrors','g',79,['bean':(domainInstance),'field':("checks[${i}].amt")],5)
printHtmlPart(21)
createTagBody(5, {->
printHtmlPart(16)
createTagBody(6, {->
printHtmlPart(17)
invokeTag('message','g',83,['error':(it)],-1)
printHtmlPart(18)
})
invokeTag('eachError','g',84,['bean':(domainInstance),'field':("checks[${i}].brstn")],6)
printHtmlPart(19)
})
invokeTag('hasErrors','g',86,['bean':(domainInstance),'field':("checks[${i}].brstn")],5)
printHtmlPart(21)
createTagBody(5, {->
printHtmlPart(16)
createTagBody(6, {->
printHtmlPart(17)
invokeTag('message','g',90,['error':(it)],-1)
printHtmlPart(18)
})
invokeTag('eachError','g',91,['bean':(domainInstance),'field':("checks[${i}].trancd")],6)
printHtmlPart(19)
})
invokeTag('hasErrors','g',93,['bean':(domainInstance),'field':("checks[${i}].trancd")],5)
printHtmlPart(22)
i++
}
}
printHtmlPart(23)
})
invokeTag('form','g',99,['name':("processInwardCheckingForm"),'action':("processInwardCheckClearing"),'controller':("deposit"),'onsubmit':("callLoadingDialog();")],3)
printHtmlPart(24)
})
invokeTag('captureContent','sitemesh',101,['tag':("main-content")],2)
printHtmlPart(2)
createTagBody(2, {->
printHtmlPart(25)
invokeTag('submitButton','g',112,['name':("submit"),'id':("processIcc"),'class':("btn btn-primary"),'value':('Process'),'onclick':("""
                        alertify.confirm(AppTitle,'Are you sure you want to continue this process?',
                                function(){
                                    checkIfAllowed('DEP01300', 'form#processInwardCheckingForm', 'Override Inward clearing process', null);
                                },
                                function(){
                                    return;
                                });
                """)],-1)
printHtmlPart(26)
createClosureForHtmlPart(27, 3)
invokeTag('link','g',113,['action':("index")],3)
printHtmlPart(26)
createClosureForHtmlPart(28, 3)
invokeTag('link','g',114,['action':("index")],3)
printHtmlPart(29)
createClosureForHtmlPart(30, 3)
invokeTag('link','g',117,['action':("depositInquiry"),'id':(depositInstance?.id),'onclick':("return confirm('Are you sure you want to return to Deposit Inquiries page?');")],3)
printHtmlPart(31)
})
invokeTag('captureContent','sitemesh',120,['tag':("main-actions")],2)
printHtmlPart(4)
})
invokeTag('captureBody','sitemesh',121,[:],1)
printHtmlPart(32)
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
