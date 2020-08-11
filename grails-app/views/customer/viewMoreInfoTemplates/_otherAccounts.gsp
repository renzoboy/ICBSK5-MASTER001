<div class="section-container">
    <legend class="section-header" >Other Accounts</legend>
    <div class="table-responsive no-padding">
        <table class="table table-hover">
            <thead>
              <tr>    
                  <th>Other Acct Type</th>
                  <th>Bank Name</th>
                  <th>Branch Name</th>
                  <th>Acct No</th>
                  <th>Joint Acct</th> 
                  <th>Year Obtained</th>
                  <th>Payed</th>      
              </tr>
            </thead>
            <g:each in="${customerInstance.otheraccts}" status="i" var="otherAcct">
                <g:if test="${otherAcct.status.id==2}">
                    <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
                        <td>${fieldValue(bean: otherAcct, field: "type.description")}</td>
                        <td>${fieldValue(bean: otherAcct, field: "bankName")}</td>
                        <td>${fieldValue(bean: otherAcct, field: "branchName")}</td>
                        <td>${fieldValue(bean: otherAcct, field: "acctNo")}</td>
                        <td>${fieldValue(bean: otherAcct, field: "isOtherAcctJoint")}</td>
                        <td>${fieldValue(bean: otherAcct, field: "yearObtained")}</td>
                        <td>${fieldValue(bean: otherAcct, field: "isPayed")}</td>
                     </tr>
                </g:if>
            </g:each>
        </table>
    </div> 
</div>