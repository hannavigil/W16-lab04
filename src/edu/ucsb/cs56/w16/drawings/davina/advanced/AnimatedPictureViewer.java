package edu.ucsb.cs56.w16.drawings.davina.advanced;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Stroke;
import java.awt.BasicStroke;
import java.awt.Font;

/** A class to see an animated cubicle bounce inside a GUI window.
   @author Davina Zamanzadeh
   @version CS56, W16
 */
public class AnimatedPictureViewer {
    private Thread animate;
    private Cubicle cubicle;
    private AnimationPanel panel;
    private boolean displayText;
    //Initialization data
    private static final double initXPos = 550;
    private static final double initYPos = 100;
    private static final double initDeskWidth = 30;
    private static final double initDeskHeight = 22.5;
    private static final double initCubicleWallHeight = 22.5;
    private static final double finalXPos = 20;
    private static final double finalYPos = 20;
    private static final double finalDeskWidth = 200;
    private static final double finalDeskHeight = 100;
    private static final double finalCubicleWallHeight = 100;
    //Data about the cubicle that gets updated as the animation goes
    private static float hue;
    private static float saturation;
    private double currentX;
    private double currentY;
    private double currentWidth;
    private double currentHeight;
    private double currentCubicleWallHeight;
    private float lineThickness;
    private int delayHelper; //This helps make a bouncy motion
    private boolean oppositeDirection; //This keeps track of the direction of animation

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
        currentWidth = initDeskWidth;
        currentHeight = initDeskHeight;
        currentCubicleWallHeight = initCubicleWallHeight;
        hue = 54.1f; //Give it an initial color similar to orange
        oppositeDirection = false;
        delayHelper = 0;
        lineThickness = 1.0f;
        displayText = false;
    }

    /**Sets the frame up (creates it, adds the necessary parts,
     * and gives it the correct settings.
     */
    public void go() {
        JFrame frame = new JFrame();
        frame.getContentPane().add(panel); //Add panel to frame (the panel will take care of the internal components)
        frame.setSize(640,480); 
        frame.setTitle("Davina's First Animated Drawing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
        frame.setVisible(true);

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

            //On click we want to toggle display text
            public void mouseClicked(MouseEvent e) {
                displayText = !displayText;
            }
        });
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
         * we can animate our cubicle bounce
         */
        public void paintComponent(Graphics g) {
            Graphics2D g2d = (Graphics2D) g;
            g2d.setColor(Color.white);
            g2d.fillRect(0,0,this.getWidth(),this.getHeight());
            

            g2d.setColor(this.nextColor());
            Cubicle newCubicle = new Cubicle(currentX, currentY, currentWidth, currentHeight, currentCubicleWallHeight);
            g2d.setStroke(new BasicStroke(lineThickness));
            if(displayText) {
                g2d.setFont(new Font("ComicSans", Font.BOLD, 30));
                g2d.drawString("Doing work is COOL!!!!", 100,100);
            }
            g2d.draw(newCubicle);
        }

        /**Helper function that generates the next color in the sequence
         * for the animation
         */
        private Color nextColor() {
            saturation = 1;
            return Color.getHSBColor(hue, saturation,1);
        }
    }

    /**Inner class that deals with running the animation of the
     * component.
     */
    class Animate extends Thread{
        /**Override the Thread method run()
         * in order to properly animate the
         * cubicle.
         */
        public void run(){
            try{
                while (true){
                    display(calculateDelay());

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
            if(currentX < finalXPos) { oppositeDirection = true; }
            else if(currentX > initXPos) { oppositeDirection = false; }
            if(oppositeDirection) {
                currentX++;
                currentY -= .2;
                currentWidth -= .7;
                currentHeight -= .2;
                currentCubicleWallHeight -= .2;
                delayHelper += .7;
                lineThickness -= .005;
            }
            else if ((!oppositeDirection) || (currentX > initXPos)) { 
                currentX--;
                currentY += .2;
                currentWidth += .7;
                currentHeight += .2;
                currentCubicleWallHeight += .2;
                delayHelper -= .7;
                lineThickness += .005;
            }

            panel.repaint();
            if(Thread.currentThread().interrupted())
                throw(new InterruptedException());
            Thread.currentThread().sleep(delay);
        }

        /**Helper function that sets the delay so that it 
         * looks like the cubicle is bouncing.
         */
        private int calculateDelay() { 
            return (int)(Math.pow(1.6, delayHelper*Math.log(delayHelper + 1)));
        }

    }
}
