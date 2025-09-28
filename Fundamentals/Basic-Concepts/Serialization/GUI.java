package BasicJava.Serialization;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

public class GUI extends JFrame implements ActionListener {

    JTextArea text = new JTextArea("");
    JButton button1 = new JButton("Show");
    JButton button2 = new JButton("Clear");
    JPanel panel = new JPanel();
    private  String textHolder;

    public GUI(){
        text.setSize(100,100);
        button1.setSize(70,70);
        button2.setSize(70,70);
        button1.addActionListener(this);
        button2.addActionListener(this);
        panel.add(button1);
        panel.add(button2);
        panel.add(text);

        getContentPane().add(panel);

        setSize(600,350);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        ArrayList<Phone> phones = new ArrayList<>();

        try {
            phones = Main.deserialize();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(actionEvent.getSource().equals(button1)){
            for (Phone p : phones) {
                if(p == phones.get(0)){
                    textHolder = p.toString();
                }else
                    textHolder += p.toString();
            }
            text.setText(textHolder);
        }
        if(actionEvent.getSource().equals(button2)) {
            text.setText("");
            textHolder = "";
        }

    }

    public static void main(String[] args) {
        new JavaGui.Example1.GUI();
    }
}
