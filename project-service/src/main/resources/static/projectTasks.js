function createProject(){
	let checkValidity = validateData();
	if(checkValidity == false){
		validateData();
	}
	else{
		fetch('/project', {
					method:'POST',
					headers: {
					      'Content-Type': 'application/json'
					    },
					    body:JSON.stringify({
					    	name: document.getElementById('name').value,
					    	managerId: document.getElementById('managerId').value,
							testerId: document.getElementById('testerIds').value.split(","),
							developerId: document.getElementById('developerIds').value.split(",")
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
	if(document.getElementById('name').value == null ||document.getElementById('managerId').value == null || document.getElementById('testerIds').value == null ||
		document.getElementById('developerIds').value == null){
			alert("Please fill all fields!");
			return false;
		}
	
	else {
		return true;
	}
}