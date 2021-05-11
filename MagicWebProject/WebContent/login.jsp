<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<%@ page import="magic.entity.ScheduledClass"%>
<%@ page import="magic.entity.Member"%>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js">
	
</script>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/magic.css">
<script src="js/login.js"></script>
<title>Sign in</title>


</head>
<body>

	<header>
		<a href="MagicServlet?action=startPage"> <img
			src="Images/Logotype3.jpg" alt="logga"></a>
	</header>
	<div class="nav">
		<ul>
			<form action="/MagicWebProject/MagicServlet" method="get">
				<li><a href="MagicServlet?action=startPage">Home</a></li>
				<li><a href="http://localhost:8080/MagicWebProject/login.jsp"><strong>Sign
							in</strong></a></li>
				<li><a href="MagicServlet?action=bookClass">Book class</a></li>
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



	<section id="mainView">
		<h2>To be able to book a class, see your bookings and cancel a
			booking you have to sign in!</h2>
		<br>
		<p>
			<strong>Please fill in your credentials below</strong>
		</p>

		<section id="contentView">
			<p>Member number*</p>

			<input type="text" id="txtMemberNbr" name="txtMemberNbr"> <br>
			<br>
			<p>Password*</p>
			<input type="password" id="txtMemberSSN" name="txtMemberSSN"><br>
			<br>
			<p id="responseLogIn"></p>
			<br> <input class="button" type="submit" name="loginBtn"
				id="loginBtn" value="Sign in" onclick="validateInfo()">
		</section>
	</section>


	<br>

	<%
		Member m = (Member) request.getAttribute("member");

		if (m != null) {
			session = request.getSession();
			session.setAttribute("memberLogin", m);

		}
	%>

	<footer>
		<p>
			&copy; Magic Training<br> Questions? Do not hesitate to contact
			us on info@magictraining.com
		</p>
	</footer>
</body>

</html>