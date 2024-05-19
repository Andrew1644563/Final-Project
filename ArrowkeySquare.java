import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;

//InflatingCircle extends YOUR Circle class and implements Animatable

//Animatable requires a step() method, which is in this file, and a
//drawMe(Graphics g) method, which you should already have in Circle

public class ArrowkeySquare extends Square implements Animatable
{
   private int dX;
      
   // constructors
   public ArrowkeySquare()
   {
      super(10, 250, 250, Color.WHITE);
      dX = 0;
   }
   
   public ArrowkeySquare(int sideValue, int xValue, int yValue, Color cValue)
   {
      super(sideValue, xValue, yValue, cValue);
      dX = 0;
   }
   
   //accessors
   public int getDX()
   {
      return dX;
   }
   
   //modifiers
   public void setDX(int dXValue)
   {
      dX = dXValue;
   }
   
      
   //instance methods
   public void step()  //Implement Animatable's required step()
   {
      setX(getX() + dX);  
   }
}