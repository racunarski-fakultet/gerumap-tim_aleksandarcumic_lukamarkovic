package main.java.dsw.gerumap.app.gui.swing.controller.actions;

import lombok.Getter;
import lombok.Setter;
import main.java.dsw.gerumap.app.gui.swing.controller.help.HelpAction;
import main.java.dsw.gerumap.app.gui.swing.controller.stateActions.*;

@Getter
@Setter
public class ActionManager {

    private ExitAction exitAction;
    private NewProjectAction newProjectAction;

    private HelpAction helpAction;

    private RemoveAction removeAction;

    private RenameAction renameAction;

    private AuthorAction authorAction;

    private ConceptAction conceptAction;
    private DeleteAction deleteAction;
    private LinkAction linkAction;
    private SelectAction selectAction;
    private MoveAction moveAction;

    public ActionManager(){
        initialiseActions();
    }

    private void initialiseActions(){
        exitAction = new ExitAction();
        newProjectAction = new NewProjectAction();
        helpAction = new HelpAction();
        removeAction = new RemoveAction();
        renameAction = new RenameAction();
        authorAction = new AuthorAction();
        conceptAction = new ConceptAction();
        deleteAction = new DeleteAction();
        linkAction = new LinkAction();
        selectAction = new SelectAction();
        moveAction = new MoveAction();
    }

}
