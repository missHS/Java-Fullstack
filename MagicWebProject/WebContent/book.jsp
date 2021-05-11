
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*"%>

<!DOCTYPE html>
<%@ page import="magic.entity.ScheduledClass"%>
<%@ page import="magic.entity.Member"%>
<html>
<link rel="stylesheet" type="text/css" href="css/magic.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="js/book.js"></script>
<head>
<meta charset="ISO-8859-1">

<title>Book class</title>

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
				<li><a href="MagicServlet?action=bookClass"><strong>Book
							class</strong></a></li>
				<li><a href="MagicServlet?action=myPage">My bookings</a></li>
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
						List<ScheduledClass> scheduledClassList = (List<ScheduledClass>) request.getAttribute("bookingClassList");
						Member member = (Member) session.getAttribute("memberLogin");
						if (member != null) {
							name = String.valueOf(member.getName());
							number = String.valueOf(member.getMemberNumber());
						}
					%>


					<h2 id="inloggInfo">
						Hello
						<%=name%>!
					</h2>

					<!--hidden text to be used in script-->

					<h2 id="memberNumberId" hidden><%=number%></h2>
					<p id="bookInfo">Please select the class you want to book.</p>




					<table id="bookTable" onclick="highlightRow()">
						<thead id="bookTable">
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
								for (int i = 0; i < scheduledClassList.size(); i += 1) {
							%>
							<tr>
								<td id="tdTable"><%=scheduledClassList.get(i).getClassName()%></td>
								<td id="tdTable"><%=scheduledClassList.get(i).getScheduledClassID()%></td>
								<td id="tdTable"><%=scheduledClassList.get(i).getRoomName()%></td>
								<td id="tdTable"><%=scheduledClassList.get(i).getInstructorName()%></td>
								<td id="tdTable"><%=scheduledClassList.get(i).getClassDate()%></td>
								<td id="tdTable"><%=scheduledClassList.get(i).getClassTime()%></td>


							</tr>
							<%
								}
							%>
						</tbody>
					</table>
					<br> <input class="button" type="button" name="bookAClass"
						id="bookAClass" value="Book" style="display: none;"
						onclick="validateBooking()">
					<p id="response"></p>
				</div>


			</article>
		</section>
	</section>

	<br>


	<p id="response"></p>


	<footer>
		<p>
			&copy; Magic Training<br> Questions? Do not hesitate to contact
			us on info@magictraining.com
		</p>
	</footer>


</body>


</html>