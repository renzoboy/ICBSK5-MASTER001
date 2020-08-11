<%@ page import="icbs.loans.CreditInvestigation" %>
<%@ page import="icbs.lov.LoanApplicationStatusNR" %>

<g:if test="${creditTypeAction == "secured"}">
    <legend>Credit Investigation Details</legend>
</g:if>   
<g:else>
    <legend>Credit Processing Unsecured Details</legend>
</g:else> 

<g:hiddenField name="securedUnsec" id="securedUnsec" value="${creditTypeAction}" />
<div class="fieldcontain form-group ${hasErrors(bean: creditInvestigationInstance, field: 'loanApplication', 'has-error')} required">
	<label class="control-label col-sm-4" for="loanApplication">
		<g:message code="creditInvestigation.loanApplication.label" default="Account Application" />
		<span class="required-indicator">*</span>
	</label>
    <div class="col-sm-7"><g:field name="loanApplication" type="number" value="${creditInvestigationInstance?.loanApplication?.id}" class="form-control" readonly="true"/>
        <g:hiddenField name="loanAppSecOrUnsecId" id="loanAppSecOrUnsecId" value=""/>
        <g:hasErrors bean="${creditInvestigationInstance}" field="loanApplication">
            <div class="controls">
                    <span class="help-block">
                        <g:eachError bean="${creditInvestigationInstance}" field="loanApplication">
                            <g:message error="${it}" /><br/>
                        </g:eachError>
                    </span>
            </div>
        </g:hasErrors>
    </div>
    


    <div class="col-sm-2"><input type="button" href="#" class="btn btn-secondary" onclick="showLoanApplicationSearch()" value="Search"/></div>             
</div>
<div class="fieldcontain form-group ${hasErrors(bean: creditInvestigationInstance, field: 'loanApplication', 'has-error')} required">
    <label class="control-label col-sm-4" for="status">
		<g:message code="creditInvestigation.loanApplication.customer.label" default="Borrower Name" />
		
	</label>
    <div class="col-sm-8">
        <g:textField name="borrowerName" id="borrowerName" value="${creditInvestigationInstance?.loanApplication?.customer?.displayName}" readonly="true" class="form-control"/>
        <g:hasErrors bean="${creditInvestigationInstance}" field="status">
            <div class="controls">
                <span class="help-block">
                    <g:eachError bean="${accountsReceivableInstance}" field="status">
                        <g:message error="${it}" /><br/>
                    </g:eachError>
                </span>
            </div>
        </g:hasErrors>
    </div>             
</div>
<div class="fieldcontain form-group ${hasErrors(bean: creditInvestigationInstance, field: 'loanApplication', 'has-error')} required">
    <label class="control-label col-sm-4" for="status">
		<g:message code="creditInvestigation.loanApplication.amount.label" default="Amount Applied" />
		
	</label>
    <div class="col-sm-8">
        <g:textField name="amount" id="amount" value="${creditInvestigationInstance?.loanApplication?.amount}" readonly="true" class="form-control truncated"/>
        <g:hasErrors bean="${creditInvestigationInstance}" field="status">
            <div class="controls">
                <span class="help-block">
                    <g:eachError bean="${accountsReceivableInstance}" field="status">
                        <g:message error="${it}" /><br/>
                    </g:eachError>
                </span>
            </div>
        </g:hasErrors>
    </div>             
</div>
<div class="fieldcontain form-group ${hasErrors(bean: creditInvestigationInstance, field: 'status', 'has-error')} required">
    <label class="control-label col-sm-4" for="status">
		<g:message code="creditInvestigation.status.label" default="Status" />
		
	</label>
    <div class="col-sm-8">
        <g:select id="status" name="status.id" from="${icbs.lov.LoanApplicationStatusNR.list()}" optionKey="id" optionValue="description" required="" value="${creditInvestigationInstance?.status?.id}" class="many-to-one form-control"/>
        <g:hasErrors bean="${creditInvestigationInstance}" field="status">
            <div class="controls">
                <span class="help-block">
                    <g:eachError bean="${accountsReceivableInstance}" field="status">
                        <g:message error="${it}" /><br/>
                    </g:eachError>
                </span>
            </div>
        </g:hasErrors>
    </div>             
</div>
</br>

<div id="secured">
    <g:if test="${creditTypeAction == "secured"}">
    <div class="fieldcontain form-group ${hasErrors(bean: creditInvestigationInstance, field: 'folderReceivedByBranchDept', 'has-error')} ">
            <label class="control-label col-sm-4" for="folderReceivedByBranchDept">
                    <g:message code="creditInvestigation.folderReceivedByBranchDept.label" default="Date Folder Received by Branches Dept" />

            </label>
            <div class="col-sm-8"><g:customDatePicker name="folderReceivedByBranchDept" precision="day" class="form-control"  value="${creditInvestigationInstance?.folderReceivedByBranchDept}"  />

                <g:hasErrors bean="${creditInvestigationInstance}" field="folderReceivedByBranchDept">
                    <div class="controls">
                            <span class="help-block">
                                <g:eachError bean="${creditInvestigationInstance}" field="folderReceivedByBranchDept">
                                    <g:message error="${it}" /><br/>
                                </g:eachError>
                            </span>
                    </div>
                </g:hasErrors>
            </div>             
    </div>






    <div class="fieldcontain form-group ${hasErrors(bean: creditInvestigationInstance, field: 'folderTransToCau', 'has-error')} ">
            <label class="control-label col-sm-4" for="folderTransToCau">
                    <g:message code="creditInvestigation.folderTransToCau.label" default="Date Received by Credit Department" />

            </label>
            <div class="col-sm-8"><g:customDatePicker name="folderTransToCau" precision="day" class="form-control"  value="${creditInvestigationInstance?.folderTransToCau}"  />


                <g:hasErrors bean="${creditInvestigationInstance}" field="folderTransToCau">
                    <div class="controls">
                            <span class="help-block">

                                <g:eachError bean="${creditInvestigationInstance}" field="folderTransToCau">
                                    <g:message error="${it}" /><br/>
                                </g:eachError>
                            </span>
                    </div>
                </g:hasErrors>
            </div>             
    </div>

    <div class="fieldcontain form-group ${hasErrors(bean: creditInvestigationInstance, field: 'assignedToCi', 'has-error')} ">
            <label class="control-label col-sm-4" for="assignedToCi">
                    <g:message code="creditInvestigation.assignedToCi.label" default="Date Assigned to Credit Investigator" />

            </label>
            <div class="col-sm-8"><g:customDatePicker name="assignedToCi" precision="day" class="form-control"  value="${creditInvestigationInstance?.assignedToCi}"  />

                <g:hasErrors bean="${creditInvestigationInstance}" field="assignedToCi">
                    <div class="controls">
                            <span class="help-block">
                                <g:eachError bean="${creditInvestigationInstance}" field="assignedToCi">
                                    <g:message error="${it}" /><br/>
                                </g:eachError>
                            </span>
                    </div>
                </g:hasErrors>
            </div>             
    </div>
    <div class="fieldcontain form-group ${hasErrors(bean: creditInvestigationInstance, field: 'deadlineAssignedToCreCom', 'has-error')} ">
            <label class="control-label col-sm-4" for="deadlineAssignedToCreCom">
                    <g:message code="creditInvestigation.deadlineAssignedToCreCom.label" default="Deadline" />

            </label>
            <div class="col-sm-8"><g:customDatePicker name="deadlineAssignedToCreCom" precision="day" class="form-control"  value="${creditInvestigationInstance?.deadlineAssignedToCreCom}"  />

                <g:hasErrors bean="${creditInvestigationInstance}" field="deadlineAssignedToCreCom">
                    <div class="controls">
                            <span class="help-block">
                                <g:eachError bean="${creditInvestigationInstance}" field="deadlineAssignedToCreCom">
                                    <g:message error="${it}" /><br/>
                                </g:eachError>
                            </span>
                    </div>
                </g:hasErrors>
            </div>             
    </div>


    <div class="fieldcontain form-group ${hasErrors(bean: creditInvestigationInstance, field: 'dateSubByCreditInvestigator', 'has-error')} ">
            <label class="control-label col-sm-4" for="dateSubByCreditInvestigator">
                    <g:message code="creditInvestigation.dateSubByCreditInvestigator.label" default="Date Submitted by Credit Investigator" />


            </label>
            <div class="col-sm-8"><g:customDatePicker name="dateSubByCreditInvestigator" precision="day" class="form-control"  value="${creditInvestigationInstance?.dateSubByCreditInvestigator}"  />

                <g:hasErrors bean="${creditInvestigationInstance}" field="dateSubByCreditInvestigator">
                    <div class="controls">
                            <span class="help-block">
                                <g:eachError bean="${creditInvestigationInstance}" field="dateSubByCreditInvestigator">
                                    <g:message error="${it}" /><br/>
                                </g:eachError>
                            </span>
                    </div>
                </g:hasErrors>
            </div>             
    </div>
    <div class="fieldcontain form-group ${hasErrors(bean: creditInvestigationInstance, field: 'assignedToAnalyst', 'has-error')} ">
            <label class="control-label col-sm-4" for="assignedToAnalyst">
                    <g:message code="creditInvestigation.assignedToAnalyst.label" default="Date Assigned to Analyst" />


            </label>
            <div class="col-sm-8"><g:customDatePicker name="assignedToAnalyst" precision="day" class="form-control"  value="${creditInvestigationInstance?.assignedToAnalyst}"  />

                <g:hasErrors bean="${creditInvestigationInstance}" field="assignedToAnalyst">
                    <div class="controls">
                            <span class="help-block">
                                <g:eachError bean="${creditInvestigationInstance}" field="assignedToAnalyst">
                                    <g:message error="${it}" /><br/>
                                </g:eachError>
                            </span>
                    </div>
                </g:hasErrors>
            </div>             
    </div>


    <div class="fieldcontain form-group ${hasErrors(bean: creditInvestigationInstance, field: 'deadlineSubAnalystreport', 'has-error')} ">
            <label class="control-label col-sm-4" for="deadlineSubAnalystreport">
                    <g:message code="creditInvestigation.deadlineSubAnalystreport.label" default="Deadline" />

            </label>
            <div class="col-sm-8"><g:customDatePicker name="deadlineSubAnalystreport" precision="day" class="form-control"  value="${creditInvestigationInstance?.deadlineSubAnalystreport}"  />

                <g:hasErrors bean="${creditInvestigationInstance}" field="deadlineSubAnalystreport">
                    <div class="controls">
                            <span class="help-block">
                                <g:eachError bean="${creditInvestigationInstance}" field="deadlineSubAnalystreport">
                                    <g:message error="${it}" /><br/>
                                </g:eachError>
                            </span>
                    </div>
                </g:hasErrors>
            </div>             
    </div>
    <div class="fieldcontain form-group ${hasErrors(bean: creditInvestigationInstance, field: 'submitAnalystRep', 'has-error')} ">
            <label class="control-label col-sm-4" for="submitAnalystRep">
                    <g:message code="creditInvestigation.submitAnalystRep.label" default="Date Submitted By Analyst " />

            </label>
            <div class="col-sm-8"><g:customDatePicker name="submitAnalystRep" precision="day" class="form-control"  value="${creditInvestigationInstance?.submitAnalystRep}"  />

                <g:hasErrors bean="${creditInvestigationInstance}" field="submitAnalystRep">
                    <div class="controls">
                            <span class="help-block">
                                <g:eachError bean="${creditInvestigationInstance}" field="submitAnalystRep">
                                    <g:message error="${it}" /><br/>
                                </g:eachError>
                            </span>
                    </div>
                </g:hasErrors>
            </div>             
    </div>
    <div class="fieldcontain form-group ${hasErrors(bean: creditInvestigationInstance, field: 'reviewDateByManager', 'has-error')} ">
            <label class="control-label col-sm-4" for="reviewDateByManager">
                    <g:message code="creditInvestigation.reviewDateByManager.label" default="Date Approved by Manager " />

            </label>
            <div class="col-sm-8"><g:customDatePicker name="reviewDateByManager" precision="day" class="form-control"  value="${creditInvestigationInstance?.reviewDateByManager}"  />

                <g:hasErrors bean="${creditInvestigationInstance}" field="reviewDateByManager">
                    <div class="controls">
                            <span class="help-block">
                                <g:eachError bean="${creditInvestigationInstance}" field="reviewDateByManager">
                                    <g:message error="${it}" /><br/>
                                </g:eachError>
                            </span>
                    </div>
                </g:hasErrors>
            </div>             
    </div>

    <div class="fieldcontain form-group ${hasErrors(bean: creditInvestigationInstance, field: 'schedForCac', 'has-error')} ">
            <label class="control-label col-sm-4" for="schedForCac">
                    <g:message code="creditInvestigation.schedForCac.label" default="Date Scheduled for CAC" />

            </label>
            <div class="col-sm-8"><g:customDatePicker name="schedForCac" precision="day" class="form-control"  value="${creditInvestigationInstance?.schedForCac}"  />

                <g:hasErrors bean="${creditInvestigationInstance}" field="schedForCac">
                    <div class="controls">
                            <span class="help-block">
                                <g:eachError bean="${creditInvestigationInstance}" field="schedForCac">
                                    <g:message error="${it}" /><br/>
                                </g:eachError>
                            </span>
                    </div>
                </g:hasErrors>
            </div>             
    </div>

    <div class="fieldcontain form-group ${hasErrors(bean: creditInvestigationInstance, field: 'actualCac', 'has-error')} ">
            <label class="control-label col-sm-4" for="actualCac">
                    <g:message code="creditInvestigation.actualCac.label" default="Date Actual CAC" />

            </label>
            <div class="col-sm-8"><g:customDatePicker name="actualCac" precision="day" class="form-control"  value="${creditInvestigationInstance?.actualCac}"  />

                <g:hasErrors bean="${creditInvestigationInstance}" field="actualCac">
                    <div class="controls">
                            <span class="help-block">
                                <g:eachError bean="${creditInvestigationInstance}" field="actualCac">
                                    <g:message error="${it}" /><br/>
                                </g:eachError>
                            </span>
                    </div>
                </g:hasErrors>
            </div>             
    </div>

    <div class="fieldcontain form-group ${hasErrors(bean: creditInvestigationInstance, field: 'schedCrecom', 'has-error')} ">
            <label class="control-label col-sm-4" for="schedCrecom">
                    <g:message code="creditInvestigation.schedCrecom.label" default="Date Scheduled Crecom" />

            </label>
            <div class="col-sm-8"><g:customDatePicker name="schedCrecom" precision="day" class="form-control"  value="${creditInvestigationInstance?.schedCrecom}"  />

                <g:hasErrors bean="${creditInvestigationInstance}" field="schedCrecom">
                    <div class="controls">
                            <span class="help-block">
                                <g:eachError bean="${creditInvestigationInstance}" field="schedCrecom">
                                    <g:message error="${it}" /><br/>
                                </g:eachError>
                            </span>
                    </div>
                </g:hasErrors>
            </div>             
    </div>

    <div class="fieldcontain form-group ${hasErrors(bean: creditInvestigationInstance, field: 'actualCrecom', 'has-error')} ">
            <label class="control-label col-sm-4" for="actualCrecom">
                    <g:message code="creditInvestigation.actualCrecom.label" default="Date Actual Crecom" />

            </label>
            <div class="col-sm-8"><g:customDatePicker name="actualCrecom" precision="day" class="form-control"  value="${creditInvestigationInstance?.actualCrecom}"  />

                <g:hasErrors bean="${creditInvestigationInstance}" field="actualCrecom">
                    <div class="controls">
                            <span class="help-block">
                                <g:eachError bean="${creditInvestigationInstance}" field="actualCrecom">
                                    <g:message error="${it}" /><br/>
                                </g:eachError>
                            </span>
                    </div>
                </g:hasErrors>
            </div>             
    </div>


    <div class="fieldcontain form-group ${hasErrors(bean: creditInvestigationInstance, field: 'ci', 'has-error')} required">
        <label class="control-label col-sm-4" for="ci">
                    <g:message code="creditInvestigation.ci.label" default="Credit Investigator" />

            </label>
        <div class="col-sm-8">
            <g:select id="ci" name="ci.id" from="${icbs.admin.UserMaster.list()}" noSelection="${['null':'No Credit Investigator']}" optionKey="id" optionValue="username" required="" value="${creditInvestigationInstance?.ci?.id}" class="many-to-one form-control"/>
            <g:hasErrors bean="${creditInvestigationInstance}" field="ci">
                <div class="controls">
                    <span class="help-block">
                        <g:eachError bean="${accountsReceivableInstance}" field="ci">
                            <g:message error="${it}" /><br/>
                        </g:eachError>
                    </span>
                </div>
            </g:hasErrors>
        </div>             
    </div>


    <div class="fieldcontain form-group ${hasErrors(bean: creditInvestigationInstance, field: 'analyst', 'has-error')} required">
        <label class="control-label col-sm-4" for="analyst">
                    <g:message code="creditInvestigation.analyst.label" default="Analyst" />

            </label>
        <div class="col-sm-8">
            <g:select id="analyst" name="analyst.id" from="${icbs.admin.UserMaster.list()}" optionKey="id" optionValue="username" required="" value="${creditInvestigationInstance?.analyst?.id}" class="many-to-one form-control"/>
            <g:hasErrors bean="${creditInvestigationInstance}" field="analyst">
                <div class="controls">
                    <span class="help-block">
                        <g:eachError bean="${accountsReceivableInstance}" field="analyst">
                            <g:message error="${it}" /><br/>
                        </g:eachError>
                    </span>
                </div>
            </g:hasErrors>
        </div>             
    </div>


    <div class="fieldcontain form-group ${hasErrors(bean: creditInvestigationInstance, field: 'approvalDate', 'has-error')} ">
            <label class="control-label col-sm-4" for="approvalDate">
                    <g:message code="creditInvestigation.approvalDate.label" default="Lending Authority Approval Date" />

            </label>
            <div class="col-sm-8"><g:customDatePicker name="approvalDate" precision="day" class="form-control"  value="${creditInvestigationInstance?.approvalDate}"  />

                <g:hasErrors bean="${creditInvestigationInstance}" field="approvalDate">
                    <div class="controls">
                            <span class="help-block">
                                <g:eachError bean="${creditInvestigationInstance}" field="approvalDate">
                                    <g:message error="${it}" /><br/>
                                </g:eachError>
                            </span>
                    </div>
                </g:hasErrors>
            </div>             
    </div>
    </g:if>
</div> <%-- close for Secured loan apps --%>
<div id="unsec">
    <g:if test="${creditTypeAction == "unsecured"}">
    <div class="fieldcontain form-group ${hasErrors(bean: creditInvestigationInstance, field: 'folderReceivedByBranchDept', 'has-error')} ">
            <label class="control-label col-sm-4" for="folderReceivedByBranchDept">
                    <g:message code="creditInvestigation.folderReceivedByBranchDept.label" default="Date Endorsed to Branch Department" />

            </label>
            <div class="col-sm-8"><g:customDatePicker name="unsecfolderReceivedByBranchDept" precision="day" class="form-control"  value="${creditInvestigationInstance?.folderReceivedByBranchDept}"  />

                <g:hasErrors bean="${creditInvestigationInstance}" field="folderReceivedByBranchDept">
                    <div class="controls">
                            <span class="help-block">
                                <g:eachError bean="${creditInvestigationInstance}" field="folderReceivedByBranchDept">
                                    <g:message error="${it}" /><br/>
                                </g:eachError>
                            </span>
                    </div>
                </g:hasErrors>
            </div>            
    </div>
    <div class="fieldcontain form-group ${hasErrors(bean: creditInvestigationInstance, field: 'folderReceivedByBranchDept', 'has-error')} ">
            <label class="control-label col-sm-4" for="folderReceivedByBranchDept">
                    <g:message code="creditInvestigation.folderReceivedByBranchDept.label" default="Date Accepted By Branch Department" />

            </label>
            <div class="col-sm-8"><g:customDatePicker name="unsecfolderTransToCau" precision="day" class="form-control"  value="${creditInvestigationInstance?.folderTransToCau}"  />

                <g:hasErrors bean="${creditInvestigationInstance}" field="folderTransToCau">
                    <div class="controls">
                            <span class="help-block">
                                <g:eachError bean="${creditInvestigationInstance}" field="folderTransToCau">
                                    <g:message error="${it}" /><br/>
                                </g:eachError>
                            </span>
                    </div>
                </g:hasErrors>
            </div>             
    </div>




 

    <div class="fieldcontain form-group ${hasErrors(bean: creditInvestigationInstance, field: 'assignedToCi', 'has-error')} ">
            <label class="control-label col-sm-4" for="folderTransToCau">
                    <g:message code="creditInvestigation.folderTransToCau.label" default="Date Endorsed to Credit Manager" />

            </label>
            <div class="col-sm-8"><g:customDatePicker name="unsecassignedToCi" precision="day" class="form-control"  value="${creditInvestigationInstance?.assignedToCi}"  />


                <g:hasErrors bean="${creditInvestigationInstance}" field="assignedToCi">
                    <div class="controls">
                            <span class="help-block">

                                <g:eachError bean="${creditInvestigationInstance}" field="assignedToCi">
                                    <g:message error="${it}" /><br/>
                                </g:eachError>
                            </span>
                    </div>
                </g:hasErrors>
            </div>             
    </div>

    <div class="fieldcontain form-group ${hasErrors(bean: creditInvestigationInstance, field: 'schedForCi', 'has-error')} ">
            <label class="control-label col-sm-4" for="assignedToCi">
                    <g:message code="creditInvestigation.assignedToCi.label" default="Date Endorsed to CRC" />

            </label>
            <div class="col-sm-8"><g:customDatePicker name="unsecschedForCi" precision="day" class="form-control"  value="${creditInvestigationInstance?.schedForCi}"  />

                <g:hasErrors bean="${creditInvestigationInstance}" field="schedForCi">
                    <div class="controls">
                            <span class="help-block">
                                <g:eachError bean="${creditInvestigationInstance}" field="schedForCi">
                                    <g:message error="${it}" /><br/>
                                </g:eachError>
                            </span>
                    </div>
                </g:hasErrors>
            </div>             
    </div>
    <div class="fieldcontain form-group ${hasErrors(bean: creditInvestigationInstance, field: 'performedCi', 'has-error')} ">
            <label class="control-label col-sm-4" for="approvalDate">
                    <g:message code="creditInvestigation.deadlineAssignedToCreCom.label" default="Date of Endorsement for approval" />

            </label>
            <div class="col-sm-8"><g:customDatePicker name="unsecperformedCi" precision="day" class="form-control"  value="${creditInvestigationInstance?.performedCi}"  />

                <g:hasErrors bean="${creditInvestigationInstance}" field="performedCi">
                    <div class="controls">
                            <span class="help-block">
                                <g:eachError bean="${creditInvestigationInstance}" field="performedCi">
                                    <g:message error="${it}" /><br/>
                                </g:eachError>
                            </span>
                    </div>
                </g:hasErrors>
            </div>             
    </div>
    <div class="fieldcontain form-group ${hasErrors(bean: creditInvestigationInstance, field: 'assignedToAnalyst', 'has-error')} ">
            <label class="control-label col-sm-4" for="assignedToAnalyst">
                    <g:message code="creditInvestigation.deadlineAssignedToCreCom.label" default="Date approval of President" />

            </label>
            <div class="col-sm-8"><g:customDatePicker name="unsecassignedToAnalyst" precision="day" class="form-control"  value="${creditInvestigationInstance?.assignedToAnalyst}"  />

                <g:hasErrors bean="${creditInvestigationInstance}" field="assignedToAnalyst">
                    <div class="controls">
                            <span class="help-block">
                                <g:eachError bean="${creditInvestigationInstance}" field="assignedToAnalyst">
                                    <g:message error="${it}" /><br/>
                                </g:eachError>
                            </span>
                    </div>
                </g:hasErrors>
            </div>             
    </div>
    <div class="fieldcontain form-group ${hasErrors(bean: creditInvestigationInstance, field: 'schedForAnalyst', 'has-error')} ">
            <label class="control-label col-sm-4" for="approvalDate">
                    <g:message code="creditInvestigation.schedForAnalyst.label" default="Date Endorsement of approval to Branch" />

            </label>
            <div class="col-sm-8"><g:customDatePicker name="unsecschedForAnalyst" precision="day" class="form-control"  value="${creditInvestigationInstance?.schedForAnalyst}"  />

                <g:hasErrors bean="${creditInvestigationInstance}" field="schedForAnalyst">
                    <div class="controls">
                            <span class="help-block">
                                <g:eachError bean="${creditInvestigationInstance}" field="schedForAnalyst">
                                    <g:message error="${it}" /><br/>
                                </g:eachError>
                            </span>
                    </div>
                </g:hasErrors>
            </div>             
    </div>
    <div class="fieldcontain form-group ${hasErrors(bean: creditInvestigationInstance, field: 'recommendation', 'has-error')} ">
            <label class="control-label col-sm-4" for="approvalDate">
                    <g:message code="creditInvestigation.deadlineAssignedToCreCom.label" default="Reason for Return" />

            </label>
            <div class="col-sm-8"><g:textArea name="unsecrecommendation" value="${creditInvestigationInstance?.recommendation}" rows="5" cols="40" class="form-control"/>

                <g:hasErrors bean="${creditInvestigationInstance}" field="recommendation">
                    <div class="controls">
                            <span class="help-block">
                                <g:eachError bean="${creditInvestigationInstance}" field="recommendation">
                                    <g:message error="${it}" /><br/>
                                </g:eachError>
                            </span>
                    </div>
                </g:hasErrors>
            </div>             
    </div>
    <div class="fieldcontain form-group ${hasErrors(bean: creditInvestigationInstance, field: 'performedByAnalyst', 'has-error')} ">
            <label class="control-label col-sm-4" for="approvalDate">
                    <g:message code="creditInvestigation.performedByAnalyst.label" default="Date Return to Branch" />

            </label>
            <div class="col-sm-8"><g:customDatePicker name="unsecperformedByAnalyst" precision="day" class="form-control"  value="${creditInvestigationInstance?.performedByAnalyst}"  />

                <g:hasErrors bean="${creditInvestigationInstance}" field="performedByAnalyst">
                    <div class="controls">
                            <span class="help-block">
                                <g:eachError bean="${creditInvestigationInstance}" field="performedByAnalyst">
                                    <g:message error="${it}" /><br/>
                                </g:eachError>
                            </span>
                    </div>
                </g:hasErrors>
            </div>             
    </div>
    <div class="fieldcontain form-group ${hasErrors(bean: creditInvestigationInstance, field: 'submitAnalystRep', 'has-error')} ">
            <label class="control-label col-sm-4" for="approvalDate">
                    <g:message code="creditInvestigation.submitAnalystRep.label" default="Date Return to Branches Department" />

            </label>
            <div class="col-sm-8"><g:customDatePicker name="unsecsubmitAnalystRep" precision="day" class="form-control"  value="${creditInvestigationInstance?.submitAnalystRep}"  />

                <g:hasErrors bean="${creditInvestigationInstance}" field="submitAnalystRep">
                    <div class="controls">
                            <span class="help-block">
                                <g:eachError bean="${creditInvestigationInstance}" field="submitAnalystRep">
                                    <g:message error="${it}" /><br/>
                                </g:eachError>
                            </span>
                    </div>
                </g:hasErrors>
            </div>             
    </div>
    </g:if>
</div>    
    








