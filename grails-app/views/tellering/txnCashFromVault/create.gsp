<%@ page contentType="text/html;charset=UTF-8" %>


<!DOCTYPE html>

<html>
    <head>  
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="layout" content="main">
        <title>Cash from Vault Transaction</title>

        <!-- Page specific CSS and JS -->
        <link rel="stylesheet" href="${resource(dir: 'css', file: 'cashfromvault.css')}" type="text/css">
        <script type="text/javascript">
            var c;
        </script>
       
        
        <g:javascript>
            function add_commas(number){
                number = '' + number;
                if (number.length > 3) {
                        var mod = number.length % 3;
                        var output = (mod > 0 ? (number.substring(0,mod)) : '');
                        for (i=0 ; i < Math.floor(number.length / 3); i++) {
                                if ((mod == 0) && (i == 0))
                                        output += number.substring(mod+ 3 * i, mod + 3 * i + 3);
                                else
                                        output+= ',' + number.substring(mod + 3 * i, mod + 3 * i + 3);
                        }
                        return (output);
                }
                else return number;
            }
            
            
           
        </g:javascript>
    </head>
    
    <body>
        <content tag="breadcrumbs">
            <span class="fa fa-chevron-right"></span><span class="current">Cash From Vault Transaction</span>
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
                        </div>   
                </div>
            </g:if>      
            <g:hasErrors bean="${txnCashFromVaultInstance}">
               <g:eachError bean="${txnCashTransferInstance}" var="error">
                <script>
                    $(function(){
                        var x = '${it}';
                        notify.error(x);
                       // console.log(x)
                       // setTimeout(function(){ notify.success(x); }, 3000);
                    });
                </script>
                </g:eachError>
                <div id= "addCustomerRelatedError" class="box-body">
<!--                    <div class="alert alert-danger alert-dismissable">
                        <i class="fa fa-ban"></i>
                        <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                        <b>Alert!</b> 
                        <ul class="errors" role="alert">
                            <div id="errorList">
                            </div>
                            <g:eachError bean="${txnCashFromVaultInstance}" var="error">
                                <li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
                            </g:eachError>
                        </ul>            
                    </div>-->
                </div>
            </g:hasErrors>
            <g:form name="txnCashFromVaultForm" action="saveTellerCashFromVaultTxn" controller="tellering" onsubmit="callLoadingDialog();" >
                <g:render template='txnCashFromVault/form' model="[txnCashFromVaultInstance:txnCashFromVaultInstance]"/>
            </g:form>
        </content>
        <!--Grails tag for jasper plugin-->
         <g:jasperReport action="printSLIP"  controller="tellering" format="PDF" name="TRANSACTION"  jasper="SLIP">
         </g:jasperReport>
        
        <content tag="main-actions">
            <ul>
                <li><a id="save" class="save" onclick="
                    
                    console.log('hahaha'+$('#txnAmt').val());
                    if($('#txnAmt').val()==''){
                        notify.message('Total Cash Received Cannot be null!|error|alert'); 
                        return;
                    }
                    var txnAmt = accounting.unformat($('#txnAmt').val()),
                    txnTotal = accounting.unformat($('#total').val());
                    
                   // console.log(txnAmt);
                   // console.log(txnTotal);
                   // return;
                    
                    if(!$('#txnTemplate').val())
                    {
                        notify.message('Transaction type required!|error|alert'); 
                        return;
                    }
                    if(txnAmt != txnTotal)
                    {
                        console.log(c);
                        notify.message('Unable to continue, Breakdown Total and Total Cash is not equal!|error|alert'); 
                        return;
                    } 
                    if(!$('#txnRef').val())
                    {
                        notify.message('Transaction Reference required!|error|alert'); 
                        return;
                    }
                   
                    
                    alertify.confirm(AppTitle,'Are you sure you want to create this transaction?',
                    function(){
                        //jQuery('#txnCashFromVaultForm').submit();
                        checkIfAllowed($('#txnTemplate option:selected').data('code'), 'form#txnCashFromVaultForm', 'CashFromVaultOverride', txnAmt);
                    },
                    function(){
                        return;
                    });">${message(code: 'default.button.create.label', default: 'Create')}</a></li>
                <li><g:link action="index" onclick="return confirm('Are you sure you want to return to the Tellering Index page?');">Tellering Index</g:link></li>
            </ul>                                        
        </content>
    </body>
</html>
