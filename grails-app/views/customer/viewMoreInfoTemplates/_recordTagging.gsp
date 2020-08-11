<div class="section-container">
    <fieldset>
        <legend class="section-header" >Record Tagging</legend>
            <table class="table table-bordered table-striped">
                <tbody>
                    <tr>
                        <td style="font-weight:bold" width="30%">PEP Description</td>
                        <td width="70%">${customerInstance?.pepDescription}</td>
                    </tr>
                    <tr>
                        <td style="font-weight:bold" width="30%">Verified AMLA Blocked person</td>
                        <td width="70%">${customerInstance?.amla}</td>
                    </tr>
                    <tr>
                        <td style="font-weight:bold" width="30%">Source of Income</td>
                        <td width="70%">${customerInstance?.sourceOfIncome}</td>
                    </tr>
                    <tr>
                        <td style="font-weight:bold" width="30%">Size of Firm</td>
                        <td width="70%">${customerInstance?.customerCode3?.description}</td>
                    </tr>
                    <tr>
                        <td style="font-weight:bold" width="30%">Risk Classification</td>
                        <td width="70%">${customerInstance?.customerCode2?.description}</td>
                    </tr>
                    <tr>
                        <td style="font-weight:bold" width="30%">Type of Resident</td>
                        <td width="70%">${customerInstance?.customerCode1?.description}</td>
                    </tr>
                </tbody>
            </table>    
    </fieldset>
</div> 