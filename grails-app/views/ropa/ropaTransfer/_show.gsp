<div class="row">
                <div class="form-horizontal">
                    <div class="col-md-8">
                        <div class="infowrap">
                            <table class="table table-bordered table-striped">
                                <legend class="section-header">Transaction Details</legend>
                                    <tr>
                                        <td><label>Transaction ID</label></td>
                                        <td>${txnFileInstance.id}</td>
                                    </tr>                                
                                    <tr>
                                        <td><label>Transaction Date</label></td>
                                        <td><g:formatDate  format="MM/dd/yyyy" date="${txnFileInstance?.txnDate}" /></td>
                                    </tr>
                                    <tr>
                                        <td><label>Transaction Type</label></td>
                                        <td><g:fieldValue bean="${txnFileInstance}" field="txnType.description"/></td>
                                    </tr>
                                    <tr>
                                        <td><label>Account Number</label></td>
                                        <td><g:fieldValue bean="${txnFileInstance}" field="acctNo"/></td>
                                    </tr>  
                                    <g:if test="${txnFileInstance.depAcct}">
                                        <tr>
                                            <td><label>Depositor Name</label></td>
                                            <td>${txnFileInstance.depAcct.customer.displayName}</td>
                                        </tr>                                        
                                    </g:if>    
                                    <g:if test="${txnFileInstance.loanAcct}">
                                        <tr>
                                            <td><label>Borrower Name</label></td>
                                            <td>${txnFileInstance.loanAcct.customer.displayName}</td>
                                        </tr>                                        
                                    </g:if> 
                                    <tr>
                                        <td><label>Branch</label></td>
                                        <td><g:fieldValue bean="${txnFileInstance}" field="branch.name"/></td>
                                    </tr>                                     
                                    <tr>
                                        <td><label>Transaction Amount</label></td>
                                        <td><g:formatNumber format="###,###,##0.00" number="${txnFileInstance?.txnAmt}"/></td>
                                    </tr>

                                    <tr>
                                        <td><label>Transaction Code</label></td>
                                        <td><g:fieldValue bean="${txnFileInstance}" field="txnCode"/></td>
                                    </tr>
                                    <tr>
                                        <td><label>Transaction Template</label></td>
                                        <td><g:fieldValue bean="${txnFileInstance}" field="txnTemplate.description"/></td>
                                    </tr>                                      
                                    <tr>
                                        <td><label>Transaction Description</label></td>
                                        <td><g:fieldValue bean="${txnFileInstance}" field="txnDescription"/></td>
                                    </tr>  
                                    <tr>
                                        <td><label>Reference</label></td>
                                        <td><g:fieldValue bean="${txnFileInstance}" field="txnRef"/></td>
                                    </tr>
                                    <tr>
                                        <td><label>Particulars</label></td>
                                        <td><g:fieldValue bean="${txnFileInstance}" field="txnParticulars"/></td>
                                    </tr>
                                    <tr>
                                        <td><label>Status</label></td>
                                        <td><g:fieldValue bean="${txnFileInstance}" field="status.description"/> </td>
                                    </tr>
                                    <tr>
                                        <td><label>User</label></td>
                                        <td><g:fieldValue bean="${txnFileInstance}" field="user.username"/></td>
                                    </tr>                                    
                            </table>


                        </div>
                    </div>

                </div>
            </div>