<%@page import="com.inquiry.model.Inquiry"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.List" %>
<!DOCTYPE HTML>
<html>
<head>
<title>View Inquiry</title>
<style type="text/css">
	.active5{
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
						<a href="#all" id="all-tab" role="tab" data-toggle="tab">All Inquiries</a>
					</li>
					<li role="presentation">
						<a href="#deleted" id="deleted-tab" role="tab" data-toggle="tab">Deleted Inquiries</a>
					</li> 
					<li role="presentation"class="active">
						<a href="#pending" role="tab" id="pending-tab" data-toggle="tab">Pending Inquiries</a>
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
												<th>Date of Joining</th>
												<th>Student Name</th> 
												<th>Mobile Number</th> 
												<th>Course</th>
												<th>Date of Inquiry</th> 
											</tr> 
										</thead>
										<tbody>
<%
	List<Inquiry> list1 = (List<Inquiry>) request.getAttribute("viewAllList");
	int count = 0;
 	for(Inquiry inquiry :list1)
 	{
		count++;
%>
 
											<tr>
												<th scope="row"><%=count %></th> 
												<td><%=inquiry.getJoining_date() %></td>
												<td><%=inquiry.getStudent_name() %></td> 
												<td><%=inquiry.getMob_no() %></td> 
												<td><%=inquiry.getCourse() %></td>
												<td><%=inquiry.getInquiry_date() %></td>
											</tr>
<%	
 	} 
	if(list1.isEmpty()) 
	{
 %>
 	<tr><td colspan="6" style="text-align: center;">No Records Found</td></tr>
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
												<th>Date of Joining</th>
												<th>Student Name</th> 
												<th>Mobile Number</th> 
												<th>Course</th>
												<th>Date of Inquiry</th>
											</tr> 
										</thead>
										<tbody>
<%
	List<Inquiry> list2 = (List<Inquiry>)request.getAttribute("viewDeletedList");
	count = 0;
 	for(Inquiry inquiry :list2)
 	{
		count++;
%>
 
											<tr>
												<th scope="row"><%=count %></th> 
												<td><%=inquiry.getJoining_date() %></td>
												<td><%=inquiry.getStudent_name() %></td> 
												<td><%=inquiry.getMob_no() %></td> 
												<td><%=inquiry.getCourse() %></td>
												<td><%=inquiry.getInquiry_date() %></td>
												<td><a href="RetrieveInquiryController?id=<%=inquiry.getID() %>">Retrieve Inquiry</a></td>
											</tr>
<%	
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
												<th>Date of Joining</th>
												<th>Student Name</th> 
												<th>Mobile Number</th> 
												<th>Course</th>
												<th>Date of Inquiry</th>
												<th>Update</th> 
											</tr> 
										</thead>
										<tbody>
<%
	List<Inquiry> list3 = (List<Inquiry>)request.getAttribute("viewPendingList");
		count = 0;
	 	for(Inquiry inquiry :list3)
	 	{
			count++;
%>
 
											<tr>
												<th scope="row"><%=count %></th> 
												<td><%=inquiry.getJoining_date() %></td>
												<td><%=inquiry.getStudent_name() %></td> 
												<td><%=inquiry.getMob_no() %></td> 
												<td><%=inquiry.getCourse() %></td>
												<td><%=inquiry.getInquiry_date() %></td>
												<td><a href="EditForm?id=<%=inquiry.getID() %>">Edit</a> / <a href="StudentForm?id=<%=inquiry.getID() %>">To Student</a> / <a id='deleteConfirm' onclick='deleteConfirm()' href="InquiryDeleteController?id=<%=inquiry.getID() %>">Delete</a></td> 
											</tr>
<%	
 	} 
	if(list3.isEmpty()) 
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
	
	<!--Confirm Delete javaScript-->
	<script>
		function deleteConfirm() {
			var r = confirm("Press 'Ok' if you want to Delete");
			if (r == false) {
				document.getElementById("deleteConfirm").href="#";
			  } else{
				  document.getElementById("deleteConfirm").href;
			  }
		}
	</script>
	
</body>
</html>