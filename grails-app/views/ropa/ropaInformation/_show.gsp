<%@ page import="icbs.gl.GlAccount" %>
<table class="table table-bordered table-rounded table-striped table-hover">
    <g:hiddenField id="ropaLoan" name="ropaLoan" value="${ropapapapaInstance?.loan.id}" />
                    <tbody>
                        <tr>
                            <td style="width:30%"><label>Branch</label></td>
                            <td style="width:70%">${ropapapapaInstance?.branch?.name}</td>
                        </tr>
                        <tr>
                            <td style="width:30%"><label>Acquired From</label></td>
                            <td style="width:70%">${ropapapapaInstance?.acquiredFrom?.displayName}</td>
                        </tr>
                        <tr>
                            <td style="width:30%"><label>ROPA Date</label></td>
                            <td><g:formatDate  format="MM/dd/yyyy" date="${ropapapapaInstance?.ropaDate}" /></td>
                        </tr>
                        <tr>
                            <td style="width:30%"><label>Loan Account Number</label></td>
                            <td style="width:70%">${ropapapapaInstance?.loan?.accountNo}</td>
                        </tr>
                        <tr>
                            <td style="width:30%"><label>ROPA Land GL Account</label></td>
                            <td style="width:70%">${ropapapapaInstance?.glContraRopa} - ${GlAccount.findByCode(ropapapapaInstance?.glContraRopa).name}</td>
                        </tr>
                        <tr>
                            <td style="width:30%"><label>ROPA Building GL Account</label></td>
                            <td style="width:70%">${ropapapapaInstance?.glContraBldg} -  ${GlAccount.findByCode(ropapapapaInstance?.glContraBldg).name}</td>
                        </tr>
                        <tr>
                            <td style="width:30%"><label>Accumulated Depreciation Building GL</label></td>
                            <td style="width:70%">${ropapapapaInstance?.accumulatedDepreciation} - ${GlAccount.findByCode(ropapapapaInstance?.accumulatedDepreciation).name}</td>
                        </tr>
                        <tr>
                            <td style="width:30%"><label>Other Properties Acquired GL</label></td>
                            <td style="width:70%">${ropapapapaInstance?.otherGl} - ${GlAccount.findByCode(ropapapapaInstance?.otherGl).name}</td>
                        </tr>
                        <tr>
                            <td style="width:30%"><label>Accumulated Depreciation Other Properties Acquired GL </label></td>
                            <td style="width:70%">${ropapapapaInstance?.otherAccumlated} - ${GlAccount.findByCode(ropapapapaInstance?.otherAccumlated).name}</td>
                        </tr>
                        <tr>
                            <td style="width:30%"><label>Gain on Sale of ROPA GL</label></td>
                            <td style="width:70%">${ropapapapaInstance?.ropaIncome} - ${GlAccount.findByCode(ropapapapaInstance?.ropaIncome).name}</td>
                        </tr>
                        <tr>
                            <td style="width:30%"><label>Litigation Expense GL Account</label></td>
                            <td style="width:70%">${ropapapapaInstance?.glContraLitigationExp} - ${GlAccount.findByCode(ropapapapaInstance?.glContraLitigationExp).name}</td>
                        </tr>

                        <tr>
                            <td style="width:30%"><label>Created by</label></td>
                            <td style="width:70%">${ropapapapaInstance?.createdBy?.username}</td>
                        </tr>
                        <tr>
                            <td style="width:30%"><label>Date Created</label></td>
                            <td><g:formatDate  format="MM/dd/yyyy" date="${ropapapapaInstance?.runDateCreated}" /></td>
                        </tr>
                    </tbody>
                </table>  
