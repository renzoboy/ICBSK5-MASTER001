<%@ page contentType="text/html;charset=UTF-8" %>


<!DOCTYPE html>

<html>
    <head>  
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="layout" content="main">
        <title>Other Cash Receipt Preferred Shares</title>
        
        <script type="text/javascript" src="${resource(dir: 'js', file: 'customerSearch.js')}"></script>
        <asset:javascript src="telleringHelper.js"/>
        
        <g:javascript>
            function updateVar(){
                var amount = parseFloat($('#txnAmt').val().replace(',', ''));
                if (isNaN(amount))
                    amount = 0;
                $('#CashReceiptBills').val(amount);
            }
            /*function initializeCustomerDetailsSearchModal(div){
                field = 'sender';
                if(div == 'txnBeneficiaryDetailsDiv') {
                    field = 'beneficiary';
                }
                modal = new icbs.UI.Modal({id:"customerDetailsModal",url:"${createLink(controller : 'search', action:'search')}",title:"Search Customer",onCloseCallback:updateCustomerDetailsForm, onCloseCallbackParams: {div: div, field: field}});
            }
            function updateCustomerDetailsForm(params){
                icbs.Tellering.Form.getForm(params.div,"${createLink(controller : 'tellering', action:'showCustomerDetailsAjax')}", params);
            }*/
            function updateCustomerInfoAjax(params) {	
            if (params.customer2) {
                $.ajax({
                    type: 'POST',
                    data: {id:params.customer2},
                    url: "${createLink(controller:'customer', action:'showBasicCustomerInfoAjax')}",
                    success: function(msg){
                        $('#customer-name').val($(msg).find('#display-name').html());
                        $('#customer-me').val($(msg).find('#display-name').html());
                        $('#customer').val(params.customer2);
                        $('#birth-date').html($(msg).find('#birth-date').html())
                        $('#address').html($(msg).find('#address').html())
                        $('#photo').html($(msg).find('#photo').html())
                        $('#total-released').html($(msg).find('#total-released').html())
                        $('#total-balance').html($(msg).find('#total-balance').html())
                        $('#total-count').html($(msg).find('#total-count').html())
                    },
                    error:function(XMLHttpRequest,textStatus,errorThrown){
                        alert(XMLHttpRequest+textStatus+errorThrown);
                    }
                });
            }
        }

        function showCustomerSearch() {
            modal = new icbs.UI.Modal({id:"customerDetailsModal", url:"${createLink(controller: 'search', action:'search')}", title:"Search Customer", onCloseCallback:updateCustomerInfoAjax});
            modal.show();                   
        }
        function showCustomerSearch() {
            modal = new icbs.UI.Modal({id:"customerDetailsModal", url:"${createLink(controller: 'search', action:'search')}", title:"Search Customer", onCloseCallback:updateCustomerInfoAjax});
            modal.show();                   
        }
        </g:javascript>           
    </head>
    
    <body>
        <content tag="breadcrumbs">
            <span class="fa fa-chevron-right"></span><span class="current">Other Cash Receipt Transaction - Bills Payment</span>
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
            
            <g:form name="txnBillsPaymentForm" action="saveTellerOtherCashReceiptBillsPaymentTxn" controller="tellering" onsubmit="callLoadingDialog();">
                <g:render template='txnBillsPayment/form' model="[txnBillsPaymentInstance:txnBillsPaymentInstance]"/>
            </g:form>
            <script>
                function validatePreferedSharedPayment(){
                    
                    var psptxnTemplate = $('#txnTemplate').val();
                    var psptxnAmt = $('#txnAmt').val();
                    var psptxnRef = $('#txnRef').val();
                    var psptxnParticulars = $('#txnParticulars').val();
                    var pspcustomer = $('#customer').val();
                    
                    if(pspcustomer == "" || pspcustomer == null || pspcustomer == "null"){
                        notify.message("Customer information is Required |error|alert");
                    }else if(psptxnTemplate == "" || psptxnTemplate == null || psptxnTemplate == "null"){
                        notify.message("Transaction Type is Required |error|alert");
                    }else if(psptxnAmt == "" || psptxnAmt == null || psptxnAmt == "null"){
                        notify.message("Transaction Amount is Required |error|alert");
                    }else if(psptxnRef == "" || psptxnRef == null || psptxnRef == "null"){
                        notify.message("Transaction Reference is Required |error|alert");
                    }else if(psptxnParticulars == "" || psptxnParticulars == null || psptxnParticulars == "null"){
                        notify.message("Transaction Particulars is Required |error|alert");
                    }else{
                        psptxnAmt = parseFloat(psptxnAmt.toString().replace(/,/g, ''));
                        if(psptxnAmt <= 0){
                            notify.message("Invalid Transaction Amount |error|alert");
                        }else{
                            alertify.confirm(AppTitle,'Are you sure you want to continue this transaction?',
                            function(){
                                //jQuery('#txnBillsPaymentForm').submit();
                                checkIfAllowed($('#txnTemplate option:selected').data('code'), 'form#txnBillsPaymentForm', 'BillsPaymentOverride', $('#CashReceiptBills').val());
                            },
                            function(){
                                return;
                            });
                        }
                        
                    }
                        
                }
            </script>    
        </content>
         <!--Grails tag for jasper plugin-->
         <g:jasperReport action="printSLIP"  controller="tellering" format="PDF" name="TRANSACTION"  jasper="SLIP">
         </g:jasperReport>
        <content tag="main-actions">
            <ul>
                <li><button onclick="validatePreferedSharedPayment();">Create</button></li>
                <li><g:link action="index">Tellering Index</g:link></li>
            </ul>                                        
        </content>
    </body>
</html>
