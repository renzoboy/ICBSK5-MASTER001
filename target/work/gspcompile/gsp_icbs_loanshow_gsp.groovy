import icbs.loans.Loan
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_loanshow_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/loan/show.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("layout"),'content':("main")],-1)
printHtmlPart(1)
invokeTag('set','g',6,['var':("entityName"),'value':(message(code: 'loan.label', default: 'Loan'))],-1)
printHtmlPart(1)
if(true && (module == 'loan')) {
printHtmlPart(2)
if(true && (loanInstance?.product?.productType?.id == 6)) {
printHtmlPart(3)
createTagBody(4, {->
createClosureForHtmlPart(4, 5)
invokeTag('captureTitle','sitemesh',9,[:],5)
})
invokeTag('wrapTitleTag','sitemesh',9,[:],4)
printHtmlPart(2)
}
printHtmlPart(2)
if(true && (loanInstance?.product?.productType?.id == 7)) {
printHtmlPart(3)
createTagBody(4, {->
createClosureForHtmlPart(5, 5)
invokeTag('captureTitle','sitemesh',12,[:],5)
})
invokeTag('wrapTitleTag','sitemesh',12,[:],4)
printHtmlPart(2)
}
printHtmlPart(6)
}
else {
printHtmlPart(7)
createTagBody(3, {->
createTagBody(4, {->
expressionOut.print(title)
printHtmlPart(8)
expressionOut.print(loanInstance?.accountNo)
printHtmlPart(9)
expressionOut.print(loanInstance?.customer?.displayName)
printHtmlPart(10)
})
invokeTag('captureTitle','sitemesh',16,[:],4)
})
invokeTag('wrapTitleTag','sitemesh',16,[:],3)
printHtmlPart(11)
}
printHtmlPart(1)
createTagBody(2, {->
printHtmlPart(12)
expressionOut.print(createLink(controller :'customer', action:'showBasicCustomerInfoAjax'))
printHtmlPart(13)
expressionOut.print(loanInstance?.id)
printHtmlPart(14)
expressionOut.print(createLink(controller :'loan', action:'showUpdateInterestRateAjax'))
printHtmlPart(15)
expressionOut.print(createLink(controller :'loan', action:'updateInterestRateAjax'))
printHtmlPart(16)
expressionOut.print(loanInstance?.id)
printHtmlPart(14)
expressionOut.print(createLink(controller :'loan', action:'showUpdateBranchAjax'))
printHtmlPart(17)
expressionOut.print(createLink(controller : 'customer', action:'customerSaveRelatedAjax'))
printHtmlPart(18)
expressionOut.print(createLink(controller :'loan', action:'updateBranchAjax'))
printHtmlPart(19)
expressionOut.print(loanInstance?.id)
printHtmlPart(14)
expressionOut.print(createLink(controller :'loan', action:'showUpdateStatusAjax'))
printHtmlPart(20)
expressionOut.print(loanInstance?.id)
printHtmlPart(14)
expressionOut.print(createLink(controller :'loan', action:'showUpdateStatAjax'))
printHtmlPart(21)
expressionOut.print(loanInstance?.id)
printHtmlPart(14)
expressionOut.print(createLink(controller :'loan', action:'showUpdateCloseStatusAjax'))
printHtmlPart(22)
expressionOut.print(createLink(controller :'loan', action:'updateStatusAjax'))
printHtmlPart(23)
expressionOut.print(createLink(controller :'loan', action:'updateStatAjax'))
printHtmlPart(24)
expressionOut.print(createLink(controller :'loan', action:'updateCloseStatusAjax'))
printHtmlPart(25)
expressionOut.print(loanInstance?.id)
printHtmlPart(14)
expressionOut.print(createLink(controller :'loan', action:'showUpdateGLClassificationAjax'))
printHtmlPart(26)
expressionOut.print(createLink(controller :'loan', action:'updateGLClassificationAjax'))
printHtmlPart(27)
expressionOut.print(loanInstance?.customer?.id)
printHtmlPart(28)
expressionOut.print(icbs.admin.Institution.get(94).paramValue)
expressionOut.print(icbs.admin.Report.get(27).baseParams)
printHtmlPart(29)
expressionOut.print(icbs.admin.Report.get(27).outputParam)
printHtmlPart(30)
expressionOut.print(icbs.admin.Report.get(27).reportUnit)
printHtmlPart(31)
expressionOut.print(loanInstance?.accountNo)
printHtmlPart(32)
expressionOut.print(icbs.admin.UserMaster.get(session.user_id).username)
printHtmlPart(33)
expressionOut.print(icbs.admin.Institution.get(94).paramValue)
expressionOut.print(icbs.admin.Report.get(29).baseParams)
printHtmlPart(29)
expressionOut.print(icbs.admin.Report.get(29).outputParam)
printHtmlPart(34)
expressionOut.print(icbs.admin.Report.get(29).reportUnit)
printHtmlPart(35)
expressionOut.print(loanInstance?.accountNo)
printHtmlPart(36)
expressionOut.print(icbs.admin.UserMaster.get(session.user_id).username)
printHtmlPart(37)
expressionOut.print(icbs.admin.Institution.get(94).paramValue)
expressionOut.print(icbs.admin.Report.get(30).baseParams)
printHtmlPart(29)
expressionOut.print(icbs.admin.Report.get(30).outputParam)
printHtmlPart(34)
expressionOut.print(icbs.admin.Report.get(30).reportUnit)
printHtmlPart(35)
expressionOut.print(loanInstance?.accountNo)
printHtmlPart(38)
expressionOut.print(icbs.admin.UserMaster.get(session.user_id).username)
printHtmlPart(39)
expressionOut.print(icbs.admin.Institution.get(94).paramValue)
expressionOut.print(icbs.admin.Report.get(28).baseParams)
printHtmlPart(29)
expressionOut.print(icbs.admin.Report.get(28).outputParam)
printHtmlPart(30)
expressionOut.print(icbs.admin.Report.get(28).reportUnit)
printHtmlPart(31)
expressionOut.print(loanInstance?.accountNo)
printHtmlPart(40)
expressionOut.print(icbs.admin.UserMaster.get(session.user_id).username)
printHtmlPart(41)
expressionOut.print(icbs.admin.Institution.get(94).paramValue)
expressionOut.print(icbs.admin.Report.get(63).baseParams)
printHtmlPart(29)
expressionOut.print(icbs.admin.Report.get(63).outputParam)
printHtmlPart(30)
expressionOut.print(icbs.admin.Report.get(63).reportUnit)
printHtmlPart(42)
expressionOut.print(loanInstance?.accountNo)
printHtmlPart(40)
expressionOut.print(icbs.admin.UserMaster.get(session.user_id).username)
printHtmlPart(43)
})
invokeTag('javascript','g',360,[:],2)
printHtmlPart(44)
})
invokeTag('captureHead','sitemesh',361,[:],1)
printHtmlPart(44)
createTagBody(1, {->
printHtmlPart(45)
createTagBody(2, {->
printHtmlPart(46)
expressionOut.print(title)
printHtmlPart(47)
})
invokeTag('captureContent','sitemesh',365,['tag':("breadcrumbs")],2)
printHtmlPart(45)
createTagBody(2, {->
printHtmlPart(48)
expressionOut.print(loanApplicationInstance?.customer?.displayName)
printHtmlPart(49)
expressionOut.print(loanInstance?.accountNo)
printHtmlPart(50)
invokeTag('textField','g',368,['name':("loanid"),'id':("loanid"),'value':(loanInstance.id),'style':("display:none")],-1)
printHtmlPart(51)
if(true && (flash.message)) {
printHtmlPart(52)
expressionOut.print(flash.message)
printHtmlPart(53)
}
printHtmlPart(54)
if(true && (module =="loanAmendment")) {
printHtmlPart(55)
invokeTag('render','g',389,['template':("classification/show")],-1)
printHtmlPart(56)
}
else {
printHtmlPart(57)
if(true && (loanInstance?.product?.productType?.id == 7)) {
printHtmlPart(58)
}
else {
printHtmlPart(59)
}
printHtmlPart(60)
invokeTag('render','g',421,['template':("loanApplication/show")],-1)
printHtmlPart(61)
invokeTag('render','g',424,['template':("specification/show")],-1)
printHtmlPart(62)
invokeTag('render','g',427,['template':("classification/show")],-1)
printHtmlPart(63)
invokeTag('render','g',430,['template':("serviceCharges/show")],-1)
printHtmlPart(64)
invokeTag('render','g',433,['template':("deductions/show")],-1)
printHtmlPart(65)
invokeTag('render','g',436,['template':("advancedInterests/list")],-1)
printHtmlPart(66)
invokeTag('render','g',439,['template':("installments/schedule")],-1)
printHtmlPart(67)
invokeTag('render','g',442,['template':("balance/list")],-1)
printHtmlPart(68)
invokeTag('render','g',445,['template':("transactions/list")],-1)
printHtmlPart(69)
invokeTag('render','g',448,['template':("restructureDetails/list")],-1)
printHtmlPart(70)
invokeTag('render','g',451,['template':("auditLog/list")],-1)
printHtmlPart(71)
invokeTag('render','g',455,['template':("sweep/show")],-1)
printHtmlPart(72)
invokeTag('render','g',458,['template':("history/list")],-1)
printHtmlPart(73)
invokeTag('render','g',461,['template':("loanReclass/list")],-1)
printHtmlPart(74)
}
printHtmlPart(75)
if(true && (loanInstance?.product?.productType?.id == 6)) {
printHtmlPart(76)
}
printHtmlPart(77)
if(true && (loanInstance?.product?.productType?.id == 7)) {
printHtmlPart(78)
}
printHtmlPart(79)
if(true && (save != 'save')) {
printHtmlPart(80)
}
printHtmlPart(81)
})
invokeTag('captureContent','sitemesh',575,['tag':("main-content")],2)
printHtmlPart(45)
createTagBody(2, {->
printHtmlPart(82)
if(true && (loanInstance?.product?.productType?.id == 6)) {
printHtmlPart(83)
createClosureForHtmlPart(84, 4)
invokeTag('link','g',578,['class':("list"),'controller':(module)],4)
printHtmlPart(85)
}
printHtmlPart(6)
if(true && (loanInstance?.product?.productType?.id == 7)) {
printHtmlPart(83)
createClosureForHtmlPart(86, 4)
invokeTag('link','g',581,['class':("indexScr"),'action':("indexScr"),'controller':("ropa")],4)
printHtmlPart(85)
}
printHtmlPart(87)
if(true && (module == 'loan')) {
printHtmlPart(88)
if(true && (loanInstance&&loanInstance.status?.id == 3 || loanInstance&&loanInstance.status?.id == 4  || loanInstance&&loanInstance.status?.id == 5)) {
printHtmlPart(89)
if(true && (loanInstance?.product?.productType?.id == 6)) {
printHtmlPart(90)
}
printHtmlPart(91)
invokeTag('textField','g',607,['class':("form-control"),'id':("textfield_dcpnno"),'name':("textfield"),'value':(loanInstance.pnNo)],-1)
printHtmlPart(92)
createClosureForHtmlPart(93, 5)
invokeTag('javascript','g',617,[:],5)
printHtmlPart(94)
if(true && (loanInstance?.product?.productType?.id == 6)) {
printHtmlPart(95)
}
printHtmlPart(96)
invokeTag('textField','g',643,['class':("form-control"),'id':("textfield_pnno"),'name':("textfield"),'value':(loanInstance.pnNo)],-1)
printHtmlPart(97)
createClosureForHtmlPart(93, 5)
invokeTag('javascript','g',653,[:],5)
printHtmlPart(94)
if(true && (loanInstance?.product?.productType?.id == 6)) {
printHtmlPart(98)
}
printHtmlPart(2)
}
printHtmlPart(3)
if(true && (loanInstance?.product?.productType?.id == 6)) {
printHtmlPart(99)
createClosureForHtmlPart(100, 5)
invokeTag('link','g',665,['action':("edit"),'resource':(loanInstance)],5)
printHtmlPart(101)
}
printHtmlPart(3)
if(true && (loanInstance?.product?.productType?.id == 7)) {
printHtmlPart(102)
createClosureForHtmlPart(103, 5)
invokeTag('link','g',668,['action':("edit"),'resource':(loanInstance)],5)
printHtmlPart(101)
}
printHtmlPart(104)
createClosureForHtmlPart(105, 4)
invokeTag('link','g',671,['action':("editSweepAccount"),'resource':(loanInstance)],4)
printHtmlPart(106)
createClosureForHtmlPart(107, 4)
invokeTag('link','g',673,['target':("_blank"),'controller':("loan"),'action':("printLoanInstallment")],4)
printHtmlPart(101)
if(true && (loanInstance?.product?.productType?.id == 6)) {
printHtmlPart(108)
}
printHtmlPart(109)
if(true && (loanInstance?.hasInterestAccrual)) {
printHtmlPart(102)
createTagBody(5, {->
invokeTag('actionSubmit','g',681,['action':("stopInterestAccrual"),'value':("Stop Interest Accrual"),'onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');")],-1)
printHtmlPart(110)
})
invokeTag('form','g',682,['url':([controller: loan, id: loanInstance.id,  action:'stopInterestAccrual']),'method':("POST")],5)
printHtmlPart(111)
}
else {
printHtmlPart(102)
createTagBody(5, {->
invokeTag('actionSubmit','g',685,['action':("startInterestAccrual"),'value':("Start Interest Accrual"),'onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');")],-1)
printHtmlPart(110)
})
invokeTag('form','g',685,['url':([controller: loan, id: loanInstance.id,  action:'startInterestAccrual']),'method':("POST")],5)
printHtmlPart(111)
}
printHtmlPart(112)
if(true && (loanInstance?.loanPerformanceId?.id == 1)) {
printHtmlPart(113)
createClosureForHtmlPart(114, 5)
invokeTag('link','g',689,['action':("reschedule"),'resource':(loanInstance)],5)
printHtmlPart(115)
}
else {
printHtmlPart(113)
createClosureForHtmlPart(116, 5)
invokeTag('link','g',690,['action':("restructure"),'resource':(loanInstance)],5)
printHtmlPart(115)
}
printHtmlPart(117)
if(true && (loanInstance&&loanInstance.status?.id <=2)) {
printHtmlPart(118)
}
else {
printHtmlPart(119)
}
printHtmlPart(120)
if(true && (loanInstance?.status?.id == 4 || loanInstance?.status?.id == 5)) {
printHtmlPart(110)
if(true && (loanInstance?.product?.productType?.id == 6)) {
printHtmlPart(102)
createClosureForHtmlPart(121, 6)
invokeTag('link','g',707,['action':("loanRelief"),'id':(loanInstance?.id)],6)
printHtmlPart(122)
}
printHtmlPart(3)
}
else {
printHtmlPart(110)
if(true && (loanInstance?.product?.productType?.id == 6)) {
printHtmlPart(123)
}
printHtmlPart(3)
}
printHtmlPart(124)
if(true && (loanInstance?.product?.productType.id == 7)) {
printHtmlPart(102)
createClosureForHtmlPart(125, 5)
invokeTag('link','g',714,['controller':("loan"),'action':("showDiscountSchedule"),'id':(loanInstance?.id)],5)
printHtmlPart(101)
}
printHtmlPart(3)
if(true && (loanInstance?.status?.id != 1 && loanInstance?.status?.id != 6)) {
printHtmlPart(110)
if(true && (loanInstance?.product?.productType?.id == 6)) {
printHtmlPart(126)
createClosureForHtmlPart(127, 6)
invokeTag('link','g',718,['controller':("loan"),'action':("loanGurantee"),'id':(loanInstance?.id)],6)
printHtmlPart(122)
}
printHtmlPart(128)
}
printHtmlPart(129)
}
else if(true && (module == "loanAmendment")) {
printHtmlPart(130)
createClosureForHtmlPart(131, 4)
invokeTag('link','g',723,['controller':(module),'action':("edit"),'id':(loanInstance?.id)],4)
printHtmlPart(85)
}
else if(true && (module == "loanInterestAccrual" && loanInstance?.status?.id==5)) {
printHtmlPart(132)
if(true && (loanInstance?.hasInterestAccrual)) {
printHtmlPart(133)
createTagBody(5, {->
printHtmlPart(134)
invokeTag('hiddenField','g',729,['id':("module"),'name':("module"),'value':(module)],-1)
printHtmlPart(135)
invokeTag('actionSubmit','g',732,['id':("stop"),'action':("stopInterestAccrual"),'value':("Stop Interest Accrual"),'onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');")],-1)
printHtmlPart(136)
})
invokeTag('form','g',740,['id':("stop-form"),'url':([controller: loan, id: loanInstance.id,  action:'stopInterestAccrual']),'method':("POST")],5)
printHtmlPart(111)
}
else {
printHtmlPart(133)
createTagBody(5, {->
printHtmlPart(93)
invokeTag('hiddenField','g',744,['id':("module"),'name':("module"),'value':(module)],-1)
printHtmlPart(135)
invokeTag('actionSubmit','g',745,['id':("start "),'action':("startInterestAccrual"),'value':("Start Interest Accrual"),'onclick':("return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');")],-1)
printHtmlPart(137)
})
invokeTag('form','g',752,['id':("start-form"),'url':([controller: loan, id: loanInstance.id,  action:'startInterestAccrual']),'method':("POST")],5)
printHtmlPart(111)
}
printHtmlPart(138)
}
else if(true && (module == "loanRepricing")) {
printHtmlPart(2)
if(true && (loanInstance?.product?.productType?.id == 6)) {
printHtmlPart(139)
}
printHtmlPart(138)
}
else if(true && (module == "loanReschedule")) {
printHtmlPart(132)
if(true && (loanInstance?.loanPerformanceId.id == 1 || loanInstance?.loanPerformanceId.id == 5 || loanInstance?.loanPerformanceId.id == 6)) {
printHtmlPart(102)
createClosureForHtmlPart(114, 5)
invokeTag('link','g',761,['controller':(module),'action':("reschedule"),'id':(loanInstance?.id)],5)
printHtmlPart(111)
}
printHtmlPart(140)
}
else if(true && (module == "loanRestructure")) {
printHtmlPart(2)
if(true && (loanInstance?.loanPerformanceId.id == 2 || loanInstance?.loanPerformanceId.id == 3)) {
printHtmlPart(3)
if(true && (loanInstance?.product?.productType?.id == 6)) {
printHtmlPart(99)
createClosureForHtmlPart(116, 6)
invokeTag('link','g',769,['controller':(module),'action':("restructure"),'id':(loanInstance?.id)],6)
printHtmlPart(101)
}
printHtmlPart(2)
}
printHtmlPart(140)
}
else if(true && (module == "loanGLClassification")) {
printHtmlPart(141)
}
else if(true && (module == "loanRenewal")) {
printHtmlPart(2)
if(true && (loanInstance?.product?.productType?.id == 6)) {
printHtmlPart(130)
createClosureForHtmlPart(142, 5)
invokeTag('link','g',778,['controller':(module),'action':("renew"),'id':(loanInstance?.id)],5)
printHtmlPart(143)
}
printHtmlPart(6)
}
else if(true && (module == "loanBranchTransfer")) {
printHtmlPart(144)
}
else if(true && (module == "loanApproval" && loanInstance?.status?.id <=2)) {
printHtmlPart(145)
if(true && (loanInstance?.product?.productType?.id == 6)) {
printHtmlPart(146)
}
printHtmlPart(147)
if(true && (loanInstance?.product?.productType?.id == 7)) {
printHtmlPart(148)
}
printHtmlPart(149)
createTagBody(4, {->
printHtmlPart(150)
invokeTag('textField','g',811,['class':("form-control"),'id':("txnParticulars"),'name':("txnParticulars"),'value':("")],-1)
printHtmlPart(151)
invokeTag('textField','g',818,['class':("form-control"),'id':("txnReference"),'name':("txnReference"),'value':("")],-1)
printHtmlPart(152)
createClosureForHtmlPart(153, 5)
invokeTag('javascript','g',847,[:],5)
printHtmlPart(154)
})
invokeTag('form','g',849,['id':("approve-form"),'url':([controller: loan, id: loanInstance.id,  action:'approved']),'method':("POST")],4)
printHtmlPart(138)
}
else if(true && (module == "loanApproval" && loanInstance?.status?.id ==3)) {
printHtmlPart(2)
if(true && (loanInstance?.product?.productType?.id == 6)) {
printHtmlPart(155)
}
printHtmlPart(156)
}
else if(true && (module == "loanTermination")) {
printHtmlPart(157)
if(true && (loanInstance?.status?.id == 2 || loanInstance?.status?.id == 3 || loanInstance?.status?.id == 4 || loanInstance?.status?.id == 5)) {
printHtmlPart(158)
createClosureForHtmlPart(159, 5)
invokeTag('link','g',876,['controller':("loan"),'action':("applyIntToDate"),'id':(loanInstance?.id)],5)
printHtmlPart(160)
createClosureForHtmlPart(161, 5)
invokeTag('link','g',878,['controller':("loan"),'action':("applyIntToMaturity"),'id':(loanInstance?.id)],5)
printHtmlPart(160)
createClosureForHtmlPart(162, 5)
invokeTag('link','g',879,['controller':("loan"),'action':("capitalizeAccruedInt"),'id':(loanInstance?.id)],5)
printHtmlPart(101)
}
printHtmlPart(132)
if(true && (loanInstance?.balanceAmount == 0 && loanInstance?.interestBalanceAmount ==  0 &&
                            loanInstance?.penaltyBalanceAmount == 0 && loanInstance?.serviceChargeBalanceAmount == 0 && 
                            (loanInstance?.status?.id == 1 || loanInstance?.status?.id == 2 || loanInstance?.status?.id == 3 || loanInstance?.status?.id == 4 || loanInstance?.status?.id == 5))) {
printHtmlPart(163)
}
printHtmlPart(132)
if(true && (loanInstance?.balanceAmount == 0 && loanInstance?.interestBalanceAmount ==  0 &&
                            loanInstance?.penaltyBalanceAmount == 0 && loanInstance?.serviceChargeBalanceAmount == 0 && 
                            loanInstance?.status?.id == 8)) {
printHtmlPart(164)
}
printHtmlPart(165)
if(true && (loanInstance?.balanceAmount == 0 && loanInstance?.interestBalanceAmount ==  0 &&
                            loanInstance?.penaltyBalanceAmount == 0 && loanInstance?.serviceChargeBalanceAmount == 0 && 
                            loanInstance?.status?.id == 6)) {
printHtmlPart(126)
createClosureForHtmlPart(166, 5)
invokeTag('link','g',893,['action':("reopen"),'resource':(loanInstance)],5)
printHtmlPart(101)
}
printHtmlPart(138)
}
else if(true && (module == "loanWriteOff")) {
printHtmlPart(83)
createClosureForHtmlPart(167, 4)
invokeTag('form','g',896,['url':([controller:loan, action:'transferToWriteOff', id:loanInstance.id]),'method':("POST")],4)
printHtmlPart(168)
createClosureForHtmlPart(169, 4)
invokeTag('link','g',897,['action':("viewWriteOff"),'id':(loanInstance.id)],4)
printHtmlPart(170)
createTagBody(4, {->
printHtmlPart(171)
createClosureForHtmlPart(172, 5)
invokeTag('link','g',899,['action':("viewWriteOff"),'id':(loanInstance.id)],5)
printHtmlPart(173)
invokeTag('actionSubmit','g',901,['action':("writeOff"),'value':("Write-Off")],-1)
printHtmlPart(174)
})
invokeTag('form','g',901,['url':([controller:loan, action:'writeOff', id:loanInstance.id]),'method':("POST")],4)
printHtmlPart(175)
}
else if(true && (module == "loanROPA")) {
printHtmlPart(176)
createClosureForHtmlPart(3, 4)
invokeTag('form','g',904,['url':([controller:loan, action:'transferToROPA', id:loanInstance.id]),'method':("POST")],4)
printHtmlPart(177)
createClosureForHtmlPart(178, 4)
invokeTag('link','g',906,['action':("viewRopa"),'id':(loanInstance.id)],4)
printHtmlPart(179)
createClosureForHtmlPart(180, 4)
invokeTag('link','g',907,['controller':("glBatch"),'action':("create")],4)
printHtmlPart(181)
createClosureForHtmlPart(182, 4)
invokeTag('link','g',908,['controller':(module),'action':("createSCR"),'id':(loanInstance?.id)],4)
printHtmlPart(183)
}
else if(true && (module == "loanProvision")) {
printHtmlPart(2)
if(true && (loanInstance?.product?.productType?.id == 6)) {
printHtmlPart(83)
createClosureForHtmlPart(184, 5)
invokeTag('link','g',912,['controller':("loan"),'action':("loanUidDebit"),'id':(loanInstance?.id)],5)
printHtmlPart(177)
createClosureForHtmlPart(185, 5)
invokeTag('link','g',913,['controller':("loan"),'action':("loanUidCredit"),'id':(loanInstance?.id)],5)
printHtmlPart(177)
createClosureForHtmlPart(186, 5)
invokeTag('link','g',918,['controller':("loan"),'action':("loanAllowanceCredit"),'id':(loanInstance?.id)],5)
printHtmlPart(177)
createClosureForHtmlPart(187, 5)
invokeTag('link','g',921,['controller':("loan"),'action':("loanAllowanceTransferDebit"),'id':(loanInstance?.id)],5)
printHtmlPart(177)
createClosureForHtmlPart(188, 5)
invokeTag('link','g',923,['controller':("loan"),'action':("loanAllowanceTransferCredit"),'id':(loanInstance?.id)],5)
printHtmlPart(177)
createClosureForHtmlPart(189, 5)
invokeTag('link','g',925,['controller':("loan"),'action':("loanServiceChargeCredit"),'id':(loanInstance?.id)],5)
printHtmlPart(177)
createClosureForHtmlPart(190, 5)
invokeTag('link','g',928,['controller':("loan"),'action':("loanServiceChargeDebit"),'id':(loanInstance?.id)],5)
printHtmlPart(177)
createClosureForHtmlPart(191, 5)
invokeTag('link','g',930,['controller':("loan"),'action':("loanDeferredCredit"),'id':(loanInstance?.id)],5)
printHtmlPart(177)
createClosureForHtmlPart(192, 5)
invokeTag('link','g',931,['controller':("loan"),'action':("loanDeferredDebit"),'id':(loanInstance?.id)],5)
printHtmlPart(143)
}
printHtmlPart(138)
}
else if(true && (module == "scr")) {
printHtmlPart(83)
createClosureForHtmlPart(193, 4)
invokeTag('link','g',933,['controller':("loan"),'action':("loanScrMaintenance"),'id':(loanInstance?.id)],4)
printHtmlPart(85)
}
printHtmlPart(194)
if(true && (loanInstance?.status?.id == 8)) {
printHtmlPart(83)
createClosureForHtmlPart(195, 4)
invokeTag('link','g',934,['controller':("loan"),'action':("loanWriteOffCollectionList"),'id':(loanInstance?.id)],4)
printHtmlPart(85)
}
printHtmlPart(196)
})
invokeTag('captureContent','sitemesh',935,['tag':("main-actions")],2)
printHtmlPart(44)
})
invokeTag('captureBody','sitemesh',935,[:],1)
printHtmlPart(197)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1597129109941L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
