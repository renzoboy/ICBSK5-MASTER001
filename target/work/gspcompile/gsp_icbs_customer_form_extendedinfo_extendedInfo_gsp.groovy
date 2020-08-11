import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_customer_form_extendedinfo_extendedInfo_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/customer/form/extendedinfo/_extendedInfo.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
loop:{
int i = 0
for( code in (icbs.cif.Code.list()) ) {
printHtmlPart(2)
if(true && (code.status?.id==2)) {
printHtmlPart(3)
invokeTag('hiddenField','g',11,['id':("extendedinfos[${i}].code"),'name':("extendedinfos[${i}].code.id"),'value':(code?.id)],-1)
printHtmlPart(4)
expressionOut.print(hasErrors(bean: customerInstance, field: 'extendedinfos['+i+'].value', 'has-error'))
printHtmlPart(5)
expressionOut.print(i)
printHtmlPart(6)
expressionOut.print(code?.value)
printHtmlPart(7)
invokeTag('textField','g',18,['name':("extendedinfos[${i}].value"),'value':(customerInstance?.extendedinfos[i]?.value),'class':("form-control")],-1)
printHtmlPart(8)
createTagBody(3, {->
printHtmlPart(9)
createTagBody(4, {->
printHtmlPart(10)
invokeTag('message','g',23,['error':(it)],-1)
printHtmlPart(11)
})
invokeTag('eachError','g',24,['bean':(customerInstance),'field':("extendedinfos[${i}].value")],4)
printHtmlPart(12)
})
invokeTag('hasErrors','g',27,['bean':(customerInstance),'field':("extendedinfos[${i}].value")],3)
printHtmlPart(13)
}
printHtmlPart(14)
i++
}
}
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
