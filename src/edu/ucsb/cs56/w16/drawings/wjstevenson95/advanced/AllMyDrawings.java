package edu.ucsb.cs56.w16.drawings.wjstevenson95.advanced;

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
 * @author William Stevenson
 * @version for UCSB CS56, W16 
 */

public class AllMyDrawings
{
    /** Draw a picture with a few keyboards and rectangles. 
     */
    
    public static void drawPicture1(Graphics2D g2) {
	
	Rectangle r1 = new Rectangle(100,250,250,75);
	g2.setColor(Color.CYAN); g2.draw(r1);
	
	// Make a black rectangle that's half the size, 
	// and moved over 150 pixels in x direction
	
	Shape h2 = ShapeTransforms.scaledCopyOfLL(r1,0.5,0.5);
	h2 = ShapeTransforms.translatedCopyOf(h2,150,0);
	g2.setColor(Color.BLACK); g2.draw(h2);
	
	// Here's a rectangle that's 4x as big (2x the original)
	// and moved over 150 more pixels to right.
	h2 = ShapeTransforms.scaledCopyOfLL(h2,4,4);
	h2 = ShapeTransforms.translatedCopyOf(h2,150,0);
	
	// We'll draw this with a thicker stroke
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	
	// for hex colors, see (e.g.) http://en.wikipedia.org/wiki/List_of_colors
	// #002FA7 is "International Klein Blue" according to Wikipedia
	// In HTML we use #, but in Java (and C/C++) its 0x
	
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(new Color(0x002FA7)); 
	g2.draw(h2); 
	
	// Draw a Keyboard
	
	Keyboard k1 = new Keyboard(100,250,250,75);
	
	g2.draw(k1);
	g2.setColor(new Color(0x8F00FF));
	
	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("A Keyboard and some Rectangles by William Stevenson", 20,20);
    }
    
    
    /** Draw a picture with a Keyboards
     */
    public static void drawPicture2(Graphics2D g2) {
	
	// Draw some keyboards
	
	Keyboard k1 = new Keyboard(100, 250, 300, 75);
	Keyboard k2 = new Keyboard(20, 20, 200, 25);
	
	g2.setColor(Color.RED);     g2.draw(k1);
	g2.setColor(Color.GREEN);   g2.draw(k2);
	
	Rectangle r1 = new Rectangle(300,300,50,20);
	g2.setColor(Color.CYAN); g2.draw(r1);
	
	// Make a black rectangle that's half the size, 
	// and moved over 150 pixels in x direction
	Shape h2 = ShapeTransforms.scaledCopyOfLL(r1,0.5,0.5);
	h2 = ShapeTransforms.translatedCopyOf(h2,150,0);
	g2.setColor(Color.BLACK); g2.draw(h2);
	
	// Here's a rectangle that's 4x as big (2x the original)
	// and moved over 150 more pixels to right.
	h2 = ShapeTransforms.scaledCopyOfLL(h2,4,4);
	h2 = ShapeTransforms.translatedCopyOf(h2,150,0);
	
	// We'll draw this with a thicker stroke
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	
	// for hex colors, see (e.g.) http://en.wikipedia.org/wiki/List_of_colors
	// #002FA7 is "International Klein Blue" according to Wikipedia
	// In HTML we use #, but in Java (and C/C++) its 0x
	
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(new Color(0x002FA7)); 
	g2.draw(h2); 
	
	// Draw two keyboards
	
	Keyboard k3 = new Keyboard(50,50,215,40);
	Keyboard k4 = new Keyboard(200,350,265,50);
	
	g2.draw(k3);
	g2.setColor(new Color(0x8F00FF)); 
	
	// Rotate the second keyboard 45 degrees around its center.
	Shape s1 = ShapeTransforms.rotatedCopyOf(k4, Math.PI/4.0);
	
	g2.draw(s1);
	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("A bunch of Keyboards and a Rectangle by William Stevenson", 20,20);
    }
    
    /** Draw a different picture with 3 different colored Keyboards
     */
    
    public static void drawPicture3(Graphics2D g2) {
	
	// label the drawing
	
	g2.drawString("3 Keyboards by William Stevenson", 20,20);
	
	
	// Draw some coffee cups.
	
	Keyboard k1 = new Keyboard(50,50,215,40);
	Keyboard k2 = new Keyboard(125,125,200,40);
	Keyboard k3 = new Keyboard(250,250,185,40);
	
	g2.setColor(Color.RED);     g2.draw(k1);
	g2.setColor(Color.GREEN);   g2.draw(k2);
	g2.setColor(Color.BLUE);     g2.draw(k3);
	
    }       
}
