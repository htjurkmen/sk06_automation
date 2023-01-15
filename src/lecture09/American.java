package lecture09;

public class American extends Person {
    public American(String name, String sex, String religion, String job, String country, long egn) {
        super(name, sex, religion, "English", job, "American", country, egn);
    }

    public void celebrateThanksgiving() {
        System.out.println("I am celebrating Thanksgiving on the fourth Tuesday in November");
    }
}
