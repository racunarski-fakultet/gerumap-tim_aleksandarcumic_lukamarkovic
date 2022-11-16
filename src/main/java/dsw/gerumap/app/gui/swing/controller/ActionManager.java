package main.java.dsw.gerumap.app.gui.swing.controller;

import lombok.Getter;
import lombok.Setter;
import main.java.dsw.gerumap.app.gui.swing.controller.help.HelpAction;

@Getter
@Setter
public class ActionManager {

    private ExitAction exitAction;
    private NewProjectAction newProjectAction;

    private HelpAction helpAction;

    private RemoveAction removeAction;

    public ActionManager(){
        initialiseActions();
    }

    private void initialiseActions(){
        exitAction = new ExitAction();
        newProjectAction = new NewProjectAction();
        helpAction = new HelpAction();
        removeAction = new RemoveAction();
    }








}
