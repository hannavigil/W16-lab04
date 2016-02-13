package edu.ucsb.cs56.w16.drawings.j_nguyen.advanced;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.*;

/**
 * A main class to view an animation
 *
 * @author Justin Nguyen
 * @version for CS56, W16
 */


public class AnimatedPictureViewer {

    private DrawPanel panel = new DrawPanel();

    private Speaker speaker = new Speaker(50, 50, 100, 150);

    Thread anim;

    private int x = 50;
    private int y = 50;

    private int dx = 0;
    private int dy = 0;
    private int red = 50;
    private int green = 250;
    private int blue = 100;
    private boolean start = true;
    private Color randColor = new Color(red,green,blue);
    
    public static void main (String[] args) {
	new AnimatedPictureViewer().go();
    }

    public void go() {
	JFrame frame = new JFrame();
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	frame.getContentPane().add(panel);
	frame.setSize(700,700);
	frame.setVisible(true);

	frame.getContentPane().addMouseListener(new MouseAdapter() {
		public void mouseEntered(MouseEvent e){
		    anim = new Animation();
		    anim.start();
		}

		public void mouseExited(MouseEvent e){
		    // Kill the animation thread
		    anim.interrupt();
		    while (anim.isAlive()){}
		    anim = null;
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
	    g2.setColor(randColor);
	    
	    if(x == 350 && y == 250){
		red = (int)(Math.random()*255);
		green = (int)(Math.random()*255);
		blue = (int)(Math.random()*255);
		randColor = new Color(red, green, blue);
		g2.setPaint(randColor);
	    }
	    Speaker test = new Speaker(x, y, 100, 150);
	    g2.draw(test);
	}
    }

    class Animation extends Thread {
	public void run() {
	    try {
		while (true) {
		    if (x < 550 && y == 50) {
			dx = 5;
			dy = 0;
		    }
		    else if(x==550 && y == 450){
			while(x>55 && y>55){
			    dx = -5;
			    dy = -5;
			    x+=dx;
			    y +=dy;
			    panel.repaint();
			    Thread.sleep(50);
			}
		    }
		    else if(x > 50 && x <= 550 && y >= 50 && y < 450){
			dx = -5;
			dy = 5;
		    }
		    else if(y == 450 && x!= 550){
			dx = 5;
			dy = 0;
		    }
		    x += dx;
		    y += dy;
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
