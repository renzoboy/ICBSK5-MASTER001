import icbs.gl.CfgAcctGlTemplateDet
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_cfgAcctGlTemplateglLinkCreateNewEntry_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/cfgAcctGlTemplate/glLinkCreateNewEntry.gsp" }
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
createTagBody(2, {->
printHtmlPart(5)
expressionOut.print(createLink(uri: '/cfgAcctGlTemplate'))
printHtmlPart(6)
})
invokeTag('captureContent','sitemesh',13,['tag':("breadcrumbs")],2)
printHtmlPart(7)
createTagBody(2, {->
printHtmlPart(4)
createTagBody(3, {->
printHtmlPart(8)
expressionOut.print(createLink(controller:'CfgAcctGlTemplateDet', action:'checkduplicatesCfgglAcctDetAjax'))
printHtmlPart(9)
expressionOut.print(createLink(controller:'TxnTemplate', action:'validateExistingGlCodeAjax'))
printHtmlPart(10)
expressionOut.print(createLink(controller:'CfgAcctGlTemplateDet', action: 'insertnewcfgDetAjax'))
printHtmlPart(11)
expressionOut.print(createLink(controller:'CfgAcctGlTemplateDet', action: 'editCfgDetInformationAjax'))
printHtmlPart(12)
expressionOut.print(createLink(controller:'CfgAcctGlTemplateDet', action: 'checkGlcodeAjax'))
printHtmlPart(13)
})
invokeTag('javascript','g',399,[:],3)
printHtmlPart(14)
expressionOut.print(hasErrors(bean: cfgAcctGlTemplateDetInstance, field: 'glDescription', 'has-error'))
printHtmlPart(15)
invokeTag('message','g',405,['code':("cfgAcctGlTemplateDet.glDescription.label"),'default':("GL Acct Template id")],-1)
printHtmlPart(16)
invokeTag('hiddenField','g',408,['id':("cfgdetid"),'name':("cfgdetid"),'value':("")],-1)
printHtmlPart(17)
invokeTag('hiddenField','g',409,['id':("cfgtemplateid"),'name':("cfgtemplateid"),'value':(params.id)],-1)
printHtmlPart(17)
invokeTag('hiddenField','g',410,['id':("finyear"),'name':("finyear"),'value':(g.formatDate(date: (runDate), format: 'yyyy'))],-1)
printHtmlPart(17)
invokeTag('hiddenField','g',411,['id':("brchid"),'name':("brchid"),'value':(icbs.admin.Branch.findByName(session.branch).id)],-1)
printHtmlPart(17)
invokeTag('hiddenField','g',412,['id':("financialYear"),'name':("financialYear"),'value':(g.formatDate(date: (runDate), format: 'yyyy'))],-1)
printHtmlPart(18)
invokeTag('textField','g',414,['id':("cfgdescripss"),'name':("cfgdescripss"),'required':(""),'value':(icbs.gl.CfgAcctGlTemplate.findById(params.id).description),'class':("form-control"),'readonly':("readonly")],-1)
printHtmlPart(19)
expressionOut.print(hasErrors(bean: cfgAcctGlTemplateDetInstance, field: 'glDescription', 'has-error'))
printHtmlPart(15)
invokeTag('message','g',420,['code':("cfgAcctGlTemplateDet.glDescription.label"),'default':("Transaction Type")],-1)
printHtmlPart(20)
invokeTag('select','g',424,['id':("transactionType"),'name':("transactionType"),'required':("true"),'noSelection':(['':'']),'from':(icbs.lov.GlLinkEntryType.findAllByStatus(true)),'value':(""),'optionKey':("id"),'optionValue':("description"),'onChange':("changeDropdownStatus();"),'class':("form-control")],-1)
printHtmlPart(21)
expressionOut.print(hasErrors(bean: cfgAcctGlTemplateDetInstance, field: 'glDescription', 'has-error'))
printHtmlPart(15)
invokeTag('message','g',431,['code':("cfgAcctGlTemplateDet.glDescription.label"),'default':("Status")],-1)
printHtmlPart(22)
invokeTag('select','g',435,['id':("status"),'name':("status"),'required':("true"),'noSelection':(['':' ']),'from':(icbs.lov.DepositStatus.findAll{id == 2 || id == 5}),'value':(""),'optionKey':("id"),'optionValue':("description"),'onChange':("statusDropDown();"),'class':("form-control")],-1)
printHtmlPart(23)
expressionOut.print(hasErrors(bean: cfgAcctGlTemplateDetInstance, field: 'glDescription', 'has-error'))
printHtmlPart(15)
invokeTag('message','g',442,['code':("cfgAcctGlTemplateDet.glDescription.label"),'default':("Status")],-1)
printHtmlPart(22)
invokeTag('select','g',446,['id':("status1"),'name':("status1"),'required':("true"),'noSelection':(['':'']),'from':(icbs.lov.LoanPerformanceId.findAllByStatus(true)),'value':(""),'optionKey':("id"),'optionValue':("description"),'onChange':("statusDropDown();"),'class':("form-control")],-1)
printHtmlPart(24)
expressionOut.print(hasErrors(bean: cfgAcctGlTemplateDetInstance, field: 'glDescription', 'has-error'))
printHtmlPart(15)
invokeTag('message','g',453,['code':("cfgAcctGlTemplateDet.glDescription.label"),'default':("Ordinal Position")],-1)
printHtmlPart(25)
invokeTag('select','g',456,['id':("ordinals"),'name':("ordinals"),'from':(icbs.lov.GlOrdinalPos.findAllByTransactionType(1)),'optionKey':("id"),'optionValue':("description"),'value':(""),'noSelection':(['':'-Choose Ordinal Position']),'onChange':("checkDuplicatesCfgAcctGlTemplateDetAjax(this.value);"),'class':("form-control")],-1)
printHtmlPart(26)
expressionOut.print(hasErrors(bean: cfgAcctGlTemplateDetInstance, field: 'glDescription', 'has-error'))
printHtmlPart(15)
invokeTag('message','g',462,['code':("cfgAcctGlTemplateDet.glDescription.label"),'default':("Ordinal Position")],-1)
printHtmlPart(27)
invokeTag('select','g',465,['id':("ordinals"),'name':("ordinals"),'from':(icbs.lov.GlOrdinalPos.findAllByTransactionType(6)),'value':(""),'optionKey':("id"),'optionValue':("description"),'noSelection':(['':'-Choose Ordinal Position']),'onChange':("checkDuplicatesCfgAcctGlTemplateDetAjax(this.value);"),'class':("form-control")],-1)
printHtmlPart(28)
invokeTag('select','g',468,['id':("ordinals"),'name':("ordinals"),'from':(icbs.lov.GlOrdinalPos.findAllByTransactionTypeAndIdNotEqual(6,15)),'value':(""),'optionKey':("id"),'optionValue':("description"),'noSelection':(['':'-Choose Ordinal Position']),'onChange':("checkDuplicatesCfgAcctGlTemplateDetAjax(this.value);"),'class':("form-control")],-1)
printHtmlPart(29)
expressionOut.print(hasErrors(bean: cfgAcctGlTemplateDetInstance, field: 'glDescription', 'has-error'))
printHtmlPart(15)
invokeTag('message','g',476,['code':("cfgAcctGlTemplateDet.glDescription.label"),'default':("GL Code")],-1)
printHtmlPart(25)
invokeTag('textField','g',479,['id':("glCode"),'name':("glCode"),'required':(""),'value':(""),'onblur':("validateGlCode();"),'class':("form-control")],-1)
printHtmlPart(30)
createTagBody(3, {->
printHtmlPart(31)
createTagBody(4, {->
printHtmlPart(32)
invokeTag('message','g',485,['error':(it)],-1)
printHtmlPart(33)
})
invokeTag('eachError','g',486,['bean':(cfgAcctGlTemplateDetInstance),'field':("glCode")],4)
printHtmlPart(34)
})
invokeTag('hasErrors','g',489,['bean':(cfgAcctGlTemplateDetInstance),'field':("glCode")],3)
printHtmlPart(35)
expressionOut.print(hasErrors(bean: cfgAcctGlTemplateDetInstance, field: 'glDescription', 'has-error'))
printHtmlPart(15)
invokeTag('message','g',495,['code':("cfgAcctGlTemplateDet.glDescription.label"),'default':("GL Description")],-1)
printHtmlPart(25)
invokeTag('textField','g',498,['id':("glDescription"),'name':("glDescription"),'required':(""),'value':(""),'class':("form-control")],-1)
printHtmlPart(30)
createTagBody(3, {->
printHtmlPart(31)
createTagBody(4, {->
printHtmlPart(32)
invokeTag('message','g',504,['error':(it)],-1)
printHtmlPart(33)
})
invokeTag('eachError','g',505,['bean':(cfgAcctGlTemplateDetInstance),'field':("glDescription")],4)
printHtmlPart(34)
})
invokeTag('hasErrors','g',508,['bean':(cfgAcctGlTemplateDetInstance),'field':("glDescription")],3)
printHtmlPart(36)
})
invokeTag('captureContent','sitemesh',515,['tag':("main-content")],2)
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(37)
createClosureForHtmlPart(38, 3)
invokeTag('link','g',520,['action':("show"),'id':(params.id)],3)
printHtmlPart(39)
})
invokeTag('captureContent','sitemesh',522,['tag':("main-actions")],2)
printHtmlPart(40)
})
invokeTag('captureBody','sitemesh',524,[:],1)
printHtmlPart(41)
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
