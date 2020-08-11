
<!DOCTYPE html>
<html>
    <head>
	<meta name="layout" content="main">
	<title>ROPA Accumulated Depreciation Details</title>
    </head>
    <body>
         <content tag="breadcrumbs">
            <span class="fa fa-chevron-right"></span><span class="current">Show Ropa Accumulated Depreciation Details</span>
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
                    <li class="active"><a href="#tab_1" data-toggle="tab">ROPA Collateral Details</a></li>
                    <li><a href="#tab_2" data-toggle="tab">Accumulated Depreciation Records</a></li>                        
                </ul>
            </div>
            <div class="tab-content">
                <div class="tab-pane active fade in table-responsive" id="tab_1">
                    <legend class="section-header">ROPA Collateral Details</legend>
                    
                    <table class="table table-bordered table-striped">
                        <tbody>
                            <tr>
                                <td style="font-weight:bold" width="30%">Collateral Owner</td>
                                <td width="70%">${ropaCollateralDetails?.collateral?.owner?.displayName}</td>
                            </tr>
                            <tr>
                                <td style="font-weight:bold" width="30%">Former Title</td>
                                <td width="70%">${ropaCollateralDetails?.formerTitle}</td>
                            </tr>
                            <tr>
                                <td style="font-weight:bold" width="30%">Total Appraisal</td>
                                <td width="70%"><g:formatNumber format="###,###,##0.00" number="${ropaCollateralDetails?.landAppraisal}"/></td>
                            </tr>  
                            <tr>
                                <td style="font-weight:bold" width="30%">Land Area</td>
                                <td width="70%">${ropaCollateralDetails?.landArea}</td>
                            </tr> 
                            <tr>
                                <td style="font-weight:bold" width="30%">Location</td>
                                <td width="70%">${ropaCollateralDetails?.location}</td>
                            </tr> 
                            
                            <tr>
                                <td style="font-weight:bold" width="30%">Refence Date</td>
                                <td width="70%"><g:formatDate  format="MM/dd/yyyy" date="${ropaCollateralDetails?.refDate}" /></td>
                            </tr>
                           
                            <tr>
                                <td style="font-weight:bold" width="30%">ROPA Building Amount</td>
                                <td width="70%"><g:formatNumber format="###,###,##0.00" number="${ropaCollateralDetails?.ropaBldgAmt}"/></td>
                            </tr>
                            <tr>
                                <td style="font-weight:bold" width="30%">Building Accumulated Depreciation</td>
                                <td width="70%"><g:formatNumber format="###,###,##0.00" number="${ropaCollateralDetails?.buildingAccDepreciation}"/></td>
                            </tr>
                            <tr>
                                <td style="font-weight:bold" width="30%">ROPA Other Properties Acquired Amount</td>
                                <td width="70%"><g:formatNumber format="###,###,##0.00" number="${ropaCollateralDetails?.ropaOtherAmt}"/></td>
                            </tr>
                            <tr>
                                <td style="font-weight:bold" width="30%">Other Accumulated Depreciation</td>
                                <td width="70%"><g:formatNumber format="###,###,##0.00" number="${ropaCollateralDetails?.otherAccDepreciation}"/></td>
                            </tr>                           
                        </tbody>    
                    </table>                        
                </div>
                <div class="tab-pane" id="tab_2">
                    <legend>ROPA Accumulated Depreciation Records</legend>

                    <div class="table-responsive">
                        <table class="table table-hover table-condensed table-bordered table-striped">
                            <tbody>
                                <tr>
                                    <td><label>ID</label></td>
                                    <td><label>Record Date</label></td>				
                                    <td><label>Debit Amount (Building)</label></td>
                                    <td><label>Credit Amount (Building)</label></td>
                                    <td><label>Debit Amount (Other Properties)</label></td>
                                    <td><label>Credit Amount (Other Properties)</label></td>
                                    <td><label>Reference</label></td>
                                    <td><label>Particulars</label></td>
                                    <td><label>Record By</label></td>
                                </tr>
                            </tbody>
                            <tbody>
                                <g:each in="${ropaAccumulatedDepInstance}" var="ropaAccDepInstance">
                                    <tr>
                                        <td>${ropaAccDepInstance?.id}</td>
                                        <td><g:formatDate format="MM/dd/yyyy" date="${ropaAccDepInstance?.recordDate}"/></td>
                                        <td><g:formatNumber format="###,###,##0.00" number="${ropaAccDepInstance?.debitAmt}"/></td>
                                        <td><g:formatNumber format="###,###,##0.00" number="${ropaAccDepInstance?.creditAmt}"/></td>
                                        <td><g:formatNumber format="###,###,##0.00" number="${ropaAccDepInstance?.otherDebitAmt}"/></td>
                                        <td><g:formatNumber format="###,###,##0.00" number="${ropaAccDepInstance?.otherCreditAmt}"/></td>
                                        <td>${ropaAccDepInstance?.reference}</td>
                                        <td>${ropaAccDepInstance?.particulars}</td>				
                                        <td>${ropaAccDepInstance?.recordBy?.name1} ${ropaAccDepInstance?.recordBy?.name2} ${ropaAccDepInstance?.recordBy?.name3}</td>
                                    </tr>
                                </g:each>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div> 
            <%-- ============================================================  --%>        
            
               
        
            
                
                    
            </div>
        </content>		

        <content tag="main-actions">
            <ul>
                <li><g:link controller="ropa" action="ropaCreateAccdep"  id="${ropaCollateralDetails.id}" params="[actionType: 'debit']" >Debit Accumulated Depreciation </g:link></li>
                <li><g:link controller="ropa" action="ropaCreateAccdep"  id="${ropaCollateralDetails.id}" params="[actionType: 'credit']">Credit Accumulated Depreciation </g:link></li>
                <li><g:link action="collateralShow" controller="ropa" id="${ropaCollateralDetails.id}">Back to  ROPA Information</g:link></li>  
            </ul>
        </content>
    </body>
</html>