package RMI.Product;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ProductInterface extends Remote {
    String getDescription() throws RemoteException;
    
    String getName() throws RemoteException;
    String getID() throws RemoteException;
    double getPrice()throws RemoteException;
    void setName(String aName) throws RemoteException;

    void setID(String aID) throws RemoteException;
    void setPrice(double aPrice) throws RemoteException;
    
}