<%@page import="com.inquiry.repository.UserRepository"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.*" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Home</title>
<style type="text/css">
	.active1{
		border-left: 3px solid #3c8dbc;
		background-color: black;
	}
</style>
<jsp:include page="files.jsp"/>
<script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>
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
		        <div class="charts">
			        <div class="col-md-6 content-top-2 card">
						<div class="agileinfo-cdr">
							<div class="tables widget-shadow" id="chartContainer1" style="height: 370px; width: 100%;"></div>								
						</div>
					</div>
				</div>
				<div class="charts">
			        <div class="col-md-6 content-top-2 card">
						<div class="agileinfo-cdr">
							<div class="tables widget-shadow" id="chartContainer2" style="height: 370px; width: 100%;"></div>						
						</div>
					</div>
				</div>
			</div>
        </div>
		<!-- main contents end -->
<!-- Student Course Distribution Pie Chart -->	
<script>
	
	var chart = new CanvasJS.Chart("chartContainer1", {
		animationEnabled: true,
		title: {
			text: "Student Course Distribution"
		},
		data: [{
			type: "pie",
			startAngle: 240,
			yValueFormatString: "##0.00\"%\"",
			indexLabel: "{label} {y}",
			dataPoints: [
				{y: 79.45, label: "Google"},
				{y: 7.31, label: "Bing"},
				{y: 7.06, label: "Baidu"},
				{y: 4.91, label: "Yahoo"},
				{y: 1.26, label: "Others"}
				]
			}]
		});
		chart.render();
		
</script>
<!-- //Student Course Distribution Pie Chart -->
<!-- Student - Inquiry Bar Graph -->
<script>

var chart = new CanvasJS.Chart("chartContainer2", {
	animationEnabled: true,
	title:{
		text: "Student - Inquiry Bar Graph",
		fontFamily: "arial black",
		fontColor: "#333"
	},
	axisX: {
		interval: 1,
		intervalType: "year"
	},
	axisY:{
		valueFormatString:"$#0bn",
		gridColor: "#B6B1A8",
		tickColor: "#B6B1A8"
	},
	toolTip: {
		shared: true,
		content: toolTipContent
	},
	data: [{
		type: "stackedColumn",
		showInLegend: true,
		color: "#696661",
		name: "Q1",
		dataPoints: [
			{ y: 6.75, x: new Date(2010,0) },
			{ y: 8.57, x: new Date(2011,0) },
			{ y: 10.64, x: new Date(2012,0) },
			{ y: 13.97, x: new Date(2013,0) },
			{ y: 15.42, x: new Date(2014,0) },
			{ y: 17.26, x: new Date(2015,0) },
			{ y: 20.26, x: new Date(2016,0) }
		]
		},
		{        
			type: "stackedColumn",
			showInLegend: true,
			name: "Q2",
			color: "#EDCA93",
			dataPoints: [
				{ y: 6.82, x: new Date(2010,0) },
				{ y: 9.02, x: new Date(2011,0) },
				{ y: 11.80, x: new Date(2012,0) },
				{ y: 14.11, x: new Date(2013,0) },
				{ y: 15.96, x: new Date(2014,0) },
				{ y: 17.73, x: new Date(2015,0) },
				{ y: 21.5, x: new Date(2016,0) }
			]
		},
		{        
			type: "stackedColumn",
			showInLegend: true,
			name: "Q3",
			color: "#695A42",
			dataPoints: [
				{ y: 7.28, x: new Date(2010,0) },
				{ y: 9.72, x: new Date(2011,0) },
				{ y: 13.30, x: new Date(2012,0) },
				{ y: 14.9, x: new Date(2013,0) },
				{ y: 18.10, x: new Date(2014,0) },
				{ y: 18.68, x: new Date(2015,0) },
				{ y: 22.45, x: new Date(2016,0) }
			]
		},
		{        
			type: "stackedColumn",
			showInLegend: true,
			name: "Q4",
			color: "#B6B1A8",
			dataPoints: [
				{ y: 8.44, x: new Date(2010,0) },
				{ y: 10.58, x: new Date(2011,0) },
				{ y: 14.41, x: new Date(2012,0) },
				{ y: 16.86, x: new Date(2013,0) },
				{ y: 10.64, x: new Date(2014,0) },
				{ y: 21.32, x: new Date(2015,0) },
				{ y: 26.06, x: new Date(2016,0) }
			]
	}]
});
chart.render();

function toolTipContent(e) {
	var str = "";
	var total = 0;
	var str2, str3;
	for (var i = 0; i < e.entries.length; i++){
		var  str1 = "<span style= \"color:"+e.entries[i].dataSeries.color + "\"> "+e.entries[i].dataSeries.name+"</span>: $<strong>"+e.entries[i].dataPoint.y+"</strong>bn<br/>";
		total = e.entries[i].dataPoint.y + total;
		str = str.concat(str1);
	}
	str2 = "<span style = \"color:DodgerBlue;\"><strong>"+(e.entries[0].dataPoint.x).getFullYear()+"</strong></span><br/>";
	total = Math.round(total * 100) / 100;
	str3 = "<span style = \"color:Tomato\">Total:</span><strong> $"+total+"</strong>bn<br/>";
	return (str2.concat(str)).concat(str3);


}
</script>
<!-- //Student - Inquiry Bar Graph -->
		
	<!--scrolling js-->
	<script src="js/jquery.nicescroll.js"></script>
	<script src="js/scripts.js"></script>
	<!--//scrolling js-->
	
</body>
</html>