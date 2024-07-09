import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * DrawPanel creates a panel where the drawing is done.
 * According to the data in Officer.
 *
 * @author: javiergs, Pranay Tiru, Akshaj Srirambhatla
 * Version: 3.0
 */
public class DrawPanel extends JPanel{

	public DrawPanel() {
		setBackground(new Color(176, 250, 192));
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		ArrayList<DrawAction> list = new ArrayList(Officer.undoStack);

		for (DrawAction action : list) {
			if(action.isSelected()) {
				action.drawOutline(g);
			}
			action.draw(g);
		}

		if (Officer.isDrawingOutline) {
			g.setColor(Color.BLACK);
			switch (Officer.drawAction.getShape()) {
				case "Rectangle":
					g.drawRect(Officer.outlineX, Officer.outlineY, Officer.outlineWidth, Officer.outlineHeight);
					break;
				case "Circle":
					g.drawOval(Officer.outlineX, Officer.outlineY, Officer.outlineWidth, Officer.outlineHeight);
					break;
				case "Arc":
					g.drawArc(Officer.outlineX, Officer.outlineY, Officer.outlineWidth, Officer.outlineHeight, 0, 180);
					break;
			}
		}
	}
}
