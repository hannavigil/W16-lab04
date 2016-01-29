package edu.ucsb.cs56.w16.drawings.davidwang.advanced;

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
 * @author David Wang
 * @version for UCSB CS56, W16 
 */

public class AllMyDrawings
{
    /** Draw a picture with a few pigs and pigs with bodies
     */
    
    public static void drawPicture1(Graphics2D g2) {
	
        Pig p1 = new Pig(100,250,50);
        g2.setColor(Color.CYAN); g2.draw(p1);
	
	// Make a black house that's half the size, 
	// and moved over 150 pixels in x direction
	
        Shape p2 = ShapeTransforms.scaledCopyOfLL(p1,0.5,0.5);
        p2 = ShapeTransforms.translatedCopyOf(p2,150,0);
        g2.setColor(Color.BLACK); g2.draw(p2);
	
	// Here's a house that's 4x as big (2x the original)
	// and moved over 150 more pixels to right.
        p2 = ShapeTransforms.scaledCopyOfLL(p2,4,4);
        p2 = ShapeTransforms.translatedCopyOf(p2,150,0);
	
	// We'll draw this with a thicker stroke
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	
	// for hex colors, see (e.g.) http://en.wikipedia.org/wiki/List_of_colors
	// #002FA7 is "International Klein Blue" according to Wikipedia
	// In HTML we use #, but in Java (and C/C++) its 0x
	
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(new Color(0x002FA7)); 
        g2.draw(p2);
	
	// Draw two houses with Windows
	
        PigWithBody pb1 = new PigWithBody(50,350,40);
        PigWithBody pb2 = new PigWithBody(200,350,200);
	
        g2.draw(pb1);
        g2.setColor(new Color(0x8F00FF)); g2.draw(pb2);
	
	// @@@ FINALLY, SIGN AND LABEL YOUR DRAWING
	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
        g2.drawString("A few pigs and pigs with bodies by David Wang", 20,20);
    }
    
    
    /** Draw a picture with a few pigs and pigs with bodies
     */
    public static void drawPicture2(Graphics2D g2) {
	
	// Draw some coffee cups.
	
        Pig large = new Pig(100,50,225);
        Pig smallCC = new Pig(20,50,40);
        Pig tallSkinny = new Pig(20,150,20);
        Pig shortFat = new Pig(20,250,40);
	
	g2.setColor(Color.RED);     g2.draw(large);
	g2.setColor(Color.GREEN);   g2.draw(smallCC);
	g2.setColor(Color.BLUE);    g2.draw(tallSkinny);
	g2.setColor(Color.MAGENTA); g2.draw(shortFat);
	
        Pig p1 = new Pig(100,250,50);
        g2.setColor(Color.CYAN); g2.draw(p1);
	
	// Make a black house that's half the size, 
	// and moved over 150 pixels in x direction
        Shape p2 = ShapeTransforms.scaledCopyOfLL(p1,0.5,0.5);
        p2 = ShapeTransforms.translatedCopyOf(p2,150,0);
        g2.setColor(Color.BLACK); g2.draw(p2);
	
	// Here's a house that's 4x as big (2x the original)
	// and moved over 150 more pixels to right.
        p2 = ShapeTransforms.scaledCopyOfLL(p2,4,4);
        p2 = ShapeTransforms.translatedCopyOf(p2,150,0);
	
	// We'll draw this with a thicker stroke
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	
	// for hex colors, see (e.g.) http://en.wikipedia.org/wiki/List_of_colors
	// #002FA7 is "International Klein Blue" according to Wikipedia
	// In HTML we use #, but in Java (and C/C++) its 0x
	
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(new Color(0x002FA7)); 
        g2.draw(p2);
	
	// Draw two houses with Windows
	
        PigWithBody pb1 = new PigWithBody(50,350,40);
        PigWithBody pb2 = new PigWithBody(200,350,200);
	
        g2.draw(pb1);
	g2.setColor(new Color(0x8F00FF)); 
	
	// Rotate the second house 45 degrees around its center.
        Shape pb3 = ShapeTransforms.rotatedCopyOf(pb2, Math.PI/4.0);
	
        g2.draw(pb3);
	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
        g2.drawString("A bunch of pigs and pigs with bodies", 20,20);
    }
    
    /** Draw a different picture with a few houses and coffee cups
     */

    public static void drawPicture3(Graphics2D g2) {
	
	// label the drawing
	
        g2.drawString("A bunch of pigs by David Wang", 20,20);
	
	
	// Draw some coffee cups.
        Pig big = new Pig(100,100,100);
        Pig small = new Pig(50,100,20);
	
        g2.setColor(Color.PINK);     g2.draw(big);
        g2.setColor(Color.PINK);   g2.draw(small);
	
    }       
}
