<%@ page import="icbs.loans.ROPA" %>
<!DOCTYPE html>
<html>
    <head>
	<meta name="layout" content="main">
	<title>ROPA Information</title>
    </head>
    <body>
        <content tag="breadcrumbs">
                <span class="fa fa-chevron-right"></span><span class="current">ROPA Information</span>
        </content>
        <content tag="breadcrumbs">
            <span class="fa fa-chevron-right"></span><a href="${createLink(uri: '/ropa')}">ROPA Index</a>
            <span class="fa fa-chevron-right"></span><span class="current">ROPA Details</span>
        </content>
        <content tag="main-content">
             <div id="show-ROPA" class="content scaffold-show" role="main">
                <g:if test="${flash.message}">
                    <div class="box-body">
                        <div class="alert alert-info alert-dismissable">
                            <i class="fa fa-info"></i>
                            <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                            <b>Message</b> <div class="message" role="status">${flash.message}</div>
                        </div>
                    </div>
                </g:if>
                <div class="nav-tab-container">
                    <ul class="nav nav-tabs">
                        <li class="active"><a href="#tab_1" data-toggle="tab">ROPA Information</a></li>
                        <li><a href="#tab_2" data-toggle="tab">Collateral Information</a></li>   
                        <li><a href="#tab_4" data-toggle="tab">ROPA Transactions</a></li> 
                    </ul>
                </div>
                <div class="tab-content">
                    <div class="tab-pane active fade in table-responsive" id="tab_1">
                        <legend>Ropa Information</legend>
                        <g:render template="ropaInformation/show"/>
                    </div>
                    <div class="tab-pane" id="tab_2">
                        <legend>Collateral Information</legend>
                        <g:render template="collateralInformation/show"/>
                    </div>
                    <div class="tab-pane" id="tab_4">
                        <g:render template="transactions/show"/>
                    </div>
                </div>	                                  
            </div>
            <g:hiddenField id="ropaid" name="ropaid" value="${params.id}" />
        </content>	
        <content tag="main-actions">
            <ul>
                <li><g:link action="edit" controller="ropa" id="${ropapapapaInstance?.id}" >Edit ROPA</g:link></li>
                <li><g:link action="index" >List of ROPA</g:link></li>
                
            </ul>
        </content>
    </body>
</html>

