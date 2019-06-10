  </body>
</html>

<script>
		function myAccFunc1() {
			var x = document.getElementById("accCheckin");
			if (x.className.indexOf("w3-show") == -1) {
				x.className += " w3-show";
				x.previousElementSibling.className += " w3-lime";
			} else {
				x.className = x.className.replace(" w3-show", "");
				x.previousElementSibling.className = x.previousElementSibling.className
						.replace(" w3-lime", "");
			}
		}
		function myAccFunc2() {
			var x = document.getElementById("accKamar");
			if (x.className.indexOf("w3-show") == -1) {
				x.className += " w3-show";
				x.previousElementSibling.className += " w3-lime";
			} else {
				x.className = x.className.replace(" w3-show", "");
				x.previousElementSibling.className = x.previousElementSibling.className
						.replace(" w3-lime", "");
			}
		}
		function myDropFunc() {
			var x = document.getElementById("demoDrop");
			if (x.className.indexOf("w3-show") == -1) {
				x.className += " w3-show";
				x.previousElementSibling.className += " w3-lime";
			} else {
				x.className = x.className.replace(" w3-show", "");
				x.previousElementSibling.className = x.previousElementSibling.className
						.replace(" w3-lime", "");
			}
		}
		// Get the modal
		var modal = document.getElementById("myModal");

		// Get the button that opens the modal
		var btn = document.getElementById("myBtn");

		// Get the <span> element that closes the modal
		var span = document.getElementsByClassName("close")[0];

		// When the user clicks on the button, open the modal
		btn.onclick = function() {
			modal.style.display = "block";
		}

		// When the user clicks on <span> (x), close the modal
		span.onclick = function() {
			modal.style.display = "none";
		}

		// When the user clicks anywhere outside of the modal, close it
		window.onclick = function(event) {
			if (event.target == modal) {
				modal.style.display = "none";
			}
		}
	</script>

  <script>
  // $(document).ready(function(){
    // =========================================
    // ANGULAR nama alamat no hp order pembayaran via
    var url = "http://localhost:7080/pjihotel/api/v1/getAllTransaksi";
    // "ngRoute", "ngAnimate"
    var transaksiApp = angular.module("transaksiApp", []);

    transaksiApp.controller('transaksiCtrl', function($scope, $http){
      $http.get(url).then(function(response){
        $scope.transaksis = response.data;
      });
    });
  // });
  </script>

  <script>
  // angular routing
  // var routingApp = angular.module('routingApp', ['ngRoute']);
  // routingApp.config(function($routeProvider){
  //   $routeProvider
  //   .when("/", {
  //     templateUrl : "http://localhost:7080/pjihotel/welcome"
  //   })
  //   .when("/transaksi", {
  //     templateUrl : "http://localhost:7080/pjihotel/transaksi"
  //   })
  //   .when("/transaksi/catat", {
  //     templateUrl : "http://localhost:7080/pjihotel/transaksi/catat"
  //   })
  //   .when("/transaksi/edit", {
  //     templateUrl : "http://localhost:7080/pjihotel/transaksi/edit"
  //   })
  //   .when("/transaksi/checkout", {
  //     templateUrl : "http://localhost:7080/pjihotel/transaksi/checkout"
  //   })
  //   .when("/customers", {
  //     templateUrl : "http://localhost:7080/pjihotel/customers"
  //   })
  //   .when("/add-customers", {
  //     templateUrl : "http://localhost:7080/pjihotel/add-customers"
  //   })
  //   .when("/add-room", {
  //     templateUrl : "http://localhost:7080/pjihotel/add-room"
  //   })
  //   .when("/available-room", {
  //     templateUrl : "http://localhost:7080/pjihotel/available-room"
  //   });
  // });
  </script>
