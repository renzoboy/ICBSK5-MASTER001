<%@ page import="icbs.tellering.TxnBillsPayment" %>
<%@ page import="icbs.cif.Customer" %>
<div class="fieldcontain form-group ${hasErrors(bean: accountsPayableInstance, field: 'customer', 'has-error')}">
	<label class="control-label col-sm-4" for="customer">
		<g:message code="loanApplication.customer.label" default="Customer Name" />
        <span class="required-indicator">*</span>
	</label>
	<div class="col-sm-6"><g:field name="customer-name" value="${accountsPayableInstance?.customer?.displayName}" class="form-control" readonly="true"/>
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

<div class="form-group">
    <label class="control-label">Transaction Type</label>
    <div class="col-sm-6">
        <select id="txnTemplate" name="txnTemplate" class="many-to-one form-control">
            <option selected="selected" disabled="true">-- Select a transaction type --</option>
            <g:each in="${icbs.admin.TxnTemplate.findAllByTxnTypeAndMemoTxnType(icbs.lov.TxnType.read(19), icbs.lov.MemoTxnType.read(3),[sort:"code", order:"asc"])}" var="txnTemplateInstance">
                <option value="${txnTemplateInstance.id}" data-code="${txnTemplateInstance.code}">${txnTemplateInstance.codeDescription}</option>
            </g:each>
        </select>
    </div>
</div>

<%-- comment for some chanages in the layout
<fieldset class="form-group">
<g:if test="${!txnCashReceiptRemittanceInstance?.beneficiary}">
    <input type="button" href="#" class="btn btn-primary" onclick="initializeCustomerDetailsSearchModal('txnBeneficiaryDetailsDiv');modal.show()"value="Search Customer"/>
</g:if>
</fieldset>

<fieldset class="form-group">
    <div class="col-sm-10" id="txnBeneficiaryDetailsDiv">
        <g:render template='/customer/details/txnCustomerDetails' model="[customerInstance:txnBillsPaymentInstance?.beneficiary]"/>
    </div>
</fieldset> --%>

<div class="fieldcontain form-group ${hasErrors(bean: txnBillsPaymentInstance, field: 'txnAmt', 'has-error')} required">
    <label class="control-label">Transaction Amount</label>
    <div class="col-sm-6">
        <g:textField id="txnAmt" name="txnAmt" required="" value="${txnBillsPaymentInstance?.txnAmt}" class="form-control truncated" onkeyup="updateVar()"/>
   </div>             
</div>


<div class="fieldcontain form-group ${hasErrors(bean: txnBillsPaymentInstance, field: 'txnRef', 'has-error')} required">
    <label class="control-label col-sm-4" for="txnRef">
        <g:message code="txnBillsPayment.txnRef.label" default="Transaction Reference" />
    </label>
    <div class="col-sm-6">
        <g:textArea name="txnRef" id="txnRef" required="" value="${txnBillsPaymentInstance?.txnRef}"class="form-control"/>
    </div>             
</div>


<div class="fieldcontain form-group ${hasErrors(bean: txnBillsPaymentInstance, field: 'txnParticulars', 'has-error')} ">
    <label class="control-label col-sm-4" for="txnParticulars">
        <g:message code="txnBillsPayment.txnParticulars.label" default="Particulars" />
    </label>
    <div class="col-sm-6">
        <g:textArea name="txnParticulars" id="txnParticulars" value="${txnBillsPaymentInstance?.txnParticulars}"class="form-control"/>
    </div>             
</div>
