

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * MouseNanny listens for mouse events to facilitate drawing operations.
 * Sends information to Officer for handling drawing actions.
 *
 * @author javiergs
 * @author: Celine Ha
 * @version 1.0
 */
public class MouseNanny implements MouseListener, MouseMotionListener {
	@Override
	public void mouseClicked(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		for (DrawAction shape : Officer.undoStack) {
			if (shape.checkCoordinates(x, y)) {
				shape.selectShape();
				Officer.shapeSelect();
			}
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		Officer.setX(x);
		Officer.setY(y);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		Officer.setWidth(x - Officer.getX());
		Officer.setHeight(y - Officer.getY());
		Officer.performDrawAction(); // Perform drawing action on mouse release
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// Not used in this implementation
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// Not used in this implementation
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		int width = x - Officer.getX();
		int height = y - Officer.getY();
		Officer.drawOutline(Officer.getX(), Officer.getY(), width, height);
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// Not used in this implementation
	}
}
