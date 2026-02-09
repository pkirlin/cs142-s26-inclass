package oop2;

public class DogDemo {
    public static void main(String[] args) {
        // create a new dog object
        Dog fido = new Dog();
        fido.name = "Fido";
        fido.age = 5;
        System.out.println("Fido's age is " + fido.age);
        fido.birthday();
        System.out.println("Fido's age is " + fido.age);

        Dog toto = new Dog();
        toto.name = "Toto";
        toto.age = 3;
        System.out.println("Toto's age is " + toto.age);


    }
}
