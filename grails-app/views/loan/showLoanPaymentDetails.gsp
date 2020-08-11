<%@ page import="icbs.loans.LoanLedger" %>
<%@ page import="icbs.tellering.TxnBreakdown" %>
<%@ page import="icbs.gl.GlAccount" %>
<%@ page import="icbs.admin.Currency" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'loanLedger.label', default: 'LoanLedger')}" />
		<title>Payment Transaction Details</title>
              
	</head>
	<body>
        <content tag="breadcrumbs">
            <span class="fa fa-chevron-right"></span><span class="current">Loan Payment Transaction Details</span>
	</content>
        <content tag="main-content">   
		<div id="show-loanLedger" class="content scaffold-show" role="main">
                    <g:if test="${flash.message}">
                        <div class="box-body">
                            <div class="alert alert-info alert-dismissable">
                                <i class="fa fa-info"></i>
                                <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                                <b>Message</b> <div class="message" role="status">${flash.message}</div>
                            </div>
                        </div>
                    </g:if>
                    <g:else>
                        <g:if test="${loanReversalHist}">
                        <div class="box-body">
                            <div class="alert alert-danger alert-dismissable">
                                <i class="fa fa-info"></i>
                                <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                                <b>Payment Already Reversed</b> <div class="message" role="status"></div>
                            </div>
                        </div>
                        </g:if>
                    </g:else>
                <g:textField name="loanid" id="loanid" value="${loanLedgerInstance?.loan?.id}"style="display:none"  />
                  
                <div class="col-md-12">  
                    <div class="section-container">
                        <legend class="section-header">Loan Ledger Details</legend>
                       
                         <table class="table table-bordered table-striped">
                            <tbody>
                               
                                <tr>
                                    <td style="font-weight:bold" width="30%">Loan Account</td>
                                    <td width="70%"><g:link action="show" controller="loan" id="${txnLoanPaymentDetailsInstance?.acct?.id}">${txnLoanPaymentDetailsInstance?.acct?.accountNo}</g:link></td>
                                </tr>
                                <tr>
                                    <td style="font-weight:bold" width="30%">Borrower Name</td>
                                    <td width="70%"><g:link controller="customer" action="customerInquiry" id="${txnLoanPaymentDetailsInstance?.acct?.customer?.id}">${txnLoanPaymentDetailsInstance?.acct?.customer?.displayName}</g:link></td>
                                </tr>
                                
                                <tr>
                                    <td style="font-weight:bold" width="30%">Transaction ID</td>
                                    <td width="70%">${txnLoanPaymentDetailsInstance?.txnFile?.id}</td>
                                </tr>
                                <tr>
                                    <td style="font-weight:bold" width="30%">Transaction Type</td>
                                    <td width="70%">${txnLoanPaymentDetailsInstance?.txnFile?.txnType?.description}</td>
                                </tr>
                                <tr>
                                    <td style="font-weight:bold" width="30%">Transaction Code</td>
                                    <td width="70%">${txnLoanPaymentDetailsInstance?.txnFile?.txnTemplate?.description}</td>
                                </tr>
                                <tr>
                                    <td style="font-weight:bold" width="30%">Transaction Reference</td>
                                    <td width="70%">${txnLoanPaymentDetailsInstance?.txnRef}</td>
                                </tr>
                                <tr>
                                    <td style="font-weight:bold" width="30%">Transaction Particulars</td>
                                    <td width="70%">${txnLoanPaymentDetailsInstance?.txnFile?.txnParticulars}</td>
                                </tr>
                                <tr>
                                    <td style="font-weight:bold" width="30%">Transaction Date</td>
                                    <td width="70%"><g:formatDate date="${txnLoanPaymentDetailsInstance?.txnDate}" type="date" style="FULL"/></td>
                                </tr>
                                <tr>
                                    <td style="font-weight:bold" width="30%">Transaction Amount</td>
                                    <td width="70%"><g:formatNumber format="###,###,##0.00" number="${txnLoanPaymentDetailsInstance?.txnFile?.txnAmt}" /></td>
                                </tr>
                            </tbody>
                        </table>    

                            </div>
                            <div class="section-container">
                                <legend class="section-header" >Loan Ledger Financial Details</legend>
                                <table class="table table-bordered table-striped">
                                    <tbody>
                                        <g:if test="${loanLedgerDetails?.principalDebit != 0}">
                                        <tr>
                                            <td style="font-weight:bold" width="30%">Principal Debit</td>
                                            <td width="70%"><g:formatNumber format="###,###,##0.00" number="${loanLedgerDetails?.principalDebit}" /></td>
                                        </tr>
                                        </g:if>
                                        <g:if test="${loanLedgerDetails?.principalCredit != 0}">
                                        <tr>
                                            <td style="font-weight:bold" width="30%">Principal Credit</td>
                                            <td width="70%"><g:formatNumber format="###,###,##0.00" number="${loanLedgerDetails?.principalCredit}" /></td>
                                        </tr>
                                        </g:if>
                                        <tr>
                                            <td style="font-weight:bold" width="30%">Principal Balance</td>
                                            <td width="70%"><g:formatNumber format="###,###,##0.00" number="${loanLedgerDetails?.principalBalance}" /></td>
                                        </tr>
                                        <g:if test="${loanLedgerDetails?.interestDebit != 0}">
                                        <tr>
                                            <td style="font-weight:bold" width="30%">Interest Debit</td>
                                            <td width="70%"><g:formatNumber format="###,###,##0.00" number="${loanLedgerDetails?.interestDebit}" /></td>
                                        </tr>
                                        </g:if>
                                        <g:if test="${loanLedgerDetails?.interestCredit != 0}">
                                        <tr>
                                            <td style="font-weight:bold" width="30%">Interest Credit</td>
                                            <td width="70%"><g:formatNumber format="###,###,##0.00" number="${loanLedgerDetails?.interestCredit}" /></td>
                                        </tr>
                                        </g:if>
                                         <tr>
                                            <td style="font-weight:bold" width="30%">Interest Balance</td>
                                            <td width="70%"><g:formatNumber format="###,###,##0.00" number="${loanLedgerDetails?.interestBalance}" /></td>
                                        </tr>
                                        <g:if test="${loanLedgerDetails?.penaltyDebit != 0}">
                                         <tr>
                                            <td style="font-weight:bold" width="30%">Penalty Debit</td>
                                            <td width="70%"><g:formatNumber format="###,###,##0.00" number="${loanLedgerDetails?.penaltyDebit}" /></td>
                                        </tr>
                                        </g:if>
                                        <g:if test="${loanLedgerDetails?.penaltyCredit != 0}">
                                         <tr>
                                            <td style="font-weight:bold" width="30%">Penalty Credit</td>
                                            <td width="70%"><g:formatNumber format="###,###,##0.00" number="${loanLedgerDetails?.penaltyCredit}" /></td>
                                        </tr>
                                        </g:if>
                                        <tr>
                                            <td style="font-weight:bold" width="30%">Penalty Balance</td>
                                            <td width="70%"><g:formatNumber format="###,###,##0.00" number="${loanLedgerDetails?.penaltyBalance}" /></td>
                                        </tr>
                                        <g:if test="${loanLedgerDetails?.chargesDebit != 0}">
                                        <tr>
                                            <td style="font-weight:bold" width="30%">Charges Debit</td>
                                            <td width="70%"><g:formatNumber format="###,###,##0.00" number="${loanLedgerDetails?.chargesDebit}" /></td>
                                        </tr>
                                        </g:if>
                                        <g:if test="${loanLedgerDetails?.chargesCredit != 0}">
                                        <tr>
                                            <td style="font-weight:bold" width="30%">Charges Credit</td>
                                            <td width="70%"><g:formatNumber format="###,###,##0.00" number="${loanLedgerDetails?.chargesCredit}" /></td>
                                        </tr>
                                        </g:if>
                                        <tr>
                                            <td style="font-weight:bold" width="30%">Charges Balance</td>
                                            <td width="70%"><g:formatNumber format="###,###,##0.00" number="${loanLedgerDetails?.chargesBalance}" /></td>
                                        </tr>
                                    </tbody>
                                </table>    
				
			</div>
                        <div class="section-container">
                            <legend class="section-header" >General Ledger Entries</legend>
                            <div class="table-responsive">
                                <table class="table table-hover table-condensed table-bordered table-striped">
                                <thead>
                                    <th><label>Debit</label></th>
                                    <th><label>Debit Amount</label></th>
                                    <th><label>Credit</label></th>
                                    <th><label>Credit Amount</label></th>
                                </thead>  
                                <tbody>
                                <g:each in="${TxnBreakdown.findAllByTxnFile(txnLoanPaymentDetailsInstance?.txnFile)}" status="i" var="t">
                                    <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
                                        <td>${t.debitAcct}
                                            <g:if test="${t.debitAcct}">
                                            </br>    
                                            ${GlAccount.findByCodeAndBranchAndCurrencyAndFinancialYear(t.debitAcct,t.branch,Currency.get(1),t.branch.runDate.format("yyyy")).name}
                                            </g:if>
                                            </td>
                                        <td align="right"><g:formatNumber format="###,###,##0.00" number="${t.debitAmt}" /></td>
                                             
                                        <td>${t.creditAcct}
                                            <g:if test="${t.creditAcct}">
                                            </br>    
                                            ${GlAccount.findByCodeAndBranchAndCurrencyAndFinancialYear(t.creditAcct,t.branch,Currency.get(1),t.branch.runDate.format("yyyy")).name}
                                            </g:if>
                                            </td>
                                        <td align="right"><g:formatNumber format="###,###,##0.00" number="${t.creditAmt}" /></td>
                                   </tr>
                                </g:each>
                                </tbody>   
                            </table>     
                        </div>    
                    </div>                    
		</div>
                
                <g:if test="${loanReversalHist}">
                    
                </g:if>  
                <g:else>
                    <h4><legend>Reversal Form Requirement</legend></h4>
                <div>
                    <g:form id="loanReverseForm" url="[controller: 'loan', action:'loanReversePayment']" method="POST" onsubmit="callLoadingDialog();" >
                        <fieldset class="form">

                            <div class="fieldcontain form-group">
                                <label class="control-label col-sm-4" for="intRate">Reference <span class="required-indicator">*</span></label>
                                <div class="col-sm-8">
                                    <g:field class="form-control" type="Text"  id="txtReference"  name="txtReference" value="" />
                                </div>             
                            </div>   
                            <g:hiddenField name="loanPaymentDetailId" id="loanPaymentDetailId" value="${txnLoanPaymentDetailsInstance?.id}" />
                            <div class="fieldcontain form-group">
                                <label class="control-label col-sm-4" for="intRate">Particulars <span class="required-indicator">*</span></label>     
                                <div class="col-sm-8">
                                    <g:textArea name="txtParticulars" id="txtParticulars" value="" rows="5" cols="40" class="form-control"/>
                                </div>             
                            </div>   
                        </fieldset>
                    </g:form>  
                </div>
                
                
                <script>
                    function validateReverse(){
                    
                        var reference = $('#txtReference').val();
                        var particulars = $('#txtParticulars').val();
                        
                        if(reference == "" || reference == null || reference=="null"){
                            notify.message('Reversal Reference is required!|error|alert'); 
                        }else  if(particulars == "" || particulars == null || particulars=="null"){
                            notify.message('Reversal Particulars is required!|error|alert'); 
                        }else{
                            alertify.confirm(AppTitle,"Are you sure you want to Reverse this Loan Payment?",
                                function(){
                                    $('#loanReverseForm').submit();
                                },
                                function(){
                                  alertify.error('Canceled.');
                                }
                            );
                        }
                        
                        
                    }
                </script> 
                </g:else>
                   
             </div>   
        </content>
         <content tag="main-actions">
            <ul>
                <g:if test="${loanReversalHist}">
                    <li><button disabled="true">Payment Already Reversed</button></li>
                </g:if>    
                <g:else>
                
                    <li><button onclick="validateReverse();">Reverse Payment</button></li>
                </g:else>
                
                <li><g:link action="viewLoanPaymentList" controller="loan" id="${txnLoanPaymentDetailsInstance?.acct?.id}">Back to Loan Payment Transaction List</g:link></li>
                <li><g:link action="show" controller="loan" id="${txnLoanPaymentDetailsInstance?.acct?.id}">Back to Loan Inquiry</g:link></li>
                
            </ul>
        </content>
	</body>
</html>
