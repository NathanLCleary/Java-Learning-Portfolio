package BasicJava.Serialization;

import java.io.*;
import java.util.ArrayList;

public class Main{
    public static ArrayList<Phone> phoneArray = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        Phone p1 = new Phone("Sony","Experia X",32,	12.5,4.6,"Yes",150);
        Phone p2 = new Phone("Sony","Experia Z",64,	14.2,5.6,"Yes",175);
        Phone p3 = new Phone("Samsung","Galaxy M",	64,14.5,5.4,"Yes",180);
        Phone p4 = new Phone("Nokia",	"3330",16,13.2,2.3,"No",90 );
        Phone p5 = new Phone("Motorola",	"M1",	8,11.3,4.9,"Yes",	100);
        Phone p6 = new Phone("IPhone",	"6",32,13.5,6.4,"Yes",	250);
        Phone p7 = new Phone("Alcatel","A3",8,9.3,2.4,"No", 50);

        // serialize
        try{
            FileOutputStream fileOut = new FileOutputStream("phones.ser");
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(p1);
            objectOut.writeObject(p2);
            objectOut.writeObject(p3);
            objectOut.writeObject(p4);
            objectOut.writeObject(p5);
            objectOut.writeObject(p6);
            objectOut.writeObject(p7);
            objectOut.close();
            System.out.println("object serialized");
        } catch (IOException e){
            e.printStackTrace();
        }

        phoneArray = deserialize();

        for (Phone p : phoneArray) {
            System.out.println("make: " + p.getMake());
            if(p.getMake().equals("Alcatel")){
                phoneArray.remove(p);
                System.out.println("Object Alcatel removed");
            }
        }
        phoneArray.add(new Phone("iPhone", "11", 64,15.2, 7.4,"Yes", 1000));
    }

    public static ArrayList<Phone> deserialize() throws IOException {
        // deserialize
        ArrayList<Phone> dePhone = new ArrayList<>();
        try{
            FileInputStream fileIn = new FileInputStream("phones.ser");
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);


            for(int i = 0; i < 6; i++) {
                dePhone.add((Phone) objectIn.readObject());
            }

            objectIn.close();
            System.out.println("object deserialized");


            System.out.println("Created a new phone and added to arrayList");
        }catch (FileNotFoundException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return dePhone;
    }
}
