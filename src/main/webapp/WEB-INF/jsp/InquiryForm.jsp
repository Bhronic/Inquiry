<%@page import="com.inquiry.model.Course"%>
<%@page import="java.util.List"%>
<%@page import="com.inquiry.serviceImpl.CourseServiceImpl"%>
<%@page import="com.inquiry.service.CourseService"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML>
<html>
<head>
<title>Inquiry Form</title>
<style type="text/css">
	.active4{
		background-color: black;
	}
</style>
<jsp:include page="files.jsp"/>
</head>
<body class="cbp-spmenu-push">

	<jsp:include page="NavBar.jsp"/>

	<!-- main content start-->
	<div id="page-wrapper">
		<div class="main-page">
			<div class="row">
				<h3 class="title1">Inquiry Form :</h3>
				<div class="form-three widget-shadow">
					<form class="form-horizontal" action="InquiryFormController" method="post" modelAttribute="inquiry">
						<div class="form-group">
							<label for="focusedinput" class="col-sm-2 control-label">Student Name</label>
							<div class="col-sm-8">
								<input type="text" class="form-control1" id="focusedinput" name="student_name" placeholder="Enter Student Name" required>
							</div>
						</div>
						<div class="form-group">
							<label for="focusedinput" class="col-sm-2 control-label">Mobile Number</label>
							<div class="col-sm-8">
								<input type="number" class="form-control1" id="focusedinput" name="mob_no" placeholder="Enter Mobile Number" min="6000000000" max="9999999999" required>
							</div>
						</div>
						<div class="form-group">
							<label for="focusedinput" class="col-sm-2 control-label">Email Id</label>
							<div class="col-sm-8">
								<input type="email" class="form-control1" id="focusedinput" name="email" placeholder="Enter Email Id" required>
							</div>
						</div>
						<div class="form-group">
							<label for="focusedinput" class="col-sm-2 control-label">Date of Birth</label>
							<div class="col-sm-8">
								<input type="date" class="form-control1" id="focusedinput" name="dob" required>
							</div>
						</div>
						<div class="form-group">
							<label for="focusedinput" class="col-sm-2 control-label">Address</label>
							<div class="col-sm-8">
								<input type="text" class="form-control1" id="focusedinput" name="address" placeholder="Enter Address" required>
							</div>
						</div>
						<div class="form-group">
							<label for="focusedinput" class="col-sm-2 control-label">Qualification</label>
							<div class="col-sm-8">
								<input type="text" class="form-control1" id="focusedinput" name="qualification" placeholder="Enter Qualification" required>
							</div>
						</div>
						
						<div class="form-group">
							<label for="selector1" class="col-sm-2 control-label">Course</label>
							<div class="col-sm-8">
								<select name="course" id="selector1" class="form-control1">
								<%
									List<Course> list1 = (List<Course>) request.getAttribute("viewCourseList");
									if(list1 != null)
									{
										for(Course course :list1)
										{
								%>
											<option value="<%=course.getCourse_name() %>"><%=course.getCourse_name() %></option>
								<%
										}
									}
								%>
								</select>
							</div>
						</div>
						
						<div class="form-group">
							<label for="selector1" class="col-sm-2 control-label">Preferred Batch Time</label>
							<div class="col-sm-8">
								<select name="batch_time" id="selector1" class="form-control1">
									<option value="Morning">Morning</option>
									<option value="Afternoon">Afternoon</option>
									<option value="Evening">Evening</option>
								</select>
							</div>
						</div>
						<div class="form-group">
							<label for="focusedinput" class="col-sm-2 control-label">Date of Joining</label>
							<div class="col-sm-8">
								<input type="date" class="form-control1" id="focusedinput" name="joining_date" required>
							</div>
						</div>
						<div class="col-sm-offset-2">
							<button type="submit" class="btn btn-default">Submit</button>
							<button type="reset" class="btn btn-default" onClick="window.location.replace('index')">Cancel</button>
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