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

<title>JUnit Test</title>
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
				<li><a href="http://localhost:8080/MagicWebProject/about.jsp">About</a></li>
				<li><a
					href="http://localhost:8080/MagicWebProject/magicTest.jsp"><strong>Test</strong></a></li>
			</form>

		</ul>
	</div>

	<aside>

		<br> <br> <img src="Images/training1.jpg" alt="training">
	</aside>


	<section id="mainView">
		<article>


			<h2>
				Here you can select to run the following test:<br>
			</h2>
			<section id="contentView">
				<form action="TestServlet" method="get" name="youPickItForm">
					<select name="suite" size="5" multiple style="width: 120px;">
						<!-- Runs the facade test -->
						<option value="magic.test.FacadeTest">Test facade</option>

					</select> <input type="submit" value="Run" class="button">
				</form>

			</section>
		</article>

	</section>

	<footer>
		<p>
			&copy; Magic Training<br> Questions? Do not hesitate to contact
			us on info@magictraining.com
		</p>
	</footer>
</body>
</html>
