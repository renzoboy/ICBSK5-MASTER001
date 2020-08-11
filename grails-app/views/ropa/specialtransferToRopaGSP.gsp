<%@ page import="icbs.admin.UserMaster" %>
<!DOCTYPE html>
<html>
    <head>
	<meta name="layout" content="main">
	<title>Create New ROPA</title>
    
    <g:javascript>
        onoff = "";
        function showLoanSearch() {				
            modal = new icbs.UI.Modal({id:"loanModal", url:"${createLink(controller: 'loan', action:'search')}", title:"Search Loan Account", onCloseCallback:updateLoanDetailsAjax});
            modal.show();
        }
        function updateLoanDetailsAjax(params) {
            if (params.loan2) {
                $('#loanID').val(params.loan2);
                
                $.ajax({
                    type: 'POST',
                    data: {id:params.loan2},
                    url: "${createLink(controller:'loan', action:'getLoanDetailsAjax')}",
                    success: function(msg){
                            console.log(msg);
                            $('#accountNo').val($(msg).find('#account-no').html());
                            $('#loanAccountName').val($(msg).find('#customer').html());      
                            $('#loanBalance').val($(msg).find('#loan-balance-amt').html());   
                            $('#loanAcctStatusId').val($(msg).find('#loan-status-id').html());
                            var theLoanAcctNo = $('#accountNo').val();
                            var theCollateralId = $('#idOfCollateral').val();
                            var ropaCollateralAcctNo = $('#ropaCollateralLoanAcctNo').val();
                            //================= check for loan application Collaterals
                                var obj = { 
                                    accountno: theLoanAcctNo,
                                    thecollateral: theCollateralId,
                                }; 
                                console.log(JSON.stringify(obj));
                                console.log("Object Loaded iwth data...");
                                $.ajax({
                                    type: "POST",
                                    contentType: "application/json",
                                    url: "${createLink(controller:'Ropa', action:'ropaSpecialCollateralValidatorAjax')}",
                                    data: JSON.stringify(obj),

                                    success: function(data){
                                        if(data.length >=1){
                                            onoff = "";
                                            if(ropaCollateralAcctNo == theLoanAcctNo){
                                                onoff = "sameAccountNoOfRopaCollateral";
                                                notify.message('Sorry, Collateral of this Account Already Transfered to ROPA!|error|alert');
                                            }
                                        }else{
                                            onoff = "invalidLoan";
                                            notify.message('Sorry, Loan Account not linked to this collateral !|error|alert');
                                        }
                                        console.log("onoff: "+onoff);
                                    },
                                    error: function(data){

                                    },

                                });
                            //========================================================
                                
                    },
                    error:function(XMLHttpRequest,textStatus,errorThrown){
                        alert(XMLHttpRequest+textStatus+errorThrown);
                    }
                });
            }
        } 
        
        function validateTransferToRopa(){
            console.log("boom");
            var txnAmt = 0;
            var transferAmount = $('#transferAmount').val();
            var lonbalance = $('#loanBalance').val();
            var marketValueLand = $('#marketValueLand').val();
            var marketValueBuilding = $('#marketValueBuilding').val();
            
            var loanAcctStatusId = $('#loanAcctStatusId').val();
            
            var reference = $('#reference').val();
            var particulars = $('#particulars').val();


            //================= INITIALIZE RECORDS ==============
            (transferAmount == "") ? transferAmount = parseFloat(0) : transferAmount = parseFloat(transferAmount.toString().replace(/,/g, ''));
            (marketValueLand == "") ? marketValueLand = parseFloat(0) : marketValueLand = parseFloat(marketValueLand.toString().replace(/,/g, ''));
            (marketValueBuilding == "") ? marketValueBuilding = parseFloat(0) : marketValueBuilding = parseFloat(marketValueBuilding.toString().replace(/,/g, ''));
            (lonbalance == "") ? lonbalance = parseFloat(0) : lonbalance = parseFloat(lonbalance.toString().replace(/,/g, ''));
                   
            console.log("transferAmount: "+transferAmount);
            console.log("lonbalance: "+lonbalance);
            console.log("marketValueLand: "+marketValueLand);
            console.log("marketValueBuilding: "+marketValueBuilding);
            
            console.log("loanAcctStatusId: "+loanAcctStatusId);

            if($('#loanID').val() == ""){
                notify.message('Loan Account is required to Transfer !|error|alert');
            }else if(onoff == "invalidLoan"){
                notify.message('Sorry, Loan Account not linked to this collateral !|error|alert');
            }else if (onoff == "sameAccountNoOfRopaCollateral"){
                notify.message('Sorry, Collateral of this Account Already Transfered to ROPA!|error|alert');
            }else if(transferAmount <= 0 ){
                notify.message("Invalid Transfer Amount .|error|alert");
            }else if(transferAmount > lonbalance ){
                notify.message("Transfer Amount Greater than Loan Balance Amount|error|alert");
            }else if(loanAcctStatusId == 8){
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
                        checkIfAllowed('ADM00102', 'form#saveSpecialTransfer', 'Transfer  ROPA', null); 
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
                <span class="fa fa-chevron-right"></span><span class="current">Create New ROPA</span>
        </content>
	<content tag="main-content">
            <div id="create-ropa" class="content scaffold-create" role="main">
		<g:if test="${flash.message}">
                    <div class="box-body">
                        <div class="alert alert-danger alert-dismissable">
                            <i class="fa fa-info"></i>
                            <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                            <b>Message</b> <div class="message" role="status">${flash.message}</div>
                        </div>
                    </div>
                </g:if>
		<g:hasErrors bean="${ropaInstance}">
                    <ul class="errors" role="alert">
			<g:eachError bean="${ropaInstance}" var="error">
			<li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error.field} - ${error}"/></li>
			</g:eachError>
                    </ul>
		</g:hasErrors>
                <g:render template="details/collateralDetails"/>
		<g:form id="saveSpecialTransfer" url="[controller:'ropa', action:'saveSpecialTransfer']" onsubmit="callLoadingDialog();" >
                    <g:hiddenField id="loanID" name="loanID" value="" />
                    <div class="fieldcontain form-group ${hasErrors(bean: loanLedgerInstance, field: 'loan', 'has-error')} ">
                            <label class="control-label col-sm-4" for="loan">
                                    <g:message code="loanLedger.loan.label" default="Loan Account" />
                            <span class="required-indicator">*</span>
                            </label>
                            <div class="col-sm-7"><g:field name="accountNo" value="" class="form-control" readonly="true"/>        

                            <g:hasErrors bean="${loanLedgerInstance}" field="loan">
                                    <script>
                                        $(function
                                            var x = '${it}';
                                            notify.error(x);
                                           // console.log(x)
                                           // setTimeout(function(){ notify.success(x); }, 3000);
                                        });
                                    </script>
                            </g:hasErrors>
                        </div>             

                        <div class="col-sm-2"><input type="button" href="#" class="btn btn-secondary" onclick="showLoanSearch()" value="Search"/></div>
                    </div>
                    <div class="fieldcontain form-group ${hasErrors(bean: ropaInstance, field: 'loan', 'has-error')} required">
                        <label class="control-label col-sm-4" for="loan">Customer Name<span class="required-indicator">*</span></label>
                        <div class="col-sm-8"><g:textField name="loanAccountName"  required="" value="" class="form-control" readonly="true"/>
                            <g:hasErrors bean="${ropaInstance}" field="loan">
                                <div class="controls">
                                    <span class="help-block">
                                        <g:eachError bean="${ropaInstance}" field="loan">
                                            <g:message error="${it}" /><br/>
                                        </g:eachError>
                                    </span>
                                </div>
                            </g:hasErrors>
                        </div>             
                    </div>
                    <div class="fieldcontain form-group ${hasErrors(bean: ropaInstance, field: 'loan', 'has-error')} required">
                        <label class="control-label col-sm-4" for="loan">Loan Balance amount<span class="required-indicator">*</span></label>
                        <div class="col-sm-8"><g:textField name="loanBalance"  required="" value="" class="form-control" readonly="true"/>
                            <g:hasErrors bean="${ropaInstance}" field="loan">
                                <div class="controls">
                                    <span class="help-block">
                                        <g:eachError bean="${ropaInstance}" field="loan">
                                            <g:message error="${it}" /><br/>
                                        </g:eachError>
                                    </span>
                                </div>
                            </g:hasErrors>
                        </div>             
                    </div>
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

                    <g:render template="ropaTransfer/form"/>

                     <g:hiddenField id="collateral" name="collateral" value="${collateralInstance?.id}" />
                     <g:hiddenField id="transferRopa" name="transferRopa" value="${transferToRopaInstance?.id}" />
                     <g:hiddenField id="loanAcctStatusId" name="loanAcctStatusId" value="" />
                     <g:hiddenField id="idOfCollateral" name="idOfCollateral" value="${collateralInstance?.collateral?.id}" />
                     <g:hiddenField id="ropaCollateralLoanAcctNo" name="ropaCollateralLoanAcctNo" value="${collateralInstance?.loan?.accountNo}" />
                     
		</g:form>
            </div>
	</content>
	<content tag="main-actions">
            <ul>
                <li><button onclick="validateTransferToRopa();">Save Special Transfer</button></li>
		<li><g:link action="index"><g:message code="default.cancel.label" args="[entityName]" default="Cancel" /></g:link></li>
            </ul>
	</content>
    </body>
</html>
