package edu.ucsb.cs56.w16.drawings.j_nguyen.advanced;
import java.awt.geom.GeneralPath;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Ellipse2D;

/** 
   A Speaker
   @author Justin Nguyen
   @version for CS56, W16, UCSB
*/
public class Speaker extends Box implements Shape
{
    /**
       Constructor for object of type Speaker
    */
    public Speaker(double x, double y, double width, double height)
    {
	// construct the basic house shell
	super(x,y,width,height);

	// get the GeneralPath that we are going to append stuff to
	GeneralPath gp = this.get();

	//variable for the bottom circles
	double distFromBottom = height / 25.0;
	double bottomBigRadius = (width - (width/10.0)) / 2.0;
	double bottomMedRadius = bottomBigRadius - 5;
	double bottomSmallRadius = bottomBigRadius / 4.0;

	double smallCircY = y+(height - (2 * bottomBigRadius) - distFromBottom)/2;
	double topBigRadius = smallCircY - y - distFromBottom;
	double topMedRadius = topBigRadius - 2;
	double topSmallRadius = topBigRadius / 4.0;

	Circ topBigCircle = new Circ(x+(width/2), smallCircY, topBigRadius);
	Circ topMedCircle = new Circ(x+(width/2), smallCircY, topMedRadius);
	Circ topSmallCircle = new Circ(x+(width/2), smallCircY,topSmallRadius);
	
	Circ bottomBigCircle = new Circ(x+(width/2) ,y + height - bottomBigRadius- distFromBottom, bottomBigRadius);
	Circ bottomMedCircle = new Circ(x+(width/2), y + height - bottomBigRadius - distFromBottom, bottomMedRadius);
	Circ bottomSmallCircle = new Circ(x+(width/2), y + height - bottomBigRadius - distFromBottom, bottomSmallRadius);

	GeneralPath wholeSpeaker = this.get();
	wholeSpeaker.append(bottomBigCircle, false);
	wholeSpeaker.append(bottomMedCircle, false);
	wholeSpeaker.append(bottomSmallCircle, false);
	wholeSpeaker.append(topBigCircle, false);
	wholeSpeaker.append(topMedCircle, false);
	wholeSpeaker.append(topSmallCircle, false);
    }
}
