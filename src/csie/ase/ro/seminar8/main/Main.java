package csie.ase.ro.seminar8.main;

import csie.ase.ro.seminar8.classes.Calculator;
import csie.ase.ro.seminar8.classes.Console;
import csie.ase.ro.seminar8.interfaces.Displayable;
import csie.ase.ro.seminar8.interfaces.Operatable;
import csie.ase.ro.seminar8.interfaces.Printable;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Operatable operator = new Calculator();
        double value = operator.operate(2, 5);
        System.out.println("Sum: " + value);

        // anonymous class
        operator = new Operatable() {
            @Override
            public double operate(double o1, double o2) {
                return o1 - o2;
            }
        };
        value = operator.operate(2, 5);
        System.out.println("Substraction: " + value);

        // anonymous object
        System.out.println(new Calculator().operate(2, 5));

        // lambda function
        // parameter type is optional
        operator = (double o1, double o2) -> o1 * o2; // trebuie sa avem doar o metoda abstracta in clasa;
                                                      // adica functional interface; folosim adnotarea @FunctionalInterface
        value = operator.operate(2, 5);
        System.out.println("Multiplication: " + value);

        operator = (a, b) -> {
            double sum = a + b;
            return sum / 2;
        };

        value = operator.operate(2, 5);
        System.out.println("Average: " + value);

        Displayable d = () -> System.out.println("Hello");
        d.display();

        Printable p = m -> System.out.println(m); // nu este neaparat paranteza pentru un parametru
        p.print("Hi");

//        Console c = new Console();
//        c.display2();

        // Streams

        List<Integer> list = Arrays.asList(2, 3, 4, 5, 2, 3, 6, 7, 9, 2, 1);
        long count = list.stream().filter(x -> x % 2 == 0).count();
        System.out.println(count);

        int sum = list.stream().filter(x -> x % 2 == 0).mapToInt(x -> x.intValue()).sum(); // merge si fara
        System.out.println(sum);

        List<String> strings = Arrays.asList("a", "abcd", "ab", "eab", "bacd", "ba", "b", "abc");
        strings.stream().filter(s -> s.startsWith("a")).sorted().forEach(s -> System.out.println(s));

        String res = strings.stream().filter(s -> s.length() > 2).sorted().collect(Collectors.joining(", "));
        System.out.println(res);

        list.stream().sorted().distinct().map(x -> x*x).forEach(System.out::println);

        // paralell streams
        strings.parallelStream().filter(s -> s.startsWith("b")).forEach(System.out::println);
    }
}
