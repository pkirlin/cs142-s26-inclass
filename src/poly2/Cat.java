package poly2;

public class Cat extends Pet {
    public Cat(String newName, int newAge) {
        super(newName, newAge);
        System.out.println("Constructing a cat object.");
    }

    public void speak() {
        System.out.println(getName() + " says meow meow!");
    }

    public String toString() {
        return "Cat object: name=" + getName() + " age=" + getAge();
    }
};
