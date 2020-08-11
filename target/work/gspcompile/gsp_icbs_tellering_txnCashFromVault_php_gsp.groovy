import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_tellering_txnCashFromVault_php_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/tellering/txnCashFromVault/_php.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
expressionOut.print(resource(dir: 'js', file: 'cashfromvault_php.js'))
printHtmlPart(2)
invokeTag('field','g',17,['min':("0"),'type':("number"),'name':("bills1000"),'value':(txnCashFromVaultInstance?.bills1000),'class':("form-control to-compute")],-1)
printHtmlPart(3)
invokeTag('textField','g',20,['type':("number"),'readonly':("true"),'name':("total1000"),'id':("total1000"),'value':(txnCashFromVaultInstance?.total1000),'placeholder':("0"),'class':("form-control")],-1)
printHtmlPart(4)
invokeTag('textField','g',28,['type':("number"),'name':("bills500"),'value':(txnCashFromVaultInstance?.bills500),'class':("form-control to-compute")],-1)
printHtmlPart(3)
invokeTag('textField','g',31,['type':("number"),'readonly':("true"),'name':("total500"),'id':("total500"),'value':(txnCashFromVaultInstance?.total500),'placeholder':("0"),'class':("form-control")],-1)
printHtmlPart(5)
invokeTag('textField','g',39,['type':("number"),'name':("bills200"),'value':(txnCashFromVaultInstance?.bills200),'class':("form-control to-compute")],-1)
printHtmlPart(3)
invokeTag('textField','g',42,['type':("number"),'readonly':("true"),'name':("total200"),'id':("total200"),'value':(txnCashFromVaultInstance?.total200),'placeholder':("0"),'class':("form-control")],-1)
printHtmlPart(6)
invokeTag('textField','g',50,['type':("number"),'name':("bills100"),'value':(txnCashFromVaultInstance?.bills100),'class':("form-control to-compute")],-1)
printHtmlPart(3)
invokeTag('textField','g',53,['type':("number"),'readonly':("true"),'name':("total100"),'id':("total100"),'value':(txnCashFromVaultInstance?.total100),'placeholder':("0"),'class':("form-control")],-1)
printHtmlPart(7)
invokeTag('textField','g',61,['type':("number"),'name':("bills50"),'value':(txnCashFromVaultInstance?.bills50),'class':("form-control to-compute")],-1)
printHtmlPart(8)
invokeTag('textField','g',64,['type':("number"),'readonly':("true"),'name':("total50"),'id':("total50"),'value':(txnCashFromVaultInstance?.total50),'placeholder':("0"),'class':("form-control")],-1)
printHtmlPart(9)
invokeTag('textField','g',72,['type':("number"),'name':("bills20"),'value':(txnCashFromVaultInstance?.bills20),'class':("form-control to-compute")],-1)
printHtmlPart(10)
invokeTag('textField','g',75,['type':("number"),'readonly':("true"),'name':("total20"),'id':("total20"),'value':(txnCashFromVaultInstance?.total20),'placeholder':("0"),'class':("form-control")],-1)
printHtmlPart(11)
invokeTag('textField','g',83,['type':("number"),'name':("coins10"),'value':(txnCashFromVaultInstance?.coins10),'class':("form-control to-compute")],-1)
printHtmlPart(12)
invokeTag('textField','g',86,['type':("number"),'readonly':("true"),'name':("total10"),'id':("total10"),'value':(txnCashFromVaultInstance?.total10),'placeholder':("0"),'class':("form-control")],-1)
printHtmlPart(13)
invokeTag('textField','g',94,['type':("number"),'name':("coins5"),'value':(txnCashFromVaultInstance?.coins5),'class':("form-control to-compute")],-1)
printHtmlPart(12)
invokeTag('textField','g',97,['type':("number"),'readonly':("true"),'name':("total5"),'id':("total5"),'value':(txnCashFromVaultInstance?.total5),'placeholder':("0"),'class':("form-control")],-1)
printHtmlPart(14)
invokeTag('textField','g',105,['type':("number"),'name':("coins1"),'value':(txnCashFromVaultInstance?.coins1),'class':("form-control to-compute")],-1)
printHtmlPart(10)
invokeTag('textField','g',108,['type':("number"),'readonly':("true"),'name':("total1"),'id':("total1"),'value':(txnCashFromVaultInstance?.total1),'placeholder':("0"),'class':("form-control")],-1)
printHtmlPart(15)
invokeTag('textField','g',116,['type':("number"),'name':("coins025"),'value':(txnCashFromVaultInstance?.coins025),'class':("form-control to-compute")],-1)
printHtmlPart(3)
invokeTag('textField','g',119,['type':("number"),'readonly':("true"),'name':("total025"),'id':("total025"),'value':(txnCashFromVaultInstance?.total025),'placeholder':("0"),'class':("form-control")],-1)
printHtmlPart(16)
invokeTag('textField','g',127,['type':("number"),'name':("coins010"),'value':(txnCashFromVaultInstance?.coins010),'class':("form-control to-compute")],-1)
printHtmlPart(3)
invokeTag('textField','g',130,['type':("number"),'readonly':("true"),'name':("total010"),'id':("total010"),'value':(txnCashFromVaultInstance?.total010),'placeholder':("0"),'class':("form-control")],-1)
printHtmlPart(17)
invokeTag('textField','g',138,['type':("number"),'name':("coins005"),'value':(txnCashFromVaultInstance?.coins005),'class':("form-control to-compute")],-1)
printHtmlPart(3)
invokeTag('textField','g',141,['type':("number"),'readonly':("true"),'name':("total005"),'id':("total005"),'value':(txnCashFromVaultInstance?.total005),'placeholder':("0"),'class':("form-control")],-1)
printHtmlPart(18)
invokeTag('textField','g',149,['type':("number"),'name':("coins001"),'value':(txnCashFromVaultInstance?.coins001),'class':("form-control to-compute")],-1)
printHtmlPart(3)
invokeTag('textField','g',152,['type':("number"),'readonly':("true"),'name':("total001"),'id':("total001"),'value':(txnCashFromVaultInstance?.total001),'placeholder':("0"),'class':("form-control")],-1)
printHtmlPart(19)
invokeTag('textField','g',163,['disabled':("true"),'name':("total"),'id':("total"),'value':("0"),'class':("form-control total")],-1)
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
