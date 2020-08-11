import icbs.admin.Branch
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_branch_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/branch/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
expressionOut.print(hasErrors(bean: branchInstance, field: 'code', 'has-error'))
printHtmlPart(1)
invokeTag('message','g',6,['code':("branch.code.label"),'default':("Code")],-1)
printHtmlPart(2)
if(true && (mode=='edit')) {
printHtmlPart(3)
invokeTag('textField','g',12,['name':("code"),'maxlength':("10"),'disabled':(""),'value':(fieldValue(bean: branchInstance, field: "code").padLeft(3, '0')),'class':("form-control")],-1)
printHtmlPart(4)
}
else {
printHtmlPart(3)
invokeTag('textField','g',15,['name':("code"),'maxlength':("10"),'required':(""),'value':(fieldValue(bean: branchInstance, field: "code").padLeft(3, '0')),'class':("form-control")],-1)
printHtmlPart(4)
}
printHtmlPart(5)
createTagBody(1, {->
printHtmlPart(6)
createTagBody(2, {->
printHtmlPart(7)
invokeTag('message','g',22,['error':(it)],-1)
printHtmlPart(8)
})
invokeTag('eachError','g',23,['bean':(branchInstance),'field':("code")],2)
printHtmlPart(9)
})
invokeTag('hasErrors','g',26,['bean':(branchInstance),'field':("code")],1)
printHtmlPart(10)
expressionOut.print(hasErrors(bean: branchInstance, field: 'name', 'has-error'))
printHtmlPart(11)
invokeTag('message','g',33,['code':("branch.name.label"),'default':("Name")],-1)
printHtmlPart(12)
invokeTag('textField','g',36,['name':("name"),'maxlength':("50"),'required':(""),'value':(branchInstance?.name),'class':("form-control")],-1)
printHtmlPart(5)
createTagBody(1, {->
printHtmlPart(6)
createTagBody(2, {->
printHtmlPart(7)
invokeTag('message','g',42,['error':(it)],-1)
printHtmlPart(8)
})
invokeTag('eachError','g',43,['bean':(branchInstance),'field':("name")],2)
printHtmlPart(9)
})
invokeTag('hasErrors','g',46,['bean':(branchInstance),'field':("name")],1)
printHtmlPart(10)
expressionOut.print(hasErrors(bean: branchInstance, field: 'swiftCode', 'has-error'))
printHtmlPart(13)
invokeTag('message','g',53,['code':("branch.swiftCode.label"),'default':("Swift Code")],-1)
printHtmlPart(12)
invokeTag('textField','g',56,['name':("swiftCode"),'maxlength':("50"),'required':(""),'value':(branchInstance?.swiftCode),'class':("form-control")],-1)
printHtmlPart(5)
createTagBody(1, {->
printHtmlPart(6)
createTagBody(2, {->
printHtmlPart(7)
invokeTag('message','g',62,['error':(it)],-1)
printHtmlPart(8)
})
invokeTag('eachError','g',63,['bean':(branchInstance),'field':("swiftCode")],2)
printHtmlPart(9)
})
invokeTag('hasErrors','g',66,['bean':(branchInstance),'field':("swiftCode")],1)
printHtmlPart(10)
expressionOut.print(hasErrors(bean: branchInstance, field: 'address', 'has-error'))
printHtmlPart(14)
invokeTag('message','g',73,['code':("branch.address.label"),'default':("Address")],-1)
printHtmlPart(12)
invokeTag('textArea','g',76,['name':("address"),'cols':("40"),'rows':("5"),'maxlength':("255"),'required':(""),'value':(branchInstance?.address),'class':("form-control")],-1)
printHtmlPart(5)
createTagBody(1, {->
printHtmlPart(6)
createTagBody(2, {->
printHtmlPart(7)
invokeTag('message','g',82,['error':(it)],-1)
printHtmlPart(8)
})
invokeTag('eachError','g',83,['bean':(branchInstance),'field':("address")],2)
printHtmlPart(9)
})
invokeTag('hasErrors','g',86,['bean':(branchInstance),'field':("address")],1)
printHtmlPart(10)
expressionOut.print(hasErrors(bean: branchInstance, field: 'country', 'has-error'))
printHtmlPart(15)
invokeTag('message','g',93,['code':("branch.country.label"),'default':("Country")],-1)
printHtmlPart(16)
invokeTag('select','g',96,['id':("country"),'name':("country.id"),'from':(icbs.lov.Lov.findAllByGroupCodeAndStatus("CTRY",true)),'optionKey':("id"),'optionValue':("itemValue"),'value':(branchInstance?.country?.id),'class':("many-to-one form-control"),'noSelection':(['null': ''])],-1)
printHtmlPart(5)
createTagBody(1, {->
printHtmlPart(6)
createTagBody(2, {->
printHtmlPart(7)
invokeTag('message','g',102,['error':(it)],-1)
printHtmlPart(8)
})
invokeTag('eachError','g',103,['bean':(branchInstance),'field':("country")],2)
printHtmlPart(9)
})
invokeTag('hasErrors','g',106,['bean':(branchInstance),'field':("country")],1)
printHtmlPart(10)
expressionOut.print(hasErrors(bean: branchInstance, field: 'region', 'has-error'))
printHtmlPart(17)
invokeTag('message','g',113,['code':("branch.region.label"),'default':("Region")],-1)
printHtmlPart(16)
invokeTag('select','g',116,['id':("region"),'name':("region.id"),'from':(icbs.lov.Lov.findAllByGroupCodeAndStatus("RGN",true)),'optionKey':("id"),'optionValue':("itemValue"),'value':(branchInstance?.region?.id),'class':("many-to-one form-control"),'noSelection':(['null': ''])],-1)
printHtmlPart(5)
createTagBody(1, {->
printHtmlPart(6)
createTagBody(2, {->
printHtmlPart(7)
invokeTag('message','g',122,['error':(it)],-1)
printHtmlPart(8)
})
invokeTag('eachError','g',123,['bean':(branchInstance),'field':("region")],2)
printHtmlPart(9)
})
invokeTag('hasErrors','g',126,['bean':(branchInstance),'field':("region")],1)
printHtmlPart(10)
expressionOut.print(hasErrors(bean: branchInstance, field: 'contactNumber', 'has-error'))
printHtmlPart(18)
invokeTag('message','g',133,['code':("branch.contactNumber.label"),'default':("Contact Number")],-1)
printHtmlPart(16)
invokeTag('textField','g',136,['name':("contactNumber"),'value':(branchInstance?.contactNumber),'class':("form-control")],-1)
printHtmlPart(5)
createTagBody(1, {->
printHtmlPart(6)
createTagBody(2, {->
printHtmlPart(7)
invokeTag('message','g',142,['error':(it)],-1)
printHtmlPart(8)
})
invokeTag('eachError','g',143,['bean':(branchInstance),'field':("contactNumber")],2)
printHtmlPart(9)
})
invokeTag('hasErrors','g',146,['bean':(branchInstance),'field':("contactNumber")],1)
printHtmlPart(10)
expressionOut.print(hasErrors(bean: branchInstance, field: 'managerId', 'has-error'))
printHtmlPart(19)
invokeTag('message','g',153,['code':("branch.managerId.label"),'default':("Manager")],-1)
printHtmlPart(16)
invokeTag('select','g',156,['id':("managerId"),'name':("managerId.id"),'from':(icbs.admin.UserMaster.list()),'optionKey':("id"),'optionValue':("name1"),'value':(branchInstance?.managerId?.id),'class':("many-to-one form-control"),'noSelection':(['null': ''])],-1)
printHtmlPart(5)
createTagBody(1, {->
printHtmlPart(6)
createTagBody(2, {->
printHtmlPart(7)
invokeTag('message','g',162,['error':(it)],-1)
printHtmlPart(8)
})
invokeTag('eachError','g',163,['bean':(branchInstance),'field':("managerId")],2)
printHtmlPart(9)
})
invokeTag('hasErrors','g',166,['bean':(branchInstance),'field':("managerId")],1)
printHtmlPart(10)
expressionOut.print(hasErrors(bean: branchInstance, field: 'openDate', 'has-error'))
printHtmlPart(20)
invokeTag('message','g',173,['code':("branch.openDate.label"),'default':("Open Date")],-1)
printHtmlPart(16)
invokeTag('customDatePicker','g',176,['name':("openDate"),'precision':("day"),'class':("form-control"),'value':(branchInstance?.openDate),'default':("none"),'noSelection':(['': ''])],-1)
printHtmlPart(5)
createTagBody(1, {->
printHtmlPart(6)
createTagBody(2, {->
printHtmlPart(7)
invokeTag('message','g',182,['error':(it)],-1)
printHtmlPart(8)
})
invokeTag('eachError','g',183,['bean':(branchInstance),'field':("openDate")],2)
printHtmlPart(9)
})
invokeTag('hasErrors','g',186,['bean':(branchInstance),'field':("openDate")],1)
printHtmlPart(10)
expressionOut.print(hasErrors(bean: branchInstance, field: 'dataCenter', 'has-error'))
printHtmlPart(21)
invokeTag('message','g',193,['code':("branch.dataCenter.label"),'default':("Data Center")],-1)
printHtmlPart(22)
if(true && (disableDataCenter)) {
printHtmlPart(23)
invokeTag('checkBox','g',198,['name':("dataCenter"),'class':("form-control"),'value':(branchInstance?.dataCenter),'disabled':("disabled")],-1)
printHtmlPart(4)
}
else {
printHtmlPart(23)
invokeTag('checkBox','g',201,['name':("dataCenter"),'class':("form-control"),'value':(branchInstance?.dataCenter)],-1)
printHtmlPart(4)
}
printHtmlPart(24)
createTagBody(1, {->
printHtmlPart(6)
createTagBody(2, {->
printHtmlPart(7)
invokeTag('message','g',210,['error':(it)],-1)
printHtmlPart(8)
})
invokeTag('eachError','g',211,['bean':(branchInstance),'field':("dataCenter")],2)
printHtmlPart(9)
})
invokeTag('hasErrors','g',214,['bean':(branchInstance),'field':("dataCenter")],1)
printHtmlPart(10)
expressionOut.print(hasErrors(bean: branchInstance, field: 'taxNo', 'has-error'))
printHtmlPart(25)
invokeTag('message','g',221,['code':("branch.taxNo.label"),'default':("Tax No")],-1)
printHtmlPart(16)
invokeTag('textField','g',224,['name':("taxNo"),'maxlength':("50"),'value':(branchInstance?.taxNo),'class':("form-control")],-1)
printHtmlPart(5)
createTagBody(1, {->
printHtmlPart(6)
createTagBody(2, {->
printHtmlPart(7)
invokeTag('message','g',230,['error':(it)],-1)
printHtmlPart(8)
})
invokeTag('eachError','g',231,['bean':(branchInstance),'field':("taxNo")],2)
printHtmlPart(9)
})
invokeTag('hasErrors','g',234,['bean':(branchInstance),'field':("taxNo")],1)
printHtmlPart(26)
invokeTag('message','g',241,['code':("branch.workingDays.label"),'default':("Working Days")],-1)
printHtmlPart(27)
invokeTag('checkBox','g',247,['name':("openOnMon"),'value':(branchInstance?.openOnMon)],-1)
printHtmlPart(28)
invokeTag('checkBox','g',248,['name':("openOnTue"),'value':(branchInstance?.openOnTue)],-1)
printHtmlPart(29)
invokeTag('checkBox','g',249,['name':("openOnWed"),'value':(branchInstance?.openOnWed)],-1)
printHtmlPart(30)
invokeTag('checkBox','g',250,['name':("openOnThu"),'value':(branchInstance?.openOnThu)],-1)
printHtmlPart(31)
invokeTag('checkBox','g',251,['name':("openOnFri"),'value':(branchInstance?.openOnFri)],-1)
printHtmlPart(32)
invokeTag('checkBox','g',252,['name':("openOnSat"),'value':(branchInstance?.openOnSat)],-1)
printHtmlPart(33)
invokeTag('checkBox','g',253,['name':("openOnSun"),'value':(branchInstance?.openOnSun)],-1)
printHtmlPart(34)
invokeTag('hiddenField','g',264,['name':("status"),'value':("2")],-1)
printHtmlPart(35)
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
