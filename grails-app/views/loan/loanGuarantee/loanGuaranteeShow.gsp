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
                    <td style="font-weight:bold" width="30%">Loan Balance</td>
                    <td width="70%"><span><g:formatNumber format="###,###,##0.00" number="${loanInstance?.balanceAmount}"/></span></td>
                </tr>                
            </table>
            <div class="nav-tabs-custom">
           <g:form id="loan-form" url="[controller:loan, action:'saveGuarantee']"
                            onsubmit="callLoadingDialog();">    
            <div class="nav-tab-container">
                <ul class="nav nav-tabs">
                    <li class="active"><a href="#tab_1" data-toggle="tab">Agricultural Guarantee Fund Pool</a></li>
                    <li><a href="#tab_2" data-toggle="tab">Small Business Guarantee Fund</a></li>                        
                    <li><a href="#tab_3" data-toggle="tab">Home Guarantee Corporation</a></li>
                </ul>
            </div> 
            <div class="tab-content">
                <g:hiddenField name="loanInstance" value="${loanInstance.id}" />
                <div class="tab-pane active fade in table-responsive" id="tab_1">
                   
                    <g:render template="/loan/loanGuarantee/detailForm/agfpShow"/>
                     
                </div>
                <div class="tab-pane fade in table-responsive" id="tab_2">
                     <g:render template="/loan/loanGuarantee/detailForm/sbgfcShow"/>
                </div>   
                <div class="tab-pane fade in table-responsive" id="tab_3">
                     <g:render template="/loan/loanGuarantee/detailForm/hgcShow"/>
                </div>  

            </div>
            </div>
            <g:hiddenField name="loanInstance" value="${loanInstance.id}" />
             </g:form>
      
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
