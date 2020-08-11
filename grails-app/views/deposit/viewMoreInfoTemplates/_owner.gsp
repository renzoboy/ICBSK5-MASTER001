<div class="row" style="margin:auto">
    <div class="section-container">
        <fieldset>
            <legend class="section-header">Other Owners/Signatories</legend>
                <table class="table table-bordered table-striped">
                    <tbody>
                        <tr>
                            <td style="font-weight:bold" width="30%">Ownership Type</td>
                            <td width="75%">${depositInstance?.ownershipType?.description}</td>
                        </tr>
                        <tr>
                            <td style="font-weight:bold" width="30%">Signatory Rules</td>
                            <td width="75%">${depositInstance?.sigRules}</td>
                        </tr>
                        <tr>
                            <td style="font-weight:bold" width="30%">Signatory Remarks</td>
                            <td width="75%">${depositInstance?.sigRemarks}</td>
                        </tr>
                    </tbody>
                </table>    
                <div class="table-responsive col-md-12">
                    <g:if test="${depositInstance?.signatories?.size()>0}">
                        <table id="signatoryTable" class="table table-hover table-condensed table-striped">
                            <tr>
                                <td><label>CID</label></td>
                                <td><label>Name</label></td>
                                <td><label>Signatory</label></td>
                            </tr>
                            <tbody height="100px">
                                <div id="signatoryList">
                                    <g:each var="signatory" in="${depositInstance?.signatories}" status="i">
                                        <g:if test="${signatory.status.id!=3}">
                                            <g:render template='form/signatory/onetomany/signatory' model="[signatory:signatory,i:i,displayOnly:'true']"/>
                                        </g:if>
                                    </g:each>
                            </tbody>
                        </table>
                    </g:if>
                </div>
        </fieldset>
    </div>
</div>
