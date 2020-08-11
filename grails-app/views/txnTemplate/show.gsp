<%@ page import="icbs.admin.TxnTemplate" %>
<%@ page import="icbs.gl.GlAccount" %>

<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'txnTemplate.label', default: 'TxnTemplate')}" />
		<title>Transaction Template Information</title>
	</head>
	<body>
	<content tag="breadcrumbs">
	  <span class="fa fa-chevron-right"></span><a href="${createLink(uri:'/txnTemplate')}">Transction Template List</a>
      <span class="fa fa-chevron-right"></span><span class="current">Transaction Template Information</span>
	</content>
    <content tag="main-content">   
		<div id="show-txnTemplate" class="content scaffold-show" role="main">
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>

			<div class="nav-tab-container">
              <ul class="nav nav-tabs">
                <li class="active"><a href="#tab_1" data-toggle="tab">Transaction Template Details</a></li>
                <li><a href="#tab_2" data-toggle="tab">Charges</a></li>
              </ul>
            </div>

            <div class="tab-content">
            	<div class="tab-pane active fade in" id="tab_1">
                    <div class="section-container">
                    <fieldset>
                    <legend class="section-header"> Transaction Template Details </legend>
                     <table class="table table-bordered table-striped">
                        <tbody>
                            <g:if test="${txnTemplateInstance?.txnModule}">
                            <tr>
                                <td style="font-weight:bold" width="30%">Txn Module</td>
                                <td width="70%">${txnTemplateInstance?.txnModule?.description}</td>
                            </tr>
                            </g:if>
                            <g:if test="${txnTemplateInstance?.txnType}">
                            <tr>
                                <td style="font-weight:bold" width="30%">Txn Type</td>
                                <td width="70%">${txnTemplateInstance?.txnType?.description}</td>
                            </tr>
                            </g:if>
                            <g:if test="${txnTemplateInstance?.code}">
                            <tr>
                                <td style="font-weight:bold" width="30%">Code</td>
                                <td width="70%"><g:fieldValue bean="${txnTemplateInstance}" field="code"/></td>
                            </tr>
                            </g:if>
                            <g:if test="${txnTemplateInstance?.description}">
                            <tr>
                                <td style="font-weight:bold" width="30%">Description</td>
                                <td width="70%"><g:fieldValue bean="${txnTemplateInstance}" field="description"/></td>
                            </tr>
                            </g:if>
                            <g:if test="${txnTemplateInstance?.shortDescription}">
                            <tr>
                                <td style="font-weight:bold" width="30%">Short Description</td>
                                <td width="70%"><g:fieldValue bean="${txnTemplateInstance}" field="shortDescription"/></td>
                            </tr>
                            </g:if>
                            <g:if test="${txnTemplateInstance?.minAmt}">
                            <tr>
                                <td style="font-weight:bold" width="30%">Min Amt</td>
                                <td width="70%"><g:fieldValue bean="${txnTemplateInstance}" field="minAmt"/></td>
                            </tr>
                            </g:if>
                            <g:if test="${txnTemplateInstance?.maxAmt}">
                            <tr>
                                <td style="font-weight:bold" width="30%">Max Amt</td>
                                <td width="70%"><g:fieldValue bean="${txnTemplateInstance}" field="maxAmt"/></td>
                            </tr>
                            </g:if>
                            <g:if test="${txnTemplateInstance?.amlaCode}">
                            <tr>
                                <td style="font-weight:bold" width="30%">Amla Cod</td>
                                <td width="70%"><g:fieldValue bean="${txnTemplateInstance}" field="amlaCode"/></td>
                            </tr>
                            </g:if>        
                            <g:if test="${txnTemplateInstance?.defContraAcct}">
                            <tr>
                                <td style="font-weight:bold" width="30%">Dep Contra Acct</td>
                                <td width="70%"><g:fieldValue bean="${txnTemplateInstance}" field="defContraAcct"/></td>
                            </tr>
                            <tr>
                                <td style="font-weight:bold" width="30%">Dep Contra Acct Description</td>
                                <td width="70%">${GlAccount.findByCode(txnTemplateInstance?.defContraAcct).name}</td>
                            </tr>
                            </g:if>  
                            <g:if test="${txnTemplateInstance?.requireTxnReference}">
                            <tr>
                                <td style="font-weight:bold" width="30%">Require Txn Reference</td>
                                <td width="70%"><g:fieldValue bean="${txnTemplateInstance}" field="requireTxnReference"/></td>
                            </tr>
                            </g:if>   
                            <g:if test="${txnTemplateInstance?.validationCopyNo}">
                            <tr>
                                <td style="font-weight:bold" width="30%">Validation Copy No</td>
                                <td width="70%"><g:fieldValue bean="${txnTemplateInstance}" field="validationCopyNo"/></td>
                            </tr>
                            </g:if> 
                            <g:if test="${txnTemplateInstance?.validationFormCode}">
                            <tr>
                                <td style="font-weight:bold" width="30%">Other AMLA Information</td>
                                <td width="70%"><g:fieldValue bean="${txnTemplateInstance}" field="validationFormCode"/></td>
                            </tr>
                            </g:if>      
                            <g:if test="${txnTemplateInstance?.currency}">
                            <tr>
                                <td style="font-weight:bold" width="30%">Currency</td>
                                <td width="70%"><g:link controller="currency" action="show" id="${txnTemplateInstance?.currency?.id}">${txnTemplateInstance?.currency?.name}</g:link></td>
                            </tr>
                            </g:if> 
                            <g:if test="${txnTemplateInstance?.requirePassbook}">
                            <tr>
                                <td style="font-weight:bold" width="30%">Require Passbook</td>
                                <td width="70%">${txnTemplateInstance?.requirePassbook?.description}</td>
                            </tr>
                            </g:if>     
                            <g:if test="${txnTemplateInstance?.atmOnlyTxn}">
                            <tr>
                                <td style="font-weight:bold" width="30%">Atm Only Txn</td>
                                <td width="70%">${txnTemplateInstance?.atmOnlyTxn?.description}</td>
                            </tr>
                            </g:if>
                            <g:if test="${txnTemplateInstance?.interbranchTxn}">
                            <tr>
                                <td style="font-weight:bold" width="30%">Interbranch Txn</td>
                                <td width="70%">${txnTemplateInstance?.interbranchTxn?.description}</td>
                            </tr>
                            </g:if>
                            <g:if test="${txnTemplateInstance?.systemOnlyTxn}">
                            <tr>
                                <td style="font-weight:bold" width="30%">System Only Txn</td>
                                <td width="70%"><g:formatBoolean boolean="${txnTemplateInstance?.systemOnlyTxn}" /></td>
                            </tr>
                            </g:if>
                            <g:if test="${txnTemplateInstance?.memoTxnType}">
                            <tr>
                                <td style="font-weight:bold" width="30%">Memo Txn Type</td>
                                <td width="70%">${txnTemplateInstance?.memoTxnType?.description}</td>
                            </tr>
                            </g:if>   
                            <g:if test="${txnTemplateInstance?.batchTxn}">
                            <tr>
                                <td style="font-weight:bold" width="30%">Batch Txn</td>
                                <td width="70%">${txnTemplateInstance?.batchTxn?.description}</td>
                            </tr>
                            </g:if> 
                            <g:if test="${txnTemplateInstance?.configItemStatus}">
                            <tr>
                                <td style="font-weight:bold" width="30%">Config Item Status</td>
                                <td width="70%">${txnTemplateInstance?.configItemStatus?.description}</td>
                            </tr>
                            </g:if>
                        
                        </tbody>
                    </table>
                    </fieldset>
                    </div>
					

                </div>

				<div class="tab-pane fade in" id="tab_2">
            		<ul>
					<g:each in="${txnTemplateInstance.charges}" var="charge" >
						<li>${charge.description}</li>
					</g:each>
					</ul>
            	</div>
            </div>

			<g:form url="[resource:txnTemplateInstance, action:'delete']" method="DELETE">
			</g:form>
		</div>
    </content>
    <content tag="main-actions">
        <ul>
           <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
           <li><g:link class="edit" action="updateTxnTemplate" id="${txnTemplateInstance?.id}"> Edit</g:link></li>
           <li><g:link action="create">Create new Transaction Template</g:link></li>
           <li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
            
	</ul>
    </content>
	</body>
</html>
