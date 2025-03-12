package csie.ase.ro.seminar3.main;

import csie.ase.ro.seminar3.classes.Car;
import csie.ase.ro.seminar3.classes.Vehicle;

public class Main {
    public static void main(String[] args) {
        // Vehicle v = new Vehicle("BMW", 5);
        // System.out.println(v);
//
//        Car c = new Car(v.getManufacturer(), v.getNoSeats(), "black", 2.0f);
//        System.out.println(c);
//
//        Vehicle v2 = new Car();
//        v2.startEngine();

        Car car = new Car();
        car.honk();
        car.open();
        car.drive();
    }
}
