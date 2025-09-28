package JavaGui.GuiLayoutExamples;
import java.awt.*;
import javax.swing.*;

public class BoxLayoutExample extends JFrame {
	private JButton theButton1 = new JButton("Button 1");
	private JButton theButton2 = new JButton("Button 2");
	private JButton theButton3 = new JButton("Button 3");
	private JButton theButton4 = new JButton("Button 4");
	private JButton theButton5 = new JButton("Long-Named Button 5");

	public BoxLayoutExample() {
		
		getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.X_AXIS));

		theButton1.setAlignmentY(Component.LEFT_ALIGNMENT);
		getContentPane().add(theButton1);

		theButton2.setAlignmentY(Component.CENTER_ALIGNMENT);
		getContentPane().add(theButton2);

		theButton3.setAlignmentY(Component.RIGHT_ALIGNMENT);
		getContentPane().add(theButton3);

		theButton4.setAlignmentY(Component.CENTER_ALIGNMENT);
		getContentPane().add(theButton4);

		theButton5.setAlignmentY(Component.CENTER_ALIGNMENT);
		getContentPane().add(theButton5);

		setSize(250,175);
		setVisible(true);
	}

	public static void main(String args[]) {
		new BoxLayoutExample();
	}
}
