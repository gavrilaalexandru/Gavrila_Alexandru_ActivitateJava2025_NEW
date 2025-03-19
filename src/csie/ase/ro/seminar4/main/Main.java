package csie.ase.ro.seminar4.main;

import csie.ase.ro.seminar4.classes.Car;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {

    public final static int QUANTUM = 105;

    public static void main(String[] args) {
        Car car = new Car("Ford", 2.1f, "black", 5);
        System.out.println(car);

        System.out.println("Tax computed based on engine capacity " + car.computeTax(QUANTUM, car.getCapacity()));
        System.out.println("Tax computed based on noSeats capacity " + car.computeTax(QUANTUM, car.getNoSeats()));

        try {
            Car car2 = (Car)car.clone();
            car2.setColor("blue");
            System.out.println(car2);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        List<Integer> list = new ArrayList<Integer>();
        list.add(3);
        list.add(4);
        list.add(10);

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        list.add(1, 7);

        for (Integer i : list) {
            System.out.printf("%d ", i);
        }

        list.remove(0);
        System.out.println("\n");

        for (Iterator<Integer> it = list.iterator(); it.hasNext();) {
            System.out.println(it.next()); // .next afiseaza elementul curent
        }

        Car car3 = new Car();
        List<Car> cars = new ArrayList<Car>();
        cars.add(car);
        cars.add(car3);

        for(Car c : cars) {
            System.out.println(c);
        }
    }
}
