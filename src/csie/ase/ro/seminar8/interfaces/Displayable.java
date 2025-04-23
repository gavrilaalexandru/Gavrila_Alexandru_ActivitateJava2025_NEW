package csie.ase.ro.seminar8.interfaces;

@FunctionalInterface
public interface Displayable {
    public void display();

    default public void display2() { // metoda default, nu se poate schimba cu lambda
        System.out.println("Hi, I am a default method");
    }
}
