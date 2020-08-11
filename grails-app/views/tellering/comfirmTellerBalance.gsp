
<!DOCTYPE html>
<html>
    <head>
	<meta name="layout" content="main">
        <g:set var="entityName" value="${message(code: 'userMaster.label', default: 'UserMaster')}" />
        <title>Teller Balancing</title>
    </head>
    <body>
        <content tag="breadcrumbs">
            <span class="fa fa-chevron-right"></span><span class="current">Teller Balancing</span>
        </content>
        <content tag="main-content">
            <g:if test="${isUserBalanced == true}">
            <div class="alert alert-success alert-dismissable">
                <div class="panel-body">
                    <h2><span class="fa fa-check"></span> ${msgContent}</h2> 
                </div>
            </div>
            </g:if>    
            <g:else>
            <div class="alert alert-danger alert-dismissable">
                <div class="panel-body">
                    <h2><span class="fa fa-exclamation-triangle"></span> ${msgContent}</h2> 
                </div>
            </div>
                
            </g:else> 
            <div class="row">
                <div class="section-container">
                    <fieldset>
                        <legend class="section-header"></legend>
                        <table class="table table-bordered table-rounded table-striped table-hover">
                        <tbody>
                            <tr>
                                <th>Currency</th>
                                <th>Cash in</th>
                                <th>Cash out</th>
                                <th style="text-align: center;">TOTAL CASH ON HAND</th>
                                <th>Status</th>
                            </tr>
                            
                            <g:each in="${txnBalanceTeller}" var="txnTellerB" status="i" >
                                <td>${txnTellerB?.currency?.name}</td>
                                <td><g:formatNumber format="###,###,##0.00" number="${txnTellerB?.cashIn}"/></td>
                                <td><g:formatNumber format="###,###,##0.00" number="${txnTellerB?.cashOut}"/></td>
                                <td style="text-align: center;"><g:formatNumber format="###,###,##0.00" number="${txnTellerB?.cashIn - txnTellerB?.cashOut}"/></td>
                                <g:if test="${txnTellerB?.isBalance == true}">
                                    <td>Balanced</td>
                                </g:if>
                                <g:else>
                                    <td>Not yet Balanced</td>
                                </g:else>    
                            </g:each>
                        </tbody>
                        </table>
                    </fieldset>
                </div>
            </div>        
        </content>
        <content tag="main-actions">
            <ul>
                <li><a class="home" href="${createLink(uri: '/')}">Back to Home</a></li>
                <li><g:link class="index" action="index" controller="tellering">Tellering Index</g:link></li>
            </ul>
        </content>
    </body>
</html>

