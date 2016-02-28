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
   A Basketball Court with a Player                                                                                                                                                                                            
   @author Radhika Khatod                                                                                                                                                              
   @version for CS56, W16, UCSB                                                                                                                                                      
                                                                                                                                                                                     
*/
public class Players extends BasketballCourt implements Shape
{
    /**                                                                                                                                                                              
     * Constructor for objects of class Players                                                                                                                                    
     */
    public Players(double x, double y, double width, double height)
    {
        // construct the basic player                                                                                                                                           
        super(x,y,width,height);

        // get the GeneralPath that we are going to append stuff to                                                                                                                  
        GeneralPath gp = this.get();

	double headRadius = .2*width;
	double bodyLength = .4*height;
	double armsLength = .2*height;


Circle head = 
    new Circle(x+width*2, y+height*1.5, headRadius);
Line2D.Double body = 
    new Line2D.Double (x+width*2, y+ (height*1.5) +headRadius, x+width*2, y+ (height*1.5) +headRadius+bodyLength);

Line2D.Double leftLeg =
    new Line2D.Double ( x+width*2, y+ (height*1.5) +headRadius+bodyLength, x+width*1.7, y+ (height*1.5) +headRadius+bodyLength+armsLength);

Line2D.Double rightLeg = 
    new Line2D.Double (x+width*2, y+ (height*1.5) +headRadius+bodyLength, x+width*2.3, y+ (height*1.5) +headRadius+bodyLength+armsLength);

Line2D.Double leftArm = 
    new Line2D.Double(x+width*2, y + height*1.5+headRadius + .5*bodyLength, x+ width*1.7, y+height*1.5 + headRadius+.5*bodyLength);

Line2D.Double rightArm = 
    new Line2D.Double(x+width*2, y + height*1.5+headRadius + .5*bodyLength, x+ width*2.3, y+height*1.5 + headRadius+.5*bodyLength);

GeneralPath wholeCourt = this.get();
wholeCourt.append(head, false);
wholeCourt.append(body, false);
wholeCourt.append(leftLeg, false);
wholeCourt.append(rightLeg, false);
wholeCourt.append(leftArm, false);
wholeCourt.append(rightArm, false);

    }
}
