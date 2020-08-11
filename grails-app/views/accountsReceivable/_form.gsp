<%@ page import="icbs.cif.Customer" %>
<%@ page import="icbs.gl.GlAccount" %>

<div class="fieldcontain form-group ${hasErrors(bean: accountsReceivableInstance, field: 'customer', 'has-error')}">
	<label class="control-label col-sm-4" for="customer">
		<g:message code="loanApplication.customer.label" default="Customer Name" />
        <span class="required-indicator">*</span>
	</label>
	<div class="col-sm-7"><g:field name="customer-name" value="${accountsReceivableInstance?.customer?.displayName}" class="form-control" readonly="true"/>
    <g:hiddenField id="customer" name="customer.id" value="${accountsReceivableInstance?.customer?.id}" />
    <%--<g:select id="customer" name="customer.id" from="${icbs.cif.Customer.list()}" optionKey="id" optionValue="displayName" value="${loanApplicationInstance?.customer?.id}" class="many-to-one form-control"  noSelection="[null: 'Select Name']" onchange="updateCustomerInfoAjax(this.value)" />--%>
        <g:hasErrors bean="${accountsReceivableInstance}" field="customer">
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
    <div class="col-sm-2"><input type="button" href="#" class="btn btn-secondary" onclick="showCustomerSearch()" value="Search"/></div>
</div> 

</br>

<div class="col-xs-10 col-sm-11">
    <div class="section-container">
        <fieldset>
            <legend class="section-header">Customer Information</legend>
        

            <table class="table table-bordered table-striped">
                <tbody>
                    <tr>
                        <td style="font-weight:bold" width="30%">Date of Birth</td>
                        <td width="70%"><span id="birth-date"></span></td>
                    </tr>
                    <tr>
                        <td style="font-weight:bold" width="30%">Address</td>
                        <td width="70%"><span id="address"></span></span></td>
                    </tr>
                    <tr>
                        <td style="font-weight:bold" width="30%">Photo</td>
                        <td width="70%"><span id="photo"></span></td>
                    </tr>
                </tbody>
            </table>
        </fieldset>    
    </div>
</div> 

<g:if test="${accountsReceivableInstance?.balance > 0}">

</g:if>
<g:else>
<div class="fieldcontain form-group ${hasErrors(bean: txnTemplateInstance, field: 'txnType', 'has-error')} required">
    <label class="control-label col-sm-4" for="txnType">Txn Type<span class="required-indicator">*</span></label>

    <div class="col-sm-8"><g:select id="txnType" name="txnType" from="${icbs.admin.TxnTemplate.findAllByTxnTypeAndMemoTxnType(icbs.lov.TxnType.read(47),icbs.lov.MemoTxnType.read(1))}"   optionKey="id" optionValue="description" required="" value="" onchange="getcode();" class="many-to-one form-control"/>
    </div>             
</div>
</g:else>
<div class="fieldcontain form-group ${hasErrors(bean: accountsReceivableInstance, field: 'currency', 'has-error')} required">
    <label class="control-label col-sm-4" for="currency">Currency<span class="required-indicator">*</span></label>            
    <div class="col-sm-8">
        <g:select id="currency" name="currency.id" from="${icbs.admin.Currency.list()}" optionKey="id" optionValue="name" required="" value="${accountsReceivableInstance?.currency?.id}" class="many-to-one form-control"/>
        <g:hasErrors bean="${accountsReceivableInstance}" field="currency">
            <div class="controls">
                <span class="help-block">
                    <g:eachError bean="${accountsReceivableInstance}" field="currency">
                        <g:message error="${it}" /><br/>
                    </g:eachError>
                </span>
            </div>
        </g:hasErrors>
    </div>             
</div>
<g:hiddenField id="branchRunDate" name="branchRunDate" value="${g.formatDate(date: (runDate), format: 'MM/dd/yyyy')}"/>
<g:if test="${accountsReceivableInstance}">
    <g:hiddenField id="accountsReceivableId" name="accountsReceivableId" value="${params?.id}"/>
    <g:hiddenField id="xarCreatedDate" name="xarCreatedDate" value="${g.formatDate(date: (accountsReceivableInstance?.arCreatedDate), format: 'MM/dd/yyyy')}"/> 
</g:if>    

<g:if test="${accountsReceivableInstance?.balance > 0}">
<div class="fieldcontain form-group ${hasErrors(bean: accountsReceivableInstance, field: 'balance', 'has-error')} required">
	<label class="control-label col-sm-4" for="memoTxnType">
		<g:message code="txnTemplate.memoTxnType.label" default="Balance*" />
		
	</label>
	<div class="col-sm-8"><g:textField readonly="true" name="errexistbalance" id="errexistbalance" value="${accountsReceivableInstance?.balance}"  class="form-control truncated"/>
            <g:hiddenField name="existbalance" id="existbalance" value="${accountsReceivableInstance?.balance}"/>
            <g:hasErrors bean="${accountsReceivableInstance}" field="memoTxnType">
                <div class="controls">
                        <span class="help-block">
                            <g:eachError bean="${accountsReceivableInstance}" field="memoTxnType">
                                <g:message error="${it}" /><br/>
                            </g:eachError>
                        </span>
                </div>
            </g:hasErrors>
        </div>             
</div>    
<div class="fieldcontain form-group ${hasErrors(bean: accountsReceivableInstance, field: 'glContra', 'has-error')} required">
    <label class="control-label col-sm-4" for="glContra">GL Account Code<span class="required-indicator">*</span></label>
    <div class="col-sm-8"><g:textField name="glContra" id="glContra" required="" value="${accountsReceivableInstance?.glContra}" onblur="validateGlCode();" class="form-control" readonly="true"/>
        <g:hasErrors bean="${accountsReceivableInstance}" field="glContra">
            <div class="controls">
                <span class="help-block">
                    <g:eachError bean="${accountsReceivableInstance}" field="glContra">
                        <g:message error="${it}" /><br/>
                    </g:eachError>
                </span>
            </div>
        </g:hasErrors>
    </div>             
</div>
</g:if>
<g:else>
<div class="fieldcontain form-group ${hasErrors(bean: accountsReceivableInstance, field: 'balance', 'has-error')} required">
	<label class="control-label col-sm-4" for="memoTxnType">
		<g:message code="txnTemplate.memoTxnType.label" default="Balance*" />
		
	</label>
	<div class="col-sm-8"><g:textField  name="existbalance" id="existbalance" value="${accountsReceivableInstance?.balance}" onblur="updateBalance();" class="form-control truncated"/>
            
            <g:hasErrors bean="${accountsReceivableInstance}" field="memoTxnType">
                <div class="controls">
                        <span class="help-block">
                            <g:eachError bean="${accountsReceivableInstance}" field="memoTxnType">
                                <g:message error="${it}" /><br/>
                            </g:eachError>
                        </span>
                </div>
            </g:hasErrors>
        </div>             
</div>    
<div class="fieldcontain form-group ${hasErrors(bean: accountsReceivableInstance, field: 'glContra', 'has-error')} required">
    <label class="control-label col-sm-4" for="glContra">GL Account Code<span class="required-indicator">*</span></label>
    <div class="col-sm-8"><g:textField name="glContra" id="glContra" required="" value="${accountsReceivableInstance?.glContra}" onblur="validateGlCode();" class="form-control" />
        <g:hasErrors bean="${accountsReceivableInstance}" field="glContra">
            <div class="controls">
                <span class="help-block">
                    <g:eachError bean="${accountsReceivableInstance}" field="glContra">
                        <g:message error="${it}" /><br/>
                    </g:eachError>
                </span>
            </div>
        </g:hasErrors>
    </div>             
</div>    
</g:else>
<g:hiddenField name="balance" id="balance" value=""/>        
<div id="glaccountdescription" class="fieldcontain form-group ${hasErrors(bean: txnTemplateInstance, field: 'depcontra', 'has-error')} required">
	<label class="control-label col-sm-4" for="memoTxnType">
		<g:message code="txnTemplate.memoTxnType.label" default="Gl Acct Description" />
		<span class="required-indicator">*</span>
	</label>
	<div class="col-sm-8"><g:textField readonly="true" name="gldescription" id="gldescription" maxlength="100" value="" onblur="validateGlCode();" class="form-control"/>

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
<div class="fieldcontain form-group ${hasErrors(bean: accountsReceivableInstance, field: 'requiredAllowance', 'has-error')} required">
    <label class="control-label col-sm-4" for="requiredAllowance">Required Allowance</label>
    <div class="col-sm-8">
        <g:field class="form-control truncated"  id="requiredAllowance" name="requiredAllowance" value="${accountsReceivableInstance?.requiredAllowance}" />
        <g:hasErrors bean="${accountsReceivableInstance}" field="requiredAllowance">
            <div class="controls">
                <span class="help-block">
                    <g:eachError bean="${accountsReceivableInstance}" field="requiredAllowance">
                        <g:message error="${it}" /><br/>
                    </g:eachError>
                </span>
            </div>
        </g:hasErrors>
    </div>             
</div>
<div class="fieldcontain form-group ${hasErrors(bean: accountsReceivableInstance, field: 'maturityDate', 'has-error')}">
    <label class="control-label col-sm-4" for="maturityDate">Maturity Date*</label>
    <div class="col-sm-8"><g:customDatePicker id="maturityDate" name="maturityDate" precision="day" 
    class="form-control" value="${accountsReceivableInstance?.maturityDate}" />

        <g:hasErrors bean="${accountsReceivableInstance}" field="maturityDate">
            <div class="controls">
                <span class="help-block">
                    <g:eachError bean="${accountsReceivableInstance}" field="maturityDate">
                        <g:message error="${it}" /><br/>
                    </g:eachError>
                </span>
            </div>
        </g:hasErrors>
    </div>             
</div>
<div class="fieldcontain form-group ${hasErrors(bean: accountsReceivableInstance, field: 'receivableName', 'has-error')} required">
    <label class="control-label col-sm-4" for="receivableName">Receivable Name*</label>
    <div class="col-sm-8"><g:textField id="receivableName" name="receivableName" required="" value="${accountsReceivableInstance?.receivableName}"class="form-control"/>
        <g:hasErrors bean="${accountsReceivableInstance}" field="receivableName">
            <div class="controls">
                <span class="help-block">
                    <g:eachError bean="${accountsReceivableInstance}" field="receivableName">
                        <g:message error="${it}" /><br/>
                    </g:eachError>
                </span>
            </div>
        </g:hasErrors>
    </div>             
</div>

<div class="fieldcontain form-group ${hasErrors(bean: accountsReceivableInstance, field: 'description', 'has-error')} required">
    <label class="control-label col-sm-4" for="description">Description*</label>
    <div class="col-sm-8"><g:textField name="description" id="description" required="" value="${accountsReceivableInstance?.description}"class="form-control"/>
        <g:hasErrors bean="${accountsReceivableInstance}" field="description">
            <div class="controls">
                <span class="help-block">
                    <g:eachError bean="${accountsReceivableInstance}" field="description">
                        <g:message error="${it}" /><br/>
                    </g:eachError>
                </span>
            </div>
        </g:hasErrors>
    </div>             
</div>

<div class="fieldcontain form-group ${hasErrors(bean: accountsReceivableInstance, field: 'reference', 'has-error')} required">
    <label class="control-label col-sm-4" for="reference">Reference*</label>
    <div class="col-sm-8"><g:textField id="reference" name="reference" maxlength="100" required="" value="${accountsReceivableInstance?.reference}"class="form-control"/>
        <g:hasErrors bean="${accountsReceivableInstance}" field="reference">
            <div class="controls">
                <span class="help-block">
                    <g:eachError bean="${accountsReceivableInstance}" field="reference">
                        <g:message error="${it}" /><br/>
                    </g:eachError>
                </span>
            </div>
        </g:hasErrors>
    </div>             
</div>
<g:hiddenField id="financialYear" name="financialYear" value="${g.formatDate(date: (runDate), format: 'yyyy')}"/>