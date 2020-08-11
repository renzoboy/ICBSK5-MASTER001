import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_deposit_inwardCheckClearing_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/deposit/inwardCheckClearing/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
invokeTag('message','g',11,['code':("inwardCheckClearing.file.label"),'default':("Bank format")],-1)
printHtmlPart(2)
invokeTag('select','g',14,['id':("iccBankFormat"),'name':("iccBankFormat"),'required':("true"),'noSelection':(['':'']),'from':(icbs.lov.IccBank.findAllByStatus(true)),'value':(""),'optionKey':("id"),'optionValue':("description"),'onchange':("bankformat();"),'class':("form-control")],-1)
printHtmlPart(3)
invokeTag('message','g',20,['code':("inwardCheckClearing.file.label"),'default':("Clearing File Name")],-1)
printHtmlPart(4)
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
