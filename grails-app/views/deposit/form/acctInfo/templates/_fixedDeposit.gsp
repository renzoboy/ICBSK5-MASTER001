<!--
  To change this license header, choose License Headers in Project Properties.
  To change this template file, choose Tools | Templates
  and open the template in the editor.
-->

<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="icbs.admin.Branch" %>
<%@ page import="icbs.admin.UserMaster" %>

<div class="fieldcontain form-group ${hasErrors(bean: depositInstance, field: 'acctName', 'has-error')} ">
                <label class="control-label col-sm-4" for="acctName">
                        <g:message code="deposit.acctName.label" default="Account Name" />

                </label>
                <div class="col-sm-8"> <g:field name="acctName" class="form-control"  value="${depositInstance?.acctName?:depositInstance?.customer?.displayName}" />

                    <g:hasErrors bean="${depositInstance}" field="acctName">
                        <div class="controls">
                                <span class="help-block">
                                    <g:eachError bean="${depositInstance}" field="acctName">
                                        <g:message error="${it}" /><br/>
                                    </g:eachError>
                                </span>
                        </div>
                    </g:hasErrors>
                </div>             
            </div>
            <div class="fieldcontain form-group ${hasErrors(bean: depositInstance, field: 'depositInterestScheme', 'has-error')} ">
                    <label class="control-label col-sm-4" for="depositInterestScheme">
                            <g:message code="deposit.depositInterestScheme.label" default="Deposit Interest Scheme" />

                    </label>
                    <g:hiddenField id="depositInterestScheme" name="depositInterestScheme.id" value="${depositInstance?.depositInterestScheme?.id}"/>
                    <div class="col-sm-8"><g:select id="depositInterestScheme" disabled="disabled" name="depositInterestScheme.id" from="${icbs.deposit.DepositInterestScheme.list()}" optionKey="id" value="${depositInstance?.depositInterestScheme?.id}" class="many-to-one form-control" noSelection="['null': '']"/>

                        <g:hasErrors bean="${depositInstance}" field="depositInterestScheme">
                            <div class="controls">
                                    <span class="help-block">
                                        <g:eachError bean="${depositInstance}" field="depositInterestScheme">
                                            <g:message error="${it}" /><br/>
                                        </g:eachError>
                                    </span>
                            </div>
                        </g:hasErrors>
                    </div>             
                </div>
            <div class="fieldcontain form-group ${hasErrors(bean: depositInstance, field: 'depositTaxChargeScheme', 'has-error')} ">
                    <label class="control-label col-sm-4" for="depositTaxChargeScheme">
                            <g:message code="deposit.depositTaxChargeScheme.label" default="Deposit Tax Charge Scheme" />
                            <span class="required-indicator">*</span>
                    </label>
                    <div class="col-sm-8"><g:select id="depositTaxChargeScheme" name="depositTaxChargeScheme.id" from="${icbs.deposit.DepositTaxFeeAndChargeScheme.findAllByTypeInList([icbs.lov.TaxFeeCharge.read(1),icbs.lov.TaxFeeCharge.read(2)])}" optionKey="id" value="${depositInstance?.depositTaxChargeScheme?.id}" class="many-to-one form-control" noSelection="['null': '']"/>

                        <g:hasErrors bean="${depositInstance}" field="depositTaxChargeScheme">
                            <div class="controls">
                                    <span class="help-block">
                                        <g:eachError bean="${depositInstance}" field="depositTaxChargeScheme">
                                            <g:message error="${it}" /><br/>
                                        </g:eachError>
                                    </span>
                            </div>
                        </g:hasErrors>
                    </div>             
                </div>
            <div class="fieldcontain form-group ${hasErrors(bean: depositInstance, field: 'fixedDepositPreTermScheme', 'has-error')} ">
                <label class="control-label col-sm-4" for="fixedDepositPreTermScheme">
                        <g:message code="deposit.fixedDepositPreTermScheme.label" default="Fixed Deposit Pre Term Scheme" />

                </label>
                <g:hiddenField id="fixedDepositPreTermScheme" name="fixedDepositPreTermScheme.id" value="${depositInstance?.fixedDepositPreTermScheme?.id}"/>
                <div class="col-sm-8"><g:select disabled="disabled" id="fixedDepositPreTermScheme" name="fixedDepositPreTermScheme.id" from="${icbs.deposit.FixedDepositPreTermScheme.list()}" optionKey="id" value="${depositInstance?.fixedDepositPreTermScheme?.id}" class="many-to-one form-control" noSelection="['null': '']"/>

                    <g:hasErrors bean="${depositInstance}" field="fixedDepositPreTermScheme">
                        <div class="controls">
                                <span class="help-block">
                                    <g:eachError bean="${depositInstance}" field="fixedDepositPreTermScheme">
                                        <g:message error="${it}" /><br/>
                                    </g:eachError>
                                </span>
                        </div>
                    </g:hasErrors>
                </div>             
            </div>
            <div class="fieldcontain form-group ${hasErrors(bean: depositInstance, field: 'fixedDepositTermScheme', 'has-error')} ">
                <label class="control-label col-sm-4" for="depositInterestScheme">
                        <g:message code="deposit.fixedDepositTermScheme.label" default="Fixed Deposit Term Scheme" />
                </label>
                <div class="col-sm-8">
                        <g:hiddenField id="fixedDepositTermScheme" name="fixedDepositTermScheme.id" value="${depositInstance?.fixedDepositTermScheme?.id}"/>
                        <g:select disabled="disabled" id="fixedDepositTermScheme" name="fixedDepositTermScheme.id"from="${icbs.deposit.FixedDepositTermScheme.list()}" optionKey="id"  value="${depositInstance?.fixedDepositTermScheme?.id}" class="many-to-one form-control" noSelection="['null': '']"/>
                    <g:hasErrors bean="${depositInstance}" field="fixedDepositTermScheme">
                        <div class="controls">
                                <span class="help-block">
                                    <g:eachError bean="${depositInstance}" field="fixedDepositTermScheme">
                                        <g:message error="${it}" /><br/>
                                    </g:eachError>
                                </span>
                        </div>
                    </g:hasErrors>
                </div>             
            </div>
            <div class="fieldcontain form-group ${hasErrors(bean: depositInstance, field: 'interestRate', 'has-error')} ">
                <label class="control-label col-sm-4" for="interestRate">
                        <g:message code="deposit.interestRate.label" default="Interest Rate" />

                </label>
                <div class="col-sm-8">
                    <g:if test="${depositInstance?.depositInterestScheme?.canChangeInterestRate==true}">
                        <g:field name="interestRate" value="${fieldValue(bean: depositInstance, field: 'interestRate')?:fieldValue(bean: depositInstance, field: 'depositInterestScheme.interestRate')}" class="form-control"/>
                    </g:if>
                    <g:else>
                        <g:hiddenField name="interestRate" value="${fieldValue(bean: depositInstance, field: 'interestRate')}"/>
                        <g:field name="interestRate" disabled="disabled"value="${fieldValue(bean: depositInstance, field: 'interestRate')?:fieldValue(bean: depositInstance, field: 'depositInterestScheme.interestRate')}" class="form-control"/>
                    </g:else>
                    <g:hasErrors bean="${depositInstance}" field="interestRate">
                        <div class="controls">
                                <span class="help-block">
                                    <g:eachError bean="${depositInstance}" field="interestRate">
                                        <g:message error="${it}" /><br/>
                                    </g:eachError>
                                </span>
                        </div>
                    </g:hasErrors>
                </div>             
            </div>
            
    <g:if test="${depositInstance.depositInterestScheme.fdMonthlyTransfer == false}">
    <div class="fieldcontain form-group ${hasErrors(bean: depositInstance, field: 'maturityDate', 'has-error')} required">
        <label class="control-label col-sm-4" for="maturityDate">
            <g:message code="maturityDate.label" default="FD Monthly Transfer" />
            <span class="required-indicator">*</span>
        </label>
            <!--<div class="col-sm-8"><g:field name="currentRollover.endDate" readonly="true" precision="day" class="form-control"  value="${depositInstance ? depositInstance?.currentRollover?.endDate?:Branch?.get(1).runDate +depositInstance?.fixedDepositTermScheme?.value.toInteger():currentRollover?.endDate}" />-->
        <div class="col-sm-8"><g:textField name="fdMonthlyTransfer" value="${depositInstance?.depositInterestScheme?.fdMonthlyTransfer}" disabled="disable" class="form-control" />
            <g:hasErrors bean="${depositInstance}" field="currentRollover.endDate">
                <div class="controls">
                    <span class="help-block">
                        <g:eachError bean="${depositInstance}" field="currentRollover.endDate">
                            <g:message error="${it}" /><br/>
                        </g:eachError>
                    </span>
                </div>
            </g:hasErrors>
        </div>             
    </div>    
    <div class="fieldcontain form-group ${hasErrors(bean: depositInstance, field: 'maturityDate', 'has-error')} required">
        <label class="control-label col-sm-4" for="maturityDate">
            <g:message code="maturityDate.label" default="Maturity Date" />
            <span class="required-indicator">*</span>
        </label>
            <!--<div class="col-sm-8"><g:field name="currentRollover.endDate" readonly="true" precision="day" class="form-control"  value="${depositInstance ? depositInstance?.currentRollover?.endDate?:Branch?.get(1).runDate +depositInstance?.fixedDepositTermScheme?.value.toInteger():currentRollover?.endDate}" />-->
        <div class="col-sm-8"><g:customDatePicker name="maturityDate" precision="day" class="form-control"  value="${depositInstance?.maturityDate}"  />
            <g:hasErrors bean="${depositInstance}" field="currentRollover.endDate">
                <div class="controls">
                    <span class="help-block">
                        <g:eachError bean="${depositInstance}" field="currentRollover.endDate">
                            <g:message error="${it}" /><br/>
                        </g:eachError>
                    </span>
                </div>
            </g:hasErrors>
        </div>             
    </div> 
    
    </g:if>
    <g:else>
    <div class="fieldcontain form-group ${hasErrors(bean: depositInstance, field: 'maturityDate', 'has-error')} required">
        <label class="control-label col-sm-4" for="maturityDate">
            <g:message code="maturityDate.label" default="FD Monthly Transfer" />
            <span class="required-indicator">*</span>
        </label>
            <!--<div class="col-sm-8"><g:field name="currentRollover.endDate" readonly="true" precision="day" class="form-control"  value="${depositInstance ? depositInstance?.currentRollover?.endDate?:Branch?.get(1).runDate +depositInstance?.fixedDepositTermScheme?.value.toInteger():currentRollover?.endDate}" />-->
        <div class="col-sm-8"><g:textField name="fdMonthlyTransfer" value="${depositInstance?.depositInterestScheme?.fdMonthlyTransfer}" disabled="disable" class="form-control" />
            <g:hasErrors bean="${depositInstance}" field="currentRollover.endDate">
                <div class="controls">
                    <span class="help-block">
                        <g:eachError bean="${depositInstance}" field="currentRollover.endDate">
                            <g:message error="${it}" /><br/>
                        </g:eachError>
                    </span>
                </div>
            </g:hasErrors>
        </div>             
    </div>
        <div class="fieldcontain form-group ${hasErrors(bean: depositInstance, field: 'maturityDate', 'has-error')} required">
        <label class="control-label col-sm-4" for="maturityDate">
            <g:message code="maturityDate.label" default="Rollover End Date" />
            <span class="required-indicator">*</span>
        </label>
            <!--<div class="col-sm-8"><g:field name="currentRollover.endDate" readonly="true" precision="day" class="form-control"  value="${depositInstance ? depositInstance?.currentRollover?.endDate?:Branch?.get(1).runDate +depositInstance?.fixedDepositTermScheme?.value.toInteger():currentRollover?.endDate}" />-->
        <div class="col-sm-8"><g:customDatePicker name="rollOverEndDate" precision="day" class="form-control"  value="${depositInstance?.currentRollover?.endDate}"  />
            <g:hasErrors bean="${depositInstance}" field="currentRollover.endDate">
                <div class="controls">
                    <span class="help-block">
                        <g:eachError bean="${depositInstance}" field="currentRollover.endDate">
                            <g:message error="${it}" /><br/>
                        </g:eachError>
                    </span>
                </div>
            </g:hasErrors>
        </div>             
    </div>
    <div class="fieldcontain form-group ${hasErrors(bean: depositInstance, field: 'maturityDate', 'has-error')} required">
        <label class="control-label col-sm-4" for="maturityDate">
            <g:message code="maturityDate.label" default="Maturity Date" />
            <span class="required-indicator">*</span>
        </label>
            <!--<div class="col-sm-8"><g:field name="currentRollover.endDate" readonly="true" precision="day" class="form-control"  value="${depositInstance ? depositInstance?.currentRollover?.endDate?:Branch?.get(1).runDate +depositInstance?.fixedDepositTermScheme?.value.toInteger():currentRollover?.endDate}" />-->
        <div class="col-sm-8"><g:customDatePicker name="maturityDate" precision="day" class="form-control"  value="${depositInstance?.maturityDate}"  />
            <g:hasErrors bean="${depositInstance}" field="currentRollover.endDate">
                <div class="controls">
                    <span class="help-block">
                        <g:eachError bean="${depositInstance}" field="currentRollover.endDate">
                            <g:message error="${it}" /><br/>
                        </g:eachError>
                    </span>
                </div>
            </g:hasErrors>
        </div>             
    </div>
    </g:else>
