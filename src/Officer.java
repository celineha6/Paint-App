package src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Stack;

/**
 * Officer is a class that manages the drawing application's state and actions.
 * It handles drawing shapes, setting colors, and managing undo/redo operations.
 *
 * @author: Celine Ha 
 * @author: Pranay Tiru
 * Version: 3.0
 */
public class Officer implements KeyListener {
    public static DrawAction drawAction = new DrawAction("Rectangle", 0, 0, 0, 0, Color.BLACK);
    public static JPanel drawPanel;
    public static Stack<DrawAction> undoStack = new Stack<>();
    private static Stack<DrawAction> redoStack = new Stack<>();
    public static boolean isDrawingOutline = false;
    public static int outlineX, outlineY, outlineWidth, outlineHeight;
    public static DrawAction selectedShape;
    private static DrawAction copyShape;

    public static void setDrawPanel(JPanel panel) {
        drawPanel = panel;
        panel.addKeyListener(new Officer());
        panel.setFocusable(true);
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
        DrawAction action = new DrawAction(drawAction.getShape(), drawAction.getX(), drawAction.getY(),
        drawAction.getWidth(), drawAction.getHeight(), drawAction.getColor());
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
        undoStack.clear();
        redoStack.clear();
        System.out.println("tell boss");
        tellYourBoss();
    }

    public static void copyDrawAction() {
        if (selectedShape != null) {
            copyShape = selectedShape;
        } else {
            System.out.println("Select a shape!");
        }
    }

    public static void pasteDrawAction() {
        if (copyShape != null) {
            DrawAction pasteShape = new DrawAction(copyShape.getShape(), copyShape.getX() + 10,
            copyShape.getY() - 10, copyShape.getWidth(), copyShape.getHeight(), copyShape.getColor());
            pasteShape.setSelected(false);
            undoStack.push(pasteShape);
            tellYourBoss();
        } else {
            System.out.println("Paste failed!");
        }
    }

    public static void tellYourBoss() {
        if (drawPanel != null) {
            System.out.println("repaint");
            drawPanel.repaint();
        }
    }

    public static void deselectAll() {
        for (DrawAction d : undoStack) {
            d.setSelected(false);
        }
    }

    public static void shapeSelect(DrawAction shape) {
        selectedShape = shape;
        if (shape != null) {
            shape.setSelected(true);
            tellYourBoss();
        } else {
            deselectAll();
            tellYourBoss();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // No action needed on keyTyped
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.isControlDown()) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_C:
                    copyDrawAction();
                    break;
                case KeyEvent.VK_V:
                    pasteDrawAction();
                    break;
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // No action needed on keyReleased
    }
}
