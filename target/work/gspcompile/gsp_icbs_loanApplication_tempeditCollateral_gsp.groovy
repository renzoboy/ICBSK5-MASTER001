import icbs.loans.Collateral
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_loanApplication_tempeditCollateral_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/loanApplication/temp/editCollateral.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
invokeTag('set','g',6,['var':("entityName"),'value':(message(code: 'collateral.label', default: 'Collateral'))],-1)
printHtmlPart(1)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('message','g',7,['code':("default.edit.label"),'args':([entityName])],-1)
})
invokeTag('captureTitle','sitemesh',7,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',7,[:],2)
printHtmlPart(1)
createClosureForHtmlPart(2, 2)
invokeTag('javascript','g',89,[:],2)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',90,[:],1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(6)
if(true && (flash.message)) {
printHtmlPart(7)
expressionOut.print(flash.message)
printHtmlPart(8)
}
printHtmlPart(9)
createTagBody(3, {->
printHtmlPart(10)
createTagBody(4, {->
printHtmlPart(11)
if(true && (error in org.springframework.validation.FieldError)) {
printHtmlPart(12)
expressionOut.print(error.field)
printHtmlPart(13)
}
printHtmlPart(14)
invokeTag('message','g',100,['error':(error)],-1)
printHtmlPart(15)
})
invokeTag('eachError','g',101,['bean':(collateralInstance),'var':("error")],4)
printHtmlPart(16)
})
invokeTag('hasErrors','g',103,['bean':(collateralInstance)],3)
printHtmlPart(9)
createTagBody(3, {->
printHtmlPart(17)
invokeTag('hiddenField','g',105,['name':("version"),'value':(collateralInstance?.version)],-1)
printHtmlPart(18)
invokeTag('render','g',107,['template':("collateral")],-1)
printHtmlPart(19)
invokeTag('submitButton','g',110,['name':("update"),'class':("btn btn-primary"),'value':(message(code: 'default.button.update.label', default: 'Update'))],-1)
printHtmlPart(20)
})
invokeTag('form','g',112,['url':([controller:loanApplication, action:'updateCollateral']),'method':("PUT")],3)
printHtmlPart(21)
})
invokeTag('captureContent','sitemesh',114,['tag':("main-content")],2)
printHtmlPart(22)
createTagBody(2, {->
printHtmlPart(23)
createClosureForHtmlPart(24, 3)
invokeTag('link','g',117,['action':("show"),'id':(loanApplicationInstance.id)],3)
printHtmlPart(25)
createClosureForHtmlPart(26, 3)
invokeTag('link','g',118,['action':("showCollaterals"),'resource':(loanApplicationInstance)],3)
printHtmlPart(25)
createTagBody(3, {->
invokeTag('message','g',119,['code':("default.new.label"),'args':([entityName])],-1)
})
invokeTag('link','g',119,['action':("createCollateral"),'params':([loanApplication:"${loanApplicationInstance?.id}"])],3)
printHtmlPart(27)
})
invokeTag('captureContent','sitemesh',121,['tag':("main-actions")],2)
printHtmlPart(28)
})
invokeTag('captureBody','sitemesh',123,[:],1)
printHtmlPart(29)
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
