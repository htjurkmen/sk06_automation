package lecture07.constructors.vehicle;

public class Car extends Vehicle {
    private String brand;

    public Car(String regNo, String brand) {
        super(regNo);
        this.brand = brand;
    }
}
