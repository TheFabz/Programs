import java.awt.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Sandbox {

    Stream<String> lines = Files.lines(Path.of("resources/data.txt"));
    Stream<String> words = lines.flatMap(line -> Stream.of(line.split(" ")));

    public Sandbox() throws IOException {
    }

    public void findWord(int size){
       // words.findFirst(x -> x.length < 3);
        //words.
      //  words.map( x -> )
       // words.filter(x -> (x.length() > size));
       // words.forEach(System.out::println);
    }

    public long wordCount() {
        return words.count();
    }

    public static void main(String[] args) throws IOException {

        Sandbox sandbox = new Sandbox();

        //sandbox.findWord(3);
        System.out.println("word count: " + sandbox.wordCount());

    }

}
