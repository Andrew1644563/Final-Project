import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;

public class Tile extends Square implements Animatable {
   
   private int rate;
   
   
   public Tile() {
      super(10, 10, 10, Color.BLACK);
   }
   
   public Tile(int sV, int xV, int yV, Color cV, int r) {
      super(sV, xV, yV, cV);

      rate = r;
   }
     
   public int getRate()
   {
      return rate;
   }
   
   //modifiers
   public void setRate(int dXValue)
   {
      rate = dXValue;
   }
    
   public void step() {
      setY(getY()+rate);
   }
      
}