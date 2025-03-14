package eu.deic.oop.c02.ooparrays;

public class ProgMainOopArraysCar {

    public static void main(String[] args) {
        Car.setNoCars(2);
        Car[] carsArray = new Car[Car.getNoCars()];

        short[][] carsKmDaily = new short[][] {
                {51, 50, 92},
                {94, 10, 19}
        };

        int i = 0;
        while (i < carsKmDaily.length) {
            carsArray[i] = new Car("C" + i, carsKmDaily[i]);
            i++;
        }
        // carsArray[0] = new Car("C0", new short[] {51, 50, 92});
        // carsArray[1] = new Car("C1", new short[] {94, 10, 19});

        for (int ii = 0; ii < Car.getNoCars(); ii++) {
            System.out.println("The average km for the car "+ i +" is = "+
                    carsArray[i].getAverageKm());
        } // end for statment
    } // end main method

} // end class
