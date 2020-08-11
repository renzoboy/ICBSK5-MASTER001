<%@ page import="icbs.loans.LoanLedger" %>
<%@ page import="icbs.tellering.TxnBreakdown" %>
<%@ page import="icbs.gl.GlAccount" %>
<%@ page import="icbs.admin.Currency" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'loanLedger.label', default: 'LoanLedger')}" />
		<title>View Write-Off Transaction Details</title>
              
	</head>
	<body>
        <content tag="breadcrumbs">
            <span class="fa fa-chevron-right"></span><span class="current">View Write-Off Transaction Details</span>
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
                <g:textField name="loanid" id="loanid" value="${collectionInstance?.loan?.id}"style="display:none"  />
                <div class="col-md-12">  
                    <div class="section-container">
                        <legend class="section-header" >Loan Ledger Details</legend>
                       
                         <table class="table table-bordered table-striped">
                            <tbody>
                               
                                <tr>
                                    <td style="font-weight:bold" width="30%">Loan Account</td>
                                    <td width="70%"><g:link action="show" controller="loan" id="${collectionInstance?.loan?.id}">${collectionInstance?.loan?.accountNo}</g:link></td>
                                </tr>
                                <tr>
                                    <td style="font-weight:bold" width="30%">Borrower Name</td>
                                    <td width="70%"><g:link controller="customer" action="customerInquiry" id="${collectionInstance?.loan?.customer?.id}">${collectionInstance?.loan?.customer?.displayName}</g:link></td>
                                </tr>
                                
                                <tr>
                                    <td style="font-weight:bold" width="30%">Transaction ID</td>
                                    <td width="70%">${collectionInstance?.txnFile?.id}</td>
                                </tr>
                                <tr>
                                    <td style="font-weight:bold" width="30%">Transaction Type</td>
                                    <td width="70%">${collectionInstance?.txnFile?.txnType?.description}</td>
                                </tr>
                                <tr>
                                    <td style="font-weight:bold" width="30%">Transaction Code</td>
                                    <td width="70%">${collectionInstance?.txnFile?.txnTemplate?.code}</td>
                                </tr>
                                <tr>
                                    <td style="font-weight:bold" width="30%">Transaction Reference</td>
                                    <td width="70%">${collectionInstance?.txnFile?.txnRef}</td>
                                </tr>
                                <tr>
                                    <td style="font-weight:bold" width="30%">Transaction Particulars</td>
                                    <td width="70%">${collectionInstance?.txnFile?.txnParticulars}</td>
                                </tr>
                                <tr>
                                    <td style="font-weight:bold" width="30%">Transaction Date</td>
                                    <td width="70%"><g:formatDate date="${collectionInstance?.txnDate}" type="date" style="FULL"/></td>
                                </tr>
                                
                                <tr>
                                    <td style="font-weight:bold" width="30%">Transaction Amount</td>
                                    <td width="70%"><g:formatNumber format="###,###,##0.00" number="${collectionInstance?.txnAmount}" /></td>
                                </tr>
                                <tr>
                                    <td style="font-weight:bold" width="30%">Collected By</td>
                                    <td width="70%">${collectionInstance?.collectedBy?.name1} ${collectionInstance?.collectedBy?.name2} ${collectionInstance?.collectedBy?.name3}</td>
                                </tr>
                                <tr>
                                    <td style="font-weight:bold" width="30%">Transact By</td>
                                    <td width="70%">${collectionInstance?.transactBy?.name1} ${collectionInstance?.transactBy?.name2} ${collectionInstance?.transactBy?.name3}</td>
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
                                <g:each in="${TxnBreakdown.findAllByTxnFile(collectionInstance?.txnFile)}" status="i" var="t">
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
        </content>
         <content tag="main-actions">
            <ul>
                <li><g:link action="loanWriteOffCollectionList" controller="loan" id="${collectionInstance?.loan.id}">Back to Loan Write-Off Collection List</g:link></li>
                <li><g:link action="show" controller="loan" id="${collectionInstance?.loan.id}">Back to Loan Inquiry</g:link></li>
            </ul>
        </content>
	</body>
</html>
