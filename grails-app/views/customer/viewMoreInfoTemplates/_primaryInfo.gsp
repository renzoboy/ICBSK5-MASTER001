<div class="row">
    <div class="col-xs-12 col-sm-12">
      <div class="section-container">
        <fieldset>
            <legend class="section-header">Primary Information</legend>
            <div class="infowrap">
                 <div class="col-xs-3 col-sm-3">
                    <div style="margin:auto; padding:20px;"><g:if test="${(customerInstance?.attachments?.find{it.isPrimaryPhoto==true})?.id}"> <img width="160px" height="160px"src="${createLink(controller:'Attachment', action:'show', id: (customerInstance?.attachments?.find{it.isPrimaryPhoto==true})?.id )}"/></g:if></div>
                 </div>
                <div class="col-xs-12 col-sm-8">
                    <g:if test="${customerInstance?.type.id==1}">
                            <g:if test="${customerInstance?.name5}">
                                        <h3 style="font-weight:bold;">${customerInstance?.name3} ${customerInstance?.name5?.itemValue}, ${customerInstance?.name1} ${customerInstance?.name2}</h3>
                                        <p><i>(Last Name, Suffix Name, First Name, Middle Name)</i></p>
                           </g:if>
                           <g:else>
                                        <h3 style="font-weight:bold;">${customerInstance?.name3}, ${customerInstance?.name1} ${customerInstance?.name2}</h3>
                                        <p><i>(Last Name, First Name, Middle Name)</i></p>
                           </g:else>
                        <g:if test="${customerInstance?.displayName}">
                            <dl class="dl-horizontal">
                                <dt>Display Name</dt>
                                <dd>${customerInstance?.displayName}</dd>
                            </dl>
                        </g:if>
                        <g:if test="${customerInstance?.title?.itemValue}">
                            <dl class="dl-horizontal">
                                <dt>Title</dt>
                                <dd>${customerInstance?.title?.itemValue}</dd>
                            </dl>
                        </g:if>
                        <g:if test="${customerInstance?.name4}">
                            <dl class="dl-horizontal">
                               <dt>Nickname</dt>
                               <dd>${customerInstance?.name4}</dd>
                            </dl>
                        </g:if>
                        <g:if test="${customerInstance?.gender}">
                            <dl class="dl-horizontal">
                                <dt>Gender</dt>
                                <dd>${customerInstance?.gender?.description}</dd>
                            </dl>
                        </g:if>
                        <g:if test="${customerInstance?.birthDate}">
                            <dl class="dl-horizontal">
                                <dt>Date of Birth</dt>
                                <dd>${customerInstance?.birthDate?.format("MM/dd/yyyy")}</dd>
                            </dl>
                        </g:if>
                    </g:if>
                    <g:else>
                        <g:if test="${customerInstance?.name1}">
                            <dl class="dl-horizontal">
                                <dt>Company Name</dt>
                                <dd>${customerInstance?.name1}</dd>
                            </dl>
                        </g:if>
                        <g:if test="${customerInstance?.birthDate}">
                            <dl class="dl-horizontal">
                                <dt>Registration Date</dt>
                                <dd>${customerInstance?.birthDate?.format("MM/dd/yyyy")}</dd>
                            </dl>
                        </g:if>
                    </g:else>
                        <g:if test="${customerInstance?.customerId}">
                            <dl class="dl-horizontal">
                              <dt>Customer ID</dt>
                              <dd>${customerInstance?.customerId}</dd>
                            </dl>
                        </g:if>
                        <g:if test="${customerInstance?.type}">
                            <dl  class="dl-horizontal">
                               <dt>Customer Type</dt>
                                <dd>${customerInstance?.type?.description}</dd>
                            </dl>
                        </g:if>
                        <g:if test="${customerInstance?.civilStatus}">
                            <g:if test="${customerInstance?.type}">
                                <dl class="dl-horizontal">
                                    <dt>Civil Status</dt>
                                    <dd>${customerInstance?.civilStatus?.itemValue}</dd>
                                </dl>
                            </g:if>
                            <g:if test="${customerInstance?.birthPlace}">
                                <dl class="dl-horizontal">
                                    <dt>Birth Place</dt>
                                    <dd>${customerInstance?.birthPlace}</dd>
                                </dl>
                            </g:if>
                            <g:if test="${customerInstance?.nationality}">
                                <dl class="dl-horizontal">
                                    <dt>Nationality</dt>
                                    <dd>${customerInstance?.nationality?.itemValue}</dd>
                                </dl>
                            </g:if>
                        </g:if>   
                </div>    
        </fieldset>
      </div><!-- end section-container-->
    </div><!-- end of column -->
</div> <!-- end of row-->