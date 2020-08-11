<!--
  To change this license header, choose License Headers in Project Properties.
  To change this template file, choose Tools | Templates
  and open the template in the editor.
-->
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="icbs.lov.ConfigItemStatus" %>
<%@ page import="icbs.admin.UserMaster" %>
<html>
    <head>
        <title>Customer Relationships</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="layout" content="main">
        <asset:javascript src="customerHelper.js"/>
        <g:javascript>
            function updateCustomerRelatedForm(){
                icbs.Customer.Relation('relationForm',"${createLink(controller : 'customer', action:'customerShowRelatedFormAjax')}",{id:${customerInstance?.id}});
            }
            function addRelationship(params){
                if(params){
                    icbs.Customer.Relation('add',"${createLink(controller : 'customer', action:'customerCreateRelatedAjax')}",{id:${customerInstance?.id},customerRelationshipType:${customerInstance?.type?.id},customer2:params.customer2});
                }else{
                     icbs.Customer.Relation('add',"${createLink(controller : 'customer', action:'customerCreateRelatedAjax')}",{id:${customerInstance?.id},customerRelationshipType:${customerInstance?.type?.id}});
                }
               
            }
            //Add new customer relation
            function saveRelationshipAuthCallback(){
                icbs.Customer.Relation('save',"${createLink(controller : 'customer', action:'customerSaveRelatedAjax')}",jQuery('#createRelatedDiv :input').serialize());
            }
            //Override for adding new customer relation
            function saveRelationship(){
                checkIfAllowed('CIF00100', saveRelationshipAuthCallback); // params: policyTemplate.code, form to be saved
            }

            function editRelationship(id){
                icbs.Customer.Relation('edit',"${createLink(controller : 'customer', action:'customerEditRelatedAjax')}",{id:id,customerRelationshipType:${customerInstance?.type?.id}});
            }
            function deleteRelationship(id){
                icbs.Customer.Relation('delete',"${createLink(controller : 'customer', action:'customerDeleteRelatedAjax')}",{id:id,customerRelationshipType:${customerInstance?.type?.id}});
            }
            
            //Update Customer Relationship details
            function updateRelationshipAuthCallback(){
                icbs.Customer.Relation('update',"${createLink(controller : 'customer', action:'customerSaveRelatedAjax')}",jQuery('#editRelatedDiv :input').serialize());
            }
            //Override for customer relationship update
            function updateRelationship(){
                checkIfAllowed('CIF00100', updateRelationshipAuthCallback); // params: policyTemplate.code, form to be saved
            }
            
            
            function updtRelationship(){
                icbs.Customer.Relation('update',"${createLink(controller : 'customer', action:'customerSaveRelatedAjax')}",jQuery('#deleteRelatedDiv :input').serialize());
            }
            
            icbs.Dependencies.Ajax.addLoadEvent(function(){
                ;$('#editRelationshipModal').on('hidden.bs.modal', function () {
                    updateCustomerRelatedForm();
                })
                $('#addRelationshipModal').on('hidden.bs.modal', function () {
                    updateCustomerRelatedForm();
                });
                $('#deleteRelationshipModal').on('hidden.bs.modal', function () {
                    updateCustomerRelatedForm();
                });
            })
            var modal;
            function initializeAddRelationSearchModal(){
                modal = new icbs.UI.Modal({id:"addRelationSearchModal",url:"${createLink(controller : 'search', action:'search')}",title:"Search Customer",onCloseCallback:addRelationship});
            }
            function saveCustomerToUserRelation(){
                
                alertify.confirm(AppTitle,"Are you sure you want to add this Relationship",
                function(){
                  $('#customerToUserForm').submit();
                },
                function(){
                  alertify.error('Canceled');
                });
            }
            function updateCustomerToUserRelation(x){
                
                //editcustomerIDID/editcusToUserrr/elmntID/edituserididTo/edituserididTo/editstatus/edittype
                $('#editcustomerIDID').val($('#editcustomerIDID'+x).val());
                $('#editcusToUserrr').val($('#editcusToUserrr'+x).val());
                $('#elmntID').val($('#elmntID'+x).val());
                $('#edituserididTo').val($('#edituserididTo'+x).val());
                $('#editstatus').val($('#editstatus'+x).val());
                $('#edittype').val($('#edittype'+x).val());
                alertify.confirm(AppTitle,"Are you sure you want to add this Relationship",
                function(){
                  $('#editcustomerToUserForm').submit();
                },
                function(){
                  alertify.error('Canceled');
                });
            }
        </g:javascript>
    </head>
    <body>
        <content tag="breadcrumbs">
            <span class="fa fa-chevron-right"></span><span class="current">Customer Related</span>
        </content>
        <content tag="main-content">
        <div class="row">
            <g:render template="details/customerDetails"model="[customerInstance:customerInstance,boxName:'CIF INFO']"/>
        </div>
           <div class="row">
                <div id="showRelatedFormDiv">
                    <g:render template='relation/showRelatedForm'/>
                </div>
                <div class="section-container">
                <fieldset><legend class="section-header">Relationship Customer to User</legend>
                <div id="grid">
                        <div class="box-body table-responsive no-padding">
                                        <table class="table table-hover table-condensed table-bordered table-striped">
                                            <tr> 
                                                <td><label>Username</label></td>
                                                <td><label>Name</label></td>
                                                <td><label>Status</label></td>
                                                
                                                <td><label>Customer Relationship</label></td>
                                                <td><label>Action</label></td>

                                            </tr>
                                            <g:each in="${customerToUSeruser}" status="i" var="cusToUser">
                                                
                                            <tr>
                                                <td>${cusToUser?.relateToUser?.username}</td>
                                                <td>${cusToUser?.relateToUser?.name1} ${cusToUser?.relateToUser?.name2} ${cusToUser?.relateToUser?.name3}</td>
                                                <td>${cusToUser?.status?.description}</td>
                                                
                                                <td>${cusToUser?.type?.itemValue}</td>
                                                <td><button class="btn btn-primary" data-toggle="modal" data-target="#showUpdateRelationShiptoUser${i}">Update</button></td>
                                            </tr>
                                            <div id="showUpdateRelationShiptoUser${i}" class="modal fade" role="dialog">
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">Add Relationship to user</h4>
      </div>
      <div class="modal-body">
          
        
        <g:hiddenField name="editrelationToUser${i}" id="editrelationToUser${i}" value="true" />  
        <g:hiddenField name="editcustomerIDID${i}" id="editcustomerIDID${i}" value="${customerInstance?.id}" />
        <g:hiddenField name="editcusToUserrr${i}" id="editcusToUserrr${i}" value="${cusToUser?.id}" />
        <g:hiddenField name="elmntID" id="elmntID" value="${i}" />
        
            <div class="form-group fieldcontain ${hasErrors(bean: customerInstance, field: 'customerCode1', 'has-error')} ">
                <label class="control-label col-sm-4" for="dosriCode">
                        <g:message code="customer.customerCode1.label" default="Relate to User" />
                        <span class="required-indicator">*</span>
                </label>
                <div class="col-sm-8">
                    <g:select id="edituserididTo${i}" name="edituserididTo${i}" from="${icbs.admin.UserMaster.findAllByConfigItemStatus(icbs.lov.ConfigItemStatus.get(2))}" optionKey="id" optionValue ="username" value="${cusToUser?.relateToUser?.id}" class="form-control"   />

                        <div class="controls">
                            <span style="color: red;" class="help-block" id="spancontigent">

                            </span>
                        </div>

                </div>
            </div>
            <div class="form-group fieldcontain ${hasErrors(bean: customerInstance, field: 'customerCode1', 'has-error')} ">
                <label class="control-label col-sm-4" for="dosriCode">
                        <g:message code="customer.customerCode1.label" default="Status" />
                        <span class="required-indicator">*</span>
                </label>
                <div class="col-sm-8">
                    <g:select id="editstatus${i}"  name="editstatus.id${i}" from="${icbs.lov.ConfigItemStatus.findAllByCodeOrCodeLike("010","990")}" optionKey="id" optionValue ="description" value="${relationInstance?.status?.id}" class="form-control"/>

                        <div class="controls">
                            <span style="color: red;" class="help-block" id="spancontigent">

                            </span>
                        </div>

                </div>
            </div>
            <div class="form-group fieldcontain ${hasErrors(bean: customerInstance, field: 'customerCode1', 'has-error')} ">
                <label class="control-label col-sm-4" for="dosriCode">
                        <g:message code="customer.customerCode1.label" default="Relation Type " />
                        <span class="required-indicator">*</span>
                </label>
                <div class="col-sm-8">
                    
                        <g:select id="edittype${i}" name="edittype.id${i}"from="${icbs.lov.Lov.findAllByGroupCodeAndStatusAndItemCodeLike("CRT",true,"1%")}" optionKey="id" optionValue ="itemValue" value="${cusToUser?.type?.id}" class="form-control"/>
                    
                    

                        <div class="controls">
                            <span style="color: red;" class="help-block" id="spancontigent">

                            </span>
                        </div>

                </div>
            </div>
            
      </div>
      
      <div class="modal-footer">
        <button class="btn btn-primary" onclick="updateCustomerToUserRelation(${i});">Save Customer Relation</button>  
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
      </div>
      
    </div>    
                                            </g:each>
<g:form name="editcustomerToUserForm" id="editcustomerToUserForm" url="[action:'updateCustomerToUserRelation',controller:'customer']">  
        <g:hiddenField name="editrelationToUser" id="editrelationToUser" value="true" />  
        <g:hiddenField name="editcustomerIDID" id="editcustomerIDID" value="" />
        <g:hiddenField name="editcusToUserrr" id="editcusToUserrr" value="" />
        <g:hiddenField name="elmntID" id="elmntID" value="" />
        <g:hiddenField name="edituserididTo" id="edituserididTo" value="" />
        <g:hiddenField name="editstatus" id="editstatus" value="" />
        <g:hiddenField name="edittype" id="edittype" value="" />
</g:form>
                                        </table>

                        </div>
                </div>
                </fieldset>
            </div>
            </div>
               
            <div class="modal" id="addRelationshipModal">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                            <h4 class="modal-title">Add Relationship</h4>
                        </div>
                        <div class="modal-body">
                            <g:render template='/customer/details/customerInfo' model="[customerInstance:customerInstance]"/>
                            <div id="createRelatedDiv">
                            
                            </div>
                        </div>
                        <div class="modal-footer">
                            <a href="#" data-dismiss="modal" class="btn">Close</a>
                            <a href="#" class="btn btn-primary"onclick="saveRelationship()">Save changes</a>
                        </div>
                    </div>
                </div>
            </div>
            <div class="modal" id="editRelationshipModal">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                            <h4 class="modal-title">Edit Relationship</h4>
                        </div>
                        <div class="modal-body">
                            <g:render template='/customer/details/customerInfo' model="[customerInstance:customerInstance]"/>
                            <div id="editRelatedDiv">
                            
                            </div>
                        </div>
                        <div class="modal-footer">
                            <a href="#" data-dismiss="modal" class="btn">Close</a>
                            <a href="#" class="btn btn-primary"onclick="updateRelationship()">Save changes</a>
                        </div>
                    </div>
                </div>
            </div>
            <div class="modal" id="deleteRelationshipModal">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                            <h4 class="modal-title">Delete Relationship</h4>
                        </div>
                        <div class="modal-body">
                            <g:render template='/customer/details/customerInfo' model="[customerInstance:customerInstance]"/>
                            <div id="deleteRelatedDiv">
                            
                            </div>
                        </div>
                        <div class="modal-footer">
                            <a href="#" data-dismiss="modal" class="btn">Close</a>
                            <a href="#" class="btn btn-primary"onclick="updtRelationship()">Delete</a>
                        </div>
                    </div>
                </div>
            </div>           

<%-- ============ START OF RELATION TO USER ================--%>
<!-- Modal -->
<div id="showAddRelationShiptoUser" class="modal fade" role="dialog">
  <div class="modal-dialog">

    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">Add Relationship to user</h4>
      </div>
      <div class="modal-body">
        <g:form name="customerToUserForm" id="customerToUserForm" url="[action:'saveCustomerToUserRelation',controller:'customer']">  
        <g:hiddenField name="relationToUser" id="relationToUser" value="true" />  
        <g:hiddenField name="customerIDID" id="customerIDID" value="${customerInstance?.id}" />
            <div class="form-group fieldcontain ${hasErrors(bean: customerInstance, field: 'customerCode1', 'has-error')} ">
                <label class="control-label col-sm-4" for="dosriCode">
                        <g:message code="customer.customerCode1.label" default="Relate to User" />
                        <span class="required-indicator">*</span>
                </label>
                <div class="col-sm-8">
                    <g:select id="userididTo" name="userididTo" from="${icbs.admin.UserMaster.findAllByConfigItemStatus(icbs.lov.ConfigItemStatus.get(2))}" optionKey="id" optionValue ="username" value="" class="form-control"   />

                        <div class="controls">
                            <span style="color: red;" class="help-block" id="spancontigent">

                            </span>
                        </div>

                </div>
            </div>
            <div class="form-group fieldcontain ${hasErrors(bean: customerInstance, field: 'customerCode1', 'has-error')} ">
                <label class="control-label col-sm-4" for="dosriCode">
                        <g:message code="customer.customerCode1.label" default="Status" />
                        <span class="required-indicator">*</span>
                </label>
                <div class="col-sm-8">
                    <g:select id="status"  name="status.id" from="${icbs.lov.ConfigItemStatus.findAllByCodeOrCodeLike("010","990")}" optionKey="id" optionValue ="description" value="${relationInstance?.status?.id}" class="form-control"/>

                        <div class="controls">
                            <span style="color: red;" class="help-block" id="spancontigent">

                            </span>
                        </div>

                </div>
            </div>
            <div class="form-group fieldcontain ${hasErrors(bean: customerInstance, field: 'customerCode1', 'has-error')} ">
                <label class="control-label col-sm-4" for="dosriCode">
                        <g:message code="customer.customerCode1.label" default="Relation Type " />
                        <span class="required-indicator">*</span>
                </label>
                <div class="col-sm-8">
                    
                        <g:select id="type" name="type.id"from="${icbs.lov.Lov.findAllByGroupCodeAndStatusAndItemCodeLike("CRT",true,"1%")}" optionKey="id" optionValue ="itemValue" value="${relationInstance?.type?.id}" class="form-control"/>
                    
                    

                        <div class="controls">
                            <span style="color: red;" class="help-block" id="spancontigent">

                            </span>
                        </div>

                </div>
            </div>
            
      </div>
      </g:form>
      <div class="modal-footer">
        <button class="btn btn-primary" onclick="saveCustomerToUserRelation();">Save Customer Relation</button>  
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
      </div>
      
    </div>

  </div>
</div>
<%-- ====================================================== --%>
        </content>
        <content tag="main-actions">
            <ul>
                <g:if test="${customerInstance}">
                    <li><a href="#" onclick="addRelationship()">Add new Relationship</a></li>
                    <li><button data-toggle="modal" data-target="#showAddRelationShiptoUser">Add new Relationship to User</button></li>
                </g:if>
                <g:else>
                    <li><button disabled>Add New Relationship</button></li>
                </g:else>
                <li><g:link action="customerInquiry" id="${customerInstance?.id}">Back to Customer Inquiry</g:link></li>
            </ul>
        </content>
    </body> 
</html>
        

