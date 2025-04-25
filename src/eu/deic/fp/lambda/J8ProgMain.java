package eu.deic.fp.lambda;
@FunctionalInterface
interface MathFI<T> {
    T doCalculation(T a, T b);
}
class MathC<E> {
    private int ver = 1;
    public E operate(E a, E b, MathFI<E> mathOperation){
        return mathOperation.doCalculation(a, b);
    }
}
public class J8ProgMain {
    public static void main(String[] args) {
        MathC<Double> objOOP1 = new MathC<>();
        MathFI<Double> objLambdaAdd = (Double a, Double b) -> {
            var r = a + b;
            if (b == 0) r = a;
            return r;
        };
        var rAdd = objOOP1.operate(23.0, 7.0, objLambdaAdd);
        System.out.println("23 + 7 <-- rAdd = " + rAdd);
        System.out.println("115 - 9 = " + objOOP1.operate(115.79, 9.0, (x, y) -> x - y));
    } // end method main
} // end class