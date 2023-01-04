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

            for(Element central : MainFrame.getInstance().getProjectView().getMapView().getSelectedItems().getElements()) {
                if (!(central instanceof Concept)) {
                    return;
                }


                for(ElementPainter p : MainFrame.getInstance().getProjectView().getMapView().getMindMap().getPainters()){
                    if(!(p.getElement() instanceof Concept)) continue;
                    Concept p1 = (Concept) p.getElement();
                    p1.setNivo(-1);

                }


                central.setStroke(5);

                int sirina = MainFrame.getInstance().getProjectView().getMapView().getWidth() / 2;
                int visina = MainFrame.getInstance().getProjectView().getMapView().getHeight() / 2;

                sirina /= 8;
                visina /= 8;
                sirina *= 8;
                visina *= 8;
//                System.out.println(visina + " " + sirina);
                int pocY = visina;
                int pocX = sirina - 200;

                Concept t = (Concept) central;
                t.setNivo(0);

                t.setX(sirina);
                t.setY(visina);

                for (LinkPainter painter : t.getLinkList()) {
                    Link con = (Link) painter.getElement();
                    if (con.getTo().equals(t)) {
                        Point pos1 = new Point(sirina, visina);
                        painter.setPos1(pos1);
                    } else {
                        Point pos2 = new Point(sirina, visina);
                        painter.setPos2(pos2);
                    }
                }

                boolean dodajeX = false;
                boolean dodajeY = true;
                int pomoc = 0;


                int vrednostX = 200;
                int vrednostY = 150;

                if (t.getLinkList().size() <= 4) {
                    vrednostX /= 1;
                    vrednostY /= 1;
                } else if (t.getLinkList().size() <= 8) {
                    vrednostX /= 2;
                    vrednostY /= 2;
                } else if (t.getLinkList().size() <= 16) {
                    vrednostX /= 4;
                    vrednostY /= 4;
                }


                int ostalePomoc = MainFrame.getInstance().getProjectView().getMapView().getHeight();
                int red=0;

                while(true){
                    int pomozi = 0;
                    for(ElementPainter p : MainFrame.getInstance().getProjectView().getMapView().getMindMap().getPainters()){
                        if(!(p.getElement() instanceof Concept)) continue;
                        Concept p1= (Concept) p.getElement();
                        if(p1.getNivo()==red){
                            pomozi++;
                            for(ElementPainter k : MainFrame.getInstance().getProjectView().getMapView().getMindMap().getPainters()){
                                if(!(k.getElement() instanceof Concept)) continue;
                                Concept k1 = (Concept) k.getElement();
                                for (LinkPainter painter : k1.getLinkList()){
                                    Link linkara = (Link) painter.getElement();
                                    if((linkara.getTo().equals(p1) || linkara.getFrom().equals(p1)) && k1.getNivo()==-1){
                                        k1.setNivo(red+1);
                                    }
                                }
                            }
                        }
                    }
                    if(pomozi==0) break;
                    else red ++;
                }


                for(ElementPainter p : MainFrame.getInstance().getProjectView().getMapView().getMindMap().getPainters()){
                    if(!(p.getElement() instanceof Concept)) continue;
                    Concept p1 = (Concept) p.getElement();
                    System.out.println(p1.getNivo());
                }


                for (ElementPainter p : MainFrame.getInstance().getProjectView().getMapView().getMindMap().getPainters()) {
                    if (p.getElement() instanceof Concept && !(p.getElement().equals(t))) {
                        Concept k = (Concept) p.getElement();
                        for (LinkPainter painter : k.getLinkList()) {


                            Link con = (Link) painter.getElement();
                            if (con.getTo().equals(t)) {


//                                Concept k = (Concept) p.getElement();

                                if (dodajeX) {
                                    pocX += pomoc * vrednostX;
                                } else pocX -= pomoc * vrednostX;

                                if (dodajeY) pocY += pomoc * vrednostY;
                                else pocY -= pomoc * vrednostY;

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

                                if (pocY == t.getY()) {
                                    if (dodajeX) {
                                        dodajeX = false;
                                    } else {
                                        dodajeX = true;
                                    }
                                }
                                if (pocX == t.getX()) {
                                    if (dodajeY) {
                                        dodajeY = false;
                                    } else dodajeY = true;
                                }

                                pomoc = 1;


                            } else if (con.getFrom().equals(t)) {


                                //Concept k = (Concept) p.getElement();

                                if (dodajeX) {
                                    pocX += pomoc * vrednostX;
                                } else pocX -= pomoc * vrednostX;

                                if (dodajeY) pocY += pomoc * vrednostY;
                                else pocY -= pomoc * vrednostY;


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

                                if (pocY == t.getY()) {
                                    if (dodajeX) {
                                        dodajeX = false;
                                    } else {
                                        dodajeX = true;
                                    }
                                }
                                if (pocX == t.getX()) {
                                    if (dodajeY) {
                                        dodajeY = false;
                                    } else dodajeY = true;
                                }
                                pomoc = 1;


                            } else System.out.println("crnja");
                        }





//                        if (k.getLinkList().isEmpty()) {
//
//                            if (!(k.getX() >= ostalePomoc * 3)) {
//                                k.setX(k.getX() + ostalePomoc);
//                            }
//
//                        } else {
//                            int lal = 1;
//                            for (LinkPainter slikar : k.getLinkList()) {
//                                Link linkara = (Link) slikar.getElement();
//                                if (linkara.getTo().equals(t) || linkara.getFrom().equals(t)) lal = 2;
//                            }
//                            if (lal == 2) continue;
//                            for (LinkPainter slikar : k.getLinkList()) {
//                                Link linkara = (Link) slikar.getElement();
//                                if (!(linkara.getTo().equals(t)) && !(linkara.getFrom().equals(t))) {
//                                    if (lal == 1) {
//
//                                        if (!(k.getX() >= ostalePomoc * 3)) {
//                                            k.setX(k.getX() + ostalePomoc);
//                                            lal = 0;
//                                        }
//
//
//                                        if (linkara.getTo().equals(k)) {
//                                            int pomocx = (int) slikar.getPos1().getX();
//                                            int pomocy = (int) slikar.getPos1().getY();
//                                            if (!(slikar.getPos1().getX() > ostalePomoc * 3)) {
//                                                pomocx += ostalePomoc;
//                                            }
//
//                                            Point pos1 = new Point(pomocx, pomocy);
//                                            slikar.setPos1(pos1);
//                                        } else {
//                                            int pomocx = (int) slikar.getPos2().getX();
//                                            int pomocy = (int) slikar.getPos2().getY();
//                                            if (!(slikar.getPos2().getX() > ostalePomoc * 3)) {
//                                                pomocx += ostalePomoc;
//                                            }
//                                            Point pos2 = new Point(pomocx, pomocy);
//                                            slikar.setPos2(pos2);
//                                        }
//                                    } else lal = 2;
//
//                                }
//
//
//                            }
//
//                        }



                    }
                }


                for(ElementPainter p : MainFrame.getInstance().getProjectView().getMapView().getMindMap().getPainters()){
                    if (!(p.getElement() instanceof Concept)) continue;
                    Concept p1 = (Concept) p.getElement();

                    if(p1.getNivo()==-1){

                        if (!(p1.getX() >= ostalePomoc * 3)) {
                            p1.setX(p1.getX() + ostalePomoc);

                        }
                        for(LinkPainter slikar : p1.getLinkList()){
                            Link linkara = (Link) slikar.getElement();
                            if (linkara.getTo().equals(p1)) {
                                Point pos1 = new Point(p1.getX(), p1.getY());
                                slikar.setPos1(pos1);
                            } else {
                                Point pos2 = new Point(p1.getX(), p1.getY());
                                slikar.setPos2(pos2);
                            }
                        }

                    }
                }

                red=1;
                while(true) {
                    int pomozi=0;

                    for (ElementPainter p : MainFrame.getInstance().getProjectView().getMapView().getMindMap().getPainters()) {
                        if (!(p.getElement() instanceof Concept)) continue;
                        Concept p1 = (Concept) p.getElement();
                        if (p1.getNivo() == red) {
                            for (ElementPainter k : MainFrame.getInstance().getProjectView().getMapView().getMindMap().getPainters()) {
                                if (!(k.getElement() instanceof Concept)) continue;
                                Concept k1 = (Concept) k.getElement();

                                if (k1.getNivo() - 1 == red) {
                                    for (LinkPainter slikar : k1.getLinkList()) {
                                        Link linkara = (Link) slikar.getElement();

                                        if (linkara.getTo().equals(p1) || linkara.getFrom().equals(p1)) {
                                            pomozi++;




                                            if(p1.getX()==t.getX() && p1.getY() < t.getY()){
                                                k1.setY(p1.getY()-75);
                                                k1.setX(p1.getX());




                                                for (LinkPainter slikar1 : k1.getLinkList()) {
                                                    Link linkara1 = (Link) slikar1.getElement();
                                                    if (linkara1.getTo().equals(k1)) {
                                                        Point pos1 = new Point(k1.getX(), k1.getY());
                                                        slikar1.setPos1(pos1);
                                                    } else {
                                                        Point pos2 = new Point(k1.getX(), k1.getY());
                                                        slikar1.setPos2(pos2);
                                                    }
                                                }

                                            }else if(p1.getX()==t.getX() && p1.getY() > t.getY()){
                                                k1.setY(p1.getY()+75);
                                                k1.setX(p1.getX());

                                                for (LinkPainter slikar1 : k1.getLinkList()) {
                                                    Link linkara1 = (Link) slikar1.getElement();
                                                    if (linkara1.getTo().equals(k1)) {
                                                        Point pos1 = new Point(k1.getX(), k1.getY());
                                                        slikar1.setPos1(pos1);
                                                    } else {
                                                        Point pos2 = new Point(k1.getX(), k1.getY());
                                                        slikar1.setPos2(pos2);
                                                    }
                                                }

                                            }else if(p1.getX()<t.getX() && p1.getY() == t.getY()){
                                                k1.setY(p1.getY());
                                                k1.setX(p1.getX()-125);

                                                for (LinkPainter slikar1 : k1.getLinkList()) {
                                                    Link linkara1 = (Link) slikar1.getElement();
                                                    if (linkara1.getTo().equals(k1)) {
                                                        Point pos1 = new Point(k1.getX(), k1.getY());
                                                        slikar1.setPos1(pos1);
                                                    } else {
                                                        Point pos2 = new Point(k1.getX(), k1.getY());
                                                        slikar1.setPos2(pos2);
                                                    }
                                                }

                                            }else if(p1.getX()>t.getX() && p1.getY() == t.getY()){
                                                k1.setY(p1.getY() );
                                                k1.setX(p1.getX()+125);

                                                for (LinkPainter slikar1 : k1.getLinkList()) {
                                                    Link linkara1 = (Link) slikar1.getElement();
                                                    if (linkara1.getTo().equals(k1)) {
                                                        Point pos1 = new Point(k1.getX(), k1.getY());
                                                        slikar1.setPos1(pos1);
                                                    } else {
                                                        Point pos2 = new Point(k1.getX(), k1.getY());
                                                        slikar1.setPos2(pos2);
                                                    }
                                                }

                                            }else if(p1.getX()>t.getX() && p1.getY() > t.getY()){
                                                k1.setY(p1.getY() + 50);
                                                k1.setX(p1.getX() + 50);

                                                for (LinkPainter slikar1 : k1.getLinkList()) {
                                                    Link linkara1 = (Link) slikar1.getElement();
                                                    if (linkara1.getTo().equals(k1)) {
                                                        Point pos1 = new Point(k1.getX(), k1.getY());
                                                        slikar1.setPos1(pos1);
                                                    } else {
                                                        Point pos2 = new Point(k1.getX(), k1.getY());
                                                        slikar1.setPos2(pos2);
                                                    }
                                                }

                                            }else if(p1.getX()>t.getX() && p1.getY() < t.getY()){
                                                k1.setY(p1.getY() - 50);
                                                k1.setX(p1.getX() + 50);

                                                for (LinkPainter slikar1 : k1.getLinkList()) {
                                                    Link linkara1 = (Link) slikar1.getElement();
                                                    if (linkara1.getTo().equals(k1)) {
                                                        Point pos1 = new Point(k1.getX(), k1.getY());
                                                        slikar1.setPos1(pos1);
                                                    } else {
                                                        Point pos2 = new Point(k1.getX(), k1.getY());
                                                        slikar1.setPos2(pos2);
                                                    }
                                                }

                                            }else if(p1.getX()<t.getX() && p1.getY() > t.getY()){
                                                k1.setY(p1.getY() + 50);
                                                k1.setX(p1.getX() - 50);

                                                for (LinkPainter slikar1 : k1.getLinkList()) {
                                                    Link linkara1 = (Link) slikar1.getElement();
                                                    if (linkara1.getTo().equals(k1)) {
                                                        Point pos1 = new Point(k1.getX(), k1.getY());
                                                        slikar1.setPos1(pos1);
                                                    } else {
                                                        Point pos2 = new Point(k1.getX(), k1.getY());
                                                        slikar1.setPos2(pos2);
                                                    }
                                                }

                                            }else if(p1.getX()<t.getX() && p1.getY() < t.getY()){
                                                k1.setY(p1.getY() - 50);
                                                k1.setX(p1.getX() - 50);

                                                for (LinkPainter slikar1 : k1.getLinkList()) {
                                                    Link linkara1 = (Link) slikar1.getElement();
                                                    if (linkara1.getTo().equals(k1)) {
                                                        Point pos1 = new Point(k1.getX(), k1.getY());
                                                        slikar1.setPos1(pos1);
                                                    } else {
                                                        Point pos2 = new Point(k1.getX(), k1.getY());
                                                        slikar1.setPos2(pos2);
                                                    }
                                                }

                                            }




//                                            System.out.println(p1.getName() + " " + k1.getName());
//                                            k1.setY(p1.getY() - 25);
//                                            k1.setX(p1.getX());
//
//                                            if (linkara.getTo().equals(k1)) {
//                                                Point pos1 = new Point(p1.getX(), p1.getY() - 25);
//
//                                                slikar.setPos1(pos1);
//                                            } else {
//                                                Point pos2 = new Point(p1.getX(), p1.getY() - 25);
//                                                slikar.setPos2(pos2);
//                                            }


                                        }

                                    }
                                }


                            }
                        }
                    }
                    if(pomozi==0) break;
                    else red++;
                }




            }




        }

    }
}
