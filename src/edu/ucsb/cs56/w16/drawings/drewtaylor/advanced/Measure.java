package edu.ucsb.cs56.w16.drawings.drewtaylor.advanced;
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.Shape; // general class for shapes

import java.awt.geom.Line2D; 
import java.awt.geom.Rectangle2D;

import edu.ucsb.cs56.w16.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w16.drawings.utilities.GeneralPathWrapper;

/**
   A vector drawing of a measure (in music) that can be drawn, as well as
   rotated, scaled, etc.
      
   @author Drew Taylor
   @version for CS56, W16, UCSB
   
*/
public class Measure extends GeneralPathWrapper implements Shape
{
    /**
       Constructor
       
       @param x x coord of lower left corner of house
       @param y y coord of lower left corner of house
       @param width width of the house
       @param height of house (including first story and second story)
    */
    public Measure(double x, double y, double width, double height)
    {
        
        // Make the measure rectangle
        
        Rectangle2D.Double measureShape = 
            new Rectangle2D.Double(x, y,
				   width, height);

	// Add in the lines of the measure itself

        Line2D.Double line1 =
            new Line2D.Double(x, y+height*.25, x+width,y+height*.25);
        
        Line2D.Double line2 =
            new Line2D.Double(x, y+height*.5, x+width,y+height*.5);

        Line2D.Double line3 =
            new Line2D.Double(x, y+height*.75, x+width,y+height*.75);

        // put the whole measure together
	
        GeneralPath wholeMeasure = this.get();
        wholeMeasure.append(measureShape, false);
        wholeMeasure.append(line1, false);
	wholeMeasure.append(line2, false);
        wholeMeasure.append(line3, false);
    }
}
