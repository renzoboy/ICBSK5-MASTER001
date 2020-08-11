<!DOCTYPE html>
<html>
    <head>
	<meta name="layout" content="main">
	<title>Transfer To ROPA</title>
    </head>
    <body>
        <content tag="breadcrumbs">
                <span class="fa fa-chevron-right"></span><span class="current">Create New ROPA</span>
        </content>
	<content tag="main-content">
            <div id="create-ropa" class="content scaffold-create" role="main">
		<g:if test="${flash.message}">
                    <div class="message" role="status">${flash.message}</div>
		</g:if>
		<g:hasErrors bean="${ropaInstance}">
                    <ul class="errors" role="alert">
			<g:eachError bean="${ropaInstance}" var="error">
			<li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error.field} - ${error}"/></li>
			</g:eachError>
                    </ul>
		</g:hasErrors>
                <script>
                    function validateTransferToRopa(){
                        console.log("boom");
                        var txnAmt = 0;
                        var transferAmount = $('#transferAmount').val();
                        var lonbalance = $('#lonbalance').val();
                        var marketValueLand = $('#marketValueLand').val();
                        var marketValueBuilding = $('#marketValueBuilding').val();
                        var lonPerformanceId = $('#lonPerformanceId').val();
                        var otherPropertiesAcquired = $('#otherPropertiesAcquired').val();
                        var loanStatusId = $('#loanStatusId').val();
                        var reference = $('#reference').val();
                        var particulars = $('#particulars').val();
                        
                        //================= INITIALIZE RECORDS ==============
                        (transferAmount == "") ? transferAmount = parseFloat(0) : transferAmount = parseFloat(transferAmount.toString().replace(/,/g, ''));
                        (marketValueLand == "") ? marketValueLand = $('#marketValueLand').val(parseFloat(0)) : marketValueLand = parseFloat(marketValueLand.toString().replace(/,/g, ''));
                        (marketValueBuilding == "") ? marketValueBuilding = $('#marketValueBuilding').val(parseFloat(0)) : marketValueBuilding = parseFloat(marketValueBuilding.toString().replace(/,/g, ''));
                        (lonbalance == "") ? lonbalance = parseFloat(0) : lonbalance = parseFloat(lonbalance.toString().replace(/,/g, ''));
                        (otherPropertiesAcquired == "") ? otherPropertiesAcquired = $('#otherPropertiesAcquired').val(parseFloat(0)) : otherPropertiesAcquired = parseFloat(otherPropertiesAcquired.toString().replace(/,/g, ''));
                        
                        console.log("transferAmount: "+transferAmount);
                        console.log("lonbalance: "+lonbalance);
                        console.log("marketValueLand: "+marketValueLand);
                        console.log("marketValueBuilding: "+marketValueBuilding);
                        console.log("lonPerformanceId: "+lonPerformanceId);
                        console.log("loanStatusId: "+loanStatusId);
                        
                        if(transferAmount <= 0 ){
                            notify.message("Invalid Transfer Amount .|error|alert");
                        }else if(transferAmount > lonbalance ){
                            notify.message("Transfer Amount Greater than Loan Balance Amount|error|alert");
                        }else if(loanStatusId == 8){
                            notify.message("ERROR: Loan already Written-Off |error|alert");
                        }else if(reference == "null" || reference == "" || reference==null){
                            notify.message("Reference is required |error|alert");
                        }else if(particulars == "null" || particulars == "" || particulars==null){
                            notify.message("Particulars is required |error|alert");
                        }else{
                            //submit form
                            console.log("Submit");
                            
                            alertify.confirm(AppTitle,'Are you sure you want to Transfer this collateral to ROPA?',
                            function(){
                                    checkIfAllowed('ADM00102', 'form#save', 'Transfer  ROPA', null); 
                                },
                                function(){
                                    return;
                            });

                        }
                        
                    }
                    
                </script>    
                 <legend>Loan Information</legend>
                <table class="table table-bordered table-striped">
                    <tbody>
                        <tr>
                            <td style="font-weight:bold" width="30%">Loan Account Number</td>
                            <td style="width:70%">${collateralInstance?.ropa?.loan?.accountNo}</td>   
                        </tr>
                        <tr>
                            <td style="font-weight:bold" width="30%">Loan Balance Amount</td>
                            <td style="width:70%"><g:formatNumber format="###,###,##0.00" number="${collateralInstance?.ropa?.loan?.balanceAmount}"/></td>   
                            <g:hiddenField name="lonbalance" id="lonbalance" value="${collateralInstance?.ropa?.loan?.balanceAmount}" />
                            <g:hiddenField name="lonPerformanceId" id="lonPerformanceId" value="${collateralInstance?.ropa?.loan?.loanPerformanceId.id}" />
                            <g:hiddenField name="loanStatusId" id="loanStatusId" value="${collateralInstance?.ropa?.loan?.status.id}" />
                        </tr>
                    </tbody>
                </table>
                    <g:form id="save" url="[controller:'ropa', action:'saveTransferToRopa']" onsubmit="callLoadingDialog();">
                        <div class="fieldcontain form-group ${hasErrors(bean: transferToRopaInstance, field: 'transferAmount', 'has-error')} required">
                            <label class="control-label col-sm-4" for="transferAmount">
                                    <g:message code="RopaTransfer.transferAmount.label" default="Transfer Amount" /><span class="required-indicator"> *</span>
                            </label>
                            <div class="col-sm-8"><g:field name="transferAmount" id="transferAmount" value="" class="form-control truncated"/>

                            <g:hasErrors bean="${transferToRopaInstance}" field="transferAmount">
                                <div class="controls">
                                        <span class="help-block">
                                            <g:eachError bean="${transferToRopaInstance}" field="transferAmount">
                                                <g:message error="${it}" /><br/>
                                            </g:eachError>
                                        </span>
                                </div>
                            </g:hasErrors>
                        </div>             
</div>
                        <g:render template="details/transferDetails"/>
		
                    <fieldset class="form">
			<g:render template="ropaTransfer/form"/>
                         <g:hiddenField id="collateral" name="collateral" value="${collateralInstance?.id}" />
                         <g:hiddenField id="transferRopa" name="transferRopa" value="${transferToRopaInstance?.id}" />
                    </fieldset>
		</g:form>
            </div>
	</content>
	<content tag="main-actions">
            <ul>
                <li><button onclick="validateTransferToRopa();">Save Transfer</button></li>
		<li><g:link action="index"><g:message code="default.cancel.label" args="[entityName]" default="List of ROPA" /></g:link></li>
            </ul>
	</content>
    </body>
</html>
