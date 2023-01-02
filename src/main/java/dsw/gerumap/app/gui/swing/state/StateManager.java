package main.java.dsw.gerumap.app.gui.swing.state;


import lombok.Getter;
import main.java.dsw.gerumap.app.gui.swing.state.model.*;

@Getter
public class StateManager {

    private State currentState;
    private ConceptState conceptState;
    private DeleteState deleteState;
    private LinkState linkState;
    private SelectState selectState;
    private MoveState moveState;


    public StateManager(){
        initStates();
    }

    private void initStates(){
        conceptState = new ConceptState();
        linkState = new LinkState();
        selectState = new SelectState();
        deleteState = new DeleteState();
        moveState = new MoveState();
        currentState = conceptState;
    }

    public void setConceptState() {
        currentState = conceptState;
    }

    public void setDeleteState() {
        this.currentState = deleteState;
    }

    public void setLinkState() {
        this.currentState = linkState;
    }

    public void setSelectState() {
        this.currentState = selectState;
    }

    public void setMoveState() {
        this.currentState = moveState;
    }

    public State getCurrentState(){
        return currentState;
    }
}
