
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author: Tenzin Konchok
 * @version 1.0
 */
public class MenuBar extends JMenuBar {
    public MenuBar() {
        initializeMenus();
    }

    public static ArrayList<JCheckBoxMenuItem> colorCheckBoxes = new ArrayList<>();
    public static ArrayList<JCheckBoxMenuItem> shapeCheckBoxes = new ArrayList<>();

    private void initializeMenus(){
        ActionNanny actionNanny = new ActionNanny();
        //File
        JMenu FileMenu = new JMenu("File");
        JMenuItem NewItem = new JMenuItem("New");
        JMenuItem SaveItem = new JMenuItem("Save");
        JMenuItem LoadItem = new JMenuItem("Load");
        FileMenu.add(NewItem);
        FileMenu.add(SaveItem);
        FileMenu.add(LoadItem);
        
        //Shape submenu
        JMenu shapeMenu = new JMenu("Shape");
        String[] shapes = {"Rectangle", "Circle", "Arc"};


        for (String shape : shapes) {
            JCheckBoxMenuItem shapeItem = new JCheckBoxMenuItem(shape);
            if(shape.equals("Rectangle")) {
                shapeItem.setSelected(true);
            }
            shapeItem.addActionListener(actionNanny);
            shapeMenu.add(shapeItem);
            shapeCheckBoxes.add(shapeItem);
        }


        JMenu editMenu = new JMenu("Edit");
        JMenuItem copyItem = new JMenuItem("Copy");
        JMenuItem pasteItem = new JMenuItem("Paste");
        JMenuItem undoItem = new JMenuItem("Undo");
        JMenuItem redoItem = new JMenuItem("Redo");
        JMenuItem eraseItem = new JMenuItem("Erase");

        // Add ActionListener to the undo button
        undoItem.addActionListener(e -> {
            Officer.undoDrawAction(); // Undo the last drawing action
            // Repaint DrawPanel after undo
        });

        // Add ActionListener to the redo button
        redoItem.addActionListener(e -> {
            Officer.redoDrawAction(); // Redo the last undone action
            // Repaint DrawPanel after redo
        });

        eraseItem.addActionListener(e -> {
            Officer.eraseDrawAction(); // Redo the last undone action
            // Repaint DrawPanel after redo
        });

        copyItem.addActionListener(e -> {
            Officer.copyDrawAction(); // Redo the last undone action
            // Repaint DrawPanel after redo
        });

        pasteItem.addActionListener(e -> {
            Officer.pasteDrawAction(); // Redo the last undone action
            // Repaint DrawPanel after redo
        });



        editMenu.add(undoItem);
        editMenu.add(redoItem);

        editMenu.add(copyItem);
        editMenu.add(pasteItem);

        editMenu.add(eraseItem);


        JMenu colorMenu = new JMenu("Color");
        String[] colors = {"Black", "Red", "Blue", "Green", "Yellow", "Orange", "Pink"};
        for (String color : colors) {
            JCheckBoxMenuItem colorItem = new JCheckBoxMenuItem(color);
            if(color.equals("Black")) {
                colorItem.setSelected(true);
            }
            colorItem.addActionListener(actionNanny);
            colorMenu.add(colorItem);
            colorCheckBoxes.add(colorItem);
        }

        JMenu About = new JMenu("About");

        add(FileMenu);
        add(shapeMenu);
        add(colorMenu);
        add(editMenu);
        add(About);
        //
        //
    }
    public static void clearCheckBoxes(ArrayList<JCheckBoxMenuItem> arrayCB, JCheckBoxMenuItem cb){
        for (JCheckBoxMenuItem arrayCB1 : arrayCB) {
            if (arrayCB1 != cb) {
                arrayCB1.setSelected(false);
            } else {
                arrayCB1.setSelected(true);
            }
        }
    }
}
