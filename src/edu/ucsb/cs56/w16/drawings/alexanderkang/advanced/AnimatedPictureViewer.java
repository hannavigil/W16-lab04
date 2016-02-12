package edu.ucsb.cs56.w16.drawings.alexanderkang.advanced;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * A main class to view an animation
 * @author Alexander Kang
 * @version for CS56, W16
 */

public class AnimatedPictureViewer {

	private int radius = 50;
	private int slHeight = 75;
	private Streetlight streetlight = new Streetlight(100,100, radius, slHeight);

	private DrawPanel panel = new DrawPanel();
	Thread anim;

	private int x = 100;
	private int y = 100;

	private int dx = 5;
	private int dy = 5;


	public static void main (String[] args) {
      new AnimatedPictureViewer().go();
    }


    public void go(){
    	JFrame frame = new JFrame("animation");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      	frame.getContentPane().add(panel);
      	frame.setSize(600,600);
      	frame.setVisible(true);    
      	anim = new Animation();
      	anim.start();
      }

    class DrawPanel extends JPanel{
    	public void paintComponent(Graphics g){
    		Graphics2D g2 = (Graphics2D) g;

    		g2.setColor(Color.white);
    		g2.fillRect(0,0,this.getWidth(),this.getHeight());

    		g2.setColor(Color.BLUE);
    		Streetlight s = new Streetlight(x,y,radius,slHeight);
    		g2.draw(s);
    	}

    }//drawpanel

    class Animation extends Thread{
    	public void run(){
    		try{
    			while(true){
    				//check if drawing is at the boundaries
    				if(x >= 525)
    					dx = -5;
    				if(y >= 400)
    					dy = -5;
    				if(x <= 75)
    					dx = 5;
    				if(y <= 200)
    					dy = 5;

    				//move the drawing
    				x += dx;
    				y += dy;

    				panel.repaint();
            		Thread.sleep(50);
    			}
    		}
    		catch(Exception ex) {
          		if (ex instanceof InterruptedException) {
            	// Do nothing - expected on mouseExited
          		} else {
            	ex.printStackTrace();
            	System.exit(1);
         		 }
    		}
    	}

	}//thread
}
