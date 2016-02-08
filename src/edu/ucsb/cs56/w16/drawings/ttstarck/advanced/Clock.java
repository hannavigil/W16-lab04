package edu.ucsb.cs56.w16.drawings.ttstarck.advanced;
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.Shape; // general class for shapes

import java.awt.geom.Line2D; 
import java.awt.geom.Ellipse2D;

import edu.ucsb.cs56.w16.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w16.drawings.utilities.GeneralPathWrapper;

/**
   A vector drawing of a clock that implements
   the Shape interface, and so can be drawn, as well as
   rotated, scaled, etc.
      
   @author Tristan Starck
   @version for CS56, W16, UCSB
   
*/
public class Clock extends GeneralPathWrapper implements Shape
{
    /**
       Constructor
       
       @param x x coord of most left position of the clock..
       @param y y coord of highest position of the clock
       @param radius radius of the circle of the clock
    */
    public Clock(double x, double y, double radius)
    {
	
	Ellipse2D.Double circle = 
            new Ellipse2D.Double(x, y,
				   radius, radius);
    
	double bigHandX = Math.random() * radius;
	if(Math.random() >= .5)
	    bigHandX = bigHandX*-1;
	double bigHandY = Math.sqrt(Math.pow(radius,2)-Math.pow(bigHandX,2));
	if(Math.random() >= .5)
	    bigHandY = bigHandY*-1;

        Line2D.Double bigHand = 
            new Line2D.Double (x+radius/2,y+radius/2,
                               x +radius/2+ bigHandX/2, y+radius/2+bigHandY/2);
	double smallHandX = Math.random() * radius;
        if(Math.random() >= .5)
            smallHandX = smallHandX*-1;
        double smallHandY = Math.sqrt(Math.pow(radius,2)-Math.pow(smallHandX,2));
        if(Math.random() >= .5)
            smallHandY = smallHandY*-1;
        Line2D.Double smallHand =
            new Line2D.Double (x+radius/2, y+radius/2,
                               x + radius/2 +smallHandX/4, y +radius/2+ smallHandY/4);
	
        // put the whole clock together
	
        GeneralPath wholeClock = this.get();
        wholeClock.append(circle, false);
        wholeClock.append(bigHand, false);
        wholeClock.append(smallHand, false);    
    }
    public Clock(double x, double y, double radius, int minute, int hour)
    {

        Ellipse2D.Double circle =
            new Ellipse2D.Double(x, y,
				 radius, radius);
	double minuteHand = (double)minute;
	double hourHand = (double)hour;
	boolean minuteXDown = false;
	boolean minuteYDown = false;
	boolean hourXDown = false;
	boolean hourYDown = false;
	if(minute <= 15){
	    minuteHand = minuteHand/15.0;
	    minuteYDown = true;
	}
	else if(minute >15 && minute <= 30){
	    minuteHand = minute-15.0;
	    minuteHand = minuteHand / 15.0;
	    minuteHand = 1-minuteHand;
	}
	else if(minute > 30 && minute <= 45){
	    minuteHand = minute-30.0;
	    minuteHand = minuteHand/15.0;
	    minuteXDown = true;
	}
	else if (minute > 45 && minute < 60){
	    minuteHand = minute-45.0;
	    minuteHand = minuteHand/15.0;
	    minuteHand = 1-minuteHand;
	    minuteXDown = true;
	    minuteYDown = true;
	}

	double bigHandX = minuteHand * radius;
        if(minuteXDown == true)
            bigHandX = bigHandX*-1;
        double bigHandY = Math.sqrt(Math.pow(radius,2)-Math.pow(bigHandX,2));
        if( minuteYDown)
            bigHandY = bigHandY*-1;

        Line2D.Double bigHand =
            new Line2D.Double (x+radius/2,y+radius/2,
                               x +radius/2+ bigHandX/2, y+radius/2+bigHandY/2);
	if(hour<= 3){
	    hourHand = hourHand/3.0;
	    hourYDown = true;
	}
	else if(hour >3 && hour <= 6){
	    hourHand = hour-3.0;
	    hourHand = hourHand/3.0;
	    hourHand = 1-hourHand;
	}
	else if(hour > 6 && hour <= 9){
	    hourHand = hour-6.0;
	    hourHand = hourHand/3.0;
	    hourXDown = true;
	}
	else{
	    hourHand = hour-9.0;
	    hourHand = hourHand/3.0;
	    hourHand = 1-hourHand;
	    hourXDown = true;
	    hourYDown = true;
	}

	double smallHandX = hourHand * radius;
        if(hourXDown)
            smallHandX = smallHandX*-1;
        double smallHandY = Math.sqrt(Math.pow(radius,2)-Math.pow(smallHandX,2));
        if(hourYDown)
            smallHandY = smallHandY*-1;
        Line2D.Double smallHand =
            new Line2D.Double (x+radius/2, y+radius/2, x + radius/2 +smallHandX/4, y +radius/2+ smallHandY/4);

        // put the whole clock together                                               
  

        GeneralPath wholeClock = this.get();
        wholeClock.append(circle, false);
        wholeClock.append(bigHand, false);
        wholeClock.append(smallHand, false);
    }

}
