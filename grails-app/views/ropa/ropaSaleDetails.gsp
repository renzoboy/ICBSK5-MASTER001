<%@ page import="icbs.tellering.TxnBreakdown" %>
<%@ page import="icbs.gl.GlAccount" %>
<%@ page import="icbs.admin.Currency" %>
<!DOCTYPE html>
<html>
    <head>
	<meta name="layout" content="main">
	<title>ROPA Sale Transaction Details</title>
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
            <%-- --%>
            <div class="tab-content">
                <div class="tab-pane active fade in table-responsive" id="tab_1">
                    <div class="section-container">
                        <legend class="section-header">Transaction Details</legend>
                        <div class="table-responsive">
                            <table class="table table-bordered table-striped">

                                <tr>
                                    <td style="width: 30%;"><label>Sale ID</label></td>
                                    <td style="width: 70%;">${ropaSaleInstance.id}</td>
                                </tr>   
                                <tr>
                                    <td><label>Transaction ID</label></td>
                                    <td>${ropaSaleInstance?.txnFile?.id}</td>
                                </tr> 
                                <tr>
                                    <td><label>Transaction Description</label></td>
                                    <td>${ropaSaleInstance?.txnFile?.txnDescription}</td>
                                </tr>
                                <tr>
                                    <td><label>ROPA Source Branch</label></td>
                                    <td>${ropaSaleInstance?.ropaBranch?.name}</td>
                                </tr> 
                                <tr>
                                    <td><label>ROPA Sale Processing Branch</label></td>
                                    <td>${ropaSaleInstance?.processBranch?.name}</td>
                                </tr>                                     
                                <tr>
                                    <td><label>Transaction Date</label></td>
                                    <td><g:formatDate  format="MM/dd/yyyy" date="${ropaSaleInstance?.txnFile?.txnDate}" /></td>
                                </tr>
                                <tr>
                                    <td><label>Agent</label></td>
                                    <td>${ropaSaleInstance?.agent?.username}</td>
                                </tr>
                                <g:if test="${ropaSaleInstance.loan}">
                                <tr>
                                    <td><label>SCR Account Number</label></td>
                                    <td>${ropaSaleInstance?.loan?.accountNo}</td>
                                </tr>    
                                </g:if>
                                <tr>
                                    <td><label>Buyer Name</label></td>
                                    <td>${ropaSaleInstance?.loanApplication?.customer?.displayName}</td>
                                </tr>                                                                         
                                <tr>
                                    <td><label>Sale Amount</label></td>
                                    <td><g:formatNumber format="###,###,##0.00" number="${ropaSaleInstance?.saleAmount}"/></td>
                                </tr>
                                <tr>
                                    <td><label>Sales Commission</label></td>
                                    <td><g:formatNumber format="###,###,##0.00" number="${ropaSaleInstance?.commission}"/></td>
                                </tr>        
                                <tr>
                                    <td><label>Down Payment Amount</label></td>
                                    <td><g:formatNumber format="###,###,##0.00" number="${ropaSaleInstance?.downpayment}"/></td>
                                </tr>
                                <tr>
                                    <td><label>Sales Contract Receivable Amount</label></td>
                                    <td><g:formatNumber format="###,###,##0.00" number="${ropaSaleInstance?.scrAmount}"/></td>
                                </tr>      
                                <tr>
                                    <td><label>Sales Contract Receivable Discount</label></td>
                                    <td><g:formatNumber format="###,###,##0.00" number="${ropaSaleInstance?.scrDiscount}"/></td>
                                </tr>                                     
                                <tr>
                                    <td><label>ROPA Net Book Value</label></td>
                                    <td><g:formatNumber format="###,###,##0.00" number="${ropaSaleInstance?.ropaLandAmt + ropaSaleInstance?.ropaBldgAmt + ropaSaleInstance?.ropaOtherAmt - ropaSaleInstance?.accDepBldg - ropaSaleInstance?.accDepOther}"/></td>
                                </tr>                                    
                                <tr>
                                    <td><label>ROPA Gain on Sale</label></td>
                                    <td><g:formatNumber format="###,###,##0.00" number="${ropaSaleInstance?.incomeAmount}"/></td>
                                </tr>                                    
                                <tr>
                                    <td><label>Transaction Status</label></td>
                                    <td>${ropaSaleInstance?.txnFile?.status?.description}</td>
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
                                    <th><label>Branch</label></th>
                                    <th><label>Debit</label></th>
                                    <th><label>Debit Amount</label></th>
                                    <th><label>Credit</label></th>
                                    <th><label>Credit Amount</label></th>
                                </thead>  
                                <tbody>
                                <g:each in="${TxnBreakdown.findAllByTxnFile(ropaSaleInstance?.txnFile)}" status="i" var="t">
                                    <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					<td>${t?.branch?.name}</td>					  
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
			 <g:form id="cancelRopaSale" url="[controller:'ropa', action:'cancelRopaSale']" method="POST" >
                <g:hiddenField name="ropaSaleId" id="ropaSaleId" value="${ropaSaleInstance.id}"/>
            </g:form>
        </content>	
        <content tag="main-actions">
            <ul>
                <g:if test="${ropaSaleInstance?.txnFile?.status?.id == 2}">
                    <li><button type="submit" onclick="validate();">Cancel ROPA Sale</button></li>
                </g:if>
                <li><g:link action="index">List of ROPA</g:link></li>
            </ul>
			<script>		
				function validate(){
						alertify.confirm(AppTitle,'Are you sure you want to continue?',
						function(){
							 checkIfAllowed('LON02002', 'form#cancelRopaSale', 'Cancel ROPA Sale Cash .', null); 
						},
						function(){
							return;
						});   
				}
			</script>
        </content>
    </body>
</html>

