import icbs.deposit.FixedDepositTermScheme
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_fixedDepositTermScheme_form_basic_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/fixedDepositTermScheme/form/_basic.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: fixedDepositTermSchemeInstance, field: 'code', 'has-error'))
printHtmlPart(1)
invokeTag('message','g',8,['code':("fixedDepositTermScheme.code.label"),'default':("Code")],-1)
printHtmlPart(2)
invokeTag('textField','g',11,['name':("code"),'maxlength':("10"),'required':(""),'value':(fixedDepositTermSchemeInstance?.code),'class':("form-control")],-1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(5)
invokeTag('message','g',17,['error':(it)],-1)
printHtmlPart(6)
})
invokeTag('eachError','g',18,['bean':(fixedDepositTermSchemeInstance),'field':("code")],2)
printHtmlPart(7)
})
invokeTag('hasErrors','g',21,['bean':(fixedDepositTermSchemeInstance),'field':("code")],1)
printHtmlPart(8)
expressionOut.print(hasErrors(bean: fixedDepositTermSchemeInstance, field: 'name', 'has-error'))
printHtmlPart(9)
invokeTag('message','g',26,['code':("fixedDepositTermScheme.name.label"),'default':("Name")],-1)
printHtmlPart(2)
invokeTag('textField','g',29,['name':("name"),'maxlength':("50"),'value':(fixedDepositTermSchemeInstance?.name),'class':("form-control")],-1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(5)
invokeTag('message','g',35,['error':(it)],-1)
printHtmlPart(6)
})
invokeTag('eachError','g',36,['bean':(fixedDepositTermSchemeInstance),'field':("name")],2)
printHtmlPart(7)
})
invokeTag('hasErrors','g',39,['bean':(fixedDepositTermSchemeInstance),'field':("name")],1)
printHtmlPart(10)
expressionOut.print(hasErrors(bean: fixedDepositTermSchemeInstance, field: 'description', 'has-error'))
printHtmlPart(11)
invokeTag('message','g',45,['code':("fixedDepositTermScheme.description.label"),'default':("Description")],-1)
printHtmlPart(12)
invokeTag('textArea','g',48,['name':("description"),'cols':("40"),'rows':("5"),'maxlength':("255"),'value':(fixedDepositTermSchemeInstance?.description),'class':("form-control")],-1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(5)
invokeTag('message','g',54,['error':(it)],-1)
printHtmlPart(6)
})
invokeTag('eachError','g',55,['bean':(fixedDepositTermSchemeInstance),'field':("description")],2)
printHtmlPart(7)
})
invokeTag('hasErrors','g',58,['bean':(fixedDepositTermSchemeInstance),'field':("description")],1)
printHtmlPart(13)
expressionOut.print(hasErrors(bean: fixedDepositTermSchemeInstance, field: 'value', 'has-error'))
printHtmlPart(14)
invokeTag('message','g',65,['code':("fixedDepositTermScheme.value.label"),'default':("Value")],-1)
printHtmlPart(2)
invokeTag('textField','g',68,['name':("value"),'maxlength':("50"),'required':(""),'value':(fixedDepositTermSchemeInstance?.value),'class':("form-control truncated")],-1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(5)
invokeTag('message','g',74,['error':(it)],-1)
printHtmlPart(6)
})
invokeTag('eachError','g',75,['bean':(fixedDepositTermSchemeInstance),'field':("value")],2)
printHtmlPart(7)
})
invokeTag('hasErrors','g',78,['bean':(fixedDepositTermSchemeInstance),'field':("value")],1)
printHtmlPart(13)
expressionOut.print(hasErrors(bean: fixedDepositTermSchemeInstance, field: 'termMin', 'has-error'))
printHtmlPart(15)
invokeTag('message','g',85,['code':("fixedDepositTermScheme.termMin.label"),'default':("Term Min")],-1)
printHtmlPart(2)
invokeTag('field','g',88,['name':("termMin"),'value':(fieldValue(bean: fixedDepositTermSchemeInstance, field: 'termMin')),'required':(""),'class':("form-control")],-1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(5)
invokeTag('message','g',94,['error':(it)],-1)
printHtmlPart(6)
})
invokeTag('eachError','g',95,['bean':(fixedDepositTermSchemeInstance),'field':("termMin")],2)
printHtmlPart(7)
})
invokeTag('hasErrors','g',98,['bean':(fixedDepositTermSchemeInstance),'field':("termMin")],1)
printHtmlPart(13)
expressionOut.print(hasErrors(bean: fixedDepositTermSchemeInstance, field: 'termMax', 'has-error'))
printHtmlPart(16)
invokeTag('message','g',105,['code':("fixedDepositTermScheme.termMax.label"),'default':("Term Max")],-1)
printHtmlPart(2)
invokeTag('field','g',108,['name':("termMax"),'value':(fieldValue(bean: fixedDepositTermSchemeInstance, field: 'termMax')),'required':(""),'class':("form-control")],-1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(5)
invokeTag('message','g',114,['error':(it)],-1)
printHtmlPart(6)
})
invokeTag('eachError','g',115,['bean':(fixedDepositTermSchemeInstance),'field':("termMax")],2)
printHtmlPart(7)
})
invokeTag('hasErrors','g',118,['bean':(fixedDepositTermSchemeInstance),'field':("termMax")],1)
printHtmlPart(17)
if(true && (fixedDepositTermSchemeInstance?.id)) {
printHtmlPart(18)
expressionOut.print(hasErrors(bean: fixedDepositTermSchemeInstance, field: 'status', 'has-error'))
printHtmlPart(19)
invokeTag('message','g',125,['code':("fixedDepositTermScheme.status.label"),'default':("Status")],-1)
printHtmlPart(20)
invokeTag('select','g',128,['id':("status"),'name':("status.id"),'from':(icbs.lov.ConfigItemStatus.list()),'optionKey':("id"),'optionValue':("description"),'value':(fixedDepositTermSchemeInstance?.status?.id),'class':("many-to-one form-control"),'noSelection':(['null': ''])],-1)
printHtmlPart(21)
createTagBody(2, {->
printHtmlPart(22)
createTagBody(3, {->
printHtmlPart(23)
invokeTag('message','g',134,['error':(it)],-1)
printHtmlPart(24)
})
invokeTag('eachError','g',135,['bean':(fixedDepositTermSchemeInstance),'field':("status")],3)
printHtmlPart(25)
})
invokeTag('hasErrors','g',138,['bean':(fixedDepositTermSchemeInstance),'field':("status")],2)
printHtmlPart(26)
}
printHtmlPart(27)
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
