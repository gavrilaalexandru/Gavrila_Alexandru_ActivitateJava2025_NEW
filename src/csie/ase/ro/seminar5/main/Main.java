package csie.ase.ro.seminar5.main;

import csie.ase.ro.seminar5.classes.Car;
import org.jetbrains.annotations.NotNull;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Car car1 = new Car("red", "BMW", 4440);
        Car car2 = new Car("blue", "BMW", 2000);
        Car car3 = new Car("gray", "MERCEDES", 3000);

        // System.out.println(car1);
        System.out.println("List:");
        List<Car> carList = new ArrayList<Car>();
        carList.add(car3);
        carList.add(car2);
        carList.add(car1);
        // carList.add(car1);

        for (Car c : carList) {
            System.out.println(c);
        }
        System.out.println("Set:");
        Set<Car> carSet = new TreeSet<Car>();
        carSet.add(car3);
        carSet.add(car2);
        carSet.add(car1);
        // carSet.add(car1); nu putem avea obiecte duplicate

        for (Car c : carSet) {
            System.out.println(c);
        }

        System.out.println("Map:");
        Map<Car, Integer> map = new HashMap<Car, Integer>(); // cheia este definita ca un set pt. a fi unica
        // Manufacturer : Number

        for (Car c : carSet) {
            if (!map.containsKey(c)) {
                map.put(c, 1);
            }
            else {
                Integer value = map.get(c);
                map.put(c, ++value);
            }
        }

        for (Map.Entry<Car, Integer> e : map.entrySet()) {
            System.out.print(e.getKey());
            System.out.print(" : ");
            System.out.println(e.getValue());
        }
    }
}
