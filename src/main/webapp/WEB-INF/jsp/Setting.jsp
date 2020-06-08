<%@page import="com.inquiry.model.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.List" %>
<!DOCTYPE HTML>
<html>
<head>
<title>Settings</title>
<jsp:include page="files.jsp"/>
</head>
<body class="cbp-spmenu-push">
	
<jsp:include page="NavBar.jsp"/>
		
		<!-- main content start-->	
		<div id="page-wrapper">
			<div class="main-page">
				<div class="tables">
					<h2 class="title1">Settings</h2>
					<div class="bs-example widget-shadow" data-example-id="hoverable-table"> 
						<h4>Admins</h4>
						<input type="text" id="myInput" onkeyup="searchTable()" placeholder="Search..." title="Type in a name">
						<table class="table table-hover sortable" id="myTable">
							<thead> 
								<tr> 
									<th>#</th> 
									<th>Name</th>
									<th>Email</th> 
									<th>Gender</th> 
									<th>Username</th>
									<th>Password</th>
									<th>View Activity</th> 
									<th>Delete</th> 
								</tr> 
							</thead> 
							<tbody>
<%
	List<User> list1 = (List<User>) request.getAttribute("viewAllList");
	int count = 0;
	if(list1 != null)
	{
		for(User user :list1)
		{
		count++;
%>
 
								<tr>
									<th scope="row"><%=count %></th> 
									<td><%=user.getFname() +" " +user.getLname()%></td>
									<td><%=user.getEmail() %></td> 
									<td><%=user.getGender() %></td> 
									<td><%=user.getUsername() %></td>
									<td><%=user.getPassword() %></td>
									<td><a href="ViewActivity?admin=<%=user.getUsername() %>">View Activity</a></td>
									<td>
									<%
									int r = user.getUsername().compareTo("jaymodi99");
									if(r != 0)
									{
									%>
										<a href="AdminDeleteController?id=<%=user.getID() %>">Delete</a>
									<%
									}
									%>
									</td> 
								</tr>
<%}} %>
							</tbody> 
						</table>
						<button type="reset" class="btn btn-default" onClick="window.location.replace('index')">Home</button>
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