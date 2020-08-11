<div class="section-container">
    <legend class="section-header" >Education Information</legend>
    <div class="table-responsive no-padding">
        <table class="table table-hover">
            <thead>
              <tr>    
                  <th>Education Type</th>
                  <th>School Name</th>
                  <th>Year Start</th>
                  <th>Year End</th>
                  <th>Degree</th>                                     
              </tr>
            </thead>
            <g:each in="${customerInstance.educations}" status="i" var="education">
                <g:if test="${education.status.id==2}">
                    <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
                        <td>${fieldValue(bean: education, field: "type.itemValue")}</td>
                        <td>${fieldValue(bean: education, field: "schoolAttended")}</td>
                        <td>${fieldValue(bean: education, field: "yearStart")}</td>
                        <td>${fieldValue(bean: education, field: "yearEnd")}</td>
                        <td>${fieldValue(bean: education, field: "educationDegree")}</td>
                     </tr>
                </g:if>     
            </g:each>
        </table>
    </div> 
</div>