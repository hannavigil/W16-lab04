package edu.ucsb.cs56.w16.drawings.beserchris.advanced;

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
 * @author Christopher Beser
 * @version for UCSB CS56, W16 
 */

public class AllMyDrawings
{
    /** Draw a picture with an arangement of ChocolateChipCookies
     */
    
    public static void drawPicture1(Graphics2D g2) {
	
	Cookie cCookie = new ChocolateChipCookie(100 ,100 , 60);
	g2.setColor(Color.RED); g2.draw(cCookie);
	

	Shape cCookieShape = ShapeTransforms.scaledCopyOfLL(cCookie,0.5,0.5);
	cCookieShape = ShapeTransforms.translatedCopyOf(cCookieShape,150,0);
	g2.setColor(Color.BLACK); g2.draw(cCookieShape);
	
    
	cCookieShape = ShapeTransforms.scaledCopyOfLL(cCookieShape,4,4);
	cCookieShape = ShapeTransforms.translatedCopyOf(cCookieShape,150,0);
	
	// We'll draw this with a thicker stroke
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	
	// for hex colors, see (e.g.) http://en.wikipedia.org/wiki/List_of_colors
	// #002FA7 is "International Klein Blue" according to Wikipedia
	// In HTML we use #, but in Java (and C/C++) its 0x
	
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(new Color(0x002FA7)); 
	g2.draw(cCookieShape); 
	

	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("Some Chocolate Chip Cookies by Christopher Beser", 20,20);
    }
    
    
    /** Draw a picture with an arrangement of Cookies
     */
    public static void drawPicture2(Graphics2D g2) {
	Cookie cookie = new Cookie(100 ,100 , 60);
	g2.setColor(Color.YELLOW); g2.draw(cookie);
	

	Shape cookieShape = ShapeTransforms.scaledCopyOfLL(cookie,0.7,0.7);
	cookieShape = ShapeTransforms.translatedCopyOf(cookieShape,150,0);
	g2.setColor(Color.BLACK); g2.draw(cookieShape);
	
    
	cookieShape = ShapeTransforms.scaledCopyOfLL(cookieShape,2,2);
	cookieShape = ShapeTransforms.translatedCopyOf(cookieShape,200,0);
	
	// We'll draw this with a thicker stroke
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	
	// for hex colors, see (e.g.) http://en.wikipedia.org/wiki/List_of_colors
	// #002FA7 is "International Klein Blue" according to Wikipedia
	// In HTML we use #, but in Java (and C/C++) its 0x
	
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(new Color(0x002FA7)); 
	g2.draw(cookieShape); 
	

	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("Some Cookies by Christopher Beser", 20,20);

	// g2.drawString("A bunch of Coffee Cups and a few houses by Phill Conrad", 20,20);
    }
    
    /** Draws a multicolored assortment of Cookies and ChocolateChipCookies
     */
    
    public static void drawPicture3(Graphics2D g2) {
	Cookie cCookie = new ChocolateChipCookie(100 ,300 , 60);
	g2.setColor(Color.RED); g2.draw(cCookie);
	

	Shape cCookieShape = ShapeTransforms.scaledCopyOfLL(cCookie,0.5,0.5);
	cCookieShape = ShapeTransforms.translatedCopyOf(cCookieShape,150,100);
	g2.setColor(Color.BLACK); g2.draw(cCookieShape);
	
    
	cCookieShape = ShapeTransforms.scaledCopyOfLL(cCookieShape,4,4);
	cCookieShape = ShapeTransforms.translatedCopyOf(cCookieShape,150,-100);
	
	// We'll draw this with a thicker stroke
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	
	// for hex colors, see (e.g.) http://en.wikipedia.org/wiki/List_of_colors
	// #002FA7 is "International Klein Blue" according to Wikipedia
	// In HTML we use #, but in Java (and C/C++) its 0x
	
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(new Color(0x002FA7)); 
	g2.draw(cCookieShape); 
	

	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	Cookie cookie = new Cookie(100 ,100 , 60);
	g2.setColor(Color.YELLOW); g2.draw(cookie);
	

	Shape cookieShape = ShapeTransforms.scaledCopyOfLL(cookie,0.7,0.7);
	cookieShape = ShapeTransforms.translatedCopyOf(cookieShape,150,0);
	g2.setColor(Color.BLACK); g2.draw(cookieShape);
	
    
	cookieShape = ShapeTransforms.scaledCopyOfLL(cookieShape,2,2);
	cookieShape = ShapeTransforms.translatedCopyOf(cookieShape,200,500);

	g2.setStroke(thick);
	g2.setColor(new Color(0x002FA7)); 
	g2.draw(cookieShape); 
	

	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("Some Cookies AND Chocolate Chip Cookies by Christopher Beser", 20,20);

    }       
}
