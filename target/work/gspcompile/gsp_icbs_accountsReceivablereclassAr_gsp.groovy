import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_accountsReceivablereclassAr_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/accountsReceivable/reclassAr.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',4,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
createTagBody(2, {->
createClosureForHtmlPart(2, 3)
invokeTag('captureTitle','sitemesh',5,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',5,[:],2)
printHtmlPart(3)
createTagBody(2, {->
printHtmlPart(4)
expressionOut.print(createLink(controller:'TxnTemplate', action:'validateExistingGlCodeAjax'))
printHtmlPart(5)
expressionOut.print(createLink(controller:'TxnTemplate', action:'validateExistingGlCodeAjax'))
printHtmlPart(6)
})
invokeTag('javascript','g',131,[:],2)
printHtmlPart(7)
})
invokeTag('captureHead','sitemesh',132,[:],1)
printHtmlPart(7)
createTagBody(1, {->
printHtmlPart(3)
createTagBody(2, {->
printHtmlPart(8)
expressionOut.print(createLink(uri: '/accountsReceivable'))
printHtmlPart(9)
})
invokeTag('captureContent','sitemesh',137,['tag':("breadcrumbs")],2)
printHtmlPart(1)
createTagBody(2, {->
printHtmlPart(10)
if(true && (flash.message)) {
printHtmlPart(11)
expressionOut.print(flash.message)
printHtmlPart(12)
}
printHtmlPart(13)
createTagBody(3, {->
printHtmlPart(14)
createTagBody(4, {->
printHtmlPart(15)
if(true && (error in org.springframework.validation.FieldError)) {
printHtmlPart(16)
expressionOut.print(error.field)
printHtmlPart(17)
}
printHtmlPart(18)
invokeTag('message','g',146,['error':("${error.field} - ${error}")],-1)
printHtmlPart(19)
})
invokeTag('eachError','g',147,['bean':(accountsReceivableInstance),'var':("error")],4)
printHtmlPart(20)
})
invokeTag('hasErrors','g',149,['bean':(accountsReceivableInstance)],3)
printHtmlPart(13)
createTagBody(3, {->
printHtmlPart(21)
invokeTag('hiddenField','g',151,['name':("accountsReceivableId"),'id':("accountsReceivableId"),'value':(accountsReceivableInstance?.id)],-1)
printHtmlPart(22)
expressionOut.print(hasErrors(bean: accountsReceivableInstance, field: 'glContra', 'has-error'))
printHtmlPart(23)
invokeTag('textField','g',154,['name':("glContra"),'id':("glContra"),'maxlength':("25"),'required':(""),'value':(accountsReceivableInstance?.glContra),'onblur':("validateGlCode();"),'class':("form-control"),'readonly':("true")],-1)
printHtmlPart(24)
createTagBody(4, {->
printHtmlPart(25)
createTagBody(5, {->
printHtmlPart(26)
invokeTag('message','g',159,['error':(it)],-1)
printHtmlPart(27)
})
invokeTag('eachError','g',160,['bean':(accountsReceivableInstance),'field':("glContra")],5)
printHtmlPart(28)
})
invokeTag('hasErrors','g',163,['bean':(accountsReceivableInstance),'field':("glContra")],4)
printHtmlPart(29)
expressionOut.print(hasErrors(bean: accountsReceivableInstance, field: 'depcontra', 'has-error'))
printHtmlPart(30)
invokeTag('message','g',169,['code':("txnTemplate.memoTxnType.label"),'default':("Gl Acct Description")],-1)
printHtmlPart(31)
invokeTag('textField','g',172,['readonly':("true"),'name':("gldescription"),'id':("gldescription"),'maxlength':("100"),'value':(""),'onblur':("validateGlCode();"),'class':("form-control")],-1)
printHtmlPart(32)
createTagBody(4, {->
printHtmlPart(33)
createTagBody(5, {->
printHtmlPart(34)
invokeTag('message','g',178,['error':(it)],-1)
printHtmlPart(35)
})
invokeTag('eachError','g',179,['bean':(accountsReceivableInstance),'field':("memoTxnType")],5)
printHtmlPart(36)
})
invokeTag('hasErrors','g',182,['bean':(accountsReceivableInstance),'field':("memoTxnType")],4)
printHtmlPart(37)
expressionOut.print(hasErrors(bean: accountsReceivableInstance, field: 'glContra', 'has-error'))
printHtmlPart(38)
invokeTag('textField','g',190,['name':("reclassGlContra"),'id':("reclassGlContra"),'required':(""),'value':(""),'onblur':("reclassValidateGlCode();"),'class':("form-control")],-1)
printHtmlPart(24)
createTagBody(4, {->
printHtmlPart(25)
createTagBody(5, {->
printHtmlPart(26)
invokeTag('message','g',195,['error':(it)],-1)
printHtmlPart(27)
})
invokeTag('eachError','g',196,['bean':(accountsReceivableInstance),'field':("reclassGlContra")],5)
printHtmlPart(28)
})
invokeTag('hasErrors','g',199,['bean':(accountsReceivableInstance),'field':("reclassGlContra")],4)
printHtmlPart(39)
expressionOut.print(hasErrors(bean: txnTemplateInstance, field: 'depcontra', 'has-error'))
printHtmlPart(30)
invokeTag('message','g',204,['code':("txnTemplate.memoTxnType.label"),'default':("Reclass Gl Acct Description")],-1)
printHtmlPart(31)
invokeTag('textField','g',207,['readonly':("true"),'name':("reclassgldescription"),'id':("reclassgldescription"),'maxlength':("100"),'value':(txnTemplateInstance?.amlaCode),'onblur':("validateGlCode();"),'class':("form-control")],-1)
printHtmlPart(32)
createTagBody(4, {->
printHtmlPart(33)
createTagBody(5, {->
printHtmlPart(34)
invokeTag('message','g',213,['error':(it)],-1)
printHtmlPart(35)
})
invokeTag('eachError','g',214,['bean':(txnTemplateInstance),'field':("memoTxnType")],5)
printHtmlPart(36)
})
invokeTag('hasErrors','g',217,['bean':(txnTemplateInstance),'field':("memoTxnType")],4)
printHtmlPart(40)
invokeTag('hiddenField','g',220,['id':("financialYear"),'name':("financialYear"),'value':(g.formatDate(date: (runDate), format: 'yyyy'))],-1)
printHtmlPart(13)
})
invokeTag('form','g',221,['id':("create"),'url':([controller:'AccountsReceivable', action:'arSaveReclass']),'onsubmit':("callLoadingDialog();"),'method':("POST")],3)
printHtmlPart(41)
})
invokeTag('captureContent','sitemesh',223,['tag':("main-content")],2)
printHtmlPart(1)
createTagBody(2, {->
printHtmlPart(42)
createTagBody(3, {->
invokeTag('message','g',227,['code':("default.cancel.label"),'args':([entityName]),'default':("Cancel")],-1)
})
invokeTag('link','g',227,['action':("index")],3)
printHtmlPart(43)
})
invokeTag('captureContent','sitemesh',229,['tag':("main-actions")],2)
printHtmlPart(7)
})
invokeTag('captureBody','sitemesh',230,[:],1)
printHtmlPart(44)
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
