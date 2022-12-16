package main.java.dsw.gerumap.app.gui.swing.controller.stateActions;

import lombok.Getter;
import lombok.Setter;
import main.java.dsw.gerumap.app.gui.swing.controller.actions.ExitAction;
import main.java.dsw.gerumap.app.gui.swing.view.MainFrame;
import main.java.dsw.gerumap.app.repository.implementation.Element;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

@Setter
@Getter
public class Settings extends JDialog {


    JLabel imeLabel = new JLabel("oces promenis ime?");
    JLabel strokeLabel = new JLabel("Oces i debljinu?");
    JTextField imeTf = new JTextField(16);
    JTextField strokeTf = new JTextField(16);





    JColorChooser colorChooser = new JColorChooser();

    JButton dugme = new JButton("OK");


    public Settings(Frame parent, String title, boolean modal) {
        super(parent, title, modal);



        JPanel panel = new JPanel(new BorderLayout());

        JPanel panelTf = new JPanel();
        JPanel panelCenter = new JPanel();
        JPanel panelSouth = new JPanel();





        //panelTf.setLayout(new GridLayout(3,2));
        setLocationRelativeTo(parent);
        setSize(750,500);
        panelTf.add(imeLabel);
        panelTf.add(imeTf);

        panelCenter.add(strokeLabel);
        panelCenter.add(strokeTf);



        panelSouth.add(colorChooser);
        panelSouth.add(dugme);
        panelTf.add(panelCenter,BorderLayout.CENTER);
        panelTf.add(panelSouth,BorderLayout.SOUTH);

        dugme.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                for(Element el : MainFrame.getInstance().getProjectView().getMapView().getSelectedItems().getElements()){
                    System.out.println(el.getColor());
                    el.setName(imeTf.getText());


                    el.setColor(colorChooser.getColor());
                    el.setRealColor(colorChooser.getColor());

                    MainFrame.getInstance().getProjectView().getMapView().repaint();

                    if(!Objects.equals(strokeTf.getText(), "")) {
                        el.setStroke(Integer.parseInt(strokeTf.getText()));
                    }

                }




            }
        });


        this.add(panelTf);

        panelTf.setVisible(true);



    }
}
