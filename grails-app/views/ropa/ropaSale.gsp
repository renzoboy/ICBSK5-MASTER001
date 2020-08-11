<%@ page import="icbs.lov.ProductType" %>
<%@ page import="icbs.loans.LoanApplication" %>
<%@ page import="icbs.admin.Product" %>
<%@ page import="icbs.loans.ROPA" %>
<%@ page import="icbs.cif.Customer" %>
<%@ page import="icbs.loans.Collateral" %>
<!DOCTYPE html>
<html>
    <head>
	<meta name="layout" content="main">
	<title>ROPA Sale Transactions</title>
        <g:javascript>
            function updateLoanApplicationAjax(params) {
                console.log("params: "+params );
                    if (params.loanApplication2) {
                        $('#loanApplication').val(params.loanApplication2);
                        console.log("paramsssss: "+params.loanApplication2);
                        var obj = { 
                            id: params.loanApplication2,
                        }; 
                        //console.log(JSON.stringify(obj));
                        //console.log("Object Loaded iwth data...");
                        $.ajax({
                            type: "POST",
                            contentType: "application/json",
                            url: "${createLink(controller:'ropa', action:'collectionInformation')}",
                            data: JSON.stringify(obj),

                            success: function(data){

                                $.each(data, function (_key, _value) {
                                    //console.log(JSON.stringify(data));
                                    //console.log(_value.display_name);
                                    $('#lnaccountName').val(_value.display_name);
                                    $('#lnGrantedAmount').val(accounting.format(_value.amount));
                                    $('#lnApplicationDate').val(formatDate(_value.application_date));
                                    $('#productType').val(_value.product_type_id);
                                    console.log('product: '+$('product_type'));
                                });
                            },
                            error: function(data){
                                console.log('Pumasok sa error');
                            },
                        }); //AJAX CLOSE    
                    }
            } //function close tag
            function formatDate(date) {
                var d = new Date(date),
                    month = '' + (d.getMonth() + 1),
                    day = '' + d.getDate(),
                    year = d.getFullYear();

                if (month.length < 2) month = '0' + month;
                if (day.length < 2) day = '0' + day;

                return [year, month, day].join('/');
            }
            function showLoanApplicationSearch() {				
                modal = new icbs.UI.Modal({id:"loanApplicationModal", url:"${createLink(controller: 'ropa', action:'search')}", title:"Search Loan Application", onCloseCallback:updateLoanApplicationAjax});
                modal.show();
            }
            icbs.Dependencies.Ajax.addLoadEvent(function(){
                updateLoanApplicationAjax({loanApplication2:"${loanApplication?.id}"});
            });
            
	</g:javascript>
    </head>
    <body>
        <content tag="breadcrumbs">
                <span class="fa fa-chevron-right"></span><a href="${createLink(uri: '/ropa')}">ROPA Index</a>
                <span class="fa fa-chevron-right"></span><span class="current">ROPA Sale Transactions</span>
        </content>
        <content tag="main-content">
            <g:javascript>
            $( document ).ready(function() {
                console.log( "ready!" );
                scrxAmount();
            });

            function validateFields(){
            alertify.confirm(AppTitle,'Are you sure you want to continue this transaction?',
                function(){
                    var loanGrantedAmount = document.getElementById("lgaAmount").innerHTML;
                    console.log("loanGrantedAmount: "+loanGrantedAmount);
                    var loanAppID = $('#loanAppId').val();
                    console.log('loanAppID: '+ loanAppID);
                    var downpayment = $('#downpayment').val();
                    downpayment = downpayment.replace(/,/g, '');
                    downpayment = parseFloat(downpayment);
                    console.log('downpayment: '+downpayment);
                    var saleAmount = $('#sale').val();
                    saleAmount = saleAmount.replace(/,/g, '');
                    console.log('Sale ASmount: '+saleAmount);
                    
                   
                    var collateralId = $('#findCollId').val();
                    console.log('collateralId: '+ collateralId)
                    ;
                    var findCollId = $('#findCollId').val();
                    console.log('findCollId: '+ findCollId);
                    
                    var productTypeId = $('#productType').val();
                    console.log('productTypeId: '+ productTypeId);
                    var scrAmount = $('#scrAmount').val();
                    var xxxIncome = $('#income').val(); 
                    xxxIncome = xxxIncome.replace(/,/g, '');
                    if(xxxIncome == ""|| xxxIncome == null){
                        var yyyIncome = 0.00
                        $('#hiddenIncome').val(yyyIncome);
                        console.log('income: '+xxxIncome);
                        
                        var saleIncomeComputation = parseFloat(saleAmount) + parseFloat(yyyIncome)
                        $('#hiddenScrAmount').val(saleIncomeComputation);
                        console.log('xompute: '+saleIncomeComputation);
                    }else{
                        $('#hiddenIncome').val(xxxIncome);
                        var saleIncomeComputation2 = parseFloat(saleAmount) + parseFloat(xxxIncome)
                        $('#hiddenScrAmount').val(saleIncomeComputation2);
                        console.log('xompute: '+saleIncomeComputation2);
                    }
                    
                    
                    
                    if (downpayment <= 0.00){
                        notify.message('Invalid Downpayment Amount!|error|alert'); 
                        return;
                    }
                    else if(saleAmount <= 0.00){
                        notify.message('Invalid SCR amount!|error|alert'); 
                        return;
                    }
                    else if(downpayment >  saleIncomeComputation){
                        console.log('pumasok dito sa condition');
                        notify.message('Downpayment amount cannot be greater than Total SCR Amount!|error|alert'); 
                        return;
                    }
                    else if(productTypeId != 7){
                        notify.message('Invalid loan application product!|error|alert');
                        return;
                    }
                    else if (!loanAppID && (downpayment != saleAmount)){
                    notify.message('No SCR detected, invalid downpayment and/or sale amount!|error|alert');
                        return;             
                    }
                    else{
                    }
                    document.getElementById("ropaSale").submit();
                    },
                    function(){
                        return;
                    });  
                
                
            }
            function scrxAmount() {
            console.log("pasok agad dito")
                var xScrAmount = $('#scrAmount').val();
                xScrAmount = xScrAmount.replace(/,/g, '');
                var downpayment = $('#downpayment').val();
                downpayment = downpayment.replace(/,/g, '');
                var xxxIncome = $('#income').val(); 
                xxxIncome = xxxIncome.replace(/,/g, '');
                
                
                
                document.getElementById("scrAmount").disabled = true;
                document.getElementById("sale").disabled = true;
                var loanGrantedAmount = document.getElementById("lgaAmount").innerHTML;
                console.log("loanGrantedAmount: "+loanGrantedAmount);
                var saleIncomeComputation = (saleAmount + xxxIncome)
                $('#scrAmount').val(saleIncomeComputation);
                console.log('saleIncomeComputation: '+saleIncomeComputation);
                if(loanGrantedAmount == "" || loanGrantedAmount == null){
                    loanGrantedAmount = "0.00";
                }else{
                    loanGrantedAmount = loanGrantedAmount.replace(/,/g, '');
                    $('#sale').val(loanGrantedAmount);
                    console.log('sale Amount: '+$('#sale'));
                }
                var saleAmount = $('#sale').val();
                saleAmount = saleAmount.replace(/,/g, '');
                console.log('Sale ASmount: '+saleAmount);
                
                if(xScrAmount == "" || xScrAmount == null){
                    xScrAmount = "0.00";
                }
                if(downpayment == "" || downpayment == null){
                    downpayment = "0.00";
                }
                if(saleAmount == "" || saleAmount == null){
                    saleAmount = "0.00";
                }
                if(xxxIncome == "" || xxxIncome == null){
                    xxxIncome = "0.00";
                }
                xScrAmount = parseFloat(xScrAmount);
                downpayment = parseFloat(downpayment);
                saleAmount = parseFloat(saleAmount);
                xxxIncome = parseFloat(xxxIncome);
                
                xScrAmount = saleAmount + xxxIncome;
                $('#scrAmount').val(xScrAmount);
                console.log("xScrAmount: "+xScrAmount);
                console.log("downpayment: "+downpayment);
                console.log("saleAmount: "+saleAmount);
                console.log("xxxIncome: "+xxxIncome);
            }
            
            function validateGlCode(){
            var depcontra = $('#ropaContra').val();
            var financialYear = $('#financialYear').val();
            console.log("financialYear: "+financialYear);
            if(depcontra==""){

            }else{
                //=================== AJAX FUNCTION to validate code if existing
                var obj = { 
                    depcontra: depcontra,
                    financialYear: financialYear,
                }; 
                console.log(JSON.stringify(obj));
                console.log("Object Loaded iwth data...");
                $.ajax({
                    type: "POST",
                    contentType: "application/json",
                    url: "${createLink(controller:'TxnTemplate', action:'validateExistingGlCodeAjax')}",
                    data: JSON.stringify(obj),

                    success: function(data){
                        if(data.length >=1){
                            onoff = ""

                            $.each(data, function (_key, _value) {
                                console.log(JSON.stringify(obj))
                                console.log(_value.gl_code);
                                console.log(_value.name);
                                $('#gldescription').val(_value.name);

                            });

                        }else{
                            onoff = "invalidGlCode";

                            notify.message('Sorry, Invalid Gl Code!|error|alert');
                        }
                        console.log("onoff: "+onoff);
                    },
                    error: function(data){

                    },

                });                                            
            }
        }
        function validateGlCodeIncome(){
            var depcontra = $('#ropaIncomeContra').val();
            var financialYear = $('#financialYear').val();
            console.log("financialYear: "+financialYear);
            if(depcontra==""){

            }else{
                //=================== AJAX FUNCTION to validate code if existing
                var obj = { 
                    depcontra: depcontra,
                    financialYear: financialYear,
                }; 
                console.log(JSON.stringify(obj));
                console.log("Object Loaded iwth data...");
                $.ajax({
                    type: "POST",
                    contentType: "application/json",
                    url: "${createLink(controller:'TxnTemplate', action:'validateExistingGlCodeAjax')}",
                    data: JSON.stringify(obj),

                    success: function(data){
                        if(data.length >=1){
                            onoff = ""

                            $.each(data, function (_key, _value) {
                                console.log(JSON.stringify(obj))
                                console.log(_value.gl_code);
                                console.log(_value.name);
                                $('#gldescriptionIncome').val(_value.name);

                            });

                        }else{
                            onoff = "invalidGlCode";

                            notify.message('Sorry, Invalid Gl Code!|error|alert');
                        }
                        console.log("onoff: "+onoff);
                    },
                    error: function(data){

                    },

                });                                            
            }
        }
        
        </g:javascript>
             <g:if test="${flash.message}">
                <div class="box-body">
                    <div class="alert alert-danger alert-dismissable">
                        <i class="fa fa-danger"></i>
                        <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                        <b>Message</b> <div class="Message" role="status">${flash.message}</div>
                    </div>
                </div>
            </g:if>
            <div class="panel panel-primary">
                <div class = "panel-heading"><b> Ropa Loan Details </b></div>
                    <table class="table table-striped table-hover">
                        <tbody>
                            <tr>
                                <td style="width:30%"><label>Loan Account Number</label></td>
                                <td style="width:70%">${ropaSaleInstance?.ropa?.loanAcctNo}</td> 
                            </tr>    
                            <tr>
                                <td style="width:30%"><label>Ropa Name</label></td>
                                <td style="width:70%">${ropaSaleInstance?.ropa?.customerDisplayName}</td> 
                            </tr>
                            <tr>
                                <td ><label>Loan Granted Amount</label></td>
                                <td id="lgaAmount"><g:formatNumber  format="###,###,##0.00" number="${ropaSaleInstance?.ropa?.loan?.grantedAmount}"/></td>   
                            </tr>
                            <tr>
                                <td ><label>Date Opened</label></td>
                                <td><g:formatDate format="MM/dd/yyyy" date="${ropaSaleInstance?.ropa?.loan?.openingDate}"/></td>   
                            </tr>
                            <tr>
                                <td ><label>Ropa Date/Date of Transfer</label></td>
                                <td><g:formatDate format="MM/dd/yyyy" date="${ropaSaleInstance?.ropa?.dateCreated}"/></td>   
                            </tr>
                        </tbody>
                    </table>   
            </div>
            <div class="panel panel-default">
                <div class = "panel-heading">
                    <h4>Transaction Details</h4>
                </div>
                    <div class="panel-body">
                        <g:form id="ropaSale" url="[controller:'ropa', action:'saveropaSale']" method="POST" >
                            <fieldset class="form">

                                <div class="fieldcontain form-group ${hasErrors(bean: loanInstance, field: 'loanApplication', 'has-error')} required">
                                    <label class="control-label col-sm-4" for="loanApplication">
                                        <g:message code="loan.loanApplication.label" default="Loan Application SCR" />
                                        <span class="required-indicator">*</span>
                                    </label>
                                    <div class="col-sm-7"><g:field name="loanApplication" id="loanApplication" type="number" value="${loanInstance?.loanApplication?.id}" class="form-control" readonly="true"/>
                                        <g:hasErrors bean="${loanInstance}" field="loanApplication">
                                            <div class="controls">
                                                    <span class="help-block">
                                                        <g:eachError bean="${loanInstance}" field="loanApplication">
                                                            <g:message error="${it}" /><br/>
                                                        </g:eachError>
                                                    </span>
                                            </div>
                                        </g:hasErrors>
                                    </div>

                                    <g:if test="${!reschedule}">
                                    <div class="col-sm-2"><input type="button" href="#" class="btn btn-secondary" onclick="showLoanApplicationSearch()" value="Search"/></div>             
                                    </g:if>
                                </div>
                                    <div class="fieldcontain form-group ${hasErrors(bean: ropaInstance, field: 'ciName', 'has-error')} required">
                                            <label class="control-label col-sm-4" for="ciName">
                                                    <g:message code="creditInvestigation.ciName.label" default="Customer Name" />
                                            </label>
                                            <div class="col-sm-8"><g:field name="lnaccountName" id="lnaccountName" value="${loanInstance?.loanApplication?.customer?.displayName}" disabled="disable" class="form-control"/>

                                                <g:hasErrors bean="${ropaInstance}" field="ciName">
                                                    <div class="controls">
                                                            <span class="help-block">
                                                                <g:eachError bean="${ropaInstance}" field="ciName">
                                                                    <g:message error="${it}" /><br/>
                                                                </g:eachError>
                                                            </span>
                                                    </div>
                                                </g:hasErrors>
                                            </div>             
                                    </div>
                                    <div class="fieldcontain form-group ${hasErrors(bean: ropaInstance, field: 'lnGrantedAmount', 'has-error')} required">
                                            <label class="control-label col-sm-4" for="lnGrantedAmount">
                                                    <g:message code="creditInvestigation.lnGrantedAmount.label" default="Granted Amount" />
                                            </label>
                                            <div class="col-sm-8"><g:field name="lnGrantedAmount" id="lnGrantedAmount" value="${loanInstance?.loanApplication?.amount}" disabled="disable" class="form-control truncated"/>

                                                <g:hasErrors bean="${ropaInstance}" field="lnGrantedAmount">
                                                    <div class="controls">
                                                            <span class="help-block">
                                                                <g:eachError bean="${ropaInstance}" field="lnGrantedAmount">
                                                                    <g:message error="${it}" /><br/>
                                                                </g:eachError>
                                                            </span>
                                                    </div>
                                                </g:hasErrors>
                                            </div>             
                                    </div>
                                    <div class="fieldcontain form-group ${hasErrors(bean: ropaInstance, field: 'lnApplicationDate', 'has-error')} required">
                                        <label class="control-label col-sm-4" for="lnApplicationDate">
                                                <g:message code="creditInvestigation.lnApplicationDate.label" default="Loan Application Date" />
                                        </label>
                                        <div class="col-sm-8">
                                            <g:customDatePicker name="lnApplicationDate" id="lnApplicationDate"  precision="day" class="form-control"  disabled ="disable" value="${loanInstance?.loanApplication?.applicationDate}"  />
                                            <g:hasErrors bean="${ropaInstance}" field="lnApplicationDate">
                                                <div class="controls">
                                                        <span class="help-block">
                                                            <g:eachError bean="${ropaInstance}" field="lnApplicationDate">
                                                                <g:message error="${it}" /><br/>
                                                            </g:eachError>
                                                        </span>
                                                </div>
                                            </g:hasErrors>
                                        </div>  
                                    </div>
                                
                                <div class="fieldcontain form-group ${hasErrors(bean: txnTemplateInstance, field: 'txnType', 'has-error')} required">
                                    <label class="control-label col-sm-4" for="txnType">Txn Template<span class="required-indicator">*</span></label>
                                    
                                    <div class="col-sm-8"><g:select id="txnType" name="txnType" from="${icbs.admin.TxnTemplate.findAllByTxnTypeAndMemoTxnType(icbs.lov.TxnType.read(66),icbs.lov.MemoTxnType.read(1))}"   optionKey="id" optionValue="description" required="" value="" onchange="getcode();" class="many-to-one form-control"/>
                                    </div>             
                                </div>
                                <div class="fieldcontain form-group">
                                    <label class="control-label col-sm-4" for="intRate">Sale Amount<span class="required-indicator">*</span></label>                         
                                    <div class="col-sm-8">
                                        <g:field class="form-control truncated"  id="sale" name="sale" onblur="scrxAmount();" value="" />
                                        <g:hiddenField name="hiddenSale" id="hiddenSale" value="${ropaSaleInstance?.ropa?.loan?.grantedAmount}" />
                                    </div>             
                                </div>
                                <div  id ="rmincomeAmount" class="fieldcontain form-group">
                                    <label class="control-label col-sm-4" for="intRate">Income Amount<span class="required-indicator">(Optional)</span></label>                         
                                    <div class="col-sm-8">
                                        <g:field class="form-control truncated" onblur="scrxAmount();" id="income" name="income" value="" />
                                        <g:hiddenField name="hiddenIncome" id="hiddenIncome" value="" />
                                    </div>             
                                </div>
                                <div class="fieldcontain form-group ${hasErrors(bean: ropaInstance, field: 'glContraLitigationExp', 'has-error')} required">
                                    <label class="control-label col-sm-4" for="ropaContra">Ropa Income GL Account<span class="required-indicator">(Optional)</span></label>
                                    <div class="col-sm-8"><g:textField id="ropaIncomeContra" name="ropaIncomeContra" maxlength="25" required="" value="${ropaInstance?.ropaContra}" onblur="validateGlCodeIncome();" class="form-control"/>
                                        <g:hasErrors bean="${ropaInstance}" field="ropaIncomeContra">
                                            <div class="controls">
                                                <span class="help-block">
                                                    <g:eachError bean="${ropaInstance}" field="ropaIncomeContra">
                                                        <g:message error="${it}" /><br/>
                                                    </g:eachError>
                                                </span>
                                            </div>
                                        </g:hasErrors>
                                    </div>             
                                </div>
                                
                                <!-- Gl Account Description -->
                                <div id="glaccountdescription" class="fieldcontain form-group ${hasErrors(bean: txnTemplateInstance, field: 'depcontra', 'has-error')} required">
                                        <label class="control-label col-sm-4" for="ropaContra">
                                                <g:message code="ropa.gldescriptionIncome.label" default="GL Account Name" />
                                                <span class="required-indicator">(Optional)</span>
                                        </label>
                                        <div class="col-sm-8"><g:textField readonly="true" name="gldescriptionIncome" id="gldescriptionIncome" onblur="validateGlCodeIncome();" maxlength="100"  class="form-control"/>

                                            <g:hasErrors bean="${ropaInstance}" field="gldescriptionIncome">
                                                <div class="controls">
                                                        <span class="help-block">
                                                            <g:eachError bean="${txnTemplateInstance}" field="gldescriptionIncome">
                                                                <g:message error="${it}" /><br/>
                                                            </g:eachError>
                                                        </span>
                                                </div>
                                            </g:hasErrors>
                                        </div>             
                                </div>
                                <div id = "rmscrAmount" class="fieldcontain form-group">
                                    <label  class="control-label col-sm-4" for="scrAmount">Total SCR Amount<span class="required-indicator">*</span></label>                         
                                    <div class="col-sm-8">
                                        <g:field class="form-control truncated" id="scrAmount" name="scrAmount" value="" />
                                        <g:hiddenField name="hiddenScrAmount" id="hiddenScrAmount" value="" />
                                    </div>             
                                </div>
                                <div class="fieldcontain form-group">
                                    <label class="control-label col-sm-4" for="intRate">Downpayment Amount<span class="required-indicator">*</span></label>                         
                                    <div class="col-sm-8">
                                        <g:field class="form-control truncated" id="downpayment" name="downpayment" value="" />
                                    </div>             
                                </div>
                                <div class="fieldcontain form-group ${hasErrors(bean: ropaInstance, field: 'glContraLitigationExp', 'has-error')} required">
                                    <label class="control-label col-sm-4" for="ropaContra">Ropa GL Account<span class="required-indicator">*</span></label>
                                    <div class="col-sm-8"><g:textField id="ropaContra" name="ropaContra" maxlength="25" required="" value="${ropaInstance?.ropaContra}" onblur="validateGlCode();" class="form-control"/>
                                        <g:hasErrors bean="${ropaInstance}" field="ropaContra">
                                            <div class="controls">
                                                <span class="help-block">
                                                    <g:eachError bean="${ropaInstance}" field="ropaContra">
                                                        <g:message error="${it}" /><br/>
                                                    </g:eachError>
                                                </span>
                                            </div>
                                        </g:hasErrors>
                                    </div>             
                                </div>
                                <g:hiddenField id="financialYear" name="financialYear" value="${g.formatDate(date: (runDate), format: 'yyyy')}"/>
                                <!-- Gl Account Description -->
                                <div id="glaccountdescription" class="fieldcontain form-group ${hasErrors(bean: txnTemplateInstance, field: 'depcontra', 'has-error')} required">
                                        <label class="control-label col-sm-4" for="ropaContra">
                                                <g:message code="ropa.ropaContraDescription.label" default="GL Account Name" />
                                                <span class="required-indicator">*</span>
                                        </label>
                                        <div class="col-sm-8"><g:textField readonly="true" name="gldescription" id="gldescription" onblur="validateGlCode();" maxlength="100"  class="form-control"/>

                                            <g:hasErrors bean="${ropaInstance}" field="gldescription">
                                                <div class="controls">
                                                        <span class="help-block">
                                                            <g:eachError bean="${txnTemplateInstance}" field="gldescription">
                                                                <g:message error="${it}" /><br/>
                                                            </g:eachError>
                                                        </span>
                                                </div>
                                            </g:hasErrors>
                                        </div>             
                                </div>
                                
                                <g:hiddenField name="loanAppId" id="loanAppId" value="${params.id}" />
                                <g:hiddenField name="findCollId" id="findCollId" value="${ropaSaleInstance?.collateral?.id}" />
                                <g:hiddenField name="getRopaId" id="getRopaId" value="${params.idRopa}" />
                                <g:hiddenField name="productType" id="productType" value="" />
                                
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
<!--                <li><g:actionSubmit class="save" id="saveropaCredit" name="saveropaCredit"  onclick="validateFields();" value="${message(code: 'default.button.Save.label', default: 'Save')}" onclick="
                        alertify.confirm(AppTitle,'Are you sure you want to continue this transaction?',
                                function(){
                                     checkIfAllowed('CFG00303', 'form#ropaSale', 'ROPA Sale .', null); 
                                },
                                function(){
                                    return;
                                });                      
                    "/></li>-->
                <li><button onclick="validateFields();">Save Ropa Sale</button></li>
                <li><g:link action="collateralShow" id="${ropaSaleInstance?.id}">Cancel</g:link></li>
                 
        
            </ul>
        </content>
    </body>
</html>