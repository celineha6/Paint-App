package src;
import java.awt.*;

public class circle extends DrawAction {

    public circle(String shape, int x, int y, int width, int height, Color color) {
        super(shape, x, y, width, height, color); 
    }
    @Override
    public void draw(Graphics g) {
        g.setColor(getColor());
        g.fillOval(getX(), getY(), getWidth(), getHeight());
    }

    public void drawOutline(Graphics g) {
        g.setColor(Color.BLUE);
        g.drawOval(getX() - 2, getY() - 2, getWidth() + 4, getHeight() + 4);
    }

    
    
}