package edu.ucsb.cs56.w16.drawings.alexanderkang.advanced;

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
 * @author Alexander Kang
 * @version for UCSB CS56, W16 
 */

public class AllMyDrawings
{
    /** Draw a picture with a few streetlights 
     */
    
    public static void drawPicture1(Graphics2D g2) {
	
	Lightbulb h1 = new Lightbulb(100,250,50);
	g2.setColor(Color.GREEN); g2.draw(h1);
	
	// Make a black house that's half the size, 
	// and moved over 150 pixels in x direction
	
	Shape h2 = ShapeTransforms.scaledCopyOfLL(h1,0.5,0.5);
	h2 = ShapeTransforms.translatedCopyOf(h2,150,0);
	g2.setColor(Color.BLACK); g2.draw(h2);
	
	// Here's a house that's 4x as big (2x the original)
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
	
	
	
	// @@@ FINALLY, SIGN AND LABEL YOUR DRAWING
	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("A few streetlights by Alex Kang", 20,20);
    }
    
    
    /** Draw a picture with a few houses and coffee cups
     */
   public static void drawPicture2(Graphics2D g2) {
	
	// Draw some coffee cups.
	
	Streetlight large = new Streetlight(500,50,100,75);
	Streetlight smallSL = new Streetlight(20,50,40,40);
	Streetlight tallSkinny = new Streetlight(300,150,20,80);
	Streetlight shortFat = new Streetlight(20,250,40,60);
	
	g2.setColor(Color.RED);     g2.draw(large);
	g2.setColor(Color.GREEN);   g2.draw(smallSL);
	g2.setColor(Color.BLUE);    g2.draw(tallSkinny);
	g2.setColor(Color.MAGENTA); g2.draw(shortFat);
	
	Lightbulb h1 = new Lightbulb(100,250,50);
	g2.setColor(Color.CYAN); g2.draw(h1);
	
	// Make a black streelight that's half the size, 
	// and moved over 150 pixels in x direction
	Shape h2 = ShapeTransforms.scaledCopyOfLL(h1,0.5,0.5);
	h2 = ShapeTransforms.translatedCopyOf(h2,150,0);
	g2.setColor(Color.BLACK); g2.draw(h2);
	
	// Here's a streetlight that's 4x as big (2x the original)
	// and moved over 150 more pixels to right.
	h2 = ShapeTransforms.scaledCopyOfLL(h2,4,4);
	h2 = ShapeTransforms.translatedCopyOf(h2,150,0);
	
	// We'll draw this with a thicker stroke
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	
	
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(new Color(0x002FA7)); 
	g2.draw(h2); 
	
	
	
	// @@@ FINALLY, SIGN AND LABEL YOUR DRAWING
	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("A bunch streetlights and some Lightbulbs by Alex Kang", 20,20);
    }
    
    /** Draw a different picture with a few houses and coffee cups
     */
    
    public static void drawPicture3(Graphics2D g2) {
	
	// label the drawing
	
	g2.drawString("A few streetlights rotated by Alex kang", 20,20);
	
	
	// Draw some coffee cups.

	
	Streetlight large = new Streetlight(200,100,60,150);
	Streetlight smallSL = new Streetlight(300,50,30,30);
	Shape sl3 = ShapeTransforms.rotatedCopyOf(large, Math.PI/4.0);
	Shape sl4 = ShapeTransforms.rotatedCopyOf(smallSL, Math.PI/2.0);
	g2.setColor(Color.BLUE);    
	g2.draw(sl3);
 
	g2.setColor(Color.ORANGE);  

	g2.draw(sl4);
    }       
}
