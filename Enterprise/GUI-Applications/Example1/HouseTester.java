package JavaGui.Example1;

public class HouseTester {
    public static void main(String[] args) {
        House h1 = new House(5,2,"Smith");
        House h2 = new House(3,1,"Jones");

        House h3 = new House();
        h3.setOwner("Burke");
        h3.setRoom(4);
        h3.setBathroom(1);

        h1.printDetails();
        h2.printDetails();
        h3.printDetails();

    }
}
