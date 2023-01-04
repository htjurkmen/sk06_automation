package lecture08.examples;

import lecture08.examples.ClassExample;

public class Examples {
    public static void main(String[] args) {
        testClassMethods();
    }

    static void testObjectCreation() {
        ClassExample myObject = new ClassExample();
        System.out.println(myObject.x);
    }

    static void testModifyClassAttributes() {
        ClassExample myObject = new ClassExample();
        myObject.x = 30;
        System.out.println(myObject.x);

        ClassExample myObject2 = new ClassExample();

        myObject2.x = 20;
        System.out.println(myObject2.x);

        ClassExample myObject3 = new ClassExample();
        System.out.println(myObject3.x);
    }

    static void testFinalAttribute() {
        ClassExample myObject = new ClassExample();
        //myObject.z = 30; //this is not allowed
        System.out.println(myObject.z);
    }

    static void testClassMethods() {
        ClassExample.printHello();
        ClassExample myObject = new ClassExample();
        myObject.printHelloOfObject();
    }
}
