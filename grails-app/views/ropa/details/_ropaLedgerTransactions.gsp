<%@ page import="icbs.loans.ROPALedger" %>
<%@ page import="icbs.loans.RopaTransfer" %>
<%@ page import="icbs.loans.RopaSaleDetails" %>
<legend>Transactions</legend>

<div class="table-responsive">
    <table class="table table-hover table-condensed table-bordered table-striped">
        <tbody>
			<tr>
				<td><label>ID</label></td>
				<td><label>Txn Date</label></td>
				<td><label>Reference</label></td>
                                <td><label>Particulars</label></td>
                                <td><label>Debit Amount</label></td>
                                <td><label>Credit Amount</label></td>
                                <td><label>Action</label></td>
			</tr>
		</tbody>
		<tbody>
		<g:each in="${ROPALedger.findAllByRopa(collRopaInstance).sort{it.id}}" var="ropaLedgerInstance">
			<tr>
				<td>${ropaLedgerInstance?.id}</td>
                                <td><g:formatDate format="MM/dd/yyyy" date="${ropaLedgerInstance?.txnDate}"/></td>
				<td>${ropaLedgerInstance?.reference}</td>
				<td>${ropaLedgerInstance?.particulars}</td>
				<g:if test="${ropaLedgerInstance?.debitAmt == 0}">
                                <td></td>
                                </g:if> 
                                <g:else>    
                                <td align = "right"><g:formatNumber format="###,###,##0.00" number="${ropaLedgerInstance?.debitAmt}"/></td>
                                </g:else>
                                <g:if test="${ropaLedgerInstance?.creditAmt == 0}">
                                    <td></td>
                                </g:if> 
                                <g:else>   
                                <td align = "right"><g:formatNumber format="###,###,##0.00" number="${ropaLedgerInstance?.creditAmt}"/></td>
                                </g:else>  			
				<td><g:link class="btn btn-secondary" controller="ropa" action="showRopaLedgerTrans" id="${ropaLedgerInstance?.id}">View</g:link></td>
			</tr>
		</g:each>
		</tbody>
	</table>
</div>
<legend>Transfer Details</legend>

<div class="table-responsive">
    <table class="table table-hover table-condensed table-bordered table-striped">
        <tbody>
            <tr>
                <td><label>Ref Date</label></td>
                <td><label>Txn ID</label></td>
                <td><label>Reference</label></td>
                <td><label>Particulars</label></td>
                <td><label>Transfer Amount</label></td>
                <td><label>Txn Status</label></td>
                <td>Actions</td>
            </tr>
        </tbody>
        <tbody>
            <g:each in="${RopaTransfer.findAllByRopaCollateralDetails(collateralInstance)}" status="i" var="ropaTransferInstance">
                <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
                    <td><g:formatDate format="MM/dd/yyyy" date="${ropaTransferInstance?.txnFile?.txnDate}"/></td>
                    <td>${ropaTransferInstance?.txnFile?.id}</td>
                    <td>${ropaTransferInstance?.txnFile?.txnRef}</td>
                    <td>${ropaTransferInstance?.txnFile?.txnParticulars}</td>
                    <td align = "right"><g:formatNumber format="###,###,##0.00" number="${ropaTransferInstance?.transferAmount}"/></td>
                    <td>${ropaTransferInstance?.txnFile?.status?.description}</td>
                    <td><g:link class="btn btn-secondary" action="ropaTransferDetails" id="${ropaTransferInstance?.id}">View Details</g:link></td>
                </tr>
            </g:each>
        </tbody>
    </table>
</div>
<legend>ROPA Sale Details</legend>

<div class="table-responsive">
    <table class="table table-hover table-condensed table-bordered table-striped">
        <tbody>
            <tr>
                <td><label>Ref Date</label></td>
                <td><label>Txn ID</label></td>
                <td><label>Reference</label></td>
                <td><label>Particulars</label></td>
                <td><label>Sale Amount</label></td>
                <td><label>Txn Status</label></td>
                <td>Actions</td>
            </tr>
        </tbody>
        <tbody>
            <g:each in="${RopaSaleDetails.findAllByRopaCollateralDetails(collateralInstance)}" status="i" var="ropaSaleInstance">
                <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
                    <td><g:formatDate format="MM/dd/yyyy" date="${ropaSaleInstance?.txnFile?.txnDate}"/></td>
                    <td>${ropaSaleInstance?.txnFile?.id}</td>
                    <td>${ropaSaleInstance?.txnFile?.txnRef}</td>
                    <td>${ropaSaleInstance?.txnFile?.txnParticulars}</td>
                    <td align = "right"><g:formatNumber format="###,###,##0.00" number="${ropaSaleInstance?.saleAmount}"/></td>
                    <td>${ropaSaleInstance?.txnFile?.status?.description}</td>
                    <td><g:link class="btn btn-secondary" action="ropaSaleDetails" id="${ropaSaleInstance?.id}">View Details</g:link></td>
                </tr>
            </g:each>
        </tbody>
    </table>
</div>
  