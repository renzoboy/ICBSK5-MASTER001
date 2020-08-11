<!--
  To change this license header, choose License Headers in Project Properties.
  To change this template file, choose Tools | Templates
  and open the template in the editor.
-->
<script>
    function getCommodity(){
    var agfpCommodity = $('#agfpCommodity').val();
    var loanGranted = $('#loanGranted').val();
    
    console.log("loanGranted: " + loanGranted);
    if(agfpCommodity==""){

    }else{
      //=================== AJAX FUNCTION to validate code if existing
        var obj = { 
            agfpCommodity: agfpCommodity,
        }; 
        console.log(JSON.stringify(obj));
        console.log("Object Loaded iwth data...");
        $.ajax({
            type: "POST",
            contentType: "application/json",
            url: "${createLink(controller:'loan', action:'commodityRateAjax')}",
            data: JSON.stringify(obj),

            success: function(data){
                    $.each(data, function (_key, _value) {
                        console.log(JSON.stringify(obj))
                        //console.log(_value.rate);
                        //$('#agfpGuaranteeFee').val(parseFloat(_value.rate)  parseFloat(loanGranted));

                    });

            },
            error: function(data){

            },

        });                                            
    }

}
</script>
<%@ page contentType="text/html;charset=UTF-8" %>
<div class="fieldcontain form-group ${hasErrors(bean: loanGuaranteeInstance, field: 'agfpCommodity', 'has-error')} required">
    <label class="control-label col-sm-4" for="agfpCommodity">
	    <g:message code="loan.agfpCommodity.label" default="Commodity" />
	</label>
    <div class="col-sm-8">
        <g:select id="agfpCommodity" name="agfpCommodity" noSelection="${['':'Select One Commodity']}" from="${icbs.lov.Commodity.list()}" optionKey="id" optionValue="description" required="" value="${loanGuaranteeInstance?.agfpCommodity?.id}" class="many-to-one form-control"/>
        <g:hasErrors bean="${loanGuaranteeInstance}" field="agfpCommodity">
            <div class="controls">
                <span class="help-block">
                    <g:eachError bean="${loanGuaranteeInstance}" field="agfpCommodity">
                        <g:message error="${it}" /><br/>
                    </g:eachError>
                </span>
            </div>
        </g:hasErrors>
    </div>             
</div>

<div class="form-group fieldcontain ${hasErrors(bean: loanGuaranteeInstance, field: 'agfpHectaresOrHeads', 'has-error')} ">
	<label class="control-label col-sm-4"for="agfpHectaresOrHeads">
		<g:message code="loan.agfpHectaresOrHeads.label" default="Hectar Age/No. of Heads" />
		<span class="required-indicator"></span>
	</label>
	 <div class="col-sm-8">
                <g:field type="text" id="agfpHectaresOrHeads"name="agfpHectaresOrHeads"  value="${loanGuaranteeInstance?.agfpHectaresOrHeads}"class="form-control"/>
                <g:hasErrors bean="${loanGuaranteeInstance}" field="agfpHectaresOrHeads">
                <div class="controls">
                    <span class="help-block">
                        <g:eachError bean="${loanGuaranteeInstance}" field="agfpHectaresOrHeads" >
                            <g:message error="${it}" /><br/>
                        </g:eachError>
                    </span>
                </div>
             </g:hasErrors>   
         </div>
</div>
<%--
<div class="form-group fieldcontain ${hasErrors(bean: loanGuaranteeInstance, field: 'agfpPcicInsured', 'has-error')} ">
	<label class="control-label col-sm-4"for="agfpPcicInsured">
		<g:message code="loan.agfpPcicInsured.label" default="PCIC Insured" />
		<span class="required-indicator"></span>
	</label>
	 <div class="col-sm-8">
                <g:field type="text" id="agfpPcicInsured" name="agfpPcicInsured"  value="${loanGuaranteeInstance?.agfpPcicInsured}" class="form-control" readonly="readonly"/>
                <g:hasErrors bean="${loanGuaranteeInstance}" field="agfpPcicInsured">
                <div class="controls">
                    <span class="help-block">
                        <g:eachError bean="${loanGuaranteeInstance}" field="agfpPcicInsured" >
                            <g:message error="${it}" /><br/>
                        </g:eachError>
                    </span>
                </div>
             </g:hasErrors>   
         </div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: loanGuaranteeInstance, field: 'agfpArbBorrower', 'has-error')} ">
	<label class="control-label col-sm-4"for="agfpArbBorrower">
		<g:message code="loan.agfpArbBorrower.label" default="ARB Borrower" />
		<span class="required-indicator"></span>
	</label>
	 <div class="col-sm-8">
                <g:field type="text" id="agfpArbBorrower" name="agfpArbBorrower"  value="${loanGuaranteeInstance?.agfpArbBorrower}"class="form-control" readonly = "readonly"/>
                <g:hasErrors bean="${loanGuaranteeInstance}" field="agfpArbBorrower">
                <div class="controls">
                    <span class="help-block">
                        <g:eachError bean="${loanGuaranteeInstance}" field="agfpArbBorrower" >
                            <g:message error="${it}" /><br/>
                        </g:eachError>
                    </span>
                </div>
             </g:hasErrors>   
         </div>
</div>
--%>
<div class="form-group fieldcontain ${hasErrors(bean: loanGuaranteeInstance, field: 'agfpGuaranteeRate', 'has-error')} ">
	<label class="control-label col-sm-4"for="agfpGuaranteeRate">
		<g:message code="loan.agfpGuaranteeRate.label" default="Guarantee Fee rate" />
		<span class="required-indicator"></span>
	</label>
	 <div class="col-sm-8">
                <g:field type="text" id="agfpGuaranteeRate" name="agfpGuaranteeRate"  value="${loanGuaranteeInstance?.agfpGuaranteeRate}"class="form-control"/>
                <g:hasErrors bean="${loanGuaranteeInstance}" field="agfpGuaranteeRate">
                <div class="controls">
                    <span class="help-block">
                        <g:eachError bean="${loanGuaranteeInstance}" field="agfpGuaranteeRate" >
                            <g:message error="${it}" /><br/>
                        </g:eachError>
                    </span>
                </div>
             </g:hasErrors>   
         </div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: loanGuaranteeInstance, field: 'agfpGuaranteeFee', 'has-error')} ">
	<label class="control-label col-sm-4"for="agfpGuaranteeFee">
		<g:message code="loan.agfpGuaranteeFee.label" default="Guarantee Fee" />
		<span class="required-indicator"></span>
	</label>
	 <div class="col-sm-8">
                <g:field id="agfpGuaranteeFee" name="agfpGuaranteeFee"  value="${loanGuaranteeInstance?.agfpGuaranteeFee}"class="form-control truncated"/>
                <g:hasErrors bean="${loanGuaranteeInstance}" field="agfpGuaranteeFee">
                <div class="controls">
                    <span class="help-block">
                        <g:eachError bean="${loanGuaranteeInstance}" field="agfpGuaranteeFee" >
                            <g:message error="${it}" /><br/>
                        </g:eachError>
                    </span>
                </div>
             </g:hasErrors>   
         </div>
</div>

<div class="form-group fieldcontain ${hasErrors(bean: loanGuaranteeInstance, field: 'agfpReferred', 'has-error')} ">
	<label class="control-label col-sm-4"for="agfpReferred">
		<g:message code="loan.agfpReferred.label" default="Referred" />
		<span class="required-indicator"></span>
	</label>
	 <div class="col-sm-8">
                <g:field type="text" id="agfpReferred" name="agfpReferred"  value="${loanGuaranteeInstance?.agfpReferred}"class="form-control"/>
                <g:hasErrors bean="${loanGuaranteeInstance}" field="agfpReferred">
                <div class="controls">
                    <span class="help-block">
                        <g:eachError bean="${loanGuaranteeInstance}" field="agfpReferred" >
                            <g:message error="${it}" /><br/>
                        </g:eachError>
                    </span>
                </div>
             </g:hasErrors>   
         </div>
</div>


<div class="form-group fieldcontain ${hasErrors(bean: loanGuaranteeInstance, field: 'agfpRemarks', 'has-error')} ">
	<label class="control-label col-sm-4"for="agfpRemarks">
		<g:message code="loan.agfpRemarks.label" default="Remarks" />
		<span class="required-indicator"></span>
	</label>
	 <div class="col-sm-8">
                <g:field type="text" id="agfpRemarks" name="agfpRemarks"  value="${loanGuaranteeInstance?.agfpRemarks}"class="form-control"/>
                <g:hasErrors bean="${loanGuaranteeInstance}" field="agfpRemarks">
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
<g:hiddenField name="loanGranted" id="loanGranted" value="${loanInstance?.grantedAmount}"/>
