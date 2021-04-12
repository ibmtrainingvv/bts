function getProject() {
	let projectId = document.getElementById('projectId').value;



	fetch('http://localhost:8082/project/' + projectId)
		.then(response => response.json())
		.then(json => {
			let radr = JSON.stringify(json)
			radr = JSON.parse(radr)
			let txt1 = "<table class=\"table table-bordered\"><tr><th scope=\"col\">Id</th><th  scope=\"col\">Name</td><th  scope=\"col\"> Manager Id</th><th  scope=\"col\">Tester Id</th><th  scope=\"col\">Developer Id</tr>";

			if (radr.id) {
				txt1 += "<tr scope=\"row\"><td>" + radr.id + "</td><td>" + radr.name + "</td><td>" + radr.managerId + "</td><td>" + radr.testerId + "</td><td>" + radr.developerId + "</td></tr>";
			}
			for (let i = 0; i < radr.length; i++) {
				txt1 += "<tr scope=\"row\"><td>" + radr[i].id + "</td><td>" + radr[i].name + "</td><td>" + radr[i].managerId + "</td><td>" + radr[i].testerId + "</td><td>" + radr[i].developerId + "</td></tr>";
			}
			txt1 += "</table>";
			document.getElementById('showprojectdata').innerHTML = txt1
		})
		.then(data => console.log(data));

	console.log("hh");



}

function usendproject() {
	fetch('http://localhost:8082/project/' + document.getElementById('id').value, {
		method: 'PUT',
		headers: {
			'Content-Type': 'application/json'
		},
		body: JSON.stringify({
			name: document.getElementById('projectname').value,
			developerId: document.getElementById('developerids').value.split(','),
			testerId: document.getElementById('testerids').value.split(','),
			managerId: document.getElementById('managerid').value
		})
	})
		.then(response => refresh(alert("project updated!")));

}

function refresh() {
	fetch('http://localhost:8082/project/')
		.then(response => response.json())
		.then(json => {
			let radr = JSON.stringify(json)
			radr = JSON.parse(radr)
			let txt1 = "<select name=\"id\" id=\"id\" class=\"form-control\"  style=\"display: block;margin:0 auto;\">";

			for (let i = 0; i < radr.length; i++) {
				txt1 += "<option value='" + radr[i].id + "'>" + radr[i].id + "  " + radr[i].name + "</option>";
			}
			txt1 += "</select>";
			if (document.getElementById('idselect')) {
				document.getElementById('idselect').innerHTML = txt1
			}
		})
		.then(data => {
			if (document.getElementById('showprojectdata')) {
				getProject()
			}
		})
}

refresh();