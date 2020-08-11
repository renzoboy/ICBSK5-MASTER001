<div class="section-container">
    <fieldset>
        <legend class="section-header" >Record Status and History Information</legend>
         <table class="table table-bordered table-striped">
                <tbody>
                    <tr>
                        <td style="font-weight:bold" width="30%">Record Status</td>
                        <td width="70%">${customerInstance?.status?.description}</td>
                    </tr>
                    <tr>
                        <td style="font-weight:bold" width="30%">Created</td>
                        <td width="70%"><g:formatDate format="MM/dd/yyyy" date="${customerInstance?.createdAt}" /></td>
                    </tr>
                    <tr>
                        <td style="font-weight:bold" width="30%">Last Updated By</td>
                        <td width="70%">${customerInstance?.lastUpdatedBy?.username}</td>
                    </tr>
                    <tr>
                        <td style="font-weight:bold" width="30%">Last Updated On</td>
                        <td width="70%"><g:formatDate format="MM/dd/yyyy" date="${customerInstance?.lastUpdatedAt}" /></td>
                    </tr>
                </tbody>
            </table>    
   </fieldset>
</div>