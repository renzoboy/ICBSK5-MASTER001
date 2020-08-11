<!--
  To change this license header, choose License Headers in Project Properties.
  To change this template file, choose Tools | Templates
  and open the template in the editor.
-->

<%@ page contentType="text/html;charset=UTF-8" %>

<div class=" form-group fieldcontain">
        <label class="control-label">
            <g:message code="inwardCheckClearing.file.label" default="Bank format" />
        </label>   
        <div class="col-sm-4">
            <g:select id="iccBankFormat" name="iccBankFormat"  required="true" noSelection="${['':'']}" from="${icbs.lov.IccBank.findAllByStatus(true)}" value="" optionKey="id" optionValue ="description" onchange="bankformat();" class="form-control"/>
        </div>
</div>
</br>
<div class=" form-group fieldcontain" id="divclearing">       
        <label class="control-label col-sm-4">
            <g:message code="inwardCheckClearing.file.label" default="Clearing File Name" />
        </label>
        <div class="col-sm-4">
            <input type="file" id="checkClearing" name="checkClearing"class="form-control" />
        </div>
</div>

</br>
</br>
