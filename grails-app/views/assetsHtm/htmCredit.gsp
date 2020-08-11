<%@ page import="icbs.gl.AccountsReceivable" %>
<%@ page import="icbs.gl.GlAccount" %>
<!DOCTYPE html>
<html>
    <head>
	<meta name="layout" content="main">
	<title>Assets Held To Maturity Credit Transaction</title>
    </head>
    <body>
        <content tag="breadcrumbs">
            <span class="fa fa-chevron-right"></span><a href="${createLink(uri: '/accountsReceivable')}">Assets Held To Maturity Subsidiary Ledger</a>
            <span class="fa fa-chevron-right"></span><span class="current">Assets Held To Maturity Credit Transaction</span>
        </content>
        <content tag="main-content">
            <script>
                function validateCreditHtm(){
                    
                    
                    var htmCreditAmt = $('#creditAmt').val();
                    var htmreference = $('#reference').val();
                    var htmparticulars = $('#particulars').val();
                    var htmAmountExist = $('#htmAmountExist').val();
                    console.log("htmCreditAmt: "+htmCreditAmt);
                    if(htmCreditAmt=="" || htmCreditAmt == null || htmCreditAmt=="null"){
                        notify.message("HTM Credit Amount cannot be empty |error|alert");
                    }else if(htmreference=="" || htmreference == null || htmreference=="null" ){
                        notify.message("Transaction Reference cannot be empty |error|alert");
                    }else if(htmparticulars=="" || htmparticulars == null || htmparticulars=="null"){
                        notify.message("Transaction Particulars cannot be empty |error|alert");
                    }else{
                        htmCreditAmt = parseFloat(htmCreditAmt.toString().replace(/,/g, ''));
                        htmAmountExist = parseFloat(htmAmountExist.toString().replace(/,/g, ''));
                        if(htmCreditAmt < 0 ){
                            notify.message("Invalid HTM Credit Amount |error|alert");
                        }else if(htmAmountExist < htmCreditAmt){
                            notify.message("Credit amount cannot be greater than current HTM Amount |error|alert");
                        }else{
                            alertify.confirm(AppTitle,'Are you sure you want to continue this transaction?',
                                function(){
                                     checkIfAllowed('CFG00303', 'form#creditHtm', 'Override Debit HTM', null); 
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
                                    <td style = "width:70%;">${htmCreditInstance?.branch?.name}</td>    
                                </tr>
                                <tr>
                                    <td style = "width:30%;"><label>HTM Description</label></td>
                                    <td style = "width:70%;">${htmCreditInstance?.htmDescription}</td>    
                                </tr>
                                
                                <tr>
                                    <td><label>Amount</label></td>
                                    <td><g:formatNumber format="###,###,##0.00" number="${htmCreditInstance.amount}"/></td>    
                                </tr> 
                                <tr>
                                    <td><label>GL Code</label></td>
                                    <td>${htmCreditInstance.glCode}</td>    
                                </tr> 
                                <tr>
                                    <td><label>GL Description</label></td>
                                    <td>${GlAccount.findByCode(htmCreditInstance?.glCode).name}</td>    
                                </tr>
                                <tr>
                                    <td><label>Created Date</label></td> 
                                    <td><g:formatDate  format="MM/dd/yyyy" date="${htmCreditInstance?.createdDate}" /></td>  
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
                        <g:form id="creditHtm" url="[controller:assetsHtm, action:'savehtmCredit']" method="PUT" onsubmit="callLoadingDialog();">
                            <fieldset class="form">
                                <div class="fieldcontain form-group ${hasErrors(bean: txnTemplateInstance, field: 'txnType', 'has-error')} required">
                                    <label class="control-label col-sm-4" for="txnType">Txn Type<span class="required-indicator">*</span></label>
                                    
                                    <div class="col-sm-8"><g:select id="txnType" name="txnType" from="${icbs.admin.TxnTemplate.findAllByTxnTypeAndMemoTxnType(icbs.lov.TxnType.read(57),icbs.lov.MemoTxnType.read(1))}"   optionKey="id" optionValue="description" required="" value="" onchange="getcode();" class="many-to-one form-control"/>
                                    </div>             
                                </div>
                                <div class="fieldcontain form-group">
                                    <label class="control-label col-sm-4" for="intRate">Credit Amount<span class="required-indicator">*</span></label>                         
                                    <div class="col-sm-8">
                                        <g:field class="form-control truncated" id="creditAmt" name="creditAmt" value="" />
                                    </div>             
                                </div>
                                <g:hiddenField name="htmCredit" id="htmCredit" value="${htmCreditInstance?.id}" />
                                 <g:hiddenField name="htmAmountExist" id="htmAmountExist" value="${htmCreditInstance.amount}" />
                                 
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
                <li><button onclick="validateCreditHtm();">Save Credit HTM</button></li>
                <li><g:link action="show" id="${htmCreditInstance.id}">Cancel</g:link></li>            
            </ul>
        </content>
    </body>
</html>
