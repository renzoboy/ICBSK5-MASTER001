<%@ page import="icbs.gl.AccountsReceivable" %>
<!DOCTYPE html>
<html>
    <head>
	<meta name="layout" content="main">
	<title>Edit Accounts Receivable Subsidiary Ledger</title>
        <g:javascript>
        function updateCustomerInfoAjax(params) {	
                if (params.customer2) {
        $.ajax({
                            type: 'POST',
                            data: {id:params.customer2},
                            url: "${createLink(controller:'customer', action:'showBasicCustomerInfoAjax')}",
                            success: function(msg){
                                        $('#customer-name').val($(msg).find('#display-name').html());
                                        $('#receivableName').val($('#customer-name').val());
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

        	
            function showCustomerSearch(){
                console.log("pumasok na");
                modal = new icbs.UI.Modal({id:"customerDetailsModal", url:"${createLink(controller: 'search', action:'search')}", title:"Search Customer", onCloseCallback:updateCustomerInfoAjax});
                modal.show();                   
            }
        icbs.Dependencies.Ajax.addLoadEvent(function(){            	
            	updateCustomerInfoAjax({customer2:"${accountsReceivableInstance?.customer?.id}"});	
            });
        $( document ).ready(function() {
            validateGlCode();
        });
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
        function updateAP(){
        
            updateBalance();
            var arCustomer = $('#customer').val();
            var arcurrency = $('#currency').val();
            var arbalance = $('#balance').val();
            var arGlContra = $('#glContra').val();
            
            var arrequiredAllowance = $('#requiredAllowance').val();
            var armaturityDate = $('#maturityDate').val();
            var arreceivableName = $('#receivableName').val();
            var ardescription = $('#description').val();
            var arreference = $('#reference').val();
            var xarCreatedDate = $('#xarCreatedDate').val();
            
            if(arCustomer == "" || arCustomer=="null" || arCustomer == null){
                notify.message("please select customer information|error|alert");
            }else if(arcurrency == "" || arcurrency=="null" || arcurrency == null){
                notify.message("please select currency |error|alert");
            }else if(arbalance == "" || arbalance=="null" || arbalance == null){
                notify.message("Accounts receivable balance cannot be empty |error|alert");
            }else if(arGlContra == "" || arGlContra=="null" || arGlContra == null){
                notify.message("Accounts receivable GL Account code cannot be empty |error|alert");
            }else if(arrequiredAllowance == "" || arrequiredAllowance=="null" || arrequiredAllowance == null){
                $('#requiredAllowance').val('0');
            }else if(armaturityDate == "" || armaturityDate=="null" || armaturityDate == null){
                notify.message("Maturity Date cannot be empty |error|alert");
            }else if(arreceivableName == "" || arreceivableName=="null" || arreceivableName == null){
                notify.message("Receivable name cannot be empty |error|alert");
            }else if(ardescription == "" || ardescription=="null" || ardescription == null){
                notify.message("Description cannot be empty |error|alert");
            }else if(arreference == "" || arreference=="null" || arreference == null){
                notify.message("Reference cannot be empty |error|alert");
            }else{
            
                armaturityDate = new Date(armaturityDate);
                xarCreatedDate = new Date(xarCreatedDate);
                
                arbalance = parseFloat(arbalance.toString().replace(/,/g, ''));
                arrequiredAllowance = parseFloat(arrequiredAllowance.toString().replace(/,/g, ''));
                if(arbalance < 0 ){
                    notify.message("Invalid Accounts Receivabe Balance |error|alert");
                }else if(arrequiredAllowance < 0){
                    notify.message("Invalid Required Allowance |error|alert");
                }else if(armaturityDate < xarCreatedDate){
                    notify.message("Maturity Date cannot be less than Booking date |error|alert");
                }else{
                    
                    alertify.confirm(AppTitle,'Are you sure you want to continue edit Accounts Receivable ledger?',
                        function(){
                            checkIfAllowed('ADM00102', 'form#update', 'Update Accounts Receivable Ledger', null); 
                        },
                        function(){
                            alertify.error('Canceled');
                        }
                    );
                }
            }    
        }            
    </g:javascript>
    </head>
    <body>
        <content tag="breadcrumbs">
            <span class="fa fa-chevron-right"></span><a href="${createLink(uri: '/accountsReceivable')}">Accounts Receivable Subsidiary Ledger</a>
            <span class="fa fa-chevron-right"></span><span class="current">Edit Accounts Receivable Subsidiary Ledger</span>
        </content>
	<content tag="main-content">
            <div id="create-accountsReceivable" class="content scaffold-create" role="main">
		<g:if test="${flash.message}">
                    <div class="message" role="status">${flash.message}</div>
		</g:if>
		<g:hasErrors bean="${accountsReceivableInstance}">
                    <ul class="errors" role="alert">
			<g:eachError bean="${accountsReceivableInstance}" var="error">
			<li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error.field} - ${error}"/></li>
			</g:eachError>
                    </ul>
		</g:hasErrors>
		
                <g:form id="update" url="[controller:'accountsReceivable',action:'updateAccountsReceivable']" method="POST" onsubmit="callLoadingDialog();">    
                    <fieldset class="form">
			<g:render template="form"/>
                    </fieldset>
		</g:form>
            </div>
	</content>
	<content tag="main-actions">
            <ul>
                <li><button onclick="updateAP();">Update</button></li>
		<li><g:link action="index"><g:message code="default.cancel.label" args="[entityName]" default="Cancel" /></g:link></li>
            </ul>
	</content>
    </body>
</html>
