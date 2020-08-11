<!--
  To change this license header, choose License Headers in Project Properties.
  To change this template file, choose Tools | Templates
  and open the template in the editor.
-->

<%@ page contentType="text/html;charset=UTF-8" %>
<legend>Insurance Details</legend>
    <g:render template='form/insurance/onetomany/insurance' model="['insurance':customerInstance?.insurances[0],'i':0]"/>
<!-- Dito ung mga Phones Magaapend -->
<div id="insuranceList">
                <g:each var="insurance" in="${customerInstance.insurances}" status="i">
                    <g:if test="${i>0&&(insurance?.status?.id==2||!insurance?.id)}">
                           <g:render template='form/insurance/onetomany/insurance' model="['insurance':insurance,'i':i]"/>
                    </g:if>
                </g:each>
                        
                 
 </div>

 
    