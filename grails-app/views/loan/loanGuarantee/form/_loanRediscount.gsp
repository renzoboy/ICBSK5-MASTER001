<!--
  To change this license header, choose License Headers in Project Properties.
  To change this template file, choose Tools | Templates
  and open the template in the editor.
-->

<%@ page contentType="text/html;charset=UTF-8" %>

<div class="form-group fieldcontain ${hasErrors(bean: loanRediscountingInstance, field: 'dateGranted', 'has-error')} ">
	<label class="control-label col-sm-4"for="dateGranted">
		<g:message code="loan.dateGranted.label" default="Date Granted" />
		<span class="required-indicator"></span>
	</label>
	 <div class="col-sm-8">
               <g:customDatePicker  id="dateGranted" name="dateGranted" value="${loanRediscountingInstance?.dateGranted}"class="form-control"  />
                <g:hasErrors bean="${loanRediscountingInstance}" field="dateGranted">
                <div class="controls">
                    <span class="help-block">
                        <g:eachError bean="${loanRediscountingInstance}" field="dateGranted" >
                            <g:message error="${it}" /><br/>
                        </g:eachError>
                    </span>
                </div>
             </g:hasErrors>   
         </div>
</div>
<div class="form-group fieldcontain ${hasErrors(bean: loanRediscountingInstance, field: 'maturityDate', 'has-error')} ">
	<label class="control-label col-sm-4"for="maturityDate">
		<g:message code="loan.maturityDate.label" default="Maturity Date" />
		<span class="required-indicator"></span>
	</label>
	 <div class="col-sm-8">
               <g:customDatePicker  id="maturityDate" name="maturityDate" value="${loanRediscountingInstance?.maturityDate}"class="form-control"  />
                <g:hasErrors bean="${loanRediscountingInstance}" field="maturityDate">
                <div class="controls">
                    <span class="help-block">
                        <g:eachError bean="${loanRediscountingInstance}" field="maturityDate" >
                            <g:message error="${it}" /><br/>
                        </g:eachError>
                    </span>
                </div>
             </g:hasErrors>   
         </div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: loanRediscountingInstance, field: 'pnNo', 'has-error')} ">
	<label class="control-label col-sm-4"for="pnNo">
		<g:message code="loan.pnNo.label" default="PN No." />
		<span class="required-indicator"></span>
	</label>
	 <div class="col-sm-8">
                <g:field type="text" id="pnNo"name="pnNo"  value="${loanRediscountingInstance?.pnNo}"class="form-control"/>
                <g:hasErrors bean="${loanRediscountingInstance}" field="pnNo">
                <div class="controls">
                    <span class="help-block">
                        <g:eachError bean="${loanRediscountingInstance}" field="pnNo" >
                            <g:message error="${it}" /><br/>
                        </g:eachError>
                    </span>
                </div>
             </g:hasErrors>   
         </div>
</div>
<div class="fieldcontain form-group ${hasErrors(bean: loanRediscountingInstance, field: 'loanRediscountingPartner', 'has-error')} required">
    <label class="control-label col-sm-4" for="loanRediscountingInstance">
	    <g:message code="loan.loanRediscountingInstance.label" default="Rediscounting Partner" />
	</label>
    <div class="col-sm-8">
        <g:select id="loanRediscountingPartner" name="loanRediscountingPartner" from="${icbs.lov.LoanRediscountingPartner.list()}" optionKey="id" optionValue="description" required="" value="${loanRediscountingInstance?.loanRediscountingPartner?.id}" class="many-to-one form-control"/>
        <g:hasErrors bean="${loanRediscountingInstance}" field="loanRediscountingPartner">
            <div class="controls">
                <span class="help-block">
                    <g:eachError bean="${loanRediscountingInstance}" field="loanRediscountingPartner">
                        <g:message error="${it}" /><br/>
                    </g:eachError>
                </span>
            </div>
        </g:hasErrors>
    </div>             
</div>
<g:if test="${loanRediscountingInstance}">
<div class="fieldcontain form-group ${hasErrors(bean: loanRediscountingInstance, field: 'loanRediscountingPartner', 'has-error')} required">
    <label class="control-label col-sm-4" for="loanRediscountingInstance">
	    <g:message code="loan.loanRediscountingInstance.label" default="Rediscounting Status" />
	</label>
    <div class="col-sm-8">
        <g:select id="loanRediscountingStatus" name="loanRediscountingStatus" from="${icbs.loans.LoanRediscountingStatus.list()}" optionKey="id" optionValue="description" required="" value="${loanRediscountingInstance?.loanRediscountingStatus?.id}" class="many-to-one form-control"/>
        <g:hasErrors bean="${loanRediscountingInstance}" field="loanRediscountingStatus">
            <div class="controls">
                <span class="help-block">
                    <g:eachError bean="${loanRediscountingInstance}" field="loanRediscountingStatus">
                        <g:message error="${it}" /><br/>
                    </g:eachError>
                </span>
            </div>
        </g:hasErrors>
    </div>             
</div>
</g:if>

