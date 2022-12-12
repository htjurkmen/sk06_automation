package lecture08.examples.inheritance;

public class Example {
    public static void main(String[] args) {
        Car car = new Car("Toyota", "Rav4", 4.4, 1.5, 2, 4);
        car.closeOpenDoor();
        car.honk();
    }
}
