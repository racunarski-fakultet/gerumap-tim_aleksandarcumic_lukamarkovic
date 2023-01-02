package main.java.dsw.gerumap.app.gui.swing.controller.stateActions;

import main.java.dsw.gerumap.app.core.ApplicationFramework;
import main.java.dsw.gerumap.app.gui.swing.MapView;
import main.java.dsw.gerumap.app.gui.swing.commands.AbstractCommand;
import main.java.dsw.gerumap.app.gui.swing.commands.implementation.RemoveElementCommand;
import main.java.dsw.gerumap.app.gui.swing.controller.actions.AbstractGerumapAction;
import main.java.dsw.gerumap.app.gui.swing.view.MainFrame;
import main.java.dsw.gerumap.app.gui.swing.view.visual.Concept;
import main.java.dsw.gerumap.app.gui.swing.view.visual.painters.ElementPainter;
import main.java.dsw.gerumap.app.gui.swing.view.visual.painters.LinkPainter;
import main.java.dsw.gerumap.app.repository.implementation.Element;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DeleteAction extends AbstractGerumapAction {

    public DeleteAction () {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
                KeyEvent.VK_D, ActionEvent.CTRL_MASK));
        putValue(SMALL_ICON, loadIcon("/images/Delete.png"));
        putValue(NAME, "Delete");
        putValue(SHORT_DESCRIPTION, "Delete");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        List<ElementPainter> nova = new ArrayList<>();

        MapView map = MainFrame.getInstance().getProjectView().getMapView();
        for(ElementPainter p : map.getMindMap().getPainters()){
            for(Element el : map.getSelectedItems().getElements()){
                if(p.getElement().equals(el)){
                    if(p.getElement() instanceof Concept) {
                        Concept t = (Concept) p.getElement();
                        for (LinkPainter painter : t.getLinkList()) {
                            nova.add(painter);
                        }
                    }
                    nova.add(p);
                }
            }
        }

        AbstractCommand command = new RemoveElementCommand(nova, map);

        ApplicationFramework.getInstance().getGui().getCommandManager().addCommand(command);

//        for(ElementPainter n : nova){
//            map.getMindMap().removeChild(n.getElement());
//            map.getSelectedItems().getElements().remove(n.getElement());
//            map.getPainters().remove(n);
//        }


        MainFrame.getInstance().getProjectView().startDeleteState();
    }
}
