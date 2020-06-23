<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.inquiry.model.Inquiry, java.util.Optional"%>
<!DOCTYPE HTML>
<html>
<head>
<title>Student Form</title>
<style type="text/css">
	.active6{
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

<!-- Script to Display Course -->
<script>

	$(document).ready(function() {
		GetAllCourse();

	});
	
	function GetAllCourse() {
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

<!-- Script to Display Faculty -->
<script>

	$(document).ready(function() {
		GetAllFaculty();

	});
	
	function GetAllFaculty() {
		$.getJSON('http://localhost:8085/facultyList',
					function(json) {
						for (var i = 0; i < json.length; i++) {
							for(var j = 0; j < json[i].courseList.length; j++)
							{
								if(json[i].courseList[j].course == "${inquiry.course }")
								{
									$("#data-faculty-select").append(
										"<option value='" +json[i].faculty_name +"'>" +json[i].faculty_name +"</option>");
								}
							}
						}
					});
	}
</script>

<body class="cbp-spmenu-push">

<jsp:include page="NavBar.jsp"/>
	<!-- main content start-->
	
<%
	Inquiry inquiry = (Inquiry)request.getAttribute("inquiry");
%>
	
	<div id="page-wrapper">
		<div class="main-page">
			<div class="row">
				<h3 class="title1">Student Form :</h3>
				<div class="form-three widget-shadow">
					<form class="form-horizontal" action="StudentFormController" method="post">
					<input type="hidden" class="form-control1" id="focusedinput" name="id" value="<%=inquiry.getID() %>">
						<div class="form-group">
							<label for="focusedinput" class="col-sm-2 control-label">Student Name</label>
							<div class="col-sm-8">
								<input type="text" class="form-control1" id="focusedinput" name="studentName" placeholder="Enter Student Name" value="<%=inquiry.getStudent_name() %>" required>
							</div>
						</div>
						<div class="form-group">
							<label for="focusedinput" class="col-sm-2 control-label">Mobile Number</label>
							<div class="col-sm-8">
								<input type="number" class="form-control1" id="focusedinput" name="mobileNumber" placeholder="Enter Mobile Number" value="<%=inquiry.getMob_no() %>" required>
							</div>
						</div>
						<div class="form-group">
							<label for="focusedinput" class="col-sm-2 control-label">Email Id</label>
							<div class="col-sm-8">
								<input type="email" class="form-control1" id="focusedinput" name="email" placeholder="Enter Email Id" value="<%=inquiry.getEmail() %>" required>
							</div>
						</div>
						<div class="form-group">
							<label for="focusedinput" class="col-sm-2 control-label">Date of Birth</label>
							<div class="col-sm-8">
								<input type="date" class="form-control1" id="focusedinput" name="birthDate" value="<%=inquiry.getDob() %>" required>
							</div>
						</div>
						<div class="form-group">
							<label for="focusedinput" class="col-sm-2 control-label">Address</label>
							<div class="col-sm-8">
								<input type="text" class="form-control1" id="focusedinput" name="address" placeholder="Enter Address" value="<%=inquiry.getAddress() %>" required>
							</div>
						</div>
						<div class="form-group">
							<label for="focusedinput" class="col-sm-2 control-label">Qualification</label>
							<div class="col-sm-8">
								<input type="text" class="form-control1" id="focusedinput" name="qualification" placeholder="Enter Qualification" value="<%=inquiry.getQualification() %>" required>
							</div>
						</div>
						<div class="form-group">
							<label for="selector1" class="col-sm-2 control-label">Course</label>
							<div class="col-sm-8">
								<select name="course" id="data-course-select" class="form-control1" >
									<option value="<%=inquiry.getCourse() %>"><%=inquiry.getCourse() %></option>
								</select>
							</div>
						</div>
						<div class="form-group">
							<label for="selector1" class="col-sm-2 control-label">Preferred Batch Time</label>
							<div class="col-sm-8">
								<select name="batchTime" id="selector1" class="form-control1">
									<option value="Morning" <%if(inquiry.getBatch_time().equals("Morning")){ %>selected<%} %>>Morning</option>
									<option value="Afternoon" <%if(inquiry.getBatch_time().equals("Afternoon")){ %>selected<%} %>>Afternoon</option>
									<option value="Evening" <%if(inquiry.getBatch_time().equals("Evening")){ %>selected<%} %>>Evening</option>
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
							<label for="selector1" class="col-sm-2 control-label">Faculty Appointed</label>
							<div class="col-sm-8">
								<select name="course" id="data-faculty-select" class="form-control1">
									<option disabled selected>Select a Faculty</option>
								</select>
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