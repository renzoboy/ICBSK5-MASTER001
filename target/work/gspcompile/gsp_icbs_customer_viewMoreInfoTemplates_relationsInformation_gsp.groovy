import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_customer_viewMoreInfoTemplates_relationsInformation_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/customer/viewMoreInfoTemplates/_relationsInformation.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
if(true && (customerInstance?.type?.id==1)) {
printHtmlPart(1)
}
printHtmlPart(2)
if(true && (customerInstance?.type?.id!=1)) {
printHtmlPart(3)
}
printHtmlPart(4)
loop:{
int i = 0
for( relation in (customerInstance.relations) ) {
printHtmlPart(5)
if(true && (relation.status.id==2)) {
printHtmlPart(6)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(7)
expressionOut.print(fieldValue(bean: relation, field: "type.itemValue"))
printHtmlPart(8)
expressionOut.print(fieldValue(bean: relation, field: "customer2.customerId"))
printHtmlPart(8)
expressionOut.print(fieldValue(bean: relation, field: "customer2.name1"))
printHtmlPart(8)
expressionOut.print(fieldValue(bean: relation, field: "customer2.name2"))
printHtmlPart(8)
expressionOut.print(fieldValue(bean: relation, field: "customer2.name3"))
printHtmlPart(8)
expressionOut.print(fieldValue(bean: relation, field: "customer2.name4"))
printHtmlPart(9)
}
printHtmlPart(10)
i++
}
}
printHtmlPart(11)
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
