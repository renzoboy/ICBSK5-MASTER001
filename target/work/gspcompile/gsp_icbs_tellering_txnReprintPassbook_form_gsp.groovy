import icbs.tellering.TxnDepositAcctLedger
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_tellering_txnReprintPassbook_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/tellering/txnReprintPassbook/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
invokeTag('textField','g',2,['disable':("disabled"),'name':("pb"),'style':("display:none")],-1)
printHtmlPart(0)
invokeTag('textField','g',3,['id':("depAmt"),'name':("depAmt"),'value':("0"),'style':("display:none")],-1)
printHtmlPart(1)
if(true && (!txnCashDepositInstance?.acct)) {
printHtmlPart(2)
}
printHtmlPart(3)
invokeTag('render','g',12,['template':("/tellering/details/depositDetails")],-1)
printHtmlPart(4)
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
