<%@ page contentType="text/html;charset=UTF-8" %>


<!DOCTYPE html>

<html>
    <head>  
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="layout" content="main">
        <title>Other Cash Payment Transaction - Remittance</title>      

        <script type="text/javascript" src="${resource(dir: 'js', file: 'customerSearch.js')}"></script>
        <asset:javascript src="telleringHelper.js"/>

        <g:javascript>
            function updateVar(){
                var amount = parseFloat($('#txnAmt').val().replace(',', ''));
                if (isNaN(amount))
                    amount = 0;
                $('#OtherCashPaymentRemit').val(amount);
            }
            function initializeCustomerDetailsSearchModal(div){
                field = 'sender';
                if(div == 'txnBeneficiaryDetailsDiv') {
                    field = 'beneficiary';
                }
                
                $('#txnIdent').val(field);
                modal = new icbs.UI.Modal({id:"customerDetailsModal",url:"${createLink(controller : 'search', action:'search')}",title:"Search Customer",onCloseCallback:updateCustomerDetailsForm, onCloseCallbackParams: {div: div, field: field}});
            }
            function updateCustomerDetailsForm(params){
                icbs.Tellering.Form.getForm(params.div,"${createLink(controller : 'tellering', action:'showCustomerDetailsAjax')}", params);
            }
        </g:javascript>  
    </head>
    
    <body>
        <content tag="breadcrumbs">
            <span class="fa fa-chevron-right"></span><span class="current">Other Cash Payment Transaction - Remittance</span>
        </content>
        <content tag="main-content">
            <g:if test="${flash.message}">
                    <script>
                            $(function(){
                                var x = '${flash.message}';
                                    notify.message(x);
                                    $('#SlipTransaction').hide();
                                    if(x.indexOf('|success') > -1){
                                    $('#SlipTransaction').show();
                                }
                               // console.log(x)
                               // setTimeout(function(){ notify.success(x); }, 3000);
                            });
                    </script>
                    <div id="SlipTransaction" class="alert alert-success alert-dismissable" role="alert">
                        <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                            <div> 
                                <a onclick="
                                         var w = window.open('printValidationSlip', '_blank')
                                             w.print();
                                         ">
                                     <g:img dir="images" file="validate.png" width="35" height="35"/>
                                     Validation Slip
                                </a>
                                &nbsp;&nbsp;
                                <a onclick="
                                        var w = window.open('printTransactionSlip', '_blank')
                                            w.print();
                                        ">
                                     <g:img dir="images" file="transactionslip.png" width="35" height="35"/>
                                     Transaction Slip 
                                </a>
                            </div>   
                    </div>
            </g:if>
            <g:hasErrors bean="${txnCashPaymentRemittanceInstance}">
                    <script>
                        $(function(){
                            var x = '${it}';
                            notify.error(x);
                           // console.log(x)
                           // setTimeout(function(){ notify.success(x); }, 3000);
                        });
                    </script> 
<!--            <div id= "addCustomerRelatedError" class="box-body">
                    <div class="alert alert-danger alert-dismissable">
                        <i class="fa fa-ban"></i>
                        <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                        <b>Alert!</b> 
                        <ul class="errors" role="alert">
                            <div id="errorList">
                            </div>
                            <g:eachError bean="${txnCashPaymentRemittanceInstance}" var="error">
                                <li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
                            </g:eachError>
                        </ul>            
                    </div>
                </div>-->
            </g:hasErrors>
            <g:form name="txnCashPaymentRemittanceForm" action="saveTellerOtherCashPaymentRemittanceTxn" controller="tellering" onsubmit="callLoadingDialog();" >
                <g:render template='txnCashPaymentRemittance/form' model="[txnCashPaymentRemittanceInstance:txnCashPaymentRemittanceInstance]"/>
            </g:form>
 
        </content>
         <!--Grails tag for jasper plugin-->
         <g:jasperReport action="printSLIP"  controller="tellering" format="PDF" name="TRANSACTION"  jasper="SLIP">
         </g:jasperReport>
        <content tag="main-actions">
            <ul>
                <li><a class="save" onclick="
                        var chkAmt = accounting.unformat($('#OtherCashPaymentRemit').val());
                        if(!$('#txnTemplate').val()){
                            notify.message('Transaction type required!|error|alert');return;   
                        }
                        if(!$('#txnDepIDSender').val()){
                            notify.message('Sender required!|error|alert');return;   
                        }
                        if(!$('#txnDepIDBenef').val()){
                            notify.message('Beneficiary required!|error|alert');return;   
                        }
                        if($('#OtherCashPaymentRemit').val() == 0)
                        {
                            notify.message('Remittance amount required!|error|alert');return; 
                        } 
                        if($('#OtherCashPaymentRemit').val() < 0)
                        {
                            notify.message('Remittance amount must be greater than 0!|error|alert');return; 
                        }
                        if(!$('#controlNo').val()){
                            notify.message('Control number required!|error|alert');return;   
                        }
                        if(!$('#txnParticulars').val()){
                            notify.message('Particulars required!|error|alert');return;   
                        }
                        totalcash = +totalcash.toFixed(2);
                        chkAmt = +chkAmt.toFixed(2);                        
                        if(totalcash < chkAmt)
                        {
                            notify.message('Unable to continue transaction. Not enough cash on hand!|error|alert');return;   
                        }
                        if(!$('#txnRef').val()){
                            notify.message('Payout instructions required!|error|alert');return;   
                        }
                        else{
                            alertify.confirm(AppTitle,'Are you sure you want to continue this transaction?',
                            function(){
                                //jQuery('#txnCashPaymentRemittanceForm').submit();
                                checkIfAllowed($('#txnTemplate').val(), 'form#txnCashPaymentRemittanceForm', 'txnCashPaymentRemittanceOverride', $('#OtherCashPaymentRemit').val());
                            },
                            function(){
                                return;
                            });
                        }">${message(code: 'default.button.create.label', default: 'Create')}</a></li>
                <li><g:link action="index" >Tellering Index</g:link></li>
            </ul>                                        
        </content>
    </body>
</html>
