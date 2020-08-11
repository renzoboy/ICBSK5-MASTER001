<%@ page import="icbs.gl.GlAccount" %>
<!DOCTYPE html>
<html>
    <head>
	<meta name="layout" content="main">
	<title>Assets Held to Maturity Subsidiary Ledger</title>
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
                                    <g:textField  type="text" name="query" class="form-control input-sm pull-right" style="width: 350px;" placeholder="Search by Assset Type , Description and GL CODE"/>
                            </div>
                            <g:submitButton name="Search" class="btn btn-sm btn-default"><i class="fa fa-search"></i></g:submitButton>
                    </div>
                </g:form>
                <table class="table table-hover table-condensed table-bordered table-striped">
                    <thead>
                        <tr>
                            <g:sortableColumn property="glCode" title="${message(code: 'AssetsHeldToMaturity.glCode.label', default: 'Gl Code')}" />
                            <%--<g:sortableColumn property="glCode" title="${message(code: 'GlAccount.glCode.label', default: 'Gl Code')}" />--%>
                            
                            <g:sortableColumn property="htmType" title="${message(code: 'AssetsHeldToMaturity.htmType.label', default: 'Asset Type')}" />
                            <g:sortableColumn property="htmDescription" title="${message(code: 'AssetsHeldToMaturity.description.label', default: 'Description')}" />
                            <g:sortableColumn property="reference" title="${message(code: 'AssetsHeldToMaturity.reference.label', default: 'Reference')}" />
                            <g:sortableColumn property="amount" title="${message(code: 'AssetsHeldToMaturity.amount.label', default: 'Amount')}" />
                            <td><lable>Action</label></td>
                        </tr>
                        </thead>
                    <tbody>
                        <g:each in="${assetsHtmList}" status="i" var="assetsHtmInstance">
                            <g:if test="${assetsHtmInstance?.status.id == 2}">
                                <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
                                    <td>${assetsHtmInstance?.glCode}</td>    
                                    <td>${assetsHtmInstance?.htmType}</td>                                       
                                    <td>${assetsHtmInstance?.htmDescription}</td>
                                    <td>${assetsHtmInstance?.reference}</td>
                                    <td align="right"><g:formatNumber format="###,###,##0.00" number="${assetsHtmInstance?.amount}"/></td>
                                    <td><g:link class="btn btn-secondary" action="show" id="${assetsHtmInstance?.id}">View</g:link></td>
                                </tr>
                            </g:if>
                        </g:each>
                    </tbody>
                </table>    
                <div class="pagination">
                        <g:paginate total="${assetsHtmInstanceCount ?: 0}" params="${params}" />
                </div>
            </div>
        </content>	
		
        <content tag="main-actions">
            <ul>
                <li><g:link controller="home" action="landing">Home</g:link></li>
                <li><g:link action="create">New HTM Subsidiary Ledger</g:link></li>               
            </ul>
        </content>
    </body>
</html>
