   //
// Torbert, 24 July 2013
//
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.swing.*;
//
public class DisplayPix extends JPanel
{
   private PixelOperations pix = new PixelOperations();
   private BufferedImage img= new BufferedImage(1600,1200,BufferedImage.TYPE_INT_RGB);

   private Graphics buf = img.getGraphics();

   private boolean clicked = false;
   
   private int x , y;

   public DisplayPix()
   {
      int w = img.getWidth();
      int h = img.getHeight();
   }
   public int getXval() // not getX !
   {
      return x;
   } 
   public int getYval() // not getY !
   {
      return y;
   } 
   public int getRGB(int x, int y)
   {
      int xpos = x * img.getWidth( ) / getWidth() ;
      int ypos = y * img.getHeight() / getHeight();
   //
      return img.getRGB(xpos,ypos);
   }      
   public void update(int xval, int yval)
   {
      clicked = true;
   //
      x       = xval;
      y       = yval;
   }  
 
   public void paintComponent(Graphics g)
   {
      g.drawImage( img , 0 , 0 , getWidth() , getHeight() , null );
   //
      if(clicked)
      {
         g.setColor(Color.black);
         g.drawLine(x-5,y-1,x+5,y-1);
         g.drawLine(x-5,y+1,x+5,y+1);
         g.drawLine(x-1,y-5,x-1,y+5);
         g.drawLine(x+1,y-5,x+1,y+5);
      //
         g.setColor(Color.yellow);
         g.drawLine(x-5,y,x-1,y);
         g.drawLine(x+1,y,x+5,y);
         g.drawLine(x,y-5,x,y-1);
         g.drawLine(x,y+1,x,y+5);
      }
   
   }
}
//
// end of file
//