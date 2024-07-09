import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * MainHomework creates a frame and adds three panels to it.
 * This version adds MouseListener to the DrawPanel.
 * @authors: Celine Ha, Tenzin Konchok, Pranay Tiru, Akshaj Srirambhatla
 * @author javiergs
 * @version 2.0
 */
public class MainHomework extends JFrame {

	public static void main(String[] args) {
		MainHomework app = new MainHomework();
		app.setSize(800, 600);
		app.setTitle("Shape Drawing");
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.setResizable(false);
		app.setVisible(true);
	}

	public MainHomework() {
		JPanel drawPanel = new DrawPanel();
		MouseNanny mouseNanny = new MouseNanny();
		drawPanel.addMouseListener(mouseNanny);
		drawPanel.addMouseMotionListener(mouseNanny);
		Officer.setDrawPanel(drawPanel);
		setLayout(new BorderLayout());
		add(drawPanel, BorderLayout.CENTER);


		setJMenuBar(initializeMenus());
	}

	public static ArrayList<JCheckBoxMenuItem> colorCheckBoxes = new ArrayList<>();
	public static ArrayList<JCheckBoxMenuItem> shapeCheckBoxes = new ArrayList<>();

	private JMenuBar initializeMenus() {
		JMenuBar menuBar = new JMenuBar();
		ActionNanny actionNanny = new ActionNanny();

		JMenu FileMenu = getFilejMenu();

		JMenu shapeMenu = getShapejMenu(actionNanny);

		JMenu editMenu = getEditjMenu();

		JMenu colorMenu = getColorjMenu(actionNanny);

		JMenu About = new JMenu("About");

		menuBar.add(FileMenu);
		menuBar.add(shapeMenu);
		menuBar.add(colorMenu);
		menuBar.add(editMenu);
		menuBar.add(About);

		return menuBar;
	}

	private static JMenu getFilejMenu() {
		JMenu FileMenu = new JMenu("File");
		JMenuItem NewItem = new JMenuItem("New");
		JMenuItem SaveItem = new JMenuItem("Save");
		JMenuItem LoadItem = new JMenuItem("Load");
		FileMenu.add(NewItem);
		FileMenu.add(SaveItem);
		FileMenu.add(LoadItem);

		return FileMenu;
	}

	private static JMenu getShapejMenu(ActionNanny a) {
		JMenu shapeMenu = new JMenu("Shape");
		String[] shapes = {"Rectangle", "Circle", "Arc"};


		for (String shape : shapes) {
			JCheckBoxMenuItem shapeItem = new JCheckBoxMenuItem(shape);
			if (shape.equals("Rectangle")) {
				shapeItem.setSelected(true);
			}
			shapeItem.addActionListener(a);
			shapeMenu.add(shapeItem);
			shapeCheckBoxes.add(shapeItem);
		}
		return shapeMenu;
	}

	private static JMenu getColorjMenu(ActionNanny a) {
		JMenu colorMenu = new JMenu("Color");
		String[] colors = {"Black", "Red", "Blue", "Green", "Yellow", "Orange", "Pink"};
		for (String color : colors) {
			JCheckBoxMenuItem colorItem = new JCheckBoxMenuItem(color);
			if (color.equals("Black")) {
				colorItem.setSelected(true);
			}
			colorItem.addActionListener(a);
			colorMenu.add(colorItem);
			colorCheckBoxes.add(colorItem);
		}

		return colorMenu;
	}

	private static JMenu getEditjMenu() {
		JMenu editMenu = new JMenu("Edit");
		JMenuItem copyItem = new JMenuItem("Copy");
		JMenuItem pasteItem = new JMenuItem("Paste");
		JMenuItem undoItem = new JMenuItem("Undo");
		JMenuItem redoItem = new JMenuItem("Redo");
		JMenuItem eraseItem = new JMenuItem("Erase");

		undoItem.addActionListener(e -> {
			Officer.undoDrawAction();
		});

		redoItem.addActionListener(e -> {
			Officer.redoDrawAction();
		});

		eraseItem.addActionListener(e -> {
			Officer.eraseDrawAction();
		});

		copyItem.addActionListener(e -> {
			Officer.copyDrawAction();
		});

		pasteItem.addActionListener(e -> {
			Officer.pasteDrawAction();
		});


		editMenu.add(undoItem);
		editMenu.add(redoItem);
		editMenu.add(copyItem);
		editMenu.add(pasteItem);
		editMenu.add(eraseItem);

		return editMenu;
	}

	public static void clearCheckBoxes(ArrayList<JCheckBoxMenuItem> arrayCB, JCheckBoxMenuItem cb){
		for (JCheckBoxMenuItem arrayCB1 : arrayCB) {
            arrayCB1.setSelected(arrayCB1 == cb);
		}
	}

}
