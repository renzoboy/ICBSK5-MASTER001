<div class="section-container">
    <fieldset>
      <legend class="section-header" >Membership Information</legend>
          <table class="table table-bordered table-striped">
                <tbody>
                    <tr>
                        <td style="font-weight:bold" width="30%">Membership Type</td>
                        <td width="70%">${customerInstance?.membership?.membershipType?.description}</td>
                    </tr>
                    <tr>
                        <td style="font-weight:bold" width="30%">Date of Membership</td>
                        <td width="70%"><g:formatDate format="MM/dd/yyyy" date="${customerInstance?.membership?.membershipDate}" /></td>
                    </tr>
                    <tr>
                        <td style="font-weight:bold" width="30%">Reffered By</td>
                        <td width="70%">${customerInstance?.membership?.refferedBy}</td>
                    </tr>
                    <tr>
                        <td style="font-weight:bold" width="30%">Relationship</td>
                        <td width="70%">${customerInstance?.membership?.relationship?.itemValue}</td>
                    </tr>
                    <tr>
                        <td style="font-weight:bold" width="30%">Date Created</td>
                        <td width="70%"><g:formatDate format="MM/dd/yyyy" date="${customerInstance?.membership?.dateCreated}" /></td>
                    </tr>
                    <tr>
                        <td style="font-weight:bold" width="30%">Created By</td>
                        <td width="70%">${customerInstance?.membership?.createdBy?.username}</td>
                    </tr>
                    <tr>
                        <td style="font-weight:bold" width="30%">Status</td>
                        <td width="70%">${customerInstance?.membership?.status?.description}</td>
                    </tr>
                </tbody>
            </table> 
    </fieldset>
</div>