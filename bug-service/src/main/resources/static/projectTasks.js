function createProject(){
	fetch('http://localhost:8082/project', {
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

function showToast(){
	var toast = document.getElementById("toast");
	toast.className = "show";
	setTimeout(function(){ toast.className = toast.className.replace("show", ""); }, 3000);
}