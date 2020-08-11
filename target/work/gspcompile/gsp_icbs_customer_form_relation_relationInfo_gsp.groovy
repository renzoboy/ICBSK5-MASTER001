import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_customer_form_relation_relationInfo_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/customer/form/relation/_relationInfo.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
printHtmlPart(1)
invokeTag('hiddenField','g',8,['id':("customerRelationshipType"),'name':("customerRelationshipType"),'value':(customerRelationshipType)],-1)
printHtmlPart(2)
invokeTag('set','g',12,['var':("spouseCount"),'value':(0)],-1)
printHtmlPart(3)
loop:{
int i = 0
for( relation in (customerInstance?.relations) ) {
printHtmlPart(4)
if(true && (relation?.type?.id==65&&(relation?.status?.id==2||!relation?.id))) {
printHtmlPart(5)
invokeTag('render','g',15,['template':("form/relation/onetomany/relation"),'model':(['relation':relation,'i':i,'choice':'0'])],-1)
printHtmlPart(5)
invokeTag('set','g',16,['var':("spouseCount"),'value':(spouseCount+1)],-1)
printHtmlPart(4)
}
printHtmlPart(3)
i++
}
}
printHtmlPart(6)
if(true && (spouseCount==0)) {
printHtmlPart(7)
}
else {
printHtmlPart(8)
}
printHtmlPart(9)
invokeTag('set','g',33,['var':("fatherCount"),'value':(0)],-1)
printHtmlPart(3)
loop:{
int i = 0
for( relation in (customerInstance?.relations) ) {
printHtmlPart(4)
if(true && (relation?.type?.id==48&&(relation?.status?.id==2||!relation?.id))) {
printHtmlPart(5)
invokeTag('render','g',36,['template':("form/relation/onetomany/relation"),'model':(['relation':relation,'i':i,'choice':'1','hide':'true'])],-1)
printHtmlPart(5)
invokeTag('set','g',37,['var':("fatherCount"),'value':(fatherCount+1)],-1)
printHtmlPart(4)
}
printHtmlPart(3)
i++
}
}
printHtmlPart(10)
if(true && (fatherCount==0)) {
printHtmlPart(11)
}
else {
printHtmlPart(12)
}
printHtmlPart(13)
invokeTag('set','g',56,['var':("motherCount"),'value':(0)],-1)
printHtmlPart(3)
loop:{
int i = 0
for( relation in (customerInstance?.relations) ) {
printHtmlPart(4)
if(true && (relation?.type?.id==47&&(relation?.status?.id==2||!relation?.id))) {
printHtmlPart(5)
invokeTag('render','g',59,['template':("form/relation/onetomany/relation"),'model':(['relation':relation,'i':i,'choice':'2'])],-1)
printHtmlPart(5)
invokeTag('set','g',60,['var':("motherCount"),'value':(motherCount+1)],-1)
printHtmlPart(4)
}
printHtmlPart(3)
i++
}
}
printHtmlPart(10)
if(true && (motherCount==0)) {
printHtmlPart(14)
}
else {
printHtmlPart(15)
}
printHtmlPart(16)
loop:{
int i = 0
for( relation in (customerInstance?.relations) ) {
printHtmlPart(4)
if(true && (relation?.type?.id!=47&&relation?.type?.id!=48&&(relation?.status?.id==2||!relation?.id))) {
printHtmlPart(5)
invokeTag('render','g',78,['template':("form/relation/onetomany/relation"),'model':(['relation':relation,'i':i,'choice':'3'])],-1)
printHtmlPart(4)
}
printHtmlPart(3)
i++
}
}
printHtmlPart(17)
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
