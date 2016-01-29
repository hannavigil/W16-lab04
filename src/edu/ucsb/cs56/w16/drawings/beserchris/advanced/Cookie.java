package edu.ucsb.cs56.w16.drawings.beserchris.advanced;
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.Shape; // general class for shapes

import java.awt.geom.Line2D; 
import java.awt.geom.Ellipse2D;

import edu.ucsb.cs56.w16.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w16.drawings.utilities.GeneralPathWrapper;

/**
   Provides means for drawing a Cookie, implements Shape and extends GeneralPathWrapper       
   @author Christopher Beser 
   @version for CS56, W16, UCSB
   
*/
public class Cookie  extends GeneralPathWrapper implements Shape
{
    /**
       Constructor
       
       @param x x coord of lower left corner of Cookie
       @param y y coord of lower left corner of Cookie
       @param Radius of the Cookie
    */
    public Cookie(double x, double y, double radius)
    {
	

        Ellipse2D.Double outerCookie = new Ellipse2D.Double(x, y, radius, radius);
	Ellipse2D.Double innerCookie = new Ellipse2D.Double(x, y, radius - 1, radius - 1);
	GeneralPath theCookie = this.get();
	theCookie.append(outerCookie, false);
	theCookie.append(innerCookie, false);
       
    }
}
