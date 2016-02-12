package edu.ucsb.cs56.w16.drawings.davidwang.advanced;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.Timer;

import edu.ucsb.cs56.w16.drawings.utilities.ShapeTransforms;

/**
 * A main class to view an animation
 *
 * @author David Wang
 * @version for CS56, W16
 */


public class AnimatedPictureViewer {

    private DrawPanel panel = new DrawPanel();
    private PigWithBody pwb = new PigWithBody(50, 50, 100);

    Thread anim;

    private int x = 100;
    private int y = 100;
    private double radius = 100.0;
    private double angle = 0;
    private double dangle = Math.PI/12.0;
    private int dx = 10;

    public static void main (String[] args) {
      new AnimatedPictureViewer().go();
    }

    public void go() {
      JFrame frame = new JFrame();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      frame.getContentPane().add(panel);
      frame.setSize(900,600);
      frame.setVisible(true);

      frame.getContentPane().addMouseListener(new MouseAdapter() {
        public void mouseEntered(MouseEvent e){
        System.out.println("mouse entered");
          anim = new Animation();
          anim.start();
        }

        public void mouseExited(MouseEvent e){
          System.out.println("Mouse exited");
          // Kill the animation thread
          anim.interrupt();
          while (anim.isAlive()){}
          anim = null;
          panel.repaint();
        }
      });

      frame.getContentPane().addMouseListener(new MouseAdapter() {
        public void mouseClicked(MouseEvent e){
              System.out.println("mouse clicked");
              JOptionPane.showMessageDialog(frame, "OINK! OINK! OINK! OINK!", "You poked the piggy!", JOptionPane.INFORMATION_MESSAGE);
          }
      });

    } // go()

    class DrawPanel extends JPanel {
       public void paintComponent(Graphics g) {

        Graphics2D g2 = (Graphics2D) g;

         // Clear the panel first
          g2.setColor(Color.white);
          g2.fillRect(0,0,this.getWidth(), this.getHeight());

          // Draw the pig
          g2.setColor(Color.PINK);
          PigWithBody test = new PigWithBody(x, y, 100);
          Shape pb3 = ShapeTransforms.rotatedCopyOf(test,angle);
          g2.draw(pb3);

          g2.setColor(Color.BLACK);
          g2.drawString("Click to make the piggy oink!", 350,20);
       }
    }

    class Animation extends Thread {
      public void run() {
        try {
          while (true) {
            // Bounce off the walls

            if (x >= 400) { dx = -5; }
            if (x <= 50) { dx = 5; }
            if (angle >= Math.PI/6.0) {dangle = -Math.PI/12.0;}
            if (angle <= -Math.PI/6.0) {dangle = Math.PI/12.0;}
            angle += dangle;
            x += dx;
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
