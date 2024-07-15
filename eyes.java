package src;
import javax.swing.*;
import java.awt.*;

public class eyes extends JPanel {
   
    private int shapeX = 100;
    private int shapeY = 100;
    private int shapeWidth = 200;
    private int shapeHeight = 200;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawShape(g, shapeX, shapeY, shapeWidth, shapeHeight);
        drawEyes(g, shapeX, shapeY, shapeWidth, shapeHeight);
    }
    private void drawShape(Graphics g, int x, int y, int width, int height) {
        g.setColor(Color.BLUE);
        g.fillRect(x, y, width, height); 
    }

    private void drawEyes(Graphics g, int x, int y, int width, int height) {
       
        int eyeWidth = width / 5;
        int eyeHeight = height / 5;
        int eyeY = y + height / 4;
        int eyeSpacing = width / 5;

        int leftEyeX = x + eyeSpacing;
        int rightEyeX = x + width - eyeSpacing - eyeWidth;

    
        g.setColor(Color.WHITE);
        g.fillOval(leftEyeX, eyeY, eyeWidth, eyeHeight);
        g.setColor(Color.BLACK);
        g.fillOval(leftEyeX + eyeWidth / 4, eyeY + eyeHeight / 4, eyeWidth / 2, eyeHeight / 2);

 
        g.setColor(Color.WHITE);
        g.fillOval(rightEyeX, eyeY, eyeWidth, eyeHeight);
        g.setColor(Color.BLACK);
        g.fillOval(rightEyeX + eyeWidth / 4, eyeY + eyeHeight / 4, eyeWidth / 2, eyeHeight / 2);
    }


    

}
