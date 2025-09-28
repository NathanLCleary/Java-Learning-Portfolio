package RMI.Product;

import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
    
public class ProductServer extends ProductImpl {
    
        public ProductServer(String aDescription) throws RemoteException {
            super(aDescription);
        }
    
        public ProductServer(String aID, String aName, double aPrice) throws RemoteException {
            super(aID,aName,aPrice);
        }
       
        public  static void main(String args[]) {
            System.out.println("src.Server running");
            try {
                ProductImpl obj = new ProductImpl("This is a car");
                ProductInterface stub = (ProductInterface) UnicastRemoteObject.exportObject(obj, 0);
                
                ProductImpl p0000011 = new ProductImpl ("p0000011", "Banana", 0.35);  
                ProductImpl p0000012 = new ProductImpl ("p0000012", "Orange", 0.50);  
                ProductImpl p0000013 = new ProductImpl ("p0000013", "Apple", 0.45);  

                
                ProductInterface stub11 = (ProductInterface) UnicastRemoteObject.exportObject(p0000011, 0);
                ProductInterface stub12 = (ProductInterface) UnicastRemoteObject.exportObject(p0000012, 0);
                ProductInterface stub13 = (ProductInterface) UnicastRemoteObject.exportObject(p0000013, 0);
 
                // Bind the remote object's stub in the registry
                Registry registry = LocateRegistry.createRegistry(1098);
                registry.bind("rmi:///product", stub);
                registry.bind("rmi:///product11", stub11);
                registry.bind("rmi:///product12", stub12);
                registry.bind("rmi:///product13", stub13);
    

            } catch (Exception e) {
                System.err.println("src.Server exception: " + e.toString());
                e.printStackTrace();
            }
        }
    }