package RMI.DiskDriveWithGUI;

import java.rmi.Remote;

public interface DriveInterface extends Remote {

    @Override
    public String toString();

    public XboxDiskDrive getGame();

    public void setGame(XboxDiskDrive game);

    public String getName();

    public void setName(String name);

    public int getPegiAge();

    public void setPegiAge(int pegiAge);

}
