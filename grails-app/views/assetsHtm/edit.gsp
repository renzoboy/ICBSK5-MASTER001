<%@ page import="icbs.gl.AssetsHeldToMaturity" %>
<!DOCTYPE html>
<html>
    <head>
	<meta name="layout" content="main">
	<g:set var="entityName" value="${message(code: 'assetsHeldToMaturity.label', default: 'AssetsHeldToMaturity')}" />
	<title>Edit Assets Held To Maturity</title>
    </head>
    <body>
        <content tag="breadcrumbs">
            <span class="fa fa-chevron-right"></span><a href="${createLink(uri: '/assetsHtm')}">Assets Held To Maturity</a>
            <span class="fa fa-chevron-right"></span><span class="current">Edit Assets Held To Maturity</span>
        </content>
        
	<content tag="main-content">
            <div id="edit-cashInBank" class="content scaffold-edit" role="main">
		<g:if test="${flash.message}">
                    <div class="message" role="status">${flash.message}</div>
                </g:if>
		<g:hasErrors bean="${clearingBankInstance}">
                    <ul class="errors" role="alert">
			<g:eachError bean="${clearingBankInstance}" var="error">
                            <li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
			</g:eachError>
                    </ul>
		</g:hasErrors>
                <script>
                   
                    function updateHtmForm(xhtmDes){
                        console.log("xhtmDes: "+xhtmDes);
                        xhtmDes = parseInt(xhtmDes);
                        if(xhtmDes == 2){
                            document.getElementById("discountAmountDiv").style.display = "none";
                        }else{
                            document.getElementById("discountAmountDiv").style.display = "block";
                        }
                    }
                    $( document ).ready(function() {
                        validateHtmCreditGl();
                        validateHtmDebitGl();
                        $('#htmTypeDesc').val();
                        updateHtmForm($('#htmTypeDesc').val());
                    });
                    var onoff=""
                        function validateGlCode(){
                            var depcontra = $('#glCode').val();
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
                        
                        function validateHtmCreditGl(){
                            var depcontra = $('#htmAccrualCredittAcct').val();
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
                                                $('#htmAccrualCreditAcctDescription').val(_value.name);

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
                        
                        function validateHtmDebitGl(){
                            var depcontra = $('#htmAccrualDebitAcct').val();
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
                                                $('#htmAccrualDebitAcctDescription').val(_value.name);

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
                        function validateFields(){
                            var currency = $('#currency').val();
                            var glAccountCode = $('#glCode').val();
                            var htmAccrualCredittAcct = $('#htmAccrualCredittAcct').val();
                            var htmAccrualDebitAcct = $('#htmAccrualDebitAcct').val();
                            
                            var interestRate = $('#interestRate').val();
                            //var htmAmount = $('#htmAmount').val();
                            var discountAmount = $('#discountAmount').val();
							var htmTypeDesc = $('#htmTypeDesc').val();
                            if(parseInt(htmTypeDesc) == 2){
                                discountAmount = "noDiscount";
                                console.log("discountAmount: "+discountAmount);
                            }										  
                            var maturityDate = $('#maturityDate').val();
                            var htmDescription = $('#htmDescription').val();
                            var htmIssuer = $('#htmIssuer').val();
                            var effectiveYield = $('#effectiveYield').val();
                            var valueDate = $('#valueDate').val();
                            var reference = $('#reference').val();
                            var branchRunDate = $('#branchRunDate').val();
                            var residentType = $('#residentType').val();
                            var residentType = $('#residentType').val();
                            var issuer = $('#htmIssuer').val();
                            
                            if(currency == null || currency == ""){
                                notify.message("Please select currency |error|alert");
                            }else if(residentType == null || residentType == ""){
                                notify.message("Please select resident type |error|alert");
                            }else if(glAccountCode== null || glAccountCode == ""){
                                notify.message("Please Input for Gl Account code |error|alert");
                            }else if(htmAccrualDebitAcct== null || htmAccrualDebitAcct == ""){
                                notify.message("Please Input for Accural Debit Gl Account Code |error|alert");
                            }else if(htmAccrualCredittAcct== null || htmAccrualCredittAcct == ""){
                                notify.message("Please Input for Accural Credit Gl Account Code |error|alert");
                            }else if(interestRate== null || interestRate == ""){
                                notify.message("Please input for interest Rate |error|alert");
                            }else if(maturityDate== null || maturityDate == ""){
                                notify.message("Please select date for maturity date |error|alert");
                            }else if(htmTypeDesc== null || htmTypeDesc == ""){
                                notify.message("Please select HTM type |error|alert");
                            }else if(discountAmount== null || discountAmount == ""){
                                notify.message("Please input for HTM Discount amount |error|alert");
                            }else if(htmDescription== null || htmDescription == ""){
                                notify.message("Please input for HTM Description |error|alert");
                            }else if(htmIssuer== null || htmIssuer == ""){
                                notify.message("Please input for issuer |error|alert");
                            }else if(effectiveYield== null || effectiveYield == ""){
                                notify.message("Please input for effective yield |error|alert");
																		  
																								
                            }else if(reference== null || reference == ""){
                                notify.message("Please input for reference |error|alert");
                            }else{
                                
                                interestRate = parseFloat(interestRate.toString().replace(/,/g, ''));
                                //htmAmount = parseFloat(htmAmount.toString().replace(/,/g, ''));
                                if(discountAmount == "noDiscount"){
                                    discountAmount = 0.00;
                                }else{
                                    discountAmount = parseFloat(discountAmount.toString().replace(/,/g, ''));
                                }
                                effectiveYield = parseFloat(effectiveYield.toString().replace(/,/g, ''));
                                
                                maturityDate = new Date(maturityDate);
                                branchRunDate = new Date(branchRunDate);
                                valueDate = new Date(valueDate);
                                
                                if(maturityDate < branchRunDate){
                                    notify.message("Maturity Date cannot be less than run date |error|alert");
                                }else if(maturityDate < valueDate){
                                    notify.message("Maturity Date cannot be less than value date |error|alert");
                                }else if(interestRate < 0){
                                    notify.message("Invalid Interest Rate |error|alert");
                                }else if(discountAmount < 0){
                                    notify.message("Invalid HTM Discount Amount |error|alert");
                                }else if(effectiveYield < 0){
                                    notify.message("Invalid Effective Yield Amount |error|alert");
                                }else{
                                    alertify.confirm(AppTitle,'Are you sure you want to update HTM details?',
                                    function(){
                                            checkIfAllowed('ADM00102', 'form#edit', 'HTM update', null); 
                                        },
                                        function(){
                                            alertify.error('Canceled.');
                                    });
                                }
                                
                            }
                            
                        }
                            
                        
                </script>    
            	<g:form id="edit" url="[action:'update', controller: 'assetsHtm']" onsubmit="callLoadingDialog();"  method="POST" >
                    <fieldset class="form">
			<g:render template="form"/>
                        
                    </fieldset>
		</g:form>
            </div>
        </content>
        
	<content tag="main-actions">
            <ul>
                <li><button onclick="validateFields();">Update</button></li>
		
		<li><g:link controller="assetsHtm" action="show" id="${params.id}" ><g:message code="default.cancel.label" args="[entityName]" default="Cancel" /></g:link></li>
            </ul>
	</content>
    </body>
</html>
