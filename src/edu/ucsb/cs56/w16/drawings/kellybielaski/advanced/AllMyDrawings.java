package edu.ucsb.cs56.w16.drawings.kellybielaski.advanced;

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
 * @author Phill Conrad 
 * @version for UCSB CS56, W16 
 */

public class AllMyDrawings
{
    /** Draw a picture with a few bears
     */
    
    public static void drawPicture1(Graphics2D g2) {
	Bear b1= new Bear(100,100, 70);
	g2.setColor(Color.CYAN); g2.draw(b1);	
	
	// Make a black bear that's half the size, 
	// and moved over 200 pixels in x direction
	
	Shape b2 = ShapeTransforms.scaledCopyOfLL(b1,0.5,0.5);
	b2 = ShapeTransforms.translatedCopyOf(b2,200,0);
	g2.setColor(Color.BLACK); g2.draw(b2);
	
	// Here's a bear that's 5/2x as big (5/4x the original)
	// and moved over 150 more pixels down and 160 pixels to the left of the second bear.
	b2 = ShapeTransforms.scaledCopyOfLL(b2,5/2,5/2);
	b2 = ShapeTransforms.translatedCopyOf(b2,-160,150);
	
	// We'll draw this with a thicker stroke
	Stroke thick = new BasicStroke (5.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	
	// for hex colors, see (e.g.) http://en.wikipedia.org/wiki/List_of_colors
	// #45A27D is "Pine" according to Wikipedia
	// In HTML we use #, but in Java (and C/C++) its 0x
	
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(new Color(0x45A27D)); 
	g2.draw(b2); 
	
	//Draw two Smiling Bears
        Stroke inbetween = new BasicStroke (3.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);   
	g2.setStroke(inbetween);
	g2.setColor(new Color(0xFFD12A));	
	SmilingBear sb1 = new SmilingBear(375,40,120,60);
	
	SmilingBear sb2 = new SmilingBear(425,350,40,30);
	g2.draw(sb1);
	g2.setColor(new Color(0xCEC8EF)); g2.draw(sb2);

	SmilingBear sb3 = new SmilingBear(20,300,50,70);
	g2.setColor(new Color(0xDB91EF));
	g2.draw(sb3);
	
	// SIGN/LABEL
	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("A few bears translated and resized bears by Kelly Bielaski", 20,20);
    }
    
    
    /** Draw a picture with a few bears
     */
    public static void drawPicture2(Graphics2D g2) {
	//Draw some bears of different colors
	
    SmilingBear b2= new SmilingBear(20,40,35,60);
    Shape sm1 = ShapeTransforms.rotatedCopyOf(b2, Math.PI);
    g2.setColor(new Color(0x9E4B40)); g2.draw(sm1);
		
    Bear largeb = new Bear(100,50,225);
    g2.setColor(new Color(0xFFCBA4));
    Stroke small = new BasicStroke (3.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);   
    g2.setStroke(small);
    g2.draw(largeb);
	
    SmilingBear smallhappy = new SmilingBear(20,150,40,70);   
    g2.setStroke(small);
    g2.setColor(new Color(0xE97451));   //g2.draw(smallhappy);
    
    SmilingBear notveryhappy = new SmilingBear(300,150,130,30);
    Stroke large = new BasicStroke (6.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);   
    g2.setStroke(large);
    Shape sm3 = ShapeTransforms.rotatedCopyOf(notveryhappy, Math.PI/2.0);
    g2.setColor(new Color(0xD99A6C)); g2.draw(sm3);
	
    // Rotate the second bear 45 degrees around its center.
    Shape sm4 = ShapeTransforms.rotatedCopyOf(smallhappy, Math.PI/4.0);
	
    g2.draw(sm4);
	
    // SIGN/LABEL
    Stroke orig=g2.getStroke();
    g2.setStroke(orig);
    g2.setColor(Color.BLACK); 
    g2.drawString("A bunch of ethnically diverse, rotated bears", 20,20);
}
    
/** Draw a different picture with some bears
 */
    
public static void drawPicture3(Graphics2D g2) {
	
    // label the drawing
	
    g2.drawString("Two Christmas Bears by Phill Conrad", 20,20);
	
	
    // Draw some bears
	
    Bear large = new Bear(100,50,200);
    SmilingBear small = new SmilingBear(20,300,40,30);
	
    g2.setColor(Color.RED);     g2.draw(large);
    g2.setColor(Color.GREEN);   g2.draw(small);
	
}       
}
