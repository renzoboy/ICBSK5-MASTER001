<%@ page import="icbs.gl.AccountsReceivable" %>
<%@ page import="icbs.gl.GlAccount" %>
<!DOCTYPE html>
<html>
    <head>
	<meta name="layout" content="main">
	<title>Accounts Receivable Subsidiary Ledger Information</title>
        <g:javascript>
        function updateCustomerInfoAjax(params) {
                $.ajax({
				    type: 'POST',
				    data: {id:params.customer2},
				    url: "${createLink(controller :'customer', action:'showBasicCustomerInfoAjax')}",
				    success: function(msg){						
						$('#customer-name').val($(msg).find('#display-name').html());
						$('#customer').val(params.customer2);
						$('#birth-date').html($(msg).find('#birth-date').html())
						$('#address').html($(msg).find('#address').html())
						$('#photo').html($(msg).find('#photo').html())
                                                $('#total-released').html($(msg).find('#total-released').html())
                                                $('#total-balance').html($(msg).find('#total-balance').html())
                                                $('#total-count').html($(msg).find('#total-count').html())
				    },
				    error:function(XMLHttpRequest,textStatus,errorThrown){
                		alert(XMLHttpRequest+textStatus+errorThrown);
            		}
				});
            }
        
        </g:javascript>
    </head>
    <body>
         <content tag="breadcrumbs">
            <span class="fa fa-chevron-right"></span><a href="${createLink(uri: '/accountsReceivable')}">Accounts Receivable Subsidiary Ledger</a>
            <span class="fa fa-chevron-right"></span><span class="current">Accounts Receivable Subsidiary Ledger Information</span>
        </content>
        <content tag="main-content">
            <div class="content scaffold-show" role="main">
            <g:if test="${flash.message}">
                <div class="box-body">
                    <div class="alert alert-info alert-dismissable">
                        <i class="fa fa-info"></i>
                        <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                        <b>Message</b> <div class="message" role="status">${flash.message}</div>
                    </div>
                </div>
            </g:if>
             <g:if test="${accountsReceivableInstance?.customer}" >
                <div class="row">
                    <div class="col-xs-12 col-sm-12">
                            <g:render template='/customer/details/newCustomerDetailedInfo' model="[customerInstance:accountsReceivableInstance?.customer]"/>
                    </div>

                </div>
            </g:if>   
                <div class="row">
                    <div class="section-container">
                        <fieldset>
                            <legend class="section-header">Accounts Receivable Information</legend>
                            <table class="table table-bordered table-rounded table-striped table-hover">
                                <tbody>
                                    <tr>
                                        <td style = "width:30%;"><label>AR Account No</label></td>
                                        <td style = "width:70%;">${accountsReceivableInstance?.acctNo}</td>    
                                    </tr>
                                    <tr>
                                        <td style = "width:30%;"><label>Branch</label></td>
                                        <td style = "width:70%;">${accountsReceivableInstance?.branch?.name}</td>    
                                    </tr>
                                    
                                    <tr>
                                        <td><label>Receivable From (Name)</label></td>
                                        <td>${accountsReceivableInstance.receivableName}</td>    
                                    </tr> 
                                    <tr>
                                        <td><label>Description</label></td>
                                        <td>${accountsReceivableInstance.description}</td>    
                                    </tr> 
                                    <tr>
                                        <td><label>Balance</label></td>
                                        <td><g:formatNumber format="###,###,##0.00" number="${accountsReceivableInstance.balance}"/></td>    
                                    </tr> 
                                    <tr>
                                        <td><label>Currency</label></td>
                                        <td>${accountsReceivableInstance?.currency?.code}</td>    
                                    </tr> 
                                    <tr>
                                        <td><label>GL Code</label></td>
                                        <td>${accountsReceivableInstance.glContra}</td>    
                                    </tr> 
                                    <tr>
                                        <td><label>GL Description</label></td>
                                        <td>${GlAccount.findByCode(accountsReceivableInstance?.glContra).name}</td>    
                                    </tr>
                                    <tr>
                                        <td><label>Reference</label></td>
                                        <td>${accountsReceivableInstance.reference}</td>    
                                    </tr> 
                                     
                                    
                                    <tr>
                                        <td><label>Booking Date</label></td>
                                        <td><g:formatDate  format="MM/dd/yyyy" date="${accountsReceivableInstance.bookingDate}" /></td>    
                                    </tr> 
                                    <tr>
                                        <td><label>Maturity Date</label></td>
                                        <td><g:formatDate  format="MM/dd/yyyy" date="${accountsReceivableInstance.maturityDate}" /></td>    
                                    </tr>
                                    <tr>
                                        <td><label>Required Allowance</label></td>
                                        <td><g:formatNumber format="###,###,##0.00" number="${accountsReceivableInstance.requiredAllowance}"/></td>    
                                    </tr> 
                                    
                                    <tr>
                                        <td><label>User</label></td>
                                        <td>${accountsReceivableInstance?.user?.name}</td>    
                                    </tr> 
                                    <tr>
                                        <td><label>Status</label></td>
                                        <td>${accountsReceivableInstance.status}</td>    
                                    </tr> 
                                </tbody>
                            </table>
                        </fieldset>
                    </div>
                </div>        
            </div>
        </content>		

        <content tag="main-actions">
            <ul>
                <g:if test="${accountsReceivableInstance.status.id != 8}">
                    <li><g:link action="edit" controller="accountsReceivable" id="${accountsReceivableInstance.id}" >Edit</g:link></li>
                    <li><g:link action="arDebit" id="${accountsReceivableInstance.id}">Accounts Receivable Debit</g:link></li>
                    <li><g:link action="arCredit" id="${accountsReceivableInstance.id}">Accounts Receivable Credit</g:link></li>
                </g:if>
                <g:if test="${accountsReceivableInstance.balance > 0}">
                    <li><g:link action="reclassAr" controller="accountsReceivable"  id="${accountsReceivableInstance.id}">Reclass Accounts Receivable</g:link></li>        
                </g:if>
                <li><g:link action="viewTransactions" controller="accountsReceivable" id="${accountsReceivableInstance.id}">View Accounts Receivable Transactions</g:link></li>
                <g:if test="${accountsReceivableInstance.balance == 0.00D && accountsReceivableInstance.status.id != 8}">
                    <li><g:link action="arClose" id="${accountsReceivableInstance.id}">Close Accounts Receivable</g:link></li>
                </g:if>
                <li><g:link action="index" id="${accountsReceivableInstance.id}">Accounts Receivable List</g:link></li>
            </ul>
        </content>
    </body>
</html>
