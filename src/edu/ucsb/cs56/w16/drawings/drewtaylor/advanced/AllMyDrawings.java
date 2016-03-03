package edu.ucsb.cs56.w16.drawings.drewtaylor.advanced;

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
 * @author Drew Taylor 
 * @version for UCSB CS56, W16 
 */

public class AllMyDrawings
{
    /** Draw a picture with a few measures
     */
    
    public static void drawPicture1(Graphics2D g2) {
	
	Measure h1 = new Measure(100,250,200,75);
	g2.setColor(Color.RED); g2.draw(h1);
	
	Shape h2 = ShapeTransforms.scaledCopyOfLL(h1,0.5,0.5);
	h2 = ShapeTransforms.translatedCopyOf(h2,150,0);
	g2.setColor(Color.ORANGE); g2.draw(h2);
	
	h2 = ShapeTransforms.scaledCopyOfLL(h2,4,4);
	h2 = ShapeTransforms.translatedCopyOf(h2,150,0);
	
	// We'll draw this with a thicker stroke
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(new Color(0xFFF00)); 
	g2.draw(h2); 
	
	// Draw two measures with the notes
	
	Melody hw1 = new Melody(50,350,40,75,1,2,3);
	Melody hw2 = new Melody(200,350,200,100,2,4,5);
	
	g2.draw(hw1);
	g2.setColor(new Color(0xFF4500)); g2.draw(hw2);
	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("A few measures by Drew Taylor", 20,20);
    }
    
    
    /** Draw a picture with a few houses and coffee cups
     */    
    public static void drawPicture2(Graphics2D g2) {
	
	// Draw some coffee cups.
	
	Measure large = new Measure(100,50,225,150);
	Measure smallCC = new Measure(20,50,40,30);
	Measure tallSkinny = new Measure(20,150,20,40);
	Measure shortFat = new Measure(20,250,40,20);
	
	g2.setColor(Color.CYAN);     g2.draw(large);
	g2.setColor(Color.GREEN);   g2.draw(smallCC);
	g2.setColor(Color.BLUE);    g2.draw(tallSkinny);
	g2.setColor(Color.MAGENTA); g2.draw(shortFat);
	
	Melody h1 = new Melody(100,250,50,75,1,2,3);
	g2.setColor(Color.PINK); g2.draw(h1);
	
	Shape h2 = ShapeTransforms.scaledCopyOfLL(h1,0.5,0.5);
	h2 = ShapeTransforms.translatedCopyOf(h2,150,0);
	g2.setColor(Color.BLACK); g2.draw(h2);
	
	h2 = ShapeTransforms.scaledCopyOfLL(h2,4,4);
	h2 = ShapeTransforms.translatedCopyOf(h2,150,0);
	
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(new Color(0x002FA7)); 
	g2.draw(h2); 
	
	Melody hw1 = new Melody(50,350,40,75,1,2,3);
	Melody hw2 = new Melody(200,350,200,100,1,2,3);
	
	g2.draw(hw1);
	g2.setColor(new Color(0x8F00FF)); 
	
	Shape hw3 = ShapeTransforms.rotatedCopyOf(hw2, Math.PI/2.0);
	
	g2.draw(hw3);
	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("A Symphony by Drew Taylor", 20,20);
    }
    
    /** Draw a different picture with a few houses and coffee cups
     */
    
    public static void drawPicture3(Graphics2D g2) {
	
	// label the drawing
	
	g2.drawString("Black and Gray Music by Drew Taylor", 20,20);
	
	Measure large = new Measure(100,50,225,150);
	Melody smallCC = new Melody(20,50,40,30,1,2,3);

        Melody smallCC1 = new Melody(300,300,225,150,1,2,3);
        Measure large1 = new Measure(50,100,40,30);

        Measure large2 = new Measure(200,200,225,150);
        Melody smallCC2 = new Melody(175,350,40,30,1,2,3);

        Melody smallCC3 = new Melody(50,400,225,150,1,2,3);
        Measure large3 = new Measure(75,75,40,30);

        Melody smallCC4 = new Melody(350,50,225,150,1,2,3);
        Measure large4 = new Measure(200,50,40,30);
	
	g2.setColor(Color.BLACK);     g2.draw(large);
	g2.setColor(Color.GRAY);   g2.draw(smallCC);

        g2.setColor(Color.GRAY);     g2.draw(large1);
        g2.setColor(Color.BLACK);   g2.draw(smallCC1);

        g2.setColor(Color.DARK_GRAY);     g2.draw(large2);
        g2.setColor(Color.LIGHT_GRAY);   g2.draw(smallCC2);

        g2.setColor(Color.LIGHT_GRAY);     g2.draw(large3);
        g2.setColor(Color.DARK_GRAY);   g2.draw(smallCC3);

        g2.setColor(Color.BLACK);     g2.draw(large4);
        g2.setColor(Color.BLACK);   g2.draw(smallCC4);
	
    }       
}
