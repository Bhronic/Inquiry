<%@page import="com.inquiry.model.Course"%>
<%@page import="java.util.List"%>
<%@page import="com.inquiry.serviceImpl.CourseServiceImpl"%>
<%@page import="com.inquiry.service.CourseService"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML>
<html>
<head>
<title>Inquiry Form</title>

<style>
	.active3{
		background-color: black;
	}
</style>

<jsp:include page="files.jsp"/>

<script>

	$(document).ready(function() {
		GetAllProperties();

	});
	//document.getElementById('stu_course').value;
	
	function GetAllProperties() {
		$.getJSON('http://localhost:8085/courseList',
					function(json) {
						for (var i = 0; i < json.length; i++) {
							if("${inquiry.course }" != json[i].course_name)
							{
								$("#data-course-select").append(
										
									"<div class='checkbox-inline'><label><input type='checkbox' name='course' value='" +json[i].course_name +"'>" +json[i].course_name +"&emsp;&emsp;</label></div>");	
							}
							//<div class='checkbox-inline'><label><input type='checkbox' name='course'> Unchecked</label></div>		
						}
					});
	}
</script>

</head>



<body class="cbp-spmenu-push">

	<jsp:include page="NavBar.jsp"/>

	<!-- main content start-->
	<div id="page-wrapper">
		<div class="main-page">
			<div class="row">
				<h3 class="title1">Teacher :</h3>
				<div class=" grids-right widget-shadow">
				<ul id="myTabs" class="nav nav-tabs" role="tablist">
					<li role="presentation">
						<a href="#form" id="all-tab" role="tab" data-toggle="tab">Teacher Form</a>
					</li>
					<li role="presentation" class="active">
						<a href="#allTeachers" id="deleted-tab" role="tab" data-toggle="tab">View Teacher</a>
					</li>
				</ul>
				<div id="myTabContent" class="tab-content scrollbar1"> 
					<div role="tabpanel" class="tab-pane fade" id="form" aria-labelledby="all-tab"> 
						<p>
							<div class="tables">
								<div class="bs-example">
								<form class="form-horizontal" action="AddTeacherController" method="post" modelAttribute="teacher">
									<div class="form-group">
										<label for="focusedinput" class="col-sm-2 control-label">Teacher Name</label>
										<div class="col-sm-8">
											<input type="text" class="form-control1" id="focusedinput" name="teacher_name" placeholder="Enter Teacher Name" required>
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
										<label for="focusedinput" class="col-sm-2 control-label">Hourly Wage</label>
										<div class="col-sm-8">
											<input type="number" class="form-control1" id="focusedinput" name="hourly_wage" placeholder="Enter Hourly Wage" required>
										</div>
									</div>
									<div class="form-group">
										<label for="checkbox" class="col-sm-2 control-label">Course</label>
										<div class="col-sm-8" id="data-course-select">
										</div>
									</div>
									<div class="col-sm-offset-2">
										<button type="submit" class="btn btn-default">Submit</button>
										<button type="reset" class="btn btn-default" onClick="window.location.replace('index')">Cancel</button>
									</div><br><br>
								</form>
							</div>
						</div>
						</p> 
					</div>
					
					<div role="tabpanel" class="tab-pane fade active in" id="allTeachers" aria-labelledby="deleted-tab"> 
						<p>
							<div class="tables">
								<div class="bs-example" data-example-id="hoverable-table">
									<table class="table table-hover"> 
										<thead> 
											<tr> 
												<th>#</th> 
												<th>Teacher ID</th>
												<th>Name</th> 
												<th>Mobile Number</th> 
												<th>Qualification</th>
												<th>Hourly Wage</th>
												<th>Course</th> 
											</tr> 
										</thead>
										<tbody> 
											<c:set var="count" value="${0 }" />
											<c:forEach var="teacher" items="${teacherList }">
												<c:set var="count" value="${count + 1 }" />
												<tr>
													<th>${count }</th>
													<td>${teacher.ID }</td>
													<td>${teacher.teacher_name }</td>
													<td>${teacher.mob_no }</td>
													<td>${teacher.qualification }</td>
													<td>${teacher.hourly_wage }</td>
													<td>
														<select class="form-control1">
															<c:forEach var="teacherCourse" items="${teacher.courseList }">
																<option>${teacherCourse.course }</option>
															</c:forEach>
														</select>
													</td>
													<td><a href="StudentNewCourse?id=${teacher.ID }">Edit</a></td> 
													<td><a href="ViewStudentDetails?id=${teacher.ID }">Delete</a></td>
												</tr>
											</c:forEach>
											<c:if test="${count == 0}">
												<tr><td colspan="8" style="text-align: center;">No Records Found</td></tr>
											</c:if>
										</tbody>
									</table>
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