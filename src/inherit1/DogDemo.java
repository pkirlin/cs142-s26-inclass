package inherit1;

public class DogDemo {
    public static void main(String[] args) {
        Dog fido = new Dog("Fido", 2);
        //fido.setName("Fido");
        //fido.setAge(2);

        Dog toto = new Dog("Toto", 3);
        //toto.setName("Toto");
        //toto.setAge(3);

        System.out.println(fido);
        System.out.println(toto);

        ShowDog showdog = new ShowDog("Lassie", 5);
        //showdog.setName("Lassie");
        //showdog.setAge(5);
        System.out.println(showdog);

        showdog.rollover();
        showdog.rollover();
        //toto.rollover();  won't work because toto is a "regular" dog

        toto.speak();
        //showdog.speak();
        showdog.speak();

    }
}
