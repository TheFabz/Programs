$(document).ready(function(){


    $.get("http://localhost:8080/javabank5/api/customer", function(data){


    data.forEach(element => {

      $("table").append("<tr>" +
      "<td>" + element.firstName + "</td>" +
      "<td>" + element.lastName + "</td>" +
      "<td>" + element.phone + "</td>" +
      "<td>" + element.email + "</td>" +
      
      "</tr>");
    });
     
    });
});
