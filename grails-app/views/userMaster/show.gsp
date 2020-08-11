<%@ page import="icbs.admin.UserMaster" %>
<%@ page import="icbs.audit.AuditLog" %>
<!DOCTYPE html>
<html>
    <head>
	<meta name="layout" content="main">
	<g:set var="entityName" value="${message(code: 'userMaster.label', default: 'UserMaster')}" />
	<title>User Information</title>
    </head>
    <body>
	<content tag="breadcrumbs">
            <span class="fa fa-chevron-right"></span><a href="${createLink(uri: '/userMaster')}">User Management</a>
            <span class="fa fa-chevron-right"></span><span class="current">User Information</span>
	</content>
        <content tag="main-content">   
            <div id="show-userMaster" class="content scaffold-show" role="main">
		<g:if test="${flash.message}">
                    <script>
                        $(function(){
                            var x = '${flash.message}';
                                notify.message(x);
                        });
                    </script>
                        
                </g:if>

		<div class="nav-tab-container">
                    <ul class="nav nav-tabs">
                        <li class="active"><a href="#tab_1" data-toggle="tab">User Details</a></li>
                        <li><a href="#tab_2" data-toggle="tab">Roles</a></li>
                        <%--<li><a href="#tab_3" data-toggle="tab">Audit Log</a></li>--%>
                    </ul>
                </div>
                <div class="tab-content">
                    <div class="tab-pane active fade in" id="tab_1">
                        <table class="table table-bordered table-rounded table-striped table-hover">
                            <tbody>
                                <g:if test="${userMasterInstance?.username}">
                                    <tr>
                                        <td style="width:30%"><label><span id="username-label" class="property-label"><g:message code="userMaster.username.label" default="Username" /></span></label></td>
                                        <td style="width:70%"><span class="property-value" aria-labelledby="username-label"><g:fieldValue bean="${userMasterInstance}" field="username"/></span></td>
                                    </tr>
				</g:if>
					
				<g:if test="${userMasterInstance?.name1}">
                                    <tr>
                                        <td style="width:30%"><label><span id="name1-label" class="property-label"><g:message code="userMaster.name1.label" default="First Name" /></span></label></td>
                                        <td style="width:70%"><span class="property-value" aria-labelledby="name1-label"><g:fieldValue bean="${userMasterInstance}" field="name1"/></span></td>
                                    </tr>
				</g:if>
					
				<g:if test="${userMasterInstance?.name2}">
                                    <tr>
                                        <td style="width:30%"><label><span id="name2-label" class="property-label"><g:message code="userMaster.name2.label" default="Middle Name" /></span></label></td>
                                        <td style="width:70%"><span class="property-value" aria-labelledby="name2-label"><g:fieldValue bean="${userMasterInstance}" field="name2"/></span></td>
                                    </tr>
                                </g:if>
					
				<g:if test="${userMasterInstance?.name3}">
                                    <tr>
                                        <td style="width:30%"><label><span id="name3-label" class="property-label"><g:message code="userMaster.name3.label" default="Last Name" /></span></label></td>
                                        <td style="width:70%"><span class="property-value" aria-labelledby="name3-label"><g:fieldValue bean="${userMasterInstance}" field="name3"/></span></td>
                                    </tr>
				</g:if>
					
				<g:if test="${userMasterInstance?.name4}">
                                    <tr>
                                        <td style="width:30%"><label><span id="name4-label" class="property-label"><g:message code="userMaster.name4.label" default="Name4" /></span></label></td>
                                        <td style="width:70%"><span class="property-value" aria-labelledby="name4-label"><g:fieldValue bean="${userMasterInstance}" field="name4"/></span></td>
                                    </tr>
				</g:if>
					
				<g:if test="${userMasterInstance?.birthdate}">
                                    <tr>
                                        <td style="width:30%"><label><span id="birthdate-label" class="property-label"><g:message code="userMaster.birthdate.label" default="Birthdate" /></span></label></td>
                                        <td style="width:70%"><span class="property-value" aria-labelledby="birthdate-label"><g:formatDate format="MM/dd/yyyy" date="${userMasterInstance?.birthdate}"/></span></td>
                                    </tr>
				</g:if>
					
				<g:if test="${userMasterInstance?.gender}">
                                    <tr>
                                        <td style="width:30%"><label><span id="gender-label" class="property-label"><g:message code="userMaster.gender.label" default="Gender" /></span></label></td>
                                        <td style="width:70%"><span class="property-value" aria-labelledby="gender-label">${userMasterInstance?.gender?.description}</span></td>
                                    </tr>
				</g:if>
					
				<g:if test="${userMasterInstance?.address1}">
                                    <tr>
                                        <td style="width:30%"><label><span id="address1-label" class="property-label"><g:message code="userMaster.address1.label" default="Address1" /></span></label></td>
                                        <td style="width:70%"><span class="property-value" aria-labelledby="address1-label"><g:fieldValue bean="${userMasterInstance}" field="address1"/></span></td>
                                    </tr>
				</g:if>
					
				<g:if test="${userMasterInstance?.address2}">
                                    <tr>
                                        <td style="width:30%"><label><span id="address2-label" class="property-label"><g:message code="userMaster.address2.label" default="Address2" /></span></label></td>
                                        <td style="width:70%"><span class="property-value" aria-labelledby="address2-label"><g:fieldValue bean="${userMasterInstance}" field="address2"/></span></td>
                                    </tr>
				</g:if>
					
				<g:if test="${userMasterInstance?.province}">
                                    <tr>
                                        <td style="width:30%"><label><span id="province-label" class="property-label"><g:message code="userMaster.province.label" default="Province" /></span></label></td>
                                        <td style="width:70%"><span class="property-value" aria-labelledby="province-label">${userMasterInstance?.province?.itemValue}</span></td>
                                    </tr>
				</g:if>
					
				<g:if test="${userMasterInstance?.zipCode}">
                                    <tr>
                                        <td style="width:30%"><label><span id="zipCode-label" class="property-label"><g:message code="userMaster.zipCode.label" default="Zip Code" /></span></label></td>
                                        <td style="width:70%"><span class="property-value" aria-labelledby="zipCode-label"><g:fieldValue bean="${userMasterInstance}" field="zipCode"/></span></td>
                                    </tr>
				</g:if>
					
				<g:if test="${userMasterInstance?.email}">
                                    <tr>
                                        <td style="width:30%"><label><span id="email-label" class="property-label"><g:message code="userMaster.email.label" default="Email" /></span></label></td>
                                        <td style="width:70%"><span class="property-value" aria-labelledby="email-label"><g:fieldValue bean="${userMasterInstance}" field="email"/></span></td>
                                    </tr>
				</g:if>
					
				<g:if test="${userMasterInstance?.contact}">
                                    <tr>
                                        <td style="width:30%"><label><span id="contact-label" class="property-label"><g:message code="userMaster.contact.label" default="Contact" /></span></label></td>
                                        <td style="width:70%"><span class="property-value" aria-labelledby="contact-label"><g:fieldValue bean="${userMasterInstance}" field="contact"/></span></td>
                                    </tr>
				</g:if>
					
				<g:if test="${userMasterInstance?.dateHired}">
                                    <tr>
                                        <td style="width:30%"><label><span id="dateHired-label" class="property-label"><g:message code="userMaster.dateHired.label" default="Date Hired" /></span></label></td>
                                        <td style="width:70%"><span class="property-value" aria-labelledby="dateHired-label"><g:formatDate format="MM/dd/yyyy" date="${userMasterInstance?.dateHired}"/></span></td>
                                    </tr>
				</g:if>
					
				<g:if test="${userMasterInstance?.designation}">
                                    <tr>
                                        <td style="width:30%"><label><span id="designation-label" class="property-label"><g:message code="userMaster.designation.label" default="Designation" /></span></label></td>
                                        <td style="width:70%"><span class="property-value" aria-labelledby="designation-label">${userMasterInstance?.designation?.description}</span></td>
                                    </tr>
				</g:if>
					
				<g:if test="${userMasterInstance?.branch}">
                                    <tr>
                                        <td style="width:30%"><label><span id="branch-label" class="property-label"><g:message code="userMaster.branch.label" default="Branch" /></span></label></td>
                                        <td style="width:70%"><span class="property-value" aria-labelledby="branch-label"><g:link controller="branch" action="show" id="${userMasterInstance?.branch?.id}">${userMasterInstance?.branch?.name}</g:link></span></td>
                                    </tr>
				</g:if>

				<g:if test="${userMasterInstance?.cash}">
                                    <tr>
                                        <td style="width:30%"><label><span id="cash-label" class="property-label"><g:message code="userMaster.cash.label" default="Cash" /></span></label></td>
                                        <td style="width:70%"><span class="property-value" aria-labelledby="cash-label"><g:link controller="glAccount" action="show" id="${userMasterInstance?.cash?.id}">${userMasterInstance?.cash?.name}</g:link></span></td>
                                    </tr>
				</g:if>

				<g:if test="${userMasterInstance?.coci}">
                                    <tr>
                                        <td style="width:30%"><label><span id="coci-label" class="property-label"><g:message code="userMaster.coci.label" default="COCI" /></span></label></td>
                                        <td style="width:70%"><span class="property-value" aria-labelledby="branch-label"><g:link controller="glAccount" action="show" id="${userMasterInstance?.coci?.id}">${userMasterInstance?.coci?.name}</g:link></span></td>
                                    </tr>
				</g:if>
					
				<g:if test="${userMasterInstance?.employmentType}">
                                    <tr>
                                        <td style="width:30%"><label><span id="employmentType-label" class="property-label"><g:message code="userMaster.employmentType.label" default="Employment Type" /></span></label></td>
                                        <td style="width:70%"><span class="property-value" aria-labelledby="employmentType-label">${userMasterInstance?.employmentType?.itemValue}</span></td>
                                    </tr>
				</g:if>
					
				<g:if test="${userMasterInstance?.expiryDate}">
                                    <tr>
                                        <td style="width:30%"><label><span id="expiryDate-label" class="property-label"><g:message code="userMaster.expiryDate.label" default="User Access Expiry Date" /></span></label></td>
                                        <td style="width:70%"><span class="property-value" aria-labelledby="expiryDate-label"><g:formatDate format="MM/dd/yyyy" date="${userMasterInstance?.expiryDate}"/></span></td>
                                    </tr>
				</g:if>
                                
				<g:if test="${userMasterInstance?.expiryPwdDate}">
                                    <tr>
                                        <td style="width:30%"><label><span id="expiryDate-label" class="property-label"><g:message code="userMaster.expiryPwdDate.label" default="Password Expiry Date" /></span></label></td>
                                        <td style="width:70%"><span class="property-value" aria-labelledby="expiryDate-label"><g:formatDate format="MM/dd/yyyy" date="${userMasterInstance?.expiryPwdDate}"/></span></td>
                                    </tr>
				</g:if>
                                
				<g:if test="${userMasterInstance?.isLocked}">
                                    <tr>
                                        <td style="width:30%"><label><span id="isLocked-label" class="property-label"><g:message code="userMaster.isLocked.label" default="User Locked" /></span></label></td>
                                        <td style="width:70%"><span class="property-value" aria-labelledby="isLocked-label">Yes</span></td>
                                    </tr>
				</g:if>

				<g:if test="${userMasterInstance?.hasExceededMaxLogin}">
                                    <tr>
                                        <td style="width:30%"><label><span id="hasExceededMaxLogin-label" class="property-label"><g:message code="userMaster.hasExceededMaxLogin.label" default="User Has Exceeded Max Login Attempt" /></span></label></td>
                                        <td style="width:70%"><span class="property-value" aria-labelledby="hasExceededMaxLogin-label"><g:formatBoolean boolean="${userMasterInstance?.hasExceededMaxLogin}" true="Yes" false="No" /></span></td>
                                    </tr>
				</g:if>
					
                                <g:if test="${userMasterInstance?.configItemStatus}">
                                    <tr>
                                        <td style="width:30%"><label><span id="configItemStatus-label" class="property-label"><g:message code="userMaster.configItemStatus.label" default="Config Item Status" /></span></label></td>
                                        <td style="width:70%"><span class="property-value" aria-labelledby="configItemStatus-label">${userMasterInstance?.configItemStatus?.description}</span></td>
                                    </tr>
				</g:if>
                            </tbody>
                        </table>
                    </div>
                    <div class="tab-pane fade in" id="tab_2">
                        <table class="table table-bordered table-rounded table-striped table-hover">
                            <tbody>
                                <g:each in="${userMasterInstance.roles}" var="role" >
                                    <tr>
                                        <td>${role.name}</td>
                                    </tr>
                                </g:each>
                            </tbody>
                        </table>
                    </div>
                    <%--<div class="tab-pane fade in" id="tab_3">
                        <div class="table-responsive">
                            <table class="table table-bordered table-rounded table-striped table-hover" id="tbluserLogs">
                               <thead>
                                       <tr>
                                           <td><label>Log ID</label></td>
                                           <td><label>Date/Time</label></td>
                                           <td><label>Action Performed</label></td>
                                       </tr>
                                </thead>
                               <tbody>
                                   <g:each in="${AuditLog.findAllByUserMaster(userMasterInstance)}" var="audit" >
                                           <tr>
                                               <td>${audit.id}</td>
                                               <td>${audit.date}</td>
                                               <td>${audit.description}</td>
                                           </tr>
                                       </g:each>
                               </tbody>
                           </table> 
                        </div> --%>
                        <script>
                                $(document).ready(function() {
                                $('#tbluserLogs').DataTable({
                                  dom: 'Bfrtlip',
                                 //dom : '<"wrapper"flipt>',
                                  
                                    buttons: [
                                        {
                                            extend: 'print',
                                            customize: function ( win ) {
                                                $(win.document.body)
                                                    .css( 'font-size', '10pt' )
                                                    .prepend(
                                                        '<img src="icbs/assets/logo.png" style="position:absolute; top:0; left:0;" />'
                                                    );

                                                $(win.document.body).find( 'table' )
                                                    .addClass( 'compact' )
                                                    .css( 'font-size', 'inherit' );
                                            }
                                        }
                                    ]   
                                });
                                
                               $('.buttons-print').hide();
                            } );
                        </script>
                        
                    </div>                    
                </div>
                <g:form id="deactivateUser" url="[resource:userMasterInstance, action:'delete']" method="DELETE"> </g:form>
                <g:form id="lockUserForm" url="[resource:userMasterInstance, action:'lock']" method="DELETE"> </g:form>
                <g:form id="unlockUserForm" url="[resource:userMasterInstance, action:'unlock']" method="DELETE"> </g:form>

            </div>
        </content>

        <content tag="main-actions">
            <ul>
                <li><g:link class="create" action="create"><g:message code="default.new.user" args="[entityName]" default="New User" /></g:link></li>
                <li><g:link action="edit" resource="${userMasterInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link></li>
                <li><g:link action="resetPassword" resource="${userMasterInstance}">Reset Password</g:link></li>
                <li><g:link action="forceLogout" resource="${userMasterInstance}">Force Logout</g:link></li>
                <li><button onclick="sendRefreshBalance();">Refresh Balancing Record</button></li>
                <g:form name="refreshUserBalance" id="refreshUserBalance"  onsubmit="callLoadingDialog();" url="[action:'refreshBalance',controller:'userMaster']" method="POST">
                    <g:hiddenField name="id" id="id" value="${params?.id}" /> 
                </g:form>    
                <li><g:actionSubmit id="deleteUser" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="
                            alertify.confirm(AppTitle,'Are you sure you want to delete?',
                                function(){
                                    checkIfAllowed('ADM00504', 'form#deactivateUser', 'Delete User.', null);
                                },
                                function(){
                                    return;
                                });                          
                    " /></li>
                <g:if test="${!userMasterInstance.hasExceededMaxLogin && !userMasterInstance.isLocked}">
                    <li><g:actionSubmit id="lockUser" action="lock" value="${message(code: 'default.button.unlock.label', default: 'Lock User')}" onclick="
                            alertify.confirm(AppTitle,'Are you sure you want to lock user?',
                                function(){
                                    checkIfAllowed('ADM00506', 'form#lockUserForm', 'Unlock User.', null);
                                },
                                function(){
                                    return;
                                });                              
                        " /></li>
                </g:if>
                <g:else>
                    <li><g:actionSubmit id="unlockUser" action="unlock" value="${message(code: 'default.button.unlock.label', default: 'Unlock User')}" onclick="
                            alertify.confirm(AppTitle,'Are you sure you want to unlock user?',
                                function(){
                                    checkIfAllowed('ADM00506', 'form#unlockUserForm', 'Unlock User.', null);
                                },
                                function(){
                                    return;
                                });                               
                        " /></li>
                </g:else>
                <script>
                    function sendRefreshBalance(){
                        alertify.confirm(AppTitle,'Are you sure you want to refresh user Teller Balance?',
                        function(){
                            $('#refreshUserBalance').submit();
                        },
                        function(){
                            return;
                        });
                    }
                </script>    
            </ul>
            
            <!--
            <script type="text/javascript">
                    $(document).ready(function() {
                           $( "#deleteUser" ).click(function() {
                              checkIfAllowed('ADM00504', 'form#deactivateUser', 'Delete User.', null); // params: policyTemplate.code, form to be saved
                           });
                    });
                    
                    $(document).ready(function() {
                           $( "#lockUser" ).click(function() {
                              checkIfAllowed('ADM00506', 'form#lockUserForm', 'Unlock User.', null); // params: policyTemplate.code, form to be saved
                           });
                    });
                    
                     $(document).ready(function() {
                           $( "#unlockUser" ).click(function() {
                              checkIfAllowed('ADM00506', 'form#unlockUserForm', 'Unlock User.', null); // params: policyTemplate.code, form to be saved
                           });
                    });
                    
                </script>
                -->
        </content>
    </body>
</html>