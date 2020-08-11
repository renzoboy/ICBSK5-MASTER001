<%@ page import="icbs.loans.LoanRestructureHist" %>

<legend>Account Restructure History</legend>

<div class="table-responsive">
    <table class="table table-hover table-condensed table-bordered table-striped">
        <tbody>
            <tr>
                <td><label>ID</label></td>
                <td><label>Date Restructured </label></td>
                <td><label>Amount Restructured </label></td>
                <td><label>Status</label></td>
                <td><label>Restructured By</label></td>
            </tr>
        </tbody>
        <tbody>
         <g:each in="${LoanRestructureHist.findAllByLoan(loanInstance).sort{it.id}}" var="restructureHist">
                <tr>
                        <td>${restructureHist?.id}</td>
                        <td><g:formatDate format="MM/dd/yyyy" date="${restructureHist?.restructuredDate}"/></td>
                        <td><g:formatNumber format="###,###,##0.00" number="${restructureHist?.amount}"/></td>
                        <td>${restructureHist?.status?.description}</td>
                        <td>${restructureHist?.restructuredBy?.username}</td>   
                </tr>
        </g:each> 
        </tbody>
    </table>
</div>
			