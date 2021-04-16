function createEmployee(){
	let checkValidity = validateData();
	if(checkValidity == false){
		validateData();
	}
	else{
		fetch('/employee', {
				method:'POST',
				headers: {
				      'Content-Type': 'application/json'
				    },
				    body:JSON.stringify({
						name: document.getElementById('employeeName').value,
				    	projectId: document.getElementById('projectId').value,
				    	emailId: document.getElementById('emailId').value,
						mobileNumber: document.getElementById('mobileNumber').value
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
	if(document.getElementById('employeeName').value == null ||document.getElementById('projectId').value == null || document.getElementById('emailId').value == null ||
		document.getElementById('mobileNumber').value == null){
			alert("Please fill all fields!");
			return false;
		}
	
	else {
		return true;
	}
}