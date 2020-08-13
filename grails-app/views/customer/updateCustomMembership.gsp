<!--
  To change this license header, choose License Headers in Project Properties.
  To change this template file, choose Tools | Templates
  and open the template in the editor.
-->

<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="icbs.cif.Membership" %>
<%@ page import="icbs.lov.ConfigItemStatus" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="layout" content="main">
        <asset:javascript src="customerHelper.js"/>
        <g:javascript>
                   /* Javascript to update customer membership page */
                    function openCustomerMembership(){
                    console.log("xxxxxx");
                        icbs.Customer.Inquiry.Update.getForm('membership',"${createLink(controller : 'customer', action:'getCustomerUpdateMembershipFormAjax')}",{id:${customerInstance?.id}});
                    }
                    /*Javascript function to submit customer update membership form*/
                    function updateCustomerMembershipAjaxAuthCallback(){
                        console.log("updateCustomerMembershipModal");
                        icbs.Customer.Inquiry.Update('membership',"${createLink(controller : 'customer', action:'customerUpdateMembershipAjax')}",jQuery('#customerUpdateMembershipForm').serialize());
                    }
                    //Override for update customer membership
                    function updateCustomerMembershipAjax(){
                        checkIfAllowed('CIF00110', updateCustomerMembershipAjaxAuthCallback, 'Override Customer Membership Update', null); // params: policyTemplate.code, form to be saved
                    }
         </g:javascript>
        <title>Customer Membership</title>
    </head>
    <body>
        <content tag="breadcrumbs">
            <span class="fa fa-chevron-right"></span><span class="current">Customer Membership</span>
        </content>
        <content tag="main-content">
         <div class="panel-body">
                <div class="panel panel-default">
                    <div class="panel-heading">Customer Information</div>
                        <div class="panel-body">
                            <table class="table table-bordered table-rounded table-striped table-hover">
                                <tbody>
                                    <tr>
                                        <td style="width:30%"><label>Customer Name</label></td>
                                        <td style="width:70%">${customerInstance?.displayName}</td>   
                                    </tr> 
                                    <tr>
                                        <g:set var="primaryAddress" value="${(customerInstance?.addresses?.find{it.isPrimary==true})}"/>
                                        <td style="font-weight:bold" width="30%">Address</td>
                                        <g:if test="${primaryAddress!=null}">
                                        <td width="70%">${primaryAddress?.address1 + ", "+ primaryAddress?.address2 +", " +primaryAddress?.town.description+", "+primaryAddress?.address3}</td>
                                        </g:if>
                                        <g:else>
                                                <td width="70%">N / A</td>
                                        </g:else>
                                    </tr>
                                    <tr>
                                        <td style="width:30%"><label>Date of Birth</label></td>
                                        <td style="width:70%">${customerInstance?.birthDate?.format("MM/dd/yyyy")}</td>    
                                    </tr> 
                               </tbody>
                            </table> 
                            </div>
                  </div>
                           <g:set var="membership" value="${icbs.cif.Membership.findByCustomerAndStatus(customerInstance,ConfigItemStatus.get(2))}"/>
                           <g:if test="${membership!=null}">
                                    <g:render template="update/customerEditMembership"/>
                           </g:if>
                           <g:else>
                            <g:form id="customerUpdateMembershipForm" name="customerUpdateMembershipForm "url="[resource:customerInstance,action:'customerUpdateMembershipAjax']" method="POST"  class="form-horizontal" onsubmit="callLoadingDialog();">
                                    <g:hiddenField name="id" id="id" value="${customerInstance?.id}"/>
                                    <div class="form-group fieldcontain ${hasErrors(bean: customerInstance, field: 'membershipType', 'has-error')} ">
                                        <label class="control-label col-sm-4"for="membershipType">
                                                <g:message code="membership.membershipType.label" default="Customer Membership" />
                                        </label>
                                        <div class="col-sm-8">
                                            <g:select id="membershipType" name="membershipType" from="${icbs.lov.MembershipType.findAllByStatus('TRUE')}" optionKey="id" optionValue="description" value="${membershipInstance?.membershipType?.id}" noSelection="['null': '']" class="form-control"/>
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
                                                <g:message code="membership.membershipDate.label" default="Date of Membership" />
                                        </label>
                                        <div class="col-sm-8">
                                            <g:customDatePicker name="membershipDate" value="${membershipInstance?.membershipDate}" default="none" noSelection="['': '']" class="form-control"  />
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
                                            <g:field name="refferedBy" id="refferedBy" value="${membershipInstance ?. refferedBy}" required="" class="form-control"/>
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
                                             <g:select id="relationship" name="relationship" from="${icbs.lov.Lov.findAllByGroupCodeAndStatus('CRT','TRUE')}" optionKey="id" optionValue="itemValue" value="${membershipInstance?.relationship?.id}" default="none" noSelection="['': '']" class="form-control"/>
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
                        </g:else>
                 </div> 
                
        </content>
        <content tag="main-actions">
            <ul>
                <li>
                <g:submitButton id="update" name="update" value="Update" onclick="
                        alertify.confirm(AppTitle,'Are you sure you want to Update Customer Membership of this Account?',
                                function(){
                                    checkIfAllowed('CIF00110', 'form#customerUpdateMembershipForm', 'Update Customer Membership', null);;
                                },
                                function(){
                                    return;
                                }); 
                        "/></li>
                <li><g:link action="customerInquiry" id="${customerInstance?.id}">Back to Customer Inquiry</g:link></li>
            </ul>
        </content>
    </body>
</html>
