<%@ page import="icbs.loans.LoanLedger" %>
<%@ page import="icbs.tellering.TxnBreakdown" %>
<%@ page import="icbs.gl.GlAccount" %>
<%@ page import="icbs.admin.Currency" %>
<!DOCTYPE html>
<html>
    <head>
	<meta name="layout" content="main">
	<title>ROPA Transfer Details</title>
        <script>
            
        </script>
    </head>
        
    <body>
        
        <content tag="main-content">
             <div id="show-ROPA" class="content scaffold-show" role="main">
                <g:if test="${flash.message}">
                    <div class="box-body">
                        <div class="alert alert-info alert-dismissable">
                            <i class="fa fa-info"></i>
                            <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                            <b>Alert</b> <div class="message" role="status">${flash.message}</div>
                        </div>
                    </div>
                </g:if>
            </div>
            <div class="nav-tab-container">
                    <ul class="nav nav-tabs">
                        <li class="active"><a href="#tab_1" data-toggle="tab">Transfer Transaction Details</a></li>
                        <li><a href="#tab_2" data-toggle="tab">General Ledger Entries</a></li> 																	
                    </ul>
                </div>
                <div class="tab-content">
                    <div class="tab-pane active fade in table-responsive" id="tab_1">
                        <div class="section-container">
                            <legend class="section-header">Transaction Details</legend>
                            <div class="table-responsive">
                                <table class="table table-bordered table-striped">

                                    <tr>
                                        <td style="width: 30%;"><label>Transfer ID</label></td>
                                        <td style="width: 70%;">${ropaTransferInstance.id}</td>
                                    </tr>   
                                    <tr>
                                        <td><label>Transaction ID</label></td>
                                        <td>${ropaTransferInstance?.txnFile?.id}</td>
                                    </tr> 
                                    <tr>
                                        <td><label>Transaction Description</label></td>
                                        <td>${ropaTransferInstance?.txnFile?.txnDescription}</td>
                                    </tr> 
                                    <tr>
                                        <td><label>Transaction Date</label></td>
                                        <td><g:formatDate  format="MM/dd/yyyy" date="${ropaTransferInstance?.txnFile?.txnDate}" /></td>
                                    </tr>
                                    <tr>
                                        <td><label>Loan Account Number</label></td>
                                        <td>${ropaTransferInstance?.txnFile?.acctNo}</td>
                                    </tr>    
                                    <tr>
                                        <td><label>Branch</label></td>
                                        <td>${ropaTransferInstance?.txnFile?.branch?.name}</td>
                                    </tr>                                     
                                    <tr>
                                        <td><label>Transfer Amount</label></td>
                                        <td><g:formatNumber format="###,###,##0.00" number="${ropaTransferInstance?.transferAmount}"/></td>
                                    </tr>
                                    <tr>
                                        <td><label>Latest Appraised Value - Land</label></td>
                                        <td><g:formatNumber format="###,###,##0.00" number="${ropaTransferInstance?.marketValueLand}"/></td>
                                    </tr>  
                                    <tr>
                                        <td><label>Latest Appraised Value - Building</label></td>
                                        <td><g:formatNumber format="###,###,##0.00" number="${ropaTransferInstance?.marketValueBuilding}"/></td>
                                    </tr>  
                                    <tr>
                                        <td><label>Latest Appraised Value - Other Properties</label></td>
                                        <td><g:formatNumber format="###,###,##0.00" number="${ropaTransferInstance?.marketValueOther}"/></td>
                                    </tr> 
                                    <tr>
                                        <td><label>Allocated ROPA Amount - Land</label></td>
                                        <td><g:formatNumber format="###,###,##0.00" number="${ropaTransferInstance?.ropaLandAmount}"/></td>
                                    </tr> 
                                    <tr>
                                        <td><label>Allocated ROPA Amount - Building</label></td>
                                        <td><g:formatNumber format="###,###,##0.00" number="${ropaTransferInstance?.ropaBuildingAmount}"/></td>
                                    </tr>   
                                    <tr>
                                        <td><label>Allocated ROPA Amount - Other Properties</label></td>
                                        <td><g:formatNumber format="###,###,##0.00" number="${ropaTransferInstance?.otherGlAmount}"/></td>
                                    </tr> 
                                    <tr>
                                        <td><label>Transaction Status</label></td>
                                        <td>${ropaTransferInstance?.txnFile?.status?.description}</td>
                                    </tr> 
                                    <tr>
                                        <td><label>Transaction Reference</label></td>
                                        <td>${ropaTransferInstance?.txnFile?.txnRef}</td>
                                    </tr>
                                    <tr>
                                        <td><label>Transaction Particulars</label></td>
                                        <td>${ropaTransferInstance?.txnFile?.txnParticulars}</td>
                                    </tr> 
                                </table>
                            </div>
                        </div>
                    </div>
                    <div class="tab-pane" id="tab_2">
                       <div class="section-container">
                            <legend class="section-header" >General Ledger Entries</legend>
                            <div class="table-responsive">
                                <table class="table table-hover table-condensed table-bordered table-striped">
                                    <thead>
                                        <th><label>Debit</label></th>
                                        <th><label>Debit Amount</label></th>
                                        <th><label>Credit</label></th>
                                        <th><label>Credit Amount</label></th>
                                    </thead>  
                                    <tbody>
                                    <g:each in="${TxnBreakdown.findAllByTxnFile(ropaTransferInstance?.txnFile)}" status="i" var="t">
                                        <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
                                            <td>${t.debitAcct}
                                                <g:if test="${t.debitAcct}">
                                                </br>    
                                                <b>${GlAccount.findByCodeAndBranchAndCurrencyAndFinancialYear(t.debitAcct,t.branch,Currency.get(1),t.branch.runDate.format("yyyy")).name}</b>
                                                </g:if>
                                                </td>
                                            <td align="right"><g:formatNumber format="###,###,##0.00" number="${t.debitAmt}" /></td>

                                            <td>${t.creditAcct}
                                                <g:if test="${t.creditAcct}">
                                                </br>    
                                                <b>${GlAccount.findByCodeAndBranchAndCurrencyAndFinancialYear(t.creditAcct,t.branch,Currency.get(1),t.branch.runDate.format("yyyy")).name}</b>
                                                </g:if>
                                                </td>
                                            <td align="right"><g:formatNumber format="###,###,##0.00" number="${t.creditAmt}" /></td>
                                       </tr>
                                    </g:each>
                                    </tbody>   
                                </table>     
                            </div>   
                        </div> 
                    </div>
                </div>    
            <g:form id="cancelRopaTransfer" url="[controller:'ropa', action:'cancelRopaTransfer']" method="POST" >
                <g:hiddenField name="ropaTransferId" id="ropaTransferId" value="${ropaTransferInstance.id}"/>
            </g:form>
            
        </content>	
        <content tag="main-actions">
            <ul>
                <g:if test="${ropaTransferInstance?.txnFile?.status?.id == 2}">
                        
                    <li><button type="submit" onclick="validate();">Cancel Transfer</button></li>
                </g:if>
                <li><g:link action="index">List of ROPA </g:link></li>
            </ul>
            <script>
              function validate(){
                    alertify.confirm(AppTitle,'Are you sure you want to continue?',
                    function(){
                         checkIfAllowed('LON02001', 'form#cancelRopaTransfer', 'Cancel ROPA Transfer .', null); 
                    },
                    function(){
                        return;
                    });   
              }
        </script>
        </content>
        
    </body>
</html>

