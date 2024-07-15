package src;
import java.awt.*;

public class rectangle extends DrawAction {

    public rectangle(String shape, int x, int y, int width, int height, Color color) {
        super(shape, x, y, width, height, color);
    }
    @Override
    public void draw(Graphics g) {
        g.setColor(getColor());
        g.fillRect(getX(), getY(), getWidth(), getHeight());
    }
    @Override
    public void drawOutline(Graphics g) {
        g.setColor(Color.BLUE);
        g.drawRect(getX() - 2, getY() - 2, getWidth() + 4, getHeight() + 4);
    }

    

    
}
