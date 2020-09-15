1<!DOCTYPE html>
<html> 
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="layout" content="main">
        <asset:javascript src="customerHelper.js"/>
        <g:set var="entityName" value="${message(code: 'customer.label', default: 'Customer')}" />
        <title><g:message code="default.create.label" args="[entityName]"/>
                <div class="customerName">
                    <g:if test="${customerInstance?.displayName}">
                        ${customerInstance?.displayName}
                    </g:if>
                </div>
        </title>
        <g:javascript>
            function updateContact() {
                var Contact = $('#contactNum').val().replace(/([A-Z,a-z])/g,'');
                $('#contactNum').val(Contact);
            }
            function customerVerificationValidation(onsubmit){
                if(onsubmit){
                    icbs.Customer.Form.Validation.validateForm("${createLink(controller : 'customer', action:'customerVerificationValidationAjax')}",jQuery('#tab_1 :input').serialize()+"&onsubmit=true",1,true);     
                }else{
                    icbs.Customer.Form.Validation.validateForm("${createLink(controller : 'customer', action:'customerVerificationValidationAjax')}",jQuery('#tab_1 :input').serialize(),1);     
                }
            }
            function customerAddressValidation(){
                icbs.Customer.Form.Validation.validateForm("${createLink(controller : 'customer', action:'customerAddressInformationValidationAjax')}",jQuery('#tab_4 :input').serialize(),4);
            }
            function customerBeneficiaryValidation(){
                icbs.Customer.Form.Validation.validateForm("${createLink(controller : 'customer', action:'customerBeneficiaryInformationValidationAjax')}",jQuery('#tab_10 :input').serialize(),10);
            }
            function customerInsuranceValidation(){
                icbs.Customer.Form.Validation.validateForm("${createLink(controller : 'customer', action:'customerInsuranceInformationValidationAjax')}",jQuery('#tab_11 :input').serialize(),11);
            }
            function customerContactDetailsValidation(){
                icbs.Customer.Form.Validation.validateForm("${createLink(controller : 'customer', action:'customerContactInformationValidationAjax')}",jQuery('#tab_3 :input').serialize(),3);  
            }
            function customerOtherDetailsValidation(){
                icbs.Customer.Form.Validation.validateForm("${createLink(controller : 'customer', action:'customerOtherDetailsValidationAjax')}",jQuery('#tab_2 :input').serialize()+'&type.id=${customerInstance?.type?.id}',2);     
            }
            function customerEducationValidation(){
                icbs.Customer.Form.Validation.validateForm("${createLink(controller : 'customer', action:'customerEducationInformationValidationAjax')}",jQuery('#tab_7 :input').serialize(),7);
            }
            function customerBusinessAndEmploymentValidation(){
                icbs.Customer.Form.Validation.validateForm("${createLink(controller : 'customer', action:'customerEmploymentBusinessInformationValidationAjax')}",jQuery('#tab_5 :input').serialize()+'&type.id=${customerInstance?.type?.id}',5);
            }
            function customerPresentedIdAndOtherAcctValidation(){
                icbs.Customer.Form.Validation.validateForm("${createLink(controller : 'customer', action:'customerIdsAndOtherAcctsValidationAjax')}",jQuery('#tab_9 :input').serialize()+'&type.id=${customerInstance?.type?.id}',9);
            }
            function customerFamilyValidation(){
                icbs.Customer.Form.Validation.validateForm("${createLink(controller : 'customer', action:'customerRelationValidationAjax')}",jQuery('#tab_6 :input').serialize(),6);
            }
            function changeVerificationForm(){
                icbs.Customer.Form.getForm('changeVerificationForm',"${createLink(controller : 'customer', action:'changeCustomerTypeFormAjax')}",jQuery('#tab_1 :input').serialize());
            }
            function addAddressAjax(){
                icbs.Customer.Form.getForm('address',"${createLink(controller : 'customer', action:'addAddressFormAjax')}");
            }
            function addBeneficiaryAjax(){
                console.log("gieeeeee");
                 icbs.Customer.Form.getForm('beneficiary',"${createLink(controller : 'customer', action:'addBeneficiaryFormAjax')}");
            }
            function addAttachmentAjax(choice){
                icbs.Customer.Form.getForm('attachment',"${createLink(controller : 'customer', action:'addAttachmentFormAjax')}",choice);
            }    
            function addContactAjax(choice){
                icbs.Customer.Form.getForm('contact',"${createLink(controller : 'customer', action:'addContactFormAjax')}",choice);
            }
            function addEducationAjax(choice){
                icbs.Customer.Form.getForm('education',"${createLink(controller : 'customer', action:'addEducationFormAjax')}",choice);
            }
            function addOtherAcctAjax(){
                icbs.Customer.Form.getForm('otherAcct',"${createLink(controller : 'customer', action:'addOtherAcctFormAjax')}");
            }
            function addPresentedIdAjax(){
                icbs.Customer.Form.getForm('presentedId',"${createLink(controller : 'customer', action:'addPresentedIdFormAjax')}");
            }
            function addRelationAjax(params){
                icbs.Customer.Form.getForm('relation',"${createLink(controller : 'customer', action:'addRelationFormAjax')}",params);
            }
            function addKnownRelationAjax(params){
                console.log(params);
                icbs.Customer.Form.getForm('knownRelation',"${createLink(controller : 'customer', action:'addRelationFormAjax')}",params);
            }
            /*Modal for relationships*/
            var modal;
            function initializeRelationModal(){
                modal = new icbs.UI.Modal({id:"relationSearchModal",url:"${createLink(controller : 'search', action:'search')}",title:"Search Customer",onCloseCallback:addKnownRelationAjax});
            }
            
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
            <span class="fa fa-chevron-right"></span><span class="current">Create Customer</span>
	</content>
        <content tag="main-content">
                <g:if test="${flash.message}">
                    <div class="box-body">
                        <div class="alert alert-info alert-dismissable">
                            <i class="fa fa-info"></i>
                            <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                            <b>Message</b> <div class="message" role="status">${flash.message}</div>
                        </div>
                    </div>
                </g:if>
                <g:hasErrors bean="${customerInstance}">
                <div class="box-body">
                    <div class="alert alert-danger alert-dismissable">
                        <i class="fa fa-ban"></i>
                        <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                        <b>Alert!</b> 
                        <ul class="errors" role="alert">
                            There are errors. The tabs containing the errors are highlighted in red
                        </ul>            
                    </div>
                </div>
                </g:hasErrors>
            <g:if test="${firstCreate}">
                <g:form id="saveCustomerForm"url="[resource:customerInstance,action:'create']" method="POST" 
                    class="form-horizontal" onsubmit="callLoadingDialog();">
                    <g:render template="form/customer/customerverification/customerType"/>
                </g:form>
            </g:if>
            <g:else>
                <g:uploadForm id="saveCustomerForm" onsubmit="callLoadingDialog();" url="[resource:customerInstance,action:'save']" method="POST" class="form-horizontal">
                    <g:render template="form"/>
                </g:uploadForm>
            </g:else>
        </content>
        <content tag="main-actions">
            <ul>
                <g:if test="${!firstCreate}">
                    <li><a href='#' onclick="alertNowConfirmCustomerCreation();">Create</a></li>
                        <script>  
                          function alertNowConfirmCustomerCreation(){
                            console.log("customer type");
                            var civilStatusChecker = $('#xxcivilStatus').val();
                            console.log("civilStatusChecker : "+civilStatusChecker);
                            if(civilStatusChecker){

                                    var xxspouseFirstName = document.getElementById('xspouseFirstName').value;
                                    var xxspouseLastName =document.getElementById('spouseLastName').value;
                                    var xxspouseMiddleName = document.getElementById('spouseMiddleName').value;
                                    var xxspouseBirthDate = document.getElementById('spouseBirthDate').value;
                                    var xxspouseContactNo = document.getElementById('spouseContactNo').value;

                                    console.log("civilStatusChecker : "+civilStatusChecker);
                                    console.log("xspouseLastName : "+xxspouseLastName);
                                    console.log("xspouseFirstName : "+xxspouseFirstName);
                                    console.log("xspouseMiddleName : "+xxspouseMiddleName);
                                    console.log("xspouseBirthDate : "+xxspouseBirthDate);
                                    console.log("xspouseContactNo : "+xxspouseContactNo);

                                    if(civilStatusChecker !=  66){
                                              if(xxspouseFirstName =="" || xxspouseLastName == "" || xxspouseMiddleName =="" || xxspouseBirthDate =="" ||  xxspouseContactNo ==""){
                                                        console.log("incomple data");
                                                       notify.message('Incomplete Spouse Information! ...|error|alert'); 
                                                       return false;
                                              }
                                    }
                           }
                            var xxxxpreseID = $('#xxpresentID').val();
                            var idididno = $('#idno').val();
                            console.log('xxid: '+xxxxpreseID);
                            console.log('idididno: '+idididno);
                            
                            
                            var xerror = "";
                            var counter = 0;
                            $( "select[name^='presentedids']" ).each(function () {
                                console.log("select value: "+this.value);
                                console.log("ID NO: "+$('#idno'+counter).val());
                                idididno = $('#idno'+counter).val();

                                if (this.value == 20 && idididno.length != 11){
                                    //GSIS/UMID
                                    xerror = "error";
                                    notify.message('GSIS ID Number must be 11 Digits!|error|alert'); 
                                    return false;

                                }else if (this.value == 21 && idididno.length != 10){
                                    //SSS ID
                                    xerror = "error";
                                    notify.message('SSS ID Number must be 10 Digits!|error|alert'); 
                                    return false;

                                }else if (this.value == 18 && !(idididno.length > 8 && idididno.length < 13)){
                                    //TIN ID
                                    xerror = "error";    
                                    notify.message('TIN ID Number must be 9 to 12 Digits!|error|alert'); 
                                    return false;

                                }
                                
                                counter = counter + 1;
                            });
                            if(xerror == "error"){

                            }else{
                                alertify.confirm(AppTitle,"Are you sure you want to create this customer?",
                                  function(){
                                      createCIF();
                                  },
                                  function(){
                                    alertify.error('Canceled!');
                                  });
                               
                            }
                        }  
                            
                           
                       </script> 
                </g:if>
                <g:else>
                <li><a href='#' onClick='alertContinueToCustomerForm();'>Continue to Customer Form</a></li>
                        <script>  
                          function alertContinueToCustomerForm(){
                            alertify.confirm(AppTitle,"Are you sure you want to Proceed?",
                                  function(){
                                      jQuery('#saveCustomerForm').submit()
                                  },
                                  function(){
                                    alertify.error('Canceled!');
                                  });
                           }
                           
                       </script>                
                </g:else>
                <li><a href="#" onClick='theAlertCustomerCancel();'>Cancel</a></li>
                      <g:javascript>  
                           function theAlertCustomerCancel(){
                            
                            alertify.confirm(AppTitle,"Are you sure you want to return to CIF Search page? Your progress will not be saved.",
                                  
                                  function(){
                                      var x1 = "/icbs/customer/customerSearch"
                                      console.log("x1: "+x1);
                                      window.location = x1;
                                  },
                                  function(){
                                    
                                  });                                  
                           }
                       </g:javascript>      
            </ul>
        </content>
    </body>
    <g:javascript>
            icbs.Customer.Form.getForm.contactCount = ${customerInstance?.contacts.size()};
            icbs.Customer.Form.getForm.attachmentCount = ${customerInstance?.attachments.size()};
            icbs.Customer.Form.getForm.addressCount = ${customerInstance?.addresses.size()};
            icbs.Customer.Form.getForm.beneficiaryCount = ${customerInstance?.beneficiaries.size()};
            icbs.Customer.Form.getForm.relationCount = ${customerInstance?.relations.size()};
            icbs.Customer.Form.getForm.otherAcctCount = ${customerInstance?.otheraccts.size()};
            icbs.Customer.Form.getForm.presentedIdCount = ${customerInstance?.presentedids.size()};
            icbs.Customer.Form.getForm.educationCount = ${customerInstance?.educations.size()};
    </g:javascript>
</html>
