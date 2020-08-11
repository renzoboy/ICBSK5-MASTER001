<div class="row">    
    <div class="col-md-12">
      
         <div class="section-container">
                    <fieldset>
                        <legend class="section-header">Rollover Information</legend>
                        <table class="table table-bordered table-striped">
                                <tbody>
                                    <tr>
                                        <td style="font-weight:bold" width="30%">Start Date</td>
                                        <td width="70%"><g:formatDate format="MM/dd/yyyy" date="${rolloverId?.startDate}"/></td>
                                    </tr>
                                    <tr>
                                        <td style="font-weight:bold" width="30%">End Date</td>
                                        <td width="70%"><g:formatDate format="MM/dd/yyyy" date="${rolloverId?.endDate}"/></td>
                                    </tr>  
                                    <tr>
                                        <td style="font-weight:bold" width="30%">Rollover Type</td>
                                        <td width="70%">${rolloverId?.type?.description}</td>
                                    </tr> 
                                    <tr>
                                        <td style="font-weight:bold" width="30%">Balance Amount</td>
                                        <td width="70%"><g:formatNumber format="###,###,##0.00" number="${rolloverId?.principalAmt}"/></td>
                                    </tr> 
                                    <tr>
                                        <td style="font-weight:bold" width="30%">Normal Interest Amount</td>
                                        <td width="70%"><g:formatNumber format="###,###,##0.00" number="${rolloverId?.normalInterestAmt}"/></td>
                                    </tr>
                                    <tr>
                                        <td style="font-weight:bold" width="30%">Pre-term Interest Amount</td>
                                        <td width="70%"><g:formatNumber format="###,###,##0.00" number="${rolloverId?.preTermInterestAmt}"/></td>
                                    </tr>      
                                    <tr>
                                        <td style="font-weight:bold" width="30%">Tax Amount 1</td>
                                        <td width="70%"><g:formatNumber format="###,###,##0.00" number="${rolloverId?.taxAmt1}"/></td>
                                    </tr>
                                    <tr>
                                        <td style="font-weight:bold" width="30%">Tax Amount 2</td>
                                        <td width="70%"><g:formatNumber format="###,###,##0.00" number="${rolloverId?.taxAmt2}"/></td>
                                    </tr>
                                    <tr>
                                        <td style="font-weight:bold" width="30%">Tax Amount 3</td>
                                        <td width="70%"><g:formatNumber format="###,###,##0.00" number="${rolloverId?.taxAmt3}"/></td>
                                    </tr>
                                    <tr>
                                        <td style="font-weight:bold" width="30%">Rollover Status</td>
                                        <td width="70%">${rolloverId?.status?.description}</td>
                                    </tr>
                                    <tr>
                                        <td style="font-weight:bold" width="30%">Interest Payment Mode </td>
                                        <td width="70%">${rolloverId?.interestPaymentMode?.description}</td>
                                    </tr>                                        
                                    <tr>
                                        <td style="font-weight:bold" width="30%">Funded Deposit Id</td>
                                        <td width="70%">${rolloverId?.fundedDeposit?.id}</td>
                                    </tr>
                                    <tr>
                                        <td style="font-weight:bold" width="30%">Post Maturity Interest Rate</td>
                                        <td width="70%"><g:formatNumber format="###,###,##0.00" number="${rolloverId?.postMaturityInterestRate}"/></td>
                                    </tr>   
                                </tbody>
                        </table>        
                    </fieldset>
                </div>
       </div>
</div>
