
<%@ page import="icbs.deposit.DocInventory" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'docInventory.label', default: 'DocInventory')}" />
		<title>Show Deposit Inventory</title>
	</head>
	<body>
             <content tag="breadcrumbs">
                <span class="fa fa-chevron-right"></span><a href="${createLink(uri: '/docInventory')}">Document Inventory</a>
                <span class="fa fa-chevron-right"></span><span class="current">Show Deposit Inventory</span>
            </content>
            <content tag="main-content">   
		<div id="show-docInventory" class="content scaffold-show" role="main">
                    <g:if test="${flash.message}">
			<!-- div class="message" role="status">${flash.message}</div -->
                            <script>
                            $(function(){
                                var x = '${flash.message}';
                                    notify.message(x);
                                    //$('#SlipTransaction').hide();
                                    if(x.indexOf('|success') > -1){
                                    //$('#SlipTransaction').show();
                                }
                            });
                            </script>
                    </g:if>
                    <table class="table table-bordered table-rounded table-striped table-hover">
                        <tbody>
                            <tr>
                                <td style="width:30%"><label>Branch</label></td>
                                <td style="width:70%"><g:link controller="branch" action="show" id="${docInventoryInstance?.branch?.id}">${docInventoryInstance?.branch?.name.encodeAsHTML()}</g:link></td>    
                            </tr> 
                            <tr>
                                <td style="width:30%"><label>Type</label></td>
                                <td style="width:70%">${docInventoryInstance?.type?.encodeAsHTML()}</td>
                            </tr>
                            <tr>
                                <td style="width:30%"><label>Series Start</label></td>
                                <td style="width:70%">${docInventoryInstance?.seriesStart}</td>
                            </tr>
                            <tr>
                                <td style="width:30%"><label>Series End</label></td>
                                <td style="width:70%">${docInventoryInstance?.seriesEnd}</td>
                            </tr>
                            <tr>
                                <td style="width:30%"><label>Usage Count</label></td>
                                <td style="width:70%">${docInventoryInstance?.usageCount}</td>
                            </tr>
                            <tr>
                                <td style="width:30%"><label>Particulars</label></td>
                                <td style="width:70%">${docInventoryInstance?.docParticulars}</td>
                            </tr>
                            <tr>
                                <td style="width:30%"><label>Checking Account Number (Checks)</label></td>
                                <td style="width:70%">${docInventoryInstance?.checkAcctNo}</td>
                            </tr>
                            <tr>
                                <td style="width:30%"><label>Doc Inventory Item Canceled</label></td>
                                <td style="width:70%"><g:formatBoolean boolean="${docInventoryInstance?.isCanceled}" /></td>
                            </tr>
                            <tr>
                                <td style="width:30%"><label>Canceled Date</label></td>
                                <td style="width:70%"><g:formatDate format="yyyy-MM-dd" date="${docInventoryInstance?.canceledAt}" /></td>
                            </tr>
                            <tr>
                                <td style="width:30%"><label>Canceled By</label></td>
                                <td style="width:70%"><g:link controller="userMaster" action="show" id="${docInventoryInstance?.canceledBy?.username}">${docInventoryInstance?.canceledBy?.encodeAsHTML()}</g:link></td>
                            </tr>  
                            <tr>
                                <td style="width:30%"><label>Status</label></td>
                                <td style="width:70%">${docInventoryInstance?.status?.encodeAsHTML()}</td>
                            </tr>
 
                        </tbody>
                    </table>
		</div>
            </content>
             <content tag="main-actions">
                <ul>
                    <li><g:link class="list" action="index">Document Inventory List</g:link></li>
      			<li><g:link class="create" action="create">Create Document Inventory</g:link></li>
                <li><button disabled="disabled">View Document Inventory</button></li>
                <!--        
                <li><g:link action="edit"id="${docInventoryInstance.id}">Update Document Inventory</g:link></li>
                -->
                <g:if test="${docInventoryInstance.status.id == 1}">
                    <li><g:form url="[id:docInventoryInstance.id, action:'activate']" method="POST">
			<g:actionSubmit action="activate" value="Activate" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
                    </g:form></li>
                </g:if>
<!--Action cancel added -->
                <g:if test="${docInventoryInstance.status.id.toInteger() in [1, 2]}">
                    <li><g:form url="[id:docInventoryInstance.id, action:'cancel']" method="POST">
                            <g:actionSubmit action="cancel" value="Cancel" onclick="return confirm('${message(code: 'default.button.cancel.confirm.message', default: 'Are you sure?')}');" />
                        </g:form>
                    </li>
                </g:if>
                        
                <g:if test="${docInventoryInstance.status.id.toInteger() in [1, 2]}">
                    <li><g:form url="[id:docInventoryInstance.id, action:'delete']" method="POST">
                            <g:actionSubmit action="delete" value="Delete" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
                        </g:form>
                    </li>
                </g:if>
                <li><g:link action="viewDetails"id="${docInventoryInstance.id}">View Inventory Details</g:link></li>
		</ul>
            </content>
	</body>
</html>
