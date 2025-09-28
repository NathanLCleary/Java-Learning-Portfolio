public class PersonTest {
    public static void main(String[] args) {
        Person a = new Person("Michael", "Doe", "Athlone", 14022000, "0874945923", 'M' );
        a.printMethod();

        System.out.println();

        Lecturer b = new Lecturer("John", "Doe", "Athlone", 14022000, "0874945923", 'M',  5, "Engineering");
        b.printMethod();

        System.out.println();

        Student c = new Student("Mary", "Cunningham", "Athlone", 12081980, "0874563404", 'F', 273286, 3);
        c.printMethod();
    }
}
