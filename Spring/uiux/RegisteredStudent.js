           function getResponse(){


      console.log("We are in get Response");

      $.ajax({
            type: "GET",
            url: 'http://localhost:8082/student/allstudent',
            async:true, 
            dataType:"json",
            crossDomain:true,
            success: function(response) {

                  console.log("Success in getting values");

                    for(var i=0;i<response.length;i++)
            {
            var table = document.getElementById("myTable");
          /*  console.log(table);*/
            var row = table.insertRow(i+1);
            var cell1 = row.insertCell(0);
            var cell2 = row.insertCell(1);
            var cell3 = row.insertCell(2);
            var cell4 = row.insertCell(3);
            
            cell1.innerHTML = response[i].name;
            cell2.innerHTML = response[i].age;
            cell3.innerHTML = response[i].registrationNumber;

      /*       var edt_bt=document.createElement("button");
            edt_bt.setAttribute("value","Edit");
            edt_bt.innerHTML="Edit";
            edt_bt.setAttribute("class","btn-primary");
            edt_bt.setAttribute("id","edt");
            cell4.appendChild(edt_bt);
*/
            var del_bt=document.createElement("button");
            del_bt.setAttribute("value","Delete");
            del_bt.innerHTML="Delete";
            del_bt.setAttribute("class","btn-primary");
            del_bt.setAttribute("id","del");
/*            del_bt.addEventListner("click",delTask());
*/          del_bt.setAttribute("onClick","javascript:delTask("+i+");");  
            cell4.appendChild(del_bt);

            var add_bt=document.createElement("button");
            add_bt.setAttribute("value","Add");
            add_bt.innerHTML="Add";
            add_bt.setAttribute("class","btn-primary");
            add_bt.setAttribute("id","add");
/*            del_bt.addEventListner("click",delTask());
*/          add_bt.setAttribute("onClick","javascript:addTask();");  
            cell4.appendChild(add_bt);




            }


            }
      });

 }

      


function delTask(reg)
{


console.log("jgfajhsdf");
console.log(reg);


if(window.confirm("Are you sure"))
{
/*console.log("task "+id+" "+"deleted");*/
$.ajax({
      type: "DELETE",
      url: 'http://localhost:8082/delete/student/'+reg,
      async:true, 
      dataType:"json",
      crossDomain:true,
      success: function(response) 
      {
                     
                     window.location.href="RegisteredStudent.html";
      }
});
}
      

}

function addTask()
{

              window.location.href="index.html";
}
