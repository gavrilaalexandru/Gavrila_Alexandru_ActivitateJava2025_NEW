package csie.ase.ro.seminar1.classes;

public class Carte {

    String titlul;
    int nrPagini;

    public Carte(String titlul, int nrPagini) {
        super(); // legatura cu mostenirea
        this.titlul = titlul;
        this.nrPagini = nrPagini;
    }
    public Carte() {
        this.nrPagini = 0;
        this.titlul = new String("Titlu");
    }
    public String getTitlul() {
        return titlul;
    }
    public void setTitlul(String titlul) {
        this.titlul = titlul;
    }
    public int getNrPagini() {
        return nrPagini;
    }

    public void setNrPagini(int nrPagini) {
        this.nrPagini = nrPagini;
    }

    @Override
    public Object clone() {
        Carte copie = new Carte(); // sau folosesti aici constructorul
        copie.titlul = new String(this.titlul);
        copie.nrPagini = this.nrPagini;
        return copie;
    }
}
