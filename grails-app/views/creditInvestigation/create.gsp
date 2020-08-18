<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'creditInvestigation.label', default: 'CreditInvestigation')}" />
		<g:if test="${creditTypeAction == "secured"}">
                    <title>Create Credit Investigation</title>
                </g:if>   
                <g:else>
                    <title>Credit Processing for Unsecured</title>
                </g:else>    
		<g:javascript>
                // A $( document ).ready() block.
                $( document ).ready(function() {
                    console.log( "ready!" );
                    var xLoan = $('#loanApplication').val();
                    var secAndUnsec = $('#securedUnsec').val();
                    console.log("xLoan: "+xLoan);
                    if(xLoan){
                        checkIfUnsecOrSecure(xLoan);
                    }else{
                        if(secAndUnsec == "secured"){
                            document.getElementById("unsec").style.display = "none";
                            document.getElementById("secured").style.display = "block";
                        }else{
                            document.getElementById("unsec").style.display = "block";
                            document.getElementById("secured").style.display = "none";
                        }
                        
                    }
                    
                });
                function checkIfUnsecOrSecure(xLoanAppid){
                    console.log("xLoanAppid: "+xLoanAppid);
                    var obj = {
                            loanAppIdFrmSelect: xLoanAppid,
                        };
                        //console.log(JSON.stringify(obj));
                        //console.log("Object Loaded iwth data...");
                        $.ajax({
                            type: "POST",
                            contentType: "application/json",
                            url: "${createLink(controller:'loanApplication', action:'unsecAndSecuredApplicationCheckerAjax')}",
                            data: JSON.stringify(obj),

                            success: function(data){

                                $.each(data, function (_key, _value) {
                                    //console.log(JSON.stringify(data));
                                    console.log(_value.display_name);
                                    console.log(_value.amount);
                                   
                                    $('#borrowerName').val(_value.display_name);
                                    $('#amount').val(_value.amount);
//                                    if(_value.guarantee_facility_id == "null" || _value.guarantee_facility_id == null){
//                                        alertify.alert(AppTitle,"Sorry,Please Update loan application first some details missing (Guarantee Facility)", function(){
//                                            window.location.href="/icbs/creditInvestigation/";
//                                        });
//                                    }else if(parseInt(_value.cirecord) > 0){
//                                        alertify.alert(AppTitle,"Sorry, This Loan Application has record already kindly check", function(){
//                                            window.location.href="/icbs/creditInvestigation/";
//                                        });
//                                    }else{
//                                        console.log("_value.guarantee_facility_id: "+_value.guarantee_facility_id);
//                                        var secAndUnsecCheck = parseInt(_value.guarantee_facility_id);
//                                        $('#loanAppSecOrUnsecId').val(secAndUnsecCheck);
//                                        if(secAndUnsecCheck == 8 || secAndUnsecCheck == 5 || secAndUnsecCheck == 9 || secAndUnsecCheck == 2 || secAndUnsecCheck == 10 ){
//                                            //unsecured
//                                            document.getElementById("unsec").style.display = "block";
//                                            document.getElementById("secured").style.display = "none";
//                                        }else{
//                                            //secured
//                                            document.getElementById("unsec").style.display = "none";
//                                            document.getElementById("secured").style.display = "block";
//                                        }
//                                        
//                                    }   
                                    
                                    
                                    
                                });
                            },
                            error: function(data){
                                console.log('Pumasok sa error');
                            },
                        }); //AJAX CLOSE
                }
                function updateLoanApplicationAjax(params) {
                    if (params.loanApplication2) {
                        $('#loanApplication').val(params.loanApplication2);
                        checkIfUnsecOrSecure(params.loanApplication2);
                        
                    }
                }

			function showLoanApplicationSearch() {				
				modal = new icbs.UI.Modal({id:"loanApplicationModal", url:"${createLink(controller: 'loanApplication', action:'search')}", title:"Search Account Application", onCloseCallback:updateLoanApplicationAjax});
                modal.show();
			}

			function showAttachments() {
                $.ajax({
                    type: 'POST',
                    url: "${createLink(controller:'creditInvestigation', action:'showAttachmentsAjax')}",
                    success: function(msg){                     
                        $('#tab_2').html(msg);
                    },
                    error:function(XMLHttpRequest,textStatus,errorThrown){
                        alert(XMLHttpRequest+textStatus+errorThrown);
                    }
                });
            }

            function addAttachmentAjax() {
                var file = (document.getElementById("fileData")).files[0];                                

                var data = new FormData(); 
                data.append("file", file);
                data.append("description", $('#add-attachment-modal #description').val());
                data.append("type", $('#add-attachment-modal #type').val());

                $.ajax({
                    type: 'POST',
                    data: data,
                    contentType: false,
                    processData: false,
                    url: "${createLink(controller:'creditInvestigation', action:'addAttachmentAjax')}",
                    success: function(msg){
                        $('#add-attachment-modal .modal-body').html(msg);
                        $('#add-attachment-modal').on('hidden.bs.modal', function() {
                            showAttachments();
                        });                     
                    },
                    error:function(XMLHttpRequest,textStatus,errorThrown){
                        alert(XMLHttpRequest+textStatus+errorThrown);
                    }
                });        
            }            

            function showAddAttachment() {
                modal = new icbs.UI.Modal({id:"add-attachment-modal", url:"${createLink(controller: 'creditInvestigation', action:'showAddAttachmentAjax')}", title:"Add Attachment"});
                modal.show();
            }

            function updateAttachmentAjax() {
                var description = $('#update-attachment-modal #description').val();
                var type = $('#update-attachment-modal #type').val();
                
                $.ajax({
                    type: 'POST',
                    data: {id:$('#attachmentId').val(), description:description, type:type},
                    url: "${createLink(controller:'creditInvestigation', action:'updateAttachmentAjax')}",
                    success: function(msg){
                        $('#update-attachment-modal .modal-body').html(msg);
                        $('#update-attachment-modal').on('hidden.bs.modal', function() {                        
                            showAttachments();
                        });                     
                    },
                    error:function(XMLHttpRequest,textStatus,errorThrown){
                        alert(XMLHttpRequest+textStatus+errorThrown);
                    }
                });
            }            

            function showUpdateAttachment(id) { 
                $.ajax({
                    type: 'POST',
                    data: {id:id},
                    url: "${createLink(controller:'creditInvestigation', action:'showUpdateAttachmentAjax')}",
                    success: function(msg){
                        $('#attachmentId').val(id);
                        $('#update-attachment-modal .modal-body').html(msg);                      
                        $('#update-attachment-modal').modal({show:true});                     
                    },
                    error:function(XMLHttpRequest,textStatus,errorThrown){
                        alert(XMLHttpRequest+textStatus+errorThrown);
                    }
                });
            }

            function deleteAttachmentAjax(id) {
                if (confirm('Are you sure?')) {
                    $.ajax({
                        type: 'POST',
                        data: {id:id},
                        url: "${createLink(controller:'creditInvestigation', action:'deleteAttachmentAjax')}",
                        success: function(msg){
                            showAttachments();
                        },
                        error:function(XMLHttpRequest,textStatus,errorThrown){
                            alert(XMLHttpRequest+textStatus+errorThrown);
                        }
                    });
                }
            }

            icbs.Dependencies.Ajax.addLoadEvent(function(){
                updateLoanApplicationAjax({loanApplication2:"${loanApplication?.id}"});
            });
		</g:javascript>		
	</head>
	<body>
        <content tag="breadcrumbs">
            <span class="fa fa-chevron-right"></span><span class="current">Create Credit Investigation</span>
	</content>
        <content tag="main-content">
		<div id="create-creditInvestigation" class="content scaffold-create" role="main">
			<g:if test="${flash.message}">
                <div class="box-body">
                    <div class="alert alert-info alert-dismissable">
                        <i class="fa fa-info"></i>
                        <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                        <b>Message</b> <div class="message" role="status">${flash.message}</div>
                    </div>
                </div>
            </g:if>
			<g:hasErrors bean="${creditInvestigationInstance}">
				<div class="box-body">
	                <div class="alert alert-danger alert-dismissable">
	                    <i class="fa fa-ban"></i>
	                    <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
	                    <b>Alert!</b> 
	                    <ul class="errors" role="alert">
	                        There are errors
	                    </ul>            
	                </div>
	            </div>
            </g:hasErrors>
			<g:uploadForm id="credit-investigation-form" url="[controller:creditInvestigation, action:'save']" onsubmit="callLoadingDialog();" >
				<div class="nav-tab-container" onsubmit="callLoadingDialog();">
                    <ul class="nav nav-tabs">
                        <li class="active"><a href="#tab_1" data-toggle="tab">Details</a></li>
                        <li><a href="#tab_2" data-toggle="tab">Attachments</a></li>
                        <li><a href="#tab_3" data-toggle="tab">Checklist</a></li>
                    </ul>
                </div>		
                <div class="tab-content">
                    <div class="tab-pane active fade in table-responsive" id="tab_1">
                        <g:render template="details/form"/>
                    </div>
                    <div class="tab-pane" id="tab_2">
                        <g:render template="attachments/list"/>
                    </div>
                    <div class="tab-pane" id="tab_3">
                        <g:render template="checklist"/> 
                    </div>
                </div>	
			</g:uploadForm>
		</div>
        </content>
        <content tag="main-actions">
            <ul>
                <li><g:submitButton id="save" name="save" value="Save" onclick="
                        alertify.confirm(AppTitle,'Are you sure you want to continue this transaction?',
                                function(){
                                    checkIfAllowed('LON00401', 'form#credit-investigation-form', 'Save Credit Investigation', null); 
                                },
                                function(){
                                    return;
                                });                          
                    "/></li>
                <!--
            	<script type="text/javascript">
		            $(document).ready(function() {
		               	$( "#save" ).click(function() {
		             		 checkIfAllowed('LON00401', 'form#credit-investigation-form', 'Update branch XXX.', null); // params: policyTemplate.code, form to be saved
		               	});
		            }); 
                 </script>
                 -->
                <li><g:link class="list" action="index" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');">Cancel</g:link></li>
            </ul>
        </content>
	</body>
</html>
