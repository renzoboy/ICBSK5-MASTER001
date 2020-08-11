import icbs.gl.GlBatch
import icbs.admin.Branch
import icbs.admin.UserMaster
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_glBatch_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/glBatch/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(0)
printHtmlPart(1)
if(true && (session["postedOnOff"]=="postedOn")) {
printHtmlPart(2)
}
else {
printHtmlPart(3)
}
printHtmlPart(4)
if(true && (session["postedOnOff"]=="postedOn")) {
printHtmlPart(5)
invokeTag('customDatePicker','g',23,['value':(Branch?.get(1).runDate),'id':("valueDate"),'name':("newValueDate"),'precision':("day"),'class':("form-control"),'default':("none"),'noSelection':(['': '']),'disabled':("disabled")],-1)
printHtmlPart(6)
}
else {
printHtmlPart(7)
invokeTag('customDatePicker','g',26,['value':(Branch?.get(1).runDate),'id':("valueDate"),'name':("newValueDate"),'precision':("day"),'class':("form-control"),'default':("none"),'noSelection':(['': ''])],-1)
printHtmlPart(6)
}
printHtmlPart(8)
if(true && (session["postedOnOff"]=="postedOn")) {
printHtmlPart(5)
invokeTag('select','g',36,['id':("template"),'name':("template.id"),'from':(icbs.gl.GlBatchTemplate.list()),'optionKey':("id"),'optionValue':("description"),'class':("many-to-one form-control"),'noSelection':(['null': '']),'v-model':("newTemplate"),'disabled':("disabled")],-1)
printHtmlPart(9)
}
else {
printHtmlPart(5)
invokeTag('select','g',39,['id':("template"),'name':("template.id"),'from':(icbs.gl.GlBatchTemplate.list()),'optionKey':("id"),'optionValue':("description"),'class':("many-to-one form-control"),'noSelection':(['null': '']),'v-model':("newTemplate")],-1)
printHtmlPart(6)
}
printHtmlPart(10)
if(true && (session["postedOnOff"]=="postedOn")) {
printHtmlPart(11)
}
else {
printHtmlPart(12)
}
printHtmlPart(13)
if(true && (session["postedOnOff"]=="postedOn")) {
printHtmlPart(14)
invokeTag('select','g',62,['id':("branch"),'name':("branch.id"),'from':(icbs.admin.Branch.findAll{status.id == 2}),'optionKey':("id"),'optionValue':("name"),'class':("many-to-one form-control"),'noSelection':(['null': '']),'v-model':("branch")],-1)
printHtmlPart(15)
invokeTag('select','g',63,['id':("branch"),'name':("branch.id"),'from':(icbs.admin.Branch.findAll{status.id == 2}),'value':(session.branch_id),'optionKey':("id"),'optionValue':("name"),'class':("many-to-one form-control"),'noSelection':(['null': '']),'v-model':("branch"),'disabled':("disabled")],-1)
printHtmlPart(6)
}
else {
printHtmlPart(7)
invokeTag('select','g',66,['id':("branch"),'name':("branch.id"),'from':(icbs.admin.Branch.findAll{status.id == 2}),'value':(session.branch_id),'optionKey':("id"),'optionValue':("name"),'class':("many-to-one form-control"),'noSelection':(['null': '']),'v-model':("branch")],-1)
printHtmlPart(6)
}
printHtmlPart(16)
invokeTag('hiddenField','g',76,['name':("glBatchLoan"),'id':("glBatchLoanHidden"),'v-model':("newLoans")],-1)
printHtmlPart(17)
if(true && (session["postedOnOff"]=="postedOn")) {
printHtmlPart(18)
invokeTag('select','g',95,['id':("currency"),'name':("currency.id"),'from':(icbs.admin.Currency.findAll{configItemStatus.id == 2}),'optionKey':("id"),'optionValue':("name"),'value':(glAccountInstance?.currency?.id),'class':("many-to-one form-control"),'noSelection':(['null': '']),'v-model':("newCurrency"),'disabled':("disabled")],-1)
printHtmlPart(18)
}
else {
printHtmlPart(7)
invokeTag('select','g',99,['id':("currency"),'name':("currency.id"),'from':(icbs.admin.Currency.findAll{configItemStatus.id == 2}),'optionKey':("id"),'optionValue':("name"),'value':(glAccountInstance?.currency?.id),'class':("many-to-one form-control"),'noSelection':(['null': '']),'v-model':("newCurrency")],-1)
printHtmlPart(9)
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
