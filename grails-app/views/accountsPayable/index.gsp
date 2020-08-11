
<%@ page import="icbs.admin.Policy" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<title>Accounts Payable Subsidiary Ledger</title>
	</head>
	<body>

		<content tag="breadcrumbs">
                    <span class="fa fa-chevron-right"></span><span class="current">Accounts Payable Subsidiary Ledger</span>
		</content>

            <content tag="main-content">   
		<div id="list-accountReceivable" class="content scaffold-list" role="main">
                    <g:if test="${flash.message}">
                            <div class="message" role="status">${flash.message}</div>
                    </g:if>

                    <g:form url="[action:'index',controller:'accountsPayable']" method="POST">            	
                    <div class="row">
                        <div class="col-md-12">
                            <div class="col-md-2">
                                 <g:select name="max" value="${params.max}" from="[5, 10, 15, 25]" class="form-control input-sm" onchange="this.form.submit()" />
                            </div>
                            <div class="input-group col-md-10">
                                <g:textField  type="text" name="query" class="form-control" placeholder="Search by Account No or Particulars"/>
                            <div class="input-group-btn">
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
                                            
                                            <g:sortableColumn property="id" title="${message(code: 'accountsPayable.id.label', default: 'ID')}" />
                                            <td><label>Account No</label></td>
                                            <td><label>Branch</label></td>
                                            <g:sortableColumn property="payable" title="${message(code: 'accountsPayable.description.label', default: 'Payable')}" />
                                            <g:sortableColumn property="bookingDate" title="${message(code: 'accountsPayable.bookingDate.label', default: 'Booking date')}" />
                                            <g:sortableColumn property="balance" title="${message(code: 'accountsPayable.balance.label', default: 'Balance')}" />
                                            <g:sortableColumn property="particulars" title="${message(code: 'accountsPayable.currency.label', default: 'Particulars')}" />
                                            <g:sortableColumn property="status" title="Status" />
                                            <td>Action</td>
                                        </tr>
                                </thead>
                                <tbody>
                                <g:each in="${accountsPayableInstanceList}" status="i" var="accountsPayableInstance">
                                        <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
                                            
                                            <td>${accountsPayableInstance?.id}</td>
                                            <td>${accountsPayableInstance?.acctNo}</td>
                                            <td>${accountsPayableInstance?.branch?.name}</td>
                                            <td>${accountsPayableInstance?.payable}</td>                                       
                                            <td><g:formatDate format="MM/dd/yyyy" date="${accountsPayableInstance.bookingDate}"/></td>
                                            <td align="right"><g:formatNumber format="###,###,##0.00" number="${accountsPayableInstance?.balance}"/></td>
                                            <td>${accountsPayableInstance?.particulars}</td>
                                            <td>${accountsPayableInstance?.status?.description}</td>
                                            <td><g:link class="btn btn-info" action="show" id="${accountsPayableInstance?.id}">View Details</g:link></td>
                                        </tr>
                                </g:each>
                                </tbody>
                            </table>
                        </div>
			<div class="pagination">
				<g:paginate total="${AccountsPayableInstanceCount ?: 0}" params="${params}" />
			</div>
		</div>
            </content>
            <content tag="main-actions">
                <ul>
                    <li><g:link controller="home" action="landing">Home</g:link></li>
                    <li><g:link action="create">New Accounts Payable Subsidiary Ledger</g:link></li>
                <!-- <li><g:link action="printSchedule">Print Schedule of Accounts Payable</g:link></li>  -->   
                </ul>
            </content>
	</body>
</html>
