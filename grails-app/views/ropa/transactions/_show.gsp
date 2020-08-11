<%@ page import="icbs.loans.LoanLedger" %>
<%@ page import="icbs.loans.ROPA" %>
<%@ page import="icbs.loans.RopaSaleDetails" %>
<%@ page import="icbs.loans.RopaTransfer" %>
<legend>ROPA Transfer Transactions</legend>

<div class="table-responsive">
    <table class="table table-hover table-condensed table-bordered table-striped">
        <tbody>
			<tr>
				<td><label>ID</label></td>
                                <td><label>Account No</label></td>
                                <td><label>Account Name</label></td>
				<td><label>Txn Date</label></td>				
                                <td><label>Txn Type</label></td>
				<td><label>Txn Code</label></td>
				<td><label>Reference</label></td>
                                <td><label>Particulars</label></td>
                                <td><label>Action</label></td>
			</tr>
		</tbody>
		<tbody>
		<g:each in="${RopaTransfer.findAllByRopa(ropapapapaInstance).sort{it.id}}" var="ropaTransferInstance">
                    <g:each in="${LoanLedger.findAllByLoan(ropaTransferInstance?.loan).sort{it.id}}" var="loanLedgerInstance"> 
                        <g:if test="${loanLedgerInstance?.txnFile?.txnType?.id == 38}">
                            <tr>
                                    <td>${loanLedgerInstance?.id}</td>
                                    <td>${loanLedgerInstance?.txnFile?.loanAcct?.accountNo}</td>
                                    <td>${loanLedgerInstance?.txnFile?.loanAcct?.customer?.displayName}</td>
                                    <td><g:formatDate format="MM/dd/yyyy" date="${loanLedgerInstance?.txnDate}"/></td>
                                    <td>${loanLedgerInstance?.txnFile?.txnType?.description}</td>
                                    <td>${loanLedgerInstance?.txnFile?.txnCode}</td>
                                    <td>${loanLedgerInstance?.txnRef}</td>
                                    <td>${loanLedgerInstance?.txnParticulars}</td>				
                                    <td><g:link class="btn btn-secondary" controller="loanAdjustment" action="show" id="${loanLedgerInstance?.id}">View</g:link></td>
                            </tr>
                        </g:if>    
                    </g:each> 
                </g:each>         
		</tbody>
	</table>
</div>
<br>
<legend>ROPA Sale Transactions</legend>

<div class="table-responsive">
    <table class="table table-hover table-condensed table-bordered table-striped">
        <tbody>
			<tr>
				<td><label>ID</label></td>
				<td><label>Txn Date</label></td>				
                                <td><label>Txn Type</label></td>
				<td><label>Txn Code</label></td>
				<td><label>Reference</label></td>
                                <td><label>Particulars</label></td>
                                <td><label>Action</label></td>
			</tr>
		</tbody>
		<tbody>
		<g:each in="${RopaSaleDetails.findAllByRopa(ropapapapaInstance).sort{it.id}}" var="ropaSaleInstance">
                    <g:if test="${ropaSaleInstance?.txnFile?.txnType?.id == 66}">
			<tr>
				<td>${ropaSaleInstance?.id}</td>
                                <td><g:formatDate format="MM/dd/yyyy" date="${ropaSaleInstance?.txnFile?.txnDate}"/></td>
				<td>${ropaSaleInstance?.txnFile?.txnType?.description}</td>
                                <td>${ropaSaleInstance?.txnFile?.txnCode}</td>
				<td>${ropaSaleInstance?.txnFile?.txnRef}</td>
                                <td>${ropaSaleInstance?.txnFile?.txnParticulars}</td>				
				<td><g:link class="btn btn-secondary" controller="tellering" action="showGlEntries" id="${ropaSaleInstance?.txnFile?.id}">View</g:link></td>
			</tr>
                    </g:if>    
		</g:each> 
		</tbody>
	</table>
</div>