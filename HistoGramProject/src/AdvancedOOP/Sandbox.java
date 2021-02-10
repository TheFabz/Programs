package AdvancedOOP;

public class Sandbox {

    public static void main(String[] args) {

        String string = "Test morango Banana test test test Kivi Kivi test";

        WordCounter wordCounter = new WordCounter(string);

        System.out.println("MAP has " + wordCounter.size() + " distinct words.");

        for(String word : wordCounter){
            System.out.println(word + " : " + wordCounter.get(word));
        }

    }
}
