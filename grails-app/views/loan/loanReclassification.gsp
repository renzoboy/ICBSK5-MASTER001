<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'loanLedger.label', default: 'LoanLedger')}" />
		<title>Loan Reclassification Amendment</title>
		<g:javascript>
			
                </g:javascript>
	</head>
	<body>
        <content tag="breadcrumbs">
            <span class="fa fa-chevron-right"></span><span class="current">Loan Reclassification amendment</span>
	</content>
        <content tag="main-content">
		<div id="create-loanLedger" class="content scaffold-create" role="main">
                <g:if test="${flash.message}">
                <script>
                        $(function(){
                            var x = '${flash.message}';
                                notify.message(x);
                        });
                </script>
                </g:if>
                <g:form name="myForm" url="[action:'updateLoanPerformaceNow',controller:'loan']" method="POST">
                    <g:hiddenField name="loanId" id="loanId" value="${loanInstance?.id}" />
                    <div class="fieldcontain form-group ${hasErrors(bean: loanInstance, field: 'loanPerformanceId', 'has-error')} required">
                        <label class="control-label col-sm-4" for="loanPerformanceId">
                            <g:message code="loan.loanPerformanceId.label" default="Loan Status" />
                        </label>
                        <div class="col-sm-8">
                            <g:select id="newLoanPerformanceID" name="newLoanPerformanceID" from="${icbs.lov.LoanPerformanceId.list()}" optionKey="id" optionValue="description" value="${loanInstance?.loanPerformanceId?.id}" class="many-to-one form-control"/>
                        </div>             
                    </div>
                </g:form>    
		</div>
        </content>
        <content tag="main-actions">
            <ul>
                <li><button onclick="validateConfirm();">Update Loan Reclassification</button></li>
                <li><g:link class="list" action="index" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');">Cancel</g:link></li>
                <script>
                    function validateConfirm(){
                        var loanId = $('#loanId').val()
                        alertify.confirm(AppTitle,"Are you sure you want to update this Loan Reclassification ?",
                            function(){
                                var obj = { 
                                    loanId: $('#loanId').val(),
                                    newLoanPerformanceID: $('#newLoanPerformanceID').val(),
                                }; 

                                console.log(JSON.stringify(obj));
                                console.log("Object Loaded iwth data...");

                                $.ajax({
                                    type: "POST",
                                    contentType: "application/json",
                                    url: "${createLink(controller:'Loan', action:'updateLoanPerformaceNow')}",
                                    data: JSON.stringify(obj),

                                    success: function(data){
                                        alertify.alert(AppTitle,"Loan Reclassification Successfully Updated!", function(){      
                                        var x1 = "/icbs/loan/show/"+loanId
                                        console.log("x1: "+x1);
                                        window.location = x1;
                                        });  
                                    },
                                    error: function(data){

                                        console.log(data);
                                        console.log("error updating");

                                    },

                                }); 
                            },
                            function(){
                              alertify.error('Canceled!');
                            }
                        );
                    }
                </script>
            </ul>
            
        </content>
	</body>
</html>
