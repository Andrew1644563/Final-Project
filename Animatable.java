import javax.swing.*;
import java.awt.*;

/**
 * Animatable interface representing objects that can be animated and drawn on the screen.
 * 
 * <p>
 * Authors: Andrew Liu, Aashka Doshi, Aarit Koundinya
 * </p>
 */
public interface Animatable {
   
   /**
    * Updates the state of the object for animation.
    */
   public void step();
   
   /**
    * Draws the object on the screen using the provided graphics context.
    * 
    * @param g the graphics context used for drawing the object
    */
   public void drawMe(Graphics g);
}
