package edu.ucsb.cs56.w16.drawings.ryantse.advanced;

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
 * @author Ryan Tse
 * @version for UCSB CS56, W16 
 */

public class AllMyDrawings
{
	/** Draw a picture with a few regular fish.
	 */
	
	public static void drawPicture1(Graphics2D g2) {
		Fish f1 = new Fish(80,250,40,30);
		g2.setColor(Color.BLACK);
		g2.draw(f1);

		Fish f2 = new Fish(30, 90, 100, 60);
		g2.setColor(Color.RED);
		g2.draw(f2);

		Shape f3 = ShapeTransforms.rotatedCopyOf(f2, Math.PI/6.0);
		f3 = ShapeTransforms.translatedCopyOf(f3, 400, 300);
		f3 = ShapeTransforms.horizontallyFlippedCopyOf(f3);
		g2.setColor(Color.ORANGE);
		g2.draw(f3);

		Shape f4 = ShapeTransforms.scaledCopyOfLL(f3, 3, 3);
		f4 = ShapeTransforms.translatedCopyOf(f4, -100, -125);
		f4 = ShapeTransforms.rotatedCopyOf(f4, Math.PI/2.0);
		g2.setColor(Color.GREEN);
		g2.draw(f4);

		g2.setColor(Color.BLACK); 
		g2.drawString("A few regular fish in a tank, with a larger green fish attempting to escape.", 20, 450);
	}
	
	
	/** Draw a picture with a few spotted fish.
	 */
	public static void drawPicture2(Graphics2D g2) {
		Fish f1 = new Fish(15, 300, 70, 40);
		g2.setColor(Color.BLACK);
		g2.draw(f1);

		SpottedFish f2 = new SpottedFish(70, 160, 90, 30);
		g2.setColor(Color.BLUE);
		g2.draw(f2);

		Shape f3 = ShapeTransforms.rotatedCopyOf(f2, Math.PI/6.0);
		f3 = ShapeTransforms.translatedCopyOf(f3, 400, 160);
		f3 = ShapeTransforms.horizontallyFlippedCopyOf(f3);
		g2.setColor(Color.ORANGE);
		g2.draw(f3);

		Shape f4 = ShapeTransforms.scaledCopyOfLL(f3, 4, 4);
		f4 = ShapeTransforms.translatedCopyOf(f4, -100, -125);
		f4 = ShapeTransforms.rotatedCopyOf(f4, Math.PI/6.0);
		g2.setColor(Color.GREEN);
		g2.draw(f4);

		g2.setColor(Color.BLACK); 
		g2.drawString("A lonely regular fish amongst a tank of spotted fish.", 20,20);
	}
	
	/** Draw a picture with a large spotted fish chasing a few regular fish.
	 */
	public static void drawPicture3(Graphics2D g2) {
		SpottedFish f1 = new SpottedFish(15, 240, 230, 170);
		g2.setColor(Color.BLUE);
		g2.draw(f1);

		Fish f2 = new Fish(300, 240, 70, 30);
		g2.setColor(Color.ORANGE);
		g2.draw(f2);

		Shape f3 = ShapeTransforms.rotatedCopyOf(f2, Math.PI/6.0);
		f3 = ShapeTransforms.translatedCopyOf(f3, 400, 160);
		f3 = ShapeTransforms.horizontallyFlippedCopyOf(f3);
		g2.setColor(Color.ORANGE);
		g2.draw(f3);

		Shape f4 = ShapeTransforms.scaledCopyOfLL(f3, 4, 4);
		f4 = ShapeTransforms.translatedCopyOf(f4, -100, -125);
		f4 = ShapeTransforms.rotatedCopyOf(f4, Math.PI/6.0);
		g2.setColor(Color.GREEN);
		g2.draw(f4);

		Fish f6 = new Fish(290, 200, 150, 39);
		g2.setColor(Color.BLACK);
		g2.draw(f6);

		g2.setColor(Color.BLACK); 
		g2.drawString("A school of regular fish swimming toward their mother to get away from the spotted fish.", 20,20);
	}
}
