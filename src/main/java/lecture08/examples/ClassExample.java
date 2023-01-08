package lecture08.examples;

public class ClassExample {
    int x = 5;
    int y = 9;
    final int z = 10;

    public static void printHello() {
        System.out.println("Hello. This method can be called WITHOUT creating object of class ClassExample");
    }

    public void printHelloOfObject() {
        System.out.println("Hello. This method can be called only if you create an object of class ClassExample");
        System.out.println("Non-static variables as x can be accessed ONLY by non-static (object) methods");
        System.out.println("The value of x is: " + this.x + " The value of x is accessed by method printHelloOfObject.");
    }

}
