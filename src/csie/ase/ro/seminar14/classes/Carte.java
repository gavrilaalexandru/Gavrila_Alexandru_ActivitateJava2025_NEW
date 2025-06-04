package csie.ase.ro.seminar14.classes;

public class Carte implements Cloneable {
    String titlu;
    String autor;
    int nrPagini;

    public Carte(String titlu, String autor, int nrPagini) {
        this.titlu = titlu;
        this.autor = autor;
        this.nrPagini = nrPagini;
    }

    public Carte() {
        this.titlu = "";
        this.autor = "";
        this.nrPagini = -1;
    }

    public String getTitlu() {
        return titlu;
    }

    public void setTitlu(String titlu) {
        this.titlu = titlu;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getNrPagini() {
        return nrPagini;
    }

    public void setNrPagini(int nrPagini) {
        this.nrPagini = nrPagini;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Carte{");
        sb.append("titlu='").append(titlu).append('\'');
        sb.append(", autor='").append(autor).append('\'');
        sb.append(", nrPagini=").append(nrPagini);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public Carte clone() throws CloneNotSupportedException {
        Carte clone = (Carte)super.clone();
        clone.titlu = new String(this.titlu);
        clone.autor = new String(this.autor);
        clone.nrPagini = this.nrPagini;
        return clone;
    }
}
