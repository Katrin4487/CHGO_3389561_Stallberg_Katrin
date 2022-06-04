package propra22.q3389561.views;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Klasse für graphische Oberfläche.
 */
public class GraphicPanel extends JPanel implements MouseListener {

    //=============== Attribute==================

    private int currX,currY,oldX,oldY;
    private Dimension dimension;

    public GraphicPanel(Dimension dimension){
        this.dimension = dimension;
        init();
    }

    private void init(){
        this.setBackground(Color.GRAY);
        this.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        this.addMouseListener(this);
        this.setPreferredSize(this.dimension);
    }



    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

    //=========================== Override Methoden ===========================
    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
