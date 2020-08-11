<%@ page import="icbs.tellering.TxnCOCI" %>
<%@ page import="icbs.lov.CheckStatus" %>
<g:if test="${flash.message}">
    <script>
         $(function(){
            notify.message("${flash.message}");
        });
    </script>
</g:if>
<table class="table table-hover table-condensed table-bordered table-striped" id="tblcoci">
    <thead>
        <tr>
            <g:sortableColumn property="bank" title="${message(code: 'TxnCOCI.bank.label', default: 'Clearing Bank')}" />
            <g:sortableColumn property="checkNo" title="${message(code: 'TxnCOCI.checkNo.label', default: 'Check Number')}" />
            <g:sortableColumn property="checkAcctName" title="${message(code: 'TxnCOCI.checkAcctName.label', default: 'Check Account Name')}" />
            <g:sortableColumn property="checkAmt" title="${message(code: 'TxnCOCI.checkAmt.label', default: 'Check Amount')}" />
            <g:sortableColumn property="clearingDate" title="${message(code: 'TxnCOCI.clearingDate.label', default: 'Clearing Date')}" />
            <g:sortableColumn property="checkStatus" title="${message(code: 'TxnCOCI.clearingDate.label', default: 'Check Status')}" />
            <td>Actions</td>
        </tr>
    </thead>
    <tbody>
        <g:each in="${TxnCOCI.findAllByDepAcctAndCheckStatusNotEqual(depositInstance,icbs.lov.CheckStatus.get(5),[sort: "id", order: "asc"])}" status="i" var="txnCociInstance">
            <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
                <td>${txnCociInstance?.bank?.name}</td>
                <td>${txnCociInstance?.checkNo}</td>
                <td>${txnCociInstance?.checkAcctName}</td>
                <td align = "right"><g:formatNumber format="###,###,##0.00" number="${txnCociInstance?.checkAmt}"/></td>
                <td><g:formatDate format="MM/dd/yyyy" date="${txnCociInstance?.clearingDate}"/></td>
                <td>${txnCociInstance?.checkStatus.description}</td>
                <td><g:link class="btn btn-secondary" action="viewUnclearedDeposit" id="${txnCociInstance.id}">View</g:link></td>
            </tr>
        </g:each>  
    </tbody>
</table>    
<div class="pagination">
       <g:paginate total="${txnCociInstanceCount ?: 0}" params="${params}" />
</div>

