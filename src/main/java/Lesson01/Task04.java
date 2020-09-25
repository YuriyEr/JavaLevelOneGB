package Lesson01;

public class Task04 {
    public static void main(String[] args) {
//        4. Написать метод, принимающий на вход два числа, и проверяющий что их сумма лежит в пределах от 10 до 20(включительно),
//                если да – вернуть true, в противном случае – false;

        //Check
        double[] range = {10,20};
        System.out.println(checkArange(2,2,10,20));
        System.out.println(checkArange(5,5,10,20));
        System.out.println(checkArange(15,5,10,20));
        System.out.println(checkArange(10,11,10,20));
    }
    static private boolean checkArange (double first, double second, double rangeStart, double rangeFinish) {
        if ((first + second) >= rangeStart && (first + second) <= rangeFinish) {
            return true;
        } else {
            return false;
        }
    }
}
