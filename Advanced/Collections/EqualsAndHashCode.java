package genericsAndCollections;

import java.util.HashMap;
import java.util.Map;

class Dog{
    private int age;
    private String name;

    Dog(int age, String name) {
        this.age = age;
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public String getName() {
        return name;
    }
    @Override
    public String toString() {
        return "Dog{" + "age=" + age + ", name=" + name + '}';
    }
    @Override
    public int hashCode() {
        int hash = this.age + this.name.length();
        return hash;
    }
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Dog){
            Dog otherDog = (Dog)obj;
            if(this.age == otherDog.getAge() && 
                    this.name.equalsIgnoreCase(otherDog.getName())){
                return true;
            }
        }
        return false;
    }
}
class Cat{
    private int age;
    private String name;

    Cat(int age, String name) {
        this.age = age;
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public String getName() {
        return name;
    }
    @Override
    public String toString() {
        return "Cat{" + "age=" + age + ", name=" + name + '}';
    }
//    @Override
//    public int hashCode() {
//        int hash = this.age + this.name.length();
//        return hash;
//    }
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Cat){
            Cat otherCat = (Cat)obj;
            if(this.age == otherCat.getAge() && 
                    this.name.equalsIgnoreCase(otherCat.getName())){
                return true;
            }
        }
        return false;
    }
}

public class EqualsAndHashCode {
    public static void main(String[] args) {
        // Dog has overriden hashCode()
        Dog spot1 = new Dog(2, "Spot");
        Map<Dog, String> dogBreeds = new HashMap<>();
        dogBreeds.put(spot1, "Alsatian");
        // later on...
        Dog spot2 = new Dog(2, "Spot");
        System.out.println(dogBreeds.get(spot2));// Alsatian
        
        
        // Cat has NOT overriden hashCode()
        // Object::hashCode() returns a unique integer hashcode
        Cat kitty1 = new Cat(2, "Kitty");
        Map<Cat, String> catBreeds = new HashMap<>();
        catBreeds.put(kitty1, "Persian");
        // later on...
        Cat kitty2 = new Cat(2, "Kitty");
        System.out.println(catBreeds.get(kitty2));// null
        // same name and same age but it does not matter as we are 
        // looking in the wrong bucket!
        System.out.println("kitty1 hashcode == "+kitty1.hashCode());
        System.out.println("kitty2 hashcode == "+kitty2.hashCode());
    }
}
