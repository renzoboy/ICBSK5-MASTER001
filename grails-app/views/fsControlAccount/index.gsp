<%@ page import="icbs.gl.FsControlAccount" %>
<!DOCTYPE html>
<html>
    <head>
	<meta name="layout" content="main">
	<title>Financial Statement Control Account List</title>
    </head>
    <body>
	<content tag="main-content">
            <div id="list-assetsHtm" class="content scaffold-list" role="main">
                <g:if test="${flash.message}">
                        <div class="message" role="status">${flash.message}</div>
                </g:if>
                <g:form class="form-inline">
                    <div class="form-group">
                            <g:select name="max" value="${params.max}" from="[5, 10, 15, 20]" class="form-control input-sm pull-left"onchange="this.form.submit()" />
                    </div>
                    <div class="right">
                            <div class="form-group">
                                    <g:textField  type="text" name="query" class="form-control input-sm pull-right" style="width: 350px;" placeholder="Search by Code and Description"/>
                            </div>
                            <g:submitButton name="Search" class="btn btn-sm btn-default"><i class="fa fa-search"></i></g:submitButton>
                    </div>
                </g:form>
                <table class="table table-hover table-condensed table-bordered table-striped">
                    <thead>
                        <tr>
                            <td><lable>ID</label></td>
                            <g:sortableColumn property="account" title="${message(code: 'AssetsHeldToMaturity.glCode.label', default: 'Account Code ')}" />
                            <g:sortableColumn property="description" title="${message(code: 'AssetsHeldToMaturity.htmType.label', default: 'Description')}" />
                            <g:sortableColumn property="status" title="${message(code: 'AssetsHeldToMaturity.description.label', default: 'status')}" />
                            <td><lable>Action</label></td>
                        </tr>
                        </thead>
                    <tbody>
                        <g:each in="${fsControlAccountList}" status="i" var="fsControlAccountInstance">
                            <g:if test="${fsControlAccountInstance?.status.id == 2}">
                                <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
                                    <td>${fsControlAccountInstance?.id}</td>    
                                    <td>${fsControlAccountInstance?.account}</td>                                       
                                    <td>${fsControlAccountInstance?.description}</td>
                                    <td>${fsControlAccountInstance?.status?.description}</td>
                                    <td><g:link class="btn btn-secondary" action="show" id="${fsControlAccountInstance?.id}">View</g:link></td>
                                </tr>
                            </g:if>
                        </g:each>
                    </tbody>
                </table>    
                <div class="pagination">
                        <g:paginate total="${fsControlAccountInstanceCount ?: 0}" params="${params}" />
                </div>
            </div>
        </content>	
		
        <content tag="main-actions">
            <ul>
                <li><g:link controller="home" action="landing">Home</g:link></li>
                <li><g:link action="create">New FS Control Account</g:link></li>               
            </ul>
        </content>
    </body>
</html>
