function getBug()
{
    let bugId=document.getElementById('bugId').value;
   
		
	
        fetch('/bug/'+bugId)
       .then(response => response.json())
               .then(json => {
                     let radr =  JSON.stringify(json)
                      radr = JSON.parse(radr)
                    let txt1= "<table class=\"table table-bordered\"><tr><th scope=\"col\">Id</th><th  scope=\"col\">Name</td><th  scope=\"col\"> Priority</th><th  scope=\"col\">Severity</th><th  scope=\"col\">Project</tr>";

                      if(radr.id)
                          {
                            txt1+="<tr scope=\"row\"><td>"+radr.id+"</td><td>"+radr.name+"</td><td>"+radr.priority+"</td><td>"+radr.severity+"</td><td>"+radr.projectId+"</td></tr>";
                          }
                     for(let i=0;i<radr.length;i++){
                    txt1+="<tr scope=\"row\"><td>"+radr[i].id+"</td><td>"+radr[i].name+"</td><td>"+radr[i].priority+"</td><td>"+radr[i].severity+"</td><td>"+radr.projectId+"</td></tr>";
                     }
                     txt1+="</table>";
                    document.getElementById('showbugdata').innerHTML =txt1})
		  .then(data => console.log(data));

console.log("hh");
       
      

}

function usendData() {
		fetch('/user/'+document.getElementById('id').value, {
			method:'PUT',
			headers: {
			      'Content-Type': 'application/json'
			    },
			    body:JSON.stringify({
			    	name: document.getElementById('uusername').value,
			    	email: document.getElementById('uemail').value,
			    	mobile: document.getElementById('umobile').value


			    })
		})
		.then(response=>refresh());

	}
	
	function refresh()
	{
	 fetch('/user/')
	  .then(response => response.json())
			  .then(json => {
			        let radr =  JSON.stringify(json)
			         radr = JSON.parse(radr)
			         				        let txt1= "<select name=\"id\" id=\"id\" >";

			        for(let i=0;i<radr.length;i++){
			       txt1+="<option value='"+radr[i].id+"'>"+radr[i].id +"  "+radr[i].name+"</option>";
					}
					txt1+="</select>";
				   document.getElementById('idselect').innerHTML =txt1})
				   .then(data => 	console.log("done"));
	}