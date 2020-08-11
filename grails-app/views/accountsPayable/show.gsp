<%@ page import="icbs.gl.AccountsPayable" %>
<%@ page import="icbs.gl.GlAccount" %>
<!DOCTYPE html>
<html>
    <head>
	<meta name="layout" content="main">
	<title>Accounts Payable Subsidiary Ledger Information</title>
    </head>
    <body>
         <content tag="breadcrumbs">
            <span class="fa fa-chevron-right"></span><a href="${createLink(uri: '/accountsPayable')}">Accounts Payable Subsidiary Ledger</a>
            <span class="fa fa-chevron-right"></span><span class="current">Accounts Payable Subsidiary Ledger Information</span>
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
             <g:if test="${accountsPayableInstance?.customer}" >
                <div class="row">
                    <div class="col-xs-12 col-sm-12">
                            <g:render template='/customer/details/newCustomerDetailedInfo' model="[customerInstance:accountsPayableInstance?.customer]"/>
                    </div>

                </div>
            </g:if>   
            
                <div class="row">
                    <div class="section-container">
                        <fieldset>
                            <legend class="section-header">Accounts Payable Information</legend>
                            <table class="table table-bordered table-rounded table-striped table-hover">
                            <tbody>
                                <tr>
                                    <td><label>AP Account No</label></td>
                                    <td>${accountsPayableInstance.acctNo}</td>    
                                </tr> 
                                <tr>
                                    <td style = "width:30%;"><label>Branch</label></td>
                                    <td style = "width:70%;">${accountsPayableInstance?.branch?.name}</td>    
                                </tr>

                                <tr>
                                    <td><label>Payable</label></td>
                                    <td>${accountsPayableInstance.payable}</td>    
                                </tr> 
                                <tr>
                                    <td><label>GL Code</label></td>
                                    <td>${accountsPayableInstance.glContra}</td>    
                                </tr> 
                                <tr>
                                    <td><label>GL Description</label></td>
                                    <td>${GlAccount.findByCode(accountsPayableInstance?.glContra).name}</td>    
                                </tr>
                                 <tr>
                                    <td><label>Balance</label></td>
                                    <td><g:formatNumber format="###,###,##0.00" number="${accountsPayableInstance.balance}"/></td>    
                                </tr> 
                                 <tr>
                                    <td><label>Currency</label></td>
                                    <td>${accountsPayableInstance?.currency?.code}</td>    
                                </tr> 
                                 <tr>
                                    <td><label>Reference</label></td>
                                    <td>${accountsPayableInstance.reference}</td>    
                                </tr>
                                <tr>
                                    <td><label>Particulars</label></td>
                                    <td>${accountsPayableInstance.particulars}</td>    
                                </tr>  
                               
                                
                                <tr>
                                    <td><label>Booking Date</label></td>
                                    <td><g:formatDate  format="MM/dd/yyyy" date="${accountsPayableInstance.bookingDate}" /></td>    
                                </tr> 
                                <tr>
                                    <td><label>Date Created</label></td>
                                    <td><g:formatDate  format="MM/dd/yyyy" date="${accountsPayableInstance.apCreatedDate}" /></td>    
                                </tr> 
                               
                                <tr>
                                    <td><label>Created by </label></td>
                                    <td>${accountsPayableInstance?.user?.name1} ${accountsPayableInstance?.user?.name2} ${accountsPayableInstance?.user?.name3}</td>    
                                </tr> 
                                <tr>
                                    <td><label>Status</label></td>
                                    <td>${accountsPayableInstance.status}</td>    
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
                <g:if test="${accountsPayableInstance.status.id != 8}">
                    <li><g:link action="edit" controller="accountsPayable"  id="${accountsPayableInstance.id}" >Edit</g:link></li>                
                    <li><g:link action="apDebit" controller="accountsPayable"  id="${accountsPayableInstance.id}">Accounts Payable Debit</g:link></li>
                    <li><g:link action="apCredit" controller="accountsPayable"  id="${accountsPayableInstance.id}">Accounts Payable Credit</g:link></li>
                </g:if>
                <g:if test="${accountsPayableInstance.balance > 0}">
                    <li><g:link action="reclassAp" controller="accountsPayable"  id="${accountsPayableInstance.id}">Reclass Accounts Payable</g:link></li>        
                </g:if>    
                <li><g:link action="viewTransactions" controller="accountsPayable"  id="${accountsPayableInstance.id}">View Accounts Payable Transactions</g:link></li>
                
                <g:if test="${accountsPayableInstance.balance == 0.00D && accountsPayableInstance.status.id != 8}">
                    <li><g:link action="apClose" controller="accountsPayable"  id="${accountsPayableInstance.id}">Close Accounts Payable</g:link></li>
                </g:if>
                <li><g:link action="index" controller="accountsPayable" >Accounts Payable List</g:link></li>
            </ul>
        </content>
    </body>
</html>
