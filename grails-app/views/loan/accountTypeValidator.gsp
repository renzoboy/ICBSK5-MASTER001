
<%@ page import="icbs.admin.UserMaster" %>
<!DOCTYPE html>

<html>
    <head>
	<meta name="layout" content="main">
	<title>Create New Account</title>
    </head>
    <body>
        <content tag="breadcrumbs">
                <span class="fa fa-chevron-right"></span><span class="current">Create New Account</span>
        </content>
	<content tag="main-content">
            <g:javascript>
                function updateLoanApplicationAjax(params) {
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
                            url: "${createLink(controller:'loan', action:'applicationCollectInformation')}",
                            data: JSON.stringify(obj),

                            success: function(data){
                                var loanProductTypeId = "";
                                var loanAppApprovalStatusid = "";
                                console.log("loanProductTypeId: "+loanProductTypeId);
                                console.log("loanAppApprovalStatusid: "+loanAppApprovalStatusid);
                                
                                $.each(data, function (_key, _value) {
                                   
                                    console.log("_value.approval_status_id: "+_value.approval_status_id);
                                    loanAppApprovalStatusid = parseInt(_value.approval_status_id);
                                    loanProductTypeId = parseInt(_value.product_type_id);
                                    $('#lnaccountName').val(_value.display_name);
                                    $('#applicationDate').html(formatDate(_value.application_date));
                                    $('#product-name').html(_value.name);
                                    $('#grantedAmount').html(_value.amount);
                                    $('#customer-name').html(_value.display_name);
                                    $('#applicationStatus').html(_value.description);
                                    
                                });
                                
                                console.log("===================== ");
                                
                                
                                
                                if(parseInt(loanProductTypeId) == 7){
                                    //SCR application
                                    //check if status is in 9,10,11
                                    if(parseInt(loanAppApprovalStatusid) != 9 && loanAppApprovalStatusid != 10 && loanAppApprovalStatusid != 11){
                                        notify.message("Account Application not yet approved|info|alert");
                                    }
                                }else{
                                    // loan application
                                    if(parseInt(loanAppApprovalStatusid) < 6){
                                        notify.message("Account Application not yet approved|info|alert");
                                    }
                                }

                            },
                            error:function(XMLHttpRequest,textStatus,errorThrown){
                                alert(XMLHttpRequest+textStatus+errorThrown);
                            }
                        });
                    } // end if
                }
                function formatDate(date) {
                    var d = new Date(date),
                        month = '' + (d.getMonth() + 1),
                        day = '' + d.getDate(),
                        year = d.getFullYear();

                    if (month.length < 2) month = '0' + month;
                    if (day.length < 2) day = '0' + day;

                    return [year, month, day].join('/');
                }
                function showLoanApplicationSearch() {
                    modal = new icbs.UI.Modal({id:"loanApplicationModal", url:"${createLink(controller: 'ropa', action:'search')}", title:"Search Loan Application", onCloseCallback:updateLoanApplicationAjax});
                    modal.show();
                }
                icbs.Dependencies.Ajax.addLoadEvent(function(){
                    updateLoanApplicationAjax({loanApplication2:"${loanApplication?.id}"});
                });
                function validateCreateLoanAcct(){
                    var loanapp = $('#loanApplication').val();
                    console.log("loanapp: "+loanapp);
                    if(loanapp == "" || loanapp == null || loanapp == "null"){
                        notify.message("Please Select Account Application First |error|alert");
                    }else{
                        alertify.confirm(AppTitle,"Are you sure you sure about this ?",
                        function(){
                             
                            window.location.href = "/icbs/loan/create/"+loanapp;
                        },
                        function(){
                          alertify.error('Canceled..');
                        });
                    }
                    
                    
                }
                


                
            </g:javascript>
            <div id="create-ropa" class="content scaffold-create" role="main">
		<g:if test="${flash.message}">
                    <div class="message" role="status">${flash.message}</div>
		</g:if>
		
		<g:form id="create" url="[controller:'ropa', action:'saveRopaSaleCash']" onsubmit="callLoadingDialog();" >
                    
			<g:hiddenField name="id" id="id" value="${params?.id}" />
                    <div class="fieldcontain form-group ${hasErrors(bean: loanInstance, field: 'loanApplication', 'has-error')} required">
                        <label class="control-label col-sm-4" for="loanApplication">
                            <g:message code="loan.loanApplication.label" default="Account Application " />
                            <span class="required-indicator">*</span>
                        </label>
                        <div class="col-sm-7"><g:field name="loanApplication" id="loanApplication" type="number" value="${loanInstance?.loanApplication?.id}" class="form-control" readonly="true"/>
                            <g:hasErrors bean="${loanInstance}" field="loanApplication">
                                <div class="controls">
                                        <span class="help-block">
                                            <g:eachError bean="${loanInstance}" field="loanApplication">
                                                <g:message error="${it}" /><br/>
                                            </g:eachError>
                                        </span>
                                </div>
                            </g:hasErrors>
                        </div>

                        <g:if test="${!reschedule}">
                        <div class="col-sm-2"><input type="button" href="#" class="btn btn-secondary" onclick="showLoanApplicationSearch()" value="Search"/></div>
                        </g:if>
                    </div>
                       
                    <br/><br/>
                    <div id="customer-info">    
                        <div class="section-container">
                            <legend class="section-header">Account Information</legend>
                            <div class="table-responsive">
                                <table class="table table-bordered table-striped">
                                    <tbody>

                                        <tr>
                                            <td style="font-weight:bold" width="30%">Customer</td>
                                            <td width="70%"><span id="customer-name"></span></td>
                                        </tr>
                                        <tr>
                                            <td style="font-weight:bold" width="30%">Application Amount</td>
                                            <td width="70%"><span id="grantedAmount"></span></td>
                                        </tr>
                                        <tr>
                                            <td style="font-weight:bold" width="30%">Product</td>
                                            <td width="70%"><span id="product-name"></span></td>
                                        </tr>
                                        <tr>
                                            <td style="font-weight:bold" width="30%">Application Date</td>
                                            <td width="70%"><span id="applicationDate"></span></td>
                                        </tr>
                                        <tr>
                                            <td style="font-weight:bold" width="30%">Application Status</td>
                                            <td width="70%"><span id="applicationStatus"></span></td>
                                        </tr>

                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>   
                    
		</g:form>
            </div>
	</content>
	<content tag="main-actions">
            <ul>
                <li><button onclick="validateCreateLoanAcct();">Create Account</button></li>
		<li><g:link action="ropaForSale"><g:message code="default.cancel.label" args="[entityName]" default="Cancel" /></g:link></li>
            </ul>
	</content>
    </body>
</html>
