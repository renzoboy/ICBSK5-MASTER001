<div class="section-container">
    <fieldset>
      <legend class="section-header" >Employment Information</legend>
          <table class="table table-bordered table-striped">
                <tbody>
                    <tr>
                        <td style="font-weight:bold" width="30%">Employer Name</td>
                        <td width="70%">${customerInstance?.employments[0]?.employerName}</td>
                    </tr>
                    <tr>
                        <td style="font-weight:bold" width="30%">Employer Address</td>
                        <td width="70%">${customerInstance?.employments[0]?.address1} ${customerInstance?.employments[0]?.address2} ${customerInstance?.employments[0]?.address3}</td>
                    </tr>
                    <tr>
                        <td style="font-weight:bold" width="30%">Year Start</td>
                        <td width="70%">${customerInstance?.employments[0]?.yearStart}</td>
                    </tr>
                    <tr>
                        <td style="font-weight:bold" width="30%">Year End</td>
                        <td width="70%">${customerInstance?.employments[0]?.yearEnd}</td>
                    </tr>
                    <tr>
                        <td style="font-weight:bold" width="30%">Designation</td>
                        <td width="70%">${customerInstance?.employments[0]?.designation}</td>
                    </tr>
                    <tr>
                        <td style="font-weight:bold" width="30%">Employment Id No</td>
                        <td width="70%">${customerInstance?.employments[0]?.employmentId}</td>
                    </tr>
                    <tr>
                        <td style="font-weight:bold" width="30%">DEPED Id</td>
                        <td width="70%">${customerInstance?.employments[0]?.depedEmploymentId}</td>
                    </tr>
                    <tr>
                        <td style="font-weight:bold" width="30%">Region</td>
                        <td width="70%">${customerInstance?.employments[0]?.region?.itemValue}</td>
                    </tr>
                    <tr>
                        <td style="font-weight:bold" width="30%">Contact No</td>
                        <td width="70%">${customerInstance?.employments[0]?.contactNo}</td>
                    </tr>
                     <tr>
                        <td style="font-weight:bold" width="30%">Fax No</td>
                        <td width="70%">${customerInstance?.employments[0]?.faxNo}</td>
                    </tr>
                    <tr>
                        <td style="font-weight:bold" width="30%">Email</td>
                        <td width="70%">${customerInstance?.employments[0]?.eMail}</td>
                    </tr>
                    <tr>
                        <td style="font-weight:bold" width="30%">Monthly Gross Income</td>
                        <td width="70%"><g:formatNumber format="###,###,##0.00" number="${customerInstance?.employments[0]?.monthlyIncome}"/></td>
                    </tr>
                    <tr>
                        <td style="font-weight:bold" width="30%">Salary</td>
                        <td width="70%"><g:formatNumber format="###,###,##0.00" number="${customerInstance?.employments[0]?.salary}"/></td>
                    </tr>
                </tbody>
            </table> 
    </fieldset>
</div>