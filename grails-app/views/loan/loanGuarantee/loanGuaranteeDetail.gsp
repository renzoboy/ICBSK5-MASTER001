<!--
  To change this license header, choose License Headers in Project Properties.
  To change this template file, choose Tools | Templates
  and open the template in the editor.
-->
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="layout" content="main"> 
        <title>Loan Guarantee and Rediscounting Details</title>
    </head>
    <body>
        <content tag="main-content">
             <table class="table table-bordered table-striped">
                <legend>Loan Specification</legend>
                <tr>
                    <td style="font-weight:bold" width="30%">PN No.</td>
                    <td width="70%"><span>${loanInstance?.pnNo}</span></td>
                </tr>
                <tr>
                    <td style="font-weight:bold" width="30%">Loan Account Number</td>
                    <td width="70%"><span>${loanInstance?.accountNo}</span></td>
                </tr>     
                <tr>
                    <td style="font-weight:bold" width="30%">Borrower Name</td>
                    <td width="70%"><span>${loanInstance?.customer?.displayName}</span></td>
                </tr>
                <tr>
                    <td style="font-weight:bold" width="30%">Date Opened</td>
                    <td width="70%"><span><g:formatDate format="MM/dd/yyyy" date="${loanInstance?.openingDate}"/></span></td>
                </tr>     
                <tr>
                    <td style="font-weight:bold" width="30%">Loan Granted Amount</td>
                    <td width="70%"><span><g:formatNumber format="###,###,##0.00" number="${loanInstance?.grantedAmount}"/></span></td>
                </tr>
                <tr>
                    <td style="font-weight:bold" width="30%">LOan Balance</td>
                    <td width="70%"><span><g:formatNumber format="###,###,##0.00" number="${loanInstance?.balanceAmount}"/></span></td>
                </tr>                
            </table>
            <g:if test = "${loanGuaranteeInstance}">
              <legend>Loan Guarantee Details</legend>
               <table class="table table-bordered table-striped">
                    <tr>
                        <td style="font-weight:bold" width="30%">Guarantee Details ID</td>
                        <td width="70%"><span> ${loanGuaranteeInstance.id}</span></td>
                    </tr>
               </table>      
            </g:if>
            <g:else>
                <table class="table table-bordered table-striped">
                    <legend>Loan Guarantee Details</legend>
                    <tr>
                        <td style="font-weight:bold" width="30%">Guarantee Details</td>
                        <td width="70%"><span>Not Applicable</span></td>
                    </tr>
                </table>    
            </g:else>    
        </content>    
        <content tag="main-actions">
            <ul>  
                <li><g:link class="list" action="agfpInformation" id="${loanInstance.id}" >Update AGFP Information</g:link></li>
                <li><g:link class="list" action="sbgfcInformation" id="${loanInstance.id}" >Update SBGFC Information</g:link></li>
                <li><g:link class="list" action="hgcInformation" id="${loanInstance.id}" >Update HGC Information</g:link></li>
                <li><g:link class="list" action="loanRediscountingGsp" id="${loanInstance.id}" >Update Loan Rediscounting Information</g:link></li>
                <li><g:link class="list" action="show" id="${loanInstance.id}" >Return to Loan Inquiry</g:link></li>
            </ul>
        </content>
    </body>
</html>
