<%@ page import="icbs.gl.BillsPayable" %>
<%@ page import="icbs.loans.Loan" %>
<!DOCTYPE html>
<html>
    <head>
	<meta name="layout" content="main">
	<title>Bills Payable Subsidiary Ledger Information</title>

		<g:javascript>
            function showLoanSearch() {				
                modal = new icbs.UI.Modal({id:"loanModal", url:"${createLink(controller: 'loan', action:'search')}", title:"Search Loan Account", onCloseCallback:updateLoanDetailsAjax});
                modal.show();
            }
            function deleteAssignLoan(billsPayableIDID){
                if (billsPayableIDID) {
                alertify.confirm(AppTitle,"Are you sure you want to delete this loan account ?",
                 function(){
                    //======================================
                       
                        var delbpL = $('#did').val();
			var assignLoanId = billsPayableIDID;
                        var obj = { 
                            billspayablelinkLoans: delbpL,
                            assignLoanId: assignLoanId  
                        }; 
                        console.log(JSON.stringify(obj));
                        console.log("Object Loaded iwth data...");
                        $.ajax({
                            type: "POST",
                            
                            url: "${createLink(controller:'billsPayable', action:'deleteLinkLoans')}",
                            data: {billspayablelinkLoans:delbpL,assignLoanId: assignLoanId},

                            success: function(data){

                                $.each(data, function (_key, _value) {
                                    console.log(JSON.stringify(data));
                                    notify.message("Loan Account Successfully Deleted! |success|alert");
                                    location.reload();
                                });
                            },
                            error: function(data){

                            },

                        });
                        //=====================================
                },
                function(){
                  alertify.error('Canceled');
                });
                    
                }
            }
            
            function updateLoanDetailsAjax(params) {
                if (params.loan2) {
                alertify.confirm(AppTitle,"Are you sure you want to link this account ?",
                function(){
                    //======================================
                        
                       
                        var highBP = $('#myFarewellID').val();
                        console.log("delete: "+ highBP);
                        
                        var obj = { 
                            id:params.loan2,
                            billspayable: highBP
                        }; 
                        console.log(JSON.stringify(obj));
                        console.log("Object Loaded iwth data...");
                        $.ajax({
                            type: "POST",
                            
                            url: "${createLink(controller:'billsPayable', action:'validateExistingAssignLoan')}",
                            data: {id:params.loan2,billspayable: highBP},

                            success: function(data){

                               if(data.length > 0){
                                    notify.message("Linking Error, please verify loan account |error|alert");
                                    
                               }else{
                                    //==================== main loop by giezel ======================
                                    var obj = { 
                                        id:params.loan2,
                                        billspayable: highBP
                                    }; 
                                    console.log(JSON.stringify(obj));
                                    console.log("Object Loaded iwth data...");
                                    $.ajax({
                                        type: "POST",

                                        url: "${createLink(controller:'billsPayable', action:'assignLoan')}",
                                        data: {id:params.loan2,billspayable: highBP},

                                        success: function(data){

                                            $.each(data, function (_key, _value) {
                                                console.log(JSON.stringify(data));
                                                notify.message("Loan Account Successfully Linked! |success|alert");
                                                location.reload();
                                            });
                                        },
                                        error: function(data){

                                        },

                                    });
                                    ////==================== main loop by giezel ======================
                               }
                            },
                            error: function(data){

                            },

                        });
                        
                },
                function(){
                  alertify.error('Canceled');
                });
                    
                }
            }

        </g:javascript>
	</head>
    <body>
        <content tag="breadcrumbs">
            <span class="fa fa-chevron-right"></span><a href="${createLink(uri: '/billsPayable')}">Bills Payable Subsidiary Ledger</a>
            <span class="fa fa-chevron-right"></span><span class="current">Bills Payable Subsidiary Ledger Information</span>
        </content>
        <content tag="main-content">
             <div id="show-billsPayable" class="content scaffold-show" role="main">
                
		<table class="table table-bordered table-rounded table-striped table-hover">
                    <tbody>               
                        <g:hiddenField name="myFarewellID" id="myFarewellID" value="${billsPayableInstance?.id}" />
                        <tr>
                            <td style="width:30%"><label>GL Account Code</label></td>
                            <td style="width:70%">${billsPayableInstance?.glContra}</td>    
                        </tr> 
                        <tr>
                            <td style="width:30%"><label>Creditor Name</label></td>
                            <td style="width:70%">${billsPayableInstance?.creditorName}</td>    
                        </tr> 
                        <tr>
                            <td style="width:30%"><label>Date Opened</label></td>
                            <td><g:formatDate  format="MM/dd/yyyy" date="${billsPayableInstance.dateOpened}" /></td>    
                        </tr>                        
                        <tr>
                            <td style="width:30%"><label>Maturity Date</label></td>
                            <td><g:formatDate  format="MM/dd/yyyy" date="${billsPayableInstance.dueDate}" /></td>    
                        </tr>
                        <tr>
                            <td style="width:30%"><label>Promissory Note Date</label></td>
                            <td><g:formatDate  format="MM/dd/yyyy" date="${billsPayableInstance.pnDate}" /></td>    
                        </tr>  
                        <tr>
                            <td style="width:30%"><label>Promissory Note Number</label></td>
                            <td style="width:70%">${billsPayableInstance?.pnNo}</td>    
                        </tr>
                        <tr>
                            <td style="width:30%"><label>Account Name</label></td>
                            <td style="width:70%">${billsPayableInstance?.accountName}</td>    
                        </tr>   
                        <tr>
                            <td style="width:30%"><label>Payee</label></td>
                            <td style="width:70%">${billsPayableInstance?.payee}</td>    

                        </tr>   
                        
                    </tbody>
                </table>                                  
            </div>
            <g:form id="deposit" url="[controller:BillsPayable, action:'assignLoan']" method="POST" >
                
                <g:hiddenField name="loanloan" id="loanloan" value="${loanInstance?.id}" />
                 <g:hiddenField id="idnibp" name="idnibp" value="${params.id}"/>
                
            </g:form>
	<g:form name="LinkLoansDetails" url="[action:'linkLoans',controller:'BillsPayable']">
                <g:hiddenField id="id" name="id" value="${billsPayableInstance.id}"/>
                    <div class="row">
                        <div class=" col-md-2">
                            <g:select name="max" value="${params.max}" from="[5, 10, 15, 20]" class="form-control input-sm" onchange="submit(${billsPayableInstance.id})" />
                        </div>
                               
                        <div class="input-group col-md-10">
                            <input id="searchQuery"name="query"type="text" class="form-control" value="${params?.query}" onchange="this.form.submit()">
                                <span class="input-group-btn">
                                    <g:submitButton name="search" value="Search" class="btn btn-primary" />
                                </span>
                        </div><!-- /input-group -->
                    </div><!-- /.col-lg-6 -->
            </g:form>   
            <div class="box-body table-responsive no-padding">
                
                <table class="table table-hover table-condensed table-bordered table-striped">
                    <tr> 
                        <td><center><label>Bills Payable</label></center></td>
                        <td><center><label>Loan Account No.</label></center></td>
                        <td><center><label>Link Date</label></center></td>
                        <td><center><label>User</label></center></td>
                        <td><center><label>Status</label></center></td>
                        <td><center><label>Action</label></center></td>
                    </tr>
                    <g:each var="bplli" in="${billPayableLinkLoansInstance}">
                        <tr>
                            <g:hiddenField id="did" name="did" value="${bplli?.id}"/>
                            <td>${bplli?.billsPayable?.accountName}</td>
                            <td>${bplli?.loan?.accountNo}</td>
                            <td><g:formatDate date="${bplli?.linkDate}" type="date" style="LONG"/></td>
                            <td>${bplli?.user?.username}</td>
                            <td>${bplli?.status?.description}</td>
                            <td><button class="btn btn-secondary" onclick="deleteAssignLoan('${bplli.id}')">Delete</button></td>
                        </tr>
                     </g:each>     
                </table>
                <div class="pagination">
                        <g:paginate total="${billPayableLinkLoansInstanceCount ?: 0}" params="${params}"/>
                </div>


            </div>
            
        </content>
        
        <content tag="main-actions">
            <ul>
                <li><g:link action="show" controller="billsPayable" id="${billsPayableInstance.id}" >Return to Bills Payable</g:link></li>
                <li><button onclick="showLoanSearch()">Assign Loan Accounts</button></li>
                <li><g:link action="index" controller="billsPayable" >Bills Payable List</g:link></li>
            </ul>
        </content>
    </body>
</html>
