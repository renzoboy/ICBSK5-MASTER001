<div class="section-container">
                <g:if test="${customerInstance?.type?.id==1}"><legend class="section-header" >Relations Information</legend></g:if>
                <g:if test="${customerInstance?.type?.id!=1}"><legend class="section-header" >Company Connections Information</legend></g:if>
                <div class="table-responsive no-padding">
                    <table class="table table-hover">
                        <thead>
                          <tr>    
                              <th>Relation Type</th>
                              <th>Customer Id</th>
                              <th>First Name</th>
                              <th>Middle Name</th>
                              <th>Last Name</th> 
                              <th>Nickname</th>
                          </tr>
                        </thead>
                        <g:each in="${customerInstance.relations}" status="i" var="relation">
                            <g:if test="${relation.status.id==2}">
                                <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
                                    <td>${fieldValue(bean: relation, field: "type.itemValue")}</td>
                                    <td>${fieldValue(bean: relation, field: "customer2.customerId")}</td>
                                    <td>${fieldValue(bean: relation, field: "customer2.name1")}</td>
                                    <td>${fieldValue(bean: relation, field: "customer2.name2")}</td>
                                    <td>${fieldValue(bean: relation, field: "customer2.name3")}</td>
                                    <td>${fieldValue(bean: relation, field: "customer2.name4")}</td>
                                 </tr>
                            </g:if>
                        </g:each>
                    </table>
                </div> 
</div>