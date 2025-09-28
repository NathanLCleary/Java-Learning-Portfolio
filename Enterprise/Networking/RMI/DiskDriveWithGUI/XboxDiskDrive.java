package RMI.DiskDriveWithGUI;

import java.io.*;

public class XboxDiskDrive implements Serializable, DriveInterface {
	private static final long serialVersionUID = 7397842038680177658L;
	private static XboxDiskDrive game=null;
	private String name;
	private int pegiAge;

	public XboxDiskDrive(String name, int pegi_age) {
		this.name = name;
		this.pegiAge = pegi_age;
	}

	public static XboxDiskDrive setInstance(String name, int PEGI_age) {
		if(game == null){
			System.out.println("A game does not exist inside the disk tray. Inserting a disk now");
			game = new XboxDiskDrive(name, PEGI_age);
			serialise();
	    	return game;
	  	}else{
			System.out.println("Sorry a game already exists inside the disk tray. please remove it first before adding a new one");
			return null;
		}
	}

	public void removeInstance(){
		game = null;
	}

	public static void serialise(){
		//Serialize
		try {
			FileOutputStream fileOut = new FileOutputStream("StoredGame.ser");
			ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
			objectOut.writeObject(game);
			objectOut.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}
	public static XboxDiskDrive deserialise() {
		//Deserialize
		XboxDiskDrive newGame = null;
		try {
			FileInputStream fileIn = new FileInputStream("StoredGame.ser");
			ObjectInputStream objectIn = new ObjectInputStream(fileIn);
			newGame = (XboxDiskDrive) objectIn.readObject();
			objectIn.close();

		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return newGame;
	}
	@Override
	public String toString() {
		return "name: " + name + ", pegiAge: " + pegiAge;
	}

	public XboxDiskDrive getGame() {
		return game;
	}

	public void setGame(XboxDiskDrive game) {
		XboxDiskDrive.game = game;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPegiAge() {
		return pegiAge;
	}

	public void setPegiAge(int pegiAge) {
		this.pegiAge = pegiAge;
	}
}

