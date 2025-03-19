package csie.ase.ro.seminar4.classes;

import csie.ase.ro.seminar4.interfaces.Moveable;

public class Car extends Vehicle implements Moveable {
    private String color;
    private float capacity;

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

    public Car() {
        super();
        this.color = "white";
        this.capacity = 1.0f;
    }

    public Car(String color, float capacity, String manufacturer, int noSeats) {
        super(manufacturer, noSeats);
        this.color = color;
        this.capacity = capacity;
    }

    public float computeTax(int quantum, float capacity) {
        return  (float) quantum * capacity;
    }

    public int computeTax(int quantum, int noSeats) {
        return quantum * noSeats;
    }

    @Override
    public void open() {
        System.out.println("The car is now open.");
    }

    @Override
    public void move() {
        System.out.println("The car is moving below " + MAX_SPEED + "km/h.");
    }
    @Override
    public String toString() {
        return "Car{" +
                "manufacturer='" + super.getManufacturer() + '\'' +
                "noSeats='" + super.getNoSeats() + '\'' +
                "color='" + color + '\'' +
                ", capacity=" + capacity +
                '}';
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        Car clone = (Car)super.clone();
        clone.capacity = this.capacity;
        clone.color = this.color;
        return clone;
    }
}
