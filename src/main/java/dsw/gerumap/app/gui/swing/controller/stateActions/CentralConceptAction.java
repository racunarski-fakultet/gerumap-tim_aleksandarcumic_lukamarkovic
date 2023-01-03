package main.java.dsw.gerumap.app.gui.swing.controller.stateActions;

import com.sun.tools.javac.Main;
import main.java.dsw.gerumap.app.gui.swing.controller.actions.AbstractGerumapAction;
import main.java.dsw.gerumap.app.gui.swing.view.MainFrame;
import main.java.dsw.gerumap.app.gui.swing.view.visual.Concept;
import main.java.dsw.gerumap.app.gui.swing.view.visual.Link;
import main.java.dsw.gerumap.app.gui.swing.view.visual.painters.ElementPainter;
import main.java.dsw.gerumap.app.gui.swing.view.visual.painters.LinkPainter;
import main.java.dsw.gerumap.app.repository.implementation.Element;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class CentralConceptAction extends AbstractGerumapAction {

    public CentralConceptAction () {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
                KeyEvent.VK_C, ActionEvent.CTRL_MASK));
        putValue(SMALL_ICON, loadIcon("/images/CenterConcept.png"));
        putValue(NAME, "Central Concept");
        putValue(SHORT_DESCRIPTION, "Central Concept");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(MainFrame.getInstance().getProjectView().getMapView().getSelectedItems().getElements().size() == 1){

            for(Element central : MainFrame.getInstance().getProjectView().getMapView().getSelectedItems().getElements()){
                if(!(central instanceof Concept)){
                    return;
                }

                central.setStroke(central.getStroke() + 3);

                int sirina = MainFrame.getInstance().getProjectView().getMapView().getWidth() / 2;
                int visina = MainFrame.getInstance().getProjectView().getMapView().getHeight() / 2;

                sirina /=8;
                visina /=8;
                sirina*=8;
                visina *=8;
//                System.out.println(visina + " " + sirina);
                int pocY = visina;
                int pocX = sirina-200;
                Concept t = (Concept) central;
                t.setX(sirina);
                t.setY(visina);
                for(LinkPainter painter : t.getLinkList()){
                    Link con = (Link) painter.getElement();
                    if(con.getTo().equals(t)){
                        Point pos1 = new Point(sirina, visina);
                        painter.setPos1(pos1);
                    }else{
                        Point pos2 = new Point(sirina, visina);
                        painter.setPos2(pos2);
                    }
                }

                boolean dodajeX =false;
                boolean dodajeY =true;
                int pomoc=0;



                int vrednostX = 200;
                int vrednostY = 150;

                if(t.getLinkList().size() <= 4){
                    vrednostX = 200;
                    vrednostY = 150;
                }else if(t.getLinkList().size() <= 8){
                    vrednostX /= 2;
                    vrednostY /= 2;
                }
                else if(t.getLinkList().size() <= 16){
                    vrednostX /=4;
                    vrednostY /=4;
                }

                for(ElementPainter p : MainFrame.getInstance().getProjectView().getMapView().getMindMap().getPainters()){
                    if(p.getElement() instanceof Concept && !(p.getElement().equals(t))){

                        for(LinkPainter painter : t.getLinkList()){





                            Link con = (Link) painter.getElement();
                            if(con.getTo().equals(p.getElement())){




                                Concept k = (Concept) p.getElement();

                                if(dodajeX){
                                    pocX += pomoc * vrednostX;
                                }else pocX -=pomoc * vrednostX;

                                if(dodajeY) pocY +=pomoc * vrednostY;
                                else pocY -=pomoc *  vrednostY;
                                k.setX(pocX);
                                k.setY(pocY);

                                for (LinkPainter slikar : k.getLinkList()) {
                                    Link linkara = (Link) slikar.getElement();
                                    if (linkara.getTo().equals(k)) {
                                        Point pos1 = new Point(pocX, pocY);
                                        slikar.setPos1(pos1);
                                    } else {
                                        Point pos2 = new Point(pocX, pocY);
                                        slikar.setPos2(pos2);
                                    }
                                }



                                Point pos1 = new Point(pocX, pocY);
                                painter.setPos1(pos1);

                                if(pocY==t.getY()){
                                    if(dodajeX){
                                        dodajeX=false;
                                    }else{
                                        dodajeX=true;
                                    }
                                }
                                if(pocX==t.getX()){
                                    if(dodajeY){
                                        dodajeY=false;
                                    }else dodajeY = true;
                                }

                                pomoc=1;



                            }else if (con.getFrom().equals(p.getElement())){





                                Concept k = (Concept) p.getElement();

                                if(dodajeX){
                                    pocX +=pomoc *  vrednostX;
                                }else pocX -=pomoc * vrednostX;

                                if(dodajeY) pocY +=pomoc * vrednostY;
                                else pocY -=pomoc *  vrednostY;

//

                                k.setX(pocX);
                                k.setY(pocY);

                                for (LinkPainter slikar : k.getLinkList()) {
                                    Link linkara = (Link) slikar.getElement();
                                    if (linkara.getTo().equals(k)) {
                                        Point pos1 = new Point(pocX, pocY);
                                        slikar.setPos1(pos1);
                                    } else {
                                        Point pos2 = new Point(pocX, pocY);
                                        slikar.setPos2(pos2);
                                    }
                                }




                                Point pos2 = new Point(pocX, pocY);
                                painter.setPos2(pos2);

                                if(pocY==t.getY()){
                                    if(dodajeX){
                                        dodajeX=false;
                                    }else{
                                        dodajeX=true;
                                    }
                                }
                                if(pocX==t.getX()){
                                    if(dodajeY){
                                        dodajeY=false;
                                    }else dodajeY = true;
                                }
                                pomoc=1;



                            }
                        }

                    }



                }
            }









        }

    }
}
