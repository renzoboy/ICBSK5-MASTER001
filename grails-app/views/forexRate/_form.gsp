<%@ page import="icbs.admin.ForexRate" %>

<div class="fieldcontain form-group ${hasErrors(bean: forexRateInstance, field: 'currency', 'has-error')} required">
    <label class="control-label col-sm-4" for="currency">
        <g:message code="forexRate.currency.label" default="Received Currency" />
	<span class="required-indicator">*</span>
    </label>
    <div class="col-sm-8"><g:select id="currency" name="currency.id" from="${icbs.admin.Currency.findAll{configItemStatus.id == 2}}" optionKey="id" optionValue="name" required="" value="${forexRateInstance?.currency?.id}" class="many-to-one form-control"/>
        <g:hasErrors bean="${forexRateInstance}" field="currency">
            <div class="controls">
                <span class="help-block">
                    <g:eachError bean="${forexRateInstance}" field="currency">
                        <g:message error="${it}" /><br/>
                    </g:eachError>
                </span>
            </div>
        </g:hasErrors>
    </div>             
</div>

<div class="fieldcontain form-group ${hasErrors(bean: forexRateInstance, field: 'currency2', 'has-error')} required">
    <label class="control-label col-sm-4" for="currency2">
        <g:message code="forexRate.currency2.label" default="Pay Out Currency" />
	<span class="required-indicator">*</span>
    </label>
    <div class="col-sm-8"><g:select id="currency2" name="currency2.id" from="${icbs.admin.Currency.findAll{configItemStatus.id == 2}}" optionKey="id" optionValue="name" required="" value="${forexRateInstance?.currency2?.id}" class="many-to-one form-control"/>
        <g:hasErrors bean="${forexRateInstance}" field="currency2">
            <div class="controls">
                <span class="help-block">
                    <g:eachError bean="${forexRateInstance}" field="currency2">
                        <g:message error="${it}" /><br/>
                    </g:eachError>
                </span>
            </div>
        </g:hasErrors>
    </div>             
</div>


<div><g:hiddenField name="configItemStatus" value="2" /></div>
<div><g:hiddenField name="date" value="${new Date()}" /></div>