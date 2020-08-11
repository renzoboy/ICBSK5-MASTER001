<!--
  To change this license header, choose License Headers in Project Properties.
  To change this template file, choose Tools | Templates
  and open the template in the editor.
-->

<%@ page contentType="text/html;charset=UTF-8" %>
<table class="table table-bordered table-striped">
    <tbody>

        <tr>
            <td style="font-weight:bold" width="30%">Main Office Address</td>
            <td width="70%">${loanGuaranteeInstance?.sbgfcMainOfficeAddress}</td>
        </tr>
        <tr>
            <td style="font-weight:bold" width="30%">Position</td>
            <td width="70%"> ${loanGuaranteeInstance?.sbgfcPosition}</td>
        </tr>
        <tr>
            <td style="font-weight:bold" width="30%">Net Worth</td>
            <td width="70%"><g:formatNumber format="###,###,##0.00" number="${loanGuaranteeInstance?.sbgfcNetWorth}" /></td>
        </tr>
        <tr>
            <td style="font-weight:bold" width="30%">Nature of Business</td>
            <td width="70%">${loanGuaranteeInstance?.sbgfcNatureOfBusiness}</td>
        </tr>
        <tr>
            <td style="font-weight:bold" width="30%">Business Type</td>
            <td width="70%">${loanGuaranteeInstance?.sbgfcBusinessType}</td>
        </tr>
        <tr>
            <td style="font-weight:bold" width="30%">Start of business Ops</td>
            <td width="70%">${loanGuaranteeInstance?.sbgfcStartOfBusinessOperation}</td>
        </tr>
        <tr>
            <td style="font-weight:bold" width="30%">Asset Size</td>
            <td width="70%">${loanGuaranteeInstance?.sbgfcAssetSize}</td>
        </tr>
        <tr>
            <td style="font-weight:bold" width="30%">Number of Employees</td>
            <td width="70%">${loanGuaranteeInstance?.sbgfcNumberOfEmployees}</td>
        </tr>
        <tr>
            <td style="font-weight:bold" width="30%">Type of Loan</td>
            <td width="70%">${loanGuaranteeInstance?.sbgfcTypeOfLoan}</td>
        </tr>
        <tr>
            <td style="font-weight:bold" width="30%">Purpose of Loan</td>
            <td width="70%">${loanGuaranteeInstance?.sbgfcPurposeOfLoan}</td>
        </tr>
        <tr>
            <td style="font-weight:bold" width="30%">Outstanding Balance</td>
            <td width="70%"><g:formatNumber format="###,###,##0.00" number="${loanGuaranteeInstance?.sbgfcOutstandingBalance}" /></td>
        </tr>
        <tr>
            <td style="font-weight:bold" width="30%">Debt Serv. Capacity</td>
            <td width="70%"><g:formatNumber format="###,###,##0.00" number="${loanGuaranteeInstance?.sbgfcDsc}" /></td>
        </tr>
        <tr>
            <td style="font-weight:bold" width="30%">Initial BRR Total Points</td>
            <g:if test="${loanGuaranteeInstance?.sbgfcInitialBrrTotalPoints == null || loanGuaranteeInstance?.sbgfcInitialBrrTotalPoints == "" || loanGuaranteeInstance?.sbgfcInitialBrrTotalPoints == 0.00}">
                <td width="70%">N/A</td>
            </g:if>
            <g:else>
                    <td width="70%">${loanGuaranteeInstance?.sbgfcInitialBrrTotalPoints}</td>
            </g:else>
        </tr>
        <tr>
            <td style="font-weight:bold" width="30%">Initial BRR Grade</td>
            <g:if test="${loanGuaranteeInstance?.sbgfcInitialBrrGrade == null || loanGuaranteeInstance?.sbgfcInitialBrrGrade == "" || loanGuaranteeInstance?.sbgfcInitialBrrGrade == 0.00}">
                <td width="70%">N/A</td>
            </g:if>
            <g:else>
                 <td width="70%">${loanGuaranteeInstance?.sbgfcInitialBrrGrade}</td>
            </g:else>
        </tr>
        <tr>
            <td style="font-weight:bold" width="30%">BRR Total Points</td>


            <td width="70%">${loanGuaranteeInstance?.sbgfcBrrTotalPoints}</td>

        </tr>
        <tr>
            <td style="font-weight:bold" width="30%">BRR Grade</td>

            <td width="70%">${loanGuaranteeInstance?.sbgfcBrrGrade}</td>
        </tr>
        <tr>
            <td style="font-weight:bold" width="30%">Type of Collateral</td>
            <td width="70%">${loanGuaranteeInstance?.sbgfcTypeOfCollateral}</td>
        </tr>
        <tr>
            <td style="font-weight:bold" width="30%">Market Value</td>
            <td width="70%">${loanGuaranteeInstance?.sbgfcMarketValue}</td>
        </tr>
        <tr>
            <td style="font-weight:bold" width="30%">Loan value</td>
            <td width="70%">${loanGuaranteeInstance?.sbgfcLoanValue}</td>
        </tr>
        <tr>
            <td style="font-weight:bold" width="30%">Business Name</td>
            <td width="70%">${loanGuaranteeInstance?.sbgfcBusinessName}</td>
        </tr>
    </tbody>
</table>