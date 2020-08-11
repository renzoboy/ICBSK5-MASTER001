<%@ page import="icbs.gl.CashInBank" %>
<!DOCTYPE html>
<html>
    <head>
	<meta name="layout" content="main">
	<title>Cash in Bank Fund Transfer Transaction</title>
    </head>
    <body>
        <content tag="breadcrumbs">
                <span class="fa fa-chevron-right"></span><a href="${createLink(uri: '/cashInBank')}">Cash in Bank/Due From Bank Subsidiary Ledger</a>
                <span class="fa fa-chevron-right"></span><span class="current">Create New Cash in Bank Check Transaction</span>
        </content>
	<content tag="main-content">
            <div id="create-cashInBankCheckBook" class="content scaffold-create" role="main">
		<g:if test="${flash.message}">
                    <div class="message" role="status">${flash.message}</div>
		</g:if>
		<g:hasErrors bean="${cashInBankInstance}">
                    <ul class="errors" role="alert">
			<g:eachError bean="${cashInBankInstance}" var="error">
			<li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
			</g:eachError>
                    </ul>
		</g:hasErrors>
		<g:form id="create" url="[resource:cashInBankInstance, action:'saveFundTransfer']" >
                    <fieldset class="form">
                        <div class="fieldcontain form-group ${hasErrors(bean: txnTemplateInstance, field: 'txnType', 'has-error')} required">
                            <label class="control-label col-sm-4" for="txnType">Debit (Source of Funds)<span class="required-indicator">*</span></label>                                    
                            <div class="col-sm-8">
                                <g:select id="drTxnType" name="drTxnType" from="${icbs.admin.TxnTemplate.findAllByTxnTypeAndMemoTxnType(icbs.lov.TxnType.read(44),icbs.lov.MemoTxnType.read(1))}"   optionKey="id" optionValue="description" required="" value="" onchange="getcode();" class="many-to-one form-control"/>
                            </div>             
                        </div>
                        <div class="fieldcontain form-group ${hasErrors(bean: cashInBankInstance, field: 'bankName', 'has-error')} required">
                            <label class="control-label col-sm-4" for="txnType">Source of Funds<span class="required-indicator">*</span></label>                                    
                            <div class="col-sm-8">
                                <g:select id="drBank" name="drBank" from="${icbs.gl.CashInBank.findAllByStatus(icbs.lov.DepositStatus.read(2))}"   optionKey="id" optionValue="description" required="" value="" onchange="getcode();" class="many-to-one form-control"/>
                            </div>             
                        </div>
                        
                        <div class="fieldcontain form-group ${hasErrors(bean: txnTemplateInstance, field: 'txnType', 'has-error')} required">
                            <label class="control-label col-sm-4" for="txnType">Credit (Destination of Funds)<span class="required-indicator">*</span></label>                                    
                            <div class="col-sm-8">
                                <g:select id="crTxnType" name="crTxnType" from="${icbs.admin.TxnTemplate.findAllByTxnTypeAndMemoTxnType(icbs.lov.TxnType.read(43),icbs.lov.MemoTxnType.read(1))}"   optionKey="id" optionValue="description" required="" value="" onchange="getcode();" class="many-to-one form-control"/>
                            </div>             
                        </div>
                        <div class="fieldcontain form-group ${hasErrors(bean: cashInBankInstance, field: 'bankName', 'has-error')} required">
                            <label class="control-label col-sm-4" for="txnType">Destination of Funds<span class="required-indicator">*</span></label>                                    
                            <div class="col-sm-8">
                                <g:select id="crBank" name="crBank" from="${icbs.gl.CashInBank.findAllByStatus(icbs.lov.DepositStatus.read(2))}"   optionKey="id" optionValue="description" required="" value="" onchange="getcode();" class="many-to-one form-control"/>
                            </div>             
                        </div>

                        <div class="fieldcontain form-group">
                            <label class="control-label col-sm-4" for="intRate">Transfer Amount<span class="required-indicator">*</span></label>                         
                            <div class="col-sm-8">
                                <g:field class="form-control truncated" id="debitAdjustment" name="debitAdjustment" value="" />
                            </div>             
                        </div>
                                 
                        <div class="fieldcontain form-group">
                            <label class="control-label col-sm-4" for="intRate">Reference <span class="required-indicator">*</span></label>
                            <div class="col-sm-8">
                                <g:field class="form-control" type="Text"  id="reference"  name="reference" value="" />
                            </div>             
                        </div>   
                        <div class="fieldcontain form-group">
                            <label class="control-label col-sm-4" for="intRate">Particulars <span class="required-indicator">*</span></label>     
                            <div class="col-sm-8">
                                <g:field class="form-control" type="Text" id="particulars"   name="particulars" value="" />
                            </div>             
                        </div>  

                    </fieldset>
		</g:form>
            </div>
	</content>
	<content tag="main-actions">
            <ul>
		<li><g:submitButton id="newFT" name="create" value="${message(code: 'default.button.create.label', default: 'Create')}" onclick="
                        alertify.confirm(AppTitle,'Are you sure you want to continue Cash in Bank Fund Transfer Transaction?',
                            function(){
                                    checkIfAllowed('ADM00102', 'form#create', 'Create New Cash in Bank Checkbook', null); 
                                },
                                function(){
                                    return;
                            }); 
                "/></li>
		<li><g:link action="index"><g:message code="default.cancel.label" args="[entityName]" default="Cancel" /></g:link></li>
            </ul>
	</content>
    </body>
</html>