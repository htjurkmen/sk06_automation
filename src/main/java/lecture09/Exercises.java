package lecture09;

import java.util.Arrays;

public class Exercises {
    public static void main(String[] args) {
        Person person = new Person("Dimitar", "male", "orthodox", "Bulgarian", "Artist", "Bulgarian", "Bulgaria", 8103245060L);
        Italian italian = new Italian("Francesco", "male", "catholic", "Chef", "Italy", 7605108945L);
        Bulgarian bulgarian = new Bulgarian("Ivanka", "female", "orthodox", "Manager", "Bulgaria", 9112239583L);
        American american = new American("John", "male", "catholic", "CEO", "USA", 6811125584L);
        Child child = new Child("Ivancho", "male", "orthodox", "Bulgarian", "Bulgaria", "Bulgaria", 9912239583L);

        //Common actions
        executePersonActions(person);
        executePersonActions(italian);
        executePersonActions(bulgarian);
        executePersonActions(american);
        executePersonActions(child);

        //Individual actions
        italian.makePizza(Arrays.asList("Cheese", "Mushrooms", "Olives"));
        bulgarian.danceHoro();
        american.celebrateThanksgiving();
        child.play("Ball");
    }

    private static void executePersonActions(Person person) {
        System.out.println("Execute actions for class " + person.getClass().getSimpleName());
        person.celebrateEaster();
        person.sayHello();
        person.canTakeLoan();
        person.isAdult();
    }
}
