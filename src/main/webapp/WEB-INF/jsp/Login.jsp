<!DOCTYPE HTML>
<html>
<head>
<title>Login</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords"
	content="Glance Design Dashboard Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
SmartPhone Compatible web template, free WebDesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<script type="application/x-javascript">
	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 
</script>

<!-- Bootstrap Core CSS -->
<link href="css/bootstrap.css" rel='stylesheet' type='text/css' />

<!-- Custom CSS -->
<link href="css/style.css" rel='stylesheet' type='text/css' />

<!-- font-awesome icons CSS -->
<link href="css/font-awesome.css" rel="stylesheet">
<!-- //font-awesome icons CSS-->

<!-- js-->
<script src="js/jquery-1.11.1.min.js"></script>
<script src="js/modernizr.custom.js"></script>

<!--webfonts-->
<link
	href="//fonts.googleapis.com/css?family=PT+Sans:400,400i,700,700i&amp;subset=cyrillic,cyrillic-ext,latin-ext"
	rel="stylesheet">
<!--//webfonts-->

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