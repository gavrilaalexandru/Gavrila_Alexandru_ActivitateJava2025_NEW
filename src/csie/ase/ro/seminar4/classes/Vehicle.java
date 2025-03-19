package csie.ase.ro.seminar4.classes;

public abstract class Vehicle implements Cloneable{
    private String manufacturer;
    private int noSeats;

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

    public Vehicle() {
        this.manufacturer = "";
        this.noSeats = 1;
    }

    public Vehicle(String manufacturer, int noSeats) {
        this.manufacturer = manufacturer;
        this.noSeats = noSeats;
    }

    public abstract void open();

    @Override
    public String toString() {
        return "Vehicle{" +
                "manufacturer='" + manufacturer + '\'' +
                ", noSeats=" + noSeats +
                '}';
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        Vehicle clone = (Vehicle)super.clone();
        clone.noSeats = this.noSeats;
        clone.manufacturer = this.manufacturer;
        return clone;
    }
}
