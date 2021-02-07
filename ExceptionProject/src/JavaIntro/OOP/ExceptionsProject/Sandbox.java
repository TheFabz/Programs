package JavaIntro.OOP.ExceptionsProject;

import JavaIntro.OOP.ExceptionsProject.FileException.FileNotFoundException;
import JavaIntro.OOP.ExceptionsProject.FileException.NotEnoughPermissionsException;
import JavaIntro.OOP.ExceptionsProject.FileException.NotEnoughSpaceException;

public class Sandbox {
    public static void main(String[] args) throws FileNotFoundException, NotEnoughPermissionsException, NotEnoughSpaceException {

        FileManager manager = new FileManager();


        /*manager.logIn();

        manager.createFile("1");
        manager.createFile("2");
        manager.createFile("3");
        manager.createFile("4");
        manager.createFile("5");

       try {
           manager.getFile("0");
       }
       catch (FileNotFoundException batata){
           System.out.println(batata.getMessage());
       }*/

        try{
            manager.logOut();
        }
        catch (NotEnoughPermissionsException exemplo){
            System.out.println(exemplo.getMessage());
        }


    }
}
