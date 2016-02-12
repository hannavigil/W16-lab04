package edu.ucsb.cs56.w16.drawings.davina.advanced;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Graphics;
import java.awt.Color;

/** A class to see an animated cubicle inside a GUI window.
   @author Davina Zamanzadeh
   @version CS56, W16
 */
public class AnimatedPictureViewer {
    private Thread animate;
    private Cubicle cubicle;
    private AnimationPanel panel;
    //Initialization data
    private static final double initXPos = 20;
    private static final double initYPos = 83;
    private static final double initDeskWidth = 200;
    private static final double initDeskHeight = 150;
    private static final double initCubicleWallHeight = 150;
    private static float hue;
    private static float saturation;
    private double currentX;
    private double currentY;
    

    /** Constructor that sets up the cubicle to be animated,
     * and some necessary information for animation (such as (x,y)
     * coordinates).
     */
    public AnimatedPictureViewer() {
        //Create the drawing to be animated
        cubicle = new Cubicle(initXPos, initYPos, initDeskWidth, initDeskHeight, initCubicleWallHeight);
        panel = new AnimationPanel();
        currentX = initXPos;
        currentY = initYPos;
        hue = 344.25f;
    }

    /**Sets the frame up (creates it, adds the necessary parts,
     * and gives it the correct settings.
     */
    public void go() {
        JFrame frame = new JFrame();
        frame.getContentPane().add(panel); //Add panel to frame (the panel will take care of the internal components)
        frame.getContentPane().addMouseListener(new MouseAdapter(){
            //When the mouse enters the frame we start the animation
            public void mouseEntered(MouseEvent e){
                animate = new Animate();
                animate.start();
            }
            
            //When the mouse exits we pause the animation
            public void mouseExited(MouseEvent e){
                animate.interrupt();
                while (animate.isAlive()){}
                animate = null;
            }
        });
        frame.setSize(640,480); // Set the size of picture
        frame.setTitle("Davina's First Animated Drawing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//Enable closing window
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        AnimatedPictureViewer apv = new AnimatedPictureViewer();
        apv.go();
    }

    /**Inner class to extend JPanel to handle animation
     * and prevents smearing by overriding paintComponent().
     */
    class AnimationPanel extends JPanel {
        /**Overrides paintComponent(g) method so that
         * we can animate our cubicle
         */
        public void paintComponent(Graphics g) {
            Graphics2D g2d = (Graphics2D) g;
            g2d.setColor(Color.white);
            g2d.fillRect(0,0,this.getWidth(),this.getHeight());

            g2d.setColor(this.nextColor());
            Cubicle newCubicle = new Cubicle(currentX, currentY, initDeskWidth, initDeskHeight, initCubicleWallHeight);
            g2d.draw(newCubicle);
            //Do stuff with currentX and Y to animate it
        }

        /**Helper function that generates the next color in the sequence
         * for the animation
         */
        private Color nextColor() {
            saturation = saturation - 1;
            return Color.getHSBColor(hue, saturation,1);
        }
    }

    /**Inner class that deals with running the animation of the
     * component.
     */
    class Animate extends Thread{
        /**Runs the animation with a set delay; knows how to deal
         * with mouse interruptions.
         */
        public void runAnimation(){
            try{
                while (true){
                    display(20);
                }
            } catch(Exception ex){
                if (ex instanceof InterruptedException) {
                    //Do nothing
                } else {//Unexpected exception occurred.
                    System.out.println(ex);
                    System.exit(1);
                }
            }
        }

        /** Helper function to the runAnimation function.
         * @param delay an integer that is the desired delay you want to slow down your animation with
         */
        private void display(int delay) throws InterruptedException{
            panel.repaint();
            if(Thread.currentThread().interrupted())
                throw(new InterruptedException());
            Thread.currentThread().sleep(delay);
        }

    }
}
