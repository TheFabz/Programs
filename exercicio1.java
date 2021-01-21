class exercicio1 {
	
	public static void main(String[] args) {
	
	missingChar("Robocop", 3);

	 //receive command line argument if available
 	 if(args.length>=2){
   
	 missingChar(args[0], Integer.parseInt(args[1]));
  }
}

private static void missingChar(String str, int n) {
		
 	 // print result here
 	 String part1 = str.substring(0, n);
 	 String part2 = str.substring(n+1, str.length());
 	 String joint = part1 + part2;
 	 System.out.println(joint);

}

}


