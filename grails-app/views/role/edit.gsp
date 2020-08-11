<%@ page import="icbs.admin.Role" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'role.label', default: 'Role')}" />
		<title><g:message code="default.edit.label" args="[entityName]" /></title>
	</head>
	<body>
		<content tag="breadcrumbs">
		  <span class="fa fa-chevron-right"></span><a href="${createLink(uri: '/role')}">User Role Management</a>
          <span class="fa fa-chevron-right"></span><span class="current">Edit Role</span>
		</content>

            <content tag="main-content">
		<div id="edit-role" class="content scaffold-edit" role="main">
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<g:hasErrors bean="${roleInstance}">
			<ul class="errors" role="alert">
				<g:eachError bean="${roleInstance}" var="error">
				<li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
				</g:eachError>
			</ul>
			</g:hasErrors>

			<div class="nav-tab-container">
              <ul class="nav nav-tabs">
                <li class="active"><a href="#tab_1" data-toggle="tab">Role Details</a></li>
                <li><a href="#tab_2" data-toggle="tab">Permissions</a></li>
              </ul>
            </div>

            <div class="tab-content">
            	<div class="tab-pane active fade in" id="tab_1">
            		<g:form id="edit" url="[resource:roleInstance, action:'update']" method="PUT" >
						<g:hiddenField name="version" value="${roleInstance?.version}" />
						<fieldset class="form">
							<g:render template="form"/>
						</fieldset>
            	</div>
				<div class="tab-pane fade in" id="tab_2">
					<h3>Assign Module Permissions to Role</h3>
						<fieldset>
							<g:render template="module" />
						</fieldset>
					</g:form>
				</div>
			</div>

		</div>
            </content>
            <content tag="main-actions">
                <ul>
                    <li><g:actionSubmit id="editRole" name="edit" action="update" value="${message(code: 'default.button.update.label', default: 'Update')}" onclick="
                alertify.confirm(AppTitle,'Are you sure you want to continue this transaction?',
                                function(){
                                    checkIfAllowed('ADM00603', 'form#edit', 'Override edit new role.', null); 
                                },
                                function(){
                                    return;
                                });                    
            "/></li>
                    <li><g:link action="show" id="${roleInstance.id}">Cancel</g:link></li>
                </ul>
                <!--
                <script type="text/javascript">
                    $(document).ready(function() {
                        $( "#editRole" ).click(function() {
                                 checkIfAllowed('ADM00603', 'form#edit', 'Override edit new role.', null); // params: policyTemplate.code, form to be saved
                        });
                    }); 
                </script>
                -->
            </content>
            
	</body>
</html>
