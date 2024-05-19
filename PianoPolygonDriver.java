import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * PianoPolygonDriver class to start the Piano Polygons game.
 * 
 * <p>
 * Authors: Andrew Liu, Aashka Doshi, Aarit Koundinya
 * </p>
 */
public class PianoPolygonDriver {
   
   /**
    * Default constructor for PianoPolygonDriver.
    */
   public PianoPolygonDriver() {
      // Default constructor
   }

   /**
    * The main method to create the JFrame and start the game.
    * 
    * @param args command-line arguments
    */
   public static void main(String[] args) { 
      JFrame frame = new JFrame("Piano Polygon");
      frame.setSize(800, 1025);
      frame.setLocation(20, 20);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setContentPane(new PianoPolygonPanel());
      frame.setVisible(true);
   }
}
