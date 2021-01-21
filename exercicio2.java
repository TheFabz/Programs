class exercicio2 {
	public static void main(String[] args) {

    notString("semicolon");
    notString("not test");

    //receive command line argument if available
    if(args.length>0){
      notString(args[0]);
    }
}

private static void notString(String str) {

	String isNotPresent = str.substring(0,3);
	String notText = "not";

	if (isNotPresent.equals(notText) == false ) {
		
		String modString = (notText + " " + str);
		
		System.out.println(modString);

	}

	else{
		
		System.out.println(str);

	}

    // print result here

}

}
