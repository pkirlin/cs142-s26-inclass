package poly2;

import java.util.ArrayList;

public class MyPets {
    public static void main(String[] args) {
        ArrayList<Pet> mypets = new ArrayList<Pet>();

        mypets.add(new Dog("Fido", 2));
        mypets.add(new ShowDog("Lassie", 5));
        mypets.add(new Cat("Snowball", 3));

        for (Pet p : mypets) {
            System.out.println(p);
            // I want p to speak!

        }
    }
}
