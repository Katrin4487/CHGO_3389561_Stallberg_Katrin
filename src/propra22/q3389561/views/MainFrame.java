package propra22.q3389561.views;

import propra22.q3389561.controllers.WindowController;
import propra22.q3389561.controllers.WindowResizeListener;
import propra22.q3389561.controllers.WindowResizeMonitor;
import propra22.q3389561.models.WindowResizeEvent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Klasse für das Hauptfenster
 */
public class MainFrame extends JFrame implements WindowResizeListener {

    //Konstanten für das Hauptfenster
    private static final String APPNAME = "CHGO_3389561_Stallberg_Katrin";
    private static final int DEFAULT_FRAME_WIDTH = 400;
    private static final int DEFAULT_FRAME_HEIGHT = 400;

    //Attribute
    Dimension windowDimension;
    //Einzelkomponenten
    private JScrollPane scrollPane;
    private GraphicPanel graphicPanel;
    private FooterPanel footerPanel;



    //================ Konstruktor=======================

    /**
     * Konstruktor Erzeugt ein Hauptfenster.
     */
    public MainFrame(){
        this.init();
    }

    private void init(){
        windowDimension = WindowController.getWindowDimension();

        this.setTitle(APPNAME);
        this.setSize(windowDimension);
        this.setLayout(new BorderLayout(2,1)); //TODO

        this.setJMenuBar(new MainMenu());
        graphicPanel = new GraphicPanel(windowDimension);
        scrollPane = new JScrollPane(graphicPanel);
        scrollPane.setPreferredSize(new Dimension(windowDimension.width-15,windowDimension.height-100));
        footerPanel = new FooterPanel(windowDimension.width-15);

        this.add(scrollPane, BorderLayout.PAGE_START);
        this.add(footerPanel, BorderLayout.PAGE_END);
        WindowResizeMonitor.register(this,this);
    }

    @Override
    public void windowResized(WindowResizeEvent e) {
        //System.out.println("resized:"+ e.getNewSize());
        windowDimension = e.getNewSize();
        scrollPane.setPreferredSize(new Dimension(windowDimension.width-15,windowDimension.height-100));
        footerPanel.setPreferredSize(new Dimension(windowDimension.width-15,100));
    }

}



