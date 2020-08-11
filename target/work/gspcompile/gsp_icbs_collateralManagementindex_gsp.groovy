import icbs.loans.Collateral
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_collateralManagementindex_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/collateralManagement/index.gsp" }
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
createTagBody(2, {->
createClosureForHtmlPart(3, 3)
invokeTag('captureTitle','sitemesh',7,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',7,[:],2)
printHtmlPart(4)
})
invokeTag('captureHead','sitemesh',8,[:],1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(5)
createClosureForHtmlPart(6, 2)
invokeTag('captureContent','sitemesh',12,['tag':("breadcrumbs")],2)
printHtmlPart(5)
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
invokeTag('select','g',28,['name':("max"),'value':(params.max),'from':([25, 50, 75, 100]),'class':("form-control input-sm"),'onchange':("this.form.submit()")],-1)
printHtmlPart(12)
invokeTag('textField','g',31,['type':("text"),'name':("query"),'class':("form-control"),'placeholder':("Enter Collateral ID")],-1)
printHtmlPart(13)
invokeTag('submitButton','g',33,['name':("Search"),'class':("btn btn-primary")],-1)
printHtmlPart(14)
})
invokeTag('form','g',38,[:],3)
printHtmlPart(15)
invokeTag('sortableColumn','g',44,['property':("id"),'title':("ID")],-1)
printHtmlPart(16)
invokeTag('sortableColumn','g',46,['property':("collateralType.owner.displayName"),'title':("Owner")],-1)
printHtmlPart(17)
invokeTag('sortableColumn','g',48,['property':("collateralType.description"),'title':("Type")],-1)
printHtmlPart(18)
invokeTag('sortableColumn','g',50,['property':("appraisedValue"),'title':("Appraised Value")],-1)
printHtmlPart(16)
invokeTag('sortableColumn','g',52,['property':("description"),'title':("Description")],-1)
printHtmlPart(16)
invokeTag('sortableColumn','g',54,['property':("status.description"),'title':("Status")],-1)
printHtmlPart(19)
loop:{
int i = 0
for( collateralInstance in (collateralInstanceList) ) {
printHtmlPart(20)
expressionOut.print((i % 2) == 0 ? 'even' : 'odd')
printHtmlPart(21)
expressionOut.print(fieldValue(bean: collateralInstance, field: "id"))
printHtmlPart(22)
expressionOut.print(collateralInstance?.owner?.displayName)
printHtmlPart(22)
expressionOut.print(collateralInstance?.collateralType?.description)
printHtmlPart(23)
invokeTag('formatNumber','g',70,['format':("###,###,##0.00"),'number':(collateralInstance?.appraisedValue)],-1)
printHtmlPart(24)
expressionOut.print(collateralInstance?.description)
printHtmlPart(25)
expressionOut.print(collateralInstance?.status?.description)
printHtmlPart(23)
createClosureForHtmlPart(26, 4)
invokeTag('link','g',76,['class':("btn btn-secondary"),'action':("show"),'id':(collateralInstance.id)],4)
printHtmlPart(27)
i++
}
}
printHtmlPart(28)
invokeTag('paginate','g',84,['total':(collateralInstanceCount ?: 0),'params':(params)],-1)
printHtmlPart(29)
})
invokeTag('captureContent','sitemesh',87,['tag':("main-content")],2)
printHtmlPart(5)
createTagBody(2, {->
printHtmlPart(30)
createClosureForHtmlPart(31, 3)
invokeTag('link','g',90,['class':("create"),'action':("create")],3)
printHtmlPart(32)
createTagBody(3, {->
printHtmlPart(33)
expressionOut.print(icbs.admin.Institution.get(94).paramValue)
expressionOut.print(icbs.admin.Report.get(18).baseParams)
printHtmlPart(34)
expressionOut.print(icbs.admin.Report.get(18).outputParam)
printHtmlPart(35)
expressionOut.print(icbs.admin.Report.get(18).reportUnit)
printHtmlPart(36)
expressionOut.print(icbs.admin.UserMaster.get(session.user_id).username)
printHtmlPart(37)
})
invokeTag('javascript','g',99,[:],3)
printHtmlPart(38)
})
invokeTag('captureContent','sitemesh',101,['tag':("main-actions")],2)
printHtmlPart(4)
})
invokeTag('captureBody','sitemesh',102,[:],1)
printHtmlPart(39)
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
