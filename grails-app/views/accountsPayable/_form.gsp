<%@ page import="icbs.cif.Customer" %>
<div class="fieldcontain form-group ${hasErrors(bean: accountsPayableInstance, field: 'customer', 'has-error')}">
	<label class="control-label col-sm-4" for="customer">
		<g:message code="loanApplication.customer.label" default="Customer Name" />
        <span class="required-indicator">*</span>
	</label>
	<div class="col-sm-7"><g:field name="customer-name" value="${accountsPayableInstance?.customer?.displayName}" class="form-control" readonly="true"/>
    <g:hiddenField id="customer" name="customer.id" value="${accountsPayableInstance?.customer?.id}" />
    <%--<g:select id="customer" name="customer.id" from="${icbs.cif.Customer.list()}" optionKey="id" optionValue="displayName" value="${loanApplicationInstance?.customer?.id}" class="many-to-one form-control"  noSelection="[null: 'Select Name']" onchange="updateCustomerInfoAjax(this.value)" />--%>
        <g:hasErrors bean="${accountsPayableInstance}" field="customer">
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
<g:if test="${accountsPayableInstance?.balance > 0}">

</g:if>
<g:else>
<div class="fieldcontain form-group ${hasErrors(bean: txnTemplateInstance, field: 'txnType', 'has-error')} required">
    <label class="control-label col-sm-4" for="txnType">Txn Type<span class="required-indicator">*</span></label>

    <div class="col-sm-8"><g:select id="txnType" name="txnType" from="${icbs.admin.TxnTemplate.findAllByTxnTypeAndMemoTxnType(icbs.lov.TxnType.read(50),icbs.lov.MemoTxnType.read(1))}"   optionKey="id" optionValue="description" required="" value="" onchange="getcode();" class="many-to-one form-control"/>
    </div>             
</div>
</g:else>
<div class="fieldcontain form-group ${hasErrors(bean: accountsPayableInstance, field: 'currency', 'has-error')} required">
    <label class="control-label col-sm-4" for="currency">Currency<span class="required-indicator">*</span></label>            
    <div class="col-sm-8">
        <g:select id="currency" name="currency.id" from="${icbs.admin.Currency.list()}" optionKey="id" optionValue="name" required="" value="${accountsPayableInstance?.currency?.id}" class="many-to-one form-control"/>
        <g:hasErrors bean="${accountsPayableInstance}" field="currency">
            <div class="controls">
                <span class="help-block">
                    <g:eachError bean="${accountsPayableInstance}" field="currency">
                        <g:message error="${it}" /><br/>
                    </g:eachError>
                </span>
            </div>
        </g:hasErrors>
    </div>             
</div>

<g:if test="${accountsPayableInstance?.balance > 0}">
<div class="fieldcontain form-group ${hasErrors(bean: txnTemplateInstance, field: 'balance', 'has-error')} required">
	<label class="control-label col-sm-4" for="memoTxnType">
		<g:message code="txnTemplate.memoTxnType.label" default="Balance" />
		
	</label>
	<div class="col-sm-8"><g:textField readonly="true" name="existbalance" id="existbalance" value="${accountsPayableInstance?.balance}"  class="form-control truncated"/>
            
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
<div class="fieldcontain form-group ${hasErrors(bean: accountsPayableInstance, field: 'glContra', 'has-error')} required">
    <label class="control-label col-sm-4" for="glContra">GL Account Code<span class="required-indicator">*</span></label>
    <div class="col-sm-8"><g:textField name="glContra" id="glContra"  required="" value="${accountsPayableInstance?.glContra}" onblur="validateGlCode();" class="form-control" readonly="true"/>
        <g:hasErrors bean="${accountsPayableInstance}" field="glContra">
            <div class="controls">
                <span class="help-block">
                    <g:eachError bean="${accountsPayableInstance}" field="glContra">
                        <g:message error="${it}" /><br/>
                    </g:eachError>
                </span>
            </div>
        </g:hasErrors>
    </div>             
</div>
</g:if>
<g:else>
<div class="fieldcontain form-group ${hasErrors(bean: txnTemplateInstance, field: 'balance', 'has-error')} required">
	<label class="control-label col-sm-4" for="memoTxnType">
		<g:message code="txnTemplate.memoTxnType.label" default="Balance" />
		
	</label>
	<div class="col-sm-8"><g:textField  name="existbalance" id="existbalance" value="${accountsPayableInstance?.balance}" onblur="updateBalance();" class="form-control truncated"/>
            
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
<div class="fieldcontain form-group ${hasErrors(bean: accountsPayableInstance, field: 'glContra', 'has-error')} required">
    <label class="control-label col-sm-4" for="glContra">GL Account Code<span class="required-indicator">*</span></label>
    <div class="col-sm-8"><g:textField name="glContra" id="glContra"  required="" value="${accountsPayableInstance?.glContra}" onblur="validateGlCode();" class="form-control" />
        <g:hasErrors bean="${accountsPayableInstance}" field="glContra">
            <div class="controls">
                <span class="help-block">
                    <g:eachError bean="${accountsPayableInstance}" field="glContra">
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
	<div class="col-sm-8"><g:textField readonly="true" name="gldescription" id="gldescription" value="${txnTemplateInstance?.amlaCode}" onblur="validateGlCode();" class="form-control"/>

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
<div class="fieldcontain form-group ${hasErrors(bean: accountsPayableInstance, field: 'payable', 'has-error')} required">
    <label class="control-label col-sm-4" for="payable">Payable<span class="required-indicator">*</span></label>
    <div class="col-sm-8"><g:textField id="payable" name="payable"  required="" value="${accountsPayableInstance?.payable}"class="form-control"/>
        <g:hasErrors bean="${accountsReceivableInstance}" field="payable">
            <div class="controls">
                <span class="help-block">
                    <g:eachError bean="${accountsPayableInstance}" field="payable">
                        <g:message error="${it}" /><br/>
                    </g:eachError>
                </span>
            </div>
        </g:hasErrors>
    </div>             
</div>

 <g:hiddenField name="accountsPayableId" id="accountsPayableId" value="${params.id}" />
<div class="fieldcontain form-group ${hasErrors(bean: accountsPayableInstance, field: 'particulars', 'has-error')} required">
    <label class="control-label col-sm-4" for="particulars">Reference<span class="required-indicator">*</span></label>
    <div class="col-sm-8"><g:textField id="reference" name="reference"  required="" value="${accountsPayableInstance?.reference}"class="form-control"/>
        <g:hasErrors bean="${accountsPayableInstance}" field="reference">
            <div class="controls">
                <span class="help-block">
                    <g:eachError bean="${accountsPayableInstance}" field="reference">
                        <g:message error="${it}" /><br/>
                    </g:eachError>
                </span>
            </div>
        </g:hasErrors>
    </div>             
</div>
<div class="fieldcontain form-group ${hasErrors(bean: accountsPayableInstance, field: 'particulars', 'has-error')} required">
    <label class="control-label col-sm-4" for="particulars">Particulars<span class="required-indicator">*</span></label>
    <div class="col-sm-8"><g:textField id="particulars" name="particulars"  required="" value="${accountsPayableInstance?.particulars}"class="form-control"/>
        <g:hasErrors bean="${accountsPayableInstance}" field="particulars">
            <div class="controls">
                <span class="help-block">
                    <g:eachError bean="${accountsPayableInstance}" field="particulars">
                        <g:message error="${it}" /><br/>
                    </g:eachError>
                </span>
            </div>
        </g:hasErrors>
    </div>             
</div>
<g:hiddenField id="financialYear" name="financialYear" value="${g.formatDate(date: (runDate), format: 'yyyy')}"/>