package csie.ase.ro.seminar6.main;

import csie.ase.ro.seminar6.classes.Student;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Student s = new Student("John", 9.6f);

        System.out.println(s);
        /*
        Scanner scanner = new Scanner(System.in);
        Student stud = new Student();

        System.out.print("Student name: ");
        stud.setName(scanner.nextLine());
        System.out.print("Student average: ");
        stud.setAverage(scanner.nextFloat());
        System.out.println(stud);
         */

        // write to .txt file
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("student.txt");
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
            BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);

            bufferedWriter.write(s.getName());
            bufferedWriter.write(System.lineSeparator()); // bufferedWriter.newLine();
            bufferedWriter.write(String.valueOf(s.getAverage()));
            bufferedWriter.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // read from .txt file

        BufferedReader bufferedReader = null;
        try {
            FileInputStream fileInputStream = new FileInputStream("student.txt");
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            bufferedReader = new BufferedReader(inputStreamReader);
            Student student = new Student();

            String name = bufferedReader.readLine();
            student.setName(name);

            student.setAverage(Float.parseFloat(bufferedReader.readLine()));
            System.out.println(student);
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

        File file = new File("student.txt");
        try (Scanner scanner = new Scanner(file);) {
            Student s1 = new Student();
            s1.setName(scanner.nextLine());
            s1.setAverage(scanner.nextFloat());
            System.out.println(s1);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
