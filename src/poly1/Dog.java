package poly1;

public class Dog {
    private String name;
    private int age;

    public Dog(String newName, int newAge) {
        System.out.println("Constructing a dog object.");
        name = newName;
        age = newAge;
    }

    public void speak() {
        System.out.println(name + " says woof woof!");
    }

    public void chase(Dog otherdog) {
        System.out.println(name + " chases " + otherdog.name);
    }

    public String getName() {
        return name;
    }

    public void setName(String newName) {
        name = newName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int newAge) {
        if (newAge >= 0) {
            age = newAge;
        }
    }

    public String toString() {
        return "Dog object: name=" + name + " age=" + age;
    }
};
