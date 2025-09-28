import java.awt.*;
import java.awt.event.*;
import java.io.FileWriter;
import java.io.PrintWriter;
import javax.swing.*;
import javax.swing.border.*;
import java.sql.*;

@SuppressWarnings("serial")
public class JDBCMainWindowContent extends JInternalFrame implements ActionListener
{	
	String cmd = null;

	// DB Connectivity Attributes
	private Connection con = null;
	private Statement stmt = null;
	private ResultSet rs = null;

	private Container content;

	private JPanel detailsPanel;
	private JPanel exportButtonPanel;
	//private JPanel exportConceptDataPanel;
	private JScrollPane dbContentsPanel;

	private Border lineBorder;

	private JLabel IDLabel=new JLabel("ID:                 ");
	private JLabel IPAddressLabel=new JLabel("IP Address:               ");
	private JLabel NameLabel=new JLabel("Name:      ");
	private JLabel TypeLabel=new JLabel("Type:        ");
	private JLabel RoomLabel=new JLabel("Room:                 ");
	private JLabel FirstConLabel=new JLabel("First Connected:               ");
	private JLabel isOnLabel=new JLabel("Is it on?:      ");
	private JLabel RuntimeLabel=new JLabel("Runtime:      ");


	private JTextField IDTF= new JTextField(10);
	private JTextField IPAddressTF=new JTextField(10);
	private JTextField NameTF=new JTextField(10);
	private JTextField TypeTF=new JTextField(10);
	private JTextField RoomTF=new JTextField(10);
	private JTextField FirstConTF=new JTextField(10);
	private JTextField isOnTF=new JTextField(10);
	private JTextField RuntimeTF=new JTextField(10);



	private static QueryTableModel TableModel = new QueryTableModel();
	//Add the models to JTabels
	private JTable TableofDBContents=new JTable(TableModel);
	//Buttons for inserting, and updating members
	//also a clear button to clear details panel
	private JButton updateButton = new JButton("Update");
	private JButton insertButton = new JButton("Insert");
	private JButton exportButton  = new JButton("Export");
	private JButton deleteButton  = new JButton("Delete");
	private JButton clearButton  = new JButton("Clear");

	private JButton  NumDevices = new JButton("Number Device For Room:");
	private JTextField NumDevicesTF  = new JTextField(12);
	private JButton AvgRuntime  = new JButton("Avg Runtime For Room:");
	private JTextField avgRuntimeTF  = new JTextField(12);
	private JButton ListAllRooms  = new JButton("ListAllRooms");
	private JButton ListAllTypes  = new JButton("ListAllTypes");



	public JDBCMainWindowContent( String aTitle)
	{	
		//setting up the GUI
		super(aTitle, false,false,false,false);
		setEnabled(true);

		initiate_db_conn();
		//add the 'main' panel to the Internal Frame
		content=getContentPane();
		content.setLayout(null);
		content.setBackground(Color.lightGray);
		lineBorder = BorderFactory.createEtchedBorder(15, Color.red, Color.black);

		//setup details panel and add the components to it
		detailsPanel=new JPanel();
		detailsPanel.setLayout(new GridLayout(11,2));
		detailsPanel.setBackground(Color.lightGray);
		detailsPanel.setBorder(BorderFactory.createTitledBorder(lineBorder, "CRUD Actions"));

		detailsPanel.add(IDLabel);			
		detailsPanel.add(IDTF);
		detailsPanel.add(IPAddressLabel);		
		detailsPanel.add(IPAddressTF);
		detailsPanel.add(NameLabel);		
		detailsPanel.add(NameTF);
		detailsPanel.add(TypeLabel);	
		detailsPanel.add(TypeTF);
		detailsPanel.add(RoomLabel);		
		detailsPanel.add(RoomTF);
		detailsPanel.add(FirstConLabel);
		detailsPanel.add(FirstConTF);
		detailsPanel.add(isOnLabel);
		detailsPanel.add(isOnTF);
		detailsPanel.add(RuntimeLabel);
		detailsPanel.add(RuntimeTF);


		//setup details panel and add the components to it
		exportButtonPanel=new JPanel();
		exportButtonPanel.setLayout(new GridLayout(3,2));
		exportButtonPanel.setBackground(Color.lightGray);
		exportButtonPanel.setBorder(BorderFactory.createTitledBorder(lineBorder, "Export Data"));
		exportButtonPanel.add(NumDevices);
		exportButtonPanel.add(NumDevicesTF);
		exportButtonPanel.add(AvgRuntime);
		exportButtonPanel.add(avgRuntimeTF);
		exportButtonPanel.add(ListAllRooms);
		exportButtonPanel.add(ListAllTypes);
		exportButtonPanel.setSize(500, 200);
		exportButtonPanel.setLocation(3, 300);
		content.add(exportButtonPanel);

		insertButton.setSize(100, 30);
		updateButton.setSize(100, 30);
		exportButton.setSize (100, 30);
		deleteButton.setSize (100, 30);
		clearButton.setSize (100, 30);

		insertButton.setLocation(370, 10);
		updateButton.setLocation(370, 110);
		exportButton.setLocation (370, 160);
		deleteButton.setLocation (370, 60);
		clearButton.setLocation (370, 210);

		insertButton.addActionListener(this);
		updateButton.addActionListener(this);
		exportButton.addActionListener(this);
		deleteButton.addActionListener(this);
		clearButton.addActionListener(this);

		this.ListAllRooms.addActionListener(this);
		this.NumDevices.addActionListener(this);
		this.AvgRuntime.addActionListener(this);
		this.ListAllTypes.addActionListener(this);


		content.add(insertButton);
		content.add(updateButton);
		content.add(exportButton);
		content.add(deleteButton);
		content.add(clearButton);


		TableofDBContents.setPreferredScrollableViewportSize(new Dimension(900, 300));

		dbContentsPanel=new JScrollPane(TableofDBContents,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		dbContentsPanel.setBackground(Color.lightGray);
		dbContentsPanel.setBorder(BorderFactory.createTitledBorder(lineBorder,"Database Content"));

		detailsPanel.setSize(360, 300);
		detailsPanel.setLocation(3,0);
		dbContentsPanel.setSize(700, 300);
		dbContentsPanel.setLocation(477, 0);

		content.add(detailsPanel);
		content.add(dbContentsPanel);

		setSize(982,645);
		setVisible(true);

		TableModel.refreshFromDB(stmt);
	}

	public void initiate_db_conn()
	{
		try
		{
			// Load the JConnector Driver
			Class.forName("com.mysql.jdbc.Driver");
			// Specify the DB Name
			String url="jdbc:mysql://localhost:3306/SmartThings?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
			// Connect to DB using DB URL, Username and password
			con = DriverManager.getConnection(url, "root", "admin");
			//Create a generic statement which is passed to the TestInternalFrame1
			stmt = con.createStatement();
		}
		catch(Exception e)
		{
			System.out.println("Error: Failed to connect to database\n"+e.getMessage());
		}
	}

	//event handling 
	public void actionPerformed(ActionEvent e)
	{
		Object target=e.getSource();
		if (target == clearButton)
		{
			IDTF.setText("");
			IPAddressTF.setText("");
			NameTF.setText("");
			TypeTF.setText("");
			RoomTF.setText("");
			FirstConTF.setText("");
			isOnTF.setText("");
			RuntimeTF.setText("");
			

		}
		String updateTemp = "";

		if (target == insertButton)
		{		 
			try
			{
				updateTemp ="INSERT INTO SmartThings VALUES("+
				null +",'"+IPAddressTF.getText()+"','"+NameTF.getText()+"','"+TypeTF.getText()+"','"+RoomTF.getText()+"','"
				+FirstConTF.getText()+"','"+isOnTF.getText()+"','"+RuntimeTF.getText() +"');";

				stmt.executeUpdate(updateTemp);

			}
			catch (SQLException sqle)
			{
				System.err.println("Error with  insert: " + updateTemp +"\n"+sqle.toString());
			}
			finally
			{
				TableModel.refreshFromDB(stmt);
			}
		}
		if (target == deleteButton)
		{

			try
			{
				updateTemp ="DELETE FROM SmartThings WHERE id = "+IDTF.getText()+";"; 
				stmt.executeUpdate(updateTemp);

			}
			catch (SQLException sqle)
			{
				System.err.println("Error with delete:\n"+sqle.toString());
			}
			finally
			{
				TableModel.refreshFromDB(stmt);
			}
		}
		if (target == updateButton)
		{	 	
			try
			{ 			
				updateTemp ="UPDATE SmartThings SET " +
				"Ip = '"+IPAddressTF.getText()+
				"', Name = '"+NameTF.getText()+
				"', Type = '"+TypeTF.getText()+
				"', Room ='"+RoomTF.getText()+
				"', FirstConnected = '"+FirstConTF.getText()+
				"', Is_on = '"+isOnTF.getText()+
				"', Runtime = '"+RuntimeTF.getText()+
				"' where id = "+IDTF.getText();


				stmt.executeUpdate(updateTemp);
				//these lines do nothing but the table updates when we access the db.
				rs = stmt.executeQuery("SELECT * from SmartThings ");
				rs.next();
				rs.close();	
			}
			catch (SQLException sqle){
				System.err.println("Error with  update: " + updateTemp + "\n"+sqle.toString());
			}
			finally{
				TableModel.refreshFromDB(stmt);
			}
		}

		/////////////////////////////////////////////////////////////////////////////////////
		//I have only added functionality of 2 of the button on the lower right of the template
		///////////////////////////////////////////////////////////////////////////////////

		if(target == this.ListAllRooms){

			cmd = "select distinct Room from SmartThings;";

			try{					
				rs= stmt.executeQuery(cmd); 	
				writeToFile(rs);
			}
			catch(Exception e1){e1.printStackTrace();}

		}

		if(target == this.NumDevices){
			String roomName = this.NumDevicesTF.getText();

			cmd = "select Room, count(*) "+  "from SmartThings " + "where Room = '"  + roomName+ "';";

			System.out.println(cmd);
			try{					
				rs= stmt.executeQuery(cmd); 	
				writeToFile(rs);
			}
			catch(Exception e1){e1.printStackTrace();}

		} 
		
		if(target == this.ListAllTypes){

			cmd = "select distinct Type from SmartThings;";

			try{					
				rs= stmt.executeQuery(cmd); 	
				writeToFile(rs);
			}
			catch(Exception e1){e1.printStackTrace();}

		}

		if(target == this.AvgRuntime){
			String roomName = this.avgRuntimeTF.getText();

			cmd = " SELECT Room, SEC_TO_TIME(AVG(TIME_TO_SEC(`Runtime`))) as AvgTime FROM SmartThings where Room =  '"  + roomName + "';";

			System.out.println(cmd);
			try{					
				rs= stmt.executeQuery(cmd); 	
				writeToFile(rs);
			}
			catch(Exception e1){e1.printStackTrace();}
		
		} 

	}
	///////////////////////////////////////////////////////////////////////////

	private void writeToFile(ResultSet rs){
		try{
			System.out.println("In writeToFile");
			FileWriter outputFile = new FileWriter("Nathan.csv");
			PrintWriter printWriter = new PrintWriter(outputFile);
			ResultSetMetaData rsmd = rs.getMetaData();
			int numColumns = rsmd.getColumnCount();

			for(int i=0;i<numColumns;i++){
				printWriter.print(rsmd.getColumnLabel(i+1)+",");
			}
			printWriter.print("\n");
			while(rs.next()){
				for(int i=0;i<numColumns;i++){
					printWriter.print(rs.getString(i+1)+",");
				}
				printWriter.print("\n");
				printWriter.flush();
			}
			printWriter.close();
		}
		catch(Exception e){e.printStackTrace();}
	}
}
