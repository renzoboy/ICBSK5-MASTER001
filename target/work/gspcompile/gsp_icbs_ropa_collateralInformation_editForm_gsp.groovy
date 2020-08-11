import icbs.admin.UserMaster
import icbs.lov.ConfigItemStatus
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_ropa_collateralInformation_editForm_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/ropa/collateralInformation/_editForm.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
expressionOut.print(hasErrors(bean: collateralInstance, field: 'forClosureDate', 'has-error'))
printHtmlPart(2)
invokeTag('customDatePicker','g',5,['name':("forClosureDate"),'precision':("day"),'class':("form-control"),'value':(collateralInstance?.forClosureDate)],-1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(5)
invokeTag('message','g',11,['error':(it)],-1)
printHtmlPart(6)
})
invokeTag('eachError','g',12,['bean':(collateralInstance),'field':("forClosureDate")],2)
printHtmlPart(7)
})
invokeTag('hasErrors','g',15,['bean':(collateralInstance),'field':("forClosureDate")],1)
printHtmlPart(8)
expressionOut.print(hasErrors(bean: collateralInstance, field: 'certificateDate', 'has-error'))
printHtmlPart(9)
invokeTag('customDatePicker','g',20,['name':("certificateDate"),'precision':("day"),'class':("form-control"),'value':(collateralInstance?.certificateDate)],-1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(5)
invokeTag('message','g',26,['error':(it)],-1)
printHtmlPart(6)
})
invokeTag('eachError','g',27,['bean':(collateralInstance),'field':("certificateDate")],2)
printHtmlPart(7)
})
invokeTag('hasErrors','g',30,['bean':(collateralInstance),'field':("certificateDate")],1)
printHtmlPart(8)
expressionOut.print(hasErrors(bean: collateralInstance, field: 'certificateRegistrationDate', 'has-error'))
printHtmlPart(10)
invokeTag('customDatePicker','g',35,['name':("certificateRegistrationDate"),'precision':("day"),'class':("form-control"),'value':(collateralInstance?.certificateRegistrationDate)],-1)
printHtmlPart(11)
createTagBody(1, {->
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(5)
invokeTag('message','g',40,['error':(it)],-1)
printHtmlPart(6)
})
invokeTag('eachError','g',41,['bean':(collateralInstance),'field':("certificateRegistrationDate")],2)
printHtmlPart(7)
})
invokeTag('hasErrors','g',44,['bean':(collateralInstance),'field':("certificateRegistrationDate")],1)
printHtmlPart(8)
expressionOut.print(hasErrors(bean: collateralInstance, field: 'notarizationOfDacionDate', 'has-error'))
printHtmlPart(12)
invokeTag('customDatePicker','g',49,['name':("notarizationOfDacionDate"),'precision':("day"),'class':("form-control"),'value':(collateralInstance?.notarizationOfDacionDate)],-1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(5)
invokeTag('message','g',55,['error':(it)],-1)
printHtmlPart(6)
})
invokeTag('eachError','g',56,['bean':(collateralInstance),'field':("notarizationOfDacionDate")],2)
printHtmlPart(7)
})
invokeTag('hasErrors','g',59,['bean':(collateralInstance),'field':("notarizationOfDacionDate")],1)
printHtmlPart(8)
expressionOut.print(hasErrors(bean: collateralInstance, field: 'consolidatedDate', 'has-error'))
printHtmlPart(13)
invokeTag('customDatePicker','g',64,['name':("consolidatedDate"),'precision':("day"),'class':("form-control"),'value':(collateralInstance?.consolidatedDate)],-1)
printHtmlPart(11)
createTagBody(1, {->
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(5)
invokeTag('message','g',69,['error':(it)],-1)
printHtmlPart(6)
})
invokeTag('eachError','g',70,['bean':(collateralInstance),'field':("consolidatedDate")],2)
printHtmlPart(7)
})
invokeTag('hasErrors','g',73,['bean':(collateralInstance),'field':("consolidatedDate")],1)
printHtmlPart(8)
expressionOut.print(hasErrors(bean: collateralInstance, field: 'consolidatedTitleNumber', 'has-error'))
printHtmlPart(14)
invokeTag('message','g',78,['code':("RopaCollateralDetails.consolidatedTitleNumber.label"),'default':("Consolidated Title Number")],-1)
printHtmlPart(15)
invokeTag('field','g',80,['name':("consolidatedTitleNumber"),'id':("consolidatedTitleNumber"),'value':(collateralInstance?.consolidatedTitleNumber),'class':("form-control")],-1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(16)
createTagBody(2, {->
printHtmlPart(17)
invokeTag('message','g',86,['error':(it)],-1)
printHtmlPart(18)
})
invokeTag('eachError','g',87,['bean':(collateralInstance),'field':("consolidatedTitleNumber")],2)
printHtmlPart(19)
})
invokeTag('hasErrors','g',90,['bean':(collateralInstance),'field':("consolidatedTitleNumber")],1)
printHtmlPart(20)
expressionOut.print(hasErrors(bean: collateralInstance, field: 'fireInsuranceAmt', 'has-error'))
printHtmlPart(21)
invokeTag('message','g',96,['code':("RopaCollateralDetails.fireInsuranceAmt.label"),'default':("Amount of Fire Insurance Coverage")],-1)
printHtmlPart(15)
invokeTag('field','g',98,['name':("fireInsuranceAmt"),'id':("fireInsuranceAmt"),'value':(collateralInstance?.fireInsuranceAmt),'class':("form-control truncated")],-1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(22)
createTagBody(2, {->
printHtmlPart(17)
invokeTag('message','g',104,['error':(it)],-1)
printHtmlPart(18)
})
invokeTag('eachError','g',105,['bean':(collateralInstance),'field':("fireInsuranceAmt")],2)
printHtmlPart(19)
})
invokeTag('hasErrors','g',108,['bean':(collateralInstance),'field':("fireInsuranceAmt")],1)
printHtmlPart(8)
expressionOut.print(hasErrors(bean: collateralInstance, field: 'fireInsurancePolicyNo', 'has-error'))
printHtmlPart(23)
invokeTag('message','g',113,['code':("RopaCollateralDetails.fireInsurancePolicyNo.label"),'default':("Fire Insurance Policy Number")],-1)
printHtmlPart(15)
invokeTag('field','g',115,['name':("fireInsurancePolicyNo"),'id':("fireInsurancePolicyNo"),'value':(collateralInstance?.fireInsurancePolicyNo),'class':("form-control ")],-1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(22)
createTagBody(2, {->
printHtmlPart(17)
invokeTag('message','g',121,['error':(it)],-1)
printHtmlPart(18)
})
invokeTag('eachError','g',122,['bean':(collateralInstance),'field':("fireInsurancePolicyNo")],2)
printHtmlPart(19)
})
invokeTag('hasErrors','g',125,['bean':(collateralInstance),'field':("fireInsurancePolicyNo")],1)
printHtmlPart(8)
expressionOut.print(hasErrors(bean: collateralInstance, field: 'fireInsuranceStartDate', 'has-error'))
printHtmlPart(24)
invokeTag('customDatePicker','g',130,['name':("fireInsuranceStartDate"),'precision':("day"),'class':("form-control"),'value':(collateralInstance?.fireInsuranceStartDate)],-1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(5)
invokeTag('message','g',136,['error':(it)],-1)
printHtmlPart(6)
})
invokeTag('eachError','g',137,['bean':(collateralInstance),'field':("fireInsuranceStartDate")],2)
printHtmlPart(7)
})
invokeTag('hasErrors','g',140,['bean':(collateralInstance),'field':("fireInsuranceStartDate")],1)
printHtmlPart(8)
expressionOut.print(hasErrors(bean: collateralInstance, field: 'fireInsuranceEndDate', 'has-error'))
printHtmlPart(25)
invokeTag('customDatePicker','g',145,['name':("fireInsuranceEndDate"),'precision':("day"),'class':("form-control"),'value':(collateralInstance?.fireInsuranceEndDate)],-1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(5)
invokeTag('message','g',151,['error':(it)],-1)
printHtmlPart(6)
})
invokeTag('eachError','g',152,['bean':(collateralInstance),'field':("fireInsuranceStartDate")],2)
printHtmlPart(7)
})
invokeTag('hasErrors','g',155,['bean':(collateralInstance),'field':("fireInsuranceEndDate")],1)
printHtmlPart(20)
expressionOut.print(hasErrors(bean: collateralInstance, field: 'latestRatrDate', 'has-error'))
printHtmlPart(26)
invokeTag('customDatePicker','g',163,['name':("latestRatrDate"),'precision':("day"),'class':("form-control"),'value':(collateralInstance?.latestRatrDate)],-1)
printHtmlPart(3)
createTagBody(1, {->
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(5)
invokeTag('message','g',169,['error':(it)],-1)
printHtmlPart(6)
})
invokeTag('eachError','g',170,['bean':(collateralInstance),'field':("latestRatrDate")],2)
printHtmlPart(7)
})
invokeTag('hasErrors','g',173,['bean':(collateralInstance),'field':("latestRatrDate")],1)
printHtmlPart(27)
if(true && (collateralInstance?.appraisedBy == null)) {
printHtmlPart(1)
expressionOut.print(hasErrors(bean: collateralInstance, field: 'appraisedBy', 'has-error'))
printHtmlPart(28)
invokeTag('message','g',179,['code':("RopaCollateralDetails.appraisedBy.label"),'default':("Appraise by")],-1)
printHtmlPart(15)
invokeTag('select','g',181,['id':("appraisedBy"),'name':("appraisedBy"),'from':(icbs.admin.UserMaster.findAllByConfigItemStatus(ConfigItemStatus.get(2))),'optionKey':("id"),'optionValue':("name"),'required':(""),'value':(collateralInstance?.appraisedBy),'noSelection':(['':'Select Appraised by']),'class':("form-control")],-1)
printHtmlPart(11)
createTagBody(2, {->
printHtmlPart(29)
createTagBody(3, {->
printHtmlPart(17)
invokeTag('message','g',187,['error':(it)],-1)
printHtmlPart(18)
})
invokeTag('eachError','g',188,['bean':(collateralInstance),'field':("appraisedBy")],3)
printHtmlPart(19)
})
invokeTag('hasErrors','g',191,['bean':(collateralInstance),'field':("appraisedBy")],2)
printHtmlPart(27)
}
else {
printHtmlPart(1)
expressionOut.print(hasErrors(bean: collateralInstance, field: 'appraisedBy', 'has-error'))
printHtmlPart(28)
invokeTag('message','g',198,['code':("RopaCollateralDetails.appraisedBy.label"),'default':("Appraise by")],-1)
printHtmlPart(15)
invokeTag('select','g',200,['id':("appraisedBy"),'name':("appraisedBy"),'from':(icbs.admin.UserMaster.findAllByConfigItemStatus(ConfigItemStatus.get(2))),'optionKey':("id"),'optionValue':("name"),'required':(""),'value':(collateralInstance?.appraisedBy.id),'noSelection':(['':'Select Appraised by']),'class':("form-control")],-1)
printHtmlPart(11)
createTagBody(2, {->
printHtmlPart(22)
createTagBody(3, {->
printHtmlPart(17)
invokeTag('message','g',205,['error':(it)],-1)
printHtmlPart(18)
})
invokeTag('eachError','g',206,['bean':(collateralInstance),'field':("appraisedBy")],3)
printHtmlPart(19)
})
invokeTag('hasErrors','g',209,['bean':(collateralInstance),'field':("appraisedBy")],2)
printHtmlPart(27)
}
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
