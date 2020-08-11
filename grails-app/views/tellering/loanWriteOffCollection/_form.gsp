<%@ page import="icbs.loans.LoanLedger" %>
<%@ page import="icbs.admin.Branch" %>
<%@ page import="icbs.admin.UserMaster" %>
<%@ page import="icbs.lov.WriteOffCollectionType" %>




<div class="fieldcontain form-group ${hasErrors(bean: loanLedgerInstance, field: 'txnType', 'has-error')} ">
    <label class="control-label col-sm-4" for="txnType">
        <g:message code="loanLedger.txnType.label" default="Transaction Type*" />        
    </label>
    <div class="col-sm-8">
        <g:select id="txnTemplate" name="txnTemplate.id" from="${icbs.admin.TxnTemplate.findAll{txnType.id == 67}}"  optionKey="id" optionValue="description" value="" class="many-to-one form-control" onchange="updateForm()" />
    </div>             
</div>

<div class="fieldcontain form-group ${hasErrors(bean: loanLedgerInstance, field: 'loan', 'has-error')} ">
	<label class="control-label col-sm-4" for="loan">
		<g:message code="loanLedger.loan.label" default="Account*" />
        <span class="required-indicator">*</span>
	</label>
	<div class="col-sm-7"><g:field name="accountNo" value="${loanLedgerInstance?.loan?.accountNo}" class="form-control" readonly="true"/>        

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

<g:hiddenField id="loan" name="loan.id" value="${loanLedgerInstance?.loan?.id}" />

<br/><br/>

<div id="customer-info">
    <div class="infowrap">
        <table class="table table-bordered table-striped">
            <legend class="section-header">Account Details</legend>
                <tr>
                    <td style="width: 30%;"><label>Customer</label></td>
                    <td style="width: 70%;"><span id="customer"></span></td>
                </tr>                                
                <tr>
                    <td><label>Granted Amount</label></td>
                    <td><span id="granted-amount"></span></td>
                </tr>                         
                <tr>
                    <td><label>Interest Rate</label></td>
                    <td><span id="interest-rate"></span></td>
                </tr>   
                <tr>
                    <td><label>Maturity Date</label></td>
                    <td><span id="maturity-date"></span></td>
                </tr>
                <tr>
                    <td><label>Total Net Proceeds</label></td>
                    <td><span id="total-net-proceeds"></span></td>
                </tr>
                <tr>
                    <td><label>Total Disburse Amount</label></td>
                    <td> <span id="total-disbursement-amount"></span></td>
                </tr>
                <tr>
                    <td><label>Principal Balance</label></td>
                    <td><span id="principal-balance"></span></td>
                </tr>
                <tr>
                    <td><label>Overdue Principal Balance</label></td>
                    <td><span id="overdue-principal-balance"></span></td>
                </tr>
                <tr>
                    <td><label>Interest Balance</label></td>
                    <td><span id="interest-balance"></span></td>
                </tr>
                <tr>
                    <td><label>Penalty Balance</label></td>
                    <td><span id="penalty-balance"></span></td>
                </tr>
                <tr>
                    <td><label>Service Charge Balance</label></td>
                    <td><span id="service-charge-balance"></span></td>
                </tr>
                <tr>
                    <td><label>Account Status</label></td>
                    <td><span id="loan-status"></span></td>
                </tr>
        </table>
    </div>
  
</div>
<div id="interest-credit-form-group" class="fieldcontain form-group ${hasErrors(bean: loanLedgerInstance, field: 'interestCredit', 'has-error')} ">
	<label class="control-label col-sm-4" for="interestCredit">
		<g:message code="loanLedger.interestCredit.label" default="Collection Type*" />
	</label>
	<div class="col-sm-8">
            <g:select name="collectionType" id="collectionType" from="${WriteOffCollectionType.findAll{status == true}}" value="" optionKey="id" optionValue="description" class="form-control" noSelection="['':'-Select Collection Type-']"/>
        </div>             
</div>
<div id="interest-credit-form-group" class="fieldcontain form-group ${hasErrors(bean: loanLedgerInstance, field: 'interestCredit', 'has-error')} ">
	<label class="control-label col-sm-4" for="interestCredit">
		<g:message code="loanLedger.interestCredit.label" default="Collection Amount*" />
	</label>
	<div class="col-sm-8">
            <g:field  name="collectionAmt" id="collectionAmt" value="" class="form-control truncated" />
        </div>             
</div>
<div id="interest-credit-form-group" class="fieldcontain form-group ${hasErrors(bean: loanLedgerInstance, field: 'interestCredit', 'has-error')} ">
	<label class="control-label col-sm-4" for="interestCredit">
		<g:message code="loanLedger.interestCredit.label" default="Collected By*" />
	</label>
	<div class="col-sm-8">
            <g:select name="collectedBy" id="collectedBy" from="${UserMaster.list()}" value="" optionKey="id" optionValue="name" class="form-control" noSelection="['':'-Choose Collector-']"/>
        </div>             
</div>
<div id="interest-credit-form-group" class="fieldcontain form-group ${hasErrors(bean: loanLedgerInstance, field: 'interestCredit', 'has-error')} ">
	<label class="control-label col-sm-4" for="interestCredit">
		<g:message code="loanLedger.interestCredit.label" default="Reference*" />
	</label>
	<div class="col-sm-8">
            <g:field name="txnReference" id="txnReference" value="" class="form-control" />
        </div>             
</div>
<div id="interest-credit-form-group" class="fieldcontain form-group ${hasErrors(bean: loanLedgerInstance, field: 'interestCredit', 'has-error')} ">
	<label class="control-label col-sm-4" for="interestCredit">
		<g:message code="loanLedger.interestCredit.label" default="Particulars*" />
	</label>
	<div class="col-sm-8">
            <g:textArea name="txnParticulars" id="txnParticulars" value="" rows="5" cols="40" class="form-control"/>
        </div>             
</div>
