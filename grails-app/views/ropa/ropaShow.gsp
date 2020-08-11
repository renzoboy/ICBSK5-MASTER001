<%@ page import="icbs.loans.ROPA" %>
<%@ page import="icbs.gl.GlAccount" %>
<!DOCTYPE html>
<html>
    <head>
	<meta name="layout" content="main">
	<title>ROPA Information</title>
    </head>
    <body>
        <content tag="breadcrumbs">
                <span class="fa fa-chevron-right"></span><span class="current">ROPA Information</span>
        </content>
        <content tag="breadcrumbs">
            <span class="fa fa-chevron-right"></span><a href="${createLink(uri: '/ropa')}">ROPA Index</a>
            <span class="fa fa-chevron-right"></span><span class="current">ROPA Details</span>
        </content>
        <content tag="main-content">
             <div id="show-ROPA" class="content scaffold-show" role="main">
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
                            <td style="width:30%"><label>Balance Amount</label></td>
                            <td style="width:70%">${ropaInstance?.balanceAmt}</td>    
                        </tr>                         
                                                 
                    </tbody>
                </table>                                  
            </div>
        </content>	
        <content tag="main-actions">
            <ul>
                <li><g:link action="edit" id="${ropaInstance?.id}" >Edit</g:link></li>
                <li><g:link action="viewTransactions" id="${RopaInstance?.id}" >View ROPA Transactions</g:link></li>
                <li><g:link action="ropaDebit" id="${ropaInstance?.id}">ROPA Debit</g:link></li>
                <li><g:link action="ropaCredit" id="${ropaInstance?.id}">ROPA Credit</g:link></li>
                <li><g:link action="ropaExpense" id="${RopaInstance?.id}">Create ROPA Expense</g:link></li>
                <!-- <li><g:link action="index" >ROPA List</g:link></li> -->
            </ul>
        </content>
    </body>
</html>

