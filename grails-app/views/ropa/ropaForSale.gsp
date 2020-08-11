
<!DOCTYPE html>

<html>
    <head>
	<meta name="layout" content="main">
	<title>Real and Other Properties Acquired (ROPA)For Sale ${ropaInstanceList}</title>
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
            </div>
            <div class="table-responsive">
                <table class="table table-bordered table-rounded table-striped table-hover" id="tblRopaColl"> 
                    <thead>
                        <tr>
                            <td><label>Collateral ID</label></td>
                            <td><label>Reference Date</label></td>
                            <td><label>Appraisal Value</label></td>
                            <td><label>Description</label></td>
                            <td><label>Collateral Type</label></td>
                            <td><label>Status</label></td>
                             <td><label>Action</label></td>       
                        </tr>
                    </thead>
                    <tbody>
                        <g:each in="${ropaList}" status="i" var="ropaCollateralDetailsInstance">
                            <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
                                <td>${ropaCollateralDetailsInstance?.collateral.id}</td>
                                <g:hiddenField id="reymartID" name="reymartID" value="${ropaCollateralDetailsInstance?.collateral.id}" />
                                <td><g:formatDate format="MM/dd/yyyy" date="${ropaCollateralDetailsInstance?.refDate}"/></td>
                                <td><g:formatNumber format="###,###,##0.00" number="${ropaCollateralDetailsInstance?.collateral?.appraisedValue}"/></td>
                                <td>${ropaCollateralDetailsInstance?.collateral?.description}</td>
                                <td>${ropaCollateralDetailsInstance?.collateral?.collateralType?.description}</td>
                                <td>${ropaCollateralDetailsInstance?.status?.description}</td>
                                <td><g:link class="btn btn-secondary" id="${ropaCollateralDetailsInstance?.id}" params="['ropaId': ropapapapaInstance?.id]" action="collateralShow" >View Details</g:link></td>                                                                     
                            </tr>
            
                        </g:each>
                     </tbody>
                </table>
            </div>
        </content>	
		
        <content tag="main-actions">
            <ul>
                <li><g:link controller="home" action="landing">Home</g:link></li>
                <li><g:link action="index">ROPA Listing</g:link></li>
                <!-- <li><g:link action="printRopaSchedule">Print Schedule of ROPA</g:link></li> -->
            </ul>
        </content>
    </body>
</html>
