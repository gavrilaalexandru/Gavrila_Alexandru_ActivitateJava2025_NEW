package csie.ase.ro.seminar2.classes;

public class Book {
    private String title;
    private int noPages;
    private int[] ratings;

    public enum  Genre { // sau facem din meniul new --> enum
        SF, Drama, Comedy
    };

    private Genre genre;

    public Book() {
        title = "";
        noPages = 0;
        ratings = new int[1];
        // ratings[0] = 0; redundant
        genre = Genre.SF;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getNoPages() {
        return noPages;
    }

    public void setNoPages(int noPages) {
        this.noPages = noPages;
    }

    public int[] getRatings() {
        int[] copy  = new int[ratings.length];
//        for (int i = 0; i < ratings.length; i++) {
//            copy[i] = ratings[i];
//        }
        System.arraycopy(ratings, 0, copy, 0, ratings.length);
        return copy;
    }

    public void setRatings(int[] ratings) {
        this.ratings = new int[ratings.length];
//        for (int i = 0; i < ratings.length; i++) {
//            this.ratings[i] = ratings[i];
//        }
        System.arraycopy(ratings, 0, this.ratings, 0, ratings.length);
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public void showRatings() {
        System.out.print("Ratings: ");
//        for (int i = 0; i < this.ratings.length; i++) {
//            System.out.print(this.ratings[i] + " ");
//        }
        for (int rating : this.ratings) {
            System.out.print(rating + " ");
        }
        System.out.println();
    }

    public float getAverageRating() {
        float average = 0;
        int sum = 0;

        for(int rating : this.ratings) { // enhanced for
            sum += rating;
        }
        average = (float)sum / ratings.length; // trebuie cast deoarece java returneaza un int
        return average;
    }

    @Override
    public Object clone() {
        Book clone = new Book();
        clone.title = new String(this.title);
        clone.noPages = this.noPages;
        clone.genre = this.genre;
        clone.ratings = getRatings();
        return clone;
    }
}
