package engine.input;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Mouse implements MouseListener, MouseMotionListener {

	public static boolean down = false;
	public static int x = 0;
	public static int y = 0;
	
	public void mouseClicked(MouseEvent e) {}

	public void mousePressed(MouseEvent e) {
		down = true;
	}

	public void mouseReleased(MouseEvent e) {
		down = false;
	}

	public void mouseEntered(MouseEvent e) {}

	public void mouseExited(MouseEvent e) {}

	public void mouseDragged(MouseEvent e) {
		x = e.getX();
		y = e.getY();
	}

	public void mouseMoved(MouseEvent e) {
		x = e.getX();
		y = e.getY();		
	}
}
