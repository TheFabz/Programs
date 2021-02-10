
public class Sandbox {

    public static void main(String[] args) {

        String string = "this is a test test test this is a . Can you you hear hear this is a test me ? test me hear is a you you you";

        UniqueWord uniqueWord = new UniqueWord(string);

        for ( String word : uniqueWord ) {
            System.out.println(word);
        }

    }


}
