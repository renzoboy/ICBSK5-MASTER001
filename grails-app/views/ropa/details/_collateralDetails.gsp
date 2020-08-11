<%@ page import="icbs.loans.RopaCollateralDetails" %>
<%@ page import="icbs.loans.ROPA" %>
<%@ page import="icbs.loans.Collateral" %>
<%@ page import="icbs.lov.AppraisedValueType" %>
<legend>Collateral Details</legend>
<table class="table table-bordered table-striped">
    <tbody>
        <tr>
            <td style="font-weight:bold" width="40%">Name of Former Owner</td>
            <td width="60%">${collateralInstance?.collateral?.owner?.displayName}</td>
        </tr>
        <tr>
            <td style="font-weight:bold" width="40%">Date Acquired (ROPA Date)</td>
            <td width="60%"><g:formatDate  format="MM/dd/yyyy" date="${collateralInstance?.ropa.runDateCreated}" /></td>
        </tr>
        <tr>
            <td style="font-weight:bold" width="40%">Title Number</td>
            <td width="60%">${collateralInstance?.formerTitle}</td>
        </tr>
        <tr>
            <td style="font-weight:bold" width="40%">Kind of Property</td>
            <td width="60%">${collateralInstance?.kindOfLand}</td>
        </tr>
        <tr>
            <td style="font-weight:bold" width="40%">Location</td>
            <td width="60%">${collateralInstance?.location}</td>
        </tr>
        <tr>
            <td style="font-weight:bold" width="40%">Property Area (sq. m.)</td>
            <td width="60%">${collateralInstance?.landArea}</td>
        </tr>
        <tr>
            <td style="font-weight:bold" width="40%">Allocated Cost of Land</td>
            <td width="60%"> <g:formatNumber format="###,###,##0.00" number="${collateralInstance?.ropaLandAmt}"/></td>
        </tr> 
        <tr>
            <td style="font-weight:bold" width="40%">Allocated Cost of Building</td>
            <td width="60%"> <g:formatNumber format="###,###,##0.00" number="${collateralInstance?.ropaBldgAmt}"/></td>
        </tr> 
        <tr>
            <td style="font-weight:bold" width="40%">Allocated Cost of Other Properties Acquired</td>
            <td width="60%"> <g:formatNumber format="###,###,##0.00" number="${collateralInstance?.ropaOtherAmt}"/></td>
        </tr> 
         <tr>
            <td style="font-weight:bold" width="40%">Total Cost of ROPA</td>
            <td width="60%"> <g:formatNumber format="###,###,##0.00" number="${collateralInstance?.ropaLandAmt + collateralInstance?.ropaBldgAmt + collateralInstance?.ropaOtherAmt}"/></td>
        </tr> 
         <tr>
            <td style="font-weight:bold" width="40%">Accumulated Depreciation Building</td>
            <td width="60%"> <g:formatNumber format="###,###,##0.00" number="${collateralInstance?.buildingAccDepreciation}"/></td>
        </tr>         
         <tr>
            <td style="font-weight:bold" width="40%">Accumulated Depreciation Other Properties</td>
            <td width="60%"> <g:formatNumber format="###,###,##0.00" number="${collateralInstance?.otherAccDepreciation}"/></td>
        </tr>  
         <tr>
            <td style="font-weight:bold" width="40%">Total Accumulated Depreciation</td>
            <td width="60%"> <g:formatNumber format="###,###,##0.00" number="${collateralInstance?.buildingAccDepreciation + collateralInstance?.otherAccDepreciation}"/></td>
        </tr>          
         <tr>
            <td style="font-weight:bold" width="40%">Allowance for Probable Loss - Land</td>
            <td width="60%"> <g:formatNumber format="###,###,##0.00" number="${collateralInstance?.allowanceProbLoss}"/></td>
        </tr>  
         <tr>
            <td style="font-weight:bold" width="40%">Allowance for Probable Loss - Building</td>
            <td width="60%"> <g:formatNumber format="###,###,##0.00" number="${collateralInstance?.allowanceProbLossBldg}"/></td>
        </tr> 
         <tr>
            <td style="font-weight:bold" width="40%">Allowance for Probable Loss - Other Properties</td>
            <td width="60%"> <g:formatNumber format="###,###,##0.00" number="${collateralInstance?.allowanceProbLossOtherProp}"/></td>
        </tr> 
         <tr>
            <td style="font-weight:bold" width="40%">Total Allowance for Probable Loss</td>
            <td width="60%"> <g:formatNumber format="###,###,##0.00" number="${collateralInstance?.allowanceProbLoss + collateralInstance?.allowanceProbLossBldg + collateralInstance?.allowanceProbLossOtherProp}"/></td>
        </tr>     
         <tr>
            <td style="font-weight:bold" width="40%">Net Book Value</td>
            <g:set var="netBookValue" value="${collateralInstance?.ropaLandAmt + collateralInstance?.ropaBldgAmt + collateralInstance?.ropaOtherAmt - collateralInstance?.buildingAccDepreciation - collateralInstance?.otherAccDepreciation - collateralInstance?.allowanceProbLoss - collateralInstance?.allowanceProbLossBldg - collateralInstance?.allowanceProbLossOtherProp}" />
            <td width="60%"> <g:formatNumber format="###,###,##0.00" number="${netBookValue}"/></td>
        </tr>  
        <tr>
            <td style="font-weight:bold" width="40%">Status</td>
            <td width="60%">${collateralInstance?.status}</td>
        </tr>
    </tbody>    
</table> 