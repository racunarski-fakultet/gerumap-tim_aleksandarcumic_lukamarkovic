package main.java.dsw.gerumap.app.gui.swing.controller.help;

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.Parameter;

public class Help extends JDialog {

    JLabel Ime = new JLabel("Ime");
    JLabel Ime1 = new JLabel("Luka");
    JLabel Ime2 = new JLabel("Aleksandar");
    JLabel prezime = new JLabel("Prezime");
    JLabel prezime1 = new JLabel("Markovic");
    JLabel prezime2 = new JLabel("Cumic");
    JLabel indeks = new JLabel("Indeks");
    JLabel indeks1 = new JLabel("144/22 RN");
    JLabel indeks2 = new JLabel("116/22 RN");
    JLabel slika = new JLabel("Slika");
    JLabel slika1 = new JLabel("/");
    JLabel slika2 = new JLabel("/");




    public Help(Frame parent, String title, boolean modal) {
        super(parent, title, modal);

        JPanel panel = new JPanel();
        setLocationRelativeTo(parent);
        setSize(350,350);
        panel.setLayout(new GridLayout(4,4));

        panel.add(Ime);
        panel.add(Ime1);
        panel.add(Ime2);
        panel.add(prezime);
        panel.add(prezime1);
        panel.add(prezime2);
        panel.add(indeks);
        panel.add(indeks1);
        panel.add(indeks2);
        panel.add(slika);
        panel.add(slika1);
        panel.add(slika2);

        this.add(panel);
        panel.setVisible(true);



    }
}
