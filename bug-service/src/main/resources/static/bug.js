function getBug() {
	let bugId = document.getElementById('bugId').value;



	fetch('/bug/' + bugId)
		.then(response => response.json())
		.then(json => {
			let radr = JSON.stringify(json)
			radr = JSON.parse(radr)
			let txt1 = "<table class=\"table table-bordered\"><tr><th scope=\"col\">Id</th><th  scope=\"col\">Name</td><th  scope=\"col\"> Priority</th><th  scope=\"col\">Severity</th><th  scope=\"col\">Project</tr>";

			if (radr.id) {
				txt1 += "<tr scope=\"row\"><td>" + radr.id + "</td><td>" + radr.name + "</td><td>" + radr.priority + "</td><td>" + radr.severity + "</td><td>" + radr.projectId + "</td></tr>";
			}
			for (let i = 0; i < radr.length; i++) {
				txt1 += "<tr scope=\"row\"><td>" + radr[i].id + "</td><td>" + radr[i].name + "</td><td>" + radr[i].priority + "</td><td>" + radr[i].severity + "</td><td>" + radr[i].projectId + "</td></tr>";
			}
			txt1 += "</table>";
			document.getElementById('showbugdata').innerHTML = txt1
		})
		.then(data => console.log(data));

	console.log("hh");



}

function usendbug() {
	let bugd = {};

	let error = 0;
	let errorText="";

	let name = document.getElementById('bugname').value
	if (name) {
		let remText = name.replace(/ /g, "");
		if (remText.length < 5 || remText.length > 25) {
			error++;
			errorText += error + ". Error Name should be minimum 5 and maximum 25) \n";
		}
		else {
			bugd.name = name;
		}

	}
	else {
		error++;
		errorText += error + ". error- Name is mandatory \n";
	}


	let status = document.getElementById('status').value;
	if (status) {
		bugd.status = status;
	}
	else {
		error++;
		errorText += error + ". error- status is mandatory \n";
	}

	let priority = document.getElementById('bugpriority').value;
	if (priority) {
		bugd.priority = priority;
	}
	else {
		error++;
		errorText += error + ". error- priority is mandatory \n";
	}

	let severity = document.getElementById('severity').value;
	if (severity) {
		bugd.severity = severity;
	}
	else {
		error++;
		errorText += error + ". error- severity is mandatory \n";
	}

	let type = document.getElementById('type').value;
	if (type) {
		bugd.type = type;
	}
	else {
		error++;
		errorText += error + ". error- type is mandatory \n";
	}

	let projectId = document.getElementById('idproject').value
	if (projectId) {
		let remText = projectId.replace(/ /g, "");
		if (remText.length < 1 || remText.length > 25 || remText.length != projectId.length) {
			error++;
			errorText += error + ". error- projectId should be minimum 1 and maximum 25 and spaces not allowed) \n";
		}
		else {
			bugd.projectId = projectId;
		}

	}
	else {
		error++;
		errorText += error + ". error- projectId is mandatory \n";
	}

	let synopsis = document.getElementById('synopsis').value
	if (synopsis) {
		let remText = synopsis.replace(/ /g, "");
		if (remText.length < 10 || remText.length > 50) {
			error++;
			errorText += error + ". error- synopsis should be minimum 10 and maximum 50) \n";
		}
		else {
			bugd.synopsis = synopsis;
		}

	}
	else {
		error++;
		errorText += error + ". error- synopsis is mandatory \n";
	}

	let module = document.getElementById('module').value
	if (module) {
		let remText = module.replace(/ /g, "");
		if (remText.length < 1 || remText.length > 50) {
			error++;
			errorText += error + ". error- module should be minimum 10 and maximum 50) \n";
		}
		else {
			bugd.module = module;
		}

	}
	else {
		error++;
		errorText += error + ". error- module is mandatory \n";
	}

	let description = document.getElementById('description').value
	if (description) {
		let remText = description.replace(/ /g, "");
		if (remText.length < 10 || remText.length > 200) {
			error++;
			errorText += error + ". error- description should be minimum 10 and maximum 200) \n";
		}
		else {
			bugd.description = description;
		}

	}
	else {
		error++;
		errorText += error + ". error- description is mandatory \n";
	}

	let buildVersion = document.getElementById('buildversion').value
	if (buildVersion) {
		let remText = buildVersion.replace(/ /g, "");
		if (remText.length < 1 || remText.length > 25) {
			error++;
			errorText += error + ". error- buildVersion should be minimum 1 and maximum 25) \n";
		}
		else {
			bugd.buildVersion = buildVersion;
		}
	}



	let submitOn = document.getElementById('date').value
	if (submitOn) {
		bugd.submitOn = submitOn;
	}

	let testerId = document.getElementById('testerid').value
	if (testerId) {
		let remText = testerId.replace(/ /g, "");
		if (remText.length < 1 || remText.length > 25 || remText.length != testerId.length) {
			error++;
			errorText += error + ". error- testerId should be minimum 1 and maximum 25 and no spaces allowed) \n";
		}
		else {
			bugd.testerId = testerId;
		}

	}



	let developerId = document.getElementById('developerid').value
	if (developerId) {
		let remText = developerId.replace(/ /g, "");
		if (remText.length < 1 || remText.length > 25 || remText.length != developerId.length) {
			error++;
			errorText += error + ". error- developerId should be minimum 1 and maximum 25 and no spaces allowed) \n";
		}
		else {
			bugd.developerId = developerId;
		}
	}

	if (error) {
		if (error < 4)
			return alert("Total error are : " + error + "\n"+ errorText);
		else {
			return alert("total Errors are : " + error + "\n"+ errorText);
		}
		console.log((bugd));
	}



	fetch('/bug/' + document.getElementById('id').value, {
		method: 'PUT',
		headers: {
			'Content-Type': 'application/json'
		},
		body: JSON.stringify(bugd)
	})
		.then(response => refresh(alert("bug updated!")));

}

function refresh() {
	fetch('/bug/')
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
				document.getElementById('idselect').innerHTML = txt1;
				getProject();
			}
		})
		.then(data => {
			if (document.getElementById('showbugdata')) {
				getBug()
			}
		})
}
function getProject() {
	fetch('http://localhost:8082/project/')
		.then(response => response.json())
		.then(json => {
			let radr = JSON.stringify(json)
			radr = JSON.parse(radr)
			let txt2 = "<label><b>Project ID's <span style=\"color:red\">*</span></b></label><select name=\"idproject\" id=\"idproject\" class=\"form-control\"   style=\"margin: auto;\">";
			for (let i = 0; i < radr.length; i++) {
				txt2 += "<option value='" + radr[i].id + "'>" + radr[i].id + "  " + radr[i].name + "</option>";
			}
			txt2 += "</select>";
			if (document.getElementById('idproject1')) {
				document.getElementById('idproject1').innerHTML = txt2;
			}
		})

}
refresh();