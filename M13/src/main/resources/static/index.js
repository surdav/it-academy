$(document).ready(function() {
	updateTable();
});

const table = $('#employeeTable').DataTable({
	rowId: 0,
	columnDefs: [
		{ targets: '_all', className: 'text-center' }]
});

//Read employee List & Update the table
function updateTable() {
	$.get("/EmployeeList", function(data) {
		table.clear();
		$.each(data, function(i, employee) {
			table.row.add(createRow(employee)).draw();
		});
	});
}

//Create Row for DataTables Format
function createRow(employee) {
	return [
		employee.id,
		employee.name,
		employee.job,
		employee.salary,
		//Edit button with Icon
		"<a role='button' class='btn btn-light btn-table' data-toggle='modal' data-target='#modal' " +
		"onclick='editEmployee(" + employee.id + ")'>" +
		"<i class='bi bi-pencil-square icon'></i></a>" +
		//Delete button with Icon
		"<a role='button' type='button' class='btn btn-danger btn-table'" +
		" onclick='deleteEmployee(" + employee.id + ")'>" +
		"<i class='bi bi-person-dash-fill icon' style='color:white'></i></a>"
	];
}

//Create & update
function sendEmployee() {
	//create employee
	if ($('#action').val() === 'Añadir') {
		$.ajax({
			url: '/EmployeeList',
			type: 'POST',
			contentType: 'application/Json',
			data: JSON.stringify({
				"name": $('#name').val(),
				"job": $('#job').val()
			}),
			success: function(data, textStatus, jQxhr) {
				table.row.add(createRow(data)).order([0, 'asc']).page('last').draw(false);
			},
			error: function(xhr, textStatus) {
				console.log(textStatus);
			}
		});
		//Update employee
	} if ($('#action').val() === 'Actualizar') {
		$.ajax({
			url: '/EmployeeList/' + $('#idEmployee').val(),
			type: 'PUT',
			contentType: 'application/Json',
			data: JSON.stringify({
				"id": $('#idEmployee').val(),
				"name": $('#name').val(),
				"job": $('#job').val()
			}),
			success: function(data) {
				const rowSelector = "#" + data.id;
				table.row(rowSelector).data(createRow(data)).draw(false);
				$('#modal').modal('hide');
			},
			error: function(xhr, textStatus) {
				console.log(textStatus);
			}
		});
	}
	$('#EmployeeForm').trigger('reset');
	$('#action').val('Añadir');
	$('#formType').html('Añadir nuevo');
}

//Delete employee
function deleteEmployee(id) {
	bootbox.confirm({
		size: "small",
		message: "Seguro que quiere eliminar el Empleado?",
		centerVertical: "modal-dialog-centered",
		buttons: {
			confirm: {
				label: 'Eliminar',
				classcourse: 'btn-danger'
			},
			cancel: {
				label: 'Cancelar',
				classcourse: 'btn-default'
			}
		},
		callback: function(result) {
			if (result === true) {
				$.ajax({
					type: "DELETE",
					url: "/EmployeeList/" + id,
					success: function(data, textStatus, jQxhr) {
						const rowSelector = "#" + id;
						table.row(rowSelector).remove().draw(false);
					},
					error: function(xhr, textStatus) {
						console.log(textStatus);
					}
				});
			}
		}
	});
}

//Read one employee info and put in the modifier form.
function editEmployee(id) {
	$.get("/EmployeeList/" + id, function(data) {
		$('#idEmployee').val(data.id);
		$('#name').val(data.name);
		$('#job').val(getJobCode(data.job));
	});
	$('#action').val('Actualizar');
	$('#formType').html('Actualizar');
}

//Set Form in New Employee Mode
function newEmployee() {
	$('#EmployeeForm').trigger('reset');
	$('#action').val('Añadir');
	$('#formType').html('Añadir nuevo');
}

//Take the enum codes for Employee Jobs.
function getJobCode(job) {
	if (job === 'Director de proyectos') {
		return 'Director_Projectes';
	} if (job === 'Programador Senior') {
		return 'Programador_Senior';
	} if (job === 'Programador Mid-Level') {
		return 'Programador_Mid';
	} if (job === 'Programador Junior') {
		return 'Programador_Junior';
	} if (job === 'Administrativo') {
		return 'Administrativo';
	} else {
		return "Default";
	}
}
