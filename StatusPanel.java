package javiergs.gui.paint.gamma;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;

public class StatusPanel extends JPanel {

    private Stack<Action> undoStack = new Stack<>();
    private Stack<Action> redoStack = new Stack<>();

    public StatusPanel() {
        JButton buttonUndo = new JButton("Undo");
        JButton buttonErase = new JButton("Erase");
        add(buttonUndo);
        add(buttonErase);

        ActionNanny actionNanny = new ActionNanny();
        buttonUndo.addActionListener(actionNanny);
        buttonErase.addActionListener(actionNanny);
    }

    private void performAction(Action action) {
        action.execute();
        undoStack.push(action);
        redoStack.clear();
    }

    private void undoAction() {
        if (!undoStack.isEmpty()) {
            Action action = undoStack.pop();
            action.undo();
            redoStack.push(action);
        }
    }

    private void redoAction() {
        if (!redoStack.isEmpty()) {
            Action action = redoStack.pop();
            action.execute();
            undoStack.push(action);
        }
    }

    private interface Action {
        void execute();
        void undo();
    }

    private class EraseAction implements Action {
        @Override
        public void execute() {
            System.out.println("Erase executed");
        }

        @Override
        public void undo() {
            System.out.println("Erase undone");
        }
    }

    private class ActionNanny implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            if (command.equals("Undo")) {
                undoAction();
            } else if (command.equals("Erase")) {
                performAction(new EraseAction());
            }
        }
    }
}
