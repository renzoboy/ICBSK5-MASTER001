<%@ page import="icbs.loans.LoanLedger" %>
<%@ page import="icbs.loans.LoanWriteOffCollectionHist" %>
<legend>Transactions</legend>

<div class="table-responsive">
    <table class="table table-hover table-condensed table-bordered table-striped">
        <tbody>
			<tr>
				<td><label>ID</label></td>
				<td><label>Date</label></td>				
                                <td><label>Type</label></td>
				<td><label>Code</label></td>
				<td><label>Reference</label></td>
                                <td><label>Particulars</label></td>
                                <td><label>Action</label></td>
			</tr>
		</tbody>
		<tbody>
		<g:each in="${LoanLedger.findAllByLoan(loanInstance).sort{it.id}}" var="loanLedgerInstance">
			<tr>
				<td>${loanLedgerInstance?.id}</td>
                                <td><g:formatDate format="MM/dd/yyyy" date="${loanLedgerInstance?.txnDate}"/></td>
				<td>${loanLedgerInstance?.txnType?.description}</td>
				<td>${loanLedgerInstance?.txnTemplate?.description}</td>
				<td>${loanLedgerInstance?.txnRef}</td>
                                <td>${loanLedgerInstance?.txnParticulars}</td>				
				<td><g:link class="btn btn-secondary" controller="loanAdjustment" action="show" id="${loanLedgerInstance?.id}">View</g:link></td>
			</tr>
		</g:each>
		</tbody>
	</table>
</div>
<%-- WRITE OFF COLLECTION --%>
<legend>Write-Off Collections</legend>

<div class="table-responsive">
    <table class="table table-hover table-condensed table-bordered table-striped">
        <tbody>
			<tr>
				<td><label>Date</label></td>	
				<td><label>Txn Description</label></td>
                                <td><label>Processed By</label></td>
                                <td><label>Collector</label></td>
                                <td><label>Txn Amount</label></td>
			</tr>
		</tbody>
		<tbody>
		<g:each in="${LoanWriteOffCollectionHist.findAllByLoan(loanInstance).sort{it.id}}" var="writeOffInstancehist">
			<tr>
                                <td><g:formatDate format="MM/dd/yyyy" date="${writeOffInstancehist?.txnDate}"/></td>
				<td>${writeOffInstancehist?.txnDescription}</td>
                                <td>${writeOffInstancehist?.transactBy?.name1 +' '+writeOffInstancehist?.transactBy?.name2 +' '+writeOffInstancehist?.transactBy?.name3}</td>
                                <td>${writeOffInstancehist?.collectedBy?.name1 +' '+writeOffInstancehist?.collectedBy?.name2 +' '+writeOffInstancehist?.collectedBy?.name3}</td>
				<td><g:formatNumber format="###,##0.00" number="${writeOffInstancehist?.txnAmount}" /></td>
			</tr>
		</g:each>
		</tbody>
	</table>
</div>