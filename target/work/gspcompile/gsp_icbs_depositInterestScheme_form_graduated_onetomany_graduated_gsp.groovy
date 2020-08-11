import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_depositInterestScheme_form_graduated_onetomany_graduated_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/depositInterestScheme/form/graduated/onetomany/_graduated.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
expressionOut.print(i)
printHtmlPart(2)
if(true && (graduated?.id)) {
printHtmlPart(3)
invokeTag('hiddenField','g',10,['name':("graduateds[${i}].id"),'value':(graduated?.id)],-1)
printHtmlPart(3)
invokeTag('hiddenField','g',11,['name':("graduateds[${i}].new"),'value':("false")],-1)
printHtmlPart(4)
}
else {
printHtmlPart(3)
invokeTag('hiddenField','g',14,['name':("graduateds[${i}].new"),'value':("true")],-1)
printHtmlPart(4)
}
printHtmlPart(4)
invokeTag('hiddenField','g',16,['name':("graduateds[${i}].deleted"),'value':("false")],-1)
printHtmlPart(5)
expressionOut.print(hasErrors(bean: depositInterestSchemeInstance, field: 'graduateds['+i+'].startBal', 'has-error'))
printHtmlPart(6)
expressionOut.print(i)
printHtmlPart(7)
invokeTag('message','g',21,['code':("depositInterestSchemeGraduated.startBal.label"),'default':("Start Bal")],-1)
printHtmlPart(8)
invokeTag('field','g',24,['name':("graduateds[${i}].startBal"),'value':(graduated?.startBal),'class':("form-control")],-1)
printHtmlPart(9)
createTagBody(1, {->
printHtmlPart(10)
createTagBody(2, {->
printHtmlPart(11)
invokeTag('message','g',30,['error':(it)],-1)
printHtmlPart(12)
})
invokeTag('eachError','g',31,['bean':(depositInterestSchemeInstance),'field':("graduateds[${i}].startBal")],2)
printHtmlPart(13)
})
invokeTag('hasErrors','g',34,['bean':(depositInterestSchemeInstance),'field':("graduateds[${i}].startBal")],1)
printHtmlPart(14)
expressionOut.print(hasErrors(bean: depositInterestSchemeInstance, field: 'graduateds['+i+'].endBal', 'has-error'))
printHtmlPart(6)
expressionOut.print(i)
printHtmlPart(15)
invokeTag('message','g',39,['code':("depositInterestSchemeGraduated.startBal.label"),'default':("End Bal")],-1)
printHtmlPart(8)
invokeTag('field','g',42,['name':("graduateds[${i}].endBal"),'value':(graduated?.endBal),'class':("form-control")],-1)
printHtmlPart(9)
createTagBody(1, {->
printHtmlPart(10)
createTagBody(2, {->
printHtmlPart(11)
invokeTag('message','g',48,['error':(it)],-1)
printHtmlPart(12)
})
invokeTag('eachError','g',49,['bean':(depositInterestSchemeInstance),'field':("graduateds[${i}].endBal")],2)
printHtmlPart(13)
})
invokeTag('hasErrors','g',52,['bean':(depositInterestSchemeInstance),'field':("graduateds[${i}].endBal")],1)
printHtmlPart(14)
expressionOut.print(hasErrors(bean: depositInterestSchemeInstance, field: 'graduateds['+i+'].interestRate', 'has-error'))
printHtmlPart(6)
expressionOut.print(i)
printHtmlPart(16)
invokeTag('message','g',57,['code':("depositInterestSchemeGraduated.interestRate.label"),'default':("Interest Rate")],-1)
printHtmlPart(8)
invokeTag('field','g',60,['name':("graduateds[${i}].interestRate"),'value':(graduated?.interestRate),'class':("form-control")],-1)
printHtmlPart(9)
createTagBody(1, {->
printHtmlPart(10)
createTagBody(2, {->
printHtmlPart(11)
invokeTag('message','g',66,['error':(it)],-1)
printHtmlPart(12)
})
invokeTag('eachError','g',67,['bean':(depositInterestSchemeInstance),'field':("graduateds[${i}].interestRate")],2)
printHtmlPart(13)
})
invokeTag('hasErrors','g',70,['bean':(depositInterestSchemeInstance),'field':("graduateds[${i}].interestRate")],1)
printHtmlPart(17)
if(true && (canDelete!="false")) {
printHtmlPart(18)
}
printHtmlPart(19)
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
