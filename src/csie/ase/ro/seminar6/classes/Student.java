package csie.ase.ro.seminar6.classes;

public class Student {
    private String name;
    private float average;

    public Student() {

    }

    public Student(String name, float average) {
        super();
        this.name = name;
        this.average = average;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Student{");
        sb.append("name='").append(name).append('\'');
        sb.append(", average=").append(average);
        sb.append('}');
        return sb.toString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getAverage() {
        return average;
    }

    public void setAverage(float average) {
        this.average = average;
    }
}
