<%@ page import="icbs.loans.LoanApplicationComaker" %>														  
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'loan.label', default: 'Loan')}" />
                    <title>Create Account</title>   
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
                                function reprice() 
                                {
                                var Amt = $('#interestRate').val().replace(/([A-Z,a-z],#,@,-,+,=)/g,'');
                                $('#interestRate').val(Amt);
                                }
                                function int() 
                                {
                                var Amt = $('#interestRate').val().replace(/([A-Z,a-z],#,@,-,+,=)/g,'');
                                $('#interestRate').val(Amt);
                                updateInstallmentAmount();
                                }
                                function inst() 
                                {
                                var Amt = $('#numInstallments').val().replace(/([A-Z,a-z],#,@,-,+,=)/g,'');
                                $('#numInstallments').val(Amt);
                                updateInstallmentAmount();
                                }


			function pmt(interestRate, numPeriods, presentValue, futureValue) {
				var presentValueInterestFactor;

				if (!futureValue) 
					futureValue = 0;

				if (interestRate == 0)
					return -(presentValue + futureValue) / numPeriods;

				presentValueInterestFactor = Math.pow(1 + interestRate, numPeriods);
				return -interestRate * presentValue * (presentValueInterestFactor + futureValue) / (presentValueInterestFactor - 1)
			}

			function updateInstallmentAmount() {
				var amount = parseFloat($('#grantedAmount').val().replace(',', ''));				
				var numInstallments = $('#numInstallments').val();
				var interestRate = $('#interestRate').val() * 0.01;
				var frequency = $('#frequency').val();
                                amount = accounting.unformat($('#grantedAmount').val());
				var contractualRate = interestRate / 12;

				var compoundingRate
                                if (frequency == 1 || frequency == 2) {
                                    compoundingRate = contractualRate / 30;
                                } else if (frequency == 3) {
                                    compoundingRate = (contractualRate / 30) * 7;
                                } else if (frequency == 4) {
                                    compoundingRate = (contractualRate / 30) * 14;
                                } else if (frequency == 5 || frequency == 14) {
                                    compoundingRate = (contractualRate / 30) * 15;
                                } else if (frequency == 6 || frequency == 7) {
                                    compoundingRate = contractualRate;
                                } else if (frequency == 8) {
                                    compoundingRate = interestRate / 6;
                                } else if (frequency == 9) {
                                    compoundingRate = interestRate / 4;
                                } else if (frequency == 10) {
                                    compoundingRate = interestRate / 2;
                                } else if (frequency == 11) {
                                    compoundingRate = interestRate;
                                } else {
                                    compoundingRate = contractualRate;
                                }

				if (amount > 0 && numInstallments > 0) {
					var installmentAmount = 0;

                                        if (frequency == 3)
                                        {
                                            var frequencyFactor = 0;

                                            if (frequency == 1 || frequency == 2) {
                                                frequencyFactor = 365;
                                            } else if (frequency == 3) {
                                                frequencyFactor = 52;
                                            } else if (frequency == 4) {
                                                frequencyFactor = 26;
                                            } else if (frequency == 5 || frequency == 14) {
                                                frequencyFactor = 24;
                                            } else if (frequency == 6 || frequency == 7) {
                                                frequencyFactor = 12;
                                            } else if (frequency == 8) {
                                                frequencyFactor = 6;
                                            } else if (frequency == 9) {
                                                frequencyFactor = 4;
                                            } else if (frequency == 10) {
                                                frequencyFactor = 2;
                                            } else if (frequency == 11) {
                                                frequencyFactor = 1;
                                            } else {
                                                frequencyFactor = 365;
                                            }
                                        
                                           factor = interestRate / frequencyFactor;
                                           installmentAmount = amount * ( factor / ( 1 - ( Math.pow( ( 1 / ( 1 + factor ) ),numInstallments ) ) ) );
                                        }
                                        else
                                      {
					   installmentAmount = pmt(compoundingRate, numInstallments, amount * -1);
					   
					}
                                        installmentAmount = installmentAmount.toFixed(2).replace(/(\d)(?=(\d{3})+\.)/g, '$1,');
					$('#installmentAmount').val(installmentAmount);
				} else {
					$('#installmentAmount').val('');
				}				
			}

			function updateLoanApplicationAjax(params) {
                                
				$('#loanApplication').val(params.loanApplication2);
                                
				$.ajax({
				    type: 'POST',
				    data: {id:params.loanApplication2},
				    url: "${createLink(controller:'loan', action:'showLoanApplicationAjax')}",
				    success: function(msg){						
						$('#loan-application-group').html(msg);
						$('#customer-name').val($(msg).find('#customer-name2 a').html());
						$('#customer').val($(msg).find('#customer-id').html());
                                                $('#grantedAmount').val($(msg).find('#loan-amount').html()-0);
						$('#product-name').val($(msg).find('#product-name2 a').html());
						$('#product').val($(msg).find('#product-id').html());
						$('#term').val($(msg).find('#loan-term').html());
						$('#applicationDate').val($(msg).find('#loan-application-date').html());
                                                console.log("===================== ");
                                                console.log("status: "+$(msg).find('#loan-application-status').html());
                                                
                                                var loanProductTypeId = $(msg).find('#loanApp-product-type').val();
                                                var loanAppApprovalStatusid = $(msg).find('#loanApp-status-id').val();
                                                console.log("loanProductTypeId: "+loanProductTypeId);
                                                console.log("loanAppApprovalStatusid: "+loanAppApprovalStatusid);
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
                                               
											   
												
												
													  
                                                //alert(msg)
						updateSchemes();
				    },
				    error:function(XMLHttpRequest,textStatus,errorThrown){
                		alert(XMLHttpRequest+textStatus+errorThrown);
            		}
				});
            }

			function showLoanApplicationSearch() {				
				modal = new icbs.UI.Modal({id:"loanApplicationModal", url:"${createLink(controller: 'loanApplication', action:'search')}", title:"Search Account Application", onCloseCallback:updateLoanApplicationAjax});
                modal.show();
			}

			// update form schemes based on product
    		function updateSchemes() {
				$.ajax({
				    type: 'POST',
				    data: {id:"${loanInstance?.id}", product:$('#product').val(), interestIncomeScheme:"${loanInstance?.interestIncomeScheme?.id}", currentPenaltyScheme:"${loanInstance?.currentPenaltyScheme?.id}", pastDuePenaltyScheme:"${loanInstance?.pastDuePenaltyScheme?.id}"}, 
				    url: "${createLink(controller :'loan', action:'getProductSchemesAjax')}",
				    success: function(msg){						
				    	$('#interest-income-scheme').html($(msg).find('#interest-income-scheme').html());
				    	$('#current-penalty-scheme').html($(msg).find('#current-penalty-scheme').html());
				    	$('#past-due-penalty-scheme').html($(msg).find('#past-due-penalty-scheme').html());
				    	/*$('#performance-classification-scheme1').html($(msg).find('#performance-classification-scheme1').html());
				    	$('#performance-classification-scheme2').html($(msg).find('#performance-classification-scheme2').html());
				    	$('#performance-classification-scheme3').html($(msg).find('#performance-classification-scheme3').html());
				    	$('#performance-classification-scheme4').html($(msg).find('#performance-classification-scheme4').html());*/

            			updateForm();

				    },
				    error:function(XMLHttpRequest,textStatus,errorThrown){
                		alert(XMLHttpRequest+textStatus+errorThrown);
            		}
				});				
    		}
    		
			// update form fields based on installment calculation type	(from interest income scheme)
    		updateForm = function() {    			
			    var callback = function(data,params) {
			    	if ($('#interestRate').val().trim() == '') {
			    		$('#interestRate').val($(data).find('#default-interest-rate').html());
	    			}

					if ($(data).find('#changeable-interest-rate').html() == 'true') {
						$("#interestRate").prop('readonly', false);
					} else {
						$("#interestRate").prop('readonly', true);
					}

			    	var penaltyType = $(data).find('#penalty-type').html();
			    	if (penaltyType == 1) {  // fixed amount
		    			if ($('#penaltyAmount').val().trim() == '') {
			    			$('#penaltyAmount').val($(data).find('#default-penalty-amount').html());
		    			}
			    		$('#penaltyRate').val('');

			    		document.getElementById('penalty-amount-form-group').style.display = 'block';
			    		document.getElementById('penalty-rate-form-group').style.display = 'none';
			    	} else {  // rate based			    					    		
			    		$('#penaltyAmount').val('');
			    		if ($('#penaltyRate').val().trim() == '') {
			    			$('#penaltyRate').val($(data).find('#default-penalty-rate').html());
		    			}

			    		document.getElementById('penalty-amount-form-group').style.display = 'none';
			    		document.getElementById('penalty-rate-form-group').style.display = 'block';

			    		if ($(data).find('#changeable-penalty-rate').html() == 'true') {
							$("#penaltyRate").prop('readonly', false);
						} else {
							$("#penaltyRate").prop('readonly', true);
						}	
			    	}			    	

			    	/*var serviceChargeType = $(data).find('#service-charge-type').html();
			    	if (serviceChargeType == 1) {  // fixed amount
			    		$('#serviceCharge').val($(data).find('#service-charge-amount').html());
			    		$('#serviceCharge').prop('readonly', true);
			    		document.getElementById('service-charge-amount-form-group').style.display = 'block';
		    			document.getElementById('service-charge-rate-form-group').style.display = 'none';
			    	} else if (serviceChargeType == 2) {  // rate based
			    		$('#serviceChargeRate').val($(data).find('#service-charge-rate').html());
		    			document.getElementById('service-charge-amount-form-group').style.display = 'none';
		    			document.getElementById('service-charge-rate-form-group').style.display = 'block';
		    		} else {  
		    			//$('#serviceCharge').val('')
		    			$('#serviceCharge').prop('readonly', false);
			    		document.getElementById('service-charge-amount-form-group').style.display = 'block';
			    		document.getElementById('service-charge-rate-form-group').style.display = 'none';
		    		}*/

					var installmentType = $(data).find('#installment-type').html();
					var installmentCalculation = $(data).find('#installment-calculation').html();
					var advInterestType = $(data).find('#adv-interest-type').html();
			    	if (installmentCalculation == 1) {  // single payment
			    		$('#installment-tab').hide();
			    		//document.getElementById('amount-form-group').style.display = 'block';	
			    		$('#numInstallments').val('1');
						document.getElementById('term-form-group').style.display = 'block';
						document.getElementById('frequency-form-group').style.display = 'none';
						document.getElementById('num-installments-form-group').style.display = 'none';
						document.getElementById('installment-amount-form-group').style.display = 'none';
						document.getElementById('balloon-installments-form-group').style.display = 'none';

						// advanced interests
						if (advInterestType == 3) {
							document.getElementById('adv-interest-periods-form-group').style.display = 'none';
							document.getElementById('adv-interest-days-form-group').style.display = 'block';
						} else {
							document.getElementById('adv-interest-periods-form-group').style.display = 'none';
							document.getElementById('adv-interest-days-form-group').style.display = 'none';
						}

						document.getElementById('interest-start-date-form-group').style.display = 'block';
						document.getElementById('first-installment-date-form-group').style.display = 'block';
			    	} else if (installmentType == 5 || installmentCalculation == 6) {  // manual
			    		$('#installment-tab').show();
			    		//document.getElementById('amount-form-group').style.display = 'none';
			    		$('#numInstallments').val("${session['installments']?.size()}");
			    		document.getElementById('term-form-group').style.display = 'none';
                                                // allow frequency for manual type
						document.getElementById('frequency-form-group').style.display = 'block';
						document.getElementById('num-installments-form-group').style.display = 'none'
						document.getElementById('installment-amount-form-group').style.display = 'none';
						document.getElementById('balloon-installments-form-group').style.display = 'none';
						document.getElementById('adv-interest-periods-form-group').style.display = 'none';
						document.getElementById('adv-interest-days-form-group').style.display = 'none';
						document.getElementById('interest-start-date-form-group').style.display = 'block';
						document.getElementById('first-installment-date-form-group').style.display = 'none';
			    	} else {  // others
			    		$('#installment-tab').hide();
			    		//document.getElementById('amount-form-group').style.display = 'block';
			    		document.getElementById('term-form-group').style.display = 'none';
						document.getElementById('frequency-form-group').style.display = 'block';
						document.getElementById('num-installments-form-group').style.display = 'block';

						if (installmentCalculation == 3 || installmentCalculation == 7) {  // annuity
							updateInstallmentAmount();
							document.getElementById('installment-amount-form-group').style.display = 'block';
						} else {
							document.getElementById('installment-amount-form-group').style.display = 'none';
						}

						// declining fixed principal and straight/flat
						if ((installmentCalculation == 2 || installmentCalculation == 5) && 
							$(data).find('#balloon-mode').html() == 'true') {
							document.getElementById('balloon-installments-form-group').style.display = 'block';
						} else {
							document.getElementById('balloon-installments-form-group').style.display = 'none';
						}

						// advanced interests
						if (installmentCalculation == 2 || installmentCalculation == 5) {
							if (advInterestType == 3) {
								document.getElementById('adv-interest-periods-form-group').style.display = 'block';
								document.getElementById('adv-interest-days-form-group').style.display = 'none';
							} else {
								document.getElementById('adv-interest-periods-form-group').style.display = 'none';
								document.getElementById('adv-interest-days-form-group').style.display = 'none';
							}
						} else {
							document.getElementById('adv-interest-periods-form-group').style.display = 'none';
							document.getElementById('adv-interest-days-form-group').style.display = 'none';
						}

						document.getElementById('interest-start-date-form-group').style.display = 'block';
						document.getElementById('first-installment-date-form-group').style.display = 'block';
			    	}
			    };

			     var sendUpdate = function(){
			        var ajax = icbs.Dependencies.Ajax;
			        ajax.run({url:"${createLink(controller:'loan', 
			                      action:'getSchemeDetailsAjax')}", 
			                      params:{interestIncomeScheme:$('#interestIncomeScheme').val(), penaltyIncomeScheme:$('#currentPenaltyScheme').val()},
			                      callback:callback});    		    	
			    };
			    
			    sendUpdate();
			};

			function updateCustomerInfoAjax(params) {
                $.ajax({
				    type: 'POST',
				    data: {id:params.customer2},
				    url: "${createLink(controller :'customer', action:'showLoanApplicationAjax')}",
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

        	function showCustomerSearch() {
                modal = new icbs.UI.Modal({id:"customerDetailsModal", url:"${createLink(controller: 'search', action:'search')}", title:"Search Customer", onCloseCallback:updateCustomerInfoAjax});
                modal.show();
            }

            function showInstallments() {
				$.ajax({
				    type: 'POST',
									
				    url: "${createLink(controller:'loan', action:'showInstallmentsAjax')}",
									
				    success: function(msg){				    	
				    	$('#tab_6').html(msg);
				    },
				    error:function(XMLHttpRequest,textStatus,errorThrown){
                		alert(XMLHttpRequest+textStatus+errorThrown);
            		}
				});
            }
			
		 

            function addInstallmentAjax() {
				$.ajax({
				    type: 'POST',
				    data: {date:$('#installmentDate').val(), principal:$('#principalInstallmentAmount').val(), interest:$('#interestInstallmentAmount').val(),serviceCharge:$('#serviceChargeInstallmentAmount').val()},
				    url: "${createLink(controller:'loan', action:'addInstallmentAjax')}",
				    success: function(msg){
				    	$('#add-installment-modal .modal-body').html(msg);
    	                $('#add-installment-modal').on('hidden.bs.modal', function() {
    	                	showInstallments();
						});						
				    },
				    error:function(XMLHttpRequest,textStatus,errorThrown){
                		alert(XMLHttpRequest+textStatus+errorThrown);
            		}
				});				
            }            

            function showAddInstallment() {
				modal = new icbs.UI.Modal({id:"add-installment-modal", url:"${createLink(controller: 'loan', action:'showAddInstallmentAjax')}", title:"Add Installment"});
                modal.show();
            }
            function showAddImportInstallments(){
            modal = new icbs.UI.Modal({id:"import-installment-modal", url:"${createLink(controller: 'loan', action:'showImportInstallmentAjax')}", title:"Import Installment"});
             modal.show();
            
            } 

            function updateInstallmentAjax() {
				$.ajax({
				    type: 'POST',
				    data: {id:$('#installmentId').val(), date:$('#installmentDate').val(), principal:$('#principalInstallmentAmount').val(), interest:$('#interestInstallmentAmount').val(),serviceCharge:$('#serviceChargeInstallmentAmount').val()},
				    url: "${createLink(controller:'loan', action:'updateInstallmentAjax')}",
				    success: function(msg){
				    	$('#update-installment-modal .modal-body').html(msg);
    	                $('#update-installment-modal').on('hidden.bs.modal', function() {
    	                	showInstallments();
						});						
				    },
				    error:function(XMLHttpRequest,textStatus,errorThrown){
                		alert(XMLHttpRequest+textStatus+errorThrown);
            		}
				});
            }            

            function showUpdateInstallment(id) { 
            	$.ajax({
				    type: 'POST',
				    data: {id:id},
				    url: "${createLink(controller:'loan', action:'showUpdateInstallmentAjax')}",
				    success: function(msg){
				    	$('#installmentId').val(id);
				    	$('#update-installment-modal .modal-body').html(msg);				    	
				    	$('#update-installment-modal').modal({show:true});				    	
				    },
				    error:function(XMLHttpRequest,textStatus,errorThrown){
                		alert(XMLHttpRequest+textStatus+errorThrown);
            		}
				});
            }

            function deleteInstallmentAjax(id) {
            	if (confirm('Are you sure?')) {
					$.ajax({
					    type: 'POST',
					    data: {id:id},
					    url: "${createLink(controller:'loan', action:'deleteInstallmentAjax')}",
					    success: function(msg){
					    	if ($('#numInstallments').val() == '' || $('#numInstallments').val() == '0') {
					            $('#numInstallments').val('0');
					        } else {
					            var numInstallments = $('#numInstallments').val();
					            numInstallments--;
					            $('#numInstallments').val(numInstallments);
					        }

					    	showInstallments();
					    },
					    error:function(XMLHttpRequest,textStatus,errorThrown){
	                		alert(XMLHttpRequest+textStatus+errorThrown);
	            		}
					});
				}
            }

            function showServiceCharges() {
				$.ajax({
				    type: 'POST',
				    url: "${createLink(controller:'loan', action:'showServiceChargesAjax')}",
				    success: function(msg){				    	
				    	$('#tab_4').html(msg);
				    },
				    error:function(XMLHttpRequest,textStatus,errorThrown){
                		alert(XMLHttpRequest+textStatus+errorThrown);
            		}
				});
            }

            function addServiceChargeAjax() {
				$.ajax({
				    type: 'POST',
				    data: {grantedAmount:$('#grantedAmount').val(), numInstallments:$('#numInstallments').val(), scheme:$('#serviceChargeScheme').val(), product:$('#product').val(), amount:$('#serviceChargeAmount').val(), rate:$('#serviceChargeRate').val()},
				    url: "${createLink(controller:'loan', action:'addServiceChargeAjax')}",
				    success: function(msg){
				    	$('#add-service-charge-modal .modal-body').html(msg);
    	                $('#add-service-charge-modal').on('hidden.bs.modal', function() {
    	                	showServiceCharges();
						});						
				    },
				    error:function(XMLHttpRequest,textStatus,errorThrown){
                		alert(XMLHttpRequest+textStatus+errorThrown);
            		}
				});
            } 

            function showAddServiceCharge() {
                $.ajax({
				    type: 'POST',
				    data: {product:$('#product').val()},
				    url: "${createLink(controller:'loan', action:'showAddServiceChargeAjax')}",
				    success: function(msg){
				    	$('#add-service-charge-modal .modal-body').html(msg);    					    	
				    	$('#add-service-charge-modal').modal({show:true});				    	
				    },
				    error:function(XMLHttpRequest,textStatus,errorThrown){
                		alert(XMLHttpRequest+textStatus+errorThrown);
            		}
				});
            }

            function updateServiceChargeAjax() {
				$.ajax({
				    type: 'POST',
				    data: {grantedAmount:$('#grantedAmount').val(), numInstallments:$('#numInstallments').val(),id:$('#serviceChargeId').val(), scheme:$('#serviceChargeScheme').val(), product:$('#product').val(), amount:$('#serviceChargeAmount').val(), rate:$('#serviceChargeRate').val()},
				    url: "${createLink(controller:'loan', action:'updateServiceChargeAjax')}",
				    success: function(msg){				    	
				    	$('#update-service-charge-modal .modal-body').html(msg);
    	                $('#update-service-charge-modal').on('hidden.bs.modal', function() {
    	                	showServiceCharges();
						});						
				    },
				    error:function(XMLHttpRequest,textStatus,errorThrown){
                		alert(XMLHttpRequest+textStatus+errorThrown);
            		}
				});
            }            

            function showUpdateServiceCharge(id) { 
            	$.ajax({
				    type: 'POST',
				    data: {id:id, product:$('#product').val()},
				    url: "${createLink(controller:'loan', action:'showUpdateServiceChargeAjax')}",
				    success: function(msg){
				    	$('#serviceChargeId').val(id);
				    	$('#update-service-charge-modal .modal-body').html(msg);    	
				    	$('#update-service-charge-modal').modal({show:true});
				    },
				    error:function(XMLHttpRequest,textStatus,errorThrown){
                		alert(XMLHttpRequest+textStatus+errorThrown);
            		}
				});
            }

            function updateServiceChargeAmount() {
            	if ($('#grantedAmount').val() != '' && $('#numInstallments').val() > 0) {
					var grantedAmount = parseFloat($('#grantedAmount').val().replace(',', ''));
					var rate = $('#serviceChargeRate').val();
					var numInstallments = $('#numInstallments').val();
                                        grantedAmount = $('#grantedAmount').val();
					var amount = (grantedAmount * rate * 0.01) / numInstallments;
					amount = amount.toFixed(2);

					$("#serviceChargeRateAmount").val(amount);
				} else {
					$("#serviceChargeRateAmount").val('');	
				}
            }

            function updateServiceChargeForm() {
            	if ($('#serviceChargeScheme').val()) {
	                $.ajax({
					    type: 'POST',
					    data: {id:$('#serviceChargeScheme').val()},
					    url: "${createLink(controller :'loan', action:'getAmortizedChargeSchemeInfoAjax')}",
					    success: function(msg){	
							var type = $(msg).find('#type').html();
							var rate = $(msg).find('#rate').html();
							var amount = $(msg).find('#amount').html();

							if (type == 1) {  // fixed amount
								//if ($('#serviceChargeAmount').val().trim() == '') {
									$('#serviceChargeAmount').val(amount);
								//}
								$('#serviceChargeRate').val('');
								
								document.getElementById('service-charge-amount-form-group').style.display = 'block';
								document.getElementById('service-charge-rate-form-group').style.display = 'none';
							} else if (type == 2) {  // rate-based
								$('#serviceChargeAmount').val('');
								//if ($('#serviceChargeRate').val().trim() == '') {
									$('#serviceChargeRate').val(rate);
								//}
								
								updateServiceChargeAmount();
								document.getElementById('service-charge-amount-form-group').style.display = 'none';								
								document.getElementById('service-charge-rate-form-group').style.display = 'block';
							} else {  // manual
								//if ($('#serviceChargeAmount').val().trim() == '') {
									$('#serviceChargeAmount').val('');									
								//}								
								$('#serviceChargeRate').val('');

								document.getElementById('service-charge-amount-form-group').style.display = 'block';
								document.getElementById('service-charge-rate-form-group').style.display = 'none';
							}				
					    },
					    error:function(XMLHttpRequest,textStatus,errorThrown){
	                		alert(XMLHttpRequest+textStatus+errorThrown);
	            		}
					});
				}
        	}

        	function deleteServiceChargeAjax(id) {
            	if (confirm('Are you sure?')) {
					$.ajax({
					    type: 'POST',
					    data: {id:id},
					    url: "${createLink(controller:'loan', action:'deleteServiceChargeAjax')}",
					    success: function(msg){
					    	showServiceCharges();
					    },
					    error:function(XMLHttpRequest,textStatus,errorThrown){
	                		alert(XMLHttpRequest+textStatus+errorThrown);
	            		}
					});
				}
            }

            function showDeductions() {
				$.ajax({
				    type: 'POST',
				    url: "${createLink(controller:'loan', action:'showDeductionsAjax')}",
				    success: function(msg){				    	
				    	$('#tab_5').html(msg);
				    },
				    error:function(XMLHttpRequest,textStatus,errorThrown){
                		alert(XMLHttpRequest+textStatus+errorThrown);
            		}
				});
            }

            function addDeductionAjax() {
				$.ajax({
				    type: 'POST',
				    data: {grantedAmount:$('#grantedAmount').val(), scheme:$('#deductionScheme').val(), product:$('#product').val(), amount:$('#deductionAmount').val(), rate:$('#deductionRate').val()},
				    url: "${createLink(controller:'loan', action:'addDeductionAjax')}",
				    success: function(msg){
				    	$('#add-deduction-modal .modal-body').html(msg);
    	                $('#add-deduction-modal').on('hidden.bs.modal', function() {
    	                	showDeductions();
						});						
				    },
				    error:function(XMLHttpRequest,textStatus,errorThrown){
                		alert(XMLHttpRequest+textStatus+errorThrown);
            		}
				});				
            }            

            function showAddDeduction() {
                /*modal = new icbs.UI.Modal({id:"add-deduction-modal", url:"${createLink(controller: 'loan', action:'showAddDeductionAjax')}", title:"Add Deduction"});
                modal.show();*/

                $.ajax({
				    type: 'POST',
				    data: {product:$('#product').val()},
				    url: "${createLink(controller:'loan', action:'showAddDeductionAjax')}",
				    success: function(msg){
				    	$('#add-deduction-modal .modal-body').html(msg);    					    	
				    	$('#add-deduction-modal').modal({show:true});				    	
				    },
				    error:function(XMLHttpRequest,textStatus,errorThrown){
                		alert(XMLHttpRequest+textStatus+errorThrown);
            		}
				});
            }

            function updateDeductionAjax() {
				$.ajax({
				    type: 'POST',
				    data: {grantedAmount:$('#grantedAmount').val(), id:$('#deductionId').val(), scheme:$('#deductionScheme').val(), product:$('#product').val(), amount:$('#deductionAmount').val(), rate:$('#deductionRate').val()},
				    url: "${createLink(controller:'loan', action:'updateDeductionAjax')}",
				    success: function(msg){
				    	$('#update-deduction-modal .modal-body').html(msg);
    	                $('#update-deduction-modal').on('hidden.bs.modal', function() {
    	                	showDeductions();
						});						
				    },
				    error:function(XMLHttpRequest,textStatus,errorThrown){
                		alert(XMLHttpRequest+textStatus+errorThrown);
            		}
				});
            }            

            function showUpdateDeduction(id) {
            	$.ajax({
				    type: 'POST',
				    data: {id:id, product:$('#product').val()},
				    url: "${createLink(controller:'loan', action:'showUpdateDeductionAjax')}",
				    success: function(msg){
				    	$('#deductionId').val(id);
				    	$('#update-deduction-modal .modal-body').html(msg);    	
				    	$('#update-deduction-modal').modal({show:true});
				    },
				    error:function(XMLHttpRequest,textStatus,errorThrown){
                		alert(XMLHttpRequest+textStatus+errorThrown);
            		}
				});
            }
            //===================================================
            function Comma(Num) { //function to add commas to textboxes
                Num += '';
                Num = Num.replace(',', ''); Num = Num.replace(',', ''); Num = Num.replace(',', '');
                Num = Num.replace(',', ''); Num = Num.replace(',', ''); Num = Num.replace(',', '');
                x = Num.split('.');
                x1 = x[0];
                x2 = x.length > 1 ? '.' + x[1] : '';
                var rgx = /(\d+)(\d{3})/;
                while (rgx.test(x1))
                    x1 = x1.replace(rgx, '$1' + ',' + '$2');
                return x1 + x2;
            }
            function AddComma(){
                  $('#deductionAmount').val(Comma( $('#deductionAmount').val()));
                  
            }
            //===================================================
            function updateDeductionAmount(type) {
            	if ($('#grantedAmount').val() != '') {
            		var amount
            		var grantedAmount = parseFloat($('#grantedAmount').val().replace(',', ''));
                        grantedAmount = accounting.unformat($('#grantedAmount').val());
            		if (type == 2) {  // rate            			
						var rate = $('#deductionRate').val();

						amount = (grantedAmount * rate * 0.01);	
						amount = amount.toFixed(2);
						$("#deductionRateAmount").val(amount);
            		} else if (type == 3) {  // special - dst rem
            			amount = (grantedAmount / 1000 * 5) + 10;
            			amount = amount.toFixed(2);
            			$("#deductionAmount").val(amount);
            		} else if (type == 4) {  // special - dst rn
            			$.ajax({
						    type: 'POST',
						    data: {term:$('#term').val(), numInstallments:$('#numInstallments').val(), frequency:$('#frequency').val(), openingDate:$('#openingDate').val(), firstInstallmentDate:$('#firstInstallmentDate').val(), interestIncomeScheme:$('#interestIncomeScheme').val()},
						    url: "${createLink(controller :'loan', action:'getTermAjax')}",
						    success: function(msg){
						    	var term = $(msg).find('#term').html();
						    	
						    	amount = (grantedAmount / 1000 * 5) * (term / 365);
						    	amount = amount.toFixed(2);
						    	$("#deductionAmount").val(amount);
						    },
						    error:function(XMLHttpRequest,textStatus,errorThrown){
		                		$("#deductionAmount").val('');
		            		}
						});
            		}            	
				} else {
					$("#deductionAmount").val('');
					$("#deductionRateAmount").val('');	
				}
            }

            function updateDeductionForm() {
            	if ($('#deductionScheme').val()) {
	                $.ajax({
					    type: 'POST',
					    data: {id:$('#deductionScheme').val()},
					    url: "${createLink(controller :'loan', action:'getDeductionSchemeInfoAjax')}",
					    success: function(msg){
							var type = $(msg).find('#type').html();
							var rate = $(msg).find('#rate').html();
							var amount = $(msg).find('#amount').html();

							if (type == 1) {  // fixed amount
								//if ($('#deductionAmount').val().trim() == '') {
									$('#deductionAmount').val(amount);	
								//}
								$('#deductionRate').val('');
								
								document.getElementById('deduction-amount-form-group').style.display = 'block';
								document.getElementById('deduction-rate-form-group').style.display = 'none';
							} else if (type == 2) {  // rate-based
								$('#deductionAmount').val('');
								//if ($('#deductionRate').val().trim() == '') {
									$('#deductionRate').val(rate);	
								//}
								
								updateDeductionAmount(type);
								document.getElementById('deduction-amount-form-group').style.display = 'none';
								document.getElementById('deduction-rate-form-group').style.display = 'block';
							} else if (type == 3) {  // special - dst rem
								//if ($('#deductionAmount').val().trim() == '') {
									$('#deductionAmount').val('');
								//}
								$('#deductionRate').val('');

								updateDeductionAmount(type);
								document.getElementById('deduction-amount-form-group').style.display = 'block';
								document.getElementById('deduction-rate-form-group').style.display = 'none';
							} else if (type == 4) {  // special - dst rn
								//if ($('#deductionAmount').val().trim() == '') {
									$('#deductionAmount').val('');
								//}
								$('#deductionRate').val('');

								updateDeductionAmount(type);
								document.getElementById('deduction-amount-form-group').style.display = 'block';
								document.getElementById('deduction-rate-form-group').style.display = 'none';
							} else {  // manual
								//if ($('#deductionAmount').val().trim() == '') {
									$('#deductionAmount').val('');
								//}
								$('#deductionRate').val('');

								document.getElementById('deduction-amount-form-group').style.display = 'block';
								document.getElementById('deduction-rate-form-group').style.display = 'none';
							}
					    },
					    error:function(XMLHttpRequest,textStatus,errorThrown){
	                		alert(XMLHttpRequest+textStatus+errorThrown);
	            		}
					});
				}
            }

            function deleteDeductionAjax(id) {
            	if (confirm('Are you sure?')) {
					$.ajax({
					    type: 'POST',
					    data: {id:id},
					    url: "${createLink(controller:'loan', action:'deleteDeductionAjax')}",
					    success: function(msg){
					    	showDeductions();
					    },
					    error:function(XMLHttpRequest,textStatus,errorThrown){
	                		alert(XMLHttpRequest+textStatus+errorThrown);
	            		}
					});
				}
            }

            function showSweepAccounts() {
				$.ajax({
				    type: 'POST',
				    url: "${createLink(controller:'loan', action:'showSweepAccountsAjax')}",
				    success: function(msg){				    	
				    	$('#tab_7').html(msg);
				    },
				    error:function(XMLHttpRequest,textStatus,errorThrown){
                		alert(XMLHttpRequest+textStatus+errorThrown);
            		}
				});
            }

            function addSweepAccountAjax() {        		
				$.ajax({
				    type: 'POST',
				    data: {loanidvalue:$('#loanidvalue').val(),deposit:$('#depositAccount').val(), type:$('#type').val(), rule:$('#rule').val(), fundLimitAmt:$('#fundLimitAmt').val(), fundLimitPercentage:$('#fundLimitPercentage').val(), ordinalNum:$('#ordinalNum').val(), remarks:$('#remarks').val()},
				    url: "${createLink(controller:'loan', action:'addSweepAccountAjax')}",
				    success: function(msg){
				    	$('#add-sweep-account-modal .modal-body').html(msg);
                                        $('#add-sweep-account-modal').on('hidden.bs.modal', function() {
                                         showSweepAccounts();
						});
        
				    },
				    error:function(XMLHttpRequest,textStatus,errorThrown){
                		alert(XMLHttpRequest+textStatus+errorThrown);
            		}
				});				
            }            

            function showAddSweepAccount() {
                $.ajax({
				    type: 'POST',
				    data: {product:$('#product').val()},
				    url: "${createLink(controller:'loan', action:'showAddSweepAccountAjax')}",
				    success: function(msg){
				    	$('#add-sweep-account-modal .modal-body').html(msg);    					    	
				    	$('#add-sweep-account-modal').modal({show:true});				    	
				    },
				    error:function(XMLHttpRequest,textStatus,errorThrown){
                		alert(XMLHttpRequest+textStatus+errorThrown);
            		}
				});
            }

            function updateSweepAccountAjax() {
                alertify.confirm(AppTitle,"Are you sure you want to update this Sweep Account?",
                    function(){
				$.ajax({
				    type: 'POST',
				    data: {posArray:$('#arraypoistion').val(),id:$('#sweepAccountId').val(), deposit:$('#depositAccount').val(), type:$('#type').val(), rule:$('#rule').val(), fundLimitAmt:$('#fundLimitAmt').val(), fundLimitPercentage:$('#fundLimitPercentage').val(), ordinalNum:$('#ordinalNum').val(), remarks:$('#remarks').val()},
				    url: "${createLink(controller:'loan', action:'updateSweepAccountAjax')}",
				    success: function(msg){				    	
				    	$('#update-sweep-account-modal .modal-body').html(msg);
                                        $('#update-sweep-account-modal').on('hidden.bs.modal', function() {
                                            showSweepAccounts();
						});						
				    },
				    error:function(XMLHttpRequest,textStatus,errorThrown){
                                        alert(XMLHttpRequest+textStatus+errorThrown);
                                    }
				});
                    },
                    function(){
                        
                    });
            }            

            function showUpdateSweepAccount(frmsessionValue) { 
                console.log("the sweep frmsessionValue:"+frmsessionValue);
                
                var actionpageControl = $('#actionPage').val()
                var id=""
                var posArray=""
                if(actionpageControl=='edit'){
                    console.log("actionpageControl: "+actionpageControl);
                    var valuessSession = frmsessionValue.split("*");
                    id = valuessSession[0]
                    posArray = valuessSession[1]                
                }else{
                    id = frmsessionValue
                    posArray = frmsessionValue
                }

				
            	$.ajax({
				    type: 'POST',
				    data: {id:id,posArray:posArray},
				    url: "${createLink(controller:'loan', action:'showUpdateSweepAccountAjax')}",
				    success: function(msg){
				    	$('#sweepAccountId').val(id);
				    	$('#update-sweep-account-modal .modal-body').html(msg);    	
				    	$('#update-sweep-account-modal').modal({show:true});
				    },
				    error:function(XMLHttpRequest,textStatus,errorThrown){
                		alert(XMLHttpRequest+textStatus+errorThrown);
            		}
		}); 
            }

            function updateSweepForm() {
            	var rule = $('#rule').val();
            	if (rule == 1 || rule == 2) {
					document.getElementById('fund-limit-amount-form-group').style.display = 'none';
					document.getElementById('fund-limit-percentage-form-group').style.display = 'none';
				} else if (rule == 3) {
					document.getElementById('fund-limit-amount-form-group').style.display = 'block';
					document.getElementById('fund-limit-percentage-form-group').style.display = 'none';
				} else if (rule == 4) {
					document.getElementById('fund-limit-amount-form-group').style.display = 'none';
					document.getElementById('fund-limit-percentage-form-group').style.display = 'block';
				}
        	}

            function deleteSweepAccountAjax(frmsessionValue) {
                console.log("the sweep frmsessionValue:"+frmsessionValue);
                var actionpageControl = $('#actionPage').val()
                var id=""
                var posArray=""
                if(actionpageControl=='edit'){
                    console.log("actionpageControl: "+actionpageControl);
                    var valuessSession = frmsessionValue.split("*");
                    id = valuessSession[0]
                    posArray = valuessSession[1]                
                }else{
                    id = frmsessionValue
                    posArray = frmsessionValue
                } 
                alertify.confirm(AppTitle,"Are you sure you want to Remove/Delete this ?",
                  function(){
            	
                        $.ajax({
                            type: 'POST',
                            data: {id:id,posArray:posArray},
                            url: "${createLink(controller:'loan', action:'deleteSweepAccountAjax')}",
                            success: function(msg){
                                alertify.alert("Successfully Deleted!", function(){
                                    showSweepAccounts();      
                                });    
                                
                            },
                            error:function(XMLHttpRequest,textStatus,errorThrown){
                                alert(XMLHttpRequest+textStatus+errorThrown);
                            }
                        });                    
                  },
                  function(){
                    
                  });

				
            }

            function showDepositSearch(){
                modal = new icbs.UI.Modal({id:"searchDepositModal",url:"${createLink(controller : 'search', action:'search', params:[searchDomain: "deposit"])}",title:"Search Deposit Accounts",onCloseCallback:updateDepositAccount});
            	modal.show();
            }

            function updateDepositAccount(params){
            	if (params.deposit) {
            		$.ajax({
				    type: 'POST',
				    data: {id:params.deposit},
				    url: "${createLink(controller:'loan', action:'showDepositAccountInfo')}",
				    success: function(msg){				    					    	
				    	$('#accountNo').val($(msg).find('#account-no').html());
				    	$('#depositAccount').val(params.deposit);

				    },
				    error:function(XMLHttpRequest,textStatus,errorThrown){
                		alert(XMLHttpRequest+textStatus+errorThrown);
            		}
				});

            	}
            }
            function addImportInstallmentAjax(){
                console.log("hahahah");
                var filetopass = $("#file2")[0].files[0];
                var oMyForm = new FormData();
                oMyForm.append("file", filetopass);
                 var url="${createLink(controller:'loan',action:'importInstallmentss')}";
                  $.ajax({
                   url: url,
                   data: oMyForm,
                   dataType: 'text',
                   processData: false,
                   contentType: false,
                   type: 'POST',
                   success: function(data){
                     showImportInstallmentsfrm();
                   }
                 });
                
            }
            function showImportInstallmentsfrm() {
            var passvalueonoff = "import";
				$.ajax({
				    type: 'POST',
                                    data: {onffvalue:passvalueonoff},
				    url: "${createLink(controller:'loan', action:'showInstallmentsAjax')}",
                                    
				    success: function(msg){				    	
				    	$('#tab_6').html(msg);
				    },
				    error:function(XMLHttpRequest,textStatus,errorThrown){
                		alert(XMLHttpRequest+textStatus+errorThrown);
            		}
				});
            }

        	icbs.Dependencies.Ajax.addLoadEvent(function(){
        		$('#installment-tab').hide();
        		updateLoanApplicationAjax({loanApplication2:"${loanInstance?.loanApplication?.id ?: loanApplication?.id}"});
            });
            
             //Update customer info update
            function createCIFAuthCallback(){
                //jQuery('#updateCustomerForm').submit()
                customerVerificationValidation(true)
            }
            //Override for customer info update
            function createCIF(){
                checkIfAllowed('CIF00010', createCIFAuthCallback); // params: policyTemplate.code, form to be saved
            }
            
   		</g:javascript>		
	</head>
	<body>
        <content tag="breadcrumbs">
            <span class="fa fa-chevron-right"></span><span class="current">Create Account Account</span>
	</content>
        <content tag="main-content">
		<div id="create-loan" class="content scaffold-create" role="main">
			<g:if test="${flash.message}">
                <script>
                        $(function(){
                            var x = '${flash.message}';
                                notify.message(x);
                        });
                </script>
            </g:if>
			<g:hasErrors bean="${loanInstance}">
	            <script>
                    $(function
                        var x = '${it}';
                        notify.error(x);
                       // console.log(x)
                       // setTimeout(function(){ notify.success(x); }, 3000);
                    });
                    </script>
            </g:hasErrors>
			<g:form id="loan-form" url="[resource:loanInstance, action:'save']"
                            onsubmit="callLoadingDialog();">
				<div class="nav-tab-container">
                    <ul class="nav nav-tabs">
                        <li class="active"><a href="#tab_1" data-toggle="tab">Account Application</a></li> 
                        <li><a href="#tab_2" data-toggle="tab">Specification</a></li>                        
                        <li><a href="#tab_3" data-toggle="tab">Classification</a></li>
                        <li><a href="#tab_4" data-toggle="tab">Service Charges</a></li>
                        <li><a href="#tab_5" data-toggle="tab">Deductions</a></li>
                        <li><a href="#tab_6" data-toggle="tab" id="installment-tab">Installments</a></li>                    
                    </ul>
                </div>
                <div class="tab-content">
					<div class="tab-pane active fade in table-responsive" id="tab_1">
						<g:render template="loanApplication/form"/>
					</div>
					<div class="tab-pane" id="tab_2">
						<g:render template="specification/form"/>						
					</div>
					<div class="tab-pane" id="tab_3">
						<g:render template="classification/form"/>						
					</div>
					<div class="tab-pane" id="tab_4">
						<g:render template="serviceCharges/list"/>
					</div>
					<div class="tab-pane" id="tab_5">
						<g:render template="deductions/list"/>
					</div>
					<div class="tab-pane" id="tab_6">
						<g:render template="installments/list"/>
					</div>
				</div>
			</g:form>
		</div>
        </content>
        <content tag="main-actions">
            <ul>
                <!-- 
                <li><g:submitButton id="save" name="save" value="Save" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Save?')}');"/></li>
                <script type="text/javascript">
		            $(document).ready(function() {
		               	$( "#save" ).click(function() {
		             		 checkIfAllowed('LON00500', 'form#loan-form', 'Update branch XXX.', null); // params: policyTemplate.code, form to be saved
		               	});
		            }); 
               </script>
               -->
                <li><g:submitButton id="save" name="save" value="Save" onclick="
                        alertify.confirm(AppTitle,'Are you sure you want to create this Account?',
                                function(){
                                    checkIfAllowed('LON00500', 'form#loan-form', 'Open New Account', null);;
                                },
                                function(){
                                    return;
                                }); 
                        "/></li>
                <li><g:link class="list" action="index" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');">Cancel</g:link></li>
            </ul>
        </content>
	</body>
</html>
