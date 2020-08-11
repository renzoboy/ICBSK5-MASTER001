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
        <title>Process Inward Check Clearing</title>
    </head>
    <body>
        <content tag="main-content">
            <g:if test="${flash.message}">
                <!--
                <div class="box-body">
                    <div class="alert alert-info alert-dismissable">
                        <i class="fa fa-info"></i>
                        <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                        <b>Message</b> <div class="message" role="status">${flash.message}</div>
                    </div>
                </div>
                -->
                <script>
                    $(function(){
                        var x = '${flash.message}';
                        notify.message(x);
                    });
                </script>
            </g:if>
            <div class="row">
                <g:form name="processInwardCheckingForm" action="processInwardCheckClearing" controller="deposit" onsubmit="callLoadingDialog();">
                    <div class="box-body table-responsive no-padding">
                        <table id="clearingTable" class="table table-hover table-condensed table-bordered table-striped">
                            <tr>
                                <td>Count</td>
                                <td><label>Account Number</label></td>
                                <td><label>Check No</label></td>
                                <td><label>Amount</label></td>
                                <td><label>BRSTN</label></td>
                                <td><label>TRANCD</label></td>
                                <td><label>Remarks</label></td>
                            </tr>
                            <g:each var="check" in="${domainInstance?.checks}" status="i">
                                <tr>
                                    <g:hiddenField name="checks[${i}].chequeNo" value="${check?.chequeNo}"/>
                                    <g:hiddenField name="checks[${i}].amt" value="${check?.amt}"/>
                                    <g:hiddenField name="checks[${i}].brstn" value="${check?.brstn}"/>
                                    <g:hiddenField name="checks[${i}].trancd" value="${check?.trancd}"/>
                                    <g:hiddenField name="checks[${i}].acctNo" value="${check?.acctNo}"/>
                                    <td>${i + 1}</td>
                                    <td>${check?.acctNo}</td>
                                    <td>${check?.chequeNo}</td>
                                    <td><g:formatNumber format="###,###,##0.00" number="${check?.amt}"/></td>
                                    <td>${check?.brstn}</td>
                                    <td>${check?.trancd}</td>
                                    <td>
                                         <g:hasErrors bean="${domainInstance}" field="checks[${i}].acctNo">
                                        <span class="help-block">
                                            <g:eachError bean="${domainInstance}" field="checks[${i}].acctNo">
                                                <g:message error="${it}" /><br/>
                                            </g:eachError>
                                        </span>
                                        </g:hasErrors>
                                        <g:hasErrors bean="${domainInstance}" field="checks[${i}].chequeNo">
                                        <span class="help-block">
                                            <g:eachError bean="${domainInstance}" field="checks[${i}].chequeNo">
                                                <g:message error="${it}" /><br/>
                                            </g:eachError>
                                        </span>
                                        </g:hasErrors>
                                         <g:hasErrors bean="${domainInstance}" field="checks[${i}].amt">
                                        <span class="help-block">
                                            <g:eachError bean="${domainInstance}" field="checks[${i}].amt">
                                                <g:message error="${it}" /><br/>
                                            </g:eachError>
                                        </span>
                                        </g:hasErrors>
                                         <g:hasErrors bean="${domainInstance}" field="checks[${i}].brstn">
                                        <span class="help-block">
                                            <g:eachError bean="${domainInstance}" field="checks[${i}].brstn">
                                                <g:message error="${it}" /><br/>
                                            </g:eachError>
                                        </span>
                                        </g:hasErrors>
                                         <g:hasErrors bean="${domainInstance}" field="checks[${i}].trancd">
                                        <span class="help-block">
                                            <g:eachError bean="${domainInstance}" field="checks[${i}].trancd">
                                                <g:message error="${it}" /><br/>
                                            </g:eachError>
                                        </span>
                                        </g:hasErrors>
                                    </td>
                                </tr>
                            </g:each>
                        </table>
                    </div>
                </g:form>
            </div>
        </content>
        <content tag="main-actions">
            <ul>
                <li><g:submitButton name="submit" id="processIcc" class="btn btn-primary" value="${'Process'}" onclick="
                        alertify.confirm(AppTitle,'Are you sure you want to continue this process?',
                                function(){
                                    checkIfAllowed('DEP01300', 'form#processInwardCheckingForm', 'Override Inward clearing process', null);
                                },
                                function(){
                                    return;
                                });
                "/></li>
                <li><g:link action="index">Print Inward Check Clearing View</g:link></li>
                <li><g:link action="index">Cancel</g:link></li>
                <!--
                <li><g:link action="depositInquiry" id="${depositInstance?.id}"
                                                    onclick="return confirm('Are you sure you want to return to Deposit Inquiries page?');">Return to Deposit Inquiry Page</g:link></li>
                -->
            </ul>
        </content>
    </body>
</html>
