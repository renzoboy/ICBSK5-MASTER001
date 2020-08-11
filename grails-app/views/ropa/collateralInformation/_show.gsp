<%@ page import="icbs.loans.RopaCollateralDetails" %>
<%@ page import="icbs.loans.ROPA" %>
<%@ page import="icbs.loans.Collateral" %>

<html>
    <body>
<table class="table table-bordered table-rounded table-striped table-hover" id="tblRopaColl"> 
        <thead>
            <tr>
                <td><label>Collateral ID</label></td>
                <td><label>Reference Date</label></td>
                <td><label>Description</label></td>
                <td><label>Collateral Type</label></td>
                <td><label>Status</label></td>
                <td><label>Action</label></td>
                
            </tr>
        </thead>
    <tbody>
        <g:hiddenField id="ropaId" name="ropaId" value="${ropapapapaInstance?.id}" />
        <g:each in="${RopaCollateralDetails.findAllByRopa(ropapapapaInstance,[sort: "id", order: "asc"])}" status="i" var="ropaCollateralDetailsInstance">
            <g:if test="${ropaCollateralDetailsInstance?.collateral?.collateralType.id < 3}">
            <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
                <td>${ropaCollateralDetailsInstance?.collateral.id}</td>
                <g:hiddenField id="reymartID" name="reymartID" value="${ropaCollateralDetailsInstance?.collateral.id}" />
                <td><g:formatDate format="MM/dd/yyyy" date="${ropaCollateralDetailsInstance?.refDate}"/></td>
                <td>${ropaCollateralDetailsInstance?.collateral?.description}</td>
                <td>${ropaCollateralDetailsInstance?.collateral?.collateralType?.description}</td>
                <td>${ropaCollateralDetailsInstance?.status?.description}</td>
                
                <td><g:link class="btn btn-secondary" id="${ropaCollateralDetailsInstance?.id}" params="['ropaId': ropapapapaInstance?.id]" action="collateralShow" >View Details</g:link></td>                                                                     
                <%--<td><a onclick = "getRopaId(${ropaCollateralDetailsInstance?.id});">View</a><td> --%>
            </tr>
            </g:if>
        </g:each>
    </tbody>
</table>
<script>
    function getRopaId(x){
    console.log($('#ropaid').val())
    console.log(x)
    
    var ropaId = $('#ropaId').val();

    
        $.ajax({
            type: "POST",
            url: "${createLink(controller:'ropa', action:'collateralShow')}",
            data: {ropaId: ropaId},
            success: function(data){
            },
            error: function(data){

            },

        });
    }

</script>
</body>
</html>
