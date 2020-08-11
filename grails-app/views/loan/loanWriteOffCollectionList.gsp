<%@ page contentType="text/html;charset=UTF-8" %>

<html>
    <head>
        <title>Loan Write-Off Collections</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="layout" content="main">
    </head>
    <body>
        <content tag="breadcrumbs">
            <span class="fa fa-chevron-right"></span><span class="current">Loan Write Off Collections</span>
        </content>
        <content tag="main-content">
            <g:if test="${flash.message}">
                <script>
                     $(function(){
                        notify.message("${flash.message}");
                    });
                </script>
            </g:if>
            <%-- <g:form class="form-inline">
                    <div class="form-group">
                            <g:select name="max" value="${params.max}" from="[5, 10, 15, 20]" class="form-control input-sm pull-left"onchange="this.form.submit()" />
                    </div>
                    <div class="right">
                            <div class="form-group">
                                    <g:textField  type="text" name="query" class="form-control input-sm pull-right" style="width: 350px;" placeholder="Search"/>
                            </div>
                            <g:submitButton name="Search" class="btn btn-sm btn-default"><i class="fa fa-search"></i></g:submitButton>
                    </div>
            </g:form> --%>
            <table class="table table-hover table-condensed table-bordered table-striped">
                <thead>
                    <tr>
                        <g:sortableColumn property="branch" title="${message(code: 'SssOnlinePaymentDetail.brnum.label', default: 'Branch')}" />
                        <g:sortableColumn property="loan.accountNo" title="${message(code: 'SssOnlinePaymentDetail.brnum.label', default: 'Loan Account No ')}" />
                        <g:sortableColumn property="currency" title="${message(code: 'SssOnlinePaymentDetail.ername.label', default: 'Currency')}" />
                        <g:sortableColumn property="txnDescription" title="${message(code: 'SssOnlinePaymentDetail.indiEename.label', default: 'txnDescription')}" />
                        <g:sortableColumn property="txnAmount" title="${message(code: 'SssOnlinePaymentDetail.amount.label', default: 'Collection Amount')}" />
                        <g:sortableColumn property="txnDate" title="${message(code: 'SssOnlinePaymentDetail.amount.label', default: 'Collection Date')}" />
                        <td>Actions</td>
                    </tr>
                </thead>
                <tbody>
                    <g:each in="${loanWriteOffCollectionInstance}" status="i" var="writeOffCollectionInstance">
                        <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
                            <td>${writeOffCollectionInstance?.branch?.name}</td>
                            <td>${writeOffCollectionInstance?.loan.accountNo}</td>
                            <td>${writeOffCollectionInstance?.currency?.name}</td>
                            <td>${writeOffCollectionInstance.txnDescription}</td>
                            <td><g:formatNumber format="###,###,##0.00" number="${writeOffCollectionInstance?.txnAmount}"/></td>
                            <td><g:formatDate  format="MM/dd/yyyy" date="${writeOffCollectionInstance?.txnDate}" /></td>
                            <td><g:link class="btn btn-secondary" action="writeOffCollectionDetails" controller="loan" id="${writeOffCollectionInstance.id}">View More Details</g:link></td>
                        </tr>
                    </g:each>    
                </tbody>
            </table>    
            <div class="pagination">
                    <g:paginate total="${loanWriteOffCollectionInstance ?: 0}" params="${params}" />
            </div>
            
        </content>
        <content tag="main-actions">
            <ul>
                <li><g:link action="show" controller="loan" id="${loanWriteOffCollectionInstance?.loan.id}">Back to Loan Inquiry</g:link></li>
                
            </ul>                                        
        </content>    
  </body>
</html>
