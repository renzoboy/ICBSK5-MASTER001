<!--
  To change this license header, choose License Headers in Project Properties.
  To change this template file, choose Tools | Templates
  and open the template in the editor.
-->

<%@ page contentType="text/html;charset=UTF-8" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="layout" content="main">
        <title>Customer View Information</title>
    </head>
    <body>
        <content tag="main-content">
            <div class="row">
                <div class="col-xs-12 col-sm-12">
                   <g:render template="viewMoreInfoTemplates/primaryInfo"/>
                </div>
            </div>
            <div class="row">
                <div class="col-xs-12 col-sm-12">
                    <g:render template="viewMoreInfoTemplates/xform"/>
                </div>
            </div>
        </content>
        <content tag="main-actions">
            <ul>
                <li><g:link action="customerInquiry" id="${customerInstance?.id}">Back to Customer Inquiry</g:link></li>
                <li>
                <a href = "#" onclick="genReportCIF001();">Print Customer Information</a></li>
                
                <g:javascript>
                    function genReportCIF001(){
                        reportlink = "${icbs.admin.Institution.get(90).paramValue}${icbs.admin.Report.get(5).baseParams}&output=${icbs.admin.Report.get(5).outputParam}";
                        reportlink = reportlink + "&reportUnit=${icbs.admin.Report.get(5).reportUnit}";             
                        reportlink = reportlink + "&customer_id=${customerInstance?.customerId}";
                        reportlink = reportlink + "&generatedby=${icbs.admin.UserMaster.get(session.user_id).username}";
                        sendtojasperver(reportlink);
                    }       
                </g:javascript>
            </ul>
        </content>
    </body>
</html>