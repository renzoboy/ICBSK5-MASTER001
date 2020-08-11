<%@ page import="icbs.loans.ROPA" %>
<!DOCTYPE html>
<html>
    <head>
	<meta name="layout" content="main">
	<title>ROPA Debit Transactions</title>
    </head>
    <body>
        <content tag="breadcrumbs">
                <span class="fa fa-chevron-right"></span><a href="${createLink(uri: '/ropa')}">ROPA Index</a>
                <span class="fa fa-chevron-right"></span><span class="current">ROPA Debit Transactions</span>
        </content>
        <content tag="main-content">
            <g:if test="${flash.message}">
                <div class="message" role="status">${flash.message}</div>
            </g:if>
            <div class="panel panel-default">
            <div class="panel-heading">
    <h4>${ropadebitInstance?.loanAcctNo} - ${ropadebitInstance?.customerDisplayName}</h4>
</div>
    <div class = "panel-body">
    <table class="table table-bordered table-rounded table-striped table-hover">
        <tbody>
            <tr>
                <td style="width:30%"><label>Branch</label></td>
                <td style="width:70%">${ropadebitInstance?.branch?.name}</td> 
            </tr>    
            <tr>
                <td style="width:30%"><label>ROPA Date</label></td>
                <td style="width:70%"><g:formatDate  format="MM/dd/yyyy" date="${ ropadebitInstance?.ropaDate}" /></td> 
            </tr>
        </tbody>
    </table>
    <g:render template="details/collateralDetails"/>
    
    </div>
</div>
    <div class="panel panel-default">
        <div class = "panel-heading">
            <h4>Transaction Details</h4>
        </div>
            <div class="panel-body">
                <g:form id="save" url="[controller:'ropa', action:'taropaDebitSave']" method="POST" onsubmit="callLoadingDialog();">
                    <g:hiddenField name="collID" id="collID" value="${params.id}"/>
                   
                    <fieldset class="form">
                        <div class="fieldcontain form-group ${hasErrors(bean: txnTemplateInstance, field: 'txnType', 'has-error')} required">
                            <label class="control-label col-sm-4" for="txnType">Txn Type<span class="required-indicator">*</span></label>

                            <div class="col-sm-8"><g:select id="txnType" name="txnType" from="${icbs.admin.TxnTemplate.findAllByTxnTypeAndMemoTxnType(icbs.lov.TxnType.read(53),icbs.lov.MemoTxnType.read(1))}"   optionKey="id" optionValue="description" required="" value="" onchange="getcode();" class="many-to-one form-control"/>
                            </div>             
                        </div>
                        <div class="fieldcontain form-group">
                            <label class="control-label col-sm-4" for="intRate">Debit Amount<span class="required-indicator">*</span></label>                         
                            <div class="col-sm-8">
                                <g:field class="form-control truncated" id="ropadebit" name="ropadebit" value="" />
                            </div>             
                        </div>

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
                <li><button type="submit" onclick="validateRopaDebit();">Save</button></li>
                <li><g:link action="collateralShow" id="${collateralInstance.id}">Cancel</g:link></li>            
            </ul>
            <script>
            function validateRopaDebit(){
            console.log("VHOOOOM")
                var ropadebit = $('#ropadebit').val();
                var reference = $('#reference').val();
                var particulars = $('#particulars').val();
                
                
                
                if(ropadebit == null || ropadebit == "" || ropadebit=="null"){
                    notify.message("Ropa debit amount is required|error|alert");
                }else if(reference == null || reference == ""|| reference == "null"){
                    notify.message("Reference is required|error|alert");
                }else if(particulars == null || particulars == ""|| particulars == "null"){
                    notify.message("Particulars is required|error|alert");
                }else{
                    
                    ropadebit = parseFloat(ropadebit.toString().replace(/,/g, ''));
                    
                    if(ropadebit <= 0){
                        notify.message("Invalid Debit Amount|error|alert");
                    }else{
                        //submit form
                        console.log("Submit");

                        alertify.confirm(AppTitle,'Are you sure you want to continue create ROPA?',
                        function(){
                                checkIfAllowed('ADM00102', 'form#save', 'Create New ROPA', null); 
                            },
                            function(){
                                return;
                        });
                    }
                    
                }
            }
            </script>
        </content>
    </body>
</html>
