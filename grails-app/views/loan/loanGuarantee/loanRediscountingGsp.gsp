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
        <title>Loan Rediscounting Details</title>
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
                    <td style="font-weight:bold" width="30%">Loan Balance</td>
                    <td width="70%"><span><g:formatNumber format="###,###,##0.00" number="${loanInstance?.balanceAmount}"/></span></td>
                </tr>                
            </table>
            <div class="nav-tabs-custom">
           <g:form id="loan-form" url="[controller:loan, action:'saveLoanRediscounting']"
                onsubmit="callLoadingDialog();">   
                <g:hiddenField name="loanInstance" value="${loanInstance.id}" />
                <g:render template="/loan/loanGuarantee/form/loanRediscount"/>
                <br>
                
            </g:form>
           </div>
        </content> 
        <content tag="main-actions">
            <ul>  
               <li><g:submitButton id="save" name="save" value="Save" onclick="
                        alertify.confirm(AppTitle,'Are you sure you want to create this loan guarantee?',
                                function(){
                                    checkIfAllowed('LON00500', 'form#loan-form', 'Open New Loan guarantee', null);;
                                },
                                function(){
                                    return;
                                }); 
                        "/></li>
                <%--
                <li><g:link class="list" action="saveGuarantee" id="${loanInstance.id}" >Save</g:link></li> --%>
                <li><g:link class="list" action="loanGurantee" id="${loanInstance.id}" >Return to Guarantee Information View</g:link></li>
            </ul>
        </content>
    </body>
</html>


