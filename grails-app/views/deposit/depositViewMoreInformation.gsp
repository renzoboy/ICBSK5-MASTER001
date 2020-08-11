<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="icbs.tellering.TxnCOCI" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="layout" content="main">
        <title>Deposit View More Information</title>
    </head>
    <body>
        <content tag="breadcrumbs">
            <span class="fa fa-chevron-right"></span><span class="current">Deposit View Information</span>
	</content>
        <content tag="main-content">
            
           <h3>Account Number: ${depositInstance?.acctNo}</h3> 
            <div class="row">
                <div class="col-xs-12 col-sm-12">
                        <g:render template='/customer/details/newCustomerDetailedInfo' model="[customerInstance:depositInstance?.customer]"/>
                </div>

            </div>
            <div class="row">
                <div class="nav tab-container">
                    <ul class="nav nav-tabs">
                        <li class="active"><a href="#tab_1" data-toggle="tab">Account and Balance Information</a></li>
                        <li><a href="#tab_2" data-toggle="tab">Other Owners/Signatories</a></li> 
                        <li><a href="#tab_3" data-toggle="tab">Transactions</a></li>
                        <li><a href="#tab_4" data-toggle="tab">Uncleared Deposits</a></li>
                    </ul>
                </div>	
                <div class="tab-content">
                    <div class="tab-pane active fade in table-responsive" id="tab_1">
                        <legend>Account and Balance Information</legend>
                        <g:render template="viewMoreInfoTemplates/accountAndBalance"/>
                    </div>
                    <div class="tab-pane" id="tab_2">
                        <legend>Other Owners/Signatories</legend>
                        <g:render template="viewMoreInfoTemplates/owner"/>
                    </div>
                    <div class="tab-pane" id="tab_3">
                        <legend>Transactions</legend>
                        <g:render template="/search/searchTemplate/deposit/txn/viewGrid"/>
                    </div>
                    <div class="tab-pane" id="tab_4">
                        <legend>Uncleared Deposits</legend>
                        <g:render template="viewMoreInfoTemplates/unclearedDeposits"/>
                    </div>
                </div>
            </div>
        </content>
        <content tag="main-actions">
            <ul>
                <!-- <li><g:link action="depositInquiry" id="${depositInstance?.id}" onclick="return confirm('Are you sure you want to return to Deposit Inquiries page?');  ">Return to Deposit Inquiry Page</g:link></li>-->
                <li><g:link action="depositInquiry" id="${depositInstance?.id}" >Return to Deposit Inquiry Page</g:link></li>
                <li>
                <a href = "#" onclick="genReportDEP007();">Print Deposit Inquiry</a></li>
                
                <g:javascript>
                    function genReportDEP007(){
                        reportlink = "${icbs.admin.Institution.get(90).paramValue}${icbs.admin.Report.get(14).baseParams}&output=${icbs.admin.Report.get(14).outputParam}";
                        reportlink = reportlink + "&reportUnit=${icbs.admin.Report.get(14).reportUnit}";             
                        reportlink = reportlink + "&deposit_acct_no=${depositInstance?.acctNo}";
                        reportlink = reportlink + "&generatedby=${icbs.admin.UserMaster.get(session.user_id).username}";
                        sendtojasperver(reportlink);
                    }       
                </g:javascript>
                
                <li><a href='#' id="add-buttons" type="button" data-toggle="modal" data-target="#modalParameters" class="btn btn-primary multi-field-btn-add">
                        Print Bank Statement</a></li>
                <!-- Modal -->
                <div id="modalParameters" class="modal fade" role="dialog">
                  <div class="modal-dialog">

                    <!-- Modal content-->
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                            <h4 class="modal-title" style="color: black;">Deposit Bank Statement</h4>
                        </div>
                        <div class="modal-body">
                            
                            <!-- date1 -->
                            <div class="fieldcontain form-group ${hasErrors(bean: customerInstance, field: 'registrationDate', 'has-error')} ">
                                <label class="control-label col-sm-4" style="color: gray;">Cut-Off Date Start: </label>
                                <div class="col-sm-8"><g:customDatePicker name="date1" id="date1"  precision="day" class="form-control"  value="" default="none" noSelection="['': '']" /></div>
                            </div>
                            <!-- date2 -->
                            <div class="fieldcontain form-group ${hasErrors(bean: customerInstance, field: 'registrationDate', 'has-error')} ">
                                <label class="control-label col-sm-4" style="color: gray;">Cut-Off Date End: </label>
                                <div class="col-sm-8"><g:customDatePicker name="date2" id="date2"  precision="day" class="form-control"  value="" default="none" noSelection="['': '']" /></div>
                            </div>
                        </div>
                        <div class="modal-footer">
                            <a href = "#" onclick="genReportDEP008();" class="btn btn-default"> Print Report </a>
                            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                        </div>
                       
                        <g:javascript>
                            function genReportDEP008(){
                                reportlink = "${icbs.admin.Institution.get(94).paramValue}${icbs.admin.Report.get(15).baseParams}&output=${icbs.admin.Report.get(15).outputParam}";
                                reportlink = reportlink + "&reportUnit=${icbs.admin.Report.get(15).reportUnit}";
                                reportlink = reportlink + "&DateFrom=" + dateformat(document.getElementById('date1').value);
                                reportlink = reportlink + "&DateTo=" + dateformat(document.getElementById('date2').value);
                                reportlink = reportlink + "&deposit_acct_no=${depositInstance?.acctNo}";
                                reportlink = reportlink + "&generatedby=${icbs.admin.UserMaster.get(session.user_id).username}";
                                sendtojasperver(reportlink);
                            }
                        </g:javascript>
                    </div>

                  </div>
                </div>  
                <!-- modal close --> 
            </ul>       
        </content>
    </body>
</html>
