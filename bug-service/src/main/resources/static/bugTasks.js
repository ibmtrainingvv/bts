function createBug(){
	
		
			let bugd = {};

			let error = 0;
			let errorText="";
		
			let name = document.getElementById('bugname').value
			if (name) {
				let remText = name.replace(/ /g, "");
				if (remText.length < 5 || remText.length > 25) {
					error++;
					errorText += error + ". Error- Name should be minimum 5 and maximum 25) \n";
				}
				else {
					bugd.name = name;
				}
		
			}
			else {
				error++;
				errorText += error + ". Error- Name is mandatory \n";
			}
		
		
			let status = document.getElementById('status').value;
			if (status) {
				bugd.status = status;
			}
			else {
				error++;
				errorText += error + ". Error- status is mandatory \n";
			}
		
			let priority = document.getElementById('bugpriority').value;
			if (priority) {
				bugd.priority = priority;
			}
			else {
				error++;
				errorText += error + ". Error- priority is mandatory \n";
			}
		
			let severity = document.getElementById('severity').value;
			if (severity) {
				bugd.severity = severity;
			}
			else {
				error++;
				errorText += error + ". Error- severity is mandatory \n";
			}
		
			let type = document.getElementById('type').value;
			if (type) {
				bugd.type = type;
			}
			else {
				error++;
				errorText += error + ". Error- type is mandatory \n";
			}
		
			let projectId = document.getElementById('idproject').value
			if (projectId) {
				let remText = projectId.replace(/ /g, "");
				if (remText.length < 1 || remText.length > 25 || remText.length != projectId.length) {
					error++;
					errorText += error + ". Error- projectId should be minimum 1 and maximum 25 and spaces not allowed) \n";
				}
				else {
					bugd.projectId = projectId;
				}
		
			}
			else {
				error++;
				errorText += error + ". Error- projectId is mandatory \n";
			}
		
			let synopsis = document.getElementById('synopsis').value
			if (synopsis) {
				let remText = synopsis.replace(/ /g, "");
				if (remText.length < 10 || remText.length > 50) {
					error++;
					errorText += error + ". Error- synopsis should be minimum 10 and maximum 50) \n";
				}
				else {
					bugd.synopsis = synopsis;
				}
		
			}
			else {
				error++;
				errorText += error + ". Error- synopsis is mandatory \n";
			}
		
			let module = document.getElementById('module').value
			if (module) {
				let remText = module.replace(/ /g, "");
				if (remText.length < 1 || remText.length > 50) {
					error++;
					errorText += error + ". Error- module should be minimum 10 and maximum 50) \n";
				}
				else {
					bugd.module = module;
				}
		
			}
			else {
				error++;
				errorText += error + ". Error- module is mandatory \n";
			}
		
			let description = document.getElementById('description').value
			if (description) {
				let remText = description.replace(/ /g, "");
				if (remText.length < 10 || remText.length > 200) {
					error++;
					errorText += error + ". Error- description should be minimum 10 and maximum 200) \n";
				}
				else {
					bugd.description = description;
				}
		
			}
			else {
				error++;
				errorText += error + ". Error- description is mandatory \n";
			}
		
			let buildVersion = document.getElementById('buildversion').value
			if (buildVersion) {
				let remText = buildVersion.replace(/ /g, "");
				if (remText.length < 1 || remText.length > 25) {
					error++;
					errorText += error + ". Error- buildVersion should be minimum 1 and maximum 25) \n";
				}
				else {
					bugd.buildVersion = buildVersion;
				}
			}
		
		
		
			let submitOn = document.getElementById('date').value
			if (submitOn) {
				bugd.eta = submitOn;
			}
		
			let testerId = document.getElementById('testerid').value
			if (testerId) {
				let remText = testerId.replace(/ /g, "");
				if (remText.length < 1 || remText.length > 25 || remText.length != testerId.length) {
					error++;
					errorText += error + ". Error- testerId should be minimum 1 and maximum 25 and no spaces allowed) \n";
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
					errorText += error + ". Error- developerId should be minimum 1 and maximum 25 and no spaces allowed) \n";
				}
				else {
					bugd.developerId = developerId;
				}
			}
			let id = document.getElementById('id').value
			if (id) {
				let remText = id.replace(/ /g, "");
				if (remText.length < 1 || remText.length > 25 || remText.length != id.length) {
					error++;
					errorText += error + ". Error- id should be minimum 1 and maximum 25 and no spaces allowed) \n";
				}
				else {
					bugd.id = id;
				}
			}
		
			if (error) {
				if (error < 4)
					return alert("Total error are : " + error+ "\n" + errorText);
				else {
					return alert("total Errors are : " + error + "\n"+ errorText);
				}
				console.log((bugd));
			}
			
			function success(response){
				if(!response.ok)
				{
					return(alert("error !!"));
				}
							showToast(alert("bug created"));

			}

			fetch('/bug', {

				method:'POST',
				headers: {
				      'Content-Type': 'application/json'
				    },

				    body:JSON.stringify(bugd)
			})
			.then(success);
}

function getProject() {
	fetch('http://localhost:8082/project/')
		.then(response => response.json())
		.then(json => {
			let radr = JSON.stringify(json)
			radr = JSON.parse(radr)
			let txt2 = "<label><b>Project ID's <span style=\"color:red\">*</span></b></label><select name=\"idproject\" id=\"idproject\" class=\"form-control\"   >";
			for (let i = 0; i < radr.length; i++) {
				txt2 += "<option value='" + radr[i].id + "'>" + radr[i].id + "  " + radr[i].name + "</option>";
			}
			txt2 += "</select>";
			if (document.getElementById('idproject1')) {
				document.getElementById('idproject1').innerHTML = txt2;
			}
		})

}
getProject();

function showToast(){
	var toast = document.getElementById("toast");
	toast.className = "show";
	setTimeout(function(){ toast.className = toast.className.replace("show", ""); }, 3000);
}

