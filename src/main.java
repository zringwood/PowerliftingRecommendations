import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;
import javax.swing.border.LineBorder;

public class Main extends Canvas implements MouseListener{
	
	//These are the points needed for measuring the proportions of the photo.
	public Point[] bioMarkers = new Point[8];
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
		g.setColor(Color.black);
		g.drawRect(0, 0, image.getWidth(this), image.getHeight(this));
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
		frameWindow.setLayout(null);
		frameWindow.setResizable(false);
		//Eventually we'll set this to the size of the photo automatically
		frameWindow.setSize(500, 700);
		
		
		//This is there so that we can draw on the screen. 
		//Not sure if I'll keep it as "main" or not. 
		Main m = new Main(500,500);
		frameWindow.add(m);		
		//Adds a reset button.
		JButton reset = new JButton("Reset");
		reset.setBounds(0, 500, 80, 30);
		reset.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				m.reset();
			}
			
		});
		frameWindow.add(reset);
		//Adds a back button.
		JButton back = new JButton("Back");
		back.setBounds(0, 580, 80, 30);
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				m.back();
			}
		});
		
		frameWindow.add(back);
		//Adds a text display
		JLabel textDisplay = new JLabel("Please Click on the left Ankle");
		textDisplay.setBackground(Color.white);
		textDisplay.setVerticalAlignment(JLabel.TOP);
		textDisplay.setBounds(reset.getWidth() + 2, reset.getY(), 400,150);
		textDisplay.setBorder(new LineBorder(Color.black));
		frameWindow.add(textDisplay);
		frameWindow.setVisible(true);
	
		//Begin Animation
		while(m.currentInput <= m.bioMarkers.length) {
			m.paint(m.getGraphics());
			
			switch(m.currentInput) {
			case(ANKLE):
				textDisplay.setText("Please Click on the Left Ankle.");
				break;
			case(KNEE):
				textDisplay.setText("Please Click on the Left Knee.");
				break;
			case(HIP):
				textDisplay.setText("Please Click on the Left Hip.");
				break;
			case(LEFT_SHOULDER):
				textDisplay.setText("Please Click on the Left Shoulder.");
				break;
			case(RIGHT_SHOULDER):
				textDisplay.setText("Please Click on the Right Shoulder.");
				break;
			case(ELBOW):
				textDisplay.setText("Please Click on the Left Elbow.");
				break;
			case(WRIST):
				textDisplay.setText("Please Click on the Left Wrist.");
				break;
			case(TOP_OF_HEAD):
				textDisplay.setText("Please Click on the Top of the Head.");
				break;
			}
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		} 
		
		
	}
	public void back() {
		if (currentInput > 0)
		currentInput--;
		
	}
	public void reset() {
		currentInput = 0;
		
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
