class exercicio4 {

	public static void main(String[] args) {

	String str = "http://www.academiadecodigo.org";
	String domain = str.substring(7); // www.academiadecodigo.org
	String AcademiaString = str.substring(11, 12).toUpperCase() + str.substring(12, 19) + " " + str.substring(19,21) + " " + str.substring(21,22).toUpperCase() +str.substring(22, 27) ;
	String sentenceStart = "I am a Code Cadet at ";
	String finalSentence = (sentenceStart + "<"  + " " + AcademiaString + "_" + " " + ">"  + "," + " "  + domain);

	// print the following message at the end
	// I am a Code Cadet at < Academia de Codigo_ >, www.academiadecodigo.org				

	System.out.println(finalSentence );
}

}

