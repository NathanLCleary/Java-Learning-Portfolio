package lambdas;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

interface Printable<T> {

    void print(T t);// a functional interface i.e. it has only one abstract method 
}

interface Retrievable<T> {

    T retrieve();
}

interface Evaluate<T> {

    Boolean checkIfNegative(T t);
}

interface Functionable<T, R> {

    R applyThis(T t);
}

public class BasicLambdasCopy {

    public static void main(String[] args) {
        BasicLambdas bl = new BasicLambdas();
//        bl.consumer();
//        bl.supplier();
//        bl.predicate();
//        bl.function();

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
        anonInnerRef.print("Pre Java 8: anonymous inner class version");

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

    }

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
}
