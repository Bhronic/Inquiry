<%@page import="com.inquiry.model.StudentCourse"%>
<%@page import="java.util.List"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML>
<html>
<head>
<title>Edit Student</title>
<style type="text/css">
	.active3{
		border-left: 3px solid #3c8dbc;
		background-color: black;
	}
</style>
<jsp:include page="files.jsp"/>
<!-- Script to Display Course -->
<script>

	$(document).ready(function() {
		GetAllProperties();

	});
	function GetAllProperties() {
		$.getJSON('http://localhost:8085/courseList',
				function(json) {
					for (var i = 0; i < json.length; i++){
						//if("${facultyCourse.course }" != json[i].course_name)
						//{
							$("#data-course-select").append(
									
								"<div class='checkbox-inline'><label><input type='checkbox' name='course' value='" +json[i].course_name +"'>" +json[i].course_name +"&emsp;&emsp;</label></div>");	
						//}	
					}
				});
	}
	
</script>

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
	<div id="page-wrapper">
		<div class="main-page">
			<div class="row">
				<h3 class="title1">Faculty Edit :</h3>
				<div class="form-three widget-shadow">
					<form class="form-horizontal" action="FacultyEditController" method="post" modelAttribute="faculty" modelAttribute="facultyCourse">
					<input type="hidden" class="form-control1" id="focusedinput" name="ID" value="${faculty.ID }">
						<div class="form-group">
							<label for="focusedinput" class="col-sm-2 control-label">Faculty ID</label>
							<div class="col-sm-8">
								<input type="number" class="form-control1" id="focusedinput" name="id1" value="${faculty.ID }" disabled>
							</div>
						</div>
						<div class="form-group">
							<label for="focusedinput" class="col-sm-2 control-label">Faculty Name</label>
							<div class="col-sm-8">
								<input type="text" class="form-control1" id="focusedinput" name="faculty_name" placeholder="Enter Student Name" value="${faculty.faculty_name }" required>
							</div>
						</div>
						<div class="form-group">
							<label for="focusedinput" class="col-sm-2 control-label">Mobile Number</label>
							<div class="col-sm-8">
								<input type="number" class="form-control1" id="focusedinput" name="mob_no" placeholder="Enter Mobile Number" value="${faculty.mob_no }" min="6000000000" max="9999999999" required>
							</div>
						</div>
						<div class="form-group">
							<label for="focusedinput" class="col-sm-2 control-label">Email Id</label>
							<div class="col-sm-8">
								<input type="email" class="form-control1" id="focusedinput" name="email" placeholder="Enter Email Id" value="${faculty.email }" required>
							</div>
						</div>
						<div class="form-group">
							<label for="focusedinput" class="col-sm-2 control-label">Date of Birth</label>
							<div class="col-sm-8">
								<input type="date" class="form-control1" id="focusedinput" name="dob" value="${faculty.dob }" required>
							</div>
						</div>
						<div class="form-group">
							<label for="focusedinput" class="col-sm-2 control-label">Address</label>
							<div class="col-sm-8">
								<input type="text" class="form-control1" id="focusedinput" name="address" placeholder="Enter Address" value="${faculty.address }" required>
							</div>
						</div>
						<div class="form-group">
							<label for="focusedinput" class="col-sm-2 control-label">Qualification</label>
							<div class="col-sm-8">
								<input type="text" class="form-control1" id="focusedinput" name="qualification" placeholder="Enter Qualification" value="${faculty.qualification }" required>
							</div>
						</div>
						<div class="form-group">
							<label for="checkbox" class="col-sm-2 control-label">Course</label>
							<div class="col-sm-8" id="data-course-select">
								<c:forEach var="facultyCourse" items="${faculty.courseList }">
									<div class='checkbox-inline'><label><input type='checkbox' name='course' value="${facultyCourse.course }" checked>${facultyCourse.course }</label></div>
								</c:forEach>
							</div>
						</div>
						<div class="form-group">
							<label for="focusedinput" class="col-sm-2 control-label">Hourly Wage</label>
							<div class="col-sm-8">
								<input type="number" class="form-control1" id="focusedinput" name="hourly_wage" placeholder="Enter Hourly Wage" value="${faculty.hourly_wage }" required>
							</div>
						</div>
						<div class="col-sm-offset-2">
							<button type="submit" class="btn btn-default">Submit</button>
							<button type="reset" class="btn btn-default" onClick="window.location.replace('ViewFaculty')">Cancel</button>
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