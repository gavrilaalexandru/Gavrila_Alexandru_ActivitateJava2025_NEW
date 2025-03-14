package csie.ase.ro.practice.seminar3Practice.main;


import csie.ase.ro.practice.seminar3Practice.classes.Device;
import csie.ase.ro.practice.seminar3Practice.classes.Phone;

public class Main {
    public static void main(String[] args) {
        Phone phone = new Phone("Iphone", "14 Pro", 5.7f, "Black");
        phone.charge();
        phone.open();
        phone.systemMessage();
        System.out.println(phone);
        Device v1 = new Phone(6.0f, "Blue");
        System.out.println(v1);
    }
}
