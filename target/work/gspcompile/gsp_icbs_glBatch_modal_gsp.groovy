import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_glBatch_modal_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/glBatch/_modal.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
invokeTag('hiddenField','g',11,['name':("glName"),'id':("glName"),'v-model':("glName")],-1)
printHtmlPart(1)
invokeTag('select','g',14,['id':("transaction"),'name':("transaction.id"),'from':(icbs.gl.GlBatchTransactionType.list(sort: "description")),'optionKey':("id"),'optionValue':("description"),'class':("many-to-one form-control"),'noSelection':(['null': '']),'v-model':("transaction")],-1)
printHtmlPart(2)
invokeTag('select','g',19,['id':("transaction"),'name':("transaction.id"),'from':(icbs.gl.GlBatchTransactionType.findAllByIdGreaterThanEquals(7)),'optionKey':("id"),'optionValue':("description"),'class':("many-to-one form-control"),'noSelection':(['null': '']),'v-model':("transaction")],-1)
printHtmlPart(3)
invokeTag('hiddenField','g',30,['name':("glCode"),'id':("glBatchAccountHidden"),'v-model':("newAccount")],-1)
printHtmlPart(4)
invokeTag('hiddenField','g',45,['name':("glname"),'id':("glBatchAccountHidden"),'v-model':("newAccount")],-1)
printHtmlPart(5)
invokeTag('hiddenField','g',58,['name':("glCode"),'id':("glBatchAccountHidden"),'v-model':("newAccount")],-1)
printHtmlPart(6)
invokeTag('hiddenField','g',73,['name':("glname"),'id':("glBatchAccountHidden"),'v-model':("newAccount")],-1)
printHtmlPart(7)
invokeTag('hiddenField','g',86,['name':("glCode"),'id':("glBatchAccountHidden"),'v-model':("newAccount")],-1)
printHtmlPart(8)
invokeTag('hiddenField','g',103,['name':("glname"),'id':("glBatchAccountHidden"),'v-model':("newAccount")],-1)
printHtmlPart(9)
invokeTag('hiddenField','g',117,['name':("glCode"),'id':("glBatchAccountHidden"),'v-model':("newAccount")],-1)
printHtmlPart(8)
invokeTag('hiddenField','g',134,['name':("glname"),'id':("glBatchAccountHidden"),'v-model':("newAccount")],-1)
printHtmlPart(10)
createTagBody(1, {->
printHtmlPart(11)
expressionOut.print(createLink(controller:'glBatch',action:'getGLAcctByBranch'))
printHtmlPart(12)
expressionOut.print(createLink(controller:'glBatch',action:'getDepositAcctByBranch'))
printHtmlPart(13)
expressionOut.print(createLink(controller:'glBatch',action:'getLoanAcctByBranch'))
printHtmlPart(14)
})
invokeTag('javascript','g',215,[:],1)
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
