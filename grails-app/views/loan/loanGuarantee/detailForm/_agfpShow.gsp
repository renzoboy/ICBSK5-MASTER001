<!--
  To change this license header, choose License Headers in Project Properties.
  To change this template file, choose Tools | Templates
  and open the template in the editor.
-->

<%@ page contentType="text/html;charset=UTF-8" %>
<table class="table table-bordered table-striped">
    <tbody>

        <tr>
            <td style="font-weight:bold" width="30%">Commodity</td>
            <td width="70%">${loanGuaranteeInstance?.agfpCommodity}</td>
        </tr>
        <tr>
            <td style="font-weight:bold" width="30%">Hectar Age/No. of Heads</td>
            <td width="70%"><g:formatNumber format="###,###,##0.00" number="${loanGuaranteeInstance?.agfpHectaresOrHeads}" /></td>
        </tr>
        <tr>
            <td style="font-weight:bold" width="30%">Guarantee Fee rate</td>
            <td width="70%"><g:formatNumber format="###,###,##0.00" number="${loanGuaranteeInstance?.agfpGuaranteeRate}" /></td>
        </tr>
        <tr>
            <td style="font-weight:bold" width="30%">Guarantee Fee</td>
            <td width="70%"><g:formatNumber format="###,###,##0.00" number="${loanGuaranteeInstance?.agfpGuaranteeFee}" /></td>
        </tr>

        <tr>
            <td style="font-weight:bold" width="30%">Referred</td>
            <td width="70%">${loanGuaranteeInstance?.agfpReferred}</td>
        </tr>
        <tr>
            <td style="font-weight:bold" width="30%">Remarks</td>
            <td width="70%">${loanGuaranteeInstance?.agfpRemarks}</td>
        </tr>
    </tbody>
</table>