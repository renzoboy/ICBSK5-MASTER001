<%@ page import="icbs.gl.AssetsHeldToMaturity" %>
<%@ page import="icbs.gl.GlAccount" %>
<!DOCTYPE html>
<html>
    <head>
	<meta name="layout" content="main">
	<title>Assets Held To Maturity Information</title>
    </head>
    <body>
         <content tag="breadcrumbs">
            <span class="fa fa-chevron-right"></span><a href="${createLink(uri: '/accountsReceivable')}">Assets Held To Maturity</a>
            <span class="fa fa-chevron-right"></span><span class="current">Assets Held To Maturity Information</span>
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
                    <li class="active"><a href="#tab_1" data-toggle="tab">HTM Details</a></li>
                    <li><a href="#tab_2" data-toggle="tab">HTM Discount Schedule</a></li>																		   
                </ul>
            </div>
            <div class="tab-content">
                <div class="tab-pane active fade in" id="tab_1">
                    <div class="row">
                        <div class="section-container">
                            <fieldset>
                                <legend class="section-header">Asset Held to Maturity</legend>
                                <table class="table table-bordered table-rounded table-striped table-hover">
                                    <tbody>
                                        <tr>
                                            <td style = "width:30%;"><label>Branch</label></td>
                                            <td style = "width:70%;">${htmInstance?.branch?.name}</td>    
                                        </tr>
                                        <tr>
                                            <td><label>Currency</label></td>
                                            <td>${htmInstance?.currency?.name}</td>    
                                        </tr>
                                        <tr>
                                            <td><label>Resident Type</label></td>
                                            <td>${htmInstance?.residentType?.description}</td>    
                                        </tr>
                                        <tr>
                                            <td><label>HTM GL Code</label></td>
                                            <td>${htmInstance?.glCode}</td>    
                                        </tr>
                                         <tr>
                                            <td><label>HTM GL Description</label></td>
                                            <td>${GlAccount.findByCode(htmInstance?.glCode).name}</td>    
                                        </tr>
                                        <tr>
                                            <td><label>HTM Debit GL Code</label></td>
                                            <td>${htmInstance?.htmAccrualDebitAcct}</td>    
                                        </tr>
                                        <tr>
                                            <td><label>HTM Debit GL Description</label></td>
                                            <td>${GlAccount.findByCode(htmInstance?.htmAccrualDebitAcct).name}</td>    
                                        </tr>
                                        <tr>
                                            <td><label>HTM Credit GL Code</label></td>
                                            <td>${htmInstance?.htmAccrualCredittAcct}</td>    
                                        </tr>
                                        <tr>
                                            <td><label>HTM Credit GL Description</label></td>
                                            <td>${GlAccount.findByCode(htmInstance?.htmAccrualCredittAcct).name}</td>    
                                        </tr>
                                        <tr>
                                            <td ><label>Amount of Placement</label></td>
                                            <td><g:formatNumber format="###,###,##0.00" number="${htmInstance?.amount}"/></td>   
                                        </tr>
                                         <tr>
                                            <td><label>Interest Rate</label></td>
                                            <td><g:formatNumber format="###,###,##0.00" number="${htmInstance?.interestRate}"/></td>  
                                        </tr>
                                        <tr>
                                            <td><label>Value Date</label></td> 
                                            <td><g:formatDate  format="MM/dd/yyyy" date="${htmInstance?.valueDate}" /></td>  
                                        </tr>
                                        <tr>
                                            <td><label>Maturity Date</label></td> 
                                            <td><g:formatDate  format="MM/dd/yyyy" date="${htmInstance?.maturityDate}" /></td>  
                                        </tr>
                                        <tr>
                                            <td><label>HTM Type</label></td> 
                                            <td>${htmInstance?.htmTypeDesc?.description}</td>  
                                        </tr>
                                        <tr>
                                            <td ><label>HTM Discount Amount</label></td>
                                            <td><g:formatNumber format="###,###,##0.00" number="${htmInstance?.discountAmount}"/></td>   
                                        </tr>
                                        <tr>
                                            <td><label>HTM Description</label></td>
                                            <td>${htmInstance?.htmDescription}</td>    
                                        </tr>
                                        <tr>
                                            <td><label>Issuer</label></td>
                                            <td>${htmInstance?.htmIssuer}</td>    
                                        </tr>
                                        <tr>
                                            <td ><label>Effective Yield</label></td>
                                            <td><g:formatNumber format="###,###,##0.00" number="${htmInstance?.effectiveYield}"/></td>   
                                        </tr>
       
                                        <tr>
                                            <td><label>Reference</label></td>
                                            <td>${htmInstance?.reference}</td>    
                                        </tr>
                                        
                                        <tr>
                                            <td><label>Created Date</label></td> 
                                            <td><g:formatDate  format="MM/dd/yyyy" date="${htmInstance?.createdDate}" /></td>  
                                        </tr>
                                        <tr>
                                            <td><label>Status</label></td>
                                            <td>${htmInstance?.status.description}</td>    
                                        </tr>

                                    </tbody>
                                </table>
                            </fieldset>
                        </div>
                </div>   
                </div>
                <div class="tab-pane fade in" id="tab_2">
                    
                    <div class="row">
                        <div class="section-container">
                            <fieldset>
                                <legend class="section-header"> Schedule Details</legend>
                                <table class="table table-hover table-condensed table-bordered table-striped">
                                    <tbody>
                                        <tr>
                                                <td><label>HTM Discount Schedule</label></td>			
                                                <td><label>Discount Amount</label></td>
                                                <td><label>HTM Schedule Status</label></td>
                                        </tr>
                                    </tbody>
                                        <tbody>
                                            <g:each var="htmScheduleList" in="${htmScheduleInstance}" >
                                            <tr>
                                                <td><g:formatDate  format="MM/dd/yyyy" date="${htmScheduleList?.xhtmScheduleDate}" /></td>
                                                <td><g:formatNumber format="###,###,##0.00" number="${htmScheduleList?.amount}"/></td>
                                                <td>${htmScheduleList?.status?.description}</td>
                                            </tr>
                                            </g:each>
                                        </tbody>
                                </table>
                                <div>
                                    <table border="0">
                                        <tr>
                                            <td width="200">Total Discount</td>
                                            <td><strong><g:formatNumber format="###,###,##0.00" number="${totalDiscountInstance}"/></strong></td>
                                        </tr>
                                        <tr>
                                            <td width="200">Remaining Discount</td>
                                            <td><strong><g:formatNumber format="###,###,##0.00" number="${remainingDiscount}"/></strong></td>
                                        </tr>
                                    </table>
                                </div>    
                            </fieldset>  
                        </div>    
                    </div>  
                
                </div>   
            </div>
                 
                
            </div>
        </content>
        <content tag="main-actions">
            <ul>
                <g:if test="${htmInstance.status.id != 8}">
                    <li><g:link action="edit" controller="assetsHtm" id="${htmInstance.id}" >Edit</g:link></li>
                    <li><g:link action="htmDebit" controller="assetsHtm"  id="${htmInstance?.id}">Assets HTM Debit</g:link></li>
                    <li><g:link action="htmCredit" controller="assetsHtm"  id="${htmInstance?.id}">Assets HTM Credit</g:link></li>
                </g:if>   
                <g:if test="${htmInstance.amount > 0}">
                    <li><g:link action="reclassHtm" controller="assetsHtm"  id="${htmInstance.id}">Reclass HTM</g:link></li>        
                </g:if>
                
                <li><g:link action="viewMoreTransaction" controller="assetsHtm" id="${htmInstance?.id}">View Assets HTM Transactions</g:link></li>
                <li><g:link action="index" controller="assetsHtm" >Assets HTM List</g:link></li>
            </ul>
        </content>

    </body>
</html>
