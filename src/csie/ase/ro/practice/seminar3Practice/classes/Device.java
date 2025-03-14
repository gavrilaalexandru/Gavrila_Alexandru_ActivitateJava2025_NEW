package csie.ase.ro.practice.seminar3Practice.classes;

public abstract class Device {
    private String manufacturer;
    private String model;

    public Device() {
        this.manufacturer = "";
        this.model = "";
        System.out.println("Device constructor without parametres");
    }

    public Device(String manufacturer, String model) {
        this.manufacturer = manufacturer;
        this.model = model;
        System.out.println("Device constructor with parametres");
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void poweringUp() {
        System.out.println("Device has started powering up");
    }

    public abstract void systemMessage();

    @Override
    public String toString() {
        return "Device{" +
                "manufacturer='" + manufacturer + '\'' +
                ", model='" + model + '\'' +
                '}';
    }
}