<!--
  To change this license header, choose License Headers in Project Properties.
  To change this template file, choose Tools | Templates
  and open the template in the editor.
-->
<%@ page contentType="text/html;charset=UTF-8" %>
<div id="beneficiary${i}" class="beneficiary-div">
    <g:if test="${beneficiary?.id}">
        <g:hiddenField name='beneficiaries[${i}].id' value="${beneficiary?.id}"/>
        <g:hiddenField name='beneficiaries[${i}].new' value="false"/>
    </g:if>
    <g:else>
        <g:hiddenField name='beneficiaries[${i}].new' value="true"/>
    </g:else>
    <g:hiddenField name='beneficiaries[${i}].deleted' value='false'/>
    
    <div class="form-group fieldcontain ${hasErrors(bean: customerInstance, field: 'beneficiaries['+i+'].firstName', 'has-error')} ">
	<label class="control-label col-sm-4" for="beneficiaries[${i}].firstName">
		<g:message code="beneficiary.firstName.label" default="First Name" />
		
	</label>
	<div class="col-sm-8">
            <g:textField name="beneficiaries[${i}].firstName" value="${beneficiary?.firstName}"class="form-control"/>
            <g:hasErrors bean="${customerInstance}" field="beneficiaries[${i}].firstName">
                <div class="controls">
                    <span class="help-block">
                        <g:eachError bean="${customerInstance}" field="beneficiaries[${i}].firstName">
                            <g:message error="${it}" /><br/>
                        </g:eachError>
                    </span>
                </div>
            </g:hasErrors>
        </div>
    </div>
    <div class="form-group fieldcontain ${hasErrors(bean: customerInstance, field: 'beneficiaries['+i+'].middleName', 'has-error')} ">
	<label class="control-label col-sm-4" for="beneficiaries[${i}].middleName">
		<g:message code="beneficiary.middleName.label" default="Middle Name" />
		
	</label>
	<div class="col-sm-8">
            <g:textField name="beneficiaries[${i}].middleName" value="${beneficiary?.middleName}"class="form-control"/>
            <g:hasErrors bean="${customerInstance}" field="beneficiaries[${i}].middleName">
                <div class="controls">
                    <span class="help-block">
                        <g:eachError bean="${customerInstance}" field="beneficiaries[${i}].middleName">
                            <g:message error="${it}" /><br/>
                        </g:eachError>
                    </span>
                </div>
            </g:hasErrors>
        </div>
    </div>
    <div class="form-group fieldcontain ${hasErrors(bean: customerInstance, field: 'beneficiaries['+i+'].lastName', 'has-error')} ">
	<label class="control-label col-sm-4" for="beneficiaries[${i}].lastName">
		<g:message code="beneficiary.lastName.label" default="Last Name" />
		
	</label>
	<div class="col-sm-8">
            <g:textField name="beneficiaries[${i}].lastName" value="${beneficiary?.lastName}"class="form-control"/>
            <g:hasErrors bean="${customerInstance}" field="beneficiaries[${i}].lastName">
                <div class="controls">
                    <span class="help-block">
                        <g:eachError bean="${customerInstance}" field="beneficiaries[${i}].lastName">
                            <g:message error="${it}" /><br/>
                        </g:eachError>
                    </span>
                </div>
            </g:hasErrors>
        </div>
    </div>
    <div class="form-group fieldcontain ${hasErrors(bean: customerInstance, field: 'beneficiaries['+i+'].suffixName', 'has-error')} ">
	<label class="control-label col-sm-4" for="beneficiaries[${i}].suffixName">
		<g:message code="beneficiary.suffixName.label" default="Suffix Name" />
		
	</label>
	<div class="col-sm-8">
            <g:textField name="beneficiaries[${i}].suffixName" value="${beneficiary?.suffixName}"class="form-control"/>
            <g:hasErrors bean="${customerInstance}" field="beneficiaries[${i}].suffixName">
                <div class="controls">
                    <span class="help-block">
                        <g:eachError bean="${customerInstance}" field="beneficiaries[${i}].suffixName">
                            <g:message error="${it}" /><br/>
                        </g:eachError>
                    </span>
                </div>
            </g:hasErrors>
        </div>
    </div>
    <div class="form-group fieldcontain ${hasErrors(bean: customerInstance, field: 'beneficiaries['+i+'].birthDate', 'has-error')} ">
	<label class="control-label col-sm-4" for="beneficiaries[${i}].birthDate">
		<g:message code="beneficiary.birthDate.label" default="Bith Date" />
	</label>
	<div class="col-sm-8">
            <g:customDatePicker name="beneficiaries[${i}].birthDate" precision="day"  value="${beneficiary?.birthDate}" default="none" noSelection="['': '']" class="form-control"/>
            <g:hasErrors bean="${customerInstance}" field="beneficiaries[${i}].birthDate">
                <div class="controls">
                    <span class="help-block">
                        <g:eachError bean="${customerInstance}" field="beneficiaries[${i}].birthDate">
                            <g:message error="${it}" /><br/>
                        </g:eachError>
                    </span>
                </div>
            </g:hasErrors>
        </div>
    </div>
    <div class="form-group fieldcontain ${hasErrors(bean: customerInstance, field: 'beneficiaries['+i+'].customerRelationship', 'has-error')} ">
	<label class="control-label col-sm-4" for="beneficiaries[${i}].customerRelationship">
		<g:message code="beneficiary.customerRelationship.label" default="Relationship" />
	</label>
	<div class="col-sm-8">
            <g:select id="beneficiaries[${i}].customerRelationship" name="beneficiaries[${i}].customerRelationship.id" from="${icbs.lov.Lov.findAllByGroupCodeAndStatus('CRT','TRUE')}" optionKey="id" optionValue="itemValue" value="${beneficiary?.customerRelationship?.id}" class="form-control"/>
            <g:hasErrors bean="${customerInstance}" field="beneficiaries[${i}].customerRelationship">
                <div class="controls">
                    <span class="help-block">
                        <g:eachError bean="${customerInstance}" field="beneficiaries[${i}].customerRelationship">
                            <g:message error="${it}" /><br/>
                        </g:eachError>
                    </span>
                </div>
            </g:hasErrors>
        </div>
    </div>
    <br></br>
    
    <g:if test="${i!=0}">
        <div class="form-group form-buttons">
            <button type="button" class="btn btn-danger field-btn-delete" onClick="icbs.Customer.Form.Utilities.bindDelete(this,'.beneficiary-div');"><span class="fa fa-minus" ></span> Remove</button>
        </div>
    </g:if>
</div> 

