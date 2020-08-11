<%@ page import="icbs.tellering.TxnBillsPayment" %>

<g:hiddenField id="CashReceiptCheckBills" name="CashReceiptCheckBills" value="0"/>
<g:hiddenField name="txnDepID" id="txnDepID" value="${customerInstance?.id}"/>
<div class="form-group">
    <label class="control-label">Transaction Type</label>
    <div class="col-sm-6">
        <select id="txnTemplate" name="txnTemplate" class="many-to-one form-control">
            <option selected="selected" disabled="true">-- Select a transaction type --</option>
            <g:each in="${icbs.admin.TxnTemplate.findAllByTxnTypeAndMemoTxnType(icbs.lov.TxnType.read(20), icbs.lov.MemoTxnType.read(3),[sort:"code", order:"asc"])}" var="txnTemplateInstance">
                <option value="${txnTemplateInstance.id}" data-code="${txnTemplateInstance.code}">${txnTemplateInstance.codeDescription}</option>
            </g:each>
        </select>
    </div>
</div>

<fieldset class="form-group">
    <g:if test="${!txnCheckBillsPaymentInstance?.beneficiary}">
        <input type="button" href="#" class="btn btn-primary" onclick="initializeCustomerDetailsSearchModal('txnBeneficiaryDetailsDiv');modal.show()"value="Search Customer"/>
    </g:if>
</fieldset>

<fieldset class="form-group">
    <div class="col-sm-10" id="txnBeneficiaryDetailsDiv">
        <g:render template='/customer/details/txnCustomerDetails' model="[customerInstance:txnCheckBillsPaymentInstance?.beneficiary]"/>
    </div>
</fieldset>

<div class="fieldcontain form-group ${hasErrors(bean: txnCheckBillsPaymentInstance, field: 'txnAmt', 'has-error')} required">
    <label class="control-label">Transaction Amount</label>
    <div class="col-sm-6">
        <g:textField type="number" name="txnAmt" required="" value="${txnCheckBillsPaymentInstance?.txnAmt}"class="form-control truncated" onkeyup="updateVar()"/>
    </div>
</div>

<div class="form-group form-buttons">
    <button id="add-button" type="button" onclick="showAddChecks()" class="btn btn-primary multi-field-btn-add"><span class="fa fa-plus"></span> Add Check</button>
</div>

<div class="table-responsive" id="check_table">
    <table class="table table-hover table-condensed table-bordered table-striped">
    <tbody>
        <tr>
            <td><label>Check Type</label></td>
            <td><label>Bank</label></td>
            <td><label>Account Number</label></td>
            <td><label>Check Date</label></td>
            <td><label>Check Number</label></td>
            <td><label>Check Amount</label></td>
            <td class="col-sm-2"><label>Actions</label></td>		
	</tr>
    </tbody>
    <tbody>
        <g:if test="${txnCOCIInstance?.checks}">
            <g:each var="check" in="${txnCOCIInstance?.checks.sort{it.description}}">
                <tr>
                    <td>${check?.checkType?.description}</td>
                    <td>${check?.bank?.name}</td>
                    <td>${check?.acctNo}</td>
                    <td>${check?.checkDate}</td>
                    <td>${check?.checkNo}</td>
                    <td>${check?.checkAmt}</td>
                    <td>
                        <a href="#" class="btn btn-secondary" onclick="deleteCheckAjax('${check?.id}')">Remove</a>
                    </td>		
                </tr>
            </g:each>
        </g:if>
        <g:elseif test="${session["checks"]}">
            <g:set var="i" value="${0}" />
            <g:each var="check" in="${session["checks"]}">
                <tr>
                    <td>${check?.checkType?.description}</td>
                    <td>${check?.bank?.name}</td>
                    <td>${check?.acctNo}</td>
                    <td>${check?.checkDate}</td>
                    <td>${check?.checkNo}</td>
                    <td>${check?.checkAmt}</td>
                    <td>
                        <a href="#" class="btn btn-secondary" onclick="deleteCheckAjax('${i}')">Remove</a>
                    </td>		
                </tr>
                <g:set var="i" value="${i = i + 1}" />
            </g:each>		
        </g:elseif>
    </tbody>
    </table>
</div>

<div class="fieldcontain form-group ${hasErrors(bean: txnCheckBillsPaymentInstance, field: 'txnRef', 'has-error')} required">
    <label class="control-label col-sm-4" for="txnRef">
        <g:message code="txnCheckBillsPayment.txnRef.label" default="Transaction Reference" />
    </label>
    <div class="col-sm-6">
        <g:textArea name="txnRef" required="" value="${txnCheckBillsPaymentInstance?.txnRef}"class="form-control"/>
    </div>             
</div>


<div class="fieldcontain form-group ${hasErrors(bean: txnCheckBillsPaymentInstance, field: 'txnParticulars', 'has-error')} ">
    <label class="control-label col-sm-4" for="txnParticulars">
        <g:message code="txnCheckBillsPayment.txnParticulars.label" default="Particulars" />
    </label>
    <div class="col-sm-6">
        <g:textArea name="txnParticulars" maxlength="100" value="${txnCheckBillsPaymentInstance?.txnParticulars}"class="form-control"/>
    </div>             
</div>
