<%@ page import="icbs.gl.AssetsHeldToMaturity" %>
<%@ page import="icbs.gl.AssetsHeldToMaturityLedger" %>
<%@ page import="icbs.gl.GlAccount" %>
<!DOCTYPE html>
<html>
    <head>
	<meta name="layout" content="main">
	<title>Assets Held To Maturity Ledger Transactions</title>
    </head>
    <body>
        <content tag="breadcrumbs">
            <span class="fa fa-chevron-right"></span><a href="${createLink(uri: '/accountsReceivable')}">Assets Held To Maturity</a>
            <span class="fa fa-chevron-right"></span><span class="current">Assets Held To Maturity Information</span>
        </content>
        <content tag="main-content">
            
            <div class="panel panel-default">
                <div class="panel panel-default">
                    <div class="content scaffold-show" role="main">
                    <g:if test="${flash.message}">
                        <div class="box-body">
                            <div class="alert alert-info alert-dismissable">
                                <i class="fa fa-info"></i>
                                <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                                <b>Message</b> <div class="message" role="status">${flash.message}</div>
                            </div>
                        </div>
                    </g:if>
                    <div class="panel-body">
                        <table class="table table-bordered table-rounded table-striped table-hover">
                            <tbody>
                                <tr>
                                    <td style = "width:30%;"><label>Branch</label></td>
                                    <td style = "width:70%;">${htmVmtInstance?.branch?.name}</td>    
                                </tr>
                                <tr>
                                    <td><label>HTM Description</label></td>
                                    <td>${htmVmtInstance.htmDescription}</td>    
                                </tr> 
                                
                                <tr>
                                    <td><label>HTM Amount</label></td>
                                    <td><g:formatNumber format="###,###,##0.00" number="${htmVmtInstance.amount}"/></td>    
                                </tr>
                                <tr>
                                    <td><label>GL Code</label></td>
                                    <td>${htmVmtInstance.glCode}</td>    
                                </tr> 
                                <tr>
                                    <td><label>GL Description</label></td>
                                    <td>${GlAccount.findByCode(htmVmtInstance?.glCode).name}</td>    
                                </tr>
                                 <tr>
                                    <td><label>Created Date</label></td> 
                                    <td><g:formatDate  format="MM/dd/yyyy" date="${htmVmtInstance?.createdDate}" /></td>  
                                </tr>
                            </tbody>
                        </table>
                    </div>
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
				<g:sortableColumn property="refDate" title="${message(code: 'AssetsHeldToMaturityLedger.refDate.label', default: 'Ref Date')}" />
				<g:sortableColumn property="valueDate" title="${message(code: 'AssetsHeldToMaturityLedger.valueDate.label', default: 'Value Date')}" />
                                <g:sortableColumn property="reference" title="${message(code: 'AssetsHeldToMaturityLedger.reference.date', default: 'References')}" />
				<g:sortableColumn property="particulars" title="${message(code: 'AssetsHeldToMaturityLedger.particulars.label', default: 'Particulars')}" />
				<g:sortableColumn property="debit" title="${message(code: 'AssetsHeldToMaturityLedger.debit.label', default: 'Debit Amount')}" />
				<g:sortableColumn property="credit" title="${message(code: 'AssetsHeldToMaturityLedger.credit.label', default: 'Credit Amount')}" />
				<g:sortableColumn property="balance" title="${message(code: 'AssetsHeldToMaturityLedger.balance.label', default: 'Balance Amount')}" />
                            </tr>
			</thead>
			<tbody>
                            <g:each in="${htmLedgerInstance}" status="i" var="assetsHtmLedgerInstance">
                                <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
                                    <td><g:formatDate format="MM/dd/yyyy" date="${assetsHtmLedgerInstance?.refDate}"/></td>
                                    <td><g:formatDate format="MM/dd/yyyy" date="${assetsHtmLedgerInstance?.valueDate}"/></td>
                                    <td>${assetsHtmLedgerInstance?.reference}</td>
                                    <td>${assetsHtmLedgerInstance?.particulars}</td>
                                    <g:if test="${assetsHtmLedgerInstance?.debit == 0}">
                                        <td></td>
                                    </g:if> 
                                    <g:else>    
                                    <td align = "right"><g:formatNumber format="###,###,##0.00" number="${assetsHtmLedgerInstance?.debit}"/></td>
                                    </g:else>
                                    <g:if test="${assetsHtmLedgerInstance?.credit == 0}">
                                        <td></td>
                                    </g:if> 
                                    <g:else>   
                                    <td align = "right"><g:formatNumber format="###,###,##0.00" number="${assetsHtmLedgerInstance?.credit}"/></td>
                                    </g:else>   
                                    <td align = "right"><g:formatNumber format="###,###,##0.00" number="${assetsHtmLedgerInstance?.balance}"/></td>
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
                <li><g:link action="show" id="${htmVmtInstance?.id}" >View Account Details</g:link></li>
                <li><g:link action="index" controller="assetsHtm" id="${htmInstance?.id}">Asset HTM List</g:link></li>
            </ul>
        </content>
    </body>
</html>
