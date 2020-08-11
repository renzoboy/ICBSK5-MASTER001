<%@ page import="icbs.gl.AccountsPayable" %>
<%@ page import="icbs.gl.AccountsPayableLedger" %>
<%@ page import="icbs.gl.GlAccount" %>
<!DOCTYPE html>
<html>
    <head>
	<meta name="layout" content="main">
	<title>Accounts Payable Ledger Transactions</title>
    </head>
    <body>

        <content tag="main-content">
            <div class="panel panel-default">
            <table class="table table-bordered table-rounded table-striped table-hover">
                    <tbody>
                        <tr>
                            <td style = "width:30%;"><label>AP Account No</label></td>
                            <td style = "width:70%;">${accountsPayableInstance.acctNo}</td>    
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
                            <td><label>Date Created</label></td>
                            <td><g:formatDate  format="MM/dd/yyyy" date="${accountsPayableInstance.apCreatedDate}" /></td>    
                        </tr>
                        <tr>
                            <td><label>Balance</label></td>
                            <td><g:formatNumber format="###,###,##0.00" number="${accountsPayableInstance.balance}"/></td>    
                        </tr> 
                    </tbody>
                </table>
            </div>
            <div class="panel panel-default">
                <div class = "panel-heading">
                    <h4>Transaction Details</h4>
                </div>
                <div class="panel-body">
                <div class="table-responsive">
                    <table class="table table-bordered table-rounded table-striped table-hover">
                        <thead>
                            <tr>
				<g:sortableColumn property="refDate" title="${message(code: 'accountsPayableLedger.refDate.label', default: 'Ref Date')}" />
				<g:sortableColumn property="valueDate" title="${message(code: 'accountsPayableLedger.valueDate.label', default: 'Value Date')}" />
                                <g:sortableColumn property="reference" title="${message(code: 'accountsPayableLedger.reference.date', default: 'References')}" />
				<g:sortableColumn property="particulars" title="${message(code: 'accountsPayableLedger.particulars.label', default: 'Particulars')}" />
				<g:sortableColumn property="debit" title="${message(code: 'accountsPayableLedger.debit.label', default: 'Debit Amount')}" />
				<g:sortableColumn property="credit" title="${message(code: 'accountsPayableLedger.credit.label', default: 'Credit Amount')}" />
				<g:sortableColumn property="balance" title="${message(code: 'accountsPayableLedger.balance.label', default: 'Balance Amount')}" />
                            </tr>
			</thead>
			<tbody>
                            <g:each in="${AccountsPayableLedger.findAllByAccountsPayable(accountsPayableInstance,[sort: "id", order: "asc"])}" status="i" var="accountsPayableLedgerInstance">
                                <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
                                    <td><g:formatDate format="MM/dd/yyyy" date="${accountsPayableLedgerInstance?.refDate}"/></td>
                                    <td><g:formatDate format="MM/dd/yyyy" date="${accountsPayableLedgerInstance?.valueDate}"/></td>
                                    <td>${accountsPayableLedgerInstance?.reference}</td>
                                    <td>${accountsPayableLedgerInstance?.particulars}</td>
                                    <g:if test="${accountsPayableLedgerInstance?.debit == 0}">
                                        <td></td>
                                    </g:if> 
                                    <g:else>    
                                    <td align = "right"><g:formatNumber format="###,###,##0.00" number="${accountsPayableLedgerInstance?.debit}"/></td>
                                    </g:else>
                                    <g:if test="${accountsPayableLedgerInstance?.credit == 0}">
                                        <td></td>
                                    </g:if> 
                                    <g:else>   
                                    <td align = "right"><g:formatNumber format="###,###,##0.00" number="${accountsPayableLedgerInstance?.credit}"/></td>
                                    </g:else>   
                                    <td align = "right"><g:formatNumber format="###,###,##0.00" number="${accountsPayableLedgerInstance?.balance}"/></td>
				</tr>
                            </g:each>
			</tbody>
                    </table>
                </div>
                </div>
            </div>
		<div class="pagination">
                    <g:paginate total="${accountsPayableLedgerInstanceCount ?: 0}" params="${params}" />
		</div>
        </content>	

        <content tag="main-actions">
            <ul>
                <li><g:link action="edit" controller="accountsPayable" id="${accountsPayableInstance.id}" >Edit</g:link></li>
                <li><g:link action="show" controller="accountsPayable" id="${accountsPayableInstance.id}" >View Details</g:link></li>
                <li><g:link action="index" controller="accountsPayable" id="${accountsPayableInstance.id}">Accounts Payable List</g:link></li>
            </ul>
        </content>
    </body>
</html>
