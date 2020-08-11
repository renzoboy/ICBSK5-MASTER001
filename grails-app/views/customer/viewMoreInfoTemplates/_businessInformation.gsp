<div class="section-container">
    <fieldset>
        <legend class="section-header" >Business Information</legend>
            <table class="table table-bordered table-striped">
                <tbody>
                    <tr>
                        <td style="font-weight:bold" width="30%">Business Name</td>
                        <td width="70%">${customerInstance?.businesses[0]?.name}</td>
                    </tr>
                    <tr>
                        <td style="font-weight:bold" width="30%">Economic Activity</td>
                        <td width="70%">${customerInstance?.businesses[0]?.lProject}</td>
                    </tr>
                    <tr>
                        <td style="font-weight:bold" width="30%">Business Address</td>
                        <td width="70%">${customerInstance?.businesses[0]?.address1} ${customerInstance?.businesses[0]?.address2} ${customerInstance?.businesses[0]?.address3}</td>
                    </tr>
                    <tr>
                        <td style="font-weight:bold" width="30%">Business Registration Date</td>
                        <td width="70%"><g:formatDate format="MM/dd/yyyy" date="${customerInstance?.businesses[0]?.registrationDate}" /></td>
                    </tr>
                    <tr>
                        <td style="font-weight:bold" width="30%">Fax No</td>
                        <td width="70%">${customerInstance?.businesses[0]?.faxNo}</td>
                    </tr>
                    <tr>
                        <td style="font-weight:bold" width="30%">Email Address</td>
                        <td width="70%">${customerInstance?.businesses[0]?.eMail}</td>
                    </tr>
                    <tr>
                        <td style="font-weight:bold" width="30%">Remittance</td>
                        <td width="70%">${customerInstance?.businesses[0]?.remittance}</td>
                    </tr>
                </tbody>
            </table> 
    </fieldset>
</div>