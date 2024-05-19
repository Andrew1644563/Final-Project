import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;

/**
 * Represents a tile needed for the Piano Polygons game.
 * This class extends the Square class and implements the Animatable interface.
 * 
 * <p>
 * Authors: Andrew Liu, Aashka Doshi, Aarit Koundinya
 * </p>
 */
public class Tile extends Square implements Animatable {
   
   /** The rate of movement for the tile. */
   private int rate;

   /**
    * Default constructor for Tile.
    * Initializes the tile with default values.
    */
   public Tile() {
      super(10, 10, 10, Color.BLACK);
   }
   
   /**
    * Constructs a tile with specified side length, position, color, and movement rate.
    * 
    * @param sV the side length of the tile
    * @param xV the x-coordinate of the tile's position
    * @param yV the y-coordinate of the tile's position
    * @param cV the color of the tile
    * @param r the movement rate of the tile
    */
   public Tile(int sV, int xV, int yV, Color cV, int r) {
      super(sV, xV, yV, cV);
      rate = r;
   }
     
   /**
    * Gets the movement rate of the tile.
    * 
    * @return the movement rate of the tile
    */
   public int getRate() {
      return rate;
   }
   
   /**
    * Sets the movement rate of the tile.
    * 
    * @param dXValue the new movement rate of the tile
    */
   public void setRate(int dXValue) {
      rate = dXValue;
   }
    
   /**
    * Updates the position of the tile by moving it downwards according to its rate.
    */
   public void step() {
      setY(getY() + rate);
   }
}
