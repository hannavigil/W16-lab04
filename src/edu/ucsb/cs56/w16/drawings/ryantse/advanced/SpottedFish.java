package edu.ucsb.cs56.w16.drawings.ryantse.advanced;
import java.awt.geom.GeneralPath;  
import java.awt.Shape; 
import java.awt.geom.Ellipse2D;

/**
	A spotted fish.

	@author Ryan Tse
	@version for CS56, W16, UCSB
   
*/
public class SpottedFish extends Fish implements Shape
{
	/**
	 * Constructor for objects of class SpottedFish
	 */
	public SpottedFish(double x, double y, double width, double height)
	{
		// Construct the basic fish.
		super(x,y,width,height);
	
		// Get the GeneralPath that we are going to append stuff to
		GeneralPath gp = this.get();

		double spot1radius = height * 0.1;
		double spot1x = x + width*0.35 - spot1radius;
		double spot1y = y - height*0.40 - spot1radius;
		Ellipse2D.Double spot1 = new Ellipse2D.Double(spot1x, spot1y, spot1radius*2, spot1radius*2);

		double spot2radius = height * 0.15;
		double spot2x = x + width*0.63 - spot2radius;
		double spot2y = y - height*0.20 - spot2radius;
		Ellipse2D.Double spot2 = new Ellipse2D.Double(spot2x, spot2y, spot2radius*2, spot2radius*2);

		double spot3radius = height * 0.08;
		double spot3x = x + width*0.52 - spot3radius;
		double spot3y = y - height*0.70 - spot3radius;
		Ellipse2D.Double spot3 = new Ellipse2D.Double(spot3x, spot3y, spot3radius*2, spot3radius*2);

		gp.append(spot1, false);
		gp.append(spot2, false);
		gp.append(spot3, false);
	}
}
