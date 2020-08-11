<%@ page import="icbs.loans.RopaAllowanceLedger" %>
<legend>Transactions</legend>

<div class="table-responsive">
    <table class="table table-hover table-condensed table-bordered table-striped">
        <tbody>
            <tr>
		<td><label>ID</label></td>
		<td><label>Txn Date</label></td>
                <td><label>Particulars</label></td>
                <td><label>Debit Amount (Land)</label></td>
                <td><label>Credit Amount (Land)</label></td>
                <td><label>Debit Amount (Building)</label></td>
                <td><label>Credit Amount (Building)</label></td>        
                <td><label>Debit Amount (Other Properties)</label></td>
                <td><label>Credit Amount (Other Properties)</label></td>
            </tr>
	</tbody>
        <tbody>
            <g:each in="${RopaAllowanceLedger.findAllByRopa(collRopaInstance).sort{it.id}}" var="ropaLedgerInstance">
		<tr>
                    <td>${ropaLedgerInstance?.id}</td>
                    <td><g:formatDate format="MM/dd/yyyy" date="${ropaLedgerInstance?.recordDate}"/></td>
                    <td>${ropaLedgerInstance?.particulars}</td>
                    <g:if test="${ropaLedgerInstance?.landDebit == 0}">
                        <td></td>
                    </g:if> 
                    <g:else>    
                        <td align = "right"><g:formatNumber format="###,###,##0.00" number="${ropaLedgerInstance?.landDebit}"/></td>
                    </g:else>
                    <g:if test="${ropaLedgerInstance?.landCredit == 0}">
                        <td></td>
                    </g:if> 
                    <g:else>   
                        <td align = "right"><g:formatNumber format="###,###,##0.00" number="${ropaLedgerInstance?.landCredit}"/></td>
                    </g:else>  	
                    <g:if test="${ropaLedgerInstance?.bldgDebit == 0}">
                        <td></td>
                    </g:if> 
                    <g:else>    
                        <td align = "right"><g:formatNumber format="###,###,##0.00" number="${ropaLedgerInstance?.bldgDebit}"/></td>
                    </g:else>
                    <g:if test="${ropaLedgerInstance?.bldgCredit == 0}">
                        <td></td>
                    </g:if> 
                    <g:else>   
                        <td align = "right"><g:formatNumber format="###,###,##0.00" number="${ropaLedgerInstance?.bldgCredit}"/></td>
                    </g:else>  	
                    <g:if test="${ropaLedgerInstance?.otherDebitAmt == 0}">
                        <td></td>
                    </g:if> 
                    <g:else>    
                        <td align = "right"><g:formatNumber format="###,###,##0.00" number="${ropaLedgerInstance?.otherDebitAmt}"/></td>
                    </g:else>
                    <g:if test="${ropaLedgerInstance?.otherCreditAmt == 0}">
                        <td></td>
                    </g:if> 
                    <g:else>   
                        <td align = "right"><g:formatNumber format="###,###,##0.00" number="${ropaLedgerInstance?.otherCreditAmt}"/></td>
                    </g:else>  	                    
		</tr>
            </g:each>
	</tbody>
    </table>
</div>