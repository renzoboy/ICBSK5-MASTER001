<%@ page import="icbs.loans.Loan" %>
<!DOCTYPE html>

<html>
    <head>
	<meta name="layout" content="main">
	<title>Sales Contract Receivables</title>
    </head>
    <body>
        <content tag="breadcrumbs">
                <span class="fa fa-chevron-right"></span><span class="current">ROPA</span>
        </content>
	<content tag="main-content">
            <div id="list-ropaSaleDetailsInstance" class="content scaffold-list" role="main">
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<g:form class="form-inline" url="[action:'indexScr',controller:'ropa']" method="POST">
				<div class="form-group">
					<g:select name="max" value="${params.max}" from="[5, 10, 15, 20]" class="form-control input-sm pull-left"onchange="this.form.submit()" />
				</div>
				<div class="right">
					<div class="form-group">
						<g:textField  type="text" name="query" class="form-control input-sm pull-right" style="width: 250px;" placeholder="Search By Account No"/>
					</div>
					<g:submitButton name="Search" class="btn btn-sm btn-default"><i class="fa fa-search"></i></g:submitButton>
				</div>
			</g:form>

			<div class="table-responsive">
                <table class="table table-bordered table-rounded table-striped table-hover">
                    <thead>
                        <tr>
                            <td><label>SCR Acct No</label></td>
                            <td><label>Reference Date</label></td>
                            <td><label>Borrower Name</label></td>
                            <td><label>Status</label></td>
                            <td><label>SCR Amount</label></td>
                            <td><label>Total Sale Amount</label></td>
                            <td><label>Action</label></td>       
                        </tr>
                    </thead>
                    <tbody>     
                        <g:each in="${ropaSaleDetailsList}" status="i" var="ropaSaleDetailsInstance">
                            <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
                                <td>${ropaSaleDetailsInstance?.loan?.accountNo}</td>
                                <g:hiddenField id="reymartID" name="reymartID" value="${ropaSaleDetailsInstance?.collateral.id}" />
                                <td><g:formatDate format="MM/dd/yyyy" date="${ropaSaleDetailsInstance?.txnFile?.txnDate}"/></td>
                                <td>${ropaSaleDetailsInstance?.loan?.customer?.displayName}</td>
                                <td>${ropaSaleDetailsInstance?.loan?.status?.description}</td>
                                <td><g:formatNumber format="###,###,##0.00" number="${ropaSaleDetailsInstance?.scrAmount}"/></td>
                                <td><g:formatNumber format="###,###,##0.00" number="${ropaSaleDetailsInstance?.saleAmount}"/></td>
                                <td><g:link class="btn btn-secondary" controller="loan" action="show" id="${Loan.findByLoanApplication(ropaSaleDetailsInstance?.loanApplication).id}">View Details</g:link></td>                                
                                </tr>
                        </g:each>
                        </tbody>
                    </table>
                     </div>
			<div class="pagination">
				<g:paginate total="${ropaSaleDetailsInstanceCount ?: 0}" params="${params}" />
			</div>
		</div>
        </content>	
		
        <content tag="main-actions">
            <ul>
               <li><g:link controller="home" action="landing">Home</g:link></li>
               <li><g:link controller="loanApplication" action="createScr">New Sales Contract Receivable Application</g:link></li>																											  
               <li><g:link action="index">List of ROPA</g:link></li>
               <!--<li><g:link action="ropaForTransfer">List of ROPA Sold</g:link></li> -->
               <!-- <li><g:link action="printRopaSchedule">Print Schedule of ROPA</g:link></li> -->
           </ul>
       </content>
    </body>
</html>
