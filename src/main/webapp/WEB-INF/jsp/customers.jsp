<%@ include file = "header.jsp" %>
<%@ include file = "nav.jsp" %>
<%-- <%@ include file = "sidebar.jsp" %> --%>

	<div class="w3-container" style="margin-left: 200px">
		<div class="div-title">
			<h3>Data Tamu</h3>
		</div>

		<div class="table-responsive">
			<table class="table table-striped table-bordered text-left">
				<thead>
					<tr>
						<th>Id Customer</th>
						<th>No. Identitas</th>
						<th>Nama Tamu</th>
						<th>No. Telp</th>
						<th>Email</th>
						<th>Alamat</th>
						<th colspan="2">Aksi</th>

					</tr>

				</thead>
				<tbody id="tbody">
					<c:forEach var="customer" items="${customerlist}">
						<tr>
							<td>${customer.idCustomer}</td>
							<td>${customer.noIdentitas}</td>
							<td>${customer.namaCustomer}</td>
							<td>${customer.noTelp}</td>
							<td>${customer.email}</td>
							<td>${customer.alamat}</td>
							<td><a href="edit-customer/${customer.idCustomer}" type="submit"
								class="btn btn-primary"><i class="fas fa-edit"></i> Edit</a></td>
							<%-- <td>
								<!-- Trigger/Open The Modal -->
								<button id="myBtn">Edit
								</button> <!-- The Modal -->
								<div id="myModal" class="modal">

									<!-- Modal content -->
									<div class="modal-content">
										<span class="close">&times;</span>
										<p>Hay</p>
									</div>

								</div>
							</td> --%>

							<td><a href="delete-customer/${customer.idCustomer}" class="btn btn-danger"><i class="far fa-trash-alt"></i>Delete</a></td>
						</tr>
					</c:forEach>

				</tbody>
			</table>
		</div>
		<a href="add-customers" type="submit" class="btn btn-primary"><i
			class="fas fa-user-plus"></i> Tambah Customer</a>
	</div>

	<%@ include file = "footer.jsp" %>
