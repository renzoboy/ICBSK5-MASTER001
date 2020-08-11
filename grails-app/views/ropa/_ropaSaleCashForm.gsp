<%@ page import="icbs.lov.ConfigItemStatus" %>
<g:hiddenField name="id" id="id" value="${params?.id}" />
<div class="fieldcontain form-group ${hasErrors(bean: loanInstance, field: 'loanApplication', 'has-error')} required">
    <label class="control-label col-sm-4" for="loanApplication">
        <g:message code="loan.loanApplication.label" default="SCR Application " />
        <span class="required-indicator">*</span>
    </label>
    <div class="col-sm-7"><g:field name="loanApplication" id="loanApplication" type="number" value="${loanInstance?.loanApplication?.id}" class="form-control" readonly="true"/>
        <g:hasErrors bean="${loanInstance}" field="loanApplication">
            <div class="controls">
                    <span class="help-block">
                        <g:eachError bean="${loanInstance}" field="loanApplication">
                            <g:message error="${it}" /><br/>
                        </g:eachError>
                    </span>
            </div>
        </g:hasErrors>
    </div>

    <g:if test="${!reschedule}">
    <div class="col-sm-2"><input type="button" href="#" class="btn btn-secondary" onclick="showLoanApplicationSearch()" value="Search"/></div>
    </g:if>
</div>
    <div class="fieldcontain form-group ${hasErrors(bean: ropaInstance, field: 'ciName', 'has-error')} required">
            <label class="control-label col-sm-4" for="ciName">
                    <g:message code="creditInvestigation.ciName.label" default="Customer Name" />
            </label>
            <div class="col-sm-8"><g:field name="lnaccountName" id="lnaccountName" value="${loanInstance?.loanApplication?.customer?.displayName}" disabled="disable" class="form-control"/>

                <g:hasErrors bean="${ropaInstance}" field="ciName">
                    <div class="controls">
                            <span class="help-block">
                                <g:eachError bean="${ropaInstance}" field="ciName">
                                    <g:message error="${it}" /><br/>
                                </g:eachError>
                            </span>
                    </div>
                </g:hasErrors>
            </div>
    </div>
<div class="fieldcontain form-group ${hasErrors(bean: txnTemplateInstance, field: 'txnType', 'has-error')} required">
    <label class="control-label col-sm-4" for="txnType">Txn Template<span class="required-indicator">*</span></label>

    <div class="col-sm-8"><g:select id="txnType" name="txnType" from="${icbs.admin.TxnTemplate.get(icbs.admin.Institution.findByParamCode("GLS.60620").paramValue.toInteger())}" optionKey="id" optionValue="description" required="" value="" onchange="getcode();" class="many-to-one form-control"/>
    </div>
</div>
<div class="fieldcontain form-group ${hasErrors(bean: transferToRopaInstance, field: 'sellingPrice', 'has-error')} required">
        <label class="control-label col-sm-4" for="sellingPrice">
                <g:message code="ropaSale.sellingPrice.label" default="Selling Price" /><span class="required-indicator"> *</span>
        </label>
        <div class="col-sm-8"><g:field name="sellingPrice" id="sellingPrice" value="" class="form-control truncated"/>

            <g:hasErrors bean="${collateralInstance}" field="sellingPrice">
                <div class="controls">
                        <span class="help-block">
                            <g:eachError bean="${collateralInstance}" field="sellingPrice">
                                <g:message error="${it}" /><br/>
                            </g:eachError>
                        </span>
                </div>
            </g:hasErrors>
        </div>
</div>

<div class="fieldcontain form-group ${hasErrors(bean: transferToRopaInstance, field: 'commission', 'has-error')} required">
        <label class="control-label col-sm-4" for="commission">
                <g:message code="ropaSale.commission.label" default="Commission" />
        </label>
        <div class="col-sm-8"><g:field name="commission" id="commission" value="" class="form-control truncated"/>

            <g:hasErrors bean="${collateralInstance}" field="commission">
                <div class="controls">
                        <span class="help-block">
                            <g:eachError bean="${collateralInstance}" field="grt">
                                <g:message error="${it}" /><br/>
                            </g:eachError>
                        </span>
                </div>
            </g:hasErrors>
        </div>
</div>
<%--
<div class="fieldcontain form-group ${hasErrors(bean: transferToRopaInstance, field: 'downPayment', 'has-error')} required">
        <label class="control-label col-sm-4" for="downPayment">
                <g:message code="ropaSale.downPayment.label" default="Down Payment" />
        </label>
        <div class="col-sm-8"><g:field name="downPayment" id="downPayment" value="" class="form-control truncated"/>

            <g:hasErrors bean="${collateralInstance}" field="downPayment">
                <div class="controls">
                        <span class="help-block">
                            <g:eachError bean="${collateralInstance}" field="grt">
                                <g:message error="${it}" /><br/>
                            </g:eachError>
                        </span>
                </div>
            </g:hasErrors>
        </div>
</div>
<div class="fieldcontain form-group ${hasErrors(bean: transferToRopaInstance, field: 'scrDiscount', 'has-error')} required">
        <label class="control-label col-sm-4" for="scrDiscount">
                <g:message code="ropaSale.scrDiscount.label" default="Down Payment" />
        </label>
        <div class="col-sm-8"><g:field name="scrDiscount" id="scrDiscount" value="" class="form-control truncated"/>

            <g:hasErrors bean="${collateralInstance}" field="scrDiscount">
                <div class="controls">
                        <span class="help-block">
                            <g:eachError bean="${collateralInstance}" field="grt">
                                <g:message error="${it}" /><br/>
                            </g:eachError>
                        </span>
                </div>
            </g:hasErrors>
        </div>
</div> --%>

<div class="fieldcontain form-group ${hasErrors(bean: transferToRopaInstance, field: 'reference', 'has-error')} required">
        <label class="control-label col-sm-4" for="reference">
                <g:message code="ropaSale.commission.label" default="Agent" />
        </label>
        <div class="col-sm-8"><g:select id="agent" name="agent.id" from="${icbs.admin.UserMaster.findAllByConfigItemStatus(ConfigItemStatus.get(2))}" optionKey="id" optionValue="name" required="" value="" class="many-to-one form-control"/>

            <g:hasErrors bean="${collateralInstance}" field="Agent">
                <div class="controls">
                        <span class="help-block">
                            <g:eachError bean="${collateralInstance}" field="Agent">
                                <g:message error="${it}" /><br/>
                            </g:eachError>
                        </span>
                </div>
            </g:hasErrors>
        </div>
</div>
<div class="fieldcontain form-group ${hasErrors(bean: transferToRopaInstance, field: 'reference', 'has-error')} required">
        <label class="control-label col-sm-4" for="reference">
                <g:message code="ropaSale.commission.label" default="Reference" />
        </label>
        <div class="col-sm-8"><g:field name="reference" id="reference" value="" class="form-control"/>

            <g:hasErrors bean="${collateralInstance}" field="reference">
                <div class="controls">
                        <span class="help-block">
                            <g:eachError bean="${collateralInstance}" field="grt">
                                <g:message error="${it}" /><br/>
                            </g:eachError>
                        </span>
                </div>
            </g:hasErrors>
        </div>
</div>
<div class="fieldcontain form-group ${hasErrors(bean: transferToRopaInstance, field: 'particulars', 'has-error')} required">
        <label class="control-label col-sm-4" for="particulars">
                <g:message code="ropaSale.commission.label" default="Particulars" />
        </label>
        <div class="col-sm-8"><g:textArea name="particulars" value="" rows="5" cols="40" class="form-control"/>

            <g:hasErrors bean="${collateralInstance}" field="particulars">
                <div class="controls">
                        <span class="help-block">
                            <g:eachError bean="${collateralInstance}" field="grt">
                                <g:message error="${it}" /><br/>
                            </g:eachError>
                        </span>
                </div>
            </g:hasErrors>
        </div>
</div>
