<!--
  To change this license header, choose License Headers in Project Properties.
  To change this template file, choose Tools | Templates
  and open the template in the editor.
-->

<%@ page contentType="text/html;charset=UTF-8" %>

<legend>Small Business Guarantee Fund</legend>


<div class="form-group fieldcontain ${hasErrors(bean: loanGuaranteeInstance, field: 'sbgfcMainOfficeAddress', 'has-error')} ">
	<label class="control-label col-sm-4"for="sbgfcMainOfficeAddress">
		<g:message code="loan.sbgfcMainOfficeAddress.label" default="Main Office Address" />
		<span class="required-indicator"></span>
	</label>
	 <div class="col-sm-8">
                <g:field id="sbgfcMainOfficeAddress"name="sbgfcMainOfficeAddress"  value="${loanGuaranteeInstance?.sbgfcMainOfficeAddress}" class="form-control"/>
                <g:hasErrors bean="${loanGuaranteeInstance}" field="sbgfcMainOfficeAddress">
                <div class="controls">
                    <span class="help-block">
                        <g:eachError bean="${loanGuaranteeInstance}" field="sbgfcMainOfficeAddress" >
                            <g:message error="${it}" /><br/>
                        </g:eachError>
                    </span>
                </div>
             </g:hasErrors>   
         </div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: loanGuaranteeInstance, field: 'sbgfcPosition', 'has-error')} ">
	<label class="control-label col-sm-4"for="sbgfcPosition">
		<g:message code="loan.sbgfcPosition.label" default="Position " />
		<span class="required-indicator"></span>
	</label>
	 <div class="col-sm-8">
                <g:field type="text" id="sbgfcPosition"name="sbgfcPosition"  value="${loanGuaranteeInstance?.sbgfcPosition}"class="form-control"/>
                <g:hasErrors bean="${loanGuaranteeInstance}" field="sbgfcPosition">
                <div class="controls">
                    <span class="help-block">
                        <g:eachError bean="${loanGuaranteeInstance}" field="sbgfcPosition" >
                            <g:message error="${it}" /><br/>
                        </g:eachError>
                    </span>
                </div>
             </g:hasErrors>   
         </div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: loanGuaranteeInstance, field: 'sbgfcNetWorth', 'has-error')} ">
	<label class="control-label col-sm-4"for="sbgfcNetWorth">
		<g:message code="loan.sbgfcNetWorth.label" default="Net Worth" />
		<span class="required-indicator"></span>
	</label>
        <div class="col-sm-8">
               <g:field type="text" id="sbgfcNetWorth" name="sbgfcNetWorth"  value="${loanGuaranteeInstance?.sbgfcNetWorth}" class="form-control truncated" />
               <g:hasErrors bean="${loanGuaranteeInstance}" field="sbgfcNetWorth">
               <div class="controls">
                   <span class="help-block">
                       <g:eachError bean="${loanGuaranteeInstance}" field="sbgfcNetWorth" >
                           <g:message error="${it}" /><br/>
                       </g:eachError>
                   </span>
               </div>
            </g:hasErrors>   
        </div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: loanGuaranteeInstance, field: 'sbgfcNatureOfBusiness', 'has-error')} ">
	<label class="control-label col-sm-4"for="sbgfcNatureOfBusiness">
		<g:message code="loan.sbgfcNatureOfBusiness.label" default="Nature of Business" />
		<span class="required-indicator"></span>
	</label>
	 <div class="col-sm-8">
                <g:field type="text" id="sbgfcNatureOfBusiness" name="sbgfcNatureOfBusiness"  value="${loanGuaranteeInstance?.sbgfcNatureOfBusiness}"class="form-control" />
                <g:hasErrors bean="${loanGuaranteeInstance}" field="sbgfcNatureOfBusiness">
                <div class="controls">
                    <span class="help-block">
                        <g:eachError bean="${loanGuaranteeInstance}" field="sbgfcNatureOfBusiness" >
                            <g:message error="${it}" /><br/>
                        </g:eachError>
                    </span>
                </div>
             </g:hasErrors>   
         </div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: loanGuaranteeInstance, field: 'sbgfcBusinessType', 'has-error')} ">
	<label class="control-label col-sm-4"for="sbgfcBusinessType">
		<g:message code="loan.sbgfcBusinessType.label" default="Business Type" />
		<span class="required-indicator"></span>
	</label>
	 <div class="col-sm-8">
                <g:field type="text" id="sbgfcBusinessType" name="sbgfcBusinessType"  value="${loanGuaranteeInstance?.sbgfcBusinessType}"class="form-control"/>
                <g:hasErrors bean="${loanGuaranteeInstance}" field="sbgfcBusinessType">
                <div class="controls">
                    <span class="help-block">
                        <g:eachError bean="${loanGuaranteeInstance}" field="sbgfcBusinessType" >
                            <g:message error="${it}" /><br/>
                        </g:eachError>
                    </span>
                </div>
             </g:hasErrors>   
         </div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: loanGuaranteeInstance, field: 'sbgfcStartOfBusinessOperation', 'has-error')} ">
	<label class="control-label col-sm-4"for="sbgfcStartOfBusinessOperation">
		<g:message code="loan.sbgfcStartOfBusinessOperation.label" default="Start of Business Operation" />
		<span class="required-indicator"></span>
	</label>
	 <div class="col-sm-8">
                <g:field type="text" id="sbgfcStartOfBusinessOperation" name="sbgfcStartOfBusinessOperation"  value="${loanGuaranteeInstance?.sbgfcStartOfBusinessOperation}"class="form-control"/>
                <g:hasErrors bean="${loanGuaranteeInstance}" field="sbgfcStartOfBusinessOperation">
                <div class="controls">
                    <span class="help-block">
                        <g:eachError bean="${loanGuaranteeInstance}" field="sbgfcStartOfBusinessOperation" >
                            <g:message error="${it}" /><br/>
                        </g:eachError>
                    </span>
                </div>
             </g:hasErrors>   
         </div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: loanGuaranteeInstance, field: 'sbgfcAssetSize', 'has-error')} ">
	<label class="control-label col-sm-4"for="sbgfcAssetSize">
		<g:message code="loan.sbgfcAssetSize.label" default="Asset Size" />
		<span class="required-indicator"></span>
	</label>
	 <div class="col-sm-8">
                <g:field id="sbgfcAssetSize" name="sbgfcAssetSize"  value="${loanGuaranteeInstance?.sbgfcAssetSize}"class="form-control truncated"/>
                <g:hasErrors bean="${loanGuaranteeInstance}" field="sbgfcAssetSize">
                <div class="controls">
                    <span class="help-block">
                        <g:eachError bean="${loanGuaranteeInstance}" field="sbgfcAssetSize" >
                            <g:message error="${it}" /><br/>
                        </g:eachError>
                    </span>
                </div>
             </g:hasErrors>   
         </div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: loanGuaranteeInstance, field: 'sbgfcNumberOfEmployees', 'has-error')} ">
	<label class="control-label col-sm-4"for="sbgfcNumberOfEmployees">
		<g:message code="loan.sbgfcNumberOfEmployees.label" default="Number of Employee" />
		<span class="required-indicator"></span>
	</label>
	 <div class="col-sm-8">
                <g:field type="text" id="sbgfcNumberOfEmployees" name="sbgfcNumberOfEmployees"  value="${loanGuaranteeInstance?.sbgfcNumberOfEmployees}"class="form-control"/>
                <g:hasErrors bean="${loanGuaranteeInstance}" field="sbgfcNumberOfEmployees">
                <div class="controls">
                    <span class="help-block">
                        <g:eachError bean="${loanGuaranteeInstance}" field="sbgfcNumberOfEmployees" >
                            <g:message error="${it}" /><br/>
                        </g:eachError>
                    </span>
                </div>
             </g:hasErrors>   
         </div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: loanGuaranteeInstance, field: 'sbgfcApprovalExiryDate', 'has-error')} ">
	<label class="control-label col-sm-4"for="sbgfcApprovalExiryDate">
		<g:message code="loan.sbgfcApprovalExiryDate.label" default="Approve Expiry Date" />
		<span class="required-indicator"></span>
	</label>
	 <div class="col-sm-8">
            
               <g:customDatePicker  id="sbgfcApprovalExiryDate" name="sbgfcApprovalExiryDate" value="${loanGuaranteeInstance?.sbgfcApprovalExiryDate}"class="form-control"  />
                <g:hasErrors bean="${loanGuaranteeInstance}" field="sbgfcApprovalExiryDate">
                <div class="controls">
                    <span class="help-block">
                        <g:eachError bean="${loanGuaranteeInstance}" field="agfpRemarks" >
                            <g:message error="${it}" /><br/>
                        </g:eachError>
                    </span>
                </div>
             </g:hasErrors>   
         </div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: loanGuaranteeInstance, field: 'sbgfcTypeOfLoan', 'has-error')} ">
	<label class="control-label col-sm-4"for="sbgfcTypeOfLoan">
		<g:message code="loan.sbgfcTypeOfLoan.label" default="Type of Loan" />
		<span class="required-indicator"></span>
	</label>
	 <div class="col-sm-8">
                <g:field type="text" id="sbgfcTypeOfLoan" name="sbgfcTypeOfLoan"  value="${loanGuaranteeInstance?.sbgfcTypeOfLoan}"class="form-control"/>
                <g:hasErrors bean="${loanGuaranteeInstance}" field="sbgfcTypeOfLoan">
                <div class="controls">
                    <span class="help-block">
                        <g:eachError bean="${loanGuaranteeInstance}" field="sbgfcTypeOfLoan" >
                            <g:message error="${it}" /><br/>
                        </g:eachError>
                    </span>
                </div>
             </g:hasErrors>   
         </div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: loanGuaranteeInstance, field: 'sbgfcPurposeOfLoan', 'has-error')} ">
	<label class="control-label col-sm-4"for="sbgfcPurposeOfLoan">
		<g:message code="loan.sbgfcPurposeOfLoan.label" default="Purpose of Loan" />
		<span class="required-indicator"></span>
	</label>
	 <div class="col-sm-8">
                <g:field type="text" id="sbgfcPurposeOfLoan" name="sbgfcPurposeOfLoan"  value="${loanGuaranteeInstance?.sbgfcPurposeOfLoan}"class="form-control"/>
                <g:hasErrors bean="${loanGuaranteeInstance}" field="sbgfcPurposeOfLoan">
                <div class="controls">
                    <span class="help-block">
                        <g:eachError bean="${loanGuaranteeInstance}" field="sbgfcPurposeOfLoan" >
                            <g:message error="${it}" /><br/>
                        </g:eachError>
                    </span>
                </div>
             </g:hasErrors>   
         </div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: loanGuaranteeInstance, field: 'sbgfcOutstandingBalance', 'has-error')} ">
	<label class="control-label col-sm-4"for="sbgfcOutstandingBalance">
		<g:message code="loan.sbgfcOutstandingBalance.label" default="Outstanding Balance" />
		<span class="required-indicator"></span>
	</label>
	 <div class="col-sm-8">
                <g:field  id="sbgfcOutstandingBalance" name="sbgfcOutstandingBalance"  value="${loanGuaranteeInstance?.sbgfcOutstandingBalance}"class="form-control truncated"/>
                <g:hasErrors bean="${loanGuaranteeInstance}" field="sbgfcOutstandingBalance">
                <div class="controls">
                    <span class="help-block">
                        <g:eachError bean="${loanGuaranteeInstance}" field="sbgfcOutstandingBalance" >
                            <g:message error="${it}" /><br/>
                        </g:eachError>
                    </span>
                </div>
             </g:hasErrors>   
         </div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: loanGuaranteeInstance, field: 'sbgfcDsc', 'has-error')} ">
	<label class="control-label col-sm-4"for="sbgfcDsc">
		<g:message code="loan.sbgfcDsc.label" default="Debt Serv. Capacity" />
		<span class="required-indicator"></span>
	</label>
	 <div class="col-sm-8">
                <g:field type="text" id="sbgfcDsc" name="sbgfcDsc"  value="${loanGuaranteeInstance?.sbgfcDsc}"class="form-control"/>
                <g:hasErrors bean="${loanGuaranteeInstance}" field="sbgfcDsc">
                <div class="controls">
                    <span class="help-block">
                        <g:eachError bean="${loanGuaranteeInstance}" field="sbgfcDsc" >
                            <g:message error="${it}" /><br/>
                        </g:eachError>
                    </span>
                </div>
             </g:hasErrors>   
         </div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: loanGuaranteeInstance, field: 'sbgfcInitialBrrTotalPoints', 'has-error')} ">
	<label class="control-label col-sm-4"for="sbgfcInitialBrrTotalPoints">
		<g:message code="loan.sbgfcInitialBrrTotalPoints.label" default="Initial BRR Total Points" />
		<span class="required-indicator"></span>
	</label>
	 <div class="col-sm-8">
                <g:field type="text" id="sbgfcInitialBrrTotalPoints" name="sbgfcInitialBrrTotalPoints"  value="${loanGuaranteeInstance?.sbgfcInitialBrrTotalPoints}"class="form-control truncated"/>
                <g:hasErrors bean="${loanGuaranteeInstance}" field="sbgfcInitialBrrTotalPoints">
                <div class="controls">
                    <span class="help-block">
                        <g:eachError bean="${loanGuaranteeInstance}" field="sbgfcInitialBrrTotalPoints" >
                            <g:message error="${it}" /><br/>
                        </g:eachError>
                    </span>
                </div>
             </g:hasErrors>   
         </div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: loanGuaranteeInstance, field: 'sbgfcInitialBrrGrade', 'has-error')} ">
	<label class="control-label col-sm-4"for="sbgfcInitialBrrGrade">
		<g:message code="loan.sbgfcInitialBrrGrade.label" default="Initial BRR Grade" />
		<span class="required-indicator"></span>
	</label>
	 <div class="col-sm-8">
                <g:field type="text" id="sbgfcInitialBrrGrade" name="sbgfcInitialBrrGrade"  value="${loanGuaranteeInstance?.sbgfcInitialBrrGrade}"class="form-control truncated"/>
                <g:hasErrors bean="${loanGuaranteeInstance}" field="sbgfcInitialBrrGrade">
                <div class="controls">
                    <span class="help-block">
                        <g:eachError bean="${loanGuaranteeInstance}" field="sbgfcInitialBrrGrade" >
                            <g:message error="${it}" /><br/>
                        </g:eachError>
                    </span>
                </div>
             </g:hasErrors>   
         </div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: loanGuaranteeInstance, field: 'sbgfcBrrTotalPoints', 'has-error')} ">
	<label class="control-label col-sm-4"for="sbgfcBrrTotalPoints">
		<g:message code="loan.sbgfcBrrTotalPoints.label" default="BRR Total Points" />
		<span class="required-indicator"></span>
	</label>
	 <div class="col-sm-8">
                <g:field type="text" id="sbgfcBrrTotalPoints" name="sbgfcBrrTotalPoints"  value="${loanGuaranteeInstance?.sbgfcInitialBrrGrade}"class="form-control truncated"/>
                <g:hasErrors bean="${loanGuaranteeInstance}" field="sbgfcBrrTotalPoints">
                <div class="controls">
                    <span class="help-block">
                        <g:eachError bean="${loanGuaranteeInstance}" field="sbgfcBrrTotalPoints" >
                            <g:message error="${it}" /><br/>
                        </g:eachError>
                    </span>
                </div>
             </g:hasErrors>   
         </div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: loanGuaranteeInstance, field: 'sbgfcBrrGrade', 'has-error')} ">
	<label class="control-label col-sm-4"for="sbgfcBrrGrade">
		<g:message code="loan.sbgfcBrrGrade.label" default="BRR Grade" />
		<span class="required-indicator"></span>
	</label>
	 <div class="col-sm-8">
                <g:field type="text" id="sbgfcBrrGrade" name="sbgfcBrrGrade"  value="${loanGuaranteeInstance?.sbgfcBrrGrade}"class="form-control truncated"/>
                <g:hasErrors bean="${loanGuaranteeInstance}" field="sbgfcBrrGrade">
                <div class="controls">
                    <span class="help-block">
                        <g:eachError bean="${loanGuaranteeInstance}" field="sbgfcBrrGrade" >
                            <g:message error="${it}" /><br/>
                        </g:eachError>
                    </span>
                </div>
             </g:hasErrors>   
         </div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: loanGuaranteeInstance, field: 'sbgfcTypeOfCollateral', 'has-error')} ">
	<label class="control-label col-sm-4"for="sbgfcTypeOfCollateral">
		<g:message code="loan.sbgfcTypeOfCollateral.label" default="Type of Collateral" />
		<span class="required-indicator"></span>
	</label>
	 <div class="col-sm-8">
                <g:field type="text" id="sbgfcTypeOfCollateral" name="sbgfcTypeOfCollateral"  value="${loanGuaranteeInstance?.sbgfcTypeOfCollateral}"class="form-control"/>
                <g:hasErrors bean="${loanGuaranteeInstance}" field="sbgfcTypeOfCollateral">
                <div class="controls">
                    <span class="help-block">
                        <g:eachError bean="${loanGuaranteeInstance}" field="sbgfcTypeOfCollateral" >
                            <g:message error="${it}" /><br/>
                        </g:eachError>
                    </span>
                </div>
             </g:hasErrors>   
         </div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: loanGuaranteeInstance, field: 'sbgfcMarketValue', 'has-error')} ">
	<label class="control-label col-sm-4"for="sbgfcMarketValue">
		<g:message code="loan.sbgfcMarketValue.label" default="Market Value" />
		<span class="required-indicator"></span>
	</label>
	 <div class="col-sm-8">
                <g:field type="text" id="sbgfcMarketValue" name="sbgfcMarketValue"  value="${loanGuaranteeInstance?.sbgfcMarketValue}"class="form-control truncated"/>
                <g:hasErrors bean="${loanGuaranteeInstance}" field="sbgfcMarketValue">
                <div class="controls">
                    <span class="help-block">
                        <g:eachError bean="${loanGuaranteeInstance}" field="sbgfcMarketValue" >
                            <g:message error="${it}" /><br/>
                        </g:eachError>
                    </span>
                </div>
             </g:hasErrors>   
         </div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: loanGuaranteeInstance, field: 'sbgfcLoanValue', 'has-error')} ">
	<label class="control-label col-sm-4"for="sbgfcLoanValue">
		<g:message code="loan.sbgfcLoanValue.label" default="Loan Value" />
		<span class="required-indicator"></span>
	</label>
	 <div class="col-sm-8">
                <g:field  id="sbgfcLoanValue" name="sbgfcLoanValue"  value="${loanGuaranteeInstance?.sbgfcLoanValue} "class="form-control truncated"/>
                <g:hasErrors bean="${loanGuaranteeInstance}" field="sbgfcLoanValue">
                <div class="controls">
                    <span class="help-block">
                        <g:eachError bean="${loanGuaranteeInstance}" field="sbgfcLoanValue" >
                            <g:message error="${it}" /><br/>
                        </g:eachError>
                    </span>
                </div>
             </g:hasErrors>   
         </div>
</div>
<div class="form-group fieldcontain ${hasErrors(bean: loanGuaranteeInstance, field: 'sbgfcBusinessName', 'has-error')} ">
	<label class="control-label col-sm-4"for="sbgfcBusinessName">
		<g:message code="loan.sbgfcBusinessName.label" default="Business Name" />
		<span class="required-indicator"></span>
	</label>
	 <div class="col-sm-8">
                <g:field id="sbgfcBusinessName" name="sbgfcBusinessName" value="${loanGuaranteeInstance?.sbgfcBusinessName}" class="form-control"/>
                <g:hasErrors bean="${loanGuaranteeInstance}" field="sbgfcBusinessName">
                <div class="controls">
                    <span class="help-block">
                        <g:eachError bean="${loanGuaranteeInstance}" field="sbgfcBusinessName" >
                            <g:message error="${it}" /><br/>
                        </g:eachError>
                    </span>
                </div>
             </g:hasErrors>   
         </div>
</div>
