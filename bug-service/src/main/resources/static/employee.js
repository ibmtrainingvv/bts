function getEmployee() {
	let employeeId = document.getElementById('employeeId').value;



	fetch('http://localhost:8080/employee/' + employeeId)
		.then(response => response.json())
		.then(json => {
			let radr = JSON.stringify(json)
			radr = JSON.parse(radr)
			let txt1 = "<table class=\"table table-bordered\"><tr><th scope=\"col\">Id</th><th  scope=\"col\">Name</td><th  scope=\"col\">Email Id</th><th  scope=\"col\">Mobile Number</tr>";

			if (radr.id) {
				txt1 += "<tr scope=\"row\"><td>" + radr.id + "</td><td>" + radr.name + "</td><td>" + radr.emailId + "</td><td>" + radr.mobileNumber + "</td></tr>";
			}
			for (let i = 0; i < radr.length; i++) {
				txt1 += "<tr scope=\"row\"><td>" + radr[i].id + "</td><td>" + radr[i].name + "</td><td>" + radr[i].emailId + "</td><td>" + radr[i].mobileNumber + "</td></tr>";
			}
			txt1 += "</table>";
			document.getElementById('showemployeedata').innerHTML = txt1
		})
		.then(data => console.log(data));

	console.log("hh");



}

function usendemployee() {
	fetch('http://localhost:8080/employee/' + document.getElementById('id').value, {
		method: 'PUT',
		headers: {
			'Content-Type': 'application/json'
		},
		body: JSON.stringify({
			name: document.getElementById('employeename').value,
			emailId: document.getElementById('emailid').value,
			mobileNumber: 1 * document.getElementById('mobilenumber').value,
			projectId: document.getElementById('projectid').value
		})
	})
		.then(response => refresh(alert("employee updated!")));

}

function refresh() {
	fetch('http://localhost:8080/employee/')
		.then(response => response.json())
		.then(json => {
			let radr = JSON.stringify(json)
			radr = JSON.parse(radr)
			let txt1 = "<select name=\"id\" id=\"id\" class=\"form-control\"   style=\"display: block;margin:0 auto;\">";

			for (let i = 0; i < radr.length; i++) {
				txt1 += "<option value='" + radr[i].id + "'>" + radr[i].id + "  " + radr[i].name + "</option>";
			}
			txt1 += "</select>";
			if (document.getElementById('idselect')) {
				document.getElementById('idselect').innerHTML = txt1
			}
		})
		.then(data => {
			if (document.getElementById('showemployeedata')) {
				getEmployee()
			}
		})
}

refresh();