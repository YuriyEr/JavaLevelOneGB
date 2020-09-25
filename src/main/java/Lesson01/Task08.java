package Lesson01;

public class Task08 {
    public static void main(String[] args) {
//        8. * Написать метод, который определяет является ли год високосным, и выводит сообщение в консоль.
//        Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный.

        //Check
        checkLeap(200);
    }

    private static void checkLeap (long year) {
        if ((year % 4 != 0 || year % 100 ==0) && year % 400 !=0) System.out.println(year + " is not leap");
        else System.out.println(year + " is leap");
    }
}
