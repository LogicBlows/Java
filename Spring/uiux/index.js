function postValues()
{
console.log("Post Values Called");
var name=document.getElementById("student-name").value;
var age=document.getElementById("student-age").value;
var reg=document.getElementById("Registration-Number").value;
console.log(name);
console.log(age);
console.log(reg);


$.ajax({
	type: "POST",
	url: 'http://localhost:8082/register/student',
	async:true, 
	dataType:"json",
	data:{"name":name,"age":age,"registrationNumber":reg},
	crossDomain:true,
	success: function(response) {
		alert("added Success");
			 // id++;
			 console.log(response);
			 /*console.log(response.ID);
			 newElement(response.ID);*/
			 document.getElementById("student-name").value='';
			 document.getElementById("student-age").value='';
				document.getElementById("Registration-Number").value='';
                     window.location.href="RegisteredStudent.html";
				
	},
error:function(err)
{
	alert("values not posted");
	console.log(err);
}

			 


});
}


