package csie.ase.ro.seminar14.main;

import csie.ase.ro.seminar14.classes.Biblioteca;
import csie.ase.ro.seminar14.classes.Carte;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int[] idRaft = new int[] {2, 5, 2, 1, 3};
        List<Carte> carti = new ArrayList<>();

        carti.add(new Carte("1984", "George Orwell", 328));
        carti.add(new Carte("Mândrie și prejudecată", "Jane Austen", 279));
        carti.add(new Carte("Crimă și pedeapsă", "Fyodor Dostoevsky", 671));
        carti.add(new Carte("În căutarea timpului pierdut", "Marcel Proust", 4215));
        carti.add(new Carte("Maestrul și Margareta", "Mihail Bulgakov", 384));

        Biblioteca biblioteca = new Biblioteca(carti, idRaft);
        System.out.println(biblioteca);
    }
}
