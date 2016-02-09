package edu.ucsb.cs56.w16.drawings.wjstevenson95.advanced;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * A main class to view an animation
 *
 * @author William Stevenson
 * @version for CS56, W16
 */

public class AnimatedPictureViewer {

    private DrawPanel panel = new DrawPanel();

    private Keyboard keyboard = new Keyboard(100,100,200,50);

    Thread anim;

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
		    anim = new Animation();
		    anim.start();
		}

		public void mouseExited(MouseEvent e) {
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
	    g2.setColor(Color.white);
	    g2.fillRect(0,0,this.getWidth(),this.getHeight());

	    // Draw keyboard
	    g2.setColor(Color.BLUE);
	    Keyboard k1 = new Keyboard(100,100,200,50);
	    g2.draw(k1);

	    // Rotate the keyboard
	    g2.rotate(Math.toRadians(90));
	}
    }

    class Animation extends Thread {
	public void run() {
	    try {
		while(true) {
		    panel.repaint();
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
