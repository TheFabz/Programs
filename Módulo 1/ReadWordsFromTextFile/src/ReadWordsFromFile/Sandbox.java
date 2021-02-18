package ReadWordsFromFile;

import java.io.*;

public class Sandbox {

    public static void main(String[] args) throws IOException {

        BufferedReader inputStream = new BufferedReader(new FileReader("resources/fileToRead.txt"));

            String l;

            while ((l = inputStream.readLine()) != null) {
                String[] lineWords = l.split(" ");
                for(String i : lineWords){
                    System.out.println(i);
                }
            }

            inputStream.close();

        }
    }


