package edu.ucsb.cs56.w16.drawings.beserchris.advanced;
import java.awt.geom.GeneralPath;  
import java.awt.Shape; 
import java.awt.geom.Ellipse2D;

/**
   A Chocolate Chip Cookie
      
   @author Christopher Beser
   @version for CS56, W16, UCSB
   
*/
public class ChocolateChipCookie extends Cookie implements Shape
{
    /**
     * Constructor 
     *
     *
     */
    public ChocolateChipCookie(double x, double y, double radius)
    {
	//construct the Cookiel
	super(x,y,radius);
	
	// get the GeneralPath that we are going to append stuff to
	GeneralPath gp = this.get();
	
	
	double chipOffset = radius/2;
	Ellipse2D.Double [] chips = {
	    new Ellipse2D.Double(x + chipOffset, y + chipOffset, 2, 2),

	    new Ellipse2D.Double(x + chipOffset-radius/4, y + chipOffset-radius/4, 2, 2),

	    new Ellipse2D.Double(x + chipOffset + radius/4, y + chipOffset - radius/4, 2, 2),

	    new Ellipse2D.Double(x + chipOffset + radius/4, y + chipOffset + radius/4, 2, 2),

	    new Ellipse2D.Double(x + chipOffset - radius/4, y + chipOffset + radius/4, 2, 2),

	    new Ellipse2D.Double(x + chipOffset , y + chipOffset - radius/3, 2, 2),

	    new Ellipse2D.Double(x + chipOffset , y + chipOffset + radius/3, 2, 2), 

	    new Ellipse2D.Double(x + chipOffset - radius/3 , y + chipOffset , 2, 2),

	    new Ellipse2D.Double(x + chipOffset + radius/3 , y + chipOffset , 2, 2)

	    
	};
	//add the chips to the cookie
	
        GeneralPath theCookie  = this.get();
	for(Ellipse2D.Double chip : chips){
	    theCookie.append(chip,false);
	}

    }    
}
