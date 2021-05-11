<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>

<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js">
	
</script>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/magic.css">

<title>About</title>
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
				<li><a href="MagicServlet?action=myPage">My bookings</a></li>
				<li><a href="http://localhost:8080/MagicWebProject/about.jsp"><strong>About</strong></a></li>
				<li><a
					href="http://localhost:8080/MagicWebProject/magicTest.jsp">Test</a></li>
			</form>

		</ul>
	</div>
	<aside>

		<br> <br> <img src="Images/training1.jpg" alt="training">
	</aside>

	<article>
		<section id="main">
			<section id="content">
				<p>
				<pre style="font-family: times new roman;">
    	<h2>  About us</h2>
Magic Training is available to give everyone who wants the opportunity to find their own inspiration and desire for movement.
We know that if training is to happen, it must be fun! At Magic Training, we offer just different types of exercises 
that can take place in many different ways. So that everyone can find a way to move.

Magic Training opened the first facility in the winter of 2021. Since the pandemic is a fact, we want to offer outdoor training to all our members.
It is just as important now in the pandemic as before that exercise and health must still be in focus. 
We believe that fun, outdoor training is the way best way to achieve this!  

We want training to be easy, therefore we now offer outdoor training with both coaching and an outdoor gym for our members.
We also offer forms of distance training via link. This enables home training that we know many people prefer at the moment. 

Magic Training should be available to everyone, around the clock all year round.
<br>
Come and join us, it will be fun!
	<em>The Magic Training team </em>				
</pre>
	</article>

	<footer>
		<p>
			&copy; Magic Training<br> Questions? Do not hesitate to contact
			us on info@magictraining.com
		</p>
	</footer>
</body>
</html>