package main.java.dsw.gerumap.app.core;

import main.java.dsw.gerumap.app.Observer.Subscriber;
import main.java.dsw.gerumap.app.gui.swing.commands.CommandManager;

public interface Gui extends Subscriber {

    void start();

    void disableUndoAction();
    void disableRedoAction();
    void enableUndoAction();
    void enableRedoAction();
    CommandManager getCommandManager();
}
