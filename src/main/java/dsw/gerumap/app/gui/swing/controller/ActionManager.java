package main.java.dsw.gerumap.app.gui.swing.controller;


public class ActionManager {

    private ExitAction exitAction;
    private NewProjectAction newProjectAction;

    private HelpAction helpAction;

    public ActionManager(){
        initialiseActions();
    }

    private void initialiseActions(){
        exitAction = new ExitAction();
        newProjectAction = new NewProjectAction();
        helpAction = new HelpAction();
    }

    public ExitAction getExitAction() {
        return exitAction;
    }

    public NewProjectAction getNewProjectAction() {
        return newProjectAction;
    }

    public void setExitAction(ExitAction exitAction) {
        this.exitAction = exitAction;
    }

    public void setNewProjectAction(NewProjectAction newProjectAction) {
        this.newProjectAction = newProjectAction;
    }

    public HelpAction getHelpAction() {
        return helpAction;
    }

    public void setHelpAction(HelpAction helpAction) {
        this.helpAction = helpAction;
    }
}
