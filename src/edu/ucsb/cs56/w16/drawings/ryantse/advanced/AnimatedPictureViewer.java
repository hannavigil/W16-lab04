package edu.ucsb.cs56.w16.drawings.ryantse.advanced;
import javax.swing.JFrame;
import java.awt.event.*;

public class AnimatedPictureViewer extends JFrame
{
	private Thread animation;
	private AnimatedPictureContent content;
	private static final Integer frameWidth = 640;
	private static final Integer frameHeight = 480;
	public static Integer framesPerSecond = 60;

	public AnimatedPictureViewer() {
		setSize(frameWidth, frameHeight);
		setTitle("Ryan Tse's Animated Fish Tank");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		content = new AnimatedPictureContent(frameWidth, frameHeight);

		add(content);

		MouseListener ml = new MouseListener();
		getContentPane().addMouseListener(ml);
		getContentPane().addMouseWheelListener(ml);
		setVisible(true);
	}

	public static Integer getFramesPerSecond() {
		return framesPerSecond;
	}

	public static void main(String[] args) {
		AnimatedPictureViewer apv = new AnimatedPictureViewer();
	}

	private class MouseListener extends MouseAdapter {
		public void mouseEntered(MouseEvent e) {
			animation = new Animation();
			animation.start();
		}

		public void mouseExited(MouseEvent e) { 
			animation.interrupt();
			while(animation.isAlive()) {}
			animation = null;
		}

		public void mouseReleased(MouseEvent e) {
			if(e.getButton() == MouseEvent.BUTTON1) {
				int skew = (int)(20 * Math.random());
				content.addFish(e.getX(), e.getY(), 70 + skew, 30 + skew);
			}
		}

		public void mouseWheelMoved(MouseWheelEvent e) {
			framesPerSecond += e.getWheelRotation();
			if(framesPerSecond < 1) framesPerSecond = 1;
		}
	}

	private class Animation extends Thread {
		public void run() {
			try {
				while(true) {
					display();
				}
			} catch (Exception e) {
				if(!(e instanceof InterruptedException)) {
					System.out.println(e);
					System.exit(1);
				}
			}
		}

		public void display() throws InterruptedException{
			content.repaint();

			if(Thread.currentThread().interrupted()) {
				throw (new InterruptedException());
			}

			Thread.currentThread().sleep(1000/framesPerSecond);
		}
	}
}
