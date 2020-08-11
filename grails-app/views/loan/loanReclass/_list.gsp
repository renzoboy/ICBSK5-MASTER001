<%@ page import="icbs.loans.LoanReClassHist" %>
<legend>Account Reclass History</legend>
<div class="panel panel-default">
    <div class = "panel-heading">
        <h4>Transaction Details</h4>
    </div>
    <div class="panel-body">
    <div class="table-responsive">
         <table class="table table-bordered table-rounded table-striped table-hover" id="tblReclass">
            <thead>
                <tr>
                    <g:sortableColumn property="reclassDate" title="${message(code: 'LoanReClassHist.reclassDate.label', default: 'Action Date')}" />
                    <g:sortableColumn property="oldClass" title="${message(code: 'LoanReClassHist.oldClass.date', default: 'From (Old Classification)')}" />
                    <g:sortableColumn property="newClass" title="${message(code: 'LoanReClassHist.newClass.label', default: 'To (New Classification)')}" />
                    <g:sortableColumn property="txnFile" title="${message(code: 'LoanReClassHist.txnFile.label', default: 'Txn Id')}" />
                    <g:sortableColumn property="reclassDesc" title="${message(code: 'LoanReClassHist.reclassDesc.label', default: 'Re Class Desc')}" />
                </tr>
            </thead>
            <tbody>
                <g:each in="${LoanReClassHist.findAllByLoanAcct(loanInstance,[sort: "id", order: "asc"])}" status="i" var="LoanReClassHistInstance">
                    <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
                        <td><g:formatDate format="MM/dd/yyyy" date="${LoanReClassHistInstance?.reclassDate}"/></td>
                        <td>${LoanReClassHistInstance?.oldClass}</td>
                        <td>${LoanReClassHistInstance?.newClass}</td>
                        <td>${LoanReClassHistInstance?.txnFile?.id}</td>
                        <td>${LoanReClassHistInstance?.reclassDesc}</td>
                    </tr>
                </g:each>
            </tbody>
        </table> 
    </div>
    </div>
</div>