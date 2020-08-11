<div class="row" style="margin:auto">
    <div class="section-container">
        <fieldset>
        <legend class="section-header">Account Information</legend>
        <table class="table table-bordered table-striped">
            <tbody>
                <tr>
                    <td style="font-weight:bold" width="30%">Date Open</td>
                    <td width="75%"><g:formatDate format="MM/dd/yyyy" date="${depositInstance?.dateOpened}"/></td>
                </tr>
                <g:if test="${depositInstance?.type?.id==3}">  
                <tr>
                    <td style="font-weight:bold" width="30%">Interest Start Date</td>
                    <td width="75%"><g:formatDate format="MM/dd/yyyy" date="${depositInstance?.currentRollover?.startDate}"/></td>
                </tr>
                <tr>
                    <td style="font-weight:bold" width="30%">Maturity Date</td>
                     <g:if test="${depositInstance?.depositInterestScheme?.fdMonthlyTransfer==true}">
                        <td width="75%"><g:formatDate format="MM/dd/yyyy"  date="${depositInstance?.maturityDate}" /></td>
                     </g:if>
                     <g:else>
                         <td width="75%"><g:formatDate format="MM/dd/yyyy" date="${depositInstance?.currentRollover?.endDate}" /></td>
                     </g:else>
                </tr>
                <tr>
                    <td style="font-weight:bold" width="30%">Term</td>
                    <td width="75%"><g:formatNumber format="##,###" number="${depositInstance?.maturityDate - depositInstance?.currentRollover?.startDate}"/></td>
                </tr>
                </g:if>
                <tr>
                    <td style="font-weight:bold" width="30%">Interest Rate</td>
                    <td width="75%"><g:formatNumber format="#,##0.00" number="${depositInstance?.interestRate}"/>%</td>
                </tr>
                <tr>
                    <td style="font-weight:bold" width="30%">Passbook No</td>
                    <td width="75%"><g:formatNumber format="###############" id="NoPass" number="${depositInstance.passBookNo}"/></td>
                </tr>
                <g:if test="${depositInstance?.type?.id==3}">
                <tr>
                    <td style="font-weight:bold" width="30%">Rollover Type</td>
                    <td width="75%">${depositInstance?.currentRollover?.type}</td>
                </tr>
                <tr>
                    <td style="font-weight:bold" width="30%">Mode of Interest Payment</td>
                    <td width="75%">${depositInstance?.currentRollover?.interestPaymentMode?.description}</td>
                </tr>
                <tr>
                    <td style="font-weight:bold" width="30%">Credit Account</td>
                    <td width="75%"><g:link action="depositInquiry" id="${depositInstance?.currentRollover?.fundedDeposit?.id}">${depositInstance?.currentRollover?.fundedDeposit?.acctNo}</g:link></td>
                </tr>
                </g:if>
                <tr>
                    <td style="font-weight:bold" width="30%">Last Transaction Date</td>
                    <td width="75%"><g:formatDate format="MM/dd/yyyy"  date="${depositInstance?.lastTxnDate}" /></td>
                </tr>
                <tr>
                    <td style="font-weight:bold" width="30%">Status Change Date</td>
                    <td width="75%"><g:formatDate format="MM/dd/yyyy"  date="${depositInstance?.statusChangeDate}" /></td>
                </tr>
                <tr>
                    <td style="font-weight:bold" width="30%">Last Capitalization Date</td>
                    <td width="75%"><g:formatDate format="MM/dd/yyyy" date="${depositInstance?.lastCapitalizationDate}" /></td>
                </tr>
                <tr>
                    <td style="font-weight:bold" width="30%">Deposit Account Officer</td>
                    <td width="75%">${depositInstance?.userDepositAcctOfficer?.name1} ${depositInstance?.userDepositAcctOfficer?.name2} ${depositInstance?.userDepositAcctOfficer?.name3}</td>
                </tr>
            </tbody>
        </table>
        </fieldset>
    </div>    
</div>
<div class="row" style="margin:auto">
    <div class="section-container">
        <fieldset>
            <legend class="section-header">Balance Information</legend>
                <table class="table table-bordered table-striped">
                    <tbody>
                        <tr>
                            <td style="font-weight:bold" width="30%">Current Balance</td>
                            <td width="75%"><g:formatNumber format="###,###,##0.00" number="${depositInstance?.ledgerBalAmt}"/></td>
                        </tr>
                        <tr>
                            <td style="font-weight:bold" width="30%">Available Balance</td>
                            <td width="75%"><g:formatNumber format="###,###,##0.00" number="${depositInstance?.availableBalAmt}"/></td>
                        </tr>
                        <tr>
                            <td style="font-weight:bold" width="30%">Passbook Balance</td>
                            <td width="75%"><g:formatNumber format="###,###,##0.00" number="${depositInstance?.passbookBalAmt}"/></td>
                        </tr>
                        <tr>
                            <td style="font-weight:bold" width="30%">Hold Balance</td>
                            <td width="75%"><g:formatNumber format="###,###,##0.00" number="${depositInstance?.holdBalAmt}"/></td>
                        </tr>
                        <g:if test="${depositInstance?.type?.id == 3 && depositInstance?.currentRollover?.status?.id == 1}">
                            <g:if test="${depositInstance?.status?.id == 7}">
                                <tr>
                                    <td style="font-weight:bold" width="30%">Accrued Interest</td>
                                    <td width="75%"><g:formatNumber format="###,###,##0.00" number="${depositInstance?.acrintAmt}"/></td>
                                </tr>
                            </g:if>    
                            <g:else>
                                <tr>
                                    <td style="font-weight:bold" width="30%">Accrued Interest</td>
                                    <td width="75%"><g:formatNumber format="###,###,##0.00" number="${depositInstance?.currentRollover?.normalInterestAmt}"/></td>
                                </tr>
                                <tr>
                                    <td style="font-weight:bold" width="30%">Pre-Term Interest</td>
                                    <td width="75%"><g:formatNumber format="###,###,##0.00" number="${depositInstance?.currentRollover?.preTermInterestAmt}"/></td>
                                </tr>
                            </g:else>
                        </g:if>
                        <g:else>
                            <tr>
                                <td style="font-weight:bold" width="30%">Accrued Interest</td>
                                <td width="75%"><g:formatNumber format="###,###,##0.00" number="${depositInstance?.acrintAmt}"/></td>
                            </tr>
                        </g:else>
                            <tr>
                                <td style="font-weight:bold" width="30%">Last EOM ADB</td>
                                <td width="75%"><g:formatNumber format="###,###,##0.00" number="${depositInstance?.lmAveBalAmt}"/></td>
                            </tr>
                            <tr>
                                <td style="font-weight:bold" width="30%">Uncleared Check Balance Amount</td>
                                <td width="75%"><g:formatNumber format="###,###,##0.00" number="${depositInstance?.unclearedCheckBalAmt}"/></td>
                            </tr>
                    </tbody>
                </table>    
        </fieldset>
    </div>
</div>
