
<%@ page import="icbs.admin.Currency" %>
<!DOCTYPE html>
<html>
    <head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'currency.label', default: 'Currency')}" />
		<title>Currency Information</title>
    </head>
    <body>
	<content tag="breadcrumbs">
            <span class="fa fa-chevron-right"></span><a href="${createLink(uri:'/currency')}">Currency Maintenance</a>
            <span class="fa fa-chevron-right"></span><span class="current">Currency Information</span>
	</content>
	<content tag="main-content">
            <div id="show-currency" class="content scaffold-show" role="main">
		<g:if test="${flash.message}">
                    <div class="message" role="status">${flash.message}</div>
		</g:if>
                <table class="table table-bordered table-rounded table-striped table-hover">
                    <tbody>
                        <tr>
                            <td style="width:30%"><label>Currency Code</label></td>
                            <td style="width:70%">${currencyInstance?.code}</td> 
                        </tr>    
                        <tr>
                            <td style="width:30%"><label>Currency Name</label></td>
                            <td style="width:70%">${currencyInstance?.name}</td> 
                        </tr> 
                        <tr>
                            <td style="width:30%"><label>Status</label></td>
                            <td style="width:70%">${currencyInstance?.configItemStatus?.description}</td> 
                        </tr>                             
                    </tbody>
                </table>
            </div>
        </content>	

        <content tag="main-actions">
            <ul>
                <li><g:link action="edit" controller="currency" id="${currencyInstance.id}" >Edit</g:link></li>
                <li><g:link action="detailView" id="${currencyInstance.id}" >Currency Detail</g:link></li>
                <li><g:link action="index"  >Cancel</g:link></li>
                
            </ul>
        </content>

    </body>
</html>
