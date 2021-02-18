package org.advancedOOP.paintProgram;

import java.io.*;

public class FileManager {

    String newFileName = ("resources/cache/output.txt");

    FileOutputStream outputStream;
    BufferedReader inputStream;

    public FileManager() throws IOException {

    }

    public void startOutput() throws FileNotFoundException {
        outputStream = new FileOutputStream(newFileName);
    }

    public void startInput() throws FileNotFoundException {
        inputStream = new BufferedReader(new FileReader(newFileName));
    }

}

