<%@ page import="icbs.gl.GlContigentAccount" %>
<!DOCTYPE html>


<html>
    <head>
	<meta name="layout" content="main">	
        <g:set var="entityName" value="${message(code: 'ContigentAccount.label', default: 'Contigent Account')}" />
	<title><g:message code="default.list.label" args="[entityName]" /></title>
    </head>
    <body>
        <content tag="breadcrumbs">
            <span class="fa fa-chevron-right"></span><span class="current">Contigent Account List</span>
	</content>

        <content tag="main-content">   
            <div id="list-atm_txn" class="content scaffold-list" role="main">
		<g:if test="${flash.message}">
                    <div class="message" role="status">${flash.message}</div>
		</g:if>
                <g:form class="form-inline">
                    <div class="form-group">
			<g:select name="max" value="${params.max}" from="[5, 10, 15, 20]" class="form-control input-sm pull-left"onchange="this.form.submit()" />
                    </div>
                    <div class="right">
                        <div class="form-group">
                            <g:textField  type="text" name="query" class="form-control input-sm pull-right" style="width: 150px;" placeholder="Search"/>
			</div>
			<g:submitButton name="Search" class="btn btn-sm btn-default"><i class="fa fa-search"></i></g:submitButton>
                    </div>
		</g:form>

		<div class="table-responsive">
                    <table class="table table-bordered table-rounded table-striped table-hover">
                        <thead>
                            <tr>
				<g:sortableColumn property="id" title="${message(code: 'GlContigentAccount.id.label', default: 'ID')}" />
				<g:sortableColumn property="txnDate" title="${message(code: 'GlContigentAccount.txnDate.label', default: 'Transaction Date')}" />
				<g:sortableColumn property="accountNo" title="${message(code: 'GlContigentAccount.contigentId.label', default: 'Account Number')}" />					
                                <g:sortableColumn property="particulars" title="${message(code: 'GlContigentAccount.particulars.label', default: 'Particulars')}" />
                                <g:sortableColumn property="currentCustodian" title="${message(code: 'GlContigentAccount.particulars.label', default: 'Current Custodian')}" />
                                <th>Action</th>
                            </tr>
			</thead>
                        <tbody>
                            <g:each in="${GlContigentAccountList}" status="i" var="ContigentInstance">
                                <g:if test="${ContigentInstance?.status?.description=='Active'}">
                                    <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
                                        <td>${fieldValue(bean: ContigentInstance, field: "id")}</td>
					<td><g:formatDate  format="MM/dd/yyyy" date="${ContigentInstance.txnDate}" /></td>
                                        <td>${ContigentInstance.accountNo}</td>
                                        <td>${ContigentInstance.particulars}</td>
                                        <td>${ContigentInstance.currentCustodian}</td>
                                        <td>
                                            <g:link  class="btn btn-secondary" controller="GlContAcct" action="viewDetails" id="${ContigentInstance.id}"><span>View</span></g:link>
                                        </td>  
                                    </tr>
                                </g:if>
                            </g:each>
			</tbody>
                    </table>
                </div>
                <div class="pagination">
                    <g:paginate total="${BranchInstanceCount ?: 0}" params="${params}" />
		</div>
            </div>
        </content>
        <!-- Action menus Right side menus -->
        <content tag="main-actions">
            <ul>
                <li><g:link action="createcontigent">Create New Contigent Account</g:link></li>
            </ul>
        </content>
    </body>
</html>