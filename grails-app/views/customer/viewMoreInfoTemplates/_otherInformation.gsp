<div class="section-container">
    <fieldset>
      <legend class="section-header" >Other Information</legend>
          <table class="table table-bordered table-striped">
                <tbody>
                            <g:if test="${customerInstance?.religion}">
                                    <tr>
                                            <td style="font-weight:bold" width="30%">Religion</td>
                                            <td width="70%">${customerInstance?.religion?.description}</td>
                                    </tr>
                           </g:if>
                           <g:if test="${customerInstance?.noOfDependent}">
                                    <tr>
                                            <td  style="font-weight:bold" width="30%">No. of Dependents</td>
                                            <td width="70%">${customerInstance?.noOfDependent}</td>
                                    </tr>
                           </g:if>
                           <g:if test="${customerInstance?.motherMaidenName}">
                                    <tr>
                                            <td style="font-weight:bold" width="30%">Mother's Maiden Name</td>
                                            <td width="70%">${customerInstance?.motherMaidenName}</td>
                                   </tr>
                           </g:if>
                           <g:if test="${customerInstance?.fatherName}">
                                     <tr>
                                            <td style="font-weight:bold" width="30%">Father's Name</td>
                                            <td width="70%">${customerInstance?.fatherName}</td>
                                    </tr>
                          </g:if>
                           <g:if test="${customerInstance?.civilStatus?.id == 65}">
                                    <tr>
                                            <td style="font-weight:bold" width="30%">Spouse Name</td>
                                            <td width="70%">${customerInstance?.spouseLastName} , ${customerInstance?.spouseFirstName} ${customerInstance?.spouseMiddleName} </td>
                                    </tr>
                                    <tr>
                                            <td style="font-weight:bold" width="30%">Spouse Birth Date</td>
                                            <td width="70%"><g:formatDate format="MM/dd/yyyy" date="${customerInstance?.spouseBirthDate}" /></td>
                                    </tr>
                                    <tr>
                                            <td style="font-weight:bold" width="30%">Spouse Contact</td>
                                            <td width="70%">${customerInstance?.spouseContactNo}</td>
                                    </tr>
                           </g:if>
                </tbody>
            </table> 
    </fieldset>
</div>