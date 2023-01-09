package lecture09;

import java.time.LocalDate;

/*
Create class Person which has the following attributes: name, sex, religion, language spoken, job, nationality, EGN, date of birth, age, country of residence.
 */
public class Person {
    private String name;
    private String sex;
    private String religion;
    private String language;
    private String job;
    private String nationality;
    private String birthDate;
    private String country;

    private int age;
    private long egn;

    public Person(String name, String sex, String religion, String language, String job, String nationality, String country, long egn) {
        this.name = name;
        this.sex = sex;
        this.religion = religion;
        this.language = language;
        this.job = job;
        this.nationality = nationality;
        this.country = country;
        this.egn = egn;
        setAge(egn);
        setBirthDate(egn);
    }

    private void setAge(long egn) {
        String birthYear = "19" + Long.toString(egn).substring(0, 2);
        int currentYear = LocalDate.now().getYear();
        this.age = currentYear - Integer.parseInt(birthYear);
    }

    private void setBirthDate(long egn) {
        //ToDo implement me
        this.birthDate = null;
    }
}
