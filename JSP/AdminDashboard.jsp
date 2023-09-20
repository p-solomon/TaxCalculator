<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<head>
<title>Social Media App</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<style>
.error li {
	font-size: 20px;
	color: #990000;
	list-style: none;
	padding-right: 50px;
}
</style>

<!-- <a href="viewFrofile.jsp">View Profile</a>
<a href="viewAllUsers.jsp">View All Users</a> -->
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">Admin Dashboard</a>
    </div>
    <ul class="nav navbar-nav">
       <li><a href="addEmployeePage">Add Employee</a></li>
      <li><a href="calculateTaxPage">Calculate Tax</a></li>
        <li><a href="viewAllEmployees">View All Employee Tax</a></li>
        <li><a href="removeEmployee">Remove Employee</a></li>
        <li><a href="viewTax">Tax For The Year</a></li>
        
    </ul>
    <ul class="nav navbar-nav navbar-right">
    <li> <span style="color:white;ma"><%=session.getAttribute("loggedInStaffNumber") %></span></li>
      <li><a href="logoutUser"><span></span> Logout</a></li>
      
    </ul>
  </div>
</nav>
  
<div class="container">
  <marquee>Admin Dashboard</marquee>
</div>


	<body>
	<div style="margin: 20px;">
		<h2>Staff Number: ${loggedInStaffNumber}</h2>

<img src="https://techbullion.com/wp-content/uploads/2021/07/Payroll-Software.jpg"/>

</body>
</html>