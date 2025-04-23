package csie.ase.ro.seminar7.main;

import csie.ase.ro.seminar7.classes.Student;

import java.io.*;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Student s = new Student("John", 9.6f);
        System.out.println(s);

        // write binary
        try(FileOutputStream fileOutputStream = new FileOutputStream("student.bin", true);
            DataOutputStream dataOutputStream = new DataOutputStream(fileOutputStream)) {
            dataOutputStream.writeUTF(s.getName());
            dataOutputStream.writeFloat(s.getAverage());
        } catch (IOException e) {
            e.printStackTrace();
        }

        // read binary
        try(FileInputStream fileInputStream = new FileInputStream("student.bin");
           DataInputStream dataInputStream = new DataInputStream(fileInputStream)) {
            Student s1 = new Student();
            s1.setName(dataInputStream.readUTF());
            s1.setAverage(dataInputStream.readFloat());
            System.out.println(s1);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // serialize
        try {
            s.serialize();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // deserialize
        Student s2 = new Student();
        try {
            s2.deserialize();
            System.out.println(s2);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (RandomAccessFile randomAccessFile = new RandomAccessFile("student.bin", "r")) {
            System.out.println("Pointer position: " + randomAccessFile.getFilePointer());
            randomAccessFile.seek(randomAccessFile.length() - Float.BYTES);
            System.out.println("Pointer position: " + randomAccessFile.getFilePointer());
            float value = randomAccessFile.readFloat();
            System.out.println(value);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Student student1 = new Student("Alex", 9);
        Student student2 = new Student("Timeea", 10);
        Student student3 = new Student("Bogdan", 8);

        Set<Student> setStudenti = new TreeSet<Student>();
        setStudenti.add(student1);
        setStudenti.add(student2);
        setStudenti.add(student3);

        try {
            FileOutputStream fileOutputStream = new FileOutputStream("setStudenti.txt");
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
            BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);

            for (Student stud : setStudenti) {
                bufferedWriter.write(stud.getName());
                bufferedWriter.write(System.lineSeparator());
                bufferedWriter.write(String.valueOf(stud.getAverage()));
                bufferedWriter.write(System.lineSeparator());
            }
            bufferedWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        BufferedReader bufferedReader = null;
        try {
            FileInputStream fileInputStream = new FileInputStream("setStudenti.txt");
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            bufferedReader = new BufferedReader(inputStreamReader);


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}