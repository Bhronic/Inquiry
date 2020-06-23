<%@page import="com.inquiry.model.Activity"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.List" %>
<!DOCTYPE HTML>
<html>
<head>
<title>View Activity</title>
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
			<div class="main-page">
				<div class="tables">
					<h2 class="title1">View Activity</h2>
					<div class="bs-example widget-shadow" data-example-id="hoverable-table"> 
						<h4>Table</h4>
						<input type="text" id="myInput" onkeyup="searchTable()" placeholder="Search..." title="Type in a name">
						<table class="table table-hover sortable" id="myTable"> 
							<thead> 
								<tr> 
									<th>#</th> 
									<th>Admin</th>
									<th>Date & Time</th> 
									<th>Type</th> 
									<th>Description</th> 
								</tr> 
							</thead> 
							<tbody>
<%
	List<Activity> list1 = (List<Activity>) request.getAttribute("activityList");
	int count = 0;
		for(Activity activity :list1)
		{
		count++;
%>
 
								<tr>
									<th scope="row"><%=count %></th> 
									<td><%=activity.getAdminName() %></td>
									<td><%=activity.getDate_time() %></td> 
									<td><%=activity.getType() %></td> 
									<td><%=activity.getDescription() %></td>
									</tr>
<%	
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
						<button type="reset" class="btn btn-default" onClick="window.location.replace('index')">Home</button>
						<button type="reset" class="btn btn-default" onClick="window.location.replace('Setting')">Back</button>
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