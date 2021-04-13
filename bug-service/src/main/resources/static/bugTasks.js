function createBug(){
	let checkValidity = validateData();
	if(checkValidity == false){
		validateData();
	}
	else{
		fetch('/bug', {
				method:'POST',
				headers: {
				      'Content-Type': 'application/json'
				    },
				    body:JSON.stringify({
						id: document.getElementById('id').value,
				    	name: document.getElementById('name').value,
				    	status: document.getElementById('status').value,
						priority: document.getElementById('priority').value,
						submitOn: document.getElementById('submittedOn').value,
						module: document.getElementById('module').value,
						buildVersion: document.getElementById('buildVersion').value,
						type: document.getElementById('type').value,
						severity: document.getElementById('severity').value,
				    	projectId: document.getElementById('projectId').value,
						developerId: document.getElementById('developerId').value,
						testerId: document.getElementById('testerId').value,
						synopsis: document.getElementById('synopsis').value,
						description: document.getElementById('description').value
				    })
			});
			showToast();
	}
}

function showToast(){
	var toast = document.getElementById("toast");
	toast.className = "show";
	setTimeout(function(){ toast.className = toast.className.replace("show", ""); }, 3000);
}

function validateData(){
	if(document.getElementById('name').value == null ||document.getElementById('status').value == null || document.getElementById('priority').value == null ||
		document.getElementById('module').value == null ||  document.getElementById('type').value == null || document.getElementById('severity').value== null ||
		document.getElementById('projectId').value == null ||document.getElementById('synopsis').value == null || document.getElementById('description').value == null){
			alert("Please fill all fields!");
			return false;
		}
	
	else if(document.getElementById('description').value.length <= 10 || document.getElementById('description').value.length >= 200){
		alert("Description cannot be less than 10 characters and more than 200 characters");
		return false;
	}
	
	else if(document.getElementById('synopsis').value.length <= 10 || document.getElementById('synopsis').value.length >= 50){
		alert("Synopsis cannot be less than 10 characters and more than 200 characters");
		return false;
	}
	
	else if(document.getElementById('name').value.length == 0){
		alert("Name cannot be empty!")
		return false
	}
	
	else {
		return true;
	}
}