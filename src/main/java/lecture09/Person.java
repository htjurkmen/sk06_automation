package lecture09;

import java.time.LocalDate;

public class Person {
    private final String name;
    private final String religion;
    private final String language;
    private final String nationality;
    private String sex;
    private String job;
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
        try {
            validateSex(sex);
            this.sex = sex;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void validateSex(String sex) throws Exception {
        String male = "Male";
        String female = "Female";

        if (!sex.equalsIgnoreCase(male) && !sex.equalsIgnoreCase(female)) {
            throw new Exception("Please provide a valid value for sex. Valid options are 'male' or 'female'");
        }
    }

    public void sayHello() {
        System.out.println("Hello!");
    }

    public void celebrateEaster() {
        if (religion.equalsIgnoreCase("orthodox") || religion.equalsIgnoreCase("catholic")) {
            System.out.println("I am celebrating Easter");
        } else {
            System.out.println("I am not celebrating Easter");
        }
    }

    public boolean isAdult() {
        switch (country) {
            case "Bulgaria":
            case "Italy":
                return age >= 18;
            case "USA":
                return age >= 21;
            default:
                throw new RuntimeException("We don't have information about country: " + country);
        }
    }

    public boolean canTakeLoan() {
        return job != null;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
