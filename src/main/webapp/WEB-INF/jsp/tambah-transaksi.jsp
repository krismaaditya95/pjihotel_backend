<%@ include file="header.jsp"%>
<%@ include file="nav.jsp"%>


<div class="w3-container" style="margin-left: 200px">
	<div class="div-title">
		<h3>Tambah Check-In / Booking data</h3>
	</div>

	<div class="transaksi-div-wrapper container text-center" id="tasksDiv">
	<form class="formtambaheditTrx w3-card-4 w3-light-grey w3-text-grey w3-margin" method="post">

		<div class="col-sm-7">
			<label class="form-label">Tamu</label> <select name="idCustomer"
				class="w3-select">
				<c:forEach var="customer" items="${customerdata}">
					<option value="${customer.idCustomer}">${customer.namaCustomer}</option>
				</c:forEach>
			</select>
		</div>

		<div class="col-sm-7">
			<label class="form-label">Kamar tersedia : </label> <select class="w3-select"
				name="idKamar">
				<c:forEach var="kamar" items="${kamars}">
					<option value="${kamar.idKamar}">${kamar.noKamar}</option>
				</c:forEach>
			</select>
		</div>

		<div class="form-row">
			<div class="form-group col-md-6">
				<label class="form-label">Tanggal Check In : </label>
				<div class="form-line">
					<input name="check_in_date" type="date" class="form-control">
				</div>
			</div>

			<div class="form-group col-md-6">
				<label class="form-label">Waktu Check In : </label>
				<div class="form-line">
					<input name="check_in_time" type="time" class="form-control">
				</div>
			</div>
		</div>

		<div class="form-row">
			<div class="form-group col-md-6">
				<label class="form-label">Tanggal Check Out : </label>
				<div class="form-line">
					<input name="check_out_date" type="date" class="form-control">
				</div>
			</div>

			<div class="form-group col-md-6">
				<label class="form-label">Waktu Check Out : </label>
				<div class="form-line">
					<input name="check_out_time" type="time" class="form-control">
				</div>
			</div>
		</div>

		<div class="col-sm-7">
			<label class="form-label">Kamar tersedia :</label> <select class="w3-select"
				name="idStatusCheck">
				<c:forEach var="statuscheck" items="${statuschecks}">
					<option value="${statuscheck.idStatusCheck}">${statuscheck.namaStatus}</option>
				</c:forEach>
			</select>
		</div>

		<%-- <div class="col-sm-7">
			<div class="form-group form-float">
				<label class="form-label">Total harga : </label>
				<div class="form-line">
					<input name="totalHarga" type="number" class="form-control">
				</div>
			</div>
		</div> --%>

		<div class="col-md-6">
			<input type="submit" class="w3-btn w3-ripple w3-teal" value="TAMBAH"></input>
			<a href="transaksi/catat" type="submit" class="btn btn-danger">Cancel</a>
		</div>

	</form>
</div>
</div>
<%@ include file="footer.jsp"%>
