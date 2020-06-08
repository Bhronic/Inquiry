<%@page import="com.inquiry.model.Course"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>View Course</title>
<style type="text/css">
	.active2{
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
				<div class="tables">
					<h2 class="title1">Course</h2>
					<div class="bs-example widget-shadow" data-example-id="hoverable-table"> 
						<h4>Add Course</h4>
						<form class="form-horizontal" action="AddCourseController" method="post">
							<div class="form-group mb-n">
								<div class="row">
									<div class="col-md-2 grid_box1">
										<input type="number" class="form-control1" id="focusedinput" name="courseID" placeholder="Enter Course ID" required>
									</div>
									<div class="col-md-2 grid_box1">
										<input type="text" class="form-control1" id="focusedinput" name="courseName" placeholder="Enter Course Name" required>
									</div>
									<button type="submit" class="btn btn-default col-md-1">Add</button>
								</div>
							</div>	
						</form>
					</div>
					<div class="bs-example widget-shadow" data-example-id="hoverable-table"> 
						<h4>Course List</h4>
						<input type="text" id="myInput" onkeyup="searchTable()" placeholder="Search..." title="Type in a name">
						<table class="table table-hover sortable" id="myTable">
							<thead> 
								<tr> 
									<th>#</th> 
									<th>Course ID</th>
									<th>Course Name</th>
								</tr> 
							</thead> 
							<tbody>
<%
	List<Course> list1 = (List<Course>) request.getAttribute("viewCourseList");
	int count = 0;
	if(list1 != null)
	{
		for(Course course :list1)
		{
			count++;
%>
 
								<tr>
									<th scope="row"><%=count %></th> 
									<td><%=course.getCourse_id() %></td>
									<td><%=course.getCourse_name() %></td> 
									<td><a href="EditCourse?id=<%=course.getID() %>">Edit</a></td> 
									<td><a href="CourseDeleteController?id=<%=course.getID() %>">Delete</a></td>
								</tr>
<%}} %>
							</tbody> 
						</table>
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