import icbs.gl.GlBatchHdr
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_glBatchHdrshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/glBatchHdr/show.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',6,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(2)
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'glBatchHdr.label', default: 'GlBatchHdr'))],-1)
printHtmlPart(2)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',8,['code':("default.show.label"),'args':([entityName])],-1)
})
invokeTag('captureTitle','sitemesh',8,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',8,[:],2)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',9,[:],1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(5)
if(true && (flash.message)) {
printHtmlPart(6)
expressionOut.print(flash.message)
printHtmlPart(7)
}
printHtmlPart(8)
if(true && (glBatchHdrInstance?.contraGl)) {
printHtmlPart(9)
invokeTag('message','g',20,['code':("glBatchHdr.contraGl.label"),'default':("Contra Gl")],-1)
printHtmlPart(10)
createTagBody(4, {->
expressionOut.print(glBatchHdrInstance?.contraGl?.encodeAsHTML())
})
invokeTag('link','g',22,['controller':("glAccount"),'action':("show"),'id':(glBatchHdrInstance?.contraGl?.id)],4)
printHtmlPart(11)
}
printHtmlPart(12)
if(true && (glBatchHdrInstance?.errorGl)) {
printHtmlPart(13)
invokeTag('message','g',29,['code':("glBatchHdr.errorGl.label"),'default':("Error Gl")],-1)
printHtmlPart(14)
createTagBody(4, {->
expressionOut.print(glBatchHdrInstance?.errorGl?.encodeAsHTML())
})
invokeTag('link','g',31,['controller':("glAccount"),'action':("show"),'id':(glBatchHdrInstance?.errorGl?.id)],4)
printHtmlPart(11)
}
printHtmlPart(12)
if(true && (glBatchHdrInstance?.batchType)) {
printHtmlPart(15)
invokeTag('message','g',38,['code':("glBatchHdr.batchType.label"),'default':("Batch Type")],-1)
printHtmlPart(16)
invokeTag('fieldValue','g',40,['bean':(glBatchHdrInstance),'field':("batchType")],-1)
printHtmlPart(11)
}
printHtmlPart(12)
if(true && (glBatchHdrInstance?.batchParticulars)) {
printHtmlPart(17)
invokeTag('message','g',47,['code':("glBatchHdr.batchParticulars.label"),'default':("Batch Particulars")],-1)
printHtmlPart(18)
invokeTag('fieldValue','g',49,['bean':(glBatchHdrInstance),'field':("batchParticulars")],-1)
printHtmlPart(11)
}
printHtmlPart(12)
if(true && (glBatchHdrInstance?.loanAcct)) {
printHtmlPart(19)
invokeTag('message','g',56,['code':("glBatchHdr.loanAcct.label"),'default':("Loan Acct")],-1)
printHtmlPart(20)
createTagBody(4, {->
expressionOut.print(glBatchHdrInstance?.loanAcct?.encodeAsHTML())
})
invokeTag('link','g',58,['controller':("loan"),'action':("show"),'id':(glBatchHdrInstance?.loanAcct?.id)],4)
printHtmlPart(11)
}
printHtmlPart(12)
if(true && (glBatchHdrInstance?.txnType)) {
printHtmlPart(21)
invokeTag('message','g',65,['code':("glBatchHdr.txnType.label"),'default':("Txn Type")],-1)
printHtmlPart(22)
invokeTag('fieldValue','g',67,['bean':(glBatchHdrInstance),'field':("txnType")],-1)
printHtmlPart(11)
}
printHtmlPart(12)
if(true && (glBatchHdrInstance?.batchCurrency)) {
printHtmlPart(23)
invokeTag('message','g',74,['code':("glBatchHdr.batchCurrency.label"),'default':("Batch Currency")],-1)
printHtmlPart(24)
createTagBody(4, {->
expressionOut.print(glBatchHdrInstance?.batchCurrency?.encodeAsHTML())
})
invokeTag('link','g',76,['controller':("currency"),'action':("show"),'id':(glBatchHdrInstance?.batchCurrency?.id)],4)
printHtmlPart(11)
}
printHtmlPart(12)
if(true && (glBatchHdrInstance?.batchId)) {
printHtmlPart(25)
invokeTag('message','g',83,['code':("glBatchHdr.batchId.label"),'default':("Batch Id")],-1)
printHtmlPart(26)
invokeTag('fieldValue','g',85,['bean':(glBatchHdrInstance),'field':("batchId")],-1)
printHtmlPart(11)
}
printHtmlPart(12)
if(true && (glBatchHdrInstance?.batchName)) {
printHtmlPart(27)
invokeTag('message','g',92,['code':("glBatchHdr.batchName.label"),'default':("Batch Name")],-1)
printHtmlPart(28)
invokeTag('fieldValue','g',94,['bean':(glBatchHdrInstance),'field':("batchName")],-1)
printHtmlPart(11)
}
printHtmlPart(12)
if(true && (glBatchHdrInstance?.branch)) {
printHtmlPart(29)
invokeTag('message','g',101,['code':("glBatchHdr.branch.label"),'default':("Branch")],-1)
printHtmlPart(30)
createTagBody(4, {->
expressionOut.print(glBatchHdrInstance?.branch?.encodeAsHTML())
})
invokeTag('link','g',103,['controller':("branch"),'action':("show"),'id':(glBatchHdrInstance?.branch?.id)],4)
printHtmlPart(11)
}
printHtmlPart(12)
if(true && (glBatchHdrInstance?.isBalanced)) {
printHtmlPart(31)
invokeTag('message','g',110,['code':("glBatchHdr.isBalanced.label"),'default':("Is Balanced")],-1)
printHtmlPart(32)
invokeTag('formatBoolean','g',112,['boolean':(glBatchHdrInstance?.isBalanced)],-1)
printHtmlPart(11)
}
printHtmlPart(12)
if(true && (glBatchHdrInstance?.isLocked)) {
printHtmlPart(33)
invokeTag('message','g',119,['code':("glBatchHdr.isLocked.label"),'default':("Is Locked")],-1)
printHtmlPart(34)
invokeTag('formatBoolean','g',121,['boolean':(glBatchHdrInstance?.isLocked)],-1)
printHtmlPart(11)
}
printHtmlPart(12)
if(true && (glBatchHdrInstance?.totalCredit)) {
printHtmlPart(35)
invokeTag('message','g',128,['code':("glBatchHdr.totalCredit.label"),'default':("Total Credit")],-1)
printHtmlPart(36)
invokeTag('formatNumber','g',130,['format':("###,###,##0.00"),'number':(glBatchHdrInstance?.totalCredit)],-1)
printHtmlPart(11)
}
printHtmlPart(12)
if(true && (glBatchHdrInstance?.totalDebit)) {
printHtmlPart(37)
invokeTag('message','g',137,['code':("glBatchHdr.totalDebit.label"),'default':("Total Debit")],-1)
printHtmlPart(38)
invokeTag('formatNumber','g',139,['format':("###,###,##0.00"),'number':(glBatchHdrInstance?.totalDebit)],-1)
printHtmlPart(11)
}
printHtmlPart(39)
createTagBody(3, {->
printHtmlPart(40)
createTagBody(4, {->
invokeTag('message','g',147,['code':("default.button.edit.label"),'default':("Edit")],-1)
})
invokeTag('link','g',147,['class':("edit"),'action':("edit"),'resource':(glBatchHdrInstance)],4)
printHtmlPart(41)
invokeTag('actionSubmit','g',148,['class':("delete"),'action':("delete"),'value':(message(code: 'default.button.delete.label', default: 'Delete')),'onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');")],-1)
printHtmlPart(42)
})
invokeTag('form','g',150,['url':([resource:glBatchHdrInstance, action:'delete']),'method':("DELETE")],3)
printHtmlPart(43)
})
invokeTag('captureContent','sitemesh',152,['tag':("main-content")],2)
printHtmlPart(44)
createTagBody(2, {->
printHtmlPart(45)
expressionOut.print(createLink(uri: '/'))
printHtmlPart(46)
invokeTag('message','g',155,['code':("default.home.label")],-1)
printHtmlPart(47)
createTagBody(3, {->
invokeTag('message','g',156,['code':("default.list.label"),'args':([entityName])],-1)
})
invokeTag('link','g',156,['class':("list"),'action':("index")],3)
printHtmlPart(48)
createTagBody(3, {->
invokeTag('message','g',157,['code':("default.new.label"),'args':([entityName])],-1)
})
invokeTag('link','g',157,['class':("create"),'action':("create")],3)
printHtmlPart(49)
})
invokeTag('captureContent','sitemesh',159,['tag':("main-actions")],2)
printHtmlPart(3)
})
invokeTag('captureBody','sitemesh',160,[:],1)
printHtmlPart(50)
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
