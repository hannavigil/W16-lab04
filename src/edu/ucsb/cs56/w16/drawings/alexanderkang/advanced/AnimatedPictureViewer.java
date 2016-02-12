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

	private int radius = 70;
	private int slHeight = 50;
	private Streetlight streetlight = new Streetlight(100,100, radius, slHeight);

	private DrawPanel panel = new DrawPanel();
	Thread anim;

	private int x = 100;
	private int y = 100;

	private int dx = 5;
	private int dy = 5;

	private Color c = Color.blue;

	public static void main (String[] args) {
      new AnimatedPictureViewer().go();
    }


    public void go(){
    	JFrame frame = new JFrame("animation");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      	frame.getContentPane().add(panel);
      	frame.setSize(600,600);
      	frame.setVisible(true);    
      	frame.getContentPane().addMouseListener(new ColorListener());
      	//anim = new Animation();
      	//anim.start();
      }

    class DrawPanel extends JPanel{
    	public void paintComponent(Graphics g){
    		Graphics2D g2 = (Graphics2D) g;

    		g2.setColor(Color.white);
    		g2.fillRect(0,0,this.getWidth(),this.getHeight());
    		
    		g2.setColor(c);
    		Streetlight s = new Streetlight(x,y,radius,slHeight);
    		g2.draw(s);
    	}

    }//drawpanel

    
    class ColorListener extends MouseAdapter{
    	public void mouseEntered(MouseEvent e){
        System.out.println("Color Changed");
        	int red = (int) (Math.random() * 255);
    		int green = (int) (Math.random() * 255);
    		int blue = (int) (Math.random() * 255);
    		c = new Color(red, green, blue);
          anim = new Animation();
          anim.start();
        }

        public void mouseExited(MouseEvent e){        
          System.out.println("Mouse exited");
          anim.interrupt();
          while (anim.isAlive()){}
          anim = null;         
          panel.repaint();        
        }
    }
	
    class Animation extends Thread{
    	public void run(){
    		try{
    			while(true){
    				//check if drawing is at the boundaries
    				if(x >= 525)
    					dx = -5;
    				if(y >= 280)
    					dy = -5;
    				if(x <= 20)
    					dx = 5;
    				if(y <= 20)
    					dy = 5;

    				//move the drawing
    				x += dx;
    				y += dy;

    				panel.repaint();
            		Thread.sleep(45);
    			}
    		}
    		catch(Exception ex) {
          		if (ex instanceof InterruptedException) {
          		} else {
            	ex.printStackTrace();
            	System.exit(1);
         		 }
    		}
    	}

	}//thread
}
