package csie.ase.ro.test.classes;

import csie.ase.ro.test.interfaces.Driveable;
import org.jetbrains.annotations.NotNull;

import java.io.*;
import java.util.Arrays;
import java.util.Objects;

public class Car extends Vehicle implements Driveable, Comparable<Car> {
    private static final long serialVersionUID = 1L;
    private String color;
    private float capacity;
    private int vin;
    private int[] revisions;

    public Car() {
        super();
        this.color = "";
        this.capacity = -1.0f;
        this.vin = -1;
        revisions = new int[1];
        System.out.println("Car default constructor");
    }

    public Car(String color, float capacity, int vin, int[] revisions) {
        super();
        this.color = color;
        this.capacity = capacity;
        this.vin = vin;
        this.revisions = new int[revisions.length];
        System.arraycopy(revisions, 0, this.revisions, 0, revisions.length);
        System.out.println("Car constructor without super parameters");
    }

    public Car(String manufacturer, int noSeats, String color, float capacity, int vin, int[] revisions) {
        super(manufacturer, noSeats);
        this.color = color;
        this.capacity = capacity;
        this.vin = vin;
        this.revisions = new int[revisions.length];
        System.arraycopy(revisions, 0, this.revisions, 0, revisions.length);
        System.out.println("Car constructor with super parameters");
    }

    @Override
    public void honk() {
        System.out.println("This is the car honking");
    }

    @Override
    public void drive() {
        System.out.println("This is the car driving under " + MAX_SPEED + "km/h");
    }

    public void open() {
        System.out.println("The car's doors are now open");
    }

    public void showRevisions() {
        for (int revision : revisions) {
            System.out.println(revision + " ");
        }
        System.out.println();
    }

    public int getAverageRevisionCost() {
        int average = 0;
        int sum = 0;
        for (int revision : revisions) {
            sum += revision;
        }
        average = sum / revisions.length;
        return average;
    }

    public float computeTax(int quantum, float capacity) {
        return (float) quantum * capacity;
    }

    public int computeTax(int quantum, int noSeats) {
        return quantum * noSeats;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public float getCapacity() {
        return capacity;
    }

    public void setCapacity(float capacity) {
        this.capacity = capacity;
    }

    public int getVin() {
        return vin;
    }

    public void setVin(int vin) {
        this.vin = vin;
    }

    public int[] getRevisions() {
        int[] copy = new int[revisions.length];
        System.arraycopy(revisions, 0, copy, 0, revisions.length);
        return copy;
    }

    public void setRevisions(int[] revisions) {
        this.revisions = new int[revisions.length];
        System.arraycopy(revisions, 0, this.revisions, 0, revisions.length);
    }

    @Override
    public String toString() {
        return "Car{" +
                "color='" + color + '\'' +
                ", capacity=" + capacity +
                ", vin=" + vin +
                ", revisions=" + Arrays.toString(revisions) +
                "} " + super.toString();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Car clone = (Car)super.clone();
        clone.color = this.color;
        clone.capacity = this.capacity;
        clone.vin = this.vin;
        clone.revisions = this.revisions.clone(); // or with getRevisions()
        return clone;
    }

    @Override
    public int compareTo(@NotNull Car o) {
        if (vin < o.vin) {
            return -1;
        } else if (vin == o.vin) {
            return 0;
        }
        else {
            return 1;
        }
        // return Integer.compare(vin, o.vin);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getManufacturer());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) return false;
        Car car = (Car)obj;
        return Objects.equals(getManufacturer(), car.getManufacturer());
    }

    public void serialize() throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("src/csie/ase/ro/test/cars.data"));
        objectOutputStream.writeObject(this);
        objectOutputStream.close();
    }

    public void deserialize() throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("src/csie/ase/ro/test/cars.data"));
        Car c = (Car) objectInputStream.readObject();
        this.color = c.color;
        this.vin = c.vin;
        this.capacity = c.capacity;
        this.revisions = c.getRevisions();
        this.setManufacturer(c.getManufacturer());
        this.setNoSeats(c.getNoSeats());
        objectInputStream.close();
    }
} // end class
