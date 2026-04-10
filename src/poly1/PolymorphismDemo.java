package poly1;

import java.util.ArrayList;

public class PolymorphismDemo {

    public static void main(String[] args) {
        testPolymorphism();
        //dogpark();
    }

    public static void testPolymorphism() {
        // construct a regular dog
        Dog regularDog = new Dog("Fido", 3);

        // construct a showdog
        ShowDog showDog = new ShowDog("Lassie", 4);

        // construct a showdog but store it in a dog reference
        Dog polymorphDog = new ShowDog("Toto", 5);

        // but can't do it the other way:
        //ShowDog cantDoThis = new Dog("Nope", 3);

        // print all the dogs
        System.out.println("here is the dog: " + regularDog);
        System.out.println("here is the showdog: " + showDog);
        System.out.println("here is the polymorphism dog: " + polymorphDog);

        // make all the dogs speak:
        System.out.println("Test speaking:");
        regularDog.speak();
        showDog.speak();
        polymorphDog.speak();

        // Not all the dogs can dance, though:
        System.out.println("Test dancing:");
        //regularDog.dance();
        showDog.dance();
        //polymorphDog.dance();

        // try calling speakTwice:
        System.out.println("Calling speaktwice:");
        //speakTwice(regularDog);

        // try creating a random dog:
        Dog d = createRandomDog();
        System.out.println("Is this a dog or a showdog?  We don't know ahead of time:");
        //d.speak();
        //d.dance();
    }

    // This function takes a Dog object as a parameter, and so also will
    // accept any subclass of Dog as a parameter.
    public static void speakTwice(Dog d) {
        d.speak();
        d.speak();
    }

    // This function returns a Dog object, and may also return any
    // subclass of Dog if it wants to.
    public static Dog createRandomDog() {
        if (Math.random() > .5) {
            return new Dog("Fifi", 6);
        } else {
            return new ShowDog("Fifi", 6);
        }
    }

    public static void dogpark() {
        // create a list of dogs.  I can add dogs or showdogs to this arraylist.
        ArrayList<Dog> listOfDogs = new ArrayList<Dog>();

        String[] namesOfDogs = new String[] { "Pongo", "Perdita", "Patch", "Penny", "Pepper" };
        for (int i = 0; i < 5; i++) {
            Dog d = createRandomDog(); // create a random dog or showdog...
            d.setName(namesOfDogs[i]);
            listOfDogs.add(d);  // and add to the list
        }

        System.out.println("Dogs at the dog park:");
        for (Dog d : listOfDogs) {
            System.out.println(d);  // notice how this calls the correct toString() for dogs and showdogs.
            d.speak();
            //d.dance();
        }

        // What if there is a stuck up showdog that will only play with other showdogs?
        ShowDog stuckUpDog = new ShowDog("Fluffy", 3);

        for (Dog d : listOfDogs) {
            stuckUpDog.chase(d);
        }
    }
}
