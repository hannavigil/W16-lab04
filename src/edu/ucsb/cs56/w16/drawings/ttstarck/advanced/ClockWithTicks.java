package edu.ucsb.cs56.w16.drawings.ttstarck.advanced;
import java.awt.geom.GeneralPath;  
import java.awt.Shape; 
import java.awt.geom.Line2D;

import edu.ucsb.cs56.w16.drawings.utilities.ShapeTransforms;


/**
   A Clock with Ticks
      
   @author TristanStarck
   @version for CS56, W16, UCSB
   
*/
public class ClockWithTicks extends Clock implements Shape
{
    /**
     * Constructor for objects of class ClockWithTicks
     */
    public ClockWithTicks(double x, double y, double radius)
    {
	// construct the basic clock shell
	super(x,y,radius);
		
	Line2D.Double tick0 = new Line2D.Double(x+radius/2,y+radius/2+3*radius/8,x+radius/2,y+radius);
	Line2D.Double tick3 = new Line2D.Double(x+radius/2+radius*3/8,y+radius/2,x+radius,y+radius/2);
	Line2D.Double tick6 = new Line2D.Double(x+radius/2,y+radius/2-3*radius/8,x+radius/2,y);
        Line2D.Double tick9 = new Line2D.Double(x+radius/2-radius*3/8,y+radius/2,x,y+radius/2);
	    
	
	GeneralPath wholeClock;
	
	for(int i = 0; i < 3; i++){
	    wholeClock = this.get();
	    wholeClock.append(tick0, false);
	    wholeClock.append(tick3, false);
	    wholeClock.append(tick6, false);
	    wholeClock.append(tick9,false);
	
	    Shape s = ShapeTransforms.rotatedCopyOf(wholeClock, Math.PI/6);

	    this.set(new GeneralPath(s));
	}
	/*
	wholeClock = this.get();
        wholeClock.append(tick0, false);
        wholeClock.append(tick3, false);
        wholeClock.append(tick6, false);
        wholeClock.append(tick9,false);

        Shape s1 = ShapeTransforms.rotatedCopyOf(wholeClock, Math.PI/6);

        this.set(new GeneralPath(s1));
	
        wholeClock = this.get();
        wholeClock.append(tick0, false);
        wholeClock.append(tick3, false);
        wholeClock.append(tick6, false);
        wholeClock.append(tick9,false);

        Shape s2 = ShapeTransforms.rotatedCopyOf(wholeClock, Math.PI/6);

	this.set(new GeneralPath(s2));
	*/
	
    }    
}
