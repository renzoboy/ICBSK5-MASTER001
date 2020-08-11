import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_ropa_ropaTransfer_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/ropa/ropaTransfer/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: transferToRopaInstance, field: 'marketValueLand', 'has-error'))
printHtmlPart(1)
invokeTag('message','g',5,['code':("RopaTransfer.marketValueLand.label"),'default':("Appraised Value Land")],-1)
printHtmlPart(2)
invokeTag('field','g',7,['name':("marketValueLand"),'id':("marketValueLand"),'value':(""),'class':("form-control truncated")],-1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(5)
invokeTag('message','g',13,['error':(it)],-1)
printHtmlPart(6)
})
invokeTag('eachError','g',14,['bean':(transferToRopaInstance),'field':("marketValueLand")],2)
printHtmlPart(7)
})
invokeTag('hasErrors','g',17,['bean':(transferToRopaInstance),'field':("marketValueLand")],1)
printHtmlPart(8)
expressionOut.print(hasErrors(bean: transferToRopaInstance, field: 'marketValueBuilding', 'has-error'))
printHtmlPart(9)
invokeTag('message','g',23,['code':("RopaTransfer.marketValueBuilding.label"),'default':("Appraised Value Building")],-1)
printHtmlPart(2)
invokeTag('field','g',25,['name':("marketValueBuilding"),'id':("marketValueBuilding"),'value':(""),'class':("form-control truncated")],-1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(5)
invokeTag('message','g',31,['error':(it)],-1)
printHtmlPart(6)
})
invokeTag('eachError','g',32,['bean':(transferToRopaInstance),'field':("marketValueBuilding")],2)
printHtmlPart(7)
})
invokeTag('hasErrors','g',35,['bean':(transferToRopaInstance),'field':("marketValueBuilding")],1)
printHtmlPart(10)
expressionOut.print(hasErrors(bean: transferToRopaInstance, field: 'otherPropertiesAcquired', 'has-error'))
printHtmlPart(11)
invokeTag('message','g',40,['code':("RopaTransfer.otherPropertiesAcquired.label"),'default':("Appraised of Other Properties Acquired")],-1)
printHtmlPart(2)
invokeTag('field','g',42,['name':("otherPropertiesAcquired"),'id':("otherPropertiesAcquired"),'value':(""),'class':("form-control truncated")],-1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(5)
invokeTag('message','g',48,['error':(it)],-1)
printHtmlPart(6)
})
invokeTag('eachError','g',49,['bean':(transferToRopaInstance),'field':("otherPropertiesAcquired")],2)
printHtmlPart(7)
})
invokeTag('hasErrors','g',52,['bean':(transferToRopaInstance),'field':("otherPropertiesAcquired")],1)
printHtmlPart(8)
expressionOut.print(hasErrors(bean: txnTemplateInstance, field: 'txnType', 'has-error'))
printHtmlPart(12)
invokeTag('select','g',59,['id':("txnType"),'name':("txnType"),'from':(icbs.admin.TxnTemplate.findAllByTxnType(icbs.lov.TxnType.read(38))),'optionKey':("id"),'optionValue':("description"),'required':(""),'value':(""),'onchange':("getcode();"),'class':("many-to-one form-control")],-1)
printHtmlPart(13)
expressionOut.print(hasErrors(bean: transferToRopaInstance, field: 'reference', 'has-error'))
printHtmlPart(14)
invokeTag('textField','g',64,['id':("reference"),'name':("reference"),'value':(""),'class':("form-control")],-1)
printHtmlPart(15)
createTagBody(1, {->
printHtmlPart(16)
createTagBody(2, {->
printHtmlPart(17)
invokeTag('message','g',69,['error':(it)],-1)
printHtmlPart(18)
})
invokeTag('eachError','g',70,['bean':(transferToRopaInstance),'field':("reference")],2)
printHtmlPart(19)
})
invokeTag('hasErrors','g',73,['bean':(transferToRopaInstance),'field':("reference")],1)
printHtmlPart(13)
expressionOut.print(hasErrors(bean: transferToRopaInstance, field: 'particulars', 'has-error'))
printHtmlPart(20)
invokeTag('textField','g',78,['id':("particulars"),'name':("particulars"),'value':(""),'class':("form-control")],-1)
printHtmlPart(15)
createTagBody(1, {->
printHtmlPart(16)
createTagBody(2, {->
printHtmlPart(17)
invokeTag('message','g',83,['error':(it)],-1)
printHtmlPart(18)
})
invokeTag('eachError','g',84,['bean':(transferToRopaInstance),'field':("particulars")],2)
printHtmlPart(19)
})
invokeTag('hasErrors','g',87,['bean':(transferToRopaInstance),'field':("particulars")],1)
printHtmlPart(21)
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
