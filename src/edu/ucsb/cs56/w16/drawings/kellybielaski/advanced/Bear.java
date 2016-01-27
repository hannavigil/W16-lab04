package edu.ucsb.cs56.w16.drawings.kellybielaski.advanced;
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
      
   @author Kelly Bielaski 
   @version for CS56, W16, UCSB
   
*/
public class Bear extends GeneralPathWrapper implements Shape
{
    /**
       Constructor
       
       @param x x coord of upper left corner of face 
       @param y y coord of upper left corner of face
       @param rad radius of the face
    */
    public Bear(double x, double y, double rad)
    {
	//make the base of the face
	Ellipse2D.Double face= new Ellipse2D.Double(x, y, 2*rad,2*rad);

	//make the mouth regin
	double mouthx=x+rad/4;
	double mouthy=y+4*rad/3-rad/8;
	double mouthw=3*rad/2;
	double mouthh=2*rad/3;
	Ellipse2D.Double mouth= new Ellipse2D.Double(mouthx, mouthy, mouthw, mouthh);

	//make the nose
	double nosex=mouthx+3*rad/4-rad/10;
	double nosey= mouthy+mouthh/5;
	double nosew=rad/10;
	double noseh= rad/18;
	Ellipse2D.Double nose= new Ellipse2D.Double(nosex, nosey, 2*nosew, 2*noseh);

	//make the right ear
	double earrad=rad/2;
	double rearx=x+rad+0.707*(earrad/2+rad)-earrad/2;
	double reary=y+rad-.707*(rad)-earrad/2;
	Ellipse2D.Double rear= new Ellipse2D.Double(rearx, reary, earrad, earrad);

	//make the left ear
	double learx=x+rad-0.707*(earrad/2+rad)-earrad/2;
	double leary=y+rad-.707*rad-earrad/2;
	Ellipse2D.Double lear= new Ellipse2D.Double(learx, leary, earrad, earrad);     

	//make the right eye
	double eyerad=noseh;
	double reyex=x+rad+rad/3-eyerad;
	double reyey=y+2*rad/3+rad/12-eyerad;
	Ellipse2D.Double reye=new Ellipse2D.Double(reyex, reyey, 2*eyerad, 2*eyerad);

	//make the left eye
	double leyex=x+2*rad/3-eyerad;
	double leyey=y+2*rad/3+rad/12-eyerad;
	Ellipse2D.Double leye=new Ellipse2D.Double(leyex, leyey, 2*eyerad, 2*eyerad);

        // put the whole face together	
        GeneralPath wholeBear = this.get();
        wholeBear.append(face, false);
        wholeBear.append(mouth, false);
        wholeBear.append(nose, false);
	wholeBear.append(rear, false);    
	wholeBear.append(lear, false);
	wholeBear.append(reye, false);
	wholeBear.append(leye, false);
    }
}
