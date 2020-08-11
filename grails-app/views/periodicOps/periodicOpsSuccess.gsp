
<!DOCTYPE html>
<html>
    <head>
	<meta name="layout" content="main">
        <g:set var="entityName" value="${message(code: 'userMaster.label', default: 'UserMaster')}" />
        <title>Periodic Operations Success</title>
    </head>
    <body>
        <content tag="breadcrumbs">
            <span class="fa fa-chevron-right"></span><a href="${createLink(uri: '/periodicOps')}">Periodic Operation Index</a>
            <span class="fa fa-chevron-right"></span><span class="current">Periodic Operations Success</span>
        </content>
        <content tag="main-content">
            <div class="alert alert-success alert-dismissable">
                <div class="panel-body">
                    
                    <g:if test="${periodicLogInstance?.periodicOpsProcess?.id == 1}">
                        <%-- START OF DAY --%>
                        <h2><span class="fa fa-check"></span> Start of Day Successfully Executed</h2>
                    </g:if>
                    <g:else>
                        <%-- END OF DAY --%>
                        <h2><span class="fa fa-check"></span> End of Day Successfully Executed</h2>
                    </g:else>
                </div>
            </div>
            <div class="row">
                <div class="section-container">
                    <fieldset>
                        <legend class="section-header">Periodic Operation Details</legend>
                        <table class="table table-bordered table-rounded table-striped table-hover">
                        <tbody>
                           
                            <tr>
                                <td><label>Start Time</label></td>
                                <td>${periodicLogInstance.startTime}</td>    
                            </tr> 
                            <tr>
                                <td><label>End Time</label></td>
                                <td>${periodicLogInstance.endTime}</td>    
                            </tr>
                            <tr>
                                <td><label>Date Processed</label></td>
                                <td><g:formatDate  format="MM/dd/yyyy " date="${periodicLogInstance.runDate}" /></td>    
                            </tr>
                            <tr>
                                <td><label>Executed By</label></td>
                                <td>${periodicLogInstance.user?.name1} ${periodicLogInstance.user?.name2} ${periodicLogInstance.user?.name3}</td>    
                            </tr>
                        </tbody>
                        </table>
                    </fieldset>
                </div>
            </div>        
        </content>
        <content tag="main-actions">
            <ul>
                <li><a class="home" href="${createLink(uri: '/')}">Back to Home</a></li>
                <li><g:link class="index" action="index">Periodic Operations Index</g:link></li>
            </ul>
        </content>
    </body>
</html>

