<%@ page import="icbs.loans.RopaTransfer" %>
<%@ page import="icbs.loans.RopaCollateralDetails" %>
<%@ page import="icbs.admin.UserMaster" %>
<!DOCTYPE html>

<html>
    <head>
	<meta name="layout" content="main">
	<title>ROPA Sale - Installment</title>
    </head>
    <body>
        <content tag="breadcrumbs">
                <span class="fa fa-chevron-right"></span><span class="current">ROPA Sale Installment</span>
        </content>
	<content tag="main-content">
            <g:javascript>
                function updateLoanApplicationAjax(params) {
                    console.log("params: "+params );
                    if (params.loanApplication2) {
                        $('#loanApplication').val(params.loanApplication2);
                        console.log("paramsssss: "+params.loanApplication2);
                        var obj = { 
                            id: params.loanApplication2,
                        }; 
                        //console.log(JSON.stringify(obj));
                        //console.log("Object Loaded iwth data...");
                        $.ajax({
                            type: "POST",
                            contentType: "application/json",
                            url: "${createLink(controller:'ropa', action:'collectionInformationInstallment')}",
                            data: JSON.stringify(obj),

                            success: function(data){

                                $.each(data, function (_key, _value) {
                                    
                                    
                                    var statusId = parseInt(_value.status_id);
                                    var productTypeId = (_value.product_type_id);
                                    var grantedAmountt = (_value.granted_amount);
                                    var balanceamount = (_value.balance_amountt);
                                    $('#xxxGranted').val(_value.granted_amount);
                                    $('#scrBalanceAmount').val(balanceamount);
                                    $('#scrGrantedAmount').val(grantedAmountt);
                                    if(statusId != 3){
                                        //loan account not yet approve
                                        alertify.alert(AppTitle,"Loan account not yet approve.", function(){
                                            location.reload();
                                        });
                                    }else if(productTypeId != 7){
                                        // invalid Loan product - should be Sales Contract Receivable (SCR)
                                        alertify.alert(AppTitle,"Invalid Loan product - should be Sales Contract Receivable (SCR)", function(){
                                            location.reload();
                                        });
                                    }else{
                                        $('#lnaccountName').val(_value.display_name);
                                    }
                                });
                            },
                            error: function(data){
                                console.log('Pumasok sa error');
                            },
                        }); //AJAX CLOSE    
                    }
                }
                function showLoanApplicationSearch() {				
                    modal = new icbs.UI.Modal({id:"loanApplicationModal", url:"${createLink(controller: 'ropa', action:'search')}", title:"Search Loan Application", onCloseCallback:updateLoanApplicationAjax});
                    modal.show();
                }
                //=====================================================================================
                function showLoanSearch() {				
                    modal = new icbs.UI.Modal({id:"loanModal", url:"${createLink(controller: 'loan', action:'search')}", title:"Search Account", onCloseCallback:updateLoanDetailsAjax});
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

                                console.log("productType: "+$(msg).find('#product-type-id').html());
                                if(parseInt($(msg).find('#product-type-id').html()) != 7){
                                    
                                    notify.message("Loan product should be - Sales Contract Receivables|error|alert");
                                }else{
                                    $('#accountNo').val($(msg).find('#account-no').html());
                                    $('#loanAccountName').val($(msg).find('#customer').html());  
                                    $('#xxxGranted').val($(msg).find('#granted-amount').html());  
                                    $('#loanApplication').val($(msg).find('#loan-application-id').html());
                                    $('#productName').val($(msg).find('#product-name').html());
                                }
                                
                                
                                
                            },
                            error:function(XMLHttpRequest,textStatus,errorThrown){
                                alert(XMLHttpRequest+textStatus+errorThrown);
                            }
                        });
                    }
                } 
                //=====================================================================================
                icbs.Dependencies.Ajax.addLoadEvent(function(){
                    updateLoanApplicationAjax({loanApplication2:"${loanApplication?.id}"});
                });
                
                function validateRopaSaleInst(){
                    
                    var sellingPrice = $('#sellingPrice').val();
                    var processBranch = $('#processBranch').val();
                    var ropaBranch = $('#ropaBranch').val();
                    var loanID = $('#loanID').val();
                    var scrGrantedAmount = $('#scrGrantedAmount').val();
                    var scrBalanceAmount = $('#scrBalanceAmount').val();
                    var downPayment = $('#downPayment').val();
                    var scrDiscount = $('#scrDiscount').val();
                    var commission = $('#commission').val();
                    var reference = $('#reference').val();
                    var particulars = $('#particulars').val();
                    (sellingPrice == "") ? sellingPrice = parseFloat(0) : sellingPrice = parseFloat(sellingPrice.toString().replace(/,/g, ''));
                    
                    (scrGrantedAmount == "") ? scrGrantedAmount = parseFloat(0) : scrGrantedAmount = parseFloat(scrGrantedAmount.toString().replace(/,/g, ''));
                    (scrBalanceAmount == "") ? scrBalanceAmount = parseFloat(0) : scrBalanceAmount = parseFloat(scrBalanceAmount.toString().replace(/,/g, ''));
                    (downPayment == "") ? downPayment = parseFloat(0) : downPayment = parseFloat(downPayment.toString().replace(/,/g, ''));
                    (scrDiscount == "") ? scrDiscount = parseFloat(0) : scrDiscount = parseFloat(scrDiscount.toString().replace(/,/g, ''));
                    (commission == "") ? commission = parseFloat(0) : commission = parseFloat(commission.toString().replace(/,/g, ''));
                    
                    console.log("sellingPrice: "+sellingPrice);
                    console.log("processBranch: "+processBranch);
                    console.log("ropaBranch: "+ropaBranch);
                    console.log("scrGrantedAmount: "+scrGrantedAmount);
                    console.log("scrBalanceAmount: "+scrBalanceAmount);
                    console.log("downPayment: "+downPayment);
                    console.log("loanID: "+loanID);
                    console.log("scrDiscount: "+scrDiscount);
                    console.log("commission: "+commission);
                    
                    processBranch = parseInt(processBranch);
                    ropaBranch = parseInt(ropaBranch);
                    
                    if(loanID == "" || loanID == null || loanID=="null"){
                        notify.message("SCR Account is required|error|alert");
                    }else if(sellingPrice <= 0){
                        notify.message("Invalid Selling price |error|alert");
                    }else if(downPayment < 0){
                        notify.message("Invalid downpayment amount |error|alert");
                    }else if(scrDiscount < 0){
                        notify.message("Invalid SCR Discount amount |error|alert");
                    }else if(commission < 0){
                        notify.message("Invalid commission amount |error|alert");
                    }else if(reference == "" || reference == null || reference=="null"){
                       notify.message("Reference is required |error|alert");
                    }else if(particulars == "" || particulars == null || particulars=="null"){
                       notify.message("Particulars is required |error|alert");
                    }else{
                        alertify.confirm(AppTitle,'Are you sure you want to continue ROPA Sale?',
                            function(){
                                    checkIfAllowed('LON02002', 'form#create', 'Create ROPA Sale', null); 
                                },
                                function(){
                                    alertify.error('Canceled.');
                            }); 
                    }
                }
            </g:javascript>    
            <div id="create-ropa" class="content scaffold-create" role="main">
		<g:if test="${flash.message}">
                    <div class="message" role="status">${flash.message}</div>
		</g:if>
		<g:hasErrors bean="${collateralInstance}">
                    <ul class="errors" role="alert">
			<g:eachError bean="${collateralInstance}" var="error">
			<li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error.field} - ${error}"/></li>
			</g:eachError>
                    </ul>
		</g:hasErrors>
                <table class="table table-bordered table-striped">
                    <tbody>
                        <tr>
                            <td style="font-weight:bold" width="30%">ROPA Branch</td>
                            <td width="70%">${collateralInstance?.loan?.branch?.name}</td>
                        </tr>
                        <tr>
                            <td style="font-weight:bold" width="30%">TCT Number</td>
                            <td width="70%">${collateralInstance?.newTct}</td>
                        </tr>
                        <tr>
                            <td style="font-weight:bold" width="30%">Kind of Land</td>
                            <td width="70%">${collateralInstance?.kindOfLand}</td>
                        </tr>
                        <tr>
                            <td style="font-weight:bold" width="30%">Location</td>
                            <td width="70%">${collateralInstance?.location}</td>
                        </tr>
                        <tr>
                            <td style="font-weight:bold" width="30%">Latest Appraised Value (Total)</td>
                            <td width="70%"><g:formatNumber format="###,###,##0.00" number="${collateralInstance?.landAppraisal + collateralInstance?.buildingAppraisal + collateralInstance?.otherAppraisal}"/></td>
                        </tr>
                        <tr>
                            <td style="font-weight:bold" width="30%">ROPA Amount (Gross)</td>
                            <td width="70%"><g:formatNumber format="###,###,##0.00" number="${collateralInstance?.ropaLandAmt + collateralInstance?.ropaBldgAmt + collateralInstance?.ropaOtherAmt}"/></td>
                        </tr>
                        <tr>
                            <td style="font-weight:bold" width="30%">ROPA Net Book Value</td>
                            <td width="70%"><g:formatNumber format="###,###,##0.00" number="${collateralInstance?.ropaLandAmt + collateralInstance?.ropaBldgAmt + collateralInstance?.ropaOtherAmt 
                                - collateralInstance?.buildingAccDepreciation - collateralInstance?.otherAccDepreciation
                                - collateralInstance?.allowanceProbLoss - collateralInstance?.allowanceProbLossBldg - collateralInstance?.allowanceProbLossOtherProp}"/></td>
                         </tr>

                        <%-- DO NOT ERASE HIDDEN FIELDS THIS IS FOR VALIDATION PURPOSES --%>
                        <g:hiddenField name="processBranch" id="processBranch" value="${UserMaster.get(session.user_id).branch.id}" />
                        <g:hiddenField name="ropaBranch" id="ropaBranch" value="${collateralInstance?.loan?.branch?.id}" />
                        <g:hiddenField name="scrGrantedAmount" id="scrGrantedAmount" value="" />
                         <g:hiddenField name="scrBalanceAmount" id="scrBalanceAmount" value="" />
                    </tbody>
                </table> 
		<g:form id="create" url="[controller:'ropa', action:'saveRopaSaleInst']" onsubmit="callLoadingDialog();" >
                    <fieldset class="form">
			<g:render template="ropaSaleInstForm"/>
                    </fieldset>
		</g:form>
            </div>
	</content>
	<content tag="main-actions">
            <ul>
                <li><button onclick="validateRopaSaleInst();">Create</button></li>
		<li><g:link action="ropaForSale"><g:message code="default.cancel.label" args="[entityName]" default="Cancel" /></g:link></li>
            </ul>
	</content>
    </body>
</html>