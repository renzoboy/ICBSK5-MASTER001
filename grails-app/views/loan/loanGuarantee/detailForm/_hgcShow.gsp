<!--
  To change this license header, choose License Headers in Project Properties.
  To change this template file, choose Tools | Templates
  and open the template in the editor.
-->

<%@ page contentType="text/html;charset=UTF-8" %>
<table class="table table-bordered table-striped">
    <tbody>

        <tr>
            <td style="font-weight:bold" width="30%">Value of Enrollment</td>
            <td width="70%"><g:formatNumber format="###,###,##0.00" number="${loanGuaranteeInstance?.hgcValueForEnrollment}" /></td>
        </tr>
        <tr>
            <td style="font-weight:bold" width="30%">Start of Coverage Period</td>
            <td width="70%"><g:formatDate format="MM/dd/yyyy" date="${loanGuaranteeInstance?.hgcCoverageStartPeriod}"/></td>
        </tr>
        <tr>
            <td style="font-weight:bold" width="30%">End of Coverage Period</td>
            <td width="70%"><g:formatDate format="MM/dd/yyyy" date="${loanGuaranteeInstance?.hgcCoverageEndPeriod}"/></td>
        </tr>
        <tr>
            <td style="font-weight:bold" width="30%">Premium Rate</td>
            <td width="70%"><g:formatNumber format="###,###,##0.00" number="${loanGuaranteeInstance?.hgcPremiumRate}" /></td>
        </tr>
        <tr>
            <td style="font-weight:bold" width="30%">Premium Due</td>
            <td width="70%"><g:formatNumber format="###,###,##0.00" number="${loanGuaranteeInstance?.hgcPremiumDue}" /></td>
        </tr>
        <tr>
            <td style="font-weight:bold" width="30%">Transaction Number</td>
            <td width="70%">${loanGuaranteeInstance?.hgcTctNo}</td>
        </tr>
        <tr>
            <td style="font-weight:bold" width="30%">Location</td>
            <td width="70%">${loanGuaranteeInstance?.hgcLocation}</td>
        </tr>
        
        <tr>
            <td style="font-weight:bold" width="30%">Appraised Value</td>
            <td width="70%"><g:formatNumber format="###,###,##0.00" number="${loanGuaranteeInstance?.hgcAppraisedValue}" /></td>
        </tr>
        <tr>
            <td style="font-weight:bold" width="30%">Loan To Value Ratio</td>
            <td width="70%"><g:formatNumber format="###,###,##0.00" number="${loanGuaranteeInstance?.hgcLoanToValueRatio}" /></td>
        </tr>
        
        
        <tr>
            <td style="font-weight:bold" width="30%">Value of New Release For Enrollment</td>
            <td width="70%"><g:formatNumber format="###,###,##0.00" number="${loanGuaranteeInstance?.hgcValueOfNewReleaseForEnrollment}" /></td>
        </tr>
        <tr>
            <td style="font-weight:bold" width="30%">Total Amount Released</td>
            <td width="70%"><g:formatNumber format="###,###,##0.00" number="${loanGuaranteeInstance?.hgcTotalAmountReleased}" /></td>
        </tr>
        <tr>
            <td style="font-weight:bold" width="30%">Loan Released Date</td>
            <td width="70%"><g:formatDate format="MM/dd/yyyy" date="${loanGuaranteeInstance?.hgcloanReleasedDate}"/></td>
        </tr>
        <tr>
            <td style="font-weight:bold" width="30%">COG. No of The First Released</td>
            <td width="70%">${loanGuaranteeInstance?.hgcCogNoOfTheFirstReleased}</td>
        </tr>
        <tr>
            <td style="font-weight:bold" width="30%">Start of Coverage Period</td>
            <td width="70%"><g:formatDate format="MM/dd/yyyy" date="${loanGuaranteeInstance?.hgcAddCoverageStartPeriod}"/></td>
        </tr>
        <tr>
            <td style="font-weight:bold" width="30%">End of Coverage Period</td>
            <td width="70%"><g:formatDate format="MM/dd/yyyy" date="${loanGuaranteeInstance?.hgcAddCoverageEndPeriod}"/></td>
        </tr>
        <tr>
            <td style="font-weight:bold" width="30%">Premium Due</td> 
            <td width="70%"><g:formatNumber format="###,###,##0.00" number="${loanGuaranteeInstance?.hgcAddPremiumDue}" /></td>
        </tr>
    </tbody>
</table>