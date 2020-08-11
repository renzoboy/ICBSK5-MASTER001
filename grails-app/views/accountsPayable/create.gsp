<!DOCTYPE html>
<html>
    <head>
	<meta name="layout" content="main">
	<title>Create New Accounts Payable Subsidiary Ledger</title>
        <g:javascript>
        function updateCustomerInfoAjax(params) {	
            if (params.customer2) {
                $.ajax({
                    type: 'POST',
                    data: {id:params.customer2},
                    url: "${createLink(controller:'customer', action:'showBasicCustomerInfoAjax')}",
                    success: function(msg){
                        $('#customer-name').val($(msg).find('#display-name').html());
                        $('#payable').val($('#customer-name').val());
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
            <span class="fa fa-chevron-right"></span><a href="${createLink(uri: '/accountsPayable')}">Accounts Payable Subsidiary Ledger</a>
            <span class="fa fa-chevron-right"></span><span class="current">Create Accounts Payable Subsidiary Ledger</span>
        </content>
	<content tag="main-content">
            <div id="create-accountsPayable" class="content scaffold-create" role="main">
		<g:if test="${flash.message}">
                    <div class="message" role="status">${flash.message}</div>
		</g:if>
		<g:hasErrors bean="${accountsPayableInstance}">
                    <ul class="errors" role="alert">
			<g:eachError bean="${accountsPayableInstance}" var="error">
			<li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error.field} - ${error}"/></li>
			</g:eachError>
                    </ul>
		</g:hasErrors>
                
		<g:form id="create" url="[resource:accountsPayableInstance, action:'save']" onsubmit="callLoadingDialog();" >
                    <fieldset class="form">
			<g:render template="form"/>
                    </fieldset>
                    <g:javascript>
                        var onoff=""
                        function validateGlCode(){
                            var depcontra = $('#glContra').val();
                            var financialYear = $('#financialYear').val();
                            console.log("financialYear: "+financialYear);
                            if(depcontra==""){

                            }else{
                              //=================== AJAX FUNCTION to validate code if existing
                                var obj = { 
                                    depcontra: depcontra,
                                    financialYear: financialYear,
                                }; 
                                console.log(JSON.stringify(obj));
                                console.log("Object Loaded iwth data...");
                                $.ajax({
                                    type: "POST",
                                    contentType: "application/json",
                                    url: "${createLink(controller:'TxnTemplate', action:'validateExistingGlCodeAjax')}",
                                    data: JSON.stringify(obj),

                                    success: function(data){
                                        if(data.length >=1){
                                            onoff = ""
                                            //document.getElementById('gldescription').style.display = "block";
                                            $.each(data, function (_key, _value) {
                                                console.log(JSON.stringify(obj))
                                                console.log(_value.gl_code);
                                                console.log(_value.name);
                                                $('#gldescription').val(_value.name);

                                            });

                                        }else{
                                            onoff = "invalidGlCode";
                                            //document.getElementById('gldescription').style.display = "none";
                                            notify.message('Sorry, Invalid Gl Code!|error|alert');

                                        }
                                        console.log("onoff: "+onoff);


                                    },
                                    error: function(data){

                                    },

                                });                                            
                            }

                        }
                       
                        function updateBalance(){
                            $('#balance').val($('#existbalance').val());
                        }
                        function validateApCreate(){
                            updateBalance();
                            var apCustomer = $('#customer').val();
                            var apCurrency = $('#currency').val();
                            var apBalance = $('#balance').val();
                            var apGlContra = $('#glContra').val();
                            var apPayable = $('#payable').val();
                            var apParticulars = $('#particulars').val();
                            var apReference = $('#reference').val();
                            var apTxnTemplate = $('#txnType').val();
                            
                            if(apCustomer == "" || apCustomer == null || apCustomer == "null"){
                                notify.message("Please add/link customer information|error|alert");
                            }if(apTxnTemplate == "" || apTxnTemplate == null || apTxnTemplate=="null"){
                                notify.message("Please select transaction type|error|alert");
                            }else if(apCurrency == "" || apCurrency == null || apCurrency == "null"){
                                notify.message("Please select currency |error|alert");
                            }else if(apBalance == "" || apBalance == null || apBalance == "null"){
                                notify.message("field Balance cannot be empty|error|alert");
                            }else if(apGlContra == "" || apGlContra == null || apGlContra == "null"){
                                notify.message("Please input for GL Account code |error|alert");
                            }else if(apPayable == "" || apPayable == null || apPayable == "null"){
                                notify.message("Please input for Payable |error|alert");
                            }else if(apReference == "" || apReference == null || apReference == "null"){
                                notify.message("Please input for Reference |error|alert");
                            }else if(apParticulars == "" || apParticulars == null || apParticulars == "null"){
                                notify.message("Please input for Particulars |error|alert");
                            }else{
                                apBalance = parseFloat(apBalance.toString().replace(/,/g, ''));
                                if(apBalance < 0){
                                    notify.message("Invalid Balance Amount |error|alert");
                                }else{
                                    alertify.confirm(AppTitle,'Are you sure you want to continue create Accounts Payable ledger?',
                                        function(){
                                            checkIfAllowed('ADM00102', 'form#create', 'Create New Accounts Payable Ledger', null); 
                                        },
                                        function(){
                                            alertify.error('Canceled');
                                        }
                                    ); 
                                }
                                
                            }
                        }    
        </g:javascript>
		</g:form>
            </div>
	</content>
	<content tag="main-actions">
            <ul>
                <li><button onclick="validateApCreate();">Create</button></li>
		<li><g:link action="index"><g:message code="default.cancel.label" args="[entityName]" default="Cancel" /></g:link></li>
            </ul>
	</content>
    </body>
</html>
