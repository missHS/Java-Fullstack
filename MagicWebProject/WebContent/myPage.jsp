<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*"%>
<!DOCTYPE html>
<%@ page import="magic.entity.Member"%>
<%@ page import="magic.entity.ScheduledClass"%>
<html>
<link rel="stylesheet" type="text/css" href="css/magic.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"
	type="text/javascript"></script>
<script src="js/myPage.js"></script>
<head>
<meta charset="ISO-8859-1">
<title>My bookings</title>
</head>

<body>


	<header>
		<a href="MagicServlet?action=startPage"> <img
			src="Images/Logotype3.jpg" alt="logo"></a>
	</header>
	<div class="nav">
		<ul>

			<form action="/MagicWebProject/MagicServlet" method="get">

				<li><a href="MagicServlet?action=startPage">Home</a></li>
				<li><a href="http://localhost:8080/MagicWebProject/login.jsp">Sign
						in</a></li>
				<li><a href="MagicServlet?action=bookClass">Book class</a></li>
				<li><a href="MagicServlet?action=myPage"><strong>My
							bookings</strong></a></li>
				<li><a href="http://localhost:8080/MagicWebProject/about.jsp">About</a></li>
				<li><a
					href="http://localhost:8080/MagicWebProject/magicTest.jsp">Test</a></li>

			</form>

		</ul>

	</div>

	<aside>

		<br> <br> <img src="Images/training1.jpg" alt="training">
	</aside>
	<section id="main">
		<section id="content">
			<article>
				<div id="divInfo" style="height: 597px;">
					<%
						String name = null;
						String number = null;

						List<ScheduledClass> scheduledClassesForMember = (List<ScheduledClass>) request.getAttribute("memberList");

						Member member = (Member) session.getAttribute("memberLogin");
						if (member != null) {
							name = String.valueOf(member.getName());
							number = String.valueOf(member.getMemberNumber());
					%>

					<h2 id="loginInfo">
						Hello
						<%=name%>!
					</h2>
					<h2 id="memberId" hidden><%=number%></h2>
					<p id="bookedInfo">
						Here are the classes that you have secured a reservation for. <br>
						<br> If you want to cancel the reservation just select the
						class and then press "cancel"
					</p>





					<table id="bookedTable" onclick="highlightRow()">
						<thead id="bookedTable">
							<tr>
								<th id="thTable">Class</th>
								<th id="thTable">ID</th>
								<th id="thTable">Room</th>
								<th id="thTable">Instructor</th>
								<th id="thTable">Date</th>
								<th id="thTable">Time</th>

							</tr>
						</thead>
						<tbody>
							<%
								for (int i = 0; i < scheduledClassesForMember.size(); i += 1) {
							%>
							<tr>
								<td id="tdTable"><%=scheduledClassesForMember.get(i).getClassName()%></td>
								<td id="tdTable"><%=scheduledClassesForMember.get(i).getScheduledClassID()%></td>
								<td id="tdTable"><%=scheduledClassesForMember.get(i).getRoomName()%></td>
								<td id="tdTable"><%=scheduledClassesForMember.get(i).getInstructorName()%></td>
								<td id="tdTable"><%=scheduledClassesForMember.get(i).getClassDate()%></td>
								<td id="tdTable"><%=scheduledClassesForMember.get(i).getClassTime()%></td>


							</tr>
							<%
								}
								}
							%>
						</tbody>
					</table>
					<br> <input class="button" type="button" name="unBookAClass"
						id="unBookAClass" value="Cancel"
						style="display: none; width: 137px" onclick="validateUnBooking()">
					<p id="response"></p>

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








