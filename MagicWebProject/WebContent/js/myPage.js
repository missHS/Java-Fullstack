function highlightRow() {
		var table = document.getElementById('bookedTable');
		var cells = table.getElementsByTagName('td')
		for (var i = 0; i < cells.length; i++) {
			// Take each cell
			var cell = cells[i];

			cell.onclick = function() {
				// Get the row id for the cell
				var rowId = this.parentNode.rowIndex;

				// Styling
				var rowsNotSelected = table.getElementsByTagName('tr');
				for (var row = 0; row < rowsNotSelected.length; row++) {
					rowsNotSelected[row].style.backgroundColor = "";
				}

				var rowSelected = table.getElementsByTagName('tr')[rowId];

				rowSelected.style.backgroundColor = "lightgrey";
				rowSelected.className += " selected";

				classID = rowSelected.cells[1].innerHTML;

				var visible = document.getElementById("unBookAClass");

				visible.style.display = "block";

			}
		}

	}

	function validateUnBooking() {

		var fnElement = $("#selectedClass");
		var selectedClass = classID;
		fnElement = $("#memberId");
		var memberNbr = fnElement.text();

		if (selectedClass != "") {
			$.ajax({
				method : "POST",
				url : "/MagicWebProject/MagicServlet",
				data : {
					operation : "unbookMemberOnClass",
					bookedMemberNbr : memberNbr,
					bookedClassID : selectedClass
				},
				success : function(data) {
					location.reload(true);
					$("#response").html("You are now canceled from the class");

				},
				error : function(status) {
					$("#response").html("You are not booked on this class");
				}
			});
		}
	}

	$(document).ready(function() {
		var nullCheck = $("#memberId").text().substring(0, 4);
		if (nullCheck == "") {
			window.location = "/MagicWebProject/login.jsp"
		}

	});