package examen.TCPobj;

import java.io.Serializable;

public class Book implements Serializable {
    String name;
    int noPages;

    public Book(String name, int noPages) {
        this.name = name;
        this.noPages = noPages;
    }

    public Book() {
        this.name = "";
        this.noPages = -1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNoPages() {
        return noPages;
    }

    public void setNoPages(int noPages) {
        this.noPages = noPages;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Book{");
        sb.append("name='").append(name).append('\'');
        sb.append(", noPages=").append(noPages);
        sb.append('}');
        return sb.toString();
    }
}
