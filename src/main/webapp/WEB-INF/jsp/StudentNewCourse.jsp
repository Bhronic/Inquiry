<%@page import="com.inquiry.model.StudentDetails"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.inquiry.model.Inquiry, java.util.Optional"%>
<!DOCTYPE HTML>
<html>
<head>
<title>Student New Course</title>
<style type="text/css">
	.active6{
		background-color: black;
	}
</style>
<jsp:include page="files.jsp"/>
<script>

	$(document).ready(function() {
		GetAllProperties();

	});
	function GetAllProperties() {
		$.getJSON('http://localhost:8085/courseList',
					function(json) {
						for (var i = 0; i < json.length; i++) {
							$("#data-course-select").append(
									"<option value='" +json[i].course_name +"'>" +json[i].course_name +"</option>");
						}
					});
	}
</script>

</head>
<body class="cbp-spmenu-push">
	
<jsp:include page="NavBar.jsp"/>

	<!-- main content start-->
	
<%
	StudentDetails student = (StudentDetails)request.getAttribute("student");
%>
	
	<div id="page-wrapper">
		<div class="main-page">
			<div class="row">
				<h3 class="title1">Student Form :</h3>
				<div class="form-three widget-shadow">
					<form class="form-horizontal" action="StudentNewCourseController" method="post">
					<input type="hidden" class="form-control1" id="focusedinput" name="id" value="<%=student.getID() %>">
						<div class="form-group">
							<label for="focusedinput" class="col-sm-2 control-label">Student ID</label>
							<div class="col-sm-8">
								<input type="number" class="form-control1" id="focusedinput" name="id" value="<%=student.getID() %>" disabled>
							</div>
						</div>
						<div class="form-group">
							<label for="focusedinput" class="col-sm-2 control-label">Student Name</label>
							<div class="col-sm-8">
								<input type="text" class="form-control1" id="focusedinput" name="studentName" placeholder="Enter Student Name" value="<%=student.getStudent_name() %>" required>
							</div>
						</div>
						<div class="form-group">
							<label for="focusedinput" class="col-sm-2 control-label">Mobile Number</label>
							<div class="col-sm-8">
								<input type="number" class="form-control1" id="focusedinput" name="mobileNumber" placeholder="Enter Mobile Number" value="<%=student.getMob_no() %>" required>
							</div>
						</div>
						<div class="form-group">
							<label for="focusedinput" class="col-sm-2 control-label">Email Id</label>
							<div class="col-sm-8">
								<input type="email" class="form-control1" id="focusedinput" name="email" placeholder="Enter Email Id" value="<%=student.getEmail() %>" required>
							</div>
						</div>
						<div class="form-group">
							<label for="focusedinput" class="col-sm-2 control-label">Date of Birth</label>
							<div class="col-sm-8">
								<input type="date" class="form-control1" id="focusedinput" name="birthDate" value="<%=student.getDob() %>" disabled>
							</div>
						</div>
						<div class="form-group">
							<label for="focusedinput" class="col-sm-2 control-label">Address</label>
							<div class="col-sm-8">
								<input type="text" class="form-control1" id="focusedinput" name="address" placeholder="Enter Address" value="<%=student.getAddress() %>" required>
							</div>
						</div>
						<div class="form-group">
							<label for="focusedinput" class="col-sm-2 control-label">Qualification</label>
							<div class="col-sm-8">
								<input type="text" class="form-control1" id="focusedinput" name="qualification" placeholder="Enter Qualification" value="<%=student.getQualification() %>" required>
							</div>
						</div>
						<div class="form-group">
							<label for="selector1" class="col-sm-2 control-label">Course</label>
							<div class="col-sm-8">
								<select name="course" id="data-course-select" class="form-control1" >
									
								</select>
							</div>
						</div>
						<div class="form-group">
							<label for="selector1" class="col-sm-2 control-label">Preferred Batch Time</label>
							<div class="col-sm-8">
								<select name="batchTime" id="selector1" class="form-control1">
									<option value="Morning">Morning</option>
									<option value="Afternoon">Afternoon</option>
									<option value="Evening">Evening</option>
								</select>
							</div>
						</div>
						<div class="form-group">
							<label for="focusedinput" class="col-sm-2 control-label">Fees</label>
							<div class="col-sm-8">
								<input type="number" class="form-control1" id="focusedinput" name="fees" placeholder="Enter Fees" required>
							</div>
						</div>
						<div class="form-group">
							<label for="focusedinput" class="col-sm-2 control-label">Teacher Appointed</label>
							<div class="col-sm-8">
								<input type="text" class="form-control1" id="focusedinput" name="teacher_appointed" placeholder="Enter Teacher Appointed" required>
							</div>
						</div>
						<div class="col-sm-offset-2">
							<button type="submit" class="btn btn-default">Submit</button>
							<button type="reset" class="btn btn-default" onClick="window.location.replace('ViewStudent')">Cancel</button>
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