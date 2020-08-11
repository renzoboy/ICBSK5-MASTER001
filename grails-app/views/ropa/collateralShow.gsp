<%@ page import="icbs.loans.ROPA" %>
<%@ page import="icbs.loans.LoanApplication" %>
<!DOCTYPE html>
<html>
    <head>
	<meta name="layout" content="main">
	<title>ROPA Details</title>
        <script>
            
        </script>
    </head>
        
    <body>
        <content tag="breadcrumbs">
                <span class="fa fa-chevron-right"></span><span class="current">ROPA Information</span>
        </content>
        <content tag="breadcrumbs">
            <span class="fa fa-chevron-right"></span><a href="${createLink(uri: '/ropa')}">ROPA Index</a>
            <span class="fa fa-chevron-right"></span><span class="current">ROPA Collateral Information</span>
        </content>
        <content tag="main-content">
            <script>
                function validateAmtsForProbLosesDr(){
                    console.log("boom");
                    var allowanceProbLoss = $('#allowanceProbLoss').val();
                    var allowanceProbLossBldg = $('#allowanceProbLossBldg').val();
                    var allowanceProbLossOtherProp = $('#allowanceProbLossOtherProp').val();
                    (allowanceProbLoss == "") ? allowanceProbLoss = $('#allowanceProbLoss').val(parseFloat(0)) : allowanceProbLoss = parseFloat(allowanceProbLoss.toString().replace(/,/g, ''));
                    (allowanceProbLossBldg == "") ? allowanceProbLossBldg = $('#allowanceProbLossBldg').val(parseFloat(0)) : allowanceProbLossBldg = parseFloat(allowanceProbLossBldg.toString().replace(/,/g, ''));
                    (allowanceProbLossOtherProp == "") ? allowanceProbLossOtherProp = $('#allowanceProbLossOtherProp').val(parseFloat(0)) : allowanceProbLossOtherProp = parseFloat(allowanceProbLossOtherProp.toString().replace(/,/g, ''));
                    
                    if(allowanceProbLoss < 0){
                        notify.message("Invalid Allowance for Probable Loses |error|alert");
                    }else if(allowanceProbLossBldg < 0){
                        notify.message("Invalid Allowance for Probable Loses Building |error|alert");
                    }else if(allowanceProbLossOtherProp < 0){
                        notify.message("Invalid Allowance for Probable Loses Other properties |error|alert");
                    }else{
                        alertify.confirm(AppTitle,"Are you sure about this?",
                          function(){
                            $('#allowanceProbLoses').submit();
                            $('#modalROPAProbloss').modal('hide');
                          },
                          function(){
                            alertify.error('Canceled.');
                          });
                        }
                    
                }
                function validateAmtsForProbLosesCr(){
                    console.log("boom");
                    var allowanceProbLoss = $('#allowanceProbLossCr').val();
                    var allowanceProbLossBldg = $('#allowanceProbLossBldgCr').val();
                    var allowanceProbLossOtherProp = $('#allowanceProbLossOtherPropCr').val();
                    (allowanceProbLoss == "") ? allowanceProbLoss = $('#allowanceProbLoss').val(parseFloat(0)) : allowanceProbLoss = parseFloat(allowanceProbLoss.toString().replace(/,/g, ''));
                    (allowanceProbLossBldg == "") ? allowanceProbLossBldg = $('#allowanceProbLossBldg').val(parseFloat(0)) : allowanceProbLossBldg = parseFloat(allowanceProbLossBldg.toString().replace(/,/g, ''));
                    (allowanceProbLossOtherProp == "") ? allowanceProbLossOtherProp = $('#allowanceProbLossOtherProp').val(parseFloat(0)) : allowanceProbLossOtherProp = parseFloat(allowanceProbLossOtherProp.toString().replace(/,/g, ''));
                    
                    
                    if(allowanceProbLoss < 0){
                        notify.message("Invalid Allowance for Probable Loses |error|alert");
                    }else if(allowanceProbLossBldg < 0){
                        notify.message("Invalid Allowance for Probable Loses Building |error|alert");
                    }else if(allowanceProbLossOtherProp < 0){
                        notify.message("Invalid Allowance for Probable Loses Other properties |error|alert");
                    }else{
                        
                    alertify.confirm(AppTitle,"Are you sure about this?",
                      function(){
                        
                        $('#allowanceProbLosesCr').submit();
                        $('#modalROPAProbloss').modal('hide');
                      },
                      function(){
                        alertify.error('Canceled.');
                      });
                    }
                    
                }
            </script> 
             <div id="show-ROPA" class="content scaffold-show" role="main">
                <g:if test="${flash.message}">
                    <div class="box-body">
                        <div class="alert alert-info alert-dismissable">
                            <i class="fa fa-info"></i>
                            <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                            <b>Alert</b> <div class="message" role="status">${flash.message}</div>
                        </div>
                    </div>
                </g:if>
                <div class="nav-tab-container">
                    <ul class="nav nav-tabs">
                        <li class="active"><a href="#tab_1" data-toggle="tab">Details</a></li>
                        <li><a href="#tab_2" data-toggle="tab">Additional Details</a></li> 
                        <li><a href="#tab_3" data-toggle="tab">Attachments</a></li>   
			<li><a href="#tab_4" data-toggle="tab">ROPA Ledger Transactions</a></li>
                        <li><a href="#tab_5" data-toggle="tab">Allowance for Probable Losses</a></li>
                    </ul>
                </div>
                <div class="tab-content">
                    <div class="tab-pane active fade in table-responsive" id="tab_1">
                        <g:render template="details/collateralDetails"/>
                    </div>
                    <div class="tab-pane" id="tab_2">
                        <g:render template="details/additionalDetails"/>
                    </div>
                    <div class="tab-pane" id="tab_3">
                        <legend>Attachment</legend>
                    </div>
                    <div class="tab-pane" id="tab_4">
                        <g:render template="details/ropaLedgerTransactions"/>
                    </div>
                    <div class="tab-pane" id="tab_5">
                        <g:render template="details/ropaAllowance"/>
                    </div>
                    <g:hiddenField id="collateralInstance" name="collateralInstance" value="${collateralInstance}" />
                    <g:hiddenField id="loanBal" name="loanBal" value="${loanBal}" />
                   
                    
                </div>
            </div>
            <div id="modalROPAProblossDebit" class="modal fade" role="dialog">
                <g:form onsubmit="callLoadingDialog();" name="allowanceProbLoses" url="[action:'probableLosesSaveUpdateDebit',controller:'ropa']" method="POST">
                <div class="modal-dialog">
                <!-- Modal content-->
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                            <h4 class="modal-title" style="color: black;">Update Allowance for Probable Losses Debit</h4>
                        </div>

                        <g:hiddenField id="id" name="id" value="${collateralInstance?.id}"/>
                       
                        <div class="modal-body">
                            <div class="fieldcontain form-group ${hasErrors(bean: customerInstance, field: 'registrationDate', 'has-error')} ">
                                <label class="control-label col-sm-4" style="color: gray;">Allowance for Probable Losses - Land: </label>
                                <div class="col-sm-8"><g:textField id="allowanceProbLoss" name="allowanceProbLoss" value="${collateralInstance?.allowanceProbLoss}" class="form-control truncated"/></div>
                            </div>
                            
                            <div class="fieldcontain form-group ${hasErrors(bean: customerInstance, field: 'registrationDate', 'has-error')} ">
                                <label class="control-label col-sm-4" style="color: gray;">Allowance for Probable Losses - Building: </label>
                                <div class="col-sm-8"><g:textField id="allowanceProbLossBldg" name="allowanceProbLossBldg" value="${collateralInstance?.allowanceProbLossBldg}" class="form-control truncated"/></div>
                            </div>
                            <div class="fieldcontain form-group ${hasErrors(bean: customerInstance, field: 'registrationDate', 'has-error')} ">
                                <label class="control-label col-sm-4" style="color: gray;">Allowance for Probable Losses - Other Properties: </label>
                                <div class="col-sm-8"><g:textField id="allowanceProbLossOtherProp" name="allowanceProbLossOtherProp" value="${collateralInstance?.allowanceProbLossOtherProp}" class="form-control truncated"/></div>
                            </div> 
                            </br>
                            </br>
                        </div>
                         </g:form>
                        <div class="modal-footer">
                            <button type="button" onclick="validateAmtsForProbLosesDr();" class="btn btn-primary">save</button>
                            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                        </div>
                    </div>

                </div>
            </div>

            <div id="modalROPAProblossCredit" class="modal fade" role="dialog">
                <g:form onsubmit="callLoadingDialog();" name="allowanceProbLosesCr" url="[action:'probableLosesSaveUpdateCredit',controller:'ropa']" method="POST">
                <div class="modal-dialog">
                <!-- Modal content-->
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                            <h4 class="modal-title" style="color: black;">Update Allowance for Probable Losses Credit</h4>
                        </div>

                        <g:hiddenField id="id" name="id" value="${collateralInstance?.id}"/>
                       
                        <div class="modal-body">
                            <div class="fieldcontain form-group ${hasErrors(bean: customerInstance, field: 'registrationDate', 'has-error')} ">
                                <label class="control-label col-sm-4" style="color: gray;">Allowance for Probable Losses - Land: </label>
                                <div class="col-sm-8"><g:textField id="allowanceProbLossCr" name="allowanceProbLossCr" value="${collateralInstance?.allowanceProbLoss}" class="form-control truncated"/></div>
                            </div>
                            
                            <div class="fieldcontain form-group ${hasErrors(bean: customerInstance, field: 'registrationDate', 'has-error')} ">
                                <label class="control-label col-sm-4" style="color: gray;">Allowance for Probable Losses - Building: </label>
                                <div class="col-sm-8"><g:textField id="allowanceProbLossBldgCr" name="allowanceProbLossBldgCr" value="${collateralInstance?.allowanceProbLossBldg}" class="form-control truncated"/></div>
                            </div>
                            <div class="fieldcontain form-group ${hasErrors(bean: customerInstance, field: 'registrationDate', 'has-error')} ">
                                <label class="control-label col-sm-4" style="color: gray;">Allowance for Probable Losses - Other Properties: </label>
                                <div class="col-sm-8"><g:textField id="allowanceProbLossOtherPropCr" name="allowanceProbLossOtherPropCr" value="${collateralInstance?.allowanceProbLossOtherProp}" class="form-control truncated"/></div>
                            </div> 
                            </br>
                            </br>
                        </div>
                         </g:form>
                        <div class="modal-footer">
                            <button type="button" onclick="validateAmtsForProbLosesCr();" class="btn btn-primary">save</button>
                            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                        </div>
                    </div>

                </div>
               
            </div>
            
        </content>	
        <content tag="main-actions">
            <ul>
                <!--<g:if test="${isSold == true}">
                <li><button type="button" disabled>Sale Ropa Collateral</button>
                </g:if>
                <g:else>
                    <li><g:link action="ropaSale" controller="ropa" id="${collateralInstance?.id}" params="['idRopa': params?.ropaId]" >Sale Ropa Collateral</g:link></li>
                </g:else> -->
                <g:if test="${collateralInstance?.status?.id==1}">
                    <g:if test="${collateralInstance?.loan?.balanceAmount <= 0}">
                        <li><button disabled="disable">Transfer To ROPA</button></li>
                    </g:if>
                    <g:else>
                        <li id="transferButton"><g:link name="transfer"  action="transferToRopaGSP" controller="ropa" id="${collateralInstance?.id}" params="['idRopa': params?.ropaId]" >Transfer To ROPA</g:link></li>
                    </g:else>    
                </g:if>
                <g:if test="${isCollateralLinkedToOtherLoan == true}">
                    <g:if test="${collateralInstance?.status?.id==6}">
                    <li><g:link name="transfer"  action="specialtransferToRopaGSP" controller="ropa" id="${collateralInstance?.id}" params="['idRopa': params?.ropaId]" >Special Transfer To ROPA</g:link></li>
                    </g:if>
                </g:if>
                <g:else>
                    <li><button disabled="disable">Special Transfer To ROPA</button></li>
                </g:else>    
                <g:if test="${collateralInstance?.status?.id==6}">
                   <li><g:link action="ropaSaleCash" controller="ropa" id="${collateralInstance?.id}" >ROPA Sale - Cash</g:link></li>
                   <li><g:link action="ropaSaleInst" controller="ropa" id="${collateralInstance?.id}" >ROPA Sale - Installment</g:link></li>
                   <li><g:link action="showRopaAccDepDetails" controller="ropa" id="${params?.id}">View Accumulated Depreciation Records</g:link></li>
                   <li><g:link action="ropaDebitCap" controller="ropa" id="${collateralInstance?.id}" >ROPA Debit (Capitalize)</g:link></li>
                   <li><g:link action="ropaCreditCap" controller="ropa" id="${collateralInstance?.id}" >ROPA Credit (Capitalize)</g:link></li>
                   <li><button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#modalROPAProblossDebit">Allowance For Probable Losses Debit</button></li>
                   <li><button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#modalROPAProblossCredit">Allowance For Probable Losses Credit</button></li>
               </g:if>      
                <li><g:link action="editCollateral" controller="ropa" id="${collateralInstance?.id}" >Edit ROPA Collateral</g:link></li>
                <li><g:link action="index">List of ROPA </g:link></li>
            </ul>
        </content>
    </body>
</html>