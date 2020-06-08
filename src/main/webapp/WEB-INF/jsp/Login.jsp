<!DOCTYPE HTML>
<html>
<head>
<title>Login</title>
<jsp:include page="files.jsp"/>
</head>
<body>
	<!-- main content start-->
	<div id="page-wrapper">
		<div class="main-page login-page ">
			<h4 style="color: red; text-align: center">${msg }</h4>
			<h2 class="title1">Login</h2>
			<div class="widget-shadow">
				<div class="login-body">
					<form action="LoginController" method="post" modelAttribute="user">
						<input type="text" class="user" name="username"
							placeholder="Enter Your Username" required=""> <input
							type="password" name="password" class="lock"
							placeholder="Password" required=""> <input type="submit"
							name="Sign In" value="Sign In">
					</form>
				</div>
			</div>
		</div>
	</div>
	<!-- main contents end -->

	<div class="footer">
		<p>
			&copy; 2018 Glance Design Dashboard. All Rights Reserved | Design by
			<a href="https://w3layouts.com/" target="_blank">w3layouts</a>
		</p>
	</div>

	<!--scrolling js-->
	<script src="js/jquery.nicescroll.js"></script>
	<script src="js/scripts.js"></script>
	<!--//scrolling js-->

	<!-- Bootstrap Core JavaScript -->
	<script src="js/bootstrap.js">
		
	</script>
	<!-- //Bootstrap Core JavaScript -->

</body>
</html>