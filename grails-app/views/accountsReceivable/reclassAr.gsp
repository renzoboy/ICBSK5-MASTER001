<!DOCTYPE html>
<html>
    <head>
	<meta name="layout" content="main">
	<title>Reclass Accounts Receivable Subsidiary Ledger</title>
        <g:javascript>
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
            function reclassValidateGlCode(){
                var depcontra = $('#reclassGlContra').val();
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
                                    $('#reclassgldescription').val(_value.name);

                                });

                            }else{
                                onoff = "invalidGlCode";
                                $('#reclassgldescription').val('');
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
            
            function validateAccountsReceivableReclass(){
                var oldGlContra = $('#glContra').val()
                var currentGlContra = $('#reclassGlContra').val()
                if(currentGlContra == ""){
                    notify.message("Sorry, Reclass account cannot be empty |error|alert");
                }else if(oldGlContra == currentGlContra){
                    notify.message("Sorry, Cannot reclass to same Account|error|alert");
                }else if(onoff == "invalidGlCode"){
                    notify.message("Sorry, Invalid Gl Account Code |error|alert");
                }else{
                    alertify.confirm(AppTitle,'Are you sure you want to Reclass This Accounts Receivable?',
                    function(){
                            checkIfAllowed('ADM00102', 'form#create', 'Create New Accounts Receivable Ledger', null); 
                        },
                        function(){
                            return;
                    });
                }
            }
        </g:javascript>
    </head>
    <body>
        <content tag="breadcrumbs">
            <span class="fa fa-chevron-right"></span><a href="${createLink(uri: '/accountsReceivable')}">Accounts Receivable Subsidiary Ledger</a>
            <span class="fa fa-chevron-right"></span><span class="current">Reclass Accounts Receivable Subsidiary Ledger</span>
        </content>
	<content tag="main-content">
            <div id="create-accountsPayable" class="content scaffold-create" role="main">
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
		<g:form id="create" url="[controller:'AccountsReceivable', action:'arSaveReclass']" onsubmit="callLoadingDialog();" method="POST">
                    <g:hiddenField name="accountsReceivableId" id="accountsReceivableId" value="${accountsReceivableInstance?.id}" />
                    <div class="fieldcontain form-group ${hasErrors(bean: accountsReceivableInstance, field: 'glContra', 'has-error')} required">
                        <label class="control-label col-sm-4" for="glContra">AR GL Account Code<span class="required-indicator">*</span></label>
                        <div class="col-sm-8"><g:textField name="glContra" id="glContra" maxlength="25" required="" value="${accountsReceivableInstance?.glContra}" onblur="validateGlCode();" class="form-control" readonly="true"/>
                            <g:hasErrors bean="${accountsReceivableInstance}" field="glContra">
                                <div class="controls">
                                    <span class="help-block">
                                        <g:eachError bean="${accountsReceivableInstance}" field="glContra">
                                            <g:message error="${it}" /><br/>
                                        </g:eachError>
                                    </span>
                                </div>
                            </g:hasErrors>
                        </div>             
                    </div>    
                    
                    <div id="glaccountdescription" class="fieldcontain form-group ${hasErrors(bean: accountsReceivableInstance, field: 'depcontra', 'has-error')} required">
                            <label class="control-label col-sm-4" for="memoTxnType">
                                    <g:message code="txnTemplate.memoTxnType.label" default="Gl Acct Description" />
                                    <span class="required-indicator">*</span>
                            </label>
                            <div class="col-sm-8"><g:textField readonly="true" name="gldescription" id="gldescription" maxlength="100" value="" onblur="validateGlCode();" class="form-control"/>

                                <g:hasErrors bean="${accountsReceivableInstance}" field="memoTxnType">
                                    <div class="controls">
                                            <span class="help-block">
                                                <g:eachError bean="${accountsReceivableInstance}" field="memoTxnType">
                                                    <g:message error="${it}" /><br/>
                                                </g:eachError>
                                            </span>
                                    </div>
                                </g:hasErrors>
                            </div>             
                    </div>
                    </br>
                    </br>
                    <legend>Accounts Receivable Reclassification Details</legend>
                    <div class="fieldcontain form-group ${hasErrors(bean: accountsReceivableInstance, field: 'glContra', 'has-error')} required">
                        <label class="control-label col-sm-4" for="reclassGlContra">Reclass to GL Account Code<span class="required-indicator">*</span></label>
                        <div class="col-sm-8"><g:textField name="reclassGlContra" id="reclassGlContra"  required="" value="" onblur="reclassValidateGlCode();" class="form-control" />
                            <g:hasErrors bean="${accountsReceivableInstance}" field="reclassGlContra">
                                <div class="controls">
                                    <span class="help-block">
                                        <g:eachError bean="${accountsReceivableInstance}" field="reclassGlContra">
                                            <g:message error="${it}" /><br/>
                                        </g:eachError>
                                    </span>
                                </div>
                            </g:hasErrors>
                        </div>             
                    </div>
                    <div id="reclassGlaccountdescription" class="fieldcontain form-group ${hasErrors(bean: txnTemplateInstance, field: 'depcontra', 'has-error')} required">
                            <label class="control-label col-sm-4" for="memoTxnType">
                                    <g:message code="txnTemplate.memoTxnType.label" default="Reclass Gl Acct Description" />
                                    <span class="required-indicator">*</span>
                            </label>
                            <div class="col-sm-8"><g:textField readonly="true" name="reclassgldescription" id="reclassgldescription" maxlength="100" value="${txnTemplateInstance?.amlaCode}" onblur="validateGlCode();" class="form-control"/>

                                <g:hasErrors bean="${txnTemplateInstance}" field="memoTxnType">
                                    <div class="controls">
                                            <span class="help-block">
                                                <g:eachError bean="${txnTemplateInstance}" field="memoTxnType">
                                                    <g:message error="${it}" /><br/>
                                                </g:eachError>
                                            </span>
                                    </div>
                                </g:hasErrors>
                            </div>             
                    </div>
                    <g:hiddenField id="financialYear" name="financialYear" value="${g.formatDate(date: (runDate), format: 'yyyy')}"/>
		</g:form>
            </div>
	</content>
	<content tag="main-actions">
            <ul>
                <li><button onclick="validateAccountsReceivableReclass();">Save AR Reclass</button></li>
		<li><g:link action="index"><g:message code="default.cancel.label" args="[entityName]" default="Cancel" /></g:link></li>
            </ul>
	</content>
    </body>
</html>
