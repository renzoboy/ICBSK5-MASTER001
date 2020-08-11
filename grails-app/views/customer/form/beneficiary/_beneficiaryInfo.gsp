<!--
  To change this license header, choose License Headers in Project Properties.
  To change this template file, choose Tools | Templates
  and open the template in the editor.
-->

<%@ page contentType="text/html;charset=UTF-8" %>
<legend>Beneficiaries</legend>
    <g:render template='form/beneficiary/onetomany/beneficiary' model="['beneficiary':customerInstance?.beneficiaries[0],'i':0]"/>
<!-- Dito ung mga Phones Magaapend -->
<div id="beneficiaryList">
                <g:each var="beneficiary" in="${customerInstance.beneficiaries}" status="i">
                    <g:if test="${i>0&&(beneficiary?.status?.id==2||!beneficiary?.id)}">
                           <g:render template='form/beneficiary/onetomany/beneficiary' model="['beneficiary':beneficiary,'i':i]"/>
                    </g:if>
                </g:each>
                        
                 
 </div>
 
<div class="form-group form-buttons">
    <button type="button" class="btn btn-primary multi-field-btn" onclick="addBeneficiaryAjax()"><span class="fa fa-plus"></span> Add more Beneficiary</button>
 </div>
 
    