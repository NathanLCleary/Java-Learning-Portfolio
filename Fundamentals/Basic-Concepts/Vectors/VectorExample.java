package BasicJava.Vectors;

import java.util.Vector;

public class VectorExample {
    public static void main(String[] args) {
        Vector v = new Vector(5);
        Vector s = new Vector(5);
        for(int i = 0; i < 11; i++){
            v.add(i);
        }
        System.out.println("Vector elements: " + v);
        System.out.println("Vector size: " + v.size());
        System.out.println("Vector Capicity: " +v.capacity());

        s.add("Mary");
        s.add(10);
        s.add(7.3);
        //Vectors can have different data types, arrays canno

        System.out.println(s.elementAt(2));
        System.out.println(s.firstElement());
        System.out.println(s.lastElement());
    }
}
