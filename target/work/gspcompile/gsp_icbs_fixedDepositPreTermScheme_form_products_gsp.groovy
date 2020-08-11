import icbs.lov.ProductType
import icbs.lov.ConfigItemStatus
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_fixedDepositPreTermScheme_form_products_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/fixedDepositPreTermScheme/form/_products.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
printHtmlPart(2)
invokeTag('select','g',10,['id':("products"),'name':("products"),'from':(icbs.admin.Product.findAllByProductTypeAndConfigItemStatus(ProductType.get(3),ConfigItemStatus.get(2))),'optionKey':("id"),'optionValue':("name"),'value':(fixedDepositPreTermSchemeInstance?.products?.id),'class':("many-to-one form-control"),'multiple':("")],-1)
printHtmlPart(3)
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
