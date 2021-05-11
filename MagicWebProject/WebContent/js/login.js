	function validateInfo() {
		var fnElement = $("#txtMemberNbr");
		var memberNbr = fnElement.val();
		fnElement = $("#txtMemberSSN");
		var memberSSN = fnElement.val();

		if (memberNbr == "" && memberSSN == "") {
			$("#responseLogIn").html(
					"Please type in your member number and password");
		}

		else if (memberNbr == "") {
			$("#responseLogIn").html("Please type in your member number");
		} else if (memberSSN == "") {
			$("#responseLogIn").html("Please type in your password");
		} else {
			$
					.ajax({
						method : "POST",
						url : "/MagicWebProject/MagicServlet",
						data : {
							operation : "memberLogIn",
							txtMemberNbr : memberNbr,
							txtMemberSSN : memberSSN

						},
						success : function(data) {

							window.location = "/MagicWebProject/MagicServlet?action=myPage"
						},
						error : function(status) {

							$("#responseLogIn")
									.html(
											"Something went wrong, check your spelling and try again");

						}

					});
		}
	}