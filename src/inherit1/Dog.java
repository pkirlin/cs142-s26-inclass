package inherit1;

public class Dog
{
    protected String name;
    private int age;

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
