                                                                                                  
package edu.ucsb.cs56.w16.drawings.rkhatod.advanced;
import edu.ucsb.cs56.w16.drawings.pconrad.simple.Circle;
import java.awt.geom.GeneralPath; // combinations of lines and curves                                                                       
import java.awt.geom.AffineTransform;
import java.awt.Shape; // general class for shapes                                                                                          

import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

import edu.ucsb.cs56.w16.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w16.drawings.utilities.GeneralPathWrapper;
import java.awt.geom.PathIterator;
import java.awt.geom.AffineTransform;
/**                                                                                                                                         
   A vector drawing of a basketball court that implements                                                                                              
   the Shape interface, and so can be drawn, as well as                                                                                     
   rotated, scaled, etc.                                                                                                                    
                                                                                                                                            
   @author Radhika Khatod                                                                                                                     
   @version for CS56, W16, UCSB                                                                                                             
                                                                                                                                            
*/
public class BasketballCourt extends GeneralPathWrapper implements Shape
{
    /**                                                                                                                                     
       Constructor                                                                                                                          
                                                                                                                                            
       @param x x coord of lower left corner of court                                                                                       
       @param y y coord of lower left corner of court                                                                                       
       @param width width of the court                                                                                                      
       @param height of court                                                                     
    */
    public BasketballCourt(double x, double y, double width, double height)
    {

        // Rather than having to scale at the end, we can just                                                                              
        // draw things the right way to begin with, using the                                                                               
        // x, y, width and height.   If you haven't already                                                                                 
        // hard coded a particular drawing, this may be an easier                                                                           
        // way.                                                                                                                             

        
	double courtHeight = height;
	double keyHeight = .25*height;
	double key2Height = .25*height;
	double circleHeight = .25*height;
	double circle2Height = .25*height;
	double halfCourtLineHeight = height;
	double halfCourtCircleHeight = .5*height;

	double courtUpperLeftY = y + height;
Rectangle2D.Double court = 
    new Rectangle2D.Double(x, courtUpperLeftY ,
			   width, courtHeight);
//left key
Rectangle2D. Double key = 
    new Rectangle2D.Double(x+width*.4, y+1.75*height ,
			   0.2*width, keyHeight);
//right key
Rectangle2D. Double rightKey = 
    new Rectangle2D.Double(x+width*.4,y + height-.25  ,
			   0.2*width, keyHeight);
//half court
Line2D.Double halfCourt = 
    new Line2D.Double (x, y + 1.5*courtHeight,
		       x+width, y+1.5*courtHeight);

Circle halfCircle = 
    new Circle (x+width*0.5, y+height*1.5, .12*height);



GeneralPath wholeCourt = this.get();
wholeCourt.append(court, false);
wholeCourt.append(key, false);
wholeCourt.append(halfCourt, false);
wholeCourt.append(rightKey, false);
wholeCourt.append(halfCircle, false);
    }
}
