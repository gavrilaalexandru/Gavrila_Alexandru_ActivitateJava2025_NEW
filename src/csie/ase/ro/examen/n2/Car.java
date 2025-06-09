package csie.ase.ro.examen.n2;

public class Car extends Vehicle {
    private int id;
    private String registryPlate;
    private String company;
    private Expenses expenses;

    public Car(String color, String model, int id, String registryPlate, String company, Expenses expenses) {
        super(color, model);
        this.id = id;
        this.registryPlate = registryPlate;
        this.company = company;
        this.expenses = expenses.clone();
    }

    public Car(int id, String registryPlate, String company, Expenses expenses) {
        this.id = id;
        this.registryPlate = registryPlate;
        this.company = company;
        this.expenses = expenses.clone();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRegistryPlate() {
        return registryPlate;
    }

    public void setRegistryPlate(String registryPlate) {
        this.registryPlate = registryPlate;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Expenses getExpenses() {
        return expenses.clone();
    }

    public void setExpenses(Expenses expenses) {
        this.expenses = expenses.clone();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Car{");
        sb.append("id=").append(id);
        sb.append(", registryPlate='").append(registryPlate).append('\'');
        sb.append(", company='").append(company).append('\'');
        sb.append(", expenses=").append(expenses);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public Car clone() {
        Car carClone = (Car) super.clone();
        carClone.expenses = this.expenses.clone();
        return carClone;
    }
}
