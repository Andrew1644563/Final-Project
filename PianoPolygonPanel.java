import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.util.ArrayList;
import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 * PianoPolygonPanel class representing the main panel for the Piano Polygons game.
 * The game is based on the idea of Piano Tiles.
 * 
 * <p>
 * Authors: Andrew Liu, Aashka Doshi, Aarit Koundinya
 * </p>
 */
public class PianoPolygonPanel extends JPanel implements MouseListener {
   
   /** The background color of the panel. */
   private static final Color BACKGROUND = new Color(204, 204, 204);
   
   /** The buffered image used for double buffering to reduce flickering. */
   private BufferedImage myImage; 
   
   /** The graphics context of the buffered image. */
   private Graphics myBuffer;
   
   /** The timer that triggers animation updates. */
   private Timer t;
   
   /** The list of animatable objects (tiles) in the game. */
   private ArrayList<Animatable> animationObjects;
   
   /** The first tile in the game. */
   private Tile tile1;
   
   /** The second tile in the game. */
   private Tile tile2;
   
   /** The third tile in the game. */
   private Tile tile3;
   
   /** The fourth tile in the game. */
   private Tile tile4;
   
   /** The fifth tile in the game. */
   private Tile tile5;
   
   /** The sixth tile in the game. */
   private Tile tile6;
   
   /** The seventh tile in the game. */
   private Tile tile7;
   
   /** The eighth tile in the game. */
   private Tile tile8;
   
   /**
    * Constructor for PianoPolygonPanel. Initializes the game panel, sets up the tiles, and starts the animation.
    */
   public PianoPolygonPanel() {
      setLayout(new BorderLayout());
         
      myImage = new BufferedImage(800, 1000, BufferedImage.TYPE_INT_RGB); 
      myBuffer = myImage.getGraphics(); 
      myBuffer.setColor(BACKGROUND);  
      myBuffer.fillRect(0, 0, 800, 1000);
      
      animationObjects = new ArrayList<>();      
      tile1 = new Tile(200, 0, -100, Color.BLACK, 3);
      animationObjects.add(tile1);
      tile2 = new Tile(200, 200, -300, Color.BLACK, 3);
      animationObjects.add(tile2);
      tile3 = new Tile(200, 400, -500, Color.BLACK, 3);
      animationObjects.add(tile3);
      tile4 = new Tile(200, 600, -700, Color.BLACK, 3);
      animationObjects.add(tile4);
      tile5 = new Tile(200, 600, -900, Color.BLACK, 3);
      animationObjects.add(tile5);
      tile6 = new Tile(200, 400, -1000, Color.BLACK, 3);
      animationObjects.add(tile6);
      tile7 = new Tile(200, 200, -1100, Color.BLACK, 3);
      animationObjects.add(tile7);
      tile8 = new Tile(200, 0, -1200, Color.BLACK, 3);
      animationObjects.add(tile8);
           
      t = new Timer(5, new AnimationListener());
      t.start();  
      addKeyListener(new Key()); 
      addMouseListener(this); // Add mouse listener to the panel
      setFocusable(true);
   }
   
   /**
    * Paints the component.
    * 
    * @param g the graphics context
    */
   @Override
   public void paintComponent(Graphics g) {
      super.paintComponent(g); // Call superclass method to ensure proper painting
      g.drawImage(myImage, 0, 0, getWidth(), getHeight(), null);     
   }
   
   /**
    * Animates the game by updating and redrawing the tiles.
    */
   public void animate() {
      myBuffer.setColor(BACKGROUND);
      myBuffer.fillRect(0, 0, 800, 1000);
      
      for (Animatable animationObject : animationObjects) {
         animationObject.step(); 
         animationObject.drawMe(myBuffer);  
      }         
      repaint();
   }
   
   /**
    * Inner class AnimationListener that listens to the timer events and triggers animation.
    */
   private class AnimationListener implements ActionListener {
      /**
       * Default constructor for AnimationListener.
       */
      public AnimationListener() {
         // Default constructor
      }      /**
       * Invoked when an action occurs.
       * 
       * @param e the action event
       */
      public void actionPerformed(ActionEvent e) {
         animate(); 
      }
   }
   
   /**
    * Plays music from a specified file location.
    * 
    * @param location the file path of the music file
    */
   public static void PlayMusic(String location) {
      try {
         File musicPath = new File(location);
         if (musicPath.exists()) {
            AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
            Clip clip = AudioSystem.getClip();
            clip.open(audioInput);
            clip.start();
         } else {
            System.out.println("Can't find file");
         }
      } catch (Exception e) {
         System.out.println(e);
      }
   }
   
   /**
    * Inner class Key that handles key events for the game.
    */
   private class Key extends KeyAdapter {
      /**
       * Default constructor for Key.
       */
      public Key() {
         // Default constructor
      }

      /**
       * Invoked when a key has been pressed.
       * 
       * @param e the key event
       */
      public void keyPressed(KeyEvent e) {
         if(e.getKeyCode() == KeyEvent.VK_F) {
            tile1.setColor(new Color(128, 128, 128)); 
            String filepath = "test.wav";
            PlayMusic(filepath);           
         }
         if(e.getKeyCode() == KeyEvent.VK_G) {
            tile2.setColor(new Color(128, 128, 128)); 
            String filepath = "test.wav";
            PlayMusic(filepath);   
         }
         if(e.getKeyCode() == KeyEvent.VK_H) {
            tile3.setColor(new Color(128, 128, 128)); 
            String filepath = "test.wav";
            PlayMusic(filepath);
         }
         if(e.getKeyCode() == KeyEvent.VK_J) {
            tile4.setColor(new Color(128, 128, 128)); 
            String filepath = "test.wav";
            PlayMusic(filepath);
         }
      }
   }
   
   
   
   
   /**
    * Invoked when the mouse button has been clicked (pressed and released) on the panel.
    * 
    * @param e the MouseEvent
    */
   public void mouseClicked(MouseEvent e) {
      int x = e.getX();
      int y = e.getY();
      
      for (Animatable animationObject : animationObjects) {
         if (animationObject instanceof Tile) {
            Tile tile = (Tile) animationObject;
            if (tile.contains(x, y)) {
               tile.setColor(new Color(128, 128, 128));
               String filepath = "test.wav";
               PlayMusic(filepath);
               break;
            }
         }
      }
   }

   public void mousePressed(MouseEvent e) {}
   public void mouseReleased(MouseEvent e) {}
   public void mouseEntered(MouseEvent e) {}
   public void mouseExited(MouseEvent e) {}
}

