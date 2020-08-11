<%@ page import="icbs.loans.ROPA" %>
<%@ page import="icbs.gl.GlAccount" %>

<!DOCTYPE html>
<html>
    <head>
	<meta name="layout" content="main">
	<g:set var="entityName" value="${message(code: 'ROPA.label', default: 'ROPA')}" />
	<title>Edit ROPA Information</title>
        <g:javascript>   
        var onoff = "";
        function validateGlCodeglContraRopa(){
            console.log("ssssssssssssssssssss");
            
            var depcontra = $('#glContraRopa').val();
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

                            $.each(data, function (_key, _value) {
                                console.log(JSON.stringify(obj))
                                console.log(_value.gl_code);
                                console.log(_value.name);
                                $('#glbldgdescriptionContra').val(_value.name);

                            });

                        }else{
                            onoff = "invalidGlCode";
                            $('#glbldgdescriptionContra').val('');
                            notify.message('Sorry, Invalid Gl Code!|error|alert');
                        }
                        console.log("onoff: "+onoff);
                    },
                    error: function(data){

                    },

                });                                            
            }
        }
        //==================
        function validateGlCodeAccum(){
            console.log("ssssssssssssssssssss");
            
            var depcontra = $('#accumulatedDepreciation').val();
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

                            $.each(data, function (_key, _value) {
                                console.log(JSON.stringify(obj))
                                console.log(_value.gl_code);
                                console.log(_value.name);
                                $('#accumDescription').val(_value.name);

                            });

                        }else{
                            onoff = "invalidGlCode";
                            $('#glLitigationExpenseDescription').val('');
                            notify.message('Sorry, Invalid Gl Code!|error|alert');
                        }
                        console.log("onoff: "+onoff);
                    },
                    error: function(data){

                    },

                });                                            
            }
        }
        function validateGlCodeglContraLitigationExp(){
            console.log("ssssssssssssssssssss");
            
            var depcontra = $('#glContraLitigationExp').val();
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

                            $.each(data, function (_key, _value) {
                                console.log(JSON.stringify(obj))
                                console.log(_value.gl_code);
                                console.log(_value.name);
                                $('#glLitigationExpenseDescription').val(_value.name);

                            });

                        }else{
                            onoff = "invalidGlCode";
                            $('#glLitigationExpenseDescription').val('');
                            notify.message('Sorry, Invalid Gl Code!|error|alert');
                        }
                        console.log("onoff: "+onoff);
                    },
                    error: function(data){

                    },

                });                                            
            }
        }
        //==================
        function validateGlCodeglContraBldg(){
            console.log("ssssssssssssssssssss");
            
            var depcontra = $('#glContraBldg').val();
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

                            $.each(data, function (_key, _value) {
                                console.log(JSON.stringify(obj))
                                console.log(_value.gl_code);
                                console.log(_value.name);
                                $('#glRopaBldgDescription').val(_value.name);

                            });

                        }else{
                            onoff = "invalidGlCode";
                            $('#glRopaBldgDescription').val('');
                            notify.message('Sorry, Invalid Gl Code!|error|alert');
                        }
                        console.log("onoff: "+onoff);
                    },
                    error: function(data){

                    },

                });                                            
            }
        }
        //==================
        function validateGlCodeotherAccumlated(){
            console.log("ssssssssssssssssssss");
            
            var depcontra = $('#otherAccumlated').val();
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

                            $.each(data, function (_key, _value) {
                                console.log(JSON.stringify(obj))
                                console.log(_value.gl_code);
                                console.log(_value.name);
                                $('#otherAccumulatedDescription').val(_value.name);

                            });

                        }else{
                            onoff = "invalidGlCode";
                            $('#otherAccumulatedDescription').val('');
                            notify.message('Sorry, Invalid Gl Code!|error|alert');
                        }
                        console.log("onoff: "+onoff);
                    },
                    error: function(data){

                    },

                });                                            
            }
        }
        //==================
        function validateGlCoderopaIncome(){
            console.log("ssssssssssssssssssss");
            
            var depcontra = $('#ropaIncome').val();
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

                            $.each(data, function (_key, _value) {
                                console.log(JSON.stringify(obj))
                                console.log(_value.gl_code);
                                console.log(_value.name);
                                $('#ropaGainOnSaleDescription').val(_value.name);

                            });

                        }else{
                            onoff = "invalidGlCode";
                            $('#ropaGainOnSaleDescription').val('');
                            notify.message('Sorry, Invalid Gl Code!|error|alert');
                        }
                        console.log("onoff: "+onoff);
                    },
                    error: function(data){

                    },

                });                                            
            }
        }
        //==================
        function validateGlCodeotherGl(){
            console.log("ssssssssssssssssssss");
            
            var depcontra = $('#otherGl').val();
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

                            $.each(data, function (_key, _value) {
                                console.log(JSON.stringify(obj))
                                console.log(_value.gl_code);
                                console.log(_value.name);
                                $('#otherGlDescription').val(_value.name);

                            });

                        }else{
                            onoff = "invalidGlCode";
                            $('#otherGlDescription').val('');
                            notify.message('Sorry, Invalid Gl Code!|error|alert');
                        }
                        console.log("onoff: "+onoff);
                    },
                    error: function(data){

                    },

                });                                            
            }
        }
        </g:javascript>   
    </head>
    <body>
        <content tag="breadcrumbs">
                <span class="fa fa-chevron-right"></span><span class="current">Edit ROPA Information</span>
        </content>
        <content tag="main-content">
            <div id="edit-ROPA" class="content scaffold-edit" role="main">
		<g:if test="${flash.message}">
                    <div class="message" role="status">${flash.message}</div>
                </g:if>
		<g:hasErrors bean="${ropaInstance}">
                    <ul class="errors" role="alert">
			<g:eachError bean="${ropaInstance}" var="error">
                            <li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
			</g:eachError>
                    </ul>
		</g:hasErrors>
                <div class="panel panel-default">
												 
                    <div class="panel panel-default">
                        <div class="panel-body">
                            <table class="table table-bordered table-rounded table-striped table-hover">
                                <tbody>
                                    <tr>
                                        <td style="width:30%"><label>Branch</label></td>
                                        <td style="width:70%">${ropapapapaInstanceInstance?.branch?.name}</td> 
                                    </tr>    
                                    <tr>
                                        <td style="width:30%"><label>ROPA Date</label></td>
                                        <td style="width:70%"><g:formatDate  format="MM/dd/yyyy" date="${ ropapapapaInstanceInstance?.ropaDate}" /></td> 
								 
                                    </tr>
                                </tbody>
																																		  
                            </table>
                        </div>
							
                    </div>
				
                </div>
				  
                <g:form id="editRopa" name="editRopa" url="[action:'updateRopa',controller:'Ropa']" onsubmit="callLoadingDialog();">
                    <fieldset class="form">
			<g:render template="editForm"/>
                    </fieldset>
		</g:form>
            </div>
        </content>
    
        <content tag="main-actions">
            <ul>
                <li><a href="#" onClick="callAlertSendEdit();" >Update</a></li>
                <li><g:link action="show" id="${ropapapapaInstanceInstance?.id}">Cancel</g:link></li>
                <script>
                    function callAlertSendEdit(){
                        console.log("SUBMIT onoff: "+onoff);
                              
                        
                        var glContraRopa = $('#glContraRopa').val();
                        var glContraLitigationExp = $('#glContraLitigationExp').val();
                        var glContraBldg = $('#glContraBldg').val();
                        var otherAccumlated = $('#otherAccumlated').val();
                        var ropaIncome = $('#ropaIncome').val();
                        var otherGl = $('#otherGl').val();
                        
                        if(glContraRopa == ""){
                            notify.message("Please input for Ropa Land GL Account |error|alert");
                        }else if (glContraLitigationExp == ""){
                            notify.message("Please input for Litigation Expense GL Account |error|alert");
                        }else if (glContraBldg == ""){
                            notify.message("Please input for ROPA Building GL Account |error|alert");
                        }else if (otherAccumlated == ""){
                            notify.message("Please input for Other Accumulated Depreciation GL Account |error|alert");
                        }else if (ropaIncome == ""){
                            notify.message("Please input for Gain on Sale of ROPA |error|alert");
                        }else if (otherGl == ""){
                            notify.message("Please input for Other Properties Acquired |error|alert");
                        }else if(onoff != ""){
                            notify.message("Cannot Proceed process due to field Errors|error|alert");
                        }else{
                            alertify.confirm(AppTitle,'Are you sure you want to save ROPA Information?',
                                function(){
                                    checkIfAllowed('CFG00303', 'form#editRopa', 'Override edit ROPA', null); 

                                },
                                function(){
                                    return;
                                }
                            ); 
                        }
                        
                    }
                </script>
            </ul>
        </content>           
    </body>
</html>
