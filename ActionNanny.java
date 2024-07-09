

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
				Officer.setColor(Color.BLACK);
				MenuBar.clearCheckBoxes(MenuBar.colorCheckBoxes, (JCheckBoxMenuItem) e.getSource());
			} else if (command.equals("Red")) {
				Officer.setColor(Color.RED);
				MenuBar.clearCheckBoxes(MenuBar.colorCheckBoxes, (JCheckBoxMenuItem) e.getSource());
			} else if (command.equals("Blue")) {
				Officer.setColor(Color.BLUE);
				MenuBar.clearCheckBoxes(MenuBar.colorCheckBoxes, (JCheckBoxMenuItem) e.getSource());
			} else if (command.equals("Green")) {
				Officer.setColor(Color.GREEN);
				MenuBar.clearCheckBoxes(MenuBar.colorCheckBoxes, (JCheckBoxMenuItem) e.getSource());
			} else if (command.equals("Yellow")) {
				Officer.setColor(Color.YELLOW);
				MenuBar.clearCheckBoxes(MenuBar.colorCheckBoxes, (JCheckBoxMenuItem) e.getSource());
			} else if (command.equals("Orange")) {
				Officer.setColor(Color.ORANGE);
				MenuBar.clearCheckBoxes(MenuBar.colorCheckBoxes, (JCheckBoxMenuItem) e.getSource());
			} else if (command.equals("Pink")) {
				Officer.setColor(Color.PINK);
				MenuBar.clearCheckBoxes(MenuBar.colorCheckBoxes, (JCheckBoxMenuItem) e.getSource());
			} else {
				Officer.setShape(e.getActionCommand());
				MenuBar.clearCheckBoxes(MenuBar.shapeCheckBoxes, (JCheckBoxMenuItem) e.getSource());
			}
		}
	}
}