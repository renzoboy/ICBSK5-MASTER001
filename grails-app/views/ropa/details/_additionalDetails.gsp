<%@ page import="icbs.loans.RopaCollateralDetails" %>
<%@ page import="icbs.loans.ROPA" %>
<%@ page import="icbs.loans.Collateral" %>
<%@ page import="icbs.lov.AppraisedValueType" %>
<legend>Additional Details</legend>

<table class="table table-bordered table-striped">
    <tbody>
        <tr>
            <td style="font-weight:bold" width="40%">Date of Filing of Foreclosure</td>
            <td width="70%"><g:formatDate  format="MM/dd/yyyy" date="${collateralInstance?.forClosureDate}" /></td>
        </tr>
        <tr>
            <td style="font-weight:bold" width="40%">Date of Execution of Certificate of Sale</td>
            <td width="70%"><g:formatDate  format="MM/dd/yyyy" date="${collateralInstance?.certificateDate}" /></td>
        </tr>
        <tr>
            <td style="font-weight:bold" width="40%">Date of Registration of Certificate of Sale</td>
            <td width="70%"><g:formatDate  format="MM/dd/yyyy" date="${collateralInstance?.certificateRegistrationDate}" /></td>
        </tr>
        <tr>
            <td style="font-weight:bold" width="40%">Date of Notarization of Dacion</td>
            <td width="70%"><g:formatDate  format="MM/dd/yyyy" date="${collateralInstance?.notarizationOfDacionDate}" /></td>
        </tr>
        <tr>
            <td style="font-weight:bold" width="40%">Expiry Date of Redemption</td>
            <td width="70%"><g:formatDate  format="MM/dd/yyyy" date="${collateralInstance?.cosExpiryDateOfRedemption}" /></td>
        </tr>
        <tr>
            <td style="font-weight:bold" width="40%">Date of Consolidation</td>
            <td><g:formatDate  format="MM/dd/yyyy" date="${collateralInstance?.consolidatedDate}" /></td>  
        </tr>
        <tr>
            <td style="font-weight:bold" width="40%">Consolidated Title Number</td>
            <td width="70%">${collateralInstance?.consolidatedTitleNumber}</td>
        </tr>
        <tr>
            <td style="font-weight:bold" width="40%">Amount of Fire Insurance Coverage</td>
            <td width="70%"> <g:formatNumber format="###,###,##0.00" number="${collateralInstance?.fireInsuranceAmt}"/></td>
        </tr> 
        <tr>
            <td style="font-weight:bold" width="40%">Fire Insurance Policy Number</td>
            <td width="70%">${collateralInstance?.fireInsurancePolicyNo}</td>
        </tr>
        <tr>
            <td style="font-weight:bold" width="40%">Date of Effectivity of Fire Insurance</td>
            <td width="70%"><g:formatDate  format="MM/dd/yyyy" date="${collateralInstance?.fireInsuranceStartDate}" /></td>
        </tr>
        <tr>
            <td style="font-weight:bold" width="40%">Expiry Date of Fire Insurance</td>
            <td width="70%"><g:formatDate  format="MM/dd/yyyy" date="${collateralInstance?.fireInsuranceEndDate}" /></td>
        </tr>
        <tr>
            <td style="font-weight:bold" width="40%">Date of Latest Real Estate Tax Receipt (RETR)</td>
            <td width="70%"><g:formatDate  format="MM/dd/yyyy" date="${collateralInstance?.latestRatrDate}" /></td>
        </tr>
         
        <g:if test="${collateralInstance?.appraisedBy}">
        <tr>
            <td style="font-weight:bold" width="40%">Appraised by:</td>
            <td width="70%">${collateralInstance?.appraisedBy.name1} ${collateralInstance?.appraisedBy.name2} ${collateralInstance?.appraisedBy.name3}</td>
        </tr> 
        </g:if>
        <g:else>
            <tr>
                <td style="font-weight:bold" width="40%">Appraised by:</td>
                <td width="70%"></td>
            </tr>
        </g:else>
        <tr>
            <td style="font-weight:bold" width="40%">Latest Appraisal Date:</td>
            <td width="70%"><g:formatDate  format="MM/dd/yyyy" date="${collateralInstance?.appraisalDate}" /></td>
        </tr>         
        <tr>
            <td style="font-weight:bold" width="30%">Latest Appraised Value - Land</td>
            <td width="70%"> <g:formatNumber format="###,###,##0.00" number="${collateralInstance?.landAppraisal}"/></td>
        </tr> 
        <tr>
            <td style="font-weight:bold" width="30%">Latest Appraised Value - Building</td>
            <td width="70%"> <g:formatNumber format="###,###,##0.00" number="${collateralInstance?.buildingAppraisal}"/></td>
        </tr> 
        <tr>
            <td style="font-weight:bold" width="30%">Latest Appraised Value - Other Properties Acquired</td>
            <td width="70%"> <g:formatNumber format="###,###,##0.00" number="${collateralInstance?.otherAppraisal}"/></td>
        </tr> 
        <tr>
            <td style="font-weight:bold" width="30%">Total Latest Appraised Value</td>
            <td width="70%"> <g:formatNumber format="###,###,##0.00" number="${collateralInstance?.landAppraisal + collateralInstance?.buildingAppraisal + collateralInstance?.otherAppraisal}"/></td>
        </tr>         
    </tbody>    
</table> 

