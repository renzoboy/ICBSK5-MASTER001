
<%@ page import="icbs.admin.Policy" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<title>Accounts Receivable Subsidiary Ledger</title>
	</head>
	<body>

		<content tag="breadcrumbs">
                    <span class="fa fa-chevron-right"></span><span class="current">Accounts Receivable Subsidiary Ledger</span>
		</content>

            <content tag="main-content">   
		<div id="list-accountReceivable" class="content scaffold-list" role="main">
                    <g:if test="${flash.message}">
                            <div class="message" role="status">${flash.message}</div>
                    </g:if>

                    <g:form url="[action:'index',controller:'accountsReceivable']" method="POST">            	
                    <div class="row">
                        <div class="col-md-12">
                            <div class="col-md-2">
                                 <g:select name="max" value="${params.max}" from="[5, 10, 15, 25]" class="form-control input-sm" onchange="this.form.submit()" />
                            </div>
                            <div class="input-group col-md-10">
                                <g:textField  type="text" name="query" class="form-control" placeholder="Search by Account No or Description or Particulars"/>
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
                                            <td><label>ID</label></td>
                                            <td><label>Account No</label></td>
                                            <td><label>Branch</label></td>
                                            <g:sortableColumn property="receivableName" title="${message(code: 'accountsReceivable.description.label', default: 'Receivable')}" />
                                            <g:sortableColumn property="description" title="${message(code: 'accountsReceivable.description.label', default: 'Description')}" />
                                            <g:sortableColumn property="bookingDate" title="${message(code: 'accountsReceivable.bookingDate.label', default: 'Booking date')}" />
                                            <g:sortableColumn property="balance" title="${message(code: 'accountsReceivable.balance.label', default: 'Balance')}" />
                                            <g:sortableColumn property="status" title="Status" />
                                            <td><label>Action</label>
                                        </tr>
                                </thead>
                                <tbody>
                                <g:each in="${accountsReceivableInstanceList}" status="i" var="accountsReceivableInstance">
                                        <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
                                            <td>${accountsReceivableInstance?.id}</td>
                                            <td>${accountsReceivableInstance?.acctNo}</td>
                                            <td>${accountsReceivableInstance?.branch?.name}</td>
                                            <td>${accountsReceivableInstance?.receivableName}</td>
                                            <td>${accountsReceivableInstance?.description}</td>                                        
                                            <td><g:formatDate format="MM/dd/yyyy" date="${accountsReceivableInstance.bookingDate}"/></td>
                                            <td align="right"><g:formatNumber format="###,###,##0.00" number="${accountsReceivableInstance?.balance}"/></td>
                                            <td>${accountsReceivableInstance?.status?.description}</td> 
                                            <td><g:link class="btn btn-info" action="show" id="${accountsReceivableInstance?.id}">View Details</g:link></td>
                                        </tr>
                                </g:each>
                                </tbody>
                            </table>
                        </div>
			<div class="pagination">
				<g:paginate total="${AccountsReceivableInstanceCount ?: 0}" params="${params}" />
			</div>
		</div>
            </content>
            <content tag="main-actions">
                <ul>
                    <li><g:link controller="home" action="landing">Home</g:link></li>
                    <li><g:link controller="accountsReceivable" action="create">New Accounts Receivable Subsidiary Ledger</g:link></li>
                    <!-- <li><g:link controller="home" action="landing">Print Schedule of Accounts Receivable</g:link></li>  -->              
                </ul>
            </content>
	</body>
</html>
