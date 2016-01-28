package edu.ucsb.cs56.w16.drawings.sdbistarkey.advanced;
import java.awt.geom.GeneralPath;  
import java.awt.Shape; 
import java.awt.geom.Rectangle2D;
import java.awt.geom.Ellipse2D;

/**
   A House
      
   @author Skyler Bistarkey-Rez
   @version for CS56, W16, UCSB
   
*/
public class SmartPhoneWithBackground extends SmartPhone implements Shape
{
    /**
     * Constructor for objects of class CoffeeCup
     */
    public SmartPhoneWithBackground(double x, double y, double width, double height, double radius)
    {
	// construct the basic phone shell
	super(x,y,width,height,radius);
	
	double innerScreenX = x+10.0;
	double innerScreenY = y+10.0;
	double innerScreenWidth = width - 20.0;
	double innerScreenHeight = height - 20.0;

	double w = (innerScreenWidth/12.0);
	
	Rectangle2D.Double firstClockDigit =
	    new Rectangle2D.Double(innerScreenX + w, innerScreenY + w,
				   w, 3*w);

	Rectangle2D.Double secondClockDigit =
	    new Rectangle2D.Double(innerScreenX + 3*w, innerScreenY + w,
				   w, 3 * w);

	Ellipse2D.Double firstColonDot =
	    new Ellipse2D.Double(innerScreenX + 5*w, innerScreenY + w,
				 w, w);

	Ellipse2D.Double secondColonDot =
	    new Ellipse2D.Double(innerScreenX + 5*w, innerScreenY + 3 * w,
				 w, w);
	
	Rectangle2D.Double thirdClockDigit =
	    new Rectangle2D.Double(innerScreenX + 8*w, innerScreenY + w,
				   w, 3 * w);
	
	Rectangle2D.Double fourthClockDigit =
	    new Rectangle2D.Double(innerScreenX + 10*w, innerScreenY + w,
				   w, 3 * w);
	
	//get the GeneralPath we are going to append stuff to
	GeneralPath wholePhone = this.get();
        wholePhone.append(firstClockDigit, false);
        wholePhone.append(secondClockDigit, false);
        wholePhone.append(firstColonDot, false);
	wholePhone.append(secondColonDot, false);
	wholePhone.append(thirdClockDigit, false);
	wholePhone.append(fourthClockDigit, false) ;
    }    
}
