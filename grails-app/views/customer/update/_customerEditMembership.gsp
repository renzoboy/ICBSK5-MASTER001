  <g:form id="customerUpdateMembershipForm" name="customerUpdateMembershipForm "url="[resource:customerInstance,action:'customerUpdateMembershipAjax']" method="POST"  class="form-horizontal" onsubmit="callLoadingDialog();">
                        <g:hiddenField name="id" id="id" value="${customerInstance?.id}"/>
                        <div class="form-group fieldcontain ${hasErrors(bean: customerInstance, field: 'membershipType', 'has-error')} ">
                            <label class="control-label col-sm-4"for="membershipType">
                                    <g:message code="membership.membershipType.label" default="Customer Membership" />
                            </label>
                            <div class="col-sm-8">
                                <g:select id="membershipType" name="membershipType" from="${icbs.lov.MembershipType.findAllByStatus('TRUE')}" optionKey="id" optionValue="description" value="${membership?.membershipType?.id}" noSelection="['null': '']" class="form-control"/>
                                <g:hasErrors bean="${customerInstance}" field="membershipType">
                                    <div class="controls">
                                        <span class="help-block">
                                            <g:eachError bean="${customerInstance}" field="membershipType">
                                                <g:message error="${it}" /><br/>
                                            </g:eachError>
                                        </span>
                                    </div>
                                </g:hasErrors>
                            </div>
                        </div>
                        <div class="form-group fieldcontain ${hasErrors(bean: customerInstance, field: 'membershipDate', 'has-error')} ">
                            <label class="control-label col-sm-4"for="membershipDate">
                                    <g:message code="membership.membershipDate.label" default="Date of Membership" />
                            </label>
                            <div class="col-sm-8">
                                <g:customDatePicker name="membershipDate" value="${membership?.membershipDate}" default="none" noSelection="['': '']" class="form-control"  />
                                <g:hasErrors bean="${customerInstance}" field="membershipDate">
                                    <div class="controls">
                                        <span class="help-block">
                                            <g:eachError bean="${customerInstance}" field="membershipDate">
                                                <g:message error="${it}" /><br/>
                                            </g:eachError>
                                        </span>
                                    </div>
                                </g:hasErrors>
                            </div>
                        </div>
                        <br>
                        <div class="form-group fieldcontain ${hasErrors(bean: customerInstance, field: 'refferedBy', 'has-error')} ">
                            <label class="control-label col-sm-4"for="refferedBy">
                                    <g:message code="membership.refferedBy.label" default="Reffered By" />
                            </label>
                            <div class="col-sm-8">
                                <g:field name="refferedBy" id="refferedBy" value="${membership ?. refferedBy}" required="" class="form-control"/>
                                <g:hasErrors bean="${customerInstance}" field="refferedBy">
                                    <div class="controls">
                                        <span class="help-block">
                                            <g:eachError bean="${customerInstance}" field="refferedBy">
                                                <g:message error="${it}" /><br/>
                                            </g:eachError>
                                        </span>
                                    </div>
                                </g:hasErrors>
                            </div>
                        </div>
                        <br>
                        <div class="form-group fieldcontain ${hasErrors(bean: customerInstance, field: 'relationship', 'has-error')} ">
                            <label class="control-label col-sm-4"for="refferedBy">
                                    <g:message code="membership.relationship.label" default="Relationship" />
                            </label>
                            <div class="col-sm-8">
                                 <g:select id="relationship" name="relationship" from="${icbs.lov.Lov.findAllByGroupCodeAndStatus('CRT','TRUE')}" optionKey="id" optionValue="itemValue" value="${membership?.relationship?.id}" default="none" noSelection="['': '']" class="form-control"/>
                                <g:hasErrors bean="${customerInstance}" field="relationship">
                                    <div class="controls">
                                        <span class="help-block">
                                            <g:eachError bean="${customerInstance}" field="relationship">
                                                <g:message error="${it}" /><br/>
                                            </g:eachError>
                                        </span>
                                    </div>
                                </g:hasErrors>
                            </div>
                        </div>
                </g:form>