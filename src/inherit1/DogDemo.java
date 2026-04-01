package inherit1;

public class DogDemo {
    public static void main(String[] args) {
        Dog fido = new Dog();
        fido.setName("Fido");
        fido.setAge(2);

        Dog toto = new Dog();
        toto.setName("Toto");
        toto.setAge(3);

        System.out.println(fido);
        System.out.println(toto);

        ShowDog showdog = new ShowDog();
        showdog.setName("Lassie");
        showdog.setAge(5);
        System.out.println(showdog);
    }
}
