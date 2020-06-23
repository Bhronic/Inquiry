<%@page import="com.inquiry.model.StudentCourse"%>
<%@page import="java.util.List"%>
<%@page import="com.inquiry.model.StudentDetails"%>
<%@page import="com.inquiry.model.Student, java.util.Optional"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML>
<html>
<head>
<title>Pay Fee</title>
<style type="text/css">
	.active7{
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
				<h3 class="title1">Pay Fee :</h3>
				<div class="form-three widget-shadow">
					<form class="form-horizontal" action="PayFeeController" method="post">
					<input type="hidden" class="form-control1" id="focusedinput" name="id" value="<%=student.getID() %>">
						<div class="form-group">
							<label for="focusedinput" class="col-sm-2 control-label">Student ID</label>
							<div class="col-sm-8">
								<input type="number" class="form-control1" id="focusedinput" name="id" value="<%=student.getID() %>" disabled>
							</div>
						</div>
						<div class="form-group">
							<label for="focusedinput" class="col-sm-2 control-label">Student Name</label>
							<div class="col-sm-8">
								<input type="hidden" class="form-control1" id="focusedinput" name="studentName" value="<%=student.getStudent_name() %>">
								<input type="text" class="form-control1" id="focusedinput" name="studentName" value="<%=student.getStudent_name() %>" disabled>
							</div>
						</div>
						<div class="form-group">
							<label for="focusedinput" class="col-sm-2 control-label">Course</label>
							<div class="col-sm-8">
								<input type="text" class="form-control1" id="focusedinput" name="course" value="<%=studentCourse.getCourse() %>" disabled>
							</div>
						</div>
						<div class="form-group">
							<label for="focusedinput" class="col-sm-2 control-label">Total Fees</label>
							<div class="col-sm-8">
								<input type="number" class="form-control1" id="focusedinput" name="totalFees" value="<%=studentCourse.getFees() %>" disabled>
							</div>
						</div>
						<div class="form-group">
							<label for="focusedinput" class="col-sm-2 control-label">Fees Paid</label>
							<div class="col-sm-8">
								<input type="number" class="form-control1" id="focusedinput" name="feesPaid" value="<%=studentCourse.getFeesPaid() %>" disabled>
							</div>
						</div>
						<div class="form-group">
							<label for="focusedinput" class="col-sm-2 control-label">Fees Left</label>
							<div class="col-sm-8">
								<input type="number" class="form-control1" id="focusedinput" value="<%=(studentCourse.getFees()-studentCourse.getFeesPaid()) %>" disabled>
							</div>
						</div>
						<div class="form-group">
							<label for="selector1" class="col-sm-2 control-label">Payment Method</label>
							<div class="col-sm-8">
								<select name="method" id="selector1" class="form-control1">
									<option value="Cash">Cash</option>
									<option value="Cheque">Cheque</option>
									<option value="Credit/Debit Card">Credit/Debit Card</option>
									<option value="Wallet">Wallet</option>
								</select>
							</div>
						</div>
						<div class="form-group">
							<label for="focusedinput" class="col-sm-2 control-label">Amount</label>
							<div class="col-sm-8">
								<input type="number" class="form-control1" id="focusedinput" name="amount" placeholder="Enter Amount" max="<%=(studentCourse.getFees()-studentCourse.getFeesPaid()) %>" required>
							</div>
						</div>
						<div class="col-sm-offset-2">
							<button type="submit" class="btn btn-default">Submit</button>
							<button type="reset" class="btn btn-default" onClick="window.location.replace('ViewFees')">Cancel</button>
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

</body>
</html>