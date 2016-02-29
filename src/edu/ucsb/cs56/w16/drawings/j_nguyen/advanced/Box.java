package edu.ucsb.cs56.w16.drawings.j_nguyen.advanced;

import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.Shape; // general class for shapes

import java.awt.geom.Line2D; 
import java.awt.geom.Rectangle2D;

import edu.ucsb.cs56.w16.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w16.drawings.utilities.GeneralPathWrapper;

/**
   A vector drawing of a box that implements
   the Shape interface, and so can be drawn, as well as
   rotated, scaled, etc.
      
   @author Justin Nguyen 
   @version for CS56, W16, UCSB
   
*/
public class Box extends GeneralPathWrapper implements Shape
{
    /**
       Constructor
       
       @param x x coord of upper left corner of box
       @param y y coord of upper left corner of box
       @param width width of the box
       @param height height of box
    */
    public Box(double x, double y, double width, double height)
    {
	
        // Rather than having to scale at the end, we can just
        // draw things the right way to begin with, using the
        // x, y, width and height.   If you haven't already
        // hard coded a particular drawing, this may be an easier
        // way.

	Rectangle2D.Double singleBox = new Rectangle2D.Double(x, y, width, height);
	
	GeneralPath wholeBox = this.get();
	wholeBox.append(singleBox, false);
    }
}
