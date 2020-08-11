<%@ page import="icbs.loans.RopaCollateralDetails" %>
<%@ page import="icbs.loans.ROPA" %>
<%@ page import="icbs.loans.Collateral" %>
<tr>
    <td style="font-weight:bold" width="30%">Land Area (sq. meters)</td>
    <td width="70%"><g:formatNumber format="##,###,###,##0.00" number="${collateralInstance?.collateral?.rem?.landArea}"/></td>
</tr>
<tr>
    <td style="font-weight:bold" width="30%">TCT No.</td>
    <td width="70%">${collateralInstance?.collateral?.rem?.tctNo}</td>
</tr>
<tr>
    <td style="font-weight:bold" width="30%">Lot No.</td>
    <td width="70%">${collateralInstance?.collateral?.rem?.lotNo}</td>
</tr>
<tr>
    <td style="font-weight:bold" width="30%">Location</td>
    <td width="70%">${collateralInstance?.collateral?.rem?.location}</td>
</tr>
<tr>
    <td style="font-weight:bold" width="30%">Other Owners</td>
    <td width="70%">${collateralInstance?.collateral?.rem?.otherOwners}</td>
</tr>
<tr>
    <td style="font-weight:bold" width="30%">Registry of Deeds</td>
    <td width="70%">${collateralInstance?.collateral?.rem?.registryOfDeeds}</td>
</tr>
<tr>
    <td style="font-weight:bold" width="30%">Date of Issuance</td>
    <td width="70%"><g:formatDate date="${collateralInstance?.collateral?.rem?.dateOfIssuance}" type="date" style="FULL"/></td>
</tr>
<tr>
    <td style="font-weight:bold" width="30%">Encumberances</td>
    <td width="70%">${collateralInstance?.collateral?.rem?.encumberances}</td>
</tr>