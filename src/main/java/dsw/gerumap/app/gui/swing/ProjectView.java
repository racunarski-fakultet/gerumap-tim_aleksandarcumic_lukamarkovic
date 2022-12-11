package main.java.dsw.gerumap.app.gui.swing;

import lombok.Getter;
import lombok.Setter;
import main.java.dsw.gerumap.app.Observer.Subscriber;
import main.java.dsw.gerumap.app.gui.swing.state.StateManager;
import main.java.dsw.gerumap.app.gui.swing.view.MainFrame;
import main.java.dsw.gerumap.app.repository.composite.MapNode;
import main.java.dsw.gerumap.app.repository.implementation.MindMap;
import main.java.dsw.gerumap.app.repository.implementation.Project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
@Setter
@Getter

public class ProjectView extends JPanel implements Subscriber {

    private Project p;
    private StateManager sm;
    private String projectName;
    private String authorName;
    private JLabel bothNames;

    private JLabel projectName1;

    private  JLabel authorName1;

    private MapNode project;

    private JTabbedPane tabbedPane;
    private List<MapView> tabs;

    public ProjectView(){
        this.projectName1 = new JLabel();
        this.authorName1 = new JLabel();
        this.bothNames = new JLabel();
        this.tabbedPane = new JTabbedPane();
        this.tabs = new ArrayList<>();
        this.p = new Project(projectName, project);
        this.sm = new StateManager();
        add(projectName1);
        add(authorName1);
        add(tabbedPane);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        authorName1.setVisible(true);
        projectName1.setVisible(true);

        authorName1.setText("Autor");
        projectName1.setText("Projekat");

        authorName1.setMinimumSize(new Dimension(150,20));
        projectName1.setMinimumSize(new Dimension(150,20));

    }


    public void refreshWorkspace(MapNode selectedProject){

        tabs.clear();
        tabbedPane.removeAll();

        if(project != null){
            ((Project)project).removeSubscriber(this);
        }

        this.project = selectedProject;

        ((Project)project).addSubscriber(this);


        for(MapNode child: ((Project) selectedProject).getChildren()) {
            MapView tab = new MapView((MindMap) child);
            tabs.add(tab);
        }

        if (project == null) {
            tabbedPane.setVisible(false);
            return;
        }

        for(MapView tab : tabs)
            tabbedPane.addTab(tab.getMindMap().getName(), tab);

        refreshLabele();
        tabbedPane.setVisible(true);
    }

    @Override
    public void update(Object notification) {
        if(project == null){
            return;
        }
        refreshLabele();
    }

    private void refreshLabele(){

        authorName = ((Project)project).getAuthor();
        projectName = ((Project)project).getName();

        projectName1.setText(projectName);
        authorName1.setText(authorName);


    }

    public void clearTab(){
        tabbedPane.removeAll();
        tabs.clear();
        bothNames.setText("Autor i ime projekta");
    }

    public void startConceptState(){
        this.sm.setConceptState();
    }

    public void startDeleteState(){
        this.sm.setDeleteState();
    }

    public void startLinkState(){
        this.sm.setLinkState();
    }

    public void startSelectState(){
        this.sm.setSelectState();
    }

    public void startMoveState(){
        this.sm.setMoveState();
    }

    // da li nama treba nesto poput calculate result?

    public void clickedMouse(int x, int y, MindMap mindMap){
        this.sm.getCurrentState();
    }

}
