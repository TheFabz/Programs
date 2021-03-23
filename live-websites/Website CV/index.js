function receiveEmail() {

	var name = document.getElementById("form34").value;
	

	Email.send({
	Host: "smtp.gmail.com",
	Username : "do.not.reply.fabio.rodrigues@gmail.com",
	Password : "Sitel123!",

	  To : 'ffrr.rodrigues@gmail.com',
	  
	  From : document.getElementById("form29").value,
	  
	  Subject : document.getElementById("form32").value,
	  
	  Body :  `<b>${document.getElementById("form34").value} says:</b> <br> ${document.getElementById("form8").value}`,
	  
	}).then(
	  message => alert(`Thank you ${name}, your message was sent successfully.`)
	);
  }


  function sendEmail() {

	var name = document.getElementById("form34").value;

	Email.send({
	Host: "smtp.gmail.com",
	Username : "do.not.reply.fabio.rodrigues@gmail.com",
	Password : "Sitel123!",

	  To : document.getElementById("form29").value,
	  
	  From : "do.not.reply.fabio.rodrigues@gmail.com",
	  
	  Subject : "Thank you for your e-mail.",
	  
	  Body :  `Hello ${name}, <br/>Thanks for getting in touch, I'll reply to your message at the latest. <br/><br/> Fábio Rodrigues <br/> www.fabiorodriguescv.great-site.net`,
	  
	});
  };

  function sortMail(){
	  receiveEmail();
	  sendEmail();
  };