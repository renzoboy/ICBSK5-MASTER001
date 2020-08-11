<!--
  To change this license header, choose License Headers in Project Properties.
  To change this template file, choose Tools | Templates
  and open the template in the editor.
-->
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="icbs.gl.AccountsReceivable" %>
<%@ page import="icbs.gl.AccountsPayable" %>
<%@ page import="icbs.loans.LoanApplicationComaker" %>
<%@ page import="icbs.loans.Loan" %>
<html>
    <head>
        <title>Customer Accounts</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="layout" content="main">
        <asset:javascript src="customerHelper.js"/>
    </head>
    <body>
        <content tag="breadcrumbs">
            <span class="fa fa-chevron-right"></span><span class="current">Customer Accounts</span>
        </content>
        <content tag="main-content">
         <div class="modal-body">
                <div class="panel panel-default">
                    <div class="panel-heading">Customer Information</div>
                        <div class="panel-body">
                            <table class="table table-bordered table-rounded table-striped table-hover">
                                <tbody>
                                    <tr>
                                        <td style="width:30%"><label>Customer Name</label></td>
                                        <td style="width:70%">${customerInstance?.displayName}</td>   
                                    </tr> 
                                    <tr>
                                        <g:set var="primaryAddress" value="${(customerInstance?.addresses?.find{it.isPrimary==true})}"/>
                                        <td style="font-weight:bold" width="30%">Address</td>
                                        <g:if test="${primaryAddress!=null}">
                                        <td width="70%">${primaryAddress?.address1 + ", "+ primaryAddress?.address2 +", " +primaryAddress?.town.description+", "+primaryAddress?.address3}</td>
                                        </g:if>
                                        <g:else>
                                                <td width="70%">N / A</td>
                                        </g:else>
                                    </tr>
                                    <tr>
                                        <td style="width:30%"><label>Date of Birth</label></td>
                                        <td style="width:70%">${customerInstance?.birthDate?.format("MM/dd/yyyy")}</td>    
                                    </tr> 
                                
                                    <%--<tr>
                                        <td style="width:30%"><label>Credit Limit</label></td>
                                        <td style="width:70%">${customerInstance?.creditLimit}</td>    
                                    </tr> --%>
                               
                                </tbody>
                            </table> 
                        </div>
               </div>
                    <div class="row col-md-12">
                        <div class="table-responsive">
                            <legend>Customer Deposit Accounts</legend>
                            <table class="table table-hover table-condensed table-bordered table-striped">
                                <thead style="background-color: #cce6ff;">
                                    <tr>
                                        <td><label>Account Type</label></td>
                                        <td><label>Account Number</label></td>
                                        <td><label>Balance</label></td>
                                        <td><label>Status</label></td>
                                    </tr>
				</thead>
                                <tbody>
														  
                                    <g:each var="deposit" in="${customerInstance?.deposits}" status="i">
                                            <tr>			
                                                <td>${deposit?.product?.name}</td>		
                                                <td><g:link action="depositInquiry" controller="deposit" id="${deposit?.id}">${deposit?.acctNo}</g:link></td>
                                                <td><g:formatNumber format="###,###,##0.00" number="${deposit?.ledgerBalAmt}"/></td>
                                                <td>${deposit?.status?.description}</td>
                                            </tr>     
                                    </g:each> 
                                </tbody>    
                            </table>
                                    <%-- FOR AND/OR SIGNATORY--%>
                                    <legend>Customer Joint Accounts / Other Signatories</legend>
                                    <table class="table table-hover table-condensed table-bordered table-striped">
                                        <thead style="background-color: #cce6ff;">							   
																				   
                                            <tr>
                                                <td><label>Joint Account Name</label></td>
                                                <td><label>Deposit Account</label></td>
                                                <td><label>Status</label></td>					 
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <g:each var="thesignatories" in="${icbs.deposit.Signatory.findAllBySignatory(customerInstance)}" status="p">
                                                    <tr>
                                                        <td><g:link target="_blank" action="customerInquiry" controller="customer" id="${thesignatories?.deposit?.customer?.id}">${thesignatories?.deposit?.acctName}</g:link></td>
                                                        <td><g:link action="depositInquiry" controller="deposit" id="${thesignatories?.deposit?.id}">${thesignatories?.deposit?.acctNo}</g:link></td>
                                                        <td>${thesignatories?.deposit?.status?.description}</td>
                                                    </tr>
                                            </g:each>
                                        </tbody>
                                    </table>
                                    <legend>Customer Loan and SCR Accounts</legend>
                                    <table class="table table-hover table-condensed table-bordered table-striped">
                                        <thead style="background-color: #cce6ff;">
                                            <tr>
                                                <td><label>Type</label></td>
                                                <td><label>Account Number</label></td>
                                                <td><label>Balance</label></td>
                                                <td><label>Status</label></td>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <g:each var="loan" in="${customerInstance?.loans}" status="i">
                                                    <tr>
                                                        <td>${loan?.product?.name}</td>
                                                        <td><g:link action="show" controller="loan" id="${loan?.id}">${loan?.accountNo}</g:link></td>
                                                        <td><g:formatNumber format="###,###,##0.00" number="${loan?.balanceAmount}"/></td>
                                                        <td>${loan?.status?.description}</td>
                                                    </tr>
                                            </g:each> 
                                        </tbody>
                                    </table>
                                    
                                    <legend>Co-Maker</legend>
                                    <table class="table table-hover table-condensed table-bordered table-striped">
                                        <thead style="background-color: #cce6ff;">
                                            <tr>
                                                <td><label>Customer</label></td>
                                                <td><label>Account</label></td>
                                                <td><label>Balance</label></td>
                                                <td><label>Status</label></td>
                                                                                               
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <g:each in="${LoanApplicationComaker.findAllByCustomer(customerInstance)}" status="i" var="CM">
                                                <g:if test="${Loan.findByLoanApplication(CM?.loanApplication)}" >
                                                <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
                                                    <td>${CM?.loanApplication?.customer?.displayName}</td>
                                                    <td>${Loan.findByLoanApplication(CM?.loanApplication)?.accountNo}</td>
                                                    <td><g:formatNumber format="###,###,##0.00" number="${Loan.findByLoanApplication(CM?.loanApplication)?.balanceAmount}"/></td>
                                                    <td>${Loan.findByLoanApplication(CM?.loanApplication)?.status?.description}</td>                                               
                                                </tr>
                                                </g:if>
                                            </g:each> 
                                        </tbody>
                                    </table>
                                    
                                    
                        </div>
                    </div>
                </div>        
        </content>
        <content tag="main-actions">
            <ul>
                <li><g:link action="customerInquiry" id="${customerInstance?.id}">Back to Customer Inquiry</g:link></li>
            </ul>
        </content>
    </body> 
</html>
