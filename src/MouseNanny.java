package src;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 * MouseNanny listens for mouse events to facilitate drawing operations.
 * Sends information to Officer for handling drawing actions.
 *
 * @version 1.0
 */
public class MouseNanny implements MouseListener, MouseMotionListener {
	private boolean drawingInProgress = false;
	private boolean draggingShape = false;
	private int initialX, initialY;

	@Override
	public void mouseClicked(MouseEvent e) {
		if (!drawingInProgress) {
			clickShape(e);
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		Officer.deselectAll();
		if (!drawingInProgress) {
			int x = e.getX();
			int y = e.getY();
			Officer.drawAction.setX(x);
			Officer.drawAction.setY(y);
			if(clickShape(e)) {
				initialX = x;
				initialY = y;
				draggingShape = true;
			}
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if (drawingInProgress) {
			int x = e.getX();
			int y = e.getY();
			int startX = Officer.drawAction.getX();
			int startY = Officer.drawAction.getY();
			int width = Math.abs(x - startX);
			int height = Math.abs(y - startY);

			if (x < startX) {
				startX = x;
			}
			if (y < startY) {
				startY = y;
			}

			Officer.drawAction.setX(startX);
			Officer.drawAction.setY(startY);
			Officer.drawAction.setWidth(width);
			Officer.drawAction.setHeight(height);
			Officer.performDrawAction();
			drawingInProgress = false;
		}

		if (draggingShape) {
			draggingShape = false;
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

		if (draggingShape && Officer.selectedShape != null) {
			int deltaX = x - initialX;
			int deltaY = y - initialY;
			Officer.selectedShape.setX(Officer.selectedShape.getX() + deltaX);
			Officer.selectedShape.setY(Officer.selectedShape.getY() + deltaY);
			initialX = x;
			initialY = y;
			Officer.tellYourBoss();
		} else {
			int startX = Officer.drawAction.getX();
			int startY = Officer.drawAction.getY();
			int width = Math.abs(x - startX);
			int height = Math.abs(y - startY);

			if (x < startX) {
				startX = x;
			}
			if (y < startY) {
				startY = y;
			}

			drawingInProgress = true;
			Officer.drawOutline(startX, startY, width, height);
		}
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// Not used in this implementation
	}

	private boolean clickShape(MouseEvent e) {
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
		if (!selected) {
			Officer.shapeSelect(null);
		}
		return selected;
	}
}
