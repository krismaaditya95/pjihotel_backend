
<nav class="navbar bg-light">
	<div class="container-fluid">
		<div class="navbar-header">
		<h3 class="w3-wide">PJI Hotel</h3>
		</div>
		<ul class="nav navbar-nav navbar-right">
			<li>
				<a href="/pjihotel/logout"><span class="glyphicon glyphicon-log-in"></span> Logout</a>
			</li>
			<li>
				<a href="#">Selamat datang, ${sessionScope.userName} <span>(${sessionScope.userRoleName})</span></a>
			</li>
			<%-- <li>
				<a href="#">Session created : ${sessionScope.sessionCreationTime}</a>
				<a href="#">Session Id : ${sessionScope.sessionId}</a>
				<a href="#">Last Accessed time : ${sessionScope.lastAccessedTime}</a>
			</li> --%>
		</ul>
	</div>
</nav>

	<div class="w3-sidebar w3-bar-block w3-teal w3-card" style="width: 200px;">
		<div class="w3-container w3-display-container w3-padding-16">
			<i onclick="w3_close()"
				class="fa fa-remove w3-hide-large w3-button w3-display-topright"></i>
			<img class="sizeimage" src="/static/images/Logo.gif" alt="">

		</div>
		<a href="#!" class="w3-bar-item w3-button"><i class="fas fa-fw fa-tachometer-alt"></i> Dashboard</a>

		<button class="w3-button w3-block w3-left-align" onclick="myAccFunc1()"><i class="fa fa-key"></i>
		CheckIn/Out <i class="fa fa-caret-down"></i>
		</button>

		<div id="accCheckin" class="w3-hide w3-light-gray w3-card">
			<a href="/pjihotel/transaksi/catat" class="w3-bar-item w3-button">Check in/Check Out</a>
			<%-- <a href="/pjihotel/transaksi/checkout" class="w3-bar-item w3-button">Check in</a> --%>
			<%-- <a href="#!transaksi/catat" class="w3-bar-item w3-button">Check in</a> --%>
			<%-- <a href="#!transaksi/checkout" class="w3-bar-item w3-button">Check out</a> --%>
			<%-- <a href="#" class="w3-bar-item w3-button">Reservation</a> --%>
		</div>

		<a href="/pjihotel/customers" class="w3-bar-item w3-button"><i class="fa fa-suitcase"></i> Buku tamu </a>
		<%-- <a href="#!customers" class="w3-bar-item w3-button"><i class="fa fa-suitcase"></i> Buku tamu </a> --%>

		<button class="w3-button w3-block w3-left-align" onclick="myAccFunc2()"><i class="fa fa-bed"></i>
			Kamar <i class="fa fa-caret-down"></i>
		</button>

		<div id="accKamar" class="w3-hide w3-light-gray w3-card">
			<%-- <a href="" class="w3-bar-item w3-button">Add Type Room</a> --%>
			<a href="/pjihotel/add-room" class="w3-bar-item w3-button">Add Room</a>
			<a href="/pjihotel/available-room" class="w3-bar-item w3-button">Available Room</a>
			<%-- <a href="#!add-room" class="w3-bar-item w3-button">Add Room</a> --%>
			<%-- <a href="#!available-room" class="w3-bar-item w3-button">Available Room</a> --%>
		</div>
		<a href="/pjihotel/transaksi" class="w3-bar-item w3-button"><i class="fa fa-book"></i>Laporan Transaksi</a>
		<%-- <a href="#!transaksi" class="w3-bar-item w3-button"><i class="fa fa-book"></i>Laporan Transaksi</a> --%>
	</div>
