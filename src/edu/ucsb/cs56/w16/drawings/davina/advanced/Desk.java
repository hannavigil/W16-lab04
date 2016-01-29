package edu.ucsb.cs56.w16.drawings.davina.advanced;
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.Shape; // general class for shapes

import java.awt.geom.Line2D; 
import java.awt.geom.Rectangle2D;
import java.awt.geom.Ellipse2D;

import edu.ucsb.cs56.w16.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w16.drawings.utilities.GeneralPathWrapper;

/**
   A vector drawing of a house that implements
   the Shape interface, and so can be drawn, as well as
   rotated, scaled, etc.
      
   @author Davina Zamanzadeh
   @version for CS56, W16, UCSB
   
*/
public class Desk extends GeneralPathWrapper implements Shape
{
    /**
       Constructor
       
       @param x x coord of lower left corner of desk
       @param y y coord of lower left corner of desk
       @param width width of the desk
       @param height of desk 
    */
    public Desk(double x, double y, double width, double height)
    {
	
        //Make left side of desk
        Line2D.Double leftSide =
            new Line2D.Double (x, y + height, // Remember that y goes DOWN the page,
                               x, y);        // so we ADD to y to get a "lower" value on the screen

        //Make right side of desk
        Line2D.Double rightSide = 
            new Line2D.Double (x + width, y+height,
                              x+width,y);

        //Make top piece of desk
        Line2D.Double top = 
            new Line2D.Double (x, y, x+width, y);

        //Make 3 drawers 1/3 the size of the width of the desk
        double drawerX = x + ((2*width)/3);
        double drawerWidth = width/3;
        double drawerHeight = height/3;
        double topDrawerY = y;
        double middleDrawerY = topDrawerY + drawerHeight;
        double bottomDrawerY = middleDrawerY + drawerHeight;
            //Drawer top (1/3)
        Rectangle2D.Double topDrawer  = 
            new Rectangle2D.Double(drawerX, topDrawerY,
			        drawerWidth, drawerHeight);
			//Drawer middle (2/3)
        Rectangle2D.Double middleDrawer  = 
            new Rectangle2D.Double(drawerX, middleDrawerY,
			        drawerWidth, drawerHeight);
			//Drawer bottom (3/3)
        Rectangle2D.Double bottomDrawer  = 
            new Rectangle2D.Double(drawerX, bottomDrawerY,
			        drawerWidth, drawerHeight);

        //Make 3 knobs for each drawer
        double r = (.1)*drawerWidth;
            //Knob top
        Ellipse2D.Double topKnob =
            new Ellipse2D.Double (drawerX + (drawerWidth/2) - (r/2), 
                                topDrawerY + (drawerHeight/2) - (r/2),
                                r, r);
             //Knob middle
        Ellipse2D.Double middleKnob =
            new Ellipse2D.Double (drawerX + (drawerWidth/2) - (r/2), 
                                middleDrawerY + (drawerHeight/2) - (r/2),
                                r, r);
             //Knob bottom
        Ellipse2D.Double bottomKnob =
            new Ellipse2D.Double (drawerX + (drawerWidth/2) - (r/2), 
                                bottomDrawerY + (drawerHeight/2) - (r/2),
                                r, r);
                                

        // put the whole desk together
	
        GeneralPath wholeDesk = this.get();
        wholeDesk.append(leftSide, false);
        wholeDesk.append(rightSide, false);
        wholeDesk.append(top, false);    
        wholeDesk.append(topDrawer, false);    
        wholeDesk.append(middleDrawer, false);    
        wholeDesk.append(bottomDrawer, false);    
        wholeDesk.append(topKnob, false);    
        wholeDesk.append(middleKnob, false);    
        wholeDesk.append(bottomKnob, false);    
    }
}
