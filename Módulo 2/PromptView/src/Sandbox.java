import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.string.StringInputScanner;
import org.academiadecodigo.bootcamp.scanners.string.StringSetInputScanner;

import java.util.HashSet;
import java.util.Set;

public class Sandbox {

    public static void main(String[] args) {

        Prompt prompt = new Prompt(System.in,System.out);

        StringInputScanner question1 = new StringInputScanner();
        question1.setMessage("Username: ");

       /* PasswordInputScanner question2 = new PasswordInputScanner();
        question2.setMessage("Password: ");*/

        String userInput = prompt.getUserInput(question1);

        Set<String> options = new HashSet<>();
        options.add("password123");

        StringSetInputScanner question3 = new StringSetInputScanner(options);
        question3.setMessage("Password: ");

        System.out.println("User " + (prompt.getUserInput(question3).equals("password123") ? "Password is correct." : "Password is wrong."));

    }

}
