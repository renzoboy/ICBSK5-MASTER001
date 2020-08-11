import icbs.deposit.FixedDepositPreTermScheme
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_fixedDepositPreTermScheme_form_basic_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/fixedDepositPreTermScheme/form/_basic.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: fixedDepositPreTermSchemeInstance, field: 'code', 'has-error'))
printHtmlPart(1)
invokeTag('message','g',8,['code':("fixedDepositPreTermScheme.code.label"),'default':("Code")],-1)
printHtmlPart(2)
invokeTag('textField','g',11,['name':("code"),'maxlength':("10"),'required':(""),'value':(fixedDepositPreTermSchemeInstance?.code),'class':("form-control")],-1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(5)
invokeTag('message','g',17,['error':(it)],-1)
printHtmlPart(6)
})
invokeTag('eachError','g',18,['bean':(fixedDepositPreTermSchemeInstance),'field':("code")],2)
printHtmlPart(7)
})
invokeTag('hasErrors','g',21,['bean':(fixedDepositPreTermSchemeInstance),'field':("code")],1)
printHtmlPart(8)
expressionOut.print(hasErrors(bean: fixedDepositPreTermSchemeInstance, field: 'name', 'has-error'))
printHtmlPart(9)
invokeTag('message','g',27,['code':("fixedDepositPreTermScheme.name.label"),'default':("Name")],-1)
printHtmlPart(2)
invokeTag('textField','g',30,['name':("name"),'maxlength':("50"),'value':(fixedDepositPreTermSchemeInstance?.name),'class':("form-control")],-1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(5)
invokeTag('message','g',36,['error':(it)],-1)
printHtmlPart(6)
})
invokeTag('eachError','g',37,['bean':(fixedDepositPreTermSchemeInstance),'field':("name")],2)
printHtmlPart(7)
})
invokeTag('hasErrors','g',40,['bean':(fixedDepositPreTermSchemeInstance),'field':("name")],1)
printHtmlPart(8)
expressionOut.print(hasErrors(bean: fixedDepositPreTermSchemeInstance, field: 'description', 'has-error'))
printHtmlPart(10)
invokeTag('message','g',46,['code':("fixedDepositPreTermScheme.description.label"),'default':("Description")],-1)
printHtmlPart(11)
invokeTag('textArea','g',49,['name':("description"),'cols':("40"),'rows':("5"),'maxlength':("255"),'value':(fixedDepositPreTermSchemeInstance?.description),'class':("form-control")],-1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(5)
invokeTag('message','g',55,['error':(it)],-1)
printHtmlPart(6)
})
invokeTag('eachError','g',56,['bean':(fixedDepositPreTermSchemeInstance),'field':("description")],2)
printHtmlPart(7)
})
invokeTag('hasErrors','g',59,['bean':(fixedDepositPreTermSchemeInstance),'field':("description")],1)
printHtmlPart(12)
expressionOut.print(hasErrors(bean: fixedDepositPreTermSchemeInstance, field: 'type', 'has-error'))
printHtmlPart(13)
invokeTag('message','g',66,['code':("fixedDepositPreTermScheme.type.label"),'default':("Type")],-1)
printHtmlPart(2)
invokeTag('select','g',69,['id':("type"),'name':("type.id"),'from':(icbs.lov.FdPreTerminationType.list()),'optionKey':("id"),'optionValue':("description"),'required':(""),'value':(fixedDepositPreTermSchemeInstance?.type?.id),'class':("many-to-one form-control")],-1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(5)
invokeTag('message','g',75,['error':(it)],-1)
printHtmlPart(6)
})
invokeTag('eachError','g',76,['bean':(fixedDepositPreTermSchemeInstance),'field':("type")],2)
printHtmlPart(7)
})
invokeTag('hasErrors','g',79,['bean':(fixedDepositPreTermSchemeInstance),'field':("type")],1)
printHtmlPart(12)
expressionOut.print(hasErrors(bean: fixedDepositPreTermSchemeInstance, field: 'rate', 'has-error'))
printHtmlPart(14)
invokeTag('message','g',86,['code':("fixedDepositPreTermScheme.rate.label"),'default':("Rate")],-1)
printHtmlPart(2)
invokeTag('field','g',89,['name':("rate"),'value':(fieldValue(bean: fixedDepositPreTermSchemeInstance, field: 'rate')),'required':(""),'class':("form-control")],-1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(5)
invokeTag('message','g',95,['error':(it)],-1)
printHtmlPart(6)
})
invokeTag('eachError','g',96,['bean':(fixedDepositPreTermSchemeInstance),'field':("rate")],2)
printHtmlPart(7)
})
invokeTag('hasErrors','g',99,['bean':(fixedDepositPreTermSchemeInstance),'field':("rate")],1)
printHtmlPart(12)
expressionOut.print(hasErrors(bean: fixedDepositPreTermSchemeInstance, field: 'term1stHalf', 'has-error'))
printHtmlPart(15)
invokeTag('message','g',106,['code':("fixedDepositPreTermScheme.term1stHalf.label"),'default':("Term1st Half")],-1)
printHtmlPart(2)
invokeTag('field','g',109,['name':("term1stHalf"),'value':(fieldValue(bean: fixedDepositPreTermSchemeInstance, field: 'term1stHalf')),'required':(""),'class':("form-control")],-1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(5)
invokeTag('message','g',115,['error':(it)],-1)
printHtmlPart(6)
})
invokeTag('eachError','g',116,['bean':(fixedDepositPreTermSchemeInstance),'field':("term1stHalf")],2)
printHtmlPart(7)
})
invokeTag('hasErrors','g',119,['bean':(fixedDepositPreTermSchemeInstance),'field':("term1stHalf")],1)
printHtmlPart(12)
expressionOut.print(hasErrors(bean: fixedDepositPreTermSchemeInstance, field: 'term2ndHalf', 'has-error'))
printHtmlPart(16)
invokeTag('message','g',126,['code':("fixedDepositPreTermScheme.term2ndHalf.label"),'default':("Term2nd Half")],-1)
printHtmlPart(2)
invokeTag('field','g',129,['name':("term2ndHalf"),'value':(fieldValue(bean: fixedDepositPreTermSchemeInstance, field: 'term2ndHalf')),'required':(""),'class':("form-control")],-1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(5)
invokeTag('message','g',135,['error':(it)],-1)
printHtmlPart(6)
})
invokeTag('eachError','g',136,['bean':(fixedDepositPreTermSchemeInstance),'field':("term2ndHalf")],2)
printHtmlPart(7)
})
invokeTag('hasErrors','g',139,['bean':(fixedDepositPreTermSchemeInstance),'field':("term2ndHalf")],1)
printHtmlPart(12)
expressionOut.print(hasErrors(bean: fixedDepositPreTermSchemeInstance, field: 'divisor', 'has-error'))
printHtmlPart(17)
invokeTag('message','g',146,['code':("fixedDepositPreTermScheme.divisor.label"),'default':("Divisor")],-1)
printHtmlPart(2)
invokeTag('field','g',149,['name':("divisor"),'type':("number"),'value':(fixedDepositPreTermSchemeInstance.divisor),'required':(""),'class':("form-control")],-1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(5)
invokeTag('message','g',155,['error':(it)],-1)
printHtmlPart(6)
})
invokeTag('eachError','g',156,['bean':(fixedDepositPreTermSchemeInstance),'field':("divisor")],2)
printHtmlPart(7)
})
invokeTag('hasErrors','g',159,['bean':(fixedDepositPreTermSchemeInstance),'field':("divisor")],1)
printHtmlPart(18)
if(true && (fixedDepositPreTermSchemeInstance?.id)) {
printHtmlPart(19)
expressionOut.print(hasErrors(bean: fixedDepositPreTermSchemeInstance, field: 'status', 'has-error'))
printHtmlPart(20)
invokeTag('message','g',166,['code':("fixedDepositPreTermScheme.status.label"),'default':("Status")],-1)
printHtmlPart(21)
invokeTag('select','g',169,['id':("status"),'name':("status.id"),'from':(icbs.lov.ConfigItemStatus.list()),'optionKey':("id"),'optionValue':("description"),'value':(fixedDepositPreTermSchemeInstance?.status?.id),'class':("many-to-one form-control"),'noSelection':(['null': ''])],-1)
printHtmlPart(22)
createTagBody(2, {->
printHtmlPart(23)
createTagBody(3, {->
printHtmlPart(24)
invokeTag('message','g',175,['error':(it)],-1)
printHtmlPart(25)
})
invokeTag('eachError','g',176,['bean':(fixedDepositPreTermSchemeInstance),'field':("status")],3)
printHtmlPart(26)
})
invokeTag('hasErrors','g',179,['bean':(fixedDepositPreTermSchemeInstance),'field':("status")],2)
printHtmlPart(27)
}
printHtmlPart(28)
expressionOut.print(hasErrors(bean: fixedDepositPreTermSchemeInstance, field: 'isGradeRate', 'has-error'))
printHtmlPart(29)
invokeTag('message','g',186,['code':("fixedDepositPreTermScheme.isGradeRate.label"),'default':("Is Grade Rate")],-1)
printHtmlPart(11)
invokeTag('checkBox','g',189,['name':("isGradeRate"),'class':(""),'value':(fixedDepositPreTermSchemeInstance?.isGradeRate)],-1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(5)
invokeTag('message','g',195,['error':(it)],-1)
printHtmlPart(6)
})
invokeTag('eachError','g',196,['bean':(fixedDepositPreTermSchemeInstance),'field':("isGradeRate")],2)
printHtmlPart(7)
})
invokeTag('hasErrors','g',199,['bean':(fixedDepositPreTermSchemeInstance),'field':("isGradeRate")],1)
printHtmlPart(30)
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
