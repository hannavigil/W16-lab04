package edu.ucsb.cs56.w16.drawings.rkhatod.advanced;

import java.awt.Graphics2D;
import java.awt.Shape; // general class for shapes
import java.awt.Color; // class for Colors
import java.awt.Stroke;
import java.awt.BasicStroke;

import edu.ucsb.cs56.w16.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w16.drawings.utilities.GeneralPathWrapper;

/**
 * A class with static methods for drawing various pictures
 * 
 * @author Radhika Khatod 
 * @version for UCSB CS56, W16 
 */

public class AllMyDrawings
{
    /** Draw a picture with a few houses 
     */
    
    public static void drawPicture1(Graphics2D g2) {
	
	BasketballCourt b1 = new BasketballCourt(200,10,150,225);
	g2.setColor(Color.BLACK); g2.draw(b1);

	Players p1 = new Players(400, 150, 50, 50);
	g2.setColor(Color.BLACK); g2.draw(p1);
	
	Players p2 = new Players (300, 150, 50, 50);
	// We'll draw this with a thicker stroke
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	
	// for hex colors, see (e.g.) http://en.wikipedia.org/wiki/List_of_colors
	// #002FA7 is "International Klein Blue" according to Wikipedia
	// In HTML we use #, but in Java (and C/C++) its 0x
	
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(new Color(0x002FA7)); 
	g2.draw(p2); 
       
    }
    
    
    /** Draw a picture with a few houses and coffee cups
     */
    public static void drawPicture2(Graphics2D g2) {
	
	// Draw a court and some players
	BasketballCourt b1 = new BasketballCourt(200,10,150,225);
	g2.setColor(Color.BLACK); g2.draw(b1);

	Players p1 = new Players(400, 150, 50, 50);
	g2.setColor(Color.PINK); g2.draw(p1);

	//Make a Magenta player thats double the size of p1 
	//and moved over 150 pixels to the left in the x direction
	Shape p2 = ShapeTransforms.scaledCopyOfLL(p1,2.0,2.0);
	p2 = ShapeTransforms.translatedCopyOf(p2,150,0);
	g2.setColor(Color.MAGENTA); g2.draw(p2);

	Players p3 = new Players(50, 50, 100, 100);
	g2.setColor(Color.BLUE); g2.draw(p3);
	
    }
    public static void drawPicture3(Graphics2D g2) {
	
	// label the drawing
	
	g2.drawString("A bunch of basketball courts and players by Radhika Khatod", 20,20);
	
	
	// Draw some courts.
	
	Players large = new Players(200,10,150,225);
	Players smallBC = new Players(20,50,50,75);

	
	g2.setColor(Color.RED);     g2.draw(large);
	// We'll draw this with a thicker stroke
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(new Color(0x7B68EE)); 
	g2.draw(smallBC); 
       	
	
    }       
}
