package propra22.q3389561.views;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Klasse für das Hauptmenü des Hauptfensters
 */
public class MainMenu extends JMenuBar implements ActionListener {

    private static final String LABEL_MENU_DATEI = "Datei";
    private static final String LABEL_MENUITEM_NEU = "Neu";
    private static final String LABEL_MENUITEM_OEFFNEN = "Öffnen";
    private static final String LABEL_MENUITEM_SPEICHERN = "Speichern";
    private static final String LABEL_MENUITEM_SPEICHERNUNTER = "Speichern unter";
    private static final String LABEL_MENUITEM_BEENDEN = "Programm beenden";


    private static JMenuItem beenden = new JMenuItem(LABEL_MENUITEM_BEENDEN); ;


    public MainMenu(){

        super();
        JMenu datei = new JMenu(LABEL_MENU_DATEI);

        JMenuItem neu = new JMenuItem(LABEL_MENUITEM_NEU);
        JMenuItem oeffnen = new JMenuItem(LABEL_MENUITEM_OEFFNEN);
        JMenuItem speichern = new JMenuItem(LABEL_MENUITEM_SPEICHERN);
        JMenuItem speichernUnter = new JMenuItem(LABEL_MENUITEM_SPEICHERNUNTER);


        datei.add(neu);
        datei.add(oeffnen);
        datei.add(speichern);
        datei.add(speichernUnter);
        datei.add(beenden);

        beenden.addActionListener(this);


        this.add(datei);


    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==beenden){
            System.exit(0);
        }

    }
}
