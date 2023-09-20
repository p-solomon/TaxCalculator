<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<title>Assginment3</title>
</head>


<style>
<!--

-->
.mainDiv
{
 height:400px;
 width:600px;
 background-color:#808080;
 margin-left:400px;
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
  width:100px;
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
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css" />



<div class="mainDiv">

<body>
<div class="header"><span class="textHeader">Register</span></div>
		<s:actionerror />
		
		
		
		<s:form action="/registerForm" method="post">

			<div class="form-group">
				<s:textfield name="staffNumber" key="label.staffnumber" cssClass="txtField"/>
			</div>

			<div class="form-group">
				<s:textfield name="username" label="Name" cssClass="txtField"/>
			</div>

			<div class="form-group">
				<s:password name="password" key="label.password" cssClass="txtField"/>
			</div>

			<div class="form-check">
				<s:radio label="User Role" key="label.userrole" name="userRole"
					list="#{'1':'Admin','2':'User'}" value="2" />
			</div>

			<div class="form-group">
				<s:submit method="execute" key="label.register" class="registerBtn" />
			</div>

		</s:form>
	</div>
</body>
</html>