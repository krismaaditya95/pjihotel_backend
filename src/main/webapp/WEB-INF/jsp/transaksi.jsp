<%@ include file = "header.jsp" %>
<%@ include file = "nav.jsp" %>

	<div class="w3-container" style="margin-left: 200px" ng-app = "transaksiApp" ng-controller="transaksiCtrl">
		<div class="div-title">
			<h3>Check-In / Booking data</h3>
		</div>

	<div class="transaksi-div-wrapper container text-center" id="tasksDiv">
		<div class="table-responsive">
			<table class="table table-striped table-bordered text-left">
				<thead>
					<tr>
						<th>No.</th>
						<%-- <th>Id.Transaksi</th> --%>
						<%-- <th>Id Customer</th> --%>
						<th>Nama Tamu</th>
						<%-- <th>Id Kamar</th> --%>
						<th>Kamar</th>
						<th>Tanggal Check In</th>
						<th>Waktu Check In</th>
						<th>Tanggal Check Out</th>
						<th>Waktu Check Out</th>
						<%-- <th>Id Status Check</th> --%>
						<th>Status CheckIn/Out</th>
						<th>Total Harga</th>
						<th colspan = "2">Pilihan</th>

					</tr>
				</thead>

				<%-- JSP biasa --%>
				<%-- <tbody> --%>
					<%-- <c:forEach var="transaksi" items="${transactions}">
						<tr>
							<td>${transaksi.idTransaksi}</td>
							<td>${transaksi.customer.namaCustomer}</td>
							<td>${transaksi.idKamar}</td>
							<td>${transaksi.kamar.noKamar}</td>
							<td>${transaksi.checkInDate}</td>
							<td>${transaksi.checkInTime}</td>
							<td>${transaksi.checkOutDate}</td>
							<td>${transaksi.checkOutTime}</td>
							<td>${transaksi.idStatusCheck}</td>
							<td>${transaksi.statusCheck.namaStatus}</td>
							<td>${transaksi.totalHarga}</td>
						</tr>
					</c:forEach> --%>
				<%-- </tbody> --%>

				<%-- Javascript AJAXs --%>
				<%-- <tbody id="tbodytransc">

				</tbody> --%>

				<%-- <tbody> --%>
					<%-- {{transaksiData}} --%>
					<tr ng-repeat="transaksi in transaksis">
						<td>{{transaksi.idTransaksi}}</td>
						<td>{{transaksi.customer.namaCustomer}}</td>
						<td>{{transaksi.kamar.noKamar}}</td>
						<td>{{transaksi.checkInDate | date : "mediumDate" }}</td>
						<td>{{transaksi.checkInTime | date : "HH:mm" }}</td>
						<td>{{transaksi.checkOutDate | date : "mediumDate" }}</td>
						<td>{{transaksi.checkOutTime | date : "HH:mm" }}</td>
						<td>{{transaksi.statusCheck.namaStatus}}</td>
						<td>{{transaksi.totalHarga | currency : "Rp." : 0}}</td>
						<%-- <td><a href="#edit" id="showEditTrxModal" class="btn btn-primary">Edit</a></td> --%>
						<%-- <td><a href="#edit" id="showEditTrxModal" class="btn btn-primary">Edit</a></td> --%>
						<td><a href="edit-transaksi/{{transaksi.idTransaksi}}" id="showEditTrxModal" class="btn btn-primary">Edit</a></td>
						<td><a href="delete-transaksi/{{transaksi.idTransaksi}}" class="btn btn-danger">Delete</a></td>
						<%-- Modal --%>
						<%-- <div ="editTrxModal" class="edittrxmodal" data="">

						</div> --%>
						<nav aria-label="Page navigation example">
		  				<ul class="pagination justify-content-end">
		    			<li class="page-item disabled"><a class="page-link" href="" tabindex="-1">Previous</a></li>
		    			<li class="page-item"><a class="page-link" href="#"></a></li>
		    			<li class="page-item"><a class="page-link" href="#">Next</a></li>
		  				</ul>
						</nav>
					</tr>
				</tbody>


			</table>
		</div>
	</div>

</div>

<script>
// =========================================
// ANGULAR
// var url = "http://localhost:7080/pjihotel/api/v1/getAllTransaksi";
// // "ngRoute", "ngAnimate"
// var transaksiApp = angular.module("transaksiApp", []);
//
// transaksiApp.controller('transaksiCtrl', function($scope, $http){
// 	$http.get(url).then(function(response){
// 		$scope.transaksis = response.data;
// 	});
// });
</script>
<%@ include file = "footer.jsp" %>
<%-- Angular --%>

<%-- Javascript AJAX --%>
<%-- <script>
$(document).ready(function(){

	$(function(){
		fetch_data();
		function fetch_data(){
					$.ajax({
						type: 'get',
						url: 'http://localhost:7080/pjihotel/api/v1/getAllTransaksi',
						async: false,
						dataType: 'json',
						success: function(data){
							var html='';
							var i;
							for(i=0; i<data.length; i++){
								html +=
								'<tr>'+
								'<td>'+i+1+'</td>'+
								'<td>'+data[i].idTransaksi+'</td>'+
								'<td>'+data[i].customer.namaCustomer+'</td>'+
								// '<td>'+data[i].customer.namaCustomer+'</td>'+
								'<td>'+data[i].kamar.noKamar+'</td>'+
								// '<td>'+data[i].kamar.noKamar+'</td>'+
								'<td>'+data[i].checkInDate+'</td>'+
								'<td>'+data[i].checkInTime+'</td>'+
								'<td>'+data[i].checkOutDate+'</td>'+
								'<td>'+data[i].checkOutTime+'</td>'+
								// '<td>'+data[i].idStatusCheck+'</td>'+
								// '<td>'+data[i].statusCheck.namaStatus+'</td>'+
								'<td>'+data[i].statusCheck.namaStatus+'</td>'+
								'<td>'+data[i].totalHarga+'</td>'
							}
							$('#tbodytransc').html(html);
						},
						error: function(){
							alert('Gagal');
						}
					});
				}
	});
});
</script> --%>
