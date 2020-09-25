package Lesson01;

public class Task05 {
    public static void main(String[] args) {
//        5. Написать метод, которому в качестве параметра передается целое число, метод должен напечатать в консоль положительное ли
//        число передали, или отрицательное; Замечание: ноль считаем положительным числом.

        //Check
        checkUInt(-200);
        checkUInt(0);
        checkUInt(200);
    }
    private static void checkUInt (long value) {
        if (value < 0) {
            System.out.println("Значение " + value + " отрицательное");
        } else {
            System.out.println("Значение " + value + " положительное");
        }
    }

}
