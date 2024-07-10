package src;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 * MouseNanny listens for mouse events to facilitate drawing operations.
 * Sends information to Officer for handling drawing actions.
 *
 * @author javiergs
 * @author: Celine Ha
 * @version 1.0
 */
public class MouseNanny implements MouseListener, MouseMotionListener {
	private boolean drawingInProgress = false;
	@Override
	public void mouseClicked(MouseEvent e) {
		if(!drawingInProgress) {
			Officer.deselectAll();
			boolean selected = false;
			int x = e.getX();
			int y = e.getY();
			for (int i = Officer.undoStack.size() - 1; i >= 0; i--) {
				DrawAction shape = Officer.undoStack.get(i);
				if (shape.checkCoordinates(x, y)) {
					Officer.shapeSelect(shape);
					selected = true;
					break;
				}
			}
			if(!selected) {
				Officer.shapeSelect(null);
			}
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if(!drawingInProgress) {
			int x = e.getX();
			int y = e.getY();
			Officer.drawAction.setX(x);
			Officer.drawAction.setY(y);
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if(drawingInProgress) {
			int x = e.getX();
			int y = e.getY();
			Officer.drawAction.setWidth(x - Officer.drawAction.getX());
			Officer.drawAction.setHeight(y - Officer.drawAction.getY());
			Officer.performDrawAction();
			drawingInProgress = false;
		}
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
		int width = x - Officer.drawAction.getX();
		int height = y - Officer.drawAction.getY();
		drawingInProgress = true;
		Officer.drawOutline(Officer.drawAction.getX(), Officer.drawAction.getY(), width, height);
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// Not used in this implementation
	}
}
