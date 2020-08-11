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
        <asset:javascript src="depositHelper.js"/>
        <title>Transfer Deposit Branch</title>

    </head>
    <body>
        <content tag="main-content">   
            <div id="depositInquiryDiv">
                <g:render template='inquiry/depositInquiryForm'/>
            </div>

             <div class="row">
                <div class="section-container">
                    <fieldset>
                        <legend class="section-header">Transfer to Another Branch</legend>
                        <div class="infowrap">
                            <g:form name="saveNewBranchForm" url="[action:'updateBranch',controller:'deposit']" method="POST" onsubmit="callLoadingDialog();">
                                <g:render template='transferDepositBranch/form' model='[depositInstance:depositInstance]'/>
                            </g:form>
                            <dl class="dl-horizontal">
                                <dt></dt>
                                <dd></dd>
                            </dl>
                        </div>
                    </fieldset>
                </div>
             </div>
        </content>

        <content tag="main-actions">
            <ul>
                <li><button onclick="validateTransferToBranch();">Save</button></li>
                <li>
                    <a href=# onclick="alertify.confirm(AppTitle,'Are you sure you want to return to Deposit Inquiries page?',
                                    function(){
                                    var t_url = '/icbs/deposit/depositInquiry/${depositInstance?.id}';
                                    location.href=t_url;},
                                    function(){});">Return to Deposit Inquiry Page</a>
                </li>
                <script>
                    function validateTransferToBranch(){
                    
                        var jmbranch = $('#branch').val();
                        var jmOldBranch = $('#oldDepBranch').val();
                        var jmreference = $('#reference').val();
                        var jmparticulars = $('#remarks').val();
                        jmbranch = parseInt(jmbranch);
                        jmOldBranch = parseInt(jmOldBranch);
                        if(jmbranch == jmOldBranch){
                            notify.message('Sorry, Cannot Transfer to same branch !|error|alert'); 
                        }else if(jmreference == "" || jmreference == null || jmreference=="null"){
                            notify.message('Sorry, Reference is required !|error|alert'); 
                        }else if(jmparticulars == "" || jmparticulars == "null" || jmparticulars == null){
                            notify.message('Sorry, Particulars is required !|error|alert'); 
                        }else{
                            alertify.confirm(AppTitle,'Are you sure you want to continue this transaction?',
                            function(){
                                checkIfAllowed('DEP01910', 'form#saveNewBranchForm', 'saveNewBranchForm');
                            },
                            function(){
                                return;
                            }); 
                        }
                        
                    }
                   
                </script>    
            </ul>                                        
        </content>
    </body>
</html>