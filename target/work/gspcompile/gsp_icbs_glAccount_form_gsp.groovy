import icbs.gl.GlAccount
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_glAccount_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/glAccount/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: glAccountInstance, field: 'type', 'has-error'))
printHtmlPart(1)
invokeTag('message','g',8,['code':("glAccount.type.label"),'default':("Type")],-1)
printHtmlPart(2)
invokeTag('select','g',11,['id':("type"),'name':("type.id"),'from':(icbs.lov.GlAcctType.list()),'optionKey':("id"),'value':(glAccountInstance?.type?.id),'class':("many-to-one form-control"),'noSelection':(['null': ''])],-1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(5)
invokeTag('message','g',17,['error':(it)],-1)
printHtmlPart(6)
})
invokeTag('eachError','g',18,['bean':(glAccountInstance),'field':("type")],2)
printHtmlPart(7)
})
invokeTag('hasErrors','g',21,['bean':(glAccountInstance),'field':("type")],1)
printHtmlPart(8)
expressionOut.print(hasErrors(bean: glAccountInstance, field: 'currency', 'has-error'))
printHtmlPart(9)
invokeTag('message','g',28,['code':("glAccount.currency.label"),'default':("Currency")],-1)
printHtmlPart(2)
invokeTag('select','g',31,['id':("currency"),'name':("currency.id"),'from':(icbs.admin.Currency.findAll{configItemStatus.id == 2}),'optionKey':("id"),'optionValue':("name"),'value':(glAccountInstance?.currency?.id),'class':("many-to-one form-control"),'noSelection':(['null': ''])],-1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(5)
invokeTag('message','g',37,['error':(it)],-1)
printHtmlPart(6)
})
invokeTag('eachError','g',38,['bean':(glAccountInstance),'field':("currency")],2)
printHtmlPart(7)
})
invokeTag('hasErrors','g',41,['bean':(glAccountInstance),'field':("currency")],1)
printHtmlPart(8)
expressionOut.print(hasErrors(bean: glAccountInstance, field: 'code', 'has-error'))
printHtmlPart(10)
invokeTag('message','g',48,['code':("glAccount.code.label"),'default':("Code")],-1)
printHtmlPart(11)
invokeTag('textField','g',51,['name':("code"),'required':(""),'value':(glAccountInstance?.code),'class':("form-control")],-1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(5)
invokeTag('message','g',57,['error':(it)],-1)
printHtmlPart(6)
})
invokeTag('eachError','g',58,['bean':(glAccountInstance),'field':("code")],2)
printHtmlPart(7)
})
invokeTag('hasErrors','g',61,['bean':(glAccountInstance),'field':("code")],1)
printHtmlPart(8)
expressionOut.print(hasErrors(bean: glAccountInstance, field: 'name', 'has-error'))
printHtmlPart(12)
invokeTag('message','g',68,['code':("glAccount.name.label"),'default':("Name")],-1)
printHtmlPart(11)
invokeTag('textField','g',71,['name':("name"),'required':(""),'value':(glAccountInstance?.name),'class':("form-control")],-1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(5)
invokeTag('message','g',77,['error':(it)],-1)
printHtmlPart(6)
})
invokeTag('eachError','g',78,['bean':(glAccountInstance),'field':("name")],2)
printHtmlPart(7)
})
invokeTag('hasErrors','g',81,['bean':(glAccountInstance),'field':("name")],1)
printHtmlPart(8)
expressionOut.print(hasErrors(bean: glAccountInstance, field: 'parent', 'has-error'))
printHtmlPart(13)
invokeTag('message','g',88,['code':("glAccount.parent.label"),'default':("Parent (Sort Code)")],-1)
printHtmlPart(14)
invokeTag('hiddenField','g',92,['name':("parent.id"),'id':("glSortCodeHidden"),'value':(glAccountInstance?.parent?.id)],-1)
printHtmlPart(15)
expressionOut.print(glAccountInstance?.parent?.sort_code)
printHtmlPart(16)
expressionOut.print(hasErrors(bean: glAccountInstance, field: 'shortName', 'has-error'))
printHtmlPart(17)
invokeTag('message','g',110,['code':("glAccount.shortName.label"),'default':("Short Name")],-1)
printHtmlPart(2)
invokeTag('textField','g',113,['name':("shortName"),'value':(glAccountInstance?.shortName),'class':("form-control")],-1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(5)
invokeTag('message','g',119,['error':(it)],-1)
printHtmlPart(6)
})
invokeTag('eachError','g',120,['bean':(glAccountInstance),'field':("shortName")],2)
printHtmlPart(7)
})
invokeTag('hasErrors','g',123,['bean':(glAccountInstance),'field':("shortName")],1)
printHtmlPart(8)
expressionOut.print(hasErrors(bean: glAccountInstance, field: 'batchUpdate', 'has-error'))
printHtmlPart(18)
invokeTag('message','g',130,['code':("glAccount.batchUpdate.label"),'default':("Batch Update")],-1)
printHtmlPart(2)
invokeTag('checkBox','g',133,['name':("batchUpdate"),'class':("form-control"),'value':(glAccountInstance?.batchUpdate)],-1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(5)
invokeTag('message','g',139,['error':(it)],-1)
printHtmlPart(6)
})
invokeTag('eachError','g',140,['bean':(glAccountInstance),'field':("batchUpdate")],2)
printHtmlPart(7)
})
invokeTag('hasErrors','g',143,['bean':(glAccountInstance),'field':("batchUpdate")],1)
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
