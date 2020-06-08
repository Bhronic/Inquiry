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
<title>Payment History</title>
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
		
		<div id="page-wrapper">
			<div class="main-page">
<%
	StudentDetails student = (StudentDetails)request.getAttribute("student");
	List<StudentCourse> list11 = student.getStudentCourse();
	for(StudentCourse studentCourse :list11)
	{
		if(studentCourse.getStatus() == 0)
		{
%>	
				<div class="tables">
					<h2 class="title1">Payment History</h2>
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
								<label for="focusedinput" class="col-sm-2 control-label">Fees</label>
								<div class="col-sm-8">
									<input type="number" class="form-control1" id="focusedinput" name="id" value="<%=studentCourse.getFees() %>" disabled>
								</div>
							</div>
						</form>
						<table class="table table-hover"> 
							<thead> 
								<tr> 
									<th>#</th>
									<th>ID</th> 
									<th>Date</th>
									<th>Amount</th> 
									<th>Method</th>
								</tr> 
							</thead> 
							<tbody>
<%
	List<Fees> list22 = student.getFeesTable();
	int count = 0;
	double total = 0;
	for(Fees fees :list22)
	{
		count++;
		total = total + fees.getFees_amount();
%>
								<tr>
									<th scope="row"><%=count %></th> 
									<td><%=fees.getID() %></td>
									<td><%=fees.getDate() %></td>
									<td><%=fees.getFees_amount() %></td> 
									<td><%=fees.getMethod() %></td>
								</tr>
<%	
 	} 
	if(list22.isEmpty()) 
	{
 %>
 	<tr><td colspan="6" style="text-align: center;">No Records Found</td></tr>
 <%
 	}
 %>
								<tr>
									<td></td>
									<td></td>
									<th>Total Fees Paid :</th>
									<td><%=total %></td>
									<td></td>
								</tr>
								<tr>
									<td></td>
									<td></td>
									<th>Fees Left :</th>
									<td><%=(studentCourse.getFees() - total) %></td>
									<td></td>
								</tr>
							</tbody> 
						</table>
						<button type="reset" class="btn btn-default" onClick="window.location.replace('index')">Home</button>
						<button type="reset" class="btn btn-default" onClick="window.location.replace('ViewStudentDetails?id=<%=student.getID() %>')">Back</button>
					</div>
				</div>
<%	
		}
	}
%>
			</div>
		</div>
		
		<!-- main contents end -->
	
	<!--scrolling js-->
	<script src="js/jquery.nicescroll.js"></script>
	<script src="js/scripts.js"></script>
	<!--//scrolling js-->
	
</body>
</html>