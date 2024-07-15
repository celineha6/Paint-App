package src;
import java.awt.*;

public class arc extends DrawAction {

    public arc(String shape, int x, int y, int width, int height, Color color) {
        super(shape, x, y, width, height, color);
      
    }
    @Override
    public void draw(Graphics g) {
        g.setColor(getColor());
        g.fillArc(getX(), getY(), getWidth(), getHeight(), 0, 180);
    }
    
    public void drawOutline(Graphics g) {
        g.setColor(Color.BLUE);
        g.drawArc(getX() - 2, getY() - 2, getWidth() + 4, getHeight() + 4, 0, 180);

    }
}
