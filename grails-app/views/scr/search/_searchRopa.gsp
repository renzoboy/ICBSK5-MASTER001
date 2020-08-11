<g:javascript>
    var searchVar = new icbs.Utilities.Search("${createLink(controller:'scr', action:'search')}");
    $(document).ready(function() {
        $('#searchForm').on('submit', function(e){
            e.preventDefault();
        });
    });
</g:javascript>

<div name="inlineSearchDiv" id="inlineSearchDiv">
    <g:form id="searchForm" name="searchForm" url="[controller:scr, action:'search']">
    <div class="row">
        <div class="col-md-12">
            <div class=" col-md-2">
                <g:select name="max" value="${params.max}" from="[25 , 50 , 75 , 100]" class="form-control input-sm "onchange="searchVar.searchMe();" />
            </div>
            <div class="input-group col-md-10">
                <input id="query" name="query" type="text" class="form-control" value="${params?.query}">
                <span class="input-group-btn">
                    <a href="#" class="btn btn-primary" onclick="searchVar.searchMe();">Search</a>
                </span>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-md-12">
            <label class="radio-inline">
                <g:hiddenField name="searchType" value="0"/>
            </label>
        </div>
    </div>
    </g:form>

    <div id="grid">
        <div class="table-responsive">
            <table class="table table-hover table-condensed table-bordered table-striped">
                <tbody>
                    <tr>    
                        <g:sortableColumn property="id" title="${message(code: 'ROPA.id', default: 'ID')}" />
                        
                        <g:sortableColumn property="loanAcctNo" title="${message(code: 'ROPA.loanAcctNo.label', default: 'Loan Account')}" />
                        
                        <g:sortableColumn property="glContraLitigationExp" title="${message(code: 'ROPA.glContraLitigationExp.label', default: 'GL Contra Litigation')}" />
                        
                        <g:sortableColumn property="glContraRopa" title="${message(code: 'ROPA.glContraRopa.label', default: 'GL Contra ROPA')}" />

                        <g:sortableColumn property="glContraBldg" title="${message(code: 'ROPA.glContraBldg.label', default: 'GL Contra Building')}" />
                        
                        <g:sortableColumn property="loanBalance" title="${message(code: 'ROPA.loanBalance.label', default: 'Loan Balance')}" />

                        <td><label>Action</label></td>
                        
                        
                    </tr>
                </tbody>
                <tbody>
                    <g:each in="${domainInstanceList}" status="i" var="domainInstance">
                    <tr>
                        <td>${fieldValue(bean: domainInstance, field: "id")}</td>

                        <td>${domainInstance?.loanAcctNo}</td>
                        
                        <td>${domainInstance?.glContraLitigationExp}</td>
                        
                        <td>${domainInstance?.glContraRopa}</td>
                        
                        <td>${domainInstance?.glContraBldg}</td>
                        
                        <td>${domainInstance?.loanBalance}</td>
                        
                        <td> <input name="selectScr" id="idniya"  type="button"class="btn btn-secondary" data-dismiss="modal" onclick="var temp = confirm('Are you sure you want to select this loan application?'); if(temp){modal.addOnCloseCallbackParams('loanApplication2',${domainInstance?.id})}" value="Select"/></td>
                       
                    </tr>
                    </g:each>
                </tbody>
            </table>
        </div> 
        <div class="pagination">
            <g:paginate total="${domainInstanceCount ?: 0}"/>
        </div>
    </div>
</div> 
