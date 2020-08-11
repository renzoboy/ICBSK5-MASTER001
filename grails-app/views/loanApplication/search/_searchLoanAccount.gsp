
<g:javascript>
    var searchVar = new icbs.Utilities.Search("${createLink(controller:'loanApplication', action:'searchAccount')}");
    $(document).ready(function() {
        $('#searchForm').on('submit', function(e){
            e.preventDefault();
        });
    });
</g:javascript>

<div name="inlineSearchDiv" id="inlineSearchDiv">
    <g:form id="searchForm" name="searchForm" url="[controller:loanApplication, action:'searchAccount']">
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
                        <g:sortableColumn property="accntNumber" title="${message(code: 'loan.accntNumber', default: 'Account Number')}" />
                        
                        <g:sortableColumn property="customer.displayName" title="${message(code: 'loanApplication.customer.label', default: 'Customer Name')}" />
                    
                        <g:sortableColumn property="product.name" title="${message(code: 'loanApplication.address.label', default: 'Address')}" />

                        <g:sortableColumn property="amount" title="${message(code: 'loanApplication.dateGranted.label', default: 'Date Granted')}" />

                        <g:sortableColumn property="applicationDate" defaultOrder="desc" title="${message(code: 'loanApplication.maturityDate.label', default: 'Maturity Date')}" />

                         <g:sortableColumn property="applicationDate" title="${message(code: 'loanApplication.amountGranted.label', default: 'Amount Granted')}" />
                         
                         <g:sortableColumn property="applicationDate" title="${message(code: 'loanApplication.amountBalance.label', default: 'Account Balance')}" />
                        
                        <td><label>Action  <h3>${params.actionTemplate}</h3></label></td>
                    </tr>
                </tbody>
                <tbody>
                    <g:each in="${domainInstanceList}" status="i" var="domainInstance">
                    <tr>
                        <td>${domainInstance.accountNo}</td>
                        <td>${domainInstance.customer.displayName}</td>
                        <td>${domainInstance.customer.addresses.address1[0]} &nbsp ${domainInstance.customer.addresses.address2[0]}</td>
                        <td><g:formatDate format="MM/dd/yyyy" date="${domainInstance?.dateApproved}"/></td>
                        <td><g:formatDate format="MM/dd/yyyy" date="${domainInstance?.maturityDate}"/></td>
                        <td><g:formatNumber format="###,##0.00" number="${domainInstance?.grantedAmount}" /></td>
                        <td><g:formatNumber format="###,##0.00" number="${domainInstance?.balanceAmount}" /></td>
                        
                        <g:if test="${params.actionTemplate}">
                        <g:hiddenField id="actionTemplate" name="actionTemplate" value="${params.actionTemplate}"/>
                        <g:render template="actionTemplate/${params.actionTemplate}" model="[domainInstance:domainInstance]"/>
                        </g:if>
                        <g:else>
                        <td><input type="button"class="btn btn-secondary" data-dismiss="modal" onclick="var temp = confirm('Are you sure you want to select this loan application?'); if(temp){modal.addOnCloseCallbackParams('loanApplication2',${domainInstance?.id})}" value="Select"/></td>
                        </g:else>
                    </tr>
                    </g:each>
                </tbody>
            </table>
        </div> 
        <div class="pagination">
            <g:paginate total="${domainInstanceCount ?: 0}" params="${[sa:1]}"/>
        </div>
    </div>
</div>   