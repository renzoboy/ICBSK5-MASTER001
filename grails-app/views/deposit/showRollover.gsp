<%@ page import="icbs.deposit.Deposit" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'deposit.label', default: 'Deposit')}" />
		<title>Rollover History</title>
	</head>
	<body>
            <content tag="breadcrumbs">
                <span class="fa fa-chevron-right"></span><span class="current">Rollover Information</span>
            </content>
            <content tag="main-content">   
		<fieldset class="form">
                        <g:render template="rollover/show"/>
                </fieldset>
            </content>
             <content tag="main-actions">
                 <ul>
                   <li><a href=# onclick="alertify.confirm(AppTitle,'Are you sure you want to return to Deposits Inquiry page?',
                                    function(){
                                    var t_url = '/icbs/deposit/depositInquiry/${rolloverId?.id}';
                                    location.href=t_url;},
                                    function(){});">Return to Deposit Inquiry Page</a></li> 
                </ul>
            </content>
	</body>
</html>
