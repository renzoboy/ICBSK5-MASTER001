<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
    <head>  
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="layout" content="main">
        <title>Update Passbook</title>
        <script type="text/javascript" src="${resource(dir: 'js', file: 'customerSearch.js')}"></script>
        <asset:javascript src="checkPassbookBal.js"/>
        <asset:javascript src="telleringHelper.js"/>
        
        <g:javascript>
            var modal;
            function refreshForm(params){
                if(params.deposit){
                    icbs.Tellering.depositDetails('getDepositDetailsCallback',"${createLink(controller : 'tellering', action:'changeDepositDetails')}",{deposit:params.deposit});
                }
            }
            function initializeDepositAcctSearchModal(){
                modal = new icbs.UI.Modal({id:"addFundTransferSearchModal",url:"${createLink(controller : 'search', action:'search', params:[searchDomain: "deposit"])}",title:"Search Deposit Accounts",onCloseCallback:refreshForm});
            }
        </g:javascript>
    </head>
    
    <body>
        <content tag="breadcrumbs">
            <span class="fa fa-chevron-right"></span><span class="current">Update Passbook</span>
        </content>
        <content tag="main-content">
                <g:render template='txnUpdatePassbook/form'/>   
        </content>    
 
        <content tag="main-actions">
            <ul>
                <li><g:link action="index">Tellering Index</g:link></li>
            </ul>                                        
        </content>
    </body>
</html>
