package src;
import javax.swing.*;
import java.awt.*;

public class hat extends JPanel {
   
    private int shapeX = 100;
    private int shapeY = 100;
    private int shapeWidth = 200;
    private int shapeHeight = 200;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawShape(g, shapeX, shapeY, shapeWidth, shapeHeight);
        drawHat(g, shapeX, shapeY, shapeWidth, shapeHeight);
    }
    private void drawShape(Graphics g, int x, int y, int width, int height) {
        g.setColor(Color.BLUE);
        g.fillRect(x, y, width, height); 
    }

    private void drawHat(Graphics g, int shapeX, int shapeY, int shapeWidth, int shapeHeight) {
    
        int brimWidth = shapeWidth;
        int brimHeight = shapeHeight / 8;
        int brimX = shapeX;
        int brimY = shapeY - brimHeight;

        int hatWidth = shapeWidth / 2;
        int hatHeight = shapeHeight / 4;
        int hatX = shapeX + (shapeWidth - hatWidth) / 2;
        int hatY = shapeY - hatHeight - brimHeight;

   
        g.setColor(Color.BLACK);
        g.fillRect(brimX, brimY, brimWidth, brimHeight);


        g.setColor(Color.BLACK);
        g.fillRect(hatX, hatY, hatWidth, hatHeight);
    }


    

}
