package edu.ucsb.cs56.w16.drawings.beserchris.advanced;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * A main class. Creates a cookie object that bounces around the screen
 *
 * @author Christopher Beser
 * @version for CS56, W16
 */

public class AnimatedPictureViewer{
    private int xPos = 100;
    private int yPos = 100;
    private int dx = 3;
    private int dy = 3;

    Thread theAnimation;
    private MyPanel myPanel = new MyPanel();
    public static void main(String[] args){
	new AnimatedPictureViewer().go();
    }
    public void go(){
	JFrame frame = new JFrame();
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.getContentPane().add(myPanel);
	frame.setSize(640,480);
	frame.setVisible(true);
	/* run the animation thread*/
	frame.getContentPane().addMouseListener(new MouseAdapter(){
		public void mouseEntered(MouseEvent e){
		    theAnimation = new Animation();
		    theAnimation.start();
		}

		public void mouseExited(MouseEvent e){
		    theAnimation.interrupt();
		    while(theAnimation.isAlive()){}
		    theAnimation = null;
		    myPanel.repaint();
		}
	    });
    }

	    public class MyPanel extends JPanel{ //contains the animation
		public void paintComponent(Graphics g){
		    Graphics2D g2 = (Graphics2D) g;
		    g2.setColor(Color.white);
		    g2.fillRect(0,0,this.getWidth(),this.getHeight());

		    g2.setColor(Color.black);
		    ChocolateChipCookie cookie = new ChocolateChipCookie(xPos,yPos,50);
		    g2.drawString("A bouncing cookie by Christopher Beser",20,20);
		    g2.draw(cookie);
		}
	    }//end class MyPanel
	public class Animation extends Thread{
	    public void run(){ //override the run() method
		try{
		    while(true){
			if(xPos>= myPanel.getWidth() - 100){
			    dx++;
			    dx = -dx;
			}
			if(xPos <= 50){
			    dx--;
			    dx = -dx;
			}
			if(yPos>= myPanel.getHeight() - 100){
			    dy++;
			    dy = -dy;
			} 
			if(yPos <= 50){
			    dy--;
			    dy = -dy;
			}
			xPos += dx;
			yPos += dy;
			myPanel.repaint();
			Thread.sleep(50);
		    }
		}
		catch(Exception e){
		    if(e instanceof InterruptedException){
			dx = 3;
			dy = 3;
		    }
		    else{
			e.printStackTrace();
			System.exit(1);
		    }
		}

	    }
	}
    }
