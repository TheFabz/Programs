package JavaIntro.OOP.ExceptionsProject;

import JavaIntro.OOP.ExceptionsProject.FileException.FileNotFoundException;
import JavaIntro.OOP.ExceptionsProject.FileException.NotEnoughPermissionsException;
import JavaIntro.OOP.ExceptionsProject.FileException.NotEnoughSpaceException;

public class FileManager {

    private File filesArray[] = new File[5];
    private int fileNumber;
    private boolean isLoggedIn;

    public void logIn(){
        System.out.println("Welcome! You have successfully logged in.");
        isLoggedIn = true;
    }

    public void logOut() throws NotEnoughPermissionsException{

        if(!isLoggedIn){
            throw new NotEnoughPermissionsException("You must first be logged in.");
        }

        isLoggedIn = false;
    }

    public void createFile(String fileName) throws NotEnoughPermissionsException, NotEnoughSpaceException {

        if(!isLoggedIn){
            throw new NotEnoughPermissionsException("You must first be logged in.");
        }

        if(fileNumber > 4){
            throw new NotEnoughSpaceException("You have exceeded storage space.");
        }

        System.out.println("Creating a new file.....");
        filesArray[fileNumber] = new File(fileName);
        fileNumber++;
        System.out.println("File " + fileName + ".js created and added to your folder.");

    }

    public void getFile(String fileName) throws FileNotFoundException , NotEnoughPermissionsException{

        if(!isLoggedIn){
            throw new NotEnoughPermissionsException("You must first be logged in.");
        }

        for (int i = 0; i < filesArray.length; i++) {

            if(fileName.equals(filesArray[i].getName())){
                System.out.println("The index of your file is # " + i);
                return;
            }
        }

        for (int i = 0; i < filesArray.length; i++) {

            if(!fileName.equals(filesArray[i].getName())){
                throw new FileNotFoundException("Unable to find your file.");
            }
        }

    }
}
