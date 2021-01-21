class exercicio3{

public static void main(String[] args) {

    	frontBack("heisenberg");

   	//receive command line argument if available
   	 if(args.length>0){
     	 frontBack(args[0]);
   	 }
}

private static void frontBack(String str) {


	char first = str.charAt(0);

	char last = str.charAt(str.length() -1 );
	
	String modWord = last + str.substring( 1, str.length() -2) + first;
	

	System.out.println(modWord);
	
    // print result here

}

}
