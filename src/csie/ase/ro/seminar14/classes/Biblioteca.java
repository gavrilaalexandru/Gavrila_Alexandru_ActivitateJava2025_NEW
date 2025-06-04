package csie.ase.ro.seminar14.classes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Biblioteca {
    List<Carte> carti;
    int[] idRaft;

    public Biblioteca(List<Carte> carti, int[] idRaft) {
        this.idRaft = new int[idRaft.length];
        System.arraycopy(idRaft, 0, this.idRaft, 0, idRaft.length);

        this.carti = new ArrayList<>();
        for (Carte c : carti) {
            try {
                this.carti.add(c.clone());
            } catch (CloneNotSupportedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public Biblioteca() {
        this.idRaft = new int[1];
        this.carti = new ArrayList<>();
    }

    public List<Carte> getCarti() {
        List<Carte> copy = new ArrayList<>();
        for (Carte c : this.carti) {
            try {
                copy.add(c.clone());
                return copy;
            } catch (CloneNotSupportedException e) {
                throw new RuntimeException(e);
            }
        }
        return copy;
    }

    public void setCarti(List<Carte> carti) {
        this.carti = new ArrayList<>();
        for (Carte c : carti) {
            try {
                this.carti.add(c.clone());
            } catch (CloneNotSupportedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public int[] getIdRaft() {
        int[] copy = new int[idRaft.length];
        System.arraycopy(idRaft, 0, copy, 0, idRaft.length);
        return copy;
        }

    public void setIdRaft(int[] idRaft) {
        this.idRaft = new int[idRaft.length];
        System.arraycopy(idRaft, 0, this.idRaft, 0, idRaft.length);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Biblioteca{");
        sb.append("carti=").append(carti);
        sb.append(", idRaft=").append(Arrays.toString(idRaft));
        sb.append('}');
        return sb.toString();
    }
}
