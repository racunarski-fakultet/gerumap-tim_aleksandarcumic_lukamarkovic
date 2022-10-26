package dew.rudok.app.gui.swing;

import dew.rudok.app.core.Gui;
import dew.rudok.app.gui.swing.view.MainFrame;

public class SwingGui implements Gui {

    private MainFrame instance;

    @Override
    public void start() {
        instance = MainFrame.getInstance();
        instance.setVisible(true);
    }
}
