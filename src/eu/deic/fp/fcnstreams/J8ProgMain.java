package eu.deic.fp.fcnstreams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class J8ProgMain {
    public static void main(String[] args) {
        System.out.println("======= Using Java 8+: ");

        // List of strings
        // Count empty strings
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
        System.out.println("List: " + strings);

        long tstart = 0L, tstop = 0L;

        tstart = System.nanoTime();
        var co1 = 0;
        for (var i = 0; i < strings.size(); i++) {
            if (strings.get(i) != null && strings.get(i).length() == 0)
                // if(strings.get(i) != null && strings.get(i).equals(""))
                co1++;
        }
        tstop = System.nanoTime();
        System.out.printf("\n co1 = %d, ns = %d \n", co1, (tstop - tstart));
        tstart = System.nanoTime();
        var co2 = 0;
        for (var s : strings) {
            if (s.isEmpty())
                co2++;
        }
        tstop = System.nanoTime();
        System.out.printf("\n co2 = %d, ns = %d \n", co2, (tstop - tstart));

        tstart = System.nanoTime();
        Predicate<String> predEmptyStr = (String s) -> {
            boolean res = s.isEmpty();
            return res;
        };
        long countEmptyStr = strings.stream().filter(predEmptyStr).count();
        tstop = System.nanoTime();
        System.out.printf("\n co3 = %d, ns = %d \n", countEmptyStr, (tstop - tstart));

        tstart = System.nanoTime();
        long count = strings.stream().filter(s -> s.isEmpty()).count();
        // System.out.println("Empty Strings: " + count);
        tstop = System.nanoTime();
        System.out.printf("\n co4 = %d, ns = %d \n", count, (tstop - tstart));
    } // end main method
} // end class