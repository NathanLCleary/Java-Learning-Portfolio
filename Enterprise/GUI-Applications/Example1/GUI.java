package JavaGui.Example1;

import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame {
    public JButton theButton1 = new JButton();
    public JButton theButton2 = new JButton();
    public JButton theButton3 = new JButton();

    public GUI() {
        theButton1.setSize(50,30);
        theButton2.setSize(50,30);
        theButton3.setSize(50,30);

        GridBagLayout gridbag = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();
        getContentPane().setLayout(gridbag);

        c.fill = GridBagConstraints.HORIZONTAL;

        c.gridx = 1;
        c.gridy = 1;
        gridbag.setConstraints(theButton1, c);
        add(theButton1);

        c.gridx = 2;
        c.gridy = 2;
        gridbag.setConstraints(theButton2, c);
        add(theButton2);

        c.gridx = 3;
        c.gridy = 1;
        gridbag.setConstraints(theButton3, c);
        add(theButton3);

        //panel.setAlignmentX(Component.CENTER_ALIGNMENT);

        setSize(300,200);
        setVisible(true);
    }

    public static void main(String args[]) {
        new GUI();
    }
}
