package edu.ucsb.cs56.w16.drawings.wjstevenson95.advanced;
import java.awt.geom.GeneralPath;
import java.awt.Shape;

import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

import edu.ucsb.cs56.w16.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w16.drawings.utilities.GeneralPathWrapper;

/**
   A vector drawing of a rectangle that implements
   the Shape interface, and so can be drawn, as well as rotated, scaled, etc.

   @author William Stevenson
   @version for CS56, W16, UCSB

*/

public class Rectangle extends GeneralPathWrapper implements Shape
{
    /**
       Constructor

       @param x x coordinate of upper left corner of rectangle
       @param y y coordinate of upper left corner of rectangle
       @param length length of the rectangle
       @param height height of the rectangle
    */
    public Rectangle(double x, double y, double length, double height)
    {

	// Make the rectangle

	Rectangle2D.Double rect = 
	    new Rectangle2D.Double(x, y, length, height);

	GeneralPath newRectangle = this.get();
	newRectangle.append(rect,false);
    }
}
