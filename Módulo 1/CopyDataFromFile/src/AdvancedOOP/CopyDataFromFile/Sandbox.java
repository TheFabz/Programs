package AdvancedOOP.CopyDataFromFile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class Sandbox {

    public static void main(String[] args) throws IOException {

        FileInputStream inputStream = new FileInputStream("resources/GameOver.wav");
        FileOutputStream outputStream = new FileOutputStream("resources/test.wav");

        byte[] buffer = new byte[1024];

        int lengthRead;

        while ((lengthRead = inputStream.read(buffer)) != -1) {
            outputStream.write(buffer, 0, lengthRead);
            outputStream.flush();
            System.out.println(lengthRead);
        }

        inputStream.close();
        outputStream.close();
    }
}
