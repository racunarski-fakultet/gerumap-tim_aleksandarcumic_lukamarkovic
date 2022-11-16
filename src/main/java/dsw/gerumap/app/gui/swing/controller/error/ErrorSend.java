package main.java.dsw.gerumap.app.gui.swing.controller.error;

import main.java.dsw.gerumap.app.gui.swing.tree.controller.MapTreeCellEditor;
import main.java.dsw.gerumap.app.gui.swing.tree.model.MapTreeItem;
import main.java.dsw.gerumap.app.message.EventType;
import main.java.dsw.gerumap.app.message.MessageGenerator;
import main.java.dsw.gerumap.app.message.implementation.MessageGeneratorImplementation;

import java.util.Map;

public class ErrorSend {
    MessageGenerator mg;
    MapTreeItem mapTreeItem;
    MapTreeCellEditor mapTreeCellEditor;
    public ErrorSend(MapTreeItem mapTreeItem) {
        System.out.println("Doslo je do ErrorSend");
        this.mapTreeItem = mapTreeItem;
        if(mapTreeItem.getParent() == null) {
            mg = new MessageGeneratorImplementation();
            mg.generate(EventType.DELETEPROJEXPL);
        }else if(mapTreeItem.isLeaf()) {
            mg = new MessageGeneratorImplementation();
            mg.generate(EventType.CANNOTADDCHILD);
//        }else if(mapTreeItem.toString().isEmpty().){
//            System.out.println("Usao je u dobar if");
//            mg = new MessageGeneratorImplementation();
//            mg.generate(EventType.NAMECANNOTBEEMPTY);
        }else{
            mg = new MessageGeneratorImplementation();
            mg.generate(EventType.NAMECANNOTBEEMPTY);        }
    }

}
