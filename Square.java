import javax.swing.*;
import java.awt.*;

/**
 * Represents a square with a specified side length, position, and color.
 */
public class Square {

   /** The side length of the square. */
   private int side;

   /** The x-coordinate of the square's position. */
   private int x;  

   /** The y-coordinate of the square's position. */
   private int y; 

   /** The color of the square. */
   private Color c;

   /**
    * Default constructor for Square.
    * Initializes the square with default values.
    */
   public Square() {
      side = 10;
      x = 10;
      y = 10;
      c = Color.WHITE;
   }

   /**
    * Constructs a square with specified side length, position, and color.
    * 
    * @param sideValue the side length of the square
    * @param xValue the x-coordinate of the square's position
    * @param yValue the y-coordinate of the square's position
    * @param cValue the color of the square
    */
   public Square(int sideValue, int xValue, int yValue, Color cValue) {
      side = sideValue;
      x = xValue;
      y = yValue;
      c = cValue;
   }

   /**
    * Gets the side length of the square.
    * 
    * @return the side length of the square
    */
   public int getSide() {
      return side;
   }

   /**
    * Gets the x-coordinate of the square's position.
    * 
    * @return the x-coordinate of the square's position
    */
   public int getX() {
      return x;
   }

   /**
    * Gets the y-coordinate of the square's position.
    * 
    * @return the y-coordinate of the square's position
    */
   public int getY() {
      return y;
   }

   /**
    * Gets the color of the square.
    * 
    * @return the color of the square
    */
   public Color getColor() {
      return c;
   }

   /**
    * Sets the side length of the square.
    * 
    * @param sideValue the new side length of the square
    */
   public void setSide(int sideValue) {
      side = sideValue;
   }

   /**
    * Sets the x-coordinate of the square's position.
    * 
    * @param xValue the new x-coordinate of the square's position
    */
   public void setX(int xValue) {
      x = xValue;
   }

   /**
    * Sets the y-coordinate of the square's position.
    * 
    * @param yValue the new y-coordinate of the square's position
    */
   public void setY(int yValue) {
      y = yValue;
   }

   /**
    * Sets the color of the square.
    * 
    * @param cValue the new color of the square
    */
   public void setColor(Color cValue) {
      c = cValue;
   }

   /**
    * Draws the square on a graphics context.
    * 
    * @param g the graphics context
    */
   public void drawMe(Graphics g) {
      g.setColor(c);
      g.fillRect(x, y, side, side);
   }
      
   /**
    * Returns a string representation of the square.
    * 
    * @return a string representation of the square
    */
   @Override
   public String toString() {
      return "Square at " + x + ", " + y + " with side length " + side + " and color set to " + c;
   }
}
