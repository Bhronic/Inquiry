<%@page import="com.inquiry.model.StudentCourse"%>
<%@page import="com.inquiry.model.StudentDetails"%>
<%@page import="com.inquiry.model.Student"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<!DOCTYPE HTML>
<html>
<head>
<title>View Student</title>
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
		<div id="page-wrapper">
			<div class=" grids-right widget-shadow">
				<ul id="myTabs" class="nav nav-tabs" role="tablist">
					<li role="presentation">
						<a href="#all" id="all-tab" role="tab" data-toggle="tab">All Students</a>
					</li>
					<li role="presentation">
						<a href="#deleted" id="deleted-tab" role="tab" data-toggle="tab">Past Students</a>
					</li> 
					<li role="presentation"class="active">
						<a href="#pending" role="tab" id="pending-tab" data-toggle="tab">Current Students</a>
					</li> 
				</ul>
				<div id="myTabContent" class="tab-content scrollbar1"> 
					<div role="tabpanel" class="tab-pane fade" id="all" aria-labelledby="all-tab"> 
						<p>
							<div class="tables">
								<div class="bs-example" data-example-id="hoverable-table">
									<table class="table table-hover"> 
										<thead> 
											<tr> 
												<th>#</th> 
												<th>ID</th>
												<th>Student Name</th> 
												<th>Mobile Number</th> 
												<th>Total Courses</th>
												<th>Course Completed</th> 
											</tr> 
										</thead>
										<tbody>

											<c:set var="count" value="${0 }" />
											<c:forEach var = "student" items = "${viewAllList}">
												<c:set var="count" value="${count + 1 }" />
												<tr>
													<th>${count }</th>
													<td>${student.ID }</td>
													<td>${student.student_name }</td>
													<td>${student.mob_no }</td>
													<td>${student.total_course }</td>
													<td>${student.course_completed }</td>
													<td><a href="ViewStudentDetails?id=${student.ID }">View Details</a></td>
												</tr>
											</c:forEach>
											<c:if test="${count == 0}">
												<tr><td colspan="6" style="text-align: center;">No Records Found</td></tr>
											</c:if>
										</tbody> 
									</table>
								</div>
							</div>
						</p> 
					</div>
					
					<div role="tabpanel" class="tab-pane fade" id="deleted" aria-labelledby="deleted-tab"> 
						<p>
							<div class="tables">
								<div class="bs-example" data-example-id="hoverable-table">
									<table class="table table-hover"> 
										<thead> 
											<tr> 
												<th>#</th> 
												<th>Student ID</th>
												<th>Student Name</th> 
												<th>Mobile Number</th> 
												<th>Total Course</th>
												<th>Course Completed</th> 
											</tr> 
										</thead>
										<tbody> 
											<c:set var="count" value="${0 }" />
											<c:forEach var = "student" items = "${viewDeletedList}">
												<c:set var="count" value="${count + 1 }" />
												<tr>
													<th>${count }</th>
													<td>${student.ID }</td>
													<td>${student.student_name }</td>
													<td>${student.mob_no }</td>
													<td>${student.total_course }</td>
													<td>${student.course_completed }</td>
													<td><a href="StudentNewCourse?id=${student.ID }">New Course</a></td> 
													<td><a href="ViewStudentDetails?id=${student.ID }">View Details</a></td>
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
					
					
					<div role="tabpanel" class="tab-pane fade active in" id="pending" aria-labelledby="pending-tab"> 
						<p>
							<div class="tables">
								<div class="bs-example " data-example-id="hoverable-table">
								<input type="text" id="myInput" onkeyup="searchTable()" placeholder="Search..." title="Type in a name">
									<table class="table table-hover sortable" id="myTable"> 
										<thead> 
											<tr> 
												<th>#</th> 
												<th>Date of Joining</th>
												<th>Student Name</th> 
												<th>Mobile Number</th> 
												<th>Course</th>
												<th>Teacher Appointed</th>
												<th>Update Course Status</th>
											</tr> 
										</thead>
										<tbody>
											<c:set var="count" value="${0 }" />
											<c:forEach var = "student" items = "${viewPendingList}">
												<c:set var="count" value="${count + 1 }" />
												<c:forEach var ="studentCourse" items = "${student.studentCourse}">
													<c:if test="${studentCourse.status == 0}">
														<tr>
															<th>${count }</th>
															<td>${studentCourse.joining_date }</td>
															<td>${student.student_name }</td>
															<td>${student.mob_no }</td>
															<td>${studentCourse.course }</td>
															<td>${studentCourse.teacher }</td>
															<td><a <c:if test="${studentCourse.fees > studentCourse.feesPaid}"> onclick="alert('Fees not Paid')" href="#"</c:if> href="UpdateStudentStatus?id=${student.ID }">Update</a></td> 
															<td><a href="ViewStudentDetails?id=${student.ID }">View Details</a></td>
														</tr>			
													</c:if>
												</c:forEach>
											</c:forEach>
											<c:if test="${count == 0}">
												<tr><td colspan="8" style="text-align: center;">No Records Found</td></tr>
											</c:if>
										</tbody> 
									</table>
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