
<!DOCTYPE html>

<html>
    <head>
	<meta name="layout" content="main">
	<title>Pending Real and Other Properties Acquired (ROPA)</title>
    </head>
    <body>
        <content tag="breadcrumbs">
                <span class="fa fa-chevron-right"></span><span class="current">ROPA</span>
        </content>
	<content tag="main-content">
            <div id="list-atm_txn" class="content scaffold-list" role="main">
                <g:if test="${flash.message}">
                        <div class="message" role="status">${flash.message}</div>
                </g:if>
                <g:form class="form-inline" url="[controller:'ropa', action:'ropaForTransfer']" method="POST">
                    <div class="form-group">
                            <g:select name="max" value="${params.max}" from="[5, 10, 15, 20]" class="form-control input-sm pull-left"onchange="this.form.submit()" />
                    </div>
                    <div class="right">
                        <div class="form-group">
                            <g:textField  type="text" name="query" class="form-control input-sm pull-right" style="width: 250px;" placeholder="Search Former Title or Kind of Land"/>
                        </div>
                        <g:submitButton name="Search" class="btn btn-sm btn-default"><i class="fa fa-search"></i></g:submitButton>
                    </div>
                </g:form>

			<div class="table-responsive">
                <table class="table table-bordered table-rounded table-striped table-hover">
                    <thead>
                            <tr>
                                <g:sortableColumn property="id" title="${message(code: 'GlContigentAccount.id.label', default: 'ID')}" />
                                <g:sortableColumn property="branch" title="${message(code: 'GlContigentAccount.id.label', default: 'Branch')}" />
                                <g:sortableColumn property="refDate" title="${message(code: 'GlContigentAccount.id.label', default: 'Date')}" />
                                <g:sortableColumn property="formerTitle" title="${message(code: 'GlContigentAccount.id.label', default: 'Former Title')}" />
                                <g:sortableColumn property="kindOfLand" title="${message(code: 'ropa.ropaDate.label', default: 'Kind of Land')}" />
                                <th><label>Status</label></th>
                                <th><label>Action</label></th>
                            </tr>
                    </thead>
                    <tbody>
                        <g:each in="${RopaInstanceList}" status="i" var="RopaInstance">

                                <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
                                        <td>${RopaInstance.id}</td>
                                        <td>${RopaInstance.loan.branch.name}</td>
                                        <td><g:formatDate format="MM/dd/yyyy" date="${RopaInstance.refDate}"/></td>
                                        <td>${RopaInstance.formerTitle}</td>
                                        <td>${RopaInstance.kindOfLand}</td>
                                        <td>${RopaInstance?.status?.description}</td>
                                        <td><g:link class="btn btn-secondary" action="collateralShow" id="${RopaInstance?.id}">View Details</g:link></td>
                                </tr>

                        </g:each>
                        </tbody>
                    </table>
                     </div>
			<div class="pagination">
				<g:paginate total="${BranchInstanceCount ?: 0}" params="${params}" />
			</div>
		</div>
        </content>

        <content tag="main-actions">
            <ul>
                <li><g:link controller="home" action="landing">Home</g:link></li>
                <li><g:link action="create">Prepare Loan for ROPA Transfer</g:link></li>
		<li><g:link action="index">Schedule of ROPA</g:link></li>
                <li><g:link action="indexScr">Schedule of SCR</g:link></li>
		
                <!-- <li><g:link action="printRopaSchedule">Print Schedule of ROPA</g:link></li> -->
            </ul>
        </content>
    </body>
</html>
