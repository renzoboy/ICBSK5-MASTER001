         <div class="row">
                 <div class="col-xs-12 col-sm-12">   
              <div class="section-container">
                <legend class="section-header">Addresses Information</legend>
                  <div class="table-responsive no-padding">
                      <table class="table table-hover">
                        <thead>
                          <tr>    
                              <th>Address Type</th>
                              <th>Full Address</th>

                              <th>Phone (1)</th>
                              <th>Phone (2)</th>
                              <th>Fax (1)</th>
                              <th>Fax (2)</th>
                              <th>Primary</th>
                              <th> Mailing</th>
                              <th>Owned</th>
                              <th>Mortgaged</th>
                          </tr>
                        </thead>
                        <g:each in="${customerInstance.addresses}" status="i" var="address">
                            <g:if test="${address.status.id==1 || address.status.id==2}">
                                <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
                                    <td>${fieldValue(bean: address, field: "type.description")}</td>
                                    <td>${fieldValue(bean: address, field: "address1")} ${fieldValue(bean: address, field: "address2")} ${fieldValue(bean: address, field: "town.description")} ${fieldValue(bean: address, field: "address3")}</td>
                                    <td>${fieldValue(bean: address, field: "phone1")}</td>
                                    <td>${fieldValue(bean: address, field: "phone2")}</td>
                                    <td>${fieldValue(bean: address, field: "phone3")}</td>
                                    <td>${fieldValue(bean: address, field: "phone4")}</td>
                                    <td>${fieldValue(bean: address, field: "isPrimary")}</td>
                                    <td>${fieldValue(bean: address, field: "isOwned")}</td>
                                    <td>${fieldValue(bean: address, field: "isMailing")}</td>
                                    <td>${fieldValue(bean: address, field: "isMortaged")}</td>
                                </tr>
                            </g:if>
                        </g:each>
                      </table>
                  </div> 
              </div><!-- end section-container -->
            </div>
            </div>