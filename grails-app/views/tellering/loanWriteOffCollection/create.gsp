<%@ page contentType="text/html;charset=UTF-8" %>


<!DOCTYPE html>

<html>
    <head>  
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="layout" content="main">
        <title>Write off Collection Transaction</title>
        
        <script type="text/javascript" src="${resource(dir: 'js', file: 'customerSearch.js')}"></script>
        <asset:javascript src="telleringHelper.js"/>

        <g:javascript>
            function showLoanSearch() {				
                modal = new icbs.UI.Modal({id:"loanModal", url:"${createLink(controller: 'loan', action:'search')}", title:"Search Loan Account", onCloseCallback:updateLoanDetailsAjax});
                modal.show();
            }
            icbs.Dependencies.Ajax.addLoadEvent(function(){
                updateLoanDetailsAjax({loan2:"${loanLedgerInstance?.loan?.id}"});     		
            });
            function updateLoanDetailsAjax(params) {
                if (params.loan2) {
                    $('#loan').val(params.loan2);

                    $.ajax({
                        type: 'POST',
                        data: {id:params.loan2},
                        url: "${createLink(controller:'loan', action:'getLoanDetailsAjax')}",
                        success: function(msg){
                            console.log("################"+parseInt($(msg).find('#loan-status-id').html()));
                            if($(msg).find('#loan-status-id').html() == "8"){
                                if($(msg).find('#loan-balance-amt').html() != "0" || $(msg).find('#loan-overduePrincipal-amt').html() != "0"){
                                    //console.log(msg);
                                    $('#accountNo').val($(msg).find('#account-no').html());	
                                    $('#customer').html($(msg).find('#customer').html());
                                    $('#granted-amount').html($(msg).find('#granted-amount').html());
                                    $('#interest-rate').html($(msg).find('#interest-rate').html());
                                    $('#maturity-date').html($(msg).find('#maturity-date').html());
                                    $('#total-net-proceeds').html($(msg).find('#total-net-proceeds').html());
                                    $('#total-disbursement-amount').html($(msg).find('#total-disbursement-amount').html());
                                    $('#overdue-principal-balance').html($(msg).find('#overdue-principal-balance').html());
                                    $('#principal-balance').html($(msg).find('#principal-balance').html());
                                    $('#interest-balance').html($(msg).find('#interest-balance').html());
                                    $('#penalty-balance').html($(msg).find('#penalty-balance').html());
                                    $('#service-charge-balance').html($(msg).find('#service-charge-balance').html());
                                    $('#loan-status').html($(msg).find('#loan-status').html());
                                }else{
                                    alertify .alert(AppTitle,"Balance amount is zero", function(){
                                        location.reload();
                                    });
                                }
                                
                            }else{
                                alertify .alert(AppTitle,"Status not yet Write Off", function(){
                                    location.reload();
                                });
                            }
                        },
                        error:function(XMLHttpRequest,textStatus,errorThrown){
                            alert(XMLHttpRequest+textStatus+errorThrown);
                        }
                    });
                }
            }
            
        </g:javascript>           
    </head>
    
    <body>
        <content tag="breadcrumbs">
            
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
            <g:hasErrors bean="${txnLoanCashSpecifiedRepaymentInstance}">
                <script>
                    $(function(){
                        var x = '${it}';
                        notify.error(x);
                       // console.log(x)
                       // setTimeout(function(){ notify.success(x); }, 3000);
                    });
                </script>

            </g:hasErrors>
            <g:form id="writeOffCollectionFrm" name="writeOffCollectionFrm" url="[controller: 'tellering', action:'saveLoanWriteOffColletion']" onsubmit="callLoadingDialog();" method="POST" >
                <div>
                    <g:render template="/tellering/loanWriteOffCollection/form"/>
                </div>
            </g:form>
 
        </content>
        
         <!--Grails tag for jasper plugin-->
         <g:jasperReport action="printSLIP"  controller="tellering" format="PDF" name="TRANSACTION"  jasper="SLIP">
         </g:jasperReport>
        
        <content tag="main-actions">
            <script>
            function createnew(){
                var loanIds = $('#loan').val();
                var collectionType = $('#collectionType').val();
                var collectionAmt = $('#collectionAmt').val();
                var collectedBy = $('#collectedBy').val();
                var txnReference = $('#txnReference').val();
                var txnParticulars = $('#txnParticulars').val();
                console.log("loanIds: "+loanIds);
                console.log("collectionType: "+collectionType);
                console.log("collectionAmt: "+collectionAmt);
                console.log("collectedBy: "+collectedBy);
                console.log("txnReference: "+txnReference);
                console.log("txnParticulars: "+txnParticulars);
                if(loanIds == "" || loanIds == null || loanIds == "null"){
                    notify.message("Please Select Account |error|alert");
                }else if(collectionType == "" || collectionType == null || collectionType == "null"){
                    notify.message("Please Select Write Off Collection Type |error|alert");
                }else if(collectionAmt == "" || collectionAmt == null || collectionAmt == "null"){
                    notify.message("Please Input Write Off Collection Amount |error|alert");
                }else if(collectedBy == "" || collectedBy == null || collectedBy == "null"){
                    notify.message("Please Select Write Off Collector |error|alert");
                }else if(txnReference == "" || txnReference == null || txnReference == "null"){
                    notify.message("Please input for Transaction Reference |error|alert");
                }else if(txnParticulars == "" || txnParticulars == null || txnParticulars == "null"){
                    notify.message("Please input for Transaction Particulars |error|alert");
                }else{
                    if(parseFloat(collectionAmt.replace(/,/g, '')) < 0){
                         notify.message("Collection Amount cannot be less then zero |error|alert");
                    }else{
                        alertify.confirm(AppTitle,'Are you sure you want to continue this transaction?',
                        function(){
                           $('#writeOffCollectionFrm').submit();
                        },
                        function(){
                            return;
                        });
                    }
                } 
            }
            </script>
            <ul>
                <li><a class="save" onclick="createnew()">${message(code: 'default.button.create.label', default: 'Create')}</a></li>
                <li><g:link action="index" >Tellering Index</g:link></li>
            </ul>                                        
        </content>
    </body>
</html>
