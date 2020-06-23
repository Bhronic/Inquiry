<%@page import="com.inquiry.model.Course"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML>
<html>
<head>
<title>Edit Inquiry</title>
<style type="text/css">
	.active2{
		border-left: 3px solid #3c8dbc;
		background-color: black;
	}
</style>

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
	Course course = (Course) request.getAttribute("course");
	%>
	
	<div id="page-wrapper">
		<div class="main-page">
			<div class="row">
				<h3 class="title1">Course Edit Form :</h3>
				<div class="form-three widget-shadow">
					<form class="form-horizontal" action="CourseEditController" method="post">
					<input type="hidden" class="form-control1" id="focusedinput" name="id" value="<%=course.getID() %>">
						<div class="form-group">
							<label for="focusedinput" class="col-sm-2 control-label">Course ID</label>
							<div class="col-sm-8">
								<input type="number" class="form-control1" id="focusedinput" name="courseID" value="<%=course.getCourse_id() %>" required>
							</div>
						</div>
						<div class="form-group">
							<label for="focusedinput" class="col-sm-2 control-label">Course Name</label>
							<div class="col-sm-8">
								<input type="text" class="form-control1" id="focusedinput" name="courseName" placeholder="Enter Student Name" value="<%=course.getCourse_name() %>" required>
							</div>
						</div>
						<div class="col-sm-offset-2">
							<button type="submit" class="btn btn-default">Submit</button>
							<button type="reset" class="btn btn-default" onClick="window.location.replace('ViewCourse')">Cancel</button>
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