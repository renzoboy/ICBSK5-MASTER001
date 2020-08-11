<%@ page import="icbs.loans.ScrDiscountSchedule" %>
<!DOCTYPE html>
<html>
    <head>
	<meta name="layout" content="main">
	<title>SCR Discount Schedule Details</title>
    </head>
    <body>
         <content tag="breadcrumbs">
            <span class="fa fa-chevron-right"></span><span class="current">Show Discount Schedule</span>
        </content>
        <content tag="main-content">
            <div class="content scaffold-show" role="main">
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
                    <li class="active"><a href="#tab_1" data-toggle="tab">SCR Account</a></li>
                    <li><a href="#tab_2" data-toggle="tab">SCR Discount Schedule</a></li>                        
                </ul>
            </div>
            <div class="tab-content">
                <div class="tab-pane active fade in table-responsive" id="tab_1">
                    <legend class="section-header">SCR Account Information</legend>
                    <table class="table table-bordered table-rounded table-striped table-hover">
                        <tbody>
                            <tr>
                                <td style="width: 30%;"><label>SCR Account Number</label></td>
                                <td style="width: 70%;">${loanInstance?.accountNo}</td>    
                            </tr> 
                            <tr>
                                <td><label>Account Name</label></td>
                                <td>${loanInstance?.customer?.displayName}</td>    
                            </tr>
                            <tr>
                                <td><label>Balance amount</label></td>
                                <td><g:formatNumber format="###,###,##0.00" number="${loanInstance?.balanceAmount}"/></td>    
                            </tr>
                            <tr>
                                <td><label>SCR Performance Status</label></td>
                                <td>${loanInstance?.loanPerformanceId.description}</td>    
                            </tr>
                            <tr>
                                <td><label>SCR Status</label></td>
                                <td>${loanInstance?.status.description}</td>    
                            </tr>
                        </tbody>
                    </table>                         
                </div>
                <div class="tab-pane" id="tab_2">
                    <legend>Schedule</legend>

                    <div class="table-responsive">
                        <table class="table table-hover table-condensed table-bordered table-striped">
                            <tbody>
                                <tr>
                                    <td><label>ID</label></td>
                                    <td><label>Schedule Date</label></td>				
                                    <td><label>Debit Amount</label></td>
                                    <td><label>Credit Amount</label></td>
                                    <td><label>Reference</label></td>
                                    <td><label>Particulars</label></td>
                                    <td><label>Record By</label></td>
                                </tr>
                            </tbody>
                            <tbody>
                                <g:each in="${scrDiscountScheduleInstance}" var="scrSchedInstance">
                                    <tr>
                                        <td>${scrSchedInstance?.id}</td>
                                        <td><g:formatDate format="MM/dd/yyyy" date="${scrSchedInstance?.scheduleDate}"/></td>
                                        <td><g:formatNumber format="###,###,##0.00" number="${scrSchedInstance?.debitAmt}"/></td>
                                        <td><g:formatNumber format="###,###,##0.00" number="${scrSchedInstance?.creditAmt}"/></td>
                                        <td>${scrSchedInstance?.reference}</td>
                                        <td>${scrSchedInstance?.particulars}</td>				
                                        <td>${scrSchedInstance?.createdBy?.name1} ${scrSchedInstance?.createdBy?.name2} ${scrSchedInstance?.createdBy?.name3}</td>
                                    </tr>
                                </g:each>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div> 
            
                
                    
            </div>
        </content>		

        <content tag="main-actions">
            <ul>
                <li><g:link action="scrCreateDiscountSchedule" controller="loan"  id="${loanInstance.id}" >Create Discount Schedule</g:link></li>
                <li><g:link action="show" controller="loan" id="${loanInstance.id}">Back to  SCR Account Inquiry</g:link></li>  
            </ul>
        </content>
    </body>
</html>
