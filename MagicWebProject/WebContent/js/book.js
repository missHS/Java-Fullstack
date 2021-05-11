function highlightRow() {
		var table = document.getElementById('bookTable');
		var cells = table.getElementsByTagName('td');
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
				//get the id-value of the selected row
				classID = rowSelected.cells[1].innerHTML;
				//shows the book button when selected
				var visible = document.getElementById("bookAClass");
				visible.style.display = "block";
			}
		}
	}
	function validateBooking() {
		var selectedClass = classID;
		var fnElement = $("#memberNumberId");
		var memberNbr = fnElement.text();
		if (selectedClass == "") {
			$("#response").html("Please select a class in the list to book");
		} else {
			$.ajax({
				method : "POST",
				url : "/MagicWebProject/MagicServlet",
				data : {
					operation : "bookMemberOnClass",
					bookMemberNbr : memberNbr,
					bookClassID : selectedClass
				},
				success : function(data) {
					$("#response").html("You are now booked on the class");
				},
				error : function(status) {
					$("#response").html("You have already booked this class");
				}
			});
		}
	}

	$(document).ready(function() {
		var nullCheck = $("#memberNumberId").text().substring(0, 4);
		console.log(nullCheck)
		if (nullCheck == "null") {
			window.location = "/MagicWebProject/login.jsp"
		}

	});