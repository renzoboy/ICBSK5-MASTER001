<!DOCTYPE html>
<%@ page import="icbs.lov.ConfigItemStatus" %>
<html>
    <head>
	<meta name="layout" content="main">
	<title>Edit Collateral Information</title>
    </head>
    <body>
        <content tag="breadcrumbs">
                <span class="fa fa-chevron-right"></span><span class="current">Create New ROPA</span>
        </content>
	<content tag="main-content">
            <div id="create-ropa" class="content scaffold-create" role="main">
		<g:if test="${flash.message}">
                    <div class="message" role="status">${flash.message}</div>
		</g:if>
		<g:hasErrors bean="${ropaInstance}">
                    <ul class="errors" role="alert">
			<g:eachError bean="${ropaInstance}" var="error">
			<li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error.field} - ${error}"/></li>
			</g:eachError>
                    </ul>
		</g:hasErrors>
                
                <g:form id="updateCollateral" url="[controller:'ropa', action:'updateCollateral']" onsubmit="callLoadingDialog();" >
                    <fieldset class="form">
			<g:render template="collateralInformation/editForm"/>
                        <g:hiddenField name="collateralId" id="collateralId" value="${params?.id}"/>
                    </fieldset>
		</g:form>
                
		
            </div>
	</content>
	<content tag="main-actions">
            <ul>
                <li><g:submitButton id="updateCollateral" name="update" value="${message(code: 'default.button.update.label', default: 'Update')}" onclick="
                        alertify.confirm(AppTitle,'Are you sure you want to continue create ROPA?',
                            function(){
                                    checkIfAllowed('ADM00102', 'form#updateCollateral', 'Create New ROPA', null); 
                                },
                                function(){
                                    return;
                            }); 
                "/></li>
		<li><g:link action="index"><g:message code="default.cancel.label" args="[entityName]" default="Cancel" /></g:link></li>
            </ul>
	</content>
    </body>
</html>
