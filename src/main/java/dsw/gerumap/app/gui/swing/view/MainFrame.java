package main.java.dsw.gerumap.app.gui.swing.view;

import lombok.Getter;
import lombok.Setter;
import main.java.dsw.gerumap.app.core.ApplicationFramework;
import main.java.dsw.gerumap.app.gui.swing.ProjectView;
import main.java.dsw.gerumap.app.gui.swing.controller.actions.ActionManager;
import main.java.dsw.gerumap.app.gui.swing.tree.MapTree;
import main.java.dsw.gerumap.app.gui.swing.tree.MapTreeImplementation;

import javax.swing.*;
import java.awt.*;

@Getter
@Setter
public class MainFrame extends JFrame {

    private static MainFrame instance;
    private ActionManager actionManager;
    private JMenuBar menu;
    private JToolBar toolBar;

    private JToolBar palette;
    private ProjectView projectView;

    private MapTree mapTree;

    private  MainFrame () {

    }

    private void initialise () {
        actionManager = new ActionManager();
        mapTree = new MapTreeImplementation();
        projectView = new ProjectView();
        initialiseGui();

    }

    private void initialiseGui() {

        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;
        setSize(screenWidth / 2 + screenWidth / 4, screenHeight / 2 + screenHeight / 4);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("GeRuMap");

        menu = new MyMenuBar();
        setJMenuBar(menu);

        toolBar = new Toolbar();
        add(toolBar, BorderLayout.NORTH);

        palette = new Palette();
        add(palette, BorderLayout.EAST);

        JTree projectExplorer = mapTree.generateTree(ApplicationFramework.getInstance().getMapRepository().getProjectExplorer());

        JScrollPane scroll=new JScrollPane(projectExplorer);
        JPanel rightPanel = projectView;
        JSplitPane split =  new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,scroll,rightPanel);
        getContentPane().add(split,BorderLayout.CENTER);
        split.setDividerLocation(250);
        split.setOneTouchExpandable(true);


 //       JPanel desktop = new JPanel();


//        JSplitPane split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, scroll, desktop);
 //       getContentPane().add(split, BorderLayout.CENTER);
  //      split.setDividerLocation(250);
  //      split.setOneTouchExpandable(true);
    }

    public static MainFrame getInstance() {

        if (instance == null) {
            instance = new MainFrame();
            instance.initialise();
        }
        return instance;
    }

    public ActionManager getActionManager() {
        return actionManager;
    }
}
