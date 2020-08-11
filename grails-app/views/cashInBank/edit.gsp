<%@ page import="icbs.gl.CashInBank" %>
<!DOCTYPE html>
<html>
    <head>
	<meta name="layout" content="main">
	<g:set var="entityName" value="${message(code: 'cashInBank.label', default: 'CashInBank')}" />
	<title>Edit Cash in Bank Subsidiary Ledger</title>
    </head>
    <body>
        <content tag="breadcrumbs">
                <span class="fa fa-chevron-right"></span><a href="${createLink(uri: '/cashInBank')}">Cash in Bank/Due From Bank Subsidiary Ledger</a>
                <span class="fa fa-chevron-right"></span><span class="current">Edit Cash in Bank/Due From Bank Subsidiary Ledger</span>
        </content>
        <content tag="main-content">
            <div id="edit-cashInBank" class="content scaffold-edit" role="main">
		<g:if test="${flash.message}">
                    <div class="message" role="status">${flash.message}</div>
                </g:if>
		<g:hasErrors bean="${clearingBankInstance}">
                    <ul class="errors" role="alert">
			<g:eachError bean="${clearingBankInstance}" var="error">
                            <li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
			</g:eachError>
                    </ul>
		</g:hasErrors>
            	<g:form id="edit" url="[action:'update',controller:'cashInBank',resource:cashInBankInstance]" method="POST" >
                    <fieldset class="form">
                        <g:hiddenField name="ccashInnBank" id="ccashInnBank" value="${params.id}" />
			<g:render template="form"/>
                    </fieldset>
		</g:form>
            </div>
        </content>
    
        <content tag="main-actions">
            <ul>
                <li><g:actionSubmit class="save" id="editClearingBank" name="edit" action="update" value="${message(code: 'default.button.update.label', default: 'Update')}" onclick="
                        alertify.confirm(AppTitle,'Are you sure you want to continue this transaction?',
                                function(){
                                     checkIfAllowed('CFG00303', 'form#edit', 'Override edit cash in bank.', null); 
                                },
                                function(){
                                    return;
                                });                      
                    "/></li>
                <li><g:link action="show" id="${cashInBankInstance.id}">Cancel</g:link></li>
            </ul>
        </content>           
    </body>
</html>
