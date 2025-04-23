package csie.ase.ro.seminar8.classes;

import csie.ase.ro.seminar8.interfaces.Operatable;

public class Calculator implements Operatable {
    @Override
    public double operate(double o1, double o2) {
        return o1 + o2;
    }
}
