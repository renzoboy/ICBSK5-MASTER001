<!DOCTYPE html>
<html>
    <head>
	<meta name="layout" content="main">
	<title>Edit FS Control Account</title>
    </head>
    <body>
	<content tag="main-content">
            <div id="create-assetsHtm" class="content scaffold-create" role="main">
		<g:if test="${flash.message}">
                    <div class="message" role="status">${flash.message}</div>
		</g:if>
		<g:hasErrors bean="${assetsHtmInstance}">
                    <ul class="errors" role="alert">
			<g:eachError bean="${assetsHtmInstance}" var="error">
			<li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error.field} - ${error}"/></li>
			</g:eachError>
                    </ul>
		</g:hasErrors>
		<g:form id="create" url="[controller:'fsControlAccount', action:'saveEdit']" onsubmit="callLoadingDialog();" method="POST">
                    <fieldset class="form">
			<g:render template="form"/> 
                    </fieldset>
                    <g:javascript>
                        var onoff = "";
                        function validateGlCode(){
                            var xcodegl = $('#account').val();
                            var fsaccountId = $('#fsControlId').val();
                            
                            if(xcodegl==""){

                            }else{
                              //=================== AJAX FUNCTION to validate code if existing
                                var obj = { 
                                    account: xcodegl,
                                    fsaccountId: fsaccountId,
                                }; 
                                console.log(JSON.stringify(obj));
                                console.log("Object Loaded iwth data...");
                                $.ajax({
                                    type: "POST",
                                    contentType: "application/json",
                                    url: "${createLink(controller:'FsControlAccount', action:'validateCodeIfExistAjax')}",
                                    data: JSON.stringify(obj),

                                    success: function(data){
                                        if(data.length >=1){
                                            onoff = "";
                                            
                                            onoff = "invalidGlCode";
                                            notify.message('Sorry, Code Already Exists! !|error|alert');
                                        }else{
                                            onoff = "";
                                        }

                                    },
                                    error: function(data){

                                    },

                                });                                            
                            }

                        }
                        
                        function validateFields(){
                            
                            var account = $('#account').val();
                            var description = $('#description').val();
                            
                            
                            if(account == null || account == ""){
                                notify.message("Sorry, Account code is required |error|alert");
                            }else if(description == null || description == ""){
                                notify.message("Sorry, Account Description is required |error|alert");
                            
                            }else if(onoff == "invalidGlCode"){
                                notify.message('Sorry, Code Already Exists! !|error|alert');
                            }else{
                                
                                alertify.confirm(AppTitle,'Are you sure you want to continue create New FS Control Account?',
                                function(){
                                        checkIfAllowed('ADM01100', 'form#create', 'Create New FS Control Account', null); 
                                    },
                                    function(){
                                        alertify.error('Canceled.');
                                });
                                
                            }
                            
                        }
                    </g:javascript>
		</g:form>
            </div>
	</content>
	<content tag="main-actions">
            <ul>
                <li><button onclick="validateFields();">Edit</button></li>
		<li><g:link action="index"><g:message code="default.cancel.label" args="[entityName]" default="Cancel" /></g:link></li>
            </ul>
	</content>
    </body>
</html>
