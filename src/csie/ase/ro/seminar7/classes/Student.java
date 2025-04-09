package csie.ase.ro.seminar7.classes;

import org.jetbrains.annotations.NotNull;

import java.io.*;

public class Student implements Serializable, Comparable<Student> {
    @Serial
    private static final long serialVersionUID = 1L;
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

    public void serialize() throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("student.data");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(this);
        objectOutputStream.close();
    }

    public void deserialize() throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream("student.data");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        Student s = (Student)objectInputStream.readObject();
        this.name = s.name;
        this.average = s.average;
        objectInputStream.close();
    }

    @Override
    public int compareTo(@NotNull Student o) {
        return Float.compare(average, o.average);
    }
}
