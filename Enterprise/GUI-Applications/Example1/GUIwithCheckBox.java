package JavaGui.Example1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIwithCheckBox extends JFrame implements ActionListener {
    private JButton theButton1 = new JButton();
    private JButton theButton2 = new JButton();
    private JButton theButton3 = new JButton();
    private JCheckBox checkBox = new JCheckBox("give colours");

    public GUIwithCheckBox() {
        theButton1.setSize(50, 30);
        theButton2.setSize(50, 30);
        theButton3.setSize(50, 30);

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

        c.gridx = 4;
        c.gridy = 1;
        gridbag.setConstraints(checkBox, c);

        checkBox.addActionListener(this);
        add(checkBox);

        setSize(300, 200);
        setVisible(true);
    }

    public static void main(String args[]) {
        new GUIwithCheckBox();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(checkBox.isSelected()){
            theButton1.setBackground(Color.GREEN);
            theButton2.setBackground(Color.blue);
            theButton3.setBackground(Color.red);
        }else if(!(checkBox.isSelected())){
            theButton1.setBackground(Color.lightGray);
            theButton2.setBackground(Color.lightGray);
            theButton3.setBackground(Color.lightGray);
        }
    }
}
