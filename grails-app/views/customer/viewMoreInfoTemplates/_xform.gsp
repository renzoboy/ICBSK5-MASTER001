 <%@ page import="icbs.cif.Customer" %>
                <div class="navn-tabs-custom">
                  <div class="nav-tab-container nav-justified">
                    <ul class="nav nav-tabs">
                        <li class="active"><a id="tabLi12" href="#tab_12" data-toggle="tab">Other Information</a></li>
                        <li><a id="tabLi1" href="#tab_1" data-toggle="tab">Contact Information</a></li>
                        <li><a id="tabLi2" href="#tab_2" data-toggle="tab">Address Information</a></li> 
                        <li><a id="tabLi3" href="#tab_3" data-toggle="tab">Relations Information</a></li>
                        <li><a id="tabLi11" href="#tab_11" data-toggle="tab">Beneficial Owner Information</a></li>
                       
                        <g:if test="${customerInstance?.type?.id==1}">
                        <li><a id="tabLi4" href="#tab_4" data-toggle="tab">Educational Information</a></li>
                        </g:if>
                        <li><a id="tabLi5" href="#tab_5" data-toggle="tab">Other Accounts</a></li>
                        <li><a id="tabLi6" href="#tab_6" data-toggle="tab">Attachments</a></li>
                        <li><a id="tabLi7" href="#tab_7" data-toggle="tab">Record Tagging</a></li>
                        <li><a id="tabLi8" href="#tab_8" data-toggle="tab">Record Status and History Information</a></li>
                        <li><a id="tabLi9" href="#tab_9" data-toggle="tab">Business Information</a></li>
                        <li><a id="tabLi10" href="#tab_10" data-toggle="tab">Employment Information</a></li>
                        <li><a id="tabLi13" href="#tab_13" data-toggle="tab">Insurance Information</a></li>
                        <li><a id="tabLi14" href="#tab_14" data-toggle="tab">Membership Information</a></li>
                    </ul>
                  </div>
                    <div class="tab-content">
                        <div class="tab-pane active fade in table-responsive" id="tab_12">
                                <legend>Other Information</legend>
                                <g:render template="viewMoreInfoTemplates/otherInformation"/>
                        </div>
                        <div class="tab-pane" id="tab_1">
                                <legend>Contact Information</legend>
                                <g:render template="viewMoreInfoTemplates/contactInformation"/>
                        </div>
                        <div class="tab-pane" id="tab_2">
                                <legend>Address Information</legend>
                                <g:render template="viewMoreInfoTemplates/addressInformation"/>
                        </div>
                        <div class="tab-pane" id="tab_3">
                                <legend>Relations Information</legend>
                                <g:render template="viewMoreInfoTemplates/relationsInformation"/>
                        </div>
                        <div class="tab-pane" id="tab_11">
                                <legend>Beneficial Owner Information</legend>
                                <g:render template="viewMoreInfoTemplates/beneficiaryInformation"/>
                        </div>
                        <g:if test="${customerInstance?.type?.id==1}">
                        <div class="tab-pane" id="tab_4">
                                <legend>Educational Information</legend>
                                <g:render template="viewMoreInfoTemplates/educationalInformation"/>
                        </div>
                        </g:if>
                        <div class="tab-pane" id="tab_5">
                                <legend>Other Accounts</legend>
                                <g:render template="viewMoreInfoTemplates/otherAccounts"/>
                        </div>
                        <div class="tab-pane" id="tab_6">
                                <legend>Attachments</legend>
                                <g:render template="viewMoreInfoTemplates/attachments"/>
                        </div>
                        <div class="tab-pane" id="tab_7">
                                <legend>Record Tagging</legend>
                                <g:render template="viewMoreInfoTemplates/recordTagging"/>
                        </div>
                        <div class="tab-pane" id="tab_8">
                                <legend>Record Status and History Information</legend>
                                <g:render template="viewMoreInfoTemplates/recordStatHistInformation"/>
                        </div>
                        <div class="tab-pane" id="tab_9">
                                <legend>Business Information</legend>
                                <g:render template="viewMoreInfoTemplates/businessInformation"/>
                        </div>
                        <div class="tab-pane" id="tab_10">
                                <legend>Employment Information</legend>
                                <g:render template="viewMoreInfoTemplates/employmentInfo"/>
                        </div>
                        <div class="tab-pane" id="tab_13">
                                <legend>Insurance Information</legend>
                                <g:render template="viewMoreInfoTemplates/insuranceInformation"/>
                        </div>
                        <div class="tab-pane" id="tab_14">
                                <legend>Membership Information</legend>
                                <g:render template="viewMoreInfoTemplates/membershipInformation"/>
                        </div>
                    </div>
                </div>