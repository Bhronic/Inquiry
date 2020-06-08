<%@page import="com.inquiry.model.Course"%>
<%@page import="java.util.List"%>
<%@page import="com.inquiry.model.Inquiry, java.util.Optional"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE HTML>
<html>
<head>
<title>Edit Inquiry</title>
<style type="text/css">
	.active5{
		background-color: black;
	}
</style>

<jsp:include page="files.jsp"/>

</head>

<!-- Script to Display Course -->
<script>

	$(document).ready(function() {
		GetAllProperties();

	});
	
	function GetAllProperties() {
		$.getJSON('http://localhost:8085/courseList',
					function(json) {
						for (var i = 0; i < json.length; i++) {
							if("${inquiry.course }" != json[i].course_name)
							{
								$("#data-course-select").append(
								
									"<option value='" +json[i].course_name +"'>" +json[i].course_name +"</option>");	
							}
									
						}
					});
	}
</script>

<body class="cbp-spmenu-push">

	<jsp:include page="NavBar.jsp"/>

	<!-- main content start-->
	
	
	<div id="page-wrapper">
		<div class="main-page">
			<div class="row">
				<h3 class="title1">Inquiry Edit :</h3>
				<div class="form-three widget-shadow">
					<form class="form-horizontal" action="InquiryEditController" method="post" modelAttribute="inquiry">
						<input type="hidden" class="form-control1" id="focusedinput" name="ID" value="${inquiry.ID }">
						<div class="form-group">
							<label for="focusedinput" class="col-sm-2 control-label">Date of Inquiry</label>
							<div class="col-sm-8">
								<input type="date" class="form-control1" id="focusedinput" name="inquiry_date" value="${inquiry.inquiry_date }" required>
							</div>
						</div>
						<div class="form-group">
							<label for="focusedinput" class="col-sm-2 control-label">Student Name</label>
							<div class="col-sm-8">
								<input type="text" class="form-control1" id="focusedinput" name="student_name" placeholder="Enter Student Name" value="${inquiry.student_name }" required>
							</div>
						</div>
						<div class="form-group">
							<label for="focusedinput" class="col-sm-2 control-label">Mobile Number</label>
							<div class="col-sm-8">
								<input type="number" class="form-control1" id="focusedinput" name="mob_no" placeholder="Enter Mobile Number" value="${inquiry.mob_no }" min="6000000000" max="9999999999" required>
							</div>
						</div>
						<div class="form-group">
							<label for="focusedinput" class="col-sm-2 control-label">Email Id</label>
							<div class="col-sm-8">
								<input type="email" class="form-control1" id="focusedinput" name="email" placeholder="Enter Email Id" value="${inquiry.email }" required>
							</div>
						</div>
						<div class="form-group">
							<label for="focusedinput" class="col-sm-2 control-label">Date of Birth</label>
							<div class="col-sm-8">
								<input type="date" class="form-control1" id="focusedinput" name="dob" value="${inquiry.dob }" required>
							</div>
						</div>
						<div class="form-group">
							<label for="focusedinput" class="col-sm-2 control-label">Address</label>
							<div class="col-sm-8">
								<input type="text" class="form-control1" id="focusedinput" name="address" placeholder="Enter Address" value="${inquiry.address }" required>
							</div>
						</div>
						<div class="form-group">
							<label for="focusedinput" class="col-sm-2 control-label">Qualification</label>
							<div class="col-sm-8">
								<input type="text" class="form-control1" id="focusedinput" name="qualification" placeholder="Enter Qualification" value="${inquiry.qualification }" required>
							</div>
						</div>
						<div class="form-group">
							<label for="selector1" class="col-sm-2 control-label">Course</label>
							<div class="col-sm-8">
								<select name="course" id="data-course-select" class="form-control1" >
	 								<option value="${inquiy.course }">${inquiry.course }</option>
								</select>
							</div>
						</div>
						<div class="form-group">
							<label for="selector1" class="col-sm-2 control-label">Preferred Batch Time</label>
							<div class="col-sm-8">
								<select name="batch_time" id="selector1" class="form-control1">
									<option value="${inquiry.batch_time }">${inquiry.batch_time }</option>
									<option value="Morning">Morning</option>
									<option value="Afternoon">Afternoon</option>
									<option value="Evening">Evening</option>	
								</select>
							</div>
						</div>
						<div class="form-group">
							<label for="focusedinput" class="col-sm-2 control-label">Date of Joining</label>
							<div class="col-sm-8">
								<input type="date" class="form-control1" id="focusedinput" name="joining_date" value="${inquiry.joining_date }" required>
							</div>
						</div>
						<div class="col-sm-offset-2">
							<button type="submit" class="btn btn-default">Submit</button>
							<button type="reset" class="btn btn-default" onClick="window.location.replace('ViewInquiry')">Cancel</button>
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