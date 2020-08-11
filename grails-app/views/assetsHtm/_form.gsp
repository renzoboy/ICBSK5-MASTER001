<%@ page import="icbs.gl.AssetsHeldToMaturity" %>
<%@ page import="icbs.gl.GlAccount" %>
<g:hiddenField name="idto" id="idto" value="${params.id}" />

<g:if test="${assetsHtmInstance?.amount > 0}">
</g:if>
<g:else>
<div class="fieldcontain form-group ${hasErrors(bean: txnTemplateInstance, field: 'txnType', 'has-error')} required">
    <label class="control-label col-sm-4" for="txnType">Txn Type<span class="required-indicator">*</span></label>

    <div class="col-sm-8"><g:select id="txnType" name="txnType" from="${icbs.admin.TxnTemplate.findAllByTxnTypeAndMemoTxnType(icbs.lov.TxnType.read(56),icbs.lov.MemoTxnType.read(1))}" optionKey="id" optionValue="description" required="" value="" onchange="getcode();" class="many-to-one form-control"/>
    </div>             
</div>
</g:else>
<div class="fieldcontain form-group ${hasErrors(bean: assetsHtmInstance, field: 'currency', 'has-error')} required">
    <label class="control-label col-sm-4" for="currency">Currency<span class="required-indicator">*</span></label>            
        <div class="col-sm-8">
             <g:select id="currency" name="currency.id" from="${icbs.admin.Currency.list()}" optionKey="id" optionValue="name" required="" value="${assetsHtmInstance?.currency?.id}" class="many-to-one form-control"/>
                <g:hasErrors bean="${assetsHtmInstance}" field="currency">
                    <div class="controls">
                        <span class="help-block">
                            <g:eachError bean="${assetsHtmInstance}" field="currency">
                                <g:message error="${it}" /><br/>
                            </g:eachError>
                        </span>
                    </div>
                </g:hasErrors>
        </div>             
</div>
<div class="fieldcontain form-group ${hasErrors(bean: txnTemplateInstance, field: 'txnType', 'has-error')} required">
    <label class="control-label col-sm-4" for="txnType">Resident Type<span class="required-indicator">*</span></label>

    <div class="col-sm-8"><g:select id="residentType" name="residentType" from="${icbs.lov.ResidentType.findAll{status == true}}" optionKey="id" optionValue="description" required="" value="${assetsHtmInstance?.residentType?.id}" onchange="getcode();" class="many-to-one form-control"/>
    </div>             
</div>
<g:if test="${assetsHtmInstance?.amount > 0}">
<div class="fieldcontain form-group ${hasErrors(bean: assetsHtmInstance, field: 'glCode', 'has-error')} required">
    <label class="control-label col-sm-4" for="glCode">GL Account Code<span class="required-indicator">*</span></label>
    <div class="col-sm-8"><g:textField name="xglCode" id="xglCode" required="" value="${assetsHtmInstance?.glCode}" onblur="validateGlCode();" class="form-control" readonly="true"/>
             <g:hiddenField name="glCode" id="glCode" value="${assetsHtmInstance?.glCode}" />
            <g:hasErrors bean="${assetsHtmInstance}" field="glCode">
            <div class="controls">
                <span class="help-block">
                    <g:eachError bean="${assetsHtmInstance}" field="glCode">
                        <g:message error="${it}" /><br/>
                    </g:eachError>
                </span>
            </div>
        </g:hasErrors>
    </div>             
</div>
<div id="glaccountdescription" class="fieldcontain form-group ${hasErrors(bean: assetsHtmInstance, field: 'depcontra', 'has-error')} required">
	<label class="control-label col-sm-4" for="memoTxnType">
		<g:message code="txnTemplate.memoTxnType.label" default="GL Acct Description" />
		<span class="required-indicator">*</span>
	</label>
	<div class="col-sm-8"><g:textField readonly="true" name="gldescription" id="gldescription" value="${GlAccount.findByCode(assetsHtmInstance?.glCode).name}" onblur="validateGlCode();" class="form-control"/>
           
            <g:hasErrors bean="${assetsHtmInstance}" field="memoTxnType">
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
</g:if>
<g:else>
    <div class="fieldcontain form-group ${hasErrors(bean: assetsHtmInstance, field: 'glCode', 'has-error')} required">
    <label class="control-label col-sm-4" for="glCode">GL Account Code<span class="required-indicator">*</span></label>
    <div class="col-sm-8"><g:textField name="glCode" id="glCode" required="" value="${assetsHtmInstance?.glCode}" onblur="validateGlCode();" class="form-control"/>
        <g:hasErrors bean="${assetsHtmInstance}" field="glCode">
            <div class="controls">
                <span class="help-block">
                    <g:eachError bean="${assetsHtmInstance}" field="glCode">
                        <g:message error="${it}" /><br/>
                    </g:eachError>
                </span>
            </div>
        </g:hasErrors>
    </div>             
</div>
<div id="glaccountdescription" class="fieldcontain form-group ${hasErrors(bean: assetsHtmInstance, field: 'depcontra', 'has-error')} required">
	<label class="control-label col-sm-4" for="memoTxnType">
		<g:message code="txnTemplate.memoTxnType.label" default="GL Acct Description" />
		<span class="required-indicator">*</span>
	</label>
	<div class="col-sm-8"><g:textField readonly="true" name="gldescription" id="gldescription" value="${txnTemplateInstance?.amlaCode}" onblur="validateGlCode();" class="form-control"/>
           
            <g:hasErrors bean="${assetsHtmInstance}" field="memoTxnType">
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
</g:else>


<div class="fieldcontain form-group ${hasErrors(bean: assetsHtmInstance, field: 'glCode', 'has-error')} required">
    <label class="control-label col-sm-4" for="glCode"> Debit GL Code<span class="required-indicator">*</span></label>
    <div class="col-sm-8"><g:textField name="htmAccrualDebitAcct" id="htmAccrualDebitAcct" required="" value="${assetsHtmInstance?.htmAccrualDebitAcct}" onblur="validateHtmDebitGl();" class="form-control"/>
        <g:hasErrors bean="${assetsHtmInstance}" field="htmAccrualDebitAcct">
            <div class="controls">
                <span class="help-block">
                    <g:eachError bean="${assetsHtmInstance}" field="htmAccrualDebitAcct">
                        <g:message error="${it}" /><br/>
                    </g:eachError>
                </span>
            </div>
        </g:hasErrors>
    </div>             
</div>

<div id="glaccountdescription" class="fieldcontain form-group ${hasErrors(bean: txnTemplateInstance, field: 'depcontra', 'has-error')} required">
	<label class="control-label col-sm-4" for="memoTxnType">
		<g:message code="txnTemplate.memoTxnType.label" default="Debit GL Description" />
		<span class="required-indicator">*</span>
	</label>
	<div class="col-sm-8"><g:textField readonly="true" name="htmAccrualDebitAcctDescription" id="htmAccrualDebitAcctDescription" value="${txnTemplateInstance?.amlaCode}" onblur="validateGlCode();" class="form-control"/>

            <g:hasErrors bean="${txnTemplateInstance}" field="memoTxnType">
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
<div class="fieldcontain form-group ${hasErrors(bean: assetsHtmInstance, field: 'glCode', 'has-error')} required">
    <label class="control-label col-sm-4" for="glCode">Credit GL Code<span class="required-indicator">*</span></label>
    <div class="col-sm-8"><g:textField name="htmAccrualCredittAcct" id="htmAccrualCredittAcct" required="" value="${assetsHtmInstance?.htmAccrualCredittAcct}" onblur="validateHtmCreditGl();" class="form-control"/>
        <g:hasErrors bean="${assetsHtmInstance}" field="htmAccrualCredittAcct">
            <div class="controls">
                <span class="help-block">
                    <g:eachError bean="${assetsHtmInstance}" field="htmAccrualCredittAcct">
                        <g:message error="${it}" /><br/>
                    </g:eachError>
                </span>
            </div>
        </g:hasErrors>
    </div>             
</div>

<div id="glaccountdescription" class="fieldcontain form-group ${hasErrors(bean: txnTemplateInstance, field: 'depcontra', 'has-error')} required">
	<label class="control-label col-sm-4" for="memoTxnType">
		<g:message code="txnTemplate.memoTxnType.label" default="Credit GL Description" />
		<span class="required-indicator">*</span>
	</label>
	<div class="col-sm-8"><g:textField readonly="true" name="htmAccrualCreditAcctDescription" id="htmAccrualCreditAcctDescription" value="${txnTemplateInstance?.amlaCode}" onblur="validateGlCode();" class="form-control"/>

            <g:hasErrors bean="${txnTemplateInstance}" field="memoTxnType">
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
<g:if test="${assetsHtmInstance?.amount > 0}">
<div class="fieldcontain form-group ${hasErrors(bean: assetsHtmInstance, field: 'amount', 'has-error')} required">
    <label class="control-label col-sm-4" for="amount">Amount of Placement<span class="required-indicator">*</span>
    </label>
    <div class="col-sm-8">
        <g:field class="form-control truncated" id="viewhtmAmount" name="viewhtmAmount" value="${assetsHtmInstance?.amount}" readonly="true"/>
        <g:hasErrors bean="${assetsHtmInstance}" field="amount">
            <div class="controls">
                <span class="help-block">
                    <g:eachError bean="${assetsHtmInstance}" field="amount">
                        <g:message error="${it}" /><br/>
                    </g:eachError>
                </span>
            </div>
        </g:hasErrors>
    </div>             
</div>
</g:if>
<g:else>
    <div class="fieldcontain form-group ${hasErrors(bean: assetsHtmInstance, field: 'amount', 'has-error')} required">
    <label class="control-label col-sm-4" for="amount">Amount of Placement<span class="required-indicator">*</span>
    </label>
    <div class="col-sm-8">
        <g:field class="form-control truncated" id="htmAmount" name="amount" value="${assetsHtmInstance?.amount}" />
        <g:hasErrors bean="${assetsHtmInstance}" field="amount">
            <div class="controls">
                <span class="help-block">
                    <g:eachError bean="${assetsHtmInstance}" field="amount">
                        <g:message error="${it}" /><br/>
                    </g:eachError>
                </span>
            </div>
        </g:hasErrors>
    </div>             
</div>
</g:else>
<div class="fieldcontain form-group ${hasErrors(bean: assetsHtmInstance, field: 'interestRate', 'has-error')} required">
    <label class="control-label col-sm-4" for="interestRate">Interest Rate<span class="required-indicator">*</span>
    </label>
    <div class="col-sm-8">
        <g:field class="form-control"  style="text-align:right;" id="interestRate" name="interestRate" value="${assetsHtmInstance?.interestRate}" />
        <g:hasErrors bean="${assetsHtmInstance}" field="interestRate">
            <div class="controls">
                <span class="help-block">
                    <g:eachError bean="${assetsHtmInstance}" field="interestRate">
                        <g:message error="${it}" /><br/>
                    </g:eachError>
                </span>
            </div>
        </g:hasErrors>
    </div>             
</div>


<div class="fieldcontain form-group ${hasErrors(bean: assetsHtmInstance, field: 'valueDate', 'has-error')}">
    <label class="control-label col-sm-4" for="valueDate">Value Date*</label>
    <div class="col-sm-8"><g:customDatePicker id="valueDate" name="valueDate" precision="day" 
    class="form-control" value="${assetsHtmInstance?.valueDate}" />

        <g:hasErrors bean="${assetsHtmInstance}" field="valueDate">
            <div class="controls">
                <span class="help-block">
                    <g:eachError bean="${assetsHtmInstance}" field="valueDate">
                        <g:message error="${it}" /><br/>
                    </g:eachError>
                </span>
            </div>
        </g:hasErrors>
    </div>             
</div>
<div class="fieldcontain form-group ${hasErrors(bean: assetsHtmInstance, field: 'maturityDate', 'has-error')}">
    <label class="control-label col-sm-4" for="maturityDate">Maturity Date*</label>
    <div class="col-sm-8"><g:customDatePicker id="maturityDate" name="maturityDate" precision="day" 
    class="form-control" value="${assetsHtmInstance?.maturityDate}" />

        <g:hasErrors bean="${assetsHtmInstance}" field="maturityDate">
            <div class="controls">
                <span class="help-block">
                    <g:eachError bean="${assetsHtmInstance}" field="maturityDate">
                        <g:message error="${it}" /><br/>
                    </g:eachError>
                </span>
            </div>
        </g:hasErrors>
    </div>             
</div>
<div class="fieldcontain form-group ${hasErrors(bean: assetsHtmInstance, field: 'htmType', 'has-error')} required">
    <label class="control-label col-sm-4" for="htmType">HTM Type*</label>
    <div class="col-sm-8"><g:select id="htmTypeDesc" name="htmTypeDesc" from="${icbs.gl.HtmType.findAll{status == true}}" optionKey="id" optionValue="description" required="" value="${assetsHtmInstance?.status?.id}" class="many-to-one form-control" onchange="updateHtmForm(this.value);"/>
        <g:hasErrors bean="${assetsHtmInstance}" field="htmTypeDesc">
            <div class="controls">
                <span class="help-block">
                    <g:eachError bean="${assetsHtmInstance}" field="htmTypeDesc">
                        <g:message error="${it}" /><br/>
                    </g:eachError>
                </span>
            </div>
        </g:hasErrors>
    </div>             
</div>
<div id="discountAmountDiv" class="fieldcontain form-group ${hasErrors(bean: assetsHtmInstance, field: 'discountAmount', 'has-error')} required">
    <label class="control-label col-sm-4" for="amount">Discount Amount<span class="required-indicator">*</span>
    </label>
    <div class="col-sm-8">
        <g:field class="form-control truncated" id="discountAmount" name="discountAmount" value="${assetsHtmInstance?.discountAmount}" />
        <g:hasErrors bean="${assetsHtmInstance}" field="discountAmount">
            <div class="controls">
                <span class="help-block">
                    <g:eachError bean="${assetsHtmInstance}" field="discountAmount">
                        <g:message error="${it}" /><br/>
                    </g:eachError>
                </span>
            </div>
        </g:hasErrors>
    </div>             
</div>


<div class="fieldcontain form-group ${hasErrors(bean: assetsHtmInstance, field: 'description', 'has-error')} required">
    <label class="control-label col-sm-4" for="htmDescription">HTM Description*</label>
    <div class="col-sm-8"><g:textField name="xHtmDesc" id="xHtmDesc"  required="" value="BROKER/DEALER" class="form-control" readonly="true"/>
        <g:hiddenField name="htmDescription" id="htmDescription" value="BROKER/DEALER" />
        <g:hasErrors bean="${assetsHtmInstance}" field="htmDescription">
            <div class="controls">
                <span class="help-block">
                    <g:eachError bean="${assetsHtmInstance}" field="htmDescription">
                        <g:message error="${it}" /><br/>
                    </g:eachError>
                </span>
            </div>
        </g:hasErrors>
    </div>             
</div>
<div class="fieldcontain form-group ${hasErrors(bean: assetsHtmInstance, field: 'htmIssuer', 'has-error')} required">
    <label class="control-label col-sm-4" for="remarks">Issuer*</label>
    <div class="col-sm-8"><g:textField name="htmIssuer" id="htmIssuer"  required="" value="${assetsHtmInstance?.htmIssuer}"class="form-control"/>
        <g:hasErrors bean="${assetsHtmInstance}" field="htmIssuer">
            <div class="controls">
                <span class="help-block">
                    <g:eachError bean="${assetsHtmInstance}" field="htmIssuer">
                        <g:message error="${it}" /><br/>
                    </g:eachError>
                </span>
            </div>
        </g:hasErrors>
    </div>             
</div>
<%--<div class="fieldcontain form-group ${hasErrors(bean: assetsHtmInstance, field: 'remarks', 'has-error')} required">
    <label class="control-label col-sm-4" for="remarks">Issuer*</label>
    <div class="col-sm-8"><g:textField name="remarks" id="remarks"  required="" value="${assetsHtmInstance?.remarks}"class="form-control"/>
        <g:hasErrors bean="${assetsHtmInstance}" field="remarks">
            <div class="controls">
                <span class="help-block">
                    <g:eachError bean="${assetsHtmInstance}" field="remarks">
                        <g:message error="${it}" /><br/>
                    </g:eachError>
                </span>
            </div>
        </g:hasErrors>
    </div>             
</div> --%>
<div class="fieldcontain form-group ${hasErrors(bean: assetsHtmInstance, field: 'effectiveYield', 'has-error')} required">
    <label class="control-label col-sm-4" for="effectiveYield">Effective Yield*</label>
    <div class="col-sm-8">
         <g:field class="form-control"  style="text-align:right;" id="effectiveYield" name="effectiveYield" value="${assetsHtmInstance?.effectiveYield}" />
        <g:hasErrors bean="${assetsHtmInstance}" field="effectiveYield">
            <div class="controls">
                <span class="help-block">
                    <g:eachError bean="${assetsHtmInstance}" field="effectiveYield">
                        <g:message error="${it}" /><br/>
                    </g:eachError>
                </span>
            </div>
        </g:hasErrors>
    </div>             
</div>



<div class="fieldcontain form-group ${hasErrors(bean: assetsHtmInstance, field: 'reference', 'has-error')} required">
    <label class="control-label col-sm-4" for="reference">Reference*</label>
    <div class="col-sm-8"><g:textField name="reference" id="reference" required="" value="${assetsHtmInstance?.reference}"class="form-control"/>
        <g:hasErrors bean="${assetsHtmInstance}" field="reference">
            <div class="controls">
                <span class="help-block">
                    <g:eachError bean="${assetsHtmInstance}" field="reference">
                        <g:message error="${it}" /><br/>
                    </g:eachError>
                </span>
            </div>
        </g:hasErrors>
    </div>             
</div>
<%--<g:if test="${assetsHtmInstance}">
<div class="fieldcontain form-group ${hasErrors(bean: assetsHtmInstance, field: 'status', 'has-error')} required">
    <label class="control-label col-sm-4" for="status">Status<span class="required-indicator">*</span>
    </label>
    <div class="col-sm-8">
       <g:select id="status" name="status" from="${icbs.lov.ConfigItemStatus.list()}" optionKey="id" required="" value="${assetsHtmInstance?.status?.id}" class="many-to-one form-control"/>
    </div>             
</div>
</g:if>--%>
<g:hiddenField id="financialYear" name="financialYear" value="${g.formatDate(date: (runDate), format: 'yyyy')}"/>
<g:hiddenField id="branchRunDate" name="branchRunDate" value="${g.formatDate(date: (runDate), format: 'MM/dd/yyyy')}"/>
