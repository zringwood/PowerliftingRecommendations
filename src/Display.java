import java.awt.Canvas;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Display extends Canvas implements MouseListener{

	private int width, height;
	
	public Display(int width, int height) {
		super();
		this.width = width;
		this.height = height;
		addMouseListener(this);
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
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
