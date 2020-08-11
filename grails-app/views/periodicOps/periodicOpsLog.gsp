<!--
  To change this license header, choose License Headers in Project Properties.
  To change this template file, choose Tools | Templates
  and open the template in the editor.
-->

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
    <head>
        <title>Periodic Operations Log</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="layout" content="main">
  </head>
  <body>
        <content tag="breadcrumbs">
            <span class="fa fa-chevron-right"></span><span class="current">Periodic Operation Index</span>
        </content>
        <content tag="main-content">
            <div id="list-assetsHtm" class="content scaffold-list" role="main">
                <g:if test="${flash.message}">
                        <div class="message" role="status">${flash.message}</div>
                </g:if>
                <g:form class="form-inline" url="[action:'periodicOpsLog',controller:'periodicOps']" method="POST">
                    <div class="form-group">
                            <g:select name="max" value="${params.max}" from="[5, 10, 15, 20]" class="form-control input-sm pull-left"onchange="this.form.submit()" />
                    </div>
                    <%--<div class="right">
                            <div class="form-group">
                                    <g:textField  type="text" name="query" class="form-control input-sm pull-right" style="width: 350px;" placeholder="Search by Assset Type , Description and GL CODE"/>
                            </div>
                            <g:submitButton name="Search" class="btn btn-sm btn-default"><i class="fa fa-search"></i></g:submitButton>
                    </div> --%>
                </g:form>
                <table class="table table-hover table-condensed table-bordered table-striped">
                    <thead>
                        <tr>
                            <th><label>Run Date</label></th>
                            <th><label>Start Time</label></th>
                            <th><label>End Time</label></th>
                            <th><label>Process</label></th>
                            <th><label>Type</label></th>
                            <th><label>Process By</label></th>
                        </tr>
                        </thead>
                    <tbody>
                        <g:each in="${periodicOpsLogList}" status="i" var="periodicOpsLogInstance"> 
                            <tr>
                                <td><g:formatDate format="MM/dd/yyyy" date="${periodicOpsLogInstance.runDate}"/></td>
                                <td>${periodicOpsLogInstance.startTime}</td>
                                <td>${periodicOpsLogInstance.endTime}</td>
                                <td>${periodicOpsLogInstance.processUID}</td>
                                <td>${periodicOpsLogInstance.periodicOpsProcess.processDescription}</td>
                                <td>${periodicOpsLogInstance?.user?.name1} ${periodicOpsLogInstance?.user?.name2} ${periodicOpsLogInstance?.user?.name3}</td>
                            </tr>
                        </g:each>
                    </tbody>
                </table>    
                <div class="pagination">
                        <g:paginate total="${periodicOpsLogInstanceCount ?: 0}" params="${params}" />
                </div>
            </div>
            <%-- ====================================================== --%>
    </content>
    <content tag="main-actions">
        <ul>
            <li><a class="home" href="${createLink(uri: '/')}">Back to Home</a></li>
            <li><g:link class="index" action="index">Periodic Operations</g:link></li>
            <li><g:link class="lockSystem" action="lockSystem">Lock System for Periodic Operations</g:link></li>
            <li><g:link class="unlockSystem" action="unlockSystem">Unlock System for Periodic Operations</g:link></li>
            <li><g:link class="EODCheck" action="EODCheck">EOD Checking</g:link></li>
            <li><g:link class="eodReports" action="eodReport">EOD Reports</g:link></li>
            <li><g:link class="eomReports" action="eomReport">EOM Reports</g:link></li>
            <li><g:link class="periodicOpsUtil" action="periodicOpsUtil">Periodic Operations Utilities</g:link></li>           
        </ul>
    </content>
  </body>
</html>