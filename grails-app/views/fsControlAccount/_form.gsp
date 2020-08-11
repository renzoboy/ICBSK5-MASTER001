<%@ page import="icbs.gl.FsControlAccount" %>
<%@ page import="icbs.gl.GlAccount" %>

<g:hiddenField name="idto" id="idto" value="${params.id}" />

<div class="fieldcontain form-group ${hasErrors(bean: fsControlAccountInstance, field: 'reference', 'has-error')} required">
    <label class="control-label col-sm-4" for="account">Account Code*</label>
    <div class="col-sm-8"><g:textField name="account" id="account" required="" value="${fsControlAccountInstance?.account}" onblur="validateGlCode();" class="form-control"/>
        <g:hasErrors bean="${fsControlAccountInstance}" field="account">
            <div class="controls">
                <span class="help-block">
                    <g:eachError bean="${fsControlAccountInstance}" field="account">
                        <g:message error="${it}" /><br/>
                    </g:eachError>
                </span>
            </div>
        </g:hasErrors>
    </div>             
</div>
<div class="fieldcontain form-group ${hasErrors(bean: fsControlAccountInstance, field: 'reference', 'has-error')} required">
    <label class="control-label col-sm-4" for="description">Account Description*</label>
    <div class="col-sm-8"><g:textField name="description" id="description" required="" value="${fsControlAccountInstance?.description}"class="form-control"/>
        <g:hasErrors bean="${fsControlAccountInstance}" field="description">
            <div class="controls">
                <span class="help-block">
                    <g:eachError bean="${fsControlAccountInstance}" field="description">
                        <g:message error="${it}" /><br/>
                    </g:eachError>
                </span>
            </div>
        </g:hasErrors>
    </div>             
</div>
<g:if test="${fsControlAccountInstance}">
    <g:hiddenField id="fsControlId" name="fsControlId" value="${fsControlAccountInstance?.id}" />
<div class="fieldcontain form-group ${hasErrors(bean: fsControlAccountInstance, field: 'status', 'has-error')} required">
	<label class="control-label col-sm-4" for="status">
		<g:message code="fsControlAccountInstance.status.label" default="status" />
		<span class="required-indicator">*</span>
	</label>
	<div class="col-sm-8"><g:select id="status" name="status.id" from="${icbs.lov.ConfigItemStatus.list()}" optionKey="id" required="" value="${fsControlAccountInstance?.status?.id}" class="many-to-one form-control"/>
          
            <g:hasErrors bean="${fsControlAccountInstance}" field="status">
                <div class="controls">
                        <span class="help-block">
                            <g:eachError bean="${fsControlAccountInstance}" field="status">
                                <g:message error="${it}" /><br/>
                            </g:eachError>
                        </span>
                </div>
            </g:hasErrors>
        </div>             
</div>    
</g:if>    