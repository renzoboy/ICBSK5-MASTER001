import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_loan_schemes_schemes2_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/loan/schemes/_schemes2.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
invokeTag('select','g',2,['readonly':("true"),'id':("interestIncomeScheme"),'name':("interestIncomeScheme.id"),'from':(product?.interestIncomeSchemes?.findAll{it.status.id == 2}),'optionKey':("id"),'optionValue':("name"),'value':(loanInstance?.interestIncomeScheme?.id ?: params?.interestIncomeScheme),'class':("many-to-one form-control"),'onchange':("updateForm()")],-1)
printHtmlPart(1)
invokeTag('select','g',3,['readonly':("true"),'id':("currentPenaltyScheme"),'name':("currentPenaltyScheme.id"),'from':(product?.penaltyIncomeSchemes?.findAll{it.status.id == 2}),'optionKey':("id"),'optionValue':("name"),'value':(loanInstance?.currentPenaltyScheme?.id ?: params?.currentPenaltyScheme),'class':("many-to-one form-control"),'onchange':("updateForm()")],-1)
printHtmlPart(2)
invokeTag('select','g',4,['readonly':("true"),'id':("pastDuePenaltyScheme"),'name':("pastDuePenaltyScheme.id"),'from':(product?.penaltyIncomeSchemes?.findAll{it.status.id == 2}),'optionKey':("id"),'optionValue':("name"),'value':(loanInstance?.pastDuePenaltyScheme?.id ?: params?.pastDuePenaltyScheme),'class':("many-to-one form-control")],-1)
printHtmlPart(3)
invokeTag('select','g',5,['readonly':("true"),'id':("amortizedChargeScheme"),'name':("amortizedChargeScheme.id"),'from':(product?.amortizedChargeSchemes?.findAll{it.status.id == 2}),'optionKey':("id"),'optionValue':("name"),'value':(loanInstance?.amortizedChargeScheme?.id ?: params?.amortizedChargeScheme),'class':("many-to-one form-control"),'onchange':("updateForm()")],-1)
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
