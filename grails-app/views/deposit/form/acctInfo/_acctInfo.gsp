<!--
  To change this license header, choose License Headers in Project Properties.
  To change this template file, choose Tools | Templates
  and open the template in the editor.
-->

<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="icbs.lov.ConfigItemStatus" %>
 <fieldset>
    <legend>Account Information</legend>
    <div id="acctInfoDiv">
            <g:if test="${depositInstance?.type?.id==null || depositInstance?.type?.id==1}">
                <g:render template='form/acctInfo/templates/deposit'/>
            </g:if>
            <g:if test="${depositInstance?.type?.id==2}">
                <g:render template='form/acctInfo/templates/current'/>
            </g:if>
            <g:if test="${depositInstance?.type?.id==3}">
                <g:render template='form/acctInfo/templates/fixedDeposit'/>
            </g:if>
            <g:if test="${depositInstance?.type?.id==4}">
                <g:render template='form/acctInfo/templates/deposit'/>
            </g:if>
            <g:if test="${depositInstance?.type?.id==5}">
                <g:render template='form/acctInfo/templates/deposit'/>
            </g:if>
            <div class="fieldcontain form-group ${hasErrors(bean: depositInstance, field: 'userDepositAcctOfficer', 'has-error')} ">
                <label class="control-label col-sm-4" for="userDepositAcctOfficer">
                        <g:message code="deposit.userDepositAcctOfficer.label" default="Deposit Account Officer" />

                </label>
                <div class="col-sm-8">
                    <g:select id="userDepositAcctOfficer" name="userDepositAcctOfficer.id" from="${icbs.admin.UserMaster.findAllByConfigItemStatus(ConfigItemStatus.get(2))}" optionKey="id" optionValue="name" required="" value="${depositInstance?.userDepositAcctOfficer?.id}" class="many-to-one form-control"/>
                    <%-- <g:textField class="form-control" name="depAccountOfficer" id="depAccountOfficer" value="${fieldValue(bean: depositInstance, field: 'depAccountOfficer')}" /> --%>
                    <g:hasErrors bean="${depositInstance}" field="userDepositAcctOfficer">
                        <div class="controls">
                                <span class="help-block">
                                    <g:eachError bean="${depositInstance}" field="userDepositAcctOfficer">
                                        <g:message error="${it}" /><br/>
                                    </g:eachError>
                                </span>
                        </div>
                    </g:hasErrors>
                </div>             
            </div>
    </div>
</fieldset>