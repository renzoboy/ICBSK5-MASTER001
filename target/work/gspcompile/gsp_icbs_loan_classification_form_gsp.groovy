import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_loan_classification_form_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/loan/classification/_form.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
if(true && (loanApplication?.product?.productType?.id == 7)) {
printHtmlPart(1)
expressionOut.print(hasErrors(bean: loanInstance, field: 'loanPerformanceId', 'has-error'))
printHtmlPart(2)
invokeTag('message','g',5,['code':("loan.loanPerformanceId.label"),'default':("Account Status")],-1)
printHtmlPart(3)
invokeTag('select','g',8,['id':("loanPerformanceId"),'name':("loanPerformanceId.id"),'from':(icbs.lov.LoanPerformanceId.list().findAll{it.id == 5 || it.id == 6}),'optionKey':("id"),'optionValue':("description"),'value':(loanInstance?.loanPerformanceId?.id),'class':("many-to-one form-control")],-1)
printHtmlPart(4)
createTagBody(2, {->
printHtmlPart(5)
createTagBody(3, {->
printHtmlPart(6)
invokeTag('message','g',14,['error':(it?.code)],-1)
printHtmlPart(7)
})
invokeTag('eachError','g',15,['bean':(loanInstance),'field':("loanPerformanceId")],3)
printHtmlPart(8)
})
invokeTag('hasErrors','g',18,['bean':(loanInstance),'field':("loanPerformanceId")],2)
printHtmlPart(9)
expressionOut.print(hasErrors(bean: loanInstance, field: 'loanSecurity', 'has-error'))
printHtmlPart(10)
invokeTag('message','g',23,['code':("loan.loanSecurity.label"),'default':("Account Security")],-1)
printHtmlPart(3)
invokeTag('select','g',26,['id':("loanSecurity"),'name':("loanSecurity.id"),'from':(icbs.lov.LoanSecurity.list().findAll{it.id == 1 || it.id == 2 || it.id == 3 || it.id == 5}),'optionKey':("id"),'optionValue':("description"),'value':(loanInstance?.loanSecurity?.id),'class':("many-to-one form-control")],-1)
printHtmlPart(11)
createTagBody(2, {->
printHtmlPart(5)
createTagBody(3, {->
printHtmlPart(6)
invokeTag('message','g',32,['error':(it?.code)],-1)
printHtmlPart(7)
})
invokeTag('eachError','g',33,['bean':(loanInstance),'field':("loanSecurity")],3)
printHtmlPart(8)
})
invokeTag('hasErrors','g',36,['bean':(loanInstance),'field':("loanSecurity")],2)
printHtmlPart(12)
expressionOut.print(hasErrors(bean: loanInstance, field: 'glLink', 'has-error'))
printHtmlPart(13)
invokeTag('message','g',44,['code':("loan.glLink.label"),'default':("Account Type")],-1)
printHtmlPart(3)
invokeTag('hiddenField','g',47,['id':("oldGlLink"),'name':("oldGlLink"),'value':(loanInstance?.glLink?.id)],-1)
printHtmlPart(14)
invokeTag('select','g',48,['id':("glLink"),'name':("glLink.id"),'from':(icbs.gl.CfgAcctGlTemplate.list().findAll{it.type == 7}),'optionKey':("id"),'optionValue':("description"),'value':(loanInstance?.glLink?.id),'class':("many-to-one form-control")],-1)
printHtmlPart(15)
createTagBody(2, {->
printHtmlPart(5)
createTagBody(3, {->
printHtmlPart(6)
invokeTag('message','g',54,['error':(it?.code)],-1)
printHtmlPart(7)
})
invokeTag('eachError','g',54,['bean':(loanInstance),'field':("glLink")],3)
printHtmlPart(8)
})
invokeTag('hasErrors','g',56,['bean':(loanInstance),'field':("glLink")],2)
printHtmlPart(16)
}
else {
printHtmlPart(17)
expressionOut.print(hasErrors(bean: loanInstance, field: 'loanKindOfLoan', 'has-error'))
printHtmlPart(18)
invokeTag('message','g',65,['code':("loan.KindOfLoan.label"),'default':("Kind of Account")],-1)
printHtmlPart(19)
invokeTag('select','g',70,['id':("loanKindOfLoan"),'name':("loanKindOfLoan.id"),'from':(icbs.lov.LoanKindOfLoan.list()),'optionKey':("id"),'optionValue':("description"),'value':(loanInstance?.loanKindOfLoan?.id),'class':("form-control"),'noSelection':(['null': ''])],-1)
printHtmlPart(11)
createTagBody(2, {->
printHtmlPart(5)
createTagBody(3, {->
printHtmlPart(6)
invokeTag('message','g',76,['error':(it?.code)],-1)
printHtmlPart(7)
})
invokeTag('eachError','g',76,['bean':(loanInstance),'field':("loanKindOfLoan")],3)
printHtmlPart(8)
})
invokeTag('hasErrors','g',78,['bean':(loanInstance),'field':("loanKindOfLoan")],2)
printHtmlPart(20)
expressionOut.print(hasErrors(bean: loanInstance, field: 'loanType', 'has-error'))
printHtmlPart(21)
invokeTag('message','g',87,['code':("loan.loanType.label"),'default':("Name of Institution")],-1)
printHtmlPart(3)
invokeTag('select','g',90,['id':("loanType"),'name':("loanType.id"),'from':(icbs.lov.LoanType.list()),'optionKey':("id"),'optionValue':("description"),'value':(loanInstance?.loanType?.id),'class':("many-to-one form-control")],-1)
printHtmlPart(11)
createTagBody(2, {->
printHtmlPart(5)
createTagBody(3, {->
printHtmlPart(6)
invokeTag('message','g',96,['error':(it?.code)],-1)
printHtmlPart(7)
})
invokeTag('eachError','g',96,['bean':(loanInstance),'field':("loanType")],3)
printHtmlPart(8)
})
invokeTag('hasErrors','g',98,['bean':(loanInstance),'field':("loanType")],2)
printHtmlPart(22)
expressionOut.print(hasErrors(bean: loanInstance, field: 'loanProject', 'has-error'))
printHtmlPart(23)
invokeTag('message','g',106,['code':("loan.loanProject.label"),'default':("Economic Activity")],-1)
printHtmlPart(3)
invokeTag('select','g',109,['id':("loanProject"),'name':("loanProject.id"),'from':(icbs.lov.LoanProject.list()),'optionKey':("id"),'optionValue':("description"),'value':(loanInstance?.loanProject?.id),'class':("many-to-one form-control")],-1)
printHtmlPart(11)
createTagBody(2, {->
printHtmlPart(5)
createTagBody(3, {->
printHtmlPart(6)
invokeTag('message','g',115,['error':(it?.code)],-1)
printHtmlPart(7)
})
invokeTag('eachError','g',115,['bean':(loanInstance),'field':("loanProject")],3)
printHtmlPart(8)
})
invokeTag('hasErrors','g',117,['bean':(loanInstance),'field':("loanProject")],2)
printHtmlPart(22)
expressionOut.print(hasErrors(bean: loanInstance, field: 'loanProvision', 'has-error'))
printHtmlPart(24)
invokeTag('message','g',125,['code':("loan.loanProvision.label"),'default':("Account Provision")],-1)
printHtmlPart(3)
invokeTag('select','g',128,['id':("loanProvision"),'name':("loanProvision.id"),'from':(icbs.lov.LoanProvision.list()),'optionKey':("id"),'optionValue':("description"),'value':(loanInstance?.loanProvision?.id),'class':("many-to-one form-control")],-1)
printHtmlPart(11)
createTagBody(2, {->
printHtmlPart(5)
createTagBody(3, {->
printHtmlPart(6)
invokeTag('message','g',134,['error':(it?.code)],-1)
printHtmlPart(7)
})
invokeTag('eachError','g',134,['bean':(loanInstance),'field':("loanProvision")],3)
printHtmlPart(8)
})
invokeTag('hasErrors','g',136,['bean':(loanInstance),'field':("loanProvision")],2)
printHtmlPart(22)
expressionOut.print(hasErrors(bean: loanInstance, field: 'loanPerformanceId', 'has-error'))
printHtmlPart(2)
invokeTag('message','g',144,['code':("loan.loanPerformanceId.label"),'default':("Account Status")],-1)
printHtmlPart(3)
invokeTag('select','g',147,['id':("loanPerformanceId"),'name':("loanPerformanceId.id"),'from':(icbs.lov.LoanPerformanceId.list().findAll{it.id == 1 || it.id == 2 || it.id == 3 || it.id == 4 }),'optionKey':("id"),'optionValue':("description"),'value':(loanInstance?.loanPerformanceId?.id),'class':("many-to-one form-control")],-1)
printHtmlPart(11)
createTagBody(2, {->
printHtmlPart(5)
createTagBody(3, {->
printHtmlPart(6)
invokeTag('message','g',153,['error':(it?.code)],-1)
printHtmlPart(7)
})
invokeTag('eachError','g',153,['bean':(loanInstance),'field':("loanPerformanceId")],3)
printHtmlPart(8)
})
invokeTag('hasErrors','g',155,['bean':(loanInstance),'field':("loanPerformanceId")],2)
printHtmlPart(22)
expressionOut.print(hasErrors(bean: loanInstance, field: 'loanSecurity', 'has-error'))
printHtmlPart(10)
invokeTag('message','g',163,['code':("loan.loanSecurity.label"),'default':("Account Security")],-1)
printHtmlPart(3)
invokeTag('select','g',166,['id':("loanSecurity"),'name':("loanSecurity.id"),'from':(icbs.lov.LoanSecurity.list()),'optionKey':("id"),'optionValue':("description"),'value':(loanInstance?.loanSecurity?.id),'class':("many-to-one form-control")],-1)
printHtmlPart(11)
createTagBody(2, {->
printHtmlPart(5)
createTagBody(3, {->
printHtmlPart(6)
invokeTag('message','g',172,['error':(it?.code)],-1)
printHtmlPart(7)
})
invokeTag('eachError','g',172,['bean':(loanInstance),'field':("loanSecurity")],3)
printHtmlPart(8)
})
invokeTag('hasErrors','g',174,['bean':(loanInstance),'field':("loanSecurity")],2)
printHtmlPart(25)
expressionOut.print(hasErrors(bean: loanInstance, field: 'glLink', 'has-error'))
printHtmlPart(13)
invokeTag('message','g',180,['code':("loan.glLink.label"),'default':("Account Type")],-1)
printHtmlPart(3)
invokeTag('hiddenField','g',182,['id':("oldGlLink"),'name':("oldGlLink"),'value':(loanInstance?.glLink?.id)],-1)
printHtmlPart(14)
invokeTag('select','g',187,['id':("glLink"),'name':("glLink.id"),'from':(icbs.gl.CfgAcctGlTemplate.list().findAll{it.type == 6}),'optionKey':("id"),'optionValue':("description"),'value':(loanInstance?.glLink?.id),'class':("many-to-one form-control")],-1)
printHtmlPart(15)
createTagBody(2, {->
printHtmlPart(5)
createTagBody(3, {->
printHtmlPart(6)
invokeTag('message','g',193,['error':(it?.code)],-1)
printHtmlPart(7)
})
invokeTag('eachError','g',195,['bean':(loanInstance),'field':("glLink")],3)
printHtmlPart(8)
})
invokeTag('hasErrors','g',197,['bean':(loanInstance),'field':("glLink")],2)
printHtmlPart(26)
}
printHtmlPart(27)
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
