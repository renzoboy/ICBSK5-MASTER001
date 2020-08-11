<table class="table table-bordered table-rounded table-striped table-hover">
    <g:hiddenField id="ropaLoan" name="ropaLoan" value="${ropapapapaInstance?.loan.id}" />
    <tbody>
        <tr>
            <td style="width:30%"><label>Cost Capitalized</label></td>
            <td style="width:70%"><g:formatNumber format="###,###,##0.00" number="${ropapapapaInstance?.costsCapitalized}"/></td>    
        </tr>  
        <tr>
            <td style="width:30%"><label>Provision Amount</label></td>
            <td style="width:70%"><g:formatNumber format="###,###,##0.00" number="${ropapapapaInstance?.provisionAmt}"/></td>    
        </tr>  
        <tr>
            <td style="width:30%"><label>Provision Rate</label></td>
            <td style="width:70%"><g:formatNumber format="###,###,##0.00" number="${ropapapapaInstance?.provisionRate}"/></td>    
        </tr>   
        <tr>
            <td style="width:30%"><label>Allocated Book Value Land</label></td>
            <td style="width:70%"><g:formatNumber format="###,###,##0.00" number="${ropapapapaInstance?.allocatedBookValueLand}"/></td>    
        </tr> 
        <tr>
            <td style="width:30%"><label>Allocated Book Value Building</label></td>
            <td style="width:70%"><g:formatNumber format="###,###,##0.00" number="${ropapapapaInstance?.allocatedBookValueBuilding}"/></td>    
        </tr> 
        <tr>
            <td style="width:30%"><label>Allocated Depreciation Building</label></td>
            <td style="width:70%"><g:formatNumber format="###,###,##0.00" number="${ropapapapaInstance?.accumulatedDepreciationBuilding}"/></td>    
        </tr> 
        <tr>
            <td style="width:30%"><label>Allowance for Probable losses Building</label></td>
            <td style="width:70%"><g:formatNumber format="###,###,##0.00" number="${ropapapapaInstance?.allowanceBuilding}"/></td>    
        </tr> 
        <tr>
            <td style="width:30%"><label>Other Costs</label></td>
            <td style="width:70%"><g:formatNumber format="###,###,##0.00" number="${ropapapapaInstance?.otherCosts}"/></td>    
        </tr> 
        <tr>
            <td style="width:30%"><label>Allowance for Probable Losses - Other Costs</label></td>
            <td style="width:70%"><g:formatNumber format="###,###,##0.00" number="${ropapapapaInstance?.allowanceOthers}"/></td>    
        </tr>                        
        <tr>
            <td style="width:30%"><label>Former Title</label></td>
            <td style="width:70%">${ropapapapaInstance?.formerTitle}</td>    
        </tr>                          
        <tr>
            <td style="width:30%"><label>Former Title</label></td>
            <td style="width:70%">${ropapapapaInstance?.kindOfLand}</td>    
        </tr>                        
        <tr>
            <td style="width:30%"><label>Land Area</label></td>
            <td style="width:70%"><g:formatNumber format="###,###,##0.00" number="${ropapapapaInstance?.landArea}"/></td>    
        </tr>  
        <tr>
            <td style="width:30%"><label>Location</label></td>
            <td style="width:70%">${ropapapapaInstance?.location}</td>    
        </tr>
        <tr>
            <td style="width:30%"><label>Date of Certificate</label></td>
            <td><g:formatDate  format="MM/dd/yyyy" date="${ropapapapaInstance?.dateOfCertificate}" /></td>    
        </tr>                        
        <tr>
            <td style="width:30%"><label>Date of Certificate Registration</label></td>
            <td><g:formatDate  format="MM/dd/yyyy" date="${ropapapapaInstance?.dateOfCertificateRegistration}" /></td>    
        </tr> 
        <tr>
            <td style="width:30%"><label>Date of Consolidation</label></td>
            <td><g:formatDate  format="MM/dd/yyyy" date="${ropapapapaInstance?.dateConsolidated}" /></td>    
        </tr> 
        <tr>
            <td style="width:30%"><label>New TCT</label></td>
            <td style="width:70%">${ropapapapaInstance?.newTct}</td>    
        </tr>                        
        <tr>
            <td style="width:30%"><label>Land Appraisal</label></td>
            <td style="width:70%"><g:formatNumber format="###,###,##0.00" number="${ropapapapaInstance?.landAppraisal}"/></td>    
        </tr>  
        <tr>
            <td style="width:30%"><label>Building Appraisal</label></td>
            <td style="width:70%"><g:formatNumber format="###,###,##0.00" number="${ropapapapaInstance?.buildingAppraisal}"/></td>    
        </tr>
        <tr>
            <td style="width:30%"><label>Other Appraisal</label></td>
            <td style="width:70%"><g:formatNumber format="###,###,##0.00" number="${ropapapapaInstance?.otherAppraisal}"/></td>    
        </tr>                
        <tr>
            <td style="width:30%"><label>Date of Appraisal</label></td>
            <td><g:formatDate  format="MM/dd/yyyy" date="${ropapapapaInstance?.dateOfAppraisal}" /></td>    
        </tr> 
        <tr>
            <td style="width:30%"><label>Appraised By</label></td>
            <td style="width:70%">${ropapapapaInstance?.appraisedBy}</td>    
        </tr>                          
        <tr>
            <td style="width:30%"><label>Fire Insurance Policy Number</label></td>
            <td style="width:70%">${ropapapapaInstance?.fireInsurancePolicyNo}</td>    
        </tr>                         
        <tr>
            <td style="width:30%"><label>Fire Insurance Amount</label></td>
            <td style="width:70%"><g:formatNumber format="###,###,##0.00" number="${ropapapapaInstance?.fireInsuranceAmt}"/></td>    
        </tr>                         
        <tr>
            <td style="width:30%"><label>Fire Insurance Date</label></td>
            <td><g:formatDate  format="MM/dd/yyyy" date="${ropapapapaInstance?.fireInsuranceDate}" /></td>    
        </tr>                         
        <tr>
            <td style="width:30%"><label>Fire Insurance Provision Amount</label></td>
            <td style="width:70%"><g:formatNumber format="###,###,##0.00" number="${ropapapapaInstance?.provisionForFireInsurance}"/></td>    
        </tr>                      
    </tbody>
</table>  