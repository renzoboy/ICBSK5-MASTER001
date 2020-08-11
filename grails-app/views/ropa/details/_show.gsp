<%@ page import="icbs.loans.RopaCollateralDetails" %>
<%@ page import="icbs.loans.ROPA" %>
<%@ page import="icbs.loans.Collateral" %>
<%@ page import="icbs.lov.AppraisedValueType" %>
<legend>Collateral Details</legend>
<table class="table table-bordered table-striped">
    <tbody>
        <tr>
            <td style="font-weight:bold" width="30%">Collateral Owner</td>
            <td width="70%">${collateralInstance?.collateral?.owner?.displayName}</td>
        </tr>
        <tr>
            <td style="font-weight:bold" width="30%">Former Title</td>
            <td width="70%">${collateralInstance?.formerTitle}</td>
        </tr>
        <tr>
            <td style="font-weight:bold" width="30%">Total Appraisal</td>
            <td width="70%"><g:formatNumber format="###,###,##0.00" number="${collateralInstance?.landAppraisal}"/></td>
        </tr>  
        <tr>
            <td style="font-weight:bold" width="30%">Land Area</td>
            <td width="70%">${collateralInstance?.landArea}</td>
        </tr> 
        <tr>
            <td style="font-weight:bold" width="30%">Location</td>
            <td width="70%">${collateralInstance?.location}</td>
        </tr> 
        <tr>
            <td style="font-weight:bold" width="30%">Loan Account No</td>
            <td width="70%">${collateralInstance?.loan.accountNo}</td>
        </tr> 
        <tr>
            <td style="font-weight:bold" width="30%">Refence Date</td>
            <td width="70%"><g:formatDate  format="MM/dd/yyyy" date="${collateralInstance?.refDate}" /></td>
        </tr>
        <tr>
            <td style="font-weight:bold" width="30%">Status</td>
            <td width="70%">${collateralInstance?.status}</td>
        </tr>
    </tbody>    
</table> 