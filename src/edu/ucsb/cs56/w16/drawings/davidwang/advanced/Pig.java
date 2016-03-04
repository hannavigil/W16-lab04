package edu.ucsb.cs56.w16.drawings.davidwang.advanced;
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.Shape; // general class for shapes

import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Ellipse2D;

import edu.ucsb.cs56.w16.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w16.drawings.utilities.GeneralPathWrapper;

/**
   A vector drawing of a pig that implements
   the Shape interface, and so can be drawn, as well as
   rotated, scaled, etc.

   @author David Wang
   @version for CS56, W16, UCSB

*/
public class Pig extends GeneralPathWrapper implements Shape
{
    /**
       Constructor

       @param x x coord of middle of face
       @param y y coord of middle of face
       @param radius radius of head

    */
    public Pig(double x, double y, double radius)
    {

        double eyeSize = .4 * radius;
        double noseSize = .8 * radius;
        double earWidth = .4 * radius;
        double earHeight = .8 * radius;

        double leftEyeX = x + .4 * radius;
        double leftEyeY = y + .4 * radius;
        double rightEyeX = x + 1.2 * radius;
        double rightEyeY = y + .4 * radius;
        double noseX = x + .6 * radius;
        double noseY = y + radius;
        double leftEarX = x + radius - (radius * Math.sqrt(2) / 2) - .2 * radius;
        double leftEarY = y + radius - (radius * Math.sqrt(2) / 2) - earHeight;
        double rightEarX = x + radius + (radius * Math.sqrt(2) / 2) - .2 * radius;
        double rightEarY = y + radius - (radius * Math.sqrt(2) / 2) - earHeight;
        double leftNostrilStartX = x + .8 * radius;
        double leftNostrilStartY = y + 1.2 * radius;
        double leftNostrilEndX = x + .8 * radius;
        double leftNostrilEndY = y + 1.6 * radius;
        double rightNostrilStartX = x + 1.2 * radius;
        double rightNostrilStartY = y + 1.2 * radius;
        double rightNostrilEndX = x + 1.2 * radius;
        double rightNostrilEndY = y + 1.6 * radius;

        Ellipse2D.Double head = new Ellipse2D.Double(x, y, 2 * radius, 2 * radius);
        Ellipse2D.Double leftEye = new Ellipse2D.Double(leftEyeX, leftEyeY, eyeSize, eyeSize);
        Ellipse2D.Double rightEye = new Ellipse2D.Double(rightEyeX, rightEyeY, eyeSize, eyeSize);
        Ellipse2D.Double nose = new Ellipse2D.Double(noseX, noseY, noseSize, noseSize);
        Ellipse2D.Double leftEar = new Ellipse2D.Double(leftEarX, leftEarY, earWidth, earHeight);
        Ellipse2D.Double rightEar = new Ellipse2D.Double(rightEarX, rightEarY, earWidth, earHeight);
        Line2D.Double leftNostril = new Line2D.Double(leftNostrilStartX, leftNostrilStartY, leftNostrilEndX, leftNostrilEndY);
        Line2D.Double rightNostril = new Line2D.Double(rightNostrilStartX, rightNostrilStartY, rightNostrilEndX, rightNostrilEndY);


        GeneralPath pig = this.get();
        pig.append(head, false);
        pig.append(leftEye, false);
        pig.append(rightEye, false);
        pig.append(nose, false);
        pig.append(leftEar, false);
        pig.append(rightEar, false);
        pig.append(leftNostril, false);
        pig.append(rightNostril, false);
    }
}
