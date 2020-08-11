import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_customer_viewMoreInfoTemplates_beneficiaryInformation_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/customer/viewMoreInfoTemplates/_beneficiaryInformation.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
if(true && (customerInstance?.type?.id==1)) {
printHtmlPart(1)
}
printHtmlPart(2)
loop:{
int i = 0
for( beneficiaries in (icbs.cif.Beneficiary.findAllByCustomer(customerInstance)) ) {
printHtmlPart(3)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(4)
expressionOut.print(fieldValue(bean: beneficiaries, field: "firstName"))
printHtmlPart(5)
expressionOut.print(fieldValue(bean: beneficiaries, field: "middleName"))
printHtmlPart(5)
expressionOut.print(fieldValue(bean: beneficiaries, field: "lastName"))
printHtmlPart(5)
expressionOut.print(fieldValue(bean: beneficiaries, field: "suffixName"))
printHtmlPart(5)
invokeTag('formatDate','g',25,['format':("MM/dd/yyyy"),'date':(beneficiaries?.birthDate)],-1)
printHtmlPart(5)
expressionOut.print(beneficiaries?.customerRelationship?.itemValue)
printHtmlPart(6)
i++
}
}
printHtmlPart(7)
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
