import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * ActionNanny listens for action events.
 * Send information to Officer.
 *
 * @author javiergs
 * @author Tenzin Konchok
 * @version 2.0
 */
public class ActionNanny implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() instanceof JCheckBoxMenuItem) {
			String command = e.getActionCommand();
			if (command.equals("Black")) {
				colorActionCommand(Color.BLACK, e);
			} else if (command.equals("Red")) {
				colorActionCommand(Color.RED, e);
			} else if (command.equals("Blue")) {
				colorActionCommand(Color.BLUE, e);
			} else if (command.equals("Green")) {
				colorActionCommand(Color.GREEN, e);
			} else if (command.equals("Yellow")) {
				colorActionCommand(Color.YELLOW, e);
			} else if (command.equals("Orange")) {
				colorActionCommand(Color.ORANGE, e);
			} else if (command.equals("Pink")) {
				colorActionCommand(Color.PINK, e);
			} else {
				Officer.drawAction.setShape(e.getActionCommand());
				MainHomework.clearCheckBoxes(MainHomework.shapeCheckBoxes, (JCheckBoxMenuItem) e.getSource());
			}
		}
	}

	public void colorActionCommand(Color color, ActionEvent e) {
		Officer.drawAction.setColor(color);
		MainHomework.clearCheckBoxes(MainHomework.colorCheckBoxes, (JCheckBoxMenuItem) e.getSource());
		if(Officer.selectedShape != null) {
			for(DrawAction d: Officer.undoStack) {
				if(d.isSelected()) {
					d.setColor(color);
					Officer.tellYourBoss();
				}
			}
		}
	}
}