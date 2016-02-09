package edu.ucsb.cs56.w16.drawings.drewtaylor.advanced;
import java.awt.geom.GeneralPath;  
import java.awt.Shape; 
import java.awt.geom.Rectangle2D;
import java.awt.geom.Line2D;
import edu.ucsb.cs56.w16.drawings.drewtaylor.simple.Circle;

/**
   A measure with notes inputted to create a melody
      
   @author Drew Taylor
   @version for CS56, W16, UCSB
   
*/
public class Melody extends Measure implements Shape
{
    /**
     * Constructor for objects of class Melody
     */
    public Melody(double x, double y, double width, double height, int note1, int note2, int note3)
    {
	// construct the basic measure shell
	super(x,y,width,height);
	
	// create note 1
	Circle noteCircle1 = new Circle(x+width*0.25,y+height*note1*0.125,height*0.125);
        Line2D.Double line1 =
            new Line2D.Double(x+width*0.25+height*0.125,y+height*note1*0.125,x+width*0.25+height*0.125,y+height*note1*0.125-height);
	
	// create note 2
	Circle noteCircle2 = new Circle(x+width*0.5,y+height*note2*0.125,height*0.125);
        Line2D.Double line2 =
            new Line2D.Double(x+width*0.5+height*0.125,y+height*note2*0.125,x+width*0.5+height*0.125,y+height*note2*0.125-height);	

	// create note 3
	Circle noteCircle3 = new Circle(x+width*0.75,y+height*note3*0.125,height*0.125);
        Line2D.Double line3 =
            new Line2D.Double(x+width*0.75+height*0.125,y+height*note3*0.125,x+width*0.75+height*0.125,y+height*note3*0.125-height);

        GeneralPath wholeMelody = this.get();
        wholeMelody.append(noteCircle1, false);
        wholeMelody.append(line1, false);
        wholeMelody.append(noteCircle2, false);
        wholeMelody.append(line2, false);
        wholeMelody.append(noteCircle3, false);
        wholeMelody.append(line3, false);	
    }    
}
