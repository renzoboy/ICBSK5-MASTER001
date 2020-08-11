

<%@ page import="icbs.loans.LoanLedger" %>
<%@ page import="icbs.tellering.TxnBreakdown" %>
<%@ page import="icbs.gl.GlAccount" %>
<%@ page import="icbs.admin.Currency" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'loanLedger.label', default: 'LoanLedger')}" />
		<title>View ROPA Ledger Transaction Details</title>
              
	</head>
	<body>
        <content tag="breadcrumbs">
            <span class="fa fa-chevron-right"></span><span class="current">View ROPA Ledger Transaction Details</span>
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
                <div class="table-responsive">
                    <table class="table table-hover table-condensed table-bordered table-striped">
                    <thead>
                        <th><label>Debit</label></th>
                        <th><label>Debit Amount</label></th>
                        <th><label>Credit</label></th>
                        <th><label>Credit Amount</label></th>
                    </thead>  
                    <tbody>
                    <g:each in="${TxnBreakdown.findAllByTxnFile(ropaLedgerInstance?.txnFile)}" status="i" var="t">
                        <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
                            <td>${t.debitAcct}
                                <g:if test="${t.debitAcct}">
                                </br>    
                                <b>${GlAccount.findByCodeAndBranchAndCurrencyAndFinancialYear(t.debitAcct,t.branch,Currency.get(1),t.branch.runDate.format("yyyy")).name}</b>
                                </g:if>
                                </td>
                            <td align="right"><g:formatNumber format="###,###,##0.00" number="${t.debitAmt}" /></td>

                            <td>${t.creditAcct}
                                <g:if test="${t.creditAcct}">
                                </br>    
                                <b>${GlAccount.findByCodeAndBranchAndCurrencyAndFinancialYear(t.creditAcct,t.branch,Currency.get(1),t.branch.runDate.format("yyyy")).name}</b>
                                </g:if>
                                </td>
                            <td align="right"><g:formatNumber format="###,###,##0.00" number="${t.creditAmt}" /></td>
                       </tr>
                    </g:each>
                    </tbody>   
                </table>     
                </div>
            </div>
        </content>
         <content tag="main-actions">
            <ul>
                <li><g:link action="index">List of Ropa</g:link></li>
            </ul>
        </content>
	</body>
</html>
