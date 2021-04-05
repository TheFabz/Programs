package org.academiadecodigo.mapFilterReduce;

import java.util.stream.Stream;

public class Sandbox {

    public static void main(String[] args) {

        String message = "I'll send an SOS to the garbage world, " + "I hope that someone garbage gets my message in a garbage bottle.";

        String streamString = Stream.of(message.split(" "))
                .filter(word -> (!word.equals("garbage")))
                .map(String::toUpperCase)
                .reduce("", (acc, elem) -> acc + elem + " ");
        
        System.out.println(streamString);

    }
}

