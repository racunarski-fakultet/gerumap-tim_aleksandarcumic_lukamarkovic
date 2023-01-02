package main.java.dsw.gerumap.app.gui.swing;

import main.java.dsw.gerumap.app.core.Gui;
import main.java.dsw.gerumap.app.gui.swing.commands.CommandManager;
import main.java.dsw.gerumap.app.gui.swing.view.MainFrame;
import main.java.dsw.gerumap.app.message.implementation.Message;

import javax.swing.*;

public class SwingGui implements Gui {

    private MainFrame instance;

    private CommandManager commandManager;

    public SwingGui(){

    }

    @Override
    public void start() {
        instance = MainFrame.getInstance();
        commandManager = new CommandManager();

        disableRedoAction();
        disableUndoAction();
        instance.setVisible(true);
    }

    @Override
    public void disableUndoAction() {
        MainFrame.getInstance().getActionManager().getUndoAction().setEnabled(false);
    }

    @Override
    public void disableRedoAction() {
        MainFrame.getInstance().getActionManager().getRedoAction().setEnabled(false);
    }

    @Override
    public void enableUndoAction() {
        MainFrame.getInstance().getActionManager().getUndoAction().setEnabled(true);
    }

    @Override
    public void enableRedoAction() {
        MainFrame.getInstance().getActionManager().getRedoAction().setEnabled(true);
    }

    @Override
    public CommandManager getCommandManager() {
        return commandManager;
    }

    @Override
    public void update(Object obj) {
        JOptionPane.showMessageDialog(MainFrame.getInstance(), ((Message)obj), "Dialog", JOptionPane.ERROR_MESSAGE);
    }
}
