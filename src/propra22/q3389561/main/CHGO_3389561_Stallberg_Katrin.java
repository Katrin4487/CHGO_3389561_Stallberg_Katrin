package propra22.q3389561.main;

import propra22.q3389561.controllers.TxtReader;
import propra22.q3389561.controllers.WindowController;
import propra22.q3389561.models.CPArrayList;
import propra22.q3389561.models.CPoint;
import propra22.q3389561.views.MainFrame;

import javax.swing.*;

/**
 * Klasse mit der Main-Methode des Prgramms
 */
public class CHGO_3389561_Stallberg_Katrin {

    /**
     * Main-Methode des Programms
     * @param args Liste mit Parametern (String). Ist diese leer, wird das Programm normal gestartet.
     *             Ist der erste Eintrag -t wird ein Test gestartet.
     */
    public static void main(String[] args) {

        String path = "C:\\CHGO_3389561_Stallberg_Katrin\\data\\random10.points";
        CPArrayList l = TxtReader.getCPListFromFile(path);
        CPArrayList sl = l.sorted();


        System.out.println("Die Liste ist :");
        System.out.println(l.toString());
        System.out.println("----------------");
        System.out.println("============ PUNKTE ==============");

        System.out.println("Links "+l.returnLeft());
        System.out.println("Rechts "+l.returnRight());
        System.out.println("Oben "+l.returnTop());
        System.out.println("Unten "+l.returnBottom());


        MainFrame frame = new MainFrame();

        frame.setVisible(true);

        System.out.println(WindowController.getWindowDimension().toString());




    }

    }
