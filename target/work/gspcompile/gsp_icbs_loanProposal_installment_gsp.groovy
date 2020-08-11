import icbs.loans.LoanApplication
import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_icbs_loanProposal_installment_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/loanProposal/_installment.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
invokeTag('set','g',4,['var':("loanService"),'bean':("loanService")],-1)
printHtmlPart(1)
invokeTag('set','g',19,['var':("totalPrincipal"),'value':(0)],-1)
printHtmlPart(2)
invokeTag('set','g',20,['var':("totalInterest"),'value':(0)],-1)
printHtmlPart(2)
invokeTag('set','g',21,['var':("totalDue"),'value':(0)],-1)
printHtmlPart(3)
if(true && (interestIncomeScheme.installmentCalcType.id == 1 && interestIncomeScheme.advInterestType.id == 1)) {
printHtmlPart(4)
invokeTag('set','g',27,['var':("dueDate"),'value':(firstInstallmentDate ?: openingDate + term)],-1)
printHtmlPart(5)
invokeTag('set','g',28,['var':("term"),'value':(dueDate - (interestStartDate ?: openingDate))],-1)
printHtmlPart(5)
invokeTag('set','g',29,['var':("interest"),'value':((amount * interestRate * term) / divisor)],-1)
printHtmlPart(5)
invokeTag('set','g',30,['var':("due"),'value':(amount + interest)],-1)
printHtmlPart(6)
invokeTag('formatDate','g',32,['format':("MM-dd-yyyy"),'date':(dueDate)],-1)
printHtmlPart(7)
invokeTag('formatNumber','g',33,['format':("###,###,##0.00"),'number':(amount)],-1)
printHtmlPart(7)
invokeTag('formatNumber','g',34,['format':("###,###,##0.00"),'number':(interest)],-1)
printHtmlPart(7)
invokeTag('formatNumber','g',35,['format':("###,###,##0.00"),'number':(due)],-1)
printHtmlPart(8)
invokeTag('set','g',37,['var':("totalPrincipal"),'value':(amount)],-1)
printHtmlPart(5)
invokeTag('set','g',38,['var':("totalInterest"),'value':(interest)],-1)
printHtmlPart(5)
invokeTag('set','g',39,['var':("totalDue"),'value':(due)],-1)
printHtmlPart(9)
}
printHtmlPart(10)
if(true && (interestIncomeScheme.installmentCalcType.id == 1 && interestIncomeScheme.advInterestType.id == 2)) {
printHtmlPart(11)
invokeTag('set','g',45,['var':("dueDate"),'value':(firstInstallmentDate ?: openingDate + term)],-1)
printHtmlPart(12)
invokeTag('set','g',46,['var':("term"),'value':(dueDate - (interestStartDate ?: openingDate))],-1)
printHtmlPart(12)
invokeTag('set','g',47,['var':("interest"),'value':((amount * interestRate * term) / divisor)],-1)
printHtmlPart(12)
invokeTag('set','g',48,['var':("due"),'value':(amount - interest)],-1)
printHtmlPart(12)
invokeTag('set','g',49,['var':("due1"),'value':(amount)],-1)
printHtmlPart(12)
invokeTag('set','g',50,['var':("interest1"),'value':(interest - interest)],-1)
printHtmlPart(13)
invokeTag('formatDate','g',52,['format':("MM-dd-yyyy"),'date':(dueDate)],-1)
printHtmlPart(14)
invokeTag('formatNumber','g',53,['format':("###,###,##0.00"),'number':(amount)],-1)
printHtmlPart(14)
invokeTag('formatNumber','g',54,['format':("###,###,##0.00"),'number':("${interest1} ")],-1)
printHtmlPart(14)
invokeTag('formatNumber','g',55,['format':("###,###,##0.00"),'number':(due1)],-1)
printHtmlPart(15)
invokeTag('set','g',57,['var':("totalPrincipal"),'value':(amount)],-1)
printHtmlPart(12)
invokeTag('set','g',58,['var':("totalInterest"),'value':(interest)],-1)
printHtmlPart(12)
invokeTag('set','g',59,['var':("totalDue"),'value':("${due1} ")],-1)
printHtmlPart(16)
}
else if(true && (interestIncomeScheme.installmentType.id == 5 || interestIncomeScheme.installmentCalcType.id == 6)) {
printHtmlPart(17)
invokeTag('set','g',65,['var':("prevDueDate"),'value':(firstInstallmentDate)],-1)
printHtmlPart(17)
invokeTag('set','g',66,['var':("baseDate"),'value':(firstInstallmentDate)],-1)
printHtmlPart(17)
invokeTag('set','g',67,['var':("prevBalance"),'value':(amount)],-1)
printHtmlPart(17)
for( i in (1..installmentDates.size()) ) {
printHtmlPart(18)
if(true && (i == 1 && firstInstallmentDate)) {
printHtmlPart(19)
invokeTag('set','g',71,['var':("dueDate"),'value':(firstInstallmentDate)],-1)
printHtmlPart(5)
}
else {
printHtmlPart(19)
invokeTag('set','g',74,['var':("dueDate"),'value':(installmentDates[i - 1])],-1)
printHtmlPart(5)
}
printHtmlPart(5)

/*def interest
                        if (interestStartDate) {
                            if (dueDate > interestStartDate) {
                                interest = prevBalance * (interestRate / divisor) * (dueDate - interestStartDate)
                                interestStartDate = null
                            } else {
                                interest = 0
                            }                            
                        } else {
                            interest = prevBalance * (interestRate / divisor) * (dueDate - prevDueDate)
                        }*/

printHtmlPart(20)
invokeTag('set','g',89,['var':("due"),'value':(principalAmounts[i - 1] + interestAmounts[i - 1])],-1)
printHtmlPart(5)
invokeTag('set','g',90,['var':("balance"),'value':(prevBalance - principalAmounts[i - 1])],-1)
printHtmlPart(21)
expressionOut.print(i)
printHtmlPart(7)
invokeTag('formatDate','g',91,['format':("MM-dd-yyyy"),'date':(dueDate)],-1)
printHtmlPart(7)
invokeTag('formatNumber','g',93,['format':("###,###,##0.00"),'number':(principalAmounts[i - 1])],-1)
printHtmlPart(7)
invokeTag('formatNumber','g',94,['format':("###,###,##0.00"),'number':(interestAmounts[i - 1])],-1)
printHtmlPart(7)
invokeTag('formatNumber','g',95,['format':("###,###,##0.00"),'number':(due)],-1)
printHtmlPart(7)
invokeTag('formatNumber','g',96,['format':("###,###,##0.00"),'number':(balance)],-1)
printHtmlPart(22)
invokeTag('set','g',97,['var':("prevDueDate"),'value':(dueDate)],-1)
printHtmlPart(5)
invokeTag('set','g',97,['var':("prevBalance"),'value':(balance)],-1)
printHtmlPart(5)
invokeTag('set','g',99,['var':("totalPrincipal"),'value':(totalPrincipal + principalAmounts[i - 1])],-1)
printHtmlPart(5)
invokeTag('set','g',100,['var':("totalInterest"),'value':(totalInterest + interestAmounts[i - 1])],-1)
printHtmlPart(5)
invokeTag('set','g',101,['var':("totalDue"),'value':(totalDue + due)],-1)
printHtmlPart(23)
}
printHtmlPart(2)
}
else if(true && (interestIncomeScheme.installmentCalcType.id == 2)) {
printHtmlPart(24)
invokeTag('set','g',109,['var':("principal"),'value':(amount / (numInstallments + balloonInstallments))],-1)
printHtmlPart(17)
invokeTag('set','g',109,['var':("prevDueDate"),'value':(firstInstallmentDate)],-1)
printHtmlPart(17)
invokeTag('set','g',110,['var':("baseDate"),'value':(firstInstallmentDate)],-1)
printHtmlPart(17)
invokeTag('set','g',111,['var':("prevBalance"),'value':(amount)],-1)
printHtmlPart(17)
for( i in (1..numInstallments) ) {
printHtmlPart(18)
if(true && (i == numInstallments && balloonInstallments > 0)) {
printHtmlPart(19)
invokeTag('set','g',115,['var':("principal"),'value':(amount - (principal * (i - 1)))],-1)
printHtmlPart(5)
}
printHtmlPart(25)
if(true && (i == 1 && firstInstallmentDate)) {
printHtmlPart(19)
invokeTag('set','g',118,['var':("dueDate"),'value':(firstInstallmentDate)],-1)
printHtmlPart(5)
}
else {
printHtmlPart(19)
invokeTag('set','g',121,['var':("dueDate"),'value':(loanService.getNextDueDate(prevDueDate, baseDate, frequency))],-1)
printHtmlPart(5)
}
printHtmlPart(26)

def interest
                        def numDays
                        if (interestStartDate) {                        
                            if (dueDate > interestStartDate) {
                                numDays = dueDate - interestStartDate
                                if (frequency == 1 || frequency == 2) {
                                    numDays = 1
                                }
                                interest = prevBalance * (interestRate / divisor) * numDays
                                interestStartDate = null
                            } else {
                                interest = 0
                            }
                        } else {
                            numDays = dueDate - prevDueDate
                            if (frequency == 1 || frequency == 2) {
                                numDays = 1
                            }
                            interest = prevBalance * (interestRate / divisor) * numDays
                        }

printHtmlPart(27)
invokeTag('set','g',145,['var':("due"),'value':(principal + interest)],-1)
printHtmlPart(5)
invokeTag('set','g',147,['var':("balance"),'value':(prevBalance - principal)],-1)
printHtmlPart(21)
expressionOut.print(i)
printHtmlPart(28)
invokeTag('formatDate','g',150,['format':("MM-dd-yyyy"),'date':(dueDate)],-1)
printHtmlPart(7)
invokeTag('formatNumber','g',151,['format':("###,###,##0.00"),'number':(principal)],-1)
printHtmlPart(7)
invokeTag('formatNumber','g',153,['format':("###,###,##0.00"),'number':(interest)],-1)
printHtmlPart(7)
invokeTag('formatNumber','g',154,['format':("###,###,##0.00"),'number':(due)],-1)
printHtmlPart(7)
invokeTag('formatNumber','g',156,['format':("###,###,##0.00"),'number':(balance)],-1)
printHtmlPart(22)
invokeTag('set','g',157,['var':("prevDueDate"),'value':(dueDate)],-1)
printHtmlPart(5)
invokeTag('set','g',159,['var':("prevBalance"),'value':(balance)],-1)
printHtmlPart(5)
invokeTag('set','g',160,['var':("totalPrincipal"),'value':(totalPrincipal + principal)],-1)
printHtmlPart(5)
invokeTag('set','g',161,['var':("totalInterest"),'value':(totalInterest + interest)],-1)
printHtmlPart(5)
invokeTag('set','g',161,['var':("totalDue"),'value':(totalDue + due)],-1)
printHtmlPart(29)
}
printHtmlPart(2)
}
else if(true && (interestIncomeScheme.installmentCalcType.id == 3  || interestIncomeScheme.installmentCalcType.id == 8)) {
printHtmlPart(17)

def frequencyFactor
                    if (frequency == 1 || frequency == 2) {
                        frequencyFactor = 365
                    } else if (frequency == 3) {
                        frequencyFactor = 52
                    } else if (frequency == 4) {
                        frequencyFactor = 26
                    } else if (frequency == 5) {
                        frequencyFactor = 24
                    } else if (frequency == 6 || frequency == 7) {
                        frequencyFactor = 12
                    } else if (frequency == 8) {
                        frequencyFactor = 6
                    } else if (frequency == 9) {
                        frequencyFactor = 4
                    } else if (frequency == 10) {
                        frequencyFactor = 2
                    } else if (frequency == 11) {
                        frequencyFactor = 1
                    } else {
                        frequencyFactor = 365
                    }
                    def factor = interestRate / frequencyFactor
                    def due = installmentAmount ?: amount * (factor / (1 - ((1 / (1 + factor))**numInstallments)))

printHtmlPart(30)
invokeTag('set','g',189,['var':("prevDueDate"),'value':(firstInstallmentDate)],-1)
printHtmlPart(17)
invokeTag('set','g',190,['var':("baseDate"),'value':(firstInstallmentDate)],-1)
printHtmlPart(31)
invokeTag('set','g',192,['var':("prevBalance"),'value':(amount)],-1)
printHtmlPart(32)
for( i in (1..numInstallments) ) {
printHtmlPart(18)
if(true && (i == 1 && firstInstallmentDate)) {
printHtmlPart(19)
invokeTag('set','g',198,['var':("dueDate"),'value':(firstInstallmentDate)],-1)
printHtmlPart(5)
}
else {
printHtmlPart(33)
invokeTag('set','g',201,['var':("dueDate"),'value':(loanService.getNextDueDate(prevDueDate, baseDate, frequency))],-1)
printHtmlPart(5)
}
printHtmlPart(26)

def interest
                        def numDays
                        if (interestStartDate) {                        
                            if (dueDate > interestStartDate) {
                                numDays = dueDate - interestStartDate
                                if (frequency == 1 || frequency == 2) {
                                    numDays = 1
                                }
                                interest = prevBalance * (interestRate / divisor) * numDays
                                interestStartDate = null
                            } else {
                                interest = 0
                            }
                        } else {
                            numDays = dueDate - prevDueDate
                            if (frequency == 1 || frequency == 2) {
                                numDays = 1
                            }
                            interest = prevBalance * (interestRate / divisor) * numDays
                        }
                        def principal
                        if (i == numInstallments) {
                            principal = prevBalance
                            due = principal + interest
                        } else {
                            principal = due - interest
                        }

printHtmlPart(34)
invokeTag('set','g',230,['var':("balance"),'value':(prevBalance - principal)],-1)
printHtmlPart(21)
expressionOut.print(i)
printHtmlPart(28)
invokeTag('formatDate','g',232,['format':("MM-dd-yyyy"),'date':(dueDate)],-1)
printHtmlPart(7)
invokeTag('formatNumber','g',234,['format':("###,###,##0.00"),'number':(principal)],-1)
printHtmlPart(7)
invokeTag('formatNumber','g',237,['format':("###,###,##0.00"),'number':(interest)],-1)
printHtmlPart(7)
invokeTag('formatNumber','g',239,['format':("###,###,##0.00"),'number':(due)],-1)
printHtmlPart(7)
invokeTag('formatNumber','g',241,['format':("###,###,##0.00"),'number':(balance)],-1)
printHtmlPart(22)
invokeTag('set','g',244,['var':("prevDueDate"),'value':(dueDate)],-1)
printHtmlPart(5)
invokeTag('set','g',244,['var':("prevBalance"),'value':(balance)],-1)
printHtmlPart(5)
invokeTag('set','g',246,['var':("totalPrincipal"),'value':(totalPrincipal + principal)],-1)
printHtmlPart(5)
invokeTag('set','g',248,['var':("totalInterest"),'value':(totalInterest + interest)],-1)
printHtmlPart(5)
invokeTag('set','g',248,['var':("totalDue"),'value':(totalDue + due)],-1)
printHtmlPart(29)
}
printHtmlPart(2)
}
else if(true && (interestIncomeScheme.installmentCalcType.id == 4)) {
printHtmlPart(17)
invokeTag('set','g',253,['var':("prevDueDate"),'value':(firstInstallmentDate)],-1)
printHtmlPart(17)
invokeTag('set','g',255,['var':("baseDate"),'value':(firstInstallmentDate)],-1)
printHtmlPart(17)
invokeTag('set','g',255,['var':("factor"),'value':(0)],-1)
printHtmlPart(17)
for( i in (1..numInstallments) ) {
printHtmlPart(5)
if(true && (i == 1 && firstInstallmentDate)) {
printHtmlPart(19)
invokeTag('set','g',259,['var':("dueDate"),'value':(firstInstallmentDate)],-1)
printHtmlPart(5)
}
else {
printHtmlPart(19)
invokeTag('set','g',261,['var':("dueDate"),'value':(loanService.getNextDueDate(prevDueDate, baseDate, frequency))],-1)
printHtmlPart(5)
}
printHtmlPart(25)
invokeTag('set','g',262,['var':("prevDueDate"),'value':(dueDate)],-1)
printHtmlPart(5)
invokeTag('set','g',263,['var':("factor"),'value':(factor + i)],-1)
printHtmlPart(17)
}
printHtmlPart(32)
invokeTag('set','g',264,['var':("maturityDate"),'value':(dueDate)],-1)
printHtmlPart(35)
if(true && (interestStartDate)) {
printHtmlPart(5)
invokeTag('set','g',266,['var':("term"),'value':(maturityDate - interestStartDate)],-1)
printHtmlPart(17)
}
else {
printHtmlPart(5)
invokeTag('set','g',268,['var':("term"),'value':(maturityDate - openingDate)],-1)
printHtmlPart(17)
}
printHtmlPart(36)
if(true && (frequency == 2)) {
printHtmlPart(5)
if(true && (interestStartDate)) {
printHtmlPart(19)
invokeTag('set','g',274,['var':("weekends"),'value':(loanService.getNumOfWeekends(interestStartDate, maturityDate))],-1)
printHtmlPart(19)
invokeTag('set','g',276,['var':("term"),'value':(maturityDate - interestStartDate - weekends)],-1)
printHtmlPart(5)
}
else {
printHtmlPart(19)
invokeTag('set','g',278,['var':("weekends"),'value':(loanService.getNumOfWeekends(openingDate, maturityDate))],-1)
printHtmlPart(19)
invokeTag('set','g',280,['var':("term"),'value':(maturityDate - openingDate - weekends)],-1)
printHtmlPart(5)
}
printHtmlPart(37)
}
printHtmlPart(36)
invokeTag('set','g',282,['var':("principal"),'value':(amount / numInstallments)],-1)
printHtmlPart(38)
invokeTag('set','g',284,['var':("totalInterest"),'value':(amount * (interestRate / divisor) * term)],-1)
printHtmlPart(38)
invokeTag('set','g',286,['var':("prevDueDate"),'value':(firstInstallmentDate),'<g:set var':("baseDate")],-1)
printHtmlPart(31)
invokeTag('set','g',287,['var':("prevBalance"),'value':(amount)],-1)
printHtmlPart(17)
for( i in (1..numInstallments) ) {
printHtmlPart(39)
if(true && (i == 1 && firstInstallmentDate)) {
printHtmlPart(19)
invokeTag('set','g',292,['var':("dueDate"),'value':(firstInstallmentDate)],-1)
printHtmlPart(5)
}
else {
printHtmlPart(19)
invokeTag('set','g',295,['var':("dueDate"),'value':(loanService.getNextDueDate(prevDueDate, baseDate, frequency))],-1)
printHtmlPart(5)
}
printHtmlPart(40)
invokeTag('set','g',300,['var':("interest"),'value':(((numInstallments + 1 - i) / factor) * totalInterest)],-1)
printHtmlPart(5)
invokeTag('set','g',301,['var':("due"),'value':(principal + interest)],-1)
printHtmlPart(5)
invokeTag('set','g',301,['var':("balance"),'value':(prevBalance - principal)],-1)
printHtmlPart(21)
expressionOut.print(i)
printHtmlPart(28)
invokeTag('formatDate','g',303,['format':("MM-dd-yyyy"),'date':(dueDate)],-1)
printHtmlPart(7)
invokeTag('formatNumber','g',305,['format':("###,###,##0.00"),'number':(principal)],-1)
printHtmlPart(7)
invokeTag('formatNumber','g',306,['format':("###,###,##0.00"),'number':(interest)],-1)
printHtmlPart(7)
invokeTag('formatNumber','g',308,['format':("###,###,##0.00"),'number':(due)],-1)
printHtmlPart(7)
invokeTag('formatNumber','g',311,['format':("###,###,##0.00"),'number':(balance)],-1)
printHtmlPart(22)
invokeTag('set','g',311,['var':("prevDueDate"),'value':(dueDate)],-1)
printHtmlPart(5)
invokeTag('set','g',312,['var':("prevBalance"),'value':(balance)],-1)
printHtmlPart(5)
invokeTag('set','g',313,['var':("totalPrincipal"),'value':(totalPrincipal + principal)],-1)
printHtmlPart(5)
invokeTag('set','g',314,['var':("totalDue"),'value':(totalDue + due)],-1)
printHtmlPart(29)
}
printHtmlPart(41)
}
else if(true && (interestIncomeScheme.installmentCalcType.id == 5)) {
printHtmlPart(17)
invokeTag('set','g',319,['var':("prevDueDate"),'value':(firstInstallmentDate)],-1)
printHtmlPart(17)
invokeTag('set','g',321,['var':("baseDate"),'value':(firstInstallmentDate)],-1)
printHtmlPart(17)
for( i in (1..numInstallments) ) {
printHtmlPart(5)
if(true && (i == 1 && firstInstallmentDate)) {
printHtmlPart(19)
invokeTag('set','g',323,['var':("dueDate"),'value':(firstInstallmentDate)],-1)
printHtmlPart(5)
}
else {
printHtmlPart(19)
invokeTag('set','g',326,['var':("dueDate"),'value':(loanService.getNextDueDate(prevDueDate, baseDate, frequency))],-1)
printHtmlPart(5)
}
printHtmlPart(25)
invokeTag('set','g',327,['var':("prevDueDate"),'value':(dueDate)],-1)
printHtmlPart(17)
}
printHtmlPart(17)
invokeTag('set','g',329,['var':("maturityDate"),'value':(dueDate)],-1)
printHtmlPart(36)
if(true && (interestStartDate)) {
printHtmlPart(5)
invokeTag('set','g',330,['var':("term"),'value':(maturityDate - interestStartDate)],-1)
printHtmlPart(17)
}
else {
printHtmlPart(5)
invokeTag('set','g',332,['var':("term"),'value':(maturityDate - openingDate)],-1)
printHtmlPart(17)
}
printHtmlPart(36)
if(true && (frequency == 2)) {
printHtmlPart(5)
if(true && (interestStartDate)) {
printHtmlPart(19)
invokeTag('set','g',334,['var':("weekends"),'value':(loanService.getNumOfWeekends(interestStartDate, maturityDate))],-1)
printHtmlPart(19)
invokeTag('set','g',336,['var':("term"),'value':(maturityDate - interestStartDate - weekends)],-1)
printHtmlPart(5)
}
else {
printHtmlPart(19)
invokeTag('set','g',339,['var':("weekends"),'value':(loanService.getNumOfWeekends(openingDate, maturityDate))],-1)
printHtmlPart(19)
invokeTag('set','g',342,['var':("term"),'value':(maturityDate - openingDate - weekends)],-1)
printHtmlPart(5)
}
printHtmlPart(38)
}
printHtmlPart(36)
invokeTag('set','g',344,['var':("totalInterest"),'value':(amount * (interestRate / divisor) * term)],-1)
printHtmlPart(17)
invokeTag('set','g',346,['var':("interest"),'value':(totalInterest / (numInstallments + balloonInstallments))],-1)
printHtmlPart(17)
invokeTag('set','g',348,['var':("principal"),'value':(amount / (numInstallments + balloonInstallments))],-1)
printHtmlPart(17)
invokeTag('set','g',349,['var':("prevDueDate"),'value':(firstInstallmentDate)],-1)
printHtmlPart(17)
invokeTag('set','g',351,['var':("baseDate"),'value':(firstInstallmentDate)],-1)
printHtmlPart(17)
invokeTag('set','g',351,['var':("prevBalance"),'value':(amount)],-1)
printHtmlPart(17)
for( i in (1..numInstallments) ) {
printHtmlPart(18)
if(true && (i == numInstallments && balloonInstallments > 0)) {
printHtmlPart(19)
invokeTag('set','g',355,['var':("principal"),'value':(amount - (principal * (i - 1)))],-1)
printHtmlPart(19)
invokeTag('set','g',358,['var':("interest"),'value':(totalInterest - (interest * (i - 1)))],-1)
printHtmlPart(5)
}
printHtmlPart(42)
if(true && (i == 1 && firstInstallmentDate)) {
printHtmlPart(19)
invokeTag('set','g',362,['var':("dueDate"),'value':(firstInstallmentDate)],-1)
printHtmlPart(5)
}
else {
printHtmlPart(19)
invokeTag('set','g',366,['var':("dueDate"),'value':(loanService.getNextDueDate(prevDueDate, baseDate, frequency))],-1)
printHtmlPart(5)
}
printHtmlPart(43)
invokeTag('set','g',367,['var':("due"),'value':(principal + interest)],-1)
printHtmlPart(5)
invokeTag('set','g',368,['var':("balance"),'value':(prevBalance - principal)],-1)
printHtmlPart(21)
expressionOut.print(i)
printHtmlPart(28)
invokeTag('formatDate','g',371,['format':("MM-dd-yyyy"),'date':(dueDate)],-1)
printHtmlPart(7)
invokeTag('formatNumber','g',371,['format':("###,###,##0.00"),'number':(principal)],-1)
printHtmlPart(7)
invokeTag('formatNumber','g',373,['format':("###,###,##0.00"),'number':(interest)],-1)
printHtmlPart(7)
invokeTag('formatNumber','g',376,['format':("###,###,##0.00"),'number':(due)],-1)
printHtmlPart(7)
invokeTag('formatNumber','g',377,['format':("###,###,##0.00"),'number':(balance)],-1)
printHtmlPart(22)
invokeTag('set','g',378,['var':("prevDueDate"),'value':(dueDate)],-1)
printHtmlPart(5)
invokeTag('set','g',378,['var':("prevBalance"),'value':(balance)],-1)
printHtmlPart(5)
invokeTag('set','g',380,['var':("totalPrincipal"),'value':(totalPrincipal + principal)],-1)
printHtmlPart(5)
invokeTag('set','g',381,['var':("totalDue"),'value':(totalDue + due)],-1)
printHtmlPart(29)
}
printHtmlPart(2)
}
else if(true && (interestIncomeScheme.installmentCalcType.id == 7)) {
printHtmlPart(17)

def frequencyFactor
                    if (frequency == 1 || frequency == 2) {
                        frequencyFactor = 365
                    } else if (frequency == 3) {
                        frequencyFactor = 52
                    } else if (frequency == 4) {
                        frequencyFactor = 26
                    } else if (frequency == 5) {
                        frequencyFactor = 24
                    } else if (frequency == 6 || frequency == 7) {
                        frequencyFactor = 12
                    } else if (frequency == 8) {
                        frequencyFactor = 6
                    } else if (frequency == 9) {
                        frequencyFactor = 4
                    } else if (frequency == 10) {
                        frequencyFactor = 2
                    } else if (frequency == 11) {
                        frequencyFactor = 1
                    } else {
                        frequencyFactor = 365
                    }
                    def factor = interestRate / frequencyFactor
                    def due = installmentAmount ?: amount * (factor / (1 - ((1 / (1 + factor))**numInstallments)))

printHtmlPart(30)
invokeTag('set','g',403,['var':("prevDueDate"),'value':(firstInstallmentDate)],-1)
printHtmlPart(17)
invokeTag('set','g',404,['var':("baseDate"),'value':(firstInstallmentDate)],-1)
printHtmlPart(31)
invokeTag('set','g',405,['var':("prevBalance"),'value':(amount)],-1)
printHtmlPart(32)
for( i in (1..numInstallments) ) {
printHtmlPart(18)
if(true && (i == 1 && firstInstallmentDate)) {
printHtmlPart(19)
invokeTag('set','g',408,['var':("dueDate"),'value':(firstInstallmentDate)],-1)
printHtmlPart(5)
}
else {
printHtmlPart(33)
invokeTag('set','g',413,['var':("dueDate"),'value':(loanService.getNextDueDate(prevDueDate, baseDate, frequency))],-1)
printHtmlPart(5)
}
printHtmlPart(26)

def interest
                        def numDays
                        if (interestStartDate) {                        
                            if (dueDate > interestStartDate) {
                                numDays = dueDate - interestStartDate
                                if (frequency == 1 || frequency == 2) {
                                    numDays = 1
                                }
                                interest = prevBalance * (interestRate / divisor) * numDays
                                interestStartDate = null
                            } else {
                                interest = 0
                            }
                        } else {
                            numDays = dueDate - prevDueDate
                            if (frequency == 1 || frequency == 2) {
                                numDays = 1
                            }
                            interest = prevBalance * (interestRate / divisor) * numDays
                            if (frequency == 7){
                                interest = prevBalance * (interestRate / 12)
                            }
                        }
                        def principal
                        if (i == numInstallments) {
                            principal = prevBalance
                            due = principal + interest
                        } else {
                            principal = due - interest
                        }

printHtmlPart(34)
invokeTag('set','g',448,['var':("balance"),'value':(prevBalance - principal)],-1)
printHtmlPart(21)
expressionOut.print(i)
printHtmlPart(28)
invokeTag('formatDate','g',450,['format':("MM-dd-yyyy"),'date':(dueDate)],-1)
printHtmlPart(7)
invokeTag('formatNumber','g',452,['format':("###,###,##0.00"),'number':(principal)],-1)
printHtmlPart(7)
invokeTag('formatNumber','g',454,['format':("###,###,##0.00"),'number':(interest)],-1)
printHtmlPart(7)
invokeTag('formatNumber','g',457,['format':("###,###,##0.00"),'number':(due)],-1)
printHtmlPart(7)
invokeTag('formatNumber','g',458,['format':("###,###,##0.00"),'number':(balance)],-1)
printHtmlPart(22)
invokeTag('set','g',459,['var':("prevDueDate"),'value':(dueDate)],-1)
printHtmlPart(5)
invokeTag('set','g',460,['var':("prevBalance"),'value':(balance)],-1)
printHtmlPart(5)
invokeTag('set','g',462,['var':("totalPrincipal"),'value':(totalPrincipal + principal)],-1)
printHtmlPart(5)
invokeTag('set','g',463,['var':("totalInterest"),'value':(totalInterest + interest)],-1)
printHtmlPart(5)
invokeTag('set','g',465,['var':("totalDue"),'value':(totalDue + due)],-1)
printHtmlPart(29)
}
printHtmlPart(2)
}
printHtmlPart(44)
invokeTag('formatNumber','g',471,['format':("###,###,##0.00"),'number':(totalPrincipal)],-1)
printHtmlPart(45)
invokeTag('formatNumber','g',473,['format':("###,###,##0.00"),'number':(totalInterest)],-1)
printHtmlPart(45)
invokeTag('formatNumber','g',475,['format':("###,###,##0.00"),'number':(totalDue)],-1)
printHtmlPart(46)
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
