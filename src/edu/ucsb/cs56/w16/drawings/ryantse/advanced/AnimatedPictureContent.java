package edu.ucsb.cs56.w16.drawings.ryantse.advanced;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import javax.swing.JComponent;

import java.awt.Shape;
import java.awt.Color;
import java.awt.geom.GeneralPath;
import java.awt.geom.Line2D; 
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.AffineTransform;

import java.util.ArrayList;

import edu.ucsb.cs56.w16.drawings.utilities.GeneralPathWrapper;
import edu.ucsb.cs56.w16.drawings.utilities.ShapeTransforms;

public class AnimatedPictureContent extends JComponent {
	private int frameWidth;
	private int frameHeight;
	private ArrayList<AnimatedFish> fishes;
	private ArrayList<Bubble> bubbles;
	private Color[] fishColors = {Color.BLACK, Color.CYAN, Color.DARK_GRAY, Color.GRAY, Color.LIGHT_GRAY, Color.MAGENTA, Color.ORANGE, Color.PINK, Color.RED, Color.WHITE, Color.YELLOW};

	public AnimatedPictureContent(int frameWidth, int frameHeight) {
		this.frameWidth = frameWidth;
		this.frameHeight = frameHeight;
		this.fishes = new ArrayList<AnimatedFish>();
		this.bubbles = new ArrayList<Bubble>();

		// Start off with a random number of fish (at least 10) that have size 70 x 30 or greater.
		for(int i = 0; i < 10 + (int)(10 * Math.random()); i++) {
			int skew = (int)(20 * Math.random());
			addFish(50 + (int)((frameWidth - 50)*Math.random()), 50 + (int)((frameHeight-50)*Math.random()), 70 + skew, 30 + skew);
		}
	}

	public void addFish(int x, int y, int width, int height) {
		fishes.add(new AnimatedFish(x, y, width, height));
	}

	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;

		// Draw the fish tank color.
		g.setColor(new Color(217, 235, 250));
		g.fillRect(0, 0, frameWidth, frameHeight);

		g2.setColor(Color.BLACK); 
		g2.drawString("Current Animation Speed: " + AnimatedPictureViewer.getFramesPerSecond() + " FPS", 5, 15);
		g2.drawString("Use the scroll wheel to change the animation speed.", 5, 430);
		g2.drawString("Click anywhere to spawn a fish at the current location.", 5, 450);

		for(int i = 0; i < fishes.size(); i++) {
			AnimatedFish thisFish = fishes.get(i);
			thisFish.draw();
			g2.setColor(fishColors[i % fishColors.length]);
			g2.draw(thisFish);
		}

		/* This is a workaround for the lack of a GeneralPath reset() method
		 * in the GeneralPathWrapper. Instead, we construct a new GeneralPath
		 * that is then set for the wrapper. In this case, since we are creating
		 * bubbles that do not need a transform, we can reuse the same
		 * GeneralPath on all the bubbles.
		 */
		GeneralPath bubblePath = new GeneralPath();

		for(int i = (bubbles.size()-1); i >= 0; i--) {
			Bubble thisBubble = bubbles.get(i);
			thisBubble.set(bubblePath);
			thisBubble.draw();
			g2.setColor(Color.BLUE);
			g2.draw(thisBubble);
		}
	}

	private void addBubble(double x, double y, double radius) {
		bubbles.add(new Bubble(x, y, radius));
	}

	private class Bubble extends GeneralPathWrapper implements Shape {
		private double currentX;
		private double currentY;
		private double radius;
		private double DELTA_Y = 3;

		public Bubble(double x, double y, double radius) {
			this.currentX = x;
			this.currentY = y;
			this.radius = radius;
		}

		public void draw() {
			// Clean up bubbles that are off screen.
			if(this.currentY < -radius) {
				bubbles.remove(this);
				return;
			}

			Ellipse2D.Double bubble = new Ellipse2D.Double(currentX - radius, currentY - radius, radius*2, radius*2);
			this.get().append(bubble, false);

			currentY -= DELTA_Y;
		}
	}

	private class AnimatedFish extends GeneralPathWrapper implements Shape {
		private double currentX;
		private double currentY;
		private double width;
		private double height;
		private double DELTA_X = 1;
		private double DELTA_Y = -1;
		private boolean flipped = false;

		public AnimatedFish(int x, int y, int width, int height) {
			this.currentX = x;
			this.currentY = y;
			this.width = width;
			this.height = height;

			// Have some of the fish move in the opposite vertical direction.
			if(Math.random() < 0.5) { DELTA_Y *= -1; }

			// Have some fish start off facing the other way.
			if(Math.random() < 0.5) { flipFish(); }
		}

		public void flipFish() {
			this.flipped = !this.flipped;
			DELTA_X *= -1;
		}

		public void draw() {
			// Randomly have the fish change it's x-direction.
			if(Math.random() < 0.01) {
				flipFish();
			}

			// Randomly have the fish change it's y-direction.
			if(Math.random() < 0.05) {
				DELTA_Y *= -1;
			}

			// Apply the change in x and y directions.
			currentX += DELTA_X;
			currentY += DELTA_Y;

			// Create the spotted fish in new location.
			SpottedFish sf = new SpottedFish(currentX, currentY, width, height);

			// Adopt the GeneralPath created by the spotted fish.
			this.set(sf.get());

			// Check if the fish is flipped, if so, then transform the drawn fish.
			if(this.flipped) {
				AffineTransform af = new AffineTransform();
				Rectangle2D box = getBounds2D();

				double x = box.getX();
				double y = box.getY();

				af.translate(box.getWidth(), 0);
				af.translate(x, y);
				af.scale(-1, 1);
				af.translate(-x, -y);

				this.get().transform(af);
			}

			// Check that the fish is within the x-bounds of the frame.
			if(currentX < 0 || currentX > frameWidth) {
				flipFish();
				// Prevent fish from getting stuck at the border.
				currentX = (currentX < 0) ? 1 : frameWidth-1;
			}

			// Check that the fish is within the y-bounds of the frame.
			if(currentY < 0 || currentY > frameHeight) {
				DELTA_Y *= -1;
				currentY = (currentY < 0) ? 1 : frameHeight - 1;
			}

			// Randomly generate bubbles from the fish.
			if(Math.random() < 0.01) {
				AnimatedPictureContent.this.addBubble(currentX + (this.flipped ? 0 : width), currentY - height/2, (height/2) * Math.random());
			}
		}
	}
}