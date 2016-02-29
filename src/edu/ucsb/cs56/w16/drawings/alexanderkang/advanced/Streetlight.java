package edu.ucsb.cs56.w16.drawings.alexanderkang.advanced;
import java.awt.geom.GeneralPath;  
import java.awt.Shape; 
import java.awt.geom.Rectangle2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;

/**
   A Streetlight
      
   @author Alexander Kang
   @version for CS56, W16, UCSB
   
*/
public class Streetlight extends Lightbulb implements Shape
{
     /**
       Constructor
       
       @param x x coord of lower left corner of streetlight
       @param y y coord of lower left corner of streetlight
       @param radius radius of the lightbulb/container at top of streetlights
       @param height of streetlight including container for bulb at top
    */
    public Streetlight(double x, double y, double radius, double height)
    {
	// construct the basic lightbulb
	super(x+.26*radius,y+.37*radius,.5*radius);	

	//construct container for lightbulb
	Ellipse2D.Double lbContainer = new Ellipse2D.Double(x,y,radius,radius);

	double fractionOfRad = 24*radius/25;
	double bottomOfSL = y+fractionOfRad*4;
    Line2D.Double leftLine = new Line2D.Double(x+radius/3, y+fractionOfRad, x+radius/3, bottomOfSL);
    Line2D.Double rightLine = new Line2D.Double(x+2*radius/3, y+fractionOfRad, x+2*radius/3, bottomOfSL);
   	Line2D.Double bottomOfBuSL = new Line2D.Double(x+radius/3, bottomOfSL, x+2*radius/3,  bottomOfSL);
    
    //give some depth to the streetlight
    double bottomOfDepth = bottomOfSL*.9;
    double xStartDepth = (x+radius/3) + radius/12;
    double xEndDepth = (x+2*radius/3) - radius/12;
    Line2D.Double depth1 = new Line2D.Double(xStartDepth, y+fractionOfRad*1.5, xStartDepth, bottomOfDepth);
    Line2D.Double depth2 = new Line2D.Double(xEndDepth, y+fractionOfRad*1.5, xEndDepth, bottomOfDepth);
    Line2D.Double depth3 = new Line2D.Double(xStartDepth + radius/12, y+fractionOfRad*1.2, xStartDepth + radius/12, bottomOfDepth*1.05);

	
	// get the GeneralPath that we are going to append stuff to
	GeneralPath gp = this.get();
	
	
	
    GeneralPath wholeStreetLight = this.get();
    wholeStreetLight.append(lbContainer,false);
    wholeStreetLight.append(leftLine,false);
    wholeStreetLight.append(rightLine,false);
    wholeStreetLight.append(bottomOfBuSL,false);
	wholeStreetLight.append(depth1,false);
    wholeStreetLight.append(depth2,false);
    wholeStreetLight.append(depth3,false);



    }    
}
