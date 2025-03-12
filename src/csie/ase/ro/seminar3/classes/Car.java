package csie.ase.ro.seminar3.classes;

import csie.ase.ro.seminar3.interfaces.Moveable;

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
        System.out.println("Car constructor");
    }

    @Override
    public void honk() {
        System.out.println("The car honks");
    }

    public Car(String manufacturer, int noSeats, String color, float capacity) {
        super(manufacturer, noSeats);
        this.color = color;
        this.capacity = capacity;
    }

    public void open() {
        System.out.println("The car is open");
    }

    @Override
    public String toString() {
        return "Car{" +
                "color='" + color + '\'' +
                ", capacity=" + capacity +
                ", manufacturer='" + super.getManufacturer() + '\'' +
                ", number of seats=" + super.getNoSeats() +
                '}';
    }

    @Override
    public void drive() {
        System.out.println("The car is moving under " + Moveable.MAX_SPEED);
    }
}
