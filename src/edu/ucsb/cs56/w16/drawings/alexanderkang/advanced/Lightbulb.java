package edu.ucsb.cs56.w16.drawings.alexanderkang.advanced;
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.Shape; // general class for shapes

import java.awt.geom.Line2D; 
import java.awt.geom.Rectangle2D;

import edu.ucsb.cs56.w16.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w16.drawings.utilities.GeneralPathWrapper;
import java.awt.geom.Ellipse2D;

/**
   A vector drawing of a Lightbulb that implements
   the Shape interface, and so can be drawn, as well as
   rotated, scaled, etc.
      
   @author Alexander Kang
   @version for CS56, W16, UCSB
   
*/
public class Lightbulb extends GeneralPathWrapper implements Shape
{
    /**
       Constructor
       
       @param x x coord of lower left corner of Lightbulb
       @param y y coord of lower left corner of Lightbulb
       @param raduius radius of the Lightbulb
    */
    public Lightbulb(double x, double y, double radius)
    {
	
        // Rather than having to scale at the end, we can just
        // draw things the right way to begin with, using the
        // x, y, width and height.   If you haven't already
        // hard coded a particular drawing, this may be an easier
        // way.
        
        
        
        // make bulb       
        Ellipse2D.Double bulb = new Ellipse2D.Double(x, y, radius, radius);
        //make bottom part of bulb
        double fractionOfRadius = 24*radius/25;
        double bottomOfLB = y+fractionOfRadius*1.3;
        Line2D.Double leftLine = new Line2D.Double(x+radius/3, y+fractionOfRadius, x+radius/3, bottomOfLB);
        Line2D.Double rightLine = new Line2D.Double(x+2*radius/3, y+fractionOfRadius, x+2*radius/3, bottomOfLB);
        Line2D.Double bottomOfBulb = new Line2D.Double(x+radius/3, bottomOfLB, x+2*radius/3,  bottomOfLB);
        
        //make filament of lightbulb
        double xStartFilament = x + .4*radius;
        double yStartFilament = y + .75*radius;
        double xEndFilament = x + .6*radius;
        double yEndFilament = y + .98*radius;
        double fracRadius = (xEndFilament-xStartFilament)/5.0;
        
        Line2D.Double leftFilament = new Line2D.Double(xStartFilament, yStartFilament, xStartFilament, yEndFilament);
        Line2D.Double rightFilament = new Line2D.Double(xEndFilament, yStartFilament, xEndFilament, yEndFilament);
        
        //draw lines in filament
        // put the whole Lightbulb together
        Line2D.Double partF1 = new Line2D.Double(xStartFilament, yStartFilament, xStartFilament+fracRadius, yStartFilament+fracRadius);
       Line2D.Double partF2 = new Line2D.Double(xStartFilament+fracRadius, yStartFilament+fracRadius, xStartFilament+fracRadius*2, yStartFilament);
       Line2D.Double partF3 = new Line2D.Double(xStartFilament+2*fracRadius, yStartFilament, xStartFilament+fracRadius*3, yStartFilament+fracRadius);
        Line2D.Double partF4 = new Line2D.Double(xStartFilament+3*fracRadius, yStartFilament+fracRadius, xStartFilament+fracRadius*4, yStartFilament);
        Line2D.Double partF5 = new Line2D.Double(xStartFilament+4*fracRadius, yStartFilament, xStartFilament+fracRadius*5, yStartFilament+fracRadius);
        Line2D.Double partF6 = new Line2D.Double(xStartFilament+5*fracRadius, yStartFilament+fracRadius, xEndFilament, yStartFilament);


        GeneralPath wholeLightbulb = this.get();
        wholeLightbulb.append(bulb, false);
        wholeLightbulb.append(leftLine, false);
        wholeLightbulb.append(rightLine, false);
        wholeLightbulb.append(bottomOfBulb, false);
        wholeLightbulb.append(leftFilament, false);
        wholeLightbulb.append(rightFilament, false);

        wholeLightbulb.append(partF1,false); 
        wholeLightbulb.append(partF2,false); 
        wholeLightbulb.append(partF3,false); 
        wholeLightbulb.append(partF4,false); 
        wholeLightbulb.append(partF5,false); 
        wholeLightbulb.append(partF6,false);

    }
}
