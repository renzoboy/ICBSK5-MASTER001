<%@ page import="icbs.gl.AccountsPayable" %>
<%@ page import="icbs.gl.GlAccount" %>
<!DOCTYPE html>
<html>
    <head>
	<meta name="layout" content="main">
	<title>SCR Discount Schedule Debit Details</title>
    </head>
    <body>
        <content tag="breadcrumbs">
            <span class="fa fa-chevron-right"></span><a href="${createLink(uri: '/showDiscountSchedule')}">SCR Discount Schedule</a>
            <span class="fa fa-chevron-right"></span><span class="current">SCR Discount Scheule Debit details</span>
        </content>
        <content tag="main-content">
            <div class="content scaffold-show" role="main">
            <g:if test="${flash.message}">
                <div class="box-body">
                    <div class="alert alert-info alert-dismissable">
                        <i class="fa fa-info"></i>
                        <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                        <b>Message</b> <div class="message" role="status">${flash.message}</div>
                    </div>
                </div>
            </g:if>
            
            <legend class="section-header">SCR Account Information</legend>
            <table class="table table-bordered table-rounded table-striped table-hover">
                <tbody>
                    <tr>
                        <td style="width: 30%;"><label>SCR Account Number</label></td>
                        <td style="width: 70%;">${loanInstance?.accountNo}</td>    
                    </tr> 
                    <tr>
                        <td><label>Account Name</label></td>
                        <td>${loanInstance?.customer?.displayName}</td>    
                    </tr>
                    <tr>
                        <td><label>Balance amount</label></td>
                        <td><g:formatNumber format="###,###,##0.00" number="${loanInstance?.balanceAmount}"/></td>    
                    </tr>
                    <tr>
                        <td><label>SCR Performance Status</label></td>
                        <td>${loanInstance?.loanPerformanceId.description}</td>    
                    </tr>
                    <tr>
                        <td><label>SCR Status</label></td>
                        <td>${loanInstance?.status.description}</td>    
                    </tr>
                </tbody>
            </table> 
            <div class="panel panel-default">
                <div class = "panel-heading">
                    <h4>Transaction Details</h4>
                </div>
                    <div class="panel-body">
                        <g:form id="scrDiscount" url="[action:'saveScrDiscountSchedule', controller: 'loan']" method="POST" onsubmit="callLoadingDialog();" >
                            <fieldset class="form">
                                
                                
                                    <div class="fieldcontain form-group">
                                        <label class="control-label col-sm-4" for="intRate">Discount Schedule Date<span class="required-indicator">*</span></label>                         
                                        <div class="col-sm-8">
                                            <g:customDatePicker id="scheduleDate" name="scheduleDate" precision="day" class="form-control" value="" />
                                            
                                        </div>             
                                    </div>
                                    <div class="fieldcontain form-group">
                                        <label class="control-label col-sm-4" for="intRate">Debit Amount<span class="required-indicator">*</span></label>                         
                                        <div class="col-sm-8">
                                            <g:field class="form-control truncated" id="debitAmt" name="debitAmt" value="" />
                                            
                                        </div>             
                                    </div>
                                
                                
                                    <div class="fieldcontain form-group">
                                        <label class="control-label col-sm-4" for="intRate">Credit Amount<span class="required-indicator">*</span></label>                         
                                        <div class="col-sm-8">
                                            <g:field class="form-control truncated" id="creditAmt" name="creditAmt" value="" />
                                            
                                        </div>             
                                    </div>
                                  
                                <g:hiddenField name="loanId" id="loanId" value="${params?.id}" />
                                
                                <div class="fieldcontain form-group">
                                    <label class="control-label col-sm-4" for="intRate">Reference <span class="required-indicator">*</span></label>
                                    <div class="col-sm-8">
                                        <g:field class="form-control" type="Text"  id="reference"  name="reference" value="" />
                                    </div>             
                                </div>   
                                <div class="fieldcontain form-group">
                                    <label class="control-label col-sm-4" for="intRate">Particulars <span class="required-indicator">*</span></label>     
                                    <div class="col-sm-8">
                                        <g:field class="form-control" type="Text" id="particulars"   name="particulars" value="" />
                                    </div>             
                                </div>   
                            </fieldset>
                        </g:form>  
                    </div>
            </div>
            </div>
            <g:javascript>
                function validateScrDiscountSchedule(){
                
                    var scheduleDate = $('#scheduleDate').val()
                    var debitAmt = $('#debitAmt').val()
                    var creditAmt = $('#creditAmt').val();
                    var reference = $('#reference').val();
                    var particulars = $('#particulars').val();
                    
                    console.log("scheduleDate: "+scheduleDate);
                    console.log("debitAmt: "+debitAmt);
                    console.log("creditAmt: "+creditAmt);
                    console.log("reference: "+reference);
                    console.log("particulars: "+particulars);

                    if(scheduleDate == "" || scheduleDate == null || scheduleDate=="null"){
                        notify.message("Please select Date for Discount Schedule |error|alert");
                    }else if(reference == "" || reference == null || reference=="null"){
                        notify.message("Please input for reference |error|alert");
                    }else if(particulars == "" || particulars == null || particulars=="null"){
                        notify.message("Please input for particulars |error|alert");
                    }else{
                        if(debitAmt == ""){
                            debitAmt = 0.00;
                            $('#debitAmt').val(debitAmt);
                        }
                        if(creditAmt == ""){
                            creditAmt = 0.00;
                            $('#creditAmt').val(creditAmt);
                        }
                        debitAmt = parseFloat(debitAmt.toString().replace(/,/g, ''));
                        creditAmt = parseFloat(creditAmt.toString().replace(/,/g, ''));
                        
                        if(debitAmt < 0){
                            notify.message("Invalid Debit amount |error|alert");
                        }else if(creditAmt < 0){
                            notify.message("Invalid Credit amount |error|alert");
                        }else{
                            alertify.confirm(AppTitle,'Are you sure you want to save this details?',
                                function(){
                                    
                                    $('#scrDiscount').submit();
                                },
                                function(){
                                     alertify.error('Canceled');
                                }
                            );    
                        }
                    }
                }
            </g:javascript>
        </content>		

        <content tag="main-actions">
            <ul>
                <li><button onclick="validateScrDiscountSchedule();">Save</button></li>
                <li><g:link action="showDiscountSchedule" controller="loan" id="${loanInstance.id}">Back to  SCR Discount Schedule</g:link></li>          
                <li><g:link action="show" controller="loan" id="${loanInstance.id}">Back to  SCR Account Inquiry</g:link></li>   
            </ul>
        </content>
    </body>
</html>
