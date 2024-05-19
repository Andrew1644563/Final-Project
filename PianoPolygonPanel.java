import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.util.ArrayList;
import java.awt.image.BufferedImage;
import java.io.File;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JOptionPane;

public class PianoPolygonPanel extends JPanel {
   
   private static final Color BACKGROUND = new Color(204, 204, 204);
   private BufferedImage myImage; 
   private Graphics myBuffer;
   private Timer t;
   private ArrayList<Animatable> animationObjects;
   private DisplayPix display;
   private Tile tile1;
   private Tile tile2;
   private Tile tile3;
   private Tile tile4;
   private Tile tile5;
   private Tile tile6;
   private Tile tile7;
   private Tile tile8;

   private ScoreboardPix scoreboard;

   

   
   public PianoPolygonPanel()
   {
      setLayout(new BorderLayout());
      scoreboard = new ScoreboardPix();
      add(scoreboard,BorderLayout.NORTH);
      
      display = new DisplayPix();
      display.addMouseListener(new Mouse());
      
   
      
   
   
   
   
   
   
      myImage =  new BufferedImage(800, 1000, BufferedImage.TYPE_INT_RGB); 
      myBuffer = myImage.getGraphics(); 
      myBuffer.setColor(BACKGROUND);  
      myBuffer.fillRect(0,0,800,1000);
      
      animationObjects = new ArrayList<Animatable>();      
      tile1 = new Tile(200, 0, -100, Color.BLACK, 5);
      animationObjects.add(tile1);
      tile2 = new Tile(200, 200, -300, Color.BLACK, 5);
      animationObjects.add(tile2);
      tile3 = new Tile(200, 400, -500, Color.BLACK, 5);
      animationObjects.add(tile3);
      tile4 = new Tile(200, 600, -700, Color.BLACK, 5);
      animationObjects.add(tile4);
      tile5 = new Tile(200, 600, -900, Color.BLACK, 5);
      animationObjects.add(tile5);
      tile6 = new Tile(200, 400, -1000, Color.BLACK, 5);
      animationObjects.add(tile6);
      tile7 = new Tile(200, 200, -1100, Color.BLACK, 5);
      animationObjects.add(tile7);
      tile8 = new Tile(200, 0, -1200, Color.BLACK, 5);
      animationObjects.add(tile8);

      
           
      t = new Timer(5, new AnimationListener());
      t.start();  
      addKeyListener(new Key());  //Key is a private class defined below
      setFocusable(true);
   
   }
   
   public void paintComponent(Graphics g) 
   {
      g.drawImage(myImage, 0, 0, getWidth(), getHeight(), null);     }
   
   public void animate()
   {
      myBuffer.setColor(BACKGROUND);
      myBuffer.fillRect(0,0,800,1000);
      
      for(Animatable animationObject : animationObjects)
      {
         animationObject.step(); 
         animationObject.drawMe(myBuffer);  
      }         
   
      repaint();
   }
   
   private class AnimationListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)  
      {
         animate(); 
      }
   }
   
   private class Mouse extends MouseAdapter
   {
      public void mouseClicked(MouseEvent e)
      {
         update( e.getX() , e.getY() );
      }
   }
      private void update(int x, int y)
   {
      int rgb = display.getRGB(x,y);
   //
      display.update(x,y);
      //scoreboard.update(display.getCol(),display.getRow(),rgb);
   //
      display.repaint();
   //
      display.requestFocus();
   }
   public static void PlayMusic(String location) {
      try
      {
         File musicPath = new File(location);
         if (musicPath.exists()) {
            AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
            Clip clip = AudioSystem.getClip();
            clip.open(audioInput);
            clip.start();
         }
         else {
            System.out.println("Can't find file");
         }
      }
      catch(Exception e) {
         System.out.println(e);
      }
   }
   private class Key extends KeyAdapter 
   {
      public void keyPressed(KeyEvent e)
      {
         if(e.getKeyCode() == KeyEvent.VK_F) 
         {
            tile1.setColor(new Color(128, 128, 128)); 
            String filepath = "test.wav";
            PlayMusic(filepath);
            
            //tile8.setColor(new Color(128, 128, 128));   
           
         }
         if(e.getKeyCode() == KeyEvent.VK_G)
         {
            tile2.setColor(new Color(128, 128, 128)); 
            String filepath = "test.wav";
            PlayMusic(filepath);

            //tile7.setColor(new Color(128, 128, 128));   
         }
         if(e.getKeyCode() == KeyEvent.VK_H) 
         {
            tile3.setColor(new Color(128, 128, 128)); 
            String filepath = "test.wav";
            PlayMusic(filepath);

            //tile6.setColor(new Color(128, 128, 128));  
           
         }
         if(e.getKeyCode() == KeyEvent.VK_J) 
         {
            tile4.setColor(new Color(128, 128, 128)); 
            String filepath = "test.wav";
            PlayMusic(filepath);
 
            //tile5.setColor(new Color(128, 128, 128));  
           
         }
         
         
      }
      
         }

   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   /*
      setLayout(new BorderLayout());
      
      //At first this is the same as the BorderGUIDemo.
      JLabel title = new JLabel("A simple calculator!");
      title.setFont(new Font("Serif", Font.BOLD, 20));
      title.setHorizontalAlignment(SwingConstants.CENTER);
      add(title, BorderLayout.NORTH);
      
      num = 0;
      number = new JLabel("" + num);
      number.setFont(new Font("Serif", Font.BOLD, 80));
      number.setHorizontalAlignment(SwingConstants.CENTER);
      add(number);
      
      //But: now I want TWO buttons in the west region.  So: let's make a subpanel - a grid layout to hold two buttons.
      JPanel southSubpanel = new JPanel();
      southSubpanel.setLayout(new GridLayout(1, 2));
      
      JButton add = new JButton("Add");
      add.addActionListener(new AddListener());
      southSubpanel.add(add);  //Add the button TO THE SUBPANEL
      
      JButton subtract = new JButton("Subtract");
      subtract.addActionListener(new SubtractListener());
      southSubpanel.add(subtract);  //Add the button TO THE SUBPANEL
      
      JButton multiply = new JButton("Multiply");
      multiply.addActionListener(new MultiplyListener());
      southSubpanel.add(multiply);  //Add the button TO THE SUBPANEL
      
      JButton divide = new JButton("Divide");
      divide.addActionListener(new DivideListener());
      southSubpanel.add(divide);  //Add the button TO THE SUBPANEL
   
      add(southSubpanel, BorderLayout.SOUTH);  //Add the SUBPANEL to the PANEL
      
      //In the east, I want a text field where the user can type and two buttons.
      //One will allow the user to set the current value, the other will add whatever they type.
      //Note again that since we'll need to refer to the text field inside action listeners,
      //every other element is newly DECLARED but we only REFERENCE the field userIn.
      //It does NOT say "JTextField userIn" below; we already declared that field.
      JPanel eastSubpanel = new JPanel();
      eastSubpanel.setLayout(new GridLayout(2, 1));  //Note the 3 this time, to fit 3 GUI elements
      
     
      JLabel righttitle = new JLabel("Enter a number:");
      title.setFont(new Font("Arial", Font.BOLD, 20));
      title.setVerticalAlignment(SwingConstants.BOTTOM);
      eastSubpanel.add(righttitle);
      add(eastSubpanel, BorderLayout.EAST);
      
      userInEast = new JTextField("0", 10);  //Text field will begin displaying the String "0" and be 10 characters wide
      userInEast.setHorizontalAlignment(SwingConstants.CENTER);  //Put the text centered in the text field
      eastSubpanel.add(userInEast);
      add(eastSubpanel, BorderLayout.EAST);
      
      JPanel westSubpanel = new JPanel();
      westSubpanel.setLayout(new GridLayout(2, 1));  //Note the 3 this time, to fit 3 GUI elements
      
      JLabel lefttitle = new JLabel("Enter a number:");
      title.setFont(new Font("Arial", Font.BOLD, 20));
      title.setVerticalAlignment(SwingConstants.BOTTOM);
      westSubpanel.add(lefttitle);
      add(westSubpanel, BorderLayout.WEST);
      
      userInWest = new JTextField("0", 10);  //Text field will begin displaying the String "0" and be 10 characters wide
      userInWest.setHorizontalAlignment(SwingConstants.CENTER);  //Put the text centered in the text field
      westSubpanel.add(userInWest);
      add(westSubpanel, BorderLayout.WEST);
   }
   
   
   //ActionListener for the add 1 button.
   private class AddListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         double westVal = Integer.parseInt(userInWest.getText());
         double eastVal = Integer.parseInt(userInEast.getText());
         num = westVal + eastVal;
         number.setText("" + num);
      }
   }
   
   //ActionListener for the add 5 button.
   private class SubtractListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         double westVal = Integer.parseInt(userInWest.getText());
         double eastVal = Integer.parseInt(userInEast.getText());
         num = westVal - eastVal;
         number.setText("" + num);
      }
   }
   
   //ActionListener for the Reset Value button
   private class MultiplyListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         double westVal = Integer.parseInt(userInWest.getText());
         double eastVal = Integer.parseInt(userInEast.getText());
         num = westVal * eastVal;
         number.setText("" + num);
      }
   }
   
   //ActionListener for the Add Value button
   private class DivideListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         double westVal = Integer.parseInt(userInWest.getText());
         double eastVal = Integer.parseInt(userInEast.getText());
         num = westVal/eastVal;
         number.setText("" + num);
      }
   }
   */

}