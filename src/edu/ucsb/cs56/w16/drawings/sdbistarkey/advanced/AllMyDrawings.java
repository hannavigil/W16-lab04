package edu.ucsb.cs56.w16.drawings.sdbistarkey.advanced;

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
 * @author Skyler Bistarkey-Rez 
 * @version for UCSB CS56, W16 
 */

public class AllMyDrawings
{
    /** Draw a picture with a SmartPhones 
     */
    
    public static void drawPicture1(Graphics2D g2) {
	
	SmartPhone sp1 = new SmartPhone(200,350,50,75);
	g2.setColor(Color.MAGENTA); g2.draw(sp1);
	
	// Make a green phone that's .75 the size, 
	// and moved over 200 pixels in x direction
	
	Shape sp2 = ShapeTransforms.scaledCopyOfLL(sp1,0.75,0.75);
	sp2 = ShapeTransforms.translatedCopyOf(sp2,200,0);
	g2.setColor(Color.GREEN); g2.draw(sp2);
	
	// Here's a phone that's 2x as big (1.5x the original)
	// and moved 200 pixels up.
	sp2 = ShapeTransforms.scaledCopyOfLL(sp2,2,2);
	sp2 = ShapeTransforms.translatedCopyOf(sp2,0,-200);
	
	// We'll draw this with a thicker stroke
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       

	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(Color.BLACK); 
	g2.draw(sp2); 

	
	// Draw two SmartPhones with Backgrounds
	
	SmartPhoneWithBackground spbg1 = new SmartPhoneWithBackground(50,50,40,75);
	SmartPhoneWithBackground spbg2 = new SmartPhoneWithBackground(90,250,100,200);
	
	g2.draw(spbg1);
	g2.setColor(new Color(0x8F00FF)); g2.draw(spbg2);
	
	g2.setStroke(orig);
        
	g2.setColor(Color.BLACK);
	g2.drawString("A few smart phones by Skyler Bistarkey-Rez", 20,20);
    }
    
    
    /** Draw a picture with a few smartphones that spell "Hi" */
    public static void drawPicture2(Graphics2D g2) {
	
	//create the base smartphone, and translate/rotate the rest
	//everything is based off sp1
	
	SmartPhoneWithBackground sp1 =
	    new SmartPhoneWithBackground(100, 300, 50, 100);
        Shape sp2 =
	    ShapeTransforms.translatedCopyOf(sp1, 0, -100);
	Shape sp3 =
	    ShapeTransforms.rotatedCopyOf(sp2, Math.PI/2.0);
	sp3 = ShapeTransforms.translatedCopyOf(sp3, 75, 50);

	Shape sp4 =
	    ShapeTransforms.translatedCopyOf(sp1, 150, 0);
	Shape sp5 =
	    ShapeTransforms.translatedCopyOf(sp2, 150, 0);
	Shape sp6 =
	    ShapeTransforms.scaledCopyOf(sp1, 1.0, 2.0);
	sp6 = ShapeTransforms.translatedCopyOf(sp6, 300, -100);
	
	g2.setColor(Color.RED);     g2.draw(sp1);
	g2.setColor(Color.GREEN);   g2.draw(sp2);
	g2.setColor(Color.BLUE);    g2.draw(sp3);
	g2.setColor(Color.MAGENTA); g2.draw(sp4);
	g2.setColor(Color.BLACK);   g2.draw(sp5);
	g2.setColor(Color.PINK);    g2.draw(sp6);
        
	g2.setColor(Color.BLACK); 
	g2.drawString("Smart Phones in the shape of \"Hi\" by Skyler Bistarkey-Rez", 20,20);
    }
    
    /** Draw a different picture with a rainbow S of smartphones
     */
    
    public static void drawPicture3(Graphics2D g2) {

	Stroke orig=g2.getStroke();
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL); 
	g2.setStroke(thick);
	
        SmartPhone sp1 = new SmartPhone(200, 50, 50, 100);
	Shape sp2 = ShapeTransforms.rotatedCopyOf(sp1, -1 * Math.PI/4.0);
	Shape sp3 = ShapeTransforms.horizontallyFlippedCopyOf(sp2);
	Shape sp4 = ShapeTransforms.verticallyFlippedCopyOf(sp3);
	sp4 = ShapeTransforms.translatedCopyOf(sp4, 0, 150*Math.sqrt(2));
	Shape sp5 = ShapeTransforms.translatedCopyOf(sp2, 0, 150*Math.sqrt(2));
	Shape sp6 = ShapeTransforms.verticallyFlippedCopyOf(sp5);
	sp6 = ShapeTransforms.translatedCopyOf(sp6, 0, 150*Math.sqrt(2));
	Shape sp7 = ShapeTransforms.horizontallyFlippedCopyOf(sp6);
	
	g2.setColor(Color.RED);     g2.draw(sp2);
	g2.setColor(Color.ORANGE);  g2.draw(sp3);
	g2.setColor(Color.YELLOW);  g2.draw(sp4);
	g2.setColor(Color.GREEN);   g2.draw(sp5);
	g2.setColor(Color.BLUE);    g2.draw(sp6);
	g2.setColor(Color.MAGENTA); g2.draw(sp7);

	g2.setStroke(orig);
	g2.setColor(Color.BLACK);
	g2.drawString("A rainbow S made of SmartPhones by Skyler Bistarkey-Rez", 20,20);
    }       
}
