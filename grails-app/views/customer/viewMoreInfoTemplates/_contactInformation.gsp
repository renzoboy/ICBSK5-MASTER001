<div class="section-container">
    <fieldset>
        
            <div class="table-responsive no-padding">
                <table class="table table-hover">
                    <thead>
                        <tr>    
                            <th>Contact Type</th>
                            <th>Contact Value</th>
                            <th>Primary Email</th>
                            <th>Primary Phone</th>
                        </tr>
                    </thead>
                    <g:each in="${customerInstance.contacts}" status="i" var="contact">
                        <g:if test="${contact?.status.id == 2}">
                            <tr>
                                <td>${fieldValue(bean: contact, field: "type.itemValue")}</td>
                                <td>${fieldValue(bean: contact, field: "contactValue")}</td>
                                <td>${fieldValue(bean: contact, field: "isPrimaryEmail")}</td>
                                <td>${fieldValue(bean: contact, field: "isPrimaryPhone")}</td>
                            </tr>
                        </g:if>
                    </g:each>
                </table>
            </div>
    </fieldset>
</div> 