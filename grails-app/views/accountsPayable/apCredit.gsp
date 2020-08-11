<%@ page import="icbs.gl.AccountsPayable" %>
<%@ page import="icbs.gl.GlAccount" %>
<!DOCTYPE html>
<html>
    <head>
	<meta name="layout" content="main">
	<title>Accounts Payable Subsidiary Ledger Credit Transaction</title>
    </head>
    <body>
        <content tag="breadcrumbs">
            <span class="fa fa-chevron-right"></span><a href="${createLink(uri: '/accountsPayable')}">Accounts Payable Subsidiary Ledger</a>
            <span class="fa fa-chevron-right"></span><span class="current">Accounts Payable Subsidiary Ledger Credit Transaction</span>
        </content>
        <content tag="main-content">
            <div class="content scaffold-show" role="main">
            <g:if test="${flash.message}">
                <div class="box-body">
                    <div class="alert alert-info alert-dismissable">
                        <i class="fa fa-info"></i>
                        <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                        <b>Message</b> <div class="message" role="status">${flash.message}</div>
                    </div>
                </div>
            </g:if>
            <g:if test="${accountsPayableInstance?.customer}" >
                <div class="row">
                    <div class="col-xs-12 col-sm-12">
                            <g:render template='/customer/details/newCustomerDetailedInfo' model="[customerInstance:accountsPayableInstance?.customer]"/>
                    </div>

                </div>
            </g:if> 
            <div class="row">
                    <div class="section-container">
                        <fieldset>
                            <legend class="section-header">Accounts Payable Information</legend>
                            <table class="table table-bordered table-rounded table-striped table-hover">
                            <tbody>
                                
                                <tr>
                                    <td style = "width:30%;"><label>AP Account No</label></td>
                                    <td style = "width:70%;">${accountsPayableInstance.acctNo}</td>    
                                </tr>
                                <tr>
                                    <td style = "width:30%;"><label>Branch</label></td>
                                    <td style = "width:70%;">${accountsPayableInstance?.branch?.name}</td>    
                                </tr>
                                <tr>
                                    <td><label>Payable</label></td>
                                    <td>${accountsPayableInstance.payable}</td>    
                                </tr> 
                                
                                <tr>
                                    <td><label>Currency</label></td>
                                    <td>${accountsPayableInstance?.currency?.code}</td>    
                                </tr> 
                                <tr>
                                    <td><label>GL Code</label></td>
                                    <td>${accountsPayableInstance.glContra}</td>    
                                </tr> 
                                <tr>
                                    <td><label>GL Description</label></td>
                                    <td>${GlAccount.findByCode(accountsPayableInstance?.glContra).name}</td>    
                                </tr>
                                <tr>
                                    <td><label>Date Created</label></td>
                                    <td><g:formatDate  format="MM/dd/yyyy" date="${accountsPayableInstance.apCreatedDate}" /></td>    
                                </tr>
                                <tr>
                                    <td><label>Balance</label></td>
                                    <td><g:formatNumber format="###,###,##0.00" number="${accountsPayableInstance.balance}"/></td>    
                                </tr> 
                                <tr>
                                    <td><label>Created by </label></td>
                                    <td>${accountsPayableInstance?.user?.name1} ${accountsPayableInstance?.user?.name2} ${accountsPayableInstance?.user?.name3}</td>    
                                </tr> 
                               
                            </tbody>
                            </table>
                        </fieldset>
                    </div>  
                </div>
            <div class="panel panel-default">
                <div class = "panel-heading">
                    <h4>Transaction Details</h4>
                </div>
                    <div class="panel-body">
                        <g:form id="deposit" url="[resource:accountsPayableInstance, action:'saveapCredit']" method="PUT" onsubmit="callLoadingDialog();">
                            <fieldset class="form">
                                <div class="fieldcontain form-group ${hasErrors(bean: txnTemplateInstance, field: 'txnType', 'has-error')} required">
                                    <label class="control-label col-sm-4" for="txnType">Txn Type<span class="required-indicator">*</span></label>
                                    
                                    <div class="col-sm-8"><g:select id="txnType" name="txnType" from="${icbs.admin.TxnTemplate.findAllByTxnTypeAndMemoTxnType(icbs.lov.TxnType.read(50),icbs.lov.MemoTxnType.read(1))}"   optionKey="id" optionValue="description" required="" value="" onchange="getcode();" class="many-to-one form-control"/>
                                    </div>             
                                </div>
                                <div class="fieldcontain form-group">
                                    <label class="control-label col-sm-4" for="intRate">Credit Amount<span class="required-indicator">*</span></label>                         
                                    <div class="col-sm-8">
                                        <g:field class="form-control truncated" id="creditAmt" name="creditAmt" value="" />
                                    </div>             
                                </div>
                                <g:hiddenField name="apCredit" id="apCredit" value="${params.id}" />
                                 
                                <div class="fieldcontain form-group">
                                    <label class="control-label col-sm-4" for="intRate">Reference <span class="required-indicator">*</span></label>
                                    <div class="col-sm-8">
                                        <g:field class="form-control" type="Text"  id="reference"  name="reference" value="" />
                                    </div>             
                                </div>   
                                <div class="fieldcontain form-group">
                                    <label class="control-label col-sm-4" for="intRate">Particulars <span class="required-indicator">*</span></label>     
                                    <div class="col-sm-8">
                                        <g:field class="form-control" type="Text" id="txparticulars"   name="txparticulars" value="" />
                                    </div>             
                                </div>   
                            </fieldset>
                        </g:form>  
                    </div>
            </div>
            </div>
            <g:javascript>
                function validateApCredit(){
                
                    var apCreditAmt = $('#creditAmt').val()
                    var apTxnTemplate = $('#txnType').val();
                    var apReference = $('#reference').val();
                    var apParticulars = $('#txparticulars').val();
                    
                    console.log("apCreditAmt: "+apCreditAmt);
                    
                    console.log("apTxnTemplate: "+apTxnTemplate);
                    console.log("apReference: "+apReference);
                    console.log("apParticulars: "+apParticulars);
                    
                    if(apTxnTemplate == "" || apTxnTemplate == null || apTxnTemplate=="null"){
                        notify.message("Please select transaction type|error|alert");
                    }else if(apCreditAmt == "" || apCreditAmt == null || apCreditAmt=="null"){
                        notify.message("Please input AP Credit Amount |error|alert");
                    }else if(apReference == "" || apReference == null || apReference=="null"){
                        notify.message("Please input AP referece |error|alert");
                    }else if(apParticulars == "" || apParticulars == null || apParticulars=="null"){
                        notify.message("Please input AP particulars |error|alert");
                    }else{
                        
                        apCreditAmt = parseFloat(apCreditAmt.toString().replace(/,/g, ''));
                        if(apCreditAmt <= 0){
                            notify.message("Invalid AP Credit Amount |error|alert");
                        }else{
                            alertify.confirm(AppTitle,'Are you sure you want to continue this transaction?',
                                function(){
                                     checkIfAllowed('CFG00303', 'form#deposit', 'Override AP Credit', null); 
                                },
                                function(){
                                     alertify.error('Canceled');
                                }
                            );    
                        }
                    }
                }
            </g:javascript>
        </content>		

        <content tag="main-actions">
            <ul>
                <li><button onclick="validateApCredit();">Save</button></li>
                <li><g:link action="show" id="${accountsPayableInstance.id}">Cancel</g:link></li>            
            </ul>
        </content>
    </body>
</html>
