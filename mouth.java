package src;
import javax.swing.*;
import java.awt.*;

public class mouth extends JPanel {
   
    private int shapeX = 100;
    private int shapeY = 100;
    private int shapeWidth = 200;
    private int shapeHeight = 200;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawShape(g, shapeX, shapeY, shapeWidth, shapeHeight);
        drawMouth(g, shapeX, shapeY, shapeWidth, shapeHeight);
    }
    private void drawShape(Graphics g, int x, int y, int width, int height) {
        g.setColor(Color.BLUE);
        g.fillRect(x, y, width, height); // Draw a rectangle as an example shape
    }

    private void drawMouth(Graphics g, int shapeX, int shapeY, int shapeWidth, int shapeHeight) {
        // Calculate the position and size for the mouth based on the shape dimensions
        int mouthWidth = shapeWidth / 2;
        int mouthHeight = shapeHeight / 10;
        int mouthX = shapeX + (shapeWidth - mouthWidth) / 2;
        int mouthY = shapeY + (3 * shapeHeight / 4) - mouthHeight / 2;

   
        g.setColor(Color.RED);
        g.drawArc(mouthX, mouthY, mouthWidth, mouthHeight, 0, -180); 
    }


    

}
