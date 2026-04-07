package inherit1;

public class ShowDog extends Dog {

    private int numTrophies;

    public void rollover() {
        System.out.println(name + " rolls over");
        numTrophies++;
        System.out.println(name + " has won " + numTrophies + " trophies");
    }

    public void speak(boolean choice) {
        if (choice == true) {
            System.out.println(name + " says woof woof in French");
        }
        else {
            super.speak();
        }
    }

}
