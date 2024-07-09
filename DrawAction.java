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

    public boolean checkCoordinates(int xClick, int yClick) {
        int lowBoundX = x;
        int highBoundX = x + width;
        int lowBoundY = y;
        int highBoundY = y + width;

        return xClick >= lowBoundX && xClick <= highBoundX && yClick >= lowBoundY && yClick <= highBoundY;
    }

    public void selectShape() {
        selected = true;
    }

    public void deselect() {
        selected = false;
    }
}

