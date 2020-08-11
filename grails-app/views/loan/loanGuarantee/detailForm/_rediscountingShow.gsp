<legend>Loan Rediscounting Details</legend>

<div class="table-responsive">
    
    <table class="table table-bordered table-striped">
        <tbody>

            <tr>
                <td style="font-weight:bold" width="30%">Date Granted</td>
                 <td width="70%"><g:formatDate format="MM/dd/yyyy" date="${loanRediscountingInstance?.dateGranted}"/></td>
            </tr>
            <tr>
                <td style="font-weight:bold" width="30%">Maturity Date</td>
                 <td width="70%"><g:formatDate format="MM/dd/yyyy" date="${loanRediscountingInstance?.maturityDate}"/></td>
            </tr>
            <tr>
                <td style="font-weight:bold" width="30%">PN No.</td>
                <td width="70%">${loanRediscountingInstance?.pnNo}</td>
            </tr>
            <tr>
                <td style="font-weight:bold" width="30%">Rediscounting Partner</td>
                <td width="70%">${loanRediscountingInstance?.loanRediscountingPartner?.description}</td>
            </tr>
            <tr>
                <td style="font-weight:bold" width="30%">Rediscounting Status</td>
                <td width="70%">${loanRediscountingInstance?.loanRediscountingStatus?.description}</td>
            </tr>
        </tbody>
    </table>
    <br>
    <legend>Collateral Details</legend>
    <table class="table table-hover table-condensed table-bordered table-striped">
        <tbody>
                    <tr>
                            <td><label>ID</label></td>
                            <td><label>Type</label></td>
                            <td><label>Appraised Value</label></td>		
                            <td><label>Status</label></td>					
                            <td class="col-sm-2"><label>Action</label></td>
                    </tr>
            </tbody>
            <tbody>
                    <g:each var="collateral" in="${getLoanAppCollInstance?.collaterals.sort{it.id}}">
                    <tr>
                            <td>${collateral?.id}</td>
                            <td>${collateral?.collateralType?.description}</td>
                            <<td><g:formatNumber format="###,##0.00" number="${collateral?.appraisedValue}" /></td>		
                            <td>${collateral?.status?.description}</td>
                            <td><g:link class="btn btn-secondary" controller="collateralManagement" action="show" id="${collateral?.id}">View</g:link> 
                    </tr>
                    </g:each>
            </tbody>
    </table>
</div>
