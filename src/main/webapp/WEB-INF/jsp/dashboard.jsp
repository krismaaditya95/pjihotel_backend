<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en" dir="ltr">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Cache-Control" content="no-cache">
<meta http-equiv="Expires" content="Sat, 01 Dec 2001 00:00:00 GMT">
<title>PJI Hotel - Sistem Back Office Reservasi Kamar</title>
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
<body>


	<div class="w3-sidebar w3-bar-block w3-pale-yellow w3-card"
		style="width: 160px;">
		<div class="w3-container w3-display-container w3-padding-16">
			<i onclick="w3_close()"
				class="fa fa-remove w3-hide-large w3-button w3-display-topright"></i>
			<h3 class="w3-wide">
				<b>PJI Hotel</b>
			</h3>
		</div>
		<a href="dashboard" class="w3-bar-item w3-button">Dashboard</a>

		<button class="w3-button w3-block w3-left-align"
			onclick="myAccFunc1()">
			CheckIn/Out <i class="fa fa-caret-down"></i>
		</button>
		<div id="accCheckin" class="w3-hide w3-white w3-card">
			<a href="transaksi/catat" class="w3-bar-item w3-button">Check in</a>
			<a href="#" class="w3-bar-item w3-button">Check out</a> <a href="#"
				class="w3-bar-item w3-button">Reservation</a>
		</div>



		<a href="customers" class="w3-bar-item w3-button">Buku tamu </a>

		<button class="w3-button w3-block w3-left-align"
			onclick="myAccFunc2()">
			Kamar <i class="fa fa-caret-down"></i>
		</button>
		<div id="accKamar" class="w3-hide w3-white w3-card">
			<a href="#" class="w3-bar-item w3-button">Add Type Room</a> <a
				href="#" class="w3-bar-item w3-button">Add Room</a> <a href="#"
				class="w3-bar-item w3-button">Available Room</a>
		</div>
		<a href="transaksi" class="w3-bar-item w3-button">Laporan Transaksi </a>
	</div>
	
			

<div class="w3-container" style="margin-left: 160px">
		<div class="jumbotron text-center">
			<h3>PJI Hotel - Customer</h3>
		</div>
		</div>
	<script src="/static/js/jquery-1.11.1.min.js"></script>
	<script src="/static/js/bootstrap.min.js"></script>

</body>
</html>
