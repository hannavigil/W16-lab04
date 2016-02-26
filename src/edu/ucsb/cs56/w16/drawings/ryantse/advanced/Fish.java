package edu.ucsb.cs56.w16.drawings.ryantse.advanced;
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.Shape; // general class for shapes

import java.awt.geom.Line2D; 
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

import edu.ucsb.cs56.w16.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w16.drawings.utilities.GeneralPathWrapper;

/**
	A vector drawing of a fish that implements
	the Shape interface, and so can be drawn, as well as
	rotated, scaled, etc.
			
	@author Ryan Tse
	@version for CS56, W16, UCSB
	 
*/
public class Fish extends GeneralPathWrapper implements Shape
{
	/**
		Constructor
		 
		@param x x coord of lower left corner of fish
		@param y y coord of lower left corner of fish
		@param width width of the fish
		@param height height of the fish
	*/
	public Fish(double x, double y, double width, double height)
	{
		double finWidth = 0.25 * width;
		double bodyWidth = width - finWidth;

		// The fish eye should be proportional to the body size.
		double eyeRadius = 0.01 * width;
		// The minimum width of the eye radius should be 1.
		if(eyeRadius < 1) eyeRadius = 1;
		
		double eyeCenterX = 0.75 * bodyWidth;
		double eyeCenterY = 0.75 * height;

		// Compose the fins of the fish.
		Line2D.Double finEnd = new Line2D.Double (x, y, x, y - height);
		Line2D.Double finTop = new Line2D.Double (x, y - height, x+finWidth, y - height/2);
		Line2D.Double finBottom = new Line2D.Double (x, y, x+finWidth, y - height/2);

		// Create the fish's body.
		Ellipse2D.Double fishBody = new Ellipse2D.Double (x + finWidth, y - height, bodyWidth, height);

		// Create the fish's eye.
		Ellipse2D.Double fishEye = new Ellipse2D.Double(x + finWidth + eyeCenterX - eyeRadius, y - eyeCenterY - eyeRadius, eyeRadius*2, eyeRadius*2);

		// Assemble the fish together.
		GeneralPath wholeFish = this.get();
		wholeFish.append(finEnd, false);
		wholeFish.append(finTop, false);
		wholeFish.append(finBottom, false);
		wholeFish.append(fishBody, false);
		wholeFish.append(fishEye, false);
	}
}
