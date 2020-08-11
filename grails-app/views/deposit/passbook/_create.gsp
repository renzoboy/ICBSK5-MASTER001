<!--
  To change this license header, choose License Headers in Project Properties.
  To change this template file, choose Tools | Templates
  and open the template in the editor.
-->

<%@ page contentType="text/html;charset=UTF-8" %>

            <g:if test="${flash.message}">
                <div class="box-body">
                    <div class="alert alert-info alert-dismissable">
                        <i class="fa fa-info"></i>
                        <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                        <b>Message</b> <div class="message" role="status">${flash.message}</div>
                    </div>
                </div>
                <script>
                    (function(){
                        var x = "${flash.message}";
                       // console.log('value of x? '+x);
                        if(x.indexOf('Successfully')>0)
                        {
                            $('#passsvbtn').hide();
                            $('.passbookNo').attr('readonly',true);
                            $('#remarks').attr('readonly',true);
                        }
                    })();
                </script>
            </g:if>
            <g:hasErrors bean="${issuePassbookInstance}">
                <div id= "addCustomerRelatedError" class="box-body">
                    <div class="alert alert-danger alert-dismissable">
                        <i class="fa fa-ban"></i>
                        <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                        <b>Alert!</b> 
                        <ul class="errors" role="alert">
                            <div id="errorList">
                                            
                            </div>
                            <g:eachError bean="${issuePassbookInstance}" var="error">
                                <li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
                            </g:eachError>
                        </ul>            
                    </div>
                </div>
            </g:hasErrors>
            <g:form name="savePassbookForm">
                <g:render template='passbook/form' model='[issuePassbookInstance:issuePassbookInstance]'/>
            </g:form>