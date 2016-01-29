package edu.ucsb.cs56.w16.drawings.davidwang.advanced;
import java.awt.geom.GeneralPath;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;

/**
   A Pig With Body

   @author David Wang
   @version for CS56, W16, UCSB

*/
public class PigWithBody extends Pig implements Shape
{
    /**
     * Constructor for objects of class PigWithBody
     */
    public PigWithBody(double x, double y, double radius)
    {

        super(x,y,radius);

        // get the GeneralPath that we are going to append stuff to
        GeneralPath gp = this.get();

        double bodyWidth = 3 * radius;
        double bodyHeight = 2 * radius;
        double bodyX = x + 1.3 * radius;
        double bodyY = y + 1.3 * radius;
        double leg1StartX = bodyX + .8 * radius;
        double leg1StartY = bodyY + 1.75 * radius;
        double leg1EndX = bodyX + .8 * radius;
        double leg1EndY = leg1StartY + radius;
        double leg2StartX = leg1StartX + .5 * radius;
        double leg2StartY = bodyY + 1.85 * radius;
        double leg2EndX = leg1StartX + .5 * radius;
        double leg2EndY = leg2StartY + radius;
        double leg3StartX = leg2StartX + .5 * radius;
        double leg3StartY = bodyY + 1.85 * radius;
        double leg3EndX = leg2StartX + .5 * radius;
        double leg3EndY = leg3StartY + radius;
        double leg4StartX = leg3StartX + .5 * radius;
        double leg4StartY = bodyY + 1.75 * radius;
        double leg4EndX = leg3StartX + .5 * radius;
        double leg4EndY = leg4StartY + radius;

        Ellipse2D.Double body = new Ellipse2D.Double(bodyX, bodyY, bodyWidth, bodyHeight);
        Line2D.Double leg1 = new Line2D.Double(leg1StartX, leg1StartY, leg1EndX, leg1EndY);
        Line2D.Double leg2 = new Line2D.Double(leg2StartX, leg2StartY, leg2EndX, leg2EndY);
        Line2D.Double leg3 = new Line2D.Double(leg3StartX, leg3StartY, leg3EndX, leg3EndY);
        Line2D.Double leg4 = new Line2D.Double(leg4StartX, leg4StartY, leg4EndX, leg4EndY);


        GeneralPath wholePig = this.get();
        wholePig.append(body, false);
        wholePig.append(leg1, false);
        wholePig.append(leg2, false);
        wholePig.append(leg3, false);
        wholePig.append(leg4, false);
    }
}
