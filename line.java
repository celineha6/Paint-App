package src;
import java.awt.*;

public class line extends DrawAction {

    public line(String shape, int x, int y, int width, int height, Color color) {
        super(shape, x, y, width, height, color);
    }
    @Override
    public void draw(Graphics g) {
        g.setColor(getColor());
        g.drawLine(getX(), getY(), getX() + getWidth(), getY() + getHeight());
    }

    @Override
    public void drawOutline(Graphics g) {
        g.setColor(Color.BLUE);
        g.drawLine(getX() - 2, getY() - 2, getX() + getWidth() + 4, getY() + getHeight() + 4);
        
    }

    
}
