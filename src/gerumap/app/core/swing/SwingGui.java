package gerumap.app.core.swing;

import gerumap.app.core.gui.Gui;
import gerumap.app.core.swing.view.MainFrame;

public class SwingGui implements Gui {

    private MainFrame instance;

    @Override
    public void start() {
        instance = MainFrame.getInstance();
        instance.setVisible(true);
    }
}
