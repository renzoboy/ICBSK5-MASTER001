import icbs.admin.Institution
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_institutionindex_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/institution/index.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',6,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(2)
invokeTag('set','g',7,['var':("entityName"),'value':(message(code: 'institution.label', default: 'Institution'))],-1)
printHtmlPart(2)
createTagBody(2, {->
createClosureForHtmlPart(3, 3)
invokeTag('captureTitle','sitemesh',8,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',8,[:],2)
printHtmlPart(4)
})
invokeTag('captureHead','sitemesh',9,[:],1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(5)
createClosureForHtmlPart(6, 2)
invokeTag('captureContent','sitemesh',13,['tag':("breadcrumbs")],2)
printHtmlPart(2)
createTagBody(2, {->
printHtmlPart(7)
if(true && (flash.message)) {
printHtmlPart(8)
expressionOut.print(flash.message)
printHtmlPart(9)
}
printHtmlPart(10)
createTagBody(3, {->
printHtmlPart(11)
invokeTag('select','g',21,['name':("max"),'value':(params.max),'from':([5, 10, 15, 20]),'class':("form-control input-sm"),'onchange':("this.form.submit()")],-1)
printHtmlPart(12)
expressionOut.print(params?.query)
printHtmlPart(13)
invokeTag('submitButton','g',27,['name':("search"),'value':("Search"),'class':("btn btn-primary")],-1)
printHtmlPart(14)
})
invokeTag('form','g',31,[:],3)
printHtmlPart(15)
invokeTag('sortableColumn','g',35,['property':("id"),'title':(message(code: 'institution.id.label', default: 'ID'))],-1)
printHtmlPart(16)
invokeTag('sortableColumn','g',36,['property':("paramCode"),'title':(message(code: 'institution.paramCode.label', default: 'Param Code'))],-1)
printHtmlPart(16)
invokeTag('sortableColumn','g',37,['property':("caption"),'title':(message(code: 'institution.caption.label', default: 'Caption'))],-1)
printHtmlPart(16)
invokeTag('sortableColumn','g',38,['property':("paramValue"),'title':(message(code: 'institution.paramValue.label', default: 'Param Value'))],-1)
printHtmlPart(17)
loop:{
int i = 0
for( institutionInstance in (institutionInstanceList) ) {
printHtmlPart(18)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(19)
expressionOut.print(fieldValue(bean: institutionInstance, field: "id"))
printHtmlPart(20)
expressionOut.print(fieldValue(bean: institutionInstance, field: "paramCode"))
printHtmlPart(21)
expressionOut.print(fieldValue(bean: institutionInstance, field: "caption"))
printHtmlPart(22)
expressionOut.print(fieldValue(bean: institutionInstance, field: "paramValue"))
printHtmlPart(23)
expressionOut.print(i)
printHtmlPart(24)
expressionOut.print(i)
printHtmlPart(25)
invokeTag('textField','g',71,['class':("form-control"),'id':("pcode${i}"),'name':("glcode"),'value':(fieldValue(bean: institutionInstance, field: "paramCode")),'readonly':("readonly")],-1)
printHtmlPart(26)
invokeTag('textField','g',75,['class':("form-control"),'id':("caption${i}"),'name':("glcode"),'value':(fieldValue(bean: institutionInstance, field: "caption")),'readonly':("readonly")],-1)
printHtmlPart(27)
invokeTag('textField','g',79,['class':("form-control"),'id':("paramvalue${i}"),'name':("glcode"),'value':(fieldValue(bean: institutionInstance, field: "paramValue"))],-1)
printHtmlPart(28)
expressionOut.print(i)
printHtmlPart(29)
createTagBody(4, {->
printHtmlPart(30)
expressionOut.print(createLink(controller:'institution', action:'updateParamvalue'))
printHtmlPart(31)
})
invokeTag('javascript','g',135,[:],4)
printHtmlPart(32)
i++
}
}
printHtmlPart(33)
invokeTag('paginate','g',147,['total':(InstitutionInstanceCount ?: 0),'params':(params)],-1)
printHtmlPart(34)
})
invokeTag('captureContent','sitemesh',149,['tag':("main-content")],2)
printHtmlPart(35)
createTagBody(2, {->
printHtmlPart(36)
createClosureForHtmlPart(37, 3)
invokeTag('link','g',160,['onclick':("window.print();")],3)
printHtmlPart(38)
invokeTag('textField','g',174,['class':("form-control"),'id':("crtpcode"),'name':("crtpcode"),'value':("")],-1)
printHtmlPart(26)
invokeTag('textField','g',178,['class':("form-control"),'id':("crtcaption"),'name':("crtcaption"),'value':("")],-1)
printHtmlPart(39)
invokeTag('textField','g',182,['class':("form-control"),'id':("crtparamtype"),'name':("crtparamtype"),'value':("")],-1)
printHtmlPart(40)
invokeTag('textField','g',186,['class':("form-control"),'id':("crtparamvalue"),'name':("crtparamvalue"),'value':("")],-1)
printHtmlPart(41)
createTagBody(3, {->
printHtmlPart(42)
expressionOut.print(createLink(controller:'institution', action:'createNewInstitutionAjax'))
printHtmlPart(43)
})
invokeTag('javascript','g',251,[:],3)
printHtmlPart(44)
})
invokeTag('captureContent','sitemesh',261,['tag':("main-actions")],2)
printHtmlPart(4)
})
invokeTag('captureBody','sitemesh',262,[:],1)
printHtmlPart(45)
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
