<%@ page import="icbs.loans.LoanLossProvisionDetail" %>

<table class="table table-bordered table-striped">
    <legend>Performance Classification</legend>
    <tr>
        <td style="font-weight:bold" width="30%">Kind Of Loan</td>
        <td width="70%"><span>${loanInstance?.loanKindOfLoan?.description}</span></td>
    </tr>
    <tr>
        <td style="font-weight:bold" width="30%">Name of Institution</td>
        <td width="70%"><span>${loanInstance?.loanType?.description}</span></td>
    </tr>
    <tr>
        <td style="font-weight:bold" width="30%">Economic Activity</td>
        <td width="70%"><span>${loanInstance?.loanProject?.description}</span></td>
    </tr>
    <tr>
        <td style="font-weight:bold" width="30%">Age in Arears</td>
        <td width="70%"><span>${loanInstance?.ageInArrears}</span></td>
    </tr>
    <tr>
        <td style="font-weight:bold" width="30%">Bsp Provision</td>
        <td width="70%"><span>${loanInstance?.loanProvisionBsp?.description}</span></td>
    </tr>    
    <tr>
        <td style="font-weight:bold" width="30%">Loan Provision</td>
        <td width="70%"><span>${loanInstance?.loanProvision?.description}</span></td>
    </tr>
    <tr>
        <td style="font-weight:bold" width="30%">Loan Status</td>
        <td width="70%"><span>${loanInstance?.loanPerformanceId?.description}</span></td>
    </tr>
    <tr>
        <td style="font-weight:bold" width="30%">Loan Security</td>
        <td width="70%"><span>${loanInstance?.loanSecurity?.description}</span></td>
    </tr> 
</table>    

<table class="table table-bordered table-striped">
    <legend>General Ledger Link</legend>
    <tr>
        <td style="font-weight:bold" width="30%">Loan GL Link Pointer</td>
        <td width="70%"><span><g:link controller="cfgAcctGlTemplate" action="show" id="${loanInstance?.glLink?.id}">${loanInstance?.glLink?.description}</g:link></span></td>
    </tr> 
</table>    

