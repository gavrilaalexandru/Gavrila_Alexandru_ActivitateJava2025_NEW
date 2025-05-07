package csie.ase.ro.test.classes;

import java.io.Serializable;

public abstract class Vehicle implements Cloneable, Serializable {
    private static final long serialVersionUID = 1L;
    private String manufacturer;
    private int noSeats;

    public Vehicle() {
        this.manufacturer = "";
        this.noSeats = -1;
        System.out.println("Vehicle default constructor");
    }

    public Vehicle(String manufacturer, int noSeats) {
        super();
        this.manufacturer = manufacturer;
        this.noSeats = noSeats;
        System.out.println("Vehicle constructor with parameters");
    }

    public void startEngine() {
        System.out.println("Vehicle's engine has started");
    }

    public abstract void honk();

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getNoSeats() {
        return noSeats;
    }

    public void setNoSeats(int noSeats) {
        this.noSeats = noSeats;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "manufacturer='" + manufacturer + '\'' +
                ", noSeats=" + noSeats +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Vehicle clone = (Vehicle)super.clone();
        clone.noSeats = this.noSeats;
        clone.manufacturer = this.manufacturer;
        return clone;
    }
} // end class
