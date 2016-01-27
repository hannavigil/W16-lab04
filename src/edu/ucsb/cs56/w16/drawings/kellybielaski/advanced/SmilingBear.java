package edu.ucsb.cs56.w16.drawings.kellybielaski.advanced;
import java.awt.geom.GeneralPath;  
import java.awt.Shape; 
import java.awt.geom.Rectangle2D;
import java.awt.geom.Line2D;

/**
   A Smiling Bear
      
   @author Kelly Bielaski 
   @version for CS56, W16, UCSB
   
*/
public class SmilingBear extends Bear implements Shape
{
    /**
       Constructor for objects of class SmilingBear
       @param x x coord of upper left corner of face 
       @param y y coord of upper left corner of face
       @param rad radius of the face
       @param smile is the ratio out of 100 of how big the smile is
    */
    public SmilingBear(double x, double y, double rad, double smile)
    {
	//smile parameter is some number out of 100... the bigger the number the bigger the smile!
	// construct the basic bear
	super(x,y,rad);
	
	// get the GeneralPath that we are going to append stuff to
	GeneralPath gp = this.get();
	
	// Make left half of the smile
	double xsmile=x+rad;
	double ysmile=y+rad*2*7/8;
	
	double xbegin= xsmile-3*rad/4*smile/100;
	double ytop= y+4*rad/3-rad/8+(rad/3);

	Line2D.Double lhalf= new Line2D.Double(xsmile, ysmile, xbegin, ytop);

	//Make right half of the smile
	double xend=xsmile+3*rad/4*smile/100;
	Line2D.Double rhalf = new Line2D.Double(xsmile, ysmile, xend, ytop);
	
	// add the smile to the bear's face
	
        GeneralPath wholeBear = this.get();
        wholeBear.append(lhalf, false);
        wholeBear.append(rhalf, false); 
    }    
}
