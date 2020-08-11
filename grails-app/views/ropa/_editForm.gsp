<%@ page import="icbs.gl.GlAccount" %>
<div class="fieldcontain form-group ${hasErrors(bean: ropapapapaInstanceInstance, field: 'glContraRopa', 'has-error')} required">
    <label class="control-label col-sm-4" for="glContraRopa">Ropa Land GL Account<span class="required-indicator">*</span></label>
    <div class="col-sm-8"><g:textField id="glContraRopa" name="glContraRopa" required="" value="${ropapapapaInstanceInstance?.glContraRopa}" onblur="validateGlCodeglContraRopa();"  class="form-control"/>
        <g:hasErrors bean="${ropapapapaInstanceInstance}" field="glContraRopa">
            <div class="controls">
                <span class="help-block">
                    <g:eachError bean="${ropapapapaInstanceInstance}" field="glContraRopa">
                        <g:message error="${it}" /><br/>
                    </g:eachError>
                </span>
            </div>
        </g:hasErrors>
    </div>             
</div>
<!-- Gl Account Description -->
<div id="glaccountdescription" class="fieldcontain form-group ${hasErrors(bean: txnTemplateInstance, field: 'depcontra', 'has-error')} required">
	<label class="control-label col-sm-4" for="memoTxnType">
		<g:message code="txnTemplate.memoTxnType.label" default="GL Account Name" />
		<span class="required-indicator">*</span>
	</label>
	<div class="col-sm-8"><g:textField readonly="true" name="glbldgdescriptionContra" id="glbldgdescriptionContra" value="${GlAccount.findByCode(ropapapapaInstanceInstance?.glContraRopa).name}"  class="form-control"/>

            <g:hasErrors bean="${ropapapapaInstanceInstance}" field="memoTxnType">
                <div class="controls">
                        <span class="help-block">
                            <g:eachError bean="${txnTemplateInstance}" field="memoTxnType">
                                <g:message error="${it}" /><br/>
                            </g:eachError>
                        </span>
                </div>
            </g:hasErrors>
        </div>             
</div>
<div class="fieldcontain form-group ${hasErrors(bean: ropapapapaInstanceInstance, field: 'glContraLitigationExp', 'has-error')} required">
    <label class="control-label col-sm-4" for="glContraRopa">Litigation Expense GL Account<span class="required-indicator">*</span></label>
    <div class="col-sm-8"><g:textField id="glContraLitigationExp" name="glContraLitigationExp"  required="" value="${ropapapapaInstanceInstance?.glContraLitigationExp}" onblur="validateGlCodeglContraLitigationExp();" class="form-control"/>
        <g:hasErrors bean="${ropapapapaInstanceInstance}" field="glContraLitigationExp">
            <div class="controls">
                <span class="help-block">
                    <g:eachError bean="${ropapapapaInstanceInstance}" field="glContraLitigationExp">
                        <g:message error="${it}" /><br/>
                    </g:eachError>
                </span>
            </div>
        </g:hasErrors>
    </div>             
</div>
<!-- Gl Account Description -->
<div id="glaccountdescription" class="fieldcontain form-group ${hasErrors(bean: txnTemplateInstance, field: 'depcontra', 'has-error')} required">
	<label class="control-label col-sm-4" for="memoTxnType">
		<g:message code="txnTemplate.memoTxnType.label" default="GL Account Name" />
		<span class="required-indicator">*</span>
	</label>
	<div class="col-sm-8"><g:textField readonly="true" name="glLitigationExpenseDescription" id="glLitigationExpenseDescription" value="${GlAccount.findByCode(ropapapapaInstanceInstance?.glContraLitigationExp).name}"  class="form-control"/>

            <g:hasErrors bean="${ropapapapaInstanceInstance}" field="glLitigationExpenseDescription">
                <div class="controls">
                        <span class="help-block">
                            <g:eachError bean="${txnTemplateInstance}" field="glLitigationExpenseDescription">
                                <g:message error="${it}" /><br/>
                            </g:eachError>
                        </span>
                </div>
            </g:hasErrors>
        </div>             
</div>
<div class="fieldcontain form-group ${hasErrors(bean: ropapapapaInstanceInstance, field: 'glContraRopa', 'has-error')} required">
    <label class="control-label col-sm-4" for="glContraRopa">ROPA Building GL Account<span class="required-indicator">*</span></label>
    <div class="col-sm-8"><g:textField id="glContraBldg" name="glContraBldg" required="" value="${ropapapapaInstanceInstance?.glContraBldg}" onblur="validateGlCodeglContraBldg();" class="form-control"/>
        <g:hasErrors bean="${ropapapapaInstanceInstance}" field="glContraBldg">
            <div class="controls">
                <span class="help-block">
                    <g:eachError bean="${ropapapapaInstanceInstance}" field="glContraRopa">
                        <g:message error="${it}" /><br/>
                    </g:eachError>
                </span>
            </div>
        </g:hasErrors>
    </div>             
</div>
<!-- Gl Account Description -->
<div id="glaccountdescription" class="fieldcontain form-group ${hasErrors(bean: txnTemplateInstance, field: 'depcontra', 'has-error')} required">
	<label class="control-label col-sm-4" for="memoTxnType">
		<g:message code="txnTemplate.memoTxnType.label" default="GL Account Name" />
		<span class="required-indicator">*</span>
	</label>
	<div class="col-sm-8"><g:textField readonly="true" name="glRopaBldgDescription" id="glRopaBldgDescription" value="${GlAccount.findByCode(ropapapapaInstanceInstance?.glContraRopa).name}"  class="form-control"/>

            <g:hasErrors bean="${ropapapapaInstanceInstance}" field="glRopaBldgDescription">
                <div class="controls">
                        <span class="help-block">
                            <g:eachError bean="${txnTemplateInstance}" field="glRopaBldgDescription">
                                <g:message error="${it}" /><br/>
                            </g:eachError>
                        </span>
                </div>
            </g:hasErrors>
        </div>             
</div>
<div class="fieldcontain form-group ${hasErrors(bean: ropapapapaInstanceInstance, field: 'glContraRopa', 'has-error')} required">
    <label class="control-label col-sm-4" for="glContraRopa">Other Accumulated Depreciation GL Account<span class="required-indicator">*</span></label>
    <div class="col-sm-8"><g:textField id="otherAccumlated" name="otherAccumlated" required="" value="${ropapapapaInstanceInstance?.otherAccumlated}" onblur="validateGlCodeotherAccumlated();" class="form-control"/>
        <g:hasErrors bean="${ropapapapaInstanceInstance}" field="otherAccumlated">
            <div class="controls">
                <span class="help-block">
                    <g:eachError bean="${ropapapapaInstanceInstance}" field="otherAccumlated">
                        <g:message error="${it}" /><br/>
                    </g:eachError>
                </span>
            </div>
        </g:hasErrors>
    </div>             
</div>
<!-- Gl Account Description -->
<div id="glaccountdescription" class="fieldcontain form-group ${hasErrors(bean: txnTemplateInstance, field: 'depcontra', 'has-error')} required">
	<label class="control-label col-sm-4" for="memoTxnType">
		<g:message code="txnTemplate.memoTxnType.label" default="GL Account Name" />
		<span class="required-indicator">*</span>
	</label>
	<div class="col-sm-8"><g:textField readonly="true" name="otherAccumulatedDescription" id="otherAccumulatedDescription" value="${GlAccount.findByCode(ropapapapaInstanceInstance?.otherAccumlated).name}"  class="form-control"/>

            <g:hasErrors bean="${ropapapapaInstanceInstance}" field="memoTxnType">
                <div class="controls">
                        <span class="help-block">
                            <g:eachError bean="${txnTemplateInstance}" field="memoTxnType">
                                <g:message error="${it}" /><br/>
                            </g:eachError>
                        </span>
                </div>
            </g:hasErrors>
        </div>             
</div>
<div class="fieldcontain form-group ${hasErrors(bean: ropapapapaInstanceInstance, field: 'glContraRopa', 'has-error')} required">
    <label class="control-label col-sm-4" for="glContraRopa">Gain on Sale of ROPA<span class="required-indicator">*</span></label>
    <div class="col-sm-8"><g:textField id="ropaIncome" name="ropaIncome" required="" value="${ropapapapaInstanceInstance?.ropaIncome}" onblur="validateGlCoderopaIncome();" class="form-control"/>
        <g:hasErrors bean="${ropapapapaInstanceInstance}" field="ropaIncome">
            <div class="controls">
                <span class="help-block">
                    <g:eachError bean="${ropapapapaInstanceInstance}" field="ropaIncome">
                        <g:message error="${it}" /><br/>
                    </g:eachError>
                </span>
            </div>
        </g:hasErrors>
    </div>             
</div>
<!-- Gl Account Description -->
<div id="glaccountdescription" class="fieldcontain form-group ${hasErrors(bean: txnTemplateInstance, field: 'depcontra', 'has-error')} required">
	<label class="control-label col-sm-4" for="memoTxnType">
		<g:message code="txnTemplate.memoTxnType.label" default="GL Account Name" />
		<span class="required-indicator">*</span>
	</label>
	<div class="col-sm-8"><g:textField readonly="true" name="ropaGainOnSaleDescription" id="ropaGainOnSaleDescription" value="${GlAccount.findByCode(ropapapapaInstanceInstance?.ropaIncome).name}"  class="form-control"/>

            <g:hasErrors bean="${ropapapapaInstanceInstance}" field="ropaGainOnSaleDescription">
                <div class="controls">
                        <span class="help-block">
                            <g:eachError bean="${txnTemplateInstance}" field="ropaGainOnSaleDescription">
                                <g:message error="${it}" /><br/>
                            </g:eachError>
                        </span>
                </div>
            </g:hasErrors>
        </div>             
</div>
<div class="fieldcontain form-group ${hasErrors(bean: ropapapapaInstanceInstance, field: 'accumulatedDepreciation', 'has-error')} required">
    <label class="control-label col-sm-4" for="accumulatedDepreciation">Accumulated Depreciation GL Account<span class="required-indicator">*</span></label>
    <div class="col-sm-8"><g:textField id="accumulatedDepreciation" name="accumulatedDepreciation" required="" value="${ropapapapaInstanceInstance?.accumulatedDepreciation}" onblur="validateGlCodeAccum();" class="form-control"/>
        <g:hasErrors bean="${ropapapapaInstanceInstance}" field="accumulatedDepreciation">
            <div class="controls">
                <span class="help-block">
                    <g:eachError bean="${ropapapapaInstanceInstance}" field="accumulatedDepreciation">
                        <g:message error="${it}" /><br/>
                    </g:eachError>
                </span>
            </div>
        </g:hasErrors>
    </div>             
</div>
<!-- Gl Account Description -->
<div id="glaccountdescription" class="fieldcontain form-group ${hasErrors(bean: txnTemplateInstance, field: 'depcontra', 'has-error')} required">
	<label class="control-label col-sm-4" for="memoTxnType">
		<g:message code="txnTemplate.memoTxnType.label" default="GL Account Name" />
		<span class="required-indicator">*</span>
	</label>
	<div class="col-sm-8"><g:textField readonly="true" name="accumDescription" id="accumDescription" value="${GlAccount.findByCode(ropapapapaInstanceInstance?.accumulatedDepreciation).name}"  class="form-control"/>

            <g:hasErrors bean="${ropapapapaInstanceInstance}" field="accumDescription">
                <div class="controls">
                        <span class="help-block">
                            <g:eachError bean="${txnTemplateInstance}" field="accumDescription">
                                <g:message error="${it}" /><br/>
                            </g:eachError>
                        </span>
                </div>
            </g:hasErrors>
        </div>             
</div>
<div class="fieldcontain form-group ${hasErrors(bean: ropapapapaInstanceInstance, field: 'glContraRopa', 'has-error')} required">
    <label class="control-label col-sm-4" for="glContraRopa">Other Properties Acquired<span class="required-indicator">*</span></label>
    <div class="col-sm-8"><g:textField id="otherGl" name="otherGl" required="" value="${ropapapapaInstanceInstance?.otherGl}" onblur="validateGlCodeotherGl();" class="form-control"/>
        <g:hasErrors bean="${ropapapapaInstanceInstance}" field="otherGl">
            <div class="controls">
                <span class="help-block">
                    <g:eachError bean="${ropapapapaInstanceInstance}" field="otherGl">
                        <g:message error="${it}" /><br/>
                    </g:eachError>
                </span>
            </div>
        </g:hasErrors>
    </div>             
</div>
<!-- Gl Account Description -->
<div id="glaccountdescription" class="fieldcontain form-group ${hasErrors(bean: txnTemplateInstance, field: 'depcontra', 'has-error')} required">
	<label class="control-label col-sm-4" for="memoTxnType">
		<g:message code="txnTemplate.memoTxnType.label" default="GL Account Name" />
		<span class="required-indicator">*</span>
	</label>
	<div class="col-sm-8"><g:textField readonly="true" name="otherGlDescription" id="otherGlDescription" value="${GlAccount.findByCode(ropapapapaInstanceInstance?.otherGl).name}"  class="form-control"/>

            <g:hasErrors bean="${ropapapapaInstanceInstance}" field="otherGlDescription">
                <div class="controls">
                        <span class="help-block">
                            <g:eachError bean="${txnTemplateInstance}" field="otherGlDescription">
                                <g:message error="${it}" /><br/>
                            </g:eachError>
                        </span>
                </div>
            </g:hasErrors>
        </div>             
</div>
<%-- =============================================================================================== --%>
<g:hiddenField id="financialYear" name="financialYear" value="${g.formatDate(date: (runDate), format: 'yyyy')}"/>
<g:hiddenField id="ropaId" name="ropaId" value="${params?.id}"/>


