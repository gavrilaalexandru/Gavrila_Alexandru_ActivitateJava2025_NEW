package csie.ase.ro.test.main;

import csie.ase.ro.test.classes.Car;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[] revisions1 = {10000, 20000, 30000};
        Car car1 = new Car("Toyota", 4, "Red", 1.5f, 123456789, revisions1);

        int[] revisions2 = {5000, 15000, 25000};
        Car car2 = new Car("Honda", 5, "Blue", 2.0f, 987654321, revisions2);

        int[] revisions3 = {8000, 18000, 28000};
        Car car3 = new Car("Ford", 4, "Green", 1.8f, 456123789, revisions3);

        // Adăugăm încă 3 mașini
        int[] revisions4 = {12000, 22000, 32000};
        Car car4 = new Car("BMW", 5, "Black", 2.2f, 741258963, revisions4);

        int[] revisions5 = {3000, 13000, 23000};
        Car car5 = new Car("Mercedes", 4, "White", 1.4f, 852963741, revisions5);

        int[] revisions6 = {4000, 14000, 24000};
        Car car6 = new Car("Audi", 4, "Yellow", 2.1f, 159753486, revisions6);

        int[] revisions7 = {2000, 34000, 15000};
        Car car7 = new Car("Audi", 4, "Yellow", 2.1f, 243553486, revisions7);

        System.out.println("Car list:");
        List<Car> carList = new ArrayList<Car>();
        carList.add(car1);
        carList.add(car2);
        carList.add(car3);
        carList.add(car4);
        carList.add(car5);
        carList.add(car6);
        for (Car c : carList) {
            System.out.println(c);
        }

        System.out.println("Car set:");
        Set<Car> carSet = new TreeSet<Car>();
        carSet.add(car1);
        carSet.add(car2);
        carSet.add(car3);
        carSet.add(car4);
        carSet.add(car5);
        carSet.add(car6);
        carSet.add(car7);
        for (Car c : carSet) {
            System.out.println(c);
        }

        System.out.println("Car map:");
        Map<Car, Integer> carMap = new HashMap<Car, Integer>();
        for (Car c : carSet) {
            if (!carMap.containsKey(c)) {
                carMap.put(c, 1);
            }
            else {
                Integer value = carMap.get(c);
                carMap.put(c, ++value);
            }
        }
        for (Map.Entry<Car, Integer> e : carMap.entrySet()) {
            System.out.println(e.getKey() + ":" + e.getValue());
        }

        System.out.println("Write to .txt file");
        try (BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("src/csie/ase/ro/test/cars.txt")))) {
            bufferedWriter.write(car4.getManufacturer());
            bufferedWriter.write(System.lineSeparator());
            bufferedWriter.write(String.valueOf(car4.getVin()));
            bufferedWriter.write(System.lineSeparator());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Read from .txt file");
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("src/csie/ase/ro/test/cars.txt")))) {
            Car c = new Car();
            c.setManufacturer(bufferedReader.readLine());
            c.setVin(Integer.parseInt(bufferedReader.readLine()));
            System.out.println(c);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Read from .txt file with scanner");
        try (Scanner sc = new Scanner(new File("src/csie/ase/ro/test/cars.txt"))) {
            Car c = new Car();
            c.setManufacturer(sc.nextLine());
            c.setVin(sc.nextInt());
            System.out.println(c);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Write to binary file");
        try (DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream("src/csie/ase/ro/test/cars.bin", true))) {
            dataOutputStream.writeUTF(car2.getManufacturer());
            dataOutputStream.writeFloat(car2.getCapacity());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Read from binary file");
        try (DataInputStream dataInputStream = new DataInputStream(new FileInputStream("src/csie/ase/ro/test/cars.bin"))) {
            Car c = new Car();
            c.setManufacturer(dataInputStream.readUTF());
            c.setCapacity(dataInputStream.readFloat());
            System.out.println(c);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Serialization");
        try {
            car6.serialize();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Deserialization");
        Car cDeserialized = new Car();
        try {
            cDeserialized.deserialize();
            System.out.println(cDeserialized);
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Random access file");
        try(RandomAccessFile randomAccessFile = new RandomAccessFile("src/csie/ase/ro/test/cars.bin", "r")) {
            randomAccessFile.seek(randomAccessFile.length() - Float.BYTES);
            float value = randomAccessFile.readFloat();
            System.out.println(value);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    } // end main method
} // end class
