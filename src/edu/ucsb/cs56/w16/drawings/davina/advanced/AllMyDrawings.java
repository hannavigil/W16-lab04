package edu.ucsb.cs56.w16.drawings.davina.advanced;

import java.awt.Graphics2D;
import java.awt.Shape; // general class for shapes
import java.awt.Color; // class for Colors
import java.awt.Stroke;
import java.awt.BasicStroke;

import edu.ucsb.cs56.w16.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w16.drawings.utilities.GeneralPathWrapper;

/**
 * A class with static methods for drawing various pictures
 * 
 * @author Davina Zamanzadeh
 * @version for UCSB CS56, W16 
 */

public class AllMyDrawings
{
    /** Draw a picture with a few desks and cubicles
     * all floating around/balancing on/teetering off
     * each other.
     */
    
    public static void drawPicture1(Graphics2D g2) {
	
        //Make a black desk near the top left
        Desk d1 = new Desk(50,50,200,100);
        g2.setColor(Color.BLACK); g2.draw(d1);

        // We'll draw a huge magenta desk with a very thick stroke
        // it's a little further down and to the right from the red desk
        Stroke thick = new BasicStroke (7.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
        Stroke orig=g2.getStroke(); //Save old stroke
        Desk d3 = new Desk(300,200,400,528);
        g2.setStroke(thick);
        g2.setColor(Color.MAGENTA); g2.draw(d3);

        //Make a red scaled version that's smaller
        //moved to the rightmost edge of the magenta desk
        //rotated to look like it's falling off
        Shape d2 = ShapeTransforms.scaledCopyOfLL(d1,0.8,0.46);
        d2 = ShapeTransforms.translatedCopyOf(d2,560,87);
        d2 = ShapeTransforms.rotatedCopyOf(d2, 57);
        g2.setStroke(orig);
        g2.setColor(Color.RED); g2.draw(d2);
        
        //All the desks seem to be teetering on each other
        //Let's throw in a cyan cubicle to balance the black one
        Cubicle c1 = new Cubicle(0,130,293,200,200);
        g2.setStroke(new BasicStroke(3.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL));
        g2.setColor(Color.CYAN); g2.draw(c1);

        //Label my drawing
        g2.setStroke(orig);
        g2.setColor(Color.BLACK); 
        g2.drawString("A few floating/balancing desks and cubicles  by Davina Zamanzadeh", 20,20);
    }
    
    
    /** Draw a picture of a waves of cubicles (in size) that alternate color
     * according to the rainbow.
     */
    public static void drawPicture2(Graphics2D g2) {
	
	    //Red -> Orange -> Yellow -> Green -> Blue -> Purple -> Pink
	    //It scales down by .8 each time until it hits the middle (c4)
	    //and then scales up by 1.25. The stroke continuously decreases
	    Cubicle c1 = new Cubicle(0,30,200,200,200);
        g2.setStroke(new BasicStroke(3.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL));
        g2.setColor(Color.RED); g2.draw(c1);

        Shape c2 = ShapeTransforms.scaledCopyOfLL(c1,0.8,0.8);
        c2 = ShapeTransforms.translatedCopyOf(c2,203,2);
        g2.setStroke(new BasicStroke(2.5f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL));
        g2.setColor(Color.ORANGE); g2.draw(c2);

        Shape c3 = ShapeTransforms.scaledCopyOfLL(c2,0.8,0.8);
        c3 = ShapeTransforms.translatedCopyOf(c3,163,2);
        g2.setStroke(new BasicStroke(2.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL));
        g2.setColor(Color.YELLOW); g2.draw(c3);

        Shape c4 = ShapeTransforms.scaledCopyOfLL(c3,0.8,0.8);
        c4 = ShapeTransforms.translatedCopyOf(c4,133,2);
        g2.setStroke(new BasicStroke(1.5f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL));
        g2.setColor(Color.GREEN); g2.draw(c4);

        Shape c5 = ShapeTransforms.scaledCopyOfLL(c4,1.25,1.25);
        c5 = ShapeTransforms.translatedCopyOf(c5,103,2);
        g2.setStroke(new BasicStroke(1.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL));
        g2.setColor(Color.BLUE); g2.draw(c5);

        Shape c6 = ShapeTransforms.scaledCopyOfLL(c5,1.25,1.25);
        c6 = ShapeTransforms.translatedCopyOf(c6,128,2);
        g2.setStroke(new BasicStroke(0.5f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL));
        g2.setColor(new Color(76,0,153)); g2.draw(c6); //Purple

        Shape c7 = ShapeTransforms.scaledCopyOfLL(c6,1.25,1.25);
        c7 = ShapeTransforms.translatedCopyOf(c7,162,2);
        g2.setStroke(new BasicStroke(0.3f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL));
        g2.setColor(Color.PINK); g2.draw(c7); 

        //Label my drawing
        g2.setColor(Color.BLACK); 
        g2.drawString("A rainbow wave of cubicles by Davina Zamanzadeh", 20,20);

    }
    
    /** Draws a curve using different colored desks 
     * by rotating the objects themselves.
     */
    
    public static void drawPicture3(Graphics2D g2) {
        //The desks scale down to the middle and scale up to the other side
        //just like in drawPicture 2
        //But here the desks  are rotated down and then up to form a curve
        Desk d1 = new Desk(50,60,200,200);
        Shape d2 = ShapeTransforms.rotatedCopyOf(d1,.8);
        g2.setColor(Color.BLACK); g2.draw(d2);

        Shape c2 = ShapeTransforms.scaledCopyOfLL(d1,0.8,0.8);
        c2 = ShapeTransforms.translatedCopyOf(c2,153,62);
        c2 = ShapeTransforms.rotatedCopyOf(c2,.75);
        g2.setColor(Color.YELLOW); g2.draw(c2);

        Shape c3 = ShapeTransforms.scaledCopyOfLL(c2,0.8,0.8);
        c3 = ShapeTransforms.translatedCopyOf(c3,123,10);
        c3 = ShapeTransforms.rotatedCopyOf(c3,-.25);
        g2.setColor(Color.RED); g2.draw(c3);

        Shape c4 = ShapeTransforms.scaledCopyOfLL(c3,0.8,0.8);
        c4 = ShapeTransforms.translatedCopyOf(c4,133,0);
        c4 = ShapeTransforms.rotatedCopyOf(c4,-.45);
        g2.setColor(Color.GREEN); g2.draw(c4);

        Shape c5 = ShapeTransforms.scaledCopyOfLL(c4,1.25,1.25);
        c5 = ShapeTransforms.translatedCopyOf(c5,103,12);
        c5 = ShapeTransforms.rotatedCopyOf(c5,-.35);
        g2.setColor(Color.PINK); g2.draw(c5);

        Shape c6 = ShapeTransforms.scaledCopyOfLL(c5,1.25,1.25);
        c6 = ShapeTransforms.translatedCopyOf(c6,108,2);
        c6 = ShapeTransforms.rotatedCopyOf(c6,-.35);
        g2.setColor(Color.BLUE); g2.draw(c6); 

        Shape c7 = ShapeTransforms.scaledCopyOfLL(c6,1.25,1.25);
        c7 = ShapeTransforms.translatedCopyOf(c7,102,-80);
        c7 = ShapeTransforms.rotatedCopyOf(c7,-.35);
        g2.setColor(Color.MAGENTA); g2.draw(c7); 


        // label the drawing
        g2.setColor(Color.BLACK);
        g2.drawString("A curve of multicolored desks (using actual objects) by Davina Zamanzadeh", 250,20);
	
    }       
}
