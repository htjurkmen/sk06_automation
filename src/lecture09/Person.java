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
        this.religion = religion;
        this.language = language;
        this.job = job;
        this.nationality = nationality;
        this.country = country;
        setSex(sex);
        setEgn(egn);
        setAge(egn);
        setBirthDate(egn);
    }

    private void setAge(long egn) {
        String birthYear = "19" + Long.toString(egn).substring(0, 2);
        int currentYear = LocalDate.now().getYear();
        this.age = currentYear - Integer.parseInt(birthYear);
    }

    private void setBirthDate(long egn) {
        String date = Long.toString(egn).substring(4, 6);
        String month = Long.toString(egn).substring(2, 4);
        this.birthDate = month + "-" + date;
    }

    private void setEgn(long egn) {
        int engLength = Long.toString(egn).length();
        if (engLength == 10) {
            this.egn = egn;
        } else {
            throw new RuntimeException("The provided EGN is not valid! The EGN must contain only 10 digits!");
        }
    }

    private void setSex(String sex) {
        String male = "Male";
        String female = "Female";

        if (sex.equalsIgnoreCase(male) || sex.equalsIgnoreCase(female)) {
            this.sex = sex;
        }
        //ToDo Implement me
    }
}
