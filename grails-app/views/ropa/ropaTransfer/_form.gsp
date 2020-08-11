

<div class="fieldcontain form-group ${hasErrors(bean: transferToRopaInstance, field: 'marketValueLand', 'has-error')} required">
        <label class="control-label col-sm-4" for="marketValueLand">
                <g:message code="RopaTransfer.marketValueLand.label" default="Appraised Value Land" /><span class="required-indicator"> *</span>
        </label>
        <div class="col-sm-8"><g:field name="marketValueLand" id="marketValueLand" value="" class="form-control truncated"/>

            <g:hasErrors bean="${transferToRopaInstance}" field="marketValueLand">
                <div class="controls">
                        <span class="help-block">
                            <g:eachError bean="${transferToRopaInstance}" field="marketValueLand">
                                <g:message error="${it}" /><br/>
                            </g:eachError>
                        </span>
                </div>
            </g:hasErrors>
        </div>             
</div>

<div class="fieldcontain form-group ${hasErrors(bean: transferToRopaInstance, field: 'marketValueBuilding', 'has-error')} required">
        <label class="control-label col-sm-4" for="marketValueBuilding">
                <g:message code="RopaTransfer.marketValueBuilding.label" default="Appraised Value Building" /><span class="required-indicator"> *</span>
        </label>
        <div class="col-sm-8"><g:field name="marketValueBuilding" id="marketValueBuilding" value="" class="form-control truncated"/>

            <g:hasErrors bean="${transferToRopaInstance}" field="marketValueBuilding">
                <div class="controls">
                        <span class="help-block">
                            <g:eachError bean="${transferToRopaInstance}" field="marketValueBuilding">
                                <g:message error="${it}" /><br/>
                            </g:eachError>
                        </span>
                </div>
            </g:hasErrors>
        </div>             
</div>
<div class="fieldcontain form-group ${hasErrors(bean: transferToRopaInstance, field: 'otherPropertiesAcquired', 'has-error')} required">
        <label class="control-label col-sm-4" for="otherPropertiesAcquired">
                <g:message code="RopaTransfer.otherPropertiesAcquired.label" default="Appraised of Other Properties Acquired" /><span class="required-indicator"> *</span>
        </label>
        <div class="col-sm-8"><g:field name="otherPropertiesAcquired" id="otherPropertiesAcquired" value="" class="form-control truncated"/>

            <g:hasErrors bean="${transferToRopaInstance}" field="otherPropertiesAcquired">
                <div class="controls">
                        <span class="help-block">
                            <g:eachError bean="${transferToRopaInstance}" field="otherPropertiesAcquired">
                                <g:message error="${it}" /><br/>
                            </g:eachError>
                        </span>
                </div>
            </g:hasErrors>
        </div>             
</div>

<div class="fieldcontain form-group ${hasErrors(bean: txnTemplateInstance, field: 'txnType', 'has-error')} required">
    <label class="control-label col-sm-4" for="txnType">Txn Template<span class="required-indicator">*</span></label>
                                    
    <div class="col-sm-8"><g:select id="txnType" name="txnType" from="${icbs.admin.TxnTemplate.findAllByTxnType(icbs.lov.TxnType.read(38))}" optionKey="id" optionValue="description" required="" value="" onchange="getcode();" class="many-to-one form-control"/>
    </div>             
</div>
<div class="fieldcontain form-group ${hasErrors(bean: transferToRopaInstance, field: 'reference', 'has-error')} required">
    <label class="control-label col-sm-4" for="reference">Reference<span class="required-indicator"> *</span></label>
    <div class="col-sm-8"><g:textField id="reference" name="reference" value="" class="form-control"/>
        <g:hasErrors bean="${transferToRopaInstance}" field="reference">
            <div class="controls">
                <span class="help-block">
                    <g:eachError bean="${transferToRopaInstance}" field="reference">
                        <g:message error="${it}" /><br/>
                    </g:eachError>
                </span>
            </div>
        </g:hasErrors>
    </div>             
</div>
<div class="fieldcontain form-group ${hasErrors(bean: transferToRopaInstance, field: 'particulars', 'has-error')} required">
    <label class="control-label col-sm-4" for="particulars">Particulars<span class="required-indicator"> *</span></label>
    <div class="col-sm-8"><g:textField id="particulars" name="particulars" value="" class="form-control"/>
        <g:hasErrors bean="${transferToRopaInstance}" field="particulars">
            <div class="controls">
                <span class="help-block">
                    <g:eachError bean="${transferToRopaInstance}" field="particulars">
                        <g:message error="${it}" /><br/>
                    </g:eachError>
                </span>
            </div>
        </g:hasErrors>
    </div>             
</div>