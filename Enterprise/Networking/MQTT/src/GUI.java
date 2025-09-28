import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GUI extends JFrame {
    private JLabel temp= new JLabel();
    private JLabel hum = new JLabel();
    GridBagLayout gridBagLayout =  new GridBagLayout();
    GridBagConstraints c = new GridBagConstraints();

    GUI(){
        setSize(500,500);
        setVisible(true);
        getContentPane().setLayout(gridBagLayout);

        // get values needed from the subscriber client
        SimpleCallback.messageArrived1(); /*  If mqtt subscriber works remove this line. This puts hardcoded values into array */
        ArrayList<Integer> tempArray = SimpleCallback.tempArray;
        ArrayList<Integer> humArray = SimpleCallback.humArray;

        // for each element in the array pass the temp, humidity and the column that the temp is in into the createColumn method
        int colNum = 0;
        for(int temper : tempArray){
            int humid = humArray.get(tempArray.indexOf(temper));
            createColumn(temper, humid, colNum);
            // since 3 columns are created (temp, humidity, and a space for the next block) add 3 to the columns
            colNum = colNum + 3;

        }

        // add the label to the bottom
        JLabel label = new JLabel("Red = Temperature, Blue = Humidity");
        c.gridy = 3;
        c.gridx = 0;
        c.ipady = 1;
        c.gridwidth = tempArray.size() * 3;
        c.anchor = GridBagConstraints.PAGE_END;
        gridBagLayout.setConstraints(label, c);
        add(label);

        System.out.println(tempArray);
        System.out.println(humArray);


    }

    private void createColumn(int temper, int humid, int colNum) {
        // create variables
        JPanel temp = new JPanel();
        JPanel hum = new JPanel();
        JLabel tempLabel = new JLabel();
        JLabel humLabel = new JLabel();
        JPanel space = new JPanel();


        // set the temp background to red and the humidity background to blue
        temp.setBackground(Color.red);
        hum.setBackground(Color.blue);

// everything is anchored to the bottom
        // add the temperature column, the height is the temperature value scaled up by 5. the x value is 1 and the y value is the Array (index * 3)
        // the width is 10. the constraits are added to the JLabel and then the JLabel is added to the JFrame
        c.gridy = 1;
        c.gridx = colNum;
        c.ipady = temper * 5;
        c.ipadx = 10;
        c.anchor = GridBagConstraints.PAGE_END;
        gridBagLayout.setConstraints(temp, c);
        add(temp);

        // set the label below the bar to show the temperature value
        tempLabel.setText("" + temper);
        c.anchor = GridBagConstraints.PAGE_END;
        c.ipady = 1;
        c.gridy = 2;
        c.gridx = colNum;
        gridBagLayout.setConstraints(tempLabel, c);
        add(tempLabel);

        // add the humid column, the height is the humid value scaled up by 5. the x value is 1 and the y value is one to the right of the previous
        // the width is 10. the constraints are added to the JLabel and then the JLabel is added to the JFrame
        c.gridy = 1;
        c.gridx = colNum + 1;
        c.ipady = humid * 5;
        c.ipadx = 10;
        gridBagLayout.setConstraints(hum, c);
        add(hum);

        // set the label below the bar to show the humidity value
        humLabel.setText("" + humid);
        c.anchor = GridBagConstraints.PAGE_END;
        c.ipady = 1;
        c.gridy = 2;
        c.gridx = colNum + 1;
        gridBagLayout.setConstraints(humLabel, c);
        add(humLabel);

        // add a blank column to separate the the current set of readings and the next set of readings
        c.gridy = 1;
        c.gridx = colNum + 2;
        c.ipady = humid * 5;
        c.ipadx = 10;
        gridBagLayout.setConstraints(space, c);
        add(space);
    }




}

