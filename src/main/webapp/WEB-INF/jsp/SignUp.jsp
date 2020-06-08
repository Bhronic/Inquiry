<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SignUp</title>
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
<body>
<div id="page-wrapper">
			<div class="main-page signup-page">
				<h2 class="title1">SignUp Here</h2>
				<div class="sign-up-row widget-shadow">
				<center style="color:red">${msg }</center>
					<h5>Personal Information :</h5>
				<form action="SignUpController" method="post" modelAttribute="user">
					<div class="sign-u">
						<input type="text" name="fname" placeholder="First Name" required>
					</div>
					<div class="sign-u">
						<input type="text" name="lname" placeholder="Last Name" required>
					</div>
					<div class="sign-u">
						<input type="email" name="email" placeholder="Email Address" required>
					</div>
					<div class="sign-u">
						<div class="sign-up1">
							<h4>Gender* :</h4>
						</div>
						<div class="sign-up2">
							<label>
								<input type="radio" name="gender" value="Male" required>
								Male
							</label>
							<label>
								<input type="radio" name="gender" value="Female" required>
								Female
							</label>
						</div>
						<div class="clearfix"> </div>
					</div>
					<h6>Login Information :</h6>
					<div class="sign-u">
								<input type="text" name="username" placeholder="Username" required>
						<div class="clearfix"> </div>
					</div>
					<div class="sign-u">
								<input type="password" name="password" placeholder="Password" required>
						</div>
						<div class="clearfix"> </div>
					<div class="sub_home" align="center">
							<button type="submit" class="btn btn-default">Submit</button>
							<button type="reset" class="btn btn-default" onClick="window.location.replace('index')">Cancel</button>
					</div>
				</form>
				</div>
			</div>
		</div>
</body>
</html>