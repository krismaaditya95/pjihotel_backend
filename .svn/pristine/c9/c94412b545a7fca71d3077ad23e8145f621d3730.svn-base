<%-- <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en" dir="ltr">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Cache-Control" content="no-cache">
<meta http-equiv="Expires" content="Sat, 01 Dec 2001 00:00:00 GMT">

<title>Tambah Kamar</title>
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
			<h3>PJI Hotel - Tambah Kamar</h3>
		</div> --%>

		<div class="div-title">
			<h3>Tambah kamar</h3>
		</div>

		<div class="transaksi-div-wrapper container text-center" id="tasksDiv">

		<form class="transaksiform" method="post">
			<div class="col-sm-7">
				<label class="form-label">Tipe Kamar</label>
				<select name="idType" class="w3-select">
					<c:forEach var="tipe" items="${tipeKamar}">
						<option value="${tipe.idType}">${tipe.typeName}</option>
					</c:forEach>
				</select>
			</div>

			<br>

			<div class="col-sm-7">
				<label class="form-label">Status Kamar</label> <select class="w3-select"
					name="idStatus">
					<c:forEach var="status" items="${statusKamar}">
						<option value="${status.idStatus}">${status.statusName}</option>
					</c:forEach>
				</select>
			</div>
			</div>


			<div class="col-sm-7">
				<div class="form-group form-float">
					<label class="form-label">Nomor Kamar : </label>
					<div class="form-line">
						<input name="noKamar" type="text" class="form-control">
					</div>
				</div>
			</div>

			<center>
				<div class="col-md-6">
				<input type="submit" class = "w3-btn w3-ripple w3-teal" value="TAMBAH"></input>

					<a href="customers" type="submit" class="btn btn-danger">Cancel</a>
				</div>
			</center>
		</form>
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
