<%@ page import="icbs.admin.UserMaster" %>
<%@ page import="icbs.lov.ConfigItemStatus" %>
<div class="fieldcontain form-group ${hasErrors(bean: collateralInstance, field: 'forClosureDate', 'has-error')}">
    <label class="col-sm-5" for="forClosureDate" >Date of Foreclosure<span class="required-indicator"> </span></label>
    <div class="col-sm-7"><g:customDatePicker name="forClosureDate" precision="day" class="form-control" value="${collateralInstance?.forClosureDate}" />

        <g:hasErrors bean="${collateralInstance}" field="forClosureDate">
            <div class="controls">
                <span class="help-block">
                    <g:eachError bean="${collateralInstance}" field="forClosureDate">
                        <g:message error="${it}" /><br/>
                    </g:eachError>
                </span>
            </div>
        </g:hasErrors>
    </div>             
</div>
<div class="fieldcontain form-group ${hasErrors(bean: collateralInstance, field: 'certificateDate', 'has-error')}">
    <label class="col-sm-5" for="certificateDate">Date of Execution of Certificate of Sale<span class="required-indicator"> </span></label>
    <div class="col-sm-7"><g:customDatePicker name="certificateDate" precision="day" class="form-control" value="${collateralInstance?.certificateDate}" />

        <g:hasErrors bean="${collateralInstance}" field="certificateDate">
            <div class="controls">
                <span class="help-block">
                    <g:eachError bean="${collateralInstance}" field="certificateDate">
                        <g:message error="${it}" /><br/>
                    </g:eachError>
                </span>
            </div>
        </g:hasErrors>
    </div>             
</div>
<div class="fieldcontain form-group ${hasErrors(bean: collateralInstance, field: 'certificateRegistrationDate', 'has-error')}">
    <label class="col-sm-5" for="certificateRegistrationDate">Date of Registration of Certificate of Sale<span class="required-indicator"> </span></label>
    <div class="col-sm-7"><g:customDatePicker name="certificateRegistrationDate" precision="day" class="form-control" value="${collateralInstance?.certificateRegistrationDate}" />
        <g:hasErrors bean="${collateralInstance}" field="certificateRegistrationDate">
            <div class="controls">
                <span class="help-block">
                    <g:eachError bean="${collateralInstance}" field="certificateRegistrationDate">
                        <g:message error="${it}" /><br/>
                    </g:eachError>
                </span>
            </div>
        </g:hasErrors>
    </div>             
</div>
<div class="fieldcontain form-group ${hasErrors(bean: collateralInstance, field: 'notarizationOfDacionDate', 'has-error')}">
    <label class="col-sm-5" for="notarizationOfDacionDate">Date of Notarization of Dacion<span class="required-indicator"> </span></label>
    <div class="col-sm-7"><g:customDatePicker name="notarizationOfDacionDate" precision="day" class="form-control" value="${collateralInstance?.notarizationOfDacionDate}" />

        <g:hasErrors bean="${collateralInstance}" field="notarizationOfDacionDate">
            <div class="controls">
                <span class="help-block">
                    <g:eachError bean="${collateralInstance}" field="notarizationOfDacionDate">
                        <g:message error="${it}" /><br/>
                    </g:eachError>
                </span>
            </div>
        </g:hasErrors>
    </div>             
</div>
<div class="fieldcontain form-group ${hasErrors(bean: collateralInstance, field: 'consolidatedDate', 'has-error')}">
    <label class="col-sm-5" for="consolidatedDate">Date of Consolidation<span class="required-indicator"> </span></label>
    <div class="col-sm-7"><g:customDatePicker name="consolidatedDate" precision="day" class="form-control" value="${collateralInstance?.consolidatedDate}" />
        <g:hasErrors bean="${collateralInstance}" field="consolidatedDate">
            <div class="controls">
                <span class="help-block">
                    <g:eachError bean="${collateralInstance}" field="consolidatedDate">
                        <g:message error="${it}" /><br/>
                    </g:eachError>
                </span>
            </div>
        </g:hasErrors>
    </div>             
</div>
<div class="fieldcontain form-group ${hasErrors(bean: collateralInstance, field: 'consolidatedTitleNumber', 'has-error')} required">
    <label class="col-sm-5" for="consolidatedTitleNumber">
            <g:message code="RopaCollateralDetails.consolidatedTitleNumber.label" default="Consolidated Title Number" /> <span class="required-indicator"> </span>
    </label>
    <div class="col-sm-7"><g:field name="consolidatedTitleNumber" id="consolidatedTitleNumber" value="${collateralInstance?.consolidatedTitleNumber}" class="form-control"/>

        <g:hasErrors bean="${collateralInstance}" field="consolidatedTitleNumber">																	 
            <div class="controls">
                    <span class="help-block">
                        <g:eachError bean="${collateralInstance}" field="consolidatedTitleNumber">
                            <g:message error="${it}" /><br/>
                        </g:eachError>
                    </span>
            </div>
        </g:hasErrors>
    </div>             
</div>

<div class="fieldcontain form-group ${hasErrors(bean: collateralInstance, field: 'fireInsuranceAmt', 'has-error')} required">
    <label class="col-sm-5" for="fireInsuranceAmt">
            <g:message code="RopaCollateralDetails.fireInsuranceAmt.label" default="Amount of Fire Insurance Coverage" /> <span class="required-indicator"> </span>
    </label>
    <div class="col-sm-7"><g:field name="fireInsuranceAmt" id="fireInsuranceAmt" value="${collateralInstance?.fireInsuranceAmt}" class="form-control truncated"/>

        <g:hasErrors bean="${collateralInstance}" field="fireInsuranceAmt">
            <div class="controls">
                    <span class="help-block">
                        <g:eachError bean="${collateralInstance}" field="fireInsuranceAmt">
                            <g:message error="${it}" /><br/>
                        </g:eachError>
                    </span>
            </div>
        </g:hasErrors>
    </div>             
</div>
<div class="fieldcontain form-group ${hasErrors(bean: collateralInstance, field: 'fireInsurancePolicyNo', 'has-error')} required">
    <label class="col-sm-5" for="fireInsurancePolicyNo">
            <g:message code="RopaCollateralDetails.fireInsurancePolicyNo.label" default="Fire Insurance Policy Number" /> <span class="required-indicator"> </span>
    </label>
    <div class="col-sm-7"><g:field name="fireInsurancePolicyNo" id="fireInsurancePolicyNo" value="${collateralInstance?.fireInsurancePolicyNo}" class="form-control "/>

        <g:hasErrors bean="${collateralInstance}" field="fireInsurancePolicyNo">
            <div class="controls">
                    <span class="help-block">
                        <g:eachError bean="${collateralInstance}" field="fireInsurancePolicyNo">
                            <g:message error="${it}" /><br/>
                        </g:eachError>
                    </span>
            </div>
        </g:hasErrors>
    </div>             
</div>
<div class="fieldcontain form-group ${hasErrors(bean: collateralInstance, field: 'fireInsuranceStartDate', 'has-error')}">
    <label class="col-sm-5" for="fireInsuranceStartDate">Date of Effectivity of Fire Insurance<span class="required-indicator"> </span></label>
    <div class="col-sm-7"><g:customDatePicker name="fireInsuranceStartDate" precision="day" class="form-control" value="${collateralInstance?.fireInsuranceStartDate}" />

        <g:hasErrors bean="${collateralInstance}" field="fireInsuranceStartDate">
            <div class="controls">
                <span class="help-block">
                    <g:eachError bean="${collateralInstance}" field="fireInsuranceStartDate">
                        <g:message error="${it}" /><br/>
                    </g:eachError>
                </span>
            </div>
        </g:hasErrors>
    </div>             
</div>
<div class="fieldcontain form-group ${hasErrors(bean: collateralInstance, field: 'fireInsuranceEndDate', 'has-error')}">
    <label class="col-sm-5" for="fireInsuranceEndDate">Expiry Date of Fire Insurance<span class="required-indicator"> </span></label>
    <div class="col-sm-7"><g:customDatePicker name="fireInsuranceEndDate" precision="day" class="form-control" value="${collateralInstance?.fireInsuranceEndDate}" />

        <g:hasErrors bean="${collateralInstance}" field="fireInsuranceEndDate">
            <div class="controls">
                <span class="help-block">
                    <g:eachError bean="${collateralInstance}" field="fireInsuranceStartDate">
                        <g:message error="${it}" /><br/>
                    </g:eachError>
                </span>
            </div>
        </g:hasErrors>
    </div>             
</div>

<div class="fieldcontain form-group ${hasErrors(bean: collateralInstance, field: 'latestRatrDate', 'has-error')}">
    <label class="col-sm-5" for="latestRatrDate">Date of Latest Real Estate Tax Receipt (RETR)<span class="required-indicator"> </span></label>
																											 
			
    <div class="col-sm-7"><g:customDatePicker name="latestRatrDate" precision="day" class="form-control" value="${collateralInstance?.latestRatrDate}" />

        <g:hasErrors bean="${collateralInstance}" field="latestRatrDate">
            <div class="controls">
                <span class="help-block">
                    <g:eachError bean="${collateralInstance}" field="latestRatrDate">
                        <g:message error="${it}" /><br/>
                    </g:eachError>
                </span>
            </div>
        </g:hasErrors>
    </div>             
</div>
<g:if test="${collateralInstance?.appraisedBy == null}">
<div class="fieldcontain form-group ${hasErrors(bean: collateralInstance, field: 'appraisedBy', 'has-error')} required">
    <label class="col-sm-5" for="appraisedBy">
            <g:message code="RopaCollateralDetails.appraisedBy.label" default="Appraise by" /> <span class="required-indicator"> </span>
    </label>
    <div class="col-sm-7"><g:select id="appraisedBy" name="appraisedBy" from="${icbs.admin.UserMaster.findAllByConfigItemStatus(ConfigItemStatus.get(2))}" optionKey="id" optionValue="name" required="" value="${collateralInstance?.appraisedBy}" noSelection="${['':'Select Appraised by']}" class="form-control"/>
        <g:hasErrors bean="${collateralInstance}" field="appraisedBy">
																				
            <div class="controls">
                    <span class="help-block">
                        <g:eachError bean="${collateralInstance}" field="appraisedBy">
                            <g:message error="${it}" /><br/>
                        </g:eachError>
                    </span>
            </div>
        </g:hasErrors>
    </div>             
</div>
</g:if>
<g:else>
<div class="fieldcontain form-group ${hasErrors(bean: collateralInstance, field: 'appraisedBy', 'has-error')} required">
    <label class="col-sm-5" for="appraisedBy">
            <g:message code="RopaCollateralDetails.appraisedBy.label" default="Appraise by" /> <span class="required-indicator"> </span>
    </label>
    <div class="col-sm-7"><g:select id="appraisedBy" name="appraisedBy" from="${icbs.admin.UserMaster.findAllByConfigItemStatus(ConfigItemStatus.get(2))}" optionKey="id" optionValue="name" required="" value="${collateralInstance?.appraisedBy.id}" noSelection="${['':'Select Appraised by']}" class="form-control"/>
        <g:hasErrors bean="${collateralInstance}" field="appraisedBy">
            <div class="controls">
                    <span class="help-block">
                        <g:eachError bean="${collateralInstance}" field="appraisedBy">
                            <g:message error="${it}" /><br/>
                        </g:eachError>
                    </span>
            </div>
        </g:hasErrors>
    </div>             
</div>
</g:else>