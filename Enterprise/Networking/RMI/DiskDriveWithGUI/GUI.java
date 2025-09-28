package RMI.DiskDriveWithGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame implements ActionListener{
	private static final long serialVersionUID = 7397842038680177658L;
	private static XboxDiskDrive gameInserted;
	private JButton insert = new JButton("insert");
	private JButton remove = new JButton("Remove");

	private JLabel nameLabel = new JLabel("Name ");
	private JLabel ageLabel = new JLabel("Age ");
	private JLabel nameInfo = new JLabel();
	private JLabel ageInfo = new JLabel();
	private JLabel message = new JLabel("This is a information field to help you know what is going on with the disk tray");

	private JTextField nameText = new JTextField();
	private JTextField ageText = new JTextField();

	public static void main(String args[]){
		gameInserted = XboxDiskDrive.deserialise();
		new JavaGui.Example1.GUI();
	}

	public GUI(){
		nameText.setSize(100,20);
		ageText.setSize(100,20);
		setSize(700,250);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


		GridBagLayout gridbag = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();
		getContentPane().setLayout(gridbag);

		//natural height, maximum width
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipadx = 100;
		c.ipady = 10;

		c.gridx = 0;
		c.gridy = 0;
		gridbag.setConstraints(nameLabel, c);
		getContentPane().add(nameLabel);

		c.gridx = 1;
		c.gridy = 0;
		gridbag.setConstraints(ageLabel, c);
		getContentPane().add(ageLabel);

		c.gridx = 0;
		c.gridy = 1;
		gridbag.setConstraints(nameInfo, c);
		getContentPane().add(nameInfo);

		c.gridx = 1;
		c.gridy = 1;
		gridbag.setConstraints(ageInfo, c);
		getContentPane().add(ageInfo);

		c.gridx = 0;
		c.gridy = 2;
		gridbag.setConstraints(nameText, c);
		getContentPane().add(nameText);

		c.gridx = 1;
		c.gridy = 2;
		gridbag.setConstraints(ageText, c);
		getContentPane().add(ageText);

		remove.addActionListener(this);
		c.gridx = 2;
		c.gridy = 1;
		gridbag.setConstraints(remove, c);
		getContentPane().add(remove);

		insert.addActionListener(this);
		c.gridx = 2;
		c.gridy = 2;
		gridbag.setConstraints(insert, c);
		getContentPane().add(insert);

		c.gridwidth = 3;
		c.gridx = 0;
		c.gridy = 3;
		gridbag.setConstraints(message, c);
		getContentPane().add(message);

		setInfo();
	}
	public void setInfo(){
		nameInfo.setText(gameInserted.getName());
		ageInfo.setText("" + gameInserted.getPegiAge());
		message.setText("The game has been Inserted");
	}

	public void removeInfo(){
		nameInfo.setText("");
		ageInfo.setText("");
		message.setText("The game has been removed");
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(insert)){
			String name = nameText.getText();
			int age = Integer.parseInt(ageText.getText());
			gameInserted = XboxDiskDrive.setInstance(name, age);

			if(gameInserted == null){
				message.setText("Sorry a game already exists inside the disk tray. please remove it first before adding a new one");
			}else{
				setInfo();
			}
		}else if(e.getSource().equals(remove)){
			gameInserted.removeInstance();
			removeInfo();
		}
	}

}
