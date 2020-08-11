import icbs.gl.AccountsPayable
import icbs.gl.GlAccount
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_roparopaCreateAccdep_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/ropa/ropaCreateAccdep.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
createTagBody(1, {->
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',6,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(3)
if(true && (params?.actionType == "debit")) {
printHtmlPart(4)
createTagBody(3, {->
createClosureForHtmlPart(5, 4)
invokeTag('captureTitle','sitemesh',8,[:],4)
})
invokeTag('wrapTitleTag','sitemesh',8,[:],3)
printHtmlPart(3)
}
else {
printHtmlPart(4)
createTagBody(3, {->
createClosureForHtmlPart(6, 4)
invokeTag('captureTitle','sitemesh',11,[:],4)
})
invokeTag('wrapTitleTag','sitemesh',11,[:],3)
printHtmlPart(3)
}
printHtmlPart(7)
})
invokeTag('captureHead','sitemesh',13,[:],1)
printHtmlPart(8)
createTagBody(1, {->
printHtmlPart(3)
createTagBody(2, {->
printHtmlPart(9)
expressionOut.print(createLink(uri: '/showRopaAccDepDetails'))
printHtmlPart(10)
})
invokeTag('captureContent','sitemesh',18,['tag':("breadcrumbs")],2)
printHtmlPart(3)
createTagBody(2, {->
printHtmlPart(11)
if(true && (flash.message)) {
printHtmlPart(12)
expressionOut.print(flash.message)
printHtmlPart(13)
}
printHtmlPart(14)
createTagBody(3, {->
printHtmlPart(15)
invokeTag('field','g',43,['class':("form-control"),'id':("xx"),'name':("xx"),'value':(icbs.admin.Branch.get(1).runDate.format("YYYY/MM/dd")),'readonly':("true")],-1)
printHtmlPart(16)
if(true && (params?.actionType == "debit")) {
printHtmlPart(17)
invokeTag('field','g',51,['class':("form-control truncated"),'id':("debitAmt"),'name':("debitAmt"),'value':("")],-1)
printHtmlPart(18)
invokeTag('hiddenField','g',52,['name':("creditAmt"),'id':("creditAmt"),'value':("0.00")],-1)
printHtmlPart(19)
invokeTag('field','g',58,['class':("form-control truncated"),'id':("debitAmtOth"),'name':("debitAmtOth"),'value':("")],-1)
printHtmlPart(18)
invokeTag('hiddenField','g',59,['name':("creditAmtOth"),'id':("creditAmtOth"),'value':("0.00")],-1)
printHtmlPart(20)
}
else {
printHtmlPart(21)
invokeTag('field','g',68,['class':("form-control truncated"),'id':("creditAmt"),'name':("creditAmt"),'value':("")],-1)
printHtmlPart(22)
invokeTag('hiddenField','g',69,['name':("debitAmt"),'id':("debitAmt"),'value':("0.00")],-1)
printHtmlPart(23)
invokeTag('field','g',75,['class':("form-control truncated"),'id':("creditAmtOth"),'name':("creditAmtOth"),'value':("")],-1)
printHtmlPart(22)
invokeTag('hiddenField','g',76,['name':("debitAmtOth"),'id':("debitAmtOth"),'value':("0.00")],-1)
printHtmlPart(24)
}
printHtmlPart(25)
invokeTag('hiddenField','g',81,['name':("ropaColleteralId"),'id':("ropaColleteralId"),'value':(params?.id)],-1)
printHtmlPart(26)
invokeTag('hiddenField','g',82,['name':("ropaBldgAmtss"),'id':("ropaBldgAmtss"),'value':(ropaCollateralDetails.buildingAccDepreciation)],-1)
printHtmlPart(26)
invokeTag('hiddenField','g',83,['name':("ropaOtherAmtss"),'id':("ropaOtherAmtss"),'value':(ropaCollateralDetails.otherAccDepreciation)],-1)
printHtmlPart(27)
invokeTag('field','g',88,['class':("form-control"),'type':("Text"),'id':("reference"),'name':("reference"),'value':("")],-1)
printHtmlPart(28)
invokeTag('field','g',94,['class':("form-control"),'type':("Text"),'id':("particulars"),'name':("particulars"),'value':("")],-1)
printHtmlPart(29)
})
invokeTag('form','g',98,['id':("ropaAccDep"),'url':([action:'saveRopaAccDep', controller: 'ropa']),'method':("POST"),'onsubmit':("callLoadingDialog();")],3)
printHtmlPart(30)
createClosureForHtmlPart(31, 3)
invokeTag('javascript','g',164,[:],3)
printHtmlPart(3)
})
invokeTag('captureContent','sitemesh',165,['tag':("main-content")],2)
printHtmlPart(32)
createTagBody(2, {->
printHtmlPart(33)
createClosureForHtmlPart(34, 3)
invokeTag('link','g',170,['action':("showRopaAccDepDetails"),'controller':("ropa"),'id':(ropaCollateralDetails.id)],3)
printHtmlPart(35)
createClosureForHtmlPart(36, 3)
invokeTag('link','g',171,['action':("show"),'controller':("ropa"),'id':(ropaCollateralDetails.ropa.id)],3)
printHtmlPart(37)
})
invokeTag('captureContent','sitemesh',173,['tag':("main-actions")],2)
printHtmlPart(8)
})
invokeTag('captureBody','sitemesh',174,[:],1)
printHtmlPart(38)
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
