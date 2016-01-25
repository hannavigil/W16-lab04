package edu.ucsb.cs56.w16.drawings.ttstarck.advanced;
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.Shape; // general class for shapes

import java.awt.geom.Line2D; 
import java.awt.geom.Ellipse2D;

import edu.ucsb.cs56.w16.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w16.drawings.utilities.GeneralPathWrapper;

/**
   A vector drawing of a clock that implements
   the Shape interface, and so can be drawn, as well as
   rotated, scaled, etc.
      
   @author Tristan Starck
   @version for CS56, W16, UCSB
   
*/
public class Clock extends GeneralPathWrapper implements Shape
{
    /**
       Constructor
       
       @param x x coord of most left position of the clock..
       @param y y coord of highest position of the clock
       @param radius radius of the circle of the clock
    */
    public Clock(double x, double y, double radius)
    {
	
	Ellipse2D.Double circle = 
            new Ellipse2D.Double(x, y,
				   radius, radius);
    
	double bigHandX = Math.random() * radius;
	if(Math.random() >= .5)
	    bigHandX = bigHandX*-1;
	double bigHandY = Math.sqrt(Math.pow(radius,2)-Math.pow(bigHandX,2));
	if(Math.random() >= .5)
	    bigHandY = bigHandY*-1;

        Line2D.Double bigHand = 
            new Line2D.Double (x+radius/2,y+radius/2,
                               x +radius/2+ bigHandX/2, y+radius/2+bigHandY/2);
	double smallHandX = Math.random() * radius;
        if(Math.random() >= .5)
            smallHandX = smallHandX*-1;
        double smallHandY = Math.sqrt(Math.pow(radius,2)-Math.pow(smallHandX,2));
        if(Math.random() >= .5)
            smallHandY = smallHandY*-1;
        Line2D.Double smallHand =
            new Line2D.Double (x+radius/2, y+radius/2,
                               x + radius/2 +smallHandX/4, y +radius/2+ smallHandY/4);
	
        // put the whole clock together
	
        GeneralPath wholeClock = this.get();
        wholeClock.append(circle, false);
        wholeClock.append(bigHand, false);
        wholeClock.append(smallHand, false);    
    }
}
