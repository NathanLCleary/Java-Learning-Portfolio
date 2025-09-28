package RMI.DiskDriveWithGUI;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server {
    public DriveServer(String aDescription) throws RemoteException {
        super(aDescription);
    }

    public DriveServer(String aID, String aName, double aPrice) throws RemoteException {
        super(aID,aName,aPrice);
    }

    public  static void main(String args[]) {
        System.out.println("src.Server running");
        try {
            XboxDiskDrive obj = new XboxDiskDrive("This is a car");
            DriveInterface stub = (DriveInterface) UnicastRemoteObject.exportObject(obj, 0);

            XboxDiskDrive p0000011 = new XboxDiskDrive ("p0000011", "Banana", 0.35);
            XboxDiskDrive p0000012 = new XboxDiskDrive ("p0000012", "Orange", 0.50);
            XboxDiskDrive p0000013 = new XboxDiskDrive ("p0000013", "Apple", 0.45);


            DriveInterface stub11 = (DriveInterface) UnicastRemoteObject.exportObject(p0000011, 0);
            DriveInterface stub12 = (DriveInterface) UnicastRemoteObject.exportObject(p0000012, 0);
            DriveInterface stub13 = (DriveInterface) UnicastRemoteObject.exportObject(p0000013, 0);

            // Bind the remote object's stub in the registry
            Registry registry = LocateRegistry.createRegistry(1098);
            registry.bind("rmi:///Drive", stub);
            registry.bind("rmi:///Drive11", stub11);
            registry.bind("rmi:///Drive12", stub12);
            registry.bind("rmi:///Drive13", stub13);


        } catch (Exception e) {
            System.err.println("src.Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
}
