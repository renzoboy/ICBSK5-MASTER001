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
 
        <title>Process Loan Write-Off</title>
    </head>
    <body>
        <content tag="main-content">
            <table class="table table-bordered table-striped">
                <tr>
                    <td style="font-weight:bold" width="30%">Account Number</td>
                    <td width="70%"><span>${loanInstance?.accountNo}</span></td>
                </tr> 
                 <tr>
                    <td style="font-weight:bold" width="30%">Borrower Name</td>
                    <td width="70%"><span>${loanInstance?.customer?.displayName}</span></td>
                </tr>
                <tr>
                    <td style="font-weight:bold" width="30%">Loan Amount</td>
                    <td width="70%"><span><g:formatNumber format="###,###,##0.00" number="${loanInstance?.grantedAmount}"/></span></td>
                </tr> 
                <tr>
                    <td style="font-weight:bold" width="30%">Loan Balance</td>
                    <td width="70%"><span><g:formatNumber format="###,###,##0.00" number="${loanInstance?.balanceAmount}"/></span></td>
                </tr> 
                <tr>
                    <td style="font-weight:bold" width="30%">Date Opened</td>
                    <td width="70%"><span><g:formatDate format="MM/dd/yyyy" date="${loanInstance?.openingDate}"/></span></td>
                </tr>   
                <tr>
                    <td style="font-weight:bold" width="30%">Maturity Date</td>
                    <td width="70%"><span><g:formatDate format="MM/dd/yyyy" date="${loanInstance?.maturityDate}"/></span></td>
                </tr>
                <tr>
                    <td style="font-weight:bold" width="30%">Last Transaction Date</td>
                    <td width="70%"><span><g:formatDate format="MM/dd/yyyy" date="${loanInstance?.lastTransactionDate}"/></span></td>
                </tr>                
            </table>      
            <g:form id="transfers" name="transfers" url="[controller:loan, action:'transferW', id:loanInstance.id]" method="POST">
            <div class="form-group">
                <label class="control-label">Transaction Type</label>
                <div class="col-sm-6">
                    <select id="txnTemplate" name="txnTemplate" class="many-to-one form-control">
                        <g:each in="${icbs.admin.TxnTemplate.findAllByTxnType(icbs.lov.TxnType.read(35))}" var="txnTemplateInstance">
                            <option value="${txnTemplateInstance.id}">${txnTemplateInstance.codeDescription}</option>
                        </g:each>
                    </select>
                </div>
            </div>               
            <div class="fieldcontain form-group ${hasErrors(bean: loanInstance, field: 'loan', 'has-error')} ">
                <label class="control-label col-sm-4" for="loan">
                    <g:message code="loan.label" default="Reference" />
                    <span class="required-indicator">*</span>
                </label>
                <div class="col-sm-7"><g:field name="reference"  class="form-control"/></div>
            </div>
    
            <div class="fieldcontain form-group ${hasErrors(bean: loanInstance, field: 'loan', 'has-error')} ">
                <label class="control-label col-sm-4" for="loan">
                    <g:message code="loan.label" default="Particulars" />
                    <span class="required-indicator">*</span>
                </label>
                <div class="col-sm-7"><g:field name="particulars" class="form-control" /></div>
            </div>
        </g:form>
        </content>     
        <content tag="main-actions">
            <ul>
                <g:if test="${loanInstance?.status?.id <= 5}"> 
                    <li>
                        <g:actionSubmit id="transfer" action="transferW" value="Transfer Account to Write off" onclick="
                            alertify.confirm(AppTitle,'Are you sure you want to continue Write-Off transaction?',    
                                function(){
                                    checkIfAllowed('LON01900', 'form#transfers', 'Transfer to Write off', null);
                                },
                                function(){
                                    return;
                                });                        
                    "/></li>            
                </g:if>
                <li><g:link class="list" action="index" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');">Cancel</g:link></li>
            </ul>                           
        </content>
    </body>
</html> 