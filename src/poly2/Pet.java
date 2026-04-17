package poly2;

public abstract class Pet {

    private String name;
    private int age;

    public Pet(String newName, int newAge) {
        System.out.println("Constructing a pet object.");
        name = newName;
        age = newAge;
    }

    public abstract void speak();
    // 1. all pets have the ability to speak, but
    // this concept is so ABSTRACT that we can't specify how it
    // works here (in Pet).
    // 2. Each subclass of Pet MUST OVERRIDE this method.

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
        return "Pet object: name=" + name + " age=" + age;
    }
}
