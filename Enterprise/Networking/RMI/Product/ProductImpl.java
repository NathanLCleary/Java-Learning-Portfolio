package RMI.Product;

import java.rmi.RemoteException;

public class ProductImpl implements ProductInterface {

    private String theDescription;
   private String theID; 
   private String theName; 
   private double thePrice;

    
    public ProductImpl(String adescription) throws RemoteException{
        theDescription=adescription;
    }

    
   public ProductImpl (String aID, String aName, double aPrice) 
   { 
        theID = aID; 
        theName = aName; 
        thePrice = aPrice; 

   } 
  @Override
    public String getDescription(){

        return theDescription;
    }

      @Override
    public String getName() 
   { 
        return theName; 
   } 
      @Override
   public String getID() 
   { 
        return theID; 
   }
     @Override
   public double getPrice() 
   { 
        return thePrice; 
   } 
     @Override
   public void setName(String aName) 
   { 
        theName=aName; 
   } 
  @Override
   public void setID(String aID) 
   { 
        theID=aID; 

  } 
     @Override
   public void setPrice(double aPrice) 
   { 
        thePrice=aPrice; 
   } 
}