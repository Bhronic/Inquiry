<%@page import="org.springframework.http.HttpHeaders"%>
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

<!-- Script to Display Faculty -->
<script>

	$(document).ready(function() {
		GetAllProperties();

	});
	
	function GetAllProperties() {
		$.getJSON('http://localhost:8085/facultyList?',
					function(json) {
						for (var i = 0; i < json.length; i++) {
								$("#data-faculty-select").append(
									"<option value='" +json[i].id +"'>" +json[i].faculty_name +"</option>");
						}
					});
	}
</script>

<!-- Script to Display Course -->
<script>

	$(document).ready(function() {
		GetAllCourse();

	});
	
	function GetAllCourse() {
		$.getJSON('http://localhost:8085/coursePage',
					function(json) {
						for (var i = 0; i < json.length; i++) {
								$("#data-course-display").append(
									"<tr>"
										+"<th scope='row'>" +(i+1) +"</th>" 
										+"<td>" +json[i].course_id +"</td>"
										+"<td>" +json[i].course_name +"</td>" 
										+"<td><a href='EditCourse?id=" +json[i].ID +"'>Edit</a></td>" 
										+"<td><a href='CourseDeleteController?id=" +json[i].course_id +"'>Delete</a></td>"
									+"</tr>");
						}
					});
	}
</script>

<!-- Script to Search Course -->
<script>	
	function CourseSearch(search) {
		$("#data-course-display").empty();
		if (search.length == 0) { 
		    GetAllCourse();
		  }
		else {
		$.getJSON('http://localhost:8085/courseSearch?search='+search,
					function(json) {
						for (var i = 0; i < json.length; i++) {
								$("#data-course-display").append(
									"<tr>"
										+"<th scope='row'>" +(i+1) +"</th>" 
										+"<td>" +json[i].course_id +"</td>"
										+"<td>" +json[i].course_name +"</td>" 
										+"<td><a href='EditCourse?id=" +json[i].ID +"'>Edit</a></td>" 
										+"<td><a href='CourseDeleteController?id=" +json[i].course_id +"'>Delete</a></td>"
									+"</tr>");
						}
					});
		}
	}
</script>

<body class="cbp-spmenu-push">
	
	<jsp:include page="NavBar.jsp"/>
		
		<!-- main content start-->	
		<div id="page-wrapper">
			<div class="main-page">
				<div class="row">
					<h3 class="title1">Faculty :</h3>
					<div class=" grids-right widget-shadow">
						<ul id="myTabs" class="nav nav-tabs" role="tablist">
							<li role="presentation">
								<a href="#form" id="all-tab" role="tab" data-toggle="tab">Add Course</a>
							</li>
							<li role="presentation" class="active">
								<a href="#allTeachers" id="deleted-tab" role="tab" data-toggle="tab">View Course</a>
							</li>
						</ul>
						<div id="myTabContent" class="tab-content"> 
							<div role="tabpanel" class="tab-pane fade" id="form" aria-labelledby="all-tab"> 
								<p>
									<div class="tables">
										<div class="bs-example">
											<form class="form-horizontal" action="AddCourseController" method="post">
												<div class="form-group mb-n">
													<div class="row">
														<div class="col-md-2 grid_box1">
															<input type="number" class="form-control1" id="focusedinput" name="courseID" placeholder="Enter Course ID" required>
														</div>
														<div class="col-md-2 grid_box1">
															<input type="text" class="form-control1" id="focusedinput" name="courseName" placeholder="Enter Course Name" required>
														</div>
														<div class="col-md-2 grid_box1">
															<select name="faculty" id="data-faculty-select" class="form-control1" multiple>
															</select>
														</div>
														<button type="submit" class="btn btn-default col-md-1">Add</button>
													</div>
												</div>	
											</form>
										</div>
									</div>
								</p> 
							</div>
							
							<div role="tabpanel" class="tab-pane fade active in" id="allTeachers" aria-labelledby="deleted-tab"> 
								<p>
									<div class="tables">
										<div class="bs-example" data-example-id="hoverable-table">
											<input type="text" id="myInput" onkeyup="CourseSearch(this.value)" placeholder="Search..." title="Type in a name">
											<table class="table table-hover"> 
												<thead> 
													<tr> 
														<th>#</th> 
														<th>Course ID</th>
														<th>Course Name</th>
													</tr> 
												</thead> 
												<tbody id="data-course-display">
												</tbody> 
											</table>
											<ul class="pagination">
												<li class="disabled"><a href="#">«</a></li>
												<li class="active"><a href="#">1</a></li>
												<li><a href="#">2</a></li>
												<li><a href="#">3</a></li>
												<li><a href="#">4</a></li>
												<li><a href="#">5</a></li>
												<li><a href="#">»</a></li>
											</ul>
										</div>
									</div>
								</p> 
							</div>
						</div>				
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