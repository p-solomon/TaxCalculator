<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<head>
<title>Employee Dashboard</title>
</head>

<body>
	<div style="margin: 20px;">
		<h2>Staff Number: ${loggedInStaffNumber}</h2>

		<div class="content">
			<table class="todoTable  table table-hover">

				<tr class="even">
				
					<th>Staff Number</th>
					<th>Year</th>
					<th>Gross Salary</th>
					<th>Tax Due</th>
					<th>Net Salary</th>
				</tr>
				<s:iterator value="employeeTaxList">
					<tr>
						<td><s:property value="staffNumber" /></td>
						<td><s:property value="year" /></td>
						<td><s:property value="grossSalary" /></td>
						<td><s:property value="taxDue" /></td>
						<td><s:property value="netSalary" /></td>
					</tr>
				</s:iterator>
				</tbody>
			</table>
		</div>

		<div class="form-group">
			<s:form action="/logoutUser" method="post">
				<s:submit method="execute" key="label.logout" align="center"
					class="btn btn-primary" />
			</s:form>
		</div>

	</div>
</body>
</html>