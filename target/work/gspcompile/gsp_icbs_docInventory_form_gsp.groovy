import icbs.deposit.DocInventory
import icbs.lov.DocInventoryType
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_docInventory_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/docInventory/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
expressionOut.print(hasErrors(bean: docInventoryInstance, field: 'type', 'has-error'))
printHtmlPart(2)
invokeTag('message','g',6,['code':("docInventory.type.label"),'default':("Doc Inventory Type")],-1)
printHtmlPart(3)
invokeTag('select','g',9,['disabled':(readonly),'id':("type"),'name':("type.id"),'from':(icbs.lov.DocInventoryType.list()),'optionKey':("id"),'optionValue':("description"),'required':(""),'value':(docInventoryInstance?.type?.id),'class':("many-to-one form-control")],-1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(6)
invokeTag('message','g',15,['error':(it)],-1)
printHtmlPart(7)
})
invokeTag('eachError','g',16,['bean':(docInventoryInstance),'field':("type")],2)
printHtmlPart(8)
})
invokeTag('hasErrors','g',19,['bean':(docInventoryInstance),'field':("type")],1)
printHtmlPart(9)
expressionOut.print(hasErrors(bean: docInventoryInstance, field: 'seriesStart', 'has-error'))
printHtmlPart(10)
invokeTag('message','g',24,['code':("docInventory.seriesStart.label"),'default':("Series Start")],-1)
printHtmlPart(3)
invokeTag('textField','g',27,['name':("seriesStart"),'id':("seriesStart"),'required':(""),'value':(docInventoryInstance?.seriesStart),'class':("form-control")],-1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(6)
invokeTag('message','g',33,['error':(it)],-1)
printHtmlPart(7)
})
invokeTag('eachError','g',34,['bean':(docInventoryInstance),'field':("seriesStart")],2)
printHtmlPart(8)
})
invokeTag('hasErrors','g',37,['bean':(docInventoryInstance),'field':("seriesStart")],1)
printHtmlPart(9)
expressionOut.print(hasErrors(bean: docInventoryInstance, field: 'seriesEnd', 'has-error'))
printHtmlPart(11)
invokeTag('message','g',42,['code':("docInventory.seriesEnd.label"),'default':("Series End")],-1)
printHtmlPart(3)
invokeTag('textField','g',45,['name':("seriesEnd"),'id':("seriesEnd"),'required':(""),'value':(docInventoryInstance?.seriesEnd),'class':("form-control")],-1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(6)
invokeTag('message','g',51,['error':(it)],-1)
printHtmlPart(7)
})
invokeTag('eachError','g',52,['bean':(docInventoryInstance),'field':("seriesEnd")],2)
printHtmlPart(8)
})
invokeTag('hasErrors','g',55,['bean':(docInventoryInstance),'field':("seriesEnd")],1)
printHtmlPart(9)
expressionOut.print(hasErrors(bean: docInventoryInstance, field: 'docParticulars', 'has-error'))
printHtmlPart(12)
invokeTag('message','g',60,['code':("docInventory.docParticulars.label"),'default':("Particulars")],-1)
printHtmlPart(13)
invokeTag('textArea','g',62,['name':("docParticulars"),'id':("docParticulars"),'required':(""),'value':(docInventoryInstance?.docParticulars),'class':("form-control"),'rows':("5"),'cols':("40")],-1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(6)
invokeTag('message','g',68,['error':(it)],-1)
printHtmlPart(7)
})
invokeTag('eachError','g',69,['bean':(docInventoryInstance),'field':("docParticulars")],2)
printHtmlPart(8)
})
invokeTag('hasErrors','g',72,['bean':(docInventoryInstance),'field':("docParticulars")],1)
printHtmlPart(9)
expressionOut.print(hasErrors(bean: docInventoryInstance, field: 'checkAcctNo', 'has-error'))
printHtmlPart(14)
invokeTag('message','g',77,['code':("docInventory.checkAcctNo.label"),'default':("Account Number (for checks)")],-1)
printHtmlPart(13)
invokeTag('textField','g',79,['name':("checkAcctNo"),'id':("checkAcctNo"),'required':(""),'value':(docInventoryInstance?.checkAcctNo),'class':("form-control")],-1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(6)
invokeTag('message','g',85,['error':(it)],-1)
printHtmlPart(7)
})
invokeTag('eachError','g',86,['bean':(docInventoryInstance),'field':("checkAcctNo")],2)
printHtmlPart(8)
})
invokeTag('hasErrors','g',89,['bean':(docInventoryInstance),'field':("checkAcctNo")],1)
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
