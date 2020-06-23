<%@page import="com.inquiry.model.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML>
<html>
<head>
<title>Profile</title>
<jsp:include page="files.jsp"/>
</head>
<%
	session=request.getSession(false);  
	String uname=(String)session.getAttribute("uname");
	if(uname == null) 
	{
		response.sendRedirect("Login");
	}
%>
<body class="cbp-spmenu-push">

	<jsp:include page="NavBar.jsp"/>

	<!-- main content start-->
<%
	User user = (User)request.getAttribute("user");
%>	
	<div id="page-wrapper">
		<div class="main-page">
			<div class="row">
				<h3 class="title1">Profile :</h3>
				<div class="form-three widget-shadow">
					<form class="form-horizontal" action="InquiryEditController">
						<div class="form-group">
							<label for="focusedinput" class="col-sm-2 control-label">Name</label>
							<div class="col-sm-8">
								<input type="text" class="form-control1" id="focusedinput" value="<%=user.getFname() +" " +user.getLname() %>" disabled>
							</div>
						</div>
						<div class="form-group">
							<label for="focusedinput" class="col-sm-2 control-label">Email</label>
							<div class="col-sm-8">
								<input type="text" class="form-control1" id="focusedinput" value="<%=user.getEmail() %>" disabled>
							</div>
						</div>
						<div class="form-group">
							<label for="focusedinput" class="col-sm-2 control-label">Gender</label>
							<div class="col-sm-8">
								<input type="text" class="form-control1" id="focusedinput" value="<%=user.getGender() %>" disabled>
							</div>
						</div>
						<div class="form-group">
							<label for="focusedinput" class="col-sm-2 control-label">Username</label>
							<div class="col-sm-8">
								<input type="text" class="form-control1" id="focusedinput" value="<%=user.getUsername() %>" disabled>
							</div>
						</div>
						<div class="col-sm-offset-2">
							<button type="reset" class="btn btn-default" onClick="window.location.replace('index')">Home</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<!-- main contents end -->

	<!--scrolling js-->
	<script src="js/jquery.nicescroll.js"></script>
	<script src="js/scripts.js"></script>
	<!--//scrolling js-->

</body>
</html>