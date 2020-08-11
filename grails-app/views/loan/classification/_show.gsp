<%@ page import="icbs.loans.LoanLossProvisionDetail" %>

<table class="table table-bordered table-striped">
    <legend>Performance Classification</legend>
    <g:if test="${loanInstance?.product?.productType?.id == 7}" >
        
    <tr>
        <td style="font-weight:bold" width="30%">Age in Arears</td>
        <td width="70%"><span>${loanInstance?.ageInArrears}</span></td>
    </tr>

    <tr>
        <td style="font-weight:bold" width="30%">Account Status</td>
        <td width="70%"><span>${loanInstance?.loanPerformanceId?.description}</span></td>
    </tr>
    <tr>
        <td style="font-weight:bold" width="30%">Account Security</td>
        <td width="70%"><span>${loanInstance?.loanSecurity?.description}</span></td>
    </tr> 
    </g:if>
    <g:else>
        
    <tr>
        <td style="font-weight:bold" width="30%">Kind Of Account</td>
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
        <td style="font-weight:bold" width="30%">Account Provision</td>
        <td width="70%"><span>${loanInstance?.loanProvision?.description}</span></td>
    </tr>
    <tr>
        <td style="font-weight:bold" width="30%">Account Status</td>
        <td width="70%"><span>${loanInstance?.loanPerformanceId?.description}</span></td>
    </tr>
    <tr>
        <td style="font-weight:bold" width="30%">Account Security</td>
        <td width="70%"><span>${loanInstance?.loanSecurity?.description}</span></td>
    </tr> 
    </g:else>
</table>    

<%--<div class="fieldcontain form-group">
    <label class="control-label col-sm-4">
        <g:message code="loan.performanceClassificationScheme.label" default="Performance Classification Scheme 1" />
    </label>
    <span><g:link controller="loanPerformanceClassification" action="show" id="${loanInstance?.performanceClassificationScheme1?.id}">${loanInstance?.performanceClassificationScheme1?.name}</g:link></span>
</div>

<div class="fieldcontain form-group">
    <label class="control-label col-sm-4">
        <g:message code="loan.performanceClassificationScheme.label" default="Performance Classification Scheme 2" />
    </label>
    <span><g:link controller="loanPerformanceClassification" action="show" id="${loanInstance?.performanceClassificationScheme2?.id}">${loanInstance?.performanceClassificationScheme2?.name}</g:link></span>
</div>

<div class="fieldcontain form-group">
    <label class="control-label col-sm-4">
        <g:message code="loan.performanceClassificationScheme.label" default="Performance Classification Scheme 3" />
    </label>
    <span><g:link controller="loanPerformanceClassification" action="show" id="${loanInstance?.performanceClassificationScheme3?.id}">${loanInstance?.performanceClassificationScheme3?.name}</g:link></span>
</div>

<div class="fieldcontain form-group">
    <label class="control-label col-sm-4">
        <g:message code="loan.performanceClassificationScheme.label" default="Performance Classification Scheme 4" />
    </label>
    <span><g:link controller="loanPerformanceClassification" action="show" id="${loanInstance?.performanceClassificationScheme4?.id}">${loanInstance?.performanceClassificationScheme4?.name}</g:link></span>
</div>--%>

<table class="table table-bordered table-striped">
    <legend>General Ledger Link</legend>
    <g:if test="${loanInstance?.product?.productType?.id == 7}" >
    <tr>
        <td style="font-weight:bold" width="30%">Account GL Link Pointer</td>
        <td width="70%"><span><g:link controller="cfgAcctGlTemplate" action="show" id="${loanInstance?.glLink?.id}">${loanInstance?.glLink?.description}</g:link></span></td>
    </tr> 
    </g:if>
    <g:else>
    <tr>
        <td style="font-weight:bold" width="30%">Account GL Link Pointer</td>
        <td width="70%"><span><g:link controller="cfgAcctGlTemplate" action="show" id="${loanInstance?.glLink?.id}">${loanInstance?.glLink?.description}</g:link></span></td>
    </tr>
    </g:else>    
</table>    

<table class="table table-bordered table-striped">
    <g:if test="${loanInstance?.product?.productType?.id == 7}" >
        <legend>Account Discount and Provision Information</legend>
        <g:if test="${LoanLossProvisionDetail.findByLoan(loanInstance)}">
            <tr>
                <td style="font-weight:bold" width="30%">Account Loss Provision</td>
                <td width="70%"><span><g:formatNumber format="###,##0.00" number="${LoanLossProvisionDetail.findByLoan(loanInstance).totalProvision}" /></span></td>
            </tr>   
            <tr>
                <td style="font-weight:bold" width="30%">Account Remarks</td>
                <td width="70%"><span>${LoanLossProvisionDetail.findByLoan(loanInstance).remarks}</span></td>
            </tr> 
        </g:if>
        
    </g:if> 
    <g:else>
        <legend>Account Discount and Provision Information</legend>
        <g:if test="${LoanLossProvisionDetail.findByLoan(loanInstance)}">
            <tr>
                <td style="font-weight:bold" width="30%">Account Discount Interest</td>
                <td width="70%"><span><g:formatNumber format="###,##0.00" number="${LoanLossProvisionDetail.findByLoan(loanInstance).uidBalance}" /></span></td>
            </tr> 
            <tr>
                <td style="font-weight:bold" width="30%">Account Discount Service Charge</td>
                <td width="70%"><span><g:formatNumber format="###,##0.00" number="${LoanLossProvisionDetail.findByLoan(loanInstance).loanServiceCharge}" /></span></td>
            </tr>
            <tr>
                <td style="font-weight:bold" width="30%">Account Deferred Credits</td>
                <td width="70%"><span><g:formatNumber format="###,##0.00" number="${LoanLossProvisionDetail.findByLoan(loanInstance).otherDeferredCredit}" /></span></td>
            </tr>
            <tr>
                <td style="font-weight:bold" width="30%">Account Loss Provision</td>
                <td width="70%"><span><g:formatNumber format="###,##0.00" number="${LoanLossProvisionDetail.findByLoan(loanInstance).totalProvision}" /></span></td>
            </tr>   
            <tr>
                <td style="font-weight:bold" width="30%">Remarks</td>
                <td width="70%"><span>${LoanLossProvisionDetail.findByLoan(loanInstance).remarks}</span></td>
            </tr> 
        </g:if>
    </g:else>      
</table> 
