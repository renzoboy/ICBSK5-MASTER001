import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_tellering_txnCashFromVault_usd_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/tellering/txnCashFromVault/_usd.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
expressionOut.print(resource(dir: 'js', file: 'cashfromvault_usd.js'))
printHtmlPart(2)
invokeTag('textField','g',18,['type':("number"),'name':("bills100"),'value':(txnCashFromVaultInstance?.bills100),'class':("form-control to-compute")],-1)
printHtmlPart(3)
invokeTag('textField','g',21,['type':("number"),'readonly':("true"),'name':("total100"),'id':("total100"),'value':(txnCashFromVaultInstance?.total100),'placeholder':("0"),'class':("form-control")],-1)
printHtmlPart(4)
invokeTag('textField','g',29,['type':("number"),'name':("bills50"),'value':(txnCashFromVaultInstance?.bills50),'class':("form-control to-compute")],-1)
printHtmlPart(5)
invokeTag('textField','g',32,['type':("number"),'readonly':("true"),'name':("total50"),'id':("total50"),'value':(txnCashFromVaultInstance?.total50),'placeholder':("0"),'class':("form-control")],-1)
printHtmlPart(6)
invokeTag('textField','g',40,['type':("number"),'name':("bills20"),'value':(txnCashFromVaultInstance?.bills20),'class':("form-control to-compute")],-1)
printHtmlPart(7)
invokeTag('textField','g',43,['type':("number"),'readonly':("true"),'name':("total20"),'id':("total20"),'value':(txnCashFromVaultInstance?.total20),'placeholder':("0"),'class':("form-control")],-1)
printHtmlPart(8)
invokeTag('textField','g',52,['type':("number"),'name':("bills10"),'value':(txnCashFromVaultInstance?.bills10),'class':("form-control to-compute")],-1)
printHtmlPart(9)
invokeTag('textField','g',55,['type':("number"),'readonly':("true"),'name':("total10"),'id':("total10"),'value':(txnCashFromVaultInstance?.total10),'placeholder':("0"),'class':("form-control")],-1)
printHtmlPart(10)
invokeTag('textField','g',63,['type':("number"),'name':("bills5"),'value':(txnCashFromVaultInstance?.bills5),'class':("form-control to-compute")],-1)
printHtmlPart(9)
invokeTag('textField','g',66,['type':("number"),'readonly':("true"),'name':("total5"),'id':("total5"),'value':(txnCashFromVaultInstance?.total5),'placeholder':("0"),'class':("form-control")],-1)
printHtmlPart(11)
invokeTag('textField','g',74,['type':("number"),'name':("bills2"),'value':(txnCashFromVaultInstance?.bills2),'class':("form-control to-compute")],-1)
printHtmlPart(7)
invokeTag('textField','g',77,['type':("number"),'readonly':("true"),'name':("total2"),'id':("total2"),'value':(txnCashFromVaultInstance?.total2),'placeholder':("0"),'class':("form-control")],-1)
printHtmlPart(12)
invokeTag('textField','g',85,['type':("number"),'name':("bills1"),'value':(txnCashFromVaultInstance?.bills1),'class':("form-control to-compute")],-1)
printHtmlPart(7)
invokeTag('textField','g',88,['type':("number"),'readonly':("true"),'name':("total1"),'id':("total1"),'value':(txnCashFromVaultInstance?.total1),'placeholder':("0"),'class':("form-control")],-1)
printHtmlPart(13)
invokeTag('textField','g',96,['type':("number"),'name':("coins100"),'value':(txnCashFromVaultInstance?.coins100),'class':("form-control to-compute")],-1)
printHtmlPart(7)
invokeTag('textField','g',99,['type':("number"),'readonly':("true"),'name':("total0100"),'id':("total0100"),'value':(txnCashFromVaultInstance?.total0100),'placeholder':("0"),'class':("form-control")],-1)
printHtmlPart(14)
invokeTag('textField','g',107,['type':("number"),'name':("coins050"),'value':(txnCashFromVaultInstance?.coins050),'class':("form-control to-compute")],-1)
printHtmlPart(3)
invokeTag('textField','g',110,['type':("number"),'readonly':("true"),'name':("total050"),'id':("total050"),'value':(txnCashFromVaultInstance?.total050),'placeholder':("0"),'class':("form-control")],-1)
printHtmlPart(15)
invokeTag('textField','g',118,['type':("number"),'name':("coins025"),'value':(txnCashFromVaultInstance?.coins025),'class':("form-control to-compute")],-1)
printHtmlPart(3)
invokeTag('textField','g',121,['type':("number"),'readonly':("true"),'name':("total025"),'id':("total025"),'value':(txnCashFromVaultInstance?.total025),'placeholder':("0"),'class':("form-control")],-1)
printHtmlPart(16)
invokeTag('textField','g',129,['type':("number"),'name':("coins010"),'value':(txnCashFromVaultInstance?.coins010),'class':("form-control to-compute")],-1)
printHtmlPart(3)
invokeTag('textField','g',132,['type':("number"),'readonly':("true"),'name':("total010"),'id':("total010"),'value':(txnCashFromVaultInstance?.total010),'placeholder':("0"),'class':("form-control")],-1)
printHtmlPart(17)
invokeTag('textField','g',140,['type':("number"),'name':("coins005"),'value':(txnCashFromVaultInstance?.coins005),'class':("form-control to-compute")],-1)
printHtmlPart(3)
invokeTag('textField','g',143,['type':("number"),'readonly':("true"),'name':("total005"),'id':("total005"),'value':(txnCashFromVaultInstance?.total005),'placeholder':("0"),'class':("form-control")],-1)
printHtmlPart(18)
invokeTag('textField','g',151,['type':("number"),'name':("coins001"),'value':(txnCashFromVaultInstance?.coins001),'class':("form-control to-compute")],-1)
printHtmlPart(3)
invokeTag('textField','g',154,['type':("number"),'readonly':("true"),'name':("total001"),'id':("total001"),'value':(txnCashFromVaultInstance?.total001),'placeholder':("0"),'class':("form-control")],-1)
printHtmlPart(19)
invokeTag('textField','g',165,['disabled':("true"),'name':("total"),'id':("total"),'value':("0"),'class':("form-control total")],-1)
printHtmlPart(20)
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
