<%@page import="com.inquiry.model.StudentCourse"%>
<%@page import="java.util.List"%>
<%@page import="com.inquiry.model.StudentDetails"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML>
<html>
<head>
<title>Update Status</title>
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
				<h3 class="title1">Update Status :</h3>
				<div class="form-three widget-shadow">
					<form class="form-horizontal" action="UpdateStudentStatusController" method="post">
					<input type="hidden" class="form-control1" id="focusedinput" name="id" value="<%=student.getID() %>">
						<div class="form-group">
							<label for="focusedinput" class="col-sm-2 control-label">Date of Joining</label>
							<div class="col-sm-8">
								<input type="date" class="form-control1" id="focusedinput" name="joiningDate" value="<%=studentCourse.getJoining_date() %>" disabled>
							</div>
						</div>
						<div class="form-group">
							<label for="focusedinput" class="col-sm-2 control-label">Student Name</label>
							<div class="col-sm-8">
								<input type="text" class="form-control1" id="focusedinput" name="studentName" value="<%=student.getStudent_name() %>" disabled>
							</div>
						</div>
						<div class="form-group">
							<label for="focusedinput" class="col-sm-2 control-label">Mobile Number</label>
							<div class="col-sm-8">
								<input type="number" class="form-control1" id="focusedinput" name="mobileNumber" value="<%=student.getMob_no() %>" disabled>
							</div>
						</div>
						<div class="form-group">
							<label for="focusedinput" class="col-sm-2 control-label">Course</label>
							<div class="col-sm-8">
								<input type="text" class="form-control1" id="focusedinput" name="course" value="<%=studentCourse.getCourse() %>" disabled>
							</div>
						</div>
						<div class="form-group">
							<label for="focusedinput" class="col-sm-2 control-label">Teacher Appointed</label>
							<div class="col-sm-8">
								<input type="text" class="form-control1" id="focusedinput" name="teacherAppointed" value="<%=studentCourse.getTeacher() %>" disabled>
							</div>
						</div>
						<div class="form-group">
							<label for="focusedinput" class="col-sm-2 control-label">Fees</label>
							<div class="col-sm-8">
								<input type="number" class="form-control1" id="focusedinput" name="fees" value="<%=studentCourse.getFees() %>" disabled>
							</div>
						</div>
						<div class="form-group">
							<label for="focusedinput" class="col-sm-2 control-label">Fees Paid</label>
							<div class="col-sm-8">
								<input type="number" class="form-control1" id="focusedinput" name="feesPaid" value="<%=studentCourse.getFeesPaid() %>" disabled>
							</div>
						</div>
						<div class="form-group">
							<label for="selector1" class="col-sm-2 control-label">Choose Status</label>
							<div class="col-sm-8">
<!-- 								<select name="status" id="selector1" class="form-control1"> -->
<!-- 									<option value="1">Completed</option> -->
<!-- 									<option value="2">Discontinue</option> -->
<!-- 								</select> -->
								<div class="form-control1">
									<label>
										<input type="radio" name="status" value="1" required>
										Completed
									</label>
									<label>
										<input type="radio" name="status" value="2" required>
										Discontinue
									</label>
								</div>
							</div>
						</div>
						<div class="form-group">
							<label for="focusedinput" class="col-sm-2 control-label">Score</label>
							<div class="col-sm-8">
								<input type="number" class="form-control1" id="focusedinput" name="score"placeholder="Enter Score (Enter 0 if Discontinued)" required>
							</div>
						</div>
						<div class="form-group">
							<label for="selector1" class="col-sm-2 control-label">Certificate Given</label>
							<div class="col-sm-8">
<!-- 								<select name="certificate" id="selector1" class="form-control1"> -->
<!-- 									<option value="0">No</option> -->
<!-- 									<option value="1">Yes (Only if Course is Completed)</option> -->
<!-- 								</select> -->
								<div class="form-control1">
									<label>
										<input type="radio" name="certificate" value="1" required>
										Yes
									</label>
									<label>
										<input type="radio" name="certificate" value="0" required>
										No
									</label>
								</div>
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
<%
		}
	}
%>
	<!-- main contents end -->

	<!--scrolling js-->
	<script src="js/jquery.nicescroll.js"></script>
	<script src="js/scripts.js"></script>
	<!--//scrolling js-->
	
	<!--Confirm Delete javaScript-->
	<script>
		function submitConfirm() {
			var r = confirm("Fees not Paid");
			if (r == false) {
				document.getElementById("submitConfirm").href="#";
			  } else{
				  document.getElementById("submitConfirm").href="#";
			  }
		}
	</script>

</body>
</html>