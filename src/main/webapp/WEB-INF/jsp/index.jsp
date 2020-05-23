<%@page import="com.inquiry.repository.UserRepository"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.sql.*" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Home</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Glance Design Dashboard Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
SmartPhone Compatible web template, free WebDesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>

<!-- Bootstrap Core CSS -->
<link href="css/bootstrap.css" rel='stylesheet' type='text/css' />

<!-- Custom CSS -->
<link href="css/style.css" rel='stylesheet' type='text/css' />

<!-- font-awesome icons CSS -->
<link href="css/font-awesome.css" rel="stylesheet"> 
<!-- //font-awesome icons CSS-->

<!-- side nav css file -->
<link href='css/SidebarNav.min.css' media='all' rel='stylesheet' type='text/css'/>
<!-- //side nav css file -->
 
 <!-- js-->
<script src="js/jquery-1.11.1.min.js"></script>
<script src="js/modernizr.custom.js"></script>

<!--webfonts-->
<link href="//fonts.googleapis.com/css?family=PT+Sans:400,400i,700,700i&amp;subset=cyrillic,cyrillic-ext,latin-ext" rel="stylesheet">
<!--//webfonts--> 

<!-- chart -->
<script src="js/Chart.js"></script>
<!-- //chart -->

<!-- Metis Menu -->
<script src="js/metisMenu.min.js"></script>
<script src="js/custom.js"></script>
<link href="css/custom.css" rel="stylesheet">
<!--//Metis Menu -->
<style>
#chartdiv {
  width: 100%;
  height: 295px;
}
</style>

	<!-- requried-jsfiles-for owl -->
					<link href="css/owl.carousel.css" rel="stylesheet">
					<script src="js/owl.carousel.js"></script>
						<script>
							$(document).ready(function() {
								$("#owl-demo").owlCarousel({
									items : 3,
									lazyLoad : true,
									autoPlay : true,
									pagination : true,
									nav:true,
								});
							});
						</script>
					<!-- //requried-jsfiles-for owl -->
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
	<div class="main-content">
		<div class="cbp-spmenu cbp-spmenu-vertical cbp-spmenu-left" id="cbp-spmenu-s1">
			<!--left-fixed -navigation-->
			<aside class="sidebar-left">
	      <nav class="navbar navbar-inverse">
	          <div class="navbar-header">
	            <h1><a class="navbar-brand" href="index.jsp"><span class="fa fa-area-chart"></span> Inquiry<span class="dashboard_text">Design dashboard</span></a></h1>
	          </div>
	          <div >
	            <ul class="sidebar-menu">
	              <li class="header">MAIN NAVIGATION</li>
	              <li class="treeview">
	                <a href="" style="background-color: black">
	                <i class="fa fa-dashboard"></i> <span>Dashboard</span>
	                </a>
	              </li>
	              <li class="treeview">
	                <a href="ViewCourse">
	                <i class="fa fa-book"></i> <span>View Course</span>
	                </a>
	              </li>
	              <li class="treeview">
	                <a href="InquiryForm">
	                <i class="fa fa-edit"></i> <span>Add Inquiry</span>
	                </a>
	              </li>
	              <li class="treeview">
	                <a href="ViewInquiry">
	                <i class="fa fa-table"></i> <span>View Inquiry</span>
	                </a>
	              </li>
	              <li class="treeview">
	                <a href="ViewStudent">
	                <i class="fa fa-users"></i> <span>View Student</span>
	                </a>
	              </li>
	              <li class="treeview">
	                <a href="ViewFees">
	                <i class="fa fa-dollar"></i> <span>Fees</span>
	                </a>
	              </li>
	            </ul>
	          </div>
	          <!-- /.navbar-collapse -->
	      </nav>
	    </aside>
		</div>
	</div>
		<!--left-fixed -navigation-->
		
		<!-- header-starts -->
		<div class="sticky-header header-section ">
		<div class="header-left">
				<!--toggle button start-->
				<button id="showLeftPush"><i class="fa fa-bars"></i></button>
				<!--toggle button end-->
		</div>
			<div class="header-right">
				<div class="profile_details">		
					<ul>
						<li class="dropdown profile_details_drop">
							<a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
								<div class="profile_img">	
									<span class="prfil-img"><img src="images/2.jpg" alt=""> </span> 
									<div class="user-name">
										<p><%=uname %></p>
										<span>Administrator</span>
									</div>
									<i class="fa fa-angle-down lnr"></i>
									<i class="fa fa-angle-up lnr"></i>
									<div class="clearfix"></div>	
								</div>	
							</a>
							<ul class="dropdown-menu drp-mnu"> 
								<%
								if(uname == null)
								{
									
								}
								else if(uname.equals("jaymodi99"))
								{
								%>
									<li> <a href="Setting"><i class="fa fa-cog"></i> Settings</a> </li>
									<li> <a href="SignUp"><i class="fa fa-user"></i> Sign Up</a> </li> 
								<%
								}
								%>
								<li> <a href="Profile"><i class="fa fa-suitcase"></i> Profile</a> </li> 
								<li> <a href="LogoutController"><i class="fa fa-sign-out"></i> Logout</a> </li>
							</ul>
						</li>
					</ul>
				</div>			
			</div>
		</div>
		<!-- //header-ends -->
		
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
		
		
	<!-- Classie --><!-- for toggle left push menu script -->
		<script src="js/classie.js"></script>
		<script>
			var menuLeft = document.getElementById( 'cbp-spmenu-s1' ),
				showLeftPush = document.getElementById( 'showLeftPush' ),
				body = document.body;
				
			showLeftPush.onclick = function() {
				classie.toggle( this, 'active' );
				classie.toggle( body, 'cbp-spmenu-push-toright' );
				classie.toggle( menuLeft, 'cbp-spmenu-open' );
				disableOther( 'showLeftPush' );
			};
			

			function disableOther( button ) {
				if( button !== 'showLeftPush' ) {
					classie.toggle( showLeftPush, 'disabled' );
				}
			}
		</script>
	<!-- //Classie --><!-- //for toggle left push menu script -->
		
	<!--scrolling js-->
	<script src="js/jquery.nicescroll.js"></script>
	<script src="js/scripts.js"></script>
	<!--//scrolling js-->
	
	<!-- side nav js -->
	<script src='js/SidebarNav.min.js' type='text/javascript'></script>
	<script>
      $('.sidebar-menu').SidebarNav()
    </script>
	<!-- //side nav js -->

	<!-- Bootstrap Core JavaScript -->
   <script src="js/bootstrap.js"> </script>
	<!-- //Bootstrap Core JavaScript -->
	
</body>
</html>