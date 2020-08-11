import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_ropa_chattel_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/ropa/chattel/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: chattelInstance, field: 'identificationNo', 'has-error'))
printHtmlPart(1)
invokeTag('field','g',7,['name':("identificationNo"),'value':(chattelInstance?.identificationNo),'class':("form-control")],-1)
printHtmlPart(2)
createTagBody(1, {->
printHtmlPart(3)
createTagBody(2, {->
printHtmlPart(4)
invokeTag('message','g',12,['error':(it)],-1)
printHtmlPart(5)
})
invokeTag('eachError','g',13,['bean':(chattelInstance),'field':("identificationNo")],2)
printHtmlPart(6)
})
invokeTag('hasErrors','g',16,['bean':(chattelInstance),'field':("identificationNo")],1)
printHtmlPart(7)
expressionOut.print(hasErrors(bean: chattelInstance, field: 'acquisitionCost', 'has-error'))
printHtmlPart(8)
invokeTag('field','g',26,['name':("acquisitionCost"),'value':(chattelInstance?.acquisitionCost),'class':("form-control")],-1)
printHtmlPart(9)
createTagBody(1, {->
printHtmlPart(3)
createTagBody(2, {->
printHtmlPart(4)
invokeTag('message','g',31,['error':(it)],-1)
printHtmlPart(5)
})
invokeTag('eachError','g',32,['bean':(chattelInstance),'field':("acquisitionCost")],2)
printHtmlPart(6)
})
invokeTag('hasErrors','g',35,['bean':(chattelInstance),'field':("acquisitionCost")],1)
printHtmlPart(10)
expressionOut.print(hasErrors(bean: chattelInstance, field: 'acquisitionDate', 'has-error'))
printHtmlPart(11)
invokeTag('customDatePicker','g',45,['name':("acquisitionDate"),'precision':("day"),'class':("form-control"),'value':(chattelInstance?.acquisitionDate)],-1)
printHtmlPart(12)
createTagBody(1, {->
printHtmlPart(3)
createTagBody(2, {->
printHtmlPart(4)
invokeTag('message','g',51,['error':(it)],-1)
printHtmlPart(5)
})
invokeTag('eachError','g',52,['bean':(chattelInstance),'field':("acquisitionDate")],2)
printHtmlPart(6)
})
invokeTag('hasErrors','g',55,['bean':(chattelInstance),'field':("acquisitionDate")],1)
printHtmlPart(13)
expressionOut.print(hasErrors(bean: chattelInstance, field: 'insuranceType', 'has-error'))
printHtmlPart(14)
invokeTag('field','g',64,['name':("insuranceType"),'value':(chattelInstance?.insuranceType),'class':("form-control")],-1)
printHtmlPart(9)
createTagBody(1, {->
printHtmlPart(3)
createTagBody(2, {->
printHtmlPart(4)
invokeTag('message','g',69,['error':(it)],-1)
printHtmlPart(5)
})
invokeTag('eachError','g',70,['bean':(chattelInstance),'field':("insuranceType")],2)
printHtmlPart(6)
})
invokeTag('hasErrors','g',73,['bean':(chattelInstance),'field':("insuranceType")],1)
printHtmlPart(10)
expressionOut.print(hasErrors(bean: chattelInstance, field: 'orNo', 'has-error'))
printHtmlPart(15)
invokeTag('field','g',82,['name':("orNo"),'value':(chattelInstance?.insuranceType),'class':("form-control")],-1)
printHtmlPart(9)
createTagBody(1, {->
printHtmlPart(3)
createTagBody(2, {->
printHtmlPart(4)
invokeTag('message','g',87,['error':(it)],-1)
printHtmlPart(5)
})
invokeTag('eachError','g',88,['bean':(chattelInstance),'field':("orNo")],2)
printHtmlPart(6)
})
invokeTag('hasErrors','g',91,['bean':(chattelInstance),'field':("orNo")],1)
printHtmlPart(10)
expressionOut.print(hasErrors(bean: chattelInstance, field: 'orDate', 'has-error'))
printHtmlPart(16)
invokeTag('customDatePicker','g',100,['name':("orDate"),'precision':("day"),'class':("form-control"),'value':(chattelInstance?.orDate)],-1)
printHtmlPart(12)
createTagBody(1, {->
printHtmlPart(3)
createTagBody(2, {->
printHtmlPart(4)
invokeTag('message','g',106,['error':(it)],-1)
printHtmlPart(5)
})
invokeTag('eachError','g',107,['bean':(chattelInstance),'field':("orDate")],2)
printHtmlPart(6)
})
invokeTag('hasErrors','g',110,['bean':(chattelInstance),'field':("orDate")],1)
printHtmlPart(13)
expressionOut.print(hasErrors(bean: chattelInstance, field: 'crNo', 'has-error'))
printHtmlPart(17)
invokeTag('field','g',119,['name':("crNo"),'value':(chattelInstance?.crNo),'class':("form-control")],-1)
printHtmlPart(9)
createTagBody(1, {->
printHtmlPart(3)
createTagBody(2, {->
printHtmlPart(4)
invokeTag('message','g',124,['error':(it)],-1)
printHtmlPart(5)
})
invokeTag('eachError','g',125,['bean':(chattelInstance),'field':("crNo")],2)
printHtmlPart(6)
})
invokeTag('hasErrors','g',128,['bean':(chattelInstance),'field':("crNo")],1)
printHtmlPart(10)
expressionOut.print(hasErrors(bean: chattelInstance, field: 'crDate', 'has-error'))
printHtmlPart(18)
invokeTag('customDatePicker','g',137,['name':("crDate"),'precision':("day"),'class':("form-control"),'value':(chattelInstance?.crDate)],-1)
printHtmlPart(12)
createTagBody(1, {->
printHtmlPart(3)
createTagBody(2, {->
printHtmlPart(4)
invokeTag('message','g',143,['error':(it)],-1)
printHtmlPart(5)
})
invokeTag('eachError','g',144,['bean':(chattelInstance),'field':("crDate")],2)
printHtmlPart(6)
})
invokeTag('hasErrors','g',147,['bean':(chattelInstance),'field':("crDate")],1)
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
