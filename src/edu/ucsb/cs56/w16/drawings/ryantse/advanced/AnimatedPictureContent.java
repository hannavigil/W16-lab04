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
			this.addFish(50 + (int)((this.frameWidth - 50)*Math.random()), 50 + (int)((this.frameHeight-50)*Math.random()), 70 + skew, 30 + skew);
		}
	}

	private void addBubble(double x, double y, double radius) {
		this.bubbles.add(new Bubble(x, y, radius));
	}

	public void addFish(int x, int y, int width, int height) {
		this.fishes.add(new AnimatedFish(x, y, width, height));
	}

	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;

		// Draw the fish tank color.
		g2.setColor(new Color(217, 235, 250));
		g2.fillRect(0, 0, this.frameWidth, this.frameHeight);

		g2.setColor(Color.BLACK); 
		g2.drawString("Current Animation Speed: " + AnimatedPictureViewer.getFramesPerSecond() + " FPS", 5, 15);
		g2.drawString("Use the scroll wheel to change the animation speed.", 5, 430);
		g2.drawString("Click anywhere to spawn a fish at the current mouse location.", 5, 450);

		for(int i = 0; i < this.fishes.size(); i++) {
			AnimatedFish thisFish = this.fishes.get(i);
			thisFish.draw();
			g2.setColor(fishColors[i % this.fishColors.length]);
			g2.draw(thisFish);
		}

		/* This is a workaround for the lack of a GeneralPath reset() method
		 * in the GeneralPathWrapper. Instead, we construct a new GeneralPath
		 * that is then set for the wrapper. In this case, since we are creating
		 * bubbles that do not need a transform, we can reuse the same
		 * GeneralPath on all the bubbles.
		 */
		GeneralPath bubblePath = new GeneralPath();

		for(int i = (this.bubbles.size()-1); i >= 0; i--) {
			Bubble thisBubble = this.bubbles.get(i);
			thisBubble.set(bubblePath);
			thisBubble.draw();
		}

		g2.setColor(Color.BLUE);
		g2.draw(bubblePath);
	}

	private class Bubble extends GeneralPathWrapper implements Shape {
		private double currentX;
		private double currentY;
		private double radius;
		private double deltaY = 3;

		public Bubble(double x, double y, double radius) {
			this.currentX = x;
			this.currentY = y;
			this.radius = radius;
		}

		public void draw() {
			// Clean up bubbles that are off screen.
			if(this.currentY < -this.radius) {
				bubbles.remove(this);
				return;
			}

			Ellipse2D.Double bubble = new Ellipse2D.Double(this.currentX - this.radius + Math.cos(this.currentY), this.currentY - this.radius, this.radius*2, this.radius*2);
			this.get().append(bubble, false);

			this.currentY -= this.deltaY;
		}
	}

	private class AnimatedFish extends GeneralPathWrapper implements Shape {
		private double currentX;
		private double currentY;
		private double width;
		private double height;
		private double deltaX = 1;
		private double deltaY = -1;
		private boolean flipped = false;

		public AnimatedFish(int x, int y, int width, int height) {
			this.currentX = x;
			this.currentY = y;
			this.width = width;
			this.height = height;

			// Have some of the fish move in the opposite vertical direction.
			if(Math.random() < 0.5) { this.deltaY *= -1; }

			// Have some fish start off facing the other way.
			if(Math.random() < 0.5) { flipFish(); }
		}

		public void flipFish() {
			this.flipped = !this.flipped;
			this.deltaX *= -1;
		}

		public void draw() {
			// Randomly have the fish change it's x-direction.
			if(Math.random() < 0.01) {
				flipFish();
			}

			// Randomly have the fish change it's y-direction.
			if(Math.random() < 0.05) {
				this.deltaY *= -1;
			}

			// Apply the change in x and y directions.
			this.currentX += this.deltaX;
			this.currentY += this.deltaY;

			// Create the spotted fish in new location.
			SpottedFish sf = new SpottedFish(this.currentX, this.currentY, this.width, this.height);

			// Adopt the GeneralPath created by the spotted fish.
			this.set(sf.get());

			// Check if the fish is flipped, if so, then transform the drawn fish.
			if(this.flipped) {
				AffineTransform af = new AffineTransform();
				Rectangle2D box = getBounds2D();

				double x = box.getX();
				double y = box.getY();

				af.translate(x + box.getWidth(), y);
				af.scale(-1, 1);
				af.translate(-x, -y);

				this.get().transform(af);
			}

			// Check that the fish is within the x-bounds of the frame.
			if(this.currentX < 0 || this.currentX > frameWidth) {
				flipFish();
				// Prevent fish from getting stuck at the border.
				this.currentX = (this.currentX < 0) ? 1 : frameWidth-1;
			}

			// Check that the fish is within the y-bounds of the frame.
			if(this.currentY < 0 || this.currentY > frameHeight) {
				this.deltaY *= -1;
				// Prevent fish from getting stuck at the border.
				this.currentY = (this.currentY < 0) ? 1 : frameHeight - 1;
			}

			// Randomly generate bubbles from the fish.
			if(Math.random() < 0.01) {
				AnimatedPictureContent.this.addBubble(this.currentX + (this.flipped ? 0 : this.width), this.currentY - this.height/2, (this.height/2) * Math.random());
			}
		}
	}
}