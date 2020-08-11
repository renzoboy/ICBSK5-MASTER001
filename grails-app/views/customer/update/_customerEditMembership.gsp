<!--
  To change this license header, choose License Headers in Project Properties.
  To change this template file, choose Tools | Templates
  and open the template in the editor.
-->

<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<div id="updateCustomerMembershipDiv">        
            <g:if test="${message}">
                <div id= "updateMembershipMessage" class="box-body">
                    <div class="alert alert-info alert-dismissable">
                        <i class="fa fa-info"></i>
                        <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                        <b>Message</b> <div class="message" role="status">${message}</div>
                    </div>
                </div>
                <script>
                    alertify.alert(AppTitle,"Customer Membership Successfully Updated!", function(){
                    
                    $('#updateCustomerMembershipModal').modal('hide');
                    var x1 = "/icbs/customer/customerMembership/"+${params.id}
                    console.log("x1: "+x1);
                    window.location = x1;
                    });  
                </script>    
            </g:if>
            <g:hasErrors bean="${customerInstance}">
                <div id= "updateMembershipError" class="box-body">
                    <div class="alert alert-danger alert-dismissable">
                        <i class="fa fa-ban"></i>
                        <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                        <b>Alert!</b> 
                        <ul class="errors" role="alert">
                            There are errors. The errors are highlighted in red
                        </ul>            
                    </div>
                </div>
            </g:hasErrors>
            <g:if test="${!saved}">
                <g:form name ="customerUpdateMembershipForm"id="customerUpdateMembershipForm">
                    <g:hiddenField name="id" id="id" value="${customerInstance?.id}"/>
                    <div class="form-group fieldcontain ${hasErrors(bean: customerInstance, field: 'membershipType', 'has-error')} ">
                        <label class="control-label col-sm-4"for="membershipType">
                                <g:message code="membership.membershipType.label" default="Customer Membership" />
                        </label>
                        <div class="col-sm-8">
                            <g:select id="membershipType" name="membershipType" from="${icbs.lov.MembershipType.findAllByStatus('TRUE')}" optionKey="id" optionValue="description" value="${membership?.membershipType?.id}" noSelection="['null': '']" class="form-control"/>
                            <g:hasErrors bean="${customerInstance}" field="membershipType">
                                <div class="controls">
                                    <span class="help-block">
                                        <g:eachError bean="${customerInstance}" field="membershipType">
                                            <g:message error="${it}" /><br/>
                                        </g:eachError>
                                    </span>
                                </div>
                            </g:hasErrors>
                        </div>
                    </div>
                    <div class="form-group fieldcontain ${hasErrors(bean: customerInstance, field: 'membershipDate', 'has-error')} ">
                        <label class="control-label col-sm-4"for="membershipDate">
                                <g:message code="membership.membershipDate.label" default="Date of Membership " />
                        </label>
                        <div class="col-sm-8">
                            <g:customDatePicker id="membershipDate" name="membershipDate" precision="day" class="form-control"  value="${membership?.membershipDate}"  />
                            <g:hasErrors bean="${customerInstance}" field="membershipDate">
                                <div class="controls">
                                    <span class="help-block">
                                        <g:eachError bean="${customerInstance}" field="membershipDate">
                                            <g:message error="${it}" /><br/>
                                        </g:eachError>
                                    </span>
                                </div>
                            </g:hasErrors>
                        </div>
                    </div>
                    <br>
                    <div class="form-group fieldcontain ${hasErrors(bean: customerInstance, field: 'refferedBy', 'has-error')} ">
                        <label class="control-label col-sm-4"for="refferedBy">
                                <g:message code="membership.refferedBy.label" default="Reffered By" />
                        </label>
                        <div class="col-sm-8">
                            <g:field name="refferedBy" id="refferedBy" value="${membership ?. refferedBy}" required="" class="form-control"/>
                            <g:hasErrors bean="${customerInstance}" field="refferedBy">
                                <div class="controls">
                                    <span class="help-block">
                                        <g:eachError bean="${customerInstance}" field="refferedBy">
                                            <g:message error="${it}" /><br/>
                                        </g:eachError>
                                    </span>
                                </div>
                            </g:hasErrors>
                        </div>
                    </div>
                    <br>
                    <div class="form-group fieldcontain ${hasErrors(bean: customerInstance, field: 'relationship', 'has-error')} ">
                        <label class="control-label col-sm-4"for="refferedBy">
                                <g:message code="membership.relationship.label" default="Relationship" />
                        </label>
                        <div class="col-sm-8">
                             <g:select id="relationship" name="relationship" from="${icbs.lov.Lov.findAllByGroupCodeAndStatus('CRT','TRUE')}" optionKey="id" optionValue="itemValue" value="${membership?.relationship?.id}" class="form-control"/>
                            <g:hasErrors bean="${customerInstance}" field="relationship">
                                <div class="controls">
                                    <span class="help-block">
                                        <g:eachError bean="${customerInstance}" field="relationship">
                                            <g:message error="${it}" /><br/>
                                        </g:eachError>
                                    </span>
                                </div>
                            </g:hasErrors>
                        </div>
                    </div>
                </g:form>
            </g:if>
</div>
    
    
    