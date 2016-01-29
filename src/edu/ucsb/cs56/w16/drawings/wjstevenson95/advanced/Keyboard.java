package edu.ucsb.cs56.w16.drawings.wjstevenson95.advanced;
import java.awt.geom.GeneralPath;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;

/**
   A Keyboard

   @author William Stevenson
   @version for CS56, W16, UCSB

*/

public class Keyboard extends Rectangle implements Shape
{
    /**
     * Constructor for objects of class Keyboard
     */
    public Keyboard(double x, double y, double width, double height)
    {
	//construct the base rectangle
	super(x,y,width,height);
	
	// get the GeneralPath that we are going to append to
	GeneralPath gp = this.get();

	// Make 1 smaller rectangle to lay on top of the shell
	// Make 7 regular white keys (small inverted rectangles)
	// Make 5 black keys (smaller inverted rectangles)

	double w = width * 0.93;
	double h = height - 10;
	double w1 = w / 7;
	double w2 = w / 14;
	double x1 = x + 10;
	double x2 = x + 20;
	double y1 = y + 10;
	
	Rectangle2D.Double background = 
	    new Rectangle2D.Double(x1, y + 10, w, h);

	Rectangle2D.Double black1 = 
	    new Rectangle2D.Double(x2 + w2,y1,w2,h * 0.5);
	Rectangle2D.Double black2 = 
	    new Rectangle2D.Double(x2 + 3 * w2,y1,w2,h * 0.5);
	Rectangle2D.Double black3 = 
	    new Rectangle2D.Double(x2 + 7 * w2 ,y1,w2,h * 0.5);
	Rectangle2D.Double black4 = 
	    new Rectangle2D.Double(x2 + 9 * w2,y1,w2,h * 0.5);
	Rectangle2D.Double black5 = 
	    new Rectangle2D.Double(x2 + 11 * w2,y1,w2,h * 0.5);
	
	
	Rectangle2D.Double white1 = 
	    new Rectangle2D.Double(x1, y + 10, w1, h);
	Rectangle2D.Double white2 =
            new Rectangle2D.Double(x1 +  w1, y1, w1, h);
	Rectangle2D.Double white3 =
	    new Rectangle2D.Double(x1 + 2 * w1, y1, w1, h);
	Rectangle2D.Double white4 =
            new Rectangle2D.Double(x1 + 3 * w1, y1, w1, h);
	Rectangle2D.Double white5 =
            new Rectangle2D.Double(x1 + 4 * w1, y1, w1, h);
	Rectangle2D.Double white6 =
            new Rectangle2D.Double(x1 + 5 * w1, y1, w1, h);
	Rectangle2D.Double white7 =
            new Rectangle2D.Double(x1 + 6 * w1, y1, w1, h);

	GeneralPath wholeKeyboard = this.get();
	wholeKeyboard.append(background, false);
	
	wholeKeyboard.append(white1, false);
	wholeKeyboard.append(white2, false);
	wholeKeyboard.append(white3, false);
	wholeKeyboard.append(white4, false);
	wholeKeyboard.append(white5, false);
	wholeKeyboard.append(white6, false);
	wholeKeyboard.append(white7, false);

	wholeKeyboard.append(black1, false);
	wholeKeyboard.append(black2, false);
	wholeKeyboard.append(black3, false);
	wholeKeyboard.append(black4, false);
	wholeKeyboard.append(black5, false);
    }
}
