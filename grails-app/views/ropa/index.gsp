
<!DOCTYPE html>

<html>
    <head>
	<meta name="layout" content="main">
	<title>Real and Other Properties Acquired (ROPA) ${ropaInstanceList}</title>
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
                

			<g:form class="form-inline">
                            <div class="form-group">
                                    <g:select name="max" value="${params.max}" from="[5, 10, 15, 20]" class="form-control input-sm pull-left"onchange="this.form.submit()" />
                            </div>
                            <div class="right">
                                    <div class="form-group">
                                            <g:textField  type="text" name="query" class="form-control input-sm pull-right" style="width: 250px;" placeholder="Search Description or Location"/>
                                    </div>
                                    <g:submitButton name="Search" class="btn btn-sm btn-default"><i class="fa fa-search"></i></g:submitButton>
                            </div>
			</g:form>

			<div class="table-responsive">
                <table class="table table-bordered table-rounded table-striped table-hover">
                    <thead>
                        <tr>
                            <td><label>ROPA ID</label></td>
                            <td><label>Reference Date</label></td>         
                            <td><label>Description</label></td>
                            <td><label>Location</label></td>
                            <td><label>Status</label></td>
                            <td><label>Action</label></td>       
                        </tr>
                    </thead>
                    <tbody>     
                        <g:each in="${RopaInstanceList}" status="i" var="RopaInstance">

                            <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
                                <td>${RopaInstance.id}</td>
                                <g:hiddenField id="reymartID" name="reymartID" value="${RopaInstance?.collateral.id}" />
																						 

                                <td><g:formatDate format="MM/dd/yyyy" date="${RopaInstance?.refDate}"/></td>                            
                                <td>${RopaInstance?.kindOfLand}</td>
                                <td>${RopaInstance?.location}</td>
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
																											  
               <li><g:link action="ropaForTransfer">List of Pending ROPA</g:link></li>
               <!--<li><g:link action="ropaForTransfer">List of ROPA Sold</g:link></li> -->
               <!-- <li><g:link action="printRopaSchedule">Print Schedule of ROPA</g:link></li> -->
           </ul>
       </content>
    </body>
</html>
