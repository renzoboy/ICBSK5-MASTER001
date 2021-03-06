
<%@ page import="icbs.deposit.DocInventory" %>
<%@ page import="icbs.deposit.Passbook" %>
<!DOCTYPE html>
<html>
	<head>
            <meta name="layout" content="main">
            <g:set var="entityName" value="${message(code: 'docInventory.label', default: 'DocInventory')}" />
            <title>Show Check Inventory Details</title>
	</head>
	<body>
            <content tag="breadcrumbs">
                <span class="fa fa-chevron-right"></span><a href="${createLink(uri: '/docInventory')}">Document Inventory</a>
                <span class="fa fa-chevron-right"></span><span class="current">Show Check Inventory Details</span>
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
                    <g:form name="ChkDetails" url="[action:'viewDetails',controller:'DocInventory']">
                           <g:hiddenField id="id" name="id" value="${docInventoryInstance.id}"/>
                            <div class="row">
                                <div class=" col-md-2">
                                     <g:select name="max" value="${params.max}" from="[5, 10, 15, 20]" class="form-control input-sm" onchange="submit(${docInventoryInstance.id})" />
                                </div>
                               
                                <div class="input-group col-md-6">
                                    <input id="searchQuery"name="query"type="text" class="form-control" value="${params?.query}" onchange="this.form.submit()">
                                    <span class="input-group-btn">
                                      <g:submitButton name="search" value="Search" class="btn btn-primary" />
                                    </span>
                                </div><!-- /input-group -->
                            </div><!-- /.col-lg-6 -->
                    </g:form>    
                    <div class="box-body table-responsive no-padding">
                        <table id="chequeTable" class="table table-hover table-condensed table-bordered table-striped">
                            <tr> 
                                <td width="15%"><label>Account No </label></td>
                                <td width="15%"><label>Account Name </label></td>
                                <td width="15%"><label>Check No.</label></td>
                                <td width="15%"><label>Date Issued</label></td>
                               <td width="10%"><label>Status</label></td>
                            </tr>
                            <g:each var="chk"  status="i" in="${chkInstance}">
                                <tr>
                                    <td>${chk?.chequebook?.deposit?.acctNo}</td>
                                    <td>${chk?.chequebook?.deposit?.acctName}</td>
                                    <td>${chk?.chequeNo}</td>
                                    <td><g:formatDate date="${chk?.chequebook?.dateIssued}" type="date" style="LONG"/></td>
                                    <td>${chk?.status?.description}</td>
                                </tr>
                            </g:each>  
                        </table>
              
            </div>
              <div class="pagination">
                        <g:paginate total="${chkInstanceCount?: 0}" params="${params}"/>
                </div>
                
            </div>
            </content>
             <content tag="main-actions">
                <ul>
                <li><g:link class="list" action="index">Document Inventory List</g:link></li>
      		<li><g:link class="create" action="create">Create Document Inventory</g:link></li>
                <li><g:link action="show"id="${docInventoryInstance.id}">View Document Inventory</g:link></li>
		</ul>
            </content>
	</body>
<g:javascript>
 
    function getMaxParams(){
    
    
    }
              
</g:javascript>
</html>
