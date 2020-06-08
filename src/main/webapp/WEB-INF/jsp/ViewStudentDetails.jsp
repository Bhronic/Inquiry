<%@page import="com.inquiry.model.StudentCourse"%>
<%@page import="java.util.List"%>
<%@page import="com.inquiry.model.StudentDetails"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.inquiry.model.Student, java.util.Optional"%>
<!DOCTYPE HTML>
<html>
<head>
<title>Student Details</title>
<style type="text/css">
	.active6{
		background-color: black;
	}
</style>
<jsp:include page="files.jsp"/>
</head>
<body class="cbp-spmenu-push">
	
<jsp:include page="NavBar.jsp"/>

	<!-- main content start-->
<%
	StudentDetails student = (StudentDetails)request.getAttribute("student");
	List<StudentCourse> list11 = student.getStudentCourse();
%>
	<div id="page-wrapper">
		<div class="main-page">
			<div class="row">
				<h3 class="title1">Student Details :</h3>
				<div class="form-three widget-shadow">
					<form class="form-horizontal" action="">
					<div class="form-group">
							<label for="focusedinput" class="col-sm-2 control-label">ID</label>
							<div class="col-sm-8">
								<input type="number" class="form-control1" id="focusedinput" name="id" value="<%=student.getID() %>" disabled>
							</div>
						</div>
						<div class="form-group">
							<label for="focusedinput" class="col-sm-2 control-label">Name</label>
							<div class="col-sm-8">
								<input type="text" class="form-control1" id="focusedinput" value="<%=student.getStudent_name() %>" disabled>
							</div>
						</div>
						<div class="form-group">
							<label for="focusedinput" class="col-sm-2 control-label">Mobile Number</label>
							<div class="col-sm-8">
								<input type="number" class="form-control1" id="focusedinput" value="<%=student.getMob_no() %>" disabled>
							</div>
						</div>
						<div class="form-group">
							<label for="focusedinput" class="col-sm-2 control-label">Email</label>
							<div class="col-sm-8">
								<input type="email" class="form-control1" id="focusedinput" value="<%=student.getEmail() %>" disabled>
							</div>
						</div>
						<div class="form-group">
							<label for="focusedinput" class="col-sm-2 control-label">Date of Birth</label>
							<div class="col-sm-8">
								<input type="date" class="form-control1" id="focusedinput" value="<%=student.getDob() %>" disabled>
							</div>
						</div>
						<div class="form-group">
							<label for="focusedinput" class="col-sm-2 control-label">Address</label>
							<div class="col-sm-8">
								<input type="text" class="form-control1" id="focusedinput" value="<%=student.getAddress() %>" disabled>
							</div>
						</div>
<%
	if(student.getDel() == 1)
	{
%>
						<div class="form-group">
							<label for="focusedinput" class="col-sm-2 control-label">Total Course</label>
							<div class="col-sm-8">
								<input type="number" class="form-control1" id="focusedinput" value="<%=student.getTotal_course() %>" disabled>
							</div>
						</div>
						<div class="form-group">
							<label for="focusedinput" class="col-sm-2 control-label">Course Completed</label>
							<div class="col-sm-8">
								<input type="number" class="form-control1" id="focusedinput" value="<%=student.getCourse_completed() %>" disabled>
							</div>
						</div>
<%
	}
	for(StudentCourse studentCourse :list11)
	{
		if(studentCourse.getStatus() == 0)
		{
%>	
						<div class="form-group">
							<label for="focusedinput" class="col-sm-2 control-label">Qualification</label>
							<div class="col-sm-8">
								<input type="text" class="form-control1" id="focusedinput" value="<%=student.getQualification() %>" disabled>
							</div>
						</div>
						<div class="form-group">
							<label for="focusedinput" class="col-sm-2 control-label">Course</label>
							<div class="col-sm-8">
								<input type="text" class="form-control1" id="focusedinput" value="<%=studentCourse.getCourse() %>" disabled>
							</div>
						</div>
						<div class="form-group">
							<label for="focusedinput" class="col-sm-2 control-label">Batch Time</label>
							<div class="col-sm-8">
								<input type="text" class="form-control1" id="focusedinput" value="<%=studentCourse.getBatch_time() %>" disabled>
							</div>
						</div>
						<div class="form-group">
							<label for="focusedinput" class="col-sm-2 control-label">Joining Date</label>
							<div class="col-sm-8">
								<input type="date" class="form-control1" id="focusedinput" value="<%=studentCourse.getJoining_date() %>" disabled>
							</div>
						</div>
						<div class="form-group">
							<label for="focusedinput" class="col-sm-2 control-label">Teacher Appointed</label>
							<div class="col-sm-8">
								<input type="text" class="form-control1" id="focusedinput" value="<%=studentCourse.getTeacher() %>" disabled>
							</div>
						</div>
						<div class="form-group">
							<label for="focusedinput" class="col-sm-2 control-label">Fees</label>
							<div class="col-sm-8">
								<input type="number" class="form-control1" id="focusedinput" value="<%=studentCourse.getFees() %>" disabled>
							</div>
						</div>
						<div class="form-group">
							<label for="focusedinput" class="col-sm-2 control-label">Fees Paid</label>
							<div class="col-sm-8">
								<input type="text" class="form-control1" id="focusedinput" value="<%=studentCourse.getFeesPaid() %>" disabled>
							</div>
						</div>
						<div class="col-sm-offset-2">
							<button type="reset" class="btn btn-default" onClick="window.location.replace('EditStudent?id=<%=student.getID() %>')">Edit</button>
							<button type="reset" class="btn btn-default" onClick="window.location.replace('ViewPaymentHistory?id=<%=student.getID() %>')">View Payment History</button>
<%	
		}
	}
%>
							<button type="reset" class="btn btn-default" onClick="window.location.replace('ViewCourseHistory?id=<%=student.getID() %>')">View Course History</button>
							<button type="reset" class="btn btn-default" onClick="window.location.replace('ViewStudent')">Back</button>
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