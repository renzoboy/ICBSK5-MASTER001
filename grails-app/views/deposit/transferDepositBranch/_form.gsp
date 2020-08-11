<!--
  To change this license header, choose License Headers in Project Properties.
  To change this template file, choose Tools | Templates
  and open the template in the editor.
-->

<%@ page contentType="text/html;charset=UTF-8" %>
<g:hiddenField name="deposit.id" value="${depositInstance?.id}"/>
<div class="fieldcontain form-group ${hasErrors(bean: depositInstance, field: 'branch', 'has-error')} ">
    <label class="control-label col-sm-4" for="branch">
	<g:message code="deposit.branch.label" default="Branch" />
    </label>
    <div class="col-sm-8">
        <g:select id="branch" name="branch.id" from="${icbs.admin.Branch.list(sort: "name", order: "asc")}" optionKey="id" optionValue="name" value="${depositInstance?.branch?.id}" class="many-to-one form-control"/> 
            <g:hasErrors bean="${depositInstance}" field="branch">
                <div class="controls">
                        <span class="help-block">
                            <g:eachError bean="${depositInstance}" field="branch">
                                <g:message error="${it}" /><br/>
                            </g:eachError>
                        </span>
                </div>
            </g:hasErrors>
        </div>   
        <g:hiddenField id="oldDepBranch" name="oldDepBranch" value="${depositInstance?.branch?.id}" />
</div>
<div class="fieldcontain form-group ${hasErrors(bean: depositInstance, field: 'reference', 'has-error')} ">
    <label class="control-label col-sm-4" for="reference">
	<g:message code="deposit.reference.label" default="Reference" />
    </label>
    <div class="col-sm-8">
        <g:textArea name="reference" id="reference" cols="40" rows="5" value="${holdInstance?.remarks}" class="form-control"/>
    </div>    
</div>

<div class="fieldcontain form-group ${hasErrors(bean: depositInstance, field: 'remarks', 'has-error')} ">
    <label class="control-label col-sm-4" for="remarks">
	<g:message code="deposit.remarks.label" default="Particulars" />
    </label>
    <div class="col-sm-8">
        <g:textArea name="remarks" id="remarks" cols="40" rows="5" value="${holdInstance?.remarks}" class="form-control"/>
    </div>    
</div>
