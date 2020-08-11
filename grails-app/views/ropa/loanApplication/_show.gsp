<%@ page import="icbs.cif.CustomerInfobase" %>
<%@ page import="icbs.lov.ConfigItemStatus" %>
<div class="fieldcontain form-group" style="display:none">
	<span id="customer-id">${loanApplicationInstance?.customer?.id}</span>
	<span id="product-id">${loanApplicationInstance?.product?.id}</span>
	<span id="loan-amount">${loanApplicationInstance?.amount}</span>
	<span id="loan-term">${loanApplicationInstance?.term}</span>
	<span id="loan-application-date"><g:formatDate format="MM/dd/yyyy" date="${loanApplicationInstance?.applicationDate}"/></span>
        <span id="loan-application-status">${loanApplicationInstance?.approvalStatus?.description}</span> 
</div>
<table class="table table-bordered table-striped">
    <tr>
        <td style="font-weight:bold" width="30%">Loan Application</td>
        <td width="70%"><span>${loanApplicationInstance?.id}</span></td>
    </tr>
    <tr>
        <td style="font-weight:bold" width="30%">Customer Name</td>
        <td width="70%"><span>${loanApplicationInstance?.customer?.displayName}</span></td>
    </tr>
    <tr>
        <td style="font-weight:bold" width="30%">Product</td>
        <td width="70%"><span>${loanApplicationInstance?.product?.name}</span></td>
    </tr> 
    <tr>
        <td style="font-weight:bold" width="30%">Amount</td>
        <td width="70%"><span><g:formatNumber format="###,###,##0.00" number="${loanApplicationInstance.amount}"/></span></td>
    </tr>   
    <tr>
        <td style="font-weight:bold" width="30%">Application Date</td>
        <td width="70%"><span><g:formatDate format="MM/dd/yyyy" date="${loanApplicationInstance?.applicationDate}"/></span></td>
    </tr>    
</table>    
