package lecture09;

import java.util.List;

public class Italian extends Person {
    public Italian(String name, String sex, String religion, String job, String country, long id) {
        super(name, sex, religion, "Italian", job, "Italian", country, id);
    }

    @Override
    public void sayHello() {
        System.out.println("Ciao!");
    }

    public void makePizza(List<String> ingredients) {
        System.out.println("I am making a pizza with the following ingredients: " + ingredients);
    }
}
