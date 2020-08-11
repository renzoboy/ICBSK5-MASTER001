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
        <title>Loan Regulatory Relief Information</title>
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
                    <td style="font-weight:bold" width="30%">Account Number</td>
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
                    <td style="font-weight:bold" width="30%">Loan Balance</td>
                    <td width="70%"><span><g:formatNumber format="###,###,##0.00" number="${loanInstance?.balanceAmount}"/></span></td>
                </tr>                
            </table>
            <g:if test = "${reliefInstance}">
                <table class="table table-bordered table-striped">
                    <legend>Loan Relief Details</legend>
                <tr>
                    <td style="font-weight:bold" width="30%">Relief Status</td>
                    <td width="70%"><span><g:formatBoolean boolean="${reliefInstance?.loanReliefStatus}" true="Applied" false="Not Applied" /></span></td>
                </tr>
                <tr>
                    <td style="font-weight:bold" width="30%">Date of Relief</td>
                    <td width="70%"><span><g:formatDate format="MM/dd/yyyy" date="${reliefInstance?.reliefDate}"/></span></td>
                </tr>     
                <tr>
                    <td style="font-weight:bold" width="30%">Loan Relief Amount</td>
                    <td width="70%"><span><g:formatNumber format="###,###,##0.00" number="${reliefInstance?.loanAmount}"/></span></td>
                </tr>
                <tr>
                    <td style="font-weight:bold" width="30%">Date of Relief Removal</td>
                    <td width="70%"><span><g:formatDate format="MM/dd/yyyy" date="${reliefInstance?.reliefRemovalDate}"/></span></td>
                </tr>   
                <tr>
                    <td style="font-weight:bold" width="30%">Particulars/Remarks</td>
                    <td width="70%"><span>${reliefInstance?.particulars}</span></td>
                </tr>
                <tr>
                    <td style="font-weight:bold" width="30%">Created By</td>
                    <td width="70%"><span>${reliefInstance?.updatedBy?.username}</span></td>
                </tr>  
                <tr>
                    <td style="font-weight:bold" width="30%">Removed By</td>
                    <td width="70%"><span>${reliefInstance?.removedBy?.username}</span></td>
                </tr>
            </table>                
            </g:if>
            <g:else>
                <table class="table table-bordered table-striped">
                    <legend>Loan Relief Details</legend>
                    <tr>
                        <td style="font-weight:bold" width="30%">Regulatory Relief Status</td>
                        <td width="70%"><span>Not Applicable</span></td>
                    </tr>
                </table>    
            </g:else>    
        </content>    
        <content tag="main-actions">
            <ul>
                <g:if test="${reliefInstance}">
                    <g:if test="${reliefInstance?.loanReliefStatus == true}">
                        <li><g:link class="list" action="removeRelief" id="${loanInstance.id}" >Remove Regulatory Relief</g:link></li>
                    </g:if>
                    <g:else>
                        <li><g:link class="list" action="applyRelief" id="${loanInstance.id}" >Apply Regulatory Relief</g:link></li>
                    </g:else>
                </g:if>
                <g:else>
                    <li><g:link class="list" action="applyRelief" id="${loanInstance.id}" >Apply Regulatory Relief</g:link></li>
                </g:else>    
                <li><g:link class="list" action="show" id="${loanInstance.id}" >Return to Loan Inquiry</g:link></li>
            </ul>
        </content>
    </body>
</html>
