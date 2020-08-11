<%@ page import="icbs.lov.ConfigItemStatus" %>
<g:hiddenField id="loanID" name="loanID" value="${ropaInstance?.loan}" />
<div class="fieldcontain form-group ${hasErrors(bean: loanLedgerInstance, field: 'loan', 'has-error')} ">
	<label class="control-label col-sm-4" for="loan">
		<g:message code="loanLedger.loan.label" default="SCR Account" />
        <span class="required-indicator">*</span>
	</label>
	<div class="col-sm-7"><g:field name="accountNo" value="${ropaInstance?.loan}" class="form-control" readonly="true"/>        

        <g:hasErrors bean="${loanLedgerInstance}" field="loan">
                <script>
                    $(function
                        var x = '${it}';
                        notify.error(x);
                       // console.log(x)
                       // setTimeout(function(){ notify.success(x); }, 3000);
                    });
                </script>
        </g:hasErrors>
    </div>             

    <div class="col-sm-2"><input type="button" href="#" class="btn btn-secondary" onclick="showLoanSearch()" value="Search"/></div>
</div>
<div class="fieldcontain form-group ${hasErrors(bean: ropaInstance, field: 'loan', 'has-error')} required">
    <label class="control-label col-sm-4" for="loan">Customer Name<span class="required-indicator">*</span></label>
    <div class="col-sm-8"><g:textField name="loanAccountName" maxlength="25" required="" value="${ropaInstance?.loan?.customer?.displayName}"class="form-control" readonly="true"/>
        <g:hasErrors bean="${ropaInstance}" field="loan">
            <div class="controls">
                <span class="help-block">
                    <g:eachError bean="${ropaInstance}" field="loan">
                        <g:message error="${it}" /><br/>
                    </g:eachError>
                </span>
            </div>
        </g:hasErrors>
    </div>             
</div>
<div class="fieldcontain form-group ${hasErrors(bean: ropaInstance, field: 'ciName', 'has-error')} required">
            <label class="control-label col-sm-4" for="ciName">
                    <g:message code="creditInvestigation.ciName.label" default="Granted Amount" />
            </label>
            <div class="col-sm-8"><g:field name="xxxGranted" id="xxxGranted" value="" disabled="disable" class="form-control truncated"/>

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
    <div class="fieldcontain form-group ${hasErrors(bean: ropaInstance, field: 'ciName', 'has-error')} required">
            <label class="control-label col-sm-4" for="ciName">
                    <g:message code="creditInvestigation.ciName.label" default="Product" />
            </label>
            <div class="col-sm-8"><g:field name="productName" id="productName" value="" disabled="disable" class="form-control"/>

                <g:hasErrors bean="${ropaInstance}" field="productName">
                    <div class="controls">
                            <span class="help-block">
                                <g:eachError bean="${ropaInstance}" field="productName">
                                    <g:message error="${it}" /><br/>
                                </g:eachError>
                            </span>
                    </div>
                </g:hasErrors>
            </div>             
    </div>
<g:hiddenField name="id" id="id" value="${params?.id}" />
<g:hiddenField name="loanApplication" id="loanApplication" value="${params?.id}" />
<div class="fieldcontain form-group ${hasErrors(bean: txnTemplateInstance, field: 'txnType', 'has-error')} required">
    <label class="control-label col-sm-4" for="txnType">Txn Template<span class="required-indicator">*</span></label>
                                    
    <div class="col-sm-8"><g:select id="txnType" name="txnType" from="${icbs.admin.TxnTemplate.get(icbs.admin.Institution.findByParamCode("GLS.60630").paramValue.toInteger())}" optionKey="id" optionValue="description" required="" value="" onchange="getcode();" class="many-to-one form-control"/>
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
<%--
<div class="fieldcontain form-group ${hasErrors(bean: transferToRopaInstance, field: 'accumulatedDepreciation', 'has-error')} required">
        <label class="control-label col-sm-4" for="accumulatedDepreciation">
                <g:message code="ropaSale.accumulatedDepreciation.label" default="Accumulated Depreciation" />
        </label>
        <div class="col-sm-8"><g:field name="accumulatedDepreciation" id="accumulatedDepreciation" value="" class="form-control truncated"/>

            <g:hasErrors bean="${collateralInstance}" field="accumulatedDepreciation">
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
<div class="fieldcontain form-group ${hasErrors(bean: transferToRopaInstance, field: 'grt', 'has-error')} required">
        <label class="control-label col-sm-4" for="grt">
                <g:message code="ropaSale.grt.label" default="Gross Receipts Tax (GRT)" />
        </label>
        <div class="col-sm-8"><g:field name="grt" id="grt" value="" class="form-control truncated"/>

            <g:hasErrors bean="${collateralInstance}" field="grt">
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
                <g:message code="ropaSale.scrDiscount.label" default="SCR Discount" />
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
<div class="fieldcontain form-group ${hasErrors(bean: transferToRopaInstance, field: 'commission', 'has-error')} required">
        <label class="control-label col-sm-4" for="commission">
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
<div class="fieldcontain form-group ${hasErrors(bean: transferToRopaInstance, field: 'commission', 'has-error')} required">
        <label class="control-label col-sm-4" for="commission">
                <g:message code="ropaSale.commission.label" default="Particulars" />
        </label>
        <div class="col-sm-8"><g:textArea name="particulars" id="particulars" value="" rows="5" cols="40" class="form-control"/>

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