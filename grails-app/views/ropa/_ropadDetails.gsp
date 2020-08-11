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
        <tr>
            <td ><label>Loan Balance</label></td>
            <td><g:formatNumber format="###,###,##0.00" number="${ ropadebitInstance?.loanBalance}"/></td>   
        </tr>
    </tbody>
</table>
</div>


