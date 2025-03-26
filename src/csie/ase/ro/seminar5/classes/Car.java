package csie.ase.ro.seminar5.classes;

import org.jetbrains.annotations.NotNull;

public class Car implements Comparable<Car> {
    private String color;
    private String manufacturer;
    private int capacity;

    public Car() {
        this.color = "white";
        this.capacity = 1000;
        this.manufacturer = "";
    }

    public Car(String color, String manufacturer, int capacity) {
        this.color = color;
        this.manufacturer = manufacturer;
        this.capacity = capacity;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "Car{" +
                "color='" + color + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", capacity=" + capacity +
                '}';
    }

    @Override
    public int compareTo(@NotNull Car o) { // niciodata nu compara doua floaturi cu ==
        // return Integer.compare(capacity, o.capacity);
        if (capacity < o.capacity) {
            return -1;
        } else if (capacity == o.capacity) {
            return 0;
        }
        else {
            return 1;
        }
    }

    @Override
    public int hashCode() {
        return manufacturer.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Car) { // sau instanceof Car c direct
            Car c = (Car)obj;
            return manufacturer.equals(c.manufacturer);
        }
        else {
            return false;
        }
    }
}


