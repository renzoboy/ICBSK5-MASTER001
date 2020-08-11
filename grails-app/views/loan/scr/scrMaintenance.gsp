<!--
  To change this license header, choose License Headers in Project Properties.
  To change this template file, choose Tools | Templates
  and open the template in the editor.
-->
<!--
  To change this license header, choose License Headers in Project Properties.
  To change this template file, choose Tools | Templates
  and open the template in the editor.
-->
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="icbs.loans.ROPA" %>
<%@ page import="icbs.loans.ScrRopa" %>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="layout" content="main"> 
        <title>Sales Contract Receivable Transaction</title>
        <g:javascript>
            function updateLoanApplicationAjax(params) {
		console.log("params: "+params );
                
                
                if (params.loanApplication2) {
                    $('#ropaididid').val(params.loanApplication2);
                    console.log("paramsssss: "+params.loanApplication2);
                    var obj = { 
                        id: params.loanApplication2,
                    }; 
                    //console.log(JSON.stringify(obj));
                    //console.log("Object Loaded iwth data...");
                    $.ajax({
                        type: "POST",
                        contentType: "application/json",
                        url: "${createLink(controller:'loan', action:'collectionInformation')}",
                        data: JSON.stringify(obj),

                        success: function(data){

                            $.each(data, function (_key, _value) {
                                //console.log(JSON.stringify(data));
                                //console.log(_value.customer_display_name);
                                $('#customerDisplayName').val(_value.customer_display_name);
                                $('#lnaccountNo').val(_value.loan_acct_no);
                            });
                        },
                        error: function(data){

                        },

                    });       
                    
                    
                }
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
            function showRopaSearch() {
                modal = new icbs.UI.Modal({id:"ropaModal", url:"${createLink(controller: 'scr', action:'search')}", title:"Search ROPA", onCloseCallback:updateLoanApplicationAjax});
                modal.show();                   
        } 
        icbs.Dependencies.Ajax.addLoadEvent(function(){
                updateLoanApplicationAjax({loanApplication2:"${ropa?.id}"});
            });
		</g:javascript>	
    </head>
    <body>
        <content tag="main-content">
             <table class="table table-bordered table-striped">
                <legend>Loan Specification</legend>
                <tr>
                    <td style="font-weight:bold" width="30%">PN No.</td>
                    <td width="70%"><span>${loanInstance?.pnNo}</span></td>
                </tr>
                <tr>
                    <td style="font-weight:bold" width="30%">Account Number</td>
                    <td width="70%"><span>${loanInstance?.accountNo}</span></td>
                </tr>     
                <tr>
                    <td style="font-weight:bold" width="30%">Borrower Name</td>
                    <td width="70%"><span>${loanInstance?.customer?.displayName}</span></td>
                </tr>
                <tr>
                    <td style="font-weight:bold" width="30%">Date Opened</td>
                    <td width="70%"><span><g:formatDate format="MM/dd/yyyy" date="${loanInstance?.openingDate}"/></span></td>
                </tr>     
                <tr>
                    <td style="font-weight:bold" width="30%">Loan Granted Amount</td>
                    <td width="70%"><span><g:formatNumber format="###,###,##0.00" number="${loanInstance?.grantedAmount}"/></span></td>
                </tr>
                <tr>
                    <td style="font-weight:bold" width="30%">Loan Balance</td>
                    <td width="70%"><span><g:formatNumber format="###,###,##0.00" number="${loanInstance?.balanceAmount}"/></span></td>
                </tr>                
            </table>
            <div class="panel panel-default">
                <div class = "panel-heading">
                    <h4>Transaction Details</h4>
                </div>
               <div class="panel-body">
                    <g:form id="deposit" url="[controller:loan, action:'saveScrMaintenance']" method="PUT" >
                        <fieldset class="form">
                        <br>
                            <div class="col-xs-10 col-sm-11">
                                <div class="fieldcontain form-group ${hasErrors(bean: ropaInstance, field: 'ropa', 'has-error')} required">
                                        <label class="control-label col-sm-4" for="ropa">
                                                <g:message code="ScrRopa.ropa.label" default="ROPA Name" />
                                        </label>
                                        <div class="col-sm-7"><g:field name="customerDisplayName" id="customerDisplayName" value="${ropaInstance?.customerDisplayName}" disabled="disable" class="form-control"/>

                                            <g:hasErrors bean="${ropaInstance}" field="ropaLoanAcctNo">
                                                <div class="controls">
                                                        <span class="help-block">
                                                            <g:eachError bean="${ropaInstance}" field="ropa">
                                                                <g:message error="${it}" /><br/>
                                                            </g:eachError>
                                                        </span>
                                                </div>
                                            </g:hasErrors>
                                        </div> 
                                    <div class="col-sm-2"><input type="button" href="#" class="btn btn-secondary" onclick="showRopaSearch()" value="Search"/></div> 
                                </div> 
                                <div id="ifLoanApplicationSearch">
                                    <div class="fieldcontain form-group ${hasErrors(bean: ropaInstance, field: 'loanAcctNo', 'has-error')} required">
                                            <label class="control-label col-sm-4" for="loanAcctNo">
                                                    <g:message code="creditInvestigation.ciName.label" default="Loan Account" />
                                            </label>
                                            <div class="col-sm-8"><g:field name="lnaccountNo" id="lnaccountNo" value="${ropaInstance?.loanAcctNo}" disabled="disable" class="form-control"/>

                                                <g:hasErrors bean="${creditInvestigationInstance}" field="loanAcctNo">
                                                    <div class="controls">
                                                            <span class="help-block">
                                                                <g:eachError bean="${creditInvestigationInstance}" field="loanAcctNo">
                                                                    <g:message error="${it}" /><br/>
                                                                </g:eachError>
                                                            </span>
                                                    </div>
                                                </g:hasErrors>
                                            </div>             
                                    </div>
                                </div> 
                                 
                                 <g:hiddenField name="scrId" id="scrId" value="${params?.id}" />
                                 
                                 <g:hiddenField name="ropaididid" id="ropaididid" value="${ropaInstance?.id}" />
                                 
                            <div class="fieldcontain form-group">
                                <label class="control-label col-sm-4" for="remarks">Remarks<span class="required-indicator">*</span></label>                         
                                <div class="col-sm-8">
                                    <g:field class="form-control" id="remarks" name="remarks" value="" />
                                </div>             
                            </div>
                        </fieldset>
                    </g:form>  
                </div>
            </div>
        </content>    
        <content tag="main-actions">
            <ul>   
                <li><g:submitButton id="saveScrMaintenance" name="saveScrMaintenance" value="saveScrMaintenance" value="${message(code: 'default.button.Save.label', default: 'Link To Ropa')}" onclick="
                        alertify.confirm(AppTitle,'Are you sure you want to continue this transaction?',
                                function(){
                                     checkIfAllowed('CFG00303', 'form#deposit', 'save.', null); 
                                },
                                function(){
                                    return;
                                });     
                        "/></li>
                <li><g:link action="show" id="${loanInstance.id}" >Return to Loan Inquiry</g:link></li>
            </ul>
        </content>
    </body>
