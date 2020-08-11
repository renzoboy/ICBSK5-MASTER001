<div class="section-container">
    <legend class="section-header" >Attachments</legend>
    <div class="table-responsive no-padding">
        <table class="table table-hover">
            <thead>
                <tr>    
                    <th>Attachment Type</th>
                    <th>Attachment Name</th> 
                </tr>
            </thead>
           <g:each in="${customerInstance.attachments}" status="i" var="attachment">
               <g:if test="${attachment.status.id==2}">
                   <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
                       <td>${fieldValue(bean: attachment, field: "type.description")}</td>
                       <td>
                           <div class="input-group">
                           ${fieldValue(bean: attachment, field: "fileName")}
                           <g:if test="${attachment?.id!=null}">
                               <span class="input-group-btn">
                                   <button type="button" class="btn btn-default 
                                      dropdown-toggle" data-toggle="dropdown">
                                      Action
                                      <span class="caret"></span>
                                   </button>
                                   <ul class="dropdown-menu">
                                      <li> <a target="_blank"href="${createLink(controller:'Attachment', action:'show', id: attachment?.id)}">View</a></li>
                                 <!--     <li> <a target="_blank"href="${createLink(controller:'Attachment', action:'download', id: attachment?.id)}">Download</a></li> -->
                                   </ul>
                               </span>
                           </g:if>
                           </div>
                       </td>

                    </tr>
               </g:if>
           </g:each>
       </table>
   </div> 
</div>