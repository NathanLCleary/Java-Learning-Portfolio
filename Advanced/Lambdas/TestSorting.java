package lambdas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TestSorting {
    public static void main(String[] args) {
        List<Person> listPeople = getPeople();

//        sortAge(listPeople); // pre Java 8
//        sortName(listPeople); // pre Java 8
//        sortHeight(listPeople); // pre Java 8

//        sortAgeUsingLambdas(listPeople); // Java 8
//        sortNameUsingLambdas(listPeople); // Java 8
        sortHeightUsingLambdas(listPeople); // Java 8
    }
    private static void sortHeight(List<Person> listPeople) {
        System.out.println("Before Sort");
        for (Person p : listPeople) {
            System.out.println(p);
        }

        //sort by height
        Collections.sort(listPeople, new Comparator<Person>() {
            @Override
            public int compare(Person p1, Person p2) {
                // need wrapper here - otherwise an "if-else" required
                return p1.getHeight().compareTo(p2.getHeight());
            }
        });

        System.out.println("After Sort");
        for (Person p : listPeople) {
            System.out.println(p);
        }        
    }
    private static void sortAge(List<Person> listPeople) {
        System.out.println("Before Sort");
        for (Person p : listPeople) {
            System.out.println(p);
        }

        //sort by age
        Collections.sort(listPeople, new Comparator<Person>() {
            @Override
            public int compare(Person p1, Person p2) {
                // if I dont use wrappers then its "p1.getAge()-p2.getAge()"
                return p1.getAge().compareTo(p2.getAge());
            }
        });

        System.out.println("After Sort");
        for (Person p : listPeople) {
            System.out.println(p);
        }        
    }
    private static void sortName(List<Person> listPeople) {
        System.out.println("Before Sort");
        for (Person p : listPeople) {
            System.out.println(p);
        }

        //sort by name
        Collections.sort(listPeople, new Comparator<Person>() {
            @Override
            public int compare(Person p1, Person p2) {
                return p1.getName().compareTo(p2.getName());
            }
        });

        System.out.println("After Sort");
        for (Person p : listPeople) {
            System.out.println(p);
        }        
    }

    private static List<Person> getPeople() {
        List<Person> result = new ArrayList<Person>();

        result.add(new Person("Mike", 33, 1.8));
        result.add(new Person("Mary", 25, 1.4));
        result.add(new Person("Alan", 34, 1.7));
        result.add(new Person("Zoe", 30, 1.5));

        return result;

    }
    private static void sortAgeUsingLambdas(List<Person> listPeople) {
        System.out.println("Before Sort");
        for (Person p : listPeople) {
            System.out.println(p);
        }

        //sort by age
        // Note: In Java 8, the List interface supports the sort method directly, 
        //       so no need to use Collections.sort anymore.
        // This works.
//        listPeople.sort(new Comparator<Person>() {
//            @Override
//            public int compare(Person p1, Person p2) {
//                // if I dont use wrappers then its "p1.getAge()-p2.getAge()"
//                return p1.getAge().compareTo(p2.getAge());
//            }
//        });

        // lambda expression
//        listPeople.sort((p1, p2)->p1.getAge()-p2.getAge());// works, unboxing
        listPeople.sort( (p1, p2) -> p1.getAge().compareTo( p2.getAge() ) );
        
        System.out.println("After Sort");
        for (Person p : listPeople) {
            System.out.println(p);
        }        
    }
    private static void sortHeightUsingLambdas(List<Person> listPeople) {
        System.out.println("Before Sort");
        for (Person p : listPeople) {
            System.out.println(p);
        }

        //sort by height
        // Note: In Java 8, the List interface supports the sort method directly, 
        //       so no need to use Collections.sort anymore.
        // This works.
        listPeople.sort(new Comparator<Person>() {
            @Override
            public int compare(Person p1, Person p2) {
                // need wrapper here i.e. compareTo() - otherwise an "if-else" required
                return p1.getHeight().compareTo(p2.getHeight());
            }
        });

        // lambda expression
        // need wrapper here i.e. compareTo() - otherwise an "if-else" required
        listPeople.sort( (p1, p2) -> p1.getHeight().compareTo(p2.getHeight()) );
        
        System.out.println("After Sort");
        for (Person p : listPeople) {
            System.out.println(p);
        }        
    }
    private static void sortNameUsingLambdas(List<Person> listPeople) {
        System.out.println("Before Sort");
        for (Person p : listPeople) {
            System.out.println(p);
        }

        //sort by name
        // Note: In Java 8, the List interface supports the sort method directly, 
        //       so no need to use Collections.sort anymore.
        // This works.
//        listPeople.sort( new Comparator<Person>() {
//            @Override
//            public int compare(Person p1, Person p2) {
//                return p1.getName().compareTo(p2.getName());
//            }
//        });

        // lambda expression
        listPeople.sort( (p1, p2) -> p1.getName().compareTo( p2.getName() ) );
        
        System.out.println("After Sort");
        for (Person p : listPeople) {
            System.out.println(p);
        }        
    }

}

