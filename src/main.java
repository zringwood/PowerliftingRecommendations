import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Main extends Canvas implements MouseListener{
	
	//These are the points needed for measuring the proportions of the photo.
	public static Point[] bioMarkers = new Point[8];
	//These allow the program to access each biomarker as they've been selected by the user.
	public static final int ANKLE = 0;
	public static final int KNEE = 1;
	public static final int HIP = 2;
	public static final int LEFT_SHOULDER = 3;
	public static final int RIGHT_SHOULDER = 4;
	public static final int ELBOW = 5;
	public static final int WRIST = 6;
	public static final int TOP_OF_HEAD = 7;
	
	//This integer tracks the current point being inputted. 
	private int currentInput = 0;
	
	/*
	 * Constructor just implements itself as a mouselistener. 
	 * It needs dimensions so that it can clear the canvas for animation.
	 */
	public Main(int width, int height) {
		super();
		setSize(width,height);
		addMouseListener(this);
	}
	
	
	//Draws the image to the screen
	public void paint(Graphics g) {
		//Clears the canvas, makes sure we don't get overlapping images. 
		g.clearRect(0, 0, getWidth(), getHeight());
		Toolkit t = Toolkit.getDefaultToolkit();
		//TODO: Have a user upload an image.
		Image image = t.getImage("exampleImage.png");
		g.drawImage(image, 0, 0, this);
		
		g.setColor(Color.red);
		//Here we draw each point, if they've been selected.
		for(int i = 0;i<currentInput;i++) {
			g.fillRect(bioMarkers[i].x - 5, bioMarkers[i].y - 5, 10, 10);
		}
	
	}
	
	/*
	 * TODO: Split the JFrame between the canvas, a text area, and a button. 
	 */
	public static void main(String[] args) {
		//Display a frame on the screen
		JFrame frameWindow = new JFrame("Powerlifting Recommendations");
		frameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Eventually we'll set this to the size of the photo automatically
		frameWindow.setSize(500, 700);
		//This is there so that we can draw on the screen. 
		//Not sure if I'll keep it as "main" or not. 
		Main m = new Main(500,500);
		
		//frameWindow.add(m);
		
		//Adds a reset button.
		JButton reset = new JButton("Reset");
		//frameWindow.add(reset);
		frameWindow.setVisible(true);
		
		
		
		
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		if(currentInput < bioMarkers.length) {
		bioMarkers[currentInput] = e.getPoint();
		currentInput++;
		paint(getGraphics());
		}
	}


	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	

}
