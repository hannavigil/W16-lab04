package edu.ucsb.cs56.w16.drawings.kellybielaski.advanced;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * A main class to view an animation
 *
 * @author Kelly Bielaski
 * @version for CS56, W16
 */


public class AnimatedPictureViewer {

    private DrawPanel panel = new DrawPanel();
    

    
    Thread anim;   
    
    private int x = 0;
    private int y = 40;
        private SmilingBear bear = new SmilingBear(x, y , 120,60);
    
    private double dx = 5;
    private double dy =5;

    private int[] oldCoord={0,40};
    private int[] newCoord={0,40};

    private int[] colors={0xfe9128, 0xf79828, 0xb1d253, 0x1355d5, 0x002a5c, 
			  0xee3224, 0x99cccc, 0xff7ba3, 0xcc99cc, 0xab6983, 
			  0x7cbf2f, 0x21cdf2, 0xb3cc99, 0xffba3f, 0xff7ba3, 
			  0x99cccc, 0x9999cc, 0xeec30d, 0x498ff0, 0x0e8304, 
			  0x66cdaa, 0x468499, 0xa0db8e, 0xfa8072, 0x088da5, 
			  0xffa500, 0xb0e0e6, 0x40e0d0, 0xf6546a, 0x20b2aa, 0xfa8072};
    private int color=0xFFD12A;
    private int randColor(){
	int indexOfColor=(int)(Math.random()*32);
	return colors[indexOfColor];
    }
    private int[] pickPerimeter(){
	int randX=(int)(Math.random()*400);
	int randY=(int)(Math.random()*240);
	int XorY=(int)(Math.random()*4);
	int[] randCoord = {randX,randY};
	if(XorY==0) randCoord[0]=0;
	if(XorY==1) randCoord[0]=400;
	if(XorY==2) randCoord[1]=0;
	if(XorY==3) randCoord[1]=240;              //make sure one of the hits the edge	
	return randCoord;
    }
    private double getdx(){
	return (newCoord[0]-oldCoord[0])/50;
    }
    private double getdy(){
	return (newCoord[1]-oldCoord[1])/50;
    }
    
    public static void main (String[] args) {
	new AnimatedPictureViewer().go();
    }

    public void go() {
	JFrame frame = new JFrame();
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	frame.getContentPane().add(panel);
	frame.setSize(640,480);
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
	frame.getContentPane().addMouseListener(new MouseAdapter(){
		public void mouseClicked(MouseEvent e){
		    System.out.println("Mouse clicked");
		    color=randColor();
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
	    
	    // Draw the bear
	    g2.setColor(new Color(color));
	    SmilingBear test = new SmilingBear(x, y, 120,60);
	    g2.setStroke(new BasicStroke(3.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL));
	    g2.draw(test);
	}
    }
    
    class Animation extends Thread {
	public void run() {
	    try {
		while (true) {
		    // Bounce off the walls
		    //		    if (x >= 400) { dx = -5; }
		    //if (x <= 50) { dx = 5; }
		    if(x<=0||x>=400||y<=0||y>=240){
			//System.out.println(oldCoord[0]); System.out.println(oldCoord[1]);
	
		
			oldCoord=newCoord;
			//System.out.println(oldCoord[0]); System.out.println(oldCoord[1]);
			newCoord=pickPerimeter();
			//		System.out.println(newCoord[0]); System.out.println(newCoord[1]);
			dx=getdx();
			dy=getdy();
			//	System.out.println(dx); System.out.println(dy);
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
