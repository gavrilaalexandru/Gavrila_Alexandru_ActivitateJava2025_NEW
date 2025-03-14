package csie.ase.ro.practice.seminar3Practice.classes;

import csie.ase.ro.practice.seminar3Practice.interfaces.Chargeable;

public class Phone extends Device implements Chargeable {

    private float diagonal;
    private String color;

    public Phone() {
        super();
        this.color = "White";
        this.diagonal = 0.0f;
        System.out.println("Phone constructor without parametres");
    }

    public Phone(float diagonal, String color) {
        this.diagonal = diagonal;
        this.color = color;
        System.out.println("Phone constructor with parametres (only phone attributes)");
    }

    public Phone(String manufacturer, String model, float diagonal, String color) {
        super(manufacturer, model);
        this.diagonal = diagonal;
        this.color = color;
        System.out.println("Phone constructor with parametres (with device's attributes)");
    }

    public float getDiagonal() {
        return diagonal;
    }

    public void setDiagonal(float diagonal) {
        this.diagonal = diagonal;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void open() {
        System.out.println("The phone is now open");
    }

    @Override
    public void charge() {
        System.out.println("The phone is charging and has a maximum capacity of " + MAX_CHARGE + "%");
    }

    @Override
    public void systemMessage() {
        System.out.println("This is a phone");
    }

    @Override
    public String toString() {
        return "Phone{" +
                "manufacturer='" + super.getManufacturer() + '\'' +
                "model='" + super.getModel() + '\'' +
                "diagonal=" + diagonal +
                ", color='" + color + '\'' +
                '}';
    }
}
