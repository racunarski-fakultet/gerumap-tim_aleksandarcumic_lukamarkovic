package dew.rudok.app;

import dew.rudok.app.core.ApplicationFramework;
import dew.rudok.app.core.Gui;
import dew.rudok.app.gui.swing.SwingGui;

public class AppCore extends ApplicationFramework {

    public static AppCore instance;

    private AppCore () {

    }

    @Override
    public void run() {
        this.gui.start();
    }

    public static AppCore getInstance() {
        if (instance == null) {
            instance = new AppCore();
        }
        return instance;
    }

    public static void main(String[] args) {
        Gui gui = new SwingGui();
        ApplicationFramework appCore = AppCore.getInstance();
        appCore.initialise(gui);
        appCore.run();
    }


}
