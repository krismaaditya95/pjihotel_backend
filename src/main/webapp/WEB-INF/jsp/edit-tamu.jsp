<%@ include file="header.jsp"%>
<%@ include file="nav.jsp"%>


<div class="w3-container" style="margin-left: 200px">
	<div class="div-title">
		<h3>Edit Data Tamu</h3>
	</div>
	<nav class="navbar navbar-light bg-light">
		<span class="navbar-brand mb-0 h1 judul">Edit data tamu</span>
	</nav>
	<hr>


	<form
		class="w3-container w3-card-4 w3-light-grey w3-text-grey w3-margin"
		method="post">
		<hr>
		<div class="col-sm-7">
			<div class="form-group form-float">
				<label class="form-label">No Identitas</label>
				<div class="form-line">
					<input name="no_identitas" type="number" class="form-control"
						value="${customer.noIdentitas}">

				</div>
			</div>
		</div>
		<div class="col-sm-7">
			<div class="form-group form-float">
				<label class="form-label">Nama Tamu</label>
				<div class="form-line">
					<input name="nama_customer" type="text" class="form-control"
						value="${customer.namaCustomer}">

				</div>
			</div>
		</div>
		<div class="col-sm-7">
			<div class="form-group form-float">
				<label class="form-label">Nomor telepon</label>
				<div class="form-line">
					<input name="no_telp" type="number" class="form-control"
						value="${customer.noTelp}">

				</div>
			</div>
		</div>
		<div class="col-sm-7">
			<div class="form-group form-float">
				<label class="form-label">Email</label>
				<div class="form-line">
					<input name="email" type="email" class="form-control"
						value="${customer.email}">

				</div>
			</div>
		</div>
		<div class="col-sm-7">
			<div class="form-group form-float">
				<label class="form-label">Alamat</label>
				<div class="form-line">
					<input name="alamat" type="text" class="form-control"
						value="${customer.alamat}">

				</div>
			</div>


			<p class="w3-center">
				<input type="submit" value="TAMBAH"></input> <a href="customers"
					type="submit" class="btn btn-danger">Cancel</a>
			</p>

		</div>
	</form>
</div>
<script>
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
</html>
