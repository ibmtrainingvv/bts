
function updateBug() {
    document.getElementById("bugDetails").style.visibility = "hidden";
    document.getElementById("updateBugDetails").style.visibility = "visible";
    document.getElementById("bugDetails").style.display = "none";
    document.getElementById("updateBugDetails").style.display = "block";
}

function isNumber(keyEvent) {
    let charCode = (keyEvent.which) ? keyEvent.which : keyEvent.keyCode
    if (charCode > 31 && (charCode < 48 || charCode > 57))
        return false;
    return true;
}

function createBug(){
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

function showToast(){
	var toast = document.getElementById("toast");
	toast.className = "show";
	setTimeout(function(){ toast.className = toast.className.replace("show", ""); }, 3000);
}