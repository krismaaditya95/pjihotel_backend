<%-- <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en" dir="ltr">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Cache-Control" content="no-cache">
<meta http-equiv="Expires" content="Sat, 01 Dec 2001 00:00:00 GMT">
<title>PJI Hotel - Available Rooms</title>
<link href="/static/css/bootstrap.min.css" rel="stylesheet">
<link href="/static/css/style.css" rel="stylesheet">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.8.2/css/all.css"
	integrity="sha384-oS3vJWv+0UjzBfQzYUhtDYW+Pj2yciDJxpsK1OYPAYjqT085Qq/1cq5FLXAZQ7Ay"
	crossorigin="anonymous">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>

<body> --%>

<%@ include file = "header.jsp" %>
<%@ include file = "nav.jsp" %>
	<div class="w3-container" style="margin-left: 200px">
		<%-- <div class="jumbotron text-center">
			<h3>PJI Hotel - Customer</h3>
		</div> --%>

		<div class="div-title">
			<h3>Daftar Kamar Tersedia</h3>
		</div>

		<div class="transaksi-div-wrapper container text-center" id="tasksDiv">
			<a href="add-room" type="submit" class="btn btn-primary"><i
				class="fas fa-user-plus"></i> Tambah Kamar</a>
		<div class="table-responsive">
			<table class="table table-striped table-bordered text-left">
				<thead>
					<tr>
						<th>Id Kamar</th>
						<th>No. Kamar</th>
						<th>Tipe Kamar</th>
						<th>Harga Kamar</th>
						<th>Status Kamar</th>

						<th colspan="2">Aksi</th>
					</tr>

				</thead>
				<tbody>
					<c:forEach var="kamar" items="${kamars}">
						<tr>
							<td>${kamar.idKamar}</td>
							<td>${kamar.noKamar}</td>
							<td>${kamar.tipeKamar.typeName}</td>
							<td>${kamar.tipeKamar.harga}</td>
              <td>${kamar.statusKamar.statusName}</td>
							<td><a href="edit-kamar/${kamar.idKamar}" type="submit"
								class="btn btn-primary"><i class="fas fa-edit"></i> Edit</a></td>
							<td><a href="delete-kamar/${kamar.idKamar}" type="submit"
								class="btn btn-danger"><i class="far fa-trash-alt"></i>
									Delete</a></td>
						</tr>
					</c:forEach>

				</tbody>
			</table>
		</div>
	</div>
	</div>

	<%@ include file = "footer.jsp" %>
	<%-- <script>
		function myAccFunc1() {
			var x = document.getElementById("accCheckin");
			if (x.className.indexOf("w3-show") == -1) {
				x.className += " w3-show";
				x.previousElementSibling.className += " w3-green";
			} else {
				x.className = x.className.replace(" w3-show", "");
				x.previousElementSibling.className = x.previousElementSibling.className
						.replace(" w3-green", "");
			}
		}
		function myAccFunc2() {
			var x = document.getElementById("accKamar");
			if (x.className.indexOf("w3-show") == -1) {
				x.className += " w3-show";
				x.previousElementSibling.className += " w3-green";
			} else {
				x.className = x.className.replace(" w3-show", "");
				x.previousElementSibling.className = x.previousElementSibling.className
						.replace(" w3-green", "");
			}
		}
		function myDropFunc() {
			var x = document.getElementById("demoDrop");
			if (x.className.indexOf("w3-show") == -1) {
				x.className += " w3-show";
				x.previousElementSibling.className += " w3-green";
			} else {
				x.className = x.className.replace(" w3-show", "");
				x.previousElementSibling.className = x.previousElementSibling.className
						.replace(" w3-green", "");
			}
		}
	</script>





	<script src="/static/js/jquery-1.11.1.min.js"></script>
	<script src="/static/js/bootstrap.min.js"></script>

</body>
</html> --%>
