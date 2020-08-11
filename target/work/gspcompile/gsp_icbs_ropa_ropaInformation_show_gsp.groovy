import icbs.gl.GlAccount
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_ropa_ropaInformation_show_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/ropa/ropaInformation/_show.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
invokeTag('hiddenField','g',3,['id':("ropaLoan"),'name':("ropaLoan"),'value':(ropapapapaInstance?.loan.id)],-1)
printHtmlPart(1)
expressionOut.print(ropapapapaInstance?.branch?.name)
printHtmlPart(2)
expressionOut.print(ropapapapaInstance?.acquiredFrom?.displayName)
printHtmlPart(3)
invokeTag('formatDate','g',15,['format':("MM/dd/yyyy"),'date':(ropapapapaInstance?.ropaDate)],-1)
printHtmlPart(4)
expressionOut.print(ropapapapaInstance?.loan?.accountNo)
printHtmlPart(5)
expressionOut.print(ropapapapaInstance?.glContraRopa)
printHtmlPart(6)
expressionOut.print(GlAccount.findByCode(ropapapapaInstance?.glContraRopa).name)
printHtmlPart(7)
expressionOut.print(ropapapapaInstance?.glContraBldg)
printHtmlPart(8)
expressionOut.print(GlAccount.findByCode(ropapapapaInstance?.glContraBldg).name)
printHtmlPart(9)
expressionOut.print(ropapapapaInstance?.accumulatedDepreciation)
printHtmlPart(6)
expressionOut.print(GlAccount.findByCode(ropapapapaInstance?.accumulatedDepreciation).name)
printHtmlPart(10)
expressionOut.print(ropapapapaInstance?.otherGl)
printHtmlPart(6)
expressionOut.print(GlAccount.findByCode(ropapapapaInstance?.otherGl).name)
printHtmlPart(11)
expressionOut.print(ropapapapaInstance?.otherAccumlated)
printHtmlPart(6)
expressionOut.print(GlAccount.findByCode(ropapapapaInstance?.otherAccumlated).name)
printHtmlPart(12)
expressionOut.print(ropapapapaInstance?.ropaIncome)
printHtmlPart(6)
expressionOut.print(GlAccount.findByCode(ropapapapaInstance?.ropaIncome).name)
printHtmlPart(13)
expressionOut.print(ropapapapaInstance?.glContraLitigationExp)
printHtmlPart(6)
expressionOut.print(GlAccount.findByCode(ropapapapaInstance?.glContraLitigationExp).name)
printHtmlPart(14)
expressionOut.print(ropapapapaInstance?.createdBy?.username)
printHtmlPart(15)
invokeTag('formatDate','g',56,['format':("MM/dd/yyyy"),'date':(ropapapapaInstance?.runDateCreated)],-1)
printHtmlPart(16)
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
