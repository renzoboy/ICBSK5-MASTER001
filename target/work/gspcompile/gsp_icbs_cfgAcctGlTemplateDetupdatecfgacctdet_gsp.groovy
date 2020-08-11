import icbs.gl.CfgAcctGlTemplateDet
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_cfgAcctGlTemplateDetupdatecfgacctdet_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/cfgAcctGlTemplateDet/updatecfgacctdet.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
invokeTag('set','g',6,['var':("entityName"),'value':(message(code: 'cfgAcctGlTemplateDet.label', default: 'CfgAcctGlTemplateDet'))],-1)
printHtmlPart(1)
createTagBody(2, {->
createClosureForHtmlPart(2, 3)
invokeTag('captureTitle','sitemesh',7,['id':("titles")],3)
})
invokeTag('wrapTitleTag','sitemesh',7,[:],2)
printHtmlPart(3)
})
invokeTag('captureHead','sitemesh',8,[:],1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
for( detInstance in (CfgAcctGlTemplateDetInstance) ) {
printHtmlPart(5)
createTagBody(3, {->
printHtmlPart(5)
createTagBody(4, {->
printHtmlPart(6)
expressionOut.print(createLink(controller:'CfgAcctGlTemplateDet', action: 'insertnewcfgDetAjax'))
printHtmlPart(7)
expressionOut.print(createLink(controller:'CfgAcctGlTemplateDet', action: 'editCfgDetInformationAjax'))
printHtmlPart(8)
expressionOut.print(createLink(controller:'CfgAcctGlTemplateDet', action: 'checkGlcodeAjax'))
printHtmlPart(9)
expressionOut.print(createLink(controller:'CfgAcctGlTemplateDet', action: 'checkGlcodeAjax'))
printHtmlPart(10)
expressionOut.print(createLink(controller:'CfgAcctGlTemplateDet', action: 'updatecfgAcctGlDetAjax'))
printHtmlPart(11)
})
invokeTag('javascript','g',341,[:],4)
printHtmlPart(12)
expressionOut.print(hasErrors(bean: cfgAcctGlTemplateDetInstance, field: 'glDescription', 'has-error'))
printHtmlPart(13)
invokeTag('message','g',348,['code':("cfgAcctGlTemplateDet.glDescription.label"),'default':("GL Acct Template id")],-1)
printHtmlPart(14)
invokeTag('hiddenField','g',351,['id':("cfgdetid"),'name':("cfgdetid"),'value':(detInstance.id)],-1)
printHtmlPart(15)
invokeTag('hiddenField','g',352,['id':("cfgtemplateid"),'name':("cfgtemplateid"),'value':(detInstance.glTemplate.id)],-1)
printHtmlPart(15)
invokeTag('hiddenField','g',353,['id':("finyear"),'name':("finyear"),'value':(g.formatDate(date: (runDate), format: 'yyyy'))],-1)
printHtmlPart(15)
invokeTag('hiddenField','g',354,['id':("brchid"),'name':("brchid"),'value':(icbs.admin.Branch.findByName(session.branch).id)],-1)
printHtmlPart(16)
invokeTag('textField','g',357,['id':("cfgdescripss"),'name':("cfgdescripss"),'required':(""),'value':(icbs.gl.CfgAcctGlTemplate.findById(detInstance.glTemplate.id).description),'class':("form-control"),'readonly':("readonly")],-1)
printHtmlPart(17)
expressionOut.print(hasErrors(bean: cfgAcctGlTemplateDetInstance, field: 'glDescription', 'has-error'))
printHtmlPart(18)
invokeTag('message','g',363,['code':("cfgAcctGlTemplateDet.glDescription.label"),'default':("Transaction Type")],-1)
printHtmlPart(19)
invokeTag('select','g',367,['id':("transactionType"),'name':("transactionType"),'required':("true"),'noSelection':(['':'']),'from':(icbs.lov.GlLinkEntryType.findAllByStatus(true)),'value':(detInstance.transactionType),'optionKey':("id"),'optionValue':("description"),'onChange':("changeDropdownStatus();"),'disabled':("true"),'class':("form-control")],-1)
printHtmlPart(20)
expressionOut.print(hasErrors(bean: cfgAcctGlTemplateDetInstance, field: 'glDescription', 'has-error'))
printHtmlPart(18)
invokeTag('message','g',374,['code':("cfgAcctGlTemplateDet.glDescription.label"),'default':("Status")],-1)
printHtmlPart(21)
invokeTag('select','g',378,['id':("status"),'name':("status"),'required':("true"),'noSelection':(['':' ']),'from':(icbs.lov.DepositStatus.findAll{id == 2 || id == 5}),'value':(detInstance.status),'optionKey':("id"),'optionValue':("description"),'onChange':("statusDropDown();"),'disabled':("true"),'class':("form-control")],-1)
printHtmlPart(22)
expressionOut.print(hasErrors(bean: cfgAcctGlTemplateDetInstance, field: 'glDescription', 'has-error'))
printHtmlPart(18)
invokeTag('message','g',385,['code':("cfgAcctGlTemplateDet.glDescription.label"),'default':("Status")],-1)
printHtmlPart(21)
invokeTag('select','g',389,['id':("status1"),'name':("status1"),'required':("true"),'noSelection':(['':'']),'from':(icbs.lov.LoanPerformanceId.findAllByStatus(true)),'value':(detInstance.status),'optionKey':("id"),'optionValue':("description"),'onChange':("statusDropDown();"),'disabled':("true"),'class':("form-control")],-1)
printHtmlPart(23)
expressionOut.print(hasErrors(bean: cfgAcctGlTemplateDetInstance, field: 'glDescription', 'has-error'))
printHtmlPart(18)
invokeTag('message','g',396,['code':("cfgAcctGlTemplateDet.glDescription.label"),'default':("Ordinal Position")],-1)
printHtmlPart(24)
invokeTag('select','g',399,['id':("ordinals"),'name':("ordinals"),'from':(0..3),'value':(detInstance.ordinalPos),'noSelection':(['':'-Choose Ordinal Position']),'disabled':("true"),'onChange':("checkDuplicatesCfgAcctGlTemplateDetAjax();")],-1)
printHtmlPart(25)
expressionOut.print(hasErrors(bean: cfgAcctGlTemplateDetInstance, field: 'glDescription', 'has-error'))
printHtmlPart(18)
invokeTag('message','g',405,['code':("cfgAcctGlTemplateDet.glDescription.label"),'default':("Ordinal Position")],-1)
printHtmlPart(26)
invokeTag('select','g',408,['id':("ordinals"),'name':("ordinals"),'from':(0..9),'value':(detInstance.ordinalPos),'noSelection':(['':'-Choose Ordinal Position']),'disabled':("true"),'onChange':("checkDuplicatesCfgAcctGlTemplateDetAjax();")],-1)
printHtmlPart(27)
invokeTag('select','g',411,['id':("ordinals"),'name':("ordinals"),'from':(0..8),'value':(detInstance.ordinalPos),'noSelection':(['':'-Choose Ordinal Position']),'disabled':("true"),'onChange':("checkDuplicatesCfgAcctGlTemplateDetAjax();")],-1)
printHtmlPart(28)
expressionOut.print(hasErrors(bean: cfgAcctGlTemplateDetInstance, field: 'glDescription', 'has-error'))
printHtmlPart(18)
invokeTag('message','g',419,['code':("cfgAcctGlTemplateDet.glDescription.label"),'default':("GL Code")],-1)
printHtmlPart(24)
invokeTag('textField','g',422,['id':("glCode"),'name':("glCode"),'required':(""),'value':(detInstance.glCode),'class':("form-control")],-1)
printHtmlPart(29)
createTagBody(4, {->
printHtmlPart(30)
createTagBody(5, {->
printHtmlPart(31)
invokeTag('message','g',428,['error':(it)],-1)
printHtmlPart(32)
})
invokeTag('eachError','g',429,['bean':(cfgAcctGlTemplateDetInstance),'field':("glCode")],5)
printHtmlPart(33)
})
invokeTag('hasErrors','g',432,['bean':(cfgAcctGlTemplateDetInstance),'field':("glCode")],4)
printHtmlPart(34)
expressionOut.print(hasErrors(bean: cfgAcctGlTemplateDetInstance, field: 'glDescription', 'has-error'))
printHtmlPart(18)
invokeTag('message','g',438,['code':("cfgAcctGlTemplateDet.glDescription.label"),'default':("GL Description")],-1)
printHtmlPart(24)
invokeTag('textField','g',441,['id':("glDescription"),'name':("glDescription"),'required':(""),'value':(detInstance.glDescription),'class':("form-control")],-1)
printHtmlPart(29)
createTagBody(4, {->
printHtmlPart(30)
createTagBody(5, {->
printHtmlPart(31)
invokeTag('message','g',447,['error':(it)],-1)
printHtmlPart(32)
})
invokeTag('eachError','g',448,['bean':(cfgAcctGlTemplateDetInstance),'field':("glDescription")],5)
printHtmlPart(33)
})
invokeTag('hasErrors','g',451,['bean':(cfgAcctGlTemplateDetInstance),'field':("glDescription")],4)
printHtmlPart(35)
})
invokeTag('captureContent','sitemesh',458,['tag':("main-content")],3)
printHtmlPart(5)
createTagBody(3, {->
printHtmlPart(36)
createClosureForHtmlPart(37, 4)
invokeTag('link','g',463,['action':("show"),'id':(params.id)],4)
printHtmlPart(38)
})
invokeTag('captureContent','sitemesh',466,['tag':("main-actions")],3)
printHtmlPart(39)
}
printHtmlPart(3)
})
invokeTag('captureBody','sitemesh',468,[:],1)
printHtmlPart(40)
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
