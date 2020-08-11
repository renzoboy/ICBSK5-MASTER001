<!--
  To change this license header, choose License Headers in Project Properties.
  To change this template file, choose Tools | Templates
  and open the template in the editor.
-->

<%@ page contentType="text/html;charset=UTF-8" %>

<legend>Home Guarantee Corporation</legend>


<div class="form-group fieldcontain ${hasErrors(bean: loanGuaranteeInstance, field: 'hgcValueForEnrollment', 'has-error')} ">
	<label class="control-label col-sm-4"for="hgcValueForEnrollment">
		<g:message code="loan.hgcValueForEnrollment.label" default="Value for Enrollment" />
		<span class="required-indicator"></span>
	</label>
	 <div class="col-sm-8">
                <g:field type="text" id="hgcValueForEnrollment"name="hgcValueForEnrollment"  value="${loanGuaranteeInstance?.hgcValueForEnrollment}  "class="form-control truncated"/>
                <g:hasErrors bean="${loanGuaranteeInstance}" field="hgcValueForEnrollment">
                <div class="controls">
                    <span class="help-block">
                        <g:eachError bean="${loanGuaranteeInstance}" field="hgcValueForEnrollment" >
                            <g:message error="${it}" /><br/>
                        </g:eachError>
                    </span>
                </div>
             </g:hasErrors>   
         </div>
</div>
<div class="form-group fieldcontain ${hasErrors(bean: loanGuaranteeInstance, field: 'hgcCoverageStartPeriod', 'has-error')} ">
	<label class="control-label col-sm-4"for="hgcCoverageStartPeriod">
		<g:message code="loan.hgcCoverageStartPeriod.label" default="Coverage Period Start Date" />
		<span class="required-indicator"></span>
	</label>
        <div class="col-sm-8">
              <g:customDatePicker  id="hgcCoverageStartPeriod" name="hgcCoverageStartPeriod" value="${loanGuaranteeInstance?.hgcCoverageStartPeriod}"class="form-control"  />
               <g:hasErrors bean="${loanGuaranteeInstance}" field="hgcCoverageStartPeriod">
               <div class="controls">
                   <span class="help-block">
                       <g:eachError bean="${loanGuaranteeInstance}" field="hgcCoverageStartPeriod" >
                           <g:message error="${it}" /><br/>
                       </g:eachError>
                   </span>
               </div>
            </g:hasErrors>   
        </div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: loanGuaranteeInstance, field: 'hgcCoverageEndPeriod', 'has-error')} ">
	<label class="control-label col-sm-4"for="hgcCoverageEndPeriod">
		<g:message code="loan.hgcCoverageEndPeriod.label" default="Coverage Period End Date" />
		<span class="required-indicator"></span>
	</label>
        <div class="col-sm-8">
              <g:customDatePicker  id="hgcCoverageEndPeriod" name="hgcCoverageEndPeriod" value="${loanGuaranteeInstance?.hgcCoverageEndPeriod}"class="form-control"  />
               <g:hasErrors bean="${loanGuaranteeInstance}" field="hgcCoverageEndPeriod">
               <div class="controls">
                   <span class="help-block">
                       <g:eachError bean="${loanGuaranteeInstance}" field="hgcCoverageEndPeriod" >
                           <g:message error="${it}" /><br/>
                       </g:eachError>
                   </span>
               </div>
            </g:hasErrors>   
        </div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: loanGuaranteeInstance, field: 'hgcPremiumRate', 'has-error')} ">
	<label class="control-label col-sm-4"for="hgcPremiumRate">
		<g:message code="loan.hgcPremiumRate.label" default="Premium Rate" />
		<span class="required-indicator"></span>
	</label>
	 <div class="col-sm-8">
                <g:field type="text" id="hgcPremiumRate" name="hgcPremiumRate"  value="${loanGuaranteeInstance?.hgcPremiumRate}" class="form-control" />
                <g:hasErrors bean="${loanGuaranteeInstance}" field="hgcPremiumRate">
                <div class="controls">
                    <span class="help-block">
                        <g:eachError bean="${loanGuaranteeInstance}" field="hgcPremiumRate" >
                            <g:message error="${it}" /><br/>
                        </g:eachError>
                    </span>
                </div>
             </g:hasErrors>   
         </div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: loanGuaranteeInstance, field: 'hgcPremiumDue', 'has-error')} ">
	<label class="control-label col-sm-4"for="hgcPremiumDue">
		<g:message code="loan.hgcPremiumDue.label" default="Premium Due" />
		<span class="required-indicator"></span>
	</label>
	 <div class="col-sm-8">
                <g:field type="text" id="hgcPremiumDue" name="hgcPremiumDue"  value="${loanGuaranteeInstance?.hgcPremiumDue}"class="form-control"/>
                <g:hasErrors bean="${loanGuaranteeInstance}" field="hgcPremiumDue">
                <div class="controls">
                    <span class="help-block">
                        <g:eachError bean="${loanGuaranteeInstance}" field="hgcPremiumDue" >
                            <g:message error="${it}" /><br/>
                        </g:eachError>
                    </span>
                </div>
             </g:hasErrors>   
         </div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: loanGuaranteeInstance, field: 'hgcTctNo', 'has-error')} ">
	<label class="control-label col-sm-4"for="hgcTctNo">
		<g:message code="loan.hgcTctNo.label" default="TCT or CCT No." />
		<span class="required-indicator"></span>
	</label>
	 <div class="col-sm-8">
                <g:field type="text" id="hgcTctNo" name="hgcTctNo"  value="${loanGuaranteeInstance?.hgcTctNo}"class="form-control"/>
                <g:hasErrors bean="${loanGuaranteeInstance}" field="hgcTctNo">
                <div class="controls">
                    <span class="help-block">
                        <g:eachError bean="${loanGuaranteeInstance}" field="hgcTctNo" >
                            <g:message error="${it}" /><br/>
                        </g:eachError>
                    </span>
                </div>
             </g:hasErrors>   
         </div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: loanGuaranteeInstance, field: 'hgcLocation', 'has-error')} ">
	<label class="control-label col-sm-4"for="hgcLocation">
		<g:message code="loan.hgcLocation.label" default="Location" />
		<span class="required-indicator"></span>
	</label>
	 <div class="col-sm-8">
                <g:field type="text" id="hgcLocation" name="hgcLocation"  value="${loanGuaranteeInstance?.hgcLocation}"class="form-control"/>
                <g:hasErrors bean="${loanGuaranteeInstance}" field="hgcLocation">
                <div class="controls">
                    <span class="help-block">
                        <g:eachError bean="${loanGuaranteeInstance}" field="hgcLocation" >
                            <g:message error="${it}" /><br/>
                        </g:eachError>
                    </span>
                </div>
             </g:hasErrors>   
         </div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: loanGuaranteeInstance, field: 'hgcAppraisedValue', 'has-error')} ">
	<label class="control-label col-sm-4"for="hgcAppraisedValue">
		<g:message code="loan.hgcAppraisedValue.label" default="Appraised Value" />
		<span class="required-indicator"></span>
	</label>
	 <div class="col-sm-8">
                <g:field type="text" id="hgcAppraisedValue" name="hgcAppraisedValue"  value="${loanGuaranteeInstance?.hgcAppraisedValue}"class="form-control truncated"/>
                <g:hasErrors bean="${loanGuaranteeInstance}" field="hgcAppraisedValue">
                <div class="controls">
                    <span class="help-block">
                        <g:eachError bean="${loanGuaranteeInstance}" field="hgcAppraisedValue" >
                            <g:message error="${it}" /><br/>
                        </g:eachError>
                    </span>
                </div>
             </g:hasErrors>   
         </div>
</div>
<div class="form-group fieldcontain ${hasErrors(bean: loanGuaranteeInstance, field: 'hgcLoanToValueRatio', 'has-error')} ">
	<label class="control-label col-sm-4"for="hgcLoanToValueRatio">
		<g:message code="loan.hgcLoanToValueRatio.label" default="Loan to Value Ratio(Based on Appraised Value)" />
		<span class="required-indicator"></span>
	</label>
	 <div class="col-sm-8">
                <g:field type="text" id="hgcLoanToValueRatio" name="hgcLoanToValueRatio"  value="${loanGuaranteeInstance?.hgcLoanToValueRatio}"class="form-control truncated"/>
                <g:hasErrors bean="${loanGuaranteeInstance}" field="hgcLoanToValueRatio">
                <div class="controls">
                    <span class="help-block">
                        <g:eachError bean="${loanGuaranteeInstance}" field="hgcLoanToValueRatio" >
                            <g:message error="${it}" /><br/>
                        </g:eachError>
                    </span>
                </div>
             </g:hasErrors>   
         </div>
</div>
<br>
<br>
<legend>Additional Data for Staggered/Additional Released</legend>
<div class="form-group fieldcontain ${hasErrors(bean: loanGuaranteeInstance, field: 'hgcValueOfNewReleaseForEnrollment', 'has-error')} ">
	<label class="control-label col-sm-4"for="hgcValueOfNewReleaseForEnrollment">
		<g:message code="loan.hgcValueOfNewReleaseForEnrollment.label" default="Value of New Release for Enrollment" />
		<span class="required-indicator"></span>
	</label>
	 <div class="col-sm-8">
                <g:field type="text" id="hgcValueOfNewReleaseForEnrollment" name="hgcValueOfNewReleaseForEnrollment"  value="${loanGuaranteeInstance?.hgcValueOfNewReleaseForEnrollment}"class="form-control truncated"/>
                <g:hasErrors bean="${loanGuaranteeInstance}" field="hgcValueOfNewReleaseForEnrollment">
                <div class="controls">
                    <span class="help-block">
                        <g:eachError bean="${loanGuaranteeInstance}" field="hgcValueOfNewReleaseForEnrollment" >
                            <g:message error="${it}" /><br/>
                        </g:eachError>
                    </span>
                </div>
             </g:hasErrors>   
         </div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: loanGuaranteeInstance, field: 'hgcTotalAmountReleased', 'has-error')} ">
	<label class="control-label col-sm-4"for="hgcTotalAmountReleased">
		<g:message code="loan.hgcTotalAmountReleased.label" default="Total Amount Released Including Value of Enrollment" />
		<span class="required-indicator"></span>
	</label>
	 <div class="col-sm-8">
                <g:field type="text" id="hgcTotalAmountReleased" name="hgcTotalAmountReleased"  value="${loanGuaranteeInstance?.hgcTotalAmountReleased}"class="form-control truncated"/>
                <g:hasErrors bean="${loanGuaranteeInstance}" field="hgcTotalAmountReleased">
                <div class="controls">
                    <span class="help-block">
                        <g:eachError bean="${loanGuaranteeInstance}" field="hgcTotalAmountReleased" >
                            <g:message error="${it}" /><br/>
                        </g:eachError>
                    </span>
                </div>
             </g:hasErrors>   
         </div>
</div>


<div class="form-group fieldcontain ${hasErrors(bean: loanGuaranteeInstance, field: 'hgcloanReleasedDate', 'has-error')} ">
	<label class="control-label col-sm-4"for="hgcloanReleasedDate">
		<g:message code="loan.hgcloanReleasedDate.label" default="Date Loan Released(of loan under enrollment)" />
		<span class="required-indicator"></span>
	</label>
        <div class="col-sm-8">

              <g:customDatePicker  id="hgcloanReleasedDate" name="hgcloanReleasedDate" value="${loanGuaranteeInstance?.hgcloanReleasedDate}"class="form-control"  />
               <g:hasErrors bean="${loanGuaranteeInstance}" field="hgcloanReleasedDate">
               <div class="controls">
                   <span class="help-block">
                       <g:eachError bean="${loanGuaranteeInstance}" field="hgcloanReleasedDate" >
                           <g:message error="${it}" /><br/>
                       </g:eachError>
                   </span>
               </div>
            </g:hasErrors>   
        </div>
</div>
<div class="form-group fieldcontain ${hasErrors(bean: loanGuaranteeInstance, field: 'hgcCogNoOfTheFirstReleased', 'has-error')} ">
	<label class="control-label col-sm-4"for="hgcCogNoOfTheFirstReleased">
		<g:message code="loan.hgcCogNoOfTheFirstReleased.label" default="COG No. of the First Released" />
		<span class="required-indicator"></span>
	</label>
	 <div class="col-sm-8">
                <g:field type="text" id="hgcCogNoOfTheFirstReleased" name="hgcCogNoOfTheFirstReleased"  value="${loanGuaranteeInstance?.hgcCogNoOfTheFirstReleased}"class="form-control"/>
                <g:hasErrors bean="${loanGuaranteeInstance}" field="hgcCogNoOfTheFirstReleased">
                <div class="controls">
                    <span class="help-block">
                        <g:eachError bean="${loanGuaranteeInstance}" field="hgcTotalAmountReleased" >
                            <g:message error="${it}" /><br/>
                        </g:eachError>
                    </span>
                </div>
             </g:hasErrors>   
         </div>
</div>
<div class="form-group fieldcontain ${hasErrors(bean: loanGuaranteeInstance, field: 'hgcAddCoverageStartPeriod', 'has-error')} ">
	<label class="control-label col-sm-4"for="hgcAddCoverageStartPeriod">
		<g:message code="loan.hgcAddCoverageStartPeriod.label" default="Coverage Period Start Date" />
		<span class="required-indicator"></span>
	</label>
        <div class="col-sm-8">
              <g:customDatePicker  id="hgcAddCoverageStartPeriod" name="hgcAddCoverageStartPeriod" value="${loanGuaranteeInstance?.hgcAddCoverageStartPeriod}"class="form-control"  />
               <g:hasErrors bean="${loanGuaranteeInstance}" field="hgcAddCoverageStartPeriod">
               <div class="controls">
                   <span class="help-block">
                       <g:eachError bean="${loanGuaranteeInstance}" field="hgcAddCoverageStartPeriod" >
                           <g:message error="${it}" /><br/>
                       </g:eachError>
                   </span>
               </div>
            </g:hasErrors>   
        </div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: loanGuaranteeInstance, field: 'hgcAddCoverageEndPeriod', 'has-error')} ">
	<label class="control-label col-sm-4"for="hgcAddCoverageEndPeriod">
		<g:message code="loan.hgcAddCoverageEndPeriod.label" default="Coverage Period End Date" />
		<span class="required-indicator"></span>
	</label>
        <div class="col-sm-8">
              <g:customDatePicker  id="hgcAddCoverageEndPeriod" name="hgcAddCoverageEndPeriod" value="${loanGuaranteeInstance?.hgcAddCoverageEndPeriod}"class="form-control"  />
               <g:hasErrors bean="${loanGuaranteeInstance}" field="hgcAddCoverageEndPeriod">
               <div class="controls">
                   <span class="help-block">
                       <g:eachError bean="${loanGuaranteeInstance}" field="hgcAddCoverageEndPeriod" >
                           <g:message error="${it}" /><br/>
                       </g:eachError>
                   </span>
               </div>
            </g:hasErrors>   
        </div>
</div>
<div class="form-group fieldcontain ${hasErrors(bean: loanGuaranteeInstance, field: 'hgcAddPremiumDue', 'has-error')} ">
	<label class="control-label col-sm-4"for="hgcPremiumDue">
		<g:message code="loan.hgcAddPremiumDue.label" default="Premium Due" />
		<span class="required-indicator"></span>
	</label>
	 <div class="col-sm-8">
                <g:field type="text" id="hgcAddPremiumDue" name="hgcAddPremiumDue"  value="${loanGuaranteeInstance?.hgcAddPremiumDue}"class="form-control"/>
                <g:hasErrors bean="${loanGuaranteeInstance}" field="hgcAddPremiumDue">
                <div class="controls">
                    <span class="help-block">
                        <g:eachError bean="${loanGuaranteeInstance}" field="hgcAddPremiumDue" >
                            <g:message error="${it}" /><br/>
                        </g:eachError>
                    </span>
                </div>
             </g:hasErrors>   
         </div>
</div>