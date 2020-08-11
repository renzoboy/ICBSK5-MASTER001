<!--
  To change this license header, choose License Headers in Project Properties.
  To change this template file, choose Tools | Templates
  and open the template in the editor.
-->

<%@ page contentType="text/html;charset=UTF-8" %>

<g:hiddenField name="id" id="id" value="${relationInstance?.id}"/>
<g:hiddenField id="customer"name="customer.id" value="${relationInstance?.customer?.id}"/>
<g:if test="${!saved}">
    <div class="fieldcontain form-group ${hasErrors(bean: relationInstance, field: 'customer2', 'has-error')} required">
        <label class="control-label col-sm-4" for="customer2">
            <g:message code="relation.customer2.label" default="Related Customer" />
            <span class="required-indicator">*</span>
        </label>
        <div class="col-sm-8">
            <g:if test="${!disabled}">
                <input type="button" href="#"onclick="initializeAddRelationSearchModal();modal.show()"value="Search Customer"/>
            </g:if>
                <g:hiddenField id="customer2" name="customer2.id" value="${relationInstance?.customer2?.id}"/>
                <!--
                    <g:textField id="displayName2" width="150" name="customer2.displayName" disabled="${disabled}" value="${relationInstance?.customer2?.displayName}"/>
                --> 
                <g:message code="relation.customer2.label" default="${relationInstance?.customer2?.displayName}" />
                <g:hasErrors bean="${relationInstance}" field="customer2">
                    <div class="controls">
                        <span class="help-block">
                            <g:eachError bean="${relationInstance}" field="customer2">
                                <g:message error="${it}" /><br/>
                            </g:eachError>
                        </span>
                    </div>
               </g:hasErrors>    
        </div>
        
        <div class="fieldcontain form-group ${hasErrors(bean: relationInstance, field: 'status', 'has-error')} ">
            <label class="control-label col-sm-4" for="status">
                <g:message code="relation.status" default="Status" />
                <span class="required-indicator">*</span>
            </label>
            <div class="col-sm-8">
                    
                    <g:select id="status"  name="status.id" from="${icbs.lov.ConfigItemStatus.findAllByCodeOrCodeLike("010","990")}" optionKey="id" optionValue ="description" value="${relationInstance?.status?.id}" class="form-control"/>

                    <g:hasErrors bean="${relationInstance}" field="status">
                        <div class="controls">
                            <span class="help-block">
                                <g:eachError bean="${relationInstance}" field="status">
                                    <g:message error="${it}" /><br/>
                                </g:eachError>
                            </span>
                        </div>
                   </g:hasErrors>    
            </div>
        </div>    
        <div class="fieldcontain form-group ${hasErrors(bean: relationInstance, field: 'type', 'has-error')} ">
            <label class="control-label col-sm-4" for="type">
                <g:message code="relation.type.label" default="Relation Type " />

            </label>
            <div class="col-sm-8">
                    <g:if test="${customerRelationshipType==1}">
                        <g:select id="type" name="type.id"from="${icbs.lov.Lov.findAllByGroupCodeAndStatusAndItemCodeLike("CRT",true,"1%")}" optionKey="id" optionValue ="itemValue" value="${relationInstance?.type?.id}" class="form-control"/>
                    </g:if>
                    <g:if test="${customerRelationshipType!=1}">
                        <g:select id="type" name="type.id"from="${icbs.lov.Lov.findAllByGroupCodeAndStatusAndItemCodeLike("CRT",true,"2%")}" optionKey="id" optionValue ="itemValue" value="${relationInstance?.type?.id}" class="form-control"/>
                    </g:if>
                <g:hasErrors bean="${relationInstance}" field="type">
                    <div class="controls">
                        <span class="help-block">
                            <g:eachError bean="${relationInstance}" field="type">
                                <g:message error="${it}" /><br/>
                            </g:eachError>
                        </span>
                    </div>
               </g:hasErrors>    
            </div>
        </div>
    </div>
</g:if>
