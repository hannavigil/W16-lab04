package edu.ucsb.cs56.w16.drawings.j_nguyen.advanced;

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
 * @author Justin Nguyen 
 * @version for UCSB CS56, W16 
 */

public class AllMyDrawings
{
    /** Draw a picture with a few boxes 
     */
    
    public static void drawPicture1(Graphics2D g2) {

	Box b1 = new Box(100,150,75,125);
	
	g2.setColor(Color.CYAN);
	g2.draw(b1);

	// Make a black box that's half the size, 
	// and moved over 150 pixels in x direction
	
	Shape b2 = ShapeTransforms.scaledCopyOfLL(b1,0.5,0.5);
	b2 = ShapeTransforms.translatedCopyOf(b2,150,0);
	g2.setColor(Color.BLACK); g2.draw(b2);
	
	// Here's a box that's 4x as big (2x the original)
	// and moved over 150 more pixels to right.
	b2 = ShapeTransforms.scaledCopyOfLL(b2,4,4);
	b2 = ShapeTransforms.translatedCopyOf(b2,150,0);
	
	// We'll draw this with a thicker stroke
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	
	// for hex colors, see (e.g.) http://en.wikipedia.org/wiki/List_of_colors
	// #002FA7 is "International Klein Blue" according to Wikipedia
	// In HTML we use #, but in Java (and C/C++) its 0x
	
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(new Color(0x002FA7)); 
	g2.draw(b2); 
	
	Shape b3 = ShapeTransforms.rotatedCopyOf(b2, Math.PI/2.0);
	b3 = ShapeTransforms.translatedCopyOf(b3,0,200);
	g2.draw(b3);
	
	// @@@ FINALLY, SIGN AND LABEL YOUR DRAWING
	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("A few boxes by Justin Nguyen", 20,20);


    }
    
    
    /** Draw a picture with a few boxes and speakers
     */
        public static void drawPicture2(Graphics2D g2) {
	
	// Draw some coffee cups.
	
	Speaker large = new Speaker(100,50,150,225);
	Speaker smallSpeaker = new Speaker(20,50,40,75);
	Speaker tallSkinny = new Speaker(20,150,20,50);
	Speaker shortFat = new Speaker(20,250,50,20);
	
	g2.setColor(Color.RED);     g2.draw(large);
	g2.setColor(Color.GREEN);   g2.draw(smallSpeaker);
	g2.setColor(Color.BLUE);    g2.draw(tallSkinny);
	g2.setColor(Color.MAGENTA); g2.draw(shortFat);
	
	Box b1 = new Box(100,250,50,75);
	g2.setColor(Color.BLUE); g2.draw(b1);
	
	Shape b2 = ShapeTransforms.scaledCopyOfLL(b1,0.5,0.5);
	b2 = ShapeTransforms.translatedCopyOf(b2,150,0);
	g2.setColor(Color.BLACK); g2.draw(b2);
	
	// Here's a house that's 4x as big (2x the original)
	// and moved over 150 more pixels to right.
	b2 = ShapeTransforms.scaledCopyOfLL(b2,4,4);
	b2 = ShapeTransforms.translatedCopyOf(b2,150,0);
	
	// We'll draw this with a thicker stroke
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	
	// for hex colors, see (e.g.) http://en.wikipedia.org/wiki/List_of_colors
	// #002FA7 is "International Klein Blue" according to Wikipedia
	// In HTML we use #, but in Java (and C/C++) its 0x
	
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(new Color(0x002FA7)); 
	g2.draw(b2); 
	
	// Draw two Speakers
	
	Speaker s1 = new Speaker(50,350,50,100);
	Speaker s2 = new Speaker(200,350,100,200);
	
	g2.draw(s1);
	g2.setColor(new Color(0x8F00FF)); 
	
	// Rotate the second house 45 degrees around its center.
	Shape s3 = ShapeTransforms.rotatedCopyOf(s2, Math.PI/4.0);
	
	g2.draw(s3);
	
	// @@@ FINALLY, SIGN AND LABEL YOUR DRAWING
	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("A bunch of speakers and a few boxes by Justin Nguyen", 20,20);
	}
    
    /** Draw a different picture with a few houses and coffee cups
     */
    
        public static void drawPicture3(Graphics2D g2) {
	
	// label the drawing
	
	g2.drawString("A bunch of speakers by Justin Nguyen", 20,20);
	
	
	// Draw some speakrs.
	
	Speaker large = new Speaker(100,50,175,225);
	Speaker smallSpeaker = new Speaker(20,50,40,60);
	
	g2.setColor(Color.RED);     g2.draw(large);
	g2.setColor(Color.GREEN);   g2.draw(smallSpeaker);
	
	}       
}
