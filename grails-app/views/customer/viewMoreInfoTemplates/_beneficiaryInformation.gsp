<div class="section-container">
                <g:if test="${customerInstance?.type?.id==1}">
                    <legend class="section-header" >Beneficial Owner Information</legend>
                </g:if>
                <div class="table-responsive no-padding">
                    <table class="table table-hover">
                        <thead>
                          <tr>    
                              <th>First Name</th>
                              <th>Middle Name</th>
                              <th>Last Name</th>
                              <th>Suffix Name</th>
                              <th>Birth Date</th>
                              <th>Relationship</th> 
                              
                          </tr>
                        </thead>
                        <g:each in="${icbs.cif.Beneficiary.findAllByCustomer(customerInstance)}" status="i" var="beneficiaries">
                           
                                <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
                                    <td>${fieldValue(bean: beneficiaries, field: "firstName")}</td>
                                    <td>${fieldValue(bean: beneficiaries, field: "middleName")}</td>
                                    <td>${fieldValue(bean: beneficiaries, field: "lastName")}</td>
                                    <td>${fieldValue(bean: beneficiaries, field: "suffixName")}</td>
                                    <td><g:formatDate format="MM/dd/yyyy" date="${beneficiaries?.birthDate}" /></td>
                                    <td>${beneficiaries?.customerRelationship?.itemValue}</td>
                                 </tr>
                            
                        </g:each>
                    </table>
                </div> 
</div>