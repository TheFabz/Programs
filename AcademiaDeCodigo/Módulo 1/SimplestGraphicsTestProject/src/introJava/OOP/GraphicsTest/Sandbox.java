package introJava.OOP.GraphicsTest;

import org.academiadecodigo.simplegraphics.graphics.Canvas;
import org.academiadecodigo.simplegraphics.graphics.Ellipse;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Sandbox {


    public static void main(String[] args) {


        
        Rectangle rectangle = new Rectangle( 10,10,100,100);

        rectangle.getColor().getGreen();

        rectangle.draw();

        Ellipse circle = new Ellipse(15,15,90,90);

        circle.draw();
    }
}
