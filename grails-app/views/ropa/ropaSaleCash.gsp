<%@ page import="icbs.loans.RopaTransfer" %>
<%@ page import="icbs.loans.RopaCollateralDetails" %>
<%@ page import="icbs.admin.UserMaster" %>
<!DOCTYPE html>

<html>
    <head>
	<meta name="layout" content="main">
	<title>ROPA Sale - Cash</title>
    </head>
    <body>
        <content tag="breadcrumbs">
                <span class="fa fa-chevron-right"></span><span class="current">ROPA Sale Cash</span>
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
                            url: "${createLink(controller:'ropa', action:'collectionInformation')}",
                            data: JSON.stringify(obj),

                            success: function(data){

                                $.each(data, function (_key, _value) {
                                    //console.log(JSON.stringify(data));
                                    //console.log(_value.display_name);
                                    console.log("_value.approval_status_id: "+_value.approval_status_id);
                                    var loanAppStatus = parseInt(_value.approval_status_id);
                                    if(loanAppStatus != 9 && loanAppStatus != 10 && loanAppStatus != 11){

                                        alertify.alert(AppTitle,"Invalid SCR Application Status- Should be Approve by EC / Board / President ", function(){
                                            location.reload();
                                        });
                                    }
                                    $('#lnaccountName').val(_value.display_name);

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
                icbs.Dependencies.Ajax.addLoadEvent(function(){
                    updateLoanApplicationAjax({loanApplication2:"${loanApplication?.id}"});
                });


                function validateRopaSaleCash(){


                    var sellingPrice = $('#sellingPrice').val();
                    var grtAmt = $('#grt').val();
                    var commission = $('#commission').val();
                    var processBranch = $('#processBranch').val();
                    var ropaBranch = $('#ropaBranch').val();
                    var loanApplication = $('#loanApplication').val();
                    var reference = $('#reference').val();
                    var particulars = $('#particulars').val();
                    (sellingPrice == "") ? sellingPrice = parseFloat(0) : sellingPrice = parseFloat(sellingPrice.toString().replace(/,/g, ''));
                    (commission == "") ? commission = parseFloat(0) : commission = parseFloat(commission.toString().replace(/,/g, ''));

                    console.log("sellingPrice: "+sellingPrice);
                    console.log("commission: "+commission);
                    console.log("processBranch: "+processBranch);
                    console.log("ropaBranch: "+ropaBranch);

                    processBranch = parseInt(processBranch);
                    ropaBranch = parseInt(ropaBranch);

                    if(loanApplication == ""){
                        notify.message("SCR Application Information is required !|error|alert");
                    }else if(sellingPrice <= 0){
                        notify.message("Invalid Selling Price !|error|alert");
                    }else if(reference == "null" || reference == "" || reference == null){
                        notify.message("Reference is required !|error|alert");
                    }else if(particulars == "null" || particulars == "" || particulars == null){
                        notify.message("Particulars is required !|error|alert");
                    }else{
                        alertify.confirm(AppTitle,'Are you sure you want to continue ROPA Sale?',
                            function(){
                                    checkIfAllowed('LON02002', 'form#create', 'Create ROPA Sale', null);
                                },
                                function(){
                                    return;
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
                        <g:hiddenField name="ropaBranch" id="ropaBranch" value="${RopaTransfer.findByRopaCollateralDetails(collateralInstance).loan.branch.id}" />

                    </tbody>
                </table>
		<g:form id="create" url="[controller:'ropa', action:'saveRopaSaleCash']" onsubmit="callLoadingDialog();" >
                    <fieldset class="form">
			<g:render template="ropaSaleCashForm"/>
                    </fieldset>
		</g:form>
            </div>
	</content>
	<content tag="main-actions">
            <ul>
                <li><button onclick="validateRopaSaleCash();">Create</button></li>
		<li><g:link action="ropaForSale"><g:message code="default.cancel.label" args="[entityName]" default="Cancel" /></g:link></li>
            </ul>
	</content>
    </body>
</html>
