<%@ page import="icbs.lov.ProductType" %>
<%@ page import="icbs.loans.LoanApplication" %>
<%@ page import="icbs.cif.Customer" %>
<legend>Account Application</legend>
<div class="fieldcontain form-group ${hasErrors(bean: loanInstance, field: 'loanApplication', 'has-error')} required">
    
        <g:if test="${loanApplication?.product?.productType?.id == 7}">
        <label class="control-label col-sm-4" for="loanApplication">
            <g:message code="loan.loanApplication.label" default="Account Application" />
            <span class="required-indicator">*</span>
        </label>
        </g:if>
        <g:else>
            <label class="control-label col-sm-4" for="loanApplication">
                <g:message code="loan.loanApplication.label" default="Account Application" />
                <span class="required-indicator">*</span>
            </label>
        </g:else> 
    <div class="col-sm-7"><g:field name="loanApplication" type="number" value="${loanInstance?.loanApplication?.id}" class="form-control" readonly="true"/>

        <g:hasErrors bean="${loanInstance}" field="loanApplication">
            <div class="controls">
                    <span class="help-block">
                        <g:eachError bean="${loanInstance}" field="loanApplication">
                            <g:message error="${it}" /><br/>
                        </g:eachError>
                    </span>
            </div>
        </g:hasErrors>
    </div>

    <g:if test="${!reschedule}">
    <div class="col-sm-2"><input type="button" href="#" class="btn btn-secondary" onclick="showLoanApplicationSearch()" value="Search"/></div>             
    </g:if>
</div>

<br/><br/>

<div id="loan-application-group"></div>