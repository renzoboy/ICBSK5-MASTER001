<%@ page import="icbs.gl.AccountsReceivable" %>
<%@ page import="icbs.gl.GlAccount" %>
<!DOCTYPE html>
<html>
    <head>
	<meta name="layout" content="main">
	<title>Accounts Receivable Subsidiary Ledger Debit Transaction</title>
    </head>
    <body>
        <content tag="breadcrumbs">
            <span class="fa fa-chevron-right"></span><a href="${createLink(uri: '/accountsReceivable')}">Accounts Receivable Subsidiary Ledger</a>
            <span class="fa fa-chevron-right"></span><span class="current">Accounts Receivable Subsidiary Ledger Debit Transaction</span>
        </content>
        <content tag="main-content">
                <script>
                function validateArDebit(){
                    
                    
                    var ardebitAmt = $('#debitAmt').val();
                    var arreference = $('#reference').val();
                    var arparticulars = $('#particulars').val();
                    console.log("ardebitAmt: "+ardebitAmt);
                    if(ardebitAmt=="" || ardebitAmt == null || ardebitAmt=="null"){
                        notify.message("Accounts Receivable Debit Amount cannot be empty |error|alert");
                    }else if(arreference=="" || arreference == null || arreference=="null" ){
                        notify.message("Transaction Reference cannot be empty |error|alert");
                    }else if(arparticulars=="" || arparticulars == null || arparticulars=="null"){
                        notify.message("Transaction Particulars cannot be empty |error|alert");
                    }else{
                        ardebitAmt = parseFloat(ardebitAmt.toString().replace(/,/g, ''));
                
                        if(ardebitAmt < 0 ){
                            notify.message("Invalid Accounts Receivabe Debit Amount |error|alert");
                        }else{
                            alertify.confirm(AppTitle,'Are you sure you want to continue this transaction?',
                            function(){
                                 checkIfAllowed('CFG00303', 'form#deposit', 'Override Accounts Receivable debit', null); 
                            },
                            function(){
                                alertify.error('Canceled');
                            });
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
                <g:if test="${accountsReceivableInstance?.customer}" >
                    <div class="row">
                        <div class="col-xs-12 col-sm-12">
                                <g:render template='/customer/details/newCustomerDetailedInfo' model="[customerInstance:accountsReceivableInstance?.customer]"/>
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
                                    <td style = "width:30%;"><label>AR Account No</label></td>
                                    <td style = "width:70%;">${accountsReceivableInstance?.acctNo}</td>    
                                </tr>
                                <tr>
                                    <td style = "width:30%;"><label>Branch</label></td>
                                    <td style = "width:70%;">${accountsReceivableInstance?.branch?.name}</td>    
                                </tr>
                                <tr>
                                    <td><label>Receivable</label></td>
                                    <td>${accountsReceivableInstance.receivableName}</td>    
                                </tr> 
                                <tr>
                                    <td><label>Description</label></td>
                                    <td>${accountsReceivableInstance.description}</td>    
                                </tr> 
                                <tr>
                                    <td><label>Balance</label></td>
                                    <td><g:formatNumber format="###,###,##0.00" number="${accountsReceivableInstance.balance}"/></td>    
                                </tr> 
                                <tr>
                                    <td><label>GL Code</label></td>
                                    <td>${accountsReceivableInstance.glContra}</td>    
                                </tr> 
                                <tr>
                                    <td><label>GL Description</label></td>
                                    <td>${GlAccount.findByCode(accountsReceivableInstance?.glContra).name}</td>    
                                </tr>
                                <tr>
                                    <td><label>Date Booked</label></td>
                                    <td><g:formatDate  format="MM/dd/yyyy" date="${accountsReceivableInstance.bookingDate}" /></td>    
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
                        <g:form id="deposit" url="[resource:accountsReceivableInstance, action:'savearDebit']" method="PUT" onsubmit="callLoadingDialog();">
                            <fieldset class="form">
                                <div class="fieldcontain form-group ${hasErrors(bean: txnTemplateInstance, field: 'txnType', 'has-error')} required">
                                    <label class="control-label col-sm-4" for="txnType">Txn Type<span class="required-indicator">*</span></label>
                                    
                                    <div class="col-sm-8"><g:select id="txnType" name="txnType" from="${icbs.admin.TxnTemplate.findAllByTxnTypeAndMemoTxnType(icbs.lov.TxnType.read(47),icbs.lov.MemoTxnType.read(1))}"   optionKey="id" optionValue="description" required="" value="" onchange="getcode();" class="many-to-one form-control"/>
                                    </div>             
                                </div>
                                <div class="fieldcontain form-group">
                                    <label class="control-label col-sm-4" for="intRate">Debit Amount<span class="required-indicator">*</span></label>                         
                                    <div class="col-sm-8">
                                        <g:textField class="form-control truncated" id="debitAmt" name="debitAmt" value="" />
                                    </div>             
                                </div>
                                <g:hiddenField name="arDebit" id="arDebit" value="${params.id}" />
                                 
                                <div class="fieldcontain form-group">
                                    <label class="control-label col-sm-4" for="intRate">Reference <span class="required-indicator">*</span></label>
                                    <div class="col-sm-8">
                                        <g:textField class="form-control" type="Text"  id="reference"  name="reference" value="" />
                                    </div>             
                                </div>   
                                <div class="fieldcontain form-group">
                                    <label class="control-label col-sm-4" for="intRate">Particulars <span class="required-indicator">*</span></label>     
                                    <div class="col-sm-8">
                                        <g:textField class="form-control" type="Text" id="particulars"   name="particulars" value="" />
                                    </div>             
                                </div>   
                            </fieldset>
                        </g:form>  
                    </div>
            </div>
            </div>
                
        </content>		

        <content tag="main-actions">
            <ul>
                <li><button onclick="validateArDebit();">Save</button></li>
                <li><g:link action="show" id="${accountsReceivableInstance.id}">Cancel</g:link></li>            
            </ul>
        </content>
    </body>
</html>
