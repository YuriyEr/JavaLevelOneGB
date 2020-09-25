package Lesson01;

public class Task03 {
    public static void main(String[] args) {
//        3. Написать метод вычисляющий выражение a * (b + (c / d)) и возвращающий результат,где a, b, c, d –
//        входные параметры этого метода;

        //Check
        calculate(10, 2.99, 99999999, -10, 4);
    }

    private static void calculate(Number a, Number b, Number c, Number d, int roundInt) {
        double result = (a.doubleValue() * (b.doubleValue() + (c.doubleValue() / d.floatValue())));
        String roundNum = "%." +  roundInt + "f"; //Не знаю можно ли вписать в текстовое значение "/переменную" поэтому так((
        System.out.println(String.format(roundNum, result));
    }
}
