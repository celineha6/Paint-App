
import javax.swing.*;
import java.awt.*;
import java.util.Iterator;
import java.util.Stack;
import java.util.concurrent.TimeUnit;

/**
 * Officer is a class that manages the drawing application's state and actions.
 * It handles drawing shapes, setting colors, and managing undo/redo operations.
 *
 * @author: Celine Ha, Pranay Tiru
 * Version: 3.0
 */
public class Officer {

	private static Color color = Color.BLACK; // Default color
	private static String shape = "Rectangle"; // Default shape
	private static int x;
	private static int y;
	private static int width;
	private static int height;
	public static JPanel drawPanel;
	public static Stack<DrawAction> undoStack = new Stack<>();
	private static Stack<DrawAction> redoStack = new Stack<>();
	public static boolean isDrawingOutline = false;
	public static int outlineX, outlineY, outlineWidth, outlineHeight;

	public static void setColor(Color color) {
		Officer.color = color;

	}

	public static String getShape() {
		return shape;
	}

	public static void setShape(String shape) {
		Officer.shape = shape;
	}

	public static int getX() {
		return x;
	}

	public static void setX(int x) {
		Officer.x = x;
	}

	public static int getY() {
		return y;
	}

	public static void setY(int y) {
		Officer.y = y;
	}

	public static void setWidth(int width) {
		Officer.width = width;
	}

	public static void setHeight(int height) {
		Officer.height = height;
	}

	public static void setDrawPanel(JPanel panel) {
		drawPanel = panel;
	}

	public static void drawOutline(int x, int y, int width, int height) {
		Officer.outlineX = x;
		Officer.outlineY = y;
		Officer.outlineWidth = width;
		Officer.outlineHeight = height;
		Officer.isDrawingOutline = true;
		tellYourBoss();
	}

	public static void clearOutline() {
		Officer.isDrawingOutline = false;
		tellYourBoss();
	}

	public static void performDrawAction() {
		DrawAction action = new DrawAction(shape, x, y, width, height, color);
		undoStack.push(action);
		redoStack.clear();
		clearOutline();
		tellYourBoss();
	}

	public static void undoDrawAction() {
		System.out.println("Undo button clicked!");
		if (!undoStack.isEmpty()) {
			DrawAction action = undoStack.pop();
			redoStack.push(action);
			System.out.println("tell boss");
			tellYourBoss();
		}
	}

	public static void redoDrawAction() {
		System.out.println("Redo button clicked!");
		if (!redoStack.isEmpty()) {
			DrawAction action = redoStack.pop();
			undoStack.push(action);
			tellYourBoss();
		}
	}
	public static void eraseDrawAction() {
		System.out.println("Erase button clicked!");
		if (!redoStack.isEmpty()) {
			DrawAction action = redoStack.pop();
			undoStack.push(action);
			tellYourBoss();
		}
	}

	public static void copyDrawAction() {
		System.out.println("Copy button clicked!");
		if (!redoStack.isEmpty()) {
			DrawAction action = redoStack.pop();
			undoStack.push(action);
			tellYourBoss();
		}
	}

	public static void pasteDrawAction() {
		System.out.println("Paste button clicked!");
		if (!redoStack.isEmpty()) {
			DrawAction action = redoStack.pop();
			undoStack.push(action);
			tellYourBoss();
		}
	}


	public static void tellYourBoss() {
		if (drawPanel != null) {
			System.out.println("repaint");
			drawPanel.repaint();
		}
	}

	public static void shapeSelect() {
		for (DrawAction shape : Officer.undoStack) {
			if (shape.isSelected()) {
				System.out.println("Shape Selected!");
				shape.deselect();
			}
		}
	}
}