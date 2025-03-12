package csie.ase.ro.seminar3.classes;

public abstract class Vehicle {
    private String manufacturer;
    private int noSeats;

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Vehicle() {
        this.manufacturer = "";
        this.noSeats = 5;
        System.out.println("Vehicle constructor");
    }

    public Vehicle(String manufacturer, int noSeats) {
        super();
        this.manufacturer = manufacturer;
        this.noSeats = noSeats;
    }

    public int getNoSeats() {
        return noSeats;
    }

    public void setNoSeats(int noSeats) {
        this.noSeats = noSeats;
    }

    public void startEngine() {
        System.out.println("Vehicle's engine has started");
    }

    public abstract void honk();

    @Override
    public String toString() {
        return "Vehicle{" +
                "manufacturer='" + manufacturer + '\'' +
                ", noSeats=" + noSeats +
                '}';
    }
}
