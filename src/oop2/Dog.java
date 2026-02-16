package oop2;

public class Dog {
    // fields or instance variables
    private String name;
    private int age;
    private int energy;

    public Dog() {
        age = 1;
        name = "My dog";
    }

    public Dog(String newName, int newAge) {
        name = newName;
        age = newAge;
    }

    // methods
    public void birthday() {
        age++;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age >= 0) {
            this.age = age;
        }
    }

    public void setName(String newName) {
        name = newName;
    }

    public String toString() {
        // return a String!
        return "name of dog is " + name + " and age of dog is " + age;
    }

}
