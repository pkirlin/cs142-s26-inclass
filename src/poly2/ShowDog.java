package poly2;

public class ShowDog extends Dog {
    private int numTrophies;

    public ShowDog(String newName, int newAge) {
        super(newName, newAge);
        System.out.println("Constructing a showdog object.");
    }

    public int getNumTrophies() {
        return numTrophies;
    }

    public void setNumTrophies(int numTrophies) {
        this.numTrophies = numTrophies;
    }

    public void dance() {
        System.out.println(getName() + " is dancing!");
    }

    public String toString() {
        return "Showdog object: name=" + getName() + " age=" + getAge()
                + " trophies=" + numTrophies;
    }

    public void speak() {
        super.speak();
        System.out.println("   and " + getName() + " also says woof woof in French.");
    }
}
