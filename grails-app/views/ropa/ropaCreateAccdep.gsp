<%@ page import="icbs.gl.AccountsPayable" %>
<%@ page import="icbs.gl.GlAccount" %>
<!DOCTYPE html>
<html>
    <head>
	<meta name="layout" content="main">
        <g:if test="${params?.actionType == "debit"}">
            <title>Debit Ropa Accumulated Depreciation Details</title>
        </g:if>  
        <g:else>
            <title>Credit Ropa Accumulated Depreciation Details</title>
        </g:else>    
    </head>
    <body>
        <content tag="breadcrumbs">
            <span class="fa fa-chevron-right"></span><a href="${createLink(uri: '/showRopaAccDepDetails')}">Ropa Accumulated Depreciation Details</a>
            <span class="fa fa-chevron-right"></span><span class="current">Create Ropa Accumulated Depreciation Detail</span>
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
            
            
            <div class="panel panel-default">
                <div class = "panel-heading">
                    <h4>Record Details</h4>
                </div>
                    <div class="panel-body">
                        <g:form id="ropaAccDep" url="[action:'saveRopaAccDep', controller: 'ropa']" method="POST" onsubmit="callLoadingDialog();" >
                            <fieldset class="form">
                                
                                    <div class="fieldcontain form-group">
                                        <label class="control-label col-sm-4" for="intRate">Record Date<span class="required-indicator">*</span></label>                         
                                        <div class="col-sm-8">
                                            <g:field class="form-control" id="xx" name="xx" value="${icbs.admin.Branch.get(1).runDate.format("YYYY/MM/dd")}" readonly="true"/>
                                            
                                        </div>             
                                    </div>
                                    <g:if test="${params?.actionType == "debit"}">
                                        <div class="fieldcontain form-group">
                                            <label class="control-label col-sm-4" for="intRate">Debit Building Accumulated Depreciation Amount<span class="required-indicator">*</span></label>                         
                                            <div class="col-sm-8">
                                                <g:field class="form-control truncated" id="debitAmt" name="debitAmt" value="" />
                                                <g:hiddenField name="creditAmt" id="creditAmt" value="0.00" />
                                            </div>             
                                        </div>
                                        <div class="fieldcontain form-group">
                                            <label class="control-label col-sm-4" for="intRate">Debit Other Accumulated Depreciation Amount<span class="required-indicator">*</span></label>                         
                                            <div class="col-sm-8">
                                                <g:field class="form-control truncated" id="debitAmtOth" name="debitAmtOth" value="" />
                                                <g:hiddenField name="creditAmtOth" id="creditAmtOth" value="0.00" />
                                            </div>             
                                        </div>
                                    </g:if>    
                                
                                    <g:else>
                                    <div class="fieldcontain form-group">
                                        <label class="control-label col-sm-4" for="intRate">Credit Building Accumulated Depreciation Amount<span class="required-indicator">*</span></label>                         
                                        <div class="col-sm-8">
                                            <g:field class="form-control truncated" id="creditAmt" name="creditAmt" value="" />
                                            <g:hiddenField name="debitAmt" id="debitAmt" value="0.00" />
                                        </div>             
                                    </div>
                                    <div class="fieldcontain form-group">
                                        <label class="control-label col-sm-4" for="intRate">Credit Other Accumulated Depreciation Amount<span class="required-indicator">*</span></label>                         
                                        <div class="col-sm-8">
                                            <g:field class="form-control truncated" id="creditAmtOth" name="creditAmtOth" value="" />
                                            <g:hiddenField name="debitAmtOth" id="debitAmtOth" value="0.00" />
                                        </div>             
                                    </div>
                                    </g:else>
                                          
                                <g:hiddenField name="ropaColleteralId" id="ropaColleteralId" value="${params?.id}" />
                                <g:hiddenField name="ropaBldgAmtss" id="ropaBldgAmtss" value="${ropaCollateralDetails.buildingAccDepreciation}" />
                                <g:hiddenField name="ropaOtherAmtss" id="ropaOtherAmtss" value="${ropaCollateralDetails.otherAccDepreciation}" />
                                
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
                function validateAccumulatedDepDetails(){
                
                    
                    var debitAmt = $('#debitAmt').val()
                    var creditAmt = $('#creditAmt').val();
                    var reference = $('#reference').val();
                    var particulars = $('#particulars').val();
                    var ropaBldgAmtss = $('#ropaBldgAmtss').val();
                    var ropaOtherAmtss = $('#ropaOtherAmtss').val();
                    var debitAmtOth = $('#debitAmtOth').val();
                    var creditAmtOth = $('#creditAmtOth').val();
                    
                    
                    console.log("debitAmt: "+debitAmt);
                    console.log("creditAmt: "+creditAmt);
                    console.log("reference: "+reference);
                    console.log("particulars: "+particulars);
                    console.log("ropaBldgAmtss: "+ropaBldgAmtss);
                    console.log("ropaOtherAmtss: "+ropaOtherAmtss);
                    console.log("debitAmtOth: "+debitAmtOth);
                    console.log("creditAmtOth: "+creditAmtOth);
                    
                    (ropaBldgAmtss == "") ? ropaBldgAmtss = parseFloat(0) : ropaBldgAmtss = parseFloat(ropaBldgAmtss.toString().replace(/,/g, ''));
                    (ropaOtherAmtss == "") ? ropaOtherAmtss = parseFloat(0) : ropaOtherAmtss = parseFloat(ropaOtherAmtss.toString().replace(/,/g, ''));
                    (creditAmt == "") ? creditAmt = parseFloat(0) : creditAmt = parseFloat(creditAmt.toString().replace(/,/g, ''));
                    (creditAmtOth == "") ? creditAmtOth = parseFloat(0) : creditAmtOth = parseFloat(creditAmtOth.toString().replace(/,/g, ''));
                    (debitAmt == "") ? debitAmt = parseFloat(0) : debitAmt = parseFloat(debitAmt.toString().replace(/,/g, ''));
                    (debitAmtOth == "") ? debitAmtOth = parseFloat(0) : debitAmtOth = parseFloat(debitAmtOth.toString().replace(/,/g, ''));
                    
                    
                    if(reference == "" || reference == null || reference=="null"){
                        notify.message("Please input for reference |error|alert");
                    }else if(particulars == "" || particulars == null || particulars=="null"){
                        notify.message("Please input for particulars |error|alert");
                    }else if(debitAmt > ropaBldgAmtss){
                        notify.message("Debit building amount greater than Building Accumulated Depreciation Amount |error|alert");
                    }else if(debitAmtOth > ropaOtherAmtss){
                        notify.message("Debit Other amount greater than Other Accumulated Depreciation Amount |error|alert");
                    }else{
                       
                        if(debitAmt < 0){
                            notify.message("Invalid Building Accumulated Depreciation Debit amount |error|alert");
                        }else if(creditAmt < 0){
                            notify.message("Invalid Building Accumulated Depreciation Credit amount |error|alert");
                        }else if(debitAmtOth < 0){
                            notify.message("Invalid Other Accumulated Depreciation Debit amount  |error|alert");
                        }else if(creditAmtOth < 0){
                            notify.message("Invalid Other Accumulated Depreciation Credit amount  |error|alert");
                        }else{
                            alertify.confirm(AppTitle,'Are you sure you want to save this details?',
                                function(){
                                    
                                    $('#ropaAccDep').submit();
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
                <li><button onclick="validateAccumulatedDepDetails();">Save</button></li>
                <li><g:link action="showRopaAccDepDetails" controller="ropa" id="${ropaCollateralDetails.id}">Back to ROPA Accumulated Details</g:link></li>          
                <li><g:link action="show" controller="ropa" id="${ropaCollateralDetails.ropa.id}">Back to ROPA Details</g:link></li>   
            </ul>
        </content>
    </body>
</html>
