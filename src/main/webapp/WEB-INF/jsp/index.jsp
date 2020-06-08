<%@page import="com.inquiry.repository.UserRepository"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.sql.*" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Home</title>
<style type="text/css">
	.active1{
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
				<div class="col_3">
					<a href="ViewInquiry">	
						<div class="col-md-3 widget widget1">
			        		<div class="r3_counter_box">
			                    <i class="pull-left fa fa-laptop user1 icon-rounded"></i>
			                    <div class="stats">
			                      <h5><strong>${count1 }</strong></h5>
			                      <span>Total Inquiries</span>
			                    </div>
			                </div>
				        </div>
					</a>
				    <a href="ViewInquiry">
			        	<div class="col-md-3 widget widget1">
			        		<div class="r3_counter_box">
			                    <i class="pull-left fa fa-pie-chart user1 icon-rounded"></i>
			                    <div class="stats">
			                      <h5><strong>${count2 }</strong></h5>
			                      <span>Pending Inquiries</span>
			                    </div>
			                </div>
			        	</div>
			        </a>
			        <a href="ViewStudent">
			        	<div class="col-md-3 widget widget1">
			        		<div class="r3_counter_box">
			                    <i class="pull-left fa fa-users dollar2 icon-rounded"></i>
			                    <div class="stats">
			                      <h5><strong>${count3 }</strong></h5>
			                      <span>Total Students</span>
			                    </div>
			                </div>
			        	</div>
			        </a>
			        <a href="ViewFees">
			        	<div class="col-md-3 widget widget1">
			        		<div class="r3_counter_box">
			                    <i class="pull-left fa fa-money dollar2 icon-rounded"></i>
			                    <div class="stats">
			                      <h5><strong>${count4 }</strong></h5>
			                      <span>Pending Fees</span>
			                    </div>
			                </div>
			        	</div>
			        </a>
	        	</div>
	        </div>
        </div>
<%
//}catch(Exception e){e.printStackTrace();}
%>
		<!-- main contents end -->
		
	<!--scrolling js-->
	<script src="js/jquery.nicescroll.js"></script>
	<script src="js/scripts.js"></script>
	<!--//scrolling js-->
	
</body>
</html>