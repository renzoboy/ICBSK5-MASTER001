<%@ page import="icbs.loans.ROPA" %>
<!DOCTYPE html>
<html>
    <head>
	<meta name="layout" content="main">
	<title>ROPA transfer Information</title>
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
                        
                  <g:render template="ropaTransfer/show"/>	                                  
            </div>
            <g:hiddenField id="ropaid" name="ropaid" value="${params.id}" />
        </content>	
        <content tag="main-actions">
            <ul>
<!--                <li><g:link action="edit" controller="ropa" id="${ropapapapaInstance?.id}" >Edit</g:link></li>
                <li><g:link action="viewMoreTransaction" controller="ropa" id="${ropapapapaInstance?.id}" >View ROPA Transactions</g:link></li>
                <li><g:link action="ropaDebit" controller="ropa" id="${ropapapapaInstance?.id}">ROPA Debit</g:link></li>
                <li><g:link action="ropaCredit" controller="ropa" id="${ropapapapaInstance?.id}">ROPA Credit</g:link></li>-->
                <li><g:link action="index" >ROPA List</g:link></li>
            </ul>
        </content>
    </body>
</html>

