
<%@ page import="icbs.admin.Policy" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<title>Payment Transaction List</title>
	</head>
	<body>

		<content tag="breadcrumbs">
                    <span class="fa fa-chevron-right"></span><span class="current">Account Payment List</span>
		</content>

            <content tag="main-content">   
		<div id="list-accountReceivable" class="content scaffold-list" role="main">
                    <g:if test="${flash.message}">
                            <div class="message" role="status">${flash.message}</div>
                    </g:if>

                    <g:form url="[action:'viewLoanPaymentList',controller:'loan']" method="POST">            	
                    <div class="row">
                        <div class="col-md-12">
                            <div class="col-md-2">
                                 <g:select name="max" value="${params.max}" from="[5, 10, 15, 25]" class="form-control input-sm" onchange="this.form.submit()" />
                            </div>
                            <div class="input-group col-md-10">
                                <g:textField  type="text" name="query" class="form-control" placeholder="Search by Particulars"/>
                            <div class="input-group-btn">
                            <g:hiddenField name="id" id="id" value="${loanInstance?.id}" />    
                            <g:submitButton name="Search" class="btn btn-primary"></g:submitButton>
                            </div>
                            </div>
                        </div>
                    </div>

                    </g:form>
                </div>    

			<div class="table-responsive">
                            <table class="table table-hover table-condensed table-bordered table-striped">
                                <thead>
                                        <tr>
                                            <g:sortableColumn property="txnFile" title="Transaction ID" />
                                            <th>Txn Description</th>
                                            <g:sortableColumn property="txnRef" title="Transaction Reference" />
                                            <g:sortableColumn property="paymentAmt" title="Transaction Amount" />
                                            <g:sortableColumn property="txnDate" title="Txn Date" />
                                            <g:sortableColumn property="currency" title="currency" />
                                            <th>Action</th>
                                        </tr>
                                </thead>
                                <tbody>
                                <g:each in="${loanPayments}" status="i" var="txnLoanPaymentDetailsInstance">
                                        
                                    <g:if test="${txnLoanPaymentDetailsInstance?.txnFile?.txnType?.id != 26 && txnLoanPaymentDetailsInstance?.txnFile?.txnType?.id != 27}" >
                                        <%-- Do not show gl batch transactions  --%>
                                        <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
                                            
                                            <td>${txnLoanPaymentDetailsInstance?.txnFile?.id}</td>
                                            <td>${txnLoanPaymentDetailsInstance?.txnFile?.txnDescription}</td>
                                            <td>${txnLoanPaymentDetailsInstance?.txnRef}</td>
                                            <td align="right"><g:formatNumber format="###,###,##0.00" number="${txnLoanPaymentDetailsInstance?.paymentAmt}"/></td>
                                            <td><g:formatDate format="MM/dd/yyyy" date="${txnLoanPaymentDetailsInstance.txnDate}"/></td>
                                            <td>${txnLoanPaymentDetailsInstance?.currency?.code}</td>
                                            
                                            <td><g:link class="btn btn-info" action="showLoanPaymentDetails" id="${txnLoanPaymentDetailsInstance?.id}">View Details</g:link></td>
                                        </tr>
                                    </g:if>   
                                </g:each>
                                </tbody>
                            </table>
                        </div>
			
		</div>
            </content>
            <content tag="main-actions">
                <ul>
                    <li><g:link controller="home" action="landing">Home</g:link></li>
                    <li><g:link action="show" controller="loan" id="${params?.id}">Back to Loan Inquiry</g:link></li>
                <!-- <li><g:link action="printSchedule">Print Schedule of Accounts Payable</g:link></li>  -->   
                </ul>
            </content>
	</body>
</html>
