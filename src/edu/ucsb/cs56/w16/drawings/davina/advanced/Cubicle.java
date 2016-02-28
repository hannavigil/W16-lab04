package edu.ucsb.cs56.w16.drawings.davina.advanced;
import java.awt.geom.GeneralPath;  
import java.awt.Shape; 
import java.awt.geom.Rectangle2D;

/**
   A Cubicle
      
   @author Davina Zamanzadeh
   @version for CS56, W16, UCSB
   
*/
public class Cubicle extends Desk implements Shape
{
    /**
     * Constructor for objects of class Cubicle
     *
     * @param x x coordinate of upper left corner of the cubicle starting from the left wall
     * @param y y coordinate of upper left corner of the cubicle starting from the left wall
     * @param width width of the cubicle/desk part of cubicle
     * @param height height of the desk part of cubicle
     * @param wallHeight height of the side walls that extend above the desk
     */
    public Cubicle(double x, double y, double width, double height, double wallHeight)
    {
        // construct the basic house shell corkheight distance down from
        // upper left corner (to make room for the corkboard/shelf)
        super(x,y+wallHeight,width,height);
	
        // get the GeneralPath that we are going to append stuff to
        GeneralPath gp = this.get();
	
	    //Create left wall of cubicle
	    double widthWall = (width/27);
        Rectangle2D.Double leftWall =
            new Rectangle2D.Double(x, y, widthWall, wallHeight);

        //Create right wall of cubicle
        Rectangle2D.Double rightWall =
            new Rectangle2D.Double(x + width - widthWall, y, widthWall, wallHeight);

	    //Create the shelf that is above the cork board
	    //It is as long as the desk itself is, but between the walls
	    double shelfX = x+widthWall;
	    double shelfYShift = 2*widthWall;
	    double shelfY = y+shelfYShift;
	    double shelfWidth = width-(2*widthWall);
	    double shelfHeight = widthWall;
        Rectangle2D.Double shelf =
            new Rectangle2D.Double(shelfX, shelfY, shelfWidth, shelfHeight);
        
        //Create the cork board that is under the shelf and extends down to the 
        //desk part. It is as long as the desk itself.
	    //It is as long as the desk itself is but between the walls
        Rectangle2D.Double corkBoard =
            new Rectangle2D.Double(shelfX, shelfY + shelfHeight, 
                                shelfWidth, wallHeight - shelfYShift - shelfHeight);

        //Create the little tube light-bulb near top left of the cork board
        Rectangle2D.Double light =
            new Rectangle2D.Double(shelfX + widthWall, shelfY + shelfHeight + widthWall, 
                                (.25*shelfWidth), (.80*widthWall));


        //The pull-out desk is a little under the top of the desk so there's a gap, and it's 
        //relatively thin and as wide as the distance between the left side of the desk
        //and the drawers on the right
        Rectangle2D.Double pullOutDesk =
            new Rectangle2D.Double(x, y + wallHeight + (height/7), ((2*width)/3), (height/13));

        
        // add the pull out desk/drawer, corkboard, and light
        GeneralPath wholeCubicle = this.get();
        wholeCubicle.append(leftWall, false);
        wholeCubicle.append(rightWall, false);
        wholeCubicle.append(shelf, false);
        wholeCubicle.append(corkBoard, false);
        wholeCubicle.append(light, false);
        wholeCubicle.append(pullOutDesk, false);
    }    
}
