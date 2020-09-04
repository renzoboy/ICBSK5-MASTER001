<%@ page import="icbs.loans.Loan" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'loan.label', default: 'Loan')}" />
		<g:if test="${module == 'loan'}">
                    <g:if test="${loanInstance?.product?.productType?.id == 6}">
                        <title>Loan Account Inquiry</title>
                    </g:if>
                    <g:if test="${loanInstance?.product?.productType?.id == 7}">
                        <title>Sales Contract Receivable Inquiry</title>
                    </g:if>    
                </g:if>
		<g:else>    
                    <title>${title} ${loanInstance?.accountNo} (${loanInstance?.customer?.displayName})</title>			
		</g:else>
		<g:javascript>
                                 function deduct() 
                                {
                                var Amt = $('#deductionAmount').val().replace(/([A-Z,a-z],#,@,-,+,=)/g,'');
                                $('#deductionAmount').val(Amt);
                                }
                                function service() 
                                {
                                var Amt = $('#serviceChargeAmount').val().replace(/([A-Z,a-z],#,@,-,+,=)/g,'');
                                $('#serviceChargeAmount').val(Amt);
                                }
                                function swep() 
                                {
                                var Amt = $('#fundLimitAmt').val().replace(/([A-Z,a-z],#,@,-,+,=)/g,'');
                                $('#fundLimitAmt').val(Amt);
                                }
                               
                                function reprice(event) 
                                {
                                    var regex = new RegExp("^[A-Z,a-z],#,@,-,+,=");
                                    var key = String.fromCharCode(!event.charCode ? event.which : event.charCode);
                                    if (!regex.test(key)) {
                                       event.preventDefault();
                                       return false;
                                    }
                                /*
                                    var Amt = accounting.unformat($('#interestRate').val());
                                    console.log('unformat? '+Amt);
                                    if(Amt<0)
                                    {
                                        $('#interestRate').val(accounting.formatNumber(Amt*-1,2));
                                    } else {
                                        Amt = parseFloat($('#interestRate').val());
                                        console.log('new amt? '+Amt);
                                        if(Amt = "NaN")
                                        {
                                            $('#interestRate').val(accounting.formatNumber($('#interestRate').val().replace(/(-,+)/g,'')));   
                                        }
                                    }
                                */    
                                    
                                //var Amt = $('#interestRate').val().replace(/([A-Z,a-z],#,@,-,+,=)/g,'');
                                //$('#interestRate').val(Amt);
                                
                                }
                                function int() 
                                {
                                var Amt = $('#interestRate').val().replace(/([A-Z,a-z],#,@,-,+,=)/g,'');
                                $('#interestRate').val(Amt);
                                }
                                function inst() 
                                {
                                var Amt = $('#numInstallments').val().replace(/([A-Z,a-z],#,@,-,+,=)/g,'');
                                $('#numInstallments').val(Amt);
                                }
			function updateCustomerInfoAjax(params) {
                $.ajax({
				    type: 'POST',
				    data: {id:params.customer2},
				    url: "${createLink(controller :'customer', action:'showBasicCustomerInfoAjax')}",
				    success: function(msg){						
						$('#customer-name').val($(msg).find('#display-name').html());
						$('#customer').val(params.customer2);
						$('#birth-date').html($(msg).find('#birth-date').html())
						$('#address').html($(msg).find('#address').html())
						$('#photo').html($(msg).find('#photo').html())
				    },
				    error:function(XMLHttpRequest,textStatus,errorThrown){
                		alert(XMLHttpRequest+textStatus+errorThrown);
            		}
				});
            }

            function showUpdateInterestRate() {
				$.ajax({
				    type: 'POST',
				    data: {id:"${loanInstance?.id}"},
				    url: "${createLink(controller :'loan', action:'showUpdateInterestRateAjax')}",
				    success: function(msg){
				    	jQuery('#update-interest-rate-modal .modal-body').html(msg);
				    },
				    error:function(XMLHttpRequest,textStatus,errorThrown){
                		alert(XMLHttpRequest+textStatus+errorThrown);
            		}
				});
				
				$('#update-interest-rate-modal').modal({show:true});
            }     

                 //Override transfer branch
            function updateInterestRateAjax(){
                checkIfAllowed('LON01600', interest); // params: policyTemplate.code, form to be saved
            }

            function interest() {
				$.ajax({
				    type: 'POST',
				    data: $('#update-interest-rate-form').serialize(),
				    url: "${createLink(controller :'loan', action:'updateInterestRateAjax')}",
				    success: function(msg){
				    	jQuery('#update-interest-rate-modal .modal-body').html(msg);
				    	$('#update-interest-rate-modal').on('hidden.bs.modal', function() {
							location.reload(true);
						});
				    },
				    error:function(XMLHttpRequest,textStatus,errorThrown){
                		alert(XMLHttpRequest+textStatus+errorThrown);
            		}
				});
            } 

            function showUpdateBranch() {
            	$.ajax({
				    type: 'POST',
				    data: {id:"${loanInstance?.id}"},
				    url: "${createLink(controller :'loan', action:'showUpdateBranchAjax')}",
				    success: function(msg){
				    	jQuery('#update-branch-modal .modal-body').html(msg);
				    },
				    error:function(XMLHttpRequest,textStatus,errorThrown){
                		alert(XMLHttpRequest+textStatus+errorThrown);
            		}
				});
				
				$('#update-branch-modal').modal({show:true});
            }        

           
            function saveRelationshipAuthCallback(){
                icbs.Customer.Relation('save',"${createLink(controller : 'customer', action:'customerSaveRelatedAjax')}",jQuery('#createRelatedDiv :input').serialize());
            }
            //Override transfer branch
            function updateBranchAjax(){
                checkIfAllowed('LON01700', transferBranch); // params: policyTemplate.code, form to be saved
            }
             //update branch
            function transferBranch() {
				$.ajax({
				    type: 'POST',
				    data: $('#update-branch-form').serialize(),
				    url: "${createLink(controller :'loan', action:'updateBranchAjax')}",
				    success: function(msg){
				    	jQuery('#update-branch-modal .modal-body').html(msg);
				    	$('#update-branch-modal').on('hidden.bs.modal', function() {
							location.reload(true);
						});
				    },
				    error:function(XMLHttpRequest,textStatus,errorThrown){
                		alert(XMLHttpRequest+textStatus+errorThrown);
            		}
				});
            }         	  

            function showUpdateStatus() {
            	$.ajax({
				    type: 'POST',
				    data: {id:"${loanInstance?.id}"},
				    url: "${createLink(controller :'loan', action:'showUpdateStatusAjax')}",
				    success: function(msg){
				    	jQuery('#update-status1-modal .modal-body').html(msg);
				    },
				    error:function(XMLHttpRequest,textStatus,errorThrown){
                		alert(XMLHttpRequest+textStatus+errorThrown);
            		}
				});
				
				$('#update-status1-modal').modal({show:true});
            } 
                      
            
                function showUpdateStat() {
            	$.ajax({
				    type: 'POST',
				    data: {id:"${loanInstance?.id}"},
				    url: "${createLink(controller :'loan', action:'showUpdateStatAjax')}",
				    success: function(msg){
				    	jQuery('#update-status-modal .modal-body').html(msg);
				    },
				    error:function(XMLHttpRequest,textStatus,errorThrown){
                		alert(XMLHttpRequest+textStatus+errorThrown);
            		}
				});
				
				$('#update-status-modal').modal({show:true});
            } 

              function showUpdateCloseStatus() {
            	$.ajax({
				    type: 'POST',
				    data: {id:"${loanInstance?.id}"},
				    url: "${createLink(controller :'loan', action:'showUpdateCloseStatusAjax')}",
				    success: function(msg){
				    	jQuery('#update-status2-modal .modal-body').html(msg);
				    },
				    error:function(XMLHttpRequest,textStatus,errorThrown){
                		alert(XMLHttpRequest+textStatus+errorThrown);
            		}
				});
				
				$('#update-status2-modal').modal({show:true});
            } 
                          //Override status 1
                         function updateStatusAjax()
                         {
                         checkIfAllowed('LON00700', statusOne); // params: policyTemplate.code, form to be saved
                         }
            function statusOne() {
				$.ajax({
				    type: 'POST',
				    data: $('#update-status-form').serialize(),
				    url: "${createLink(controller :'loan', action:'updateStatusAjax')}",
				    success: function(msg){
				    	jQuery('#update-status1-modal .modal-body').html(msg);
				    	$('#update-status1-modal').on('hidden.bs.modal', function() {
							location.reload(true);
						});
				    },
				    error:function(XMLHttpRequest,textStatus,errorThrown){
                		alert(XMLHttpRequest+textStatus+errorThrown);
            		}
				});
            }
                     function updateStatAjax()
                        {
                     checkIfAllowed('LON00700', statusTwo); // params: policyTemplate.code, form to be saved
                        }
            
            function statusTwo() {
				$.ajax({
				    type: 'POST',
				    data: $('#update-status-form').serialize(),
				    url: "${createLink(controller :'loan', action:'updateStatAjax')}",
				    success: function(msg){
				    	jQuery('#update-status-modal .modal-body').html(msg);
				    	$('#update-status-modal').on('hidden.bs.modal', function() {
							location.reload(true);
						});
				    },
				    error:function(XMLHttpRequest,textStatus,errorThrown){
                		alert(XMLHttpRequest+textStatus+errorThrown);
            		}
				});
            }
                     //override status 
                      function updateCloseStatusAjax()
                       {
                      checkIfAllowed('LON00700', statusThree); // params: policyTemplate.code, form to be saved
                       }
 
                function statusThree() {
				$.ajax({
				    type: 'POST',
				    data: $('#update-status-form').serialize(),
				    url: "${createLink(controller :'loan', action:'updateCloseStatusAjax')}",
				    success: function(msg){
				    	jQuery('#update-status2-modal .modal-body').html(msg);
				    	$('#update-status2-modal').on('hidden.bs.modal', function() {
							location.reload(true);
						});
				    },
				    error:function(XMLHttpRequest,textStatus,errorThrown){
                		alert(XMLHttpRequest+textStatus+errorThrown);
            		}
				});
            }
            
            

            function showUpdateGLClassification() {
            	$.ajax({
				    type: 'POST',
				    data: {id:"${loanInstance?.id}"},
				    url: "${createLink(controller :'loan', action:'showUpdateGLClassificationAjax')}",
				    success: function(msg){
				    	jQuery('#update-gl-modal .modal-body').html(msg);
				    },
				    error:function(XMLHttpRequest,textStatus,errorThrown){
                		alert(XMLHttpRequest+textStatus+errorThrown);
            		}
				});
				
				$('#update-gl-modal').modal({show:true});
            }        

            function updateGLClassificationAjax() {
				$.ajax({
				    type: 'POST',
				    data: $('#update-gl-form').serialize(),
				    url: "${createLink(controller :'loan', action:'updateGLClassificationAjax')}",
				    success: function(msg){
				    	jQuery('#update-gl-modal .modal-body').html(msg);
				    	$('#update-gl-modal').on('hidden.bs.modal', function() {
							location.reload(true);
						});
				    },
				    error:function(XMLHttpRequest,textStatus,errorThrown){
                		alert(XMLHttpRequest+textStatus+errorThrown);
            		}
				});
            }

        	icbs.Dependencies.Ajax.addLoadEvent(function(){
        		updateCustomerInfoAjax({customer2:"${loanInstance?.customer?.id}"});
            });
            function genReportICBS001(){
                reportlink = "${icbs.admin.Institution.get(94).paramValue}${icbs.admin.Report.get(27).baseParams}&output=${icbs.admin.Report.get(27).outputParam}";
                reportlink = reportlink + "&reportUnit=${icbs.admin.Report.get(27).reportUnit}";             
                reportlink = reportlink + "&Loan_ID=${loanInstance?.accountNo}";
                reportlink = reportlink + "&pnno=" + document.getElementById('textfield_dcpnno').value;
                reportlink = reportlink + "&generatedby=${icbs.admin.UserMaster.get(session.user_id).username}";
                sendtojasperver(reportlink);
            }
            
            function genReportICBS002(){
                                    reportlink = "${icbs.admin.Institution.get(94).paramValue}${icbs.admin.Report.get(29).baseParams}&output=${icbs.admin.Report.get(29).outputParam}";
                                    reportlink = reportlink + "&reportUnit=${icbs.admin.Report.get(29).reportUnit}";             
                                    reportlink = reportlink + "&Loan_ID=${loanInstance?.accountNo}";
                                    reportlink = reportlink + "&pnno=" + document.getElementById('textfield_pnno').value;
                                    reportlink = reportlink + "&generatedby=${icbs.admin.UserMaster.get(session.user_id).username}";
                                    sendtojasperver(reportlink);
                                }
            function genReportICBS003(){
                                    reportlink = "${icbs.admin.Institution.get(94).paramValue}${icbs.admin.Report.get(30).baseParams}&output=${icbs.admin.Report.get(30).outputParam}";
                                    reportlink = reportlink + "&reportUnit=${icbs.admin.Report.get(30).reportUnit}";             
                                    reportlink = reportlink + "&Loan_ID=${loanInstance?.accountNo}";
                                    reportlink = reportlink + "&generatedby=${icbs.admin.UserMaster.get(session.user_id).username}";
                                    sendtojasperver(reportlink);
                                }
            function genReportLNA005(){
                reportlink = "${icbs.admin.Institution.get(94).paramValue}${icbs.admin.Report.get(28).baseParams}&output=${icbs.admin.Report.get(28).outputParam}";
                reportlink = reportlink + "&reportUnit=${icbs.admin.Report.get(28).reportUnit}";             
                reportlink = reportlink + "&Loan_ID=${loanInstance?.accountNo}";
                reportlink = reportlink + "&generatedby=${icbs.admin.UserMaster.get(session.user_id).username}";
                sendtojasperver(reportlink);
            }
            function genReportLNA011(){
                reportlink = "${icbs.admin.Institution.get(94).paramValue}${icbs.admin.Report.get(63).baseParams}&output=${icbs.admin.Report.get(63).outputParam}";
                reportlink = reportlink + "&reportUnit=${icbs.admin.Report.get(63).reportUnit}";             
                reportlink = reportlink + "&loan_account_no=${loanInstance?.accountNo}";
                reportlink = reportlink + "&generatedby=${icbs.admin.UserMaster.get(session.user_id).username}";
                sendtojasperver(reportlink);
            }
   		</g:javascript>
	</head>
	<body>
        <content tag="breadcrumbs">
            <span class="fa fa-chevron-right"></span><span class="current">${title}</span>
	</content>
        <content tag="main-content"> 
        <h4 style="padding-bottom:20px;"><strong>Customer:</strong> &nbsp; ${loanApplicationInstance?.customer?.displayName} &nbsp;&nbsp;&nbsp;&nbsp;  <strong>Account Number:</strong> &nbsp; ${loanInstance?.accountNo}</h4>    
        <g:textField name="loanid" id="loanid" value="${loanInstance.id}" style="display:none"/>
		<div id="show-loan" class="content scaffold-show" role="main">
            <g:if test="${flash.message}">
                <div class="box-body">
                    <div class="alert alert-info alert-dismissable">
                        <i class="fa fa-info"></i>
                        <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                        <b>Message</b> <div class="message" role="status">${flash.message}</div>
                    </div>
                </div>
            </g:if>
                        
            <g:if test="${module =="loanAmendment"}">           
            <div class="nav-tab-container">
                <ul class="nav nav-tabs">
                    <li class="active"><a href="#tab_1" data-toggle="tab">Classification</a></li>
                </ul>
            </div>
            <div class="tab-content">
		<div class="tab-pane active fade in table-responsive" id="tab_1">
                    <legend>Account Application</legend>				
                    <g:render template="classification/show"/>
		</div>		
            </div>	
            </g:if>
            
            <g:else>          
            <div class="nav-tab-container">
                <ul class="nav nav-tabs">  
                    <li class="active"><a href="#tab_1" data-toggle="tab">Account Application</a></li>     
                    <li><a href="#tab_2" data-toggle="tab">Specification</a></li>                        
                    <li><a href="#tab_3" data-toggle="tab">Classification</a></li>
                    <li><a href="#tab_4" data-toggle="tab">Other Charges</a></li>
                    <li><a href="#tab_5" data-toggle="tab">Deductions</a></li>
                    <li><a href="#tab_6" data-toggle="tab">UID</a></li>
                    <li><a href="#tab_7" data-toggle="tab" id="installment-tab">Installments</a></li>
                    <li><a href="#tab_8" data-toggle="tab">Balance</a></li>
                    <li><a href="#tab_9" data-toggle="tab">Transactions</a></li>
                    <g:if test="${loanInstance?.product?.productType?.id == 7}" >
                       
                    </g:if> 
                    <g:else>
                        <li><a href="#tab_10" data-toggle="tab">Restructure History</a></li>
                    </g:else>    
                    <li><a href="#tab_11" data-toggle="tab">Audit Logs</a></li>
                    <!-- <li><a href="#tab_10" data-toggle="tab">Sweep</a></li> -->
                    <li><a href="#tab_12" data-toggle="tab">History</a></li>
                    <li><a href="#tab_13" data-toggle="tab">Account Reclass History</a></li>
                </ul>
            </div>
            <div class="tab-content">
				<div class="tab-pane active fade in table-responsive" id="tab_1">
						
					<g:render template="loanApplication/show"/>
				</div>
				<div class="tab-pane" id="tab_2">
					<g:render template="specification/show"/>
				</div>
				<div class="tab-pane" id="tab_3">
					<g:render template="classification/show"/>
				</div>
				<div class="tab-pane" id="tab_4">
					<g:render template="serviceCharges/show"/>   
				</div>
				<div class="tab-pane" id="tab_5">
					<g:render template="deductions/show"/>
				</div>
				<div class="tab-pane" id="tab_6">
					<g:render template="advancedInterests/list"/>
				</div>
				<div class="tab-pane" id="tab_7">
					<g:render template="installments/schedule"/>
				</div>
				<div class="tab-pane" id="tab_8">
					<g:render template="balance/list"/>
				</div>
				<div class="tab-pane" id="tab_9">
					<g:render template="transactions/list"/>
				</div>
                                <div class="tab-pane" id="tab_10">
					<g:render template="restructureDetails/list"/>
				</div>
                                <div class="tab-pane" id="tab_11">
					<g:render template="auditLog/list"/>
				</div>
                                
				<!-- <div class="tab-pane" id="tab_10">
					<g:render template="sweep/show"/>
				</div> -->
				<div class="tab-pane" id="tab_12">
					<g:render template="history/list"/>
				</div>
                                <div class="tab-pane" id="tab_13">
                                        <g:render template="loanReclass/list"/>
				</div>
			</div>	
            </g:else>     

			<div class="modal" id="update-interest-rate-modal">
				<div class="modal-dialog">
		            <div class="modal-content">
		                <div class="modal-header">
		                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
		                    <h4 class="modal-title">Update Interest Rate</h4>
		                </div>
		                <div class="modal-body">
		                </div>
		                <div class="modal-footer">
		                    <a href="#" data-dismiss="modal" class="btn">Close</a>
		                    <a href="#" class="btn btn-primary"onclick="updateInterestRateAjax()">Save changes</a>
		                </div>
		            </div>
		        </div>
		    </div>

		    <div class="modal" id="update-branch-modal">
				<div class="modal-dialog">
		            <div class="modal-content">
		                <div class="modal-header">
		                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
		                    <h4 class="modal-title">Update Branch</h4>
		                </div>
		                <div class="modal-body">
		                </div>
		                <div class="modal-footer">
		                    <a href="#" data-dismiss="modal" class="btn">Close</a>
		                    <a href="#" class="btn btn-primary"onclick="updateBranchAjax()">Save</a>
		                </div>
		            </div>
		        </div>
		    </div>

			<div class="modal" id="update-status-modal">
				<div class="modal-dialog">
		            <div class="modal-content">
		                <div class="modal-header">
		                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
		                    <h4 class="modal-title">Update Status</h4>
		                </div>
		                <div class="modal-body">
		                </div>
		                <div class="modal-footer">
		                    <a href="#" data-dismiss="modal" class="btn">Close</a>
		                    <a href="#" class="btn btn-primary"onclick="updateStatAjax()" >Save</a>
		                </div>
		            </div>
		        </div>
		    </div>
                    
                    <div class="modal" id="update-status1-modal">
				<div class="modal-dialog">
		            <div class="modal-content">
		                <div class="modal-header">
		                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                                        <g:if test="${loanInstance?.product?.productType?.id == 6}">
                                            <h4 class="modal-title">Loan Account Details Approval</h4>
                                        </g:if>   
                                        <g:if test="${loanInstance?.product?.productType?.id == 7}">
                                            <h4 class="modal-title">SCR Details Approval</h4>
                                        </g:if>
		                </div>
		                <div class="modal-body">
		                </div>
                                 <g:if test="${save != 'save'}">
		                <div class="modal-footer">
		                    <a href="#" data-dismiss="modal" class="btn">Close</a>
                                    <a href="#" class="btn btn-primary"onclick="updateStatusAjax()"  >Save</a>
                                </div>
                                  </g:if>
		            </div>
		        </div>
		    </div>
                    
                    <div class="modal" id="update-status2-modal">
				<div class="modal-dialog">
		            <div class="modal-content">
		                <div class="modal-header">
		                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
		                    <h4 class="modal-title">Close Account</h4>
		                </div>
		                <div class="modal-body">
		                </div>
		                <div class="modal-footer">
		                    <a href="#" data-dismiss="modal" class="btn">Close</a>
		                    <a href="#" class="btn btn-primary"onclick="updateCloseStatusAjax()">Save</a>
		                </div>
		            </div>
		        </div>
		    </div>

		    <div class="modal" id="update-gl-modal">
				<div class="modal-dialog">
		            <div class="modal-content">
		                <div class="modal-header">
		                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
		                    <h4 class="modal-title">Update GL Classification</h4>
		                </div>
		                <div class="modal-body">
		                </div>
		                <div class="modal-footer">
		                    <a href="#" data-dismiss="modal" class="btn">Close</a>
		                    <a href="#" class="btn btn-primary"onclick="updateGLClassificationAjax()">Save</a>
		                </div>
		            </div>
		        </div>
		    </div>	

			<%--<g:form url="[resource:loanInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${loanInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>--%>
		</div>			

        </content>
        <content tag="main-actions">
            <ul>
                <g:if test="${loanInstance?.product?.productType?.id == 6}">
                    <li><g:link class="list" controller="${module}">Search Account</g:link></li>
                </g:if>    
                <g:if test="${loanInstance?.product?.productType?.id == 7}">
                    <li><g:link class="indexScr" action="indexScr" controller="ropa">List of Sales Contract Receivables</g:link></li>
                </g:if>  
            	<g:if test="${module == 'loan'}">	
	            <g:if test="${loanInstance&&loanInstance.status?.id == 3 || loanInstance&&loanInstance.status?.id == 4  || loanInstance&&loanInstance.status?.id == 5}"> 
                        <g:if test="${loanInstance?.product?.productType?.id == 6}">
                      
                       <!-- <li><a href='#' id="btn_ICBS001" value="ICBS001" type="button" data-toggle="modal" data-target="#modalDisclosurePnNoParameters" class="btnreport">Print Disclosure Statement</a></li>
                        -->
                        </g:if>
                        <!-- PnNo Modal disclosure -->
                        <div id="modalDisclosurePnNoParameters" class="modal fade" role="dialog">
                          <div class="modal-dialog">

                            <!-- Modal content-->
                            <div class="modal-content">
                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                                    <h4 class="modal-title" style="color: black;">Disclosure statement</h4>
                                </div>
                                <div class="modal-body">

                                    <!-- PnNO -->
                                    <div class="fieldcontain form-group">
                                        <label class="control-label col-sm-4" style="color: gray;">Reference*: </label>
                                        <div class="col-sm-8"><g:textField class="form-control" id="textfield_dcpnno" name="textfield" value="${loanInstance.pnNo}"/></div>
                                    </div>
                                </div>
                                <div class="modal-footer">
                                   
                                    <a href = "#" onclick="genReportICBS001();" class="btn btn-default"> Print Report </a>
                                   
                                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                                </div>
                                <g:javascript>
                                
                                </g:javascript>
                            </div>
                            
                          </div>
                        </div>  
                        <!-- modal close --> 
                        <g:if test="${loanInstance?.product?.productType?.id == 6}">
                       <!-- <li><a href='#' id="btn_ICBS002" value="ICBS002" type="button" data-toggle="modal" data-target="#modalPnNoParameters" class="btnreport">Print Promissory Note</a></li>
                       -->
                        </g:if>
                        <!-- PnNo Modal -->
                        <div id="modalPnNoParameters" class="modal fade" role="dialog">
                          <div class="modal-dialog">

                            <!-- Modal content-->
                            <div class="modal-content">
                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                                    <h4 class="modal-title" style="color: black;">Promissory Note</h4>
                                </div>
                                <div class="modal-body">

                                    <!-- PnNO -->
                                    <div class="fieldcontain form-group">
                                        <label class="control-label col-sm-4" style="color: gray;">Reference*: </label>
                                        <div class="col-sm-8"><g:textField class="form-control" id="textfield_pnno" name="textfield" value="${loanInstance.pnNo}"/></div>
                                    </div>
                                </div>
                                <div class="modal-footer">
                                   
                                    <a href = "#" onclick="genReportICBS002();" class="btn btn-default"> Print Report </a>
                                   
                                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                                </div>
                                <g:javascript>
                                
                                </g:javascript>
                            </div>
                            
                          </div>
                        </div>  
                        <!-- modal close --> 
                        <g:if test="${loanInstance?.product?.productType?.id == 6}">                
                        <li><a href="#" onclick="genReportICBS003()">Print Approval</a></li>
                        </g:if>
                    </g:if>
                        <g:if test="${loanInstance?.product?.productType?.id == 6}">
                        <li><g:link action="edit" resource="${loanInstance}">Update Loan Account Details</g:link></li>
                        </g:if>
                        <g:if test="${loanInstance?.product?.productType?.id == 7}">
                            <li><g:link action="edit" resource="${loanInstance}">Update Sales Contract Receivable Details</g:link></li>
                        </g:if>
	    <%--  <li><g:link action="editSweepAccount" resource="${loanInstance}">Account Sweep Maintenance</g:link></li>  --%>
                        <li><g:link target="_blank" controller="loan" action="printLoanInstallment" > Print Installment Schedule</g:link></li>
                        <g:if test="${loanInstance?.product?.productType?.id == 6}">
                        <li><a href="#" onclick="genReportLNA011()">Print Account Inquiry</a></li>
                        </g:if>
                        <li><a href="#" onclick="genReportLNA005()">Print Account Ledger</a></li> 
                       
                        <g:if test="${loanInstance?.hasInterestAccrual}">
                            <li><g:form url="[controller: loan, id: loanInstance.id,  action:'stopInterestAccrual']" method="POST"><g:actionSubmit action="stopInterestAccrual" value="Stop Interest Accrual" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
                            </g:form></li>
	                </g:if>
	                <g:else>
                            <li><g:form url="[controller: loan, id: loanInstance.id,  action:'startInterestAccrual']" method="POST"><g:actionSubmit action="startInterestAccrual" value="Start Interest Accrual" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
                            </g:form></li>
	                </g:else>
	                
                        <!-- <li><a href="#" onclick="showUpdateInterestRate()">Repricing</a></li> -->
	                <g:if test="${loanInstance?.loanPerformanceId?.id == 1}">
	                	<!-- <li><g:link action="reschedule" resource="${loanInstance}">Reschedule</g:link></li> -->
	                </g:if>
	                <g:else>
	                	<!-- <li><g:link action="restructure" resource="${loanInstance}">Restructure</g:link></li> -->
	                </g:else>                
	                <!-- <li><a href="#" onclick="showUpdateBranch()">Update Branch</a></li> -->
                         <g:if test="${loanInstance&&loanInstance.status?.id <=2}">
                         <li><a href="#" onclick="showUpdateStat()">Update Status</a></li>
                         </g:if>
                         <g:else>
                         <li><button disabled>Update Status</button></li>
                         </g:else>
<!--                         <li><a href="#" onclick="showUpdateCloseStatus()">Close Loan Status</a></li>-->
                         <li><a href="#" onclick="showUpdateGLClassification()">Update GL Classification</a></li>
	                <%--<li><g:link action="showSpecial" resource="${loanInstance}">Special</g:link></li>
	                <g:if test="${loanInstance?.special?.type?.id == 1}">
	                	<li><g:link action="litigation" resource="${loanInstance}">Litigation</g:link></li>
	                </g:if>
	                <g:elseif test="${loanInstance?.special?.type?.id == 3}">
	                	<li><g:link action="ropa" resource="${loanInstance}">ROPA</g:link></li>
	                </g:elseif>--%>
                        <g:if test="${loanInstance?.status?.id == 4 || loanInstance?.status?.id == 5}">
                            <g:if test="${loanInstance?.product?.productType?.id == 6}">
                            <li><g:link action="loanRelief" id="${loanInstance?.id}">Account Regulatory Relief</g:link></li>
                            </g:if>
                        </g:if>
                        <g:else>
                            <g:if test="${loanInstance?.product?.productType?.id == 6}">
                            <li><button disabled>Account Regulatory Relief</button></li>
                            </g:if>
                        </g:else>
                        <%--<li><g:link controller="loan" action="viewLoanPaymentList" id="${loanInstance?.id}">Payment Reversal</g:link></li> --%>
                        <g:if test="${loanInstance?.product?.productType.id == 7}">
                            <li><g:link controller="loan" action="showDiscountSchedule" id="${loanInstance?.id}">View Account Discount Schedule</g:link></li>
                        </g:if>
                        <g:if test="${loanInstance?.status?.id != 1 && loanInstance?.status?.id != 6}">
                            <g:if test="${loanInstance?.product?.productType?.id == 6}">
                                <li><g:link controller="loan" action="loanGurantee" id="${loanInstance?.id}">Account Guarantees and Rediscounting</g:link></li>
                            </g:if>    
                        </g:if> 
                </g:if>
                <g:elseif test="${module == "loanAmendment"}">
                	<li><g:link controller="${module}" action="edit" id="${loanInstance?.id}">Update Account Details</g:link></li>
                </g:elseif>
                
                <g:elseif test="${module == "loanInterestAccrual" && loanInstance?.status?.id==5}">
                	<g:if test="${loanInstance?.hasInterestAccrual}">
	                <li><g:form id="stop-form"  url="[controller: loan, id: loanInstance.id,  action:'stopInterestAccrual']" method="POST">
                            
                                <g:hiddenField id="module" name="module" value="${module}" />
	                	<g:actionSubmit id="stop" action="stopInterestAccrual" value="Stop Interest Accrual" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
                                    <script type="text/javascript">
                                    $(document).ready(function() {
                                    $( "#stop" ).click(function() {
		             		 checkIfAllowed('LON01202', 'form#stop-form', 'Update branch XXX.', null); // params: policyTemplate.code, form to be saved
                                    });
                                    }); 
                                    </script>
                                        </g:form></li>
	                </g:if>
	                <g:else>
	                <li><g:form id="start-form" url="[controller: loan, id: loanInstance.id,  action:'startInterestAccrual']" method="POST">
                                
                                <g:hiddenField id="module" name="module" value="${module}" />
	                	<g:actionSubmit id="start "action="startInterestAccrual" value="Start Interest Accrual" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
                                    <script type="text/javascript">
                                    $(document).ready(function() {
                                    $( "#start" ).click(function() {
		             		 checkIfAllowed('LON01201', 'form#start-form', 'Update branch XXX.', null); // params: policyTemplate.code, form to be saved
                                    });
                                    }); 
                                    </script>
                                        </g:form></li>
	                </g:else>
                </g:elseif>
                
                <g:elseif test="${module == "loanRepricing"}">
                    <g:if test="${loanInstance?.product?.productType?.id == 6}">
                	<li><a href="#" onclick="showUpdateInterestRate()">Repricing</a></li>
                    </g:if>
                </g:elseif>
                <g:elseif test="${module == "loanReschedule"}">
                	<g:if test="${loanInstance?.loanPerformanceId.id == 1 || loanInstance?.loanPerformanceId.id == 5 || loanInstance?.loanPerformanceId.id == 6}">
                            <li><g:link controller="${module}" action="reschedule" id="${loanInstance?.id}">Reschedule</g:link></li>
	                </g:if>                	
                </g:elseif>
                <g:elseif test="${module == "loanRestructure"}">
                    <g:if test="${loanInstance?.loanPerformanceId.id == 2 || loanInstance?.loanPerformanceId.id == 3 }">
                        <g:if test="${loanInstance?.product?.productType?.id == 6}">
                        <li><g:link controller="${module}" action="restructure" id="${loanInstance?.id}">Restructure</g:link></li>
                        </g:if>
                    </g:if>                	
                </g:elseif>
                
                
                
                <g:elseif test="${module == "loanGLClassification"}">
                            <li><a href="#" onclick="showUpdateGLClassification()">Update GL Classification</a></li>
                </g:elseif>
                <g:elseif test="${module == "loanRenewal"}">
                    <g:if test="${loanInstance?.product?.productType?.id == 6}">
                	<li><g:link controller="${module}" action="renew" id="${loanInstance?.id}">Process Renewal</g:link></li>
                    </g:if>    
                </g:elseif>
                <g:elseif test="${module == "loanBranchTransfer"}">
                	<li><a href="#" onclick="showUpdateBranch()">Transfer Branch</a></li>
                </g:elseif>
                <g:elseif test="${module == "loanApproval" && loanInstance?.status?.id <=2}">
<!--                	<li><a href="#" onclick="showUpdateStatus()">Approve Loan</a></li>
                      -->
                        <li>
                              
                           <g:if test="${loanInstance?.product?.productType?.id == 6}">
                            <a href="#" id="add-buttons" type="button" data-toggle="modal" data-target="#modalParameters" >Approve Loan Account Details</a>     
                           </g:if>     
                           <g:if test="${loanInstance?.product?.productType?.id == 7}">
                               <a href="#" id="add-buttons" type="button" data-toggle="modal" data-target="#modalParameters" >Approve SCR Account Details</a>     
                           </g:if>    
                        </li>
              <!-- Modal -->
                 <g:form id="approve-form" url="[controller: loan, id: loanInstance.id,  action:'approved']" method="POST">
                 
                <div id="modalParameters" class="modal fade" role="dialog">
                  <div class="modal-dialog">

                    <!-- Modal content-->
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                            <h4 class="modal-title" style="color: black;">Requirement Fields</h4>
                        </div>
                        <div class="modal-body">
                            <div class="fieldcontain form-group">
                                <label class="control-label col-sm-4" style="color: gray;">Particulars*: </label>
                                <div class="col-sm-8"><g:textField class="form-control" id="txnParticulars" name="txnParticulars" value=""/></div>
                            </div>
                            <div class="fieldcontain form-group">
                                <label class="control-label col-sm-4" style="color: gray;">Reference*: </label>
                                <div class="col-sm-8"><g:textField class="form-control" id="txnReference" name="txnReference" value=""/></div>
                            </div>
                            
                        </div>
                        <div class="modal-footer">
                            <a href='#' onclick="validateFields();" class="btn btn-info" value=""> Approve Account </a>
                            <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
                            
                        </div>
                        <g:javascript>
                            function validateFields(){
                            var txnParticulars = $('#txnParticulars').val();
                            var txnReference = $('#txnReference').val();
                            console.log("txnParticulars: "+txnParticulars);
                            console.log("txnReference: "+txnReference);
                            if(txnParticulars=="" || txnParticulars==null){
                                notify.message('Sorry, Particulars cannot be null!|error|alert'); 
                            }
                            else if(txnReference=="" || txnReference==null){
                                notify.message('Sorry, Reference cannot be null!|error|alert'); 
                            }else{
                                alertify.confirm(AppTitle,'Are you sure you want to Approve this Account?',
                                    function(){
                                            checkIfAllowed('LON00700', 'form#approve-form', 'Approve Account', null);;
                                    },
                                    function(){
                                            return;
                                    }
                                );                          
                            
                            }

                            }
                            
                            
                        </g:javascript>    
                    </div>

                  </div>
                </div>  
                <!-- modal close -->               
                </g:form>
                </g:elseif>
                <g:elseif test="${module == "loanApproval" && loanInstance?.status?.id ==3}">
                    <g:if test="${loanInstance?.product?.productType?.id == 6}">
                        <li><a href="#" onclick="genReportICBS001()">Print Disclosure Statement</a></li>
                        <li><a href='#' id="add-buttons" type="button" data-toggle="modal" data-target="#modalPnNoParameters" class="btn btn-primary multi-field-btn-add">Print Promissory Note</a></li>
                    </g:if>    
                    <li><a href="#" onclick="genReportLNA005()">Print Account Ledger</a></li>                   
                </g:elseif>
                
                <g:elseif test="${module == "loanTermination"}">                        
                        <g:if test="${loanInstance?.status?.id == 2 || loanInstance?.status?.id == 3 || loanInstance?.status?.id == 4 || loanInstance?.status?.id == 5}">
                            <li><a href="#" onclick="generateReportToClose()">Print Account Amount to Close</a></li>
                            <li><g:link controller="loan" action="applyIntToDate" id="${loanInstance?.id}">Apply Interest to Current Date</g:link></li>
                            <li><g:link controller="loan" action="applyIntToMaturity" id="${loanInstance?.id}">Apply Interest to Maturity</g:link></li>
                            <li><g:link controller="loan" action="capitalizeAccruedInt" id="${loanInstance?.id}">Capitalize Accrued Interest</g:link></li>
                        </g:if>
                	<g:if test="${loanInstance?.balanceAmount == 0 && loanInstance?.interestBalanceAmount ==  0 &&
                            loanInstance?.penaltyBalanceAmount == 0 && loanInstance?.serviceChargeBalanceAmount == 0 && 
                            (loanInstance?.status?.id == 1 || loanInstance?.status?.id == 2 || loanInstance?.status?.id == 3 || loanInstance?.status?.id == 4 || loanInstance?.status?.id == 5)}">
	                	<li><a href="#" onclick="showUpdateCloseStatus()">Terminate</a></li>
                        </g:if>
                	<g:if test="${loanInstance?.balanceAmount == 0 && loanInstance?.interestBalanceAmount ==  0 &&
                            loanInstance?.penaltyBalanceAmount == 0 && loanInstance?.serviceChargeBalanceAmount == 0 && 
                            loanInstance?.status?.id == 8}">
	                	<li><a href="#" onclick="showUpdateCloseStatus()">Remove Write-Off Account</a></li>
                        </g:if>  
                        <g:if test="${loanInstance?.balanceAmount == 0 && loanInstance?.interestBalanceAmount ==  0 &&
                            loanInstance?.penaltyBalanceAmount == 0 && loanInstance?.serviceChargeBalanceAmount == 0 && 
                            loanInstance?.status?.id == 6}">
                                <li><g:link action="reopen" resource="${loanInstance}">Re-Open Closed Account Account</g:link></li>
                        </g:if>
                </g:elseif>
                <g:elseif test="${module == "loanWriteOff"}">
                    <li><g:form url="[controller:loan, action:'transferToWriteOff', id:loanInstance.id]" method="POST">
                                </g:form></li>
                                 <li><g:link action="viewWriteOff" id="${loanInstance.id}">Transfer to WRITE-OFF</g:link></li>
                <!--	<li><g:form url="[controller:loan, action:'writeOff', id:loanInstance.id]" method="POST">
			<li><g:link action="viewWriteOff" id="${loanInstance.id}">Transfer to Write Off</g:link></li>		
                            <g:actionSubmit action="writeOff" value="Write-Off" />
                           
					</g:form></li>
                -->
                                 
                </g:elseif>
                <g:elseif test="${module == "loanROPA"}">
                	
	            <li><g:form url="[controller:loan, action:'transferToROPA', id:loanInstance.id]" method="POST">
                        </g:form></li>
                    <li><g:link action="viewRopa" id="${loanInstance.id}">Transfer to ROPA</g:link></li>
		  <!--   		<li><g:link controller="glBatch" action="create">Sell Off</g:link></li>
				<li><g:link controller="${module}" action="createSCR" id="${loanInstance?.id}">SCR</g:link></li>
		-->		
                </g:elseif>
                <g:elseif test="${module == "loanProvision"}">
                    <g:if test="${loanInstance?.product?.productType?.id == 6}">
                    <li><g:link controller="loan" action="loanUidDebit" id="${loanInstance?.id}">Account UID Debit Entry</g:link></li>
                    <li><g:link controller="loan" action="loanUidCredit" id="${loanInstance?.id}">Account UID Credit Entry</g:link></li>
                    <li><g:link controller="loan" action="loanAllowanceCredit" id="${loanInstance?.id}">Apply Additional Provision</g:link></li>
                    <li><g:link controller="loan" action="loanAllowanceTransferDebit" id="${loanInstance?.id}">Transfer Account Provision (Debit)</g:link></li>
                    <li><g:link controller="loan" action="loanAllowanceTransferCredit" id="${loanInstance?.id}">Transfer Account Provision (Credit)</g:link></li>
                    <li><g:link controller="loan" action="loanServiceChargeCredit" id="${loanInstance?.id}">Account Service Charge Credit Entry</g:link></li>
                    <li><g:link controller="loan" action="loanServiceChargeDebit" id="${loanInstance?.id}">Account Service Charge Debit Entry</g:link></li>
                    <li><g:link controller="loan" action="loanDeferredCredit" id="${loanInstance?.id}">Account Deferred Credit Entry</g:link></li>
                    <li><g:link controller="loan" action="loanDeferredDebit" id="${loanInstance?.id}">Account Deferred Debit Entry</g:link></li>
                    </g:if>
                </g:elseif>
                <g:elseif test="${module == "scr"}">
                    <li><g:link controller="loan" action="loanScrMaintenance" id="${loanInstance?.id}">Account Maintenance</g:link></li>
                </g:elseif>  
                <g:if test="${loanInstance?.status?.id == 8}">
                    <li><g:link controller="loan" action="loanWriteOffCollectionList" id="${loanInstance?.id}">Account Write-Off Collections</g:link></li>
                </g:if>    
            </ul>			
        </content>
	</body>
</html>