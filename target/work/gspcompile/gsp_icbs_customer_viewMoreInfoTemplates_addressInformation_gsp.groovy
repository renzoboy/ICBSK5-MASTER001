import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_customer_viewMoreInfoTemplates_addressInformation_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/customer/viewMoreInfoTemplates/_addressInformation.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
loop:{
int i = 0
for( address in (customerInstance.addresses) ) {
printHtmlPart(1)
if(true && (address.status.id==1 || address.status.id==2)) {
printHtmlPart(2)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(3)
expressionOut.print(fieldValue(bean: address, field: "type.description"))
printHtmlPart(4)
expressionOut.print(fieldValue(bean: address, field: "address1"))
printHtmlPart(5)
expressionOut.print(fieldValue(bean: address, field: "address2"))
printHtmlPart(5)
expressionOut.print(fieldValue(bean: address, field: "town.description"))
printHtmlPart(5)
expressionOut.print(fieldValue(bean: address, field: "address3"))
printHtmlPart(4)
expressionOut.print(fieldValue(bean: address, field: "phone1"))
printHtmlPart(4)
expressionOut.print(fieldValue(bean: address, field: "phone2"))
printHtmlPart(4)
expressionOut.print(fieldValue(bean: address, field: "phone3"))
printHtmlPart(4)
expressionOut.print(fieldValue(bean: address, field: "phone4"))
printHtmlPart(4)
expressionOut.print(fieldValue(bean: address, field: "isPrimary"))
printHtmlPart(4)
expressionOut.print(fieldValue(bean: address, field: "isOwned"))
printHtmlPart(4)
expressionOut.print(fieldValue(bean: address, field: "isMailing"))
printHtmlPart(4)
expressionOut.print(fieldValue(bean: address, field: "isMortaged"))
printHtmlPart(6)
}
printHtmlPart(7)
i++
}
}
printHtmlPart(8)
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
