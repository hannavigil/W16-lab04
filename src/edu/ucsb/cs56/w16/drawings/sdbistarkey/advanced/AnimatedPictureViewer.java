package edu.ucsb.cs56.w16.drawings.sdbistarkey.advanced;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import edu.ucsb.cs56.w16.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w16.drawings.utilities.GeneralPathWrapper;

/**
 * A main class to view an animation
 *
 * @author Skyler Bistarkey-Rez
 * @version for CS56, W16
 */


public class AnimatedPictureViewer {

    private DrawPanel panel = new DrawPanel();
    
    private SmartPhoneWithBackground spbg =
	new SmartPhoneWithBackground(50, 50, 50, 100);
    
    Thread animation;   
    
    private int x = 50;
    private int y = 50;
    
    private int dx = 5;
    private int dy = -5;
    private double rotate = 0;
    //The smartphone will rotate pi/24 radians every update
    private double drotate = (Math.PI/24.0);

    public static void main (String[] args) {
      new AnimatedPictureViewer().go();
    }

    public void go() {
      JFrame frame = new JFrame();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      frame.getContentPane().add(panel);
      frame.setSize(640,480);
      frame.setTitle("Skyler's Rotating Smartphone");
      frame.setVisible(true);
      
      frame.getContentPane().addMouseListener(new MouseAdapter() {
        public void mouseEntered(MouseEvent e){
        System.out.println("Mouse entered");
          animation = new Animation();
          animation.start();
        }

        public void mouseExited(MouseEvent e){        
          System.out.println("Mouse exited");
          // Kill the animation thread
          animation.interrupt();
          while (animation.isAlive()){}
          animation = null;         
          panel.repaint();        
        }
      });
      
    } // go()

    class DrawPanel extends JPanel {
       public void paintComponent(Graphics g) {

        Graphics2D g2 = (Graphics2D) g;

         // Clear the panel first
          g2.setColor(Color.white);
          g2.fillRect(0,0,this.getWidth(), this.getHeight());

          // Draw the SmartPhone
          g2.setColor(Color.MAGENTA);
          SmartPhoneWithBackground temp =
	      new SmartPhoneWithBackground(x, y, 50, 100);

	  //rotate it using the ShapeTransforms class
	  Shape newAnimationPicture =
	      ShapeTransforms.rotatedCopyOf(temp, rotate);
          g2.draw(newAnimationPicture);
       }
    }
    
    class Animation extends Thread {
      public void run() {
        try {
          while (true) {
	      
            // Bounce off the walls and spins
	    // Creates an old windows 95 background feel
            if (x >= 590) { dx = -5; }
            if (x <= 0) { dx = 5; }
	    if (y >= 380) {dy = -5;}
	    if (y <= 0) {dy = 5;}

	    //This is just so the rotation amount will stay between
	    //0 and 2pi radians
	    //More for debug because the computer doesn't care how many rads
	    if (rotate >= (Math.PI*2.0)) {rotate = 0.0;}
            
            x += dx;
	    y += dy;
	    rotate += drotate;
            panel.repaint();
            Thread.sleep(50);
          }
        } catch(Exception ex) {
          if (ex instanceof InterruptedException) {
            // Do nothing - expected on mouseExited
          } else {
            ex.printStackTrace();
            System.exit(1);
          }
        }
      }
    }
}
