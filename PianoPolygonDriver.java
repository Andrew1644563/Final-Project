import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PianoPolygonDriver
{
   public static void main(String[] args)
   { 
      JFrame frame = new JFrame("Piano Polygon");
      frame.setSize(800, 1025);
      frame.setLocation(20, 20);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setContentPane(new PianoPolygonPanel());
      frame.setVisible(true);
   }
}