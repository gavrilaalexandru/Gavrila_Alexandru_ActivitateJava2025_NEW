package csie.ase.ro.seminar1.main;
import csie.ase.ro.seminar1.classes.Carte;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello from group 1053.");

        Carte fictiune = new Carte("Fictiune", 250);

        System.out.println("Titlul: " + fictiune.getTitlul() + ", Nr pagini: " + fictiune.getNrPagini());

        // shallow copy
        Carte fictiuneEdit = fictiune;

        fictiune.setNrPagini(300);

        System.out.println("Titlul: " + fictiune.getTitlul() + ", Nr pagini: " + fictiune.getNrPagini());
        System.out.println("Titlul: " + fictiuneEdit.getTitlul() + ", Nr pagini: " + fictiuneEdit.getNrPagini());

        // deep copy
        Carte fictiuneDeepCopy = (Carte)fictiune.clone();
        fictiuneDeepCopy.setNrPagini(350);
        System.out.println("Titlul: " + fictiuneDeepCopy.getTitlul() + ", Nr pagini: " + fictiuneDeepCopy.getNrPagini());
    }
}