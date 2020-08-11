


<%@ page import="icbs.gl.GlContigentAccount" %>
<%@ page import="icbs.admin.UserMaster" %>

<!DOCTYPE html>


<html>
    <head>

	<meta name="layout" content="main">
	<title>Contigent Account Details</title>
        
         <g:javascript>
            function xxxx(){
           
                alertify.confirm(AppTitle,'Are you sure you want to remove this contigent account?',
                    function(){
                                $.ajax({
                                    type: 'POST',
                                    data: {id:$('#idcontigent').val()},
                                    url: "${createLink(controller:'GlContAcct', action:'removeContigentAccountAjax')}",
                                    success: function(){                  
                                        alertify.alert(AppTitle,'sdfsdfsdf').set('message', 'Removed Successfully!').show();
                                        funcDisableProperty();
                                    },
                                    error:function(XMLHttpRequest,textStatus,errorThrown){
                                        alert(XMLHttpRequest+textStatus+errorThrown);
                                    }
                                });
                        },
                    function(){
                        return;
                    });    

                               
                    
            }
            function funcDisableProperty(){

                     document.getElementById("removedbtn").style.display="none"
                     document.getElementById("updatedbtn").style.display="none"
            }
            function submitformfunc(){
                 document.getElementById("myForm").submit();
            }
                                          
            
        </g:javascript>   
    </head>
    <body>
  	
        <content tag="main-content">   
                        
	<div class="row">
            <div class="section-container">
                <fieldset>
                <legend class="section-header">Contigent Account Details</legend>
                <table class="table table-bordered table-striped">
                    <tbody>
                        <g:hiddenField id="idcontigent"  name="id" value="${glContAcctInstance.id}" />
                        <tr>
                            <td style="font-weight:bold" width="30%">ID</td>
                            <td width="75%">${glContAcctInstance?.id}</td>
                        </tr>
                        <tr>
                            <td style="font-weight:bold" width="30%">Transaction Date</td>
                            <td width="75%"><g:formatDate  format="MM/dd/yyyy" date="${glContAcctInstance?.txnDate}" /></td>
                        </tr>
                        <tr>
                            <td style="font-weight:bold" width="30%">Contigent Type</td>
                            <td width="75%">${glContAcctInstance?.contigent?.description}</td>
                        </tr>
                        <tr>
                            <td style="font-weight:bold" width="30%">Credit Amount</td>
                            <td width="75%"><g:formatNumber format="###,###,##0.00" number="${glContAcctInstance?.creditAmt}"/></td>
                        </tr>
                        <tr>
                            <td style="font-weight:bold" width="30%">Debit Amount</td>
                            <td width="75%"><g:formatNumber format="###,###,##0.00" number="${glContAcctInstance?.debitAmt}"/></td>
                        </tr>
                        <tr>
                            <td style="font-weight:bold" width="30%">Reference</td>
                            <td width="75%">${glContAcctInstance?.reference}</td>
                        </tr>
                        <tr>
                            <td style="font-weight:bold" width="30%">Particulars</td>
                            <td width="75%">${glContAcctInstance?.particulars}</td>
                        </tr>
                        <tr>
                            <td style="font-weight:bold" width="30%">Contigent Status</td>
                            <td width="75%">${glContAcctInstance?.status?.description}</td>
                        </tr>
                        <tr>
                            <td style="font-weight:bold" width="30%">Created By</td>
                            <td width="75%">${glContAcctInstance?.createdByUser?.username}</td>
                        </tr>
                        <tr>
                            <td style="font-weight:bold" width="30%">Contigent Branch</td>
                            <td width="75%">${glContAcctInstance?.branch?.name}</td>
                        </tr>
                    </tbody>
                </table>
                </fieldset>
            </div>  
        </div>		
        </content>
           

        <content tag="main-actions">
            <ul>

                    <!--
                    <li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
                    -->
                <li id="updatedbtn"><g:link   contoller="GlContAcct" action="updatecontAcct" params="['id': glContAcctInstance.id]">Update</g:link></li>
                   
                <li id="removedbtn"><a href ="#"  onclick="xxxx();" >Remove</a></li>
                <li><g:link action="createcontigent">Create New Contigent Account</g:link></li>
                <li><g:link  contoller="GlContAcct" action="index">Contigent Account List</g:link></li>
            </ul>
        </content>
        
    </body>
</html>

