<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>

<!DOCTYPE html>
<%@ page import="magic.entity.ScheduledClass"%>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js">
	//Jquery
</script>

<meta charset="ISO-8859-1">

<link rel="stylesheet" type="text/css" href="css/magic.css">
<script src="js/startPage.js"></script>
<title>Magic Training</title>
</head>
<body>
	<header>
		<a href="MagicServlet?action=startPage"> <img
			src="Images/Logotype3.jpg" alt="logo"></a>
	</header>
	<div class="nav">
		<ul>
			<form action="http://localhost:8080/MagicWebProject/MagicServlet"
				method="get">

				<li><a href="MagicServlet?action=startPage"><strong>Home</strong></a></li>
				<li><a href="http://localhost:8080/MagicWebProject/login.jsp">Sign
						in</a></li>
				<li><a href="MagicServlet?action=bookClass">Book class</a></li>
				<li><a href="MagicServlet?action=myPage">My bookings</a></li>
				<li><a href="http://localhost:8080/MagicWebProject/about.jsp">About</a></li>
				<li><a
					href="http://localhost:8080/MagicWebProject/magicTest.jsp">Test</a></li>
			</form>
		</ul>
	</div>

	<!-- Weather API -->
	<aside>
		<p align=center>Do you plan a workout outside, see todays weather
			forecast!</p>
		<h2>
			<p align=center>
				Weather in <span id="city"></span>
			</p>
		</h2>


		<span id="ipNbr" hidden></span>

		<p align=center>
			Temperature: <span id="degree"></span>
		</p>
		<p align=center>
			Weather forecast: <span id="weather"></span>
		</p>
		<p align=center>
			<span id="sunrise"></span>
		</p>
		<p align=center>
			<span id="sunset"></span>
		</p>
		<br> <br> <img src="Images/training1.jpg" alt="training">
	</aside>

	<section id="main">
		<section id="content">
			<article>

				<%
					List<ScheduledClass> listOfScheduledClasses = (List<ScheduledClass>) request
							.getAttribute("scheduledClassList");
				%>
				<div>
					<h2>Welcome to Magic Training!</h2>
					<br>
					<p>
						We are the gym that puts our members in focus while we adapt to
						the circumstances around us. <br> <br> Do you want to
						become a member? <br>Please contact the reception and we will
						help you become a member so that you have access to our sign in
						function where you book our classes.
					</p>
					<br>

					<!--Loads the classes through the get-method and displays in this list-->
					<h3>Upcoming classes</h3>
					<table id="bookTable" onclick="highlightRow()">
						<thead id="bookTable">
							<tr>
								<th id="thTable">ID</th>
								<th id="thTable">Class</th>
								<th id="thTable">Date</th>
								<th id="thTable">Time</th>
								<th id="thTable">Room</th>
								<th id="thTable">Instructor</th>
							</tr>
						</thead>
						<tbody>
							<%
								for (int i = 0; i < listOfScheduledClasses.size(); i += 1) {
							%>
							<tr>
								<td id="tdTable"><%=listOfScheduledClasses.get(i).getScheduledClassID()%></td>
								<td id="tdTable"><%=listOfScheduledClasses.get(i).getClassName()%></td>
								<td id="tdTable"><%=listOfScheduledClasses.get(i).getClassDate()%></td>
								<td id="tdTable"><%=listOfScheduledClasses.get(i).getClassTime()%></td>
								<td id="tdTable"><%=listOfScheduledClasses.get(i).getRoomName()%></td>
								<td id="tdTable"><%=listOfScheduledClasses.get(i).getInstructorName()%></td>
							</tr>
							<%
								}
							%>
						</tbody>
					</table>
				</div>
			</article>
		</section>
	</section>
	<footer>
		<p>
			&copy; Magic Training<br> Questions? Do not hesitate to contact
			us on info@magictraining.com
		</p>
	</footer>
</body>
</html>