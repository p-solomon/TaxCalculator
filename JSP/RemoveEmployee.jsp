<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<head>
<title>Remove Employee</title>
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
      <a class="navbar-brand" href="#">Remove Employee</a>
    </div>
    <ul class="nav navbar-nav">
       <li><a href="addEmployeePage">Add Employee</a></li>
       <li><a href="calculateTaxPage">Calculate Tax</a></li>
        <li><a href="viewAllEmployees">View All Employee Tax</a></li>
        <li><a href="viewTax">Tax For The Year</a></li>
        
    </ul>
    <ul class="nav navbar-nav navbar-right">
    <li> <span style="color:white;ma"><%=session.getAttribute("loggedInStaffNumber") %></span></li>
      <li><a href="logoutUser"><span></span> Logout</a></li>
      
    </ul>
  </div>
</nav>
  
<div class="container">
  <marquee>Remove Employee</marquee>
</div>


	<body>
	<div style="margin: 20px;">
		<h2>Staff Number: ${loggedInStaffNumber}</h2>


<title>Assginment3</title>
<style>
.error li {
	font-size: 20px;
	color: #990000;
	list-style: none;
	padding-right: 50px;
}
</style>

<style>
<!--

-->
.mainDiv
{
 height:400px;
 width:600px;
 background-color:#808080;
 margin-left:100px;
 margin-top:200px;
 border-radius:20px;
 border:2px soloid black;
}
.formDiv
{
 padding:50px;

}
.txtField
{
 height:35px;
 width:300px;
 border-radius:15px;
}
.label
{
color:white;
font-weight:bold;
}
.submitBtn
{
  height:40px;
  width:150px;
  border-radius:20px;
}
.registerBtn
{
  height:40px;
  width:100px;
  border-radius:20px;
}
.header
{
height:50px;
width:600px;
 background-color:black;
}
.textHeader
{
 font-size:25px;
 font-weight:bold;
 color:gray;
 margin-left:260px;
 margin-top:50px;
}
</style>
</head>

<div class="mainDiv">


<body>
<div class="header"><span class="textHeader">Remove Employee</span></div>
		<div class="form-group">
			<br> Remove Employee:
			<s:form action="/removeEmployeeForm" method="post">
				<s:textfield name="staffNumbertoremove" key="label.staffnumber"
					cssClass="txtField"/>
				<s:submit method="execute" key="label.remove" align="center"
					class="submitBtn" />
			</s:form>

			<div class="error">
				<s:actionerror />
			</div>
		</div>
		<br>
	</div>
</body>
</html>
