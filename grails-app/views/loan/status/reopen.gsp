<%@ page import="icbs.loans.Loan" %>
<!DOCTYPE html>
<html>
    <head>
	<meta name="layout" content="main">
	<g:set var="entityName" value="${message(code: 'loan.label', default: 'Loan')}" />
	<title>Re-Open Closed Loan Account</title>
    </head>
    <body>
        <content tag="main-content">   
            <div id="show-special" class="content scaffold-show" role="main">
		<g:if test="${flash.message}">
                    <div class="box-body">
                        <div class="alert alert-info alert-dismissable">
                            <i class="fa fa-info"></i>
                            <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                            <b>Message</b> <div class="message" role="status">${flash.message}</div>
                        </div>
                    </div>
                </g:if>	
            </div>
            <table class="table table-bordered table-striped">
                <legend>Loan Details</legend>
                <tr>
                    <td style="font-weight:bold" width="30%">PN No.</td>
                    <td width="70%"><span>${loanInstance?.pnNo}</span></td>
                </tr>
                <tr>
                    <td style="font-weight:bold" width="30%">Account No.</td>
                    <td width="70%"><span>${loanInstance?.accountNo}</span></td>
                </tr>
                <tr>
                    <td style="font-weight:bold" width="30%">Borrower Name</td>
                    <td width="70%"><span>${loanInstance?.customer?.displayName}</span></td>
                </tr>                
                <tr>
                    <td style="font-weight:bold" width="30%">Branch</td>
                    <td width="70%"><span><g:link controller="branch" action="show" id="${loanInstance?.branch?.id}">${loanInstance?.branch?.name}</g:link></span></td>
                </tr>    
                <tr>
                    <td style="font-weight:bold" width="30%">Granted Amount</td>
                    <td width="70%"><span><g:formatNumber format="###,###,##0.00" number="${loanInstance?.grantedAmount}"/></span></td>
                </tr>
                <tr>
                    <td style="font-weight:bold" width="30%">Interest Rate</td>
                    <td width="70%"><span><g:formatNumber format="###,###,##0.00" number="${loanInstance?.interestRate}"/> %</span></td>
                </tr>
                <g:if test="${loanInstance?.interestIncomeScheme?.installmentCalcType?.id == 1}">
                    <tr>
                        <td style="font-weight:bold" width="30%">Term</td>
                        <td width="70%"><span>${loanInstance?.term}</span></td>
                    </tr>     
                </g:if>
                <g:else>
                    <tr>
                        <td style="font-weight:bold" width="30%">Frequency</td>
                        <td width="70%"><span>${loanInstance?.frequency?.description}</span></td>
                    </tr>
                    <tr>
                        <td style="font-weight:bold" width="30%">No. of Installments</td>
                        <td width="70%"><span>${loanInstance?.numInstallments}</span></td>
                    </tr>
                </g:else>
                <tr>
                    <td style="font-weight:bold" width="30%">Opening Date</td>
                    <td width="70%"><span><g:formatDate format="MM/dd/yyyy" date="${loanInstance?.openingDate}"/></span></td>
                </tr>                
                <tr>
                    <td style="font-weight:bold" width="30%">Maturity Date</td>
                    <td width="70%"><span><g:formatDate format="MM/dd/yyyy" date="${loanInstance?.maturityDate}"/></span></td>
                </tr>                
                <tr>
                    <td style="font-weight:bold" width="30%">Status</td>
                    <td width="70%"><span>${loanInstance?.status?.description}</span></td>
                </tr>
            </table>
            <g:form id="loan-form" url="[resource:loanInstance, action:'saveReopen']" method="PUT" 
                       onsubmit="return alertify.alert('Please wait... Processing....')">   
                <g:hiddenField name="activity" value="Amendment" />
            </g:form>
        </content>
        <content tag="main-actions">
            <ul>            	
                <li><g:submitButton id="save" name="save" value="Save" onclick="callsendAlertify();"/></li>
                <script>
                    function callsendAlertify(){
                        alertify.confirm(AppTitle,'Are you sure you want to Reopen this loan?',
                                function(){
                                    // params: policyTemplate.code, form to be saved
                                    checkIfAllowed('LON01100', 'form#loan-form', 'Reopen loan', null);
                                },
                                function(){
                                    return;
                                });                     
                    }
                </script>
                <li><g:link action="show" id="${loanInstance.id}">View Loan Account</g:link></li>                
            </ul>			
        </content>
    </body>
</html>