<%@ page import="icbs.gl.CashInBank" %>
<!DOCTYPE html>
<html>
    <head>
	<meta name="layout" content="main">
	<title>Cash in Bank Subsidiary Ledger - Cancel Check Voucher</title>
    </head>
    <body>
        <content tag="breadcrumbs">
                <span class="fa fa-chevron-right"></span><a href="${createLink(uri: '/cashInBank')}">Cash in Bank/Due From Bank Subsidiary Ledger</a>
                <span class="fa fa-chevron-right"></span><span class="current">Cash in Bank Subsidiary Ledger Debit Transactions</span>
        </content>
        <content tag="main-content">
            <div class="panel panel-default">
            <g:render template="cashInBankDetails"/>
            </div>
            <div class="panel panel-default">
                <div class = "panel-heading">
                    <h4>Transaction Details</h4>
                </div>
                    <div class="panel-body">
                        <g:form id="deposit" url="[resource:cashInBankInstance, action:'saveCancelChk']" method="PUT" >
                            <fieldset class="form">
                                <div class="fieldcontain form-group ${hasErrors(bean: cashInBankCheckbookInstance, field: 'checkNo', 'has-error')} required">
                                    <label class="control-label col-sm-4" for="checkNo">Check Number<span class="required-indicator">*</span></label>
                                    <div class="col-sm-8"><g:textField name="checkNo" id="checkNo" maxlength="25" required="" readonly="readonly" value="${cashInBankCheckbookInstance?.checkNo}"class="form-control"/>
                                    </div>
                                </div>

                                <div class="fieldcontain form-group ${hasErrors(bean: cashInBankCheckbookInstance, field: 'reference', 'has-error')} required">
                                    <label class="control-label col-sm-4" for="reference">Reference<span class="required-indicator">*</span></label>
                                    <div class="col-sm-8"><g:textField name="reference" maxlength="50" required="" readonly="readonly" value="${cashInBankCheckbookInstance?.reference}"class="form-control"/>
                                    </div>             
                                </div>
                                <div class="fieldcontain form-group ${hasErrors(bean: cashInBankCheckbookInstance, field: 'checkVoucherNo', 'has-error')} required">
                                    <label class="control-label col-sm-4" for="checkVoucherNo">Check Voucher No.</label>
                                    <div class="col-sm-8"><g:textField name="checkVoucherNo" id="checkVoucherNo" maxlength="50" required="" readonly="readonly" value="${cashInBankCheckbookInstance?.checkVoucherNo}"class="form-control"/>
                                    </div>             
                                </div>
                                <div class="fieldcontain form-group ${hasErrors(bean: cashInBankCheckbookInstance, field: 'checkAmt', 'has-error')} required">
                                    <label class="control-label col-sm-4" for="checkAmt">Check Amount<span class="required-indicator">*</span>
                                    </label>
                                    <div class="col-sm-8">
                                        <g:field class="form-control truncated"  name="checkAmt" readonly="readonly" value="${cashInBankCheckbookInstance?.checkAmt}" />

                                    </div>             
                                </div>
                                <g:hiddenField id="cashInBankCheckbookInstance" name="cashInBankCheckbookInstance" value="${cashInBankCheckbookInstance.id}" />
                            </fieldset>
                        </g:form>  
                    </div>
            </div>
        </content>	

        <content tag="main-actions">
            <ul>
                <li><g:actionSubmit class="save" id="saveCancelChk" name="saveCancelChk" action="saveCancelChk" value="${message(code: 'default.button.Save.label', default: 'Save')}" onclick="
                        alertify.confirm(AppTitle,'Are you sure you want to continue this transaction?',
                                function(){
                                     checkIfAllowed('CFG00303', 'form#deposit', 'Override edit cash in bank.', null); 
                                },
                                function(){
                                    return;
                                });                      
                    "/></li>
                <li><g:link action="show" id="${cashInBankInstance.id}">Cancel</g:link></li>            
            </ul>
        </content>
    </body>
</html>
