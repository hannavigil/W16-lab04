package edu.ucsb.cs56.w16.drawings.wjstevenson95.advanced;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import edu.ucsb.cs56.w16.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w16.drawings.utilities.GeneralPathWrapper;
    
/**
 * A main class to view an animation
 *
 * @author William Stevenson
 * @version for CS56, W16
 */

public class AnimatedPictureViewer {

    private int x = 100;
    private int y = 100;
    private int color = 1;
    
    private DrawPanel panel = new DrawPanel();
    
    Thread anim;

    private int dx = 5;

    private double angle = Math.PI/-2.0;

    public static void main(String[] args) {
	new AnimatedPictureViewer().go();
    }

    public void go() {
	JFrame frame = new JFrame();
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	frame.getContentPane().add(panel);
	frame.setSize(640,480);
	frame.setVisible(true);

	frame.getContentPane().addMouseListener(new MouseAdapter() {
		public void mouseEntered(MouseEvent e) {
		    System.out.println("mouse entered");
		    anim = new Animation();
		    anim.start();
		}

		public void mouseExited(MouseEvent e) {
		    System.out.println("Mouse exited");
		    // Kill the animation thread
		    anim.interrupt();
		    while(anim.isAlive()) {}
		    anim = null;
		    panel.repaint();
		}
	    });
    } // go()

    class DrawPanel extends JPanel {
	public void paintComponent(Graphics g) {

	    Graphics2D g2 = (Graphics2D) g;

	    // Clear the panel
	    g2.setColor(Color.WHITE);
	    g2.fillRect(0,0,this.getWidth(),this.getHeight());

	    // Draw keyboard and set color
	    Keyboard keyboard = new Keyboard(x,y,300,75);
	    if(color == 0) {
		g2.setColor(Color.BLUE);
	    } else {
		g2.setColor(Color.GREEN);
	    }
	    g2.draw(keyboard);

	    // Rotate the keyboard
	    //Shape k1 = edu.ucsb.cs56.w16.drawings.utilities.ShapeTranforms.rotatedCopyOf(keyboard,angle);
	    
	}
    }

    class Animation extends Thread {
	public void run() {
	    try {
		while(true) {
		    // Bounce off the walls and change color
		    
		    if(x >= 400) {
			dx = -5;
			color = 0;
		    }
		    if(x <= 50) {
			dx = 5;
			color = 1;
		    }

		    x += dx;
		    y += dx;
		    panel.repaint();
		    Toolkit.getDefaultToolkit().sync();
		    Thread.sleep(50);
		}
	    } catch(Exception ex) {
		if(ex instanceof InterruptedException) {
		    // Do nothing
		} else {
		    ex.printStackTrace();
		    System.exit(1);
		}
	    }
	}
    }

}