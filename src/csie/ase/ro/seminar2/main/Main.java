package csie.ase.ro.seminar2.main;
import csie.ase.ro.seminar2.classes.Book;

public class Main {
    public static void main(String[] args) {
        Book book1 = new Book();

        System.out.println("Title: " + book1.getTitle() + ", No of pages: "
                + book1.getNoPages() + ", genre: " + book1.getGenre() + ".");
        book1.showRatings();

        Book book2 =(Book)book1.clone();
        book2.setRatings(new int[]{3, 3, 5});

        System.out.println("Title: " + book2.getTitle() + ", No of pages: "
                + book2.getNoPages() + ", genre: " + book2.getGenre() + ".");
        book2.showRatings();

        System.out.println("The average rating is: " + book2.getAverageRating());
    }
}
