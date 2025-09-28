package JavaGui.GuiLayoutExamples;
import java.awt.*;
import javax.swing.*;

public class GridBagLayoutExample extends JFrame {
    private JButton theButton1 = new JButton("Button 1");
    private JButton theButton2 = new JButton("Button 2");
    private JButton theButton3 = new JButton("Button 3");
    private JButton theButton4 = new JButton("Button 4");
    private JButton theButton5 = new JButton("Long-Named Button 5");

    public GridBagLayoutExample() {
		super();
        GridBagLayout gridbag = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();
        getContentPane().setLayout(gridbag);

        //natural height, maximum width
        c.fill = GridBagConstraints.HORIZONTAL;

        c.gridx = 0;
        c.gridy = 0;
        gridbag.setConstraints(theButton1, c);
        getContentPane().add(theButton1);

        c.gridx = 1;
        c.gridy = 0;
        gridbag.setConstraints(theButton2, c);
        getContentPane().add(theButton2);

        c.gridx = 2;
        c.gridy = 0;
        gridbag.setConstraints(theButton3, c);
        getContentPane().add(theButton3);

        c.gridwidth = 2;
        c.gridx = 0;
        c.gridy = 1;
        gridbag.setConstraints(theButton4, c);
        getContentPane().add(theButton4);

        c.gridwidth = 3;
        c.gridx = 0;
        c.gridy = 3;
        gridbag.setConstraints(theButton5, c);
        getContentPane().add(theButton5);

        setVisible(true);
		pack();
    }

    public static void main(String args[]) {
       new GridBagLayoutExample();
    }
}
