import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_ropa_otherRopaInfo_show_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/ropa/otherRopaInfo/_show.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
invokeTag('hiddenField','g',2,['id':("ropaLoan"),'name':("ropaLoan"),'value':(ropapapapaInstance?.loan.id)],-1)
printHtmlPart(1)
invokeTag('formatNumber','g',6,['format':("###,###,##0.00"),'number':(ropapapapaInstance?.costsCapitalized)],-1)
printHtmlPart(2)
invokeTag('formatNumber','g',10,['format':("###,###,##0.00"),'number':(ropapapapaInstance?.provisionAmt)],-1)
printHtmlPart(3)
invokeTag('formatNumber','g',14,['format':("###,###,##0.00"),'number':(ropapapapaInstance?.provisionRate)],-1)
printHtmlPart(4)
invokeTag('formatNumber','g',18,['format':("###,###,##0.00"),'number':(ropapapapaInstance?.allocatedBookValueLand)],-1)
printHtmlPart(5)
invokeTag('formatNumber','g',22,['format':("###,###,##0.00"),'number':(ropapapapaInstance?.allocatedBookValueBuilding)],-1)
printHtmlPart(6)
invokeTag('formatNumber','g',26,['format':("###,###,##0.00"),'number':(ropapapapaInstance?.accumulatedDepreciationBuilding)],-1)
printHtmlPart(7)
invokeTag('formatNumber','g',30,['format':("###,###,##0.00"),'number':(ropapapapaInstance?.allowanceBuilding)],-1)
printHtmlPart(8)
invokeTag('formatNumber','g',34,['format':("###,###,##0.00"),'number':(ropapapapaInstance?.otherCosts)],-1)
printHtmlPart(9)
invokeTag('formatNumber','g',38,['format':("###,###,##0.00"),'number':(ropapapapaInstance?.allowanceOthers)],-1)
printHtmlPart(10)
expressionOut.print(ropapapapaInstance?.formerTitle)
printHtmlPart(11)
expressionOut.print(ropapapapaInstance?.kindOfLand)
printHtmlPart(12)
invokeTag('formatNumber','g',50,['format':("###,###,##0.00"),'number':(ropapapapaInstance?.landArea)],-1)
printHtmlPart(13)
expressionOut.print(ropapapapaInstance?.location)
printHtmlPart(14)
invokeTag('formatDate','g',58,['format':("MM/dd/yyyy"),'date':(ropapapapaInstance?.dateOfCertificate)],-1)
printHtmlPart(15)
invokeTag('formatDate','g',62,['format':("MM/dd/yyyy"),'date':(ropapapapaInstance?.dateOfCertificateRegistration)],-1)
printHtmlPart(16)
invokeTag('formatDate','g',66,['format':("MM/dd/yyyy"),'date':(ropapapapaInstance?.dateConsolidated)],-1)
printHtmlPart(17)
expressionOut.print(ropapapapaInstance?.newTct)
printHtmlPart(18)
invokeTag('formatNumber','g',74,['format':("###,###,##0.00"),'number':(ropapapapaInstance?.landAppraisal)],-1)
printHtmlPart(19)
invokeTag('formatNumber','g',78,['format':("###,###,##0.00"),'number':(ropapapapaInstance?.buildingAppraisal)],-1)
printHtmlPart(20)
invokeTag('formatNumber','g',82,['format':("###,###,##0.00"),'number':(ropapapapaInstance?.otherAppraisal)],-1)
printHtmlPart(21)
invokeTag('formatDate','g',86,['format':("MM/dd/yyyy"),'date':(ropapapapaInstance?.dateOfAppraisal)],-1)
printHtmlPart(22)
expressionOut.print(ropapapapaInstance?.appraisedBy)
printHtmlPart(23)
expressionOut.print(ropapapapaInstance?.fireInsurancePolicyNo)
printHtmlPart(24)
invokeTag('formatNumber','g',98,['format':("###,###,##0.00"),'number':(ropapapapaInstance?.fireInsuranceAmt)],-1)
printHtmlPart(25)
invokeTag('formatDate','g',102,['format':("MM/dd/yyyy"),'date':(ropapapapaInstance?.fireInsuranceDate)],-1)
printHtmlPart(26)
invokeTag('formatNumber','g',106,['format':("###,###,##0.00"),'number':(ropapapapaInstance?.provisionForFireInsurance)],-1)
printHtmlPart(27)
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
