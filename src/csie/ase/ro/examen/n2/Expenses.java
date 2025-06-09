package csie.ase.ro.examen.n2;

public class Expenses implements Cloneable {
    private int gasConsumption;
    private int gasCost;
    private int insurance;
    private int parking;

    public Expenses(int gasConsumption, int gasCost, int insurance, int parking) {
        this.gasConsumption = gasConsumption;
        this.gasCost = gasCost;
        this.insurance = insurance;
        this.parking = parking;
    }

    public Expenses() {
        this.gasConsumption = -1;
        this.gasCost = -1;
        this.insurance = -1;
        this.parking = -1;
    }

    public int getGasConsumption() {
        return gasConsumption;
    }

    public void setGasConsumption(int gasConsumption) {
        this.gasConsumption = gasConsumption;
    }

    public int getGasCost() {
        return gasCost;
    }

    public void setGasCost(int gasCost) {
        this.gasCost = gasCost;
    }

    public int getInsurance() {
        return insurance;
    }

    public void setInsurance(int insurance) {
        this.insurance = insurance;
    }

    public int getParking() {
        return parking;
    }

    public void setParking(int parking) {
        this.parking = parking;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Expenses{");
        sb.append("gasConsumption=").append(gasConsumption);
        sb.append(", gasCost=").append(gasCost);
        sb.append(", insurance=").append(insurance);
        sb.append(", parking=").append(parking);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public Expenses clone() {
        try {
            return (Expenses) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
