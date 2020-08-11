<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="icbs.gl.GlAccount" %>


<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="layout" content="main">
        <title>Transaction Log details</title>
    </head>
    <body>
        <content tag="main-content">
            <div class="section-container">
                <fieldset>            
                    <legend class="section-header">Transaction Information</legend>            
                        <div class="infowrap">
                            <div class="col-xs-8 col-sm-6 col-md-6">
                                <dl class="dl-horizontal">
                                    <dt>Transaction Number</dt>
                                    <dd>${txnFileInstance?.id}</dd>
                                </dl>   
                                <dl class="dl-horizontal">
                                    <dt>Transaction Type</dt>
                                    <dd>${txnFileInstance?.txnTemplate?.description}</dd>
                                </dl>  
                                <dl class="dl-horizontal">
                                    <dt>Branch</dt>
                                    <dd>${txnFileInstance?.branch?.name}</dd>
                                </dl>                                 
                                <dl class="dl-horizontal">
                                    <dt>Account Number</dt>
                                    <dd>${txnFileInstance?.acctNo}</dd>
                                </dl>   
                                <g:if test="${depAcct}">
                                    <dl class="dl-horizontal">
                                        <dt>Account Name</dt>
                                        <dd>${txnFileInstance?.depAcct?.customer?.displayName}</dd>
                                    </dl>                                    
                                </g:if>
                                <g:if test="${loanAcct}">
                                    <dl class="dl-horizontal">
                                        <dt>Account Name</dt>
                                        <dd>${txnFileInstance?.loanAcct?.customer?.displayName}</dd>
                                    </dl>                                    
                                </g:if>                                    
                                <dl class="dl-horizontal">
                                    <dt>Transaction Amount</dt>
                                    <dd><g:formatNumber number="${txnFileInstance?.txnAmt}" format="###,###,##0.00" /></dd>
                                </dl>  
                                <dl class="dl-horizontal">
                                    <dt>Transaction Date</dt>
                                    <dd><g:formatDate date="${txnFileInstance.txnDate}" format="MM-dd-yyyy" /></dd>
                                </dl>                                 
                                <dl class="dl-horizontal">
                                    <dt>Transaction Reference</dt>
                                    <dd>${txnFileInstance?.txnRef}</dd>
                                </dl> 
                                <dl class="dl-horizontal">
                                    <dt>Transaction Description</dt>
                                    <dd>${txnFileInstance?.txnDescription}</dd>
                                </dl>                                 
                                <dl class="dl-horizontal">
                                    <dt>Transaction Particulars</dt>
                                    <dd>${txnFileInstance?.txnParticulars}</dd>
                                </dl>     
                                <dl class="dl-horizontal">
                                    <dt>Transaction Timestamp</dt>
                                    <dd>${txnFileInstance?.txnTimestamp}</dd>
                                </dl>  
                                <dl class="dl-horizontal">
                                    <dt>User Name</dt>
                                    <dd>${txnFileInstance?.user?.username}</dd>
                                </dl>                                 
                            </div>
                        </div>
                </fieldset>
            </div>
            <div id="grid">
                <div class="table-responsive">
                    <table class="table table-hover table-condensed table-bordered table-striped">
                        <tbody>
                            <tr>    
                                <td><label>Debit Account</label></td>                    
                                <td><label>Debit Amount</label></td>          
                                <td><label>Credit Account</label></td>
                                <td><label>Credit Amount</label></td>
                            </tr>
                        </tbody>   
                        <tbody>
                            <g:each in="${glEntries}" status="i" var="gl">
                                <tr>   
                                    <td>
                                        <g:if test="${gl?.debitAcct}">
                                            ${gl?.debitAcct + "  " + GlAccount.findByBranchAndCodeAndFinancialYearAndCurrency(txnFileInstance?.branch,gl?.debitAcct,txnFileInstance?.txnDate.format('yyyy'),txnFileInstance?.currency).name}
                                        </g:if>    
                                    </td>
                                    <td><g:formatNumber number="${gl.debitAmt}" format="###,###,##0.00" /></td>
                                    <td>
                                        <g:if test="${gl?.creditAcct}">
                                            ${gl?.creditAcct + "  " + GlAccount.findByBranchAndCodeAndFinancialYearAndCurrency(txnFileInstance?.branch,gl?.creditAcct,txnFileInstance?.txnDate.format('yyyy'),txnFileInstance?.currency).name}
                                        </g:if>
                                    </td>
                                    <td><g:formatNumber number="${gl.creditAmt}" format="###,###,##0.00" /></td>
                                </tr>
                            </g:each>                                
                        </tbody>
                    </table>
              </div>
            </div>    
        </content>    
        <content tag="main-actions">
            <ul>
                <li><g:link action="Index">Transaction Log Index</g:link></li>
                <li><g:link action="viewTellerBalancing" id="${txnFileInstance.id}">Print Transaction Details</g:link></li>
            </ul>
        </content>        
    </body>    
</html>
