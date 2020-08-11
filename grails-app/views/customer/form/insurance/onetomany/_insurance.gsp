<!--
  To change this license header, choose License Headers in Project Properties.
  To change this template file, choose Tools | Templates
  and open the template in the editor.
-->
<%@ page contentType="text/html;charset=UTF-8" %>
<div id="insurance${i}" class="insurance-div">
    <g:if test="${insurance?.id}">
        <g:hiddenField name='insurances[${i}].id' value="${insurance?.id}"/>
        <g:hiddenField name='insurances[${i}].new' value="false"/>
    </g:if>
    <g:else>
        <g:hiddenField name='insurances[${i}].new' value="true"/>
    </g:else>
    <g:hiddenField name='insurances[${i}].deleted' value='false'/>
    
    <div class="form-group fieldcontain ${hasErrors(bean: customerInstance, field: 'insurances['+i+'].lifeInsurance', 'has-error')} ">
	<label class="control-label col-sm-4" for="insurances[${i}].lifeInsurance">
		<g:message code="insurance.lifeInsurance.label" default="Life Insurance" />
		
	</label>
	<div class="col-sm-8">
            <g:textField name="insurances[${i}].lifeInsurance" value="${insurance?.lifeInsurance}"class="form-control"/>
            <g:hasErrors bean="${customerInstance}" field="insurances[${i}].lifeInsurance">
                <div class="controls">
                    <span class="help-block">
                        <g:eachError bean="${customerInstance}" field="insurances[${i}].lifeInsurance">
                            <g:message error="${it}" /><br/>
                        </g:eachError>
                    </span>
                </div>
            </g:hasErrors>
        </div>
    </div>
    <div class="form-group fieldcontain ${hasErrors(bean: customerInstance, field: 'insurances['+i+'].lifeDateOfRemittance', 'has-error')} ">
	<label class="control-label col-sm-4" for="insurances[${i}].lifeDateOfRemittance">
		<g:message code="insurance.lifeDateOfRemittance.label" default="Date of Remittance" />
	</label>
	<div class="col-sm-8">
            <g:customDatePicker name="insurances[${i}].lifeDateOfRemittance" precision="day"  value="${insurance?.lifeDateOfRemittance}" default="none" noSelection="['': '']" class="form-control"/>
            <g:hasErrors bean="${customerInstance}" field="insurances[${i}].lifeDateOfRemittance">
                <div class="controls">
                    <span class="help-block">
                        <g:eachError bean="${customerInstance}" field="insurances[${i}].lifeDateOfRemittance">
                            <g:message error="${it}" /><br/>
                        </g:eachError>
                    </span>
                </div>
            </g:hasErrors>
        </div>
    </div>
    <br>
    
    <div class="form-group fieldcontain ${hasErrors(bean: customerInstance, field: 'insurances['+i+'].pcic', 'has-error')} ">
	<label class="control-label col-sm-4" for="insurances[${i}].pcic">
		<g:message code="insurance.pcic.label" default="PCIC" />
		
	</label>
	<div class="col-sm-8">
            <g:textField name="insurances[${i}].pcic" value="${insurance?.pcic}"class="form-control"/>
            <g:hasErrors bean="${customerInstance}" field="insurances[${i}].pcic">
                <div class="controls">
                    <span class="help-block">
                        <g:eachError bean="${customerInstance}" field="insurances[${i}].pcic">
                            <g:message error="${it}" /><br/>
                        </g:eachError>
                    </span>
                </div>
            </g:hasErrors>
        </div>
    </div>
    <div class="form-group fieldcontain ${hasErrors(bean: customerInstance, field: 'insurances['+i+'].pcicDateOfRemittance', 'has-error')} ">
	<label class="control-label col-sm-4" for="insurances[${i}].pcicDateOfRemittance">
		<g:message code="insurance.pcicDateOfRemittance.label" default="Date of Remittance" />
	</label>
	<div class="col-sm-8">
            <g:customDatePicker name="insurances[${i}].pcicDateOfRemittance" precision="day"  value="${insurance?.pcicDateOfRemittance}" default="none" noSelection="['': '']" class="form-control"/>
            <g:hasErrors bean="${customerInstance}" field="insurances[${i}].pcicDateOfRemittance">
                <div class="controls">
                    <span class="help-block">
                        <g:eachError bean="${customerInstance}" field="insurances[${i}].pcicDateOfRemittance">
                            <g:message error="${it}" /><br/>
                        </g:eachError>
                    </span>
                </div>
            </g:hasErrors>
        </div>
    </div> 
    <br>
    
    <div class="form-group fieldcontain ${hasErrors(bean: customerInstance, field: 'insurances['+i+'].memBenefitProgram', 'has-error')} ">
	<label class="control-label col-sm-4" for="insurances[${i}].memBenefitProgram">
		<g:message code="insurance.memBenefitProgram.label" default="Member's Benefit Program" />
		
	</label>
	<div class="col-sm-8">
            <g:textField name="insurances[${i}].memBenefitProgram" value="${insurance?.memBenefitProgram}"class="form-control"/>
            <g:hasErrors bean="${customerInstance}" field="insurances[${i}].memBenefitProgram">
                <div class="controls">
                    <span class="help-block">
                        <g:eachError bean="${customerInstance}" field="insurances[${i}].memBenefitProgram">
                            <g:message error="${it}" /><br/>
                        </g:eachError>
                    </span>
                </div>
            </g:hasErrors>
        </div>
    </div>
    <div class="form-group fieldcontain ${hasErrors(bean: customerInstance, field: 'insurances['+i+'].memDateOfRemittance', 'has-error')} ">
	<label class="control-label col-sm-4" for="insurances[${i}].memDateOfRemittance">
		<g:message code="insurance.memDateOfRemittance.label" default="Date of Remittance" />
	</label>
	<div class="col-sm-8">
            <g:customDatePicker name="insurances[${i}].memDateOfRemittance" precision="day"  value="${insurance?.memDateOfRemittance}" default="none" noSelection="['': '']" class="form-control"/>
            <g:hasErrors bean="${customerInstance}" field="insurances[${i}].memDateOfRemittance">
                <div class="controls">
                    <span class="help-block">
                        <g:eachError bean="${customerInstance}" field="insurances[${i}].memDateOfRemittance">
                            <g:message error="${it}" /><br/>
                        </g:eachError>
                    </span>
                </div>
            </g:hasErrors>
        </div>
    </div>
    <br>
    
    <div class="form-group fieldcontain ${hasErrors(bean: customerInstance, field: 'insurances['+i+'].agfp', 'has-error')} ">
	<label class="control-label col-sm-4" for="insurances[${i}].agfp">
		<g:message code="insurance.agfp.label" default="AGFP" />
		
	</label>
	<div class="col-sm-8">
            <g:textField name="insurances[${i}].agfp" value="${insurance?.agfp}"class="form-control"/>
            <g:hasErrors bean="${customerInstance}" field="insurances[${i}].agfp">
                <div class="controls">
                    <span class="help-block">
                        <g:eachError bean="${customerInstance}" field="insurances[${i}].agfp">
                            <g:message error="${it}" /><br/>
                        </g:eachError>
                    </span>
                </div>
            </g:hasErrors>
        </div>
    </div>
    <div class="form-group fieldcontain ${hasErrors(bean: customerInstance, field: 'insurances['+i+'].agfpDateOfRemitance', 'has-error')} ">
	<label class="control-label col-sm-4" for="insurances[${i}].agfpDateOfRemitance">
		<g:message code="insurance.agfpDateOfRemitance.label" default="Date of Remittance" />
	</label>
	<div class="col-sm-8">
            <g:customDatePicker name="insurances[${i}].agfpDateOfRemitance" precision="day"  value="${insurance?.agfpDateOfRemitance}" default="none" noSelection="['': '']" class="form-control"/>
            <g:hasErrors bean="${customerInstance}" field="insurances[${i}].agfpDateOfRemitance">
                <div class="controls">
                    <span class="help-block">
                        <g:eachError bean="${customerInstance}" field="insurances[${i}].agfpDateOfRemitance">
                            <g:message error="${it}" /><br/>
                        </g:eachError>
                    </span>
                </div>
            </g:hasErrors>
        </div>
    </div>
    <br>
    
    <div class="form-group fieldcontain ${hasErrors(bean: customerInstance, field: 'insurances['+i+'].fireInsurance', 'has-error')} ">
	<label class="control-label col-sm-4" for="insurances[${i}].fireInsurance">
		<g:message code="insurance.fireInsurance.label" default="Fire Insurance" />
		
	</label>
	<div class="col-sm-8">
            <g:textField name="insurances[${i}].fireInsurance" value="${insurance?.fireInsurance}"class="form-control"/>
            <g:hasErrors bean="${customerInstance}" field="insurances[${i}].fireInsurance">
                <div class="controls">
                    <span class="help-block">
                        <g:eachError bean="${customerInstance}" field="insurances[${i}].fireInsurance">
                            <g:message error="${it}" /><br/>
                        </g:eachError>
                    </span>
                </div>
            </g:hasErrors>
        </div>
    </div>
    <div class="form-group fieldcontain ${hasErrors(bean: customerInstance, field: 'insurances['+i+'].fireDateOfRemittance', 'has-error')} ">
	<label class="control-label col-sm-4" for="insurances[${i}].fireDateOfRemittance">
		<g:message code="insurance.fireDateOfRemittance.label" default="Date of Remittance" />
	</label>
	<div class="col-sm-8">
            <g:customDatePicker name="insurances[${i}].fireDateOfRemittance" precision="day"  value="${insurance?.fireDateOfRemittance}" default="none" noSelection="['': '']" class="form-control"/>
            <g:hasErrors bean="${customerInstance}" field="insurances[${i}].fireDateOfRemittance">
                <div class="controls">
                    <span class="help-block">
                        <g:eachError bean="${customerInstance}" field="insurances[${i}].fireDateOfRemittance">
                            <g:message error="${it}" /><br/>
                        </g:eachError>
                    </span>
                </div>
            </g:hasErrors>
        </div>
    </div>
    
    
    
    
    
    
    <g:if test="${i!=0}">
        <div class="form-group form-buttons">
            <button type="button" class="btn btn-danger field-btn-delete" onClick="icbs.Customer.Form.Utilities.bindDelete(this,'.insurance-div');"><span class="fa fa-minus" ></span> Remove</button>
        </div>
    </g:if>
</div> 

