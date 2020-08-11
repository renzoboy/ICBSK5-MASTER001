<%@ page import="icbs.gl.AssetsHeldToMaturity" %>
<%@ page import="icbs.gl.GlAccount" %>
<!DOCTYPE html>
<html>
    <head>
	<meta name="layout" content="main">
	<title>Assets Held To Maturity Debit Information</title>
    </head>
    <body>
        <content tag="breadcrumbs">
            <span class="fa fa-chevron-right"></span><a href="${createLink(uri: '/accountsReceivable')}">Assets Held To Maturity</a>
            <span class="fa fa-chevron-right"></span><span class="current">Assets Held To Maturity Debit Information</span>
        </content>
        <content tag="main-content">
            <script>
                function validateHtmDebit(){
                    
                    
                    var htmdebitAmt = $('#debitAmt').val();
                    var htmreference = $('#reference').val();
                    var htmparticulars = $('#particulars').val();
                    console.log("htmdebitAmt: "+htmdebitAmt);
                    if(htmdebitAmt=="" || htmdebitAmt == null || htmdebitAmt=="null"){
                        notify.message("HTM Debit Amount cannot be empty |error|alert");
                    }else if(htmreference=="" || htmreference == null || htmreference=="null" ){
                        notify.message("Transaction Reference cannot be empty |error|alert");
                    }else if(htmparticulars=="" || htmparticulars == null || htmparticulars=="null"){
                        notify.message("Transaction Particulars cannot be empty |error|alert");
                    }else{
                        htmdebitAmt = parseFloat(htmdebitAmt.toString().replace(/,/g, ''));
                
                        if(htmdebitAmt < 0 ){
                            notify.message("Invalid HTM Debit Amount |error|alert");
                        }else{
                            alertify.confirm(AppTitle,'Are you sure you want to continue this transaction?',
                                function(){
                                     checkIfAllowed('CFG00303', 'form#debitHtm', 'Override Debit HTM', null); 
                                },
                                function(){
                                    return;
                                }
                            );  
                        }
                    }
                    
                }
            </script>
           
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
                <div class="row">
                    <div class="section-container">
                        <fieldset>
                            <legend class="section-header">Asset Held to Maturity Information</legend>
                            <table class="table table-bordered table-rounded table-striped table-hover">
                            <tbody>
                                <tr>
                                    <td style = "width:30%;"><label>Branch</label></td>
                                    <td style = "width:70%;">${htmDebitInstance?.branch?.name}</td>    
                                </tr>
                                <tr>
                                    <td style = "width:30%;"><label>HTM Description</label></td>
                                    <td style = "width:70%;">${htmDebitInstance?.htmDescription}</td>    
                                </tr>
                                
                                <tr>
                                    <td><label>Amount</label></td>
                                    <td><g:formatNumber format="###,###,##0.00" number="${htmDebitInstance.amount}"/></td>    
                                </tr> 
                                <tr>
                                    <td><label>GL Code</label></td>
                                    <td>${htmDebitInstance.glCode}</td>    
                                </tr> 
                                <tr>
                                    <td><label>GL Description</label></td>
                                    <td>${GlAccount.findByCode(htmDebitInstance?.glCode).name}</td>    
                                </tr>
                                <tr>
                                    <td><label>Created Date</label></td> 
                                    <td><g:formatDate  format="MM/dd/yyyy" date="${htmDebitInstance?.createdDate}" /></td>  
                                </tr> 
                               
                            </tbody>
                            </table>
                        </fieldset>
                    </div>  
                </div>
                
                </div>
            
            <div class="panel panel-default">
                <div class = "panel-heading">
                    <h4>Transaction Details</h4>
                </div>
                    <div class="panel-body">
                        <g:form id="debitHtm" url="[controller:assetsHtm, action:'savehtmDebit']" method="PUT" onsubmit="callLoadingDialog();">
                            <fieldset class="form">
                                <div class="fieldcontain form-group ${hasErrors(bean: txnTemplateInstance, field: 'txnType', 'has-error')} required">
                                    <label class="control-label col-sm-4" for="txnType">Txn Type<span class="required-indicator">*</span></label>
                                    
                                    <div class="col-sm-8"><g:select id="txnType" name="txnType" from="${icbs.admin.TxnTemplate.findAllByTxnTypeAndMemoTxnType(icbs.lov.TxnType.read(56),icbs.lov.MemoTxnType.read(1))}" optionKey="id" optionValue="description" required="" value="" onchange="getcode();" class="many-to-one form-control"/>
                                    </div>             
                                </div>
                                <div class="fieldcontain form-group">
                                    <label class="control-label col-sm-4" for="intRate">Debit Amount<span class="required-indicator">*</span></label>                         
                                    <div class="col-sm-8">
                                        <g:field class="form-control truncated" id="debitAmt" name="debitAmt" value="" />
                                    </div>             
                                </div>
                                
                                 <g:hiddenField name="htmDebit" id="htmDebit" value="${htmDebitInstance?.id}" />
                                <div class="fieldcontain form-group">
                                    <label class="control-label col-sm-4" for="intRate">Reference <span class="required-indicator">*</span></label>
                                    <div class="col-sm-8">
                                        <g:field class="form-control" type="Text"  id="reference"  name="reference" value="" />
                                    </div>             
                                </div>   
                                <div class="fieldcontain form-group">
                                    <label class="control-label col-sm-4" for="intRate">Particulars <span class="required-indicator">*</span></label>     
                                    <div class="col-sm-8">
                                        <g:field class="form-control" type="Text" id="particulars"   name="particulars" value="" />
                                    </div>             
                                </div>   
                            </fieldset>
                        </g:form>  
                    </div>
            </div>
        </content>		

        <content tag="main-actions">
            <ul>
                <li><button onclick="validateHtmDebit();">Save HTM Debit</button></li>
                <li><g:link action="show" id="${htmDebitInstance.id}">Cancel</g:link></li>            
            </ul>
        </content>
    </body>
</html>
