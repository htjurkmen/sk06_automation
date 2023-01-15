package lecture09;

public class Bulgarian extends Person {
    public Bulgarian(String name, String sex, String religion, String job, String country, long egn) {
        super(name, sex, religion, "Bulgarian", job, "Bulgarian", country, egn);
    }

    @Override
    public void sayHello() {
        System.out.println("Здравейте!");
    }

    public void danceHoro() {
        System.out.println("Танцувам хоро!");
    }
}
