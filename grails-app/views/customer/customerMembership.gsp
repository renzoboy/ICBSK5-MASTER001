<!--
  To change this license header, choose License Headers in Project Properties.
  To change this template file, choose Tools | Templates
  and open the template in the editor.
-->
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="icbs.gl.AccountsReceivable" %>
<%@ page import="icbs.gl.AccountsPayable" %>
<%@ page import="icbs.loans.LoanApplicationComaker" %>
<%@ page import="icbs.loans.Loan" %>
<html>
    <head>
        <title>Customer Membership</title>
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
    </head>
    <body>
        <content tag="breadcrumbs">
            <span class="fa fa-chevron-right"></span><span class="current">Customer Membership</span>
        </content>
        <content tag="main-content">
         <div class="modal-body">
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
                    <div class="row col-md-12">
                        <div class="table-responsive">
                            <legend>Customer Membership History</legend>
                            <table class="table table-hover table-condensed table-bordered table-striped">
                                <thead style="background-color: #cce6ff;">
                                    <tr>
                                        <td><label>Membership Type</label></td>
                                        <td><label>Date of Membership</label></td>
                                        <td><label>Reffered By</label></td>
                                        <td><label>Relationship</label></td>
                                        <td><label>Date Created</label></td>
                                        <td><label>Created By</label></td>
                                        <td><label>Status</label></td>
                                    </tr>
                                    </thead>
                                <tbody>
														  
                                    <g:each var="membershipHist" in="${icbs.cif.MembershipHistory.findAllByMember(customerInstance?.membership,[sort: "id", order: "asc"])}" status="i">
                                            <tr>			
                                                <td>${membershipHist?.membershipType?.description}</td>
                                                <td><g:formatDate format="MM/dd/yyyy" date="${membershipHist?.membershipDate}" /></td>
                                                <td>${membershipHist?.refferedBy}</td>
                                                <td>${membershipHist?.relationship?.itemValue}</td>
                                                <td><g:formatDate format="MM/dd/yyyy" date="${membershipHist?.dateCreated}" /></td>
                                                <td>${membershipHist?.createdBy?.username}</td>
                                                <td>${membershipHist?.status?.description}</td>
                                            </tr>     
                                    </g:each> 
                                </tbody>    
                             </table>
                        </div>
                    </div>
                </div> 
                  <!-- The Modal for Customer Membership-->
                    <div class="modal" id="updateCustomerMembershipModal">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                                    <h4 class="modal-title">Update Customer Membership</h4>
                                </div>
                                <div class="modal-body">
                                    <g:render template='/customer/details/customerInfo' model="[customerInstance:customerInstance]"/>
                                    <div id="updateMembershipDiv">

                                    </div>
                                </div>
                                <div class="modal-footer">
                                    <a href="#" data-dismiss="modal" class="btn">Close</a>
                                    <a href="#" class="btn btn-primary" onclick="updateCustomerMembershipAjax()">Save changes</a>
                                </div>
                            </div>
                        </div>
                    </div>
        </content>
        <content tag="main-actions">
            <ul>
                <li><g:link action="updateCustomMembership" id="${customerInstance?.id}">Update Customer Membership</g:link></li>
                <li><g:link action="customerInquiry" id="${customerInstance?.id}">Back to Customer Inquiry</g:link></li>
            </ul>
        </content>
    </body> 
</html>
