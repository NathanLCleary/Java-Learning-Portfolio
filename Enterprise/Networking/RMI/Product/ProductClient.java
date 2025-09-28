package RMI.Product;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ProductClient {

    public static void main(String[] args) {
        String url = "rmi:///";
        System.out.println("Client has started");
        String host = (args.length < 1) ? null : args[0];
        try {
            Registry registry = LocateRegistry.getRegistry("localhost",1098);
            ProductInterface p00000011 = (ProductInterface) registry.lookup(url+"product11");
            ProductInterface p00000012 = (ProductInterface) registry.lookup(url+"product12");
            ProductInterface p00000013 = (ProductInterface) registry.lookup(url+"product13");
            
            System.out.println( " Product ID: " + 
               p00000011.getID() + " Name:"+ 
               p00000011.getName()+ " Price :" +
                p00000011.getPrice() ); 
            System.out.println( " Product ID: " + 
               p00000012.getID() + " Name:" + 
               p00000012.getName()+ " Price :" +
               p00000012.getPrice()); 
            System.out.println( " Product ID: " + 
               p00000013.getID() + " Name:" + 
               p00000013.getName()+ " Price :" +
                p00000013.getPrice() ); 

            
            
            
           // System.out.println("response: " + response);
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}