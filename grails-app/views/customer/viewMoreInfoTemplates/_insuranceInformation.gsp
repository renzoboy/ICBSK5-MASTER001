<div class="section-container">
    <fieldset>
      <legend class="section-header" >Insurance Information</legend>
          <table class="table table-bordered table-striped">
                <tbody>
                    <tr>
                        <td style="font-weight:bold" width="30%">Life Insurance</td>
                        <td width="70%">${customerInstance?.insurances[0]?.lifeInsurance}</td>
                    </tr>
                    <tr>
                        <td style="font-weight:bold" width="30%">Date of Remittance</td>
                        <td width="70%"><g:formatDate format="MM/dd/yyyy" date="${customerInstance?.insurances[0]?.lifeDateOfRemittance}" /></td>
                    </tr>
                    <tr>
                        <td style="font-weight:bold" width="30%">PCIC</td>
                        <td width="70%">${customerInstance?.insurances[0]?.pcic}</td>
                    </tr>
                    <tr>
                        <td style="font-weight:bold" width="30%">Date of Remittance</td>
                        <td width="70%"><g:formatDate format="MM/dd/yyyy" date="${customerInstance?.insurances[0]?.pcicDateOfRemittance}" /></td>
                   </tr>
                    <tr>
                        <td style="font-weight:bold" width="30%">Member's Benefit Program</td>
                        <td width="70%">${customerInstance?.insurances[0]?.memBenefitProgram}</td>
                    </tr>
                    <tr>
                        <td style="font-weight:bold" width="30%">Date of Remittance</td>
                        <td width="70%"><g:formatDate format="MM/dd/yyyy" date="${customerInstance?.insurances[0]?.memDateOfRemittance}" /></td>
                     </tr>
                    <tr>
                        <td style="font-weight:bold" width="30%">AGFP</td>
                        <td width="70%">${customerInstance?.insurances[0]?.agfp}</td>
                    </tr>
                    <tr>
                        <td style="font-weight:bold" width="30%">Date of Remittance</td>
                        <td width="70%"><g:formatDate format="MM/dd/yyyy" date="${customerInstance?.insurances[0]?.agfpDateOfRemitance}" /></td>
                    </tr>
                    <tr>
                        <td style="font-weight:bold" width="30%">Fire Insurance</td>
                        <td width="70%">${customerInstance?.insurances[0]?.fireInsurance}</td>
                    </tr>
                    <tr>
                        <td style="font-weight:bold" width="30%">Date of Remittance</td>
                        <td width="70%"><g:formatDate format="MM/dd/yyyy" date="${customerInstance?.insurances[0]?.fireDateOfRemittance}" /></td>
                    </tr>
                </tbody>
            </table> 
    </fieldset>
</div>