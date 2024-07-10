package src;

import java.awt.*;

public class DrawAction {
    private String shape;
    private int x, y, width, height;
    private Color color;
    private boolean selected;

    public DrawAction(String shape, int x, int y, int width, int height, Color color) {
        this.shape = shape;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
        this.selected = false;
    }

    public void setShape(String shape) {
        this.shape = shape;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public String getShape() {
        return shape;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Color getColor() {
        return color;
    }

    public boolean isSelected() {
        return selected;
    }

    public void draw(Graphics g) {
        g.setColor(color);
        if (shape.equals("Rectangle")) {
            g.fillRect(x, y, width, height);
        } else if (shape.equals("Circle")) {
            g.fillOval(x, y, width, height);
        } else if (shape.equals("Arc")) {
            g.fillArc(x, y, width, height, 0, 180);
        }
    }

    public void drawOutline(Graphics g) {
        g.setColor(Color.BLUE);
        if (shape.equals("Rectangle")) {
            g.drawRect(x - 2, y - 2, width + 4, height + 4);
        } else if (shape.equals("Circle")) {
            g.drawOval(x - 2, y - 2, width + 4, height + 4);
        } else if (shape.equals("Arc")) {
            g.drawArc(x - 2, y - 2, width + 4, height + 4, 0, 180);
        }
    }

    public boolean checkCoordinates(int xClick, int yClick) {
        int lowBoundX = x;
        int highBoundX = x + width;
        int lowBoundY = y;
        int highBoundY = y + width;

        return xClick >= lowBoundX && xClick <= highBoundX && yClick >= lowBoundY && yClick <= highBoundY;
    }
}

