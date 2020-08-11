<%@ page import="icbs.loans.ROPA" %>
<%@ page import="icbs.loans.ROPALedger" %>
<!DOCTYPE html>
<html>
    <head>
	<meta name="layout" content="main">
	<title>ROPA Ledger Transactions</title>
    </head>
    <body>
        <content tag="breadcrumbs">
            <span class="fa fa-chevron-right"></span><a href="${createLink(uri: '/ropa')}">Real and Other Properties Acquired (ROPA)</a>
            <span class="fa fa-chevron-right"></span><span class="current">ROPA Ledger Transactions</span>
        </content>
        <content tag="main-content">
            <div class="panel panel-default">
                <div class="panel panel-default">
                    
                    <div class="panel-body">
                        <table class="table table-bordered table-rounded table-striped table-hover">
                        <tbody>
                            <tr>
                                <td style="width:30%"><label>Branch</label></td>
                                <td style="width:70%">${moretramnsactionInstance?.branch?.name}</td> 
                            </tr>    
                            <tr>
                                <td style="width:30%"><label>ROPA Date</label></td>
                                <td style="width:70%"><g:formatDate  format="MM/dd/yyyy" date="${ moretramnsactionInstance?.ropaDate}" /></td> 
                            </tr>
                            <tr>
                                <td ><label>Loan Balance</label></td>
                                <td><g:formatNumber format="###,###,##0.00" number="${ moretramnsactionInstance?.loanBalance}"/></td>   
                            </tr>
                        </tbody>
                    </table>
                    </div>
                
            </div>
            </div>
            <div class="panel panel-default">
                <div class = "panel-heading">
                    <h4>Transaction Details</h4>
                </div>
                <div class="panel-body">
                <div class="table-responsive">
                     <table class="table table-bordered table-rounded table-striped table-hover" id="tblhtm">
                        <thead>
                            <tr>
				<g:sortableColumn property="txnDate" title="${message(code: 'ROPALedger.txnDate.label', default: 'Ref Date')}" />
				<g:sortableColumn property="valueDate" title="${message(code: 'ROPALedger.valueDate.label', default: 'Value Date')}" />
                                <g:sortableColumn property="reference" title="${message(code: 'ROPALedger.reference.date', default: 'References')}" />
				<g:sortableColumn property="particulars" title="${message(code: 'ROPALedger.particulars.label', default: 'Particulars')}" />
				<g:sortableColumn property="debitAmt" title="${message(code: 'ROPALedger.debitAmt.label', default: 'Debit Amount')}" />
				<g:sortableColumn property="creditAmt" title="${message(code: 'ROPALedger.creditAmt.label', default: 'Credit Amount')}" />
				<g:sortableColumn property="balanceAmt" title="${message(code: 'ROPALedger.balanceAmt.label', default: 'Balance Amount')}" />
                            </tr>
			</thead>
			<tbody>
                            <g:each in="${ROPALedger.findAllByRopa(moretramnsactionInstance)}" status="i" var="ropaLedgerInstance">
                                <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
                                    <td><g:formatDate format="MM/dd/yyyy" date="${ropaLedgerInstance?.txnDate}"/></td>
                                    <td><g:formatDate format="MM/dd/yyyy" date="${ropaLedgerInstance?.valueDate}"/></td>
                                    <td>${ropaLedgerInstance?.reference}</td>
                                    <td>${ropaLedgerInstance?.particulars}</td>
                                    <g:if test="${ropaLedgerInstance?.debitAmt == 0}">
                                        <td></td>
                                    </g:if> 
                                    <g:else>    
                                    <td align = "right"><g:formatNumber format="###,###,##0.00" number="${ropaLedgerInstance?.debitAmt}"/></td>
                                    </g:else>
                                    <g:if test="${ropaLedgerInstance?.creditAmt == 0}">
                                        <td></td>
                                    </g:if> 
                                    <g:else>   
                                    <td align = "right"><g:formatNumber format="###,###,##0.00" number="${ropaLedgerInstance?.creditAmt}"/></td>
                                    </g:else>   
                                    <td align = "right"><g:formatNumber format="###,###,##0.00" number="${ropaLedgerInstance?.balanceAmt}"/></td>
				</tr>
                            </g:each>
			</tbody>
                    </table> 
                </div>
                </div>
<!--                <div class="pagination">
                        <g:paginate total="${assetsHtmInstanceCount ?: 0}" params="${params}" />
                </div>-->
                        <script>
                        $(document).ready(function() {
                        $('#tblhtm').DataTable({
                          dom: 'Bfrtlip',
                         //dom : '<"wrapper"flipt>',

                            buttons: [
                                {
                                    extend: 'print',
                                    customize: function ( win ) {
                                        $(win.document.body)
                                            .css( 'font-size', '10pt' )
                                            .prepend(
                                                '<img src="icbs/assets/logo.png" style="position:absolute; top:0; left:0;" />'
                                            );

                                        $(win.document.body).find( 'table' )
                                            .addClass( 'compact' )
                                            .css( 'font-size', 'inherit' );
                                    }
                                }
                            ]   
                        });

                       $('.buttons-print').hide();
                    } );
                    </script>
            </div>
        </content>	
        <content tag="main-actions">
            <ul>
                 <li><g:link action="index" >ROPA List</g:link></li>
                 <li><g:link action="show" id="${moretramnsactionInstance?.id}" >Ropa Information</g:link></li>
            </ul>
        </content>
    </body>
</html>
