<%@ page import="icbs.lov.LoanApplicationStatus" %>


<div>
    <g:if test="${message}">
        <div class="box-body">
            <div class="alert alert-info alert-dismissable">
                <i class="fa fa-info"></i>
                <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                <b>Message</b> <div class="message" role="status">${message}</div>
            </div>
        </div>
    </g:if>
    <g:hasErrors bean="${loanApplicationInstance}"> 
        <div class="box-body">
            <div class="alert alert-danger alert-dismissable">
                <i class="fa fa-ban"></i>
                <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                <b>Alert!</b> 
                <ul class="errors" role="alert">
                    There are errors
                </ul>            
            </div>
        </div>
    </g:hasErrors>
    <g:form name="update-status-form">
        <g:hiddenField name="id" id="id" value="${loanApplicationInstance?.id}"/>
        <g:if test="${loanApplicationInstance?.product?.productType?.id == 6}">
        <div class="form-group fieldcontain ${hasErrors(bean: loanApplicationInstance, field: 'approvalStatus', 'has-error')} ">
            <label class="control-label col-sm-4" for="approvalStatus">Status</label>
            <div class="col-sm-8">
                <g:select id="approvalStatus" name="approvalStatus.id" from="${icbs.lov.LoanApplicationStatus.findAll("from LoanApplicationStatus where id in (1,2,3,4,5,6,7,8)")}" optionKey="id" optionValue="description" value="${loanApplicationInstance?.approvalStatus?.id}" class="form-control"/>
                <g:hasErrors bean="${loanApplicationInstance}" field="approvalStatus">
                    <div class="controls">
                        <span class="help-block">
                            <g:eachError bean="${loanApplicationInstance}" field="approvalStatus">
                                <g:message error="${it}" /><br/>
                            </g:eachError>
                        </span>
                    </div>
                </g:hasErrors>
            </div>
        </div>
        </g:if>
        <g:if test="${loanApplicationInstance?.product?.productType?.id == 7}">
        <div class="form-group fieldcontain ${hasErrors(bean: loanApplicationInstance, field: 'approvalStatus', 'has-error')} ">
            <label class="control-label col-sm-4" for="approvalStatus">Status</label>
            <div class="col-sm-8">
                <g:select id="approvalStatus" name="approvalStatus.id" from="${icbs.lov.LoanApplicationStatus.findAll("from LoanApplicationStatus where id in (1,8,9,10,11)")}" optionKey="id" optionValue="description" value="${loanApplicationInstance?.approvalStatus?.id}" class="form-control"/>
                <g:hasErrors bean="${loanApplicationInstance}" field="approvalStatus">
                    <div class="controls">
                        <span class="help-block">
                            <g:eachError bean="${loanApplicationInstance}" field="approvalStatus">
                                <g:message error="${it}" /><br/>
                            </g:eachError>
                        </span>
                    </div>
                </g:hasErrors>
            </div>
        </div>
        </g:if>        
    </g:form>  
</div>
