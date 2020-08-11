import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_layoutsmain_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/layouts/main.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',4,['gsp_sm_xmlClosingForEmptyTag':("/"),'charset':("UTF-8")],-1)
printHtmlPart(1)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('layoutTitle','g',5,[:],-1)
printHtmlPart(2)
})
invokeTag('captureTitle','sitemesh',5,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',5,[:],2)
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',6,['gsp_sm_xmlClosingForEmptyTag':("/"),'http-equiv':("Content-Type"),'content':("text/html; charset=UTF-8")],-1)
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',7,['gsp_sm_xmlClosingForEmptyTag':("/"),'http-equiv':("X-UA-Compatible"),'content':("IE=edge,chrome=1")],-1)
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',8,['gsp_sm_xmlClosingForEmptyTag':("/"),'content':("width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"),'name':("viewport")],-1)
printHtmlPart(3)
invokeTag('stylesheet','asset',11,['src':("myCustomStyleSheet.css")],-1)
printHtmlPart(1)
invokeTag('stylesheet','asset',12,['src':("bootstrap.min.css")],-1)
printHtmlPart(1)
invokeTag('stylesheet','asset',13,['src':("select2.css")],-1)
printHtmlPart(1)
invokeTag('stylesheet','asset',14,['src':("select2-bootstrap.css")],-1)
printHtmlPart(1)
invokeTag('stylesheet','asset',15,['src':("datepicker3.css")],-1)
printHtmlPart(1)
invokeTag('stylesheet','asset',16,['src':("font-awesome.min.css")],-1)
printHtmlPart(4)
invokeTag('stylesheet','asset',20,['src':("AdminLTE/morris/morris.css")],-1)
printHtmlPart(5)
invokeTag('stylesheet','asset',22,['src':("alertify.min.css")],-1)
printHtmlPart(1)
invokeTag('stylesheet','asset',23,['src':("themes/semantic.min.css")],-1)
printHtmlPart(6)
invokeTag('stylesheet','asset',26,['src':("AdminLTE/jvectormap/jquery-jvectormap-1.2.2.css")],-1)
printHtmlPart(7)
invokeTag('stylesheet','asset',28,['src':("AdminLTE/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css")],-1)
printHtmlPart(8)
invokeTag('stylesheet','asset',31,['src':("main.css")],-1)
printHtmlPart(1)
invokeTag('stylesheet','asset',32,['src':("BootSideMenu.css")],-1)
printHtmlPart(9)
invokeTag('stylesheet','asset',35,['src':("AdminLTE/datatables/jquery.dataTables.min.css")],-1)
printHtmlPart(10)
invokeTag('stylesheet','asset',36,['src':("AdminLTE/datatables/buttons.dataTables.min.css")],-1)
printHtmlPart(11)
invokeTag('javascript','asset',39,['src':("jquery-1.11.1.min.js")],-1)
printHtmlPart(1)
invokeTag('javascript','asset',40,['src':("bootstrap.min.js")],-1)
printHtmlPart(1)
invokeTag('javascript','asset',41,['src':("jquery-ui.min.js")],-1)
printHtmlPart(1)
invokeTag('javascript','asset',42,['src':("select2.min.js")],-1)
printHtmlPart(1)
invokeTag('javascript','asset',43,['src':("accounting.js")],-1)
printHtmlPart(1)
invokeTag('javascript','asset',44,['src':("TreeListFilter.js")],-1)
printHtmlPart(1)
invokeTag('javascript','asset',45,['src':("application.js")],-1)
printHtmlPart(1)
invokeTag('javascript','asset',46,['src':("plugins/input-mask/jquery.inputmask.js")],-1)
printHtmlPart(1)
invokeTag('javascript','asset',47,['src':("plugins/input-mask/jquery.inputmask.numeric.extensions.js")],-1)
printHtmlPart(1)
invokeTag('javascript','asset',48,['src':("plugins/datepicker/bootstrap-datepicker.js")],-1)
printHtmlPart(12)
invokeTag('javascript','asset',52,['src':("alertify.min.js")],-1)
printHtmlPart(1)
invokeTag('javascript','asset',53,['src':("BootSideMenu.js")],-1)
printHtmlPart(13)
invokeTag('javascript','asset',55,['src':("namespace.js")],-1)
printHtmlPart(1)
invokeTag('javascript','asset',56,['src':("ICBSDependencies.js")],-1)
printHtmlPart(1)
invokeTag('javascript','asset',57,['src':("search.js")],-1)
printHtmlPart(5)
invokeTag('javascript','asset',59,['src':("plugins/datatables/jquery.dataTables.js")],-1)
printHtmlPart(5)
invokeTag('javascript','asset',60,['src':("plugins/datatables/dataTables.buttons.min.js")],-1)
printHtmlPart(1)
invokeTag('javascript','asset',61,['src':("plugins/datatables/buttons.print.min.js")],-1)
printHtmlPart(5)
invokeTag('javascript','asset',62,['src':("jquery.alphanum.js")],-1)
printHtmlPart(14)
expressionOut.print(resource(dir: "images", file: "body-gradient.png"))
printHtmlPart(15)
expressionOut.print(resource(dir: "images", file: "bg-translucent.png"))
printHtmlPart(16)
invokeTag('layoutHead','g',76,[:],-1)
printHtmlPart(17)
expressionOut.print(session.session_timeout)
printHtmlPart(18)
})
invokeTag('captureHead','sitemesh',92,[:],1)
printHtmlPart(19)
createTagBody(1, {->
printHtmlPart(20)
if(true && (session.user!=null)) {
printHtmlPart(21)
if(true && (cifMenu)) {
printHtmlPart(22)
for( _it238503526 in (cifMenu) ) {
changeItVariable(_it238503526)
printHtmlPart(23)
expressionOut.print(createLink(uri: it.uri))
printHtmlPart(24)
expressionOut.print(it.name)
printHtmlPart(25)
}
printHtmlPart(26)
}
printHtmlPart(27)
if(true && (depositsMenu)) {
printHtmlPart(28)
for( _it1324276180 in (depositsMenu) ) {
changeItVariable(_it1324276180)
printHtmlPart(23)
expressionOut.print(createLink(uri: it.uri))
printHtmlPart(29)
expressionOut.print(it.name)
printHtmlPart(25)
}
printHtmlPart(26)
}
printHtmlPart(30)
if(true && (loansMenu)) {
printHtmlPart(31)
for( _it589239752 in (loansMenu) ) {
changeItVariable(_it589239752)
printHtmlPart(23)
expressionOut.print(createLink(uri: it.uri))
printHtmlPart(29)
expressionOut.print(it.name)
printHtmlPart(25)
}
printHtmlPart(26)
}
printHtmlPart(30)
if(true && (telleringMenu)) {
printHtmlPart(32)
for( _it1305415547 in (telleringMenu) ) {
changeItVariable(_it1305415547)
printHtmlPart(23)
expressionOut.print(createLink(uri: it.uri))
printHtmlPart(29)
expressionOut.print(it.name)
printHtmlPart(25)
}
printHtmlPart(26)
}
printHtmlPart(30)
if(true && (glMenu)) {
printHtmlPart(33)
for( _it1426160677 in (glMenu) ) {
changeItVariable(_it1426160677)
printHtmlPart(23)
expressionOut.print(createLink(uri: it.uri))
printHtmlPart(29)
expressionOut.print(it.name)
printHtmlPart(25)
}
printHtmlPart(26)
}
printHtmlPart(30)
if(true && (adminMenu)) {
printHtmlPart(34)
for( _it1417514172 in (adminMenu) ) {
changeItVariable(_it1417514172)
printHtmlPart(23)
expressionOut.print(createLink(uri: it.uri))
printHtmlPart(29)
expressionOut.print(it.name)
printHtmlPart(25)
}
printHtmlPart(26)
}
printHtmlPart(30)
if(true && (configMenu)) {
printHtmlPart(35)
for( _it2124592633 in (configMenu) ) {
changeItVariable(_it2124592633)
printHtmlPart(36)
if(true && (it.uri=='/glLink')) {
printHtmlPart(37)
expressionOut.print(createLink(uri: '/cfgAcctGlTemplate'))
printHtmlPart(29)
expressionOut.print(it.name)
printHtmlPart(38)
}
else {
printHtmlPart(37)
expressionOut.print(createLink(uri: it.uri))
printHtmlPart(29)
expressionOut.print(it.name)
printHtmlPart(38)
}
printHtmlPart(39)
}
printHtmlPart(26)
}
printHtmlPart(30)
if(true && (auditMenu)) {
printHtmlPart(40)
for( _it1817784162 in (auditMenu) ) {
changeItVariable(_it1817784162)
printHtmlPart(23)
expressionOut.print(createLink(uri: it.uri))
printHtmlPart(29)
expressionOut.print(it.name)
printHtmlPart(25)
}
printHtmlPart(26)
}
printHtmlPart(41)
}
printHtmlPart(42)
if(true && (session.user!=null)) {
printHtmlPart(43)
}
printHtmlPart(44)
expressionOut.print(resource(dir: "images", file: "body-gradient.png"))
printHtmlPart(45)
if(true && (session.user!=null)) {
printHtmlPart(46)
expressionOut.print(createLink(uri: '/userMaster/changePassword'))
printHtmlPart(47)
expressionOut.print(session.user)
printHtmlPart(48)
invokeTag('hiddenField','g',251,['id':("unreadnotify"),'name':("unreadnotify"),'value':(unreadMessages)],-1)
printHtmlPart(49)
invokeTag('hiddenField','g',252,['id':("alertnotify"),'name':("alertnotify"),'value':(pendingPolicyExceptions)],-1)
printHtmlPart(50)
expressionOut.print(createLink(uri: '/userMessage'))
printHtmlPart(51)
expressionOut.print(unreadMessages)
printHtmlPart(52)
expressionOut.print(createLink(uri: '/policyException'))
printHtmlPart(53)
expressionOut.print(pendingPolicyExceptions)
printHtmlPart(54)
createClosureForHtmlPart(55, 3)
invokeTag('javascript','g',291,[:],3)
printHtmlPart(56)
expressionOut.print(createLink(uri: '/authentication/logout'))
printHtmlPart(57)
expressionOut.print(createLink(uri: '/authentication/conditionallogout'))
printHtmlPart(58)
}
printHtmlPart(59)
if(true && (session.user==null)) {
printHtmlPart(46)
expressionOut.print(createLink(uri: '/authentication/login'))
printHtmlPart(60)
}
printHtmlPart(61)
expressionOut.print(createLink(uri: '/'))
printHtmlPart(62)
if(true && (session.user!=null)) {
printHtmlPart(63)
expressionOut.print(resource(dir: "images", file: "${icbs.admin.Institution.findByParamCode('GEN.10030').paramValue}"))
printHtmlPart(64)
}
printHtmlPart(59)
if(true && (session.user==null)) {
printHtmlPart(65)
expressionOut.print(resource(dir: "images", file: "mbphil.jpg"))
printHtmlPart(64)
}
printHtmlPart(66)
if(true && (session.user!=null)) {
printHtmlPart(67)
expressionOut.print(icbs.admin.Institution.findByParamCode('GEN.10000').paramValue)
printHtmlPart(68)
expressionOut.print(session.branch)
printHtmlPart(69)
expressionOut.print(g.formatDate(date: (runDate), format: 'E, dd MMMM yyyy'))
printHtmlPart(70)
}
printHtmlPart(71)
if(true && (session.user!=null)) {
printHtmlPart(72)
if(true && (cifMenu)) {
printHtmlPart(73)
}
printHtmlPart(74)
if(true && (depositsMenu)) {
printHtmlPart(75)
}
printHtmlPart(76)
if(true && (loansMenu)) {
printHtmlPart(77)
}
printHtmlPart(76)
if(true && (telleringMenu)) {
printHtmlPart(78)
}
printHtmlPart(76)
if(true && (glMenu)) {
printHtmlPart(79)
}
printHtmlPart(76)
if(true && (adminMenu)) {
printHtmlPart(80)
}
printHtmlPart(76)
if(true && (configMenu)) {
printHtmlPart(81)
}
printHtmlPart(76)
if(true && (auditMenu)) {
printHtmlPart(82)
}
printHtmlPart(83)
for( _it1396048512 in (cifMenu) ) {
changeItVariable(_it1396048512)
printHtmlPart(23)
expressionOut.print(createLink(uri: it.uri))
printHtmlPart(29)
expressionOut.print(it.name)
printHtmlPart(25)
}
printHtmlPart(84)
for( _it2128497709 in (depositsMenu) ) {
changeItVariable(_it2128497709)
printHtmlPart(23)
expressionOut.print(createLink(uri: it.uri))
printHtmlPart(29)
expressionOut.print(it.name)
printHtmlPart(25)
}
printHtmlPart(84)
for( _it878403437 in (loansMenu) ) {
changeItVariable(_it878403437)
printHtmlPart(23)
expressionOut.print(createLink(uri: it.uri))
printHtmlPart(29)
expressionOut.print(it.name)
printHtmlPart(25)
}
printHtmlPart(84)
for( _it1523976181 in (telleringMenu) ) {
changeItVariable(_it1523976181)
printHtmlPart(23)
expressionOut.print(createLink(uri: it.uri))
printHtmlPart(29)
expressionOut.print(it.name)
printHtmlPart(25)
}
printHtmlPart(84)
for( _it430216298 in (glMenu) ) {
changeItVariable(_it430216298)
printHtmlPart(23)
expressionOut.print(createLink(uri: it.uri))
printHtmlPart(29)
expressionOut.print(it.name)
printHtmlPart(25)
}
printHtmlPart(84)
for( _it67881037 in (adminMenu) ) {
changeItVariable(_it67881037)
printHtmlPart(23)
expressionOut.print(createLink(uri: it.uri))
printHtmlPart(29)
expressionOut.print(it.name)
printHtmlPart(25)
}
printHtmlPart(84)
for( _it562772302 in (configMenu) ) {
changeItVariable(_it562772302)
printHtmlPart(23)
expressionOut.print(createLink(uri: it.uri))
printHtmlPart(29)
expressionOut.print(it.name)
printHtmlPart(25)
}
printHtmlPart(84)
for( _it996098326 in (auditMenu) ) {
changeItVariable(_it996098326)
printHtmlPart(23)
expressionOut.print(createLink(uri: it.uri))
printHtmlPart(29)
expressionOut.print(it.name)
printHtmlPart(25)
}
printHtmlPart(85)
}
printHtmlPart(86)
if(true && (session.user!=null)) {
printHtmlPart(87)
expressionOut.print(createLink(uri: '/'))
printHtmlPart(88)
invokeTag('pageProperty','g',393,['name':("page.breadcrumbs")],-1)
printHtmlPart(89)
expressionOut.print(icbs.admin.Institution.findByParamCode('GEN.10150').paramValue)
printHtmlPart(90)
}
printHtmlPart(91)
if(true && (pageProperty(name:'title')!='')) {
printHtmlPart(92)
invokeTag('layoutTitle','g',405,[:],-1)
printHtmlPart(93)
}
printHtmlPart(94)
if(true && (flash.error)) {
printHtmlPart(95)
expressionOut.print(flash.error)
printHtmlPart(96)
}
printHtmlPart(97)
invokeTag('pageProperty','g',418,['name':("page.main-content")],-1)
printHtmlPart(98)
if(true && (pageProperty(name:'page.main-actions')!='')) {
printHtmlPart(99)
invokeTag('pageProperty','g',428,['name':("page.main-actions")],-1)
printHtmlPart(100)
}
printHtmlPart(101)
expressionOut.print(resource(dir:'images', file:'spinner.gif'))
printHtmlPart(102)
invokeTag('render','g',441,['template':("/policy/overrideModal")],-1)
printHtmlPart(103)
expressionOut.print(resource(dir: '/assets/images', file: 'sprites.gif'))
printHtmlPart(104)
expressionOut.print(pendingPolicyExceptions)
printHtmlPart(105)
expressionOut.print(createLink(uri: '/authentication/forcelogout'))
printHtmlPart(106)
expressionOut.print(createLink(uri: '/authentication/logout'))
printHtmlPart(107)
expressionOut.print(g.createLink(controller:'policy', action:'checkIfAllowed'))
printHtmlPart(108)
expressionOut.print(g.createLink(controller:'authentication', action:'overrideAuthenticate'))
printHtmlPart(109)
invokeTag('javascript','asset',1077,['src':("vue.min.js")],-1)
printHtmlPart(110)
invokeTag('javascript','asset',1078,['src':("batch.js")],-1)
printHtmlPart(110)
invokeTag('javascript','asset',1079,['src':("glSearch.js")],-1)
printHtmlPart(110)
invokeTag('javascript','asset',1083,['src':("plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js")],-1)
printHtmlPart(111)
invokeTag('javascript','asset',1088,['src':("bootbox.js")],-1)
printHtmlPart(112)
})
invokeTag('captureBody','sitemesh',1088,[:],1)
printHtmlPart(113)
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
