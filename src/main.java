import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

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
	//Needed for animating the canvas.
	public int width, height;
	
	//Draws the image to the screen
	public void paint(Graphics g) {
		g.clearRect(0, 0, width, height);
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
	
	public Main(int width, int height) {
		super();
		this.width = width;
		this.height = height;
		addMouseListener(this);
	}
	
	public static void main(String[] args) {
		//Display a frame on the screen
		JFrame frameWindow = new JFrame("Powerlifting Recommendations");
		frameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Eventually we'll set this to the size of the photo automatically
		frameWindow.setSize(500, 700);
		Main m = new Main(500,700);
		frameWindow.add(m);
		frameWindow.setVisible(true);
		
		
		
		//Starts the animation. 
		while(true) {
			
			m.paint(m.getGraphics());
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		if(currentInput < bioMarkers.length) {
		bioMarkers[currentInput] = e.getPoint();
		currentInput++;
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
