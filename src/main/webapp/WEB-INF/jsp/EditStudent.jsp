<%@page import="com.inquiry.model.StudentCourse"%>
<%@page import="java.util.List"%>
<%@page import="com.inquiry.model.StudentDetails"%>
<%@page import="com.inquiry.model.Student, java.util.Optional"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML>
<html>
<head>
<title>Edit Student</title>
<style type="text/css">
	.active6{
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
				for (var i = 0; i < json.length; i++) {
					$("#data-course-select").append("<option value='" +json[i].course_name +"'>" +json[i].course_name +"</option>");
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
	
<%
	StudentDetails student = (StudentDetails)request.getAttribute("student");
	List<StudentCourse> list11 = student.getStudentCourse();
	for(StudentCourse studentCourse :list11)
	{
		if(studentCourse.getStatus() == 0)
		{
%>
	
	<div id="page-wrapper">
		<div class="main-page">
			<div class="row">
				<h3 class="title1">Inquiry Form :</h3>
				<div class="form-three widget-shadow">
					<form class="form-horizontal" action="StudentEditController" method="post">
					<input type="hidden" class="form-control1" id="focusedinput" name="id" value="<%=student.getID() %>">
					<input type="hidden" class="form-control1" id="focusedinput" name="id1" value="<%=studentCourse.getID() %>">
						<div class="form-group">
							<label for="focusedinput" class="col-sm-2 control-label">Student Name</label>
							<div class="col-sm-8">
								<input type="text" class="form-control1" id="focusedinput" name="studentName" placeholder="Enter Student Name" value="<%=student.getStudent_name() %>" required>
							</div>
						</div>
						<div class="form-group">
							<label for="focusedinput" class="col-sm-2 control-label">Mobile Number</label>
							<div class="col-sm-8">
								<input type="number" class="form-control1" id="focusedinput" name="mobileNumber" placeholder="Enter Mobile Number" value="<%=student.getMob_no() %>" min="6000000000" max="9999999999" required>
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
								<input type="date" class="form-control1" id="focusedinput" name="birthDate" value="<%=student.getDob() %>" required>
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
								
									<option value="<%=studentCourse.getCourse() %>"><%=studentCourse.getCourse() %></option>
									
								</select>
							</div>
						</div>
						<div class="form-group">
							<label for="selector1" class="col-sm-2 control-label">Preferred Batch Time</label>
							<div class="col-sm-8">
								<select name="batchTime" id="selector1" class="form-control1">
									<option value="Morning" <%if(studentCourse.getBatch_time().equals("Morning")){ %>selected<%} %>>Morning</option>
									<option value="Afternoon" <%if(studentCourse.getBatch_time().equals("Afternoon")){ %>selected<%} %>>Afternoon</option>
									<option value="Evening" <%if(studentCourse.getBatch_time().equals("Evening")){ %>selected<%} %>>Evening</option>
								</select>
							</div>
						</div>
						<div class="form-group">
							<label for="focusedinput" class="col-sm-2 control-label">Date of Joining</label>
							<div class="col-sm-8">
								<input type="date" class="form-control1" id="focusedinput" name="joiningDate" value="<%=studentCourse.getJoining_date() %>" required>
							</div>
						</div>
						<div class="form-group">
							<label for="focusedinput" class="col-sm-2 control-label">Fees</label>
							<div class="col-sm-8">
								<input type="number" class="form-control1" id="focusedinput" name="fees" placeholder="Enter Fees" value="<%=studentCourse.getFees() %>" required>
							</div>
						</div>
						<div class="form-group">
							<label for="focusedinput" class="col-sm-2 control-label">Teacher Appointed</label>
							<div class="col-sm-8">
								<input type="text" class="form-control1" id="focusedinput" name="teacher_appointed" placeholder="Enter Teacher" value="<%=studentCourse.getTeacher() %>" required>
							</div>
						</div>
						<div class="col-sm-offset-2">
							<button type="submit" class="btn btn-default">Submit</button>
							<button type="reset" class="btn btn-default" onClick="window.location.replace('ViewStudentDetails?id=<%=student.getID() %>')">Cancel</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
<%	
		}
	}
%>
	<!-- main contents end -->

	<!--scrolling js-->
	<script src="js/jquery.nicescroll.js"></script>
	<script src="js/scripts.js"></script>
	<!--//scrolling js-->

</body>
</html>