package oop2;

public class DogDemo {
    public static void main(String[] args) {
        // create a new dog object
        Dog fido = new Dog("Fido", 3);
        //fido.setName("Fido");
        //fido.setAge(11);
        System.out.println("Fido's age is " + fido.getAge());
        fido.birthday();
        System.out.println("Fido's age is " + fido.getAge());

        Dog toto = new Dog();
        toto.setName("Toto");
        //toto.age = 3;
        System.out.println("Toto's age is " + toto.getAge());
        System.out.println(toto);
        System.out.println(fido);
    }
}
