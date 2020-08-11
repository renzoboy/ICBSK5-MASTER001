<%@ page import="icbs.admin.UserMaster" %>
<g:hiddenField id="loanID" name="loanID" value="${ropaInstance?.loan}" />
<div class="fieldcontain form-group ${hasErrors(bean: loanLedgerInstance, field: 'loan', 'has-error')} ">
	<label class="control-label col-sm-4" for="loan">
		<g:message code="loanLedger.loan.label" default="Account No." />
        <span class="required-indicator">*</span>
	</label>
	<div class="col-sm-7"><g:field name="accountNo"  value="${ropaInstance?.loan}" class="form-control" readonly="true"/>        

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
    <label class="control-label col-sm-4" for="loan">Borrower Name<span class="required-indicator">*</span></label>
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
<div class="fieldcontain form-group ${hasErrors(bean: ropaInstance, field: 'ropaDate', 'has-error')}">
	<label class="control-label col-sm-4" for="ropaDate">
		ROPA Date
		<span class="required-indicator"></span>
	</label>
    <div class="col-sm-8"> <g:textField value="${icbs.admin.Branch.get(1).runDate.format('YYYY/MM/dd')}" id="valueDate" name="newValueDate" precision="day" class="form-control"  default="none" noSelection="['': '']" disabled="disabled"/>
        <g:hasErrors bean="${ropaInstance}" field="ropaDate">
            <div class="controls">
                <span class="help-block">
                    <g:eachError bean="${ropaInstance}" field="ropaDate">
                        <g:message error="${it}" /><br/>
                    </g:eachError>
                </span>
            </div>
        </g:hasErrors>
    </div>             
</div> 
<%-- ADD NEW COLUMN FOR GL BUILDING--%>                    
<div class="fieldcontain form-group ${hasErrors(bean: ropaInstance, field: 'reference', 'has-error')} required">
    <label class="control-label col-sm-4" for="glContraRopa">Reference<span class="required-indicator"></span> *</label>
    <div class="col-sm-8"><g:textField id="reference" name="reference" required="" value="" class="form-control"/>
        <g:hasErrors bean="${ropaInstance}" field="reference">
            <div class="controls">
                <span class="help-block">
                    <g:eachError bean="${ropaInstance}" field="reference">
                        <g:message error="${it}" /><br/>
                    </g:eachError>
                </span>
            </div>
        </g:hasErrors>
    </div>             
</div>

<div class="fieldcontain form-group ${hasErrors(bean: ropaInstance, field: 'particulars', 'has-error')} required">
    <label class="control-label col-sm-4" for="glContraRopa">Particulars<span class="required-indicator"></span> *</label>
    <div class="col-sm-8"><g:textArea name="particulars" id="particulars" value="" class="form-control" rows="5" cols="40"/>
        <g:hasErrors bean="${ropaInstance}" field="particulars">
            <div class="controls">
                <span class="help-block">
                    <g:eachError bean="${ropaInstance}" field="particulars">
                        <g:message error="${it}" /><br/>
                    </g:eachError>
                </span>
            </div>
        </g:hasErrors>
    </div>             
</div>
