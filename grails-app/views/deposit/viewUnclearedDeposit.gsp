<%@ page import="icbs.tellering.TxnCOCI" %>
<%@ page import="icbs.loans.Loan" %>
<%@ page import="icbs.deposit.Deposit" %>
<!DOCTYPE html>
<html>
    <head>
	<meta name="layout" content="main">
	<title>TXN COCI Information</title>
    </head>
    <body>
        <content tag="breadcrumbs">
            <span class="fa fa-chevron-right"></span><a href="${createLink(uri: '/cashInBank')}">Cash in Bank/Due From Bank Subsidiary Ledger</a>
            <span class="fa fa-chevron-right"></span><span class="current">Cash in Bank Subsidiary Ledger Information</span>
        </content>
        <content tag="main-content">
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
                            <td style="width:30%"><label>Cheque</label></td>
                            <td style="width:70%">${txnCociInstanceId?.checkNo}</td>    
                        </tr>                         
                        <tr>
                            <td style="width:30%"><label>Txn Reference</label></td>
                            <td style="width:70%">${txnCociInstanceId?.txnRef}</td>    
                        </tr> 
                        <tr>
                            <td style="width:30%"><label>Total Checks</label></td>
                            <td style="width:70%">${txnCociInstanceId?.totalChecks}</td>    
                        </tr> 
                        <tr>
                            <td style="width:30%"><label>Txn Amount</label></td>
                            <td style="width:70%"><g:formatNumber format="##0.00000" number="${txnCociInstance?.txnAmt}"/></td>    
                        </tr>                        
                        <tr>
                            <td style="width:30%"><label>Payee</label></td>
                            <td style="width:70%">${txnCociInstanceId?.payee}</td>    
                        </tr>
                        <tr>
                            <td style="width:30%"><label>Loan Account</label></td>
                            <td style="width:70%">${txnCociInstanceId?.acctNo}</td>    
                        </tr>  
                        <tr>
                            <td style="width:30%"><label>Deposit Account</label></td>
                            <td style="width:70%">${txnCociInstanceId?.depAcct.id}</td>    
                        </tr>
                        <tr>
                            <td style="width:30%"><label>Branch</label></td>
                            <td style="width:70%">${txnCociInstanceId?.branch?.name}</td>    
                        </tr>
                        <tr>
                            <td style="width:30%"><label>Check Type</label></td>
                            <td style="width:70%">${txnCociInstanceId?.checkType?.id}</td>    
                        </tr>
                        <tr>
                            <td style="width:30%"><label>Clearing Bank</label></td>
                            <td style="width:70%">${txnCociInstanceId?.bank}</td>    
                        </tr>  
                        <tr>
                            <td style="width:30%"><label>Check Number</label></td>
                            <td style="width:70%">${txnCociInstanceId?.checkNo}</td>    
                        </tr>
                        <tr>
                            <td style="width:30%"><label>Check Account Name</label></td>
                            <td style="width:70%">${txnCociInstanceId?.checkAcctName}</td>    
                        </tr>
                        <tr>
                            <td style="width:30%"><label>Check Amount</label></td>
                            <td style="width:70%"><g:formatNumber format="##0.00000" number="${txnCociInstanceId?.checkAmt}"/></td>    
                        </tr>
                        <tr>
                            <td style="width:30%"><label>Check Date</label></td>
                            <td style="width:70%"><g:formatDate format="MM/dd/yyyy" date="${txnCociInstanceId?.checkDate}" /></td>  
                        </tr>
                        <tr>
                            <td style="width:30%"><label>Clearing Date</label></td>
                            <td style="width:70%"><g:formatDate format="MM/dd/yyyy" date="${txnCociInstanceId?.clearingDate}" /></td>  
                        </tr>
                        <tr>
                            <td style="width:30%"><label>Status</label></td>
                            <td style="width:70%">${txnCociInstanceId?.status?.description}</td>    
                        </tr>
                        <tr>
                            <td style="width:30%"><label>Hash</label></td>
                            <td style="width:70%">${txnCociInstanceId?.hash}</td>    
                        </tr>
                        <tr>
                            <td style="width:30%"><label>Currency</label></td>
                            <td style="width:70%">${txnCociInstanceId?.currency?.name}</td>    
                        </tr>
                        <tr>
                            <td style="width:30%"><label>Txn File</label></td>
                            <td style="width:70%">${txnCociInstanceId?.txnFile?.txnDescription}</td>    
                        </tr>
                        <tr>
                            <td style="width:30%"><label>Cleared</label></td>
                            <td style="width:70%">${txnCociInstanceId?.cleared}</td>    
                        </tr>
                        <tr>
                            <td style="width:30%"><label>User</label></td>
                            <td style="width:70%">${txnCociInstanceId?.user?.name}</td>    
                        </tr>
                          
                    </tbody>
                </table>      
        </content>	
        <content tag="main-actions">
            <ul>
                <li><g:link action="depositInquiry" id="${txnCociInstanceId?.depAcct.id}" >Return to Deposit Inquiry Page</g:link></li>
            </ul>
        </content>
    </body>
</html>