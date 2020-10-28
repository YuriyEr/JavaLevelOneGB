package AdditionalTasks;

import java.util.function.Function;

public class Lambda {
    public static void main(String[] args) {
        // собственный функциональный интерфейс (лямбда выражения)
        add result = (A, B) -> A + B;
        add result2 = (A, B) -> A * B;
        System.out.println(result.get(2,3));
        System.out.println(result2.get(2,3));

        // Интерфей Function
        Function<Double, Integer > toInteger = val -> (int)Math.round(val);
        System.out.println(toInteger.apply(20.998));
    }
}
