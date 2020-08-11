<%@ page import="icbs.loans.RopaCollateralDetails" %>
<%@ page import="icbs.loans.ROPA" %>
<%@ page import="icbs.loans.Collateral" %>
<%@ page import="icbs.lov.AppraisedValueType" %>
<legend>Collateral Details</legend>
<table class="table table-bordered table-striped">
    <tbody>
        <tr>
            <td style="font-weight:bold" width="30%">Name of Former Owner</td>
            <td width="70%">${collateralInstance?.collateral?.owner?.displayName}</td>
        </tr>
        <tr>
            <td style="font-weight:bold" width="30%">Date Acquired (ROPA Date)</td>
            <td width="70%"><g:formatDate  format="MM/dd/yyyy" date="${collateralInstance?.ropa.runDateCreated}" /></td>
        </tr>
        <tr>
            <td style="font-weight:bold" width="30%">Title Number</td>
            <td width="70%">${collateralInstance?.formerTitle}</td>
        </tr>
        <tr>
            <td style="font-weight:bold" width="30%">Kind of Property</td>
            <td width="70%">${collateralInstance?.kindOfLand}</td>
        </tr>
        <tr>
            <td style="font-weight:bold" width="30%">Location</td>
            <td width="70%">${collateralInstance?.location}</td>
        </tr>
        <tr>
            <td style="font-weight:bold" width="30%">Property Area (sq. m.)</td>
            <td width="70%">${collateralInstance?.landArea}</td>
        </tr>
        <tr>
            <td style="font-weight:bold" width="30%">Original Appraised Value</td>
            <td width="70%"> <g:formatNumber format="###,###,##0.00" number="${collateralInstance?.collateral?.appraisedValue}"/></td>
        </tr>        
    </tbody>    
</table> 