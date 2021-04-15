
    $.get("https://api.ratesapi.io/api/latest", function(data){

      $( "input" )
      .keyup(function() {
        var value = $( this ).val();
        $( "p" ).text( value * data.rates.USD );
      })
      .keyup();

    });

    
  


    
