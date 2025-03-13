package eu.deic.oop.c03_oop_poly;

public class Vehicle extends Object implements Movement, Cloneable {

    private int weight;

    public Vehicle() {
        this.weight = 0;
    }

    Vehicle(int weight) {
        this.weight = weight;
    }

    public int getWeight() {
        return this.weight;
    }

    public void setWeight(int w) {
        this.weight = w;
    }

    public String display() {
        return new String("Vehicle - w = " + this.weight);
    }

    @Override
    public void startEngine() {
        System.out.println("Vehicle::startEngine()");
    }

    @Override
    public void stopEngine() {
        System.out.println("Vehicle::stopEngine()");
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        Vehicle r = null;

        // r = (Vehicle)super.clone(); profesionist
        r = new Vehicle(); // nu profesionist
        r.weight = this.weight;

        return r;
    }
}