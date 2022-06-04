package propra22.q3389561.views;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;

public class FooterPanel extends JPanel {

    public FooterPanel(int width){
        this.setBackground(Color.GREEN);
        this.setLayout(new BorderLayout());
        this.add(new JLabel("Hallo"),BorderLayout.LINE_START);
        this.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        this.setPreferredSize(new Dimension(width,100));
    }
}
