import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;


public class Sandbox {

    public static void main(String[] args) throws IOException {

        Scanner myObj = new Scanner(System.in);
        String message = myObj.nextLine();
        ObjectMapper mapper = new ObjectMapper();

        try {
            Pojo pojo = mapper.readValue(new URL("http://api.funtranslations.com/translate/yoda.json?text=" + message ), Pojo.class);
            System.out.println(pojo);

        } catch (Exception e){
            System.out.println("failed");

        }


    }

}
