import icbs.lov.LoanInstallmentFreq
import icbs.cif.Customer
import icbs.loans.InterestIncomeScheme
import icbs.loans.LoanApplication
import icbs.lov.ConfigItemStatus
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_loanProposal_specification_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/loanProposal/_specification.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(0)
printHtmlPart(0)
printHtmlPart(0)
printHtmlPart(1)
invokeTag('select','g',14,['name':("interestIncomeScheme"),'from':(InterestIncomeScheme.findAllByStatus(ConfigItemStatus.get(2))),'optionKey':("id"),'optionValue':("name"),'value':(""),'class':("many-to-one form-control"),'onchange':("updateForm()")],-1)
printHtmlPart(2)
invokeTag('field','g',23,['name':("amount"),'value':(""),'required':(""),'class':("form-control truncated"),'onkeyup':("updateInstallmentAmount()")],-1)
printHtmlPart(3)
invokeTag('field','g',32,['name':("interestRate"),'value':(""),'required':(""),'class':("form-control"),'onchange':("updateInstallmentAmount()")],-1)
printHtmlPart(4)
invokeTag('field','g',41,['name':("term"),'type':("number"),'value':(""),'required':(""),'class':("form-control")],-1)
printHtmlPart(5)
invokeTag('select','g',50,['name':("frequency"),'from':(LoanInstallmentFreq.list()),'optionKey':("id"),'optionValue':("description"),'value':(""),'class':("many-to-one form-control"),'onchange':("updateInstallmentAmount()")],-1)
printHtmlPart(6)
invokeTag('field','g',59,['name':("numInstallments"),'type':("number"),'value':(""),'required':(""),'class':("form-control"),'onkeyup':("updateInstallmentAmount()")],-1)
printHtmlPart(7)
invokeTag('field','g',68,['name':("installmentAmount"),'value':(""),'required':(""),'class':("form-control")],-1)
printHtmlPart(8)
invokeTag('field','g',77,['name':("balloonInstallments"),'type':("number"),'value':(""),'required':(""),'class':("form-control")],-1)
printHtmlPart(9)
invokeTag('customDatePicker','g',86,['name':("openingDate"),'precision':("day"),'class':("form-control"),'value':("")],-1)
printHtmlPart(10)
invokeTag('customDatePicker','g',95,['name':("interestStartDate"),'precision':("day"),'class':("form-control"),'value':("")],-1)
printHtmlPart(11)
invokeTag('customDatePicker','g',104,['name':("firstInstallmentDate"),'precision':("day"),'class':("form-control"),'value':("")],-1)
printHtmlPart(12)
invokeTag('customDatePicker','g',118,['name':("installmentDate"),'precision':("day"),'class':("form-control")],-1)
printHtmlPart(13)
invokeTag('field','g',127,['name':("principalAmount"),'class':("form-control"),'value':("")],-1)
printHtmlPart(14)
invokeTag('field','g',136,['name':("interestAmount"),'class':("form-control"),'value':("")],-1)
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
