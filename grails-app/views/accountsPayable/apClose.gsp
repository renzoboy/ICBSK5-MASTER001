<%@ page import="icbs.gl.AccountsPayable" %>
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
            <table class="table table-bordered table-rounded table-striped table-hover">
                    <tbody>
                        <tr>
                            <td style = "width:30%;"><label>Branch</label></td>
                            <td style = "width:70%;">${accountsPayableInstance?.branch?.name}</td>    
                        </tr>
                        <tr>
                            <td><label>Receivable</label></td>
                            <td>${accountsPayableInstance.payable}</td>    
                        </tr> 
                        <tr>
                            <td><label>Particulars</label></td>
                            <td>${accountsPayableInstance.particulars}</td>    
                        </tr>  
                        <tr>
                            <td><label>Currency</label></td>
                            <td>${accountsPayableInstance?.currency?.code}</td>    
                        </tr> 
                        <tr>
                            <td><label>GL Code</label></td>
                            <td>${accountsPayableInstance.glContra}</td>    
                        </tr> 
                        <tr>
                            <td><label>Booking Date</label></td>
                            <td><g:formatDate  format="MM/dd/yyyy" date="${accountsPayableInstance.bookingDate}" /></td>    
                        </tr> 
                        <tr>
                            <td><label>Balance</label></td>
                            <td><g:formatNumber format="###,###,##0.00" number="${accountsPayableInstance.balance}"/></td>    
                        </tr> 
                        <tr>
                            <td><label>User</label></td>
                            <td>${accountsPayableInstance?.user?.name}</td>    
                        </tr> 
                        <tr>
                            <td><label>Status</label></td>
                            <td>${accountsPayableInstance.status}</td>    
                        </tr> 
                    </tbody>
                </table>
            </div>
        </content>		

        <content tag="main-actions">
            <ul>
                <li><g:link action="saveApClose" controller="accountsPayable"  id="${accountsPayableInstance.id}" >Close Accounts Payable</g:link></li>                
                <li><g:link action="show" controller="accountsPayable"  id="${accountsPayableInstance.id}">Cancel</g:link></li>
            </ul>
        </content>
    </body>
</html>
