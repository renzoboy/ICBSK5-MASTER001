<legend>Audit Logs</legend>

<div class="table-responsive">
    <table class="table table-hover table-condensed table-bordered table-striped">
        <tbody>
			<tr>
				<td><label>Date</label></td>
				<td><label>Description</label></td>
                                <td><label>Processed By</label></td>
			</tr>
		</tbody>
		<tbody>
		<g:each in="${auditLogsList}" status="i" var="auditLogInstance">
			<tr>
				<td><g:formatDate  date="${auditLogInstance?.date}"/></td>
				<td>${auditLogInstance?.description}</td>
                                <td>${auditLogInstance?.userMaster?.name1 +' '+auditLogInstance?.userMaster?.name2 +' '+auditLogInstance?.userMaster?.name3}</td>

			</tr>
		</g:each>
		</tbody>
	</table>
</div>
			