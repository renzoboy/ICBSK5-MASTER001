
<%@ page import="icbs.loans.LoanApplicationSpecAdditional" %>

<g:if test="${secUnsecTag == "unsec"}">
                  
    <legend>Unsecured Credit Process Details</legend>
</g:if>
<g:else>
    <legend>Credit Investigation Details</legend>
</g:else>  
<table class="table table-bordered table-striped">
    <tbody>
        <g:if test="${secUnsecTag == "secured"}">
            <tr>
                <td style="font-weight:bold" width="30%">Date Created</td>
                <td width="70%"><g:formatDate format="MM/dd/yyyy" date="${creditInvestigationInstance?.ciCreatedDate}"  style="FULL"/></td>
            </tr>

            <tr>
                <td style="font-weight:bold" width="30%">Account Application</td>
                <td width="70%"><g:link controller="loanApplication" action="show" id="${creditInvestigationInstance?.loanApplication?.id}">${creditInvestigationInstance?.loanApplication?.id}</g:link></td>
            </tr>
            <tr>
                <td style="font-weight:bold" width="30%">Account Application Date</td>
                <td width="70%"><g:formatDate format="MM/dd/yyyy" date="${creditInvestigationInstance?.loanApplication?.applicationDate}"  style="FULL"/></td>
            </tr>
            <g:if test="${creditInvestigationInstance?.loanApplication}">
                <tr>    
                    <td style="font-weight:bold" width="30%">Borrower Name</td>
                    <td width="70%">${creditInvestigationInstance?.loanApplication?.customer?.displayName}</td>
                </tr>
                <tr>
                    <td style="font-weight:bold" width="30%">Status</td>
                    <td width="70%">${creditInvestigationInstance?.status.description}</td>
                </tr>
                <tr>
                    <td style="font-weight:bold" width="30%">Product</td>
                    <td width="70%"><g:link controller="product" action="show" id="${creditInvestigationInstance?.loanApplication?.product?.id}">${creditInvestigationInstance?.loanApplication?.product?.name}</g:link></td>
                </tr>
                <tr>
                    <td style="font-weight:bold" width="30%">Amount</td>
                    <td width="70%"><g:formatNumber format="###,##0.00" number="${creditInvestigationInstance?.loanApplication?.amount}" /></td>
                </tr>  

            </g:if>    
            <tr>
                <td style="font-weight:bold" width="30%">Date Folder Received by Branch Dept</td>
                <td width="70%"><g:formatDate format="MM/dd/yyyy" date="${creditInvestigationInstance?.folderReceivedByBranchDept}"  style="FULL"/></td>
            </tr>
            <tr>
                <td style="font-weight:bold" width="30%">Date Received by Credit Department</td>
                <td width="70%"><g:formatDate format="MM/dd/yyyy" date="${creditInvestigationInstance?.folderTransToCau}"  style="FULL"/></td>
            </tr>
            <tr>
                <td style="font-weight:bold" width="30%">Date Assigned to CI</td>
                <td width="70%"><g:formatDate format="MM/dd/yyyy" date="${creditInvestigationInstance?.assignedToCi}"  style="FULL"/></td>
            </tr>
            <tr>
                <td style="font-weight:bold" width="30%">Deadline</td>
                <td width="70%"><g:formatDate format="MM/dd/yyyy" date="${creditInvestigationInstance?.deadlineAssignedToCreCom}"  style="FULL"/></td>
            </tr>
            <tr>
                <td style="font-weight:bold" width="30%">Date Assigned to Analyst</td>
                <td width="70%"><g:formatDate format="MM/dd/yyyy" date="${creditInvestigationInstance?.assignedToAnalyst}"  style="FULL"/></td>
            </tr>
            <tr>
                <td style="font-weight:bold" width="30%">Deadline</td>
                <td width="70%"><g:formatDate format="MM/dd/yyyy" date="${creditInvestigationInstance?.deadlineSubAnalystreport}"  style="FULL"/></td>
            </tr>
            <tr>
                <td style="font-weight:bold" width="30%">Date Submitted By Analyst</td>
                <td width="70%"><g:formatDate format="MM/dd/yyyy" date="${creditInvestigationInstance?.submitAnalystRep}"  style="FULL"/></td>
            </tr>
            <tr>
                <td style="font-weight:bold" width="30%">Date Approved by Manager</td>
                <td width="70%"><g:formatDate format="MM/dd/yyyy" date="${creditInvestigationInstance?.reviewDateByManager}"  style="FULL"/></td>
            </tr>
            <tr>
                <td style="font-weight:bold" width="30%">Date Scheduled for CAC</td>
                <td width="70%"><g:formatDate format="MM/dd/yyyy" date="${creditInvestigationInstance?.schedForCac}"  style="FULL"/></td>
            </tr>
            <tr>
                <td style="font-weight:bold" width="30%">Date Actual CAC</td>
                <td width="70%"><g:formatDate format="MM/dd/yyyy" date="${creditInvestigationInstance?.actualCac}"  style="FULL"/></td>
            </tr>
            <tr>
                <td style="font-weight:bold" width="30%">Date of Scheduled CreCom</td>
                <td width="70%"><g:formatDate format="MM/dd/yyyy" date="${creditInvestigationInstance?.schedCrecom}"  style="FULL"/></td>
            </tr>
            <tr>
                <td style="font-weight:bold" width="30%">Date of Actual CreCom</td>
                <td width="70%"><g:formatDate format="MM/dd/yyyy" date="${creditInvestigationInstance?.actualCrecom}"  style="FULL"/></td>
            </tr>
            <tr>
                <td style="font-weight:bold" width="30%">Lending Authority Approval Date</td>
                <td width="70%"><g:formatDate format="MM/dd/yyyy" date="${creditInvestigationInstance?.approvalDate}"  style="FULL"/></td>
            </tr>
            <tr>
                <td style="font-weight:bold" width="30%">CI Name</td>
                <td width="70%">${creditInvestigationInstance?.ci?.username}</td>
            </tr>
            <tr>
                <td style="font-weight:bold" width="30%">Analyst Name</td>
                <td width="70%">${creditInvestigationInstance?.analyst?.username}</td>
            </tr>
        </g:if>
        <g:else>
            <tr>
                <td style="font-weight:bold" width="30%">Date Endorsed to Branch Department</td>
                <td width="70%"><g:formatDate format="MM/dd/yyyy" date="${creditInvestigationInstance?.folderReceivedByBranchDept}"  style="FULL"/></td>
            </tr>
            <tr>
                <td style="font-weight:bold" width="30%">Date Accepted By Branch Department</td>
                <td width="70%"><g:formatDate format="MM/dd/yyyy" date="${creditInvestigationInstance?.folderTransToCau}"  style="FULL"/></td>
            </tr>
            <tr>
                <td style="font-weight:bold" width="30%">Date Endorsed to Credit Manager</td>
                <td width="70%"><g:formatDate format="MM/dd/yyyy" date="${creditInvestigationInstance?.assignedToCi}"  style="FULL"/></td>
            </tr>
            <tr>
                <td style="font-weight:bold" width="30%">Date Endorsed to CRC</td>
                <td width="70%"><g:formatDate format="MM/dd/yyyy" date="${creditInvestigationInstance?.schedForCi}"  style="FULL"/></td>
            </tr>
            <tr>
                <td style="font-weight:bold" width="30%">Date of Endorsement for approval</td>
                <td width="70%"><g:formatDate format="MM/dd/yyyy" date="${creditInvestigationInstance?.performedCi}"  style="FULL"/></td>
            </tr>
            <tr>
                <td style="font-weight:bold" width="30%">Date approval of President</td>
                <td width="70%"><g:formatDate format="MM/dd/yyyy" date="${creditInvestigationInstance?.assignedToAnalyst}"  style="FULL"/></td>
            </tr>
             <tr>
                <td style="font-weight:bold" width="30%">Date Endorsement of approval to Branch</td>
                <td width="70%"><g:formatDate format="MM/dd/yyyy" date="${creditInvestigationInstance?.schedForAnalyst}"  style="FULL"/></td>
            </tr>
            <tr>
                <td style="font-weight:bold" width="30%" >Reason for Return</td>
                <td width="70%"><g:textArea class="form-control" name="xxReason" value="${creditInvestigationInstance?.recommendation}" rows="5" cols="80" disabled="disable"/></td>
            </tr>
             <tr>
                <td style="font-weight:bold" width="30%">Date Endorsed to Branch Department</td>
                <td width="70%"><g:formatDate format="MM/dd/yyyy" date="${creditInvestigationInstance?.performedByAnalyst}"  style="FULL"/></td>
            </tr>
            <tr>
                <td style="font-weight:bold" width="30%">Date Return to Branches Department </td>
                <td width="70%"><g:formatDate format="MM/dd/yyyy" date="${creditInvestigationInstance?.submitAnalystRep}"  style="FULL"/></td>
            </tr>
          
        </g:else>    
    </tbody>
</table>