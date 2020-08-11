<!--
  To change this license header, choose License Headers in Project Properties.
  To change this template file, choose Tools | Templates
  and open the template in the editor.
-->

<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="icbs.gl.GlContigentAccount" %>
<!DOCTYPE html>


<html>
    <head>

	<meta name="layout" content="main">
	
        <g:set var="entityName" value="${message(code: 'ContigentAccount.label', default: 'Contigent Account')}" />
		<title>Create Contigent Account</title>
                
       <script>
           function updateLoanDetailsAjax(params) {
                if (params.loan2) {
                    $('#loan').val(params.loan2);

                    $.ajax({
                        type: 'POST',
                        data: {id:params.loan2},
                        url: "${createLink(controller:'loan', action:'getLoanDetailsAjax')}",
                        success: function(msg){
                                console.log("JMMMMMMM"+msg);
                                    $('#accountNo').val($(msg).find('#account-no').html());	
                                    $('#customer').html($(msg).find('#customer').html());
                                    $('#granted-amount').html($(msg).find('#granted-amount').html());
                                    $('#interest-rate').html($(msg).find('#interest-rate').html());
                                    $('#maturity-date').html($(msg).find('#maturity-date').html());
                                    $('#total-net-proceeds').html($(msg).find('#total-net-proceeds').html());
                                    $('#total-disbursement-amount').html($(msg).find('#total-disbursement-amount').html());
                                    $('#overdue-principal-balance').html($(msg).find('#overdue-principal-balance').html());
                                    $('#principal-balance').html($(msg).find('#principal-balance').html());
                                    $('#interest-balance').html($(msg).find('#interest-balance').html());
                                    $('#penalty-balance').html($(msg).find('#penalty-balance').html());
                                    $('#service-charge-balance').html($(msg).find('#service-charge-balance').html());
                        },
                        error:function(XMLHttpRequest,textStatus,errorThrown){
                            alert(XMLHttpRequest+textStatus+errorThrown);
                        }
                    });
                }
            }

	    function showLoanSearch() {				
                modal = new icbs.UI.Modal({id:"loanModal", url:"${createLink(controller: 'loan', action:'search')}", title:"Search Loan Account", onCloseCallback:updateLoanDetailsAjax});
                modal.show();
            }
            function validateInputs(){
             //currentCustodian/registeredMortgage/remarks/reference/particulars
                var loanID = $('#loan').val();
                var contigentss = $('#contigent').val();
                var titleNo = $('#titleNo').val();
                var nominalValue = $('#nominalValue').val();
                var currentCustodian = $('#currentCustodian').val();
                var registeredMortgage = $('#registeredMortgage').val();
                var remarks = $('#remarks').val();
                var reference = $('#reference').val();
                var particulars = $('#particulars').val();
                
                console.log("loanID: "+loanID);
                console.log("contigentss: "+contigentss);
                console.log("titleNo: "+titleNo);
                console.log("nominalValue: "+nominalValue);
                console.log("currentCustodian: "+currentCustodian);
                console.log("registeredMortgage: "+registeredMortgage);
                console.log("remarks: "+remarks);
                console.log("reference: "+reference);
                console.log("particulars: "+particulars);
                
                if(loanID=="" || loanID==null){
                    notify.message('Please Select Loan Account!|error|alert'); 
                }
                
                else if(titleNo == "" || titleNo == null){
                    notify.message('Field Title No cannot be empty!|error|alert'); 
                }
                else if(contigentss =="" || contigentss === null){
                    notify.message('Please Select Contigent Type !|error|alert'); 
                }
                else if(nominalValue=="" || nominalValue==null){
                    notify.message('Field Nominal Value cannot be empty|error|alert'); 
                }
                else if(currentCustodian=="" || currentCustodian==null){
                    notify.message('Field Current Custodian cannot be empty|error|alert'); 
                }
                else if(registeredMortgage=="" || registeredMortgage==null){
                    notify.message('Field Registered Mortgage cannot be empty|error|alert'); 
                }
                else if(remarks=="" || remarks==null){
                    notify.message('Field Remarks cannot be empty|error|alert'); 
                }
                else if(reference=="" || reference==null){
                    notify.message('Field Reference cannot be empty|error|alert'); 
                }
                else if(particulars=="" || particulars==null){
                    notify.message('Field Particulars cannot be empty|error|alert'); 
                }
                else{
                    registeredMortgage = parseFloat(registeredMortgage.toString().replace(/,/g , ""));
                    nominalValue = parseFloat(nominalValue.toString().replace(/,/g , ""));
                    if(registeredMortgage < 0){
                        notify.message('Field Registered Mortgage cannot be negative|error|alert'); 
                    }
                    
                    else if(nominalValue < 0){
                        notify.message('Field Nominal Value cannot be negative|error|alert');
                    }
                    else{
                        alertify.confirm(AppTitle,"Are you sure you want to create this?",
                            function(){
                              $('#myFormcontigent').submit();
                            },
                            function(){
                              alertify.error('Cancel');
                            }
                        );
                    }
                }
                
            }
            function validateContigent(x){
                console.log();
            }
       </script>    
    </head>
    <body>
        
  		<content tag="breadcrumbs">
          <span class="fa fa-chevron-right"></span><span class="current">Create Contigent Account</span>
		</content>

        <content tag="main-content">  
<legend></legend>

<%-- START OF CODING CONTIGENT--%>
<g:form name="myFormcontigent" id="myFormcontigent" url="[action:'savecontigent',controller:'GlContAcct']" onsubmit="callLoadingDialog();">
<div class="fieldcontain form-group ${hasErrors(bean: loanLedgerInstance, field: 'loan', 'has-error')} ">
	<label class="control-label col-sm-4" for="loan">
		<g:message code="loanLedger.loan.label" default="Loan Account" />
        <span class="required-indicator">*</span>
	</label>
	<div class="col-sm-7"><g:field name="accountNo" id="accountNo" value="" class="form-control" readonly="true"/>        

       
    </div>             

    <div class="col-sm-2"><input type="button" href="#" class="btn btn-secondary" onclick="showLoanSearch()" value="Search"/></div>
</div>

<g:hiddenField id="loan" name="loan.id" value="" />

<br/><br/>
<div class="fieldcontain form-group ${hasErrors(bean: loanLedgerInstance, field: 'loan', 'has-error')} ">
<table class="table table-bordered table-rounded table-striped table-hover">
    <tbody>
        <tr>
            <td style="width:30%"><label>Customer</label></td>
            <td style="width:70%" id="customer"></td>    
        </tr>
        <tr>
            <td style="width:30%"><label>Granted Amount</label></td>
            <td style="width:70%" id="granted-amount"></td>    
        </tr>
        <tr>
            <td style="width:30%"><label>Interest Rate</label></td>
            <td style="width:70%" id="interest-rate"></td>    
        </tr>
        <tr>
            <td style="width:30%"><label>Maturity Date</label></td>
            <td style="width:70%" id="maturity-date"></td>    
        </tr>
        <tr>
            <td style="width:30%"><label>Total Net Proceeds</label></td>
            <td style="width:70%" id="total-net-proceeds"></td>    
        </tr>
        <tr>
            <td style="width:30%"><label>Total Disburse Amount</label></td>
            <td style="width:70%" id="total-disbursement-amount"></td>    
        </tr>
        <tr>
            <td style="width:30%"><label>Principal Balance</label></td>
            <td style="width:70%" id="principal-balance"></td>    
        </tr>
        <tr>
            <td style="width:30%"><label>Overdue Principal Balance</label></td>
            <td style="width:70%" id="overdue-principal-balance"></td>    
        </tr>
    </tbody>
</table>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: customerInstance, field: 'customerCode1', 'has-error')} ">
            <label class="control-label col-sm-4" for="dosriCode">
                    <g:message code="customer.customerCode1.label" default="Contigent Type" />
                    <span class="required-indicator">*</span>
            </label>
            <div class="col-sm-8">
                <g:select id="contigent" name="contigent" from="${icbs.lov.ContigentAccount.findAllByStatus(true)}" optionKey="id" optionValue ="description" value="" class="form-control" onchange="validateContigent(this.value);"  />
                
                    <div class="controls">
                        <span style="color: red;" class="help-block" id="spancontigent">
                          
                        </span>
                    </div>
                 
            </div>
</div>
<div class="form-group fieldcontain ${hasErrors(bean: customerInstance, field: 'sssNo', 'has-error')} ">
            <label class="control-label col-sm-4"for="sssNo">
                    <g:message code="reference.label" default="Title No" />
                    <span class="required-indicator">*</span>
            </label>
             <div class="col-sm-8">
                <g:textField name="titleNo" id="titleNo" value="" class="form-control"/>
                    <div class="controls">
                        <span style="color: red;" class="help-block" id="spanreference">
                          
                        </span>
                    </div>  
             </div>
</div>
<div class="form-group fieldcontain ${hasErrors(bean: customerInstance, field: 'sssNo', 'has-error')} ">
            <label class="control-label col-sm-4"for="sssNo">
                    <g:message code="reference.label" default="Nominal Value" />
                    <span class="required-indicator">*</span>
            </label>
             <div class="col-sm-8">
                <g:field type="number" name="nominalValue" id="nominalValue" value="" class="form-control"/>
                    <div class="controls">
                        <span style="color: red;" class="help-block" id="spanreference">
                          
                        </span>
                    </div>  
             </div>
</div>
<div class="form-group fieldcontain ${hasErrors(bean: customerInstance, field: 'sssNo', 'has-error')} ">
            <label class="control-label col-sm-4"for="sssNo">
                    <g:message code="reference.label" default="Current Custodian" />
                    <span class="required-indicator">*</span>
            </label>
             <div class="col-sm-8">
                <g:textField name="currentCustodian" id="currentCustodian" value="" class="form-control"/>
                    <div class="controls">
                        <span style="color: red;" class="help-block" id="spanreference">
                          
                        </span>
                    </div>  
             </div>
</div>
<div class="form-group fieldcontain ${hasErrors(bean: customerInstance, field: 'sssNo', 'has-error')} ">
            <label class="control-label col-sm-4"for="sssNo">
                    <g:message code="reference.label" default="Registered Mortgage(Amount)" />
                    <span class="required-indicator">*</span>
                    
            </label>
             <div class="col-sm-8">
                <g:textField name="registeredMortgage" id="registeredMortgage" value="" class="form-control truncated"/>
                    <div class="controls">
                        <span style="color: red;" class="help-block" id="spanreference">
                          
                        </span>
                    </div>  
             </div>
</div>
<div class="form-group fieldcontain ${hasErrors(bean: customerInstance, field: 'sssNo', 'has-error')} ">
            <label class="control-label col-sm-4"for="sssNo">
                    <g:message code="reference.label" default="Remarks" />
                    <span class="required-indicator">*</span>
            </label>
             <div class="col-sm-8">
                <g:textField name="remarks" id="remarks" value="" class="form-control"/>
                    <div class="controls">
                        <span style="color: red;" class="help-block" id="spanreference">
                          
                        </span>
                    </div>  
             </div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: customerInstance, field: 'sssNo', 'has-error')} ">
            <label class="control-label col-sm-4"for="sssNo">
                    <g:message code="reference.label" default="Reference" />
                    <span class="required-indicator">*</span>
            </label>
             <div class="col-sm-8">
                
                <g:textField name="reference" id="reference" maxlength="50"  value="${customerInstance?.sssNo}"class="form-control"/>
                    <div class="controls">
                        <span style="color: red;" class="help-block" id="spanreference">
                          
                        </span>
                    </div>  
             </div>
</div>      
<div class="form-group fieldcontain ${hasErrors(bean: customerInstance, field: 'sssNo', 'has-error')} ">
            <label class="control-label col-sm-4"for="sssNo">
                    <g:message code="particulars.label" default="Particulars" />
                    <span class="required-indicator">*</span>
            </label>
             <div class="col-sm-8">
                <g:textArea name="particulars" id="particulars" value="${customerInstance}" rows="5" cols="40" class="form-control"/>
                    <div class="controls">
                        <span style="color: red;" class="help-block" id="spanparticular">
                          
                        </span>
                    </div>  
             </div>
</div>
</g:form>


</content>
        <!-- Action menus Right side menus -->
        <content tag="main-actions">
            <ul>
                <li><a href="#" onclick="validateInputs();">Create New Contigent Account</a></li>
                <li><g:link action="index" >Contigent Account List</g:link></li>
            </ul>
        </content>
    </body>
</html>           
            
            
