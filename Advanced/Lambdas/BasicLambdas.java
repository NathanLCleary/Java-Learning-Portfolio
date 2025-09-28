package lambdas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class BasicLambdas {

    public static void main(String[] args) {
//        BasicLambdas bl = new BasicLambdas();
//        bl.consumer();
//        bl.supplier();
//        bl.predicate();
//        bl.function();
        List<Person> listPeople = getPeople();

//        sortAge(listPeople); // pre Java 8
//        sortName(listPeople); // pre Java 8
//        sortHeight(listPeople); // pre Java 8

        sortAgeUsingLambdas(listPeople); // Java 8
        sortNameUsingLambdas(listPeople); // Java 8
        sortHeightUsingLambdas(listPeople); // Java 8

    }
    public void consumer() {
        // pre-Java 8 - anonymous inner class version
        // Output: Pre Java 8: anonymous inner class version
        Printable<String> anonInnerRef = new Printable<String>() {
            @Override
            public void print(String s) {
                System.out.println(s);
            }
        };
        anonInnerRef.print("Pre Java 8: anonymous inner "
                + "class version");

        // Java 8 - Lambda expression
        // Output: Java 8 : Lambda version
        Printable<String> lambda = s -> System.out.println(s);
        lambda.print("Java 8 : Lambda version");

        // Java 8 - Consumer and Method References versions
        // Output: Java 8 : Consumer version
        // Output: Java 8 : Consumer method ref version
        Consumer<String> consumer = s -> System.out.println(s);
        consumer.accept("Java 8 : Consumer version");

        Consumer<String> consumerMR = System.out::println; // method reference
        consumerMR.accept("Java 8 : Consumer method ref version");

    }

    public void supplier() {
        // pre-Java 8 - anonymous inner class version
        // Output: Pre Java 8: 77
        Retrievable<Integer> anonInnerRef = new Retrievable<Integer>() {
            @Override
            public Integer retrieve() {
                return 77;
            }
        };
        System.out.println("Pre Java 8: " + anonInnerRef.retrieve());

        // Java 8 - Lambda expression
        // Output: Java 8: 77
        Retrievable<Integer> lambda = () -> 77;
        System.out.println("Java 8: " + lambda.retrieve());

        // Java 8 - Supplier version
        // Java 8 Supplier: 77
        Supplier<Integer> supplier = () -> 77;
        System.out.println("Java 8 Supplier: " + supplier.get());

    }
    
    
    
 // **************************************** //
    
    
    
    
    
    
    
    
    public void predicate() {
        // pre-Java 8 - anonymous inner class version
        // Output: Pre Java 8: true
        // Output: Pre Java 8: false
        Evaluate<Integer> anonInnerRef = new Evaluate<Integer>() {
            @Override
            public Boolean checkIfNegative(Integer i) {
                return i < 0;
            }
        };
        System.out.println("Pre Java 8: " + anonInnerRef.checkIfNegative(-1));
        System.out.println("Pre Java 8: " + anonInnerRef.checkIfNegative(+1));

        // Java 8 - Lambda expression
        // Output: Java 8: true
        // Output: Java 8: false
        Evaluate<Integer> lambda = (i) -> i < 0;
        System.out.println("Java 8: " + lambda.checkIfNegative(-1));
        System.out.println("Java 8: " + lambda.checkIfNegative(+1));

        // Java 8 - Predicate version
        // Java 8 Predicate: true
        // Java 8 Predicate: false
        Predicate<Integer> predicate = (i) -> i < 0;
        System.out.println("Java 8 Predicate: " + predicate.test(-1));
        System.out.println("Java 8 Predicate: " + predicate.test(+1));

        
        System.out.println(check(4, n -> n % 2 == 0));
        System.out.println(check(7, n -> n % 2 == 0));

        System.out.println(check("Mr. Joe Bloggs", 
                s -> s.startsWith("Mr.") ));
        System.out.println(check("Ms. Ann Bloggs", 
                s -> s.startsWith("Mr.") ));
        
    }

    
    
    // **************************************** //
    
    
//                            check(4,    n -> n % 2 == 0)
    public static <T> boolean check(T t, Predicate<T> lambda){
        return lambda.test(t);
    }
    
    // **************************************** //
    
    
    public void function() {
        // pre-Java 8 - anonymous inner class version
        // Output: Pre Java 8: Number applied is: 24
        Functionable<Integer, String> anonInnerRef = new Functionable<Integer, String>() {
            @Override
            public String applyThis(Integer i) {
                return "Number applied is: " + i;
            }
        };
        System.out.println("Pre Java 8: " + anonInnerRef.applyThis(24));

        // Java 8 - Lambda expression
        // Output: Java 8: Number applied is: 25
        Functionable<Integer, String> lambda
                = (i) -> {
                    return "Number applied is: " + i;
                };   // R applyThis(T t)
        System.out.println("Java 8: " + lambda.applyThis(25));

        // Java 8 - Function version
        // Java 8 Function: Number applied is: 26
        Function<Integer, String> function
                = (i) -> {
                    return "Number applied is: " + i;
                };   // R apply(T t)
        System.out.println("Java 8 Function: " + function.apply(26));

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

class Person {

    private Integer age;
    private String name;
    private Double height;

    public Person(String name, Integer age, Double height) {
        this.age = age;
        this.name = name;
        this.height = height;
    }

    @Override
    public String toString() {
        return "Person{" + "age=" + age + ", name=" + name + ", height=" + height + '}';
    }

    public Double getHeight() {
        return height;
    }

    public Integer getAge() {
        return age;
    }

    public String getName() {
        return name;
    }
}