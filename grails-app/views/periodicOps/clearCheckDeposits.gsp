<!--
  To change this license header, choose License Headers in Project Properties.
  To change this template file, choose Tools | Templates
  and open the template in the editor.
-->

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
    <head>
        <title>Clear Check Deposits</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="layout" content="main">
  </head>
  <body>
        <content tag="breadcrumbs">
            <span class="fa fa-chevron-right"></span><span class="current">Periodic Operation Index</span>
        </content>
        <content tag="main-content">
            <script>
                function executeCheckClearingnow(){
                    var branchRunDate = $('#branchRunDate').val();
                    var depClearingDate = $('#depClearingDate').val();
                    console.log("branchRunDate: "+branchRunDate);
                    

                    if(depClearingDate == "" || depClearingDate == "null" || depClearingDate == null){
                        notify.message("Cannot Process Clearing Date with empty value |error|alert");
                    }else{
                        depClearingDate = new Date(depClearingDate);
                        branchRunDate = new Date(branchRunDate);
                        if(branchRunDate < depClearingDate){
                            notify.message("Cannot Clear Clearing Date greater than System Date|error|alert");
                        }else{
                            alertify.confirm(AppTitle,"Are you sure you want to process this? ",
                                function(){
                                    $('#depGetClearChecks').submit();
                                },
                                function(){
                                  alertify.error('Canceled');
                                });
                        }
                    }
                }
                
            </script>    
            
            <g:form id="depGetClearChecks" url="[controller:'periodicOps', action:'saveClearCheckDeposits']" onsubmit="callLoadingDialog();" method="POST">
                <div class="fieldcontain form-group ${hasErrors(bean: assetsHtmInstance, field: 'valueDate', 'has-error')}">
                <label class="control-label col-sm-4" for="valueDate">Check Clearing Date*</label>
                <div class="col-sm-8"><g:customDatePicker id="depClearingDate" name="depClearingDate" precision="day" 
                    class="form-control" value="" />

                        <g:hasErrors bean="${assetsHtmInstance}" field="depClearingDate">
                            <div class="controls">
                                <span class="help-block">
                                    <g:eachError bean="${assetsHtmInstance}" field="depClearingDate">
                                        <g:message error="${it}" /><br/>
                                    </g:eachError>
                                </span>
                            </div>
                        </g:hasErrors>
                    </div>             
                </div>
            </g:form>    
            <g:hiddenField id="branchRunDate" name="branchRunDate" value="${g.formatDate(date: (runDate), format: 'MM/dd/yyyy')}"/>
            <%-- ====================================================== --%>
        </content>
    <content tag="main-actions">
        <ul>
           <li><button onclick="executeCheckClearingnow();">Execute Check Clearing</button></li>
            <li><a class="home" href="${createLink(uri: '/')}">Back to Home</a></li>
            <li><g:link class="index" action="index">Periodic Operations</g:link></li>
            <li><g:link class="periodicOpsUtil" action="periodicOpsUtil">Periodic Operations Utilities</g:link></li>           
        </ul>
    </content>
  </body>
</html>