<%@page import="com.inquiry.model.StudentCourse"%>
<%@page import="com.inquiry.model.StudentDetails"%>
<%@page import="com.inquiry.model.Fees"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.List" %>
    <%@page import="com.inquiry.model.Student, java.util.Optional"%>
<!DOCTYPE HTML>
<html>
<head>
<title>Course History</title>
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
		
		<div id="page-wrapper">
			<div class="main-page">
<%
	StudentDetails student = (StudentDetails)request.getAttribute("student");
	List<StudentCourse> list11 = student.getStudentCourse();
%>
				<div class="tables">
					<h2 class="title1">Course History</h2>
					<div class="bs-example widget-shadow" data-example-id="hoverable-table">
						<form class="form-horizontal" action="">
							<div class="form-group">
								<label for="focusedinput" class="col-sm-2 control-label">Student ID</label>
								<div class="col-sm-8">
									<input type="number" class="form-control1" id="focusedinput" name="id" value="<%=student.getID() %>" disabled>
								</div>
							</div>
							<div class="form-group">
								<label for="focusedinput" class="col-sm-2 control-label">Student Name</label>
								<div class="col-sm-8">
									<input type="text" class="form-control1" id="focusedinput" value="<%=student.getStudent_name() %>" disabled>
								</div>
							</div>
							<div class="form-group">
								<label for="focusedinput" class="col-sm-2 control-label">Total Course</label>
								<div class="col-sm-8">
									<input type="number" class="form-control1" id="focusedinput" name="id" value="<%=student.getTotal_course() %>" disabled>
								</div>
							</div>
							<div class="form-group">
								<label for="focusedinput" class="col-sm-2 control-label">Course Completed</label>
								<div class="col-sm-8">
									<input type="number" class="form-control1" id="focusedinput" name="id" value="<%=student.getCourse_completed() %>" disabled>
								</div>
							</div>
						</form>
						<table class="table table-hover"> 
						<thead> 
								<tr> 
									<th>#</th>
									<th>Joining Date</th> 
									<th>Course</th>
									<th>Teacher</th> 
									<th>Status</th>
									<th>Completion Date</th> 
									<th>Score</th>
									<th>Certificate Given</th>
								</tr> 
							</thead> 
							<tbody>
<%
	int count = 0;
	for(StudentCourse studentCourse :list11)
	{
		count++;
%>	
						
							
								<tr>
									<th scope="row"><%=count %></th> 
									<td><%=studentCourse.getJoining_date() %></td>
									<td><%=studentCourse.getCourse() %></td>
									<td><%=studentCourse.getTeacher() %></td> 
									<td><%if(studentCourse.getStatus() == 0){ %><%="Current" %><%} else if(studentCourse.getStatus() == 1){ %><%="Completed" %><%} else{ %><%="Discontinued" %><%} %></td>
									<td><%if(studentCourse.getStatus() != 0){ %><%=studentCourse.getCompletion_date() %><%} else{ %><%="-" %><%} %></td>
									<td><%if(studentCourse.getStatus() == 1){ %><%=studentCourse.getScore() %><%} else{ %><%="-" %><%} %></td>
									<td><%if(studentCourse.getStatus() == 1 && studentCourse.getCertificate() == 1){ %><%="Yes" %><%} else if(studentCourse.getStatus() == 1 && studentCourse.getCertificate() == 0){ %><%="No" %><%} else{ %><%="-" %><%} %></td>
								</tr>
<%	
	}
%>
							</tbody> 							
						</table>
						<button type="reset" class="btn btn-default" onClick="window.location.replace('index')">Home</button>
						<button type="reset" class="btn btn-default" onClick="window.location.replace('ViewStudentDetails?id=<%=student.getID() %>')">Back</button>
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