import icbs.loans.Collateral
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_ropa_details_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/ropa/details/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: collateralInstance, field: 'owner', 'has-error'))
printHtmlPart(1)
invokeTag('message','g',7,['code':("collateral.owner.label"),'default':("Owner")],-1)
printHtmlPart(2)
invokeTag('field','g',10,['name':("owner-name"),'value':(collateralInstance?.owner?.displayName),'class':("form-control"),'readonly':("true")],-1)
printHtmlPart(3)
invokeTag('hiddenField','g',11,['id':("owner"),'name':("owner.id"),'value':(collateralInstance?.owner?.id)],-1)
printHtmlPart(4)
createTagBody(1, {->
printHtmlPart(5)
expressionOut.print(it)
printHtmlPart(6)
})
invokeTag('hasErrors','g',22,['bean':(collateralInstance),'field':("owner")],1)
printHtmlPart(7)
expressionOut.print(hasErrors(bean: collateralInstance, field: 'collateralType', 'has-error'))
printHtmlPart(8)
invokeTag('message','g',30,['code':("collateral.collateralType.label"),'default':("Collateral Type")],-1)
printHtmlPart(9)
invokeTag('select','g',32,['id':("collateralType"),'name':("collateralType.id"),'from':(icbs.lov.LoanCollateralType.list()),'optionKey':("id"),'optionValue':("description"),'value':(collateralInstance?.collateralType?.id),'class':("many-to-one form-control"),'onchange':("updateForm()")],-1)
printHtmlPart(10)
createTagBody(1, {->
printHtmlPart(11)
createTagBody(2, {->
printHtmlPart(12)
invokeTag('message','g',38,['error':(it)],-1)
printHtmlPart(13)
})
invokeTag('eachError','g',39,['bean':(collateralInstance),'field':("collateralType")],2)
printHtmlPart(14)
})
invokeTag('hasErrors','g',42,['bean':(collateralInstance),'field':("collateralType")],1)
printHtmlPart(15)
expressionOut.print(hasErrors(bean: collateralInstance, field: 'appraisedValue', 'has-error'))
printHtmlPart(16)
invokeTag('message','g',48,['code':("collateral.appraisedValue.label"),'default':("Appraised Value")],-1)
printHtmlPart(17)
invokeTag('field','g',51,['name':("appraisedValue"),'value':(collateralInstance?.appraisedValue),'class':("form-control truncated")],-1)
printHtmlPart(18)
createTagBody(1, {->
printHtmlPart(19)
expressionOut.print(it)
printHtmlPart(20)
})
invokeTag('hasErrors','g',62,['bean':(collateralInstance),'field':("appraisedValue")],1)
printHtmlPart(21)
expressionOut.print(hasErrors(bean: remInstance, field: 'appraisedValueType', 'has-error'))
printHtmlPart(22)
invokeTag('message','g',68,['code':("rem.appraisedValueType.label"),'default':("Appraised Value Type")],-1)
printHtmlPart(23)
invokeTag('select','g',70,['id':("appraisedValueType"),'name':("appraisedValueType.id"),'from':(icbs.lov.AppraisedValueType.list()),'optionKey':("id"),'optionValue':("description"),'value':(remInstance?.appraisedValueType?.id),'class':("many-to-one form-control")],-1)
printHtmlPart(10)
createTagBody(1, {->
printHtmlPart(24)
expressionOut.print(it)
printHtmlPart(20)
})
invokeTag('hasErrors','g',81,['bean':(remInstance),'field':("appraisedValueType")],1)
printHtmlPart(15)
expressionOut.print(hasErrors(bean: collateralInstance, field: 'description', 'has-error'))
printHtmlPart(25)
invokeTag('message','g',87,['code':("collateral.description.label"),'default':("Description")],-1)
printHtmlPart(9)
invokeTag('textArea','g',89,['name':("description"),'value':(collateralInstance?.description),'rows':("3"),'class':("form-control")],-1)
printHtmlPart(18)
createTagBody(1, {->
printHtmlPart(11)
createTagBody(2, {->
printHtmlPart(12)
invokeTag('message','g',95,['error':(it)],-1)
printHtmlPart(13)
})
invokeTag('eachError','g',96,['bean':(collateralInstance),'field':("description")],2)
printHtmlPart(14)
})
invokeTag('hasErrors','g',99,['bean':(collateralInstance),'field':("description")],1)
printHtmlPart(26)
invokeTag('render','g',104,['template':("rem/form")],-1)
printHtmlPart(27)
invokeTag('render','g',108,['template':("chattel/form")],-1)
printHtmlPart(28)
invokeTag('render','g',112,['template':("holdout/form")],-1)
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
