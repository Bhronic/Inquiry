<%@page import="java.time.temporal.ChronoUnit"%>
<%@page import="java.time.LocalDate"%>
<%@page import="com.inquiry.model.StudentCourse"%>
<%@page import="com.inquiry.model.StudentDetails"%>
<%@page import="com.inquiry.model.Student"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.List" %>
<!DOCTYPE HTML>
<html>
<head>
<title>Fees</title>
<style type="text/css">
	.active7{
		background-color: black;
	}
</style>
<jsp:include page="files.jsp"/>
</head>
<body class="cbp-spmenu-push">
	
<jsp:include page="NavBar.jsp"/>

		<!-- main content start-->	
		<div id="page-wrapper">
			<div class=" grids-right widget-shadow">
				<ul id="myTabs" class="nav nav-tabs" role="tablist">
					<li role="presentation">
						<a href="#all" id="all-tab" role="tab" data-toggle="tab">Fees Paid</a>
					</li>
					<li role="presentation">
						<a href="#deleted" id="deleted-tab" role="tab" data-toggle="tab">Fees Pending</a>
					</li> 
					<li role="presentation"class="active">
						<a href="#pending" role="tab" id="pending-tab" data-toggle="tab">Fees Due</a>
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
												<th>Student Name</th>
												<th>Student ID</th> 
												<th>Course</th> 
												<th>Total Fees</th> 
											</tr> 
										</thead>
<%
	List<StudentDetails> list1 = (List<StudentDetails>) request.getAttribute("viewFeesPaidList");
	int count = 0;
		for(StudentDetails student :list1)
		{
			List<StudentCourse> list11 = student.getStudentCourse();
			for(StudentCourse studentCourse :list11)
			{
				if(studentCourse.getStatus() == 0 && studentCourse.getFees() <= studentCourse.getFeesPaid())
				{
					count++;
%>
 
											<tr>
												<th scope="row"><%=count %></th>
												<td><%=student.getStudent_name() %></td> 
												<td><%=student.getID() %></td>
												<td><%=studentCourse.getCourse() %></td> 
												<td><%=studentCourse.getFees() %></td>
											</tr>
<%	
					break;
				}
			}
		}
	if(list1.isEmpty()) 
	{
 %>
 	<tr><td colspan="5" style="text-align: center;">No Records Found</td></tr>
 <%
 	}
 %>
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
												<th>Student Name</th>
												<th>Student ID</th> 
												<th>Course</th> 
												<th>Total Fees</th>
												<th>Fees Paid</th>
												<th>Fees Left</th>
											</tr> 
										</thead>
										<tbody>
<%
	List<StudentDetails> list2 = (List<StudentDetails>) request.getAttribute("viewFeesPendingList");
	count = 0;
		for(StudentDetails student :list2)
		{
			List<StudentCourse> list22 = student.getStudentCourse();
			for(StudentCourse studentCourse :list22)
			{
				if(studentCourse.getStatus() == 0 && studentCourse.getFees() > studentCourse.getFeesPaid())
				{
					count++;
					double feesLeft = (studentCourse.getFees() - studentCourse.getFeesPaid());
%>
 
											<tr>
												<th scope="row"><%=count %></th>
												<td><%=student.getStudent_name() %></td> 
												<td><%=student.getID() %></td>
												<td><%=studentCourse.getCourse() %></td> 
												<td><%=studentCourse.getFees() %></td>
												<td><%=studentCourse.getFeesPaid() %></td>
												<td><%=feesLeft %>
												<td><a href="PayFee?id=<%=student.getID() %>">Pay Fee</a></td>
											</tr>
<%	
					break;
				}
			}
		}
	if(list2.isEmpty()) 
	{
 %>
 	<tr><td colspan="7" style="text-align: center;">No Records Found</td></tr>
 <%
 	}
 %>
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
												<th>Student Name</th>
												<th>Student ID</th> 
												<th>Course</th> 
												<th>Total Fees</th>
												<th>Fees Paid</th>
												<th>Fees Left</th>
											</tr> 
										</thead>
										<tbody>
<%
	List<StudentDetails> list3 = (List<StudentDetails>) request.getAttribute("viewFeesDueList");
	count = 0;
		for(StudentDetails student :list3)
		{
			List<StudentCourse> list33 = student.getStudentCourse();
			for(StudentCourse studentCourse :list33)
			{
				LocalDate localDate = LocalDate.now();
				LocalDate lastDate = studentCourse.getLast_fees_paid().toLocalDate();
				long days = ChronoUnit.DAYS.between(lastDate, localDate);
				if(studentCourse.getStatus() == 0 && studentCourse.getFees() > studentCourse.getFeesPaid() && days > 7)
				{
					count++;
					double feesLeft = (studentCourse.getFees() - studentCourse.getFeesPaid());
%>
 
											<tr>
												<th scope="row"><%=count %></th> 
												<td><%=student.getStudent_name() %></td> 
												<td><%=student.getID() %></td>
												<td><%=studentCourse.getCourse() %></td> 
												<td><%=studentCourse.getFees() %></td>
												<td><%=studentCourse.getFeesPaid() %></td>
												<td><%=feesLeft %></td>
												<td><a href="PayFee?id=<%=student.getID() %>">Pay Fee</a></td> 
											</tr>
<%	
					break;
				}
			}
		}
	if(count == 0) 
	{
 %>
 	<tr><td colspan="7" style="text-align: center;">No Records Found</td></tr>
 <%
 	}
 %>
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