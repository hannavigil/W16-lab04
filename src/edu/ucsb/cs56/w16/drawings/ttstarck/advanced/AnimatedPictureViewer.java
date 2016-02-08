package edu.ucsb.cs56.w16.drawings.ttstarck.advanced;
import javax.swing.JFrame;
import java.awt.event.*;

/** A viewer class to see an animated picture by Jakob Staahl
   
   @author Tristan Starck
   @version CS56, W16
 */

public class AnimatedPictureViewer extends JFrame
{
    Thread animate;
    AnimatedPictureComponent component;
    static final double centerXPosition = 150;
    static final double centerYPosition = 150;
    static final double radius = 125;    

    /** constructs a JFrame with an animated picture inside
     */
    public AnimatedPictureViewer() {
	// If user passed a command line argument, 
	// get which picture we want to display from the user
	
	// Set the size to whatever size you like (width, height)
	// For projects you turn in, lets not get any bigger than 640,480	
	setSize(640,480);
	
	// Set your own title
	setTitle("Tristan Starck's Animted Drawing");
	
	// Always do this so that the red X (or red circle) works
	// to close the window. 
	
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	// Instantiate your drawing as a "component"
	component = new AnimatedPictureComponent(centerXPosition,centerYPosition, radius);
	
	// Always add your component to the frame 
	// and then make the window visible
	
	add(component);

	getContentPane().addMouseListener(
						new MouseAdapter(){
						    public void mouseEntered(MouseEvent e){
							//Get a new animation thread and start
							// the animation on it.
							animate = new Animate();
							animate.start();
						    }//end mouseEntered
						    
						    public void mouseExited(MouseEvent e){
							//Terminate the animation.
							animate.interrupt();
							//Let the thread die a natural death.
							// Then make it eligible for garbage
							// collection.
							while (animate.isAlive()){}//loop;
							animate = null;
						    }//end MouseExited
						}//end new MouseAdapter
						);//end addMouseListener()
	//End definition of anonymous inner class
	setVisible(true);
    }

    public static void main(String[] args) {
	AnimatedPictureViewer apv = new AnimatedPictureViewer();
    }

    class Animate extends Thread{

	public void run(){//begin run method
	    try{
		//The following code will continue to
		// loop until the animation thread is
		// interrupted by the mouseExited 
		// method.               
		while(true){
		    //Display several images in succession. 
		    display(1000);
		}//end while loop  
	    }catch(Exception ex){
		if(ex instanceof InterruptedException){
		    //Do nothing. This exception is
		    // expected on mouseExited.    
		}else{//Unexpected exception occurred.
		    System.out.println(ex);
		    System.exit(1);//terminate program
		}//end else                    
	    }//end catch              
	}//end run          
	//-----------------------------------------//

	//This method displays an image and sleeps
	// for a prescribed period of time.  It 
	// terminates and throws an      
	// InterruptedException when interrupted
	// by the mouseExited method.     
	void display(int delay)
	    throws InterruptedException{
	    //update the animation
	    component.repaint();
	    //Check interrupt status.  If interrupted
	    // while not asleep, force animation to
	    // terminate.              
	    if(Thread.currentThread().interrupted())
		throw(new InterruptedException());
	    //Delay specified number of msec.
	    //Terminate animation automatically if
	    // interrupted while asleep.  
	    Thread.currentThread().sleep(delay);
	}//end display method    
	//-----------------------------------------//
    }//end inner class named Animate     
}
