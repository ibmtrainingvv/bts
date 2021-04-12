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
	bugd=JSON.stringify({
			name: document.getElementById('bugname').value,
			status: document.getElementById('status').value,
			priority: document.getElementById('bugpriority').value,
			//submitOn: document.getElementById('date').value,
			buildVersion: document.getElementById('buildversion').value,
			module: document.getElementById('module').value,
			type: document.getElementById("type").value,
			severity: document.getElementById('severity').value,
			projectId: document.getElementById('projectid').value,
			developerId: document.getElementById('developerid').value,
			testerId: document.getElementById('testerid').value,
			synopsis: document.getElementById('synopsis').value,
			description: document.getElementById('description').value
			});
			{
let remText = bugd.name.replace(/ /g, "");
if(remText.length<5 || remText.length>25)
{
	return alert("name should be min 5 and max 25 withou space");
};

let remText = bugd.buildVersion.replace(/ /g, "");
if(remText.length<1 || remText.length>25)
{
	return alert("build version should be min 1 and max 25 withou space");
};
let remText = bugd.synopsis.replace(/ /g, "");
if(remText.length<10 || remText.length>50)
{
	return alert("synopsis should be min 10 and max 50 withou space");
};
let remText = bugd.description.replace(/ /g, "");
if(remText.length<10 || remText.length>50)
{
	return alert("descriptiom should be min 10 and max 50 withou space");
};
let remText = bugd.projectId.replace(/ /g, "");
if(remText.length<1 || remText.length>25)
{
	return alert("projectId should be min 1 and max 25 withou space");
};
}
			
	fetch('/bug/' + document.getElementById('id').value, {
		method: 'PUT',
		headers: {
			'Content-Type': 'application/json'
		},
		body: JSON.stringify({
			name: document.getElementById('bugname').value,
			status: document.getElementById('status').value,
			priority: document.getElementById('bugpriority').value,
			//submitOn: document.getElementById('date').value,
			buildVersion: document.getElementById('buildversion').value,
			module: document.getElementById('module').value,
			type: document.getElementById("type").value,
			severity: document.getElementById('severity').value,
			projectId: document.getElementById('projectid').value,
			developerId: document.getElementById('developerid').value,
			testerId: document.getElementById('testerid').value,
			synopsis: document.getElementById('synopsis').value,
			description: document.getElementById('description').value

		})
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
				document.getElementById('idselect').innerHTML = txt1
			}
		})
		.then(data => {
			if (document.getElementById('showbugdata')) {
				getBug()
			}
		})
}

refresh();